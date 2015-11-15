package ru.javarush.asui.testapp.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import ru.javarush.asui.testapp.model.User;

import java.util.List;

@Repository
public class UserDaoImpl extends GenericDaoImpl<User, Integer> implements UserDao {


    @Override
    public List<User>  findByName(String name) {
        List<User>  users = null;
        Criteria criteria = currentSession().createCriteria(User.class, "user");
        criteria.add(Restrictions.eq("user.name", name));
        users = (List<User> )criteria.list();

        return users;
    }

}
