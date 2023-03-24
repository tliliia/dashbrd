package com.tronina.dashbrd.service;

import com.tronina.dashbrd.entity.BaseEntity;
import com.tronina.dashbrd.repository.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public abstract class AbstractService<E extends BaseEntity, R extends BaseRepository<E>>
        implements BaseService<E> {

    protected final R repository;

    @Autowired
    public AbstractService(R repository) {
        this.repository = repository;
    }

    public E findById(long id) {
        return repository.getReferenceById(id);
    }

    public List<E> findAll() {
        return repository.findAll();
    }

    public E saveOrUpdate(E entity) {
        return repository.save(entity);
    }

    public void delete(E entity) {
        repository.delete(entity);
    }

    public void deleteById(long id) {
        E entity = findById(id);
        repository.delete(entity);
    }

}