package pages;

import config.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.HashMap;
import java.util.Map;

public class CartPage {
    public static final String quantityOfBookXpath = "//input[contains(@class, 'cart__qty-input')]";
    public static final String updateButtonXpath = "//input[contains(@class, 'btn btn--secondary cart__update cart__update--large small--hide')]";
    public static final String newTotalXpath = "//span[contains(@class, 'money skiptranslate notranslate') and ancestor::td[contains(@class, 'text-right small--hide')]]";

    public static final String newQ = "6";

    public static String cleanPrice(String priceText) {
        return priceText.replaceAll("[^\\d.]", "");
    }

    public static Map<String, Double> updateCard() {

        Map<String, Double> newCart = new HashMap<>();

        WebElement quantityOfBookElement = WebDriver.driver.findElement(By.xpath(quantityOfBookXpath));
        quantityOfBookElement.clear();
        quantityOfBookElement.sendKeys(newQ);

        WebElement updateButton = WebDriver.driver.findElement(By.xpath(updateButtonXpath));
        updateButton.click();

        WebDriver.getWait(10).until(ExpectedConditions.attributeToBe(By.xpath(quantityOfBookXpath), "value", newQ));

        quantityOfBookElement = WebDriver.driver.findElement(By.xpath(quantityOfBookXpath));
        String newQuantity = quantityOfBookElement.getAttribute("value");

        WebElement newTotalElement = WebDriver.driver.findElement(By.xpath(newTotalXpath));
        String newTotal = BasePage.js.executeScript("return arguments[0].textContent;", newTotalElement).toString();

        newCart.put("newQuantity", Double.parseDouble(newQuantity));
        newCart.put("newTotal", Double.parseDouble(CartPage.cleanPrice(newTotal)));

        return newCart;

    }
}
