package com.design.singleton.singletonDemo;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.lang.reflect.Constructor;

public class SingletonDemo1 {

    private String name;

    /**
     * 饿汉模式
     */

    private static final SingletonDemo1 instance = new SingletonDemo1();

    public String getName() {
        return name;
    }

    private SingletonDemo1() {

    }

    public static SingletonDemo1 getInstance() {
        return instance;
    }

    public static void main(String[] args) throws Exception {
        SingletonDemo1 instance1 = SingletonDemo1.getInstance();
        SingletonDemo1 instance2 = SingletonDemo1.getInstance();

        System.out.println(instance1 == instance2);

        // 反射构造
        Class<SingletonDemo1> clazz = SingletonDemo1.class;
        Constructor<SingletonDemo1> constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);
        SingletonDemo1 instance3 = constructor.newInstance();
        System.out.println(instance3 == instance1);

        // 序列化
        ObjectMapper objectMapper = new ObjectMapper();
        String s = objectMapper.writeValueAsString(instance1);
        SingletonDemo1 instance4 = objectMapper.readValue(s, SingletonDemo1.class);
        System.out.println(instance4 == instance1);

    }
}
