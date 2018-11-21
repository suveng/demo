package com.TT.demo.config.mongo;

/**
 * Created by 苏文广 on 2018/11/21
 */

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

public abstract class AbstractMongoConfig {

    // 变量名跟配置的参数对应
    private String host, database, username, password;
    private int port;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }


    public MongoDbFactory mongoDbFactory() throws Exception {
        // 无认证的初始化方法
//        return new SimpleMongoDbFactory(new MongoClient(host, port), database);

        // 有认证的初始化方法
         ServerAddress serverAddress = new ServerAddress(host, port);
        MongoCredential credential = MongoCredential.createCredential(username, database,
                password.toCharArray());
        MongoClientOptions options = MongoClientOptions.builder()
                .connectionsPerHost(100)
                .socketTimeout(30000)
                .connectTimeout(3000)
                .build();
         return new SimpleMongoDbFactory(new MongoClient(serverAddress,credential
         ,options), database);
    }


    /*
     * Factory method to create the MongoTemplate
     */
    abstract public MongoTemplate getMongoTemplate() throws Exception;

}
