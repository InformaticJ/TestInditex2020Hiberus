package com.inditex.test.services.Impl;
import com.inditex.test.models.Price;
import com.inditex.test.repositories.RepositoryPrice;
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
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@AutoConfigureMockMvc
@SpringBootTest
@ActiveProfiles("test")
class ServicePriceImplTest{
    @Mock
    RepositoryPrice repositoryPrice;
    @InjectMocks
    ServicePriceImpl servicePrice;
    List<Price> prices = new ArrayList<>();
    Price price1 = new Price();
    Price price2 = new Price();
    Price price3 = new Price();
    Price price4 = new Price();
    @BeforeEach
    void init() throws ParseException {
        String pattern=("yyyy-MM-dd-HH.mm.ss");
        SimpleDateFormat dateFormat= new SimpleDateFormat(pattern);
        Date startDate1 = dateFormat.parse("2020-06-14-00.00.00");
        Date endDate1 = dateFormat.parse("2020-12-31-23.59.59");
        price1 = Price.builder()
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
        price2 = Price.builder()
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
        price3 = Price.builder()
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
        price4 = Price.builder()
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
    void getPricesTest1() {
        when(repositoryPrice.findByProductIdAndBrandId(anyInt(),anyInt())).thenReturn(prices);
        when(repositoryPrice.existsByBrandId(anyInt())).thenReturn(true);
        when(repositoryPrice.existsByProductId(anyInt())).thenReturn(true);
        List<Price> priceList = servicePrice.getPrices("2020-06-14-10.00.00",35455,1);
        List<Price> priceListExpected = new ArrayList<>();
        priceListExpected.add(price1);
        Assertions.assertEquals(priceListExpected,priceList);
    }
    @Test
    void getPricesTest2() {
        when(repositoryPrice.findByProductIdAndBrandId(anyInt(),anyInt())).thenReturn(prices);
        when(repositoryPrice.existsByBrandId(anyInt())).thenReturn(true);
        when(repositoryPrice.existsByProductId(anyInt())).thenReturn(true);
        List<Price> priceList = servicePrice.getPrices("2020-06-14-16.00.00",35455,1);
        List<Price> priceListExpected = new ArrayList<>();
        priceListExpected.add(price2);
        Assertions.assertEquals(priceListExpected,priceList);
    }

    @Test
    void getPricesTest3() {
        when(repositoryPrice.findByProductIdAndBrandId(anyInt(),anyInt())).thenReturn(prices);
        when(repositoryPrice.existsByBrandId(anyInt())).thenReturn(true);
        when(repositoryPrice.existsByProductId(anyInt())).thenReturn(true);
        List<Price> priceList = servicePrice.getPrices("2020-06-14-21.00.00",35455,1);
        List<Price> priceListExpected = new ArrayList<>();
        priceListExpected.add(price1);
        Assertions.assertEquals(priceListExpected,priceList);
    }

    @Test
    void getPricesTest4() {
        when(repositoryPrice.findByProductIdAndBrandId(anyInt(),anyInt())).thenReturn(prices);
        when(repositoryPrice.existsByBrandId(anyInt())).thenReturn(true);
        when(repositoryPrice.existsByProductId(anyInt())).thenReturn(true);
        List<Price> priceList = servicePrice.getPrices("2020-06-15-10.00.00",35455,1);
        List<Price> priceListExpected = new ArrayList<>();
        priceListExpected.add(price3);
        Assertions.assertEquals(priceListExpected,priceList);
    }

    @Test
    void getPricesTest5() {
        when(repositoryPrice.findByProductIdAndBrandId(anyInt(),anyInt())).thenReturn(prices);
        when(repositoryPrice.existsByBrandId(anyInt())).thenReturn(true);
        when(repositoryPrice.existsByProductId(anyInt())).thenReturn(true);
        List<Price> priceList = servicePrice.getPrices("2020-06-14-21.00.00",35455,1);
        List<Price> priceListExpected = new ArrayList<>();
        priceListExpected.add(price1);
        Assertions.assertEquals(priceListExpected,priceList);
    }
}

