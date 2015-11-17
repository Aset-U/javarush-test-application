package ru.javarush.asui.testapp.dao;


import org.springframework.stereotype.Repository;
import ru.javarush.asui.testapp.model.Category;
@Repository
public class CategoryDaoImpl extends GenericDaoImpl<Category, Integer> implements CategoryDao{
}
