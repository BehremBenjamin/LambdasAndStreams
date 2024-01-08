package org.lambdas;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AdvancedStreamExample03 {
    public static void main(String[] args) {
        List<Product> productList = ExampleData.getProducts();

        Map<Category, BigDecimal> totalPerCategory = productList.stream()
                .collect(Collectors.toMap(
                        Product::getCategory, //key Mapper
                        Product::getPrice,   // value mapper
                        BigDecimal::add
                ));

        System.out.println(totalPerCategory);
    }
}
