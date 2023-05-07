package com.spring.dataaccess.db;

import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;

@Data
@ToString
public class Product {

    private Long id;

    private String name;

    private BigDecimal price;

    private long cartId;
}
