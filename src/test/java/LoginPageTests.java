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

import static config.WebDriver.findWebElement;
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

        WebElement customerEmail = findWebElement(customerEmailXpath);
        customerEmail.clear();

        WebElement customerPassword = findWebElement(customerPasswordXpath);
        customerPassword.clear();

        WebElement submitButton = findWebElement(submitButtonXpath);
        submitButton.click();

        WebElement captchaFrame = WebDriver.getWait(15).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(captchaFrameXpath)));

        assertTrue(captchaFrame.getSize().getHeight() > 0 && captchaFrame.getSize().getWidth() > 0);
    }

    @Test
    public void incorrectLoginPasswordTest() {
        BasePage.openLink(Consts.MAINPAGEURL, WebDriver.driver);
        LoginPage.goToLoginPage();

        WebElement customerEmail = findWebElement(customerEmailXpath);
        customerEmail.sendKeys(LoginPage.incorrectLogin);

        WebElement customerPassword = findWebElement(customerPasswordXpath);
        customerPassword.sendKeys(LoginPage.incorrectPassword);

        WebElement submitButton = findWebElement(submitButtonXpath);
        submitButton.click();

        WebElement captchaFrame = WebDriver.getWait(15).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(captchaFrameXpath)));

        assertTrue(captchaFrame.getSize().getHeight() > 0 && captchaFrame.getSize().getWidth() > 0);
    }
}
