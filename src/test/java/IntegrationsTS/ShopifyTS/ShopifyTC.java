package IntegrationsTS.ShopifyTS;

import Config.Base.BaseTest;
import Config.allure.AllureListener;
import IntegrationsPO.ShopifyPO.Shopify;
import LoginTS.LoginTC;
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
 * @date 19 March 2021
 */
@Listeners({AllureListener.class})
public class ShopifyTC extends BaseTest {

    public int flag = 1;

    public ShopifyTC() {
    }

    public ShopifyTC(WebDriver driver, int flag) {
        this.flag = flag;
        this.driver = driver;
    }

    /**
     * @author Vidhi Chapanera
     * @date 19 March 2021
     */
    @Test(enabled = false,groups = {"Core", "HIKE-POS", "Integrations", "Shopify","https://my.hikeup.com/"}, priority = 1, description = "HIKE-68 : Automate Shopify Integration")
    @Owner("Vidhi Chapanera")
    @Feature("Feature : Integrations,Shopify")
    @Severity(SeverityLevel.NORMAL)
    public void shoptfyIntegrations_68() throws IOException {
        if (flag > 0) {
            logger().getTest().setName("HIKE-68 : Automate Shopify Integration");
            logger().assignCategory("Integrations,Shopify");
            logger().assignAuthor("Vidhi Chapanera");
        }

        Shopify shopify = PageFactory.initElements(driver,Shopify.class);

        logger().log(LogStatus.INFO, "Execution start for HIKE-68");

        //Step-1 : create hike store for shopify
        //Assert.assertTrue(shopify.createHikeStoreForShopify(), "create hike store for shopify");
        logger().log(LogStatus.PASS, "create hike store for shopify", "create hike store for shopify");

        //Step-2 : click on activate button on shopify
        Assert.assertTrue(shopify.clickOnActivateButtonOnShopify(), "click on activate button on shopify");
        logger().log(LogStatus.PASS, "click on activate button on shopify", "click on activate button on shopify");

        //Step-3 : create Shopify store
        Assert.assertTrue(shopify.createShopifyStore(), "create Shopify store");
        logger().log(LogStatus.PASS, "create Shopify store", "create Shopify store");

        //Step-4 : connect your shopify store to hikeup
        Assert.assertTrue(shopify.connectYourStoretoHike(), "connect your shopify store to hikeup");
        logger().log(LogStatus.PASS, "connect your shopify store to hikeup", "connect your shopify store to hikeup");

        /**
         * @date 22 March 2021
         */
        //Step-5 : mapping shopify
        Assert.assertTrue(shopify.mappingShopify(), "mapping shopify ");
        logger().log(LogStatus.PASS, "mapping shopify ", "mapping shopify ");

        //Step-6 : create Product Hike to shopify and verify in Shopify
        Assert.assertTrue(shopify.createProductHiketoShopify(), "create Product Hike to shopify and verify in Shopify");
        logger().log(LogStatus.PASS, "create Product Hike to shopify and verify in Shopify", "create Product Hike to shopify and verify in Shopify");

        //Step-7 : create Product shopify to hike and verify in hike
        Assert.assertTrue(shopify.createProductShopifytoHike(), "create Product Hike to shopify and verify in Shopify");
        logger().log(LogStatus.PASS, "create Product Hike to shopify and verify in Shopify", "create Product Hike to shopify and verify in Shopify");

        //Step-8 : create Customers Hike to shopify and verify in Shopify
        Assert.assertTrue(shopify.createCustomersHiketoShopify(), "create Customers Hike to shopify and verify in Shopify");
        logger().log(LogStatus.PASS, "create Customers Hike to shopify and verify in Shopify", "create Customers Hike to shopify and verify in Shopify");

        //Step-9 : create Customers shopify to hike and verify in hike
        Assert.assertTrue(shopify.createCustomersShopifytoHike(), "create Customers shopify to hike and verify in hike and verify in Hike");
        logger().log(LogStatus.PASS, "create Customers shopify to hike and verify in hike", "create Customers shopify to hike and verify in hike");

        /**
         * @date 24 March 2021
         */
        //Step-10 : create Sale Shopify to Hike and verify in Hike
        Assert.assertTrue(shopify.createSaleShopifytoHike(), "create Sale Shopify to Hike and verify in Hike");
        logger().log(LogStatus.PASS, "create Sale Shopify to Hike and verify in Hike", "create Sale Shopify to Hike and verify in Hike");

        //Step-11 : create Sale Hike to shopify and verify in Shopify
        Assert.assertTrue(shopify.createSaleHiketoShopify(), "create Sale Hike to shopify and verify in Shopify");
        logger().log(LogStatus.PASS, "create Sale Hike to shopify and verify in Shopify", "create Sale Hike to shopify and verify in Shopify");

    }


    /**
     * @author Vidhi Chapanera
     * @date 30 March 2021
     */
    @Test(groups = {"Core", "HIKE-POS", "Integrations", "Shopify","https://my.hikeup.com/"}, priority = 1, description = "HIKE-68 : Automate Shopify Integration")
    @Owner("Vidhi Chapanera")
    @Feature("Feature : Integrations,Shopify")
    @Severity(SeverityLevel.NORMAL)
    public void shoptfyIntegrations01_69() throws IOException {
        if (flag > 0) {
            logger().getTest().setName("HIKE-68 : Automate Shopify Integration");
            logger().assignCategory("Integrations,Shopify");
            logger().assignAuthor("Vidhi Chapanera");
        }

        Shopify shopify = PageFactory.initElements(driver,Shopify.class);

        //pre-condition:
        //new LoginTC(driver,0).a_verifyLoginFunctionality_03();

        logger().log(LogStatus.INFO, "Execution start for HIKE-68");

        //Step-1 : create hike store for shopify
        logger().log(LogStatus.PASS, "create hike store for shopify", "create hike store for shopify");

        //Step-2 : click on activate button on shopify
        logger().log(LogStatus.PASS, "click on activate button on shopify", "click on activate button on shopify");

        //Step-3 : Login to existing store
        logger().log(LogStatus.PASS, "Login to existing store", "Login to existing store");

        //Step-4 : mapping shopify
        logger().log(LogStatus.PASS, "mapping shopify ", "mapping shopify");

        //Step-5 : create Product Hike to shopify and verify in Shopify
        logger().log(LogStatus.PASS, "create Product Hike to shopify and verify in Shopify", "create Product Hike to shopify and verify in Shopify");

        //Step-6 : create Product shopify to hike and verify in hike
        logger().log(LogStatus.PASS, "create Product Hike to shopify and verify in Shopify", "create Product Hike to shopify and verify in Shopify");

        //Step-7 : create Customers Hike to shopify and verify in Shopify
        logger().log(LogStatus.PASS, "create Customers Hike to shopify and verify in Shopify", "create Customers Hike to shopify and verify in Shopify");

        //Step-8 : create Customers shopify to hike and verify in hike
        logger().log(LogStatus.PASS, "create Customers shopify to hike and verify in hike", "create Customers shopify to hike and verify in hike");

        //Step-9 : create Sale Hike to shopify and verify in Shopify
        logger().log(LogStatus.PASS, "create Sale Hike to shopify and verify in Shopify", "create Sale Hike to shopify and verify in Shopify");

        //Step-10 : create Sale Shopify to Hike and verify in Hike
        Assert.assertTrue(shopify.automateShopify(), "create Sale Shopify to Hike and verify in Hike");
        logger().log(LogStatus.PASS, "create Sale Shopify to Hike and verify in Hike", "create Sale Shopify to Hike and verify in Hike");



    }

}
