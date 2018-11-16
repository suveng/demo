package com.TT.demo.config;

import com.github.pagehelper.PageHelper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import tk.mybatis.spring.mapper.MapperScannerConfigurer;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.Properties;

/**
 * @author Loger
 * Date: 2018-08-13
 * TIme: 15:44
 * Description :
 */
@Configuration
public class TkMybatisConfig {

    @Resource
    private DataSource dataSource;

    @Bean
    public SqlSessionFactory sqlSessionFactoryBean() throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
//        bean.setTypeAliasesPackage("");

        //添加XML目录
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        bean.setMapperLocations(resolver.getResources("mapper/*.xml"));
        return bean.getObject();
    }

    @Configuration
    @AutoConfigureAfter(TkMybatisConfig.class)
    public static class MyBatisMapperScannerConfig {

        @Bean
        public MapperScannerConfigurer mapperScannerConfig() {
            MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
            mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactoryBean");
            mapperScannerConfigurer.setBasePackage("com.TT.demo.dao.*");
            //配置通用mappers
            Properties properties = new Properties();
            properties.setProperty("notEmpty", "false");
            properties.setProperty("IDENTITY", "MYSQL");
            mapperScannerConfigurer.setProperties(properties);

            return mapperScannerConfigurer;
        }

    }

    /**
     * 配置mybatis的分页插件pageHelper
     * @return
     */
    @Bean
    public PageHelper pageHelper(){
        PageHelper pageHelper = new PageHelper();
        Properties properties = new Properties();
        properties.setProperty("offsetAsPageNum","true");
        properties.setProperty("rowBoundsWithCount","true");
        properties.setProperty("reasonable","true");
        //指定为MySQL数据库
        properties.setProperty("helperDialect","mysql");
        pageHelper.setProperties(properties);
        return pageHelper;
    }

}
