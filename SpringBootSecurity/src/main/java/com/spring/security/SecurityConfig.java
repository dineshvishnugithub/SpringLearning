package com.spring.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
//	@Autowired
	CustomAuthenticationProvider customAuthenticationProvider;
	
	@Autowired
	CustomUserDetailsService customUserDetailsService;
	
	@Bean
	public PasswordEncoder myPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	/** try first enabling authentication provider alone, try user detailservice seperately for testing*/
	   @Override
		protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		   System.out.println("SecurityConfig customAuthenticationProvider:: " +customAuthenticationProvider);
		   
		   //to test authentication provide overriding concept
//		   auth.authenticationProvider(customAuthenticationProvider);
		   
		   //   or
		   
		   //to test user details service overriding concept
		   auth.userDetailsService(customUserDetailsService).passwordEncoder(myPasswordEncoder());
		}
	   
	   @Override
	   protected void configure(HttpSecurity http) throws Exception {
		   System.out.println("Using SecurityConfig configure(HttpSecurity)");

			//default
//			http
//			    .authorizeRequests()
//				.anyRequest().authenticated()
//				.and()
//				.formLogin().and()
//				.httpBasic();
			
			//custom
			http.csrf().disable()
		    .authorizeRequests()
			.antMatchers("/admin")
			.hasRole("ADMIN")
			.antMatchers("/user")
			.hasAnyRole("ADMIN","USER")
			.and()
			.httpBasic();
		}
}
