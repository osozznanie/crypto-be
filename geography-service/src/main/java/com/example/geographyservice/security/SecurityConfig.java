package com.example.geographyservice.security;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final JwtTokenFilter JwtTokenFilter;

    @Autowired
    public SecurityConfig(JwtTokenFilter jwtTokenFilter) {
        JwtTokenFilter = jwtTokenFilter;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/countries/{tag}/sale").permitAll()
                        .requestMatchers("/api/countries/{tag}").permitAll()
                        .requestMatchers("/api/world/total-pixel-number").permitAll()
                        .requestMatchers("/api/world/total-sold-pixel-number").permitAll()
                        .requestMatchers("/api/world/total-pixel-number").permitAll()
                        .anyRequest().authenticated()
                )
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterBefore(JwtTokenFilter, UsernamePasswordAuthenticationFilter.class)
                .exceptionHandling(e -> e
                        .authenticationEntryPoint(
                                (request, response, authException)
                                        -> response.sendError(
                                        HttpServletResponse.SC_UNAUTHORIZED,
                                        authException.getLocalizedMessage()
                                )
                        )
                );
        return http.build();
    }

}
