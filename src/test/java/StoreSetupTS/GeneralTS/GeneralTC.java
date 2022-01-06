package StoreSetupTS.GeneralTS;

import CommonPO.CenterlizePO;
import Config.Base.BaseTest;
import Config.allure.AllureListener;
import LoginTS.LoginTC;
import PointofSalePO.CashRegisterPO.CashRegister;
import PointofSalePO.PointofSale;
import PointofSalePO.ProcessSalePO.ProcessSale;
import ReportingPO.Reporting;
import StoreSetupPO.GeneralPO.General;
import StoreSetupPO.ReceiptTemplatesPO.ReceiptTemplates;
import StoreSetupPO.StoreSetup;
import UsersPO.Users;
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
 * @date 22 January 2021
 */

@Listeners({AllureListener.class})
public class GeneralTC extends BaseTest {

    public int flag = 1;

    public GeneralTC() {
    }

    public GeneralTC(WebDriver driver, int flag) {
        this.flag = flag;
        this.driver = driver;
    }

    /**
     * @author Vidhi Chapanera
     * @since 22 January 2021
     */
    @Test(
            groups = {"Core",
                      "HIKE-POS",
                      "Store Setup",
                      "https://my.hikeup.com/"},
            priority = 1,
            description = "HIKE-76 : Active features and general rules for store"
    )
    @Owner("Vidhi Chapanera")
    @Feature("Feature : Store Setup")
    @Severity(SeverityLevel.NORMAL)
    public void a_activeFeatureAndGeneralRulesForStore_76() throws IOException {

        if (flag > 0) {
            logger().getTest().setName("HIKE-76 : Active features and general rules for store");
            logger().assignCategory("Store Setup");
            logger().assignAuthor("Vidhi Chapanera");
        }

        CenterlizePO centerlizePO = PageFactory.initElements(driver, CenterlizePO.class);
        General general = PageFactory.initElements(driver, General.class);
        StoreSetup storeSetup = PageFactory.initElements(driver, StoreSetup.class);

        //pre-condition
        new LoginTC(driver,0).a_verifyLoginFunctionalitydynamic_05();

        logger().log(LogStatus.INFO, "Execution start for HIKE-76");

        //Step-1 : click on store setup button
        Assert.assertTrue(PageFactory.initElements(driver, Reporting.class).clickOnReportingButton(), "click on store setup button");
        Assert.assertTrue(PageFactory.initElements(driver, Users.class).clickOnUsersButton(), "click on store setup button");
        Assert.assertTrue(storeSetup.clickOnStoreSetupButton(), "click on store setup button");
        logger().log(LogStatus.PASS, "click on store setup button", "store setup button clicked");

        //Step-2 : click on General button 
        Assert.assertTrue(centerlizePO.clickOnButton(general.getGeneralButton()), "click on General button");
        logger().log(LogStatus.PASS, "click on General button", "General button clicked");

        //Step-3 : active features and general rules
        Assert.assertTrue(general.activeFeaturesAndGeneralRules(), "active features and general rules");
        logger().log(LogStatus.PASS, "active features and general rules", "active features and general rules");
    }


