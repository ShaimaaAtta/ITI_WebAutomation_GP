package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;
import pages.HomePage;
import pages.LoginPage;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


public class BaseTests {

    ///Static to have same driver in all
    public static WebDriver driver ;
    String randomName= UUID.randomUUID().toString().substring(0,5);

    public String firstName="test";
    public String lastName="Atta";
    public String email="test@example.com";
    public String password="123456";

    public String phone="01118882107";

    public static ChromeOptions chromeOption() {
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--incognito");
        options.addArguments("disable-infobars");
        return options;
    }

   //@BeforeClass
    @BeforeSuite
    public void setUp(){
        //System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        //driver = new ChromeDriver();

        WebDriverManager.chromedriver().setup();
        //driver = new ChromeDriver();
        driver = new ChromeDriver(chromeOption());
        driver.get("https://demo.nopcommerce.com");
        driver.manage().window().maximize();

/*
        WebDriverManager.firefoxdriver().setup();
        driver=new FirefoxDriver();
        driver.get("https://demo.nopcommerce.com");
        driver.manage().window().maximize();
        */


    }

    @AfterSuite

    public void tearDown() {
        driver.quit();
    }


}






