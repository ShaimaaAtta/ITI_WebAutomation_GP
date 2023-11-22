package shoppingCart;

import base.BaseTests;
import login.LoginTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import register.RegisterTests;

public class ShoppingCartTests extends BaseTests {

    //HomePage homePage ;
    ShoppingCartPage shoppingCartPage ;
    CheckoutPage checkoutPage;
    ProductFromSearchPage macPage;

   /*
    @Test
    public void testShoppingCart(){

        shoppingCartPage=new ShoppingCartPage(driver);

        //Assert.assertEquals(shoppingCartPage.verifyShoppingCartTitle(),"Shopping cart","Title incorrect");
        Assert.assertTrue(shoppingCartPage.verifyProductNameInCart("Lollipop"),"Wrong product");

        //shoppingCartPage.checkAgree();
        //checkoutPage=shoppingCartPage.clickCheckoutButton();
    }

    */


    @Test
    public void testCompareProductPriceToTotal(){
        shoppingCartPage=new ShoppingCartPage(driver);
        shoppingCartPage.getProductPrice();
        shoppingCartPage.getTotalPrice();
        Assert.assertEquals(shoppingCartPage.getProductPrice(),shoppingCartPage.getTotalPrice(),"Price not equal");
    }

    @Test
    public void testPricesAfterChangeQty(){
        shoppingCartPage=new ShoppingCartPage(driver);
        String qty="2";
        shoppingCartPage.changeQuantity(qty);
        shoppingCartPage.clickUpdateCart();
        //String pdPrice=shoppingCartPage.getProductPrice();
        String subtotalStr=shoppingCartPage.getSubTotalPrice();
        String totalPrice=shoppingCartPage.getTotalPrice();
        //int pricePerItem=shoppingCartPage.toInteger(pdPrice);
        int newSubTotal=shoppingCartPage.toInteger(subtotalStr);
        int newTotal=shoppingCartPage.toInteger(totalPrice);
        int intQty=shoppingCartPage.toInteger(qty);
        Assert.assertEquals(newSubTotal,newTotal,"Prices after quantity modification not match");
        macPage=shoppingCartPage.searchItem("Mac");
    }





}
