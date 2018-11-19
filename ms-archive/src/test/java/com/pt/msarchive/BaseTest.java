package com.pt.msarchive;

import org.junit.After;
import org.junit.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseTest {
	
	private static final Logger log = LoggerFactory.getLogger(BaseTest.class);

	@Before
	public void before() {
		log.info("---------------------测试开始---------------------");
	}
	@After
	public void after() {
		log.info("---------------------测试结束---------------------");
	}
}
