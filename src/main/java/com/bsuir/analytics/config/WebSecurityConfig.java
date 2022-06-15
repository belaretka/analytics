package com.bsuir.analytics.config;

import com.bsuir.analytics.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private UserServiceImpl userService;

    @Autowired
    WebSecurityConfig(UserServiceImpl userService) {
        this.userService = userService;

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/", "/registration", "/information").permitAll()
                .antMatchers("/add-user", "/update-user/**", "/delete-user/**", "/users").hasRole("ADMIN")
                .antMatchers("/statistics").hasRole("ADMIN")
                .antMatchers("/requested-consultation").hasRole("ADMIN")
                .antMatchers("/companies", "/add-company", "/update-company/**", "/delete-company/**").hasRole("USER")
                .antMatchers("/sheets", "/add-sheet", "/update-sheet/**", "/delete-sheet/**", "/show-full-sheets", "/print-sheet").hasRole("USER")
                .antMatchers("/analytics", "/add-case", "/delete-case/**", "/print-case", "/analyze").hasRole("USER")
                .anyRequest().authenticated()
                .and()
                    .formLogin()
                    .loginPage("/login")
                    .permitAll()
                .and()
                    .logout().permitAll();
        http.csrf().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService)
                .passwordEncoder(NoOpPasswordEncoder.getInstance());
    }
}
