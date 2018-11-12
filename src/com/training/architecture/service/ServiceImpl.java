package com.training.architecture.service;

import java.util.List;

import com.training.architecture.dao.DaoImpl;
import com.training.architecture.dao.IDao;
import com.training.architecture.logic.Person;

public class ServiceImpl implements IService {
	
	private IDao dao = new DaoImpl();
	
	
	@Override
	public int addPerson(Person p) {
		// TODO Auto-generated method stub
		//return 0;
		return dao.addPerson(p);
	}


	@Override
	public List<Person> listAll() {
		// TODO Auto-generated method stub
		return dao.listAll();
	}




}
