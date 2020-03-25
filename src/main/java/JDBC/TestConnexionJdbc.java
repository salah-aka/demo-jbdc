package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class TestConnexionJdbc {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// �tape 0 - lecture fichier "db.properties"
       ResourceBundle db = ResourceBundle.getBundle("db");
       
       
       // �tape 1 - enregistrer le pilote
       // option 1.1
       // DriverManager.registerDriver(new Driver());
       // option 1.2
       Class.forName(db.getString("db.driver"));
       
       // �tape 2 - cr�er la connexion
       Connection connection = DriverManager.getConnection(db.getString("db.url"), db.getString("db.user"),
               db.getString("db.pass"));
       
       
       boolean connecter = connection.isValid(0);
         System.out.println("Connection : " + connecter);
             
       // lib�ration des ressources
       connection.close();

	}

}
