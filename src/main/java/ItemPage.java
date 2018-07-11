import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ItemPage {

    WebDriver driver;

    @FindBy(id = "nav-main")
    private Header header;

    @FindBy(id = "add-to-cart-button")
    private WebElement addToCartButton;

    public ItemPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        header = new Header(driver);
    }

    public ItemAddedPage addToCart() {
        addToCartButton.click();
        return new ItemAddedPage(driver);
    }
}
