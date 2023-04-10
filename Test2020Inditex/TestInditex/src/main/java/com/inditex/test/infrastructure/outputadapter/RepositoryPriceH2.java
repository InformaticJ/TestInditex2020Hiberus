package com.inditex.test.infrastructure.outputadapter;
import com.inditex.test.domain.Price;
import com.inditex.test.domain.ports.outputport.RepositoryEntityPrice;
import com.inditex.test.infrastructure.inputadapter.rest.mappers.PriceMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class RepositoryPriceH2 implements RepositoryEntityPrice {

    private final RepositoryPrice repositoryPrice;

    private final PriceMapper priceMapper;

    @Override
    public List<Price> getPrices(Date date, Integer productId, Integer brandId) {
        List<Price> pricesBetweenDate = priceMapper.priceEntityListToPriceList(repositoryPrice.findByDateBetweenAndBrandIdAndProductId(date, productId, brandId));
        return getPricesWithHighPriority(pricesBetweenDate);
    }

    private List<Price> getPricesWithHighPriority(List<Price> prices) {
        return prices.stream().max(Comparator.comparing(Price::getPriority)).stream().collect(Collectors.toList());
    }
}
