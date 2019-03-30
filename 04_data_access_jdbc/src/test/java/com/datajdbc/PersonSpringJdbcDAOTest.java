package com.datajdbc;

import com.datajdbc.entity.Person;
import com.datajdbc.jdbctemplate.PersonSpringJdbcDAO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonSpringJdbcDAOTest {

	
	@Autowired
	PersonSpringJdbcDAO personSpringJdbcDAO;
	
	@Test
	public void injectionTest() {
		assertNotNull(personSpringJdbcDAO);
	}
	
	@Test
	public void testFindAll() {
		assertNotNull(personSpringJdbcDAO.findAll());
		assertEquals(3, personSpringJdbcDAO.findAll().size());
	}
	
	@Test
	public void testFindByIdExisting() {
		Person person = personSpringJdbcDAO.findById(10001);
		assertNotNull("Pepe", person.getName());
	}

	//@Test(expected = Exception.class)
	@Test
	public void testFindByIdNotExisting() {
		Person person = personSpringJdbcDAO.findById(666);
		assertNull(person);
	}
	
	@Test
	public void deleteTest() {
		Person person = personSpringJdbcDAO.findById(10001);
		assertNotNull(person);
		personSpringJdbcDAO.delete(10001);
		person = personSpringJdbcDAO.findById(10001);
		assertNull(person);
	}
	
	@Test
	public void updateTest() {
		Person person = personSpringJdbcDAO.findById(10001);
		assertEquals("Pepe", person.getName());
		person.setName("Juan");
		personSpringJdbcDAO.update(person);
		person = personSpringJdbcDAO.findById(10001);
		assertEquals("Juan", person.getName());
		
	}	
	
}
