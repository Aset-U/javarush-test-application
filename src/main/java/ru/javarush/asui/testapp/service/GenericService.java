package ru.javarush.asui.testapp.service;

import java.util.List;

/**
 * Generic Service
 */
public interface GenericService<E, K> {

    public void saveOrUpdate(E entity);

    public List<E> getAll();

    public E get(K id);

    public void add(E entity);

    public void update(E entity);

    public void remove(E entity);

    public List<E> getPageList(Integer offset, Integer maxResults);

    public Long count();
}
