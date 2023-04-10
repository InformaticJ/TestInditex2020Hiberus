package com.inditex.test.infrastructure.inputadapter.rest.controllers;

import com.inditex.test.infrastructure.inputadapter.rest.dto.PriceDto;
import org.springframework.http.ResponseEntity;

import java.util.Date;
import java.util.List;

public interface ControllerPrice {
    ResponseEntity<List<PriceDto>> getPrices(Date date, Integer ProductId, Integer BrandId);
}
