package com.inditex.test.dominio.ports.inputport;

import com.inditex.test.dominio.Price;
import java.util.List;

public interface PricePort {
    List<Price> getPrices(String date, Integer productId, Integer brandId);
}
