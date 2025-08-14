import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class loginPageTests {

    @BeforeAll
    public static void driverExist() {
        webDriverSetup.createWebDriver();
    }

    @AfterAll
    public static void closeDriver() {
        webDriverSetup.closeWebDriver();
    }

    @Test
    public void loginScreen() {
        loginPage.goToLoginPage();

        String pageUrl = webDriverSetup.driver.getCurrentUrl();
        assertTrue(pageUrl.contains(loginPage.loginPage));
    }

    @Test
    public void emptyLoginPasswordTest() {
        loginPage.goToLoginPage();

        WebElement customerEmail = webDriverSetup.driver.findElement(By.id("CustomerEmail"));
        customerEmail.clear();

        WebElement customerPassword = webDriverSetup.driver.findElement(By.id("CustomerPassword"));
        customerPassword.clear();

        WebElement submitButton = webDriverSetup.driver.findElement(By.xpath("//input[contains(@type, 'submit')]"));
        submitButton.click();

        WebElement captchaFrame = webDriverSetup.getWait(15).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("iframe[src*='hcaptcha']")));

        assertTrue(captchaFrame.getSize().getHeight() > 0 && captchaFrame.getSize().getWidth() > 0);
    }


    @Test
    public void incorrectLoginPasswordTest() {
        loginPage.goToLoginPage();

        WebElement submitButton = webDriverSetup.driver.findElement(By.xpath("//input[contains(@type, 'submit')]"));
        submitButton.click();

        WebElement customerEmail = webDriverSetup.driver.findElement(By.id("CustomerEmail"));
        customerEmail.sendKeys(loginPage.incorrectLogin);

        WebElement customerPassword = webDriverSetup.driver.findElement(By.id("CustomerPassword"));
        customerPassword.sendKeys(loginPage.incorrectPassword);

        WebElement captchaFrame = webDriverSetup.getWait(15).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("iframe[src*='hcaptcha']")));

        assertTrue(captchaFrame.getSize().getHeight() > 0 && captchaFrame.getSize().getWidth() > 0);
    }
}
