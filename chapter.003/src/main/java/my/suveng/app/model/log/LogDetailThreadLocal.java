package my.suveng.app.model.log;

/**
 * description:
 * @author suwenguang
 * @date 2019/7/18
 * @version 1.0.0
 **/
public class LogDetailThreadLocal {
    //'必须回收自定义的ThreadLocal变量，尤其在线程池场景下，线程经常会被复用，如果不清理自定义的 ThreadLocal变量，
    // 可能会影响后续业务逻辑和造成内存泄露等问题。尽量在代理中使用try-finally块进行回收。'
    public static ThreadLocal<LogDetail> logDetailThreadLocal = new ThreadLocal<LogDetail>(){
        @Override
        protected LogDetail initialValue() {
            return new LogDetail();
        }
    };

}
