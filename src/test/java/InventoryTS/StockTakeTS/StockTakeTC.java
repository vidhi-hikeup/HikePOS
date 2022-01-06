package InventoryTS.StockTakeTS;

import Config.Base.BaseTest;
import Config.allure.AllureListener;
import InventoryPO.StockTakePO.StockTake;
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
 * @date 17 March 2021
 */

@Listeners({AllureListener.class})
public class StockTakeTC extends BaseTest {

    public int flag = 1;

    public StockTakeTC() {
    }

    public StockTakeTC(WebDriver driver, int flag) {
        this.flag = flag;
        this.driver = driver;
    }


    /**
     * @author Vidhi Chapanera
     * @since 17 March 2021
     */
    @Test(
            groups = {"Core",
                      "HIKE-POS",
                      "Inventroy",
                      "https://my.hikeup.com/"},
            priority = 1,
            description = "HIKE-65 :  Verify Quantity after receive PO"
    )
    @Owner("Vidhi Chapanera")
    @Feature("Feature : Inventroy")
    @Severity(SeverityLevel.NORMAL)
    public void a_VerifyPurchaseOrderReturnFunctionality_65() throws IOException {

        if (flag > 0) {
            logger().getTest().setName("HIKE-65 :  Verify Quantity after receive PO");
            logger().assignCategory("Inventroy");
            logger().assignAuthor("Vidhi Chapanera");
        }

        StockTake stocktake = PageFactory.initElements(driver, StockTake.class);

        //pre-condition
        new LoginTC(driver,0).a_verifyLoginFunctionalitydynamic_05();

        logger().log(LogStatus.INFO, "Execution start for HIKE-65");

        //Step-1 : click on Inventory button
        Assert.assertTrue(stocktake.createProductforStocktake(stocktake.productName1), "click on Inventory button");
        logger().log(LogStatus.PASS, "click on Inventory button", "click on Inventory button");

        //Step-2 : click on StockTake button
        logger().log(LogStatus.PASS, "click on StockTake button", "click on StockTake button");

        /**
         * @date 07 May 2021
         */
        //Step-3 : verify Add count value 0 (zero) for all skipped items option
        Assert.assertTrue(stocktake.verifyAddAccountValuezero(), "verify Add count value 0 (zero) for all skipped items option");
        logger().log(LogStatus.PASS, "verify Add count value 0 (zero) for all skipped items option", "verify Add count value 0 (zero) for all skipped items option");

        //Step-4 : verify Remove skipped items from this count list option
        Assert.assertTrue(stocktake.verifyRemoveSkippedItemFromthisCountList(), "Remove skipped items from this count list");
        logger().log(LogStatus.PASS, "Remove skipped items from this count list", "Remove skipped items from this count list");

        //Step-5 : Mistakenly clicked on this, go back!
        Assert.assertTrue(stocktake.verifyMistakenlyClickedonThisOption(), "Mistakenly clicked on this, go back!");
        logger().log(LogStatus.PASS, "Remove skipped items from this count list", "Remove skipped items from this count list");

        //Step-6 : verify Products in this count are to be unlocked only once all included products are counted option
        Assert.assertTrue(stocktake.verifyLockFunctionality(), "verify Products in this count are to be unlocked only once all included products are counted option");
        logger().log(LogStatus.PASS, "verify Products in this count are to be unlocked only once all included products are counted option","verify Products in this count are to be unlocked only once all included products are counted option");

        //Step-7 : verify Unlock products for selling as soon as they are counted option
        Assert.assertTrue(stocktake.verifyunLockFunctionality(), "verify Unlock products for selling as soon as they are counted option");
        logger().log(LogStatus.PASS, "verify Unlock products for selling as soon as they are counted option","verify Unlock products for selling as soon as they are counted option");

        //Step-8 : verify All inventory count and Omit items with 0 inventory option
        Assert.assertTrue(stocktake.verifyAllInventoryCountAndOmitItemsOption(), "verify All inventory count and Omit items with 0 inventory option");
        logger().log(LogStatus.PASS, "verify All inventory count and Omit items with 0 inventory option","verify All inventory count and Omit items with 0 inventory option");


    }


}