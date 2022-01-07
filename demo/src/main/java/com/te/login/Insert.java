package com.te.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Insert extends HttpServlet {
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String parameter = req.getParameter("user");
		String parameter1 = req.getParameter("password");
		Login login = new Login();
		PrintWriter writer = resp.getWriter();
		login.setUserName(parameter);
		login.setPassword(parameter1);
		EntityManagerFactory createEntityManagerFactory = Persistence.createEntityManagerFactory("login");
		EntityManager createEntityManager = createEntityManagerFactory.createEntityManager();
		EntityTransaction transaction = createEntityManager.getTransaction();
		transaction.begin();
		
		createEntityManager.persist(login);
		
		try {
			transaction.commit();
			writer.println("Data added succesfully");
		} catch (Exception e) {
			writer.println("Data Already Exists");
		}

	}

}
