package com.inditex.test.services.Impl;
import com.inditex.test.exceptions.ExceptionNoExistsBrand;
import com.inditex.test.exceptions.ExceptionNoExistsProduct;
import com.inditex.test.models.Price;
import com.inditex.test.repositories.RepositoryPrice;
import com.inditex.test.services.ServicePrice;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServicePriceImpl implements ServicePrice {

    @Autowired
    RepositoryPrice repositoryPrice;

    @Override
    public List<Price> getPrices(String date, Integer productId, Integer brandId) {
        try {
            if(checkBrand(brandId) && checkProduct(productId)){
                List<Price> prices = repositoryPrice.findByProductIdAndBrandId(productId,brandId);
                List<Price> pricesBetweenDate = getPricesBetweenDate(date,prices);
                return getPricesWithHighPriority(pricesBetweenDate);
            }
        } catch (ExceptionNoExistsBrand | ExceptionNoExistsProduct e) {
            throw new RuntimeException(e);
        }
        return new ArrayList<>();
    }

    private List<Price> getPricesBetweenDate(String date,List<Price> prices) {
        Date dateParse = parseDate(date);
        return prices.stream().filter(price-> dateParse.before(price.getEndDate()) && dateParse.after(price.getStartDate())).collect(Collectors.toList());
    }

    private List<Price> getPricesWithHighPriority(List<Price> prices) {
        return prices.stream().max(Comparator.comparing(Price::getPriority)).stream().collect(Collectors.toList());
    }

    private Boolean checkBrand(Integer brandId) throws ExceptionNoExistsBrand {
        if(repositoryPrice.existsByBrandId(brandId)){
            return true;
        }
        throw new ExceptionNoExistsBrand("No exists brandId " + brandId);
    }

    private Boolean checkProduct(Integer productId) throws ExceptionNoExistsProduct {
        if(repositoryPrice.existsByProductId(productId)){
            return true;
        }
        throw new ExceptionNoExistsProduct("No exists productId " + productId);
    }

    private Date parseDate(String date){
        try {
            String patter = ("yyyy-MM-dd-HH.mm.ss");
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(patter);
            return simpleDateFormat.parse(date);
        } catch (ParseException e) {
            throw new RuntimeException("Incorrect format date");
        }
    }
}
