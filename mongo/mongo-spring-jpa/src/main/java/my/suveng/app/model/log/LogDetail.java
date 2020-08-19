package my.suveng.app.model.log;

import cn.hutool.core.util.StrUtil;

/**
 * description:
 * 
 * @author suwenguang
 * 
 * @date 2019/7/16
 * 
 * @version 1.0.0
 **/
@SuppressWarnings("all")
public class LogDetail implements ILogDetail {
    private static LogDetail logDetail = null;

    /**
     * 线程名称
     **/
    private String threadName;

    /**
     * 标签
     **/
    private String tag;

    /**
     * 本地请求id
     **/
    private String requsetId;

    /**
     * 代码阶段
     **/
    private String stage;

    /**
     * 日志信息
     **/
    private String msg;

    private String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public LogDetail setThreadName(String threadName) {
        this.threadName = threadName;
        return this;
    }

    public LogDetail setStage(String stage) {
        this.stage = stage;
        return this;
    }

    public LogDetail setTag(String tag) {
        this.tag = tag;
        return this;

    }

    public LogDetail setMsg(String msg) {
        this.msg = msg;
        return this;

    }

    public LogDetail setRequsetId(String requsetId) {
        this.requsetId = requsetId;
        return this;

    }

    /**
     * 说明: 设置msg,采用format
     * 
     * @author suwenguang
     * 
     * @date 2019/7/17
     * 
     * @return void <- 返回类型
     */
    @Override
    public LogDetail setMsg(String format, Object... args) {
        this.msg = String.format(format, args);
        return this;

    }

    public LogDetail() {
        this.threadName = Thread.currentThread().getName();
    }

    public LogDetail(String tag, String requsetId, String stage) {
        this.tag = tag;
        this.requsetId = requsetId;
        this.stage = stage;
        this.threadName = Thread.currentThread().getName();
    }

    public String getThreadName() {
        return threadName;
    }

    public String getStage() {
        return stage;
    }

    public String getTag() {
        return tag;
    }

    public String getMsg() {
        return msg;
    }

    public String getRequsetId() {
        return requsetId;
    }

    /**
     * 说明: 获取系统error的返回信息
     * 
     * @author suwenguang
     * 
     * @date 2019/7/17
     * 
     * @return java.lang.String <- 返回类型
     */
    @Override
    public String getRes() {
        return String.format("%s,requestid:%s", this.msg, this.requsetId);
    }

    /**
     * 说明: 工厂方法,单例模式
     * 
     * @author suwenguang
     * 
     * @date 2019/7/17
     * 
     * @return yiyou.tt.commision.core.common.logback.LogDetail <- 返回类型
     */
    public static LogDetail build() {
        if (logDetail == null) {
            synchronized (ILogDetail.class) {
                if (logDetail == null) {
                    return new LogDetail();
                }
            }
        }
        return logDetail;
    }

    /**
     * 说明: 日志规范
     * 
     * @author suwenguang
     * 
     * @date 2019/7/17
     * 
     * @return java.lang.String <- 返回类型
     */
    @Override
    public String toString() {
        String tagStr = this.tag;
        String stageStr = this.stage;
        String msgStr = this.msg;
        String requsetIdStr = this.requsetId;

        if (StrUtil.isBlank(tagStr)) {
            String str = "默认";
            tagStr = str;
        }
        if (StrUtil.isBlank(stageStr)) {
            String str = "默认";
            stageStr = str;
        }
        if (StrUtil.isBlank(msgStr)) {
            String str = "默认";
            msgStr = str;
        }
        if (StrUtil.isBlank(requsetIdStr)) {
            String str = "默认";
            requsetIdStr = str;
        }

        return String.format("[%s]:%s:%s:requestid=%s", tagStr, stageStr, msgStr, requsetIdStr);
    }
}
