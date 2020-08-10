package my.suveng.password.auth.server.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * oauth相关配置项
 * @author suwenguang
 **/
@Data
@Component
@ConfigurationProperties(prefix = "oauth")
public class OauthEnv {
	/**
	 * 数据库的链接
	 */
	private String jdbcUrl;

	/**
	 * 数据库用户名
	 */
	private String user;

	/**
	 * 数据库密码
	 */
	private String password;

	/**
	 * 数据库驱动类
	 */
	private String jdbcDriverClass;
}
