package login;

import base.BaseTests;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import register.RegisterTests;

public class LoginTests extends BaseTests {

    //HomePage homePage ;
    LoginPage loginPage ;

    MyHomePage myHomePage;
    //RegisterPage registerPage;
    MyAccount myAccount;
    CellphonesPage cellPage;
   /*
    @Test
    public void testFailedLogin(){
        homePage = new HomePage(driver);
        loginPage=homePage.clickLoginLink();
        loginPage.setEmail("atta-magic-92@hotmail.fr");
        loginPage.setPassword("Yassin@1106");
        loginPage.clickLoginButton();
        String actualMessage=loginPage.isLoginFail();
        Assert.assertEquals(actualMessage,"Login was unsuccessful. Please correct the errors and try again.\n" +
                "No customer account found");

    }

    */

    @Test
    public void testSuccessfulLogin() {

        loginPage=new LoginPage(driver);
        loginPage.setEmail(email);
        loginPage.setPassword(password);
        Boolean wlc=loginPage.verifyWelcomeToLogin("Welcome");
        Assert.assertTrue(wlc,"Not directed to login");
        myHomePage=loginPage.clickLoginButton();

    }



}
