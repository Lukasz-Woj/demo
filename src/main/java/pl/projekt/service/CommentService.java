package pl.projekt.service;

import pl.projekt.model.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> getCommentsById(Long id);
    void deleteComment(Long id);
    void createComment(Comment comment);
}