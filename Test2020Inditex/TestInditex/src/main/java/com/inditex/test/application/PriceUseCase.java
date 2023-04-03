package com.inditex.test.application;

import com.inditex.test.domain.Price;
import com.inditex.test.domain.ports.inputport.PricePort;
import com.inditex.test.infrastructure.rest.outputadapter.RepositoryPriceH2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class PriceUseCase implements PricePort {
    @Autowired
    RepositoryPriceH2 repositoryPriceH2;
    @Override
    public List<Price> getPrices(Date date, Integer productId, Integer brandId) {
        return repositoryPriceH2.getPrices(date,productId,brandId);
    }
}
