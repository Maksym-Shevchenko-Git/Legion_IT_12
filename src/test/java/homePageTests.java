import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class homePage_Test {

    @BeforeAll
    public static void driverExist() {
        if (!webDriverSetup.webDriverExists()) {
            webDriverSetup.createWebDriver();
        }
    }

    @AfterAll
    public static void closeDriver() {
        webDriverSetup.closeWebDriver();
    }

    @Test
    public void openingMainPageTest() {
        base_Page.openLink(base_Page.mainPage, webDriverSetup.driver);
        String pageUrl = webDriverSetup.driver.getCurrentUrl();
        assertTrue(pageUrl.contains(base_Page.mainPage));
    }

}
