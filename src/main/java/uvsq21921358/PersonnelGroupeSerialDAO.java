package uvsq21921358;

public class PersonnelGroupeSerialDAO extends SerialDAO<PersonnelGroupe> {

	//
	public String getFilename(String id) {
		return id + ".pg";
	}

	public String getFilename(PersonnelGroupe objet) {
		return getFilename(objet.getId());
	}
}


