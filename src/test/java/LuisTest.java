import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class LuisTest {

    WebDriver driver;
    String recherche;

    @Before
    public void init() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("test-type");
        capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
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
    public void Test4()
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
