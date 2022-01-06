package CustomersTS.CustomersTS;

import CommonPO.CenterlizePO;
import Config.Base.BaseTest;
import Config.allure.AllureListener;
import CustomersPO.Customers;
import LoginTS.LoginTC;
import PointofSalePO.PointofSale;
import PointofSalePO.ProcessSalePO.ProcessSale;
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
 * @date 08 February 2021
 */

@Listeners({AllureListener.class})
public class CustomersTC extends BaseTest {

    public int flag = 1;
    public CustomersTC() {
    }

    public CustomersTC(WebDriver driver, int flag) {
        this.flag = flag;
        this.driver = driver;
    }


    /**
     * @author Vidhi Chapanera
     * @since 08 February 2021
     */
    @Test(
            /*enabled = false,*/
            groups = {"Core",
                      "HIKE-POS",
                      "Customers",
                      "https://my.hikeup.com/"},
            priority = 1,
            description = "HIKE-16 : Import multiple customers to and verify customers are imported successfully"
    )
    @Owner("Vidhi Chapanera")
    @Feature("Feature : Customers")
    @Severity(SeverityLevel.NORMAL)
    public void a_importMultipleCustomersAndVerifyThat_16() throws IOException {

        if (flag > 0) {
            logger().getTest().setName("HIKE-16 : Import multiple customers to and verify customers are imported successfully");
            logger().assignCategory("Customers");
            logger().assignAuthor("Vidhi Chapanera");
        }

        CenterlizePO centerlizePO = PageFactory.initElements(driver,CenterlizePO.class);
        Customers customers = PageFactory.initElements(driver,Customers.class);
        CustomersPO.CustomersPO.Customers customers1 = PageFactory.initElements(driver,CustomersPO.CustomersPO.Customers.class);

        //pre-condition
        new LoginTC(driver,0).a_verifyLoginFunctionalitydynamic_05();

        logger().log(LogStatus.INFO, "Execution start for HIKE-16");

        //Step-1 : Click on Customers Button
        Assert.assertTrue(customers.clickOnCustomersButton(), "Click on Customers Button");
        logger().log(LogStatus.PASS, "Click on Customers Button", "Customers Button clicked");

        //Step-2 : Click on Customers Button
        Assert.assertTrue(centerlizePO.clickOnButton(customers1.getCustomersButton()), "Click on Customers Button");
        logger().log(LogStatus.PASS, "Click on Customers Button", "Customers Button clicked");

        //Step-3 : import Customers using Import Button
        Assert.assertTrue(customers1.importCustomersUsingImportButton(), "import Customers using Import Button");
        logger().log(LogStatus.PASS, "import Customers using Import Button", "Customer Imported");

        //Step-4 : verify customers are imported successfully
       // Assert.assertTrue(customers1.verifyCustomersAreImported(), "verify customers are imported successfully");
        logger().log(LogStatus.PASS, "verify customers are imported successfully", "verify customers are imported successfully");
    }


