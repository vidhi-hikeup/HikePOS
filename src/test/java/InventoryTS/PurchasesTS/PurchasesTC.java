package InventoryTS.PurchasesTS;

import CommonPO.CenterlizePO;
import Config.Base.BaseTest;
import Config.allure.AllureListener;
import InventoryPO.PurchasesPO.Purchases;
import LoginTS.LoginTC;
import StoreSetupPO.GeneralPO.General;
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
 * @date 12 February 2021
 */

@Listeners({AllureListener.class})
public class PurchasesTC extends BaseTest {

    public int flag = 1;

    public PurchasesTC() {
    }

    public PurchasesTC(WebDriver driver, int flag) {
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
            description = "HIKE-57 :  Verify Quantity after receive PO"
    )
    @Owner("Vidhi Chapanera")
    @Feature("Feature : Inventroy")
    @Severity(SeverityLevel.NORMAL)
    public void a_VerifyQuantiyAfterRecievePO_57() throws IOException {

        if (flag > 0) {
            logger().getTest().setName("HIKE-57 :  Verify Quantity after receive PO");
            logger().assignCategory("Inventroy");
            logger().assignAuthor("Vidhi Chapanera");
        }

        CenterlizePO centerlizePO = PageFactory.initElements(driver, CenterlizePO.class);
        Purchases purchases = PageFactory.initElements(driver, Purchases.class);

        //pre-condition
        new LoginTC(driver,0).a_verifyLoginFunctionalitydynamic_05();

        logger().log(LogStatus.INFO, "Execution start for HIKE-57");

        //Step-1 :  Verify Quantity after receive PO
        Assert.assertTrue(purchases.verifyQuantityaftyerReceivePO(), "Verify Quantity after receive PO");
        centerlizePO.sleepFor(2);
        logger().log(LogStatus.PASS, " Verify Quantity after receive PO", " Verify Quantity after receive PO");
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
            description = "HIKE-59 : Verify low stock inventory Option in PO"
    )
    @Owner("Vidhi Chapanera")
    @Feature("Feature : Inventroy")
    @Severity(SeverityLevel.NORMAL)
    public void b_VerifyLowStockInventoryOptionInPO_59() throws IOException {

        if (flag > 0) {
            logger().getTest().setName("HIKE-59 : Verify low stock inventory Option in PO");
            logger().assignCategory("Inventroy");
            logger().assignAuthor("Vidhi Chapanera");
        }

        CenterlizePO centerlizePO = PageFactory.initElements(driver, CenterlizePO.class);
        Purchases purchases = PageFactory.initElements(driver, Purchases.class);

        //pre-condition
        //new LoginTC(driver,0).a_verifyLoginFunctionalitydynamic_05();

        logger().log(LogStatus.INFO, "Execution start for HIKE-59");

        //Step-1 : Create a new PO for low stock inventory and review that items are correctly added in PO.
        Assert.assertTrue(purchases.createNewPOForLowStockInventory(), "Create a new PO for low stock inventory and review that items are correctly added in PO. ");
        centerlizePO.sleepFor(2);
        logger().log(LogStatus.PASS, "Create a new PO for low stock inventory and review that items are correctly added in PO.", "Create a new PO for low stock inventory and review that items are correctly added in PO. ");
    }


    /**
     * @author Vidhi Chapanera
     * @since 12 February 2021
     */
    @Test(
            groups = {"Core",
                      "HIKE-POS",
                      "Inventroy",
                      "https://my.hikeup.com/"},
            priority = 1,
            description = "HIKE-23 : Test unity of measure functionality with all possible scenarios along with Average cost price, PO, Return, Transfer, etc"
    )
    @Owner("Vidhi Chapanera")
    @Feature("Feature : Inventroy")
    @Severity(SeverityLevel.NORMAL)
    public void c_testUnitOfMeasureFunctionality_23() throws IOException {

        if (flag > 0) {
            logger().getTest().setName("HIKE-23 : Test unity of measure functionality with all possible scenarios along with Average cost price, PO, Return, Transfer, etc");
            logger().assignCategory("Inventroy");
            logger().assignAuthor("Vidhi Chapanera");
        }

        CenterlizePO centerlizePO = PageFactory.initElements(driver, CenterlizePO.class);
        Purchases purchases = PageFactory.initElements(driver, Purchases.class);

        //pre-condition
        //new LoginTC(driver,0).a_verifyLoginFunctionalitydynamic_05();

        logger().log(LogStatus.INFO, "Execution start for HIKE-23");

        //Step-1 : Activate Weighted Average Cost for purchase cost calculation
        Assert.assertTrue(PageFactory.initElements(driver,General.class).activeWeightedAverageCostforPurchaseCost(), "Activate Weighted Average Cost for purchase cost calculation");
        centerlizePO.sleepFor(2);
        logger().log(LogStatus.PASS, "Activate Weighted Average Cost for purchase cost calculation", "Activate Weighted Average Cost for purchase cost calculation");

        //Step-2 : verify Unit of measure functionality with scenario PO and Average Cost price
        Assert.assertTrue(purchases.verifyUnitOfMeasureFunctionalityWithPOAndAvgCost("PT UOM"), "verify Unit of measure functionality with scenario PO and Average Cost price ");
        logger().log(LogStatus.PASS, "verify Unit of measure functionality with scenario PO and Average Cost price ", "verify Unit of measure functionality with scenario PO and Average Cost price ");
    }


