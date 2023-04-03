package com.inditex.test.infrastructure.rest.outputadapter;
import com.inditex.test.domain.Price;
import com.inditex.test.domain.ports.outputport.RepositoryEntityPrice;
import com.inditex.test.infrastructure.rest.mappers.PriceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class RepositoryPriceH2 implements RepositoryEntityPrice {
    @Autowired
    RepositoryPrice repositoryPrice;

    @Override
    public List<Price> getPrices(Date date, Integer productId, Integer brandId) {
        List<Price> prices = PriceMapper.INSTANCE.priceEntityListToPriceList(repositoryPrice.findByProductIdAndBrandId(productId,brandId));
        List<Price> pricesBetweenDate = getPricesBetweenDate(date, prices);
        return getPricesWithHighPriority(pricesBetweenDate);
    }

    private List<Price> getPricesBetweenDate(Date date,List<Price> prices) {
        return prices.stream().filter(price-> date.before(price.getEndDate()) && date.after(price.getStartDate())).collect(Collectors.toList());
    }

    private List<Price> getPricesWithHighPriority(List<Price> prices) {
        return prices.stream().max(Comparator.comparing(Price::getPriority)).stream().collect(Collectors.toList());
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
