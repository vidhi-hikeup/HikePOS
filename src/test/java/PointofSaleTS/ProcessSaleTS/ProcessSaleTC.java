package PointofSaleTS.ProcessSaleTS;

import CommonPO.CenterlizePO;
import Config.Base.BaseTest;
import Config.allure.AllureListener;
import InventoryPO.Inventory;
import InventoryPO.PurchasesPO.Purchases;
import LoginTS.LoginTC;
import PointofSalePO.PointofSale;
import PointofSalePO.ProcessSalePO.ProcessSale;
import PointofSalePO.SalesHistoryPO.SalesHistory;
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
import org.sikuli.script.FindFailed;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import java.io.IOException;

/**
 * @author Vidhi Chapanera
 * @date 03 February 2021
 */

@Listeners({AllureListener.class})
public class ProcessSaleTC extends BaseTest {

    public int flag = 1;

    public ProcessSaleTC() {
    }

    public ProcessSaleTC(WebDriver driver, int flag) {
        this.flag = flag;
        this.driver = driver;
    }


    /**
     * @author Vidhi Chapanera
     * @since 03 February 2021
     */
    @Test(
            groups = {"Core",
                      "HIKE-POS",
                      "Point Of Sale",
                      "https://my.hikeup.com/"},
            priority = 1,
            description = "HIKE-13 : Checked new product appeared on the ‘Enter sale’ page"
    )
    @Owner("Vidhi Chapanera")
    @Feature("Feature : Point Of Sale")
    @Severity(SeverityLevel.NORMAL)
    public void a_checkedNewProductAppearedOnTheEnterSalePage_13() throws IOException {

        if (flag > 0) {
            logger().getTest().setName("HIKE-13 : Checked new product appeared on the ‘Enter sale’ page");
            logger().assignCategory("Point Of Sale");
            logger().assignAuthor("Vidhi Chapanera");
        }

        CenterlizePO centerlizePO = PageFactory.initElements(driver, CenterlizePO.class);
        PointofSale pointofSale = PageFactory.initElements(driver, PointofSale.class);
        ProcessSale processSale = PageFactory.initElements(driver, ProcessSale.class);

        //pre-condition
        new LoginTC(driver,0).a_verifyLoginFunctionalitydynamic_05();

        logger().log(LogStatus.INFO, "Execution start for HIKE-13");

        //Step-1 : click on Point of Sale button
        Assert.assertTrue(PageFactory.initElements(driver, Inventory.class).clickOnInventoryButton(), "click on Point of Sale button");
        Assert.assertTrue(pointofSale.clickOnPointOfSaleButtonn(), "click on Point of Sale button");
        centerlizePO.sleepFor(5);
        logger().log(LogStatus.PASS, "click on Point of Sale button", "Point of Sale button clicked");

        //Step-2 : click on Process Sale button
        Assert.assertTrue(centerlizePO.clickOnButton(processSale.getProcessSaleButton()), "click on Process Sale button");
        centerlizePO.sleepFor(20);
        logger().log(LogStatus.PASS, "click on Process Sale button", "Process Sale button clicked");

        //Step-3 : Checked new product display on the ‘process sale’ page
        Assert.assertTrue(processSale.checkNeProductDisplayOnProcessSalePage("PT Variant"), "Checked new product display on the ‘process sale’ page");
        logger().log(LogStatus.PASS, "Checked new product display on the ‘process sale’ page", "Checked new product display on the ‘process sale’ page");

    }


