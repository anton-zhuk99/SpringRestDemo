package com.example.restdemo.repository;

import java.util.List;

/**
 * Generic CRUD repository.
 * @param <T> class for model
 * @param <D> class for DTO
 */
public interface CrudRepository<T, D> {

    void create(D dto); // T save(T obj)
    T read(Integer id);
    void update(T obj);
    void delete(Integer id);
    List<T> list();

}
