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

import fr.eni.tp.enchere.bll.UtilisateurManager;
import fr.eni.tp.enchere.bo.Article;
import fr.eni.tp.enchere.bo.Utilisateur;

public class ArticleVenduDAOJdbcImpl {
	
	RetraitDAOJdbcIImpl retraitDAO;
	
	CategorieDAOJdbcImpl categorieDAO;
	
	UtilisateurManager utilisateurManager;
	
	public ArticleVenduDAOJdbcImpl() {
		this.retraitDAO = new RetraitDAOJdbcIImpl();
		this.categorieDAO = new CategorieDAOJdbcImpl();
		this.utilisateurManager = UtilisateurManager.getInstance();
	}

	private final static String REQ_INSERT_ARTICLE_VENDU 
	= "INSERT ARTICLES_VENDUS(nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, no_utilisateur, no_categorie) VALUES (?,?,?,?,?,?,?)"; 

	private final static String REQ_SELECT_ALL_ARTICLES_VENDUS
	= "SELECT av.no_article, "
			+ "av.nom_article, "
			+ "av.description, "
			+ "av.date_debut_encheres, "
			+ "av.date_fin_encheres, "
			+ "av.prix_initial, "
			+ "av.no_utilisateur, "
			+ "av.no_categorie, "
			+ "r.rue, r.code_postal, r.ville "
			+ "FROM ARTICLES_VENDUS av "
			+ "LEFT JOIN RETRAITS r ON av.no_article=r.no_article;";
	
	/**
	 * Insere un article en BDD. 
	 * !! WARNING !! 
	 * Provoque une erreur si le no_utilisateur de 
	 * l'utilisateur n'est pas un numero existant en BDD dans la table UTILISATEUR.
	 * @param article
	 */
	public void insertArticleVendu(Article article) {
		
		try(Connection cnx = ConnectionProvider.getConnection()){
			
			try {
				
				cnx.setAutoCommit(false);
				
				PreparedStatement ordre = cnx.prepareStatement(REQ_INSERT_ARTICLE_VENDU, Statement.RETURN_GENERATED_KEYS);
				
				ordre.setString(1, article.getNomArticle());
				ordre.setString(2, article.getDescription());
				ordre.setDate(3, Date.valueOf(article.getDateDebutEncheres()));
				ordre.setDate(4, Date.valueOf(article.getDateFinEncheres()));
				ordre.setInt(5, article.getPrixVente());
				ordre.setInt(6, article.getVendeur().getNoUtilisateur());
				ordre.setInt(7, article.getCategorie().getNoCategorie());
							
				ordre.executeUpdate();
				
				ResultSet rs = ordre.getGeneratedKeys();
				
				int noArticle = -1;
				
				if (rs.next()) 
				{
					noArticle = rs.getInt(1);	
					
					//Insert le Retrait correspondant à l'article
					if (article.getRetrait() != null) {
						
						retraitDAO.insertRetrait(cnx, noArticle, article.getRetrait());

					}

				}	
				
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
	
	public ArrayList<Article> selectAllArticles() {
		
		ArrayList<Article> articlesList = new ArrayList<Article>();
		
		try(Connection cnx = ConnectionProvider.getConnection()) {
			
			try {
				
				cnx.setAutoCommit(false);
				
				Statement ordre = cnx.createStatement();
				
				ResultSet rs = ordre.executeQuery(REQ_SELECT_ALL_ARTICLES_VENDUS);
				
				while(rs.next() ) {
					
					int noArticle = rs.getInt(1);
					String nom = rs.getString("nom_article");
					String description = rs.getString("description");
					LocalDate dateDebut = newDate(rs.getString("date_debut_encheres"));
					LocalDate dateFin = newDate(rs.getString("date_fin_encheres"));
					int prixInitial = rs.getInt("prix_initial");
					int noUtilisateur = rs.getInt("no_utilisateur");
					int noCategorie = rs.getInt("no_categorie");
					String rue = rs.getString("rue");
					String codePostal = String.valueOf(rs.getInt("code_postal"));
					String ville = rs.getString("ville");
					
					Utilisateur utilisateur = utilisateurManager.getUtilisateurById(noUtilisateur);
					
					String libelleCategorie = categorieDAO.selectLibelleCategorieByNo(noCategorie);
							
					Article article = new Article(noArticle, nom, description, dateDebut, dateFin, prixInitial, utilisateur, libelleCategorie, rue, codePostal, ville);
					
					articlesList.add(article);
					
				}
				
				cnx.commit();

			} catch (SQLException e) {
				e.printStackTrace();
				try {		
					cnx.rollback();					
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
			} 
			
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		
		return articlesList;
	}// Eo selectAllArticles()
	
	
	
	private LocalDate newDate(String date) {
		
		LocalDate newDate = null;
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
  
		newDate = LocalDate.parse(date, formatter);
		
		return newDate;		
	}
	
}
