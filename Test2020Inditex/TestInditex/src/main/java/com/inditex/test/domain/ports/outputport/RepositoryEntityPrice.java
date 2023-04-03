package com.inditex.test.domain.ports.outputport;

import com.inditex.test.domain.Price;

import java.util.Date;
import java.util.List;

public interface RepositoryEntityPrice {
    List<Price> getPrices(Date date, Integer productId, Integer brandId);
}
