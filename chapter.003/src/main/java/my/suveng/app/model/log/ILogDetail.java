package my.suveng.app.model.log;

/**
 * description:
 * @author suwenguang
 * @date 2019/7/16
 * @version 1.0.0
 **/
public interface ILogDetail {
    @Override
    String toString();

    /**
     * 说明: 获取接口返回的消息
     * @author suwenguang
     * @date 2019/7/16
     * @return java.lang.String <- 返回类型
     */
    String getRes();

    /**
     * 说明: 设置信息
     * @author suwenguang
     * @date 2019/7/16
     * @return void <- 返回类型
     */
    LogDetail setMsg(String format, Object... arg);

}
