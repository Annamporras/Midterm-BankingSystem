package com.ironhack.bankingsystem.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.httpBasic();
        http.csrf().disable();
        http.authorizeHttpRequests()
                .antMatchers(HttpMethod.GET,"/balance/{id}").hasAnyRole("ADMIN", "ACCOUNT_HOLDER")
                .antMatchers(HttpMethod.POST, "/accounts/checking-account/new").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/accounts/savings-account/new").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/accounts/creditcard-account/new").hasRole("ADMIN")
                .antMatchers(HttpMethod.PATCH, "/change-status/{id}").hasRole("ADMIN")
                .antMatchers(HttpMethod.PATCH, "/change-balance/{id}").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "delete/{id}").hasRole("ADMIN")
                .anyRequest().permitAll();
        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
