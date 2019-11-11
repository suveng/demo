package my.suveng.guava.controller;

import com.google.common.base.MoreObjects;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Throwables;
import my.suveng.guava.model.TestModel;
import my.suveng.guava.service.TestService;

/**
 *
 * @author suwenguang
 * @version 1.0.0
 **/
public class TestController {

	private TestService testService;

	public TestController() {
		this.testService=TestService.SINGLE;
	}

	/**
	 * 获取test, optional使用demo
	 * @author suwenguang
	 * @date 2019/11/8
	 */
	public TestModel getOne(){
		Optional<TestModel> one = testService.getOne();
		return one.or(new TestModel());
	}

	/**
	 * object对象默认值替换空值
	 *
 	 * @see MoreObjects
	 * @author suwenguang
	 * @date 2019/11/8
	 */
	public TestModel getOneDefaultValue(){
		return testService.getOneDefaultValue();
	}

	/**
	 * guava strings的工具方法
	 * @see com.google.common.base.Strings
	 * @author suwenguang
	 * @date 2019/11/8
	 */
	public TestModel stringMethods(){
		return testService.stringMethods();
	}


	/**
	 * 前置条件检查
	 * @see Preconditions
	 * @author suwenguang
	 * @date 2019/11/8
	 */
	public void precondition(){
		//主要用于算法的参数检查, 一些集合或者数组的大小检查, 类型检查
		Preconditions.checkElementIndex(9, 10);
		Preconditions.checkArgument(true);
		Preconditions.checkNotNull(new Object());
		Preconditions.checkState(true);


		//数组越界
		Preconditions.checkElementIndex(10, 10);
		Preconditions.checkArgument(false);
		Preconditions.checkNotNull(null);
		Preconditions.checkState(false);
	}

	/**
	 * object常用方法
	 * @see com.google.common.base.Objects
	 * @author suwenguang
	 * @date 2019/11/8
	 */
	public void objects(){
		testService.objects();
	}

	/**
	 * 排序器
	 * @see com.google.common.collect.Ordering
	 * @author suwenguang
	 * @date 2019/11/8
	 */
	public void ordering(){
		testService.ordering();
	}


	/**
	 * 异常处理
	 * @author suwenguang
	 * @date 2019/11/8
	 */
	public void throwable(){
		try {
			throw new IllegalAccessException();
		} catch (IllegalAccessException e) {
			try {
				Throwables.propagateIfInstanceOf(e,IllegalAccessException.class);
			} catch (IllegalAccessException ex) {
				ex.printStackTrace();
			}
		}
	}

}
