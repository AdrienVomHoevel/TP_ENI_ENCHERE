package fr.eni.tp.enchere.bll;

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
	
	

}
