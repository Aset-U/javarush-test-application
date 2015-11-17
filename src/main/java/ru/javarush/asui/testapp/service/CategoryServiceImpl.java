package ru.javarush.asui.testapp.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.javarush.asui.testapp.dao.CategoryDao;
import ru.javarush.asui.testapp.dao.CategoryDaoImpl;
import ru.javarush.asui.testapp.dao.GenericDao;
import ru.javarush.asui.testapp.model.Category;

@Service
public class CategoryServiceImpl extends GenericServiceImpl<Category, Integer> implements CategoryService{

    private CategoryDao categoryDao;

    public CategoryServiceImpl(){

    }

    @Autowired
    public CategoryServiceImpl(@Qualifier("categoryDaoImpl") GenericDao<Category, Integer> genericDao){
        super(genericDao);
        this.categoryDao = (CategoryDaoImpl) genericDao;
    }
}
