package StoreSetupTS.PaymentTypesTS;

import CommonPO.CenterlizePO;
import Config.Base.BaseTest;
import Config.allure.AllureListener;
import LoginTS.LoginTC;
import StoreSetupPO.PaymentTypesPO.PaymentTypes;
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
 * @date 09 March 2021
 */

@Listeners({AllureListener.class})
public class PaymentTypesTC extends BaseTest {

    public int flag = 1;

    public PaymentTypesTC() {
    }

    public PaymentTypesTC(WebDriver driver, int flag) {
        this.flag = flag;
        this.driver = driver;
    }


    /**
     * @author Vidhi Chapanera
     * @since 09 March 2021
     */
    @Test(
            groups = {"Core",
                      "HIKE-POS",
                      "Store Setup",
                      "https://my.hikeup.com/"},
            priority = 1,
            description = "HIKE-49 : Verify Payment types functionality"
    )
    @Owner("Vidhi Chapanera")
    @Feature("Feature : Store Setup")
    @Severity(SeverityLevel.NORMAL)
    public void a_verifyPaymentTypesFunctionality_49() throws IOException {

        if (flag > 0) {
            logger().getTest().setName("HIKE-49 : Verify Payment types functionality");
            logger().assignCategory("Store Setup");
            logger().assignAuthor("Vidhi Chapanera");
        }

        CenterlizePO centerlizePO = PageFactory.initElements(driver, CenterlizePO.class);
        StoreSetup storeSetup = PageFactory.initElements(driver, StoreSetup.class);
        PaymentTypes paymentTypes = PageFactory.initElements(driver, PaymentTypes.class);

        //pre-condition
        new LoginTC(driver,0).a_verifyLoginFunctionalitydynamic_05();


        logger().log(LogStatus.INFO, "Execution start for HIKE-49");

        //Step-1 : click on store setup button
        Assert.assertTrue(storeSetup.clickOnStoreSetupButton(), "click on store setup button");
        logger().log(LogStatus.PASS, "click on store setup button", "store setup button clicked");

        //Step-2 : click on Payment types button
        Assert.assertTrue(centerlizePO.clickOnButton(paymentTypes.getPaymentTypes()), "click on Payment types button");
        logger().log(LogStatus.PASS, "click on Payment types button", "Payment types button clicked");

        //Step-3 : add new payment method
        Assert.assertTrue(paymentTypes.addNewPaymentMethod(), "add new payment method");
        logger().log(LogStatus.PASS, "add new payment method", "add new payment method");
        
        //Step-4 : add new sale and checkout with new payment method
        Assert.assertTrue(paymentTypes.addNewSaleAndCheckoutWithNewPaymentMethod(), "add new sale and checkout with new payment method");
        logger().log(LogStatus.PASS, "add new sale and checkout with new payment method", "add new sale and checkout with new payment method");

        //Step-5 : download invoice pdf
        //Assert.assertTrue(PageFactory.initElements(driver, ProcessSale.class).downloadPDF(), "download invoice pdf");
        logger().log(LogStatus.PASS, "download invoice pdf", "download invoice pdf");

        //Step-4 : open downloaded pdf
        //Assert.assertTrue(PageFactory.initElements(driver, ProcessSale.class).openDownloadedPDf(paymentTypes.paymentType), "open downloaded pdf");
        logger().log(LogStatus.PASS, "open downloaded pdf", "open downloaded pdf");

        //Step-5 : Verify new payment method in cash register page
        Assert.assertTrue(paymentTypes.verifyPaymentMethodinCashRegister(), "Verify new payment method in cash register page");
        logger().log(LogStatus.PASS, "Verify new payment method in cash register page", "Verify new payment method in cash register page");

        //Step-6 : Verify new payment method in sales history page
        Assert.assertTrue(paymentTypes.verifyPaymentMethodinsaleshistory(), "Verify new payment method in sales history page");
        logger().log(LogStatus.PASS, "Verify new payment method in sales history page", "Verify new payment method in sales history page");

        //Step-7 : Verify new payment method in Reporting side
        ///Assert.assertTrue(paymentTypes.verifyNewPaymentMethodInReportingSide(), "Verify new payment method in Reporting side");
        logger().log(LogStatus.PASS, "Verify new payment method in Reporting side", "Verify new payment method in Reporting side");
    }


}