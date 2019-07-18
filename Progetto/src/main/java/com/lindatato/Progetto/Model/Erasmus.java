package com.lindatato.Progetto.Model;

import java.io.Serializable;

/**
 * 
 * Classe che modella i campi del file CSV 
 *
 */
public class Erasmus implements Serializable { //Serializable permette di salvare gli oggetti su file
	private String HomeInstitution,Country,Nationality,LevelStudy,HostInstitution,CountryCodeOfHostInstitution,PlacementEnterprise,CountryOfPlacement,StudyStartDate,PlacementStartDate,ConsortiumAgreementNumber,LanguageTaught,LingPreparation,
					Gender,MobilityType,EnterpriseSize,TypePlacementSector,ShortDuration,TaughtHostLang,PreviousParticipation,QualificationAtHost;
	
	private int Age,SubjectArea,YearsPrior,EctsCreditsStudy,EctsCreditsPlacement,TotalEcts;
	
	private double LengthStudyPeriod,LengthPlacement,PlacementGrant,StudyGrant,SnSupplement;
	
	/**
	 * Costruttore della classe
	 * 
	 * @param homeInstitution
	 * @param country
	 * @param age
	 * @param gender
	 * @param nationality
	 * @param subjectArea
	 * @param levelStudy
	 * @param yearsPrior
	 * @param mobilityType
	 * @param hostInstitution
	 * @param countryCodeOfHostInstitution
	 * @param placementEnterprise
	 * @param countryOfPlacement
	 * @param enterpriseSize
	 * @param typePlacementSector
	 * @param lengthStudyPeriod
	 * @param lengthPlacement
	 * @param shortDuration
	 * @param studyStartDate
	 * @param placementStartDate
	 * @param consortiumAgreementNumber
	 * @param ectsCreditsStudy
	 * @param ectsCreditsPlacement
	 * @param totalEcts
	 * @param snSupplement
	 * @param taughtHostLang
	 * @param languageTaught
	 * @param lingPreparation
	 * @param studyGrant
	 * @param placementGrant
	 * @param previousParticipation
	 * @param qualificationAtHost
	 */

	public Erasmus(String homeInstitution, String country, int age, String gender, String nationality, int subjectArea, String levelStudy,
			int yearsPrior, String mobilityType, String hostInstitution, String countryCodeOfHostInstitution, String placementEnterprise,
			String countryOfPlacement, String enterpriseSize, String typePlacementSector,double lengthStudyPeriod, double lengthPlacement, String shortDuration, String studyStartDate, String placementStartDate,
			String consortiumAgreementNumber, int ectsCreditsStudy, int ectsCreditsPlacement, int totalEcts, double snSupplement, String taughtHostLang, String languageTaught, String lingPreparation,
			double studyGrant, double placementGrant, String previousParticipation,String qualificationAtHost) {
		
		this.HomeInstitution = homeInstitution;
		this.Country = country;
		this.Nationality = nationality;
		this.LevelStudy = levelStudy;
		this.HostInstitution = hostInstitution;
		this.CountryCodeOfHostInstitution = countryCodeOfHostInstitution;
		this.PlacementEnterprise = placementEnterprise;
		this.CountryOfPlacement = countryOfPlacement;
		this.StudyStartDate = studyStartDate;
		this.PlacementStartDate = placementStartDate;
		this.ConsortiumAgreementNumber = consortiumAgreementNumber;
		this.LanguageTaught = languageTaught;
		this.LingPreparation = lingPreparation;
		this.Gender = gender;
		this.MobilityType = mobilityType;
		this.EnterpriseSize = enterpriseSize;
		this.TypePlacementSector = typePlacementSector;
		this.ShortDuration = shortDuration;
		this.TaughtHostLang = taughtHostLang;
		this.PreviousParticipation = previousParticipation;
		this.QualificationAtHost = qualificationAtHost;
		this.Age = age;
		this.SubjectArea = subjectArea;
		this.YearsPrior = yearsPrior;
		this.EctsCreditsStudy = ectsCreditsStudy;
		this.EctsCreditsPlacement = ectsCreditsPlacement;
		this.TotalEcts = totalEcts;
		this.SnSupplement = snSupplement;
		this.StudyGrant = studyGrant;
		this.LengthStudyPeriod = lengthStudyPeriod;
		this.LengthPlacement = lengthPlacement;
		this.PlacementGrant = placementGrant;
	}
	
