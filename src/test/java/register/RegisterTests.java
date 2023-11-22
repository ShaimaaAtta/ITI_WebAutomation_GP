package register;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.RegisterPage;

public class RegisterTests extends BaseTests {

    HomePage homePage ;
    RegisterPage registerPage ;

    LoginPage loginPage;


    @Test
    public void testSuccessfulRegister() {
        homePage = new HomePage(driver);
        registerPage = homePage.clickRegisterLink();
        registerPage.setFirstNameField(firstName);
        registerPage.setLastNameField(lastName);
        registerPage.setBirthdayField(5,"February","1992");
        registerPage.setEmailField(email);
        registerPage.uncheckNewsletterField();
        registerPage.setPasswordField(password);
        registerPage.setConfirmPasswordField(password);
        RegisterPage.RegisterResultPage registerResultPage = registerPage.clickRegisterButton();
        Assert.assertEquals(registerResultPage.checkRegisterMessage(), "Your registration completed", "Register Messages donot match");
        registerResultPage.clickContinueButton();
        loginPage=homePage.clickLoginLink();
        //driver.navigate().to("http://demo.nopcommerce.com" + "/login?returnUrl=%2F");
    }

}

