package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CellphonesPage extends BasePage{


    public CellphonesPage(WebDriver driver){
        super(driver);
    }
    private By cellphoneHeader=new By.ByTagName("h1");
    //private By cellphoneHeader=new By.ByXPath("/html/body/div[6]/div[3]/div/div[1]/ul/li[3]/strong");

    private By orderByList=new By.ById("products-orderby");

    private By pricesClass = new By.ByClassName("prices");
    private By itemGridClass=new By.ByClassName("item-grid");

    private By itemBoxClass=new By.ByClassName("item-box");

    private By cellLink=new By.ByXPath("/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[2]/div[2]/div/div/div[1]/div/div[2]/h2/a");

    public String verifyCellphonesPage(){
        String header=driver.findElement(cellphoneHeader).getText();
        System.out.println(header);
        return header;
    }

    public void setOrderByList(String option){
        Select HighToLow=new Select(driver.findElement(orderByList));
        HighToLow.selectByVisibleText(option);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public void selectHighPrice(){
        List<WebElement> pricesListElements=driver.findElements(pricesClass);
        //System.out.println(pricesListElements);
        List<String> strings = new ArrayList<String>();
        for (WebElement e:pricesListElements
             ) {
            strings.add(e.getText());
        }
        System.out.println(strings);


    }

    public SelectedItemPage selectFirstItem(){
        WebElement firstItemElement=driver.findElements(itemBoxClass).get(0);
        //System.out.println(firstItemElement.getText());
        firstItemElement.click();
        return new SelectedItemPage(driver);

    }

    public void clickSelectedItemLink(){
        System.out.println(driver.findElement(cellLink).getText());
        System.out.println(driver.findElement(cellLink).getAttribute("href"));
        //driver.findElement(cellLink).click();
        WebElement build= driver.findElement(cellLink);
        build.click();
       // return new SelectedItemPage(driver)
    }



}
