package ru.javarush.asui.testapp.dao;


import ru.javarush.asui.testapp.model.Status;
import ru.javarush.asui.testapp.model.ToDoItem;

import java.io.Serializable;
import java.util.List;


public interface ToDoItemDao extends GenericDao<ToDoItem, Integer> {

    public List<ToDoItem> findByStatus(Status status, Integer offset, Integer maxResults);
    public List<ToDoItem> getPageList(Integer offset, Integer maxResults);
    public Long count();
}
