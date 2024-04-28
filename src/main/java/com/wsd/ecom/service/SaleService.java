package com.wsd.ecom.service;

import com.wsd.ecom.repository.SaleRepository;
import com.wsd.ecom.mapper.SaleMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class SaleService {
    private final SaleRepository repository;
    private final SaleMapper mapper;
}
