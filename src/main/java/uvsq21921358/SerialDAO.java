package uvsq21921358;

import java.io.Serializable;
/**
 *Impléméntation DAO
 */
public abstract class SerialDAO <T extends Serializable> extends Serial<T> implements DAO<T>{
	private Login log = new Login();
	public abstract String getFilename(String id);	
	public abstract String getFilename(T objet);
	
	public T create(T objet){
		return createFile(objet, getFilename(objet), log);
	}
	public T read(String id){
		return readFile(getFilename(id), log);
	}
	public T update(T objet){
		return updateFile(objet, getFilename(objet), log);
	}
	public void delete(T objet){
		deleteFile(getFilename(objet), log);
	}
}
