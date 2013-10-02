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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;

@Entity
@Table(name="HOTSPOT")
public class Hotspot implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3196837851397404635L;
	
	
    @Id
    @GeneratedValue
	@Column(name="hotspot_id", updatable=false)
	private Integer hotspotId;
	
	@Column(name="ups")
	private Integer ups;
	
	@Column(name="downs")
	private Integer downs;
	
	@Column(name="currentRating")
	private Double currentRating;
	
	@Column(name="timesRated")
	private Integer timesRated;
	
	// didn't make this a reference to the entry on USER table to keep it simple if a user 
	// deletes there account and we don't want to affect the Hotspot
	@Column(name="originallyTaggedBy", updatable=false)
	private String originallyTaggedBy;
	
	//creates a table HOTSPOT_LABELS that maps Hotspots to Labels and vice versa
	/*@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinTable(name = "HOTSPOT_LABELS", joinColumns = 
    			{ @JoinColumn(name = "hotspot_id") }, 
    			inverseJoinColumns = { @JoinColumn(name = "label_id") })
	private Set<Label> labels = new HashSet<Label>(0);
	*/
	
	//creates a table HOTSPOT_HOTSPOTRATINGS that maps Hotspots to HotspotRatings and vice versa
	@OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinTable(name = "HOTSPOT_HOTSPOTRATINGS", joinColumns = 
    			{ @JoinColumn(name = "hotspot_id") }, 
    			inverseJoinColumns = { @JoinColumn(name = "hotspotRating_id") })
	private Set<HotspotRating> ratings = new HashSet<HotspotRating>(0);
	
	@Column(name="originallyTaggedDate", updatable=false)
	private Date originallyTaggedDate;

	public Integer getUps() {
		return ups;
	}

	public void setUps(Integer ups) {
		this.ups = ups;
	}

	public Integer getDowns() {
		return downs;
	}

	public void setDowns(Integer downs) {
		this.downs = downs;
	}

	public Integer getTimesRated() {
		return timesRated;
	}

	public void setTimesRated(Integer timesRated) {
		this.timesRated = timesRated;
	}

	public String getOriginallyTaggedBy() {
		return originallyTaggedBy;
	}

	public void setOriginallyTaggedBy(String originallyTaggedBy) {
		this.originallyTaggedBy = originallyTaggedBy;
	}

	public Date getOriginallyTaggedDate() {
		return originallyTaggedDate;
	}

	public void setOriginallyTaggedDate(Date originallyTaggedDate) {
		this.originallyTaggedDate = originallyTaggedDate;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public void setHotspotId(Integer hotspotId) {
		this.hotspotId = hotspotId;
	}

	public Integer getHotspotId() {
		return hotspotId;
	}

	public void setCurrentRating(Double currentRating) {
		this.currentRating = currentRating;
	}

	public Double getCurrentRating() {
		return currentRating;
	}

/*	public void setLabels(Set<Label> labels) {
		this.labels = labels;
	}

	public Set<Label> getLabels() {
		return labels;
	}
*/
	public void setRatings(Set<HotspotRating> ratings) {
		this.ratings = ratings;
	}

	public Set<HotspotRating> getRatings() {
		return ratings;
	}

	public String toString()
	{
		return new ToStringBuilder(this)
		.append("Hotspot Id", this.getHotspotId())
		.append("Hotspot Ups", this.getUps())
		.append("Hotspot Downs", this.getDowns())
		.append("Hotspot Current Rating", this.getCurrentRating())
		.append("Hotspot Times Rated", this.getTimesRated())
		.append("Hotspot Originally Tagged By", this.getOriginallyTaggedBy())
		.append("Hotspot Originally Tagged Date", this.getOriginallyTaggedDate())
		//.append("Hotspot Labels", this.getLabels())
		.append("Hotspot Ratings", this.getRatings())
		.toString();
	}
}
