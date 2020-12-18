package pl.projekt.service;

import org.springframework.stereotype.Service;
import pl.projekt.model.Comment;
import pl.projekt.repository.CommentDao;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService{

    private CommentDao commentDao;

    public CommentServiceImpl(CommentDao commentDao) {
        this.commentDao = commentDao;
    }

    @Override
    public List<Comment> getCommentsById(Long id) {
        return commentDao.getCommentsById(id);
    }

    @Override
    public void deleteComment(Long id) {

    }

    @Override
    public void createComment(Comment comment) {
        commentDao.createComment(comment);
    }
}