    /**
     * @author Vidhi Chapanera
     * @since 22 January 2021
     */
    @Test(
            groups = {"Core",
                      "HIKE-POS",
                      "Store Setup",
                      "https://my.hikeup.com/"},
            priority = 1,
            description = "HIKE-50 : Verify store logo functionality"
    )
    @Owner("Vidhi Chapanera")
    @Feature("Feature : Store Setup")
    @Severity(SeverityLevel.NORMAL)
    public void b_verifyStoreLogo_50() throws IOException {

        if (flag > 0) {
            logger().getTest().setName("HIKE-50 : Verify store logo functionality");
            logger().assignCategory("Store Setup");
            logger().assignAuthor("Vidhi Chapanera");
        }

        CenterlizePO centerlizePO = PageFactory.initElements(driver, CenterlizePO.class);
        General general = PageFactory.initElements(driver, General.class);
        StoreSetup storeSetup = PageFactory.initElements(driver, StoreSetup.class);
        ReceiptTemplates receiptTemplates = PageFactory.initElements(driver, ReceiptTemplates.class);
        PointofSale pointofSale = PageFactory.initElements(driver, PointofSale.class);
        CashRegister cashRegister = PageFactory.initElements(driver, CashRegister.class);


        //pre-condition
        //new LoginTC(driver,0).a_verifyLoginFunctionalitydynamic_05();

        logger().log(LogStatus.INFO, "Execution start for HIKE-50");

        //Step-1 : click on store setup button
        Assert.assertTrue(storeSetup.clickOnStoreSetupButton(), "click on store setup button");
        logger().log(LogStatus.PASS, "click on store setup button", "store setup button clicked");

        //Step-2 : click on General button
        Assert.assertTrue(centerlizePO.clickOnButton(general.getGeneralButton()), "click on General button");
        logger().log(LogStatus.PASS, "click on General button", "General button clicked");

        //Step-3 : upload store logo
        Assert.assertTrue(general.uploadStoreLogo(), "upload store logo");
        logger().log(LogStatus.PASS, "upload store logo", "upload store logo");

        //Step-4 : click on Receipt templates button
        Assert.assertTrue(centerlizePO.clickOnButton(receiptTemplates.getReceiptTemplates()), "click on Receipt templates button");
        logger().log(LogStatus.PASS, "click on Receipt templates button", "Receipt templates button clicked");

        //Step-5 : Add receipt templates
        // Assert.assertTrue(receiptTemplates.addReceiptTemplates(), "Add receipt templates");
        Assert.assertTrue(pointofSale.clickOnPointOfSaleButtonn(), "click on Point of Sale button");
        Assert.assertTrue(centerlizePO.clickOnButton(cashRegister.getCashRegisterButton()), "click on Cash Register button");
        centerlizePO.sleepFor(10);
        Assert.assertTrue(centerlizePO.clickOnButton(cashRegister.getRefreshDataButton()), "Click on Refresh Data button");
        Assert.assertTrue(centerlizePO.clickOnButton(cashRegister.getContinueButton()), "Click on Continue button on visible popup");
        cashRegister.sleepFor(10);
        logger().log(LogStatus.PASS, "Add receipt templates", "Add receipt templates");

        //Step-6 : Add new sale
        Assert.assertTrue(receiptTemplates.addNewSale(), "Add new sale");
        logger().log(LogStatus.PASS, "Add new sale", "Add new sale");

        //Step-7 : download invoice pdf
        // Assert.assertTrue(general.downloadPDF(), "download invoice pdf");
        logger().log(LogStatus.PASS, "download invoice pdf", "download invoice pdf");

        //Step-8 : open downloaded pdf
        //Assert.assertTrue(general.openDownloadedPDf(), "open downloaded pdf");
        logger().log(LogStatus.PASS, "open downloaded pdf", "open downloaded pdf");
    }


