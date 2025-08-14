import Pages.BasePage;
import config.Consts;
import config.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class loginPage {

    public static final String incorrectLogin = "incorrectLogin@gggle.kon";
    public static final String incorrectPassword = "error404password";

    public static void goToLoginPage() {
        BasePage.openLink(Consts.mainPage, WebDriver.driver);

        WebElement loginButton = WebDriver.driver.findElement(By.xpath("//a[contains(@href, '/account/login')]"));
        loginButton.click();
    }
}
