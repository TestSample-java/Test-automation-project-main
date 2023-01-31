package com.org.ita.pages;

import com.org.ita.components.Filter;
import com.org.ita.components.Product;
import com.org.ita.models.SortOrder;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.By;

import java.util.List;

import static java.lang.String.format;
import static java.util.stream.Collectors.toList;
import static java.util.stream.IntStream.rangeClosed;

@Getter
public class SearchResultPage extends BasePage {
    private String productsPath = "(//div[contains(@class, 'product-item goods-item add-data ga-item')])";
    private Filter filter = new Filter("//div[@class='filter_content custom-scroll']");

    public List<Product> getProducts() {

        return rangeClosed(1, driver.findElements(By.xpath(productsPath))
                .size())
                .mapToObj(i -> new Product(format("(%s)[%s]", productsPath, i)))
                .collect(toList());
    }

    public Product getProduct(int index) {

        return new Product(format("(%s)[%s]", productsPath, index));
    }

    @Step("Opened details page for the {productIndex} product")
    public ProductDetailsPage openDetailsPage(int productIndex) {
        driver.findElement(By.xpath(format("(%s)[%s]", productsPath, productIndex))).click();

        return new ProductDetailsPage();
    }

    @Step("Sorted products {order}")
    public SearchResultPage sort(SortOrder order) {
        driver.findElement(By.xpath(format("//div[@data-sort='%s']", order.getSortOrderOption()))).click();

        return this;
    }
}
