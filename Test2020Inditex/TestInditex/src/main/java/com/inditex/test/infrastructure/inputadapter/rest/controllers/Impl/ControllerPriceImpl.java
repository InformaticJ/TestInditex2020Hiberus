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

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/prices")
@RequiredArgsConstructor
public class ControllerPriceImpl implements ControllerPrice {


    private final PriceUseCase priceUseCase;

    private final PriceMapper priceMapper;

    @ApiOperation(value = "Get prices by a date", notes = "Return prices of a date inserted")
    @ApiResponses(value =  {
            @ApiResponse(code = 200, message = "List prices fetched successfully",
            examples = @Example(value = @ExampleProperty(mediaType = "application/json",
                    value = "[{ \"productId\": 35455, \"brandId\": \"1\", \"priceList\": \"4\", \"startDate\": \"2020-06-15T14:00:00.000+00:00\", \"endDate\": \"2020-12-31T22:59:59.000+00:00\", \"price\": \"38.95\" }]"))),
            @ApiResponse(code = 404, message = "Empty list")})
    @GetMapping
    public ResponseEntity<List<PriceDto>> getPrices(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date date, @RequestParam Integer productId, @RequestParam Integer brandId) {
        List<Price> listPrice = priceUseCase.getPrices(date,productId,brandId);
        if(listPrice.isEmpty()){
            return new ResponseEntity<>(priceMapper.priceListToPriceDtoList(listPrice), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(priceMapper.priceListToPriceDtoList(listPrice), HttpStatus.OK);
    }
}
