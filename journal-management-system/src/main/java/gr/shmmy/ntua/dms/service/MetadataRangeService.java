package gr.shmmy.ntua.dms.service;

import java.util.List;

import gr.shmmy.ntua.dms.dao.MetadataRangeDao;
import gr.shmmy.ntua.dms.domain.MetadataRange;

import org.springframework.beans.factory.annotation.Autowired;

public class MetadataRangeService {
	
	@Autowired
	private MetadataRangeDao metadataRangeDao;
	
	public List<MetadataRange> getAllRange(){
		
		return metadataRangeDao.getAllRange();
	}
	
	

}