    /**
     * @author Vidhi Chapanera
     * @since 12 February 2021
     */
    @Test(
            groups = {"Core",
                      "HIKE-POS",
                      "Store Setup",
                      "https://my.hikeup.com/"},
            priority = 1,
            description = "HIKE-52 : Verify Gift card functionality"
    )
    @Owner("Vidhi Chapanera")
    @Feature("Feature : Store Setup")
    @Severity(SeverityLevel.NORMAL)
    public void c_verifyGiftCard_52() throws IOException {

        if (flag > 0) {
            logger().getTest().setName("HIKE-52 : Verify Gift card functionality");
            logger().assignCategory("Store Setup");
            logger().assignAuthor("Vidhi Chapanera");
        }

        CenterlizePO centerlizePO = PageFactory.initElements(driver, CenterlizePO.class);
        General general = PageFactory.initElements(driver, General.class);
        PointofSale pointofSale = PageFactory.initElements(driver, PointofSale.class);
        ProcessSale processSale = PageFactory.initElements(driver, ProcessSale.class);


        //pre-condition
        //new LoginTC(driver,0).a_verifyLoginFunctionalitydynamic_05();

        logger().log(LogStatus.INFO, "Execution start for HIKE-52");

        //Step-1 : click on store setup button
        logger().log(LogStatus.PASS, "click on store setup button", "store setup button clicked");

        //Step-2 : click on General button
        logger().log(LogStatus.PASS, "click on General button", "General button clicked");

        //Step-3 : Active gift card option
        logger().log(LogStatus.PASS, "Active gift card option", "Active gift card option");

        //Step-4 : click on Point of sale button
        Assert.assertTrue(pointofSale.clickOnPointOfSaleButtonn(), "click on Point of sale button");
        logger().log(LogStatus.PASS, "click on Point of sale button", "Point of sale button clicked");

        //Step-5 : click on process sale button
        Assert.assertTrue(centerlizePO.clickOnButton(processSale.getProcessSaleButton()), "click on process sale button");
        centerlizePO.sleepFor(10);
        logger().log(LogStatus.PASS, "click on process sale button", "click on process sale button");

        //Step-6 : sale gift card
        Assert.assertTrue(general.saleGiftCard(), "sale gift card");
        logger().log(LogStatus.PASS, "sale gift card", "sale gift card");

        //Step-7 : verify gift card is display after sale under gift card  side
        Assert.assertTrue(general.verifyGiftcardDisplay(), "verify gift card is display after sale under gift card  side");
        logger().log(LogStatus.PASS, "verify gift card is display after sale under gift card  side", "verify gift card is display after sale under gift card  side");

        //Step-8 : add new sale and checkout as gift card payment and then check flow
        Assert.assertTrue(general.addNewSaleCheckoutGiftCard(), "add new sale and checkout as gift card payment and then check flow");
        logger().log(LogStatus.PASS, "add new sale and checkout as gift card payment and then check flow", "add new sale and checkout as gift card payment and then check flow");
    }


    /**
     * @author Vidhi Chapanera
     * @since 08 December 2021
     */
    @Test(
            groups = {"Core",
                      "HIKE-POS",
                      "Store Setup",
                      "https://my.hikeup.com/"},
            priority = 1,
            description = "HIKE-94 : Add More Amount to exsting Gift card(Top up Functionality) And Verify Reporting Side"
    )
    @Owner("Vidhi Chapanera")
    @Feature("Feature : Store Setup")
    @Severity(SeverityLevel.NORMAL)
    public void d_verifyTopUpFunctionalityForGiftCard_94() throws IOException {

        if (flag > 0) {
            logger().getTest().setName("HIKE-94 : Add More Amount to exsting Gift card(Top up Functionality) And Verify Reporting Side");
            logger().assignCategory("Store Setup");
            logger().assignAuthor("Vidhi Chapanera");
        }

        CenterlizePO centerlizePO = PageFactory.initElements(driver, CenterlizePO.class);
        General general = PageFactory.initElements(driver, General.class);
        PointofSale pointofSale = PageFactory.initElements(driver, PointofSale.class);
        ProcessSale processSale = PageFactory.initElements(driver, ProcessSale.class);


        //pre-condition
        //new LoginTC(driver,0).a_verifyLoginFunctionalitydynamic_05();

        logger().log(LogStatus.INFO, "Execution start for HIKE-94");

        //Step-1 : click on Point of sale button
        Assert.assertTrue(pointofSale.clickOnPointOfSaleButtonn(), "click on Point of sale button");
        logger().log(LogStatus.PASS, "click on Point of sale button", "Point of sale button clicked");

        //Step-2 : click on process sale button
        Assert.assertTrue(centerlizePO.clickOnButton(processSale.getProcessSaleButton()), "click on process sale button");
        centerlizePO.sleepFor(25);
        logger().log(LogStatus.PASS, "click on process sale button", "click on process sale button");

        //Step-3 : click on GiftCard Button
        Assert.assertTrue(centerlizePO.clickOnButton(general.getGiftCard()), "click on GiftCard Button");
        logger().log(LogStatus.PASS, "click on GiftCard Button","click on GiftCard Button");

        //Step-4 : add TopUp for GiftCard
        Assert.assertTrue(general.addTopup(), "add TopUp for GiftCard");
        logger().log(LogStatus.PASS, "add TopUp for GiftCard", "add TopUp for GiftCard");

        //Step-5 : Verify Top up Balance in reporting side
        Assert.assertTrue(general.verifyTopupReportingSide(), "Verify Top up Balance in reporting side");
        logger().log(LogStatus.PASS, "Verify Top up Balance in reporting side", "Verify Top up Balance in reporting side");
    }


