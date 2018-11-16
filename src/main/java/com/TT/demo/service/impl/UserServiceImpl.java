package com.TT.demo.service.impl;

import com.TT.demo.domain.User;
import com.TT.demo.service.UserService;
import org.springframework.stereotype.Service;

@Service("UserService")
public class UserServiceImpl extends BaseService<User> implements UserService {

}
