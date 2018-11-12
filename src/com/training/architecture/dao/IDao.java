package com.training.architecture.dao;

import java.sql.Connection;
import java.util.List;

import com.training.architecture.logic.Person;

public interface IDao {

	public int addPerson(Person p);
	public int removePerson(Person p);
	public Person getPerson(Person p);
	public List<Person> listAll();
	Connection connectDB();
}
