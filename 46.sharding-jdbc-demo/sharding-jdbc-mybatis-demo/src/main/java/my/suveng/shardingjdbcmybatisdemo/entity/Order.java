package my.suveng.shardingjdbcmybatisdemo.entity;

import lombok.Data;

import java.util.Date;

/**
 *
 * @author suwenguang
 **/
@Data
public class Order {
	private Integer id ;
	private String uaId;
	private Integer status;
	private Date createTime;
	private Date modifyTime;
	private String type;
}
