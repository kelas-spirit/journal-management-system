package gr.shmmy.ntua.dms.dao;

import gr.shmmy.ntua.dms.domain.Metadata;
import gr.shmmy.ntua.dms.domain.User;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.multipart.MultipartFile;

public interface DocumentDao {

	
	//public void setCreatedDayAfterUpdate
	
	void saveDocument(MultipartFile multipartFile, Metadata metadata);
	
	public Metadata getDocumentById(Long id);
	
	public List<Metadata> getDocumentList();
	
	public List<Metadata> getDocumentListByCategoryId(int id);
	
	public void deleteDocument(Long documentId);

	
}
