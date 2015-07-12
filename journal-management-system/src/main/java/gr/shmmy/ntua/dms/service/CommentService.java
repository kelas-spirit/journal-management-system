package gr.shmmy.ntua.dms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import gr.shmmy.ntua.dms.dao.CommentDao;
import gr.shmmy.ntua.dms.domain.Comment;

public class CommentService {
	
	@Autowired
	private CommentDao commentDao;
	
	
	@Transactional
	public void saveComment(Comment comment){
		commentDao.saveComment(comment);
	}
	
	public List<Comment>getCommentById(Long id){
		return commentDao.getCommentById(id);
	}

}
