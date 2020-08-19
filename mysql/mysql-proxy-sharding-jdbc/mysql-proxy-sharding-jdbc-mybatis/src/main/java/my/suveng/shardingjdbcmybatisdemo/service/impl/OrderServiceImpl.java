package my.suveng.shardingjdbcmybatisdemo.service.impl;

import my.suveng.shardingjdbcmybatisdemo.dao.OrderDao;
import my.suveng.shardingjdbcmybatisdemo.entity.Order;
import my.suveng.shardingjdbcmybatisdemo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (Order)表服务实现类
 *
 * @author suwenguang
 * 
 * @since 2020-08-06 18:56:48
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id
     *            主键
     * 
     * @return 实例对象
     */
    @Override
    public Order queryById(Integer id) {
        return this.orderDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset
     *            查询起始位置
     * @param limit
     *            查询条数
     * 
     * @return 对象列表
     */
    @Override
    public List<Order> queryAllByLimit(int offset, int limit) {
        return this.orderDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param order
     *            实例对象
     * 
     * @return 实例对象
     */
    @Override
    public Order insert(Order order) {
        this.orderDao.insert(order);
        return order;
    }

    /**
     * 修改数据
     *
     * @param order
     *            实例对象
     * 
     * @return 实例对象
     */
    @Override
    public Order update(Order order) {
        this.orderDao.update(order);
        return this.queryById(order.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id
     *            主键
     * 
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.orderDao.deleteById(id) > 0;
    }
}
