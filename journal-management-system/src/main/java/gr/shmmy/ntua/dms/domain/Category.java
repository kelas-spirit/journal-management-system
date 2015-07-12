package gr.shmmy.ntua.dms.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

@Table(name = "CATEGORY")
public class Category {
	
	private int category_id;
	private String category_name;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CATEGORY_ID", nullable = false, unique = true)
	public int getCategory_id() {
		return category_id;
	}
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}
	
	@Column(name = "CATEGORY_NAME", length = 100, unique = true)
	public String getCategory_name() {
		return category_name;
	}
	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}
	
	

}
