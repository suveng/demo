package my.suveng.campus.modules.model;

import lombok.Data;

import java.util.Date;

/**
 * description:
 * 
 * @author suwenguang
 * 
 * @date 2019-08-25
 * 
 * @version 1.0.0
 **/
@Data
public class Product {
    private String name;
    private String number;
    private String type;
    private String unit;
    private String left;
    private String monthNumber;
    private String in;
    private String out;
    private Date date;
}
