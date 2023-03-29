package com.inditex.test.services;
import com.inditex.test.models.Price;
import java.util.List;

public interface ServicePrice {
    List<Price>getPrices(String date,Integer productId,Integer brandId);
}
