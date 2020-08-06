package my.suveng.shardingjdbcmybatisdemo.controller;

import my.suveng.shardingjdbcmybatisdemo.entity.Order;
import my.suveng.shardingjdbcmybatisdemo.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *
 * @author suwenguang
 **/
@RestController
public class OrderController {

	@Autowired
	private OrderMapper orderMapper;

	@RequestMapping("/get/all")
	public String getAll(){
		List<Order> all = orderMapper.getAll();
		if (all == null || all.isEmpty()){
			return "fail";
		}
		return  "success";
	}
}
