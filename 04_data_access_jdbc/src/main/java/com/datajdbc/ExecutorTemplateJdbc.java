package com.datajdbc;

import com.datajdbc.entity.Person;
import com.datajdbc.jdbc.PersonJdbcDAO;
import com.datajdbc.jdbctemplate.PersonSpringJdbcDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ExecutorTemplateJdbc implements CommandLineRunner {

	@Autowired
	PersonSpringJdbcDAO personSpringJdbcDAO;

	@Override
	public void run(String... args) {
		System.out.println("*Testing JdbcTemplate:");
		System.out.println("Before delete: " + personSpringJdbcDAO.findAll());
		//Person person = personSpringJdbcDAO.findById(10002);
		//System.out.println("Delete entity: " + personSpringJdbcDAO.delete(person.getId()));
		System.out.println("After delete: " + personSpringJdbcDAO.findAll());
		//personSpringJdbcDAO.
	}
}
