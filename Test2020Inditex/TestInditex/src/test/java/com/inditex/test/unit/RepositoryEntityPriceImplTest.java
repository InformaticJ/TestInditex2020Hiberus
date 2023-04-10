package com.inditex.test.unit;
import com.inditex.test.domain.Price;
import com.inditex.test.domain.ports.outputport.RepositoryEntityPrice;
import com.inditex.test.infrastructure.inputadapter.rest.mappers.PriceEntityMapper;
import com.inditex.test.infrastructure.outputadapter.RepositoryEntityPriceImpl;
import com.inditex.test.infrastructure.outputadapter.RepositoryPriceJPA;
import com.inditex.test.infrastructure.outputadapter.entities.PriceEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RepositoryEntityPriceImplTest {
    @Mock
    RepositoryPriceJPA repositoryPriceJPA;
    @InjectMocks
    RepositoryEntityPriceImpl repositoryEntityPriceImpl;
    @Mock
    PriceEntityMapper priceEntityMapper;

    @Test
    void getPrices() throws ParseException {
        LocalDateTime startDate1 = LocalDateTime.parse("2020-06-14T00:00:00");
        LocalDateTime endDate1 = LocalDateTime.parse("2020-12-31T23:59:59");
        PriceEntity price1 = PriceEntity.builder()
                .brandId(1)
                .startDate(startDate1)
                .endDate(endDate1)
                .priceList(1)
                .productId(35455)
                .priority(0)
                .price(35.50)
                .curr("EUR")
                .build();
        Price price2 = Price.builder()
                .brandId(1)
                .startDate(startDate1)
                .endDate(endDate1)
                .priceList(1)
                .productId(35455)
                .priority(0)
                .price(35.50)
                .curr("EUR")
                .build();
        List<PriceEntity> prices  = new ArrayList<>();
        prices.add(price1);
        when(repositoryPriceJPA.findByDateBetweenAndBrandIdAndProductId(any(),anyInt(), anyInt())).thenReturn(prices);
        when(priceEntityMapper.priceEntityListToPriceList(any())).thenReturn(List.of(price2));
        List<Price> priceList = repositoryEntityPriceImpl.getPrices(LocalDateTime.parse("2020-06-14T10:00:00"), 35455, 1);
        List<Price> priceListExpected = new ArrayList<>();
        priceListExpected.add(price2);
        assertEquals(priceListExpected.get(0), priceList.get(0));
        verify(repositoryPriceJPA).findByDateBetweenAndBrandIdAndProductId(any(),anyInt(), anyInt());
        verify(priceEntityMapper).priceEntityListToPriceList(any());
    }
}