package my.suveng.password.auth.server.config.oauth;
import my.suveng.password.auth.server.config.properties.OauthEnv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;

import javax.sql.DataSource;

// 授权服务器配置
@Configuration
@EnableAuthorizationServer
public class OAuth2AuthorizationServer extends AuthorizationServerConfigurerAdapter {
	/**
	 * 获取配置文件参数
	 */
	@Autowired
	private OauthEnv env;

	/**
	 * 	用户认证器,用户源在{@link org.springframework.security.core.userdetails.UserDetailsService}的实现类中找到
	 * 	实现类为: {@link CustomUserDetailsServiceImpl}
 	 */
	@Autowired
	private AuthenticationManager authenticationManager;

	/**
	 * 注入默认实现了UserDetailsService的实现类,这里使用{@link CustomUserDetailsServiceImpl}
	 */
	@Autowired
	private UserDetailsService userDetailsService;

	/**
	 * 配置自定义的认证服务
	 * @author suwenguang
	 */
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints
			.userDetailsService(userDetailsService)//配置用户认证来源,可扩展用户
			.tokenStore(tokenStore())//配置认证器的token存储方式
			// 配置用于JWT私钥加密的增强器
			.tokenEnhancer(jwtTokenEnhancer())
			.authenticationManager(authenticationManager);//配置认证器
	}



	/**
	 * 配置受信客户端
	 * @author suwenguang
	 */
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		// 使用jdbc进行clientId的校验,可动态配置client,在oauth_client_details表中配置
		clients.jdbc(dataSource())
		;

	}

	/**
	 *
	 * @author suwenguang
	 */
	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
		security.tokenKeyAccess("permitAll()")
			.checkTokenAccess("isAuthenticated()")//
			.allowFormAuthenticationForClients()//允许check_token
		;
	}

	/**
	 * 配置数据数据
	 * @author suwenguang
	 */
	@Bean
	public DataSource dataSource() {
		final DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(env.getJdbcDriverClass());
		dataSource.setUrl(env.getJdbcUrl());
		dataSource.setUsername(env.getUser());
		dataSource.setPassword(env.getPassword());
		return dataSource;
	}

	/**
	 * token使用jdbc存储
	 * @author suwenguang
	 */
	//@Bean
	//public TokenStore tokenStore() {
	//	return new JdbcTokenStore(dataSource());
	//}

	@Bean
	public TokenStore tokenStore() {
		return new JwtTokenStore(jwtTokenEnhancer());
	}

	@Bean
	protected JwtAccessTokenConverter jwtTokenEnhancer() {
		// 配置jks文件
		KeyStoreKeyFactory keyStoreKeyFactory = new KeyStoreKeyFactory(new ClassPathResource("oauth-jwt.jks"), "suveng".toCharArray());
		JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
		converter.setKeyPair(keyStoreKeyFactory.getKeyPair("oauth-jwt"));
		return converter;
	}


}
