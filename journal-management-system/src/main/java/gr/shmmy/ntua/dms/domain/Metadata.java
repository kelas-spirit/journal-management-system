package gr.shmmy.ntua.dms.domain;

import java.sql.Blob;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;


@Entity
@Table(name = "METADATA")
public class Metadata {

	private Long metadataId;
	private String metadataName;
	private Date metadata_date;
	private Double metadata_out_price;
	private Double metadata_web_price;
	private Blob metadata_cover_photo;
	private Double metadata_edition;
	
	
	private int categoryId;
	private int metadata_range_id;
	
	private Long size;
	
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "METADATA_ID", nullable = false, unique = true)
	public Long getMetadataId() {
		return metadataId;
	}
	public void setMetadataId(Long metadataId) {
		this.metadataId = metadataId;
	}
	
	@Column(name = "METADATA_NAME")
	public String getMetadataName() {
		return metadataName;
	}
	public void setMetadataName(String metadataName) {
		this.metadataName = metadataName;
	}
	
	@Column(name="CATEGORY_ID")
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	
	
	
	
	@Column(name = "METADATA_DATE")
	public Date getMetadata_date() {
		return metadata_date;
	}
	public void setMetadata_date(Date metadata_date) {
		this.metadata_date = metadata_date;
	}
	
	@Column(name = "METADATA_OUT_PRICE")
	public Double getMetadata_out_price() {
		return metadata_out_price;
	}
	public void setMetadata_out_price(Double metadata_out_price) {
		this.metadata_out_price = metadata_out_price;
	}
	
	@Column(name = "METADATA_WEB_PRICE")
	public Double getMetadata_web_price() {
		return metadata_web_price;
	}
	public void setMetadata_web_price(Double metadata_web_price) {
		this.metadata_web_price = metadata_web_price;
	}
	
	@Column(name = "METADATA_COVER_PHOTO")
	public Blob getMetadata_cover_photo() {
		return metadata_cover_photo;
	}
	public void setMetadata_cover_photo(Blob metadata_cover_photo) {
		this.metadata_cover_photo = metadata_cover_photo;
	}
	
	@Column(name = "METADATA_EDITION")
	public Double getMetadata_edition() {
		return metadata_edition;
	}
	public void setMetadata_edition(Double metadata_edition) {
		this.metadata_edition = metadata_edition;
	}
	
	
	
	@Column(name = "METADATA_RANGE_ID")
	public int getMetadata_range_id() {
		return metadata_range_id;
	}
	public void setMetadata_range_id(int metadata_range_id) {
		this.metadata_range_id = metadata_range_id;
	}
	
	@Column(name = "SIZE")
	public Long getSize() {
		return size;
	}
	public void setSize(Long size) {
		this.size = size;
	}
	
}
