package my.suveng.app.model.result;

import lombok.*;

import java.io.Serializable;

/**
 * @author suwenguang
 *         suveng@163.com
 * since 2019/4/22
 * description: 统一返回层
 **/
@Data
public class Result implements Serializable {

	@NonNull
    private Integer code;

	@NonNull
    private String msg;

    private Object data;

	private String requestId;

	public Result(Integer code, String msg, Object data, String requsetId) {
		this.code=code;
		this.msg=msg;
		this.data=data;
		this.requestId=requsetId;
	}
}
