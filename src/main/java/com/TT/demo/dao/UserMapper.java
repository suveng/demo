package com.TT.demo.dao;

import com.TT.demo.domain.User;
import com.TT.demo.util.MyMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends MyMapper<User> {
}