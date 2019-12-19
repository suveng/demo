package my.suveng.demo.springboot.junit.controller;

import my.suveng.demo.springboot.junit.ApplicationTests;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author suwenguang
 **/
class TestControllerTest extends ApplicationTests {

	@Autowired
	private TestController testController;

	@BeforeEach
	void setUp() {
	}

	@AfterEach
	void tearDown() {
	}

	@Test
	void hello() {
		String hello = testController.hello();
		System.out.println(hello);
	}
}
