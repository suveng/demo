package com.qw.campus.modules.recruit.dao;

import com.alibaba.fastjson.JSON;
import com.qw.campus.modules.BaseTest;
import my.suveng.campus.modules.recruit.dao.ApplicantRepository;
import my.suveng.campus.modules.recruit.model.Applicant;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * description:
 * @author suwenguang
 * @date 2019-08-24
 * @version 1.0.0
 **/
public class ApplicantRepositoryTest extends BaseTest {
	@Autowired
	ApplicantRepository applicantRepository;

	@Test
	public void save() {
		Applicant s = new Applicant();
		s.setPhone("18320664028");
		s.setQq("123");
		applicantRepository.save(s);
	}

	@Test
	public void saveMore() {
		Applicant s = new Applicant();
		s.setPhone("18320664028");
		s.setQq("123");
		s.setEmail("suveng@13.com");
		applicantRepository.save(s);
	}

	@Test
	public void get() {
		List<Applicant> all = applicantRepository.findAll();
		System.out.println(JSON.toJSONString(all));
	}
}
