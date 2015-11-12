package ru.javarush.asui.testapp.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import ru.javarush.asui.testapp.model.Status;
import ru.javarush.asui.testapp.model.ToDoItem;


import java.util.List;

@Repository
public class ToDoItemDaoImpl extends GenericDaoImpl<ToDoItem, Integer> implements ToDoItemDao {

    public List<ToDoItem> findByStatus(Status status) {
        List<ToDoItem> toDoItemList = null;
        Criteria criteria = currentSession().createCriteria(ToDoItem.class, "toDoItem");
        criteria.add(Restrictions.eq("toDoItem.status", status));
        toDoItemList = criteria.list();
        return toDoItemList;
    }

}
