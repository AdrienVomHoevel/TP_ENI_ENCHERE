package fr.eni.tp.enchere.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import fr.eni.tp.enchere.bo.Retrait;

public class RetraitDAOJdbcIImpl {
	
	private final static String REQ_INSERT_RETRAIT 
	= "INSERT RETRAITS(no_article, rue, code_postal, ville) VALUES (?,?,?,?)";
	
	public void insertRetrait(int numeroArticle, Retrait retrait) {
		
		try(Connection cnx = ConnectionProvider.getConnection()){
			
			PreparedStatement ordre = cnx.prepareStatement(REQ_INSERT_RETRAIT, Statement.RETURN_GENERATED_KEYS);
			
			ordre.setInt(1, numeroArticle);
			ordre.setString(2, retrait.getRue());
			ordre.setString(3, retrait.getCode_postal());
			ordre.setString(4, retrait.getVille());
						
			ordre.executeUpdate();	
			
		} catch (SQLException e) {
			System.err.println("Erreur lors de l'éxécution de insertRetrait()");
			e.printStackTrace();
		}
	
	}// Eo insertRetrait()

}
