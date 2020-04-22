package uvsq21921358;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//import uvsq21921358.PersonnelImuable.Builder;

public final class PersonnelImuable extends Personnel{

	/**
	 * classe de création de base
	 */
	private static final long serialVersionUID = 1L;

	private final String nom;
	private final String prenom;
	
	private final LocalDate dateNaiss;
	private  List<NumTelephone> numT ;
	
	
	public static class Builder{
		
		//PARAMETRE OBLIGATOIRE
		private final String nom;
		private final String prenom;
		
		//PARAMETRE OPTIONNEL	
		private LocalDate dateNaiss = LocalDate.of (1997, 06, 15);
		private  ArrayList<NumTelephone> numT = new ArrayList<NumTelephone>();
		
		
		public Builder (String nom,String prenom) {
			this.nom=nom;
			this.prenom=prenom;
		}
		
		public Builder dateNaiss(int annee, int mois,int jour) {
			this.dateNaiss= LocalDate.of(annee, mois, jour);
			return this;
		}
		
		public Builder numT(NumTelephone numT) {
			this.numT.add(numT);
			return this;
			
		}
		
		public PersonnelImuable build() {
			return new PersonnelImuable(this);
			
		}
	}
	
	private PersonnelImuable(Builder build) {
		
		nom=build.nom;
		prenom=build.prenom;
		
		dateNaiss=build.dateNaiss;
		numT=build.numT;
		
	}
	
	public String toString() {
		return nom + " " + prenom + " " + " "+ dateNaissanceString()+numT.stream().map(NumTelephone::toString).collect(Collectors.toList());
	}
	
	private String dateNaissanceString() {
		if (dateNaiss == null) return ""; 
		return (dateNaiss.format(DateTimeFormatter.ISO_DATE) + " ");
	}
	
	/**
	 * @return the nom
	 */

	public String getNom() {
		return nom;
	}


	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}
	
	/**

	 * @return the dateNaiss

	 */

	public LocalDate getDateNaissance() {
		return dateNaiss;
	}


	/**
	 * @return the NumTelephone
	 */

	public List<NumTelephone> getNumTelephone() {
		return numT;
	}
	
	public void addNumTelephone(NumTelephone numTe) {
		this.numT.add(numTe);
	}
	
	@Override
	public boolean isGroupe() {
		return false;
	}

}
