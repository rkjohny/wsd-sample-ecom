package com.wsd.ecom.service;

import com.wsd.ecom.dto.MaxSaleDayDto;
import com.wsd.ecom.dto.SaleDto;
import com.wsd.ecom.entity.Sale;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.time.Instant;

@Service
public interface SaleService extends IService<Sale, SaleDto> {
//    /**
//     * @param startDate
//     * @param endDate
//     * @return total sale amount.
//     */
//    Double totalSale(Instant startDate, Instant endDate);
//    /**
//     * @param startDate
//     * @param endDate
//     * @return Maximum sale day of specific date range.
//     */
//    MaxSaleDayDto getMaxSaleDay(Instant startDate, Instant endDate) throws ParseException;
}
