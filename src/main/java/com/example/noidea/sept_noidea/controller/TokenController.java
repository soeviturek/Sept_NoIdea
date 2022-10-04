package com.example.noidea.sept_noidea.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.noidea.sept_noidea.model.User;
import com.example.noidea.sept_noidea.service.UserServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/token")
public class TokenController {

    @Autowired
    private UserServiceImpl userDao;

    @GetMapping("/refresh")
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws Exception{
        String authorizationHeader = request.getHeader(AUTHORIZATION);
        if(authorizationHeader != null && authorizationHeader.startsWith("Bearer ")){
            try{
                String refreshToken = authorizationHeader.substring("Bearer ".length()); //remove Bearer
                Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());
                JWTVerifier verifier = JWT.require(algorithm).build(); //create verifier
                DecodedJWT decodedJWT = verifier.verify(refreshToken); //verify token
                String username = decodedJWT.getSubject();
                //load that user
                User user = userDao.getUserByUsername(username);
                //get refreshToken
                String accessToken = JWT.create()
                        .withSubject(user.getUsername()) //get a unique subject like uername
                        .withExpiresAt(new Date(System.currentTimeMillis() +10*60*1000)) //10 minues
                        .withIssuer(request.getRequestURL().toString())
                        .withClaim("role", new ArrayList<>().add(Integer.toString(user.getUserType()))) //all the roles, map everything into a list
                        .sign(algorithm);
                Map<String,String> tokens = new HashMap<>();
                tokens.put("access_token",accessToken);
                tokens.put("refresh_token",refreshToken);
                response.setContentType(APPLICATION_JSON_VALUE);
                new ObjectMapper().writeValue(response.getOutputStream(), tokens); //write to response body

            }catch(Exception e) {
                //token invalid, expired .etc
                response.setHeader("error",e.getMessage());
                //response.sendError(FORBIDDEN.value());
                Map<String,String> error = new HashMap<>();
                error.put("error_message",e.getMessage());
                response.setContentType(APPLICATION_JSON_VALUE);
                new ObjectMapper().writeValue(response.getOutputStream(), error); //write to response body
            }
        }
        else{
            throw new RuntimeException("Refresh Token is missing!");
        }
    }
}
