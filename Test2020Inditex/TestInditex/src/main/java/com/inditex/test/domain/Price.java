package com.inditex.test.domain;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Price {
        private Integer id;
        private Integer brandId;
        private LocalDateTime startDate;
        private LocalDateTime endDate;
        private Integer priceList;
        private Integer productId;
        private Integer priority;
        private double price;
        private String curr;
}
