package fr.diginamic.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class TestInsertion {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// étape 0 - lecture fichier "db.properties"
	       ResourceBundle db = ResourceBundle.getBundle("db");
	       
	       
	       // étape 1 - enregistrer le pilote
	       Class.forName(db.getString("db.driver"));
	       
	       // étape 2 - créer la connexion
	       Connection connection = DriverManager.getConnection(db.getString("db.url"), db.getString("db.user"),
	               db.getString("db.pass"));
	       
	       // étape 3 - créer un "statement" (outil pour faire des requêtes)
	        Statement statement = connection.createStatement();

	        // étape 4 - exécuter la requête- exemple insert, update, delete
	        int nb = statement.executeUpdate("insert into fournisseur(id,nom) values(4, 'La Maison de la Peinture')");
	       
	       boolean connecter = connection.isValid(0);
	         System.out.println("Connection : " + connecter);
	             
	       // libération des ressources
	       connection.close();

		}

	}
 

