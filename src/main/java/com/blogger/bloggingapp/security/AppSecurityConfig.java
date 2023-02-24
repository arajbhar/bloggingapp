package com.blogger.bloggingapp.security;

import com.blogger.bloggingapp.security.jwt.JWTAuthenticationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AnonymousAuthenticationFilter;

@Configuration
public class AppSecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{

        http.csrf().disable().cors().disable();

        http
                .authorizeHttpRequests()
                .requestMatchers(HttpMethod.POST,"/users").permitAll()
                .requestMatchers(HttpMethod.GET,"/articles").permitAll()
                .anyRequest().authenticated();

        http.addFilterBefore(new JWTAuthenticationFilter(), AnonymousAuthenticationFilter.class);
        return http.build();

    }


}
