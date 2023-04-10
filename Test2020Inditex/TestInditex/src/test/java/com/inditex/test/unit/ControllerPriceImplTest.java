package com.inditex.test.unit;
import com.inditex.test.domain.Price;
import com.inditex.test.domain.ports.inputport.PriceUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
@ActiveProfiles("test")
class ControllerPriceImplTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private PriceUseCase priceUseCase;

    @Test
    void getPricesNotFound() throws Exception {
        when(priceUseCase.getPrices(any(),anyInt(),anyInt())).thenReturn(new ArrayList<>());
        mockMvc.perform(get("/prices?date=2020-06-14 10:00:00&productId=35455&brandId=1"))
                .andDo(print())
                .andExpect(status().isNotFound());
    }
    @Test
    void getPricesIsOk() throws Exception {
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
        List<Price> priceList = new ArrayList<>();
        priceList.add(price1);
        when(priceUseCase.getPrices(any(),anyInt(),anyInt())).thenReturn(priceList);
        mockMvc.perform(get("/prices?date=2020-06-14 12:00:00&productId=35455&brandId=1"))
                .andDo(print())
                .andExpect(status().isOk());
    }
}