package gr.shmmy.ntua.dms.web.formBean;

import java.sql.Blob;
import java.util.Date;

public class DocumentPostFormBean {

	private Long metadataId;
	private String metadataName;
	private Date metadata_date;
	private Double metadata_out_price;
	private Double metadata_web_price;
	private String metadata_cover_photo;
	private Double metadata_edition;
	
	
	private String categoryName;

	private int categoryId;
	private int metadata_range_id;
	
	private Long size;

	
	//contsructor
	
	public DocumentPostFormBean(Long metadataId, String metadataName,
			Date metadata_date, Double metadata_out_price,
			Double metadata_web_price, String metadata_cover_photo,
			Double metadata_edition, String categoryName, int categoryId,
			int metadata_range_id, Long size) {
		super();
		this.metadataId = metadataId;
		this.metadataName = metadataName;
		this.metadata_date = metadata_date;
		this.metadata_out_price = metadata_out_price;
		this.metadata_web_price = metadata_web_price;
		this.metadata_cover_photo = metadata_cover_photo;
		this.metadata_edition = metadata_edition;
		this.categoryName = categoryName;
		this.categoryId = categoryId;
		this.metadata_range_id = metadata_range_id;
		this.size = size;
	}
	
	
	

	public Long getMetadataId() {
		return metadataId;
	}

	public void setMetadataId(Long metadataId) {
		this.metadataId = metadataId;
	}

	public String getMetadataName() {
		return metadataName;
	}

	public void setMetadataName(String metadataName) {
		this.metadataName = metadataName;
	}

	public Date getMetadata_date() {
		return metadata_date;
	}

	public void setMetadata_date(Date metadata_date) {
		this.metadata_date = metadata_date;
	}

	public Double getMetadata_out_price() {
		return metadata_out_price;
	}

	public void setMetadata_out_price(Double metadata_out_price) {
		this.metadata_out_price = metadata_out_price;
	}

	public Double getMetadata_web_price() {
		return metadata_web_price;
	}

	public void setMetadata_web_price(Double metadata_web_price) {
		this.metadata_web_price = metadata_web_price;
	}

	public String getMetadata_cover_photo() {
		return metadata_cover_photo;
	}

	public void setMetadata_cover_photo(String metadata_cover_photo) {
		this.metadata_cover_photo = metadata_cover_photo;
	}

	public Double getMetadata_edition() {
		return metadata_edition;
	}

	public void setMetadata_edition(Double metadata_edition) {
		this.metadata_edition = metadata_edition;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public int getMetadata_range_id() {
		return metadata_range_id;
	}

	public void setMetadata_range_id(int metadata_range_id) {
		this.metadata_range_id = metadata_range_id;
	}

	public Long getSize() {
		return size;
	}

	public void setSize(Long size) {
		this.size = size;
	}
	
	
	
	public String getCategoryName() {
		return categoryName;
	}




	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}




	
	
}
