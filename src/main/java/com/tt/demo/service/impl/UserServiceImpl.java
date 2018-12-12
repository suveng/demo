package com.tt.demo.service.impl;

import com.tt.demo.dao.mysql.springboot.UserMapper;
import com.tt.demo.model.domain.mysql.springboot.User;
import com.tt.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("UserService")
public class UserServiceImpl extends BaseService<User> implements UserService<User> {
    @Autowired
    private UserMapper userMapper;

}
