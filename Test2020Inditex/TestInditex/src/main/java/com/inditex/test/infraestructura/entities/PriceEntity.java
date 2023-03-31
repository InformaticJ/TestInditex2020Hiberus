package com.inditex.test.infraestructura.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Prices")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PriceEntity {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;
        @Column(name = "brand_id")
        private Integer brandId;
        @Column(name = "start_date")
        private Date startDate;
        @Column(name = "end_date")
        private Date endDate;
        @Column(name = "price_list")
        private Integer priceList;
        @Column(name = "product_id")
        private Integer productId;
        @Column(name = "priority")
        private Integer priority;
        @Column(name = "price")
        private double price;
        @Column(name = "curr")
        private String curr;
}
