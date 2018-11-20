package com.TT.demo.domain.mongo;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by 苏文广 on 2018/11/20
 * mongo实体类
 */
@Data
public class UserEntity implements Serializable {
    private  Long id;
    private String userName;
    private String password;
}
