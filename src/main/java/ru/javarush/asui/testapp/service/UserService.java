package ru.javarush.asui.testapp.service;

import ru.javarush.asui.testapp.model.User;

public interface UserService extends GenericService<User, Integer>{
    public User getByName(String name);
}
