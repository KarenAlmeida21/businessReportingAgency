package com.api.businessReportingAgency.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfig {
    //WebSecurityConfigurerAdapter descontinuada

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        //configs
        http
                .httpBasic()
                .and()
                .authorizeHttpRequests()
                .antMatchers(HttpMethod.GET, "/report/**").permitAll()
                .antMatchers(HttpMethod.POST, "/report").hasRole("MANAGER")
                .antMatchers(HttpMethod.DELETE, "/report/**").hasRole("MANAGER")
                .anyRequest().authenticated()
                .and()
                .csrf().disable();
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
