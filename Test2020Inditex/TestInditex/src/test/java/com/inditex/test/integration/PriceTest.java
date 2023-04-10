package com.inditex.test.integration;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
class PriceTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void getPricesTest1() throws Exception {
        mockMvc.perform(get("/prices?date=2020-06-14 10:00:00&productId=35455&brandId=1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].brandId").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].startDate").value("2020-06-14T00:00:00"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].endDate").value("2020-12-31T23:59:59"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].productId").value(35455))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].priceList").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].price").value(35.50));
    }


    @Test
    void getPricesTest2() throws Exception {
        mockMvc.perform(get("/prices?date=2020-06-14 16:00:00&productId=35455&brandId=1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].brandId").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].startDate").value("2020-06-14T15:00:00"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].endDate").value("2020-06-14T18:30:00"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].productId").value(35455))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].priceList").value(2))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].price").value(25.45));
    }

    @Test
    void getPricesTest3() throws Exception {
        mockMvc.perform(get("/prices?date=2020-06-14 21:00:00&productId=35455&brandId=1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].brandId").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].startDate").value("2020-06-14T00:00:00"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].endDate").value("2020-12-31T23:59:59"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].productId").value(35455))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].priceList").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].price").value(35.50));
    }

    @Test
    void getPricesTest4() throws Exception {
        mockMvc.perform(get("/prices?date=2020-06-15 10:00:00&productId=35455&brandId=1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].brandId").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].startDate").value("2020-06-15T00:00:00"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].endDate").value("2020-06-15T11:00:00"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].productId").value(35455))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].priceList").value(3))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].price").value(30.50));
    }

    @Test
    void getPricesTest5() throws Exception {
        mockMvc.perform(get("/prices?date=2020-06-14 21:00:00&productId=35455&brandId=1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].brandId").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].startDate").value("2020-06-14T00:00:00"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].endDate").value("2020-12-31T23:59:59"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].productId").value(35455))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].priceList").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].price").value(35.50));
    }
}

