package com.github.Kedzior90.Learning.Automation.Tests;

import org.apache.bcel.generic.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FirstTest {
    private WebDriver driver;

    @BeforeClass
    private void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Radek\\Learning_Automation\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @BeforeMethod
    public void openHomePage(){
        driver.get("http://www.amazon.com");
    }

    @AfterClass
    private void tearDown(){
        driver.quit();
    }

    @Test
    public void testAddingItemToCard() {
        //Select 'Books' from search category dropdown
        // driver.findElement(By.id("searchDropdownBox"))
        //        .selectByVisibleText("Books");

        //Enter search key: 'Selenium'
        driver.findElement(By.id("twotabsearchtextbox"))
                .sendKeys("Selenium");

        //Click 'Go' button
        driver.findElement(By.xpath("//*[@value='Go']"))
                .click();
    }
}
