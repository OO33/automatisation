import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LuisTest {

    WebDriver driver;
    String recherche;

    @Before
    public void init()
    {
        driver = new ChromeDriver();
    }

    @Test
    public void Test1()
    {
        driver.get("http://www.google.com");
        WebElement search = driver.findElement(By.name("q"));
        search.sendKeys("Real Madrid" + Keys.ENTER);
    }

    @Test
    public void Test2()
    {
        driver.get("http://www.google.com");
        WebElement search = driver.findElement(By.name("q"));
        search.sendKeys("Test" + Keys.ENTER);
    }

    @Test
    public void Test3()
    {
        driver.get("http://www.google.com");
        WebElement search = driver.findElement(By.name("q"));
        search.sendKeys("PSG" + Keys.ENTER);
    }

    @Test
    public void Test3()
    {
        driver.get("http://www.google.com");
        WebElement search = driver.findElement(By.name("q"));
        search.sendKeys("Garelli" + Keys.ENTER);
    }

    @After
    public void quit()
    {
        driver.quit();
    }
}
