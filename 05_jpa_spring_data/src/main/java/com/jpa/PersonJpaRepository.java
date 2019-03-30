package com.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import com.entities.Person;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class PersonJpaRepository {

	@PersistenceContext
	EntityManager entityManager;
	
	
	public Person findById(int id) {
		return entityManager.find(Person.class, id);
	}

	public List<Person> findAll() {
		TypedQuery<Person> typedQuery = entityManager.createNamedQuery("find_all_persons", Person.class);
		return typedQuery.getResultList();
		
	}
	
	public List<Person> findAllAux() {
		Query query = entityManager.createQuery("select c from Person c");
		return query.getResultList();
	}

	public Person findByName(String name) {
		Query query = entityManager.createQuery("select c from Person c where c.name = :name");
		query.setParameter("name", name);
		List<Person> resultList = query.getResultList();
		return resultList.size()>=1?resultList.get(0):null;
	}

	public void insert(Person person) {
		entityManager.persist(person);
	}
}