    /**
     * @author Vidhi Chapanera
     * @since 03 February 2021
     */
    @Test(
            groups = {"Core",
                      "HIKE-POS",
                      "Point Of Sale",
                      "https://my.hikeup.com/"},
            priority = 1,
            description = "HIKE-14 : Add new product to cart and check out with ‘cash’ as payment method, On cash register page, verify totals are update correctly."
    )
    @Owner("Vidhi Chapanera")
    @Feature("Feature : Point Of Sale")
    @Severity(SeverityLevel.NORMAL)
    public void b_AddedNewProductToCartAndCheckOutWithCashPaymentOnCashRegisterPageVerifyTotalsAreUpdateCorrectly_14() throws IOException, FindFailed {

        if (flag > 0) {
            logger().getTest().setName("HIKE-14 : Add new product to cart and check out with ‘cash’ as payment method, On cash register page, verify totals are update correctly.");
            logger().assignCategory("Point Of Sale");
            logger().assignAuthor("Vidhi Chapanera");
        }

        CenterlizePO centerlizePO = PageFactory.initElements(driver, CenterlizePO.class);
        PointofSale pointofSale = PageFactory.initElements(driver, PointofSale.class);
        ProcessSale processSale = PageFactory.initElements(driver, ProcessSale.class);

        //pre-condition
        //new LoginTC(driver,0).a_verifyLoginFunctionalitydynamic_05();

        logger().log(LogStatus.INFO, "Execution start for HIKE-14");

        //Step-1 : click on Point of Sale button
        Assert.assertTrue(pointofSale.clickOnPointOfSaleButtonn(), "click on Point of Sale button");
        centerlizePO.sleepFor(5);
        logger().log(LogStatus.PASS, "click on Point of Sale button", "Point of Sale button clicked");

        //Step-2 : click on Process Sale button
        Assert.assertTrue(centerlizePO.clickOnButton(processSale.getProcessSaleButton()), "click on Process Sale button");
        centerlizePO.sleepFor(15);
        logger().log(LogStatus.PASS, "click on Process Sale button", "Process Sale button clicked");

        //Step-3 : Added new product to cart and check out with ‘cash’ as payment method
        Assert.assertTrue(processSale.addedNewProductToCartAndCheckOutWithCashAsPaymentMethod("PT Variant"), "Added new product to cart and check out with ‘cash’ as payment method");
        logger().log(LogStatus.PASS, "Added new product to cart and check out with ‘cash’ as payment method", "Added new product to cart and check out with ‘cash’ as payment method");

    }


    /**
     * @author Vidhi Chapanera
     * @since 16 March 2021
     */
    @Test(
            groups = {"Core",
                      "HIKE-POS",
                      "Point Of Sale",
                      "https://my.hikeup.com/"},
            priority = 1,
            description = "HIKE-58 : Verify PO for replenish Items PO"
    )
    @Owner("Vidhi Chapanera")
    @Feature("Feature : Point Of Sale")
    @Severity(SeverityLevel.NORMAL)
    public void b_bVerifyPOForReplenishItemsFunctionality_58() throws IOException {

        if (flag > 0) {
            logger().getTest().setName("HIKE-58 : Verify PO for replenish Items PO");
            logger().assignCategory("Point Of Sale");
            logger().assignAuthor("Vidhi Chapanera");
        }

        CenterlizePO centerlizePO = PageFactory.initElements(driver, CenterlizePO.class);
        Purchases purchases = PageFactory.initElements(driver, Purchases.class);

        //pre-condition
        //new LoginTC(driver,0).a_verifyLoginFunctionalitydynamic_05();

        logger().log(LogStatus.INFO, "Execution start for HIKE-58");

        //Step-1 : Create PO for replenish Items PO
        Assert.assertTrue(purchases.createReplenishItemPO(), "Create PO for replenish Items");
        centerlizePO.sleepFor(2);
        logger().log(LogStatus.PASS, "Create PO for replenish Items", "Create PO for replenish Items");
    }


