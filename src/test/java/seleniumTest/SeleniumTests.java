package seleniumTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
        System.out.println("dzialajace ustawienia");
    }
}