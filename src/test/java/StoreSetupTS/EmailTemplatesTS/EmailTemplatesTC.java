package StoreSetupTS.EmailTemplatesTS;

import CommonPO.CenterlizePO;
import Config.Base.BaseTest;
import Config.allure.AllureListener;
import CustomersPO.Customers;
import LoginTS.LoginTC;
import StoreSetupPO.EmailTemplatesPO.EmailTemplates;
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

/**
 * @author Vidhi Chapanera
 * @date 03 March 2021
 */

@Listeners({AllureListener.class})
public class EmailTemplatesTC extends BaseTest {

    public int flag = 1;

    public EmailTemplatesTC() {
    }

    public EmailTemplatesTC(WebDriver driver, int flag) {
        this.flag = flag;
        this.driver = driver;
    }


    /**
     * @author Vidhi Chapanera
     * @since 05 March 2021
     */
    @Test(
            groups = {"Core",
                      "HIKE-POS",
                      "Store Setup",
                      "https://my.hikeup.com/"},
            priority = 1,
            description = "HIKE-44 : Verify Welcome email to new customer(Email Template Functionality)"
    )
    @Owner("Vidhi Chapanera")
    @Feature("Feature : Store Setup")
    @Severity(SeverityLevel.NORMAL)
    public void a_verifyWelcomeEmailToNewCustomerEmailTemplate_44() throws IOException {

        if (flag > 0) {
            logger().getTest().setName("HIKE-44 : Verify Welcome email to new customer(Email Template Functionality)");
            logger().assignCategory("Store Setup");
            logger().assignAuthor("Vidhi Chapanera");
        }

        CenterlizePO centerlizePO = PageFactory.initElements(driver, CenterlizePO.class);
        EmailTemplates emailTemplates = PageFactory.initElements(driver, EmailTemplates.class);
        StoreSetup storeSetup = PageFactory.initElements(driver, StoreSetup.class);
        General general = PageFactory.initElements(driver, General.class);

        //pre-condition
        new LoginTC(driver,0).a_verifyLoginFunctionalitydynamic_05();

        logger().log(LogStatus.INFO, "Execution start for HIKE-44");

        //Step-1 : click on store setup button
        Assert.assertTrue(storeSetup.clickOnStoreSetupButton(), "click on store setup button");
        logger().log(LogStatus.PASS, "click on store setup button", "store setup button clicked");

        //Step-2 : click on General button
        Assert.assertTrue(centerlizePO.clickOnButton(general.getGeneralButton()), "click on General button");
        logger().log(LogStatus.PASS, "click on General button", "General button clicked");

        //Step-3 : Activate quote issuance feature
        Assert.assertTrue(centerlizePO.clickOnButton(general.getCustomerWelcomeEmail()), "Activate quote issuance feature");
        Assert.assertTrue(centerlizePO.clickOnButton(PageFactory.initElements(driver, Users.class).getSaveButton()), "Activate quote issuance feature");
        centerlizePO.sleepFor(10);
        logger().log(LogStatus.PASS,"Activate quote issuance feature","Activate quote issuance feature");

        //Step-4 : click on Email Templates button
        Assert.assertTrue(centerlizePO.clickOnButton(emailTemplates.getEmailTemplateButton()), "click on Email Templates button");
        logger().log(LogStatus.PASS, "click on Email Templates button", "Email Templates button clicked");

        //Step-5 : Verify Welcome email to new customer(Email Template Functionality)
        Assert.assertTrue(emailTemplates.selectPageFromPagination(), "Verify Welcome email to new customer(Email Template Functionality)");
        Assert.assertTrue(emailTemplates.editEmailTemplate(emailTemplates.getWelcomeEmailToNewCustomer()), "Verify Welcome email to new customer(Email Template Functionality)");
        logger().log(LogStatus.PASS, "Verify Welcome email to new customer(Email Template Functionality)", "Verify Welcome email to new customer(Email Template Functionality)");

        //Step-6 : Add New Customer for Welcome email to new customer(Email Template Functionality)
        Assert.assertTrue(emailTemplates.addNewCustomer(), "Add New Customer for Welcome email to new customer(Email Template Functionality)");
        logger().log(LogStatus.PASS, "Add New Customer for Welcome email to new customer(Email Template Functionality)", "Add New Customer for Welcome email to new customer(Email Template Functionality)");

        //Step-7 : Verify Email Details for Welcome email to new customer(Email Template Functionality)
        Assert.assertTrue(emailTemplates.readEmail(), "Verify Email Details for Welcome email to new customer(Email Template Functionality)");
        Assert.assertTrue(emailTemplates.verifyEmail(), "Verify Email Details for Welcome email to new customer(Email Template Functionality)");
        logger().log(LogStatus.PASS, "Verify Email Details for Welcome email to new customer(Email Template Functionality)", "Verify Email Details for Welcome email to new customer(Email Template Functionality)");
        logger().log(LogStatus.PASS, "Receive Subject :", EmailTemplates.receivingSubject);
        logger().log(LogStatus.PASS, "Hike POS Subject :", EmailTemplates.subject);
    }


