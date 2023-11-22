package cellphones;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class CellphonesTests extends BaseTests {

    //HomePage homePage ;
    CellphonesPage cellPage;

    ShoppingCartPage shoppingCartPage;

    @Test

    public void testHover(){
        cellPage=new CellphonesPage(driver);
        String cellText=cellPage.verifyCellphonesPage();
        Assert.assertEquals(cellText,"Cell phones","header not match");
        SelectedItemPage selectedItem=cellPage.selectFirstItem();
        selectedItem.clickAddToCart();
        //selectedItem.alertDisplay();
        //selectedItem.checkAlert();
        shoppingCartPage=selectedItem.clickShoppingCart();

    }

}
