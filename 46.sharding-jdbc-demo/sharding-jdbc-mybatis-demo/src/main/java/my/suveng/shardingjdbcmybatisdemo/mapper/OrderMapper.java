package my.suveng.shardingjdbcmybatisdemo.mapper;

import my.suveng.shardingjdbcmybatisdemo.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 *
 * @author suwenguang
 **/
public interface OrderMapper {

	@Select("select * from `order` ")
	List<Order> getAll();

}
