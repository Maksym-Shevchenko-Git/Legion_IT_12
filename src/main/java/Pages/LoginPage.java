package Pages;

import config.Consts;
import config.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage {
    public static final String incorrectLogin = "incorrectLogin@gggle.kon";
    public static final String incorrectPassword = "error404password";

    public static final String loginButtonXpath = "//a[contains(@href, '/account/login')]";

    public static void goToLoginPage() {
        WebElement loginButton = WebDriver.driver.findElement(By.xpath(loginButtonXpath));
        loginButton.click();
    }
}
