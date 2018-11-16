package com.TT.demo.util;

import tk.mybatis.mapper.common.BaseMapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * 这里的mymapper是我自己定义的
 * TODO: 注意：这里的mymapper不能被扫描到，否则无效！
 * 定义这个通用mapper接口是为了自定义自己的通用mapper拥有的方法！
 * @param <T>
 */
public interface MyMapper<T> extends BaseMapper<T>, MySqlMapper<T> {
}
