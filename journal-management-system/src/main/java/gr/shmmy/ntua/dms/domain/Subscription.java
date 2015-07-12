package gr.shmmy.ntua.dms.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Subscription")
public class Subscription {

	private Long subscriptionId;
	private Long metadataId;
	private Long userId;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Subscription_id", nullable = false, unique = true)
	public Long getSubscriptionId() {
		return subscriptionId;
	}
	public void setSubscriptionId(Long subscriptionId) {
		this.subscriptionId = subscriptionId;
	}
	
	@Column(name = "METADATA_ID")
	public Long getMetadataId() {
		return metadataId;
	}
	public void setMetadataId(Long metadataId) {
		this.metadataId = metadataId;
	}
	
	

	
	@Column(name = "USER_ID")
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
}
