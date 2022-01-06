package ReportingTS.SalesTS;

import CommonPO.CenterlizePO;
import Config.Base.BaseTest;
import Config.allure.AllureListener;
import LoginTS.LoginTC;
import ReportingPO.Reporting;
import ReportingPO.SalesPO.Sales;
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
 * @date 24 November 2021
 */

@Listeners({AllureListener.class})
public class SalesTC extends BaseTest {

    public int flag = 1;

    public SalesTC() {
    }

    public SalesTC(WebDriver driver, int flag) {
        this.flag = flag;
        this.driver = driver;
    }


    /**
     * @author Vidhi Chapanera
     * @since 24 November 2021
     */
    @Test(
            groups = {"Core",
                      "HIKE-POS",
                      "Reporting",
                      "https://my.hikeup.com/"},
            priority = 1,
            description = "Hike-85 : Create LayBy sale And Verify Reporting side Before Complete sale"
    )
    @Owner("Vidhi Chapanera")
    @Feature("Feature : Reporting")
    @Severity(SeverityLevel.NORMAL)
    public void a_LayBySale_85() throws IOException {

        if (flag > 0) {
            logger().getTest().setName("Hike-85 : Create LayBy sale And Verify Reporting side Before Complete sale");
            logger().assignCategory("Reporting");
            logger().assignAuthor("Vidhi Chapanera");
        }

        CenterlizePO centerlizePO = PageFactory.initElements(driver, CenterlizePO.class);
        Reporting reporting = PageFactory.initElements(driver, Reporting.class);
        Sales sales = PageFactory.initElements(driver, Sales.class);

        //pre-condition
        new LoginTC(driver,0).a_verifyLoginFunctionalitydynamic_05();

        logger().log(LogStatus.INFO, "Execution start for Hike-85");

        //Step-1 : Create LayBy Sale
        Assert.assertTrue(sales.createLayBySale(), "Create LayBy Sale");
        logger().log(LogStatus.PASS, "Create LayBy Sale","Create LayBy Sale");

        //Step-2 : click on Reporting button
        Assert.assertTrue(reporting.clickOnReportingButton(), "click on Reporting button");
        logger().log(LogStatus.PASS, "click on Reporting button", "Reporting button clicked");

        //Step-3 : click on sales button
        Assert.assertTrue(centerlizePO.clickOnButton(sales.getSalesButton()), "click on sales button");
        logger().log(LogStatus.PASS, "click on sales button", "sales button clicked");

        //Step-4 : click on LayBy button
        Assert.assertTrue(centerlizePO.clickOnButton(sales.getLayByButtons()), "click on LayBy button");
        logger().log(LogStatus.PASS, "click on LayBy button", "LayBy button clicked");

        //Step-5 : Verify Newly Created LayBy Sale orderNumber is display in Reporting side under LayBy section
        Assert.assertTrue(sales.VerifyReportingSide("LayByDetailDataTable"), "Verify Newly Created LayBy Sale orderNumber is display in Reporting side under LayBy section");
        logger().log(LogStatus.PASS,"Verify Newly Created LayBy Sale orderNumber is display in Reporting side under LayBy section","Verify Newly Created LayBy Sale orderNumber is display in Reporting side under LayBy section");

    }


    /**
     * @author Vidhi Chapanera
     * @since 24 November 2021
     */
    @Test(
            groups = {"Core",
                      "HIKE-POS",
                      "Reporting",
                      "https://my.hikeup.com/"},
            priority = 1,
            description = "Hike-86 : Create On Account sale And Verify Reporting side Before Complete sale"
    )
    @Owner("Vidhi Chapanera")
    @Feature("Feature : Reporting")
    @Severity(SeverityLevel.NORMAL)
    public void b_OnAccountSale_86() throws IOException {

        if (flag > 0) {
            logger().getTest().setName("Hike-86 : Create On Account sale And Verify Reporting side Before Complete sale");
            logger().assignCategory("Reporting");
            logger().assignAuthor("Vidhi Chapanera");
        }

        CenterlizePO centerlizePO = PageFactory.initElements(driver, CenterlizePO.class);
        Reporting reporting = PageFactory.initElements(driver, Reporting.class);
        Sales sales = PageFactory.initElements(driver, Sales.class);

        //pre-condition
        //new LoginTC(driver,0).a_verifyLoginFunctionalitydynamic_05();

        logger().log(LogStatus.INFO, "Execution start for Hike-86");

        //Step-1 : Create On Account Sale
        Assert.assertTrue(sales.createOnAccountSale(), "Create On Account Sale");
        logger().log(LogStatus.PASS, "Create On Account Sale","Create On Account Sale");

        //Step-2 : click on Reporting button
        Assert.assertTrue(reporting.clickOnReportingButton(), "click on Reporting button");
        logger().log(LogStatus.PASS, "click on Reporting button", "Reporting button clicked");

        //Step-3 : click on sales button
        Assert.assertTrue(centerlizePO.clickOnButton(sales.getSalesButton()), "click on sales button");
        logger().log(LogStatus.PASS, "click on sales button", "sales button clicked");

        //Step-4 : click on LayBy button
        Assert.assertTrue(centerlizePO.clickOnButton(sales.getOnAccount02Buttons()), "click on LayBy button");
        logger().log(LogStatus.PASS, "click on LayBy button", "LayBy button clicked");

        //Step-5 : Verify Newly Created LayBy Sale orderNumber is display in Reporting side under LayBy section
        Assert.assertTrue(sales.VerifyReportingSide("OnAccountDetailDataTable"), "Verify Newly Created LayBy Sale orderNumber is display in Reporting side under LayBy section");
        logger().log(LogStatus.PASS,"Verify Newly Created LayBy Sale orderNumber is display in Reporting side under LayBy section","Verify Newly Created LayBy Sale orderNumber is display in Reporting side under LayBy section");

    }


