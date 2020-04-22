package uvsq21921358;

public class JDAOFactory extends ADAOFactory {

	//Fabrique d'instanciation jdbc
	public DAO<PersonnelImuable> getPersonnelDAO() {
		return new PersonnelJdbcDAO();
	}

	public DAO<PersonnelGroupe> getPersonnelGroupeDAO() {
		return new PersonnelGroupeJdbcDAO();
	}

}
