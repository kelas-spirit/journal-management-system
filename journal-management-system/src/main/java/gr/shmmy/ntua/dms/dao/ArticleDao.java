package gr.shmmy.ntua.dms.dao;

import gr.shmmy.ntua.dms.domain.Article;

import java.util.List;

public interface ArticleDao {

	
	List<Article> getArticlesById(Long id);
	public void saveArticle(Article article);
	public Article getArticleById(Long id);
}
