package org.lambdas;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class LambdasExample06 {

    public static void main(String[] args) {

        List<Product> products = ExampleData.getProducts();

        // lambdas shouldnt be used in this, complicated way - there are better options

        try {
        FileWriter fileWriter = new FileWriter("products.txt");
        products.forEach(product -> {
            try {
                fileWriter.write(product.toString());
                fileWriter.write("\n");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
            fileWriter.flush();
            fileWriter.close();
        }

        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

