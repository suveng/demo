package com.my.qs.securitydemo.service;

import org.springframework.security.core.userdetails.User;

public interface UserService {
	User findUser();
}
