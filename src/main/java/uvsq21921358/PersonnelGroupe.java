package uvsq21921358;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PersonnelGroupe extends Personnel{
	/**
	 * Classe de GRoupe
	 */
	private static final long serialVersionUID = 1L;
	private final List<Personnel> personnelList;
	private UUID id;
	
	public PersonnelGroupe(){
		personnelList = new ArrayList<Personnel>();
		id = UUID.randomUUID();
	}
	
	public PersonnelGroupe(String id){
		personnelList = new ArrayList<Personnel>();
		this.id = UUID.fromString(id);
	}
	public void addPersonnel(Personnel p){
		personnelList.add(p);
	}
	public List<Personnel> getAllPersonnel(){
		return personnelList;
	}
	
	public String getId() {
		return id.toString();
	}
	@Override
	public boolean isGroupe(){
		return false;
	}
	public String toString(){
		return "PersonnelGroupe [personnelList=" + personnelList + ", id=" + id + "]";
	}
}
