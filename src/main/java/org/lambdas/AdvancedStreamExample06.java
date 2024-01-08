package org.lambdas;

import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.DoubleStream;

public class AdvancedStreamExample06 {
    public static void main(String[] args) {
        List<Product> products = ExampleData.getProducts();

        DoubleStream ds = products.stream().mapToDouble(product -> product.getPrice().doubleValue());
         // ds.forEach(System.out::println);

        double total = ds.sum();
        System.out.println("total value is: " + total);

        DoubleSummaryStatistics summaryStatistics = products.stream()
                .mapToDouble(product -> product.getPrice().doubleValue())
                .summaryStatistics();

        System.out.println("count: " + summaryStatistics.getCount());
        System.out.println("sum: " + summaryStatistics.getSum());
        System.out.println("minimum: " +summaryStatistics.getMin());
        System.out.println("maximum: " + summaryStatistics.getMax());

        double average = summaryStatistics.getAverage();
        String formattedAverage = String.format("%.2f", average);

        System.out.println("average: " + formattedAverage);
    }
}
