package org.lambdas;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Creator {

    public static void main(String[] args) {

        //writing ints; 0 - 1 000 000 to a file

        /* File file = new File("C:\\Users\\bben636\\Desktop\\million.txt");

        try (BufferedWriter bf = new BufferedWriter(new FileWriter(file))) {

            IntStream iS = IntStream.rangeClosed(0, 1000000);
            bf.write(iS.mapToObj(Integer::toString).collect(Collectors.joining(" ")));

        } catch (IOException e) {
            e.printStackTrace();
        }
        */

        String filePath = "C:\\Users\\bben636\\Desktop\\million.txt";

        try {
            List<String> ss = Files.lines(Paths.get(filePath)).collect(Collectors.toList());

            long ff = ss.stream().map(String::trim)
                    .flatMap(line -> Stream.of(line.split("\\s+")))
                    .filter(word -> word.matches("^\\d+$"))
                    .filter(word -> word.startsWith("2")).count();
                    //.forEach(System.out::println);

            System.out.println(ff);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
