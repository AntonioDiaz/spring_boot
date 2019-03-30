package com.executors;

import com.entities.Person;
import com.jpa.PersonJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ExecutorJpa implements CommandLineRunner {

	@Autowired
	PersonJpaRepository personJpaRepository;

	@Override
	public void run(String... args) {
		System.out.println("Testing JPA: \n\t All persons: ");
		for (Person person : personJpaRepository.findAll()) {
			System.out.println("Person: " + person);
		}
	}
}
