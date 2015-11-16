package ru.javarush.asui.testapp.service;

import ru.javarush.asui.testapp.model.User;

import java.util.List;

public interface UserService extends GenericService<User, Integer>{
    public List<User> getByName(String name);
    public List<User> getPageList(Integer offset, Integer maxResults);
    public Long count();
}
