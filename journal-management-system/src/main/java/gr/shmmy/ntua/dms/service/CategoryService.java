package gr.shmmy.ntua.dms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import gr.shmmy.ntua.dms.dao.CategoryDao;
import gr.shmmy.ntua.dms.domain.Category;

public class CategoryService {
	
	@Autowired
	private CategoryDao categoryDao;
	
public List<Category>  getCategoryList(){
		
		
		return categoryDao.getCategoryList();
	}

public String getCategoryById(int id){
	return categoryDao.getCategoryById(id);
}

}
