package ru.javarush.asui.testapp.service;

import java.util.List;

/**
 * Generic Service
 */
public interface GenericService<E, K> {

    public void add(E entity);

    public void update(E entity);

    public E get(K id);

    public void delete(E entity);

    public List<E> getAll();
}
