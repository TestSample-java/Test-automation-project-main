package com.org.ita.components;

import com.org.ita.pages.BasePage;
import com.org.ita.pages.ProductDetailsPage;
import com.org.ita.pages.SearchResultPage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import static java.lang.String.format;

public class CatalogModal extends BasePage {

    @Step("Opened subcategory '{subcategoryName}' from category '{categoryName}'")
    public SearchResultPage openSubcategory(String categoryName, String subcategoryName) {
        var action = new Actions(driver);
        var category = driver.findElement(By.xpath(format("//*[contains(@class, 'menu_link')]//span[text()=\"%s\"]", categoryName)));
        action
                .moveToElement(category)
                .perform();
        driver
                .findElement(By.xpath(format("//a[contains(@class, 'menu_submenu_item') and text()='%s']", subcategoryName)))
                .click();

        return new SearchResultPage();
    }

    @Step("Opened brand '{brandName}' in subcategory '{subcategoryName}' from category '{categoryName}'")
    public SearchResultPage openBrandInSubcategory(String categoryName, String subcategoryName, String brandName) {
        var action = new Actions(driver);
        var category = driver.findElement(By.xpath(format("//*[contains(@class, 'menu_link')]//span[text()=\"%s\"]", categoryName)));
        action
                .moveToElement(category)
                .perform();
        var subcategory = driver.findElement(By.xpath(format("//a[contains(@class, 'menu_submenu_item') and text()='%s']", subcategoryName)));
        action
                .moveToElement(subcategory)
                .perform();
        driver
                .findElement(By.xpath(format("//div[@class= 'list-item_link']//a[text()='%s']", brandName)))
                .click();

        return new SearchResultPage();
    }

    @Step("Opened product '{productNameFromTheCatalog}' in subcategory 'Популярні'")
    public ProductDetailsPage openProductInSubcategory(String categoryName, String linkPartForSubcategoryPopular, String productNameFromTheCatalog) {
        var category = driver.findElement(By.xpath(format("//*[contains(@class, 'menu_link')]//span[text()=\"%s\"]", categoryName)));
        var action = new Actions(driver);
        action
                .moveToElement(category)
                .perform();

        var subcategory = driver.findElement(By.xpath(format("//*[contains(@href, '/ua/%s/popular/')]", linkPartForSubcategoryPopular)));
        action
                .moveToElement(subcategory)
                .perform();

        driver.findElement(By.xpath(format("//span[text()='%s']", productNameFromTheCatalog))).click();

        return new ProductDetailsPage();
    }
}
