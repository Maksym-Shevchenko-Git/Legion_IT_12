import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class webDriverSetup {
    public static WebDriver driver;

    public static WebDriverWait getWait(int duration) {
        return new WebDriverWait(driver, Duration.ofSeconds(duration));
    }

    public static void createWebDriver() {
        if (driver == null) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
    }

    public static void closeWebDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}




