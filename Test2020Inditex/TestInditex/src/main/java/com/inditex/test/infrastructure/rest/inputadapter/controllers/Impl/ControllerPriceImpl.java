package com.inditex.test.infrastructure.rest.inputadapter.controllers.Impl;
import com.inditex.test.domain.Price;
import com.inditex.test.domain.ports.inputport.PricePort;
import com.inditex.test.infrastructure.rest.mappers.PriceMapper;
import com.inditex.test.infrastructure.rest.inputadapter.dto.PriceDto;
import com.inditex.test.infrastructure.rest.inputadapter.controllers.ControllerPrice;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.Example;
import io.swagger.annotations.ExampleProperty;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/prices")
@RequiredArgsConstructor
public class ControllerPriceImpl implements ControllerPrice {
    @Autowired
    PricePort pricePort;
    @ApiOperation(value = "Get prices by a date", notes = "Return prices of a date inserted")
    @ApiResponse(code = 200, message = "List prices fetched successfully",
            examples = @Example(value = @ExampleProperty(mediaType = "application/json",
                    value = "[{ \"productId\": 35455, \"brandId\": \"1\", \"priceList\": \"4\", \"startDate\": \"2020-06-15T14:00:00.000+00:00\", \"endDate\": \"2020-12-31T22:59:59.000+00:00\", \"price\": \"38.95\" }]")))
    @GetMapping
    public ResponseEntity<List<PriceDto>> getPrices(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date date, @RequestParam Integer productId, @RequestParam Integer brandId) {
        List<Price> listPrice = pricePort.getPrices(date,productId,brandId);
        return new ResponseEntity<>(PriceMapper.INSTANCE.priceListToPriceDtoList(listPrice), HttpStatus.OK);
    }
}
