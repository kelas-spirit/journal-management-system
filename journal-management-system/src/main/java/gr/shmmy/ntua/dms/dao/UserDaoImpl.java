/**
 * 
 */
package gr.shmmy.ntua.dms.dao;

import gr.shmmy.ntua.dms.domain.Metadata;
import gr.shmmy.ntua.dms.domain.User;
import gr.shmmy.ntua.dms.domain.UserRole;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author kelas
 * 
 */
public class UserDaoImpl implements UserDao {
	private final Logger log = Logger.getLogger(this.getClass());
	SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public User findUserByUsernameAndPassword(String username, String password) {

		/*Session session = this.sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<User> users = session
				.createQuery(
						"from USER user where user.username=? and user.password=?")
				.setParameter(0, username).setParameter(1, password).list();
		log.info("SELECT * FROM dms.USER WHERE USERNAME=" + username
				+ " AND PASSWORD=" + password);
		if (session != null) {
			session.close();
		}
		if (users != null && !users.isEmpty()) {
			return users.get(0);
		}*/
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Long idFromUsername(String user) {
		Session session = sessionFactory.openSession();
		List<User> usq = new ArrayList<User>();
		Long id = null;
		Criteria crit = session.createCriteria(User.class);
		crit.add(Restrictions.like("username", user));
		usq = (List<User>) crit.list();
		for(User usr:usq){
			id = usr.getUserId();
		}
		
		return id;
	}
	
	@Override
	public List<User> getAllUsers() {
		Session session = sessionFactory.openSession();
		
		org.hibernate.Query query = (org.hibernate.Query) session.createQuery("from User");
		
		@SuppressWarnings("unchecked")
		List<User> lst = query.list();
		
		return lst;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getUserBySearchQuery(String searchQuery) {
		// TODO Auto-generated method stub
		List<User> usq = new ArrayList<User>();
		
		Session session = sessionFactory.openSession();
		Criteria crit = session.createCriteria(User.class);
		crit.add(Restrictions.like("username", searchQuery));
		
		usq = (List<User>) crit.list();
		
		
		return usq;
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean userExist(String username) {
		// TODO Auto-generated method stub
		List<User> usr =null;
		Session session = sessionFactory.openSession();
		Criteria crit = session.createCriteria(User.class);
		crit.add(Restrictions.like("username", username));
		usr =  (List<User>)crit.list();
		
		if(usr.size()>0){
			return true;
		}
		else{
			return false;
		}
		
	
	}
	
	
	@Override
	//@Autowired
	public void insertUser(User user, String roles) throws IOException {
		// TODO Auto-generated method stub
		UserRole userRole = new UserRole();
		
		
	//	System.out.println("ROLE IS ..."+roles);
		
		
		
		Session session = sessionFactory.openSession();
		Long UserId = (Long) session.save(user);// save data for user
	
		// this save data for userrole with user id
		log.info("UserId saved with id : " + UserId);
	////	if(roles==null || (!roles.equals("ROLE_ADMIN"))){
		//	System.out.println("in user"+roles);
			userRole.setAuthority("ROLE_USER");
	//	}
	/*	else 
			if(roles.equals("ROLE_ADMIN")){
				System.out.println("in admin"+roles);
				userRole.setAuthority(roles);
				
			}*/
		userRole.setUserId(UserId);
		Long UserRoleId = (Long) session.save(userRole);
		log.info("UserRoleId saved with id : " + UserRoleId);
		
	}

}
