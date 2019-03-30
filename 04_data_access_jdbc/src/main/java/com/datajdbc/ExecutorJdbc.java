package com.datajdbc;

import com.datajdbc.jdbc.PersonJdbcDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ExecutorJdbc implements CommandLineRunner {

	@Autowired
	PersonJdbcDAO personJdbcDAO;

	@Override
	public void run(String... args) {
		System.out.println("*Testing:");
		System.out.println(personJdbcDAO.findAll());
	}
}
