package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ShoppingCartPage extends BasePage {

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }


    private By shoppingCartTitleField=new By.ByTagName("h1");

    //private By shoppingCartTitleField=new By.ByXPath("/html/body/div[6]/div[3]/div/div/div/div[1]/h1");

    //private By productNameField=new By.ByLinkText("HTC One M8 Android L 5.0 Lollipop");

    private By quantityField=new By.ByClassName("qty-input");

    private By searchField=new By.ById("small-searchterms");

    private By productListField=new By.ById("ui-id-1");

    private By updateCartField=new By.ById("updatecart");
    //private By productNameField=new By.ByXPath("//*[@id=\"shopping-cart-form\"]/div[1]/table/tbody/tr/td[3]/a");
    private By productNameField=new By.ByLinkText("/htc-one-m8-android-l-50-lollipop");
    private By productPriceField=new By.ByXPath("//*[@id=\"shopping-cart-form\"]/div[1]/table/tbody/tr/td[4]/span");

    private By getProductPriceFieldAfterAddtoList=new By.ByXPath("//*[@id=\"shopping-cart-form\"]/div[1]/table/tbody/tr[1]/td[4]/span");
    private By subTotalField=new By.ByXPath("//*[@id=\"shopping-cart-form\"]/div[1]/table/tbody/tr/td[6]/span");
    private By totalPriceField=new By.ByXPath("//*[@id=\"shopping-cart-form\"]/div[3]/div[2]/div[1]/table/tbody/tr[4]/td[2]/span/strong");

    private By removeMacProduct=new By.ByXPath("//*[@id=\"shopping-cart-form\"]/div[1]/table/tbody/tr[2]/td[7]/button");

    private By macTiltleField=new By.ByXPath("//*[@id=\"shopping-cart-form\"]/div[1]/table/tbody/tr[2]/td[3]/a");
    private By checkAgreeField= new By.ById("termsofservice");
    private By checkoutButton=new By.ById("checkout");


    public String verifyShoppingCartTitle(){
        return driver.findElement(shoppingCartTitleField).getText();
    }

    public Boolean verifyProductNameInCart(String productNamePart){
        return driver.findElement(productNameField).getText().contains(productNamePart);
    }

    public String getProductPrice(){

        return  driver.findElement(productPriceField).getText();
    }
    public String getProductPriceAgainAfterAdd(){

        return  driver.findElement(getProductPriceFieldAfterAddtoList).getText();
    }

    public String getSubTotalPrice(){
        return driver.findElement(subTotalField).getText();
    }

    public String getTotalPrice(){
       WebElement total= driver.findElement(totalPriceField);
       return  total.getText();
    }

    public int toInteger(String str){
        // use regular expression to extract the integer value from string
        //replaceAll string values with empty values and then parse the string to integer value
        //String str= "$245.00";
        String intValue = str.replaceAll("[^0-9]", "");
        System.out.print(Integer.parseInt(intValue)/100);
        return Integer.parseInt(intValue)/100;

    }

    public void changeQuantity(String qty){
        driver.findElement(quantityField).clear();
        driver.findElement(quantityField).sendKeys(qty);

    }
    public void clickUpdateCart(){

        driver.findElement(updateCartField).click();
    }

    public ProductFromSearchPage searchItem(String newItem){
        driver.findElement(searchField).sendKeys(newItem);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("not running");;
        }
        WebElement firstItemElement=driver.findElements(productListField).get(0);
        firstItemElement.click();
        return new ProductFromSearchPage(driver);

    }

    public Boolean verifyMacProductAdded(String addedProduct){
        return driver.findElement(macTiltleField).getText().contains(addedProduct);

    }

    public void removeMacProductFromCart(){

        WebElement removeIcon=driver.findElement(removeMacProduct);
        removeIcon.click();

    }


    public void checkAgree(){
        driver.findElement(checkAgreeField).click();
    }

    public CheckoutPage clickCheckoutButton(){
        driver.findElement(checkoutButton).click();
        return new CheckoutPage(driver);
    }



}
