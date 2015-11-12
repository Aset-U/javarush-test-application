package ru.javarush.asui.testapp.service;

import ru.javarush.asui.testapp.model.Admin;

/**
 * AdminService
 */
public interface AdminService extends GenericService<Admin,Integer>{
    public boolean removeAdmin(Integer id);
    public boolean isAdminRegistered(String userName, String password);
    public Admin getAdmin(String userName);
}
