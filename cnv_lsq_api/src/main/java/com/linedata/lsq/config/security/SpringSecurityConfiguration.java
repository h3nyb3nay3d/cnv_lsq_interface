//package com.linedata.lsq.config.security;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//
//@EnableWebSecurity
//public class SpringSecurityConfiguration {
//
//  @Bean
//  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//    http
//        .authorizeHttpRequests((authz) -> authz
//            .antMatchers("/api/blocking/**").hasAuthority("SCOPE_SUPER")
//            .anyRequest().permitAll()
//        )
//        .oauth2ResourceServer().jwt();
//
//    return http.build();
//  }
//}
