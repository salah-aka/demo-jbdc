package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import fr.diginamic.jdbc.entites.Fournisseur;

public class TestSelect extends Fournisseur {

	public TestSelect(int id, String nom) {
		super(id, nom);
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		List<Fournisseur> fournisseur = new ArrayList<Fournisseur>();
		// étape 0 - lecture fichier "db.properties"
		ResourceBundle db = ResourceBundle.getBundle("db");

		Class.forName(db.getString("db.driver"));

		Connection connection = DriverManager.getConnection(db.getString("db.url"), db.getString("db.user"),
				db.getString("db.pass"));

		Statement statement = connection.createStatement();

		// une requête qui permet d’extraire la liste de tous les fournisseurs.
		ResultSet curseur = statement.executeQuery("SELECT * FROM Fournisseur");

		while (curseur.next()) {
			
			Integer id = curseur.getInt("ID");
			String nom = curseur.getString("Nom");
		fournisseur.add(new Fournisseur( id, nom));
		}
		
		for (Fournisseur f : fournisseur) {
		System.out.println(f);
		}
		
		boolean connecter = connection.isValid(0);
		System.out.println("Connection : " + connecter);

		// étape 5 => libération des ressources
		statement.close();
		connection.close();

	}

}
