package my.suveng.app.model.result;

/**
 * description:
 * 
 * @author suwenguang
 * 
 * @date 2019-08-23
 * 
 * @version 1.0.0
 **/
public enum CodeEnum {
    // 成功
    SUCCESS(2000, "成功"),

    // 异常
    EXCEPTION(5000, "异常"),

    // 参数错误
    CLIENT_EXCEPTION(4000, "客户端传参错误"),;

    private final Integer code;
    private final String msg;

    CodeEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
