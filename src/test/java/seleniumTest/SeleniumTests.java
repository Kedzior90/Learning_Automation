package seleniumTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SeleniumTests {

    private WebDriver driver;

    @BeforeClass
    private void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\RKEDRA\\IdeaProjects\\Learning_Automation\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @AfterClass
    private void tearDown(){
        driver.quit();
    }

    @Test
    public void smokeTest(){
        driver.get("http://www.amazon.com");
        System.out.println("Poprawne dzialanie");
    }
}