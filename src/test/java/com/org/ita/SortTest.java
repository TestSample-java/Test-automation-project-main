package com.org.ita;

import com.org.ita.components.Product;
import com.org.ita.models.SortOrder;
import com.org.ita.util.TestRunner;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

import java.util.stream.Collectors;

import static java.util.Collections.reverseOrder;
import static java.util.Comparator.naturalOrder;
import static org.assertj.core.api.Assertions.assertThat;

public class SortTest extends TestRunner {

    @Description("Add test script to cover 'From cheap to expensive' sort functionality")
    @Test(description = "TCM-3")
    public void verifyThatProductsAreSortedFromCheapToExpensive() {
        var searchTerm = "Asus";
        var products = homePage
                .getHeader()
                .search(searchTerm)
                .sort(SortOrder.FROM_CHEAP)
                .getProducts();

        int amountOfProducts = 24;
        assertThat(products)
                .as(amountOfProducts + " products should be displayed")
                .hasSizeGreaterThanOrEqualTo(amountOfProducts);

        var productsPrice = products
                .stream()
                .map(Product::getPrice)
                .collect(Collectors.toList());

        assertThat(productsPrice)
                .as("Products prices should be sorted from cheap to expensive")
                .isSortedAccordingTo(naturalOrder());
    }

    @Description("Add test script to cover 'From expensive to cheap' sort functionality")
    @Test(description = "TCM-4")
    public void verifyThatProductsAreSortedFromExpensiveToCheap() {
        var searchTerm = "Asus";
        var products = homePage
                .getHeader()
                .search(searchTerm)
                .sort(SortOrder.FROM_EXPENSIVE)
                .getProducts();

        int amountOfProducts = 24;
        assertThat(products)
                .as(amountOfProducts + " products should be displayed")
                .hasSizeGreaterThanOrEqualTo(amountOfProducts);

        var productsPrice = products
                .stream()
                .map(Product::getPrice)
                .collect(Collectors.toList());

        assertThat(productsPrice)
                .as("Products prices should be sorted from expensive to cheap")
                .isSortedAccordingTo(reverseOrder());
    }
}
