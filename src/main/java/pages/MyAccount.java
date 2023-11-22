package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MyAccount extends BasePage{
    public MyAccount(WebDriver driver) {
        super(driver);
    }

    //private By pageTitleField=new By.ByXPath("/html/body/div[6]/div[3]/div/div[2]/div/div[1]/h1");

    private By pageTitleField=new By.ByTagName("h1");


    //private By myEmail=new By.ByCssSelector("#Email");
    private By myEmail=new By.ById("Email");
    private By firstNameField=new By.ByXPath("//*[@id=\"FirstName\"]");

    private By lastNameField=new By.ById("LastName");

    public Boolean verifyPageTitle(String title){
        System.out.println("the Title i see "+driver.findElement(pageTitleField).getText());
        return driver.findElement(pageTitleField).getText().contains(title);
    }

    public String checkEmail(){
        //get Attribute value:value of what user entered, get text:text of website itself
        return driver.findElement(myEmail).getAttribute("value");

    }

    public String checkFirstName(){

        return driver.findElement(firstNameField).getAttribute("value");
    }
    public String checkLastName(){

        return driver.findElement(lastNameField).getAttribute("value");
    }

    public CellphonesPage hoverOverElectronicsToCellphones() {
        WebElement electronicsField = driver.findElement(By.linkText("Electronics"));
        Actions actions = new Actions(driver);
        actions.moveToElement(electronicsField).build().perform();
        WebElement cellphones = driver.findElement(By.xpath("/html/body/div[6]/div[2]/ul[1]/li[2]/ul/li[2]/a"));
        actions.moveToElement(cellphones).click().build().perform();
        return new CellphonesPage(driver);

    }

}
