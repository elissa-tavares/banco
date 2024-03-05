package org.example.infra.repository;

import org.example.infra.data.CRUD.CRUD;


public interface Repository<T> extends CRUD<T> {
    boolean existingByNUmber(Integer key);
    boolean existingByCPF(String key);
}
