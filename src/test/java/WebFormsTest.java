import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class WebFormsTest {
    public static void main(String[] args){

        System.setProperty("webdriver.chrome.driver","C:\\Users\\giorgi.lomtadze\\Desktop\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("http://webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html");

        Select dropDown = new Select(driver.findElement(By.id("dropdowm-menu-1")));

        String option = "c#";

        dropDown.selectByValue(option);

        List<WebElement> list = driver.findElements(By.cssSelector("input[type='checkbox']"));

        for (var checkbox: list
             ) {
            if(!checkbox.isSelected())
            {
                checkbox.click();
            }
        }

        WebElement rbutton = driver.findElement(By.cssSelector("input[value='yellow']"));
        rbutton.click();

        Select drpCountry = new Select(driver.findElement(By.id("fruit-selects")));
        var options = drpCountry.getOptions();

        for (var opt: options
             ) {

            var fruit = opt.getText();

            if(fruit.equals("Orange"))
            {
                if(!opt.isEnabled())
                {
                    System.out.println("Orange dropdown is disabled");
                }
            }
        }

        try {
            driver.wait(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.quit();
    }
}
