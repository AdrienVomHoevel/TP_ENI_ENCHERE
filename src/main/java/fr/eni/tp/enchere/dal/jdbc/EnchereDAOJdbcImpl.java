package fr.eni.tp.enchere.dal.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import fr.eni.tp.enchere.bo.Article;
import fr.eni.tp.enchere.bo.Enchere;

public class EnchereDAOJdbcImpl {
	
	UtilisateurDAOJdbcImpl utilisateurDAO;
	
	private final static String REQ_INSERT_ENCHERE
	= "INSERT ENCHERES(no_utilisateur, no_article, date_enchere, montant_enchere) VALUES (?,?,?,?)";
	
	private final static String REQ_SELECT_USER_ENCHERE
	= "SELECT no_utilisateur, no_article, date_enchere, montant_enchere FROM ENCHERES WHERE no_utilisateur = ? AND no_article = ? ;"; 

	private final static String REQ_UPDATE_USER_ENCHERE
	= "UPDATE ENCHERES SET montant_enchere = ? , date_enchere = ? WHERE no_utilisateur = ? AND no_article = ?;";
	
	private final static String REQ_SELECT_HIGHEST_ENCHERE
	= "SELECT MAX(montant_enchere) AS montant FROM ENCHERES WHERE no_article = ?;";
	
	private final static String REQ_SELECT_ALL_ENCHERES_OF_ARTICLE
	= "SELECT no_utilisateur, no_article, date_enchere, montant_enchere FROM ENCHERES WHERE no_article = ?;";
	
	public EnchereDAOJdbcImpl() {
		this.utilisateurDAO = new UtilisateurDAOJdbcImpl();
	}
	
	/**
	 * Insere une enchere.
	 * @param noArticle
	 * @param enchere
	 */
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
	
	/**
	 * Update une enchere.
	 * @param noArticle
	 * @param enchere
	 */
	public void updateEnchere(int noArticle, Enchere enchere) {
		
		try(Connection cnx = ConnectionProvider.getConnection()){
			
			try {
				
				cnx.setAutoCommit(false);
				
				PreparedStatement ordre = cnx.prepareStatement(REQ_UPDATE_USER_ENCHERE, Statement.RETURN_GENERATED_KEYS);
				
				ordre.setInt(1, enchere.getMontant_enchere());
				ordre.setDate(2, Date.valueOf(enchere.getDateEnchere()));
				ordre.setInt(3, enchere.getEncherisseur().getNoUtilisateur());
				ordre.setInt(4, noArticle);
							
				ordre.executeUpdate();
				
				cnx.commit();
				
			} catch (SQLException e) {
				
				cnx.rollback();
				
				System.err.println("Erreur lors de la transaction dans updateEnchere()");
				e.printStackTrace();
				
			}

		} catch (SQLException e) {

			System.err.println("Erreur lors de l'éxécution de updateEnchere()");
			e.printStackTrace();

		}
	
	}// Eo updateEnchere()
	
	/**
	 * Checks if an user already put an Enchere on an Article being sold.
	 * @param noUser
	 * @param noArticle
	 * @return boolean
	 */
	public Boolean selectEnchereByArticleAndUser(int noUser, int noArticle) {
		
		Boolean enchereExists = false; 
		
		try(Connection cnx = ConnectionProvider.getConnection()) {				
				
			PreparedStatement ordre = cnx.prepareStatement(REQ_SELECT_USER_ENCHERE, Statement.RETURN_GENERATED_KEYS);
						
			ordre.setInt(1, noUser);
			ordre.setInt(2, noArticle);
						
			ordre.executeQuery();
			
			ResultSet rs = ordre.executeQuery();	
			
			if (rs.next()) {
				
				enchereExists = true;
				
			}		
			
		} catch ( SQLException sqle) {
			System.err.println("Erreur lors de l'éxécution de selectEnchereByArticleAndUser()");
			sqle.printStackTrace();
		}
		
		return enchereExists;
		
	}// EO selectEnchereByArticleAndUser()
	
	/**
	 * Retourne le montant de l'enchere actuellement la plus haute ou 0 si aucune enchere.
	 * @param noArticle
	 * @return int
	 */
	public int selectHighestEnchere(int noArticle) {
		
		int montant = 0; // if 0 -> no Enchere found 
		
		try(Connection cnx = ConnectionProvider.getConnection()) {				
				
			PreparedStatement ordre = cnx.prepareStatement(REQ_SELECT_HIGHEST_ENCHERE, Statement.RETURN_GENERATED_KEYS);
						
			ordre.setInt(1, noArticle);
						
			ordre.executeQuery();
			
			ResultSet rs = ordre.executeQuery();	
			
			if (rs.next()) {
				
				montant = rs.getInt("montant");
				
			}		
			
		} catch ( SQLException sqle) {
			System.err.println("Erreur lors de l'éxécution de selectHighestEnchere()");
			sqle.printStackTrace();
		}
		
		return montant;
		
	}// EO selectEnchereByArticleAndUser()
	
	public ArrayList<Enchere> selectAllEnchereOfArticle(int numeroArticle) {
		
		ArrayList<Enchere> enchereList = new ArrayList<>();
		
		try(Connection cnx = ConnectionProvider.getConnection()) {				
			
			PreparedStatement ordre = cnx.prepareStatement(REQ_SELECT_ALL_ENCHERES_OF_ARTICLE, Statement.RETURN_GENERATED_KEYS);
						
			ordre.setInt(1, numeroArticle);
						
			ordre.executeQuery();
			
			ResultSet rs = ordre.executeQuery();	
			
			while (rs.next()) {
				
				String noUtilisateur = rs.getString("no_utilisateur");
				
//				Utilisateur encherisseur
				
				String noArticle = rs.getString("no_article");
				LocalDate dateEnchere = newDate(rs.getString("date_enchere"));		
				int montant = rs.getInt("montant");
				
				
				
				Enchere enchere = new Enchere(null, montant);
				
			}		
			
		} catch ( SQLException sqle) {
			System.err.println("Erreur lors de l'éxécution de selectHighestEnchere()");
			sqle.printStackTrace();
		}
		
		
		return enchereList;
		
	}
	
	private LocalDate newDate(String date) {
		
		LocalDate newDate = null;
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
  
		newDate = LocalDate.parse(date, formatter);
		
		return newDate;		
	}
	
}
