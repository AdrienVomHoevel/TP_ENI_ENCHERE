package fr.eni.tp.enchere.bo;

import java.time.LocalDate;

public class Enchere {

	private LocalDate dateEnchere;
	private int montant_enchere;
	private Utilisateur encherisseur;

	public Enchere(Utilisateur encherisseur, int montant_enchere, Article articleVendu) {
		super();
		this.dateEnchere = LocalDate.now();
		this.montant_enchere = montant_enchere;
		this.encherisseur = encherisseur;
	}

	public LocalDate getDateEnchere() {
		return dateEnchere;
	}

	public void setDateEnchere(LocalDate dateEnchere) {
		this.dateEnchere = dateEnchere;
	}

	public int getMontant_enchere() {
		return montant_enchere;
	}

	public void setMontant_enchere(int montant_enchere) {
		this.montant_enchere = montant_enchere;
	}

	public Utilisateur getEncherisseur() {
		return encherisseur;
	}

	public void setEncherisseur(Utilisateur encherisseur) {
		this.encherisseur = encherisseur;
	}

	@Override
	public String toString() {
		return "Enchere [dateEnchere=" + dateEnchere + ", montant_enchere=" + montant_enchere + ", encherisseur="
				+ encherisseur + "]";
	}

	
	
	
	
	
	
	
	
}
