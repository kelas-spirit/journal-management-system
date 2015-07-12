package gr.shmmy.ntua.dms.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Article")
public class Article {

	private Long articleId;
	private String owner;
	private Long metadataId;
	private String articleText;
	private String articleSubject;
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ArticleId", nullable = false, unique = true)
	public Long getArticleId() {
		return articleId;
	}
	public void setArticleId(Long articleId) {
		this.articleId = articleId;
	}
	
	@Column(name = "Owner")
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	@Column(name = "METADATA_ID")
	public Long getMetadataId() {
		return metadataId;
	}
	public void setMetadataId(Long metadataId) {
		this.metadataId = metadataId;
	}
	
	@Column(name = "ArticleText")
	public String getArticleText() {
		return articleText;
	}
	public void setArticleText(String articleText) {
		this.articleText = articleText;
	}
	
	@Column(name = "ArticleSubject")
	public String getArticleSubject() {
		return articleSubject;
	}
	public void setArticleSubject(String articleSubject) {
		this.articleSubject = articleSubject;
	}
	
}
