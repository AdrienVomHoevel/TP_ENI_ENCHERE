package fr.eni.tp.enchere.bo;

import java.time.LocalDateTime;

public class Enchere {

	private LocalDateTime dateEnchere;
	private int montant_enchere;
	private Utilisateur encherisseur;

	public Enchere(Utilisateur encherisseur, int montant_enchere) {
		super();
		this.dateEnchere = LocalDateTime.now();
		this.montant_enchere = montant_enchere;
		this.encherisseur = encherisseur;
	}
	
	public Enchere(Utilisateur encherisseur, LocalDateTime dateEnchere, int montant_enchere) {
		super();
		this.dateEnchere = dateEnchere;
		this.montant_enchere = montant_enchere;
		this.encherisseur = encherisseur;
	}

	public LocalDateTime getDateEnchere() {
		return dateEnchere;
	}

	public void setDateEnchere(LocalDateTime dateEnchere) {
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
