package com.my.qs.securitydemo.service.impl;

import com.my.qs.securitydemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	public User findUser() {
		return new User("root", passwordEncoder.encode("root"),
			true, true, true, true,
			AuthorityUtils.createAuthorityList("ROLE_" + "ADMIN"));
	}
}