    /**
     * @author Vidhi Chapanera
     * @since 05 March 2021
     */
    @Test(
            groups = {"Core",
                      "HIKE-POS",
                      "Store Setup",
                      "https://my.hikeup.com/"},
            priority = 1,
            description = "HIKE-45 : Verify Signup for loyalty program(Email Template Functionality)"
    )
    @Owner("Vidhi Chapanera")
    @Feature("Feature : Store Setup")
    @Severity(SeverityLevel.NORMAL)
    public void b_verifySignupForLoyaltyProgramrEmailTemplate_45() throws IOException {

        if (flag > 0) {
            logger().getTest().setName("HIKE-45 : Verify Signup for loyalty program(Email Template Functionality)");
            logger().assignCategory("Store Setup");
            logger().assignAuthor("Vidhi Chapanera");
        }

        CenterlizePO centerlizePO = PageFactory.initElements(driver, CenterlizePO.class);
        EmailTemplates emailTemplates = PageFactory.initElements(driver, EmailTemplates.class);
        StoreSetup storeSetup = PageFactory.initElements(driver, StoreSetup.class);

        //pre-condition
        //new LoginTC(driver,0).a_verifyLoginFunctionality_03();

        logger().log(LogStatus.INFO, "Execution start for HIKE-45");

        //Step-1 : click on store setup button
        Assert.assertTrue(storeSetup.clickOnStoreSetupButton(), "click on store setup button");
        logger().log(LogStatus.PASS, "click on store setup button", "store setup button clicked");

        //Step-2 : click on Email Templates button
        Assert.assertTrue(centerlizePO.clickOnButton(emailTemplates.getEmailTemplateButton()), "click on Email Templates button");
        logger().log(LogStatus.PASS, "click on Email Templates button", "Email Templates button clicked");

        //Step-3 : Verify Signup for loyalty program(Email Template Functionality)
        Assert.assertTrue(emailTemplates.editEmailTemplate(emailTemplates.getSignupForLoyaltyProgram()), "Verify Signup for loyalty program(Email Template Functionality)");
        logger().log(LogStatus.PASS, "Verify Signup for loyalty program(Email Template Functionality)", "Verify Signup for loyalty program(Email Template Functionality)");

        //Step-4 : Edit Customer for Signup for loyalty program(Email Template Functionality)
        Assert.assertTrue(emailTemplates.editCustomer(), "Edit Customer for Signup for loyalty program(Email Template Functionality)");
        logger().log(LogStatus.PASS, "Edit Customer for Signup for loyalty program(Email Template Functionality)", "Edit Customer for Signup for loyalty program(Email Template Functionality)");

        //Step-5 : Verify Email Details for Signup for loyalty program(Email Template Functionality)
        Assert.assertTrue(emailTemplates.readEmail(), "Verify Email Details for Signup for loyalty program(Email Template Functionality)");
        Assert.assertTrue(emailTemplates.verifyEmailDetails(), "Verify Email Details for Signup for loyalty program(Email Template Functionality)");
        logger().log(LogStatus.PASS, "Verify Email Details for Signup for loyalty program(Email Template Functionality)", "Verify Email Details for Signup for loyalty program(Email Template Functionality)");
        logger().log(LogStatus.PASS, "Receive Subject :", EmailTemplates.receivingSubject);
        logger().log(LogStatus.PASS, "Hike POS Subject :", EmailTemplates.subject);
    }


