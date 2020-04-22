package uvsq21921358;

public class PersonnelSerialDAO  extends SerialDAO<PersonnelImuable> {

	//
	public String getFilename(String id) {
		return id + ".personnelImuable";
	}

	public String getFilename(PersonnelImuable objet) {
		return getFilename(objet.getNom());

	}

	
	/*@Override
	public Personnel create(Personnel obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Personnel read(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Personnel update(Personnel obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Personnel obj) {
		// TODO Auto-generated method stub

	}*/

}
