package hooks;

import context.ContextStore;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.HomePage;

import java.util.Arrays;

import static data.TestData.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class Hooks {

    private WebDriver driver;
    protected HomePage homePage;

    @BeforeEach
    public void setUp(){
        ContextStore.loadProperties("src/test/resources/test.properties");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(setChromeOptions());
        driver.get(URL_SAUCE_DEMO);
        homePage = new HomePage(driver);
    }

    @AfterEach
    public void tearDown(){
        driver.quit();
        ContextStore.clear();
    }

    private ChromeOptions setChromeOptions(){
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));
        options.addArguments("--start-maximized");
        //options.addArguments("--headless");
        //options.addArguments("--disable-gpu");
        return options;
    }
}
