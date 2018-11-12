package com.training.architecture.service;

import java.util.List;

import com.training.architecture.logic.Person;

public interface IService {
	
	public int addPerson(Person p);
	
	public List<Person> listAll();
}
