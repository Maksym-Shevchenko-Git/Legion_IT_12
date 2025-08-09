import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class loginPage {

    public static final String loginPage = "https://kidkiddos.com/account/login";
    public static final String incorrectLogin = "incorrectLogin@gggle.kon";
    public static final String incorrectPassword = "error404password";

    public static void goToLoginPage() {
        basePage.openLink(basePage.mainPage, webDriverSetup.driver);

        WebElement loginButton = webDriverSetup.driver.findElement(By.xpath("//a[contains(@href, '/account/login')]"));
        loginButton.click();
    }
}