    /**
     * @author Vidhi Chapanera
     * @since 03 March 2021
     */
    @Test(
            groups = {"Core",
                      "HIKE-POS",
                      "Store Setup",
                      "https://my.hikeup.com/"},
            priority = 1,
            description = "HIKE-39 : Verify AR Statement(Email Template Functionality)"
    )
    @Owner("Vidhi Chapanera")
    @Feature("Feature : Store Setup")
    @Severity(SeverityLevel.NORMAL)
    public void c_verifyARStatementEmailTemplate_39() throws IOException {

        if (flag > 0) {
            logger().getTest().setName("HIKE-39 : Verify AR Statement(Email Template Functionality)");
            logger().assignCategory("Store Setup");
            logger().assignAuthor("Vidhi Chapanera");
        }

        CenterlizePO centerlizePO = PageFactory.initElements(driver, CenterlizePO.class);
        EmailTemplates emailTemplates = PageFactory.initElements(driver, EmailTemplates.class);
        StoreSetup storeSetup = PageFactory.initElements(driver, StoreSetup.class);
        Customers customers = PageFactory.initElements(driver, Customers.class);

        //pre-condition
        //new LoginTC(driver,0).a_verifyLoginFunctionalitydynamic_05();

        logger().log(LogStatus.INFO, "Execution start for HIKE-39");

        //Step-1 : click on store setup button
        Assert.assertTrue(storeSetup.clickOnStoreSetupButton(), "click on store setup button");
        logger().log(LogStatus.PASS, "click on store setup button", "store setup button clicked");

        //Step-2 : click on Email Templates button
        Assert.assertTrue(centerlizePO.clickOnButton(emailTemplates.getEmailTemplateButton()), "click on Email Templates button");
        logger().log(LogStatus.PASS, "click on Email Templates button", "Email Templates button clicked");

        //Step-3 : Verify AR Statement(Email Template Functionality)
        Assert.assertTrue(emailTemplates.editEmailTemplate(emailTemplates.getARStatementEmailTemplate()), "Verify AR Statement(Email Template Functionality)");
        logger().log(LogStatus.PASS, "Verify AR Statement(Email Template Functionality)", "Verify AR Statement(Email Template Functionality)");

        //Step-4 : Add New Sale for AR Statement(Email Template Functionality)
        Assert.assertTrue(emailTemplates.addNewSaleARStatementEmailTemplate(), "Add New Sale for AR Statement(Email Template Functionality)");
        logger().log(LogStatus.PASS, "Add New Sale for AR Statement(Email Template Functionality)", "Add New Sale for AR Statement(Email Template Functionality)");

        //Step-5 : Send Ar Statement Email From reporting side
        Assert.assertTrue(emailTemplates.sendARStatmentEmailFromReportingSide(), "Send Ar Statement Email From reporting side");
        logger().log(LogStatus.PASS, "Send Ar Statement Email From reporting side", "Send Ar Statement Email From reporting side");

        //Step-6 : Verify Email Details for AR Statement(Email Template Functionality)
        Assert.assertTrue(emailTemplates.readEmail(), "Verify Email Details for AR Statement(Email Template Functionality)");
        Assert.assertTrue(emailTemplates.verifyEmail(), "Verify Email Details for AR Statement(Email Template Functionality)");
        Assert.assertTrue(customers.clickOnCustomersButton(), "click on Users button");
        logger().log(LogStatus.PASS, "Verify Email Details for AR Statement(Email Template Functionality)", "Verify Email Details for AR Statement(Email Template Functionality)");
        logger().log(LogStatus.PASS, "Receive Subject :", EmailTemplates.receivingSubject);
        logger().log(LogStatus.PASS, "Hike POS Subject :", EmailTemplates.subject);
    }


