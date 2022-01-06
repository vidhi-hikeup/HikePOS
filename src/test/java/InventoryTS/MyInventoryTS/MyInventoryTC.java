package InventoryTS.MyInventoryTS;

import CommonPO.CenterlizePO;
import Config.Base.BaseTest;
import Config.allure.AllureListener;
import InventoryPO.MyInventoryPO.MyInventory;
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
 * @date 16 March 2021
 */

@Listeners({AllureListener.class})
public class MyInventoryTC extends BaseTest {

    public int flag = 1;

    public MyInventoryTC() {
    }

    public MyInventoryTC(WebDriver driver, int flag) {
        this.flag = flag;
        this.driver = driver;
    }


    /**
     * @author Vidhi Chapanera
     * @since 16 March 2021
     */
    @Test(
            groups = {"Core",
                      "HIKE-POS",
                      "Inventroy",
                      "https://my.hikeup.com/"},
            priority = 1,
            description = "HIKE-62 : Linked product edit, go to my inventory page, click on any product name , its should be open in new tab and redirect on selected product edit page."
    )
    @Owner("Vidhi Chapanera")
    @Feature("Feature : Inventroy")
    @Severity(SeverityLevel.NORMAL)
    public void a_VerifyPurchaseOrderReturnFunctionality_62() throws IOException {

        if (flag > 0) {
            logger().getTest().setName("HIKE-62 : Linked product edit, go to my inventory page, click on any product name , its should be open in new tab and redirect on selected product edit page.");
            logger().assignCategory("Inventroy");
            logger().assignAuthor("Vidhi Chapanera");
        }

        CenterlizePO centerlizePO = PageFactory.initElements(driver, CenterlizePO.class);
        MyInventory myInventory = PageFactory.initElements(driver, MyInventory.class);

        //pre-condition
        new LoginTC(driver,0).a_verifyLoginFunctionalitydynamic_05();

        logger().log(LogStatus.INFO, "Execution start for HIKE-62");

        //Step-1 : Linked product edit, go to my inventory page, click on any product name , its should
        //be open in new tab and redirect on selected product edit page.
        Assert.assertTrue(myInventory.verifyProductEdit(), "Linked product edit, go to my inventory page, click on any product name , its should\n" +
                "be open in new tab and redirect on selected product edit page.");
        centerlizePO.sleepFor(2);
        logger().log(LogStatus.PASS, " Linked product edit, go to my inventory page, click on any product name , its should\n" +
                "be open in new tab and redirect on selected product edit page.", "Linked product edit, go to my inventory page, click on any product name , its should\n" +
                "be open in new tab and redirect on selected product edit page.");
    }

}