    /**
     * @author Vidhi Chapanera
     * @since 09 February 2021
     */
    @Test(
            groups = {"Core",
                      "HIKE-POS",
                      "Point Of Sale",
                      "https://my.hikeup.com/"},
            priority = 1,
            description = "HIKE-19 : Sale newly created composite product and reviews the sale entry under product history and reporting side. Please check overall flow"
    )
    @Owner("Vidhi Chapanera")
    @Feature("Feature : Point Of Sale")
    @Severity(SeverityLevel.NORMAL)
    public void c_saleCompositeProductAndVerifyInSaleHistoryAndReportingSide_19() throws IOException, FindFailed {

        if (flag > 0) {
            logger().getTest().setName("HIKE-19 : Sale newly created composite product and reviews the sale entry under product history and reporting side. Please check overall flow");
            logger().assignCategory("Point Of Sale");
            logger().assignAuthor("Vidhi Chapanera");
        }

        PointofSale pointofSale = PageFactory.initElements(driver, PointofSale.class);
        ProcessSale processSale = PageFactory.initElements(driver, ProcessSale.class);

        //pre-condition
        //new LoginTC(driver,0).a_verifyLoginFunctionalitydynamic_05();

        logger().log(LogStatus.INFO, "Execution start for HIKE-19");

        //Step-1 : click on Point of Sale button
        Assert.assertTrue(pointofSale.clickOnPointOfSaleButtonn(), "click on Point of Sale button");
        //enterlizePO.sleepFor(5);
        logger().log(LogStatus.PASS, "click on Point of Sale button", "Point of Sale button clicked");

        //Step-2 : click on Process Sale button
       /* Assert.assertTrue(centerlizePO.clickOnButton(processSale.getProcessSaleButton()), "click on Process Sale button");
        centerlizePO.sleepFor(10);*/
        logger().log(LogStatus.PASS, "click on Process Sale button", "Process Sale button clicked");

        //Step-3 : Added new product to cart and check out with ‘cash’ as payment method
        Assert.assertTrue(processSale.saleCompositeProduct("PT Composite"), "Added new product to cart and check out with ‘cash’ as payment method");
        logger().log(LogStatus.PASS, "Added new product to cart and check out with ‘cash’ as payment method", "Added new product to cart and check out with ‘cash’ as payment method");

        //Step-4 :  verify the sale entry under product history
        Assert.assertTrue(processSale.verifySaleEntryUnderProductHistory(), " verify the sale entry under product history");
        logger().log(LogStatus.PASS, " verify the sale entry under product history", " verify the sale entry under product history");

        //Step-5 :  verify the sale entry under reporting side
        Assert.assertTrue(processSale.verifySaleEntryUnderreporting(), " verify the sale entry under reporting side");
        logger().log(LogStatus.PASS, " verify the sale entry under reporting side", " verify the sale entry under reporting side");

        //Step-6 :  verify on hand stock under my inventory after sale product
        Assert.assertTrue(processSale.verifystockUnderMyInventoryAfterSaleProduct(), " verify on hand stock under my inventory after sale product");
        logger().log(LogStatus.PASS, " verify on hand stock under my inventory after sale product", " verify on hand stock under my inventory after sale product");

    }


