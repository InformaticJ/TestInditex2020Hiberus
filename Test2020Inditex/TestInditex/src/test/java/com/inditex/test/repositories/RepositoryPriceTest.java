package com.inditex.test.repositories;
import com.inditex.test.models.Price;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class RepositoryPriceTest {
    @Autowired
    TestEntityManager entityManager;
    @Autowired
    RepositoryPrice repositoryPrice;
    String pattern=("yyyy-MM-dd-HH.mm.ss");
    SimpleDateFormat dateFormat= new SimpleDateFormat(pattern);
    @Test
    void findByProductIdAndBrandId() throws ParseException {
        Date startDate = dateFormat.parse("2020-06-14-00.00.00");
        Date endDate = dateFormat.parse("2020-12-31-23.59.59");
        Price price = Price.builder()
                .brandId(1)
                .startDate(startDate)
                .endDate(endDate)
                .priceList(1)
                .productId(35455)
                .priority(0)
                .price(35.50)
                .curr("EUR")
                .build();
        entityManager.persistAndFlush(price);
        Assertions.assertEquals(price,repositoryPrice.findByProductIdAndBrandId(35455,1).get(0));
    }

    @Test
    void existsByBrandId() throws ParseException {
        Date startDate = dateFormat.parse("2020-06-14-00.00.00");
        Date endDate = dateFormat.parse("2020-12-31-23.59.59");
        Price price = Price.builder()
                .brandId(1)
                .startDate(startDate)
                .endDate(endDate)
                .priceList(1)
                .productId(35455)
                .priority(0)
                .price(35.50)
                .curr("EUR")
                .build();
        entityManager.persistAndFlush(price);
        Assertions.assertEquals(true,repositoryPrice.existsByBrandId(1));
    }

    @Test
    void existsByProductId() throws ParseException {
        Date startDate = dateFormat.parse("2020-06-14-00.00.00");
        Date endDate = dateFormat.parse("2020-12-31-23.59.59");
        Price price = Price.builder()
                .brandId(1)
                .startDate(startDate)
                .endDate(endDate)
                .priceList(1)
                .productId(35455)
                .priority(0)
                .price(35.50)
                .curr("EUR")
                .build();
        entityManager.persistAndFlush(price);
        Assertions.assertEquals(true,repositoryPrice.existsByProductId(35455));
    }
}