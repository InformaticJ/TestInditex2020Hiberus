package com.inditex.test.dominio;
import lombok.*;
import java.util.Date;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Price {
        private Integer id;
        private Integer brandId;
        private Date startDate;
        private Date endDate;
        private Integer priceList;
        private Integer productId;
        private Integer priority;
        private double price;
        private String curr;
}
