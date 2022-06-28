package fr.eni.tp.enchere.bll;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/connexionSession")
public class servletDeConnexion extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Lire les informations
		String saisieIdentifiant = null;
		String saisieMotDePasse = null;

		saisieIdentifiant = request.getParameter("saisieIdentifiant");
		saisieMotDePasse = request.getParameter("saisieMotDePasse");

		System.out.println(saisieIdentifiant);
		System.out.println(saisieMotDePasse);
		// TODO Vérification de l'utilisateur sur la BDD et récupération de ses
		// informations.
		// TODO Utiliser un cookie pour le se souvenir checkbox
		// TODO savoir que la session est en mode connecté

		// Si tout s'est bien passé, afficher l'accueil en mode connecté
		RequestDispatcher rd = request.getRequestDispatcher("/accueil");
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
