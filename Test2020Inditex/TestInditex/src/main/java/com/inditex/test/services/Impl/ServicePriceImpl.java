package com.inditex.test.services.Impl;
import com.inditex.test.models.Price;
import com.inditex.test.repositories.RepositoryPrice;
import com.inditex.test.services.ServicePrice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicePriceImpl implements ServicePrice {

    @Autowired
    RepositoryPrice repositoryPrice;

    @Override
    public List<Price> getPrices(String startDate,Integer idProduct,Integer idBrand) {
        return repositoryPrice.findByStartDateAndProductIdAndBrandId(startDate,idProduct,idBrand);
    }
}