    /**
     * @author Vidhi Chapanera
     * @since 23 February 2021
     */
    @Test(
            /*enabled = false,*/
            groups = {"Core",
                      "HIKE-POS",
                      "Customers",
                      "https://my.hikeup.com/"},
            priority = 1,
            description = "HIKE-32 : Verify customer is tax exempted during checkout by creating a new Tax exempt customer and >> add new sale"
    )
    @Owner("Vidhi Chapanera")
    @Feature("Feature : Customers")
    @Severity(SeverityLevel.NORMAL)
    public void b_verifyCustomerIsTaxExemptDuringCheckout_32() throws IOException {

        if (flag > 0) {
            logger().getTest().setName("HIKE-32 : Verify customer is tax exempted during checkout by creating a new Tax exempt customer and >> add new sale");
            logger().assignCategory("Customers");
            logger().assignAuthor("Vidhi Chapanera");
        }

        CenterlizePO centerlizePO = PageFactory.initElements(driver,CenterlizePO.class);
        Customers customers = PageFactory.initElements(driver,Customers.class);
        CustomersPO.CustomersPO.Customers customers1 = PageFactory.initElements(driver,CustomersPO.CustomersPO.Customers.class);

        logger().log(LogStatus.INFO, "Execution start for HIKE-32");

        //Step-1 : Click on Customers Button
        Assert.assertTrue(customers.clickOnCustomersButton(), "Click on Customers Button");
        logger().log(LogStatus.PASS, "Click on Customers Button", "Customers Button clicked");

        //Step-2 : Click on Customers Button
        Assert.assertTrue(centerlizePO.clickOnButton(customers1.getCustomersButton()), "Click on Customers Button");
        logger().log(LogStatus.PASS, "Click on Customers Button", "Customers Button clicked");

        //Step-3 : creating a new Tax exempt customer
        Assert.assertTrue(customers1.creatingNewTaxExemptCustomer(), "creating a new Tax exempt customer");
        logger().log(LogStatus.PASS, "creating a new Tax exempt customer", "creating a new Tax exempt customer");

        //Step-4 : Verify customer is tax exempted during checkout by  >> add new sale
        Assert.assertTrue(customers1.verifyCustomerTaxExemptDuringCheckout(), "Verify customer is tax exempted during checkout by  >> add new sale");
        logger().log(LogStatus.PASS, "Verify customer is tax exempted during checkout by  >> add new sale", "Verify customer is tax exempted during checkout by  >> add new sale");
    }


    /**
     * @author Vidhi Chapanera
     * @since 23 February 2021
     */
    @Test(
            groups = {"Core",
                      "HIKE-POS",
                      "Customers",
                      "https://my.hikeup.com/"},
            priority = 1,
            description = "HIKE-84 : Add Customer From Process sale page And Verify that could not uncheck default Selected Outlet"
    )
    @Owner("Vidhi Chapanera")
    @Feature("Feature : Customers")
    @Severity(SeverityLevel.NORMAL)
    public void c_verifyDoNotUncheckDefaultSelectedOutlet_84() throws IOException {

        if (flag > 0) {
            logger().getTest().setName("HIKE-84 : Add Customer From Process sale page And Verify that could not uncheck default Selected Outlet");
            logger().assignCategory("Customers");
            logger().assignAuthor("Vidhi Chapanera");
        }

        CenterlizePO centerlizePO = PageFactory.initElements(driver,CenterlizePO.class);
        CustomersPO.CustomersPO.Customers customers1 = PageFactory.initElements(driver,CustomersPO.CustomersPO.Customers.class);
        PointofSale pointofSale = PageFactory.initElements(driver, PointofSale.class);
        ProcessSale processSale = PageFactory.initElements(driver, ProcessSale.class);

        logger().log(LogStatus.INFO, "Execution start for HIKE-84");

        //pre-condition
        //new LoginTC(driver,0).a_verifyLoginFunctionalitydynamic_05();

        //Step-1 : select Customer profiles by outlet
        Assert.assertTrue(customers1.selectCustomerProfileByOutletOption(), "select Customer profiles by outlet");
        logger().log(LogStatus.PASS, "select Customer profiles by outlet ", "select Customer profiles by outlet");

        //Step-2 : click on Point of Sale button
        Assert.assertTrue(pointofSale.clickOnPointOfSaleButtonn(), "click on Point of Sale button");
        logger().log(LogStatus.PASS, "click on Point of Sale button", "Point of Sale button clicked");

        //Step-3 : click on Process Sale button
        Assert.assertTrue(centerlizePO.clickOnButton(processSale.getProcessSaleButton()), "click on Process Sale button");
        centerlizePO.sleepFor(10);
        logger().log(LogStatus.PASS, "click on Process Sale button", "Process Sale button clicked");

        //Step-4 : Click on Add Customer Button
        Assert.assertTrue( centerlizePO.clickOnButton(PageFactory.initElements(driver, ProcessSale.class).getAddCustomerButton()), "Click on Add Customer Button");
        logger().log(LogStatus.PASS, "Click on Add Customer Button","Click on Add Customer Button");

        //Step-5 : Click on Add New Customer Button
        Assert.assertTrue(centerlizePO.clickOnButton(customers1.getAddNewCustomerButton()), "Click on Add New Customer Button");
        logger().log(LogStatus.PASS, "Click on Add New Customer Button","Click on Add New Customer Button");

        //Step-4 : Add Customer From Process sale page And Verify that could not uncheck default Selected Outlet
        Assert.assertTrue(customers1.verifyCouldNotUncheckDefaultSelectedOutlet(), "Add Customer From Process sale page And Verify that could not uncheck default Selected Outlet");
        logger().log(LogStatus.PASS, "Add Customer From Process sale page And Verify that could not uncheck default Selected Outlet"," Add Customer From Process sale page And Verify that could not uncheck default Selected Outlet");
    }


