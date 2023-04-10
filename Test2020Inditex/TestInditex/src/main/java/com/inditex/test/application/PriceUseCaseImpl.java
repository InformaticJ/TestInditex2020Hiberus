package com.inditex.test.application;

import com.inditex.test.domain.Price;
import com.inditex.test.domain.ports.inputport.PriceUseCase;
import com.inditex.test.domain.ports.outputport.RepositoryEntityPrice;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
@RequiredArgsConstructor
public class PriceUseCaseImpl implements PriceUseCase {

    private final RepositoryEntityPrice repositoryEntityPrice;
    @Override
    public List<Price> getPrices(Date date, Integer productId, Integer brandId) {
        return repositoryEntityPrice.getPrices(date,productId,brandId);
    }
}