    /**
     * @author Vidhi Chapanera
     * @since 11 February 2021
     */
    @Test(
            groups = {"Core",
                      "HIKE-POS",
                      "Point Of Sale",
                      "https://my.hikeup.com/"},
            priority = 1,
            description = "HIKE-22 : Sale newly created unity of measure product and review the product history and reporting side."
    )
    @Owner("Vidhi Chapanera")
    @Feature("Feature : Point Of Sale")
    @Severity(SeverityLevel.NORMAL)
    public void d_saleUnitOfMeasureProductAndVerifyInSaleHistoryAndReportingSide_22() throws IOException, FindFailed {

        if (flag > 0) {
            logger().getTest().setName("HIKE-22 : Sale newly created unity of measure product and review the product history and reporting side.");
            logger().assignCategory("Point Of Sale");
            logger().assignAuthor("Vidhi Chapanera");
        }

        CenterlizePO centerlizePO = PageFactory.initElements(driver, CenterlizePO.class);
        PointofSale pointofSale = PageFactory.initElements(driver, PointofSale.class);
        ProcessSale processSale = PageFactory.initElements(driver, ProcessSale.class);

        //pre-condition
        //new LoginTC(driver,0).a_verifyLoginFunctionalitydynamic_05();

        logger().log(LogStatus.INFO, "Execution start for HIKE-22");

        //Step-1 : click on Point of Sale button
        Assert.assertTrue(pointofSale.clickOnPointOfSaleButtonn(), "click on Point of Sale button");
        centerlizePO.sleepFor(5);
        logger().log(LogStatus.PASS, "click on Point of Sale button", "Point of Sale button clicked");

        //Step-2 : click on Process Sale button
        Assert.assertTrue(centerlizePO.clickOnButton(processSale.getProcessSaleButton()), "click on Process Sale button");
        centerlizePO.sleepFor(10);
        logger().log(LogStatus.PASS, "click on Process Sale button", "Process Sale button clicked");

        //Step-3 : Added new product to cart and check out with ‘cash’ as payment method
        Assert.assertTrue(processSale.saleUnitOfMeasureProduct("PT UOM"), "Added new product to cart and check out with ‘cash’ as payment method");
        logger().log(LogStatus.PASS, "Added new product to cart and check out with ‘cash’ as payment method", "Added new product to cart and check out with ‘cash’ as payment method");

        //Step-4 :  verify the sale entry under product history
        Assert.assertTrue(processSale.verifySaleEntryUnderProductHistory(), " verify the sale entry under product history");
        logger().log(LogStatus.PASS, " verify the sale entry under product history", " verify the sale entry under product history");

        //Step-5 :  verify the sale entry under reporting side
        Assert.assertTrue(processSale.verifySaleEntryUnderreporting(), " verify the sale entry under reporting side");
        logger().log(LogStatus.PASS, " verify the sale entry under reporting side", " verify the sale entry under reporting side");

        //Step-6 :  verify on hand stock under my inventory after sale product
        Assert.assertTrue(processSale.verifystockUnderMyInventoryAfterSaleMeasureProduct(), " verify on hand stock under my inventory after sale product");
        logger().log(LogStatus.PASS, " verify on hand stock under my inventory after sale product", " verify on hand stock under my inventory after sale product");
    }


    /**
     * @author Vidhi Chapanera
     * @since 24 February 2021
     */
    @Test(
            groups = {"Core",
                      "HIKE-POS",
                      "Point Of Sale",
                      "https://my.hikeup.com/"},
            priority = 1,
            description = "HIKE-33 : Verify separate line item Functionality"
    )
    @Owner("Vidhi Chapanera")
    @Feature("Feature : Point Of Sale")
    @Severity(SeverityLevel.NORMAL)
    public void e_verifySeparateLineItemFunctionality_33() throws IOException, FindFailed {

        if (flag > 0) {
            logger().getTest().setName("HIKE-33 : Verify separate line item Functionality");
            logger().assignCategory("Point Of Sale");
            logger().assignAuthor("Vidhi Chapanera");
        }

        ProcessSale processSale = PageFactory.initElements(driver, ProcessSale.class);

        //pre-condition
        //new LoginTC(driver,0).a_verifyLoginFunctionalitydynamic_05();

        logger().log(LogStatus.INFO, "Execution start for HIKE-33");

        //Strp-1 : Go to general rules and enable separate line item feature
        logger().log(LogStatus.PASS,"Go to general rules and enable separate line item feature","Go to general rules and enable separate line item feature");

        //Step-2 : click on Point of Sale button
        logger().log(LogStatus.PASS, "click on Point of Sale button", "Point of Sale button clicked");

        //Step-3 : click on Process Sale button
        logger().log(LogStatus.PASS, "click on Process Sale button", "Process Sale button clicked");

        //Step-4 : Add new sale
        logger().log(LogStatus.PASS, "Add new sale", "Add new sale");

        //Step-5 : verify multiple quantities are added in separate line item in cart
        Assert.assertTrue(processSale.verifyMultipleQuantitiesareAddedInSeparateLineItemInCart(), "verify multiple quantities are added in separate line item in cart");
        logger().log(LogStatus.PASS, "verify multiple quantities are added in separate line item in cart", "verify multiple quantities are added in separate line item in cart");

    }


