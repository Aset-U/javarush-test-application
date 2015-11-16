package ru.javarush.asui.testapp.dao;

import ru.javarush.asui.testapp.model.User;

import java.util.List;


public interface UserDao extends GenericDao<User, Integer> {
        public List<User> findByName(String name);
        public List<User> getPageList(Integer offset, Integer maxResults);
        public Long count();
}
