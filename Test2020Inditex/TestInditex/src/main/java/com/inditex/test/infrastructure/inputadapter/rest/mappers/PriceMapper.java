package com.inditex.test.infrastructure.inputadapter.rest.mappers;
import com.inditex.test.domain.Price;
import com.inditex.test.infrastructure.inputadapter.rest.dto.PriceDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
@Mapper(componentModel = "spring")
public interface PriceMapper {
    @Mapping(source = "productId", target = "productId")
    @Mapping(source = "brandId", target = "brandId")
    @Mapping(source = "priceList", target = "priceList")
    @Mapping(source = "startDate", target = "startDate")
    @Mapping(source = "endDate", target = "endDate")
    @Mapping(source = "price", target = "price")
    PriceDto priceToPriceDto(Price price);
    List<PriceDto> priceListToPriceDtoList(List<Price> priceList);
}
