package login;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class MyAccountTests extends BaseTests {

    HomePage homePage ;
    LoginPage loginPage ;

    MyHomePage myHomePage;
    MyAccount myAccount;
    CellphonesPage cellPage;

    @Test
    public void testMyAccountInfo(){

        myAccount=new MyAccount(driver);

        Assert.assertTrue(myAccount.verifyPageTitle("account"),"On my Account");
        Assert.assertEquals(myAccount.checkEmail(),email,"Email not match");
        Assert.assertEquals(myAccount.checkFirstName(),firstName,"FirstNames do not match");
        Assert.assertEquals(myAccount.checkLastName(),lastName,"LastNames do not match");
        cellPage=myAccount.hoverOverElectronicsToCellphones();

    }


}
