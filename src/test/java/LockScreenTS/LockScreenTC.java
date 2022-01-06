package LockScreenTS;

import CommonPO.CenterlizePO;
import Config.Base.BaseTest;
import Config.allure.AllureListener;
import CustomersPO.Customers;
import InventoryPO.Inventory;
import LockScreenPO.LockScreen;
import LoginTS.LoginTC;
import PointofSalePO.PointofSale;
import PointofSalePO.ProcessSalePO.ProcessSale;
import StoreSetupPO.GeneralPO.General;
import StoreSetupPO.StoreSetup;
import UsersPO.UserPO.Users;
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

@Listeners({AllureListener.class})
public class LockScreenTC extends BaseTest {


    public int flag = 1;

    public LockScreenTC() {
    }

    public LockScreenTC(WebDriver driver, int flag) {
        this.flag = flag;
        this.driver = driver;
    }


    /**
     * @author Vidhi Chapanera
     * @since 15 March 2021
     */
    @Test(
            groups = {"Core",
                      "HIKE-POS",
                      "Lock Screen",
                      "https://my.hikeup.com/"},
            priority = 1,
            description = "HIKE-54 : Verify Lock Screen functionality"
    )
    @Owner("Vidhi Chapanera")
    @Feature("Feature : Lock Screen")
    @Severity(SeverityLevel.NORMAL)
    public void a_verifyLockSceen_54() throws IOException {

        if (flag > 0) {
            logger().getTest().setName("HIKE-54 : Verify Lock Screen functionality");
            logger().assignCategory("Lock Screen");
            logger().assignAuthor("Vidhi Chapanera");
        }

        CenterlizePO centerlizePO = PageFactory.initElements(driver, CenterlizePO.class);
        General general = PageFactory.initElements(driver, General.class);
        StoreSetup storeSetup = PageFactory.initElements(driver, StoreSetup.class);
        ProcessSale processSale = PageFactory.initElements(driver, ProcessSale.class);
        PointofSale pointofSale = PageFactory.initElements(driver, PointofSale.class);
        LockScreen lockScreen = PageFactory.initElements(driver, LockScreen.class);
        Customers customers = PageFactory.initElements(driver, Customers.class);

        //pre-condition
        new LoginTC(driver,0).a_verifyLoginFunctionalitydynamic_05();

        logger().log(LogStatus.INFO, "Execution start for HIKE-54");

        //Step-1 : click on store setup button
        Assert.assertTrue(storeSetup.clickOnStoreSetupButton(), "click on store setup button");
        logger().log(LogStatus.PASS, "click on store setup button", "store setup button clicked");

        //Step-2 : click on General button
        Assert.assertTrue(centerlizePO.clickOnButton(general.getGeneralButton()), "click on General button");
        logger().log(LogStatus.PASS, "click on General button", "General button clicked");

        //Step-3 : active Users to enter PIN for every sale
        Assert.assertTrue(centerlizePO.clickOnButton(general.getUsertoEnterPINOnEverySale()), "active Users to enter PIN for every sale");
        logger().log(LogStatus.PASS, "active Users to enter PIN for every sale", "active Users to enter PIN for every sale");

        //Step-4 : click on save button
        Assert.assertTrue(centerlizePO.clickOnButton(PageFactory.initElements(driver, Users.class).getSaveButton()), "click on save button");
        centerlizePO.sleepFor(10);
        logger().log(LogStatus.PASS, "click on save button", "click on save button");

        //Step-5 : click on Point of Sale button
        Assert.assertTrue(PageFactory.initElements(driver, Inventory.class).clickOnInventoryButton(), "click on Point of Sale button");
        Assert.assertTrue(pointofSale.clickOnPointOfSaleButtonn(), "click on Point of Sale button");
        centerlizePO.sleepFor(5);
        logger().log(LogStatus.PASS, "click on Point of Sale button", "Point of Sale button clicked");

        //Step-6 : click on Process Sale button
        Assert.assertTrue(centerlizePO.clickOnButton(processSale.getProcessSaleButton()), "click on Process Sale button");
        centerlizePO.sleepFor(20);
        logger().log(LogStatus.PASS, "click on Process Sale button", "Process Sale button clicked");

        //Step-7 : Check lock screen functionality by adding new sale
        Assert.assertTrue(lockScreen.checkNeProductDisplayOnProcessSalePage() ,"Check lock screen functionality by adding new sale");
        Assert.assertTrue(customers.clickOnCustomersButton(), "click on store setup button");
        Assert.assertTrue(storeSetup.clickOnStoreSetupButton(), "click on store setup button");
        Assert.assertTrue(centerlizePO.clickOnButton(general.getGeneralButton()), "click on General button");
        Assert.assertTrue(centerlizePO.clickOnButton(general.getUsertoEnterPINOnEverySale()), "active Users to enter PIN for every sale");
        Assert.assertTrue(centerlizePO.clickOnButton(PageFactory.initElements(driver, Users.class).getSaveButton()), "click on save button");
        centerlizePO.sleepFor(10);
        logger().log(LogStatus.PASS, "Check lock screen functionality by adding new sale", "Check lock screen functionality by adding new sale");

    }

}
