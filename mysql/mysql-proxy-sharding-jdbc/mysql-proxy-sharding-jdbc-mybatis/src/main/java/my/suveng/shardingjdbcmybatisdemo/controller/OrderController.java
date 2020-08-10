package my.suveng.shardingjdbcmybatisdemo.controller;

import my.suveng.shardingjdbcmybatisdemo.entity.Order;
import my.suveng.shardingjdbcmybatisdemo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * (Order)表控制层
 *
 * @author suwenguang
 * @since 2020-08-06 18:56:48
 */
@RestController
@RequestMapping("order")
public class OrderController {
	/**
	 * 服务对象
	 */
	@Autowired
	private OrderService orderService;

	/**
	 * 通过主键查询单条数据
	 *
	 * @param id 主键
	 * @return 单条数据
	 */
	@GetMapping("selectOne")
	public Order selectOne(Integer id) {
		return this.orderService.queryById(id);
	}

}
