package ru.javarush.asui.testapp.dao;

import ru.javarush.asui.testapp.model.User;


public interface UserDao extends GenericDao<User, Integer> {
        public User findByName(String name);
}
