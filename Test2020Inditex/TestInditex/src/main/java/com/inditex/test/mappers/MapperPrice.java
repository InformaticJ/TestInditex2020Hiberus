package com.inditex.test.mappers;

import com.inditex.test.dto.PriceDto;
import com.inditex.test.models.Price;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MapperPrice {
    public List<PriceDto> modelToDto(List<Price>pricesList){
        List<PriceDto> pricesDtoList= new ArrayList<>();
        for (Price price : pricesList) {
            PriceDto priceDto = PriceDto.builder()
                    .brandId(price.getBrandId())
                    .startDate(price.getStartDate())
                    .endDate(price.getEndDate())
                    .priceList(price.getPriceList())
                    .productId(price.getProductId())
                    .price(price.getPrice())
                    .build();
            pricesDtoList.add(priceDto);
        }
        return pricesDtoList;
    }
}
