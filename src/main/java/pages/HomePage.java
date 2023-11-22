package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public LoginPage clickLoginLink()
    {
        driver.findElement(By.linkText("Log in")).click();
        System.out.println("we are on login");
        return new LoginPage(driver);

    }

    public RegisterPage clickRegisterLink()
    {
        driver.findElement(By.linkText("Register")).click();
        System.out.println("we are on Register");
        return new RegisterPage(driver);

    }
    public ElectronicsPage clickElectronicsLink()
    {
        driver.findElement(By.linkText("Electronics")).click();
        System.out.println("we are on Elecytonics page");
        return new ElectronicsPage(driver);
    }


    public CellphonesPage hoverOverElectronicsToCellphones()
    {
        WebElement electronicsField=driver.findElement(By.linkText("Electronics"));
        Actions actions = new Actions(driver);
        actions.moveToElement(electronicsField).build().perform();
        WebElement cellphones=driver.findElement(By.xpath("/html/body/div[6]/div[2]/ul[1]/li[2]/ul/li[2]/a"));
        actions.moveToElement(cellphones).click().build().perform();
        return new CellphonesPage(driver);


    }

    public ShoppingCartPage clickShoppingCart(){
        driver.findElement(By.id("topcartlink")).click();
        return new ShoppingCartPage(driver);
    }









}
