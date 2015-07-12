/**
 * 
 */
package gr.shmmy.ntua.dms.dao;

import java.io.IOException;
import java.util.List;

import gr.shmmy.ntua.dms.domain.User;

/**
 * @author kelas
 *
 */
public interface UserDao {
	public User findUserByUsernameAndPassword(String username, String password);
	

	public Long idFromUsername(String user);
	//public List<User> UserList(String username);


	public List<User> getAllUsers();


	public List<User> getUserBySearchQuery(String searchQuery);
	
	public boolean userExist(String user);
	
	public void insertUser( User user, String roles) throws IOException;

}
