package com.inditex.test.infrastructure.rest.inputadapter.dto;

import lombok.*;

import java.util.Date;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PriceDto {
    private Integer productId;
    private Integer brandId;
    private Integer priceList;
    private Date startDate;
    private Date endDate;
    private double price;
}
