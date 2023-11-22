package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;

public class LoginPage extends BasePage{

    //private WebDriver driver;
    //private By emailField=new By.ById("Email");
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private By welcomeField=new By.ByXPath("/html/body/div[6]/div[3]/div/div/div/div[1]/h1");
    private By emailField=new By.ByXPath("//*[@id=\"Email\"]");
    private By passwordField=new By.ById("Password");
    private By loginButton=new By.ByXPath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[2]/form/div[3]/button");
    final String loginFailMessage = "Login was unsuccessful";
   // private By loginFail = new By.ByClassName("message-error validation-summary-errors");
    private By loginFail=new By.ByXPath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[2]/form/div[1]");

    private By myAccount=new By.ByLinkText("My account");
    public Boolean verifyWelcomeToLogin(String welcomeLogin){
        return driver.findElement(welcomeField).getText().contains(welcomeLogin);
    }
    public void setEmail(String email){
        driver.findElement(emailField).sendKeys(email);
    }

    public void setPassword(String password){
        driver.findElement(passwordField).sendKeys(password);
    }

    public MyHomePage clickLoginButton(){
        driver.findElement(loginButton).click();
        return new MyHomePage(driver);
    }

    public MyAccount directToMyAccount(){
        driver.findElement(loginButton).click();
        return new MyAccount(driver);
    }


    public MyAccount clickMyAccountLink(){
        driver.findElement(myAccount).click();
        return new MyAccount(driver);
    }

    public String isLoginFail(){
        return driver.findElement(loginFail).getText();

    }

}
