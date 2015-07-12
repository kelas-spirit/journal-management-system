package gr.shmmy.ntua.dms.domain;

import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Advertising")
public class Advertising {

	private Long advertising_id;
	private Long metadataId;
	private Blob image;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "advertising_id", nullable = false, unique = true)
	public Long getAdvertising_id() {
		return advertising_id;
	}
	public void setAdvertising_id(Long advertising_id) {
		this.advertising_id = advertising_id;
	}
	@Column(name = "METADATA_ID")
	public Long getMetadataId() {
		return metadataId;
	}
	public void setMetadataId(Long metadataId) {
		this.metadataId = metadataId;
	}
	
	@Column(name = "Image")
	public Blob getImage() {
		return image;
	}
	public void setImage(Blob image) {
		this.image = image;
	}
	
	
	
}
