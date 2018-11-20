package com.TT.demo.dao.mongo.impl;

import com.TT.demo.dao.mongo.UserDao;
import com.TT.demo.domain.mongo.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
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
    MongoTemplate mongoTemplate;


    /**
     * 创建对象
     * @param user user
     */
    @Override
    public void saveUser(UserEntity user) {
        mongoTemplate.insert(user);
    }

    /**
     * 根据用户名查找对象
     * @param userName 用户名
     * @return userEntity
     */
    @Override
    public  UserEntity findUserByUserName(String userName){
    Query query=new Query(Criteria.where("userName").is(userName));
    return mongoTemplate.findOne(query, UserEntity.class);
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
        mongoTemplate.updateFirst(query, update, UserEntity.class);
//        更新所有
        mongoTemplate.updateMulti(query, update, UserEntity.class);
    }

    /**
     * 根据id删除对象
     * @param id id
     */
    @Override
    public void deleteUserById(Long id){
        Query query = new Query(Criteria.where("id").is(id));
        mongoTemplate.remove(query,UserEntity.class);
    }

}
