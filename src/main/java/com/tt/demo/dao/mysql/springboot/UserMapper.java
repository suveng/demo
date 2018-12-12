package com.tt.demo.dao.mysql.springboot;

import com.tt.demo.domain.mysql.springboot.User;
import com.tt.demo.util.MyMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface UserMapper extends MyMapper<User> {
}