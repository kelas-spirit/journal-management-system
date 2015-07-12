package gr.shmmy.ntua.dms.service;

import gr.shmmy.ntua.dms.dao.DocumentDao;
import gr.shmmy.ntua.dms.dao.UserDao;
import gr.shmmy.ntua.dms.domain.*;
import gr.shmmy.ntua.dms.web.formBean.UserPostBean;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class UserService {
	
	//private static final int Set = 0;
		
	
	@Autowired
	private UserDao userDao;
	
	
	public Long getIdByUsername(String username){
		return userDao.idFromUsername(username);
	}

	
	@Transactional
	public List<User> getUserBySearchQuery(String searchQuery) {
		List<User> usq = new ArrayList<User>();

		usq = userDao.getUserBySearchQuery(searchQuery);
		return usq;
	}
	
	
	
	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}
	
	public boolean userExist (String username){
		return	userDao.userExist(username);
	}
	
	
	@Transactional
	public void inserFromPublicReg(UserPostBean userbean){
		User user = new User();
		user.setEmail(userbean.getEmail());
		user.setEnabled(1);
		user.setFirstname(userbean.getFirstname());
		user.setLastname(userbean.getLastname());
		user.setUsername(userbean.getUsername());
		user.setPassword(userbean.getPassword());
		try {
			userDao.insertUser(user,"ROLE_USER");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
}
