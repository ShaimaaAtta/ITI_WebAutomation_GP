package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderDetailsPage extends BasePage {

    public OrderDetailsPage(WebDriver driver){
        super(driver);
    }

    private By pageTileField=new By.ByXPath("/html/body/div[6]/div[3]/div/div/div/div[1]/h1");
    private By pdfInvoiceField=new By.ByLinkText("PDF Invoice");

    public Boolean verifyOrderDetailsUrl(String currentUrl) {
        return driver.getCurrentUrl().contains(currentUrl);
    }
    public Boolean verifyPageTitle(String title){

        return driver.findElement(pageTileField).getText().contains(title);
    }

    public void DownloadPDFInvoice() {
        driver.findElement(pdfInvoiceField).click();
        try
        {
            Thread.sleep(2000);
        }
        catch(InterruptedException e)
        {
            // this part is executed when an exception (in this example InterruptedException) occurs
            System.out.println("not running");
        }

    }


}
