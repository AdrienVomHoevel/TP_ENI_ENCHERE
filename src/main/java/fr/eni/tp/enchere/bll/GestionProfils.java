package fr.eni.tp.enchere.bll;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.tp.enchere.bo.Utilisateur;
import fr.eni.tp.enchere.dal.jdbc.UtilisateurDAOJdbcImpl;

@WebServlet("/gestionProfils")
public class GestionProfils extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/************ Simulation DAL de L'insert utilisateur ******************/
		/*
		 * // Simulation de test pour la DAL Utilisateur ajoutTest = new Utilisateur(0,
		 * "Jeannnot", "Nono", "Jean", "Jno@gmail.fr", "0678904567", "Amiral Durant",
		 * "56780", "Saint-Jean", "mdpDeNon0", 500, false); // Appel de la DAL
		 * UtilisateurDAOJdbcImpl connexionDB = new UtilisateurDAOJdbcImpl(); // Ajout
		 * de l'utilisateur connexionDB.insert(ajoutTest);
		 * System.out.println("test de la conexion à la DAL" + ajoutTest.toString());
		 */

		/***********
		 * Simulation DAL pour récupérer une Liste d'utilisateurs
		 ************/
		/*
		 * // Création d'une liste d'utilisateur List<Utilisateur> listeUtilisateur =
		 * new ArrayList<Utilisateur>(); // Connexion UtilisateurDAOJdbcImpl connexionDB
		 * = new UtilisateurDAOJdbcImpl(); // Faire la liste d'utilisateurs avec ce que
		 * contient la BDD listeUtilisateur = connexionDB.selectUser();
		 * System.out.println(listeUtilisateur.toString());
		 */
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
