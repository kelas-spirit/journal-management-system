/**
 * 
 */
package gr.shmmy.ntua.dms.service;

import gr.shmmy.ntua.dms.dao.UserDao;
import gr.shmmy.ntua.dms.domain.User;
//import gr.shmmy.ntua.dms.utils.Utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

/**
 * @author kelas.spirit
 * 
 */
@Component
public class AuthenticationService implements AuthenticationProvider {

	@Autowired
	UserDao userDao;

	@Override
	public Authentication authenticate(Authentication authentication)
			throws AuthenticationException {

		String username = authentication.getName();
		String password = authentication.getCredentials().toString();
	//	String hashedPassword = Utils.hash(password);
		String hashedPassword = "min";
		User user = userDao.findUserByUsernameAndPassword(username,
				hashedPassword);

		if (user != null) {
			List<GrantedAuthority> grantedAuths = new ArrayList<>();
			grantedAuths.add(new SimpleGrantedAuthority("ROLE_USER"));
			Authentication auth = new UsernamePasswordAuthenticationToken(
					username, hashedPassword, grantedAuths);
			return auth;
		} else {
			return null;
		}
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}
}
