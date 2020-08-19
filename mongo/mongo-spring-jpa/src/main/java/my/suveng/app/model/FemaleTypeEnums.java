package my.suveng.app.model;

import lombok.Getter;

/**
 * description:
 * 
 * @author suwenguang
 * 
 * @date 2019-09-01
 * 
 * @version 1.0.0
 **/
@Getter
public enum FemaleTypeEnums {
    /**
     * 默认值
     */
    BEAUTY("漂亮", 0),

    /**
     * 大方
     */
    KINDNESS("大方", 1),

    /**
     * 聪明
     */
    CLEVER("聪明", 2),;

    private final String msg;
    private final Integer code;

    FemaleTypeEnums(String msg, Integer code) {
        this.msg = msg;
        this.code = code;
    }
}
