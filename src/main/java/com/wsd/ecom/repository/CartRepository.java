package com.wsd.ecom.repository;

import com.wsd.ecom.entity.Cart;
import com.wsd.ecom.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

    @Query("SELECT c FROM Cart c WHERE c.customer.id=:userId AND c.status=:status")
    Optional<Cart> findOneByUserAndStatus(@Param("userId") Long userId, @Param("status") Status status);

    @Query("SELECT c FROM Cart c WHERE c.status=:status")
    List<Cart> getAllByStatus(@Param("status") Status status);
}
