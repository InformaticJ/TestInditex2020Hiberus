package com.inditex.test.infrastructure.rest.outputadapter;

import com.inditex.test.application.PriceUseCase;
import com.inditex.test.domain.Price;
import com.inditex.test.infrastructure.entities.PriceEntity;
import com.inditex.test.infrastructure.rest.mappers.PriceMapper;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
@AutoConfigureMockMvc
@SpringBootTest
@ActiveProfiles("test")
class RepositoryPriceH2Test {

    @Mock
    RepositoryPrice repositoryPrice;
    @InjectMocks
    RepositoryPriceH2 repositoryPriceH2;
    List<PriceEntity> prices1 = new ArrayList<>();
    List<PriceEntity> prices2 = new ArrayList<>();
    List<PriceEntity> prices3 = new ArrayList<>();
    List<PriceEntity> prices4 = new ArrayList<>();
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
        prices1.add(price1);
        prices2.add(price2);
        prices3.add(price3);
        prices4.add(price4);
    }

    @Test
    void getPricesTest1() throws ParseException {
        String pattern = ("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        when(repositoryPrice.findByDateBetweenAndBrandIdAndProductId(any(),anyInt(), anyInt())).thenReturn(prices1);
        List<Price> priceList = repositoryPriceH2.getPrices(dateFormat.parse("2020-06-14 10:00:00"), 35455, 1);
        List<PriceEntity> priceListExpected = new ArrayList<>();
        priceListExpected.add(price1);
        Assertions.assertEquals(PriceMapper.INSTANCE.priceEntityToPrice(priceListExpected.get(0)).getBrandId(), priceList.get(0).getBrandId());
        Assertions.assertEquals(PriceMapper.INSTANCE.priceEntityToPrice(priceListExpected.get(0)).getProductId(), priceList.get(0).getProductId());
        Assertions.assertEquals(PriceMapper.INSTANCE.priceEntityToPrice(priceListExpected.get(0)).getPriceList(), priceList.get(0).getPriceList());
        Assertions.assertEquals(PriceMapper.INSTANCE.priceEntityToPrice(priceListExpected.get(0)).getStartDate(), priceList.get(0).getStartDate());
        Assertions.assertEquals(PriceMapper.INSTANCE.priceEntityToPrice(priceListExpected.get(0)).getEndDate(), priceList.get(0).getEndDate());
        Assertions.assertEquals(PriceMapper.INSTANCE.priceEntityToPrice(priceListExpected.get(0)).getPrice(), priceList.get(0).getPrice());
    }

    @Test
    void getPricesTest2() throws ParseException {
        String pattern = ("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        when(repositoryPrice.findByDateBetweenAndBrandIdAndProductId(any(),anyInt(), anyInt())).thenReturn(prices2);
        List<Price> priceList = repositoryPriceH2.getPrices(dateFormat.parse("2020-06-14 16:00:00"), 35455, 1);
        List<PriceEntity> priceListExpected = new ArrayList<>();
        priceListExpected.add(price2);
        Assertions.assertEquals(PriceMapper.INSTANCE.priceEntityToPrice(priceListExpected.get(0)).getBrandId(), priceList.get(0).getBrandId());
        Assertions.assertEquals(PriceMapper.INSTANCE.priceEntityToPrice(priceListExpected.get(0)).getProductId(), priceList.get(0).getProductId());
        Assertions.assertEquals(PriceMapper.INSTANCE.priceEntityToPrice(priceListExpected.get(0)).getPriceList(), priceList.get(0).getPriceList());
        Assertions.assertEquals(PriceMapper.INSTANCE.priceEntityToPrice(priceListExpected.get(0)).getStartDate(), priceList.get(0).getStartDate());
        Assertions.assertEquals(PriceMapper.INSTANCE.priceEntityToPrice(priceListExpected.get(0)).getEndDate(), priceList.get(0).getEndDate());
        Assertions.assertEquals(PriceMapper.INSTANCE.priceEntityToPrice(priceListExpected.get(0)).getPrice(), priceList.get(0).getPrice());
    }

    @Test
    void getPricesTest3() throws ParseException {
        String pattern = ("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        when(repositoryPrice.findByDateBetweenAndBrandIdAndProductId(any(),anyInt(), anyInt())).thenReturn(prices1);
        List<Price> priceList = repositoryPriceH2.getPrices(dateFormat.parse("2020-06-14 21:00:00"), 35455, 1);
        List<PriceEntity> priceListExpected = new ArrayList<>();
        priceListExpected.add(price1);
        Assertions.assertEquals(PriceMapper.INSTANCE.priceEntityToPrice(priceListExpected.get(0)).getBrandId(), priceList.get(0).getBrandId());
        Assertions.assertEquals(PriceMapper.INSTANCE.priceEntityToPrice(priceListExpected.get(0)).getProductId(), priceList.get(0).getProductId());
        Assertions.assertEquals(PriceMapper.INSTANCE.priceEntityToPrice(priceListExpected.get(0)).getPriceList(), priceList.get(0).getPriceList());
        Assertions.assertEquals(PriceMapper.INSTANCE.priceEntityToPrice(priceListExpected.get(0)).getStartDate(), priceList.get(0).getStartDate());
        Assertions.assertEquals(PriceMapper.INSTANCE.priceEntityToPrice(priceListExpected.get(0)).getEndDate(), priceList.get(0).getEndDate());
        Assertions.assertEquals(PriceMapper.INSTANCE.priceEntityToPrice(priceListExpected.get(0)).getPrice(), priceList.get(0).getPrice());
    }

    @Test
    void getPricesTest4() throws ParseException {
        String pattern = ("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        when(repositoryPrice.findByDateBetweenAndBrandIdAndProductId(any(),anyInt(), anyInt())).thenReturn(prices3);
        List<Price> priceList = repositoryPriceH2.getPrices(dateFormat.parse("2020-06-15 10:00:00"), 35455, 1);
        List<PriceEntity> priceListExpected = new ArrayList<>();
        priceListExpected.add(price3);
        Assertions.assertEquals(PriceMapper.INSTANCE.priceEntityToPrice(priceListExpected.get(0)).getBrandId(), priceList.get(0).getBrandId());
        Assertions.assertEquals(PriceMapper.INSTANCE.priceEntityToPrice(priceListExpected.get(0)).getProductId(), priceList.get(0).getProductId());
        Assertions.assertEquals(PriceMapper.INSTANCE.priceEntityToPrice(priceListExpected.get(0)).getPriceList(), priceList.get(0).getPriceList());
        Assertions.assertEquals(PriceMapper.INSTANCE.priceEntityToPrice(priceListExpected.get(0)).getStartDate(), priceList.get(0).getStartDate());
        Assertions.assertEquals(PriceMapper.INSTANCE.priceEntityToPrice(priceListExpected.get(0)).getEndDate(), priceList.get(0).getEndDate());
        Assertions.assertEquals(PriceMapper.INSTANCE.priceEntityToPrice(priceListExpected.get(0)).getPrice(), priceList.get(0).getPrice());
    }

    @Test
    void getPricesTest5() throws ParseException {
        String pattern = ("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        when(repositoryPrice.findByDateBetweenAndBrandIdAndProductId(any(),anyInt(), anyInt())).thenReturn(prices1);
        List<Price> priceList = repositoryPriceH2.getPrices(dateFormat.parse("2020-06-14 21:00:00"), 35455, 1);
        List<PriceEntity> priceListExpected = new ArrayList<>();
        priceListExpected.add(price1);
        Assertions.assertEquals(PriceMapper.INSTANCE.priceEntityToPrice(priceListExpected.get(0)).getBrandId(), priceList.get(0).getBrandId());
        Assertions.assertEquals(PriceMapper.INSTANCE.priceEntityToPrice(priceListExpected.get(0)).getProductId(), priceList.get(0).getProductId());
        Assertions.assertEquals(PriceMapper.INSTANCE.priceEntityToPrice(priceListExpected.get(0)).getPriceList(), priceList.get(0).getPriceList());
        Assertions.assertEquals(PriceMapper.INSTANCE.priceEntityToPrice(priceListExpected.get(0)).getStartDate(), priceList.get(0).getStartDate());
        Assertions.assertEquals(PriceMapper.INSTANCE.priceEntityToPrice(priceListExpected.get(0)).getEndDate(), priceList.get(0).getEndDate());
        Assertions.assertEquals(PriceMapper.INSTANCE.priceEntityToPrice(priceListExpected.get(0)).getPrice(), priceList.get(0).getPrice());
    }
}