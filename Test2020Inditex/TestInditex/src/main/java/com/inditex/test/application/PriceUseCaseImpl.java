package com.inditex.test.application;

import com.inditex.test.domain.Price;
import com.inditex.test.domain.ports.inputport.PriceUseCase;
import com.inditex.test.domain.ports.outputport.RepositoryEntityPrice;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class PriceUseCaseImpl implements PriceUseCase {

    private final RepositoryEntityPrice repositoryEntityPrice;
    @Override
    public List<Price> getPrices(LocalDateTime date, Integer productId, Integer brandId) {
        return getPricesWithHighPriority(repositoryEntityPrice.getPrices(date,productId,brandId));
    }
    private List<Price> getPricesWithHighPriority(List<Price> prices) {
        return prices.stream().max(Comparator.comparing(Price::getPriority)).stream().collect(Collectors.toList());
    }
}
