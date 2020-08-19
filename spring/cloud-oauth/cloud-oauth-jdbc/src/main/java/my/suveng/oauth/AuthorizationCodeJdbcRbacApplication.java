package my.suveng.oauth;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 授权码模式+rbac模型
 * 
 * @author suwenguang
 **/
@SpringBootApplication
@MapperScan(basePackages = "my.suveng.oauth.dao")
public class AuthorizationCodeJdbcRbacApplication {
    public static void main(String[] args) {
        SpringApplication.run(AuthorizationCodeJdbcRbacApplication.class, args);
    }
}
