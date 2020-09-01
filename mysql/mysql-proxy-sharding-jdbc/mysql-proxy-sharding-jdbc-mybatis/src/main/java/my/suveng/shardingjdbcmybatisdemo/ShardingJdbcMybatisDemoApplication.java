package my.suveng.shardingjdbcmybatisdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("my.suveng.shardingjdbcmybatisdemo.dao")
public class ShardingJdbcMybatisDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShardingJdbcMybatisDemoApplication.class, args);
    }

}
