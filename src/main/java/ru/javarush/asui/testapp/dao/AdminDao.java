package ru.javarush.asui.testapp.dao;

import ru.javarush.asui.testapp.model.Admin;

/**
 * Admin Dao interface
 */
public interface AdminDao extends GenericDao<Admin, Integer>{
    public boolean removeAdmin(Integer id);
    public boolean isAdminRegistered(String userName, String password);
    public Admin getAdmin(String username);
}
