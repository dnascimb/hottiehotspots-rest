package hottiehotspots.rest.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;

@Entity
@Table(name="HOTSPOT_RATING")
public class HotspotRating implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5037204213138370928L;
	
	
	@Id
    @GeneratedValue
    @Column(name="hotspotRating_id", updatable=false)
    private Integer hotspotRatingId;
	
	@Column(name="time_date_stamp", nullable=false)
	private Date timeDateStamp;
	
	@Column(name="comment")
	private String comment;
	
	@Column(name="rating", nullable=false)
	private Double rating;
	
	// didn't make this a reference to the entry on USER table to keep it simple if a user 
	// deletes there account and we don't want to affect the Hotspot
	@Column(name="originallyTaggedBy", updatable=false)
	private String ratedBy;

	public Date getTimeDateStamp() {
		return timeDateStamp;
	}

	public void setTimeDateStamp(Date timeDateStamp) {
		this.timeDateStamp = timeDateStamp;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public void setHotspotRatingId(Integer hotspotRatingId) {
		this.hotspotRatingId = hotspotRatingId;
	}

	public Integer getHotspotRatingId() {
		return hotspotRatingId;
	}
	
	public String toString()
	{
		return new ToStringBuilder(this)
		.append("Hotspot Rating Id", this.getHotspotRatingId())
		.append("Hotspot Rating Time Date Stamp", this.getTimeDateStamp())
		.append("Hotspot Rating - Rating", this.getRating())
		.append("Hotspot Rating Comment", this.getComment())
		.toString();
	}

	public void setRatedBy(String ratedBy) {
		this.ratedBy = ratedBy;
	}

	public String getRatedBy() {
		return ratedBy;
	}

}