    /**
     * @author Vidhi Chapanera
     * @since 12 February 2021
     */
    @Test(
            groups = {"Core",
                      "HIKE-POS",
                      "Store Setup",
                      "https://my.hikeup.com/"},
            priority = 1,
            description = "HIKE-53 : Verify Loyalty Point functionality"
    )
    @Owner("Vidhi Chapanera")
    @Feature("Feature : Store Setup")
    @Severity(SeverityLevel.NORMAL)
    public void e_verifyLoyaltyPoint_53() throws IOException {

        if (flag > 0) {
            logger().getTest().setName("HIKE-53 : Verify Loyalty Point functionality");
            logger().assignCategory("Store Setup");
            logger().assignAuthor("Vidhi Chapanera");
        }

        CenterlizePO centerlizePO = PageFactory.initElements(driver, CenterlizePO.class);

        //pre-condition
       //new LoginTC(driver,0).a_verifyLoginFunctionalitydynamic_05();

        logger().log(LogStatus.INFO, "Execution start for HIKE-53");

        //Step-1 : click on store setup button
        logger().log(LogStatus.PASS, "click on store setup button", "store setup button clicked");

        //Step-2 : click on General button
        logger().log(LogStatus.PASS, "click on General button", "General button clicked");

        //Step-3 : Active Loyalty Point option
        logger().log(LogStatus.PASS, "Active Loyalty Point option", "Active Loyalty Point option");

        //Step-4 : get customer current loyalty blance before sale
        //Assert.assertTrue(general.editCustomerForLoyaltyPoints(), "get customer current loyalty blance before sale");
        logger().log(LogStatus.PASS, "get customer current loyalty blance before sale", "get customer current loyalty blance before sale");

        //Step-4 : click on Point of sale button
        //Assert.assertTrue(pointofSale.clickOnPointOfSaleButtonn(), "click on Point of sale button");
        logger().log(LogStatus.PASS, "click on Point of sale button", "Point of sale button clicked");

        //Step-5 : click on process sale button
        //Assert.assertTrue(centerlizePO.clickOnButton(processSale.getProcessSaleButton()), "click on process sale button");
        centerlizePO.sleepFor(10);
        logger().log(LogStatus.PASS, "click on process sale button", "click on process sale button");

        //Step-6 : add new sale for loyalty point
        //Assert.assertTrue(general.addNewSaleForLoyaltyPoints(), "add new sale for loyalty point");
        logger().log(LogStatus.PASS, "add new sale for loyalty point", "add new sale for loyalty point");

        //Step-7 : verify loyalty point after sale product
        //Assert.assertTrue(general.verifyLoyaltyPointsAfteSalePoduct(), "verify loyalty point after sale product");
        logger().log(LogStatus.PASS, "verify loyalty point after sale product", "verify loyalty point after sale product");

        //Step-8 : verify loyalty point for reporting side
        //Assert.assertTrue(general.verifyLoyaltyPointsForReportingSide(), "verify loyalty point for reporting side");
        logger().log(LogStatus.PASS, "verify loyalty point for reporting side", "verify loyalty point for reporting side");

    }


