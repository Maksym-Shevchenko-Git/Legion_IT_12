import pages.BasePage;
import pages.BookPage;
import pages.CartPage;
import config.Consts;
import config.WebDriver;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CartPageTests {

    @BeforeAll
    public static void driverExist() {
        WebDriver.createWebDriver();
    }

    @AfterAll
    public static void closeDriver() {
        WebDriver.closeWebDriver();
    }

    @Test
    public void updateCartTest() {
        BasePage.openLink(Consts.MAINPAGEURL, WebDriver.driver);
        BasePage.closeAdvWindow();
        BookPage.selectEnglishBookCollection();
        BookPage.openBookPage();
        BookPage.addBookToCard();

        Map cart = CartPage.updateCard();

        assertEquals(cart.get("newQuantity"), Double.parseDouble(CartPage.newQ));
        assertEquals(cart.get("newTotal"), Double.parseDouble(CartPage.newQ) * BookPage.bookPrice);
    }
}
