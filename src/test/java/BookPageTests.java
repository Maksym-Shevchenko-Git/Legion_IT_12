import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class bookPageTests {
    @BeforeAll
    public static void driverExist() {
        webDriverSetup.createWebDriver();
    }

    @AfterAll
    public static void closeDriver() {
        webDriverSetup.closeWebDriver();
    }

    @Test
    public void openEnglishOnlyPage() {
        bookPage.openEnglishOnlyPage();

        String pageUrl = webDriverSetup.driver.getCurrentUrl();
        assertTrue(pageUrl.contains(bookPage.englishOnlyPage));
    }

    @Test
    public void openBookPage() {
        bookPage.openBookPage();

        String pageUrl = webDriverSetup.driver.getCurrentUrl();
        assertTrue(pageUrl.contains(bookPage.linkOfBook));
    }

    @Test
    public void addBookToCard() {
        bookPage.addBookToCard();

        String pageUrl = webDriverSetup.driver.getCurrentUrl();
        assertTrue(pageUrl.contains(cartPage.cartPageLink));
    }
}

