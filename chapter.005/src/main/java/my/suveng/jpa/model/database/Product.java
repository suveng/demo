package my.suveng.jpa.model.database;

import lombok.Data;

import javax.persistence.*;

/**
 * 商品
 * @author suwenguang
 * @version 1.0.0
 **/
@Data
@Entity
@Table(name = "sys_product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long productId;

	private String name;

	private Double price;
}
