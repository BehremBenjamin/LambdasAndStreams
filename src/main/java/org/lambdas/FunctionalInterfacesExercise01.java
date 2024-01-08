package org.lambdas;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class FunctionalInterfacesExercise01 {


    public static List<Product> filterProducts(List<Product> products, Predicate<Product> f) {
        List<Product> result = new ArrayList<>();

        for (Product p : products) {
            if (f.test(p)) {
                result.add(p);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Predicate<Product> lowPrice = product -> product.getPrice().compareTo(new BigDecimal(3.5)) < 0;


        List<Product> products = ExampleData.getProducts();

        List<Product> filteredLowPrice = filterProducts(products, lowPrice);

        filteredLowPrice.forEach(System.out::println);

    }
}
