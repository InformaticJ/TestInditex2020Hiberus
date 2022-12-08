package com.inditex.test.controllers;
import com.inditex.test.dto.PriceDtoResponse;
import com.inditex.test.models.Price;
import com.inditex.test.services.ServicePrice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/prices")
public class ControllerPrice {
    @Autowired
    ServicePrice servicePrice;
    @GetMapping(value = "")
    ResponseEntity<List<PriceDtoResponse>> getPrices(@RequestParam String startDate, @RequestParam Integer idProduct,@RequestParam Integer idBrand){
        List<Price> listPrice = servicePrice.getPrices(startDate,idProduct,idBrand);
        List<PriceDtoResponse> priceDtoResponseList = new ArrayList<>();
        for(Price price : listPrice) {
            PriceDtoResponse priceDtoResponse = PriceDtoResponse.builder()
                    .brandId(price.getBrandId())
                    .startDate(price.getStartDate())
                    .endDate(price.getEndDate())
                    .priceList(price.getPriceList())
                    .productId(price.getProductId())
                    .price(price.getPrice())
                    .build();
            priceDtoResponseList.add(priceDtoResponse);
        }
        return new ResponseEntity<>(priceDtoResponseList, HttpStatus.OK);
    }
}
