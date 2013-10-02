package hottiehotspots.rest.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="GEOCities")
public class GEOCities implements Serializable {
  	
	private static final long serialVersionUID = 6734370576210610614L;

	@Id
	@GeneratedValue
    @Column(name="CityId", updatable=false, nullable=false)
    private Integer cityId;
	
	@ManyToOne(cascade = {CascadeType.MERGE}, fetch = FetchType.EAGER)
	@JoinColumn(name="CountryID")
	//@Column(name="CountryID", updatable=false,nullable=false)
    private GEOCountries countryId;

	@ManyToOne(cascade = {CascadeType.MERGE}, fetch = FetchType.EAGER)
	@JoinColumn(name="RegionID")
	//@Column(name="RegionID", updatable=false,nullable=false)
	private GEORegions regionId;
	
	@Column(name="City", updatable=false,nullable=false,length=45)
	private String city;

	@Column(name="Latitude", updatable=false,nullable=false)
	private Float latitude;
	
	@Column(name="Longitude", updatable=false,nullable=false)
	private Float longitude;
	
	@Column(name="TimeZone", updatable=false,nullable=false,length=10)
	private String timezone;
	
	@Column(name="DmaId", updatable=false,nullable=true)
    private Integer dmaId;
	
	@Column(name="County", updatable=false,nullable=true,length=25)
	private String county;
	
	@Column(name="Code", updatable=false,nullable=true,length=4)
	private String code;
	
	public GEOCities() {
		
	}

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public GEOCountries getCountryId() {
		return countryId;
	}

	public void setCountryId(GEOCountries countryId) {
		this.countryId = countryId;
	}

	public GEORegions getRegionId() {
		return regionId;
	}

	public void setRegionId(GEORegions regionId) {
		this.regionId = regionId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Float getLatitude() {
		return latitude;
	}

	public void setLatitude(Float latitude) {
		this.latitude = latitude;
	}

	public Float getLongitude() {
		return longitude;
	}

	public void setLongitude(Float longitude) {
		this.longitude = longitude;
	}

	public String getTimezone() {
		return timezone;
	}

	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}

	public Integer getDmaId() {
		return dmaId;
	}

	public void setDmaId(Integer dmaId) {
		this.dmaId = dmaId;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
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

