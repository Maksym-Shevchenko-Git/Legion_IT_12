package pages;

import config.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BasePage {
    public static final String closeButtonLocatorXpath = "//button[text()='No, thanks']";

    public static final JavascriptExecutor js = (JavascriptExecutor) WebDriver.driver;

    public static void openLink(String link, org.openqa.selenium.WebDriver driver) {
        WebDriver.getWait(10).until((ExpectedCondition<Boolean>) wd -> js.executeScript("return document.readyState").equals("complete"));

        driver.manage().window().maximize();
        driver.get(link);
    }

    public static void closeAdvWindow() {
        try {
            By closeButtonLocator = By.xpath(closeButtonLocatorXpath);
            WebDriver.getWait(15).until(ExpectedConditions.elementToBeClickable(closeButtonLocator)).click();
        } catch (TimeoutException e) {
            System.out.println("There was no window for 15 seconds.");
        }
    }
}
