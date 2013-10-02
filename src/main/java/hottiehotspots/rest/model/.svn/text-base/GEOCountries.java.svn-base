package hottiehotspots.rest.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="GEOCountries")
public class GEOCountries implements Serializable {
  	
	private static final long serialVersionUID = -3669208497487097718L;

	@Id
	@GeneratedValue
    @Column(name="CountryId", updatable=false, nullable=false)
    private Integer countryId;

	@Column(name="Country", updatable=false,nullable=false,length=50)
	private String country;
	
	@Column(name="FIPS104", updatable=false,nullable=false,length=2)
	private String FIPS104;
	
	@Column(name="ISO2", updatable=false,nullable=false,length=2)
	private String ISO2;
	
	@Column(name="ISO3", updatable=false,nullable=false,length=3)
	private String ISO3;
	
	@Column(name="ISON", updatable=false,nullable=false,length=4)
	private String ISON;
	
	@Column(name="Internet", updatable=false,nullable=false,length=2)
	private String internet;
	
	@Column(name="Capital", updatable=false,nullable=true,length=25)
	private String capital;
	
	@Column(name="MapReference", updatable=false,nullable=true,length=50)
	private String mapReference;
	
	@Column(name="NationalitySingular", updatable=false,nullable=true,length=35)
	private String nationalitySingular;
	
	@Column(name="NationalityPlural", updatable=false,nullable=true,length=35)
	private String nationalityPlural;
	
	@Column(name="Currency", updatable=false,nullable=true,length=30)
	private String currency;
	
	@Column(name="CurrencyCode", updatable=false,nullable=true,length=3)
	private String currencyCode;
	
	@Column(name="Population", updatable=false, nullable=true)
    private Integer population;
	
	@Column(name="Title", updatable=false,nullable=true,length=50)
	private String title;
	
	@Column(name="Comment", updatable=false,nullable=true,length=255)
	private String comment;

	public GEOCountries() {
		
	}

	public Integer getCountryId() {
		return countryId;
	}

	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getFIPS104() {
		return FIPS104;
	}

	public void setFIPS104(String fIPS104) {
		FIPS104 = fIPS104;
	}

	public String getISO2() {
		return ISO2;
	}

	public void setISO2(String iSO2) {
		ISO2 = iSO2;
	}

	public String getISO3() {
		return ISO3;
	}

	public void setISO3(String iSO3) {
		ISO3 = iSO3;
	}

	public String getISON() {
		return ISON;
	}

	public void setISON(String iSON) {
		ISON = iSON;
	}

	public String getInternet() {
		return internet;
	}

	public void setInternet(String internet) {
		this.internet = internet;
	}

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	public String getMapReference() {
		return mapReference;
	}

	public void setMapReference(String mapReference) {
		this.mapReference = mapReference;
	}

	public String getNationalitySingular() {
		return nationalitySingular;
	}

	public void setNationalitySingular(String nationalitySingular) {
		this.nationalitySingular = nationalitySingular;
	}

	public String getNationalityPlural() {
		return nationalityPlural;
	}

	public void setNationalityPlural(String nationalityPlural) {
		this.nationalityPlural = nationalityPlural;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public Integer getPopulation() {
		return population;
	}

	public void setPopulation(Integer population) {
		this.population = population;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	
/*	public boolean equals(Object other)
	{
		if(!(other instanceof Area))
			return false;
		if(this == other)
			return true;
		
		final Area a = (Area)other;
		
		return new EqualsBuilder()
			.append(this.getCountry(), a.getCountry())
			.append(this.getCity(), a.getCity())
			.append(this.getPostalCode(), a.getPostalCode())
			.isEquals();
	}
	
	public String toString()
	{
		return new ToStringBuilder(this)
		.append("Area Id", this.getId())
		.append("City", this.getCity())
		.append("Postal Code", this.getPostalCode())
		.append("State", this.getState())
		.append("County", this.getCounty())
		.append("Country", this.getCountry())
		.append("Latitude", this.getLatitude())
		.append("Longitude", this.getLongitude())
		.toString();
	}
*/

}

