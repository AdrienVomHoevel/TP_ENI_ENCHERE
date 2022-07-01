package fr.eni.tp.enchere.bll;

import java.util.ArrayList;

import fr.eni.tp.enchere.bo.Article;
import fr.eni.tp.enchere.bo.Enchere;
import fr.eni.tp.enchere.bo.Utilisateur;
import fr.eni.tp.enchere.dal.jdbc.EnchereDAOJdbcImpl;

public class EnchereManager {
	
	private static EnchereManager INSTANCE = null;
	
	private EnchereDAOJdbcImpl enchereDAO;
	
	public EnchereManager() {
		
		this.enchereDAO = new EnchereDAOJdbcImpl();
		
	}
	
	public static synchronized EnchereManager getInstance() {
		
		if(INSTANCE == null) {
			INSTANCE = new EnchereManager();
		}
		
		return INSTANCE;
	}// Eo getInstance()
	
	public boolean encherir(Utilisateur encherisseur, Article article, int montant) {
		
		boolean isOk = false;

		// Montant enchere soumise superieur montant enchere actuelle ?
		if (montant > enchereDAO.selectHighestEnchere(article.getNoArticle())) {
			
			// Enchere existe ? OUI -> update, NON -> Insert
			if (enchereDAO.selectEnchereByArticleAndUser(encherisseur.getNoUtilisateur(), article.getNoArticle())) {
				
				Enchere enchere = new Enchere(encherisseur, montant);
				
				enchereDAO.updateEnchere(article.getNoArticle(), enchere);
				
//				article.getEncheres().add(enchere);
				
				isOk = true;
				
			} else {
				
				Enchere enchere = new Enchere(encherisseur, montant);
				
				enchereDAO.insertEnchere(article.getNoArticle(), enchere);
				
//				article.getEncheres().add(enchere);
				
				isOk = true;
			
			} 
			
		}// Eo first if 
		
		return isOk;
		
	}
	
	/**
	 * Retourne les encheres d'un article.
	 * @param noArticle
	 * @return ArrayList<Enchere>
	 */
	public ArrayList<Enchere> getArticlesEncheres(int noArticle) {
		
		return enchereDAO.selectAllEnchereOfArticle(noArticle);
		
	}
	
	/**
	 * Retourne une instance d'Enchere.
	 * @param encherisseur
	 * @param montant
	 * @return Enchere
	 */
	private Enchere newEnchere(Utilisateur encherisseur, int montant) {
		
		return new Enchere(encherisseur, montant);
		
	}
	
	

}
