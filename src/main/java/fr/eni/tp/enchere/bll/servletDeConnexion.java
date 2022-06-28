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

import fr.eni.tp.enchere.bo.Utilisateur;
import fr.eni.tp.enchere.dal.jdbc.UtilisateurDAOJdbcImpl;

@WebServlet("/connexionSession")
public class servletDeConnexion extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Lire les informations
		String saisieIdentifiant = null;
		String saisieMotDePasse = null;

		saisieIdentifiant = request.getParameter("saisieIdentifiant");
		saisieMotDePasse = request.getParameter("saisieMotDePasse");

		// TODO Vérification de l'utilisateur sur la BDD et récupération de ses
		// informations.
		// Création d'une liste d'utilisateur
		List<Utilisateur> listeUtilisateur = new ArrayList<Utilisateur>();
		// Connexion
		UtilisateurDAOJdbcImpl connexionDB = new UtilisateurDAOJdbcImpl();
		// Faire la liste d'utilisateurs avec ce que contient la BDD
		listeUtilisateur = connexionDB.selectUser();
		// Parcourir la liste des utilisateurs jusqu'à ce que ça corresponde
		for (Utilisateur user : listeUtilisateur) {
			do {

			} while (!user.getPseudo().equals(saisieIdentifiant) && !user.getMotDePasse().equals(saisieMotDePasse));
		}
		// TODO Utiliser un cookie pour le se souvenir checkbox
		// TODO savoir que la session est en mode connecté

		// Si tout s'est bien passé, afficher l'accueil en mode connecté
		RequestDispatcher rd = request.getRequestDispatcher("/accueil");
		rd.forward(request, response);
	}

}
