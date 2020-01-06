package my.suveng.password.auth.server.config.oauth;

import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * 自定义的UserDetailsService
 * @author suwenguang
 **/
@Service
public class CustomUserDetailsServiceImpl implements UserDetailsService {

	/**
	 * 密码编码规则
	 * @author suwenguang
	 */
	@Bean
	public PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

	/**
	 * 这里可以配置UserDetailsService, 可以实现自定义用户校验, 整合用户权限系统
	 * @author suwenguang
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		if ("username".equals(username)){
			return User.withUsername(username).password(passwordEncoder().encode("password")).authorities("ALL").build();
		}
		throw new UsernameNotFoundException(username+"没找到,请重新设置");

	}
}
