package com.inditex.test.infraestructura.rest.inputadapter.controllers;

import com.inditex.test.infraestructura.rest.inputadapter.dto.PriceDto;
import org.springframework.http.ResponseEntity;

import java.text.ParseException;
import java.util.List;

public interface ControllerPrice {
    ResponseEntity<List<PriceDto>> getPrices(String startDate, Integer idProduct, Integer idBrand) throws ParseException;
}
