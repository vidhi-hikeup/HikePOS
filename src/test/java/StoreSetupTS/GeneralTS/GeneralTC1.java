package StoreSetupTS.GeneralTS;


import Config.Base.BaseTest;
import Config.allure.AllureListener;
import LoginTS.LoginTC;
import StoreSetupPO.GeneralPO.General1;
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
 * @date 10 December 2021
 */

@Listeners({AllureListener.class})
public class GeneralTC1 extends BaseTest {

    public int flag = 1;

    public GeneralTC1() {
    }

    public GeneralTC1(WebDriver driver, int flag) {
        this.flag = flag;
        this.driver = driver;
    }


    /**
     * @author Vidhi Chapanera
     * @since 10 December 2021
     */
    //TODO
    @Test(
            enabled = false,
            groups = {"Core",
                      "HIKE-POS",
                      "Store Setup",
                      "https://my.hikeup.com/"},
            priority = 1,
            description = "HIKE-96 : General - Allow users to manually lock POS screen"
    )
    @Owner("Vidhi Chapanera")
    @Feature("Feature : Store Setup")
    @Severity(SeverityLevel.NORMAL)
    public void a_Lockscreen_96() throws IOException {

        if (flag > 0) {
            logger().getTest().setName("HIKE-96 : General - Allow users to manually lock POS screen");
            logger().assignCategory("Store Setup");
            logger().assignAuthor("Vidhi Chapanera");
        }

        General1 general = PageFactory.initElements(driver, General1.class);

        //pre-condition
        new LoginTC(driver,0).a_verifyLoginFunctionalitydynamic_05();

        logger().log(LogStatus.INFO, "Execution start for HIKE-96");

        //Step-1 : click on store setup button
        logger().log(LogStatus.PASS, "click on store setup button", "store setup button clicked");

        //Step-2 : click on General button
        logger().log(LogStatus.PASS, "click on General button", "General button clicked");

        //Step-3 : Active View inventory count on POS screen
        logger().log(LogStatus.PASS, "View inventory count on POS screen","View inventory count on POS screen");

        //Step-4 : Verify Allow users to manually lock POS screen
        Assert.assertTrue(general.verifyUserManuallyLockPOSScreen(), "Verify Allow users to manually lock POS screen");
        logger().log(LogStatus.PASS, "Allow users to manually lock POS screen","Allow users to manually lock POS screen");

    }


    /**
     * @author Vidhi Chapanera
     * @since 16 February 2021
     */
    @Test(
            /*dependsOnMethods = {"a_activeFeatureAndGeneralRulesForStore_76"},*/
            groups = {"Core",
                      "HIKE-POS",
                      "Store Setup",
                      "https://my.hikeup.com/"},
            priority = 1,
            description = "HIKE-99 : General - Tip And Surcharge Option"
    )
    @Owner("Vidhi Chapanera")
    @Feature("Feature : Store Setup")
    @Severity(SeverityLevel.NORMAL)
    public void b_verifySurcharge_99() throws IOException {

        if (flag > 0) {
            logger().getTest().setName("HIKE-99 : General - Tip And Surcharge Option");
            logger().assignCategory("Store Setup");
            logger().assignAuthor("Vidhi Chapanera");
        }

        General1 general = PageFactory.initElements(driver, General1.class);

        //pre-condition
        new LoginTC(driver,0).a_verifyLoginFunctionalitydynamic_05();

        logger().log(LogStatus.INFO, "Execution start for HIKE-99");

        //Step-1 : click on store setup button
        logger().log(LogStatus.PASS, "click on store setup button", "store setup button clicked");

        //Step-2 : click on General button
        logger().log(LogStatus.PASS, "click on General button", "General button clicked");

        //Step-3 : Active tips/surcharge option
        logger().log(LogStatus.PASS, "Active tips/surcharge option", "Active tips/surcharge option");

        //Step-4 : Verify Active tips/surcharge option
        Assert.assertTrue(general.verifySurchargeOption(), "Verify Active tips/surcharge option");
        logger().log(LogStatus.PASS, " Verify Active tips/surcharge option"," Verify Active tips/surcharge option");

    }


