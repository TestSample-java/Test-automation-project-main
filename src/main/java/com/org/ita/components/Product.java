package com.org.ita.components;

import org.openqa.selenium.By;

public class Product extends BaseComponent {
    String root;

    public Product(String root) {
        super(root);
        this.root = root;
    }

    public String getName() {
        return driver.findElement(By.xpath(root + "//a[@class='product-item_name gtm-link-product']")).getText();
    }

    public int getPrice() {
        var priceAndCashback = driver
                .findElement(By.xpath(root + "//div[contains(@class, 'product-item_price_current')]"))
                .getText()
                .split("\\+");

        return Integer.parseInt(priceAndCashback[0]
                .replace("\n", "")
                .replace(" ", "")
                .replace("грн", ""));
    }
}
