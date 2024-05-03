package com.wsd.ecom.service;

import com.wsd.ecom.dto.types.*;
import com.wsd.ecom.repository.SaleRepository;
import com.wsd.ecom.entity.mapper.SaleMapper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;


@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class SaleService {
    private final SaleRepository repository;
    private final SaleMapper mapper;

    private final EntityManager entityManager;

    public Double getTotalSaleAmountOfCurrentDate() {
        Instant date = Instant.now().truncatedTo(ChronoUnit.DAYS);
        Instant start = date;
        Instant end = date.plus(1, ChronoUnit.DAYS);
        return repository.getTotalSaleAmountAfterDate(start, end);
    }

    public GetMaxSaleDayOutput getMaxSaleDay(LocalDate start, LocalDate end) {
        GetMaxSaleDayOutput output = new GetMaxSaleDayOutput();

        StringBuffer sb = new StringBuffer();
        sb.append("SELECT sum(s.amount) as amount, DATE(s.createdDate) as dt");
        sb.append(" FROM Sale s WHERE s.createdDate BETWEEN :startDate AND :endDate AND s.status='V'");
        sb.append(" GROUP BY dt");
        sb.append(" ORDER BY amount DESC");
        sb.append(" LIMIT 1");

        Query q = entityManager.createQuery(sb.toString());
        q.setParameter("startDate", start.atStartOfDay(ZoneId.systemDefault()).toInstant());
        q.setParameter("endDate", end.atStartOfDay(ZoneId.systemDefault()).toInstant());

        List list = q.getResultList();
        if (list.size() > 0) {
            Object[] objects = (Object[]) list.get(0);
            Double amount = (Double)objects[0];
            Date d = (Date)objects[1];

            output.setAmount(amount);
            output.setDate(d.toLocalDate());
        }
        return output;
    }

    public GetTopSellingItemByPriceOutput getTop5SellingItemByAmount() {
        GetTopSellingItemByPriceOutput output = new GetTopSellingItemByPriceOutput();
        StringBuffer sb = new StringBuffer();
        sb.append("SELECT sum(s.amount) as amount, s.item.id as itemId, s.item.name as itemName");
        sb.append(" FROM Sale s WHERE s.status='V'");
        sb.append(" GROUP BY itemId, itemName");
        sb.append(" ORDER BY amount DESC");
        sb.append(" LIMIT 5");

        Query q = entityManager.createQuery(sb.toString());
        List list = q.getResultList();

        for(int i = 0; i<5 && i<list.size(); i++) {
            Object[] row = (Object[])list.get(i);

            Double amount = (Double)row[0];
            Long id = (Long)row[1];
            String name = (String)row[2];

            TopItemByAmount item = new TopItemByAmount(id, name, amount);
            output.getTopItems().add(item);
        }
        return output;
    }

    public GetTopSellingItemByQuantityOutput getTop5SellingItemInLastMonthByQuantity() {
        GetTopSellingItemByQuantityOutput output = new GetTopSellingItemByQuantityOutput();

        ZonedDateTime now = Instant.now().atZone(ZoneId.systemDefault());
        ZonedDateTime firstDayOfCurrentMonth = now.truncatedTo(ChronoUnit.DAYS).withDayOfMonth(1);
        ZonedDateTime start = firstDayOfCurrentMonth.minus(1, ChronoUnit.MONTHS);
        ZonedDateTime end = firstDayOfCurrentMonth.minusNanos(1);

        StringBuffer sb = new StringBuffer();
        sb.append("SELECT sum(s.quantity) as quantity, s.item.id as itemId, s.item.name as itemName");
        sb.append(" FROM Sale s WHERE s.status='V'");
        sb.append(" AND s.createdDate BETWEEN :startDate AND :endDate");
        sb.append(" GROUP BY itemId, itemName");
        sb.append(" ORDER BY quantity DESC");
        sb.append(" LIMIT 5");

        Query q = entityManager.createQuery(sb.toString());
        q.setParameter("startDate", start.toInstant());
        q.setParameter("endDate", end.toInstant());

        List list = q.getResultList();

        for(int i = 0; i<5 && i<list.size(); i++) {
            Object[] row = (Object[])list.get(i);

            long quantity = (Long)row[0];
            Long id = (Long)row[1];
            String name = (String)row[2];

            TopItemByQuantity item = new TopItemByQuantity(id, name, quantity);
            output.getTopItems().add(item);
        }
        return output;
    }
}
