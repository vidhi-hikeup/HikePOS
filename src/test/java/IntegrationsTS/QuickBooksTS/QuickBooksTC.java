package IntegrationsTS.QuickBooksTS;

import Config.Base.BaseTest;
import Config.allure.AllureListener;
import IntegrationsPO.QuickBooksPO.QuickBooks;
import IntegrationsPO.ShopifyPO.Shopify;
import com.relevantcodes.extentreports.LogStatus;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * @author Vidhi Chapanera
 * @date 01 April 2021
 */
@Listeners({AllureListener.class})
public class QuickBooksTC extends BaseTest {

    public int flag = 1;

    public QuickBooksTC() {
    }

    public QuickBooksTC(WebDriver driver, int flag) {
        this.flag = flag;
        this.driver = driver;
    }




    /**
     * @author Vidhi Chapanera
     * @date 01 April 2021
     */
    @Test(groups = {"Core", "HIKE-POS", "Integrations", "QuickBooks","https://my.hikeup.com/"}, priority = 1, description = "HIKE-69 : Automate QuickBooks Integration")
    @Owner("Vidhi Chapanera")
    @Feature("Feature : Integrations,QuickBooks")
    @Severity(SeverityLevel.NORMAL)
    public void quickBooksIntegrations_69() throws IOException {
        if (flag > 0) {
            logger().getTest().setName("HIKE-69 : Automate QuickBooks Integration");
            logger().assignCategory("Integrations,QuickBooks");
            logger().assignAuthor("Vidhi Chapanera");
        }

        QuickBooks quickBooks = PageFactory.initElements(driver,QuickBooks.class);

        logger().log(LogStatus.INFO, "Execution start for HIKE-69");

        //Step-1 : create hike store for QuickBooks
       // Assert.assertTrue(quickBooks.createHikeStoreForQuickBooks(), "create hike store for QuickBooks");
        logger().log(LogStatus.PASS, "create hike store for QuickBooks", "create hike store for QuickBooks");

        //Step-2 : Login to QBO store
        //Assert.assertTrue(quickBooks.loginQBOStore(), "Login to QBO store");
        logger().log(LogStatus.PASS, "Login to QBO store", "Login to QBO store");

        //Step-3 : click on activate button on QuickBooks
        //Assert.assertTrue(quickBooks.clickOnActivateButtonOnQuickBooks(), "click on activate button on QuickBooks");
        logger().log(LogStatus.PASS, "click on activate button on QuickBooks", "click on activate button on QuickBooks");

        /**
         * @date 02 April 2021
         */
        //Step-4 : mapping QuickBooks
        //Assert.assertTrue(quickBooks.mappingQuickBooks(), "mapping QuickBooks ");
        logger().log(LogStatus.PASS, "mapping QuickBooks ", "mapping QuickBooks ");

        //Step-5 : create Customers Hike to quickbooks and verify in quickbooks
       // Assert.assertTrue(quickBooks.createCustomersHiketoQuickBooks("vidhi"), "create Customers Hike to quickbooks and verify in quickbooks");
        logger().log(LogStatus.PASS, "create Customers Hike to quickbooks and verify in quickbooks", "create Customers Hike to quickbooks and verify in quickbooks");


        /**
         * @date 05 April 2021
         */
        //Step-6 : create Customers quickbooks to hike and verify in hike
        //Assert.assertTrue(quickBooks.createCustomersQuickBookstoHike("BG"), "create Customers quickbooks to hike and verify in hike");
        logger().log(LogStatus.PASS, "create Customers quickbooks to hike and verify in hike", "create Customers quickbooks to hike and verify in hike");

        //Step-7 : create Product hike to Quickbooks and verify in quickbooks
        //Assert.assertTrue(quickBooks.createProductHiketoQuickBooks("product-001"), "create Product hike to Quickbooks and verify in quickbooks");
        logger().log(LogStatus.PASS, "create Product hike to Quickbooks and verify in quickbooks", "create Product hike to Quickbooks and verify in quickbooks");

        //Step-8 : create Product Quickbooks to hike and verify in hike
        //Assert.assertTrue(quickBooks.createProductQuickBookstoHike("product-002"), "create Product Quickbooks to hike and verify in hike");
        logger().log(LogStatus.PASS, "create Product Quickbooks to hike and verify in hike", "create Product Quickbooks to hike and verify in hike");

        //Step-9 : create Sale Hike to Quickbooks and verify in Quickbooks
        //Assert.assertTrue(quickBooks.createSaleHiketoQuickbooks("product-001"), "create Sale Hike to Quickbooks and verify in Quickbooks");
        logger().log(LogStatus.PASS, "create Sale Hike to Quickbooks and verify in Quickbooks", "create Sale Hike to Quickbooks and verify in Quickbooks");

        /**
         * @date 06 April 2021
         */
        //Step-10 : create Sale Quickbooks to Hike and verify in Hike
        //Assert.assertTrue(quickBooks.createSaleQuickbookstoHike("product-001"), "create Sale Quickbooks to Hike and verify in Hike");
        logger().log(LogStatus.PASS, "create Sale Quickbooks to Hike and verify in Hike", "create Sale Quickbooks to Hike and verify in Hike");

        //Step-11 : create Suppliers Hike to Quickbooks and verify in Quickbooks
        //Assert.assertTrue(quickBooks.createSuppliersHiketoQuickbooks("BG Suppliers"), "create Suppliers Hike to Quickbooks and verify in Quickbooks");
        logger().log(LogStatus.PASS, "create Suppliers Hike to Quickbooks and verify in Quickbooks", "create Suppliers Hike to Quickbooks and verify in Quickbooks");

        //Step-12 : create Suppliers Quickbooks to Hike and verify in Hike
        //Assert.assertTrue(quickBooks.createSuppliersQuickbookstoHike("Test Suppliers"), "create Suppliers Quickbooks to Hike and verify in Hike");
        logger().log(LogStatus.PASS, "create Suppliers Quickbooks to Hike and verify in Hike", "create Suppliers Quickbooks to Hike and verify in Hike");

        /**
         * @date 07 April 2021
         */
        //Step-13 : create Purchase Order Hike to Quickbooks and verify in Quickbooks
        //Assert.assertTrue(quickBooks.createPurchaseOrderHiketoQuickbooks("product-001"), "create Purchase Order Hike to Quickbooks and verify in Quickbooks");
        logger().log(LogStatus.PASS, "create Purchase Order Hike to Quickbooks and verify in Quickbooks", "create Purchase Order Hike to Quickbooks and verify in Quickbooks");

        //Step-14 : create Purchase Order Quickbooks to Hike and verify in Hike
       // Assert.assertTrue(quickBooks.createPurchaseOrderHiketoQuickbooks("product-001"), "create Purchase Order Quickbooks to Hike and verify in Hike");
        logger().log(LogStatus.PASS, "create Purchase Order Quickbooks to Hike and verify in Hike", "create Purchase Order Quickbooks to Hike and verify in Hike");

        //Step-15 create Register summery Hike to Quickbooks and verify in Quickbooks
        //Assert.assertTrue(quickBooks.createRegisterSummeryHiketoQuickbooks(), "Hike to Quickbooks and verify in Quickbooks");
        Assert.assertTrue(quickBooks.automateQuickbooks(), "Hike to Quickbooks and verify in Quickbooks");
        logger().log(LogStatus.PASS, "Hike to Quickbooks and verify in Quickbooks", "Hike to Quickbooks and verify in Quickbooks");
    }

}
