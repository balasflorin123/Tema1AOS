package com.facultate.aos.view;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.facultate.aos.entities.PersonEntity;
import com.facultate.aos.impl.PersonImpl;


public class PersonView extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5093822362487997465L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String name = request.getParameter("name");
		String email = request.getParameter("email");

		PersonEntity person = new PersonEntity();
		person.setName(name);
		person.setEmail(email);

		PersonImpl repo = new PersonImpl("tema1");

		person = repo.createOrUpdate(person);		

		response.getWriter().write("<html>" + "<body>" + "Id: " + person.getId() + "<br>"
		+ "Name: " + person.getName() +"<br>"+ "Email: "+ person.getEmail() +	"</body>" + "</html>");
		response.getWriter().flush();
	}

	// Method to handle POST method request.
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	
}