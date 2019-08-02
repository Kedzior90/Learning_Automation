package com.github.Kedzior90.Learning.Automation.pages;

import org.openqa.selenium.WebDriver;

public class HomePage {
    private static final String AMAZON_HOME_PAGE_URL = "http://www.amazon.com";
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage open() {
        driver.get(AMAZON_HOME_PAGE_URL);
        return this;
    }
}