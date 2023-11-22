package orderDetails;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.OrderDetailsPage;

public class OrderDetailsTests extends BaseTests {
    String pageTile="Order information";
    OrderDetailsPage orderDetailsPage;

    @Test
    public void testPageTitle(){
        orderDetailsPage=new OrderDetailsPage(driver);
        Assert.assertTrue(orderDetailsPage.verifyPageTitle(pageTile),"Not on correct page");
        Boolean trueUrl=orderDetailsPage.verifyOrderDetailsUrl("orderdetails");
        Assert.assertTrue(trueUrl,"Not directed to order details page");
        orderDetailsPage.DownloadPDFInvoice();

    }
}
