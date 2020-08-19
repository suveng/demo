package my.suveng.app.model.result;

import lombok.Data;

/**
 * description:
 * 
 * @author suwenguang
 * 
 * @date 2019-08-05
 * 
 * @version 1.0.0
 **/
@Data
public class ServiceResult<T> {
    private boolean result;
    private int code;
    private String msg;
    private T data;

    public ServiceResult() {
    }

    public ServiceResult(T data) {
        this.data = data;
    }
}
