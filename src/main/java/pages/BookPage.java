package Pages;

import config.Consts;
import config.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class BookPage {
    public static Double bookPrice;
    public static final String defaultQuantity = "5";

    public static final String dropDownMenuXpath = "//a[contains(@aria-controls, 'SiteNavLabel-books-by-language')]";
    public static final String dropdownContainerLocatorXpath = "SiteNavLabel-books-by-language";
    public static final String englishOnlyItemXpath = "//a[contains(@href, '/collections/english-only')]";
    public static final String bookElementXpath = "//img[contains(@alt,'" + Consts.NAMEOFBOOK + "')]";
    public static final String formatBookXpath = "SingleOptionSelector-0";
    public static final String priceTextXpath = "//span[contains(@itemprop,'price')]";
    public static final String quantityOfBookXpath = "Quantity";
    public static final String addToCartXpath = "AddToCart-product-template";

    public static void selectEnglishBookCollection() {
        WebElement dropdownMenu = WebDriver.driver.findElement(By.xpath(dropDownMenuXpath));
        dropdownMenu.click();

        By dropdownContainerLocator = By.id(dropdownContainerLocatorXpath);
        WebDriver.getWait(10).until(ExpectedConditions.visibilityOfElementLocated(dropdownContainerLocator));

        WebElement englishOnlyItem = WebDriver.driver.findElement(By.xpath(englishOnlyItemXpath));
        BasePage.js.executeScript("arguments[0].click();", englishOnlyItem);
    }

    public static void openBookPage() {
        WebElement bookElement = WebDriver.getWait(10).until(ExpectedConditions.elementToBeClickable(By.xpath(bookElementXpath)));
        BasePage.js.executeScript("arguments[0].click();", bookElement);
    }

    public static void addBookToCard() {
        WebElement formatBook = WebDriver.driver.findElement(By.id(formatBookXpath));
        Select formatSelect = new Select(formatBook);
        formatSelect.selectByVisibleText("Hardcover");

        WebElement priceText = WebDriver.driver.findElement(By.xpath(priceTextXpath));

        BookPage.bookPrice = Double.parseDouble(CartPage.cleanPrice(priceText.getText()));

        WebElement quantityOfBook = WebDriver.driver.findElement(By.id(quantityOfBookXpath));
        quantityOfBook.clear();
        quantityOfBook.sendKeys(defaultQuantity);

        WebElement addToCart = WebDriver.driver.findElement(By.id(addToCartXpath));
        addToCart.click();
    }
}
