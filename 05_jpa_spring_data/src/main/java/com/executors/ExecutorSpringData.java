package com.executors;

import com.entities.Person;
import com.springdata.PersonSpringDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ExecutorSpringData implements CommandLineRunner {

	@Autowired
	PersonSpringDataRepository personSpringDataRepository;

	@Override
	public void run(String... args) {
		System.out.println("Testing Spring Data: ");
		for (Person person : personSpringDataRepository.findAll()) {
			System.out.println("Person: " + person);
		}
	}
}
