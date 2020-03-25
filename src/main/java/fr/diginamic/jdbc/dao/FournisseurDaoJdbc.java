package fr.diginamic.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import fr.diginamic.jdbc.Exception.ComptaException;
import fr.diginamic.jdbc.entites.Fournisseur;

public class FournisseurDaoJdbc implements FournisseurDao {
	// Extraire les données de fournisseur à partir de la BDD et les mettre dans une
	// liste
	public List<Fournisseur> extraire() {
		List<Fournisseur> listeFournisseurs = new ArrayList<Fournisseur>();

		try (Connection connection = getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM fournisseur")) {

			while (resultSet.next()) {
				listeFournisseurs.add(new Fournisseur(resultSet.getInt("id"), resultSet.getString("nom")));
			}

			return listeFournisseurs;
		} catch (SQLException e) {
			throw new ComptaException("Erreur d'échange avec la base de données", e);
		}
	}

	// une insertion dans la base de compta sur la table fournisseur

	public void insert(Fournisseur fournisseur) {
		try (Connection connection = getConnection(); Statement statement = connection.createStatement()) {

			statement.executeUpdate("INSERT INTO fournisseur (id, nom) VALUES (" + fournisseur.getId() + ", '"
					+ fournisseur.getNom() + "') ");

		} catch (SQLException e) {
			throw new ComptaException("Erreur d'échange avec la base de données", e);
		}
	}

	// changement de l'ancien nom par un nouveau Nom
	public int update(String ancienNom, String nouveauNom) {
		try (Connection connection = getConnection(); 
				Statement statement = connection.createStatement()) {

			return statement
					.executeUpdate("UPDATE fournisseur SET nom='" + nouveauNom + "' WHERE nom='" + ancienNom + "'");
		} catch (SQLException e) {
			throw new ComptaException("Erreur d'échangeavec la base de données", e);
		}
	}

	// suppression d'un fournisseur donné dans la table fournisseur de BDD
	public boolean delete(Fournisseur fournisseur) {
		try (Connection connection = getConnection(); 
				Statement statement = connection.createStatement()) {

			return statement.executeUpdate("DELETE FROM fournisseur where id=" + fournisseur.getId()) == 1;
		} catch (SQLException e) {
			throw new ComptaException("Erreur de communication avec la base de données", e);
		}
	}

	private Connection getConnection() {
		// recupere le fichier properties
		ResourceBundle db = ResourceBundle.getBundle("db");

		try {
			// enregistre le pilote
			Class.forName(db.getString("db.driver"));

			return DriverManager.getConnection(db.getString("db.url"), db.getString("db.user"),
					db.getString("db.pass"));
		} catch (ClassNotFoundException | SQLException e) {
			throw new ComptaException(e);
		}
	}

}
