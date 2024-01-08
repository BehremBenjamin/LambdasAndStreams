package org.lambdas;

import java.math.BigDecimal;
import java.util.List;
import java.util.function.Predicate;

public class FunctionalInterfacesExercise02 {

    public static class SearchCriteria {
        private Category category;
        private String namePattern;
        private BigDecimal minimumPrice;
        private BigDecimal maximumPrice;

        public SearchCriteria(Category category, String namePattern, BigDecimal minimumPrice, BigDecimal maximumPrice) {
            this.category = category;
            this.namePattern = namePattern;
            this.minimumPrice = minimumPrice;
            this.maximumPrice = maximumPrice;
        }
    }

    public static Predicate<Product> createSearchPredicate(SearchCriteria criteria) {
        Predicate<Product> categoryIs = product -> product.getCategory().equals(criteria.category);
        Predicate<Product> nameMatches = product -> product.getName().matches(criteria.namePattern);
        Predicate<Product> minimumPriceIs = product -> product.getPrice().compareTo(criteria.minimumPrice) > 0;
        Predicate<Product> maximumPriceIs = product -> product.getPrice().compareTo(criteria.maximumPrice) <= 0;

        return categoryIs
                .and(nameMatches)
                .and(minimumPriceIs)
                .and(maximumPriceIs);
    }

    public static void main(String[] args) {
        SearchCriteria sc = new SearchCriteria(Category.OFFICE, "Highlighter", new BigDecimal(1.0),
                new BigDecimal(6.0));

        List<Product> productList = ExampleData.getProducts();

        productList.stream().filter(createSearchPredicate(sc)).forEach(System.out::println);

    }
}
