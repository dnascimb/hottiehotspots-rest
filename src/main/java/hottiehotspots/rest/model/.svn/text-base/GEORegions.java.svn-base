package hottiehotspots.rest.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="GEORegions")
public class GEORegions implements Serializable {
  	
	private static final long serialVersionUID = -8116665608844279500L;

	@Id
	@GeneratedValue
    @Column(name="RegionID", updatable=false, nullable=false)
    private Integer regionId;
	
	@ManyToOne(cascade = {CascadeType.MERGE}, fetch = FetchType.EAGER)
    private GEOCountries countryId;

	@Column(name="Region", updatable=false,nullable=false,length=45)
	private String region;
	
	@Column(name="Code", updatable=false,nullable=false,length=8)
	private String code;
	
	@Column(name="ADM1Code", updatable=false,nullable=false,length=4)
    private String ADM1Code;

	public Integer getRegionId() {
		return regionId;
	}

	public void setRegionId(Integer regionId) {
		this.regionId = regionId;
	}

	public GEOCountries getCountryId() {
		return countryId;
	}

	public void setCountryId(GEOCountries countryId) {
		this.countryId = countryId;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getADM1Code() {
		return ADM1Code;
	}

	public void setADM1Code(String aDM1Code) {
		ADM1Code = aDM1Code;
	}

	public GEORegions() {
		
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

