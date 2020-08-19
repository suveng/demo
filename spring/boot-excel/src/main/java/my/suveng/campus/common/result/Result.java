package my.suveng.campus.common.result;

import lombok.*;

import java.io.Serializable;

/**
 * @author suwenguang suveng@163.com since 2019/4/22 description: 统一返回层
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Result implements Serializable {

    @NonNull
    private Integer code;

    @NonNull
    private String msg;

    private Object data;

    private String requestId;

}
