package gr.shmmy.ntua.dms.service;

import gr.shmmy.ntua.dms.dao.DocumentDao;
import gr.shmmy.ntua.dms.dao.UserDao;
import gr.shmmy.ntua.dms.domain.Metadata;
//import gr.shmmy.ntua.dms.utils.Constants;

import gr.shmmy.ntua.dms.domain.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

public class DocumentService {

	private final Logger log = Logger.getLogger(this.getClass());

	@Value("${doc.repo.path}")
	private String fileStorePath;

	@Autowired
	private DocumentDao documentDao;

	@Autowired
	private UserDao userDao;
	
	@Autowired
    private JavaMailSender mailSender;
	
	//private <gr.shmmy.ntua.dms.domain.User> User NewUser= new User();
	
	public void setDocumentDao(DocumentDao documentDao) {
		this.documentDao = documentDao;
	}

	public void setFileStorePath(String fileStorePath) {
		this.fileStorePath = fileStorePath;
	}
	
	@Transactional
	public void saveDocument(MultipartFile multipartFile, Metadata metadata){
		
		documentDao.saveDocument(multipartFile, metadata);
		
	}
	
	public Metadata getDocumentById(Long id){
		
		return documentDao.getDocumentById(id);
		
	}
	
	public List<Metadata> getDocumentList(){
		
		return documentDao.getDocumentList();
	}
	
	public  List<Metadata> getDocumentListByCategoryId(int id){
		return documentDao.getDocumentListByCategoryId(id);
	}
	
	@Transactional
	public void deleteDocument(Long id){
		
		documentDao.deleteDocument(id);
	}
	
	
}
