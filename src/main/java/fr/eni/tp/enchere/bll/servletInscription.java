package fr.eni.tp.enchere.bll;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class servletInscription
 */
@WebServlet("/servLog")
public class servletInscription extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Lire les informations
		String saisiePseudo = null;
		String saisieNom = null;
		String saisiePrenom = null;
		String saisieEmail = null;
		String saisieTelephone = null;
		String saisieRue = null;
		String saisieCodePostal = null;
		String saisieVille = null;
		String saisieMotDePasse = null;
		String saisieComfirmation = null;

		saisiePseudo = request.getParameter("saisiePseudo");
		saisieNom = request.getParameter("saisieNom");
		saisiePrenom = request.getParameter("saisiePrenom");
		saisieEmail = request.getParameter("saisieEmail");
		saisieTelephone = request.getParameter("saisieTelephone");
		saisieRue = request.getParameter("saisieRue");
		saisieCodePostal = request.getParameter("saisieCodePostal");
		saisieVille = request.getParameter("saisieVille");
		saisieMotDePasse = request.getParameter("saisieMotDePasse");
		saisieComfirmation = request.getParameter("saisieComfirmation");

		// TODO Faire un retour sur le visuel du profil
		// Si tout s'est bien passé, afficher le resultat de la recherche
		RequestDispatcher rd = request.getRequestDispatcher("/accueil");
		rd.forward(request, response);

	}

}
