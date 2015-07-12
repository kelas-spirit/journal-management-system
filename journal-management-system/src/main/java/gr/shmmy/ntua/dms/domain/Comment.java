package gr.shmmy.ntua.dms.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "COMMENT")
public class Comment {

	private Long comment_id;
	private String comment_text;
	private Long articleId;
	private Long userId;
	private String username;
	
	
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "COMMENT_ID", nullable = false, unique = true)
	public Long getComment_id() {
		return comment_id;
	}
	public void setComment_id(Long comment_id) {
		this.comment_id = comment_id;
	}
	
	@Column(name = "COMMENT_TEXT")
	public String getComment_text() {
		return comment_text;
	}
	public void setComment_text(String comment_text) {
		this.comment_text = comment_text;
	}
	
	
	@Column(name="ArticleId")
	public Long getArticleId() {
		return articleId;
	}
	public void setArticleId(Long articleId) {
		this.articleId = articleId;
	}
	
	@Column(name = "UserId")
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	@Column(name="Username")
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
}
