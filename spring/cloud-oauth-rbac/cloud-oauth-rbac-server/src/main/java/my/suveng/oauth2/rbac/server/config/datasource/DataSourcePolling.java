package my.suveng.oauth2.rbac.server.config.datasource;

/**
 * 数据源轮询
 * @author suwenguang
 **/
public class DataSourcePolling {
	private static final DataSourceType[] DATASOURCES = DataSourceType.values();

	/**
	 * 计数值
	 */
	private static int incr = 0;

	/**
	 * 最大值
	 */
	private static final int MAX = Integer.MAX_VALUE / 1000;

	/**
	 * 阈值
	 */
	private static final int LENGTH = DATASOURCES.length;

	/**
	 * 自动轮询,只轮询从库
	 * @author suwenguang
	 */
	public static String autoPolling() {
		//判定是否需要重置
		reset();
		incr++;
		int i =  (incr % (LENGTH - 1)) + 1;
		return DATASOURCES[i].name();
	}

	/**
	 * 加权轮询
	 * @author suwenguang
	 */
	public static String weightPolling() {
		//判定是否需要重置
		reset();
		incr++;
		int i = incr % 10;
		//30%返回master,权重可配置,待做
		if (i < 3) {
			return DATASOURCES[0].name();
		}
		int target = (i % (LENGTH - 1)) + 1;
		return DATASOURCES[target].name();
	}

	/**
	 * 重置指数
	 * @author suwenguang
	 */
	private static void reset() {
		if (incr > MAX) {
			incr = 1;
		}
	}
}
