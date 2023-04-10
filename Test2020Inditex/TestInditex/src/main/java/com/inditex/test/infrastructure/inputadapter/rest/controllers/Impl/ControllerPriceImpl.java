package com.inditex.test.infrastructure.inputadapter.rest.controllers.Impl;
import com.inditex.test.domain.Price;
import com.inditex.test.domain.ports.inputport.PriceUseCase;
import com.inditex.test.infrastructure.inputadapter.rest.controllers.ControllerPrice;
import com.inditex.test.infrastructure.inputadapter.rest.dto.PriceDto;
import com.inditex.test.infrastructure.inputadapter.rest.mappers.PriceMapper;
import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/prices")
@RequiredArgsConstructor
public class ControllerPriceImpl implements ControllerPrice {

    private final PriceUseCase priceUseCase;

    private final PriceMapper priceMapper;
    @GetMapping
    public ResponseEntity<List<PriceDto>> getPrices(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime date, @RequestParam Integer productId, @RequestParam Integer brandId) {
        List<Price> listPrice = priceUseCase.getPrices(date,productId,brandId);
        if(listPrice.isEmpty()){
            return new ResponseEntity<>(priceMapper.priceListToPriceDtoList(listPrice), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(priceMapper.priceListToPriceDtoList(listPrice), HttpStatus.OK);
    }
}
