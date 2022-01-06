package IntegrationsTS.WooCommerceTS;

import Config.Base.BaseTest;
import Config.allure.AllureListener;
import IntegrationsPO.ShopifyPO.Shopify;
import IntegrationsPO.WooCommercePO.WooCommerce;
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
 * @date 12 May 2021
 */
@Listeners({AllureListener.class})
public class WooCommerceTC extends BaseTest {

    public int flag = 1;

    public WooCommerceTC() {
    }

    public WooCommerceTC(WebDriver driver, int flag) {
        this.flag = flag;
        this.driver = driver;
    }

    /**
     * @author Vidhi Chapanera
     * @date 12 May 2021
     */
    @Test(groups = {"Core", "HIKE-POS", "Integrations", "WooCommerce","https://my.hikeup.com/"}, priority = 1, description = "HIKE-73 : Automate WooCommerce Integration")
    @Owner("Vidhi Chapanera")
    @Feature("Feature : Integrations,WooCommerce")
    @Severity(SeverityLevel.NORMAL)
    public void wooCommerceIntegrations_73() throws IOException {
        if (flag > 0) {
            logger().getTest().setName("HIKE-73 : Automate WooCommerce Integration");
            logger().assignCategory("Integrations,WooCommerce");
            logger().assignAuthor("Vidhi Chapanera");
        }

        Shopify shopify = PageFactory.initElements(driver,Shopify.class);
        WooCommerce wooCommerce = PageFactory.initElements(driver,WooCommerce.class);

        logger().log(LogStatus.INFO, "Execution start for HIKE-73");

        //Step-1 : create hike store for WooCommerce
        Assert.assertTrue(wooCommerce.createHikeStoreForWooCommerce(), "create hike store for WooCommerce");
        logger().log(LogStatus.PASS, "create hike store for WooCommerce", "create hike store for WooCommerce");

        //Step-2 : click on activate button on WooCommerce
        Assert.assertTrue(wooCommerce.clickOnActivateButtonOnWooCommerce(), "click on activate button on WooCommerce");
        logger().log(LogStatus.PASS, "click on activate button on WooCommerce", "click on activate button on WooCommerce");

        //Step-3 : login to WooCommerce store
        Assert.assertTrue(wooCommerce.loginToWooCommerceStore(), "login to WooCommerce store");
        logger().log(LogStatus.PASS, "login to WooCommerce store", "login to WooCommerce store");

        //Step-4 : Generate API key
        Assert.assertTrue(wooCommerce.generateAPIKeys(), " Generate API key");
        logger().log(LogStatus.PASS, " Generate API key", " Generate API key");

        //Step-5 : connect your WooCommerce store to hikeup
        Assert.assertTrue(wooCommerce.connectYourStoretoHike(), "connect your WooCommerce store to hikeup");
        logger().log(LogStatus.PASS, "connect your WooCommerce store to hikeup", "connect your WooCommerce store to hikeup");

    }

}
