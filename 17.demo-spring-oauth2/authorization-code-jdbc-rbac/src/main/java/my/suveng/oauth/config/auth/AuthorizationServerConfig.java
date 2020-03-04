package my.suveng.oauth.config.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

import javax.sql.DataSource;

/**
 * 认证中心配置
 * @author suwenguang
 **/
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

	@Autowired
	private DataSource dataSource;
	@Autowired
	private AuthenticationManager authenticationManager;

	/**
	 * 配置token使用jdbc存储
	 * @author suwenguang
	 */
	@Bean
	public TokenStore tokenStore(){
		return new JdbcTokenStore(dataSource);
	}

	@Bean
	public ClientDetailsService jdbcClientDetails() {
		// 基于 JDBC 实现，需要事先在数据库配置客户端信息
		return new JdbcClientDetailsService(dataSource);
	}


	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		// 设置令牌
		endpoints.tokenStore(tokenStore()).authenticationManager(authenticationManager);
	}


	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		// 读取客户端配置
		clients.withClientDetails(jdbcClientDetails());
	}

}
