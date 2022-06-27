package fr.eni.tp.enchere.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import fr.eni.tp.enchere.bo.Utilisateur;

public class UtilisateurDAOJdbcImpl {

	public void insert(Utilisateur utilisateur) {

		// s'il n'y a pas de parametre, cela ne sert à rien de continuer.
		if (utilisateur == null) {
			return;
		}

		try (Connection cnx = ConnectionProvider.getConnection()) // la connexion va être automatiquement fermée
		{
			try {
				// Debut de la transaction :
				cnx.setAutoCommit(false);

				// ********************
				// Ajout dans la table UTILISATEUR

				// TODO Faire la requete d'insert user
				PreparedStatement pstmt = cnx.prepareStatement(INSERT_UTILISATEUR,
						PreparedStatement.RETURN_GENERATED_KEYS);

				// Valorisation des parametres du PreparedStatement
				pstmt.setString(1, utilisateur.getPseudo());
				pstmt.setString(2, utilisateur.getNom());
				pstmt.setString(3, utilisateur.getPrenom());
				pstmt.setString(4, utilisateur.getEmail());
				pstmt.setString(5, utilisateur.getTelephone());
				pstmt.setString(6, utilisateur.getRue());
				// TODO Modifier dans la BLL le format du CodePostal en string.
				pstmt.setString(7, utilisateur.getCodePostal());
				pstmt.setString(8, utilisateur.getVille());
				pstmt.setString(9, utilisateur.getMotDePasse());
				pstmt.setInt(10, utilisateur.getCredit());
				pstmt.setString(11, utilisateur.getAdministrateur());

				// Execution de la requete
				pstmt.executeUpdate();

				// Récupération de l'ID généré pour l'utilisateur
				ResultSet rs = pstmt.getGeneratedKeys();
				if (rs.next()) {
					utilisateur.setNoutilisateur(rs.getInt(1)); // l'utilisateur du Modèle est mis à jour
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
	
	public void update(Utilisateur utilisateur) {
		
		
		
	}
}
