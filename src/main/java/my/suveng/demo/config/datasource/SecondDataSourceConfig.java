package my.suveng.demo.config.datasource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import tk.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * 副数据源
 */
@Configuration
@MapperScan(basePackages = "my.suveng.demo.dao.mysql", sqlSessionTemplateRef  = "springbootSqlSessionTemplate")
public class SecondDataSourceConfig {

    @Bean(name = "springbootDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.springboot")
    public DataSource testDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "springbootSqlSessionFactory")
    public SqlSessionFactory testSqlSessionFactory(@Qualifier("springbootDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:my/suveng/demo/dao/mysql/*.xml"));
        return bean.getObject();
    }

    @Bean(name = "springbootTransactionManager")
    public DataSourceTransactionManager testTransactionManager(@Qualifier("springbootDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "springbootSqlSessionTemplate")
    public SqlSessionTemplate testSqlSessionTemplate(@Qualifier("springbootSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
