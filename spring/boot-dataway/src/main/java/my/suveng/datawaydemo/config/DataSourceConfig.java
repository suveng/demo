package my.suveng.datawaydemo.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * 数据源配置
 * 
 * @author suwenguang
 **/
@Configuration
public class DataSourceConfig {

    @Bean("dataSource")
    public DataSource master() {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        druidDataSource
                .setUrl("jdbc:mysql://192.168.9.208:3306/dataway?useUnicode=true&characterEncoding=utf-8&useSSL=false");
        druidDataSource.setUsername("root");
        druidDataSource.setPassword("root");
        druidDataSource.setTestWhileIdle(true);
        druidDataSource.setValidationQuery("select 1");
        return druidDataSource;
    }

}
