package my.suveng.oauth2.jwt.config.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
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
 * @author suwenguang
 **/
@Configuration
public class DataSourceConfig {

	@Bean("dataSource")
	public DataSource master() {
		DruidDataSource druidDataSource = new DruidDataSource();
		druidDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		druidDataSource.setUrl("jdbc:mysql://192.168.9.234:3306/oauth2?useUnicode=true&characterEncoding=utf-8&useSSL=false");
		druidDataSource.setUsername("root");
		druidDataSource.setPassword("123456");
		druidDataSource.setTestWhileIdle(true);
		druidDataSource.setValidationQuery("select 1");
		return druidDataSource;
	}


	@Bean(name = "dataSourceTransactionManager")
	public DataSourceTransactionManager dataSourceTransactionManager(@Qualifier("dynamicDataSource") DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}


	@Bean(name = "sqlSessionFactory")
	public SqlSessionFactory sqlSessionFactory(@Qualifier("dynamicDataSource") DataSource dataSource) throws Exception {
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(dataSource);
		bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:generator/**/*.xml"));
		//bean.setConfigLocation(new PathMatchingResourcePatternResolver().getResource("classpath:mybatis-config.xml"));
		return bean.getObject();
	}


	@Bean(name = "dynamicDataSource")
	@Primary
	public DynamicDataSource dataSource(
		@Qualifier(value = "dataSource") DataSource masterDataSource
	) {
		Map<Object, Object> targetDataSources = new HashMap<>();
		targetDataSources.put(DataSourceType.MASTER.name(), masterDataSource);
		return new DynamicDataSource(masterDataSource, targetDataSources);
	}

}
