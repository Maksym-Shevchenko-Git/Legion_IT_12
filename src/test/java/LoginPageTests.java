import pages.BasePage;
import pages.LoginPage;
import config.Consts;
import config.WebDriver;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginPageTests {
    public static final String customerEmailXpath = "CustomerEmail";
    public static final String customerPasswordXpath = "CustomerPassword";
    public static final String submitButtonXpath = "//input[contains(@type, 'submit')]";
    public static final String captchaFrameXpath = "iframe[src*='hcaptcha']";

    @BeforeAll
    public static void driverExist() {
        WebDriver.createWebDriver();
    }

    @AfterAll
    public static void closeDriver() {
        WebDriver.closeWebDriver();
    }

    @Test
    public void loginScreen() {
        BasePage.openLink(Consts.MAINPAGEURL, WebDriver.driver);
        LoginPage.goToLoginPage();

        String pageUrl = WebDriver.driver.getCurrentUrl();
        assertTrue(pageUrl.contains(Consts.LOGINPAGEURL));
    }

    @Test
    public void emptyLoginPasswordTest() {
        BasePage.openLink(Consts.MAINPAGEURL, WebDriver.driver);
        LoginPage.goToLoginPage();

        WebElement customerEmail = WebDriver.driver.findElement(By.id(customerEmailXpath));
        customerEmail.clear();

        WebElement customerPassword = WebDriver.driver.findElement(By.id(customerPasswordXpath));
        customerPassword.clear();

        WebElement submitButton = WebDriver.driver.findElement(By.xpath(submitButtonXpath));
        submitButton.click();

        WebElement captchaFrame = WebDriver.getWait(15).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(captchaFrameXpath)));

        assertTrue(captchaFrame.getSize().getHeight() > 0 && captchaFrame.getSize().getWidth() > 0);
    }

    @Test
    public void incorrectLoginPasswordTest() {
        BasePage.openLink(Consts.MAINPAGEURL, WebDriver.driver);
        LoginPage.goToLoginPage();

        WebElement customerEmail = WebDriver.driver.findElement(By.id(customerEmailXpath));
        customerEmail.sendKeys(LoginPage.incorrectLogin);

        WebElement customerPassword = WebDriver.driver.findElement(By.id(customerPasswordXpath));
        customerPassword.sendKeys(LoginPage.incorrectPassword);

        WebElement submitButton = WebDriver.driver.findElement(By.xpath(submitButtonXpath));
        submitButton.click();

        WebElement captchaFrame = WebDriver.getWait(15).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(captchaFrameXpath)));

        assertTrue(captchaFrame.getSize().getHeight() > 0 && captchaFrame.getSize().getWidth() > 0);
    }
}
