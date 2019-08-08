package seleniumTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class SeleniumTests {

    private WebDriver driver;
    private HomePage homePage;

    @BeforeClass
    public void setUp() {
        String driverPath = new File("chromedriver.exe").getAbsolutePath();
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.manage()
                .timeouts()
                .implicitlyWait(5, TimeUnit.SECONDS);
    }

    @BeforeMethod
    public void openHomePage(){
        homePage = new HomePage(driver).open();
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void testAddingItemToCard() {
        //Select 'Books' from search category dropdown
        new Select(driver.findElement(By.id("searchDropdownBox")))
                .selectByVisibleText("Books");

        //Enter search key: 'Selenium'
        driver.findElement(By.id("twotabsearchtextbox"))
                .sendKeys("Selenium");

        //Click 'Go' button
        driver.findElement(By.xpath("//*[@value='Go']"))
                .click();

        //Click the first search result item title
        WebElement firstItemTitleElement = driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[2]/div/span[3]/div[1]/div[1]/div/div/div/div[2]/div[2]/div/div[1]/div/div/div[1]/h2/a/span"));
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
        assert (driver.findElement(By.xpath("//*[@id=\"huc-v2-order-row-confirm-text\"]/h1"))
                .getText()
                .equals("Added to Cart"));

        //Navigate to 'Cart' page
        driver.findElement(By.id("nav-cart"))
                .click();

        //Verify item is displayed on Shopping Cart list
        assert (driver.findElement(By.className("sc-list-item-content"))
                .getText()
                .contains(firstItemTitle));
    }
}