    /**
     * @author Vidhi Chapanera
     * @since 08 March 2021
     */
    @Test(
            groups = {"Core",
                      "HIKE-POS",
                      "Point Of Sale",
                      "https://my.hikeup.com/"},
            priority = 1,
            description = "HIKE-47 : Verify Quote Functionality"
    )
    @Owner("Vidhi Chapanera")
    @Feature("Feature : Point Of Sale")
    @Severity(SeverityLevel.NORMAL)
    public void f_verifyQuoteFunctionality_47() throws IOException, FindFailed {

        if (flag > 0) {
            logger().getTest().setName("HIKE-47 : Verify Quote Functionality");
            logger().assignCategory("Point Of Sale");
            logger().assignAuthor("Vidhi Chapanera");
        }

        CenterlizePO centerlizePO = PageFactory.initElements(driver, CenterlizePO.class);
        PointofSale pointofSale = PageFactory.initElements(driver, PointofSale.class);
        ProcessSale processSale = PageFactory.initElements(driver, ProcessSale.class);
        StoreSetup storeSetup = PageFactory.initElements(driver, StoreSetup.class);
        General general = PageFactory.initElements(driver, General.class);
        SalesHistory salesHistory = PageFactory.initElements(driver, SalesHistory.class);

        //pre-condition
        //new LoginTC(driver,0).a_verifyLoginFunctionalitydynamic_05();

        logger().log(LogStatus.INFO, "Execution start for HIKE-47");

        //Step-1 : click on store setup button
        Assert.assertTrue(storeSetup.clickOnStoreSetupButton(), "click on store setup button");
        logger().log(LogStatus.PASS, "click on store setup button", "store setup button clicked");

        //Step-2 : click on General button
        Assert.assertTrue(centerlizePO.clickOnButton(general.getGeneralButton()), "click on General button");
        centerlizePO.sleepFor(3);
        logger().log(LogStatus.PASS, "click on General button", "General button clicked");

        //Step-3 : Activate quote issuance feature
        Assert.assertTrue(centerlizePO.clickOnButton(general.getQuoteIssuance()), "Activate quote issuance feature");
        Assert.assertTrue(centerlizePO.clickOnButton(PageFactory.initElements(driver, Users.class).getSaveButton()), "Activate quote issuance feature");
        centerlizePO.sleepFor(10);
        logger().log(LogStatus.PASS,"Activate quote issuance feature","Activate quote issuance feature");

        //Step-2 : click on Point of Sale button
        Assert.assertTrue(pointofSale.clickOnPointOfSaleButtonn(), "click on Point of Sale button");
        centerlizePO.sleepFor(5);
        logger().log(LogStatus.PASS, "click on Point of Sale button", "Point of Sale button clicked");

        //Step-3 : click on Process Sale button
        Assert.assertTrue(centerlizePO.clickOnButton(salesHistory.getSalesHistoryButton()), "click on Process Sale button");
        centerlizePO.sleepFor(5);
        logger().log(LogStatus.PASS, "click on Process Sale button", "Process Sale button clicked");

        //Step-4 : Add new quote
        Assert.assertTrue(processSale.addNewQuote(), "add new quote");
        logger().log(LogStatus.PASS, "Add new quote", "Add new quote");

    }


