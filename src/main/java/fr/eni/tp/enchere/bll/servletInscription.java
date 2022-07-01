package fr.eni.tp.enchere.bll;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.tp.enchere.bo.Utilisateur;
import fr.eni.tp.enchere.dal.jdbc.UtilisateurDAOJdbcImpl;

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
		// Utiliser plusieurs fois je l'initialise ici.
		RequestDispatcher rd = null;
		// REGEX pour le pseudo traduction : Vérifie si il ne contient que des
		// caractères Alphanumérique
		String regexPseudo = "^[a-zA-Z0-9]+$";
		// Si le mot de passe et la comfirmation sont identiques
		if (saisieMotDePasse.equals(saisieComfirmation) && Pattern.compile(regexPseudo).matcher(saisiePseudo).find()) {
			Utilisateur utilisateurAjout = new Utilisateur(saisiePseudo, saisieNom, saisiePrenom, saisieEmail,
					saisieTelephone, saisieRue, saisieCodePostal, saisieVille, saisieMotDePasse, 0, false);

			// Création d'une liste d'utilisateur
			List<Utilisateur> listeUtilisateur = new ArrayList<Utilisateur>();
			// Connexion
			UtilisateurDAOJdbcImpl connexionDB = new UtilisateurDAOJdbcImpl();
			// Génère la liste des utilisateurs
			listeUtilisateur = connexionDB.selectUser();
			// Parcourir la liste des utilisateurs jusqu'à ce que ça corresponde
			boolean utilisateurTrouve = false;
			for (Utilisateur user : listeUtilisateur) {
				// si le pseudo et le mot de passe correspondent
				if (user.getPseudo().equals(saisiePseudo) || user.getEmail().equals(saisieEmail)) {
					// Si l'email ou le pseudo correspondent, l'utilisateur passe à trouvé "vrai"
					utilisateurTrouve = true;
					rd = request.getRequestDispatcher("/inscription");
					break;
				}
			}
			// Si il n'y a pas eu de correspondance
			if (!utilisateurTrouve) {
				// Ajout de l'utilisateur au niveau DAL
				connexionDB.insert(utilisateurAjout);
				// Récupération des information pour initialiser la session
				HttpSession session = request.getSession();

				session.setAttribute("pseudo", saisiePseudo);
				session.setAttribute("mdp", saisieMotDePasse);

				// La personne inscrite est dirigée sur son profil utilisateur.
				rd = request.getRequestDispatcher("/profilUtilisateur");
			}

		} else {
			rd = request.getRequestDispatcher("/inscription");
		}
		rd.forward(request, response);
	}

}
