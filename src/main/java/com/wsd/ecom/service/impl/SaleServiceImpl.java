package com.wsd.ecom.service.impl;

import com.wsd.ecom.dto.SaleDto;
import com.wsd.ecom.entity.Sale;
import com.wsd.ecom.mapper.SaleMapper;
import com.wsd.ecom.repository.SaleRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Slf4j
@Service
@Transactional
public class SaleServiceImpl extends AbstractServiceImpl<Sale, SaleDto, SaleRepository, SaleMapper> {
    private final SaleRepository repository;
    private final SaleMapper mapper;

    @Autowired
    public SaleServiceImpl(SaleRepository repository, SaleMapper mapper) {
        super(repository, mapper);
        this.repository = repository;
        this.mapper = mapper;
    }


}
