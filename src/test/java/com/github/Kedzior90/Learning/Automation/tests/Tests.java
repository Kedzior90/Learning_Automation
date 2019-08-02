package com.github.Kedzior90.Learning.Automation.tests;

import org.apache.bcel.generic.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Tests {

    private WebDriver driver;

    @BeforeClass
    private void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Radek\\Learning_Automation\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @AfterClass
    private void tearDown(){
        driver.quit();
    }

    @Test
    public void smokeTest(){
        driver.get("http://www.amazon.com");
    }

    @Test
    public void testAddingItemToCard(){
        //Select 'Books' from search category dropdown  // ----> TO REPAIR
        new Select(driver.findElement(By.id("searchDropdownBox")))
                .selectByVisibleText("Books");

        //Enter search key: 'Selenium'
        driver.findElement(By.id("twotabsearchtextbox"))
                .sendKeys("Selenium");

        //Click 'Go' button
        driver.findElement(By.xpath("//*[@value='Go']"))
                .click();

        //Click the first search result item title
        WebElement firstItemTitleElement = driver.findElement(By.className("s-access-title"));
        String firstItemTitle = firstItemTitleElement.getText();
        firstItemTitleElement.click();

        //Verify product title
        assert (driver.findElement(By.id("productTitle"))
                .getText()
                .equals(firstItemTitle));

        //Click 'Add to cart' button
        driver.findElement(By.id("add-to-cart-button"))
                .click();

        //Verify confirmation text appears
        assert (driver.findElement(By.id("confirm-text"))
                .getText()
                .equals("1 item added to Cart"));

        //Navigate to 'Cart' page
        driver.findElement(By.id("nav-cart"))
                .click();

        //Verify item is displayed on Shopping Cart list
        assert (driver.findElement(By.className("a-list-item"))
                .getText()
                .contains(firstItemTitle));
        }

    @Test
    public void sampleTestMethod(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open()
                .loginAs("username", "password");
    }
}