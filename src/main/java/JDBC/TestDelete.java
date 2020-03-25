package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class TestDelete {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// étape 0 - lecture fichier "db.properties"
	       ResourceBundle db = ResourceBundle.getBundle("db");
	       
	       
	       // étape 1 - enregistrer le pilote
	       Class.forName(db.getString("db.driver"));
	       
	       // étape 2 - créer la connexion
	       Connection connection = DriverManager.getConnection(db.getString("db.url"), db.getString("db.user"),
	               db.getString("db.pass"));
	       
	       // étape 3 - créer un "statement" 
	        Statement statement = connection.createStatement();

	        // requête qui permet de supprimer le fournisseur « La Maison des Peintures ». 
	        int nbLigneAffecter = statement.executeUpdate("DELETE FROM fournisseur WHERE fournisseur.nom ='La Maison des Peintures'");

	       boolean connecter = connection.isValid(0);
	         System.out.println("Connection : " + connecter);
	             
	       // libération des ressources
	       connection.close();

		}

	}

