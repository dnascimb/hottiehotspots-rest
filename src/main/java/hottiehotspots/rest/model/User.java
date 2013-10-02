package hottiehotspots.rest.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
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
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang3.builder.ToStringBuilder;

@Entity
@Table(name="USER")
@XmlRootElement(name = "user")
public class User implements Serializable {
   
	//TODO Add ability for users to store username from other services (facebook/twitter)
	
	private static final long serialVersionUID = -5325373806394946357L;
	
	@Id
    @GeneratedValue
    @Column(name="id", updatable=false)
    private Integer id;
	
	@Column(name="last_name")
    private String lastName;
	
	@Column(name="first_name")
    private String firstName;
	
	@Column(name="user_name")
    private String userName;
    
	@Column(name="password", nullable=false)
	private String password;
    
	@Column(name="email", nullable=false)
    private String email;
	
	@Column(name="birthday")
    private Date birthday;
	
	@Column(name="gender")
    private String gender;
    
	@Column(name="sexuality")
    private String sexuality;
	
	@Column(name="country")
	private String country;
	
	//creates a table USER_INTERESTS that maps Users to Interests and vice versa
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinTable(name = "USER_INTERESTS", joinColumns = 
    			{ @JoinColumn(name = "id") }, 
    			inverseJoinColumns = { @JoinColumn(name = "interest_id") })
	private Set<Interest> interests = new HashSet<Interest>(0);
	
	@Column(name="relationship_status")
	private String relationshipStatus;

	@Column(name="education")
	private String education;
	
	@Column(name="income")
	private String income;

	@Column(name="languages")
	private String[] languages;

	@Column(name="ethnicity")
	private String ethnicity;

	@ManyToOne(fetch = FetchType.EAGER, optional=true)
	private GEOCities defaultCity;
	
    @XmlElement
    public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

    @XmlElement
	public String getRelationshipStatus() {
		return relationshipStatus;
	}

	public void setRelationshipStatus(String relationshipStatus) {
		this.relationshipStatus = relationshipStatus;
	}

	public void setEducation(String education) {
		this.education = education;
	}

    @XmlElement
	public String getEducation() {
		return education;
	}

    @XmlElement
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

    @XmlElement
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

    @XmlElement
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

    @XmlElement
	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

    @XmlElement
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

    @XmlElement
	public String getSexuality() {
		return sexuality;
	}

	public void setSexuality(String sexuality) {
		this.sexuality = sexuality;
	}

    @XmlElement
	public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @XmlElement
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @XmlElement
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

	public void setIncome(String income) {
		this.income = income;
	}

    @XmlElement
	public String getIncome() {
		return income;
	}

	public void setLanguages(String[] languages) {
		this.languages = languages;
	}

    @XmlElement
	public String[] getLanguages() {
		return languages;
	}

	public void setEthnicity(String ethnicity) {
		this.ethnicity = ethnicity;
	}

    @XmlElement
	public String getEthnicity() {
		return ethnicity;
	}
	
	public String toString()
	{
		return new ToStringBuilder(this)
		.append("User Id", this.getId())
		.append("UserName", this.getUserName())
		.append("First Name", this.getFirstName())
		.append("Last Name", this.getLastName())
		.append("Password", this.getPassword())
		.append("Email", this.getEmail())
		.append("Birthday", this.getBirthday())
		.append("Gender", this.getGender())
		.append("Sexuality", this.getSexuality())
		.append("Country", this.getCountry())
		.append("Interests", this.getInterests())
		.append("Relationship Status", this.getRelationshipStatus())
		.append("Education", this.getEducation())
		.append("Income", this.getIncome())
		.append("Languages", this.getLanguages())
		.append("Ethnicity", this.getEthnicity())
		.append("Default User City", this.getDefaultCity())
		.toString();
	}
	
	public void setInterests(Set<Interest> interests) {
		this.interests = interests;
	}

    @XmlElement
	public Set<Interest> getInterests() {
		return interests;
	}

	public void setDefaultCity(GEOCities defaultCity) {
		this.defaultCity = defaultCity;
	}

    @XmlElement
	public GEOCities getDefaultCity() {
		return defaultCity;
	}
}
