package fr.eni.tp.enchere.bll;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.tp.enchere.bo.Article;
import fr.eni.tp.enchere.bo.Categorie;
import fr.eni.tp.enchere.bo.Utilisateur;
import fr.eni.tp.enchere.dal.jdbc.ArticleVenduDAOJdbcImpl;
import fr.eni.tp.enchere.dal.jdbc.CategorieDAOJdbcImpl;
import fr.eni.tp.enchere.dal.jdbc.UtilisateurDAOJdbcImpl;

public class servletNouvelleVente extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Récupère les information de la session
		HttpSession session = request.getSession();
		String pseudoSession = (String) session.getAttribute("pseudo");
		String mdpSession = (String) session.getAttribute("mdp");

		// Création d'une liste d'utilisateur
		List<Utilisateur> listeUtilisateur = new ArrayList<Utilisateur>();
		// Connexion à la DAL
		UtilisateurDAOJdbcImpl connexionDB = new UtilisateurDAOJdbcImpl();
		// Récupération des catégories
		CategorieDAOJdbcImpl recupCategorie = new CategorieDAOJdbcImpl();
		List<Categorie> listeCategorie = recupCategorie.selectAllCategories();
		// Envoi des informations
		request.setAttribute("listeCat", listeCategorie);
		// Génère la liste des utilisateurs
		listeUtilisateur = connexionDB.selectUser();
		// Parcourir la liste des utilisateurs jusqu'à ce que ça corresponde
		for (Utilisateur user : listeUtilisateur) {
			// si le pseudo et le mot de passe correspondent
			if (user.getPseudo().equals(pseudoSession) && user.getMotDePasse().equals(mdpSession)) {
				request.setAttribute("rue", user.getRue());
				request.setAttribute("codePostal", user.getCodePostal());
				request.setAttribute("ville", user.getVille());
			}
		}

		RequestDispatcher rd = request.getRequestDispatcher("/nouvelle_vente");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Appel de la session pour récupérer le vendeur.
		HttpSession session = request.getSession();
		String pseudoSession = (String) session.getAttribute("pseudo");
		String mdpSession = (String) session.getAttribute("mdp");
		// Récupération du pseudo
		Utilisateur vendeur = new Utilisateur();
		// Création d'une liste d'utilisateur
		List<Utilisateur> listeUtilisateur = new ArrayList<Utilisateur>();
		// Connexion à la DAL
		UtilisateurDAOJdbcImpl connexionDB = new UtilisateurDAOJdbcImpl();
		// Génère la liste des utilisateurs
		listeUtilisateur = connexionDB.selectUser();
		// Parcourir la liste des utilisateurs jusqu'à ce que ça corresponde
		for (Utilisateur user : listeUtilisateur) {
			// si le pseudo et le mot de passe correspondent
			if (user.getPseudo().equals(pseudoSession) && user.getMotDePasse().equals(mdpSession)) {
				vendeur = user;
			}
		}

		String nomArticle = request.getParameter("nomArticle");
		String description = request.getParameter("description");
		String categories = request.getParameter("categories");
		// ********** Traiter les phtotos plus tard.
//		String photoArticle = request.getParameter("photoArticle");
		String miseaprix = request.getParameter("PrixdeMise");
		int newmiseaprix = Integer.parseInt(miseaprix);
		String datedebutenchere = request.getParameter("datedebutenchere");
		LocalDate dateDebutparse = LocalDate.parse(datedebutenchere);
		String datefinenchere = request.getParameter("datefinenchere");
		LocalDate dateFinparse = LocalDate.parse(datefinenchere);
		String rueRetrait = request.getParameter("rueRetrait");
		String codepostal = request.getParameter("codepostal");
		String ville = request.getParameter("ville");

		Article nouvelArticle = new Article(nomArticle, description, dateDebutparse, dateFinparse, newmiseaprix,
				vendeur, categories, rueRetrait, codepostal, ville);
		ArticleVenduDAOJdbcImpl mettreEnVente = new ArticleVenduDAOJdbcImpl();

		mettreEnVente.insertArticleVendu(nouvelArticle);

		RequestDispatcher rd = request.getRequestDispatcher("/detailVente");
		rd.forward(request, response);
	}

}