    /**
     * @author Vidhi Chapanera
     * @since 15 February 2021
     */
    @Test(
            groups = {"Core",
                      "HIKE-POS",
                      "Inventroy",
                      "https://my.hikeup.com/"},
            priority = 1,
            description = "HIKE-24 : Verify Update selling price with same profit margin PO (Average Cost Price) using unit of measure product"
    )
    @Owner("Vidhi Chapanera")
    @Feature("Feature : Inventroy")
    @Severity(SeverityLevel.NORMAL)
    public void d_verifyUpdateSellingPriceWithSameProfitMargin_24() throws IOException {

        if (flag > 0) {
            logger().getTest().setName("HIKE-24 : Verify Update selling price with same profit margin PO (Average Cost Price) using unit of measure product");
            logger().assignCategory("Inventroy");
            logger().assignAuthor("Vidhi Chapanera");
        }

        CenterlizePO centerlizePO = PageFactory.initElements(driver, CenterlizePO.class);
        Purchases purchases = PageFactory.initElements(driver, Purchases.class);

        //pre-condition
        //new LoginTC(driver,0).a_verifyLoginFunctionalitydynamic_05();

        logger().log(LogStatus.INFO, "Execution start for HIKE-24");

        //Step-1 : Verify Update selling price with same profit margin PO (Average Cost Price) using unit of measure product
        Assert.assertTrue(purchases.verifyUpdateSellingPriceWithSameProfitMargin("PT UOM"), "Verify Update selling price with same profit margin PO (Average Cost Price) using unit of measure product");
        centerlizePO.sleepFor(2);
        logger().log(LogStatus.PASS, "Verify Update selling price with same profit margin PO (Average Cost Price) using unit of measure product", "Verify Update selling price with same profit margin PO (Average Cost Price) using unit of measure product");
   }


    /**
     * @author Vidhi Chapanera
     * @since 16 February 2021
     */
    @Test(
            groups = {"Core",
                      "HIKE-POS",
                      "Inventroy",
                      "https://my.hikeup.com/"},
            priority = 1,
            description = "HIKE-25 : Verify Update profit margin with same selling price PO (Average Cost Price) using unit of measure product"
    )
    @Owner("Vidhi Chapanera")
    @Feature("Feature : Inventroy")
    @Severity(SeverityLevel.NORMAL)
    public void e_verifyUpdatepProfitMarginWithSameSellingPrice_25() throws IOException {

        if (flag > 0) {
            logger().getTest().setName("HIKE-25 : Verify Update profit margin with same selling price (Average Cost Price) using unit of measure product");
            logger().assignCategory("Inventroy");
            logger().assignAuthor("Vidhi Chapanera");
        }

        CenterlizePO centerlizePO = PageFactory.initElements(driver, CenterlizePO.class);
        Purchases purchases = PageFactory.initElements(driver, Purchases.class);

        //pre-condition
       //new LoginTC(driver,0).a_verifyLoginFunctionalitydynamic_05();

        logger().log(LogStatus.INFO, "Execution start for HIKE-25");

        //Step-1 : Verify Update profit margin with same selling price PO (Average Cost Price) using unit of measure product
        Assert.assertTrue(purchases.verifyUpdatepProfitMarginWithSameSellingPrice("PT UOM"), "Verify Update profit margin with same selling price PO (Average Cost Price) using unit of measure product");
        centerlizePO.sleepFor(2);
        logger().log(LogStatus.PASS, "Verify Update profit margin with same selling price PO (Average Cost Price) using unit of measure product", "Verify Update profit margin with same selling price PO (Average Cost Price) using unit of measure product");
    }


