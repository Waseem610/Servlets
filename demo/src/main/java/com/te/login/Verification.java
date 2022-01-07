package com.te.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Verification extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter writer = resp.getWriter();
		EntityManagerFactory createEntityManagerFactory = Persistence.createEntityManagerFactory("login");
		EntityManager createEntityManager = createEntityManagerFactory.createEntityManager();
		EntityTransaction transaction = createEntityManager.getTransaction();

		transaction.begin();

		String Query = " select userName from Login where password=:pass";
		javax.persistence.Query createQuery = createEntityManager.createQuery(Query);

		String parameter = req.getParameter("username");
		String parameter1 = req.getParameter("Password");

		createQuery.setParameter("pass", parameter1);

		Object singleResult = null;

		RequestDispatcher requestDispatcher = req.getRequestDispatcher("./invalid");
//		RequestDispatcher requestDispatcher2 = req.getRequestDispatcher("http://localhost:8082/demo/");

		try {
			singleResult = createQuery.getSingleResult();

		} catch (Exception e) {
			writer.println("Invalid Password or Username");
		}
		if (singleResult.equals(parameter)) {

			if (parameter.equals("waseem")) {
//				requestDispatcher2.forward(req, resp);
				resp.sendRedirect("http://localhost:8082/demo/");
			} else {
				resp.sendRedirect("./welcome.html");
			}
		} else {
//			writer.println("Invalid Password");
			requestDispatcher.include(req, resp);
		}

//		createEntityManager.persist(login);
		transaction.commit();

	}
}
