package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductFromSearchPage extends BasePage{

    public ProductFromSearchPage(WebDriver driver) {
        super(driver);
    }

    private By productNameField=new By.ByTagName("h1");

    //private By addToCartButton=new By.ById("add-to-cart-button-4");
    private By addToCartButton=new By.ByXPath("//*[@id=\"add-to-cart-button-4\"]");

    private By notificationField=new By.ByXPath("//*[@id=\"bar-notification\"]");

    private By dismissNotification=new By.ByXPath("//*[@id=\"bar-notification\"]/div/span");

    public Boolean verifyProductNameFromSearch(String productFromSearch){
        return driver.findElement(productNameField).getText().contains(productFromSearch);
    }

    public void clickAddToCart(){
        driver.findElement(addToCartButton).click();
    }

    public Boolean findNotification(String addedNotification){

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("not running");;
        }
        System.out.println("Added Notification"+driver.findElement(notificationField).getText());

        return driver.findElement(notificationField).getText().contains(addedNotification);


    }

    public ShoppingCartPage clickShoppingCart(){


        //driver.findElement(By.id("topcartlink")).click();
        driver.findElement(notificationField).click();
        WebElement cart=driver.findElement(By.xpath("//*[@id=\"topcartlink\"]/a/span[1]"));
        driver.findElement(dismissNotification).click();
        cart.click();
        return new ShoppingCartPage(driver);
    }






}
