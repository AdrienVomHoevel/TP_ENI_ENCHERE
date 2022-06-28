package fr.eni.tp.enchere.bll;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ServletRechercher", urlPatterns = { "/rechRapide" })
public class servletRechercher extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Lire les informations
		String choixCategorie = null;
		String rechercheUtilisateur = null;

		// Lecture du choix. (Fonctionnel !)
		choixCategorie = request.getParameter("categories");
		rechercheUtilisateur = request.getParameter("saisieUtilisateur");
		System.out.println(rechercheUtilisateur);

		// Si tout s'est bien passé, afficher le resultat de la recherche
		RequestDispatcher rd = request.getRequestDispatcher("/accueil");
		rd.forward(request, response);
	}

}
