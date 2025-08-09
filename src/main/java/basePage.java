import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class basePage {

    public static final String mainPage = "https://kidkiddos.com/";
    public static final JavascriptExecutor js = (JavascriptExecutor) webDriverSetup.driver;

    public static void openLink(String link, WebDriver driver) {
        webDriverSetup.getWait(10).until((ExpectedCondition<Boolean>) wd -> js.executeScript("return document.readyState").equals("complete"));

        driver.manage().window().maximize();
        driver.get(link);
    }

    public static void closeAdvWindow() {
        try {
            By closeButtonLocator = By.xpath("//button[text()='No, thanks']");
            webDriverSetup.getWait(15).until(ExpectedConditions.elementToBeClickable(closeButtonLocator)).click();
        } catch (TimeoutException e) {
            System.out.println("There was no window for 15 seconds.");
        }
    }
}
