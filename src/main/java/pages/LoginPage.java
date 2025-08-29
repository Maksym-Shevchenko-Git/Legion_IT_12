package pages;

import config.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static config.WebDriver.findWebElement;

public class LoginPage {
    public static final String incorrectLogin = "incorrectLogin@gggle.kon";
    public static final String incorrectPassword = "error404password";

    public static final String loginButtonXpath = "//a[contains(@href, '/account/login')]";

    public static void goToLoginPage() {
        WebElement loginButton = findWebElement(loginButtonXpath);
        loginButton.click();
    }
}
