package shoppingCart;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CheckoutPage;
import pages.ShoppingCartPage;

public class ModifiedShoppingCartTests extends BaseTests {

    ShoppingCartPage shoppingCartPage2;
    CheckoutPage checkoutPage;

    @Test
    public void testNewProductAppeared(){
        shoppingCartPage2=new ShoppingCartPage(driver);
        shoppingCartPage2.verifyMacProductAdded("Mac");
        Assert.assertTrue(shoppingCartPage2.verifyMacProductAdded("Mac"),"Cart does not have Mac product");

    }



   /*
    @Test
    public void testTotalPriceChanged(){
        shoppingCartPage2=new ShoppingCartPage(driver);
        //String pdPrice=shoppingCartPage2.getProductPriceAgainAfterAdd();
        String totalPrice=shoppingCartPage2.getTotalPrice();
        String qty="2";
        //int pricePerItem=shoppingCartPage2.toInteger(pdPrice);
        int newTotal=shoppingCartPage2.toInteger(totalPrice);
        int intQty=shoppingCartPage2.toInteger(qty);
        //Boolean prices=((pricePerItem*intQty)==newTotal);
        Boolean newT= (newTotal<=490);
        Assert.assertFalse(newT,"Prices not changed after Mac product added");
    }

    */

    @Test
    public void testRemoveMacProduct(){
        shoppingCartPage2=new ShoppingCartPage(driver);
        String oldTotal=shoppingCartPage2.getTotalPrice();
        shoppingCartPage2.removeMacProductFromCart();
        String newTotal=shoppingCartPage2.getTotalPrice();
        int totalBeforeRemove=shoppingCartPage2.toInteger(oldTotal);
        int totalAfterRemove=shoppingCartPage2.toInteger(newTotal);
        Boolean compareTotal=(totalBeforeRemove==totalAfterRemove);
        Assert.assertFalse((compareTotal),"Remove not affecting prices");
        shoppingCartPage2.checkAgree();
        checkoutPage=shoppingCartPage2.clickCheckoutButton();

    }






}
