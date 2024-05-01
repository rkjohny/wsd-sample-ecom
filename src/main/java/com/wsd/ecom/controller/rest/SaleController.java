package com.wsd.ecom.controller.rest;


import com.wsd.ecom.core.SaleApi;
import com.wsd.ecom.dto.types.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/sales")
public class SaleController {
    private final SaleApi saleApi;

    /**
     * {@code GET  /api/v1/sales/total/amount} :
     *
     * Get total sale amount of the current date.
     *
     * @return the {@link ResponseEntity} with total amount in {@link TotalSaleOfCurrentDateOutput} object
     */
    @GetMapping("/total/amount")
    @ResponseBody
    public ResponseEntity<TotalSaleOfCurrentDateOutput> getTotalSaleAmountOfCurrentDate() {
        TotalSaleOfCurrentDateOutput output = saleApi.getTotalSaleAmountOfCurrentDate();
        return ResponseEntity.ok(output);
    }

    /**
     * {@code POST  /api/v1/sales/max-sale-day} :
     *
     * Returns the maximum sale date in a certain time period
     *
     * @param input {
     *              startDate: start date of the time period in format yyyy-mm-dd
     *              endDate:   end date of the time period in format yyyy-mm-dd
     * }
     * @return {@link GetMaxSaleDayOutput} on success
     */
    @PostMapping(value = "/max-sale-day", produces = MediaType.APPLICATION_JSON_VALUE )
    @ResponseBody
    public ResponseEntity<GetMaxSaleDayOutput> getMaxSaleDay(GetMaxSaleDayInput input) {
        GetMaxSaleDayOutput output = saleApi.getMaxSaleDay(input);
        return ResponseEntity.ok(output);
    }

    /**
     * {@code GET  /api/v1/sales/top-five-selling-item-by-amount} :
     *
     * Returns the top 5 selling items of all time based on total sale amount
     *
     * @return {@link GetTopSellingItemByPriceOutput} on success
     */
    @GetMapping("/top-five-selling-item-by-amount")
    @ResponseBody
    public ResponseEntity<GetTopSellingItemByPriceOutput> getTop5SellingItemByAmount() {
        GetTopSellingItemByPriceOutput output = saleApi.getTop5SellingItemByAmount();
        return ResponseEntity.ok(output);
    }

    /**
     * {@code GET  /api/v1/sales/top-five-selling-item-by-quantity} :
     *
     * Returns the top 5 selling items of last month based on number of sales
     *
     * @return {@link GetTopSellingItemByQuantityOutput} on success
     */
    @GetMapping("/top-five-selling-item-by-quantity")
    @ResponseBody
    public ResponseEntity<GetTopSellingItemByQuantityOutput> getTop5SellingItemInLastMonthByQuantity() {
        GetTopSellingItemByQuantityOutput output = saleApi.getTop5SellingItemInLastMonthByQuantity();
        return ResponseEntity.ok(output);
    }
}
