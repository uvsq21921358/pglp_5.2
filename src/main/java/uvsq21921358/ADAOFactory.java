package uvsq21921358;

public abstract class ADAOFactory {
 
	//Ajout de JDBC
	public enum DAOType {JDBC, Serial};
	public abstract DAO<PersonnelImuable> getPersonnelDAO();
	public abstract DAO<PersonnelGroupe> getPersonnelGroupeDAO();

	public static ADAOFactory getFactory(DAOType type) {
		if (type == DAOType.JDBC) return new JDAOFactory();
		if (type == DAOType.Serial) return new DAOFactory();
		return null;
	}
}
