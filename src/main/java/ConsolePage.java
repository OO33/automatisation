import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConsolePage extends AmazonPage {

    @FindBy(id = "anonCarousel1")
    private WebElement categoriesSection;

    public ConsolePage(WebDriver driver) {
        super(driver);
    }

    public GamesPage openGamesCategory() {
        categoriesSection.findElement(By.linkText("Jeux")).click();
        return new GamesPage(driver);
    }
}
