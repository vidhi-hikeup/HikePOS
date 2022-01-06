package IntegrationsTS.BigCommerceTS;

import Config.Base.BaseTest;
import Config.allure.AllureListener;
import IntegrationsPO.BigCommercePO.BigCommerce;
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
 * @date 12 April 2021
 */
@Listeners({AllureListener.class})
public class BigCommerceTC extends BaseTest {

    public int flag = 1;

    public BigCommerceTC() {
    }

    public BigCommerceTC(WebDriver driver, int flag) {
        this.flag = flag;
        this.driver = driver;
    }




    /**
     * @author Vidhi Chapanera
     * @date 12 April 2021
     */
    @Test(groups = {"Core", "HIKE-POS", "Integrations", "BigCommerce","https://my.hikeup.com/"}, priority = 1, description = "HIKE-70 : Automate BigCommerce Integration")
    @Owner("Vidhi Chapanera")
    @Feature("Feature : Integrations,BigCommerce")
    @Severity(SeverityLevel.NORMAL)
    public void bigCommerceIntegrations_70() throws IOException {
        if (flag > 0) {
            logger().getTest().setName("HIKE-70 : Automate BigCommerce Integration");
            logger().assignCategory("Integrations,BigCommerce");
            logger().assignAuthor("Vidhi Chapanera");
        }

        BigCommerce bigCommerce = PageFactory.initElements(driver,BigCommerce.class);

        logger().log(LogStatus.INFO, "Execution start for HIKE-70");

        //Step-1 : create hike store for BigCommerce
        logger().log(LogStatus.PASS, "create hike store for BigCommerce", "create hike store for BigCommerce");

        //Step-2 : Login to existing store
        logger().log(LogStatus.PASS, "Login to existing store", "Login to existing store");

        //Step-3 : click on activate button on BigCommerce
        logger().log(LogStatus.PASS, "click on activate button on BigCommerce", "click on activate button on BigCommerce");


        /**
         * @date 13 April 2021
         */
        //Step-4 : mapping BigCommerce
        logger().log(LogStatus.PASS, "mapping BigCommerce ", "mapping BigCommerce ");


        /**
         * @date 14 April 2021
         */
        //Step-6 : create Product Hike to BigCommerce and verify in BigCommerce
        logger().log(LogStatus.PASS, "create Product Hike to BigCommerce and verify in BigCommerce", "create Product Hike to BigCommerce and verify in BigCommerce");

        //Step-7 : create Product BigCommerce to Hike and verify in Hike
        logger().log(LogStatus.PASS, "create Product BigCommerce to Hike and verify in Hike", "create Product BigCommerce to Hike and verify in Hike");

        /**
         * @date 15 April 2021
         */
        //Step-8 : create Customer Hike to BigCommerce and verify in BigCommerce
        logger().log(LogStatus.PASS, "create Customer Hike to BigCommerce and verify in BigCommerce", "create Customer Hike to BigCommerce and verify in BigCommerce");

        //Step-9 : create Customer BigCommerce to hike and verify in hike
        logger().log(LogStatus.PASS, "create Customer BigCommerce to hike and verify in hike", "create Customer BigCommerce to hike and verify in hike");

        /**
         * @date 16 April 2021
         */
        //Step-10 : create sale Hike to BigCommerce and verify in BigCommerce
        logger().log(LogStatus.PASS, "create sale Hike to BigCommerce and verify in BigCommerce", "create sale Hike to BigCommerce and verify in BigCommerce");

        //Step-11 : create sale BigCommerce to Hike and verify in Hike
        Assert.assertTrue(bigCommerce.automateBigCommerce(), "create sale BigCommerce to Hike and verify in Hike");
        logger().log(LogStatus.PASS, "create sale BigCommerce to Hike and verify in Hike", "create sale BigCommerce to Hike and verify in Hike");
    }

}
