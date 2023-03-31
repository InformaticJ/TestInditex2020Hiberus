package com.inditex.test.infraestructura.rest.inputadapter.controllers.Impl;
import com.inditex.test.dominio.Price;
import com.inditex.test.dominio.ports.inputport.PricePort;
import com.inditex.test.infraestructura.rest.mappers.PriceMapper;
import com.inditex.test.infraestructura.rest.inputadapter.dto.PriceDto;
import com.inditex.test.infraestructura.rest.inputadapter.controllers.ControllerPrice;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/prices")
@RequiredArgsConstructor
public class ControllerPriceImpl implements ControllerPrice {
    @Autowired
    PricePort pricePort;
    @GetMapping
    public ResponseEntity<List<PriceDto>> getPrices(@RequestParam String date, @RequestParam Integer productId, @RequestParam Integer brandId) {
        List<Price> listPrice = pricePort.getPrices(date,productId,brandId);
        return new ResponseEntity<>(PriceMapper.INSTANCE.priceListToPriceDtoList(listPrice), HttpStatus.OK);
    }
}
