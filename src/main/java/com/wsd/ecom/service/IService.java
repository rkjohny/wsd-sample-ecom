package com.wsd.ecom.service;


import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 *
 * @param <D> Dto object type
 * @param <E> entity type
 */
@Service
@Transactional
public interface IService<E, D> {
    /**
     * Save the item.
     *
     * @param entity the item to save.
     * @return the persisted item.
     */
    E save(E entity);

    E create(D dto);

    /**
     * Updates the item.
     *
     * @param entity the item to update.
     * @return the persisted item.
     */
    E update(E entity);


    /**
     * Get all the items.
     *
     * @param pageable the pagination information.
     * @return the list of items.
     */
    Page<E> findAll(Pageable pageable);

    /**
     * Get the item by Id.
     *
     * @param id the id of the item.
     * @return the item.
     */
    Optional<E> findOne(Long id);

    /**
     * Delete the item by Id.
     *
     * @param id the id of the item.
     */
    void delete(Long id);
}
