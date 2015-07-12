package gr.shmmy.ntua.dms.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import gr.shmmy.ntua.dms.dao.ArticleDao;
import gr.shmmy.ntua.dms.domain.Article;

public class ArticleService {
	
	private final Logger log = Logger.getLogger(this.getClass());

	@Autowired
	private ArticleDao articleDao;
	
	
	public List<Article> getArticlesById(Long id){
		
		return articleDao.getArticlesById(id);
	}
	
	@Transactional
	public void saveArticle(Article article){
		
		articleDao.saveArticle(article);
	}
	
	public Article getArticleById(Long id){
		return articleDao.getArticleById(id);
	}
	
	
}
