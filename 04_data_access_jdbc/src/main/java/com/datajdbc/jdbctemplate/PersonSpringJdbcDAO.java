package com.datajdbc.jdbctemplate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.datajdbc.entity.Person;

@Repository
public class PersonSpringJdbcDAO {

	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<Person> findAll() {
		return jdbcTemplate.query("select * from person", new BeanPropertyRowMapper<>(Person.class));
	}
	
	public Person findById(int id) {
		try {
			return jdbcTemplate.queryForObject("select * from person where id=?", new Object[] {id}, 
					new BeanPropertyRowMapper<>(Person.class));
		} catch (Exception e) {
			return null;
		}
	}
	
	public int delete(int id) {
		return jdbcTemplate.update("delete from person where id=?", new Object[]{id});
	}
	
	public int update(Person person) {
		return jdbcTemplate.update("update person set name=? where id=?", person.getName(), person.getId());
	}
}
