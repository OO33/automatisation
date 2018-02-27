import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
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
        recherche = System.getProperty("recherche");
        driver.get("http://www.google.com");
        WebElement search = driver.findElement(By.name("q"));
        search.sendKeys(recherche);
        driver.findElement(By.name("btnK")).click();
    }

    @Test
    public void Test2()
    {
        driver.get("http://www.google.com");
        WebElement search = driver.findElement(By.name("q"));
        search.sendKeys("Test");
        driver.findElement(By.name("btnK")).click();
    }

    @Test
    public void Test3()
    {
        driver.get("http://www.google.com");
        WebElement search = driver.findElement(By.name("q"));
        search.sendKeys("PSG");
        driver.findElement(By.name("btnK")).click();
    }

    @After
    public void quit()
    {
        driver.quit();
    }
}
