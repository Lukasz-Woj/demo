package pl.projekt.repository;

import pl.projekt.model.Category;

import java.util.List;

public interface CategoryDao {
    List<Category> findCategories();

}