    /**
     * @author Vidhi Chapanera
     * @since 12 February 2021
     */
    @Test(
            /*dependsOnMethods = {"a_activeFeatureAndGeneralRulesForStore_76"},*/
            groups = {"Core",
                      "HIKE-POS",
                      "Store Setup",
                      "https://my.hikeup.com/"},
            priority = 1,
            description = "HIKE-100 : General - Already exchanged items can be exchanged or returned again"
    )
    @Owner("Vidhi Chapanera")
    @Feature("Feature : Store Setup")
    @Severity(SeverityLevel.NORMAL)
    public void c_ExchangedOrReturnAgin_100() throws IOException {

        if (flag > 0) {
            logger().getTest().setName("HIKE-100 : General - Already exchanged items can be exchanged or returned again");
            logger().assignCategory("Store Setup");
            logger().assignAuthor("Vidhi Chapanera");
        }

        General1 general = PageFactory.initElements(driver, General1.class);

        //pre-condition
        //new LoginTC(driver,0).a_verifyLoginFunctionalitydynamic_05();

        logger().log(LogStatus.INFO, "Execution start for HIKE-100");

        //Step-1 : click on store setup button
        logger().log(LogStatus.PASS, "click on store setup button", "store setup button clicked");

        //Step-2 : click on General button
        logger().log(LogStatus.PASS, "click on General button", "General button clicked");

        //Step-3 : Active Already exchanged items can be exchanged or returned again option
        logger().log(LogStatus.PASS, "Active Already exchanged items can be exchanged or returned again option", "Active Already exchanged items can be exchanged or returned again option");

        //Step-4 : Verify Already exchanged items can be exchanged or returned again option
        Assert.assertTrue(general.verifyExchangedAgain(), "Verify Already exchanged items can be exchanged or returned again");
        logger().log(LogStatus.PASS, " Verify Already exchanged items can be exchanged or returned again"," Verify Already exchanged items can be exchanged or returned again");

    }


    /**
     * @author Vidhi Chapanera
     * @since 21 December 2021
     */
    @Test(
            groups = {"Core",
                      "HIKE-POS",
                      "Store Setup",
                      "https://my.hikeup.com/"},
            priority = 1,
            description = "HIKE-102 : Every customer must have a unique phone number"
    )
    @Owner("Vidhi Chapanera")
    @Feature("Feature : Store Setup")
    @Severity(SeverityLevel.NORMAL)
    public void d_CustomerMustHaveUniquePhoneNumber_102() throws IOException {

        if (flag > 0) {
            logger().getTest().setName("HIKE-102 : Every customer must have a unique phone number");
            logger().assignCategory("Store Setup");
            logger().assignAuthor("Vidhi Chapanera");
        }

        General1 general = PageFactory.initElements(driver, General1.class);


        //pre-condition
        //new LoginTC(driver,0).a_verifyLoginFunctionalitydynamic_05();

        logger().log(LogStatus.INFO, "Execution start for HIKE-102");

        //Step-1 : click on store setup button
        logger().log(LogStatus.PASS, "click on store setup button", "store setup button clicked");

        //Step-2 : click on General button
        logger().log(LogStatus.PASS, "click on General button", "General button clicked");

        //Step-3 : Active Every customer must have a unique phone number option
        logger().log(LogStatus.PASS, "Active Every customer must have a unique phone number option", "Active Every customer must have a unique phone number option");

        //Step-4 : Verify Active Every customer must have a unique phone number option
        Assert.assertTrue(general.uniquePhoneNumber(), "Verify Active Every customer must have a unique phone number option");
        logger().log(LogStatus.PASS, " Verify Active Every customer must have a unique phone number option"," Verify Active Every customer must have a unique phone number option");
    }


