package com.org.ita;

import com.org.ita.util.TestRunner;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

import static com.org.ita.models.Category.LAPTOPS_AND_COMPUTERS;
import static com.org.ita.models.Category.PHOTO_VIDEO_AUDIO;
import static org.assertj.core.api.Assertions.assertThat;

public class CatalogTest extends TestRunner {
    @Description("Verify that product names from the catalog contain the name brand of the subcategory")
    @Test(description = "TCM-5")
    public void verifyThatProductsNamesFromTheCatalogContainTheNameBrandOfTheSubcategory() {
        var brandName = "HP";
        var products = homePage
                .getHeader()
                .openCatalog()
                .openBrandInSubcategory(LAPTOPS_AND_COMPUTERS.getName(), "Ноутбуки", brandName)
                .getProducts();

        assertThat(products)
                .allSatisfy(product -> assertThat(product.getName())
                        .as(product.getName() + " should contain " + brandName)
                        .containsIgnoringCase(brandName));
    }

    @Description("Verify that it is possible to open a product from the catalog product")
    @Test(description = "TCM-6")
    public void verifyThatItIsPossibleToOpenProductFromTheCatalog() {
        var productNameFromTheCatalog = "SONY Alpha a6400";
        var searchProductName = homePage
                .getHeader()
                .openCatalog()
                .openProductInSubcategory(PHOTO_VIDEO_AUDIO.getName(), PHOTO_VIDEO_AUDIO.getLinkPartForSubcategoryPopular(), productNameFromTheCatalog)
                .getName();

        assertThat(searchProductName)
                .as("Product name should contain product name from the catalog")
                .contains(productNameFromTheCatalog);
    }
}
