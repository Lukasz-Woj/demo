package pl.projekt.service;

import pl.projekt.model.Auto;
import pl.projekt.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findCategories();
}
