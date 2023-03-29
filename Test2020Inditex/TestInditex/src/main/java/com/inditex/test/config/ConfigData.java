package com.inditex.test.config;

import com.inditex.test.models.Price;
import com.inditex.test.repositories.RepositoryPrice;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Configuration
public class ConfigData {
    @Bean("ConfigData")
    CommandLineRunner commandLineRunner(RepositoryPrice repositoryPrice) {
        String pattern=("yyyy-MM-dd-HH.mm.ss");
        SimpleDateFormat dateFormat= new SimpleDateFormat(pattern);
        return args -> {
            Date startDate1 = dateFormat.parse("2020-06-14-00.00.00");
            Date endDate1 = dateFormat.parse("2020-12-31-23.59.59");
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
            Date startDate2 = dateFormat.parse("2020-06-14-15.00.00");
            Date endDate2 = dateFormat.parse("2020-06-14-18.30.00");
            Price price2 = Price.builder()
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
            Price price3 = Price.builder()
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
            Price price4 = Price.builder()
                    .brandId(1)
                    .startDate(startDate4)
                    .endDate(endDate4)
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
