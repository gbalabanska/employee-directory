package com.luv2code.springboot.thymeleafdemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class DemoSecurityConfig {

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {

        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

        // define query to retrieve a user by username
        jdbcUserDetailsManager.setUsersByUsernameQuery(
                "select user_id, pw, active from members where user_id=?");

        // define query to retrieve the authorities/roles by username
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
                "select user_id, role from roles where user_id=?");

        return jdbcUserDetailsManager;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(configurer ->
                        configurer
                                .requestMatchers("/sign-up", "/process-signup", "/access-denied").permitAll()
                                .requestMatchers("/employees/delete/**").hasAnyRole("ADMIN") // only admin can delete employees
                                .requestMatchers("/employees/showFormForUpdate/**").hasAnyRole("ADMIN", "MANAGER")  // admin and manager update employees
                                .requestMatchers("/employees/showFormForAdd/**").hasAnyRole("ADMIN", "MANAGER")  // admin and manager add employees
                                .anyRequest().authenticated()
                )
                .formLogin(form ->
                        form
                                .loginPage("/showMyLoginPage")
                                .loginProcessingUrl("/authenticateTheUser")
                                .defaultSuccessUrl("/employees/list", true) // redirect after successful login
                                .permitAll()
                )
                .logout(logout -> logout.permitAll()
                )
                // configure exception handling for unauthorized access
            .exceptionHandling(
                exception
                        -> exception.accessDeniedPage(
                        "/access-denied"));

        return http.build();
    }

}
