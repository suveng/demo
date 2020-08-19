package my.suveng.app.model;

import lombok.Data;

/**
 * description:
 * 
 * @author suwenguang
 * 
 * @date 2019-09-01
 * 
 * @version 1.0.0
 **/
@Data
public class Male {
    /**
     * 唯一标识
     */
    private String id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */
    private String age;

    /**
     * 财产等级
     */
    private Integer property;

    /**
     * 颜值
     */
    private Integer handsome;
}
