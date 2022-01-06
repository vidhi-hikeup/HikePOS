package StoreSetupTS.MyAccountTS;

import CommonPO.CenterlizePO;
import Config.Base.BaseTest;
import Config.allure.AllureListener;
import LoginTS.LoginTC;
import StoreSetupPO.MyAccountPO.MyAccount;
import StoreSetupPO.StoreSetup;
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
 * @date 23 December 2021
 */

@Listeners({AllureListener.class})
public class MyAccountTC extends BaseTest {

    public int flag = 1;

    public MyAccountTC() {
    }

    public MyAccountTC(WebDriver driver, int flag) {
        this.flag = flag;
        this.driver = driver;
    }

    /**
     * @author Vidhi Chapanera
     * @since 23 December 2021
     */
    @Test(
            groups = {"Core",
                      "HIKE-POS",
                      "Store Setup",
                      "https://my.hikeup.com/"},
            priority = 1,
            description = "HIKE-103 : Purge data for gift card and verify data is deleted"
    )
    @Owner("Vidhi Chapanera")
    @Feature("Feature : Store Setup")
    @Severity(SeverityLevel.NORMAL)
    public void purgeDataForGiftCardAndVerify_103() throws IOException {

        if (flag > 0) {
            logger().getTest().setName("HIKE-103 : Purge data for gift card and verify data is deleted");
            logger().assignCategory("Store Setup");
            logger().assignAuthor("Vidhi Chapanera");
        }

        CenterlizePO centerlizePO = PageFactory.initElements(driver, CenterlizePO.class);
        MyAccount myAccount = PageFactory.initElements(driver, MyAccount.class);
        StoreSetup storeSetup = PageFactory.initElements(driver, StoreSetup.class);

        //pre-condition
        new LoginTC(driver,0).a_verifyLoginFunctionalitydynamic_05();

        logger().log(LogStatus.INFO, "Execution start for HIKE-103");

        //Step-1 : click on store setup button
        Assert.assertTrue(storeSetup.clickOnStoreSetupButton(), "click on store setup button");
        logger().log(LogStatus.PASS, "click on store setup button", "store setup button clicked");

        //Step-2 : click on My Account button
        Assert.assertTrue(centerlizePO.clickOnButton(myAccount.getMyAccountButton()), "click on My Account button");
        logger().log(LogStatus.PASS, "click on My Account button", "My Account button clicked");

        //Step-3 : click on Purge data
        Assert.assertTrue(centerlizePO.clickOnButton(myAccount.getPurgeData()), "click on Purge data");
        logger().log(LogStatus.PASS, "click on Purge data", "purge data clicked");

        //Step-4 : Purge data for gift cards
        Assert.assertTrue(myAccount.purgeDataForGiftCard(), "Purge data for gift cards");
        logger().log(LogStatus.PASS, "Purge data for gift cards", "Purge data for gift cards");
    }
}