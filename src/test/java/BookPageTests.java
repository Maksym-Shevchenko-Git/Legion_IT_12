import Pages.BasePage;
import Pages.BookPage;
import config.Consts;
import config.WebDriver;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BookPageTests {
    @BeforeAll
    public static void driverExist() {
        WebDriver.createWebDriver();
    }

    @AfterAll
    public static void closeDriver() {
        WebDriver.closeWebDriver();
    }

    @Test
    public void openEnglishOnlyPageTest() {
        BasePage.openLink(Consts.MAINPAGEURL, WebDriver.driver);
        BasePage.closeAdvWindow();
        BookPage.selectEnglishBookCollection();

        String pageUrl = WebDriver.driver.getCurrentUrl();
        assertTrue(pageUrl.contains(Consts.ENGLISHONLYPAGEURL));
    }

    @Test
    public void openBookPageTest() {
        BasePage.openLink(Consts.MAINPAGEURL, WebDriver.driver);
        BasePage.closeAdvWindow();
        BookPage.selectEnglishBookCollection();
        BookPage.openBookPage();

        String pageUrl = WebDriver.driver.getCurrentUrl();
        assertTrue(pageUrl.contains(Consts.BOOKURL));
    }

    @Test
    public void addBookToCardTest() {
        BasePage.openLink(Consts.MAINPAGEURL, WebDriver.driver);
        BasePage.closeAdvWindow();
        BookPage.selectEnglishBookCollection();
        BookPage.openBookPage();
        BookPage.addBookToCard();

        String pageUrl = WebDriver.driver.getCurrentUrl();
        assertTrue(pageUrl.contains(Consts.CARTPAGEURL));
    }
}