    /**
     * @author Vidhi Chapanera
     * @since 24 December 2021
     */
    @Test(
            groups = {"Core",
                      "HIKE-POS",
                      "Store Setup",
                      "https://my.hikeup.com/"},
            priority = 1,
            description = "HIKE-104 : General - Do not include 'Parked orders' in sales reports"
    )
    @Owner("Vidhi Chapanera")
    @Feature("Feature : Store Setup")
    @Severity(SeverityLevel.NORMAL)
    public void e_DoNotIncludeParkedOrdersInSalesReports_104() throws IOException {

        if (flag > 0) {
            logger().getTest().setName("HIKE-104 : General - Do not include 'Parked orders' in sales reports");
            logger().assignCategory("Store Setup");
            logger().assignAuthor("Vidhi Chapanera");
        }

        General1 general = PageFactory.initElements(driver, General1.class);

        //pre-condition
        //new LoginTC(driver,0).a_verifyLoginFunctionalitydynamic_05();

        logger().log(LogStatus.INFO, "Execution start for HIKE-104");

        //Step-1 : click on Reporting button
        logger().log(LogStatus.PASS, "click on Reporting button", "Reporting button clicked");

        //Step-2 : click on sales Button
        logger().log(LogStatus.PASS, "click on sales Button", "sales button clicked");

        //Step-3 : get all amount from sales summery
        logger().log(LogStatus.PASS, "get all amount from sales summery", "get all amount from sales summery");

        //Step-4 : click on store setup button
        logger().log(LogStatus.PASS, "click on store setup button", "store setup button clicked");

        //Step-5 : click on General button
        logger().log(LogStatus.PASS, "click on General button", "General button clicked");

        //Step-6 : Active Do not include 'Parked orders' in sales reports option
        logger().log(LogStatus.PASS, "Active Do not include 'Parked orders' in sales reports option", "Active Do not include 'Parked orders' in sales reports option");

        //Step-7 : Create one park sale
        Assert.assertTrue(general.CreateOneParkSale(),"Create one park sale");
        logger().log(LogStatus.PASS, "Create one park sale", "Create one park sale");

        //Step-8 : verify that after park sale amount in sales summery should not be changed
        logger().log(LogStatus.PASS, "verify that after park sale amount in sales summery should not be changed", "verify that after park sale amount in sales summery should not be changed");

    }


    /**
     * @author Vidhi Chapanera
     * @since 24 December 2021
     */
    @Test(
            groups = {"Core",
                      "HIKE-POS",
                      "Store Setup",
                      "https://my.hikeup.com/"},
            priority = 1,
            description = "HIKE-105 : General - Do not include 'LayBy orders' in sales reports"
    )
    @Owner("Vidhi Chapanera")
    @Feature("Feature : Store Setup")
    @Severity(SeverityLevel.NORMAL)
    public void f_DoNotIncludeLayByOrdersInSalesReports_105() throws IOException {

        if (flag > 0) {
            logger().getTest().setName("HIKE-105 : General - Do not include 'LayBy orders' in sales reports");
            logger().assignCategory("Store Setup");
            logger().assignAuthor("Vidhi Chapanera");
        }

        General1 general = PageFactory.initElements(driver, General1.class);

        //pre-condition
        //new LoginTC(driver,0).a_verifyLoginFunctionalitydynamic_05();

        logger().log(LogStatus.INFO, "Execution start for HIKE-105");

        //Step-1 : click on Reporting button
        logger().log(LogStatus.PASS, "click on Reporting button", "Reporting button clicked");

        //Step-2 : click on sales Button
        logger().log(LogStatus.PASS, "click on sales Button", "sales button clicked");

        //Step-3 : get all amount from sales summery
        logger().log(LogStatus.PASS, "get all amount from sales summery", "get all amount from sales summery");

        //Step-4 : click on store setup button
        logger().log(LogStatus.PASS, "click on store setup button", "store setup button clicked");

        //Step-5 : click on General button
        logger().log(LogStatus.PASS, "click on General button", "General button clicked");

        //Step-6 : Active Do not include 'Layby orders' in sales reports option
        logger().log(LogStatus.PASS, "Active Do not include 'Layby orders' in sales reports option", "Active Do not include 'Layby orders' in sales reports option");

        //Step-7 : Create one Layby sale
        Assert.assertTrue(general.CreateOneLaybySale(),"Create one Layby sale");
        logger().log(LogStatus.PASS, "Create one Layby sale", "Create one Layby sale");

        //Step-8 : verify that after Layby sale amount in sales summery should not be changed
        logger().log(LogStatus.PASS, "verify that after Layby sale amount in sales summery should not be changed", "verify that after Layby sale amount in sales summery should not be changed");

    }
}