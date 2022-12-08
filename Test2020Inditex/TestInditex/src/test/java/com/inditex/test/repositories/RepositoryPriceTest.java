package com.inditex.test.repositories;
import com.inditex.test.models.Price;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class RepositoryPriceTest {
    @Autowired
    TestEntityManager entityManager;
    @Autowired
    RepositoryPrice repositoryPrice;
    @Test
    void findByStartDateAndProductIdAndBrandId() {
        Price price = Price.builder()
                .brandId(1)
                .startDate("2020-06-14-00.00.00")
                .endDate("2020-12-31-23.59.59")
                .priceList(1)
                .productId(35455)
                .priority(0)
                .price(35.50)
                .curr("EUR")
                .build();
        entityManager.persistAndFlush(price);
        Assertions.assertEquals(price,repositoryPrice.findByStartDateAndProductIdAndBrandId("2020-06-14-00.00.00",35455,1).get(0));
    }
}