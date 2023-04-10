package com.inditex.test.infrastructure.rest.inputadapter.controllers.Impl;
import com.inditex.test.domain.Price;
import com.inditex.test.domain.ports.inputport.PriceUseCase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
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
}