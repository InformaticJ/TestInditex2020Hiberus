package com.inditex.test.services.Impl;
import com.inditex.test.models.Price;
import com.inditex.test.repositories.RepositoryPrice;
import com.inditex.test.services.Impl.ServicePriceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.when;

@AutoConfigureMockMvc
@SpringBootTest
@ActiveProfiles("test")
class ServicePriceImplTest{
    @Mock
    RepositoryPrice repositoryPrice;
    @InjectMocks
    ServicePriceImpl servicePrice;
    List<Price> pricesEmpty = new ArrayList<>();
    @ParameterizedTest
    @MethodSource("getPricesParams")
    void getPrices(String startDate,Integer idProduct,Integer idBrand) {
        when(repositoryPrice.findByStartDateAndProductIdAndBrandId(startDate,idProduct,idBrand)).thenReturn(new ArrayList<>());
        List<Price> priceList = servicePrice.getPrices(startDate,idProduct,idBrand);
        Assertions.assertEquals(0,priceList.size());
    }
    private static Stream<Arguments> getPricesParams() {
        return Stream.of(
                arguments("2020-06-14-10.00.00",35455,1),
                arguments("2020-06-14-16.00.00",35455,1),
                arguments("2020-06-14-21.00.00",35455,1),
                arguments("2020-06-15-10.00.00",35455,1),
                arguments("2020-06-14-21.00.00",35455,1)
        );
    }
}