package com.inditex.test.infrastructure.rest.inputadapter.controllers;

import com.inditex.test.infrastructure.rest.inputadapter.dto.PriceDto;
import org.springframework.http.ResponseEntity;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

public interface ControllerPrice {
    ResponseEntity<List<PriceDto>> getPrices(Date date, Integer ProductId, Integer BrandId) throws ParseException;
}
