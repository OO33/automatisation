import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConsolePage {

    WebDriver driver;

    @FindBy(id = "nav-main")
    private Header header;

    @FindBy(id = "anonCarousel1")
    private WebElement categoriesSection;

    public ConsolePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        header = new Header(driver);
    }

    public GamesPage openGamesCategory() {
        categoriesSection.findElement(By.linkText("Jeux")).click();
        return new GamesPage(driver);
    }
}
