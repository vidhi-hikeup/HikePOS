package IntegrationsTS.XeroTS;

import Config.Base.BaseTest;
import Config.allure.AllureListener;
import IntegrationsPO.QuickBooksPO.QuickBooks;
import IntegrationsPO.XeroPO.Xero;
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
 * @date 19 April 2021
 */
@Listeners({AllureListener.class})
public class XeroTC extends BaseTest {

    public int flag = 1;

    public XeroTC() {
    }

    public XeroTC(WebDriver driver, int flag) {
        this.flag = flag;
        this.driver = driver;
    }




    /**
     * @author Vidhi Chapanera
     * @date 19 April 2021
     */
    @Test(groups = {"Core", "HIKE-POS", "Integrations", "Xero","https://my.hikeup.com/"}, priority = 1, description = "HIKE-71 : Automate Xero Integration")
    @Owner("Vidhi Chapanera")
    @Feature("Feature : Integrations,Xero")
    @Severity(SeverityLevel.NORMAL)
    public void XeroIntegrations_71() throws IOException {
        if (flag > 0) {
            logger().getTest().setName("HIKE-71 : Automate Xero Integration");
            logger().assignCategory("Integrations,Xero");
            logger().assignAuthor("Vidhi Chapanera");
        }

        Xero xero = PageFactory.initElements(driver,Xero.class);

        logger().log(LogStatus.INFO, "Execution start for HIKE-71");

        //Step-1 : create hike store for Xero
        //Assert.assertTrue(xero.createHikeStoreForXero(), "create hike store for Xero");
        logger().log(LogStatus.PASS, "create hike store for Xero", "create hike store for Xero");

        //Step-2 : Login to Xero store
        //Assert.assertTrue(xero.loginXeroStore(), "Login to Xero store");
       // Assert.assertTrue(xero.loginXeroStoreAndCreateNewOrganization(), "Login to Xero store");
        logger().log(LogStatus.PASS, "Login to Xero store", "Login to Xero store");

        //Step-3 : click on activate button on Xero
        //Assert.assertTrue(xero.clickOnActivateButtonOnXero(), "click on activate button on Xero");
        logger().log(LogStatus.PASS, "click on activate button on Xero", "click on activate button on Xero");

        /**
         * @date 20 April 2021
         */
        //Step-4 : mapping Xero
        //Assert.assertTrue(xero.mappingXero(), "mapping Xero");
        logger().log(LogStatus.PASS, "mapping Xero", "mapping Xero");

        /**
         * @date 21 April 2021
         */
        //Step-5 : create Product hike to Xero and verify in Xero
        //Assert.assertTrue(xero.createProductHiketoxero(), "create Product hike to Xero and verify in Xero");
        logger().log(LogStatus.PASS, "create Product hike to Xero and verify in Xero", "create Product hike to Xero and verify in Xero");

        //Step-6 : create Product Xero to hike and verify in hike
        //Assert.assertTrue(xero.createProductXerotoHike(), "create Product Xero to hike and verify in hike");
        logger().log(LogStatus.PASS, "create Product Xero to hike and verify in hike", "create Product Xero to hike and verify in hike");

        //Step-5 : create Customer hike to Xero and verify in Xero
       //Assert.assertTrue(xero.createCustomersHiketoXero(), "create Customer hike to Xero and verify in Xero");
        logger().log(LogStatus.PASS, "create Customer hike to Xero and verify in Xero", "create Customer hike to Xero and verify in Xero");

        //Step-6 : create Customer Xero to hike and verify in hike
        //Assert.assertTrue(xero.createCustomersXerotoHike(), "create Customer Xero to hike and verify in hike");
        logger().log(LogStatus.PASS, "create Customer Xero to hike and verify in hike", "create Customer Xero to hike and verify in hike");

        //Step-5 : create Supplier hike to Xero and verify in Xero
        ///Assert.assertTrue(xero.createSuppliersHiketoXero(), "create Supplier hike to Xero and verify in Xero");
        logger().log(LogStatus.PASS, "create Supplier hike to Xero and verify in Xero", "create Supplier hike to Xero and verify in Xero");

        //Step-6 : create Supplier Xero to hike and verify in hike
        //Assert.assertTrue(xero.createSuppliersXerotoHike(), "create Supplier Xero to hike and verify in hike");
        logger().log(LogStatus.PASS, "create Supplier Xero to hike and verify in hike", "create Supplier Xero to hike and verify in hike");

        //Step-7 : create Purchase Order hike to Xero and verify in Xero
       //Assert.assertTrue(xero.createPurchaseOrderHiketoXero(), "create Purchase Order hike to Xero and verify in Xero");
        logger().log(LogStatus.PASS, "create Purchase Order hike to Xero and verify in Xero", "create Purchase Order hike to Xero and verify in Xero");

        //Step-8 : create Purchase Order Xero to hike and verify in hike
        //Assert.assertTrue(xero.createPurchaseOrderXerotoHike(), "create Purchase Order Xero to hike and verify in hike");
        logger().log(LogStatus.PASS, "create Purchase Order Xero to hike and verify in hike", "create Purchase Order Xero to hike and verify in hike");


        /**
         * @date 22 April 2021
         */
        //Step-9 : create Sale hike to Xero and verify in Xero
       // Assert.assertTrue(xero.createSaleHiketoXero(), "create Sale hike to Xero and verify in Xero");
        logger().log(LogStatus.PASS, "create Sale hike to Xero and verify in Xero", "create Sale hike to Xero and verify in Xero");

        //Step-10 : create Sale Xero to hike and verify in hike
       // Assert.assertTrue(xero.createSaleXerotoHike(), "create Sale Xero to hike and verify in hike");
        logger().log(LogStatus.PASS, "create Sale Xero to hike and verify in hike", "create Sale Xero to hike and verify in hike");

        //Step-11 : create Register summery hike to Xero and verify in Xero
        //Assert.assertTrue(xero.createRegisterSummeryHiketoXero(), "create Register summery hike to Xero and verify in Xero");
       Assert.assertTrue(xero.automateXero(), "create Register summery hike to Xero and verify in Xero");
        logger().log(LogStatus.PASS, "create Register summery hike to Xero and verify in Xero", "create Register summery hike to Xero and verify in Xero");

    }

}
