package my.suveng.demo.service.impl;

import java.util.List;
import my.suveng.demo.service.IService;
import my.suveng.demo.util.MyMapper;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 通用service实现类，用于service层的基类
 * 提供一些通用方法；
 * TODO：注意:这个类里面的参数都是tk.mybatis实体类，不是实体类会出错
 * @param <T> tk.mybatis要求的实体类
 */
public abstract class BaseService<T> implements IService<T> {
    @Autowired
    protected MyMapper<T> mapper;

    public MyMapper<T> getMapper() {
        return mapper;
    }

    @Override
    public T selectByKey(Object key) {
        //说明：根据主键字段进行查询，方法参数必须包含完整的主键属性，查询条件使用等号
        return mapper.selectByPrimaryKey(key);
    }

    @Override
    public int save(T entity) {
        //说明：保存一个实体，null的属性也会保存，不会使用数据库默认值
        return mapper.insertSelective(entity);
    }

    @Override
    public int delete(Object key) {
        //说明：根据主键字段进行删除，方法参数必须包含完整的主键属性
        return mapper.deleteByPrimaryKey(key);
    }

    @Override
    public int updateAll(T entity) {
        //说明：根据主键更新实体全部字段，null值会被更新
        return mapper.updateByPrimaryKey(entity);
    }

    @Override
    public int updateNotNull(T entity) {
        //根据主键更新属性不为null的值
        return mapper.updateByPrimaryKeySelective(entity);
    }

    @Override
    public List<T> selectByExample(Object example) {
        //说明：根据Example条件进行查询
        //重点：这个查询支持通过Example类指定查询列，通过selectProperties方法指定查询列
        return mapper.selectByExample(example);
    }



    @Override
    public List<T> SelectRowBounds(T entity, int offset, int limit) {
        return mapper.selectByRowBounds(entity, new RowBounds(offset,limit));
    }


}