    /**
     * @author Vidhi Chapanera
     * @since 04 March 2021
     */
    @Test(
            groups = {"Core",
                      "HIKE-POS",
                      "Store Setup",
                      "https://my.hikeup.com/"},
            priority = 1,
            description = "HIKE-40 : Verify Customer Invoice/receipt(Email Template Functionality)"
    )
    @Owner("Vidhi Chapanera")
    @Feature("Feature : Store Setup")
    @Severity(SeverityLevel.NORMAL)
    public void d_verifyCustomerInvoiceReceiptEmailTemplate_40() throws IOException {

        if (flag > 0) {
            logger().getTest().setName("HIKE-40 : Verify Customer Invoice/receipt(Email Template Functionality)");
            logger().assignCategory("Store Setup");
            logger().assignAuthor("Vidhi Chapanera");
        }

        CenterlizePO centerlizePO = PageFactory.initElements(driver, CenterlizePO.class);
        EmailTemplates emailTemplates = PageFactory.initElements(driver, EmailTemplates.class);
        StoreSetup storeSetup = PageFactory.initElements(driver, StoreSetup.class);

        //pre-condition
        //new LoginTC(driver,0).a_verifyLoginFunctionalitydynamic_05();

        logger().log(LogStatus.INFO, "Execution start for HIKE-40");

        //Step-1 : click on store setup button
        Assert.assertTrue(storeSetup.clickOnStoreSetupButton(), "click on store setup button");
        logger().log(LogStatus.PASS, "click on store setup button", "store setup button clicked");

        //Step-2 : click on Email Templates button
        Assert.assertTrue(centerlizePO.clickOnButton(emailTemplates.getEmailTemplateButton()), "click on Email Templates button");
        logger().log(LogStatus.PASS, "click on Email Templates button", "Email Templates button clicked");

        //Step-3 : Verify Customer Invoice/receipt (Email Template Functionality)
        Assert.assertTrue(emailTemplates.editEmailTemplate(emailTemplates.getCustomerInvoiceReceiptEmailTemplate()), "Verify Customer Invoice/receipt(Email Template Functionality)");
        logger().log(LogStatus.PASS, "Verify Customer Invoice/receipt(Email Template Functionality)", "Verify Customer Invoice/receipt(Email Template Functionality)");

        //Step-4 : Add New Sale for Customer Invoice/receipt(Email Template Functionality)
        Assert.assertTrue(emailTemplates.addNewSaleCustomerInvoiceReceiptEmailTemplate(), "Add New Sale for Customer Invoice/receipt(Email Template Functionality)");
        logger().log(LogStatus.PASS, "Add New Sale for Customer Invoice/receipt(Email Template Functionality)", "Add New Sale for Customer Invoice/receipt(Email Template Functionality)");

        //Step-5 : Verify Email Details for Customer Invoice/receipt(Email Template Functionality)
        Assert.assertTrue(emailTemplates.readEmail(), "Verify Email Details for Customer Invoice/receipt(Email Template Functionality)");
        Assert.assertTrue(emailTemplates.verifyEmail(), "Verify Email Details for Customer Invoice/receipt(Email Template Functionality)");
        logger().log(LogStatus.PASS, "Verify Email Details for Customer Invoice/receipt(Email Template Functionality)", "Verify Email Details for Customer Invoice/receipt(Email Template Functionality)");
        logger().log(LogStatus.PASS, "Receive Subject :", EmailTemplates.receivingSubject);
        logger().log(LogStatus.PASS, "Hike POS Subject :", EmailTemplates.subject);
    }


