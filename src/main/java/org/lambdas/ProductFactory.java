package org.lambdas;

import java.math.BigDecimal;

interface ProductFactory {
    Product create(Category category, String name, BigDecimal price);
}