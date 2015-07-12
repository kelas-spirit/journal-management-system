package gr.shmmy.ntua.dms.service;

import java.util.List;

import gr.shmmy.ntua.dms.dao.CouponDao;
import gr.shmmy.ntua.dms.dao.DocumentDao;
import gr.shmmy.ntua.dms.dao.UserDao;
import gr.shmmy.ntua.dms.domain.Coupon;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.transaction.annotation.Transactional;

public class CouponService {
	
	private final Logger log = Logger.getLogger(this.getClass());
	
	@Autowired
	private DocumentDao documentDao;

	@Autowired
	private UserDao userDao;
	
	@Autowired
    private JavaMailSender mailSender;
	
	@Autowired
	private CouponDao couponDao;
	
	
	@Transactional
	public void saveCoupon(Coupon coupon){
		
		couponDao.insertCoupon(coupon);
			
	}
	
	public boolean couponExist(Long userId, int categoryId){
		return couponDao.couponExist(userId, categoryId);
	}
	
	public boolean couponExist(Long userId, int categoryId, Long num){
		return couponDao.couponExist(userId, categoryId,num);
	}
	
	public List<Coupon> getCouponById(Long userId){
		
		return couponDao.getCouponById(userId);
	}

}
