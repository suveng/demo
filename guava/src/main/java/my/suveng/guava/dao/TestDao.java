package my.suveng.guava.dao;

import com.google.common.base.MoreObjects;
import com.google.common.base.Optional;
import my.suveng.guava.model.TestModel;

/**
 *
 * @author suwenguang
 * @version 1.0.0
 **/
public class TestDao {
	public static final TestDao SINGLE = new TestDao();

	public Optional<TestModel> getOne() {
		return newModel();

	}

	private Optional<TestModel> newModel() {
		return Optional.absent();
	}

	/**
	 * 默认值替换
	 * @see MoreObjects
	 * @author suwenguang
	 * @date 2019/11/8
	 */
	public TestModel getOneDefaultValue() {
		return MoreObjects.firstNonNull(null, new TestModel());
	}
}
