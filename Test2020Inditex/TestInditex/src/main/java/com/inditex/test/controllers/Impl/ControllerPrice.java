package com.inditex.test.controllers.Impl;

import com.inditex.test.dto.PriceDto;
import org.springframework.http.ResponseEntity;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

public interface ControllerPrice {
    ResponseEntity<List<PriceDto>> getPrices(String startDate, Integer idProduct, Integer idBrand) throws ParseException;
}
