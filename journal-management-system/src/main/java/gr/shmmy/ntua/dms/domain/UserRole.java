package gr.shmmy.ntua.dms.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USER_ROLES")
public class UserRole {

	private Long userRoleId;
	private Long userId;
	private String authority;
	
	public UserRole() {
	}

	public UserRole( Long userId, String authority) {
		super();
		this.userId = userId;
		this.authority = authority;
	}

	@Id
	@GeneratedValue
	@Column(name = "USER_ROLE_ID" )
	public Long getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(Long userRoleId) {
		this.userRoleId = userRoleId;
	}

	@Column(name = "USER_ID")
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Column(name = "AUTHORITY", length = 100)
	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	@Override
	public String toString() {
		return "UserRole [authority=" + authority + ", userId=" + userId
				+ ", userRoleId=" + userRoleId + "]";
	}
	
	
}
