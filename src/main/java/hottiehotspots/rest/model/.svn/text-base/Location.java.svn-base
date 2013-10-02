package hottiehotspots.rest.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.annotations.Cascade;

// TODO change to be unique by - if event - by date/time stamp
@Entity
@Table(name="LOCATION",
	uniqueConstraints = {@UniqueConstraint(columnNames={"name", "address1", "address2",
			"country","state","city","type"})})
@XmlRootElement(name = "location")
public class Location implements Serializable {

	private static final long serialVersionUID = -5190981410466012821L;

	@Id
	@GeneratedValue
    @Column(name="location_id", updatable=false)
    private Integer locationId;
	
	@OneToOne
	@Cascade(org.hibernate.annotations.CascadeType.ALL)
    @JoinColumn(name="hotspot_id")
    private Hotspot hotspot;
	
	@ManyToOne(cascade = {CascadeType.MERGE}, fetch = FetchType.EAGER, optional=false)
	private GEOCities area;
	
	//creates a table LOCATION_LABELS that maps Locations to Labels and vice versa
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinTable(name = "LOCATION_LABELS", joinColumns = 
    			{ @JoinColumn(name = "location_id") }, 
    			inverseJoinColumns = { @JoinColumn(name = "label_id") })
	private Set<Label> labels = new HashSet<Label>(0);
	
	@Column(name="name")
    private String name;
	
	@Column(name="address1", nullable=false,length=100)
    private String address1;
	
	@Column(name="type", nullable=false)
    private String type;
	    
	@Column(name="address2",length=100)
    private String address2;
    
	@Column(name="address3",length=100)
	private String address3;
    
	@Column(name="phone",length=30)
    private String phone;
	
	@Column(name="city", nullable=false,length=100)
    private String city;
	
	@Column(name="country", nullable=false,length=70)
    private String country;
	
	@Column(name="county", length=70)
    private String county;
	
	@Column(name="postalCode",length=30)
    private String postalCode;
	
	@Column(name="state", nullable=false,length=100)
    private String state;
	
	@Column(name="latitude")
	private String latitude;
	
	@Column(name="longitude")
	private String longitude;
	
	@Column(name="url")
    private String url;
	
	@Column(name="eventDate")
    private Date eventDate;
	
	@Column(name="createdDate", nullable=false,updatable=false)
    private Date createdDate;

	@Column(name="description")
	private String description;
	
	public String toString()
	{
		return new ToStringBuilder(this)
		.append("Location Id", this.getLocationId())
		.append("Name", this.getName())
		.append("HotSpot", this.getHotspot())
		.append("Area", this.getArea())
		.append("Address 1", this.getAddress1())
		.append("Address 2", this.getAddress2())
		.append("Address 3", this.getAddress3())
		.append("City", this.getCity())
		.append("Postal Code", this.getPostalCode())
		.append("State", this.getState())
		.append("County", this.getCounty())
		.append("Country", this.getCountry())
		.append("Phone", this.getPhone())
		.append("Type", this.getType())
		.append("Latitude", this.getLatitude())
		.append("Longitude", this.getLongitude())
		.append("URL", this.getUrl())
		.append("Description", this.getDescription())
		.append("Event Date", this.getEventDate())
		.append("Created Date", this.getCreatedDate())
		.toString();
	}

	public boolean equals(Object other)
	{
		if(!(other instanceof Location))
			return false;
		if(this == other)
			return true;
		
		final Location a = (Location)other;
		
		return new EqualsBuilder()
			.append(this.getLocationId(), a.getLocationId())
			.append(this.getAddress1(), a.getAddress1())
			.append(this.getCity(), a.getCity())
			.append(this.getCountry(), a.getCountry())
			.append(this.getName(), a.getName())
			.append(this.getPostalCode(), a.getPostalCode())
			.append(this.getType(), a.getType())
			.isEquals();
	}
	
	public int hashCode()
	{
		return new HashCodeBuilder()
		.append(this.getLocationId())
		.append(this.getAddress1())
		.append(this.getCity())
		.append(this.getCountry())
		.append(this.getName())
		.append(this.getPostalCode())
		.append(this.getType())
		.toHashCode();
	}

	
	public void setLocationId(Integer locationId) {
		this.locationId = locationId;
	}

    @XmlElement
	public Integer getLocationId() {
		return locationId;
	}

    @XmlElement
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

    @XmlElement
	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

    @XmlElement
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public void setCity(String city) {
		this.city = city;
	}

    @XmlElement
	public String getCity() {
		return city;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}

    @XmlElement
	public String getCountry() {
		return country;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

    @XmlElement
	public String getPostalCode() {
		return postalCode;
	}
    
    @XmlElement
	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

    @XmlElement
	public String getAddress3() {
		return address3;
	}

	public void setAddress3(String address3) {
		this.address3 = address3;
	}

    @XmlElement
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

    @XmlElement
	public Date getEventDate() {
		return eventDate;
	}

	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

    @XmlElement
	public String getPhone() {
		return phone;
	}

	public void setState(String state) {
		this.state = state;
	}

    @XmlElement
	public String getState() {
		return state;
	}

	public void setCounty(String county) {
		this.county = county;
	}

    @XmlElement
	public String getCounty() {
		return county;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

    @XmlElement
	public String getLatitude() {
		return latitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

    @XmlElement
	public String getLongitude() {
		return longitude;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

    @XmlElement
	public Date getCreatedDate() {
		return createdDate;
	}

	public void setHotspot(Hotspot hotspot) {
		this.hotspot = hotspot;
	}

    @XmlElement
	public Hotspot getHotspot() {
		return hotspot;
	}

	public void setArea(GEOCities area) {
		this.area = area;
	}

    @XmlElement
	public GEOCities getArea() {
		return area;
	}

	public void setDescription(String description) {
		this.description = description;
	}

    @XmlElement
	public String getDescription() {
		return description;
	}

	public void setLabels(Set<Label> labels) {
		this.labels = labels;
	}

    @XmlElement
	public Set<Label> getLabels() {
		return labels;
	}

}
