package com.inditex.test.controllers;
import com.inditex.test.services.ServicePrice;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import java.util.ArrayList;
import java.util.stream.Stream;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@AutoConfigureMockMvc
@SpringBootTest
@ActiveProfiles("test")
class ControllerPriceTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private ServicePrice servicePrice;
    @ParameterizedTest
    @MethodSource("getPricesParams")
    void getPrices(String startDate,Integer idProduct,Integer idBrand) throws Exception {
        when(servicePrice.getPrices(startDate,idProduct,idBrand)).thenReturn(new ArrayList<>());
        mockMvc.perform(get("/prices?startDate="+startDate+"&"+"idProduct="+idProduct+"&"+"idBrand="+ idBrand))
                .andDo(print())
                .andExpect(content().json(String.valueOf(new ArrayList<>())))
                .andExpect(status().isOk());
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