package com.design.singleton.singletonDemo;

import java.lang.reflect.Constructor;

public class SingletonDemo2 {

	/**
	 * 懒汉模式
	 */

	private static volatile SingletonDemo2 instance = null;

	private SingletonDemo2() {

	}

	public static SingletonDemo2 getInstance(){
		if (instance == null){
			synchronized (SingletonDemo2.class){
				if (instance == null){
					instance = new SingletonDemo2();
				}
			}
		}
		return instance;
	}

}
