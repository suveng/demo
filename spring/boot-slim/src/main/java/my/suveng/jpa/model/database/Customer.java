package my.suveng.jpa.model.database;

import lombok.Data;

import javax.persistence.*;

/**
 * 顾客
 * 
 * @author suwenguang
 * 
 * @version 1.0.0
 **/
@Data
@Entity
@Table(name = "sys_customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(insertable = false, name = "customer_id", nullable = false)
    private Long customerId;

    @Column(name = "name", columnDefinition = "varchar(20) not null default '' comment '姓名' ")
    private String name;

    @Column(name = "age", columnDefinition = "int(3) not null default 0 comment '年龄'")
    private Integer age;

    @Column(name = "balance", columnDefinition = "decimal(30,2) not null default 0 comment '金额'")
    private Double balance;

}
