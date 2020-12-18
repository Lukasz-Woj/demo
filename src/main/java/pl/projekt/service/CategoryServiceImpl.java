package pl.projekt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.projekt.model.Auto;
import pl.projekt.model.Category;
import pl.projekt.repository.AutoDao;
import pl.projekt.repository.CategoryDao;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService{

    private CategoryDao categoryDao;




    public CategoryServiceImpl(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @Override
    public List<Category> findCategories() {
        return categoryDao.findCategories();
    }




}
