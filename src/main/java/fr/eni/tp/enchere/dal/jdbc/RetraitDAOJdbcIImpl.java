package fr.eni.tp.enchere.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import fr.eni.tp.enchere.bo.Retrait;

public class RetraitDAOJdbcIImpl {
	
	private final static String REQ_INSERT_RETRAIT 
	= "INSERT RETRAITS(no_article, rue, code_postal, ville) VALUES (?,?,?,?)";
	
	public void insertRetrait(Connection cnx, int numeroArticle, Retrait retrait) {
		
		try {
			
			PreparedStatement req = cnx.prepareStatement(REQ_INSERT_RETRAIT, Statement.RETURN_GENERATED_KEYS);
			
			req.setInt(1, numeroArticle);
			req.setString(2, retrait.getRue());
			req.setString(3, retrait.getCode_postal());
			req.setString(4, retrait.getVille());
						
			req.executeUpdate();	
			
		} catch (SQLException e) {
			System.err.println("Erreur lors de l'éxécution de insertRetrait()");
			e.printStackTrace();
		}
	
	}// Eo insertRetrait()

}
