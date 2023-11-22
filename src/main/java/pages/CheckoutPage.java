package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import static java.lang.Thread.*;

public class CheckoutPage extends BasePage{


    public CheckoutPage(WebDriver driver){
        super(driver);
    }

    private By pageTileField=new By.ByXPath("/html/body/div[6]/div[3]/div/div/div/div[1]/h1");
    private By billAddressFirstName=new By.ById("BillingNewAddress_FirstName");
    private By billAddressLastName=new By.ById("BillingNewAddress_LastName");
    private By billAddressEmail=new By.ById("BillingNewAddress_Email");
    private By billAddressCountry=new By.ById("BillingNewAddress_CountryId");
    private By billAddressCity=new By.ById("BillingNewAddress_City");
    private By billAddress1=new By.ById("BillingNewAddress_Address1");
    private By billAddressZipcode=new By.ById("BillingNewAddress_ZipPostalCode");
    private By billAddressPhone=new By.ById("BillingNewAddress_PhoneNumber");
    private By billAddressContinueButton=new By.ByXPath("//*[@id=\"billing-buttons-container\"]/button[4]");


    private By checkShipNext=new By.ById("shippingoption_1");
    private By shipContinueButton=new By.ByXPath("//*[@id=\"shipping-method-buttons-container\"]/button");

    private By checkCreditCard=new By.ByXPath("//*[@id=\"paymentmethod_1\"]");
    private By paymentContinueButton=new By.ByXPath("//*[@id=\"payment-method-buttons-container\"]/button");

    private By creditCardTypeField=new By.ById("CreditCardType");
    private By cardHolderNameField=new By.ById("CardholderName");
    private By cardNumField=new By.ById("CardNumber");
    private By expireMonthField=new By.ById("ExpireMonth");
    private By expireYearField=new By.ById("ExpireYear");
    private By cardCodeField=new By.ById("CardCode");
    private By paymentInfoContinueButton=new By.ByXPath("//*[@id=\"payment-info-buttons-container\"]/button");


    public Boolean verifyPageTitle(String title){

        return driver.findElement(pageTileField).getText().contains(title);
    }
    public void setBillFirstNameField(String firstName){
        driver.findElement(billAddressFirstName).sendKeys(firstName);
    }

    public void setBillLastNameField(String lastName){
        driver.findElement(billAddressLastName).sendKeys(lastName);
    }

    public void setBillEmailField(String email){
        driver.findElement(billAddressEmail).sendKeys(email);
    }

    public void setCountryField(String countryName){
        Select countryElement=new Select(driver.findElement(billAddressCountry));
        countryElement.selectByVisibleText(countryName);
    }

    public void setCityField(String cityName){
        driver.findElement(billAddressCity).sendKeys(cityName);
    }
    public void setAddress1Field(String address){
        driver.findElement(billAddress1).sendKeys(address);
    }
    public void setZipcodeField(String zipcode){
        driver.findElement(billAddressZipcode).sendKeys(zipcode);
    }

    public void setPhoneField(String phone){
        driver.findElement(billAddressPhone).sendKeys(phone);
    }

    public void clickBillContinueButton(){
        driver.findElement(billAddressContinueButton).click();
        //Thread.sleep(1000);
        try
        {
            Thread.sleep(1000);
        }
        catch(InterruptedException e)
        {
            // this part is executed when an exception (in this example InterruptedException) occurs
            System.out.println("not running");
        }

    }

    public void clickShipContinueButton(){
        driver.findElement(checkShipNext).click();
        driver.findElement(shipContinueButton).click();
        try
        {
            Thread.sleep(1000);
        }
        catch(InterruptedException e)
        {
            // this part is executed when an exception (in this example InterruptedException) occurs
            System.out.println("not running");
        }


    }

    public void selectPayByCredit(){
        driver.findElement(checkCreditCard).click();
        driver.findElement(paymentContinueButton).click();
        try
        {
            Thread.sleep(1000);
        }
        catch(InterruptedException e)
        {
            // this part is executed when an exception (in this example InterruptedException) occurs
            System.out.println("not running");
        }

    }

    public void fillCreditCardInfo(String cardType,String cardHolderName,String cardNum,String expMonth,String expYear,String cardCode){
        Select cardTypeElement=new Select(driver.findElement(creditCardTypeField));
        cardTypeElement.selectByVisibleText(cardType);

        driver.findElement(cardHolderNameField).sendKeys(cardHolderName);

        driver.findElement(cardNumField).sendKeys(cardNum);

        Select expMonthElement=new Select(driver.findElement(expireMonthField));
        expMonthElement.selectByVisibleText(expMonth);
        Select expYearElement=new Select(driver.findElement(expireYearField));
        expYearElement.selectByVisibleText(expYear);

        driver.findElement(cardCodeField).sendKeys(cardCode);

    }

    public void clickPaymentInfoContinueButton(){
        driver.findElement(paymentInfoContinueButton).click();
        try
        {
            Thread.sleep(1000);
        }
        catch(InterruptedException e)
        {
            // this part is executed when an exception (in this example InterruptedException) occurs
            System.out.println("not running");
        }
    }

    private By confirmBillMailField=new By.ByXPath("//*[@id=\"checkout-confirm-order-load\"]/div/div/div/div/div[1]/div[1]/ul/li[2]");
    private By confirmBillPhoneField=new By.ByXPath("//*[@id=\"checkout-confirm-order-load\"]/div/div/div/div/div[1]/div[1]/ul/li[3]");

    private By confirmShipMailField=new By.ByXPath("//*[@id=\"checkout-confirm-order-load\"]/div/div/div/div/div[2]/div[1]/ul/li[2]");
    private By confirmShipPhoneField=new By.ByXPath("//*[@id=\"checkout-confirm-order-load\"]/div/div/div/div/div[2]/div[1]/ul/li[3]");

    public Boolean verifyConfirmBillMail(String mail){
        return driver.findElement(confirmBillMailField).getText().contains(mail);
        //return trueMail;
    }

    public Boolean verifyConfirmBillPhone(String phone){
        return driver.findElement(confirmBillPhoneField).getText().contains(phone);
        //return truePhone;
    }

    public Boolean verifyConfirmShipMail(String mail){
        return driver.findElement(confirmShipMailField).getText().contains(mail);
        //return trueMail;
    }

    public Boolean verifyConfirmShipPhone(String phone){
        return driver.findElement(confirmShipPhoneField).getText().contains(phone);
        //return truePhone;
    }

    private By confirmButtonField=new By.ByXPath("//*[@id=\"confirm-order-buttons-container\"]/button");

    public void clickConfirmButton(){

        driver.findElement(confirmButtonField).click();
        try
        {
            Thread.sleep(1000);
        }
        catch(InterruptedException e)
        {
            // this part is executed when an exception (in this example InterruptedException) occurs
            System.out.println("not running");
        }
    }

    private By orderProcessedField =new By.ByXPath("/html/body/div[6]/div[3]/div/div/div/div[2]/div/div[1]/strong");

    public Boolean verifyOrderProcessedText(){
        return driver.findElement(orderProcessedField).isDisplayed();
    }

    private By orderDetailsLink=new By.ByLinkText("Click here for order details.");

    public OrderDetailsPage clickOrderDetailsLink(){
        driver.findElement(orderDetailsLink).click();
        return new OrderDetailsPage(driver);
    }


}






















