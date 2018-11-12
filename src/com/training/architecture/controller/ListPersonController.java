package com.training.architecture.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.training.architecture.logic.Person;
import com.training.architecture.service.IService;
import com.training.architecture.service.ServiceImpl;

/**
 * Servlet implementation class ListPersonController
 */
@WebServlet("/ListPersonController")
public class ListPersonController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IService service = new ServiceImpl();
   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListPersonController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
        List<Person> pers = service.listAll();
        request.setAttribute("theList", pers);
        request.getRequestDispatcher("/personList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
