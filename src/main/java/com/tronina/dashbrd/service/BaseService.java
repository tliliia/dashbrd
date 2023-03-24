package com.tronina.dashbrd.service;

import com.tronina.dashbrd.entity.BaseEntity;

import java.util.List;

public interface BaseService<E extends BaseEntity> {
    /**
     * Получить элемент по id
     * @param id идентификатор элемента
     * @return элемент
     */
    E findById(long id);

    /**
     * Получить список всех эдементов в репозитории
     * @return список всех эдементов в репозитории
     */
    List<E> findAll();

    /**
     * Сохранить или изменить элемент
     * @param entity элемент
     * @return созданный/измененный элемент
     */
    E saveOrUpdate(E entity);

    /**
     * Удалить элемент
     * @param entity элемент
     */
    void delete(E entity);

    /**
     * Удалиьт элент по соответсвующему идентификатору
     * @param id идентификатор элемента
     */
    void deleteById(long id);
}
