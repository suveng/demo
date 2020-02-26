package hutool;

import lombok.Data;

import java.io.Serializable;

/**
 *
 * @author suwenguang
 **/
public class TestObject implements Cloneable, Serializable {
	private String t1;
	private String t2;

	//这里给上对象类型, 证明浅克隆只会拷贝对象地址, 一些基本类型的值也会拷贝
	private TestObject testObject;

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	public String getT1() {
		return t1;
	}

	public void setT1(String t1) {
		this.t1 = t1;
	}

	public String getT2() {
		return t2;
	}

	public void setT2(String t2) {
		this.t2 = t2;
	}

	public TestObject getTestObject() {
		return testObject;
	}

	public void setTestObject(TestObject testObject) {
		this.testObject = testObject;
	}
}
