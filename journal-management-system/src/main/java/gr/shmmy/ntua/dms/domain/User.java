package gr.shmmy.ntua.dms.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.*;


@Entity

@Table(name = "USERS")
/*
@NamedQuery(name="User.findByName", query = "select u from User u where u.username = :username")*/
public class User implements Serializable {

	private static final long serialVersionUID = 3085500718224521430L;

	private Long userId;
	private String username;
	private String password;
	private String firstname;
	private String lastname;
	private String email;
	private int enabled;
	private Set<UserRole> userRoles = new HashSet<UserRole>();

	/* constructors */
	public User() {
	}

	public User(String username, String password,String firstname, String lastname, int enabled) {
		super();
		this.username = username;
		this.password = password;
		this.firstname= firstname;
		this.lastname=lastname;
		this.enabled = enabled;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "USER_ID", nullable = false, unique = true)
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Column(name = "USERNAME", length = 100, unique = true)
	public String getUsername() {
		return username;
	}
	
	

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "PASSWORD", length = 100)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	@Column(name = "FIRSTNAME", length = 100)
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	@Column(name = "LASTNAME", length = 100)
	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	@Column(name = "EMAIL")
	public String getEmail() {
	    return email;
	}
	public void setEmail(String email) {
	    this.email = email;
	}

	@Column(name = "ENABLED", precision = 1, scale = 0, length = 1)
	public int getEnabled() {
		return enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "USER_ID")
	public Set<UserRole> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(Set<UserRole> userRoles) {
		this.userRoles = userRoles;
	}

	@Override
	public String toString() {
		return "User [enabled=" + enabled + ", password=" + password
				+ ", userId=" + userId + ", username=" + username + "]";
	}

}
