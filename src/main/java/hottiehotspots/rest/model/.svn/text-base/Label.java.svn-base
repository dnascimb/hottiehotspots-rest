package hottiehotspots.rest.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


import org.apache.commons.lang3.builder.ToStringBuilder;


@Entity
@Table(name="LABEL",
	uniqueConstraints = {@UniqueConstraint(columnNames={"label"})})
public class Label implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8099759397746379301L;

	@Id
	@GeneratedValue
    @Column(name="label_id", updatable=false)
    private Integer labelId;
	
	@Column(name="label", nullable=false, length=30, updatable=false)
	private String label;
	
	public Label()
	{
		
	}
	
	public Label(String label)
	{
		this.label = label;
	}
	
	public String toString()
	{
		return new ToStringBuilder(this)
		.append("Label Id", this.getLabelId())
		.append("Label", this.getLabel())
		.toString();
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

	public void setLabelId(Integer labelId) {
		this.labelId = labelId;
	}

	public Integer getLabelId() {
		return labelId;
	}



}
