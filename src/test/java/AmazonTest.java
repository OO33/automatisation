import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

import static java.time.Duration.*;
import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.hamcrest.CoreMatchers.is;

public class AmazonTest {
    WebDriver driver;

    @Test
    public void testBooks()
    {
        Actions action = new Actions(driver);

        WebElement parcourirCategories = driver.findElement(By.id("nav-shop"));
        action.moveToElement(parcourirCategories);
        action.build().perform();

        WebElement livresMenu = driver.findElement(By.cssSelector("span[data-nav-panelkey='BooksPanel']"));
        action.moveToElement(livresMenu).build().perform();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#nav-flyout-shopAll>.nav-subcats ")));

        WebElement tousLesLivres = driver.findElement(By.linkText("Tous les livres"));
        System.out.println(tousLesLivres.getText());
        tousLesLivres.click();
    }

    @Test
    public void testMarioKart()
    {
        Actions action = new Actions(driver);

        WebElement parcourirCategories = driver.findElement(By.id("nav-shop"));
        action.moveToElement(parcourirCategories);
        action.build().perform();

        WebElement livresMenu = driver.findElement(By.cssSelector("span[data-nav-panelkey='VideogamesConsolesPanel']"));
        action.moveToElement(livresMenu).build().perform();

        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#nav-flyout-shopAll>.nav-subcats ")));

        driver.findElement(By.linkText("Nintendo Switch")).click();

        WebElement categoriesSection = driver.findElement(By.id("anonCarousel1"));
        categoriesSection.findElement(By.linkText("Jeux")).click();

        WebElement premierResultat = driver.findElement(By.id("result_0"));
        premierResultat.findElement(By.className("a-link-normal")).click();

        driver.findElement(By.id("add-to-cart-button")).click();

        driver.findElement(By.id("nav-cart")).click();

        Select quantite = new Select(driver.findElement(By.name("quantity")));
        quantite.selectByValue("2");

        FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(ofSeconds(5))
                .pollingEvery(ofMillis(100))
                .ignoring(NoSuchElementException.class);

        Boolean foo = wait.until(new Function<WebDriver, Boolean>() {
            public Boolean apply(WebDriver driver) {
                String sousTotal = driver.findElement(By.id("sc-subtotal-label-activecart")).getText();
                return sousTotal.contains("(2 articles):");
            }
        });


        String prixFinal = driver.findElement(By.id("sc-subtotal-amount-activecart")).getText();
        Assert.assertThat(prixFinal, is("EUR 99,98"));
    }

    @Test
    public void TestMarioKartWithPageObjects()
    {
        HomePage homePage = new HomePage(driver);
        ConsolePage consolePage = homePage.getHeader().openVideoGames("Nintendo Switch");
        GamesPage gamesPage = consolePage.openGamesCategory();
        ItemPage item = gamesPage.openItem(0); // premier resultat
        ItemAddedPage itemAddedPage = item.addToCart();
        CartPage cartPage = itemAddedPage.getHeader().openCart();
        cartPage.changeItemQuantity(0, 3); // changer la quantite de notre premier article a 3
        Assert.assertThat(cartPage.getTotalPrice(), is("EUR 149,97"));
    }

    @Before
    public void init()
    {
        driver = new ChromeDriver();
        driver.manage().window().fullscreen();
        driver.get("https://www.amazon.fr");
    }

    @After
    public void teardown()
    {
        driver.quit();
    }

}
