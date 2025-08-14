import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class bookPage {
    public static final String englishOnlyPage = "kidkiddos.com/collections/english-only";
    public static final String nameOfBook = "I-Love-to-Brush-My-Teeth-Shelley-Admont-Kids-book-cover-English-Only";
    public static final String linkOfBook = "https://kidkiddos.com/collections/english-only/products/i-love-my-dad-english-language-childrens-book";
    public static Double bookPrice;

    ///
    public static final String dropDownMenuXpath = "//a[contains(@aria-controls, 'SiteNavLabel-books-by-language')]";
    public static final String dropdownContainerLocatorXpath = "SiteNavLabel-books-by-language";
    public static final String englishOnlyItemXpath = "//a[contains(@href, '/collections/english-only')]";
    public static final String bookElementXpath = "//img[contains(@alt,'" + bookPage.nameOfBook + "')]";
    public static final String formatBookXpath = "SingleOptionSelector-0";
    public static final String priceTextXpath = "//span[contains(@itemprop,'price')]";
    public static final String quantityOfBookXpath = "Quantity";
    public static final String addToCartXpath = "AddToCart-product-template";


    public static void selectEnglishBookCollection() {
        WebElement dropdownMenu = webDriverSetup.driver.findElement(By.xpath(dropDownMenuXpath));
        dropdownMenu.click();

        By dropdownContainerLocator = By.id(dropdownContainerLocatorXpath);
        webDriverSetup.getWait(10).until(ExpectedConditions.visibilityOfElementLocated(dropdownContainerLocator));

        WebElement englishOnlyItem = webDriverSetup.driver.findElement(By.xpath(englishOnlyItemXpath));
        basePage.js.executeScript("arguments[0].click();", englishOnlyItem);
    }

    public static void openBookPage() {
        WebElement bookElement = webDriverSetup.getWait(10).until(ExpectedConditions.elementToBeClickable(By.xpath(bookElementXpath)));
        basePage.js.executeScript("arguments[0].click();", bookElement);
    }

    public static void addBookToCard() {
        WebElement formatBook = webDriverSetup.driver.findElement(By.id(formatBookXpath));
        Select formatSelect = new Select(formatBook);
        formatSelect.selectByVisibleText("Hardcover");

        WebElement priceText = webDriverSetup.driver.findElement(By.xpath(priceTextXpath));

        bookPage.bookPrice = Double.parseDouble(cartPage.cleanPrice(priceText.getText()));

        WebElement quantityOfBook = webDriverSetup.driver.findElement(By.id(quantityOfBookXpath));
        quantityOfBook.clear();
        quantityOfBook.sendKeys("5");

        WebElement addToCart = webDriverSetup.driver.findElement(By.id(addToCartXpath));
        addToCart.click();
    }
}
