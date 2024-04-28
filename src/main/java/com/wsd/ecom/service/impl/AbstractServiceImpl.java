package com.wsd.ecom.service.impl;

import com.wsd.ecom.exception.ObjectNotFoundException;
import com.wsd.ecom.mapper.DtoMapper;
import com.wsd.ecom.repository.IRepository;
import com.wsd.ecom.service.IService;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@Transactional
public class AbstractServiceImpl<E, D, R extends IRepository<E>, M extends DtoMapper<E, D>> implements IService<E, D> {

    private final R repository;
    private final M mapper;

    @Autowired
    public AbstractServiceImpl(R repository, M mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public E save(E entity) {
        return repository.save(entity);
    }

    @Override
    public E create(D dto) {
        return repository.save(mapper.toEntity(dto));
    }

    @Override
    public E update(E entity) {
        return repository.save(entity);
    }

    @Override
    public Page<E> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Optional<E> findOne(Long id) {
        return repository.findById(id);
    }

    @Override
    public void delete(Long id) {
        Optional<E> entity = findOne(id);
        if (entity.isEmpty())
            throw new ObjectNotFoundException(id);
        repository.delete(entity.get());
    }
}
