package com.mymart.mymart.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class LoginConfiguration {
	
	@Bean
	public InMemoryUserDetailsManager userDetailsManager() {
		
		UserDetails john = User.builder()
							.username("John")
							.password("{noop}john123")
							.roles("EMPLOYEE")
							.build();
		UserDetails mary = User.builder()
							.username("mary")
							.password("{noop}mary123")
							.roles("EMPLOYEE","MANAGER")
							.build();
		
		UserDetails susan = User.builder()
							.username("susan")
							.password("susan123")
							.roles("EMPLOYEE","MANAGER","ADMIN")
							.build();
		
		return new InMemoryUserDetailsManager(john,mary,susan);
		
	}

	@Bean	
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
 		http
 			.authorizeHttpRequests((authorizeHttpRequests) ->
 				authorizeHttpRequests
 				//restriction based on role
 					.requestMatchers("/").permitAll()
 					.requestMatchers("/home/**").hasRole("EMPLOYEE")
 					.requestMatchers("/leaders/**").hasRole("MANAGER")
 					.requestMatchers("/admin/**").hasRole("ADMIN")
 					//role based access ends 
 				.anyRequest()
 				.authenticated()
 			)
 			
 			.formLogin((form) -> form
 					.loginPage("/login")
 					.loginProcessingUrl("/authenticateTheUser")
 					.permitAll()
 					)
 			.logout(logout->logout.permitAll())
 			//for handling un authorized access exception
 			.exceptionHandling(config-> config.accessDeniedPage("/accessDenied"));
 		
 		return http.build();
 	}


}
