package com.org.ita;

import com.org.ita.util.TestRunner;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchTest extends TestRunner {
    @Description("Verify that products include the search term in their names")
    @Test(description = "TCM-1")
    public void verifyThatProductsIncludeTheSearchTermInTheirNames() {
        var searchTerm = "Asus";
        var products = homePage
                .getHeader()
                .search(searchTerm)
                .getProducts();

        int amountOfProducts = 24;
        assertThat(products)
                .as(amountOfProducts + " products should be displayed")
                .hasSizeGreaterThanOrEqualTo(amountOfProducts);

        assertThat(products)
                .allSatisfy(product -> assertThat(product.getName())
                        .as(product.getName() + " should contain " + searchTerm)
                        .containsIgnoringCase(searchTerm));
    }

    @Description("Verified that it's possible to search product by code")
    @Test(description = "TCM-2")
    public void verifyThatItIsPossibleToSearchProductByCode() {
        var searchTerm = "asus";
        var productDetailsPage = homePage
                .getHeader()
                .search(searchTerm)
                .openDetailsPage(1);

        var productName = productDetailsPage.getName();
        var productCode = productDetailsPage.getCode();

        productDetailsPage
                .getHeader()
                .openHomePage()
                .getHeader()
                .exactSearch(productCode);

        var searchProductName = productDetailsPage.getName();
        var searchProductCode = productDetailsPage.getCode();

        assertThat(productName)
                .as("Product name should match the searched product")
                .isEqualTo(searchProductName);

        assertThat(productCode)
                .as("Product code should match the searched product")
                .isEqualTo(searchProductCode);
    }
}
