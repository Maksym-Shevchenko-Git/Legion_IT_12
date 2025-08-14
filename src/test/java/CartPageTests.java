import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class cartPageTests {
    @BeforeAll
    public static void driverExist() {
        webDriverSetup.createWebDriver();
    }

    @AfterAll
    public static void closeDriver() {
        webDriverSetup.closeWebDriver();
    }

    @Test
    public void updateCard() {
        Map cart = cartPage.updateCard();

        assertEquals(cart.get("newQuantityOfBook"), cartPage.newQ);
        assertEquals(Double.parseDouble(cartPage.cleanPrice(cart.get("newTotalValue").toString())),  Double.parseDouble(cartPage.newQ) * bookPage.bookPrice);
    }
}
