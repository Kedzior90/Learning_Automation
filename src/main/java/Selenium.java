import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Selenium {

    public static void main(String[] args) throws InterruptedException {
        // Optional, if not specified, WebDriver will search your path for chromedriver.
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Radek\\Learning_Automation\\chromedriver_win32\\chromedriver.exe");


        WebDriver driver = new ChromeDriver();
        //driver.get("http://www.google.com/xhtml");
        driver.get("https://www.seleniumhq.org/");
        Thread.sleep(5000);  // Let the user actually see something!
        //WebElement searchBox = driver.findElement(By.name("q"));
        //searchBox.sendKeys("Dupa");
        //searchBox.submit();
        //Thread.sleep(5000);  // Let the user actually see something!
        driver.quit();
    }
}
