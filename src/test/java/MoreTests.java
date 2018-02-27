import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MoreTests {
    WebDriver driver;
    String recherche;

    @Before
    public void init()
    {
        driver = new ChromeDriver();
    }

    @Test
    public void Test3()
    {
        driver.get("http://www.google.com");
        WebElement search = driver.findElement(By.name("q"));
        search.sendKeys("Venezuela");
        driver.findElement(By.name("btnK")).click();
    }

    @After
    public void quit()
    {
        driver.quit();
    }
}
