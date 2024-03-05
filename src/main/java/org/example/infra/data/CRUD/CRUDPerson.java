package org.example.infra.data.CRUD;

import java.util.List;

public interface CRUDPerson <T>{
        void create(T o);
        void update(T newPerson, T person);
        void delete(T o);
        List<T> findAll();
}
