package pl.projekt.repository;

import pl.projekt.model.Comment;

import java.util.List;

public interface CommentDao {
    void createComment(Comment comment);
    void deleteComment(Long id);
    List<Comment> getCommentsById(Long id);
}
