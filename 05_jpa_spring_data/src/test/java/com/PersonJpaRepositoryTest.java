package com;

import com.entities.Person;
import com.jpa.PersonJpaRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class PersonJpaRepositoryTest {

	
	@Autowired
	PersonJpaRepository personRepository;
	
	@Test
	public void injectionTest() {
		assertNotNull(personRepository);
	}
	
	@Test
	public void findByIdTest() {
		Person person = personRepository.findById(555);
		assertNull(person);
	}

	@Test
	public void findByNameTest() {
		Person person = personRepository.findByName("xxx");
		assertNull(person);
	}
	
	
	@Test
	public void insertTest() {
		Person person = personRepository.findById(555);
		assertNull(person);
		person = new Person();
		person.setName("Pepito");
		personRepository.insert(person);
		person = personRepository.findByName("Pepito");
		assertNotNull(person);
	}

	@Test(expected = Exception.class)
	public void updateInsert3() {
		Person person = new Person();
		person.setName("Pepito");
		person.setId(33);
		personRepository.insert(person);
	}
	
	@Test
	public void updateTest() {
		Person person = new Person();
		person.setName("Pepito");
		personRepository.insert(person);
		person = personRepository.findByName("Pepito");
		person.setName("Juanillo");
		personRepository.insert(person);
		assertEquals(4, personRepository.findAll().size());
		assertNull(personRepository.findByName("Pepito"));
		assertNotNull(personRepository.findByName("Juanillo"));
	}
	
	@Test
	public void findAllTest() {
		assertEquals(3, personRepository.findAll().size());
		Person person = new Person();
		person.setName("Pepito");
		personRepository.insert(person);
		person = new Person();
		person.setName("Pepito2");
		personRepository.insert(person);		
		assertEquals(5, personRepository.findAll().size());
	}
	
	
	
	
}
