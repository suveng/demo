package hutool;

import cn.hutool.core.util.ObjectUtil;
import org.junit.Test;

/**
 * hutool工具core测试例子
 *
 * @author suwenguang
 **/
public class CoreTest {

	/**
	 * 深克隆与浅克隆
	 * @author suwenguang
	 */
	@Test
	public void cloneTest() {
		//浅克隆直接调用object的clone()方法,但是前提必须先实现cloneable接口,否则抛出cloneNotSupport异常
		TestObject testObject = new TestObject();
		testObject.setTestObject(new TestObject());
		try {

			Object clone = testObject.clone();
			//==判断的是内存引用的地址,克隆的对象虽然值一样,但是从内存上看 已经是不同的内存地址了
			System.out.println("浅克隆"+(clone == testObject));


			System.out.println("浅克隆"+clone.equals(testObject));

			System.out.println("浅克隆"+testObject.hashCode());
			System.out.println("浅克隆"+clone.hashCode());

			// 浅克隆的对象 里面成员属性的 地址应该是一样的, 所以这里equals应该还是true
			System.out.println("浅克隆"+testObject.getTestObject().equals(((TestObject) clone).getTestObject()));


			// 这里使用hutool的深克隆方法,前提是对象必须实现序列化接口serializable
			TestObject another = ObjectUtil.cloneByStream(testObject);
			//==判断的是内存引用的地址,克隆的对象虽然值一样,但是从内存上看 已经是不同的内存地址了
			System.out.println("深克隆"+(clone == another));


			System.out.println("深克隆"+clone.equals(another));

			System.out.println("深克隆"+another.hashCode());
			System.out.println("深克隆"+clone.hashCode());

			// 深克隆的对象 里面成员属性的 地址应该是不一样的, 所以这里equals应该还是false
			System.out.println("深克隆"+testObject.getTestObject().equals(another.getTestObject()));

		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}


	}
}
