package com.inditex.test.dominio.ports.outputport;

import com.inditex.test.dominio.Price;
import java.util.List;

public interface RepositoryEntityPrice {
    List<Price> getPrices(String date, Integer productId, Integer brandId);
}
