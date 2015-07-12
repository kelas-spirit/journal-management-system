package gr.shmmy.ntua.dms.dao;

import java.util.List;

import gr.shmmy.ntua.dms.domain.Coupon;

public interface CouponDao {
	
	public void insertCoupon(Coupon coupon);
	
	public boolean couponExist(Long userId,int categoryId);
	
	public boolean couponExist(Long userId,int categoryId, Long num);
	
	public List<Coupon> getCouponById(Long userId);

}
