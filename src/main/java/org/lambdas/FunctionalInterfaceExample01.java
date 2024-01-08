package org.lambdas;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.function.*;

public class FunctionalInterfaceExample01 {
    static Optional<Product> findProduct(List<Product> products, Predicate<Product> predicate) {
        for (Product p : products) {
            if (predicate.test(p)) {
                return Optional.of(p);
            }
        }
        return Optional.empty();
    }

    public static void main(String[] args) {

        List<Product> products = ExampleData.getProducts();

        String name = "Apples";

        Function<Product, BigDecimal> productToPrice = Product::getPrice;
        Function<BigDecimal, String> priceToMessage = price ->  String.format("The price of %s is $ 5.2f%n", name, price);
        Function<Product, String> productToMessage = productToPrice.andThen(priceToMessage);

        BigDecimal priceLimit = new BigDecimal(2.0);

        Predicate<Product> isFood = product -> product.getCategory() == Category.FOOD;
        Predicate <Product> isCheap = product -> product.getPrice().compareTo(priceLimit) < 0;

        findProduct(products, isCheap.and(isFood))
                .map(productToMessage)
                .ifPresentOrElse(System.out::println,
                () -> System.out.printf("%s is not available%n", name)
        );

        Supplier<Double> randomValue = () -> Math.random() * 1000;

        System.out.println(randomValue.get());

        Consumer<List<Product>> pricalica = list ->list.stream().forEach(System.out::println);

        pricalica.accept(products);

        UnaryOperator<Integer> plusFive = p -> p+5;

        int ten = 10;

        System. out.println(plusFive.apply(ten));

    }
}
