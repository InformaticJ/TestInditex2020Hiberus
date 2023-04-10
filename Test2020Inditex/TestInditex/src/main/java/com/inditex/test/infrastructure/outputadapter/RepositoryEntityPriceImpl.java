package com.inditex.test.infrastructure.outputadapter;
import com.inditex.test.domain.Price;
import com.inditex.test.domain.ports.outputport.RepositoryEntityPrice;
import com.inditex.test.infrastructure.inputadapter.rest.mappers.PriceEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Component
@RequiredArgsConstructor
public class RepositoryEntityPriceImpl implements RepositoryEntityPrice {

    private final RepositoryPriceJPA repositoryPrice;

    private final PriceEntityMapper priceEntityMapper;

    @Override
    public List<Price> getPrices(LocalDateTime date, Integer productId, Integer brandId) {
        return priceEntityMapper.priceEntityListToPriceList(repositoryPrice.findByDateBetweenAndBrandIdAndProductId(date, productId, brandId));
    }
}
