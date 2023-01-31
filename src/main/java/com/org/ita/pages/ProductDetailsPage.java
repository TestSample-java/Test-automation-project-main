package com.org.ita.pages;

import com.org.ita.components.Header;
import lombok.Getter;
import org.openqa.selenium.By;

@Getter
public class ProductDetailsPage extends BasePage {
    Header header = new Header();

    public String getName() {

        return driver.findElement(By.xpath("//h1[@class='product_name']")).getText();
    }

    public String getCode() {

        return driver.findElement(By.xpath("//div[@class='product_id']"))
                .getText()
                .replace("Код товару: ", "");
    }
}
