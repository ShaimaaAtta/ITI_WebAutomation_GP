package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ElectronicsPage {

    private WebDriver driver;

    public ElectronicsPage(WebDriver driver) {
        this.driver = driver;
    }

    private By cellphonesField=new By.ByXPath("/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[1]/div/div[2]/div/h2/a");

    public CellphonesPage clickCellphonesLink(){
        driver.findElement(cellphonesField).click();
        return new CellphonesPage(driver);
    }


}
