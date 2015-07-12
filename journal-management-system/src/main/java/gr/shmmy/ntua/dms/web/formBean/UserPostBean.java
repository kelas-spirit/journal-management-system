package gr.shmmy.ntua.dms.web.formBean;

public class UserPostBean {
	private Long userId;
	public static String username;
	private String password;
	private String firstname;
	private String lastname;
	private String email;
	private int enabled;
//	private Set<UserRole> userRoles = new HashSet<UserRole>();

	/* constructors */
	
	public UserPostBean() {
		
	}

	
	public  Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}
	
	

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public String getEmail() {
	    return email;
	}
	public void setEmail(String email) {
	    this.email = email;
	}

	public int getEnabled() {
		return enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}


}
