import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class bookPage {
    public static final String englishOnlyPage = "kidkiddos.com/collections/english-only";
    public static final String nameOfBook = "I-Love-to-Brush-My-Teeth-Shelley-Admont-Kids-book-cover-English-Only";
    public static final String linkOfBook = "https://kidkiddos.com/collections/english-only/products/i-love-my-dad-english-language-childrens-book";
    public static Double bookPrice;

    public static void openEnglishOnlyPage() {
        basePage.openLink(basePage.mainPage, webDriverSetup.driver);
        basePage.closeAdvWindow();

        WebElement dropdownMenu = webDriverSetup.driver.findElement(By.xpath("//a[contains(@aria-controls, 'SiteNavLabel-books-by-language')]"));
        dropdownMenu.click();

        By dropdownContainerLocator = By.id("SiteNavLabel-books-by-language");
        webDriverSetup.getWait(10).until(ExpectedConditions.visibilityOfElementLocated(dropdownContainerLocator));

        WebElement englishOnlyItem = webDriverSetup.driver.findElement(By.xpath("//a[contains(@href, '/collections/english-only')]"));
        basePage.js.executeScript("arguments[0].click();", englishOnlyItem);
    }

    public static void openBookPage() {
        openEnglishOnlyPage();

        WebElement bookElement = webDriverSetup.getWait(10).until(ExpectedConditions.elementToBeClickable(By.xpath("//img[contains(@alt,'" + bookPage.nameOfBook + "')]")));
        basePage.js.executeScript("arguments[0].click();", bookElement);
    }

    public static void addBookToCard() {
        openBookPage();

        WebElement formatBook = webDriverSetup.driver.findElement(By.id("SingleOptionSelector-0"));
        Select formatSelect = new Select(formatBook);
        formatSelect.selectByVisibleText("Hardcover");

        WebElement priceText = webDriverSetup.driver.findElement(By.xpath("//span[contains(@itemprop,'price')]"));

        bookPage.bookPrice = Double.parseDouble(cartPage.cleanPrice(priceText.getText()));

        WebElement quantityOfBook = webDriverSetup.driver.findElement(By.id("Quantity"));
        quantityOfBook.clear();
        quantityOfBook.sendKeys("5");

        WebElement addToCart = webDriverSetup.driver.findElement(By.id("AddToCart-product-template"));
        addToCart.click();
    }
}
