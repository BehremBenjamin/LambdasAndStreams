package org.lambdas;

import java.io.PrintStream;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AdvancedStreamExample05 {
    public static void main(String[] args) {
        List<Product> productList = ExampleData.getProducts();

        Map<Category, List<Product>> productsByCategory = productList.stream()
                .collect(Collectors.groupingBy(Product::getCategory));

        System.out.println(productsByCategory);

        Map<Category, List<String>> productNamesByCategory = productList.stream()
                .collect(Collectors.groupingBy(Product::getCategory,
                        Collectors.mapping(Product::getName, Collectors.toList())));


        //System.out.println(productNamesByCategory);


        BigDecimal midPrice = new BigDecimal("5.0");

        Map<Boolean, List<Product>> lowerThanMidPrice = productList.stream()
                 .collect(Collectors.partitioningBy(product -> product.getPrice().compareTo(midPrice) < 0));

        System.out.println("false: ");
        System.out.println(lowerThanMidPrice.get(false));
        System.out.println("true:  ");
        System.out.println(lowerThanMidPrice.get(true));

    }

}
