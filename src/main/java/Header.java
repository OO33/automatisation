import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Header {

    WebDriver driver;

    @FindBy(id = "nav-shop")
    WebElement categoriesMenu;

    @FindBy(id = "nav-cart")
    WebElement cartButton;

    @FindBy(css = "span[data-nav-panelkey='VideogamesConsolesPanel']")
    WebElement videoGamesCategory;

    @FindBy(css = "#nav-flyout-shopAll>.nav-subcats")
    WebElement subCategoryPanel;
    
    public Header(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public ConsolePage openVideoGames(String linkText) {
        Actions action = new Actions(driver);
        action.moveToElement(categoriesMenu).perform();
        action.moveToElement(videoGamesCategory).perform();

        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        webDriverWait.until(ExpectedConditions.visibilityOf(subCategoryPanel));

        driver.findElement(By.linkText(linkText)).click();
        return new ConsolePage(driver);
    }

    public CartPage openCart() {
        cartButton.click();
        return new CartPage(driver);
    }
}
