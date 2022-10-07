package com.example.noidea.sept_noidea.security;

import com.example.noidea.sept_noidea.filter.CustomAuthenticationFilter;
import com.example.noidea.sept_noidea.filter.CustomAuthorizationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private PasswordEncoder bCryptPasswordEncoder;



    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
    }

    @Override
    protected  void configure(HttpSecurity http) throws Exception{
        http.csrf().disable(); //disable cookie;
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.authorizeRequests().antMatchers("/","/login","/token/refresh/**","/api/users/create").permitAll(); // login is default login url
        http.authorizeRequests().antMatchers(HttpMethod.POST,"/api/users/createdoc").hasAuthority("2"); //role authorities
        http.authorizeRequests().antMatchers(HttpMethod.POST,"/api/users/all_users").hasAuthority("2");

        http.authorizeRequests().antMatchers(HttpMethod.POST,"/api/book/create").hasAnyAuthority("0","1","2");
        http.authorizeRequests().antMatchers(HttpMethod.GET,"/api/book/get/{id}").hasAnyAuthority("0","1","2");
        http.authorizeRequests().antMatchers(HttpMethod.GET,"/api/book/getuid/{id}").hasAnyAuthority("0","1","2");
        http.authorizeRequests().antMatchers(HttpMethod.GET,"/api/book/update/{id}").hasAnyAuthority("0","1","2");
        http.authorizeRequests().antMatchers(HttpMethod.DELETE,"/api/book/delete/{id}").hasAnyAuthority("0","1","2");
        http.authorizeRequests().anyRequest().authenticated();
        //filter
        http.addFilter(new CustomAuthenticationFilter(authenticationManagerBean()));
        http.addFilterBefore(new CustomAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
    }
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception{
        return super.authenticationManagerBean();
    }
}
