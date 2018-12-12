package com.tt.demo.dao.mongo;

import com.tt.demo.model.domain.mongo.UserEntity;

/**
 * Created by 苏文广 on 2018/11/20
 */
public interface UserDao {


    void saveUser(UserEntity user);


    UserEntity findUserByUserName(String userName);

    void updateUser(UserEntity userEntity);

    void deleteUserById(Long id);
}
