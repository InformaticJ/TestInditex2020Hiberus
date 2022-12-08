package com.inditex.test.dto;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PriceDtoResponse {
    private Integer productId;
    private Integer brandId;
    private Integer priceList;
    private String startDate;
    private String endDate;
    private double price;
}
