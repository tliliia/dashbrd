package com.tronina.dashbrd.service;

import com.tronina.dashbrd.entity.BaseEntity;

public interface BaseService<E extends BaseEntity> {
    E findById(long id);

    Iterable<E> findAll();

    E saveOrUpdate(E entity);

    void delete(E entity);

    void deleteById(long id);
}
