package uvsq21921358;

import org.junit.Before;
import org.junit.Test;

public class JDBCTest {
	
	private PersonnelImuable personn;
	private PersonnelGroupe personngroup;

	@Before()
	public void init() {
		personn = new PersonnelImuable.Builder("KI","SERGE").dateNaiss(1992,03,18).numT(new NumTelephone("70110203","64567890","5345676788")).build();
		personngroup = new PersonnelGroupe();
		PersonnelGroupe group = new PersonnelGroupe();
		personngroup.addPersonnel(group);
		personngroup.addPersonnel(personn);
	}
	
	@Test()
	public void createT() {
		
	}
	
}
