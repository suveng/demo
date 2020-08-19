package my.suveng.promethussimpleclientdemo.metric;

import io.prometheus.client.Counter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * 整合prometheus提供的simpleclient
 *
 * @author suwenguang
 **/
@Component
public class HttpApiCounter {
    /**
     * api请求次数 这里设置指标的label值
     */
    public static final Counter http_count = Counter.build().name("http_count")
            .labelNames("url", "node", "version", "reboot_time").help("机器的url").register();

}