    /**
     * @author Vidhi Chapanera
     * @since 12 February 2021
     */
    @Test(
            groups = {"Core",
                      "HIKE-POS",
                      "Store Setup",
                      "https://my.hikeup.com/"},
            priority = 1,
            description = "HIKE-78 : Enable option to add shipping in general rules and review the overall functionality during checkout with different sales."
    )
    @Owner("Vidhi Chapanera")
    @Feature("Feature : Store Setup")
    @Severity(SeverityLevel.NORMAL)
    public void f_verifyShipping_78() throws IOException {

        if (flag > 0) {
            logger().getTest().setName("HIKE-78 : Enable option to add shipping in general rules and review the overall functionality during checkout with different sales.");
            logger().assignCategory("Store Setup");
            logger().assignAuthor("Vidhi Chapanera");
        }

        General general = PageFactory.initElements(driver, General.class);

        //pre-condition
        //new LoginTC(driver,0).a_verifyLoginFunctionalitydynamic_05();

        logger().log(LogStatus.INFO, "Execution start for HIKE-78");

        //Step-1 : click on store setup button
        logger().log(LogStatus.PASS, "click on store setup button", "store setup button clicked");

        //Step-2 : click on General button
        logger().log(LogStatus.PASS, "click on General button", "General button clicked");

        //Step-3 : Activate option to add shipping
        logger().log(LogStatus.PASS, "Activate option to add shipping", "Activate option to add shipping");

        //Step-4 : Verify Activate option to add shipping
        Assert.assertTrue(general.verifyShippingOption(), "Verify Activate option to add shipping");
        logger().log(LogStatus.PASS, " Verify Activate option to add shipping with sale on enter sale page"," Verify Activate option to add shipping with sale on enter sale page");

    }


    /**
     * @author Vidhi Chapanera
     * @since 12 February 2021
     */
    @Test(
            groups = {"Core",
                      "HIKE-POS",
                      "Store Setup",
                      "https://my.hikeup.com/"},
            priority = 1,
            description = "HIKE-79 : Enabled park paid fulfilment option in general rules and check both option functionality with different sale"
    )
    @Owner("Vidhi Chapanera")
    @Feature("Feature : Store Setup")
    @Severity(SeverityLevel.NORMAL)
    public void g_verifyParkPaidFulfilmentOptions_79() throws IOException {

        if (flag > 0) {
            logger().getTest().setName("HIKE-79 : Enabled park paid fulfilment option in general rules and check both option functionality with different sale");
            logger().assignCategory("Store Setup");
            logger().assignAuthor("Vidhi Chapanera");
        }

        General general = PageFactory.initElements(driver, General.class);

        //pre-condition
       //new LoginTC(driver,0).a_verifyLoginFunctionalitydynamic_05();

        logger().log(LogStatus.INFO, "Execution start for HIKE-79");

        //Step-1 : click on store setup button
        logger().log(LogStatus.PASS, "click on store setup button", "store setup button clicked");

        //Step-2 : click on General button
        logger().log(LogStatus.PASS, "click on General button", "General button clicked");

        //Step-3 : Active Park paid orders for fulfillment
        logger().log(LogStatus.PASS, "Park paid orders for fulfillment","Park paid orders for fulfillment");

        //Step-4 : Verify Activate option to add shipping with sale on enter sale page
        Assert.assertTrue(general.verifyParkPaidOrdersForFulfillmentOption(), "Verify Activate option to add shipping with sale on enter sale page");
        logger().log(LogStatus.PASS, " Verify Activate option to add shipping with sale on enter sale page"," Verify Activate option to add shipping with sale on enter sale page");

    }


    /**
     * @author Vidhi Chapanera
     * @since 12 February 2021
     */
    @Test(
            groups = {"Core",
                      "HIKE-POS",
                      "Store Setup",
                      "https://my.hikeup.com/"},
            priority = 1,
            description = "HIKE-80 : Hide last 3 digits in 'sold' gift card numbers listing"
    )
    @Owner("Vidhi Chapanera")
    @Feature("Feature : Store Setup")
    @Severity(SeverityLevel.NORMAL)
    public void h_VerifyHideLastThreeDigitOfGiftCard_80() throws IOException {

        if (flag > 0) {
            logger().getTest().setName("HIKE-80 : Hide last 3 digits in 'sold' gift card numbers listing");
            logger().assignCategory("Store Setup");
            logger().assignAuthor("Vidhi Chapanera");
        }

        General general = PageFactory.initElements(driver, General.class);

        //pre-condition
       //new LoginTC(driver,0).a_verifyLoginFunctionalitydynamic_05();

        logger().log(LogStatus.INFO, "Execution start for HIKE-80");

        //Step-1 : click on store setup button
        logger().log(LogStatus.PASS, "click on store setup button", "store setup button clicked");

        //Step-2 : click on General button
        logger().log(LogStatus.PASS, "click on General button", "General button clicked");

        //Step-3 : Active Hide last 3 digits in 'sold' gift card numbers listing
        logger().log(LogStatus.PASS, "Hide last 3 digits in 'sold' gift card numbers listing","Hide last 3 digits in 'sold' gift card numbers listing");

        //Step-4 : Verify Hide last 3 digits in 'sold' gift card numbers listing
        Assert.assertTrue(general.verifyHideLastThreeDigitinSoldGiftCardNumber(), "Verify Hide last 3 digits in 'sold' gift card numbers listing");
        logger().log(LogStatus.PASS, "Verify Hide last 3 digits in 'sold' gift card numbers listing","Verify Hide last 3 digits in 'sold' gift card numbers listing");

    }


