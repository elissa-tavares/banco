package org.example.infra.data.CRUD;


import java.util.List;

public interface CRUD<T> {
    void create(T o);
    T read(Integer key);
    void update(T o, T key);
    void delete(T o);
    List<T> findAll();
}
