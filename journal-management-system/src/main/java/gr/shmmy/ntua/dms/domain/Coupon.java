package gr.shmmy.ntua.dms.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Coupon")
public class Coupon {

	private Long cuponId;
	private Long userId;
	private int categoryId;
	private Long couponNumber;
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CouponId", nullable = false, unique = true)
	public Long getCuponId() {
		return cuponId;
	}
	public void setCuponId(Long cuponId) {
		this.cuponId = cuponId;
	}
	
	@Column(name = "UserId")
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	@Column(name = "CategoryId")
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	
	
	@Column(name = "CouponNumber")
	public Long getCouponNumber() {
		return couponNumber;
	}
	public void setCouponNumber(Long couponNumber) {
		this.couponNumber = couponNumber;
	}
	
}
