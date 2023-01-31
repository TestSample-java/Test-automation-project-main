package com.org.ita.components;

import com.org.ita.pages.SearchResultPage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class Filter extends BaseComponent {
    String root;

    public Filter(String root) {
        super(root);
        this.root = root;
    }

    @Step("Filtered products by '{filterSubsectionName}' subsection")
    public SearchResultPage filterBySection(String filterSectionName, String filterSubsectionName) {
        var filterSubsectionPath = String.format("//span[@class='value' and contains(text(), '%s')]", filterSubsectionName);
        if (!driver
                .findElement(By.xpath(filterSubsectionPath))
                .isDisplayed()) {
            driver
                    .findElement(By.xpath(String.format("//div[@class='filter_section_title' and contains(text(), '%s')]", filterSectionName)))
                    .click();
        }
        driver
                .findElement(By.xpath(filterSubsectionPath))
                .click();

        return new SearchResultPage();
    }

    public int getProductsAmountInFilterSubsection(String filterSubsectionName) {

        return Integer.parseInt(driver
                .findElement(By.xpath(String.format("//span[@class='value' and contains(text(), '%s')]/../span[@class='count']", filterSubsectionName)))
                .getText());
    }

    @Step("Set price range ({min}-{max})  in filter")
    public SearchResultPage setPriceRange(int min, int max) {
        var minInput = driver.findElement(By.name("min"));
        minInput.clear();
        minInput.sendKeys(Integer.toString(min));

        var maxInput = driver.findElement(By.name("max"));
        maxInput.clear();
        maxInput.sendKeys(Integer.toString(max));

        return new SearchResultPage();
    }
}
