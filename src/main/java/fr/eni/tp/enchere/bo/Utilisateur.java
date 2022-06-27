package fr.eni.tp.enchere.bo;

import java.time.LocalDate;

public class Utilisateur {

	private int noutilisateur;
	private String pseudo;
	private String nom;
	private String prenom;
	private String email;
	private String telephone;
	private String rue;
	private int codePostal;
	private String ville;
	private String motDePasse;
	private int credit = 0;
	private String administrateur;

	public Utilisateur(int noutilisateur, String pseudo, String nom, String prenom, String email, String telephone,
			String rue, int codePostal, String ville, String motDePasse, int credit, String administrateur) {
		super();
		this.noutilisateur = noutilisateur;
		this.pseudo = pseudo;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
		this.motDePasse = motDePasse;
		this.credit = credit;
		this.administrateur = administrateur;
	}

	public int getNoutilisateur() {
		return noutilisateur;
	}

	public void setNoutilisateur(int noutilisateur) {
		this.noutilisateur = noutilisateur;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public int getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	public String getAdministrateur() {
		return administrateur;
	}

	public void setAdministrateur(String administrateur) {
		this.administrateur = administrateur;
	}

	/**
	 * 
	 * Lorsque la méthode enchérit est appelée, une nouvelle enchere est crée.
	 * 
	 * @param dateEnchere    Date de l'enchere
	 * @param montantEnchere Montant de l'enchere
	 * @return une enchere crée par la méthode.
	 */
	public Enchere encherit(LocalDate dateEnchere, int montantEnchere) {

		Enchere resultat = null;

		Enchere nouvelleEnchere = new Enchere(dateEnchere, montantEnchere);

		resultat = nouvelleEnchere;

		return resultat;
	}

	/**
	 * Permet l'échange de points lors de la fin d'une enchere, du point de vu de
	 * l'acheteur
	 * 
	 * @param noArticle Numéro de l'article concerné.
	 */
	public int achete(int noArticle) {

		int resultat = 0;

		return resultat;
	}

	/**
	 * 
	 * Permet l'échange de points lors de la fin d'une enchere, du point de vu du
	 * vendeur.
	 * 
	 * @param noArticle
	 */
	public int vend(int noArticle) {

		int resultat = 0;

		return resultat;
	}

	@Override
	public String toString() {
		return "Utilisateur [noutilisateur=" + noutilisateur + ", pseudo=" + pseudo + ", nom=" + nom + ", prenom="
				+ prenom + ", email=" + email + ", telephone=" + telephone + ", rue=" + rue + ", codePostal="
				+ codePostal + ", ville=" + ville + ", motDePasse=" + motDePasse + ", credit=" + credit
				+ ", administrateur=" + administrateur + "]";
	}

}
