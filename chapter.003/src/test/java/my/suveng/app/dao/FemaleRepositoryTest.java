package my.suveng.app.dao;

import cn.hutool.core.util.RandomUtil;
import com.alibaba.fastjson.JSON;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;
import my.suveng.app.BaseTest;
import my.suveng.app.model.Female;
import my.suveng.app.model.QFemale;
import org.joda.time.LocalDate;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

	/**
	 * description: 测试查询构造器
	 * author: suwenguang
	 * date: 2019-09-01
	 */
	public void  matching(){
		//精确匹配和模糊匹配
		Female probe = new Female();
		ExampleMatcher matching = ExampleMatcher.matching()
			.withMatcher("name", ExampleMatcher.GenericPropertyMatcher.of(ExampleMatcher.StringMatcher.CONTAINING))//模糊匹配
			.withIgnorePaths("id")//忽略匹配id
			;
		PageRequest of = PageRequest.of(0, 10);
		Page<Female> all = femaleRepository.findAll(Example.of(probe, matching), of);
		System.out.println(JSON.toJSONString(all));
	}

	/**
	 * description: 测试范围查询
	 * author: suwenguang
	 * date: 2019-09-01
	 */
	@Test
	public void findAllByCreateTimeAfter() {
		LocalDate yesteday = new LocalDate().minusDays(3);
		PageRequest of = PageRequest.of(0, 10);
		List<Female> byCreateTimeAfter = femaleRepository.findAllByCreateTimeAfter(yesteday.toDate(), of);
		System.out.println(JSON.toJSONString(byCreateTimeAfter));
	}

	/**
	 * description: 测试范围查询
	 * author: suwenguang
	 * date: 2019-09-01
	 */
	@Test
	public void findByCreateTimeBetween() {
		LocalDate localDate = new LocalDate();
		Page<Female> byCreateTimeBetween = femaleRepository.findByCreateTimeBetween(localDate.minusDays(2).toDate(), localDate.toDate(), PageRequest.of(0, 10));
		System.out.println(JSON.toJSONString(byCreateTimeBetween.getContent()));
	}

	/**
	 * description: 多条件
	 * author: suwenguang
	 * date: 2019-09-01
	 */
	@Test
	public void querydsl() {
		PageRequest of = PageRequest.of(0, 10);
		QFemale female = QFemale.female;
		BooleanExpression createTimeBetween = female.createTime.between(LocalDate.now().minusDays(2).toDate(), LocalDate.now().minusDays(1).toDate());
		BooleanBuilder builder = new BooleanBuilder(createTimeBetween);
		BooleanExpression contains = female.name.contains("3");
		builder.and(contains);
		Page<Female> all = femaleRepository.findAll(builder,of);
		System.out.println(all.getTotalElements());
		System.out.println(JSON.toJSONString(all.getContent()));
	}


}
