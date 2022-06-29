package fr.eni.tp.enchere.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class CategorieDAOJdbcImpl {
	
	private final static String REQ_SELECT_CATEGORIE_ID 
	= "SELECT no_categorie FROM categories WHERE libelle = ? ;"; 
	
	
	
	/**
	 * Retourne le numero d'une categorie correspondant au libelle fourni.
	 * @param libelle: String
	 * @return int
	 */
	public int selectNoCategorieByLibelle(String libelle) {
		
		int noCategorie = -1; // return -1 if there is an error
		
		try(Connection cnx = ConnectionProvider.getConnection()) {				
				
			PreparedStatement ordre = cnx.prepareStatement(REQ_SELECT_CATEGORIE_ID, Statement.RETURN_GENERATED_KEYS);
						
			ordre.setString(1, libelle);
						
			ordre.executeQuery();
			
			ResultSet rs = ordre.executeQuery();	
			
			while (rs.next()) {
				
				noCategorie = rs.getInt(1);
				
			}		
			
		} catch ( SQLException sqle) {
			System.err.println("Erreur lors de l'éxécution de selectNoCategorieByLibelle()");
			sqle.printStackTrace();
		}
		
		return noCategorie;
		
	}// EO selectNoCategorieByLibelle()

}
