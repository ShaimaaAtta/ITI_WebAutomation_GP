package shoppingCart;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductFromSearchPage;
import pages.ShoppingCartPage;

public class MacTests extends BaseTests {

    ShoppingCartPage shoppingCartPage ;

    ProductFromSearchPage macPage;

    @Test
    public void testMacPageTile(){
        macPage=new ProductFromSearchPage(driver);
        Assert.assertTrue(macPage.verifyProductNameFromSearch("Mac"),"not on Mac page");

    }

    @Test
    public void testProductAddedNotification(){
        macPage=new ProductFromSearchPage(driver);
        macPage.clickAddToCart();
        Assert.assertTrue(macPage.findNotification("The product has been added"),"item not added");
        shoppingCartPage=macPage.clickShoppingCart();
    }





}
