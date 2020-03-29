package my.suveng.proxy;

import java.lang.reflect.Proxy;

public class Test {
	public static void main(String[] args) {
		Service porxy = (Service)Proxy.newProxyInstance(Service.class.getClassLoader(), new Class[]{Service.class}, new MyProxy(new ServiceImpl()));
		boolean say = porxy.say();
	}
}
