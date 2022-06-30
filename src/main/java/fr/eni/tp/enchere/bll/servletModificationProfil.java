package fr.eni.tp.enchere.bll;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.tp.enchere.bo.Utilisateur;
import fr.eni.tp.enchere.dal.jdbc.UtilisateurDAOJdbcImpl;

@WebServlet("/servUpdate")
public class servletModificationProfil extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Permet de modifier les informations Utilisateur.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Récupération des informations
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

		// Récupère les information de la session
		HttpSession session = request.getSession();
		String pseudoSession = (String) session.getAttribute("pseudo");
		String mdpSession = (String) session.getAttribute("mdp");

		// Création d'une liste d'utilisateur
		List<Utilisateur> listeUtilisateur = new ArrayList<Utilisateur>();
		// initialisation de l'utilisateur en cour
		Utilisateur profilAModifier = new Utilisateur();
		// Connexion
		UtilisateurDAOJdbcImpl connexionDB = new UtilisateurDAOJdbcImpl();
		// Génère la liste des utilisateurs
		listeUtilisateur = connexionDB.selectUser();
		// Parcourir la liste des utilisateurs jusqu'à ce que ça corresponde
		for (Utilisateur user : listeUtilisateur) {
			// si le pseudo et le mot de passe correspondent
			if (user.getPseudo().equals(pseudoSession) && user.getMotDePasse().equals(mdpSession)) {
				profilAModifier = user;
			}
			// Vérification des informations et modification à effectué.
			if (saisiePseudo != null && saisiePseudo != "") {
				profilAModifier.setPseudo(saisiePseudo);
			}
			if (saisieNom != null && saisieNom != "") {
				profilAModifier.setNom(saisieNom);
			}
			if (saisiePrenom != null && saisiePrenom != "") {
				profilAModifier.setPrenom(saisiePrenom);
			}
			if (saisieEmail != null && saisieEmail != "") {
				profilAModifier.setEmail(saisieEmail);
			}
			if (saisieTelephone != null && saisieTelephone != "") {
				profilAModifier.setTelephone(saisieTelephone);
			}
			if (saisieRue != null && saisieRue != "") {
				profilAModifier.setRue(saisieRue);
			}
			if (saisieCodePostal != null && saisieCodePostal != "") {
				profilAModifier.setCodePostal(saisieCodePostal);
			}
			if (saisieVille != null && saisieVille != "") {
				profilAModifier.setVille(saisieVille);
			}
			if (saisieMotDePasse != null && saisieMotDePasse.equals(saisieComfirmation) && saisieMotDePasse != "") {
				profilAModifier.setMotDePasse(saisieMotDePasse);
			}
		}

		// Renvoi de la modification dans la BDD
		connexionDB.update(profilAModifier);

		// Renvoi vers le profil avec les modifications faites.
		getServletContext().getRequestDispatcher("/verifProfil").forward(request, response);

	}

}
