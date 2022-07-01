package fr.eni.tp.enchere.bll;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.tp.enchere.bo.Article;
import fr.eni.tp.enchere.dal.jdbc.ArticleVenduDAOJdbcImpl;

/**
 * Servlet implementation class servletAccueil
 */
@WebServlet("/servAccueil")
public class servletAccueil extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Article> enchere = new ArrayList<Article>();

		ArticleVenduDAOJdbcImpl connexionDAL = new ArticleVenduDAOJdbcImpl();

		enchere = connexionDAL.selectAllArticles();

		request.setAttribute("listeEnchere", enchere);

		RequestDispatcher rd = request.getRequestDispatcher("/accueil");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
