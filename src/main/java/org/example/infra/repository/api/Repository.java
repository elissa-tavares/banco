package org.example.infra.repository.api;

import org.example.infra.database.api.CRUD.CRUD;


public interface Repository<T> extends CRUD<T> {
    boolean existingByNUmber(Integer key);
    boolean existingByCPF(String key);
}
