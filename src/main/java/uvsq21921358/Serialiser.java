package uvsq21921358;

import uvsq21921358.ADAOFactory.DAOType;

public enum Serialiser{
	/**
	 * Enumeration
	 */
	ENVIRONNEMENT;
	private void run(String[] args, DAOType dt){
		DAO<PersonnelImuable> personnelDAO = ADAOFactory.getFactory(dt).getPersonnelDAO();
		DAO<PersonnelGroupe> pgDAO = ADAOFactory.getFactory(dt).getPersonnelGroupeDAO();
				// Creation personnel
				PersonnelImuable Marie = new PersonnelImuable.Builder("Marie", "Popins").build();
				PersonnelImuable  Ki = new PersonnelImuable.Builder("Ki", "Arnold").build();
				PersonnelGroupe pg = new PersonnelGroupe();
				PersonnelGroupe spg = new PersonnelGroupe();
				pg.addPersonnel(spg);
				pg.addPersonnel(Marie);
				spg.addPersonnel(Ki);
				// Ajout DAO
				pgDAO.create(pg);
				pgDAO.create(spg);
				personnelDAO.create(Marie); // update
				personnelDAO.create(Ki); // update
				System.out.println("\t" + pgDAO.read(spg.getId()));
				System.out.println("\t" + personnelDAO.read("Ki"));
	}
	
	public static void main(String[] args){
		
		JdbcInit ji = new JdbcInit();
		ji.dropCreate();
		// ENVIRONNEMENT.run(args, DAOType.Serial);
		ENVIRONNEMENT.run(args, DAOType.JDBC);
	}
}
