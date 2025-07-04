package com.example.copsboot.infrastructure.security;

import com.c4_soft.springaddons.security.oidc.starter.synchronised.resourceserver.ResourceServerExpressionInterceptUrlRegistryPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity //<.>
public class WebSecurityConfiguration {

    @Bean
  SecurityFilterChain configureSecurityFilterChain(HttpSecurity http) throws Exception{
  http
  .authorizeHttpRequests(authorizeRequests -> authorizeRequests
  .requestMatchers(HttpMethod.OPTIONS, "/api/**").permitAll() 
  .requestMatchers("/api/**").authenticated() 
  .anyRequest().authenticated())
  .oauth2ResourceServer(it -> it.jwt(Customizer.withDefaults())); 
  return http.build();
  }
}
