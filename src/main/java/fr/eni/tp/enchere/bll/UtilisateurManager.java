package fr.eni.tp.enchere.bll;

import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

import fr.eni.tp.enchere.bo.Utilisateur;
import fr.eni.tp.enchere.dal.jdbc.UtilisateurDAOJdbcImpl;

public class UtilisateurManager {
	
	private static UtilisateurManager INSTANCE = null;
	
	private UtilisateurDAOJdbcImpl utilisateurDAO;
	
	public UtilisateurManager() {
		
		this.utilisateurDAO = new UtilisateurDAOJdbcImpl();
		
	}
	
	public static synchronized UtilisateurManager getInstance() {
		
		if(INSTANCE == null) {
			INSTANCE = new UtilisateurManager();
		}
		
		return INSTANCE;
	}// Eo getInstance()
	
	
	/**
	 * Retourne un Utilisateur en fonction de l'ID entre en parametre.
	 * @param id
	 * @return Utilisateur
	 */
	public Utilisateur getUtilisateurById(int id) {
		
		System.out.println("getUtilisateurById() -> " + id);		
		Utilisateur utilisateurToReturn = null;
		
		ArrayList<Utilisateur> userList = (ArrayList<Utilisateur>) utilisateurDAO.selectUser();
		
		for (Utilisateur user : userList) {

			if (user.getNoUtilisateur() == id) {

				utilisateurToReturn = user;
				
				break;

			}
		}
		
		return utilisateurToReturn;
		
	}
	
	
	/**
	 * Retourne l'Utilisateur dont l'identifiant et le mot de passe correspondent aux paramètres saisis.
	 * @param saisieIdentifiant
	 * @param saisieMotDePasse
	 * @return Utilisateur
	 */
	public Utilisateur getUtilisateurByLoginData(String saisieIdentifiant, String saisieMotDePasse) {
		
		Utilisateur utilisateurToReturn = null;
		
		ArrayList<Utilisateur> userList = (ArrayList<Utilisateur>) utilisateurDAO.selectUser();
		
		for (Utilisateur user : userList) {
			// si le pseudo et le mot de passe correspondent
			if (user.getPseudo().equals(saisieIdentifiant) && user.getMotDePasse().equals(saisieMotDePasse)) {

				utilisateurToReturn = user;
				
				break;

			}
		}
		
		return utilisateurToReturn;
		
	}

}


