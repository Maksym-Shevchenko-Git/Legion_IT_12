package pages;

import config.Consts;
import config.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import static config.WebDriver.findWebElement;

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
        WebElement dropdownMenu = findWebElement(dropDownMenuXpath);
        dropdownMenu.click();

        By dropdownContainerLocator = By.id(dropdownContainerLocatorXpath);
        WebDriver.getWait(10).until(ExpectedConditions.visibilityOfElementLocated(dropdownContainerLocator));

        WebElement englishOnlyItem = findWebElement(englishOnlyItemXpath);
        BasePage.js.executeScript("arguments[0].click();", englishOnlyItem);
    }

    public static void openBookPage() {
        WebElement bookElement = WebDriver.getWait(10).until(ExpectedConditions.elementToBeClickable(By.xpath(bookElementXpath)));
        BasePage.js.executeScript("arguments[0].click();", bookElement);
    }

    public static void addBookToCard() {
        WebElement formatBook = findWebElement(formatBookXpath);
        Select formatSelect = new Select(formatBook);
        formatSelect.selectByVisibleText("Hardcover");

        WebElement priceText = findWebElement(priceTextXpath);

        BookPage.bookPrice = Double.parseDouble(CartPage.cleanPrice(priceText.getText()));

        WebElement quantityOfBook = findWebElement(quantityOfBookXpath);
        quantityOfBook.clear();
        quantityOfBook.sendKeys(defaultQuantity);

        WebElement addToCart = findWebElement(addToCartXpath);
        addToCart.click();
    }
}
