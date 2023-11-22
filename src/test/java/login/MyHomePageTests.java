package login;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MyAccount;
import pages.MyHomePage;

public class MyHomePageTests extends BaseTests {

    LoginPage loginPage ;

    MyHomePage myHomePage;
    //RegisterPage registerPage;
    MyAccount myAccount;

    @Test
    public void checkMyHome(){

        myHomePage=new MyHomePage(driver);
        System.out.println("this is my Homepage");
        myAccount =myHomePage.verifyMyAccount();

    }
}
