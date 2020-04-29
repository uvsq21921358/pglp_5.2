package uvsq21921358;

public class DAOFactory extends ADAOFactory {
	/**
	 * Fabrique d'instanciation dao
	 */
	public DAO<PersonnelImuable> getPersonnelDAO(){
		return new PersonnelSerialDAO();
	}
	public DAO<PersonnelGroupe> getPersonnelGroupeDAO(){
		return new PersonnelGroupeSerialDAO();
	}
}
