package fr.diginamic.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class TestInsertion {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// �tape 0 - lecture fichier "db.properties"
	       ResourceBundle db = ResourceBundle.getBundle("db");
	       
	       
	       // �tape 1 - enregistrer le pilote
	       Class.forName(db.getString("db.driver"));
	       
	       // �tape 2 - cr�er la connexion
	       Connection connection = DriverManager.getConnection(db.getString("db.url"), db.getString("db.user"),
	               db.getString("db.pass"));
	       
	       // �tape 3 - cr�er un "statement" (outil pour faire des requ�tes)
	        Statement statement = connection.createStatement();

	        // �tape 4 - ex�cuter la requ�te- exemple insert, update, delete
	        int nb = statement.executeUpdate("insert into fournisseur(id,nom) values(4, 'La Maison de la Peinture')");
	       
	       boolean connecter = connection.isValid(0);
	         System.out.println("Connection : " + connecter);
	             
	       // lib�ration des ressources
	       connection.close();

		}

	}
 

