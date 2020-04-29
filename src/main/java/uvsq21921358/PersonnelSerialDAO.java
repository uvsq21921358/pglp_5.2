package uvsq21921358;

public class PersonnelSerialDAO  extends SerialDAO<PersonnelImuable>{
	/**
	 * Implementation DAO
	 */
	public String getFilename(String id){
		return id + ".personnelImuable";
	}
	public String getFilename(PersonnelImuable objet){
		return getFilename(objet.getNom());
	}
}
