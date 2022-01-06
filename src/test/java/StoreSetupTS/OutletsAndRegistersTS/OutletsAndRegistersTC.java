package StoreSetupTS.OutletsAndRegistersTS;

import CommonPO.CenterlizePO;
import Config.Base.BaseTest;
import Config.allure.AllureListener;
import LoginTS.LoginTC;
import StoreSetupPO.OutletsAndRegistersPO.OutletsAndRegisters;
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
 * @date 27 December 2021
 */

@Listeners({AllureListener.class})
public class OutletsAndRegistersTC extends BaseTest {

    public int flag = 1;

    public OutletsAndRegistersTC() {
    }

    public OutletsAndRegistersTC(WebDriver driver, int flag) {
        this.flag = flag;
        this.driver = driver;
    }


    /**
     * @author Vidhi Chapanera
     * @since 27 December 2021
     */
    @Test(
            groups = {"Core",
                      "HIKE-POS",
                      "Store Setup",
                      "https://my.hikeup.com/"},
            priority = 1,
            description = "HIKE-106 : Opening hours In Outlet And Register Module"
    )
    @Owner("Vidhi Chapanera")
    @Feature("Feature : Store Setup")
    @Severity(SeverityLevel.NORMAL)
    public void a_OpeningHoursForOutletAndRegister_106() throws IOException {

        if (flag > 0) {
            logger().getTest().setName("HIKE-106 : Opening hours In Outlet And Register Module");
            logger().assignCategory("Store Setup");
            logger().assignAuthor("Vidhi Chapanera");
        }

        CenterlizePO centerlizePO = PageFactory.initElements(driver, CenterlizePO.class);
        OutletsAndRegisters outletsAndRegisters = PageFactory.initElements(driver, OutletsAndRegisters.class);
        StoreSetup storeSetup = PageFactory.initElements(driver, StoreSetup.class);

        //pre-condition
        new LoginTC(driver,0).a_verifyLoginFunctionalitydynamic_05();

        logger().log(LogStatus.INFO, "Execution start for HIKE-106");

        //Step-1 : click on store setup button
        Assert.assertTrue(storeSetup.clickOnStoreSetupButton(), "click on store setup button");
        logger().log(LogStatus.PASS, "click on store setup button", "store setup button clicked");

        //Step-2 : click on Outlet And Register  button
        Assert.assertTrue(centerlizePO.clickOnButton(outletsAndRegisters.getOutletsAndRegisters()), "click on Outlet And Register button");
        logger().log(LogStatus.PASS, "click on Outlet And Register button", "MOutlet And Register button clicked");

        //Step-3 : Verify opening/closing Timing
        Assert.assertTrue(outletsAndRegisters.VerifyTiming(), "Verify opening/closing Timing");
        logger().log(LogStatus.PASS, "Verify opening/closing Timing","Verify opening/closing Timing");



    }
}