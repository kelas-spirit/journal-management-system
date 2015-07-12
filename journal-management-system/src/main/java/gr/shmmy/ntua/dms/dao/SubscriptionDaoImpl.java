package gr.shmmy.ntua.dms.dao;

import gr.shmmy.ntua.dms.domain.Metadata;
import gr.shmmy.ntua.dms.domain.Subscription;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

public class SubscriptionDaoImpl implements SubscriptionDao{
	
	private final Logger log = Logger.getLogger(this.getClass());
	@Autowired
	SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean SubscriptionExist(Long metadataId, Long userId) {

		List<Subscription> lst = new ArrayList<Subscription>();
		
		Session session = sessionFactory.openSession();
		Criteria crit = session.createCriteria(Subscription.class);

		Conjunction conjunction = Restrictions.conjunction();
		Criterion metadata = Restrictions.eq("metadataId", metadataId);
		Criterion user = Restrictions.eq("userId", userId);
		
		conjunction.add(user);
		conjunction.add(metadata);
		
		crit.add(conjunction);
		
		lst = (List<Subscription>)crit.list();
		
		if(lst.size()>0){
			return true;
		}else {
			return false;
		}
		
		
	}

	@Override
	public void deleteSubscription(Long id) {

		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Subscription subscription = (Subscription) session.get(Subscription.class, id);
		session.delete(subscription);
		session.getTransaction().commit();
		
		
	}

	
	
	@Override
	public void deleteByUserAndDocument(Long UserId, Long metadataId) {
		
		System.out.println("userId "+UserId+" metadataId "+metadataId);
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		 Query query = session.createQuery("delete from Subscription where USER_ID = :UserId AND METADATA_ID= :metadataId");
		 query.setLong("UserId", UserId);
		 query.setLong("metadataId", metadataId);
		 
		 query.executeUpdate();
		 session.getTransaction().commit();
		 
		
		
	}

	@Override
	public void saveSubscription(Subscription subscription) {
		
		Session session = sessionFactory.openSession();
		Long subscriptionId = (Long) session.save(subscription);
		
	}

}