    /**
     * @author Vidhi Chapanera
     * @since 04 March 2021
     */
    @Test(
            groups = {"Core",
                      "HIKE-POS",
                      "Store Setup",
                      "https://my.hikeup.com/"},
            priority = 1,
            description = "HIKE-41 : Verify Customer Quote(Email Template Functionality)"
    )
    @Owner("Vidhi Chapanera")
    @Feature("Feature : Store Setup")
    @Severity(SeverityLevel.NORMAL)
    public void e_verifyCustomerQuoteEmailTemplate_41() throws IOException {

        if (flag > 0) {
            logger().getTest().setName("HIKE-41 : Verify Customer Quote(Email Template Functionality)");
            logger().assignCategory("Store Setup");
            logger().assignAuthor("Vidhi Chapanera");
        }

        CenterlizePO centerlizePO = PageFactory.initElements(driver, CenterlizePO.class);
        EmailTemplates emailTemplates = PageFactory.initElements(driver, EmailTemplates.class);
        StoreSetup storeSetup = PageFactory.initElements(driver, StoreSetup.class);
        General general = PageFactory.initElements(driver, General.class);

        //pre-condition
        //new LoginTC(driver,0).a_verifyLoginFunctionality_03();

        logger().log(LogStatus.INFO, "Execution start for HIKE-41");

        //Step-1 : click on store setup button
        Assert.assertTrue(storeSetup.clickOnStoreSetupButton(), "click on store setup button");
        logger().log(LogStatus.PASS, "click on store setup button", "store setup button clicked");

        //Step-2 : click on General button
        Assert.assertTrue(centerlizePO.clickOnButton(general.getGeneralButton()), "click on General button");
        logger().log(LogStatus.PASS, "click on General button", "General button clicked");

        //Step-3 : Activate quote issuance feature
        Assert.assertTrue(centerlizePO.clickOnButton(general.getQuoteIssuance()), "Activate quote issuance feature");
        Assert.assertTrue(centerlizePO.clickOnButton(PageFactory.initElements(driver, Users.class).getSaveButton()), "Activate quote issuance feature");
        centerlizePO.sleepFor(10);
        logger().log(LogStatus.PASS,"Activate quote issuance feature","Activate quote issuance feature");

        //Step-4 : click on Email Templates button
        Assert.assertTrue(centerlizePO.clickOnButton(emailTemplates.getEmailTemplateButton()), "click on Email Templates button");
        logger().log(LogStatus.PASS, "click on Email Templates button", "Email Templates button clicked");

        //Step-5 : Verify Customer Quote (Email Template Functionality)
        Assert.assertTrue(emailTemplates.editEmailTemplate(emailTemplates.getCustomerQuoteEmailTemplate()), "Verify Customer Quote(Email Template Functionality)");
        logger().log(LogStatus.PASS, "Verify Customer Quote(Email Template Functionality)", "Verify Customer Quote(Email Template Functionality)");

        //Step-6 : Add New Sale for Customer Quote(Email Template Functionality)
        Assert.assertTrue(emailTemplates.addNewSaleCustomerQuoteEmailTemplate(), "Add New Sale for Customer Quote(Email Template Functionality)");
        logger().log(LogStatus.PASS, "Add New Sale for Customer Quote(Email Template Functionality)", "Add New Sale for Customer Quote(Email Template Functionality)");

        //Step-7 : Verify Email Details for Customer Quote(Email Template Functionality)
        Assert.assertTrue(emailTemplates.readEmail(), "Verify Email Details for Customer Quote(Email Template Functionality)");
        Assert.assertTrue(emailTemplates.verifyEmail(), "Verify Email Details for Customer Quote(Email Template Functionality)");
        Assert.assertTrue(storeSetup.clickOnStoreSetupButton(), "click on store setup button");
        Assert.assertTrue(centerlizePO.clickOnButton(general.getGeneralButton()), "click on General button");
        Assert.assertTrue(centerlizePO.clickOnButton(general.getQuoteIssuance()), "Activate quote issuance feature");
        Assert.assertTrue(centerlizePO.clickOnButton(PageFactory.initElements(driver, Users.class).getSaveButton()), "Activate quote issuance feature");
        centerlizePO.sleepFor(10);
        logger().log(LogStatus.PASS, "Verify Email Details for Customer Quote(Email Template Functionality)", "Verify Email Details for Customer Quote(Email Template Functionality)");
        logger().log(LogStatus.PASS, "Receive Subject :", EmailTemplates.receivingSubject);
        logger().log(LogStatus.PASS, "Hike POS Subject :", EmailTemplates.subject);
    }


