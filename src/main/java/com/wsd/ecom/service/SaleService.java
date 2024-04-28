package com.wsd.ecom.service;

import com.wsd.ecom.mapper.SaleMapper;
import com.wsd.ecom.repository.SaleRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Slf4j
@Service
@Transactional
public class SaleService {
    private final SaleRepository repository;
    private final SaleMapper mapper;

    @Autowired
    public SaleService(SaleRepository repository, SaleMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }
}
