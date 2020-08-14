package my.suveng.event_driver_chain.event;

/**
 * 算法抽象
 * @author suwenguang
 **/
public interface IAlgorithm {

	/**
	 * 执行算法
	 * @param params 算法参数
	 * @return 算法结果
	 */
	IResult exec(IParams params);
}
