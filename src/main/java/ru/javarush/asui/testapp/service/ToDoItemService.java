package ru.javarush.asui.testapp.service;


import ru.javarush.asui.testapp.model.Status;
import ru.javarush.asui.testapp.model.ToDoItem;

import java.util.List;


public interface ToDoItemService extends GenericService<ToDoItem, Integer> {

    public List<ToDoItem> findByStatus(Status status);

}