    /**
     * @author Vidhi Chapanera
     * @since 26 November 2021
     */
    @Test(
            groups = {"Core",
                      "HIKE-POS",
                      "Reporting",
                      "https://my.hikeup.com/"},
            priority = 1,
            description = "Hike-88 : Create Park sale"
    )
    @Owner("Vidhi Chapanera")
    @Feature("Feature : Reporting")
    @Severity(SeverityLevel.NORMAL)
    public void c_ParkSale_88() throws IOException {

        if (flag > 0) {
            logger().getTest().setName("Hike-88 : Create Park sale");
            logger().assignCategory("Reporting");
            logger().assignAuthor("Vidhi Chapanera");
        }

        Sales sales = PageFactory.initElements(driver, Sales.class);

        //pre-condition
       //new LoginTC(driver,0).a_verifyLoginFunctionalitydynamic_05();

        logger().log(LogStatus.INFO, "Execution start for Hike-88");

        //Step-1 : Create Park Sale
        Assert.assertTrue(sales.createParkSale(), "Create Park Sale");
        logger().log(LogStatus.PASS, "Create Park Sale","Create Park Sale");

    }


    /**
     * @author Vidhi Chapanera
     * @since 29 November 2021
     */
    @Test(
            groups = {"Core",
                      "HIKE-POS",
                      "Reporting",
                      "https://my.hikeup.com/"},
            priority = 1,
            description = "Hike-89 : Voided Sale"
    )
    @Owner("Vidhi Chapanera")
    @Feature("Feature : Reporting")
    @Severity(SeverityLevel.NORMAL)
    public void d_VoidedSale_89() throws IOException {

        if (flag > 0) {
            logger().getTest().setName("Hike-89 : Voided Sale");
            logger().assignCategory("Reporting");
            logger().assignAuthor("Vidhi Chapanera");
        }

        Sales sales = PageFactory.initElements(driver, Sales.class);

        //pre-condition
        //new LoginTC(driver,0).a_verifyLoginFunctionalitydynamic_05();

        logger().log(LogStatus.INFO, "Execution start for Hike-89");

        //Step-1 : Create Voided Sale
        Assert.assertTrue(sales.createVoidedSale(), "Create Voided Sale");
        logger().log(LogStatus.PASS, "Create Voided Sale","Create Voided Sale");

    }


    /**
     * @author Vidhi Chapanera
     * @since 30 November 2021
     */
    @Test(
            groups = {"Core",
                      "HIKE-POS",
                      "Reporting",
                      "https://my.hikeup.com/"},
            priority = 1,
            description = "Hike-90 : Include Voided And Discarded transaction checkbox of Sales history and Verify Reporting side | Reporting -> register -> voided transaction"
    )
    @Owner("Vidhi Chapanera")
    @Feature("Feature : Reporting")
    @Severity(SeverityLevel.NORMAL)
    public void e_IncludeVoidedAndDiscardedTransaction_90() throws IOException {

        if (flag > 0) {
            logger().getTest().setName("Hike-90 : Include Voided And Discarded transaction checkbox of Sales history and Verify Reporting side | Reporting -> register -> voided transaction");
            logger().assignCategory("Reporting");
            logger().assignAuthor("Vidhi Chapanera");
        }

        logger().log(LogStatus.INFO, "Execution start for Hike-90");

        //Step-1 : Create Voided Sale
        logger().log(LogStatus.PASS, "Create Voided Sale","Create Voided Sale");

        //Step-2 : go to sales history and check Include Voided And Discarded transaction checkbox and select voided sales from invoice dropdown
        logger().log(LogStatus.PASS, "go to sales history and check Include Voided And Discarded transaction checkbox and select voided sales from invoice dropdown","go to sales history and check Include Voided And Discarded transaction checkbox and select voided sales from invoice dropdown");

        //Step-3 : verify that only voided sale are display
        logger().log(LogStatus.PASS, "verify that only voided sale are display","verify that only voided sale are display");
    }

}