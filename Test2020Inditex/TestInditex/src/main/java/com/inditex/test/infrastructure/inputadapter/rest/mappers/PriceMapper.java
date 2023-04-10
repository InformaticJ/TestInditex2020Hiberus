package com.inditex.test.infrastructure.inputadapter.rest.mappers;

import com.inditex.test.domain.Price;
import com.inditex.test.infrastructure.outputadapter.entities.PriceEntity;
import com.inditex.test.infrastructure.inputadapter.rest.dto.PriceDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper
public interface PriceMapper {
    PriceMapper INSTANCE = Mappers.getMapper( PriceMapper.class );
    @Mapping(source = "productId", target = "productId")
    @Mapping(source = "brandId", target = "brandId")
    @Mapping(source = "priceList", target = "priceList")
    @Mapping(source = "startDate", target = "startDate")
    @Mapping(source = "endDate", target = "endDate")
    @Mapping(source = "price", target = "price")
    PriceDto priceToPriceDto(Price price);
    Price priceEntityToPrice(PriceEntity priceEntity);
    default List<PriceDto> priceListToPriceDtoList(List<Price> priceList){
        return priceList.stream().map(this::priceToPriceDto).collect(Collectors.toList());
    }
    default List<Price> priceEntityListToPriceList(List<PriceEntity> priceEntitiesList){
        return priceEntitiesList.stream().map(this::priceEntityToPrice).collect(Collectors.toList());
    }
}
