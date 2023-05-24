package com.project.springsecuritydemo.config;

import com.project.springsecuritydemo.service.JpaUserDetailService;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

@Component
@EnableWebSecurity
public class SecurityConfiguration {
    private final JpaUserDetailService jpaUserDetailService;
    private final JwtAuthFilter jwtAuthFilter;
    private final ApplicationConfig applicationConfig;

    public SecurityConfiguration(JpaUserDetailService jpaUserDetailService, JwtAuthFilter jwtAuthFilter, ApplicationConfig applicationConfig) {
        this.jpaUserDetailService = jpaUserDetailService;
        this.jwtAuthFilter = jwtAuthFilter;
        this.applicationConfig = applicationConfig;
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf()
                .disable()
                .userDetailsService(jpaUserDetailService)
                .authorizeHttpRequests()
                .requestMatchers("/greetuser","/authenticate","/adduser")
                .permitAll()
                .requestMatchers("/getuser").hasRole("ADMIN")
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
                .authenticationProvider(applicationConfig.authenticationProvider())
                .httpBasic(Customizer.withDefaults())
                .formLogin();
        return httpSecurity.build();
    }
}
