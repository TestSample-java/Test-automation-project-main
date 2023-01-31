package com.org.ita.components;

import com.org.ita.pages.BasePage;
import com.org.ita.pages.HomePage;
import com.org.ita.pages.ProductDetailsPage;
import com.org.ita.pages.SearchResultPage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.openqa.selenium.Keys.ENTER;

public class Header extends BasePage {
    private void commonSearch(String term) {
        var searchInput = driver.findElement(By.id("search-input"));
        searchInput.click();
        searchInput.clear();
        searchInput.sendKeys(term);
        searchInput.sendKeys(ENTER);
    }

    @Step("Searched for '{term}'")
    public SearchResultPage search(String term) {
        commonSearch(term);

        return new SearchResultPage();
    }


    @Step("Searched for {productCode} product code")
    public ProductDetailsPage exactSearch(String productCode) {
        commonSearch(productCode);

        return new ProductDetailsPage();
    }

    @Step("Opened home page")
    public HomePage openHomePage() {
        driver
                .findElement(By.xpath("//div[@class='header_logo hash_links']"))
                .click();

        return new HomePage();
    }

    @Step("Opened catalog")
    public CatalogModal openCatalog() {
        driver
                .findElement(By.xpath("//div[@class='header_catalog_btn js-menu-btn']"))
                .click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//ul[@class='menu_list custom-scroll']"))));

        return new CatalogModal();
    }
}
