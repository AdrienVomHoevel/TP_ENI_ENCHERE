package fr.eni.tp.enchere.dal.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import fr.eni.tp.enchere.bo.Article;
import fr.eni.tp.enchere.bo.Enchere;

public class EnchereDAOJdbcImpl {
	
	private final static String REQ_INSERT_ENCHERE
	= "INSERT ENCHERES(no_utilisateur, no_article, date_enchere, montant_enchere) VALUES (?,?,?,?)";

	
	public void insertEnchere(int noArticle, Enchere enchere) {
		
		try(Connection cnx = ConnectionProvider.getConnection()){
			
			try {
				
				cnx.setAutoCommit(false);
				
				PreparedStatement ordre = cnx.prepareStatement(REQ_INSERT_ENCHERE, Statement.RETURN_GENERATED_KEYS);
				
				ordre.setInt(1, enchere.getEncherisseur().getNoUtilisateur());
				ordre.setInt(2, noArticle);
				ordre.setDate(3, Date.valueOf(enchere.getDateEnchere()));
				ordre.setInt(4, enchere.getMontant_enchere());
							
				ordre.executeUpdate();
				
				cnx.commit();
				
			} catch (SQLException e) {
				
				cnx.rollback();
				
				System.err.println("Erreur lors de la transaction dans insertArticleVendu()");
				e.printStackTrace();
				
			}

		} catch (SQLException e) {

			System.err.println("Erreur lors de l'éxécution de insertArticleVendu()");
			e.printStackTrace();

		}
	
	}// Eo insertArticleVendu()
	
}
