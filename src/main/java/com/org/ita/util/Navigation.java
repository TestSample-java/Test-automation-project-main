package com.org.ita.util;

import com.org.ita.driver.DriverRepository;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class Navigation {
    private WebDriver driver;

    public Navigation() {
        driver = DriverRepository.DRIVERS.get();
    }

    @Step("Opened {url}")
    public void navigateToUrl(String url) {
        driver.get(url);
        driver.manage().window().maximize();
    }
}
