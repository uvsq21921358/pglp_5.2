package uvsq21921358;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonnelJdbcDAO implements DAO<PersonnelImuable>{
	/**
	 * Implémentation JDBC
	 */
	private static String db = JdbcInit.db;
	@Override
	public PersonnelImuable create(PersonnelImuable objet){
		try (Connection connect = DriverManager.getConnection(db)){
			PreparedStatement prepare = connect.prepareStatement("INSERT INTO personnels (nom, prenom)" +"VALUES (?, ?)");
			prepare.setString(1, objet.getNom());
			prepare.setString(2, objet.getPrenom());
			System.out.println("Cr�ation reussie " + objet);
			int result = prepare.executeUpdate();
			assert result == 1; 
		}
		catch (SQLException e){
			e.printStackTrace();
		}
		return objet;
	}

	@Override
	public PersonnelImuable read(String id){
		PersonnelImuable p = null;
		try (Connection connect = DriverManager.getConnection(db)){
			System.out.println(" Recherche " + id);
			PreparedStatement prepare = connect.prepareStatement("SELECT * FROM personnels WHERE nom = ?");
			prepare.setString(1, id);
			ResultSet result = prepare.executeQuery();
			if(result.next()){
				p = new PersonnelImuable.Builder(result.getString("nom"),result.getString("prenom")).build();
				result.close();
			}
		}
		catch (SQLException e){
			e.printStackTrace();
		}
		return p;
	}

	@Override
	public PersonnelImuable update(PersonnelImuable objet){
		try (Connection connect = DriverManager.getConnection(db)) {
			PreparedStatement prepare = connect.prepareStatement("UPDATE personnels "+ "SET prenom = ?"+ "WHERE nom = ?");
			prepare.setString(1, objet.getPrenom());
			prepare.setString(3, objet.getNom());
			int result = prepare.executeUpdate();
			assert result == 1;
		}
		catch (SQLException e){
			e.printStackTrace();
		}
		System.out.println("Mise A Jour " + objet);
		return objet;
	}

	@Override
	public void delete(PersonnelImuable objet){
		try (Connection connect = DriverManager.getConnection(db)){
			PreparedStatement prepare = connect.prepareStatement("DELETE FROM personnels "+ "WHERE nom = ?");
			prepare.setString(1, objet.getNom());
			int result = prepare.executeUpdate();
			assert result == 1;
			System.out.println("Suppression reussie " + objet);
		}
		catch (SQLException e){
			e.printStackTrace();
		}
	}
}


