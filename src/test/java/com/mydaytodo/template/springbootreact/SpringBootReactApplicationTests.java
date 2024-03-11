package com.mydaytodo.template.springbootreact;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBootReactApplicationTests {

	@Autowired
	private AccountController accountController;
	@Test
	void contextLoads() {
		Assertions.assertNotNull(accountController);
	}

}
