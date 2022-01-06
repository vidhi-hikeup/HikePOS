package StoreSetupTS.LoyaltyPointsTS;

import CommonPO.CenterlizePO;
import Config.Base.BaseTest;
import Config.allure.AllureListener;
import StoreSetupPO.LoyaltyPointsPO.LoyaltyPoints;
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
 * @date 18 January 2021
 */

@Listeners({AllureListener.class})
public class LoyaltyPointsTC extends BaseTest {

    public int flag = 1;

    public LoyaltyPointsTC() {
    }

    public LoyaltyPointsTC(WebDriver driver, int flag) {
        this.flag = flag;
        this.driver = driver;
    }


    /**
     * @author Vidhi Chapanera
     * @since 18 January 2021
     */
    @Test(
            groups = {"Core",
                      "HIKE-POS",
                      "Store Setup",
                      "https://my.hikeup.com/"},
            priority = 1,
            description = "HIKE-04 : Activate loyalty points"
    )
    @Owner("Vidhi Chapanera")
    @Feature("Feature : Store Setup")
    @Severity(SeverityLevel.NORMAL)
    public void activateLoyaltyPoints_04() throws IOException {

        if (flag > 0) {
            logger().getTest().setName("HIKE-04 : Activate loyalty points");
            logger().assignCategory("Store Setup");
            logger().assignAuthor("Vidhi Chapanera");
        }

        CenterlizePO centerlizePO = PageFactory.initElements(driver, CenterlizePO.class);
        LoyaltyPoints loyaltyPoints = PageFactory.initElements(driver, LoyaltyPoints.class);
        StoreSetup storeSetup = PageFactory.initElements(driver, StoreSetup.class);

        //pre-condition
        //new LoginTC(driver,0).a_verifyLoginFunctionality_03();

        logger().log(LogStatus.INFO, "Execution start for HIKE-04");

        //Step-1 : click on store setup button
        Assert.assertTrue(storeSetup.clickOnStoreSetupButton(), "click on store setup button");
        logger().log(LogStatus.PASS, "click on store setup button", "store setup button clicked");

        //Step-2 : click on Loyalty Points button 
        Assert.assertTrue(centerlizePO.clickOnButton(loyaltyPoints.getLoyaltyPointsButton()), "click on Loyalty Points button");
        logger().log(LogStatus.PASS, "click on Loyalty Points button", "Loyalty Points button clicked");

        //Step-3 : Activate loyalty reward
        Assert.assertTrue(loyaltyPoints.activateLoyaltyRewards(), "Activate loyalty reward");
        logger().log(LogStatus.PASS, "Activate loyalty reward", "Activate loyalty reward");
    }
}