    /**
     * @author Vidhi Chapanera
     * @since 04 March 2021
     */
    @Test(
            groups = {"Core",
                      "HIKE-POS",
                      "Store Setup",
                      "https://my.hikeup.com/"},
            priority = 1,
            description = "HIKE-42 : Verify Inventory Transfer(Email Template Functionality)"
    )
    @Owner("Vidhi Chapanera")
    @Feature("Feature : Store Setup")
    @Severity(SeverityLevel.NORMAL)
    public void f_verifyInventoryTransferEmailTemplate_42() throws IOException {

        if (flag > 0) {
            logger().getTest().setName("HIKE-42 : Verify Inventory Transfer(Email Template Functionality)");
            logger().assignCategory("Store Setup");
            logger().assignAuthor("Vidhi Chapanera");
        }

        CenterlizePO centerlizePO = PageFactory.initElements(driver, CenterlizePO.class);
        EmailTemplates emailTemplates = PageFactory.initElements(driver, EmailTemplates.class);
        StoreSetup storeSetup = PageFactory.initElements(driver, StoreSetup.class);

        //pre-condition
        //new LoginTC(driver,0).a_verifyLoginFunctionality_03();

        logger().log(LogStatus.INFO, "Execution start for HIKE-42");

        //Step-1 : click on store setup button
        Assert.assertTrue(storeSetup.clickOnStoreSetupButton(), "click on store setup button");
        logger().log(LogStatus.PASS, "click on store setup button", "store setup button clicked");

        //Step-2 : click on Email Templates button
        Assert.assertTrue(centerlizePO.clickOnButton(emailTemplates.getEmailTemplateButton()), "click on Email Templates button");
        logger().log(LogStatus.PASS, "click on Email Templates button", "Email Templates button clicked");

        //Step-3 : Verify Inventory Transfer (Email Template Functionality)
        Assert.assertTrue(emailTemplates.editEmailTemplate(emailTemplates.getInventoryTransferEmailTemplate()), "Verify Inventory Transfer(Email Template Functionality)");
        logger().log(LogStatus.PASS, "Verify Inventory Transfer(Email Template Functionality)", "Verify Inventory Transfer(Email Template Functionality)");

        //Step-4 : Transfer Inventory and mail(Email Template Functionality)
        Assert.assertTrue(emailTemplates.transferInventoryEmailTemplate(), "Transfer Inventory and mail(Email Template Functionality)");
        logger().log(LogStatus.PASS, "Transfer Inventory and mail(Email Template Functionality)", "Transfer Inventory and mail(Email Template Functionality)");

        //Step-5 : Verify Email Details for  Inventory Transfer(Email Template Functionality)
        Assert.assertTrue(emailTemplates.readEmail(), "Verify Email Details for  Inventory Transfer(Email Template Functionality)");
        Assert.assertTrue(emailTemplates.verifyEmail(), "Verify Email Details for  Inventory Transfer(Email Template Functionality)");
        logger().log(LogStatus.PASS, "Verify Email Details for  Inventory Transfer(Email Template Functionality)", "Verify Email Details for Customer Quote(Email Template Functionality)");
        logger().log(LogStatus.PASS, "Receive Subject :", EmailTemplates.receivingSubject);
        logger().log(LogStatus.PASS, "Hike POS Subject :", EmailTemplates.subject);
    }


