package my.suveng.guava.model;

import com.google.common.collect.ComparisonChain;
import lombok.Data;

/**
 *
 * @author suwenguang
 * @version 1.0.0
 **/
@Data
public class TestModel implements  Comparable<TestModel> {
	private String str1;

	private String str2;

	/**
	 * @see ComparisonChain
	 * @author suwenguang
	 * @date 2019/11/8
	 */
	@Override
	public int compareTo(TestModel that) {
		return ComparisonChain.start().compare(this.str1,that.str1).result();
	}
}
