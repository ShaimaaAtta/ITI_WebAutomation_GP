package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MyHomePage extends BasePage {

    //private WebDriver driver;



    public MyHomePage(WebDriver driver) {
        super(driver);
    }


    private By myAccount=new By.ByLinkText("My account");

    public MyAccount verifyMyAccount(){
        driver.findElement(myAccount).click();
        return new MyAccount(driver);
    }

    public CellphonesPage hoverOverElectronicsToCellphones() {
        WebElement electronicsField = driver.findElement(By.linkText("Electronics"));
        Actions actions = new Actions(driver);
        actions.moveToElement(electronicsField).build().perform();
        WebElement cellphones = driver.findElement(By.xpath("/html/body/div[6]/div[2]/ul[1]/li[2]/ul/li[2]/a"));
        actions.moveToElement(cellphones).click().build().perform();
        return new CellphonesPage(driver);

    }



}
