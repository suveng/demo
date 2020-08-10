package my.suveng.demo.spring.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

/**
 * 重写 WebSecurityConfigurerAdapter 的方法，实现自定义的 Spring Security 的配置
 * @author suwenguang
 */
@Configuration
@EnableWebSecurity//实现自定义配置相关
@EnableGlobalMethodSecurity(prePostEnabled = true)//权限注解开启相关
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	/**
	 * 配置认证器{@link org.springframework.security.authentication.AuthenticationManager}
	 * @author suwenguang
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//复写父类方法,调用AuthenticationManagerBuilder的配置方法 配置 自定义身份认证器,链式调用
		auth
			// <1> 使用内存保存user身份信息
			.inMemoryAuthentication()
			// <2> 配置密码编码器, 这里使用空的密码编码器,注意: 只适用于测试项目
			.passwordEncoder(NoOpPasswordEncoder.getInstance())
			// <3> 注入用户信息
			.withUser("admin")//用户名
			.password("admin")//密码
			.roles("MASTER")//角色
			.and()
			// <3> 注入第二个用户
			.withUser("user")
			.password("password")
			.roles("USER")
		;


	}

	/**
	 * 配置资源的安全校验规则
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
				//.loginPage("/login")//指定路径的登录页,用于用户登录
				.permitAll()//登录页放开权限
				.and()
			.logout()//登出页放开权限
				//.logoutUrl("/logout") //自定义路径退出
				.permitAll();
	}


}
