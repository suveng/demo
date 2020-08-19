package my.suveng.oauth2.rbac.server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("my.suveng.oauth2.rbac.server.service.db.mysql.dao.mybatis")
public class Oauth2RbacServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(Oauth2RbacServerApplication.class, args);
    }

}
