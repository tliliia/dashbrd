package com.tronina.dashbrd.service;

import com.tronina.dashbrd.entity.BaseEntity;
import com.tronina.dashbrd.repository.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Optional;

public abstract class AbstractService<E extends BaseEntity, R extends BaseRepository<E>>
        implements BaseService<E> {

    protected final R repository;

    @Autowired
    public AbstractService(R repository) {
        this.repository = repository;
    }

    public E findById(long id) {
        Optional<E> optionalE = repository.findById(id);
        if (optionalE.isPresent()) {
            return optionalE.get();
        } else {
            throw new RuntimeException(HttpStatus.NOT_FOUND.toString());
        }
    }

    public List<E> findAll() {
        return repository.findAll();
    }

    public E create(E entity) {
        return repository.save(entity);
    }

    public E update(long id, E entity) {
        E originalEntity = findById(id);
        originalEntity.fillFromModel(entity);
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