	//implementazione getters
	
	public String getHomeInstitution() {
		return HomeInstitution;
	}

	public String getCountry() {
		return Country;
	}

	public String getNationality() {
		return Nationality;
	}

	public String getLevelStudy() {
		return LevelStudy;
	}

	public String getHostInstitution() {
		return HostInstitution;
	}

	public String getCountryCodeOfHostInstitution() {
		return CountryCodeOfHostInstitution;
	}

	public String getPlacementEnterprise() {
		return PlacementEnterprise;
	}
	
	public String getCountryOfPlacement() {
		return CountryOfPlacement;
	}
	
	public String getStudyStartDate() {
		return StudyStartDate;
	}

	public String getPlacementStartDate() {
		return PlacementStartDate;
	}

	public String getConsortiumAgreementNumber() {
		return ConsortiumAgreementNumber;
	}

	public String getLanguageTaught() {
		return LanguageTaught;
	}

	public String getLingPreparation() {
		return LingPreparation;
	}

	public String getGender() {
		return Gender;
	}

	public String getMobilityType() {
		return MobilityType;
	}

	public String getEnterpriseSize() {
		return EnterpriseSize;
	}

	public String getTypePlacementSector() {
		return TypePlacementSector;
	}

	public String getShortDuration() {
		return ShortDuration;
	}

	public String getTaughtHostLang() {
		return TaughtHostLang;
	}

	public String getPreviousParticipation() {
		return PreviousParticipation;
	}

	public String getQualificationAtHost() {
		return QualificationAtHost;
	}

	public int getAge() {
		return Age;
	}

	public int getSubjectArea() {
		return SubjectArea;
	}

	public int getYearsPrior() {
		return YearsPrior;
	}

	public int getEctsCreditsStudy() {
		return EctsCreditsStudy;
	}
	
	public int getEctsCreditsPlacement() {
		return EctsCreditsPlacement;
	}

	public int getTotalEcts() {
		return TotalEcts;
	}

	public double getSnSupplement() {
		return SnSupplement;
	}

	public double getStudyGrant() {
		return StudyGrant;
	}

	public double getLengthStudyPeriod() {
		return LengthStudyPeriod;
	}

	public double getLengthPlacement() {
		return LengthPlacement;
	}

	public double getPlacementGrant() {
		return PlacementGrant;
	}
	
	/**
	 * Metodo toString usato per la stampa dell'oggetto
	 * 
	 * @return Restituisce una stringa contenente il valore dei campi concatenati
	 */
@Override
public String toString() {
	return "Erasmus [HomeInstitution=" + HomeInstitution + ", Country=" + Country + ", Nationality=" + Nationality
			+ ", LevelStudy=" + LevelStudy + ", HostInstitution=" + HostInstitution
			+ ", CountryCodeOfHostInstitution=" + CountryCodeOfHostInstitution + ", PlacementEnterprise="
			+ PlacementEnterprise + ", CountryOfPlacement=" + CountryOfPlacement + ", StudyStartDate="
			+ StudyStartDate + ", PlacementStartDate=" + PlacementStartDate + ", ConsortiumAgreementNumber="
			+ ConsortiumAgreementNumber + ", LanguageTaught=" + LanguageTaught + ", LIngPreparation="
			+ LingPreparation + ", Gender=" + Gender + ", MobilityType=" + MobilityType + ", EnterpriseSize="
			+ EnterpriseSize + ", TypePlacementSector=" + TypePlacementSector + ", ShortDuration=" + ShortDuration
			+ ", TaughtHostLang=" + TaughtHostLang + ", PreviousParticipation=" + PreviousParticipation
			+ ", QualificationAtHost=" + QualificationAtHost + ", Age=" + Age + ", SubjectArea=" + SubjectArea
			+ ", YearsPrior=" + YearsPrior + ", EctsCreditsStudy=" + EctsCreditsStudy + ", EctsCreditsPlacement="
			+ EctsCreditsPlacement + ", TotalEcts=" + TotalEcts + ", SnSupplement=" + SnSupplement + ", StudyGrant="
			+ StudyGrant + ", LengthStudyPeriod=" + LengthStudyPeriod + ", LengthPlacement=" + LengthPlacement
			+ ", PlacementGrant=" + PlacementGrant + "]";
	}
	
}
