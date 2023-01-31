package com.org.ita;

import com.org.ita.util.TestRunner;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FilterTest extends TestRunner {
    @Description("Verify that the amount of the products in the filter subsection matches the amount of the products")
    @Test(description = "TCM-7")
    public void verifyThatTheAmountOfTheProductsInTheFilterSubsectionMatchesTheAmountOfTheProducts() {
        var searchTerm = "Legrand";
        var filter = homePage
                .getHeader()
                .search(searchTerm)
                .getFilter();

        var subsectionName = "Світлодіодні світильники";
        var productsAmountInFilterSubsection = filter
                .getProductsAmountInFilterSubsection(subsectionName);

        var productsAmount = filter
                .filterBySection("Товари для дому", subsectionName)
                .getProducts()
                .size();

        assertThat(productsAmountInFilterSubsection)
                .as("The product amount in the filter subsection should match the product amount")
                .isEqualTo(productsAmount);
    }

    @Description("Verify that products filter by the filter's range")
    @Test(description = "TCM-8")
    public void verifyThatProductsFilterByTheFiltersRange() {
        int minOfRange = 1000;
        int maxOfRange = 5000;
        var products = homePage
                .getHeader()
                .search("Картридж")
                .getFilter()
                .setPriceRange(minOfRange, maxOfRange)
                .getProducts();

        int amountOfProducts = 24;
        assertThat(products)
                .as(amountOfProducts + " products should be displayed")
                .hasSizeGreaterThanOrEqualTo(amountOfProducts);

        assertThat(products)
                .allSatisfy(product -> assertThat(product.getPrice() > minOfRange || product.getPrice() < maxOfRange)
                        .as("Products should filter by the filter's range (" + minOfRange + " - " + maxOfRange + ")"));
    }
}
