package gr.shmmy.ntua.dms.dao;


import gr.shmmy.ntua.dms.domain.Category;
import gr.shmmy.ntua.dms.domain.Metadata;
import gr.shmmy.ntua.dms.domain.User;
import gr.shmmy.ntua.dms.utils.Constants;
import gr.shmmy.ntua.dms.utils.Utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.*;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

public class DocumentDaoImpl implements DocumentDao {

	private final Logger log = Logger.getLogger(this.getClass());

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void saveDocument(MultipartFile multipartFile, Metadata metadata) {
		
		try {
			Blob blob = Hibernate.getLobCreator(sessionFactory.getCurrentSession()).createBlob(multipartFile.getInputStream(),
					metadata.getSize());
			metadata.setMetadata_cover_photo(blob);
			
		} catch (HibernateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		log.info("Saving metadata");
		Session session = sessionFactory.openSession();
		
		Long metadataId = (Long) session.save(metadata);
		log.info("Metadata saved with id : " + metadataId);
		log.info("Leaving saveFileToRepo method in DAO");
		
	}

	@Override
	public Metadata getDocumentById(Long id) {

		log.info("Entering getDocumentById method in DAO");
		Session session = sessionFactory.openSession();
		Metadata meta = (Metadata) session.get(Metadata.class, id);
		return meta;
		
	}

	@Override
	public List<Metadata> getDocumentList() {

		Session session = sessionFactory.openSession();
		
		org.hibernate.Query query = (org.hibernate.Query) session.createQuery("from Metadata");
		
		@SuppressWarnings("unchecked")
		List<Metadata> lst = query.list();
		
		return lst;
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Metadata> getDocumentListByCategoryId(int id) {
		
		List<Metadata> metadata = new ArrayList<Metadata>();
		Session session = sessionFactory.openSession();
		Criteria crit = session.createCriteria(Metadata.class);
		
		crit.add(Restrictions.eq("categoryId", id));
		metadata = (List<Metadata>)crit.list();
		
		return metadata;
	}


	@Override
	public void deleteDocument(Long id) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Metadata meta = (Metadata) session.get(Metadata.class, id);
		
		session.delete(meta);
		session.getTransaction().commit();
		
	}

	

	


}
