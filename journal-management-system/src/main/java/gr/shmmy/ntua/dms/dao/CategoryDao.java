package gr.shmmy.ntua.dms.dao;

import gr.shmmy.ntua.dms.domain.Category;

import java.util.List;

public interface CategoryDao {
	
	public List<Category> getCategoryList();
	public String getCategoryById(int id);

}
