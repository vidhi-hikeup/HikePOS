package StoreSetupTS.SubscriptionPlanTS;

import CommonPO.CenterlizePO;
import Config.Base.BaseTest;
import Config.allure.AllureListener;
import CreateStoreTS.CreateStoreTC;
import StoreSetupPO.MyAccountPO.MyAccount;
import StoreSetupPO.StoreSetup;
import StoreSetupPO.SubscriptionPlanPO.SubscriptionPlan;
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
 * @date 05 January 2022
 */

@Listeners({AllureListener.class})
public class SubscriptionPlanTC extends BaseTest {

    public int flag = 1;

    public SubscriptionPlanTC() {
    }

    public SubscriptionPlanTC(WebDriver driver, int flag) {
        this.flag = flag;
        this.driver = driver;
    }

    /**
     * @author Vidhi Chapanera
     * @since 05 January 2022
     */
    @Test(
            groups = {"Core",
                      "HIKE-POS",
                      "Store Setup",
                      "https://my.hikeup.com/",
                      "https://asy.io:82/"},
            priority = 1,
            description = "HIKE-111 : select plan for subscription monthly and yearly on asy.io.82"
    )
    @Owner("vidhi Chapanera")
    @Feature("Feature : Store Setup")
    @Severity(SeverityLevel.NORMAL)
    public void SubscriptionPlanTest_111() throws IOException {

        if (flag > 0) {
            logger().getTest().setName("HIKE-111 : select plan for subscription monthly and yearly on asy.io.82");
            logger().assignCategory("Store Setup");
            logger().assignAuthor("Vidhi Chapanera");
        }

        SubscriptionPlan subscriptionPlan = PageFactory.initElements(driver, SubscriptionPlan.class);
        StoreSetup storeSetup =  PageFactory.initElements(driver, StoreSetup.class);
        MyAccount myAccount =  PageFactory.initElements(driver, MyAccount.class);
        CenterlizePO centerlizePO =  PageFactory.initElements(driver, CenterlizePO.class);

        //Step-1 : switch to https://asy.io:82/ server
        Assert.assertTrue(subscriptionPlan.switchServer(), "switch to https://asy.io:82/ server");
        logger().log(LogStatus.PASS, "switch to https://asy.io:82/ server", "switched to https://asy.io:82/ server");

        //Step-2 : Create Store on asy.io
        new CreateStoreTC(driver,0).b_verifyCreateStoreFunctionalitydynamic_02();
        logger().log(LogStatus.PASS, "Create Store on asy.io", "Create Store on asy.io");

        //Step-3 : click on Store setup button
        Assert.assertTrue(storeSetup.clickOnStoreSetupButton(), "click on Store setup button");
        logger().log(LogStatus.PASS, "click on Store setup button", "click on Store setup button");

        //Step-4 : click on My Account button
        Assert.assertTrue(centerlizePO.clickOnButton(myAccount.getMyAccountButton()), "click on My Account button");
        logger().log(LogStatus.PASS, "click on Store setup button", "click on My Account button");

        //Step-5 : Select monthly Subscription
        Assert.assertTrue(subscriptionPlan.monthlySubscription(), "Select monthly Subscription");
        logger().log(LogStatus.PASS, "Select monthly Subscription", "Select monthly Subscription");
    }
}
