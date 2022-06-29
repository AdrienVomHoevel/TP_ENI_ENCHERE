package fr.eni.tp.enchere.bll;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.tp.enchere.bo.Utilisateur;
import fr.eni.tp.enchere.dal.jdbc.UtilisateurDAOJdbcImpl;

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

		// Etablir la connexion
		UtilisateurDAOJdbcImpl connexionDB = new UtilisateurDAOJdbcImpl();

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

		// Si le mot de passe et la comfirmation sont identiques
		if (saisieMotDePasse.equals(saisieComfirmation)) {
			Utilisateur utilisateurAjout = new Utilisateur(saisiePseudo, saisieNom, saisiePrenom, saisieEmail,
					saisieTelephone, saisieRue, saisieCodePostal, saisieVille, saisieMotDePasse, 0, false);

			connexionDB.insert(utilisateurAjout);
			// La personne inscrite est dirigée sur son profil utilisateur.
			RequestDispatcher rd = request.getRequestDispatcher("/profilUtilisateur");
			rd.forward(request, response);
		} else {
			// TODO retourner sur la création du profil en indiquant l'erreur au niveau du
			// MDP
			// manquant/erronés.
		}

	}

}
