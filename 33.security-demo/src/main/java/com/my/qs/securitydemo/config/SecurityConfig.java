package com.my.qs.securitydemo.config;

import com.my.qs.securitydemo.security.AuthProvider;
import com.my.qs.securitydemo.security.ImageCodeFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
	public ImageCodeFilter imageCodeFilter(){
		return new ImageCodeFilter();
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/index", "/").hasRole("ADMIN")
			.antMatchers("/hello").hasRole("ADMIN")
			.antMatchers("/logout").hasRole("ADMIN")
			.antMatchers("/login").permitAll()
			.and()
			.addFilterBefore(imageCodeFilter(), UsernamePasswordAuthenticationFilter.class)
			.formLogin()
			.loginPage("/login")
			.permitAll()
			.and()
			.logout()
			.logoutUrl("/logout")
			.and();

		http.csrf().disable();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// 自定义认证策略
		auth.authenticationProvider(authProvider()).eraseCredentials(true);
	}

	@Bean
	public AuthProvider authProvider(){
		return new AuthProvider();
	}
}
