package com.wsd.ecom.repository;


import com.wsd.ecom.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.Instant;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {

    @Query("SELECT sum(s.amount) FROM Sale s WHERE s.createdDate >=:date AND s.status='V'")
    Double getTotalSaleAmountAfterDate(@Param("date") Instant date);
}
