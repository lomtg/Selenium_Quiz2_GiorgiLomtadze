import io.netty.util.Timeout;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitsTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\giorgi.lomtadze\\Desktop\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://demoqa.com/progress-bar");

        var startStopButton = driver.findElement(By.id("startStopButton"));

        startStopButton.click();

        var progressBar = driver.findElement(By.xpath("//div[@role='progressbar']"));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        boolean progressStatus = wait.until(ExpectedConditions.attributeToBe(progressBar,"aria-valuenow","50"));

        if(progressStatus)
        {
            startStopButton.click();
        }
    }
}
