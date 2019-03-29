package com;

import com.controller.ExampleRestController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PruebaTest {

	@Autowired
	ExampleRestController exampleRestController;
	
	@Test
	public void test() {
		//fail("Not yet implemented");
		assertNotNull(exampleRestController);
		assertEquals("hello", exampleRestController.sayHello());
	}

}
