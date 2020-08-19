package my.suveng.validation.model;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 *
 * @author suwenguang
 * 
 * @version 1.0.0
 **/
@Data
public class HelloBo {

    private String c;

    private String d;

    /**
     * 正则校验
     */
    @Pattern(regexp = "[A-Z][a-z][0-9]")
    private String e;
}
