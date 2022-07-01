package fr.eni.tp.enchere.bo;

import java.time.LocalDate;
import java.util.ArrayList;

import fr.eni.tp.enchere.dal.jdbc.CategorieDAOJdbcImpl;

public class Article {

	private int noArticle;
	private String nomArticle;
	private String description;
	private LocalDate dateDebutEncheres;
	private LocalDate dateFinEncheres;
	private int miseAPrix;
	private int prixVente;
	private String etatVente;
	private Utilisateur vendeur;
	private Categorie categorie;
	private Retrait retrait;
	private ArrayList<Enchere> encheres; 	

	// utilitaire
	private CategorieDAOJdbcImpl categorieDAO; // pour requeter le numero des categorie en BDD � partir du libelle

	/**
	 * Constructeur sans noArticle
	 **/
	public Article(String nomArticle, String description, LocalDate dateDebutEncheres, LocalDate dateFinEncheres,
			int miseAPrix, Utilisateur vendeur, String categorie, String rue, String codePostal, String ville) {

		this.categorieDAO = new CategorieDAOJdbcImpl();
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEncheres = dateDebutEncheres;
		this.dateFinEncheres = dateFinEncheres;
		this.miseAPrix = miseAPrix;
		this.vendeur = vendeur;
		this.categorie = setCategorie(categorie);
		this.retrait = setRetrait(rue, codePostal, ville);
		this.encheres = new ArrayList<>();

	}

	public Article(int noArticle, String nomArticle, String description, LocalDate dateDebutEncheres,
			LocalDate dateFinEncheres, int miseAPrix, Utilisateur vendeur, String categorie, String rue,
			String codePostal, String ville) {

		this.categorieDAO = new CategorieDAOJdbcImpl();
		this.noArticle = noArticle;
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEncheres = dateDebutEncheres;
		this.dateFinEncheres = dateFinEncheres;
		this.miseAPrix = miseAPrix;
		this.vendeur = vendeur;
		this.categorie = setCategorie(categorie);
		this.retrait = setRetrait(rue, codePostal, ville);
		this.encheres = new ArrayList<>();
	}

	public int getNoArticle() {
		return noArticle;
	}

	public void setNoArticle(int noArticle) {
		this.noArticle = noArticle;
	}

	public String getNomArticle() {
		return nomArticle;
	}

	public void setNomArticle(String nomArticle) {
		this.nomArticle = nomArticle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getDateDebutEncheres() {
		return dateDebutEncheres;
	}

	public void setDateDebutEncheres(LocalDate dateDebutEncheres) {
		this.dateDebutEncheres = dateDebutEncheres;
	}

	public LocalDate getDateFinEncheres() {
		return dateFinEncheres;
	}

	public void setDateFinEncheres(LocalDate dateFinEncheres) {
		this.dateFinEncheres = dateFinEncheres;
	}

	public int getMiseAPrix() {
		return miseAPrix;
	}

	public void setMiseAPrix(int miseAPrix) {
		this.miseAPrix = miseAPrix;
	}

	public int getPrixVente() {
		return prixVente;
	}

	public void setPrixVente(int prixVente) {
		this.prixVente = prixVente;
	}

	public String getStatVente() {
		return etatVente;
	}

	public void setStatVente(String statVente) {
		this.etatVente = statVente;
	}

	public Utilisateur getVendeur() {
		return vendeur;
	}

	public void setVendeur(Utilisateur vendeur) {
		this.vendeur = vendeur;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public Categorie setCategorie(String libelle) {

		Categorie categorie = null;

		int noCategorie = categorieDAO.selectNoCategorieByLibelle(libelle);

		categorie = new Categorie(noCategorie, libelle);

		return categorie;

	}

	public Retrait getRetrait() {
		return retrait;
	}

	public Retrait setRetrait(String rue, String codePostal, String ville) {

		Retrait nouveauRetrait = null;

		try {
			if (!rue.isEmpty() && !codePostal.isEmpty() && !ville.isEmpty()) {
				nouveauRetrait = new Retrait(rue, codePostal, ville);
			}
		} catch (NullPointerException e) {
			nouveauRetrait = new Retrait("non-d�finie", "non-d�fini", "non-d�finie");
		}

		return nouveauRetrait;
	}

	public ArrayList<Enchere> getEncheres() {
		return encheres;
	}

	public void setEncheres(ArrayList<Enchere> encheres) {
		this.encheres = encheres;
	}

	@Override
	public String toString() {
		return "Article [noArticle=" + noArticle + ", nomArticle=" + nomArticle + ", description=" + description
				+ ", dateDebutEncheres=" + dateDebutEncheres + ", dateFinEncheres=" + dateFinEncheres + ", miseAPrix="
				+ miseAPrix + ", prixVente=" + prixVente + ", etatVente=" + etatVente + ", vendeur=" + vendeur
				+ ", categorie=" + categorie + ", retrait=" + retrait + ", categorieDAO=" + categorieDAO + "]";
	}

}
