package StoreSetupTS.GeneralTS;

import Config.Base.BaseTest;
import Config.allure.AllureListener;
import LoginTS.LoginTC;
import StoreSetupPO.GeneralPO.General2;
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
 * @date 20 December 2021
 */

@Listeners({AllureListener.class})
public class GeneralTC2 extends BaseTest {

    public int flag = 1;

    public GeneralTC2() {
    }

    public GeneralTC2(WebDriver driver, int flag) {
        this.flag = flag;
        this.driver = driver;
    }


    /**
     * @author Vidhi Chapanera
     * @since 20 December 2021
     */
    @Test(
            groups = {"Core",
                      "HIKE-POS",
                      "Store Setup",
                      "https://my.hikeup.com/"},
            priority = 1,
            description = "HIKE-101 : Change Cloud Address And Verify scenario"
    )
    @Owner("Vidhi Chapanera")
    @Feature("Feature : Store Setup")
    @Severity(SeverityLevel.NORMAL)
    public void a_ChangeCloud_101() throws IOException {

        if (flag > 0) {
            logger().getTest().setName("HIKE-101 : Change Cloud Address And Verify scenario");
            logger().assignCategory("Store Setup");
            logger().assignAuthor("Vidhi Chapanera");
        }

        General2 general2 = PageFactory.initElements(driver, General2.class);

        //pre-condition
        new LoginTC(driver,0).a_verifyLoginFunctionalitydynamic_05();

        logger().log(LogStatus.INFO, "Execution start for HIKE-101");

        //Step-1 : click on store setup button
        logger().log(LogStatus.PASS, "click on store setup button", "store setup button clicked");

        //Step-2 : click on General button
        logger().log(LogStatus.PASS, "click on General button", "General button clicked");

        //Step-3 : Change Cloud Address And Verify scenario
        Assert.assertTrue(general2.changeCloudAddress(),"Change Cloud Address And Verify scenario");
        logger().log(LogStatus.PASS, "Change Cloud Address And Verify scenario","Change Cloud Address And Verify scenario");

    }


}