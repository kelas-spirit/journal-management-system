package gr.shmmy.ntua.dms.dao;

import gr.shmmy.ntua.dms.domain.Article;
import gr.shmmy.ntua.dms.domain.Metadata;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

public class ArticleDaoImpl implements ArticleDao{

	private final Logger log = Logger.getLogger(this.getClass());
	
	@Autowired
	SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Article> getArticlesById(Long id) {

		List<Article> art = new ArrayList<Article>();
		Session session = sessionFactory.openSession();
		Criteria crit = session.createCriteria(Article.class);
		
		crit.add(Restrictions.eq("metadataId", id));
		
		art = (List<Article>)crit.list();
		
		return art;
	}

	@Override
	public void saveArticle(Article article) {
		log.info("Saving metadata");
		Session session = sessionFactory.openSession();
		Long articleId = (Long) session.save(article);
		log.info("Metadata saved with id : " + articleId);
		log.info("Leaving method in DAO");
		
	}

	@Override
	public Article getArticleById(Long id) {
		
		log.info("Entering getArticleById method in DAO");
		Session session = sessionFactory.openSession();
		Article art = (Article) session.get(Article.class, id);
		
		
		return art;
	}
	
	

}
