package PointofSaleTS.CashRegisterTS;

import CommonPO.CenterlizePO;
import Config.Base.BaseTest;
import Config.allure.AllureListener;
import LoginTS.LoginTC;
import PointofSalePO.CashRegisterPO.CashRegister;
import PointofSalePO.PointofSale;
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

/**
 * @author Vidhi Chapanera
 * @date 20 January 2021
 */

@Listeners({AllureListener.class})
public class CashRegisterTC extends BaseTest {

    public int flag = 1;

    public CashRegisterTC() {
    }

    public CashRegisterTC(WebDriver driver, int flag) {
        this.flag = flag;
        this.driver = driver;
    }

    /**
     * @author Vidhi Chapanera
     * @since 20 January 2021
     */
    @Test(
            enabled = false,
            groups = {"Core",
                      "HIKE-POS",
                      "Point Of Sale",
                      "https://my.hikeup.com/"},
            priority = 1,
            description = "HIKE-07 : Verify Refresh Data button Functionality on Cash register page"
    )
    @Owner("Vidhi Chapanera")
    @Feature("Feature : Point Of Sale")
    @Severity(SeverityLevel.NORMAL)
    public void verifyRefreshDataFunctionality_07() throws IOException {

        if (flag > 0) {
            logger().getTest().setName("HIKE-07 : Verify Refresh Data button Functionality on Cash register page");
            logger().assignCategory("Point Of Sale");
            logger().assignAuthor("Vidhi Chapanera");
        }

        CenterlizePO centerlizePO = PageFactory.initElements(driver, CenterlizePO.class);
        PointofSale pointofSale = PageFactory.initElements(driver, PointofSale.class);
        CashRegister cashRegister = PageFactory.initElements(driver, CashRegister.class);

        //pre-condition
        //new LoginTC(driver,0).a_verifyLoginFunctionality_03();

        logger().log(LogStatus.INFO, "Execution start for HIKE-07");

        //Step-1 : click on Point of Sale button
        Assert.assertTrue(pointofSale.clickOnPointOfSaleButtonn(), "click on Point of Sale button");
        logger().log(LogStatus.PASS, "click on Point of Sale button", "Point of Sale button clicked");

        //Step-2 : click on Cash Register button 
        Assert.assertTrue(centerlizePO.clickOnButton(cashRegister.getCashRegisterButton()), "click on Cash Register button");
        logger().log(LogStatus.PASS, "click on Cash Register button", "Cash Register button clicked");

        //Step-3 : Click on Refresh Data button
        centerlizePO.sleepFor(10);
        Assert.assertTrue(PageFactory.initElements(driver, Users.class).clearAllNotification(), "Click on Refresh Data button");
        Assert.assertTrue(centerlizePO.clickOnButton(cashRegister.getRefreshDataButton()), "Click on Refresh Data button");
        logger().log(LogStatus.PASS, "Click on Refresh Data button", "Refresh Data button clicked");

        //Step-4 : Click on Continue button on visible popup
        Assert.assertTrue(centerlizePO.clickOnButton(cashRegister.getContinueButton()), "Click on Continue button on visible popup");
        logger().log(LogStatus.PASS, "Click on Continue button on visible popup", "Continue button on visible popup clicked");

        //Step-5 : verify user redirect to process sale page after click on refresh data
        Assert.assertTrue(cashRegister.verifyUserRedirectToprocessSalePage(), "verify user redirect to process sale page after click on refresh data");
        logger().log(LogStatus.PASS, "verify user redirect to process sale page after click on refresh data", "user redirect to the process sale page");
    }


    /**
     * @author Vidhi Chapanera
     * @since 01 March 2021
     */
    @Test(
            groups = {"Core",
                      "HIKE-POS",
                      "Point Of Sale",
                      "https://my.hikeup.com/"},
            priority = 1,
            description = "HIKE-37 : Verify opening float feature"
    )
    @Owner("Vidhi Chapanera")
    @Feature("Feature : Point Of Sale")
    @Severity(SeverityLevel.NORMAL)
    public void a_verifyOpeningFloatFunctionality_37() throws IOException {

        if (flag > 0) {
            logger().getTest().setName("HIKE-37 : Verify opening float feature");
            logger().assignCategory("Point Of Sale");
            logger().assignAuthor("Vidhi Chapanera");
        }

        CashRegister cashRegister = PageFactory.initElements(driver, CashRegister.class);

        //pre-condition
        new LoginTC(driver,0).a_verifyLoginFunctionalitydynamic_05();

        logger().log(LogStatus.INFO, "Execution start for HIKE-37");

        //Step-1 : click on Point of Sale button
        logger().log(LogStatus.PASS, "click on Point of Sale button", "Point of Sale button clicked");

        //Step-2 : click on Cash Register button
        logger().log(LogStatus.PASS, "click on Cash Register button", "Cash Register button clicked");

        //Step-3 : open Cash register With Float amount
        Assert.assertTrue(cashRegister.openCashRagister(), "open Cash register With Float amount");
        logger().log(LogStatus.PASS, "open Cash register With Float amount", "open Cash register With Float amount");

    }


