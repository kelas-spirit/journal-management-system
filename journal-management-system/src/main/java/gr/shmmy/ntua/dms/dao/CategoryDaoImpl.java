package gr.shmmy.ntua.dms.dao;

import gr.shmmy.ntua.dms.domain.Category;
import gr.shmmy.ntua.dms.domain.Metadata;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class CategoryDaoImpl implements CategoryDao {
	
	private final Logger log = Logger.getLogger(this.getClass());

	
	@Autowired
	SessionFactory sessionFactory;	
	public List<Category> getCategoryList() {
		
		Session session = sessionFactory.openSession();
		
		org.hibernate.Query query = (org.hibernate.Query) session.createQuery("from Category");
		
		@SuppressWarnings("unchecked")
		List<Category> lst = query.list();
		
		return lst;
		
		
	}
	@Override
	public String getCategoryById(int id) {
		log.info("Entering getDocumentById method in DAO");
		Session session = sessionFactory.openSession();
		Category category = (Category) session.get(Category.class, id);
		return category.getCategory_name();
	}

}
