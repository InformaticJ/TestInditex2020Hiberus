package com.inditex.test.controllers;
import com.inditex.test.controllers.Impl.ControllerPrice;
import com.inditex.test.dto.PriceDto;
import com.inditex.test.mappers.MapperPrice;
import com.inditex.test.models.Price;
import com.inditex.test.services.ServicePrice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/prices")
public class ControllerPriceImpl implements ControllerPrice {
    @Autowired
    ServicePrice servicePrice;
    @Autowired
    MapperPrice mapperPrice;
    @GetMapping(value = "")
    public ResponseEntity<List<PriceDto>> getPrices(@RequestParam String date, @RequestParam Integer productId, @RequestParam Integer brandId) {
        List<Price> listPrice = servicePrice.getPrices(date,productId,brandId);
        return new ResponseEntity<>(mapperPrice.modelToDto(listPrice), HttpStatus.OK);
    }
}
