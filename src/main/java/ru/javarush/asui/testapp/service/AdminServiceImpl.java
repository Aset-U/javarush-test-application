package ru.javarush.asui.testapp.service;

import ru.javarush.asui.testapp.dao.AdminDao;
import ru.javarush.asui.testapp.dao.GenericDao;
import ru.javarush.asui.testapp.model.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AdminServiceImpl extends GenericServiceImpl<Admin, Integer>
        implements AdminService {

    private AdminDao adminDao;
    public AdminServiceImpl(){

    }
    @Autowired
    public AdminServiceImpl(
            @Qualifier("adminDaoImpl") GenericDao<Admin, Integer> genericDao) {
        super(genericDao);
        this.adminDao = (AdminDao) genericDao;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean removeAdmin(Integer id) {
        return adminDao.removeAdmin(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public boolean isAdminRegistered(String userName, String password) {
        return adminDao.isAdminRegistered(userName, password);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public Admin getAdmin(String userName) {
        return adminDao.getAdmin(userName);
    }
}
