package InventoryTS.TransfersTS;

import CommonPO.CenterlizePO;
import Config.Base.BaseTest;
import Config.allure.AllureListener;
import InventoryPO.TransfersPO.Transfers;
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
 * @date 18 February 2021
 */

@Listeners({AllureListener.class})
public class TransfersTC extends BaseTest {

    public int flag = 1;

    public TransfersTC() {
    }

    public TransfersTC(WebDriver driver, int flag) {
        this.flag = flag;
        this.driver = driver;
    }

    /**
     * @author Vidhi Chapanera
     * @since 17 February 2021
     */
    @Test(
            groups = {"Core",
                      "HIKE-POS",
                      "Inventroy",
                      "https://my.hikeup.com/"},
            priority = 1,
            description = "HIKE-28 : Verify Transfers Functionality"
    )
    @Owner("Vidhi Chapanera")
    @Feature("Feature : Inventroy")
    @Severity(SeverityLevel.NORMAL)
    public void a_VerifyTransferFunctionality_28() throws IOException {

        if (flag > 0) {
            logger().getTest().setName("HIKE-28 : Verify Transfers Functionality");
            logger().assignCategory("Inventroy");
            logger().assignAuthor("Vidhi Chapanera");
        }

        CenterlizePO centerlizePO = PageFactory.initElements(driver, CenterlizePO.class);
        Transfers transfers = PageFactory.initElements(driver, Transfers.class);

        //pre-condition
        new LoginTC(driver,0).a_verifyLoginFunctionalitydynamic_05();

        logger().log(LogStatus.INFO, "Execution start for HIKE-28");

        //Step-1 : Verify Transfers Functionality
        Assert.assertTrue(transfers.verifyTransfersFunctionality("PT UOM"), "Verify Transfers Functionality");
        centerlizePO.sleepFor(2);
        logger().log(LogStatus.PASS, "Verify Transfers Functionality", "Verify Transfers Functionality");
    }

}