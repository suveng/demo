package my.suveng.jpa.service;

import cn.hutool.core.util.RandomUtil;
import com.sun.org.apache.regexp.internal.RE;
import my.suveng.jpa.dao.UserRepository;
import my.suveng.jpa.model.database.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * @author suwenguang
 * @version 1.0.0
 **/
@Service
public class UserService {
	@Autowired
	UserRepository userRepository;


	public List<User> select() {
		return userRepository.findAll();
	}

	public void insert() {
		for (int i = 0; i < 1000; i++) {
			User s = new User();
			s.setUserName(RandomUtil.randomString(3));
			s.setPassword(RandomUtil.randomString(3));
			userRepository.save(s);
		}
	}
}
