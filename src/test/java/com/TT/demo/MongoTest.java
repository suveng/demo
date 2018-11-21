package com.TT.demo;

import com.TT.demo.dao.mongo.UserDao;
import com.TT.demo.domain.mongo.UserEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by 苏文广 on 2018/11/20
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MongoTest {
    @Autowired
    UserDao userDao;
    @Test
    public void testMongo(){
        UserEntity userEntity = new UserEntity();
        userEntity.setId(1231233L);
        userEntity.setPassword("sdfa");
        userEntity.setUserName("suveng");
        userDao.saveUser(userEntity);
    }
}
