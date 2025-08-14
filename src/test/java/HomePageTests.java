import Pages.BasePage;
import config.Consts;
import config.WebDriver;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class HomePageTests {

    @BeforeAll
    public static void driverExist() {
        WebDriver.createWebDriver();
    }

    @AfterAll
    public static void closeDriver() {
        WebDriver.closeWebDriver();
    }

    @Test
    public void openingMainPageTest() {
        BasePage.openLink(Consts.MAINPAGEURL, WebDriver.driver);

        String pageUrl = WebDriver.driver.getCurrentUrl();
        assertTrue(pageUrl.contains(Consts.MAINPAGEURL));
    }

}
