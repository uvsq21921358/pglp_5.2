package uvsq21921358;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

public class PersonnelGroupeJdbcDAO implements DAO<PersonnelGroupe>{

	private static String db = JdbcInit.db;

	@Override
	public PersonnelGroupe create(PersonnelGroupe objet) {
		try (Connection connect = DriverManager.getConnection(db)) {
			PreparedStatement prepare = connect.prepareStatement("INSERT INTO personnelGroupes (id)" +"VALUES (?)");
			prepare.setString(1, objet.getId());
			int result = prepare.executeUpdate();
			assert result == 1; 
			List<PersonnelImuable> lp = objet.getAllPersonnel().stream().filter(e -> !e.isGroupe()).map(e -> (PersonnelImuable) e).collect(Collectors.toList());
			
			for (PersonnelImuable p : lp) {
				prepare = connect.prepareStatement("INSERT INTO appartient "+ "VALUES (?, ?)");
				prepare.setString(1, objet.getId());
				prepare.setString(2, p.getNom());
				prepare.addBatch();
			}
			prepare.executeBatch();
			System.out.println("Création " + objet);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return objet;
	}
	
	

	@Override
	public PersonnelGroupe read(String id) {
		PersonnelGroupe pg = null;

		try (Connection connect = DriverManager.getConnection(db)) {
			System.out.println("Recherche " + id);
			PreparedStatement prepare = connect.prepareStatement("SELECT * FROM appartient WHERE id = ?");
			prepare.setString(1, id);
			pg = new PersonnelGroupe(id);
			ResultSet result = prepare.executeQuery();
			PersonnelJdbcDAO pjd = new PersonnelJdbcDAO();
			while (result.next()) {
		        pg.addPersonnel(pjd.read(result.getString("nom")));
		    }			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return pg;
	}

	@Override
	public PersonnelGroupe update(PersonnelGroupe obj) {
	try (Connection connect = DriverManager.getConnection(db)) {
		List<PersonnelImuable> lp = obj.getAllPersonnel().stream()
			.filter(e -> !e.isGroupe())
			.map(e -> (PersonnelImuable) e)
			.collect(Collectors.toList());
		PreparedStatement prepare = connect.prepareStatement("DELETE FROM appartient"+ "WHERE id = ?");
		prepare.setString(1, obj.getId());
		for (PersonnelImuable p : lp) {
			prepare = connect.prepareStatement("INSERT INTO appartient "+ "VALUES (?, ?)");
			prepare.setString(1, obj.getId());
			prepare.setString(2, p.getNom());
			prepare.addBatch();
		}
		prepare.executeBatch();
	}
	catch (SQLException e) {
		e.printStackTrace();
	}
	System.out.println("Mise A Jour " + obj);
	return obj;
	}

	@Override
	public void delete(PersonnelGroupe objet) {
		try (Connection connect = DriverManager.getConnection(db)) {
			PreparedStatement prepare = connect.prepareStatement("DELETE FROM personnelGroupes "+ "WHERE id = ?");
			prepare.setString(1, objet.getId());
			int result = prepare.executeUpdate();
			assert result == 1;
			System.out.println("Suppression terminée " + objet);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
		
}

