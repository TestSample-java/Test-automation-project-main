package com.org.ita.util;

import com.org.ita.driver.DriverRepository;
import com.org.ita.pages.HomePage;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.annotations.*;

@Listeners(UiTestListener.class)
public class TestRunner {
    public HomePage homePage;

    @BeforeSuite
    public void setup(ITestContext iTestContext) {
        for (ITestNGMethod method : iTestContext.getAllTestMethods()) {
            method.setRetryAnalyzerClass(RetryAnalyser.class);
        }
        DriverRepository.downloadWebDriver();
    }

    @BeforeMethod
    public void createDriver() {
        DriverRepository.instanceWebBrowser();
        new Navigation().navigateToUrl("https://www.moyo.ua/ua/");
        homePage = new HomePage();
    }

    @AfterMethod
    public void closeBrowser() {
        DriverRepository.closeBrowser();
    }
}
