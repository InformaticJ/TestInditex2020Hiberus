package com.inditex.test.infrastructure.inputadapter.rest.controllers;

import com.inditex.test.infrastructure.inputadapter.rest.dto.PriceDto;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface ControllerPrice {
    @ApiOperation(value = "Get prices by a date", notes = "Return prices of a date inserted")
    @ApiResponses(value =  {
            @ApiResponse(code = 200, message = "List prices fetched successfully",
                    examples = @Example(value = @ExampleProperty(mediaType = "application/json",
                            value = "[{ \"productId\": 35455, \"brandId\": \"1\", \"priceList\": \"4\", \"startDate\": \"2020-06-15T14:00:00.000+00:00\", \"endDate\": \"2020-12-31T22:59:59.000+00:00\", \"price\": \"38.95\" }]"))),
            @ApiResponse(code = 404, message = "Empty list")})
    ResponseEntity<List<PriceDto>> getPrices(LocalDateTime date, Integer ProductId, Integer BrandId);
}
