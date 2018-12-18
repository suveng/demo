package my.suvneg.demo.util.filter;

import my.suvneg.demo.util.properties.SuvengProperties;
import my.suvneg.demo.util.properties.TestProperties;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.filters.RemoteIpFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 配置properties
 */
@Slf4j
@Configuration
public class WebConfiguration {

    @Resource
    SuvengProperties suvengProperties;
    @Resource
    TestProperties testProperties;

    @Bean
    public RemoteIpFilter remoteIpFilter(){
        return new RemoteIpFilter();
    }

    @Bean
    public FilterRegistrationBean<MyFilter> filterRegistrationBean(){
        FilterRegistrationBean<MyFilter> filterRegistrationBean=new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(new MyFilter());//添加过滤器
        filterRegistrationBean.addUrlPatterns("/*");//对所有url过滤
        filterRegistrationBean.addInitParameter("name","suveng");
        filterRegistrationBean.setName("testFilter");
        filterRegistrationBean.setOrder(1);
        return filterRegistrationBean;
    }

    //1. 创建filter内部类
    public class MyFilter implements Filter {

        @Override
        public void init(FilterConfig filterConfig) throws ServletException {

        }

        @Override
        public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
            HttpServletRequest request = (HttpServletRequest) servletRequest;
            log.error("this is MyFilter,url :"+request.getRequestURI());
            filterChain.doFilter(request, servletResponse);
        }

        @Override
        public void destroy() {

        }
    }

}
