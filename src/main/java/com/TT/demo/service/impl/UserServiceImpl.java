package com.TT.demo.service.impl;

import com.TT.demo.dao.UserMapper;
import com.TT.demo.domain.User;
import com.TT.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("UserService")
public class UserServiceImpl extends BaseService<User> implements UserService {
    @Autowired
    private UserMapper userMapper;

}