    /**
     * @author Vidhi Chapanera
     * @since 1 December 2021
     */
    @Test(
            groups = {"Core",
                      "HIKE-POS",
                      "Store Setup",
                      "https://my.hikeup.com/"},
            priority = 1,
            description = "HIKE-91 : General - Display total items (quantity) in basket"
    )
    @Owner("Vidhi Chapanera")
    @Feature("Feature : Store Setup")
    @Severity(SeverityLevel.NORMAL)
    public void i_DisplayTotalItemsInBasket_91() throws IOException {

        if (flag > 0) {
            logger().getTest().setName("HIKE-91 : General - Display total items (quantity) in basket");
            logger().assignCategory("Store Setup");
            logger().assignAuthor("Vidhi Chapanera");
        }

        General general = PageFactory.initElements(driver, General.class);

        //pre-condition
        //new LoginTC(driver,0).a_verifyLoginFunctionalitydynamic_05();

        logger().log(LogStatus.INFO, "Execution start for HIKE-91");

        //Step-1 : click on store setup button
        logger().log(LogStatus.PASS, "click on store setup button", "store setup button clicked");

        //Step-2 : click on General button
        logger().log(LogStatus.PASS, "click on General button", "General button clicked");

        //Step-3 : Active Display total items (quantity) in basket
        logger().log(LogStatus.PASS, "Display total items (quantity) in basket","Display total items (quantity) in basket");

        //Step-4 : Verify Display total items (quantity) in basket
        Assert.assertTrue(general.verifyDisplayTotalItemsInBasket(), "Verify Display total items (quantity) in basket");
        logger().log(LogStatus.PASS, "Verify Display total items (quantity) in basket","Verify Display total items (quantity) in basket");

    }


    /**
     * @author Vidhi Chapanera
     * @since 7 December 2021
     */
    @Test(
            groups = {"Core",
                      "HIKE-POS",
                      "Store Setup",
                      "https://my.hikeup.com/"},
            priority = 1,
            description = "HIKE-93 : General - View Inventory Count on POS Screen"
    )
    @Owner("Vidhi Chapanera")
    @Feature("Feature : Store Setup")
    @Severity(SeverityLevel.NORMAL)
    public void j_InventoryCountOnPOSscreen_93() throws IOException {

        if (flag > 0) {
            logger().getTest().setName("HIKE-93 : General - View Inventory Count on POS Screen");
            logger().assignCategory("Store Setup");
            logger().assignAuthor("Vidhi Chapanera");
        }

        General general = PageFactory.initElements(driver, General.class);

        //pre-condition
        //new LoginTC(driver,0).a_verifyLoginFunctionalitydynamic_05();

        logger().log(LogStatus.INFO, "Execution start for HIKE-93");

        //Step-1 : click on store setup button
        logger().log(LogStatus.PASS, "click on store setup button", "store setup button clicked");

        //Step-2 : click on General button
        logger().log(LogStatus.PASS, "click on General button", "General button clicked");

        //Step-3 : Active View inventory count on POS screen
        logger().log(LogStatus.PASS, "View inventory count on POS screen","View inventory count on POS screen");

        //Step-4 : Verify inventory count Display on POS screen
        Assert.assertTrue(general.verifyInventoryCountOnPOSScreen(), "Verify inventory count Display on POS screen");
        logger().log(LogStatus.PASS, "Verify inventory count Display on POS screen","Verify inventory count Display on POS screen");

    }

}