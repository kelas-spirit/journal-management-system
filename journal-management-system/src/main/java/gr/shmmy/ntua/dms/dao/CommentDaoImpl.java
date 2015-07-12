package gr.shmmy.ntua.dms.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import gr.shmmy.ntua.dms.domain.Comment;
import gr.shmmy.ntua.dms.domain.Metadata;

public class CommentDaoImpl implements CommentDao{
	
	private final Logger log = Logger.getLogger(this.getClass());

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void saveComment(Comment comment) {
		log.info("Saving comment");
		Session session = sessionFactory.openSession();	
		
		Long metadataId = (Long) session.save(comment);
		log.info("Comment saved with id : " + metadataId);
		log.info("Leaving save comment method in DAO");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Comment> getCommentById(Long id) {
		log.info("Entering comment method in DAO");
		List<Comment> comment = new ArrayList<Comment>();
		Session session = sessionFactory.openSession();
		Criteria crit = session.createCriteria(Comment.class);
		
		crit.add(Restrictions.eq("articleId", id));
		
		comment = (List<Comment>)crit.list();
		
		return comment;
	}

}
