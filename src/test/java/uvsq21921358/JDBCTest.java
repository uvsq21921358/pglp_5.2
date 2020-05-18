package uvsq21921358;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import uvsq21921358.ADAOFactory.DAOType;
/**
 * Ma classe de testt
 */
public class JDBCTest{
	
	private PersonnelImuable personn;
	private PersonnelImuable personn1;
	private PersonnelImuable personn2;
	private PersonnelGroupe personngroup;
	private JdbcInit connexion;

	@Before()
	public void initjdbcTest(){
		personn = new PersonnelImuable.Builder("KI","SERGE").dateNaiss(1992,03,18).numT(new NumTelephone("70110203","64567890","5345676788")).build();
		personn1 = new PersonnelImuable.Builder("KI","ARNOLD").dateNaiss(1997,02,12).numT(new NumTelephone("71110203","44567890","6345676788")).build();
		personn2 = new PersonnelImuable.Builder("SIMP","NAYI").dateNaiss(1997,06,15).numT(new NumTelephone("73374028","55464768","6345656678")).build();
		personngroup = new PersonnelGroupe();
		PersonnelGroupe group = new PersonnelGroupe();
		personngroup.addPersonnel(group);
		personngroup.addPersonnel(personn);
		
	}
	
	@Test()
	public void createConnexion(){
		connexion=new JdbcInit();
	}
	
	@Test()
	public void createTable(){
		connexion=new JdbcInit();
		connexion.createTables();
	}
	
	@Test()
	public void dropTable(){
		connexion=new JdbcInit();
		connexion.dropCreate();
	}
	
	/*@Test()
	public void PersonnelJdbcTest() {
		connexion=new JdbcInit();
		DAO<PersonnelImuable> ajout =ADAOFactory.getFactory(DAOType.JDBC).getPersonnelDAO();
		//ajout.delete(personn);
		//ajout.create(personn); 
		//ajout.read("KI");
		//ajout.update(personn1);
		//assertEquals(personn1, ajout.read(personn1.getNom()));
	}
	
	@Test()
	public void PersonneGrouplJdbcTest() {
		DAO<PersonnelGroupe> PGJT = ADAOFactory.getFactory(DAOType.JDBC).getPersonnelGroupeDAO();
		PGJT.delete(personngroup);
		PGJT.create(personngroup);
		PGJT.read("KI");
		personngroup.addPersonnel(personn2);
		PGJT.update(personngroup);
		assertEquals(personngroup, PGJT.read(personngroup.getId()));
	}*/
	
}
