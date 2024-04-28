package com.wsd.ecom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepository<E> extends JpaRepository<E, Long> {
}
