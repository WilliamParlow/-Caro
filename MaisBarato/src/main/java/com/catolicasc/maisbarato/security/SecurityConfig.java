package com.catolicasc.maisbarato.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
 
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
          .authorizeRequests()
          .antMatchers("/","/index").permitAll()
          .antMatchers("/admin").hasRole("ADMIN")
          .anyRequest().authenticated()
          .and()
          .formLogin()
          .loginPage("/login")
          .permitAll()
          .and()
          .logout()
          .permitAll();
        http.exceptionHandling().accessDeniedPage("/403");
    }
 
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
         .inMemoryAuthentication()
          .withUser("user").password("{noop}user").roles("USER")
 .and()
         .withUser("admin").password("{noop}admin").roles("ADMIN");
        
    }
}