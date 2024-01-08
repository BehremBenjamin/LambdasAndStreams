package org.lambdas;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BasicStreamExample02 {

    List<Product> products = ExampleData.getProducts();
    Stream<Product> productStream = products.stream();
    String[] array = new String[]{"one", "two", "three",};
    Stream<String> stream2 = Arrays.stream(array);
    Stream<String> stream3 = Stream.of("jedan", "dva", "tri");

}
