package org.lambdas;

import java.math.BigInteger;
import java.util.UUID;
import java.util.stream.Stream;

public class AdvancedStreamExample01 {
    public static void main(String[] args) {
        Stream<UUID> uuids = Stream.generate(UUID::randomUUID);
        // uuids.limit(10).forEach(System.out::println);

        Stream<BigInteger> powersOfTwo = Stream.iterate(BigInteger.ONE, num -> num.multiply(BigInteger.TWO));
        // powersOfTwo.limit(20).forEach(System.out::println);

        Stream<Character> alphabet = Stream.iterate('A', letter -> letter <= 'z', letter -> (char)(letter + 1));
        alphabet.forEach(System.out::print);

        Stream.Builder<String> stringStreamBuilder = Stream.builder();
        stringStreamBuilder.add("Benjamin");
        stringStreamBuilder.add("Behrem");
        stringStreamBuilder.build();

    }
}
