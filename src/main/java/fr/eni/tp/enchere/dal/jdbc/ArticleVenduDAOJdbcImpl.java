package fr.eni.tp.enchere.dal.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import fr.eni.tp.enchere.bo.Article;

public class ArticleVenduDAOJdbcImpl {
	
	RetraitDAOJdbcIImpl retraitDAO = new RetraitDAOJdbcIImpl();
	
	private final static String REQ_INSERT_ARTICLE_VENDU 
	= "INSERT ARTICLES_VENDUS(nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, no_utilisateur, no_categorie) VALUES (?,?,?,?,?,?,?)"; 

	
	/**
	 * Insere un article en BDD. 
	 * !! WARNING !! 
	 * Provoque une erreur si le no_utilisateur de 
	 * l'utilisateur n'est pas un numero existant en BDD dans la table UTILISATEUR.
	 * @param article
	 */
	public void insertArticleVendu(Article article) {
		
		try(Connection cnx = ConnectionProvider.getConnection()){
			
			PreparedStatement ordre = cnx.prepareStatement(REQ_INSERT_ARTICLE_VENDU, Statement.RETURN_GENERATED_KEYS);
			
			ordre.setString(1, article.getNomArticle());
			ordre.setString(2, article.getDescription());
			ordre.setDate(3, Date.valueOf(article.getDateDebutEncheres()));
			ordre.setDate(4, Date.valueOf(article.getDateFinEncheres()));
			ordre.setInt(5, article.getPrixVente());
			ordre.setInt(6, article.getVendeur().getNoUtilisateur());
			ordre.setInt(7, article.getCategorie().getNoCategorie());
						
			ordre.executeUpdate();
			
			//Insert le Retrait correspondant à l'article
			
//			ResultSet rs = ordre.getGeneratedKeys();
//			
//			if (rs.next()) 
//			{
//				int newId = rs.getInt(1);
//				
//				article.setNoArticle(newId);
//
//			}		
			
		} catch (SQLException e) {
			System.err.println("Erreur lors de l'éxécution de insertArticleVendu()");
			e.printStackTrace();
		}
	
	}// Eo insertArticleVendu()
}
