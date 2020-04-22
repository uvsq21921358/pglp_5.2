package uvsq21921358;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * Initialisation
 * Ajout de derby
 * Creation des classes....
 */

public class JdbcInit {

	private static final String Nom = "Marie";
	private static final String password = "MARIE";
	public static String db = "jdbc:derby:bd;create=true";
	
	public JdbcInit() {
		Properties connectionProps = new Properties();
		connectionProps.put("user", Nom);
		connectionProps.put("user", password);
	}

	public void dropCreate() {

		try (Connection connect = DriverManager.getConnection(db)) {

			Statement state = connect.createStatement();
			state.addBatch("DROP TABLE personnelGroupes");
			state.addBatch("DROP TABLE appartient");
			state.addBatch("DROP TABLE personnels");
			state.addBatch("CREATE TABLE personnelGroupes ("+ "id VARCHAR(100) PRIMARY KEY"+ ")");
			state.addBatch( "CREATE TABLE appartient ("+ "id VARCHAR(100),"+ "nom VARCHAR(100)"+ ")"); 
			state.addBatch("CREATE TABLE personnels ("+ "nom VARCHAR(100) PRIMARY KEY,"+ "prenom VARCHAR(100) NOT NULL,"+ "dateNaiss DATE NOT NULL"+ ")");
			state.executeBatch();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	public void createTables() {

		try (Connection connect = DriverManager.getConnection(db)) {
			Statement state = connect.createStatement();
			state.addBatch("CREATE TABLE personnelGroupes ("+ "id VARCHAR(100) PRIMARY KEY"+ ")");
			state.addBatch("CREATE TABLE appartient ("+ "id VARCHAR(100),"+ "nom VARCHAR(100)"+ ")"); 
			state.addBatch("CREATE TABLE personnels ("+ "nom VARCHAR(100) PRIMARY KEY,"+ "prenom VARCHAR(100) NOT NULL,"+ "dateNaiss DATE NOT NULL"+ ")");
			state.executeBatch();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}		

	}
	

}
