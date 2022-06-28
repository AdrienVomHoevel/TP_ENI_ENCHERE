package fr.eni.tp.enchere.bll;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.tp.enchere.bo.Article;

public class servletNouvelleVente extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nomArticle = request.getParameter("nomArticle");
		String description = request.getParameter("description");
		String categories = request.getParameter("categories");
		String photoArticle = request.getParameter("photoArticle");
		String miseaprix = request.getParameter("PrixdeMise");
		int newmiseaprix = Integer.parseInt(miseaprix);
		String datedebutenchere = request.getParameter("datedebutenchere");
		LocalDate dateDebutparsé = LocalDate.parse(datedebutenchere);
		String datefinenchere = request.getParameter("datefinenchere");
		LocalDate dateFinparsé = LocalDate.parse(datefinenchere);
		String rueRetrait = request.getParameter("rueRetrait");
		String codepostal = request.getParameter("codepostal");
		String ville = request.getParameter("ville");

		Article nouvelArticle = new Article(1, nomArticle, description, dateDebutparsé, dateFinparsé, newmiseaprix, 40000, "Vendu");
		
		
		System.out.println(nouvelArticle);

		
		
		
		
		

	}

}
