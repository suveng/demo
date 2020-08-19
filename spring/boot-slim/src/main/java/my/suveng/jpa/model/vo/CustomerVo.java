package my.suveng.jpa.model.vo;

import lombok.Data;

import javax.persistence.Embeddable;

/**
 * vo
 * 
 * @author suwenguang
 * 
 * @version 1.0.0
 **/
@Data
@Embeddable
public class CustomerVo {
    private Long customerId;
}
