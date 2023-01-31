package com.org.ita.components;

import com.org.ita.driver.DriverRepository;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseComponent {
    protected DefaultElementLocatorFactory parentContext;
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BaseComponent(String root) {
        driver = DriverRepository.DRIVERS.get();
        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        parentContext = new DefaultElementLocatorFactory(driver.findElement(By.xpath(root)));
        PageFactory.initElements(parentContext, this);
    }
}