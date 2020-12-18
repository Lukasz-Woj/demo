package pl.projekt.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pl.projekt.model.Category;

import java.util.List;

@Repository
public class CategoryDaoImpl implements CategoryDao{

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public CategoryDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Category> findCategories() {
        String sql = "SELECT * FROM category";

        List<Category> categories = jdbcTemplate.query(sql, (rs, rowNum) ->
                new Category(rs.getLong("id"),
                        rs.getString("name"))
        );
        return categories;
    }


}