    /**
     * @author Vidhi Chapanera
     * @since 17 March 2021
     */
    @Test(
            groups = {"Core",
                      "HIKE-POS",
                      "Point Of Sale",
                      "https://my.hikeup.com/"},
            priority = 1,
            description = "HIKE-64 : Support Article, go to enter sale page , click on support article button , slider should be open , now click on any article link , now selected article should be open in new tab."
    )
    @Owner("Vidhi Chapanera")
    @Feature("Feature : Point Of Sale")
    @Severity(SeverityLevel.NORMAL)
    public void b_verifySupportArticle_64() throws IOException {

        if (flag > 0) {
            logger().getTest().setName("HIKE-64 : Support Article, go to enter sale page , click on support article button , slider should be open , now click on any article link , now selected article should be open in new tab.");
            logger().assignCategory("Point Of Sale");
            logger().assignAuthor("Vidhi Chapanera");
        }

        CashRegister cashRegister = PageFactory.initElements(driver, CashRegister.class);

        //pre-condition
        //new LoginTC(driver,0).a_verifyLoginFunctionalitydynamic_05();

        logger().log(LogStatus.INFO, "Execution start for HIKE-64");

        //Step-1 : click on Point of Sale button
        logger().log(LogStatus.PASS, "click on Point of Sale button", "Point of Sale button clicked");

        //Step-2 : click on Cash Register button
        logger().log(LogStatus.PASS, "click on Cash Register button", "Cash Register button clicked");

        //Step-3 : Support Article, go to enter sale page , click on support article button , slider should be open , now click on any article link , now selected article should be open in new tab.
        Assert.assertTrue(cashRegister.supportArticle(), "Support Article, go to enter sale page , click on support article button , slider should be open , now click on any article link , now selected article should be open in new tab.");
        logger().log(LogStatus.PASS, "Support Article, go to enter sale page , click on support article button , slider should be open , now click on any article link , now selected article should be open in new tab.", "Support Article, go to enter sale page , click on support article button , slider should be open , now click on any article link , now selected article should be open in new tab.");

    }


    /**
     * @author Vidhi Chapanera
     * @since 18 March 2021
     */
    @Test(
            groups = {"Core",
                      "HIKE-POS",
                      "Point Of Sale",
                      "https://my.hikeup.com/"},
            priority = 1,
            description = "HIKE-67 : outlet/Cash Register and floating Point"
    )
    @Owner("Vidhi Chapanera")
    @Feature("Feature : Point Of Sale")
    @Severity(SeverityLevel.NORMAL)
    public void c_outletCashRegisterFloatingPoint_67() throws IOException {

        if (flag > 0) {
            logger().getTest().setName("HIKE-67 : outlet/Cash Register and floating Point");
            logger().assignCategory("Point Of Sale");
            logger().assignAuthor("Vidhi Chapanera");
        }

        CashRegister cashRegister = PageFactory.initElements(driver, CashRegister.class);

        //pre-condition
        //new LoginTC(driver,0).a_verifyLoginFunctionalitydynamic_05();

        logger().log(LogStatus.INFO, "Execution start for HIKE-67");

        //Step-1 : click on Point of Sale button
        logger().log(LogStatus.PASS, "click on Point of Sale button", "Point of Sale button clicked");

        //Step-2 : click on Cash Register button
        logger().log(LogStatus.PASS, "click on Cash Register button", "Cash Register button clicked");

        //Step-3 : outlet/Cash Register and floating Point
        Assert.assertTrue(cashRegister.outletCashRegisterFloatingPoint(), "outlet/Cash Register and floating Point");
        logger().log(LogStatus.PASS, "outlet/Cash Register and floating Point", "outlet/Cash Register and floating Point");
    }
}