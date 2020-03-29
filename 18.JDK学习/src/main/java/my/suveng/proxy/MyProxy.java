package my.suveng.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyProxy implements InvocationHandler {
	//代理对象
	private Object target;

	public MyProxy(Object target) {
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		//
		System.out.println("前置");
		Object result = method.invoke(target, args);
		System.out.println("后置");
		return result;
	}
}
