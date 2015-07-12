package gr.shmmy.ntua.dms.service;

import gr.shmmy.ntua.dms.dao.DocumentDao;
import gr.shmmy.ntua.dms.dao.SubscriptionDao;
import gr.shmmy.ntua.dms.dao.UserDao;
import gr.shmmy.ntua.dms.domain.Subscription;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.transaction.annotation.Transactional;

public class SubscriptionService {
	
	private final Logger log = Logger.getLogger(this.getClass());
	
	@Value("${doc.repo.path}")
	private String fileStorePath;

	@Autowired
	private DocumentDao documentDao;

	@Autowired
	private UserDao userDao;
	
	@Autowired
    private JavaMailSender mailSender;
	
	@Autowired
	private SubscriptionDao subscriptionDao;
	
	//private <gr.shmmy.ntua.dms.domain.User> User NewUser= new User();
	
	public void setDocumentDao(DocumentDao documentDao) {
		this.documentDao = documentDao;
	}

	public void setFileStorePath(String fileStorePath) {
		this.fileStorePath = fileStorePath;
	}
	
	public boolean SubscriptionExist(Long metadataId,Long userId){
		return subscriptionDao.SubscriptionExist(metadataId, userId);
	}
	
	@Transactional
	public void deleteSubscription(Long id){
		subscriptionDao.deleteSubscription(id);
	}
	
	@Transactional
	public void deleteByUserAndDocument(Long UserId, Long metadataId){
		subscriptionDao.deleteByUserAndDocument(UserId, metadataId);
	}
	
	@Transactional
	public void saveSubscription(Subscription subscription){
		subscriptionDao.saveSubscription(subscription);
	}

}
