package com.inditex.test.application;

import com.inditex.test.domain.Price;
import com.inditex.test.infrastructure.entities.PriceEntity;
import com.inditex.test.infrastructure.rest.mappers.PriceMapper;
import com.inditex.test.infrastructure.rest.outputadapter.RepositoryPrice;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;


@AutoConfigureMockMvc
@SpringBootTest
@ActiveProfiles("test")
class PriceUseCaseTest {

    @Mock
    RepositoryPrice repositoryPrice;
    @InjectMocks
    PriceUseCase priceUseCase;
    List<PriceEntity> prices = new ArrayList<>();
    PriceEntity price1 = new PriceEntity();
    PriceEntity price2 = new PriceEntity();
    PriceEntity price3 = new PriceEntity();
    PriceEntity price4 = new PriceEntity();

    @BeforeEach
    void init() throws ParseException {
        String pattern = ("yyyy-MM-dd-HH.mm.ss");
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        Date startDate1 = dateFormat.parse("2020-06-14-00.00.00");
        Date endDate1 = dateFormat.parse("2020-12-31-23.59.59");
        price1 = PriceEntity.builder()
                .brandId(1)
                .startDate(startDate1)
                .endDate(endDate1)
                .priceList(1)
                .productId(35455)
                .priority(0)
                .price(35.50)
                .curr("EUR")
                .build();
        Date startDate2 = dateFormat.parse("2020-06-14-15.00.00");
        Date endDate2 = dateFormat.parse("2020-06-14-18.30.00");
        price2 = PriceEntity.builder()
                .brandId(1)
                .startDate(startDate2)
                .endDate(endDate2)
                .priceList(2)
                .productId(35455)
                .priority(1)
                .price(25.45)
                .curr("EUR")
                .build();
        Date startDate3 = dateFormat.parse("2020-06-15-00.00.00");
        Date endDate3 = dateFormat.parse("2020-06-15-11.00.00");
        price3 = PriceEntity.builder()
                .brandId(1)
                .startDate(startDate3)
                .endDate(endDate3)
                .priceList(3)
                .productId(35455)
                .priority(1)
                .price(30.50)
                .curr("EUR")
                .build();
        Date startDate4 = dateFormat.parse("2020-06-15-16.00.00");
        Date endDate4 = dateFormat.parse("2020-12-31-23.59.59");
        price4 = PriceEntity.builder()
                .brandId(1)
                .startDate(startDate4)
                .endDate(endDate4)
                .priceList(4)
                .productId(35455)
                .priority(1)
                .price(38.95)
                .curr("EUR")
                .build();
        prices.add(price1);
        prices.add(price2);
        prices.add(price3);
        prices.add(price4);
    }


    @Test
    void getPricesTest1() throws ParseException {
        String pattern = ("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        when(repositoryPrice.findByDateBetweenAndBrandIdAndProductId(any(),anyInt(), anyInt())).thenReturn(prices);
        List<Price> priceList = priceUseCase.getPrices(dateFormat.parse("2020-12-31 23:59:58"), 35455, 1);
        List<PriceEntity> priceListExpected = new ArrayList<>();
        priceListExpected.add(price1);
        Assertions.assertEquals(PriceMapper.INSTANCE.priceEntityListToPriceList(priceListExpected), priceList);
    }
/*
    @Test
    void getPricesTest2() {
        when(repositoryPrice.findByProductIdAndBrandId(anyInt(), anyInt())).thenReturn(prices);
        List<Price> priceList = servicePrice.getPrices("2020-06-14-16.00.00", 35455, 1);
        List<Price> priceListExpected = new ArrayList<>();
        priceListExpected.add(price2);
        Assertions.assertEquals(priceListExpected, priceList);
    }

    @Test
    void getPricesTest3() {
        when(repositoryPrice.findByProductIdAndBrandId(anyInt(), anyInt())).thenReturn(prices);
        List<Price> priceList = servicePrice.getPrices("2020-06-14-21.00.00", 35455, 1);
        List<Price> priceListExpected = new ArrayList<>();
        priceListExpected.add(price1);
        Assertions.assertEquals(priceListExpected, priceList);
    }

    @Test
    void getPricesTest4() {
        when(repositoryPrice.findByProductIdAndBrandId(anyInt(), anyInt())).thenReturn(prices);
        List<Price> priceList = servicePrice.getPrices("2020-06-15-10.00.00", 35455, 1);
        List<Price> priceListExpected = new ArrayList<>();
        priceListExpected.add(price3);
        Assertions.assertEquals(priceListExpected, priceList);
    }

    @Test
    void getPricesTest5() {
        when(repositoryPrice.findByProductIdAndBrandId(anyInt(), anyInt())).thenReturn(prices);
        List<Price> priceList = servicePrice.getPrices("2020-06-14-21.00.00", 35455, 1);
        List<Price> priceListExpected = new ArrayList<>();
        priceListExpected.add(price1);
        Assertions.assertEquals(priceListExpected, priceList);
    }*/
}