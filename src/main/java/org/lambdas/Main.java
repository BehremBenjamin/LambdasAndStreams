package org.lambdas;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


public class Main {

    static <T> void printer(List<T> lista) {
        for (T t : lista) {
            System.out.println(t);
        }
    }

    static void printProducts(List<Product> products, ProductFilter filter) {
        for (Product p : products) {
            if (filter.accept(p)) {
                System.out.println(p);
            }
        }
    }

    public static void main(String[] args) {

        List<Product> products = ExampleData.getProducts();
        BigDecimal priceLimit = BigDecimal.valueOf(5.00);


        List<Product> cheapProducts = new ArrayList<>();

        products.forEach(product -> {
            if (product.getPrice().compareTo(priceLimit) < 0) {
                cheapProducts.add(product);
            }
        });

        printer(cheapProducts);

        ProductFilter filter = product -> product.getPrice().compareTo(priceLimit) < 0;
        printProducts(products, filter);
    }
}