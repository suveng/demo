package my.suveng.oauth2.jwt.config.datasource;

import cn.hutool.core.util.StrUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author suwenguang
 **/
public class DynamicDataSourceContextHolder {
    public static final Logger log = LoggerFactory.getLogger(DynamicDataSourceContextHolder.class);

    /**
     * 使用ThreadLocal维护变量，ThreadLocal为每个使用该变量的线程提供独立的变量副本， 所以每一个线程都可以独立地改变自己的副本，而不会影响其它线程所对应的副本。
     */
    private static final ThreadLocal<String> CONTEXT_HOLDER = new ThreadLocal<>();

    /**
     * 默认数据源
     */
    public static final String DEFAULT_DS = "MASTER";

    /**
     * 设置数据源变量
     */
    public static void setDataSourceType(DataSourceType dataSourceType) {
        // log.info("切换到{}数据源", dataSourceType);
        setDataSource(dataSourceType.name());
    }

    /**
     * 获取数据源变量
     */
    public static String getDataSourceType() {
        String s = CONTEXT_HOLDER.get();
        if (StrUtil.isBlank(s)) {
            s = DEFAULT_DS;
        }
        return s;
    }

    /**
     * 清空数据源变量
     */
    public static void clearDataSourceType() {
        CONTEXT_HOLDER.remove();
    }

    /**
     * 读请求,轮询数据源路由
     * 
     * @author suwenguang
     */
    public static void readAutoPolling() {
        setDataSource(DataSourcePolling.autoPolling());
    }

    /**
     * 内部设置数据源
     * 
     * @author suwenguang
     */
    private static void setDataSource(String name) {
        if (StrUtil.isBlank(name)) {
            name = DEFAULT_DS;
        }
        CONTEXT_HOLDER.set(name);
    }

}
