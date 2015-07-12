package gr.shmmy.ntua.dms.dao;

import gr.shmmy.ntua.dms.domain.Category;
import gr.shmmy.ntua.dms.domain.MetadataRange;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class MetadataRangeDaoImpl implements MetadataRangeDao {
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<MetadataRange> getAllRange() {

		Session session = sessionFactory.openSession();
		
		org.hibernate.Query query = (org.hibernate.Query) session.createQuery("from MetadataRange");
		
		@SuppressWarnings("unchecked")
		List<MetadataRange> lst = query.list();
		
		return lst;
	}
	

}
