package com.inditex.test.unit;

import com.inditex.test.application.PriceUseCaseImpl;
import com.inditex.test.domain.Price;
import com.inditex.test.infrastructure.outputadapter.RepositoryEntityPriceImpl;
import com.inditex.test.infrastructure.outputadapter.entities.PriceEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PriceUseCaseImplTest {
    @Mock
    RepositoryEntityPriceImpl repositoryEntityPriceImpl;
    @InjectMocks
    PriceUseCaseImpl priceUseCaseImpl;

    @Test
    void getPrices(){
        LocalDateTime startDate1 = LocalDateTime.parse("2020-06-14T00:00:00");
        LocalDateTime endDate1 = LocalDateTime.parse("2020-12-31T23:59:59");
        Price price1 = Price.builder()
                .brandId(1)
                .startDate(startDate1)
                .endDate(endDate1)
                .priceList(1)
                .productId(35455)
                .priority(0)
                .price(35.50)
                .curr("EUR")
                .build();
        List<Price> prices  = new ArrayList<>();
        prices.add(price1);
        when(repositoryEntityPriceImpl.getPrices(any(),anyInt(), anyInt())).thenReturn(prices);
        List<Price> priceList = priceUseCaseImpl.getPrices(LocalDateTime.parse("2020-06-14T10:00:00"), 35455, 1);
        List<Price> priceListExpected = new ArrayList<>();
        priceListExpected.add(price1);
        assertEquals(priceListExpected.get(0), priceList.get(0));
        verify(repositoryEntityPriceImpl).getPrices(any(),anyInt(), anyInt());
    }
}