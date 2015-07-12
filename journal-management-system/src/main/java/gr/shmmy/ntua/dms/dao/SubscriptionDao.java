package gr.shmmy.ntua.dms.dao;

import gr.shmmy.ntua.dms.domain.Subscription;

public interface SubscriptionDao {

	public boolean SubscriptionExist(Long metadataId, Long userId);
	
	public void deleteSubscription(Long id);
	public void deleteByUserAndDocument(Long UserId, Long metadataId);
	public void saveSubscription(Subscription subscription);
	
}
