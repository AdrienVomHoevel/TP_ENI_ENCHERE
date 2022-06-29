package fr.eni.tp.enchere.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import fr.eni.tp.enchere.bo.Utilisateur;

public class UtilisateurDAOJdbcImpl {

	/**
	 * Sert à créer un nouvel utilisateur et à envoyer en BDD Les informations
	 * enregistrées.
	 * 
	 * @param utilisateur Regroupe les paramètres de l'objet utilisateur.
	 */
	public void insert(Utilisateur utilisateur) {

		// s'il n'y a pas de parametre, cela ne sert à rien de continuer.
		if (utilisateur == null) {
			return;
		}

		try (Connection cnx = ConnectionProvider.getConnection()) // la connexion va être automatiquement fermée
		{
			try {

				// ********************
				// Ajout dans la table UTILISATEUR

				PreparedStatement pstmt = cnx.prepareStatement(
						"INSERT INTO UTILISATEURS VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);",
						PreparedStatement.RETURN_GENERATED_KEYS);

				// Valorisation des parametres du PreparedStatement
				pstmt.setString(1, utilisateur.getPseudo());
				pstmt.setString(2, utilisateur.getNom());
				pstmt.setString(3, utilisateur.getPrenom());
				pstmt.setString(4, utilisateur.getEmail());
				pstmt.setString(5, utilisateur.getTelephone());
				pstmt.setString(6, utilisateur.getRue());
				pstmt.setString(7, utilisateur.getCodePostal());
				pstmt.setString(8, utilisateur.getVille());
				pstmt.setString(9, utilisateur.getMotDePasse());
				pstmt.setInt(10, utilisateur.getCredit());
				pstmt.setBoolean(11, utilisateur.getAdministrateur());

				// Execution de la requete
				pstmt.executeUpdate();

				// cnx.commit();

				// Récupération de l'ID généré pour l'utilisateur
				ResultSet rs = pstmt.getGeneratedKeys();
				if (rs.next()) {
					utilisateur.setNoUtilisateur(rs.getInt(1)); // l'utilisateur du Modèle est mis à jour
				}

				rs.close();
				pstmt.close();

			} catch (Exception e) {
				// Journalisation
				e.printStackTrace();

				// Il y a eu une probleme => transaction annulée
				cnx.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Sert à mettre à jour les informations d'un utilisateur en recherchant dans la
	 * BDD avec son noUtilisateur.
	 * 
	 * @param utilisateur Regroupe les paramètres de l'objet utilisateur.
	 */
	public void update(Utilisateur utilisateur) {

		// Sans paramètres, c'est pas la peine.
		if (utilisateur == null) {
			return;
		}

		try (Connection cnx = ConnectionProvider.getConnection()) // la connexion va être automatiquement fermée
		{
			try {
				// ********************
				// Ajout dans la table UTILISATEUR

				// Recherche par noUtilisateur dans la requête SQL
				PreparedStatement pstmt = cnx.prepareStatement("UPDATE UTILISATEURS\r\n"
						+ "SET pseudo = ?, nom = ?, prenom = ?, email = ?, telephone = ?, \r\n"
						+ "rue = ?,  code_postal = ?, ville = ?, mot_de_passe = ?,\r\n"
						+ "credit = ?, administrateur = ?\r\n" + "WHERE (no_utilisateur = "
						+ utilisateur.getNoUtilisateur() + ");");

				// Valorisation des parametres du PreparedStatement
				pstmt.setString(1, utilisateur.getPseudo());
				pstmt.setString(2, utilisateur.getNom());
				pstmt.setString(3, utilisateur.getPrenom());
				pstmt.setString(4, utilisateur.getEmail());
				pstmt.setString(5, utilisateur.getTelephone());
				pstmt.setString(6, utilisateur.getRue());
				pstmt.setString(7, utilisateur.getCodePostal());
				pstmt.setString(8, utilisateur.getVille());
				pstmt.setString(9, utilisateur.getMotDePasse());
				pstmt.setInt(10, utilisateur.getCredit());
				pstmt.setBoolean(11, utilisateur.getAdministrateur());

				// Execution de la requete
				pstmt.executeUpdate();

				pstmt.close();

			} catch (Exception e) {
				// Journalisation
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public List<Utilisateur> selectUser() {

		List<Utilisateur> listeUtilisateurs = new ArrayList<Utilisateur>();

		try (Connection cnx = ConnectionProvider.getConnection()) // la connexion va être automatiquement fermée
		{
			try {

				// ********************
				// Ajout dans la table UTILISATEUR

				PreparedStatement pstmt = cnx.prepareStatement("SELECT no_utilisateur\r\n" + "      ,pseudo\r\n"
						+ "      ,nom\r\n" + "      ,prenom\r\n" + "      ,email\r\n" + "      ,telephone\r\n"
						+ "      ,rue\r\n" + "      ,code_postal\r\n" + "      ,ville\r\n" + "      ,mot_de_passe\r\n"
						+ "      ,credit\r\n" + "      ,administrateur FROM UTILISATEURS");

				ResultSet rs = pstmt.executeQuery();
				// Valorisation des parametres du PreparedStatement

				while (rs.next()) {
					Utilisateur utilisateurAjout = new Utilisateur();
					// Pour chaque nouvel identifiant d'utilisateur
					if (rs.getInt("no_utilisateur") != utilisateurAjout.getNoUtilisateur()) {
						utilisateurAjout.setPseudo(rs.getString("pseudo"));
						utilisateurAjout.setNom(rs.getString("nom"));
						utilisateurAjout.setPrenom(rs.getString("prenom"));
						utilisateurAjout.setEmail(rs.getString("email"));
						utilisateurAjout.setTelephone(rs.getString("telephone"));
						utilisateurAjout.setRue(rs.getString("rue"));
						utilisateurAjout.setCodePostal(rs.getString("code_postal"));
						utilisateurAjout.setVille(rs.getString("ville"));
						utilisateurAjout.setMotDePasse(rs.getString("mot_de_passe"));
						utilisateurAjout.setAdministrateur(rs.getBoolean("administrateur"));
					}
					listeUtilisateurs.add(utilisateurAjout);
				}
				// Execution de la requete
				pstmt.executeUpdate();
				// Fermeture de la requete
				pstmt.close();

			} catch (Exception e) {
				// Journalisation
				e.printStackTrace();

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listeUtilisateurs;

	}
}
