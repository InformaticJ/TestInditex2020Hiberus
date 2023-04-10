package com.inditex.test.unit;
import com.inditex.test.domain.Price;
import com.inditex.test.domain.ports.inputport.PriceUseCase;
import com.inditex.test.infrastructure.inputadapter.rest.controllers.Impl.ControllerPriceImpl;
import com.inditex.test.infrastructure.inputadapter.rest.dto.PriceDto;
import com.inditex.test.infrastructure.inputadapter.rest.mappers.PriceMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class ControllerPriceImplTest {

    @Mock
    private PriceUseCase priceUseCase;

    @Mock
    private PriceMapper priceMapper;


    @InjectMocks
    private ControllerPriceImpl controllerPriceImpl;

    @Test
    void getPricesNotFound() throws Exception {
        LocalDateTime date = LocalDateTime.parse("2020-06-14T00:00:00");
        when(priceUseCase.getPrices(any(),anyInt(),anyInt())).thenReturn(new ArrayList<>());
        ResponseEntity<List<PriceDto>> result = controllerPriceImpl.getPrices(date, 35455, 1);
        assertEquals(HttpStatus.NOT_FOUND,result.getStatusCode());
        verify(priceUseCase).getPrices(any(),anyInt(),anyInt());
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
        PriceDto price2 = PriceDto.builder()
                .brandId(1)
                .startDate(startDate1)
                .endDate(endDate1)
                .priceList(1)
                .productId(35455)
                .price(35.50)
                .build();
        List<Price> priceList = new ArrayList<>();
        priceList.add(price1);
        when(priceUseCase.getPrices(any(),anyInt(),anyInt())).thenReturn(priceList);
        when(priceMapper.priceListToPriceDtoList(any())).thenReturn(List.of(price2));
        ResponseEntity<List<PriceDto>> result = controllerPriceImpl.getPrices(startDate1, 35455, 1);
        assertEquals(HttpStatus.OK,result.getStatusCode());
        verify(priceUseCase).getPrices(any(),anyInt(),anyInt());
        verify(priceMapper).priceListToPriceDtoList(any());
    }
}