    /**
     * @author Vidhi Chapanera
     * @since 05 March 2021
     */
    @Test(
            groups = {"Core",
                      "HIKE-POS",
                      "Store Setup",
                      "https://my.hikeup.com/"},
            priority = 1,
            description = "HIKE-43 : Verify Purchase order to supplier(Email Template Functionality)"
    )
    @Owner("Vidhi Chapanera")
    @Feature("Feature : Store Setup")
    @Severity(SeverityLevel.NORMAL)
    public void g_verifyPurchaseOrderToSupplierEmailTemplate_43() throws IOException {

        if (flag > 0) {
            logger().getTest().setName("HIKE-43 : Verify Purchase order to supplier(Email Template Functionality)");
            logger().assignCategory("Store Setup");
            logger().assignAuthor("Vidhi Chapanera");
        }

        CenterlizePO centerlizePO = PageFactory.initElements(driver, CenterlizePO.class);
        EmailTemplates emailTemplates = PageFactory.initElements(driver, EmailTemplates.class);
        StoreSetup storeSetup = PageFactory.initElements(driver, StoreSetup.class);

        //pre-condition
        //new LoginTC(driver,0).a_verifyLoginFunctionality_03();

        logger().log(LogStatus.INFO, "Execution start for HIKE-43");

        //Step-1 : click on store setup button
        Assert.assertTrue(storeSetup.clickOnStoreSetupButton(), "click on store setup button");
        logger().log(LogStatus.PASS, "click on store setup button", "store setup button clicked");

        //Step-2 : click on Email Templates button
        Assert.assertTrue(centerlizePO.clickOnButton(emailTemplates.getEmailTemplateButton()), "click on Email Templates button");
        logger().log(LogStatus.PASS, "click on Email Templates button", "Email Templates button clicked");

        //Step-3 : Verify Purchase order to supplier(Email Template Functionality)
        Assert.assertTrue(emailTemplates.editEmailTemplate(emailTemplates.getPurchaseOrderToSupplierEmailTemplate()), "Verify Purchase order to supplier(Email Template Functionality)");
        logger().log(LogStatus.PASS, "Verify Purchase order to supplier(Email Template Functionality)", "Verify Purchase order to supplier(Email Template Functionality)");

        //Step-4 : Add new Purchase order(Email Template Functionality)
        Assert.assertTrue(emailTemplates.addNewPurchaseOrder(), "Add new Purchase order(Email Template Functionality)");
        logger().log(LogStatus.PASS, "Add new Purchase order(Email Template Functionality)", "Add new Purchase order(Email Template Functionality)");

        //Step-5 : Verify Email Details for  Purchase order to supplier(Email Template Functionality)
        Assert.assertTrue(emailTemplates.readEmail(), "Verify Email Details for  Purchase order to supplier(Email Template Functionality)");
        Assert.assertTrue(emailTemplates.verifyEmailDetails(), "Verify Email Details for  Purchase order to supplier(Email Template Functionality)");
        logger().log(LogStatus.PASS, "Verify Email Details for  Purchase order to supplier(Email Template Functionality)", "Verify Email Details for  Purchase order to supplier(Email Template Functionality)");
        logger().log(LogStatus.PASS, "Receive Subject :", EmailTemplates.receivingSubject);
        logger().log(LogStatus.PASS, "Hike POS Subject :", EmailTemplates.subject);

    }


    /**
     * @author Vidhi Chapanera
     * @since 05 March 2021
     */
    @Test(
            groups = {"Core",
                      "HIKE-POS",
                      "Store Setup",
                      "https://my.hikeup.com/"},
            priority = 1,
            description = "HIKE-46 : Verify Welcome email to new employee(Email Template Functionality)"
    )
    @Owner("Vidhi Chapanera")
    @Feature("Feature : Store Setup")
    @Severity(SeverityLevel.NORMAL)
    public void h_verifyWelcomeEmailToNewEmployeeEmailTemplate_46() throws IOException {

        if (flag > 0) {
            logger().getTest().setName("HIKE-46 : Verify Welcome email to new employee(Email Template Functionality)");
            logger().assignCategory("Store Setup");
            logger().assignAuthor("Vidhi Chapanera");
        }

        CenterlizePO centerlizePO = PageFactory.initElements(driver, CenterlizePO.class);
        EmailTemplates emailTemplates = PageFactory.initElements(driver, EmailTemplates.class);
        StoreSetup storeSetup = PageFactory.initElements(driver, StoreSetup.class);

        //pre-condition
        //new LoginTC(driver,0).a_verifyLoginFunctionality_03();

        logger().log(LogStatus.INFO, "Execution start for HIKE-46");

        //Step-1 : click on store setup button
        Assert.assertTrue(storeSetup.clickOnStoreSetupButton(), "click on store setup button");
        logger().log(LogStatus.PASS, "click on store setup button", "store setup button clicked");

        //Step-2 : click on Email Templates button
        Assert.assertTrue(centerlizePO.clickOnButton(emailTemplates.getEmailTemplateButton()), "click on Email Templates button");
        logger().log(LogStatus.PASS, "click on Email Templates button", "Email Templates button clicked");

        //Step-3 : Verify Welcome email to new employee(Email Template Functionality)
        Assert.assertTrue(emailTemplates.editEmailTemplate(emailTemplates.getWelcomeEmailToNewEmployeee()), "Verify Welcome email to new employee(Email Template Functionality)");
        logger().log(LogStatus.PASS, "Verify Welcome email to new employee(Email Template Functionality)", "Verify Welcome email to new employee(Email Template Functionality)");

        //Step-4 : Add User for Welcome email to new employee(Email Template Functionality)
        Assert.assertTrue(emailTemplates.addUser(), "Add User for Welcome email to new employee(Email Template Functionality)");
        logger().log(LogStatus.PASS, "Add User for Welcome email to new employee(Email Template Functionality)", "Add User for Welcome email to new employee(Email Template Functionality)");

        //Step-5 : Verify Email Details for Welcome email to new employee(Email Template Functionality)
        Assert.assertTrue(emailTemplates.readEmail(), "Verify Email Details for Welcome email to new employee(Email Template Functionality)");
        Assert.assertTrue(emailTemplates.verifyEmail(), "Verify Email Details for Welcome email to new employee(Email Template Functionality)");
        logger().log(LogStatus.PASS, "Verify Email Details for Welcome email to new employee(Email Template Functionality)", "Verify Email Details for Welcome email to new employee(Email Template Functionality)");
        logger().log(LogStatus.PASS, "Receive Subject :", EmailTemplates.receivingSubject);
        logger().log(LogStatus.PASS, "Hike POS Subject :", EmailTemplates.subject);
    }


