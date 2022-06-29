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
import javax.servlet.http.HttpSession;

import fr.eni.tp.enchere.bo.Utilisateur;
import fr.eni.tp.enchere.dal.jdbc.UtilisateurDAOJdbcImpl;

/**
 * Servlet implementation class servletProfil
 */
@WebServlet("/verifProfil")
public class servletProfil extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("passage dans la servletProfil");
		// Récupère les information de la session
		HttpSession session = request.getSession();
		String pseudoSession = (String) session.getAttribute("pseudo");
		String mdpSession = (String) session.getAttribute("mdp");
		// Créer un nouvel Utilisateur
		Utilisateur profilSession = new Utilisateur();
		// Récupère la List<Utilisateur>
		// Création d'une liste d'utilisateur
		List<Utilisateur> listeUtilisateur = new ArrayList<Utilisateur>();
		// Connexion
		UtilisateurDAOJdbcImpl connexionDB = new UtilisateurDAOJdbcImpl();
		// Génère la liste des utilisateurs
		listeUtilisateur = connexionDB.selectUser();
		// Parcourir la liste des utilisateurs jusqu'à ce que ça corresponde
		for (Utilisateur user : listeUtilisateur) {
			// si le pseudo et le mot de passe correspondent
			if (user.getPseudo().equals(pseudoSession) && user.getMotDePasse().equals(mdpSession)) {
				profilSession = user;
				break;
			}
			// Renvoi les information pour les affichés sur la page profil
			RequestDispatcher rd = request.getRequestDispatcher("/profilUtilisateur");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
