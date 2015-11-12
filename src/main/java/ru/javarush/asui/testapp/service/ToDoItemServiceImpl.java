package ru.javarush.asui.testapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.javarush.asui.testapp.dao.GenericDao;
import ru.javarush.asui.testapp.dao.ToDoItemDao;
import ru.javarush.asui.testapp.model.Status;
import ru.javarush.asui.testapp.model.ToDoItem;

import java.util.List;

@Service
public class ToDoItemServiceImpl extends GenericServiceImpl<ToDoItem,Integer> implements ToDoItemService {

    private ToDoItemDao toDoItemDao;

    public ToDoItemServiceImpl(){

    }

    @Autowired
    public ToDoItemServiceImpl(@Qualifier("toDoItemDaoImpl") GenericDao<ToDoItem, Integer> genericDao){
        super(genericDao);
        this.toDoItemDao = (ToDoItemDao) genericDao;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public List<ToDoItem> findByStatus(Status status) {
        return toDoItemDao.findByStatus(status);
    }
}
