import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.HashMap;
import java.util.Map;

public class cartPage {
    public static final String cartPageLink = "https://kidkiddos.com/cart";
    public static final String newQ = "6";

    public static String cleanPrice(String priceText) {
        return priceText.replaceAll("[^\\d.]", "");
    }

    public static Map<String, String> updateCard() {

        Map<String, String> newCart = new HashMap<>();

        bookPage.addBookToCard();

        WebElement quantityOfBook = webDriverSetup.driver.findElement(By.xpath("//input[contains(@class, 'cart__qty-input')]"));
        quantityOfBook.clear();
        quantityOfBook.sendKeys(newQ);

        WebElement updateButton = webDriverSetup.driver.findElement(By.xpath("//input[contains(@class, 'btn btn--secondary cart__update cart__update--large small--hide')]"));
        updateButton.click();

        webDriverSetup.getWait(10).until(ExpectedConditions.attributeToBe(By.xpath("//input[contains(@class, 'cart__qty-input')]"), "value", newQ));

        quantityOfBook = webDriverSetup.driver.findElement(By.xpath("//input[contains(@class, 'cart__qty-input')]"));
        String newQuantityOfBookValue = quantityOfBook.getAttribute("value");

        WebElement newTotal = webDriverSetup.driver.findElement(By.xpath("//span[contains(@class, 'money skiptranslate notranslate') and ancestor::td[contains(@class, 'text-right small--hide')]]"));
        String newTotalValue = basePage.js.executeScript("return arguments[0].textContent;", newTotal).toString();

        newCart.put("newQuantityOfBook", newQuantityOfBookValue);
        newCart.put("newTotalValue", newTotalValue);

        return newCart;

    }
}
