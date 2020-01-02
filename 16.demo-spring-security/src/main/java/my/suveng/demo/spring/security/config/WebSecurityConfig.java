package my.suveng.demo.spring.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	/**
	 * 配置安全校验
	 * @author suwenguang
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers("/", "/home").permitAll()
				.anyRequest().authenticated()
				.and()
			.formLogin()
				.loginPage("/login")//指定路径的登录页,用于用户登录
				.permitAll()//登录页放开权限
				.and()
			.logout()//登出页放开权限
				.permitAll();
	}

	/**
	 * 覆盖{@link UserDetailsService}
	 * 提供受信用户,这里有两种配置方式, 这一种是直接替换{@link UserDetailsService}
	 * 另一种是替换{@link org.springframework.security.authentication.AuthenticationManager},
	 * 需要复写{@link WebSecurityConfigurerAdapter#configure(AuthenticationManagerBuilder)} 和 {@link WebSecurityConfigurerAdapter#authenticationManagerBean()}
	 * @author suwenguang
	 */
	@Bean
	@Override
	public UserDetailsService userDetailsService() {
		UserDetails user =
			 User.withDefaultPasswordEncoder()
				.username("user")
				.password("password")
				.roles("USER")
				.build();

		return new InMemoryUserDetailsManager(user);
	}
}
