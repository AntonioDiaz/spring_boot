package com.springdata;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entities.Person;

@Repository
public interface PersonSpringDataRepository extends JpaRepository<Person, Integer> { }
