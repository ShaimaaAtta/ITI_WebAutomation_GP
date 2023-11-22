package checkout;

import base.BaseTests;
import org.bouncycastle.crypto.agreement.srp.SRP6Client;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CheckoutPage;
import pages.OrderDetailsPage;
import pages.ShoppingCartPage;

public class CheckoutTests extends BaseTests {

    CheckoutPage checkoutPage;
    OrderDetailsPage orderDetailsPage;

    String pageTile="Checkout";
    String country="Egypt";
    String city="Alex";
    String address1="Miami";
    String zipcode="92500";
    String cardType="Amex";
    String cardHolderName="shaimaa";
    String cardNum="374245455400126";
    @Test
    public void testCheckoutProcess(){

        checkoutPage=new CheckoutPage(driver);
        checkoutPage.setCountryField(country);
        checkoutPage.setCityField(city);
        checkoutPage.setAddress1Field(address1);
        checkoutPage.setZipcodeField(zipcode);
        checkoutPage.setPhoneField(phone);
        //checkoutPage.verifyPageTitle(pageTile);
        Assert.assertTrue(checkoutPage.verifyPageTitle(pageTile),"Not on correct page");

    }

    @Test
    public void testMailsOfBillAndShipAddresses(){
        checkoutPage=new CheckoutPage(driver);
        checkoutPage.clickBillContinueButton();
        checkoutPage.clickShipContinueButton();
        checkoutPage.selectPayByCredit();
        checkoutPage.fillCreditCardInfo(cardType,cardHolderName,cardNum,"05","2026","123");
        checkoutPage.clickPaymentInfoContinueButton();
        Assert.assertTrue(checkoutPage.verifyConfirmBillMail(email));
        Assert.assertTrue(checkoutPage.verifyConfirmShipMail(email));

    }

    @Test
    public void testPhoneOfBillAndShipAddresses(){
        checkoutPage=new CheckoutPage(driver);
        Assert.assertTrue(checkoutPage.verifyConfirmBillPhone(phone));
        Assert.assertTrue(checkoutPage.verifyConfirmShipPhone(phone));
    }

    @Test
    public void testSuccessfulOrderText(){
        checkoutPage=new CheckoutPage(driver);
        checkoutPage.clickConfirmButton();
        Assert.assertTrue(checkoutPage.verifyOrderProcessedText());
        orderDetailsPage=checkoutPage.clickOrderDetailsLink();
    }





}
