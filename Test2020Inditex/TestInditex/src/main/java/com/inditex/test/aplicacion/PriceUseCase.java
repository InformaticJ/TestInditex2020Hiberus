package com.inditex.test.aplicacion;

import com.inditex.test.dominio.Price;
import com.inditex.test.dominio.ports.inputport.PricePort;
import com.inditex.test.infraestructura.rest.outputadapter.RepositoryPriceH2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PriceUseCase implements PricePort {
    @Autowired
    RepositoryPriceH2 repositoryPriceMySQL;
    @Override
    public List<Price> getPrices(String date, Integer productId, Integer brandId) {
        return repositoryPriceMySQL.getPrices(date,productId,brandId);
    }
}
