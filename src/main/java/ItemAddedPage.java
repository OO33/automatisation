import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ItemAddedPage {

    WebDriver driver;

    @FindBy(id = "nav-main")
    private Header header;

    public ItemAddedPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        header = new Header(driver);
    }

    public Header getHeader() {
        return header;
    }
}
