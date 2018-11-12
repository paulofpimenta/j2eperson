package com.training.architecture.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.training.architecture.logic.Person;
import com.training.architecture.service.IService;
import com.training.architecture.service.ServiceImpl;


/**
 * Servlet implementation class PersonController
 */
@WebServlet("/PersonController")
public class PersonController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	IService service = new ServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PersonController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		// retrieve params
		
		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
		int age = Integer.parseInt(request.getParameter("age"));
		
		
		// call service layer (model)
		Person p = new Person();
		p.setName(name);
		p.setSurname(surname);
		p.setAge(age);
		
		System.out.println("\nObject params inside  'doPost'" + " name : " + p.getName() + "surname: " + p.getSurname() + "age : " + p.getAge());
		service.addPerson(p);
		
		// call view
        response.sendRedirect(request.getContextPath() + "/ListPersonController");

	}

}
