package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage extends BasePage {
    //private WebDriver driver;

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    private By firstNameField=new By.ById("FirstName");
    private By lastNameField=new By.ById("LastName");
    private By emailField=new By.ById("Email");
    private By passwordField=new By.ById("Password");
    private By confirmPasswordField=new By.ById("ConfirmPassword");
    private By registerButton=new By.ById("register-button");
    private By dayField=new By.ByName("DateOfBirthDay");
    private By monthField=new By.ByName("DateOfBirthMonth");
    private By yearField=new By.ByName("DateOfBirthYear");

    private By newsletterField=new By.ById("Newsletter");

    public void setFirstNameField(String firstName){
        driver.findElement(firstNameField).sendKeys(firstName);
    }

    public void setLastNameField(String lastName){
        driver.findElement(lastNameField).sendKeys(lastName);
    }

    public void setEmailField(String email){
        driver.findElement(emailField).sendKeys(email);
    }

    public void setPasswordField(String password){
        driver.findElement(passwordField).sendKeys(password);
    }

    public void setBirthdayField(int day,String month,String year){
        Select dayElement=new Select(driver.findElement(dayField));
        dayElement.selectByIndex(day);
        Select monthElement=new Select(driver.findElement(monthField));
        monthElement.selectByVisibleText(month);
        Select yearElement=new Select(driver.findElement(yearField));
        yearElement.selectByValue(year);
    }

    public void uncheckNewsletterField(){
        driver.findElement(newsletterField).click();
    }

    public void setConfirmPasswordField(String confirmPassword){
        driver.findElement(confirmPasswordField).sendKeys(confirmPassword);
    }

    public RegisterResultPage clickRegisterButton(){
        driver.findElement(registerButton).click();
        return new RegisterResultPage(driver);
    }


    public class RegisterResultPage extends BasePage{

        public RegisterResultPage(WebDriver driver) {
            super(driver);
        }

        private By continueButton=new By.ByXPath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[2]/a");
        private By registerMessageField=new By.ByClassName("result");

       ///sometimes it returns homepage ,,sometimes Logindirectly ??
        public HomePage clickContinueButton(){
            driver.findElement(continueButton).click();
            //return new LoginPage(driver);
            return new HomePage(driver);
        }

        public String checkRegisterMessage(){
            return  driver.findElement(registerMessageField).getText();
        }

    }

    public LoginPage clickLoginLink()
    {
        driver.findElement(By.linkText("Log in")).click();
        System.out.println("we are on login");
        return new LoginPage(driver);

    }




}
