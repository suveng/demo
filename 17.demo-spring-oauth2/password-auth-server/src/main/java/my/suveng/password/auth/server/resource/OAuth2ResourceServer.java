package my.suveng.password.auth.server.resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;

// 资源服务配置
@Configuration
@EnableResourceServer
public class OAuth2ResourceServer extends ResourceServerConfigurerAdapter {

	/**
	 * 资源安全权限配置
	 * @author suwenguang
	 */
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                // 对 "/api/**" 开启认证
                .anyRequest()
                .authenticated()
                .and()
                .requestMatchers()
                .antMatchers("/api/**");
    }


	@Bean
	@Qualifier("publicTokenStore")
	public TokenStore tokenStore() {
		return new JwtTokenStore(jwtTokenEnhancer());
	}


	@Bean(name = "publicJwtTokenEnhancer")
	public JwtAccessTokenConverter jwtTokenEnhancer() {
		// 用作JWT转换器
		JwtAccessTokenConverter converter =  new JwtAccessTokenConverter();
		Resource resource = new ClassPathResource("oauth-public.cert");
		String publicKey;
		try {
			publicKey = new String(FileCopyUtils.copyToByteArray(resource.getInputStream()));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		//设置公钥
		converter.setVerifierKey(publicKey);
		return converter;
	}

}

// 实际，OAuth2ResourceServer 不是和 OAuth2AuthorizationServer 一起。
// 主要考虑，简化 demo ，所以改成这样。
