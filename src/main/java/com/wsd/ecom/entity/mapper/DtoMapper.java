package com.wsd.ecom.entity.mapper;

import org.springframework.stereotype.Component;

import java.util.List;
/**
 * @param <D> - DTO.
 * @param <E> - Entity
 */

public interface DtoMapper<E, D> {
    E toEntity(D dto);

    D toDto(E entity);

    List<E> toEntity(List<D> dtoList);

    List<D> toDto(List<E> entityList);
}
