package my.suveng.demo.service;

import java.util.List;
import org.springframework.stereotype.Service;

/**
 * 通用service接口
 * @param <T> 对应tk.mybatis实体类
 */
@Service
public interface IService<T> {
    T selectByKey(Object key);

    int save(T entity);

    int delete(Object key);

    int updateAll(T entity);

    int updateNotNull(T entity);

    List<T> selectByExample(Object example);




    List<T> SelectRowBounds(T entity, int offset, int limit);

}
