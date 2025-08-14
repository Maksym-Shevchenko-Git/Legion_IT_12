import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class homePageTests {

    @BeforeAll
    public static void driverExist() {
        webDriverSetup.createWebDriver();
    }

    @AfterAll
    public static void closeDriver() {
        webDriverSetup.closeWebDriver();
    }

    @Test
    public void openingMainPageTest() {
        basePage.openLink(basePage.mainPage, webDriverSetup.driver);

        String pageUrl = webDriverSetup.driver.getCurrentUrl();
        assertTrue(pageUrl.contains(basePage.mainPage));
    }

}
