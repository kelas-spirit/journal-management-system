package gr.shmmy.ntua.dms.web.formBean;

public class CouponPostFormBean {
	
	private String categoryName;
	private Long couponNumber;
	
	public CouponPostFormBean(String categoryName, Long couponNumber) {
		super();
		this.categoryName = categoryName;
		this.couponNumber = couponNumber;
	}
	
	
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public Long getCouponNumber() {
		return couponNumber;
	}
	public void setCouponNumber(Long couponNumber) {
		this.couponNumber = couponNumber;
	}
	
	
	

}
