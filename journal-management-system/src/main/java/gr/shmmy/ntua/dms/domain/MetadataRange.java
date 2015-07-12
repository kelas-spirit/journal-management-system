package gr.shmmy.ntua.dms.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "METADATA_RANGE")
public class MetadataRange {
	
	private int metadata_range_id;
	private String metadata_range_name;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "METADATA_RANGE_ID", nullable = false, unique = true)
	public int getMetadata_range_id() {
		return metadata_range_id;
	}
	public void setMetadata_range_id(int metadata_range_id) {
		this.metadata_range_id = metadata_range_id;
	}
	
	@Column(name = "METADATA_RANGE_NAME")
	public String getMetadata_range_name() {
		return metadata_range_name;
	}
	public void setMetadata_range_name(String metadata_range_name) {
		this.metadata_range_name = metadata_range_name;
	}
	
	

}
