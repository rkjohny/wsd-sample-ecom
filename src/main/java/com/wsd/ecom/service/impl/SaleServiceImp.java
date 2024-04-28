package com.wsd.ecom.service.impl;

import com.wsd.ecom.service.SaleService;
import com.wsd.ecom.service.mapper.SaleMapper;
import com.wsd.ecom.repository.SaleRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Slf4j
@Service
@Transactional
public class SaleServiceImp implements SaleService {
    private final SaleRepository repository;
    private final SaleMapper mapper;

    @Autowired
    public SaleServiceImp(SaleRepository repository, SaleMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }
}
