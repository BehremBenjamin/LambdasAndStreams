package org.lambdas;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public class AdvancedStreamExample02 {

    public static void main(String[] args) {

        List<Product> products = ExampleData.getProducts();

        Optional<BigDecimal> allCost = Optional.of(products.stream()
                .map(Product::getPrice)
                .reduce((result, price) -> result.add(price))
                .orElse(null));


        allCost.ifPresentOrElse(
                result -> System.out.println("Price of All articles together: " + result),
                () -> System.out.println("No price"));

        BigDecimal allCost1 = products.stream()
                .map(Product::getPrice)
                .reduce(BigDecimal::add)
                .get();


        System.out.println(allCost);

    }
}