    /**
     * @author Vidhi Chapanera
     * @since 27 August 2021
     */
    @Test(
            groups = {"Core",
                      "HIKE-POS",
                      "Store Setup",
                      "https://my.hikeup.com/"},
            priority = 1,
            description = "HIKE-75 : Verify Gift card to recipient(Email Template Functionality)"
    )
    @Owner("Vidhi Chapanera")
    @Feature("Feature : Store Setup")
    @Severity(SeverityLevel.NORMAL)
    public void i_verifyGiftCardToRecipientEmailTemplate_75() throws IOException {

        if (flag > 0) {
            logger().getTest().setName("HIKE-75 : Verify Gift card to recipient(Email Template Functionality)");
            logger().assignCategory("Store Setup");
            logger().assignAuthor("Vidhi Chapanera");
        }

        CenterlizePO centerlizePO = PageFactory.initElements(driver, CenterlizePO.class);
        EmailTemplates emailTemplates = PageFactory.initElements(driver, EmailTemplates.class);
        StoreSetup storeSetup = PageFactory.initElements(driver, StoreSetup.class);

        //pre-condition
//        new LoginTC(driver,0).a_verifyLoginFunctionalitydynamic_05();

        logger().log(LogStatus.INFO, "Execution start for HIKE-75");

        //Step-1 : click on store setup button
        Assert.assertTrue(storeSetup.clickOnStoreSetupButton(), "click on store setup button");
        logger().log(LogStatus.PASS, "click on store setup button", "store setup button clicked");

        //Step-2 : click on Email Templates button
        Assert.assertTrue(centerlizePO.clickOnButton(emailTemplates.getEmailTemplateButton()), "click on Email Templates button");
        logger().log(LogStatus.PASS, "click on Email Templates button", "Email Templates button clicked");

        //Step-3 : Verify Gift card to recipient template
        Assert.assertTrue(emailTemplates.editEmailTemplateForGiftCard(emailTemplates.getGiftCardtoRecipient()), "Gift card to recipient template");
        logger().log(LogStatus.PASS, "Gift card to recipient template", "Gift card to recipient template");

        //Step-4 : Add Gift card  for Gift card to recipient (Email Template Functionality)
        Assert.assertTrue(emailTemplates.saleGiftCard("1864"), "Add Gift card  for Gift card to recipient (Email Template Functionality)");
        logger().log(LogStatus.PASS, "Add Gift card  for Gift card to recipient (Email Template Functionality)", "Add Gift card  for Gift card to recipient (Email Template Functionality)");

        //Step-5 : Verify Email Details for Welcome email to new employee(Email Template Functionality)
        Assert.assertTrue(emailTemplates.readEmailforGiftcard(), "Verify Email Details for Welcome email to new employee(Email Template Functionality)");
        Assert.assertTrue(emailTemplates.verifyEmailforGiftCard(), "Verify Email Details for Welcome email to new employee(Email Template Functionality)");
        logger().log(LogStatus.PASS, "Verify Email Details for Welcome email to new employee(Email Template Functionality)", "Verify Email Details for Welcome email to new employee(Email Template Functionality)");
        logger().log(LogStatus.PASS, "Receive Subject :", EmailTemplates.receivingSubject);
        logger().log(LogStatus.PASS, "Hike POS Subject :", EmailTemplates.subject);
    }
}