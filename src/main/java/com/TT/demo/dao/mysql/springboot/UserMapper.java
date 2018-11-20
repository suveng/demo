package com.TT.demo.dao.mysql.springboot;

import com.TT.demo.domain.mysql.springboot.User;
import com.TT.demo.util.MyMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface UserMapper extends MyMapper<User> {
}