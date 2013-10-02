package hottiehotspots.rest.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;

@Entity
@Table(name="INTEREST")
public class Interest implements Serializable {


	private static final long serialVersionUID = 5440775645919296789L;

	@Id
	@GeneratedValue
    @Column(name="interest_id", updatable=false)
    private Integer interestId;
	
	@Column(name="label", nullable=false, length=30, updatable=false)
	private String label;
	
	public String toString()
	{
		return new ToStringBuilder(this)
		.append("Interest Id", this.getInterestId())
		.append("Label", this.getLabel())
		.toString();
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

	public void setInterestId(Integer interestId) {
		this.interestId = interestId;
	}

	public Integer getInterestId() {
		return interestId;
	}



}
