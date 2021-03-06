import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class AmazonPage {

    protected WebDriver driver;

    @FindBy(id = "nav-main")
    protected Header header;

    public AmazonPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        header = new Header(driver);
    }

    public Header getHeader() {
        return header;
    }
}
