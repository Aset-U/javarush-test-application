package ru.javarush.asui.testapp.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.javarush.asui.testapp.model.Status;
import ru.javarush.asui.testapp.model.ToDoItem;



import java.util.List;

@Repository
@Transactional
public class ToDoItemDaoImpl extends GenericDaoImpl<ToDoItem, Integer> implements ToDoItemDao {

    @Override
    @SuppressWarnings("unchecked")
    @Transactional
    public List<ToDoItem> findByStatus(Status status, Integer offset, Integer maxResults) {
        List<ToDoItem> toDoItemList = null;
        Criteria criteria = currentSession().createCriteria(ToDoItem.class, "toDoItem");
        criteria.add(Restrictions.eq("toDoItem.status", status));
        toDoItemList = criteria
                 .setFirstResult(offset!=null?offset:0)
                 .setMaxResults(maxResults!=null?maxResults:10)
                 .list();

        return toDoItemList;
    }

    @Override
    @SuppressWarnings("unchecked")
    @Transactional
    public List<ToDoItem> getPageList(Integer offset, Integer maxResults) {
        return currentSession()
                .createCriteria(ToDoItem.class)
                .setFirstResult(offset!=null?offset:0)
                .setMaxResults(maxResults!=null?maxResults:10)
                .list();
    }


    @Override
    public Long count() {
        return (Long)currentSession()
                .createCriteria(ToDoItem.class)
                .setProjection(Projections.rowCount())
                .uniqueResult();
    }

}