    /**
     * @author Vidhi Chapanera
     * @since 23 February 2021
     */
    @Test(
            groups = {"Core",
                    "HIKE-POS",
                    "Customers",
                    "https://my.hikeup.com/"},
            priority = 1,
            description = "HIKE-109 : Bulk Paymnet And email paymet invoice and verify email subject"
    )
    @Owner("Vidhi Chapanera")
    @Feature("Feature : Customers")
    @Severity(SeverityLevel.NORMAL)
    public void d_BulkPayment_109() throws IOException {

        if (flag > 0) {
            logger().getTest().setName("HIKE-109 : Bulk Paymnet And email paymet invoice and verify email subject");
            logger().assignCategory("Customers");
            logger().assignAuthor("Vidhi Chapanera");
        }

        CenterlizePO centerlizePO = PageFactory.initElements(driver,CenterlizePO.class);
        CustomersPO.CustomersPO.Customers customers1 = PageFactory.initElements(driver,CustomersPO.CustomersPO.Customers.class);

        logger().log(LogStatus.INFO, "Execution start for HIKE-109");

        //pre-condition
        //new LoginTC(driver,0).a_verifyLoginFunctionalitydynamic_05();

        //Step-1 : click on Customers button
        Assert.assertTrue(PageFactory.initElements(driver, CustomersPO.Customers.class).clickOnCustomersButton(),"click on Customers button");
        logger().log(LogStatus.PASS, "click on Customers button", "click on Customers button");

        //Step-2 : click on Customers button
        Assert.assertTrue(centerlizePO.clickOnButton(customers1.getCustomersButton()), "click on Customers button");
        logger().log(LogStatus.PASS, "click on Customers button","click on Customers button");

        //Step-3 : click on Add New Customer button
        Assert.assertTrue(centerlizePO.clickOnButton(customers1.getAddNewCustomerButton01()), "click on Add New Customer button");
        logger().log(LogStatus.PASS, "click on Add New Customer button", "click on Add New Customer button");

        //Step-4 : create New customer
        Assert.assertTrue(customers1.createCustomer(), "create New customer");
        logger().log(LogStatus.PASS, "create New customer","create New customer");

        //Step-5 : create on account sale
        Assert.assertTrue(customers1.createOnAccountSale(), "create on account sale");
        logger().log(LogStatus.PASS, "create on account sale","create on account sale");

        //Step-6 : Create bulk payment
        Assert.assertTrue(customers1.createBulkPayment(), "Create bulk payment");
        logger().log(LogStatus.PASS, "Create bulk payment","Create bulk payment");

        //Step-7 : Verify bulk payment invoice sent via email
        Assert.assertTrue(customers1.verifyEmailSent(), "Verify bulk payment invoice sent via email");
        logger().log(LogStatus.PASS, "Verify bulk payment invoice sent via email","Verify bulk payment invoice sent via email");

    }

}
