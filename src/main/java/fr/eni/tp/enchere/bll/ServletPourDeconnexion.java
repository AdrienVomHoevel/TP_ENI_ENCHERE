package fr.eni.tp.enchere.bll;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ServletPourDeconnexion extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		HttpSession session = request.getSession(); 
		session.invalidate();
		
		System.out.println("Session invalidée");
		request.getRequestDispatcher("/accueil").forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(); 
		session.invalidate();
		
		System.out.println("Session invalidée");
		request.getRequestDispatcher("/accueil").forward(request, response);
	}

}
