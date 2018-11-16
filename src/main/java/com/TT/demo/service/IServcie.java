package com.TT.demo.service;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 通用service接口
 * @param <T> 对应tk.mybatis实体类
 */
@Service
public interface IServcie<T> {
    T selectByKey(Object key);

    int save(T entity);

    int delete(Object key);

    int updateAll(T entity);

    int updateNotNull(T entity);

    List<T> selectByExample(Object example);
}
