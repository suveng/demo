package my.suveng.app.dao;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.RandomUtil;
import my.suveng.app.BaseTest;
import my.suveng.app.model.Female;
import org.joda.time.LocalDate;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * description:
 * @author suwenguang
 * @date 2019-09-01
 * @version 1.0.0
 **/
public class FemaleRepositoryTest extends BaseTest {

	@Autowired
	FemaleRepository femaleRepository;


	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * description: 添加测试数据
	 * author: suwenguang
	 * date: 2019-09-01
	 */
	@Test
	public void addTestData() {
		for (int i = 0; i < 1000; i++) {
			Female entity = new Female();
			entity.setName(RandomUtil.randomString(12));
			LocalDate now = LocalDate.now();
			LocalDate localDate = now.minusDays(RandomUtil.randomInt(4));
			entity.setCreateTime(localDate.toDate());
			femaleRepository.save(entity);
		}
	}
}