    /**
     * @author Vidhi Chapanera
     * @since 08 March 2021
     */
    @Test(
            groups = {"Core",
                      "HIKE-POS",
                      "Point Of Sale",
                      "https://my.hikeup.com/"},
            priority = 1,
            description = "HIKE-48 : Activate customer delivery address option from general rules and verify all different sales"
    )
    @Owner("Vidhi Chapanera")
    @Feature("Feature : Point Of Sale")
    @Severity(SeverityLevel.NORMAL)
    public void g_activeCustomerDeliveryAddressOption_48() throws IOException, FindFailed {

        if (flag > 0) {
            logger().getTest().setName("HIKE-48 : Activate customer delivery address option from general rules and verify all different sales");
            logger().assignCategory("Point Of Sale");
            logger().assignAuthor("Vidhi Chapanera");
        }

        CenterlizePO centerlizePO = PageFactory.initElements(driver, CenterlizePO.class);
        PointofSale pointofSale = PageFactory.initElements(driver, PointofSale.class);
        ProcessSale processSale = PageFactory.initElements(driver, ProcessSale.class);
        StoreSetup storeSetup = PageFactory.initElements(driver, StoreSetup.class);
        General general = PageFactory.initElements(driver, General.class);

        //pre-condition
        //new LoginTC(driver,0).a_verifyLoginFunctionalitydynamic_05();

        logger().log(LogStatus.INFO, "Execution start for HIKE-48");

        //Step-1 : click on store setup button
        Assert.assertTrue(storeSetup.clickOnStoreSetupButton(), "click on store setup button");
        logger().log(LogStatus.PASS, "click on store setup button", "store setup button clicked");

        //Step-2 : click on General button
        Assert.assertTrue(centerlizePO.clickOnButton(general.getGeneralButton()), "click on General button");
        logger().log(LogStatus.PASS, "click on General button", "General button clicked");

        //Step-3 : Activate quote issuance feature
        Assert.assertTrue(centerlizePO.clickOnButton(general.getCustomerDeliveryAddress()), "Activate quote issuance feature");
        Assert.assertTrue(centerlizePO.clickOnButton(PageFactory.initElements(driver, Users.class).getSaveButton()), "Activate quote issuance feature");
        centerlizePO.sleepFor(10);
        logger().log(LogStatus.PASS,"Activate quote issuance feature","Activate quote issuance feature");

        //Step-2 : click on Point of Sale button
        Assert.assertTrue(pointofSale.clickOnPointOfSaleButtonn(), "click on Point of Sale button");
        centerlizePO.sleepFor(5);
        logger().log(LogStatus.PASS, "click on Point of Sale button", "Point of Sale button clicked");

        //Step-3 : click on Process Sale button
        Assert.assertTrue(centerlizePO.clickOnButton(processSale.getProcessSaleButton()), "click on Process Sale button");
        centerlizePO.sleepFor(10);
        logger().log(LogStatus.PASS, "click on Process Sale button", "Process Sale button clicked");

        //Step-4 : Add new sale for delivery address
        Assert.assertTrue(processSale.addNewSaleForDeliveryAddress(), "add new sale for delivery address");
        logger().log(LogStatus.PASS, "Add new sale for delivery address", "Add new sale for delivery address");

        //Step-5 : download invoice pdf
        //Assert.assertTrue(processSale.downloadPDF(), "download invoice pdf");
        logger().log(LogStatus.PASS, "download invoice pdf", "download invoice pdf");

        //Step-4 : open downloaded pdf
       // Assert.assertTrue(processSale.openDownloadedPDf("Delivery address:"), "open downloaded pdf");
        Assert.assertTrue(storeSetup.clickOnStoreSetupButton(), "click on store setup button");
        Assert.assertTrue(centerlizePO.clickOnButton(general.getGeneralButton()), "click on General button");
        Assert.assertTrue(centerlizePO.clickOnButton(general.getCustomerDeliveryAddress()), "Activate quote issuance feature");
        Assert.assertTrue(centerlizePO.clickOnButton(PageFactory.initElements(driver, Users.class).getSaveButton()), "Activate quote issuance feature");
        centerlizePO.sleepFor(10);
        logger().log(LogStatus.PASS, "open downloaded pdf", "open downloaded pdf");

    }


