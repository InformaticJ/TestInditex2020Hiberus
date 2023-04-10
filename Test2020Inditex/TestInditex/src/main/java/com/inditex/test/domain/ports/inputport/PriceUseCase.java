package com.inditex.test.domain.ports.inputport;

import com.inditex.test.domain.Price;

import java.util.Date;
import java.util.List;

public interface PriceUseCase {
    List<Price> getPrices(Date date, Integer productId, Integer brandId);
}
