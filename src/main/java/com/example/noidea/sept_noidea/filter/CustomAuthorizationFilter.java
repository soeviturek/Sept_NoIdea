package com.example.noidea.sept_noidea.filter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.HttpStatus.FORBIDDEN;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

public class CustomAuthorizationFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if(request.getServletPath().equals("api/login") || request.getServletPath().equals("/token/refresh")){
            filterChain.doFilter(request,response); //not doing anything, pass to next filter
        }
        else{
            String autorizationHeader = request.getHeader(AUTHORIZATION);
            if(autorizationHeader != null && autorizationHeader.startsWith("Bearer ")){
                try{
                    //give all the permission that comes with the token
                    String token = autorizationHeader.substring("Bearer ".length()); //remove Bearer
                    Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());
                    JWTVerifier verifier = JWT.require(algorithm).build(); //create verifier
                    DecodedJWT decodedJWT = verifier.verify(token); //verify token
                    String username = decodedJWT.getSubject();
                    String role = decodedJWT.getClaim("role").asArray(String.class)[0];
                    //no need password because already authenticated
                    Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
                    //loop through the roles
                    authorities.add(new SimpleGrantedAuthority(role));
                    UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username,null,authorities);
                    //set the user's security context
                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                    filterChain.doFilter(request,response); //pass the request to move on
                }catch(Exception e) {
                    //token invalid, expired .etc
                    logger.error("Error logging in: "+e.getMessage());
                    response.setHeader("error",e.getMessage());
                    //response.sendError(FORBIDDEN.value());
                    Map<String,String> error = new HashMap<>();
                    error.put("error_message",e.getMessage());
                    response.setContentType(APPLICATION_JSON_VALUE);
                    new ObjectMapper().writeValue(response.getOutputStream(), error); //write to response body
                }
            }
            else{
                filterChain.doFilter(request,response); //do nothing, let the request continue
            }
        }
    }
}
