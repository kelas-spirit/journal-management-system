package gr.shmmy.ntua.dms.dao;

import java.util.List;

import gr.shmmy.ntua.dms.domain.Comment;

public interface CommentDao {
	
	public void saveComment(Comment comment);

	public List<Comment> getCommentById(Long id);
}
