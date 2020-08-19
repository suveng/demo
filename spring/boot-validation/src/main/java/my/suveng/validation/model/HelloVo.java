package my.suveng.validation.model;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 *
 * @author suwenguang
 * 
 * @version 1.0.0
 **/
@Data
public class HelloVo {

    @NotNull(message = "不能为空....")
    private String a;

    private String b;

}
