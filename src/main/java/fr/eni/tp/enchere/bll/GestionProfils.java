package fr.eni.tp.enchere.bll;

import java.io.IOException;
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
		// Simulation de test pour la DAL
		Utilisateur ajoutTest = new Utilisateur(0, "Jeannnot", "Nono", "Jean", "Jno@gmail.fr", "0678904567",
				"Amiral Durant", "56780", "Saint-Jean", "mdpDeNon0", 500, false);
		// Appel de la DAL
		UtilisateurDAOJdbcImpl connexionDB = new UtilisateurDAOJdbcImpl();
		// Ajout de l'utilisateur
		connexionDB.insert(ajoutTest);
		System.out.println("test de la conexion à la DAL" + ajoutTest.toString());

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
