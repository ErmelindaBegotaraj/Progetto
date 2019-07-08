package main.javaoop.model;

import java.io.Serializable;

public class Erasmus implements Serializable { //Serializable permette di salvare gli oggetti su file
	private String HomeInstitution,Country,Nationality,LevelStudy,HostInstitution,CountryCodeOfHostInstitution,PlacementEnterprise,CountryOfPlacement,StudyStartDate,PlacementStartDate,ConsortiumAgreementNumber,LanguageTaught,LIngPreparation;
	
	private char Gender,MobilityType,EnterpriseSize,TypePlacementSector,ShortDuration,TaughtHostLang,PreviousParticipation,QualificationAtHost;
	
	private int Age,SubjectArea,YearsPrior,EctsCreditsStudy,EctsCreditsPlacement,TotalEcts,SnSupplement,StudyGrant;
	
	private double LengthStudyPeriod,LengthPlacement,PlacementGrant;
	
	//Costruttore della classe

	public Erasmus(String homeInstitution, String country, String nationality, String levelStudy,
			String hostInstitution, String countryCodeOfHostInstitution, String placementEnterprise,
			String countryOfPlacement, String studyStartDate, String placementStartDate,
			String consortiumAgreementNumber, String languageTaught, String lIngPreparation, char gender,
			char mobilityType, char enterpriseSize, char typePlacementSector, char shortDuration, char taughtHostLang,
			char previousParticipation, char qualificationAtHost, int age, int subjectArea, int yearsPrior,
			int ectsCreditsStudy, int ectsCreditsPlacement, int totalEcts, int snSupplement, int studyGrant,
			double lengthStudyPeriod, double lengthPlacement, double placementGrant) {
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
		this.LIngPreparation = lIngPreparation;
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

	public String getLIngPreparation() {
		return LIngPreparation;
	}

	public char getGender() {
		return Gender;
	}

	public char getMobilityType() {
		return MobilityType;
	}

	public char getEnterpriseSize() {
		return EnterpriseSize;
	}

	public char getTypePlacementSector() {
		return TypePlacementSector;
	}

	public char getShortDuration() {
		return ShortDuration;
	}

	public char getTaughtHostLang() {
		return TaughtHostLang;
	}

	public char getPreviousParticipation() {
		return PreviousParticipation;
	}

	public char getQualificationAtHost() {
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

	public int getSnSupplement() {
		return SnSupplement;
	}

	public int getStudyGrant() {
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
	
	
@Override
public String toString() {
	return "Erasmus [HomeInstitution=" + HomeInstitution + ", Country=" + Country + ", Nationality=" + Nationality
			+ ", LevelStudy=" + LevelStudy + ", HostInstitution=" + HostInstitution
			+ ", CountryCodeOfHostInstitution=" + CountryCodeOfHostInstitution + ", PlacementEnterprise="
			+ PlacementEnterprise + ", CountryOfPlacement=" + CountryOfPlacement + ", StudyStartDate="
			+ StudyStartDate + ", PlacementStartDate=" + PlacementStartDate + ", ConsortiumAgreementNumber="
			+ ConsortiumAgreementNumber + ", LanguageTaught=" + LanguageTaught + ", LIngPreparation="
			+ LIngPreparation + ", Gender=" + Gender + ", MobilityType=" + MobilityType + ", EnterpriseSize="
			+ EnterpriseSize + ", TypePlacementSector=" + TypePlacementSector + ", ShortDuration=" + ShortDuration
			+ ", TaughtHostLang=" + TaughtHostLang + ", PreviousParticipation=" + PreviousParticipation
			+ ", QualificationAtHost=" + QualificationAtHost + ", Age=" + Age + ", SubjectArea=" + SubjectArea
			+ ", YearsPrior=" + YearsPrior + ", EctsCreditsStudy=" + EctsCreditsStudy + ", EctsCreditsPlacement="
			+ EctsCreditsPlacement + ", TotalEcts=" + TotalEcts + ", SnSupplement=" + SnSupplement + ", StudyGrant="
			+ StudyGrant + ", LengthStudyPeriod=" + LengthStudyPeriod + ", LengthPlacement=" + LengthPlacement
			+ ", PlacementGrant=" + PlacementGrant + "]";
	}
	
}