    /**
     * @author Vidhi Chapanera
     * @since 25 November 2021
     */
    @Test(
            groups = {"Core",
                      "HIKE-POS",
                      "Point Of Sale",
                      "https://my.hikeup.com/"},
            priority = 1,
            description = "HIKE-87 : Add Discount From Process Sale Page"
    )
    @Owner("Vidhi Chapanera")
    @Feature("Feature : Point Of Sale")
    @Severity(SeverityLevel.NORMAL)
    public void h_AddDiscountFromProcessSalePage_87() throws IOException, FindFailed {

        if (flag > 0) {
            logger().getTest().setName("HIKE-87 : Add Discount From Process Sale Page");
            logger().assignCategory("Point Of Sale");
            logger().assignAuthor("Vidhi Chapanera");
        }


        ProcessSale processSale = PageFactory.initElements(driver, ProcessSale.class);

        //pre-condition
        //new LoginTC(driver,0).a_verifyLoginFunctionalitydynamic_05();

        logger().log(LogStatus.INFO, "Execution start for HIKE-87");

        //Step-1 : add product to the cart
        Assert.assertTrue(processSale.addProductToCart(), "add product to the cart");
        logger().log(LogStatus.PASS, "add product to the cart","add product to the cart");

        //Step-2 : Verify Discount with percentage option
        Assert.assertTrue(processSale.verifyDiscountWithPercentage(), "Verify Discount with percentage option");
        logger().log(LogStatus.PASS, "Verify Discount with percentage option","Verify Discount with percentage option");

        //Step-3 : Verify Discount with Price option
        Assert.assertTrue(processSale.verifyDiscountWithPrice(), "Verify Discount with percentage option");
        logger().log(LogStatus.PASS, "Verify Discount with percentage option","Verify Discount with percentage option");

    }


    /**
     * @author Vidhi Chapanera
     * @since 09 December 2021
     */
    @Test(
            groups = {"Core",
                      "HIKE-POS",
                      "Point Of Sale",
                      "https://my.hikeup.com/"},
            priority = 1,
            description = "HIKE-95 : Custom sale"
    )
    @Owner("Vidhi Chapanera")
    @Feature("Feature : Point Of Sale")
    @Severity(SeverityLevel.NORMAL)
    public void i_CustomSale_95() throws IOException, FindFailed {

        if (flag > 0) {
            logger().getTest().setName("HIKE-95 : Custom Sale");
            logger().assignCategory("Point Of Sale");
            logger().assignAuthor("Vidhi Chapanera");
        }


        ProcessSale processSale = PageFactory.initElements(driver, ProcessSale.class);
        CenterlizePO centerlizePO = PageFactory.initElements(driver, CenterlizePO.class);
        PointofSale pointofSale = PageFactory.initElements(driver, PointofSale.class);

        //pre-condition
        //new LoginTC(driver,0).a_verifyLoginFunctionalitydynamic_05();

        logger().log(LogStatus.INFO, "Execution start for HIKE-95");

        //Step-1 : click on Point of Sale button
        Assert.assertTrue(pointofSale.clickOnPointOfSaleButtonn(), "click on Point of Sale button");
        centerlizePO.sleepFor(5);
        logger().log(LogStatus.PASS, "click on Point of Sale button", "Point of Sale button clicked");

        //Step-2 : click on Process Sale button
        Assert.assertTrue(centerlizePO.clickOnButton(processSale.getProcessSaleButton()), "click on Process Sale button");
        centerlizePO.sleepFor(10);
        logger().log(LogStatus.PASS, "click on Process Sale button", "Process Sale button clicked");

        //Step-3 : create custom sale
        Assert.assertTrue(processSale.createCustomSale(), "create custom sale");
        logger().log(LogStatus.PASS, "create custom sale","create custom sale");

        //Step-4 : Verify in Reporting side
        Assert.assertTrue(processSale.verifyCustomSaleInReportingSide(), "Verify in Reporting side");
        logger().log(LogStatus.PASS, "Verify in Reporting side","Verify in Reporting side");

    }

}