    /**
     * @author Vidhi Chapanera
     * @since 16 February 2021
     */
    @Test(
            groups = {"Core",
                      "HIKE-POS",
                    "Inventroy",
                      "https://my.hikeup.com/"},
            priority = 1,
            description = "HIKE-26 : Verify Temporary change – applies only to this PO (Average Cost Price) using unit of measure product"
    )
    @Owner("Vidhi Chapanera")
    @Feature("Feature : Inventroy")
    @Severity(SeverityLevel.NORMAL)
    public void f_verifyTemporaryChangeAppliesOnlyToThisPO_26() throws IOException {

        if (flag > 0) {
            logger().getTest().setName("HIKE-26 : Verify Temporary change – applies only to this PO (Average Cost Price) using unit of measure product");
            logger().assignCategory("Inventroy");
            logger().assignAuthor("Vidhi Chapanera");
        }

        CenterlizePO centerlizePO = PageFactory.initElements(driver, CenterlizePO.class);
        Purchases purchases = PageFactory.initElements(driver, Purchases.class);

        //pre-condition
        //new LoginTC(driver,0).a_verifyLoginFunctionalitydynamic_05();

        logger().log(LogStatus.INFO, "Execution start for HIKE-26");

        //Step-1 : Verify Temporary change – applies only to this PO (Average Cost Price) using unit of measure product
        Assert.assertTrue(purchases.verifyTemporaryChangeAppliesOnlyToThisPO("PT UOM"), "Verify Temporary change – applies only to this PO (Average Cost Price) using unit of measure product");
        centerlizePO.sleepFor(2);
        logger().log(LogStatus.PASS, "Verify Temporary change – applies only to this PO (Average Cost Price) using unit of measure product", "Verify Temporary change – applies only to this PO (Average Cost Price) using unit of measure product");
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
            description = "HIKE-27 : Verify Purchase Order Return Functionality"
    )
    @Owner("Vidhi Chapanera")
    @Feature("Feature : Inventroy")
    @Severity(SeverityLevel.NORMAL)
    public void g_VerifyPurchaseOrderReturnFunctionality_27() throws IOException {

        if (flag > 0) {
            logger().getTest().setName("HIKE-27 : Verify Purchase Order Return Functionality");
            logger().assignCategory("Inventroy");
            logger().assignAuthor("Vidhi Chapanera");
        }

        CenterlizePO centerlizePO = PageFactory.initElements(driver, CenterlizePO.class);
        Purchases purchases = PageFactory.initElements(driver, Purchases.class);

        //pre-condition
        //new LoginTC(driver,0).a_verifyLoginFunctionalitydynamic_05();

        logger().log(LogStatus.INFO, "Execution start for HIKE-27");

        //Step-1 : Verify Purchase Order Return Functionality
        Assert.assertTrue(purchases.verifyPurchaseOrderReturnFunctionality("PT UOM"), "Verify Purchase Order Return Functionality");
        centerlizePO.sleepFor(2);
        logger().log(LogStatus.PASS, "Verify Purchase Order Return Functionality", "Verify Purchase Order Return Functionality");
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
            description = "HIKE-61 : Print goods received functionality once received PO"
    )
    @Owner("Vidhi Chapanera")
    @Feature("Feature : Inventroy")
    @Severity(SeverityLevel.NORMAL)
    public void h_printGoodsReceivedFunctionalityOnceReceivedPO_61() throws IOException {

        if (flag > 0) {
            logger().getTest().setName("HIKE-61 : Print goods received functionality once received PO");
            logger().assignCategory("Inventroy");
            logger().assignAuthor("Vidhi Chapanera");
        }

        CenterlizePO centerlizePO = PageFactory.initElements(driver, CenterlizePO.class);
        Purchases purchases = PageFactory.initElements(driver, Purchases.class);

        //pre-condition
       // new LoginTC(driver,0).a_verifyLoginFunctionalitydynamic_05();

        logger().log(LogStatus.INFO, "Execution start for HIKE-61");

        //Step-1 : Verify Print goods received functionality once received PO
        Assert.assertTrue(purchases.printGoodsReceivedFunctionalityOnceReceivedPO(), "Print goods received functionality once received PO");
        centerlizePO.sleepFor(2);
        logger().log(LogStatus.PASS, "Print goods received functionality once received PO", "Print goods received functionality once received PO");
    }


}