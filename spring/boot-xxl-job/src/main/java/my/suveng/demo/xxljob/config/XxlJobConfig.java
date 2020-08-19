package my.suveng.demo.xxljob.config;

import com.xxl.job.core.executor.impl.XxlJobSpringExecutor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * xxl-job-executor 配置类
 * 
 * @author suwenguang
 **/
@Configuration
@Slf4j
public class XxlJobConfig {

    @Bean
    public XxlJobSpringExecutor xxlJobExecutor() {
        log.info(">>>>>>>>>>> xxl-job config init.");
        XxlJobSpringExecutor xxlJobSpringExecutor = new XxlJobSpringExecutor();
        // 调度器地址
        xxlJobSpringExecutor.setAdminAddresses("http://127.0.0.1:58080/xxl-job-admin");
        xxlJobSpringExecutor.setAppname("appname-test");
        // 默认为空 自动获取ip
        xxlJobSpringExecutor.setIp("");
        // 本地服务的端口
        xxlJobSpringExecutor.setPort(58081);
        // 非空时启用数据加密
        // xxlJobSpringExecutor.setAccessToken("accessToken");
        // 日志目录
        xxlJobSpringExecutor.setLogPath("/data/logs/xxl-job/jobhandler");
        xxlJobSpringExecutor.setLogRetentionDays(30);
        return xxlJobSpringExecutor;
    }
}
