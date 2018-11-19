package com.TT.demo.service.impl;

import com.TT.demo.dao.springboot.UserMapper;
import com.TT.demo.domain.springboot.User;
import com.TT.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("UserService")
public class UserServiceImpl extends BaseService<User> implements UserService<User> {
    @Autowired
    private UserMapper userMapper;

}
