package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Alert;

import java.util.concurrent.TimeUnit;

public class SelectedItemPage {

    private WebDriver driver;
    private WebDriverWait wait;

    //private By notificationBar=new By.ById("bar-notification");
    private By notificationBar=new By.ByXPath("//*[@id=\"bar-notification\"]/div/p/text()");

    public SelectedItemPage(WebDriver driver) {
        this.driver = driver;
    }

    private By addToCartButton=new By.ById("add-to-cart-button-18");

    public void clickAddToCart(){
        driver.findElement(addToCartButton).click();

    }
    public void alertDisplay(){
        WebDriverWait wait=new WebDriverWait(driver, 1);
        wait.until(ExpectedConditions.alertIsPresent());
        String alert=driver.switchTo().alert().getText();
        System.out.println(alert);


    }

    public void checkAlert() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 2);
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            System.out.println(alert.getText());
            //alert.accept();

        } catch (Exception e) {
            System.out.println("not running");
        }
    }

    public ShoppingCartPage clickShoppingCart(){
        driver.findElement(By.id("topcartlink")).click();
        return new ShoppingCartPage(driver);
    }


}
