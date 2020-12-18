package pl.projekt.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pl.projekt.model.Comment;

import java.util.List;

@Repository
public class CommentDaoImpl implements CommentDao{
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public CommentDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public void createComment(Comment comment) {
        String sql = "INSERT INTO comments VALUES (null, ?, ?, ?)";
        jdbcTemplate.update(sql, comment.getUserName(), comment.getTekst(), comment.getAutoId());
    }

    @Override
    public void deleteComment(Long id) {
        String sql = "DELETE FROM comments WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public List<Comment> getCommentsById(Long id) {

        String sql = "SELECT * FROM comments c WHERE c.AUTOID = " + id;
        List<Comment> comments = jdbcTemplate.query(sql, (rs, rowNum) ->
                new Comment(rs.getLong("id"),
                        rs.getString("userName"),
                        rs.getString("tekst"),
                        rs.getLong("autoId")
                        )
        );
        return comments;
    }
}
