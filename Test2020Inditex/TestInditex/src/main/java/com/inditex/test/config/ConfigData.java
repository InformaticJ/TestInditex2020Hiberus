package com.inditex.test.config;

import com.inditex.test.models.Price;
import com.inditex.test.repositories.RepositoryPrice;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.List;

@Configuration
public class ConfigData {
    @Bean("ConfigData")
    CommandLineRunner commandLineRunner(RepositoryPrice repositoryPrice) {
        return args -> {
            Price price1 = Price.builder()
                    .brandId(1)
                    .startDate("2020-06-14-00.00.00")
                    .endDate("2020-12-31-23.59.59")
                    .priceList(1)
                    .productId(35455)
                    .priority(0)
                    .price(35.50)
                    .curr("EUR")
                    .build();
            Price price2 = Price.builder()
                    .brandId(1)
                    .startDate("2020-06-14-15.00.00")
                    .endDate("2020-06-14-18.30.00")
                    .priceList(2)
                    .productId(35455)
                    .priority(1)
                    .price(25.45)
                    .curr("EUR")
                    .build();
            Price price3 = Price.builder()
                    .brandId(1)
                    .startDate("2020-06-15-00.00.00")
                    .endDate("2020-06-15-11.00.00")
                    .priceList(3)
                    .productId(35455)
                    .priority(1)
                    .price(30.50)
                    .curr("EUR")
                    .build();
            Price price4 = Price.builder()
                    .brandId(1)
                    .startDate("2020-06-15-16.00.00")
                    .endDate("2020-12-31-23.59.59")
                    .priceList(4)
                    .productId(35455)
                    .priority(1)
                    .price(38.95)
                    .curr("EUR")
                    .build();
            repositoryPrice.saveAll(List.of(price1, price2, price3, price4));
        };
    }
}
