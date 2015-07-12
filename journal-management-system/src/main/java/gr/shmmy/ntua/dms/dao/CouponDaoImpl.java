package gr.shmmy.ntua.dms.dao;

import java.util.ArrayList;
import java.util.List;

import gr.shmmy.ntua.dms.domain.Coupon;
import gr.shmmy.ntua.dms.domain.Metadata;
import gr.shmmy.ntua.dms.domain.Subscription;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

public class CouponDaoImpl implements CouponDao{

	private final Logger log = Logger.getLogger(this.getClass());

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public void insertCoupon(Coupon coupon) {
		Session session = sessionFactory.openSession();		
		Long couponId = (Long) session.save(coupon);
		log.info("Metadata saved with id : " + couponId);		
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean couponExist(Long userId, int categoryId) {
		
		List<Coupon> coupon = new ArrayList<Coupon>();
		Session session = sessionFactory.openSession();
		Criteria crit = session.createCriteria(Coupon.class);
		
		Conjunction conjunction = Restrictions.conjunction();
		Criterion user = Restrictions.eq("userId", userId);
		Criterion category = Restrictions.eq("categoryId", categoryId);
		
		conjunction.add(user);
		conjunction.add(category);
		
		crit.add(conjunction);
		
		coupon = (List<Coupon>)crit.list();
		
		if(coupon.size()>0){
			return true;
		}else{
		
		
		return false;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Coupon> getCouponById(Long userId) {
		
		List<Coupon> coupon = new ArrayList<Coupon>();
		Session session = sessionFactory.openSession();
		Criteria crit = session.createCriteria(Coupon.class);
		
		crit.add(Restrictions.eq("userId", userId));
		coupon = (List<Coupon>)crit.list();
		
		
		
		return coupon;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean couponExist(Long userId, int categoryId, Long num) {
		List<Coupon> coupon = new ArrayList<Coupon>();
		Session session = sessionFactory.openSession();
		Criteria crit = session.createCriteria(Coupon.class);
		
		Conjunction conjunction = Restrictions.conjunction();
		Criterion user = Restrictions.eq("userId", userId);
		Criterion category = Restrictions.eq("categoryId", categoryId);
		Criterion number = Restrictions.eq("couponNumber", num);
		
		conjunction.add(user);
		conjunction.add(category);
		conjunction.add(number);
		
		crit.add(conjunction);
		
		coupon = (List<Coupon>)crit.list();
		
		if(coupon.size()>0){
			return true;
		}else{
		
		
		return false;
		}
	}
	
	

}
