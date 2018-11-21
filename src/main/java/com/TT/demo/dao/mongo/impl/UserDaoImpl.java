package com.TT.demo.dao.mongo.impl;

import com.TT.demo.dao.mongo.UserDao;
import com.TT.demo.domain.mongo.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

/**
 * Created by 苏文广 on 2018/11/20
 */
@Component("userDao")
public class UserDaoImpl implements UserDao {
    @Autowired
            @Qualifier(value = "test1MongoTemplate")
    MongoTemplate test1MongoTemplate;
    @Autowired
    @Qualifier(value = "test2MongoTemplate")
    MongoTemplate test2MongoTemplate;

    /**
     * 创建对象
     * @param user user
     */
    @Override
    public void saveUser(UserEntity user) {
        test1MongoTemplate.insert(user);
        test2MongoTemplate.insert(user);
    }

    /**
     * 根据用户名查找对象
     * @param userName 用户名
     * @return userEntity
     */
    @Override
    public  UserEntity findUserByUserName(String userName){
    Query query=new Query(Criteria.where("userName").is(userName));
    return test1MongoTemplate.findOne(query, UserEntity.class);
    }

    /**
     * 更新对象
     * @param userEntity user
     */
    @Override
    public void updateUser(UserEntity userEntity){
        Query query=new Query(Criteria.where("id").is(userEntity.getId()));
        Update update=new Update().set("userName",userEntity.getUserName() )
                .set("password", userEntity.getPassword());
//        更新一条
        test1MongoTemplate.updateFirst(query, update, UserEntity.class);
//        更新所有
        test1MongoTemplate.updateMulti(query, update, UserEntity.class);
    }

    /**
     * 根据id删除对象
     * @param id id
     */
    @Override
    public void deleteUserById(Long id){
        Query query = new Query(Criteria.where("id").is(id));
        test1MongoTemplate.remove(query,UserEntity.class);
    }

}
