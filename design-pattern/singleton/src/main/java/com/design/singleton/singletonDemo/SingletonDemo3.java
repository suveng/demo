package com.design.singleton.singletonDemo;

public class SingletonDemo3 {
    /**
     * 枚举实现
     */

    enum SingletonEnum {
        INSTANCE;

        private final SingletonDemo3 instance;

        SingletonEnum() {
            instance = new SingletonDemo3();
        }

        public SingletonDemo3 getInstance() {
            return instance;
        }
    }

    public static SingletonDemo3 getInstance() {
        return SingletonEnum.INSTANCE.getInstance();
    }

}
