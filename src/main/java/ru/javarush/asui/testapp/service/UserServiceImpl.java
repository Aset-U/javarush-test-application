package ru.javarush.asui.testapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.javarush.asui.testapp.dao.GenericDao;
import ru.javarush.asui.testapp.dao.UserDao;
import ru.javarush.asui.testapp.model.User;

import java.util.List;


@Service
public class UserServiceImpl extends GenericServiceImpl<User, Integer> implements UserService{

    private UserDao userDao;

    public UserServiceImpl() {
    }
    @Autowired
    public UserServiceImpl(@Qualifier("userDaoImpl") GenericDao<User, Integer> genericDao) {
        super(genericDao);
        this.userDao = (UserDao)genericDao;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<User> getByName(String name) {
        return userDao.findByName(name);
    }

    @Override
    public List<User> getPageList(Integer offset, Integer maxResults) {
        return userDao.getPageList(offset, maxResults);
    }

    @Override
    public Long count() {
        return userDao.count();
    }
}
