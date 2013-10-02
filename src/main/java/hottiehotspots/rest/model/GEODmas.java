package hottiehotspots.rest.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="GEODmas")
public class GEODmas implements Serializable {
 
	private static final long serialVersionUID = -1845085158451305810L;

	@Id
    @Column(name="DmaId", updatable=false, nullable=false)
    private Integer dmaId;
	
	@Column(name="CountryId", updatable=false,nullable=true)
    private Integer countryId;

	@Column(name="DMA", updatable=false,nullable=true,length=3)
	private String DMA;
	
	@Column(name="Market", updatable=false,nullable=true,length=50)
	private String market;
	
	public Integer getDmaId() {
		return dmaId;
	}

	public void setDmaId(Integer dmaId) {
		this.dmaId = dmaId;
	}

	public Integer getCountryId() {
		return countryId;
	}

	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}

	public String getDMA() {
		return DMA;
	}

	public void setDMA(String dMA) {
		DMA = dMA;
	}

	public String getMarket() {
		return market;
	}

	public void setMarket(String market) {
		this.market = market;
	}

	public GEODmas() {
		
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

