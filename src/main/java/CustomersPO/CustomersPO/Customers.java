package CustomersPO.CustomersPO;

import CommonPO.BasePage;
import CommonPO.CenterlizePO;
import CustomersPO.GroupsPO.Groups;
import PointofSalePO.CashRegisterPO.CashRegister;
import PointofSalePO.PointofSale;
import PointofSalePO.ProcessSalePO.ProcessSale;
import ProductsPO.GiftCardsPO.GiftCards;
import StoreSetupPO.GeneralPO.General;
import StoreSetupPO.GeneralPO.General1;
import StoreSetupPO.LoyaltyPointsPO.LoyaltyPoints;
import StoreSetupPO.OutletsAndRegistersPO.OutletsAndRegisters;
import StoreSetupPO.StoreSetup;
import UsersPO.UserPO.Users;
import io.qameta.allure.Step;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import javax.mail.*;
import javax.mail.internet.ContentType;
import javax.mail.internet.MimeMultipart;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;

/**
 * @author Vidhi Chapanera
 * @date 08 February 2021
 */
public class Customers extends BasePage {

    public WebDriver driver;

    public static String taxExexmptCustomerName = "";
    public static String testOutletName = "";
    public static String outletName = "testLine";
    public static String name = "true test";
    public static String testEmailID = "vidhi.hike.99@gmail.com";
    public static String receivingSubject = "";
    private static final Logger log4j = LogManager.getLogger(General1.class);

    {
        BasicConfigurator.configure();
    }

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Customers button
     * @date 08 February 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//span[contains(text(),'Customers')]//parent::a[contains(@class,'auto')]//parent::li//descendant::ul//span[contains(text(),'Customers')]//parent::a"
    )
    WebElement btn_customers;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for import button
     * @date 08 February 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//a[contains(text(),'Import')]"
    )
    WebElement btn_import;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for import Excel button
     * @date 08 February 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//span[contains(@class,'dark')]//input[@type='file']"
    )
    WebElement btn_importexcel;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for continue button
     * @date 08 February 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//button[contains(text(),'Continue')]"
    )
    WebElement btn_continue;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for OK button
     * @date 08 February 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//button[text()='OK']"
    )
    WebElement btn_OK;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Connected & validate button
     * @date 08 February 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//button[contains(text(),'Connected & validate')]"
    )
    WebElement btn_connectedvalidate;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Refresh button
     * @date 08 February 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//button[contains(text(),'Refresh')]"
    )
    WebElement btn_refresh;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for tax exempt check box
     * @date 23 February 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//label[@for='toAllowForTaxExempt']"
    )
    WebElement chk_taxexempt;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for email text box
     * @date 03 March 2021
     */
    @FindBy(
            how = How.ID,
            using = "email"
    )
    WebElement txt_email;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for add customer button
     * @date 05 March 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(@class,'customers-view')]//i[@class='fa fa-plus']//parent::button"
    )
    WebElement btn_addcustomer;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for first name input box
     * @date 05 March 2021
     */
    @FindBy(
            how = How.ID,
            using = "firstName"
    )
    WebElement txt_firstname;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for last name input box
     * @date 05 March 2021
     */
    @FindBy(
            how = How.ID,
            using = "lastName"
    )
    WebElement txt_lastname;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Gender drop down
     * @date 05 March 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//a[@placeholder='Gender']"
    )
    WebElement drpdwn_gender;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for credit input box
     * @date 05 March 2021
     */
    @FindBy(
            how = How.ID,
            using = "creditLimit"
    )
    WebElement txt_credit;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for company input box
     * @date 05 March 2021
     */
    @FindBy(
            how = How.ID,
            using = "company"
    )
    WebElement txt_company;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for customer search input box
     * @date 05 March 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(@class,'customers-view')]//input[@type='search']"
    )
    WebElement txt_customersearch;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for add new customer button
     * @date 02 November 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//button[text()='Add new customer']"
    )
    WebElement btn_addNewCustomer;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Customer profiles by outlet
     * @date 02 November 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//label[@for='enableCustomerMultiOutlet']"
    )
    WebElement chk_CustomerMultiOutlet;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for default outlet
     * @date 02 November 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//label[normalize-space(.)='Sydney Store']"
    )
    WebElement chk_DefaultOutlet;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for ok button
     * @date 02 November 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//button[text()='Ok']"
    )
    WebElement ok_btn;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for bulk payment button
     * @date 31 December 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//button[text()='Bulk payment']"
    )
    WebElement btn_bulkpayment;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for paid to dropdown
     * @date 31 December 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//register-combo-bulk-payment//a"
    )
    WebElement paidtodropdown;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for apply Payment button
     * @date 31 December 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//register-combo-bulk-payment//parent::div//parent::div//following-sibling::div//button[text()='Apply payment']"
    )
    WebElement btn_applypayment;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for email button
     * @date 31 December 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//a[contains(text(),'Email')]"
    )
    WebElement btn_email;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for email input
     * @date 31 December 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//email-tagging-customer//input"
    )
    WebElement txt_emailtaging;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for send button
     * @date 31 December 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//i[contains(@class,'send')]//parent::button"
    )
    WebElement btn_send;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for add new customer button
     * @date 31 December 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//button[normalize-space(.)='Add customer']"
    )
    WebElement btn_addNewCustomer01;


    public Customers(WebDriver driver) {
        this.driver = driver;
    }
    public WebElement getCustomersButton() {
        return btn_customers;
    }
    public WebElement getImportButton() {
        return btn_import;
    }
    public WebElement getImportEXCELButton() {
        return btn_importexcel;
    }
    public WebElement getContinueButton() {
        return btn_continue;
    }
    public WebElement getOKButton() {
        return btn_OK;
    }
    public WebElement getConnectedValidateButton() {
        return btn_connectedvalidate;
    }
    public WebElement getRefreshButton() {
        return btn_refresh;
    }
    public WebElement getTaxExemptCheckbox() {
        return chk_taxexempt;
    }
    public WebElement getEmail() {
        return txt_email;
    }
    public WebElement getAddCustomerButton() {
        return btn_addcustomer;
    }
    public WebElement getFirstName() {
        return txt_firstname;
    }
    public WebElement getLastName() {
        return txt_lastname;
    }
    public WebElement getGenderDropDown() {
        return drpdwn_gender;
    }
    public WebElement getAccountLimit() {
        return txt_credit;
    }
    public WebElement getCompany() {
        return txt_company;
    }
    public WebElement getCustomerSearch() {
        return txt_customersearch;
    }
    public WebElement getAddNewCustomerButton() {
        return btn_addNewCustomer;
    }
    public WebElement getCustomerMultiOutlet() {
        return chk_CustomerMultiOutlet;
    }
    public WebElement getDefaultOutlet() {
        return chk_DefaultOutlet;
    }
    public WebElement getButtonOK() {
        return ok_btn;
    }
    public WebElement getBulkPaymnetButton() {
        return btn_bulkpayment;
    }
    public WebElement getPaidToDropDown() {
        return paidtodropdown;
    }
    public WebElement getApplyPaymentButton() {
        return btn_applypayment;
    }
    public WebElement getEmailButton() {
        return btn_email;
    }
    public WebElement getEmailTaging() {
        return txt_emailtaging;
    }
    public WebElement getSendButton() {
        return btn_send;
    }
    public WebElement getAddNewCustomerButton01() {
        return btn_addNewCustomer01;
    }


    /**
     * @return
     * @throws Exception
     * @author Vidhi Chapanera
     * @date 08 February 2021
     * @discription this method is use to Import Customers using Import Button
     */
    @Step("Import Customers using Import Button")
    public boolean importCustomersUsingImportButton() {
        try {
            sleepFor(5);
            CenterlizePO centerlizePO = PageFactory.initElements(driver,CenterlizePO.class);
            centerlizePO.clickOnButton(getImportButton());
            sleepFor(1);
            getImportEXCELButton().sendKeys(System.getProperty("user.dir")+"\\xlsx File\\Customer.xlsx");
            sleepFor(3);
            centerlizePO.clickOnButton(getContinueButton());
            sleepFor(1);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, LoyaltyPoints.class).getYesButton());
            sleepFor(1);
            centerlizePO.clickOnButton(getOKButton());
            sleepFor(3);
            centerlizePO.clickOnButton(getConnectedValidateButton());
            sleepFor(3);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    /**
     * @return
     * @throws Exception
     * @author Vidhi Chapanera
     * @date 08 February 2021
     * @discription this method is use to verify customers are imported successfully
     */
    @Step("verify customers are imported successfully")
    public boolean verifyCustomersAreImported() {
        try {
            sleepFor(5);
            CenterlizePO centerlizePO = PageFactory.initElements(driver,CenterlizePO.class);
            while (true){
                centerlizePO.clickOnButton(getRefreshButton());
                WebElement e = new WebDriverWait(driver,60).
                        until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table[@id='ImportDataTable']//tbody//tr[1]//td[2]")));
                String record = e.getText();
                WebElement e1 = new WebDriverWait(driver,60).
                        until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table[@id='ImportDataTable']//tbody//tr[1]//td[4]")));
                String result = e1.getText();
                if (result.contains(record + " " + "Imported Successfully")){
                    break;
                }
            }
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }



    /**
     * @return
     * @throws Exception
     * @author Vidhi Chapanera
     * @date 23 February 2021
     * @discription this method is use to creating a new Tax exempt customer
     */
    @Step("creating a new Tax exempt customer")
    public boolean creatingNewTaxExemptCustomer() {
        CenterlizePO centerlizePO = PageFactory.initElements(driver, CenterlizePO.class);
        try {
            sleepFor(5);
            List<WebElement> customerlist = new WebDriverWait(driver,60).until
                    (ExpectedConditions.presenceOfAllElementsLocatedBy
                            (By.xpath("//table[@id='CustomersTable']//tbody//tr//td[2]//span")));
            taxExexmptCustomerName = customerlist.get(customerlist.size()-1).getText();
            sleepFor(1);
            customerlist.get(customerlist.size()-1).click();
            sleepFor(2);
            centerlizePO.clickOnButton( PageFactory.initElements(driver, Groups.class).getEditButton());
            sleepFor(5);
            if (getTaxExemptCheckbox().findElement(By.xpath("//parent::div//input")).getAttribute("class").contains("ng-empty")) {
                getTaxExemptCheckbox().click();
            }
            sleepFor(1);
            centerlizePO.clickOnButton(PageFactory.initElements(driver,Groups.class).getSaveButton());
            sleepFor(5);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }



    /**
     * @return
     * @throws Exception
     * @author Vidhi Chapanera
     * @date 23 February 2021
     * @discription this method is use to Verify customer is tax exempted during checkout by  >> add new sale
     */
    @Step("Verify customer is tax exempted during checkout by  >> add new sale")
    public boolean verifyCustomerTaxExemptDuringCheckout() {
        CenterlizePO centerlizePO = PageFactory.initElements(driver, CenterlizePO.class);
        try {
            sleepFor(5);
            PageFactory.initElements(driver, PointofSale.class).clickOnPointOfSaleButtonn();
            centerlizePO.clickOnButton(PageFactory.initElements(driver, ProcessSale.class).getProcessSaleButton());
            sleepFor(20);
            PageFactory.initElements(driver, ProcessSale.class).getSearchBar().sendKeys("Demo Skirt");
            sleepFor(3);
            Actions actions = new Actions(driver);
            actions.sendKeys(Keys.TAB).build().perform();
            sleepFor(1);
            sleepFor(1);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, ProcessSale.class).getAddCustomerButton());
            centerlizePO.enterDataUsingSendkeys(PageFactory.initElements(driver, ProcessSale.class).getAddCustomer(),taxExexmptCustomerName);
            sleepFor(1);
            actions.sendKeys(Keys.TAB).build().perform();
            sleepFor(2);
            WebElement taxElement  = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//div[@class='detail-section']//table//tbody//tr//td[text()='Tax']//following-sibling::td")));
            String taxPrice = taxElement.getText();
                float taxPriceF = Float.parseFloat(taxPrice.substring(1));
            if (taxPriceF==0.00){
                System.out.println(" ");
            }
            sleepFor(3);
            List<WebElement> e = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy
                            (By.xpath("//div[contains(@class,'sell-item-list')]//a[not(contains(@class,'ng-hide'))]")));
            for (int i=0;i<e.size();i++){
                sleepFor(1);
                e.get(i).click();
            }
            sleepFor(3);
            WebElement customer = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@class='customer-delete']")));
            customer.click();
            sleepFor(2);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }



    /**
     * @return
     * @throws Exception
     * @author Vidhi Chapanera
     * @date 02 November 2021
     * @discription this method is use to Add Customer From Process sale page And Verify that could not uncheck default Selected Outlet
     */
    @Step("Add Customer From Process sale page And Verify that could not uncheck default Selected Outlet")
    public boolean verifyCouldNotUncheckDefaultSelectedOutlet() {
        CenterlizePO centerlizePO = PageFactory.initElements(driver,CenterlizePO.class);

        try {
            sleepFor(5);
            if (driver.findElement(By.name("customerCreateOrEditForm")).isDisplayed()){
                Actions actions = new Actions(driver);
                sleepFor(2);
                WebElement e = new WebDriverWait(driver,60).
                        until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'Outlets') and contains(@class,'uppercase')]")));
                actions.moveToElement(e).build().perform();
                centerlizePO.clickOnButton(getDefaultOutlet());
                if (driver.findElement(By.xpath("//div[text()='You can not create a customer invisible to the current outlet.']")).isDisplayed()){
                    centerlizePO.clickOnButton(getButtonOK());
                    Actions action = new Actions(driver);
                    action.sendKeys(Keys.ESCAPE).build().perform();
                }else{
                    return false;
                }
            }else {
                return false;
            }
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }finally {
            PageFactory.initElements(driver, StoreSetup.class).clickOnStoreSetupButton();
            sleepFor(3);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, OutletsAndRegisters.class).getOutletsAndRegisters());
            sleepFor(5);
            WebElement editbtn = new WebDriverWait(driver,50)
                    .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='"+outletName+"']//parent::td//parent::tr//a[text()='Edit']")));
            JavascriptExecutor executor = (JavascriptExecutor)driver;
            executor.executeScript("arguments[0].click();", editbtn);
            sleepFor(10);
            Actions actions = new Actions(driver);
            actions.moveToElement(PageFactory.initElements(driver,CashRegister.class).getDeleteOutLet()).click().build().perform();
            sleepFor(5);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Customers.class).getContinueButton());

            /**
             * @tag Added
             */
            centerlizePO.clickOnButton(PageFactory.initElements(driver,CashRegister.class).getSecondOption());
            centerlizePO.clickOnButton(PageFactory.initElements(driver,CashRegister.class).getagainContinueButton());///
            sleepFor(30);
        }
    }


    /**
     * @author Vidhi Chapanera
     * @date 28 October 2021
     * @return
     * @throws Exception
     * @discription this method is used to select Customer profiles by outlet Option
     */
    @Step("select Customer profiles by outlet Option")
    public boolean selectCustomerProfileByOutletOption() {
        try {
            getDefaultOutletName();
            sleepFor(3);
            CenterlizePO centerlizePO = PageFactory.initElements(driver,CenterlizePO.class);
            PageFactory.initElements(driver, StoreSetup.class).clickOnStoreSetupButton();
            centerlizePO.clickOnButton(PageFactory.initElements(driver, General.class).getGeneralButton());
            sleepFor(3);
            Actions actions = new Actions(driver);
            actions.moveToElement(getCustomerMultiOutlet()).click().build().perform();
            sleepFor(2);
            actions.moveToElement(PageFactory.initElements(driver, Users.class).getSaveButton()).build().perform();
            PageFactory.initElements(driver, Users.class).getSaveButton().click();
            sleepFor(13);
            return true;
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }


    /**
     * @return
     * @throws Exception
     * @author Vidhi Chapanera
     * @date 18 March 2021
     * @discription this method is use to get default outlet name
     */
    @Step("get default outlet name")
    public boolean getDefaultOutletName(){
        CenterlizePO centerlizePO = PageFactory.initElements(driver,CenterlizePO.class);
        try {
            sleepFor(3);
            PageFactory.initElements(driver, StoreSetup.class).clickOnStoreSetupButton();
            centerlizePO.clickOnButton(PageFactory.initElements(driver, OutletsAndRegisters.class).getOutletsAndRegisters());
            sleepFor(5);
            List<WebElement> outlet = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//tbody//tr[1]//td[1]//a")));
            testOutletName = outlet.get(0).getText();
            System.out.println(testOutletName+"....................");
            if(outlet.size()==1){
                PageFactory.initElements(driver, StoreSetup.class).clickOnStoreSetupButton();
                centerlizePO.clickOnButton(PageFactory.initElements(driver, General.class).getGeneralButton());
                sleepFor(7);
                try{
                    if(getCustomerMultiOutlet().isDisplayed()) {
                        return false;
                    }
                }catch (Exception e){
                    centerlizePO.clickOnButton(PageFactory.initElements(driver, OutletsAndRegisters.class).getOutletsAndRegisters());
                    sleepFor(5);
                    centerlizePO.clickOnButton(PageFactory.initElements(driver, OutletsAndRegisters.class).getAddOutlet());
                    sleepFor(1);
                    centerlizePO.enterDataUsingSendkeys(PageFactory.initElements(driver, OutletsAndRegisters.class).getOutletName(),outletName);
                    centerlizePO.enterDataUsingSendkeys(PageFactory.initElements(driver, OutletsAndRegisters.class).getEmail(),"test.Outlet@yopmail.com");
                    sleepFor(1);
                    PageFactory.initElements(driver, OutletsAndRegisters.class).getSaveButton().click();
                    sleepFor(8);
                    centerlizePO.clickOnButton(PageFactory.initElements(driver, OutletsAndRegisters.class).getLinkAllRadioButton());
                    centerlizePO.clickOnButton(PageFactory.initElements(driver, OutletsAndRegisters.class).getContinueButton());
                    sleepFor(5);
                }
            }else {
                return false;
            }
            return true;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return true;
        }
    }


    /**
     * @return
     * @throws Exception
     * @author Vidhi Chapanera
     * @date 31 December 2021
     * @discription this method is use to create customer
     */
    @Step("create customer")
    public boolean createCustomer(){
        CenterlizePO centerlizePO = PageFactory.initElements(driver,CenterlizePO.class);
        try {
            sleepFor(3);
            getFirstName().sendKeys(name.split(" ")[0]);
            sleepFor(1);
            getLastName().sendKeys(name.split(" ")[1]);
            sleepFor(2);
            getAccountLimit().sendKeys("50000");
            sleepFor(2);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, LoyaltyPoints.class).getSaveButton());
            sleepFor(5);
            return true;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return true;
        }
    }



    /**
     * @return
     * @throws Exception
     * @author Vidhi Chapanera
     * @date 31 December 2021
     * @discription this method is use to create on account sale
     */
    @Step("create on account sale")
    public boolean createOnAccountSale(){
        CenterlizePO centerlizePO = PageFactory.initElements(driver,CenterlizePO.class);
        try {
            sleepFor(3);
            PageFactory.initElements(driver, PointofSale.class).clickOnPointOfSaleButtonn();
            centerlizePO.clickOnButton(PageFactory.initElements(driver, ProcessSale.class).getProcessSaleButton());
            sleepFor(5);
            sleepFor(15);
            for (int i=0;i<3;i++){
                PageFactory.initElements(driver, ProcessSale.class).getSearchBar().sendKeys("Demo skirt");
                sleepFor(2);
                Actions actions = new Actions(driver);
                actions.sendKeys(Keys.TAB).build().perform();
                sleepFor(1);
                centerlizePO.clickOnButton(PageFactory.initElements(driver, ProcessSale.class).getAddCustomerButton());
                centerlizePO.enterDataUsingSendkeys(PageFactory.initElements(driver, ProcessSale.class).getAddCustomer(),name);
                sleepFor(1);
                actions.sendKeys(Keys.TAB).build().perform();
                sleepFor(2);
                centerlizePO.clickOnButton(PageFactory.initElements(driver, ProcessSale.class).getPayButton());
                centerlizePO.clickOnButton(PageFactory.initElements(driver, ProcessSale.class).getOnAccountButton());
                centerlizePO.clickOnButton(PageFactory.initElements(driver, GiftCards.class).getYesButton());
                sleepFor(3);
                String mainWindowHandle = driver.getWindowHandle();
                Set<String> allWindowHandles = driver.getWindowHandles();
                Iterator<String> iterator = allWindowHandles.iterator();
                while (iterator.hasNext()) {
                    String ChildWindow = iterator.next();
                    if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
                        driver.switchTo().window(ChildWindow);
                        WebElement text = new WebDriverWait(driver,60).until(ExpectedConditions.presenceOfElementLocated(By.tagName("print-preview-app")));
                        Actions actions1 = new Actions(driver);
                        actions1.sendKeys(Keys.TAB).build().perform();
                        actions1.sendKeys(Keys.ENTER).build().perform();
                    }
                }
                sleepFor(2);
                driver.switchTo().window(mainWindowHandle);
                sleepFor(1);
                centerlizePO.clickOnButton(PageFactory.initElements(driver, ProcessSale.class).getAddNewSaleButton());
                sleepFor(5);
            }
            return true;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return true;
        }
    }



    /**
     * @return
     * @throws Exception
     * @author Vidhi Chapanera
     * @date 31 December 2021
     * @discription this method is use to create bulk payment
     */
    @Step("create bulk payment")
    public boolean createBulkPayment(){
        CenterlizePO centerlizePO = PageFactory.initElements(driver,CenterlizePO.class);
        try {
            sleepFor(3);
            PageFactory.initElements(driver, CustomersPO.Customers.class).clickOnCustomersButton();
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Customers.class).getCustomersButton());
            sleepFor(5);
            WebElement e = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//table[@id='CustomersTable']//tr//td[2]//span[contains(text(),'"+name.split(" ")[0]+"')]")));
            e.click();
            sleepFor(2);
            centerlizePO.clickOnButton(getBulkPaymnetButton());
            centerlizePO.clickOnButton(getPaidToDropDown());
            sleepFor(5);
            WebElement register = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//register-combo-bulk-payment//a//following-sibling::div//li//ul//li//div//div")));
            register.click();
            centerlizePO.clickOnButton(getApplyPaymentButton());
            sleepFor(9);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, ProcessSale.class).getCashButton());
            sleepFor(9);
            String mainWindowHandle = driver.getWindowHandle();
            Set<String> allWindowHandles = driver.getWindowHandles();
            Iterator<String> iterator = allWindowHandles.iterator();
            while (iterator.hasNext()) {
                String ChildWindow = iterator.next();
                if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
                    driver.switchTo().window(ChildWindow);
                    WebElement text = new WebDriverWait(driver,60).until(ExpectedConditions.presenceOfElementLocated(By.tagName("print-preview-app")));
                    Actions actions1 = new Actions(driver);
                    actions1.sendKeys(Keys.TAB).build().perform();
                    actions1.sendKeys(Keys.ENTER).build().perform();
                }
            }
            sleepFor(2);
            driver.switchTo().window(mainWindowHandle);
            sleepFor(1);
            centerlizePO.clickOnButton(getEmailButton());
            sleepFor(3);
            getEmailTaging().sendKeys(testEmailID);
            sleepFor(2);
            getSendButton().click();
            sleepFor(15);
            return true;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return true;
        }
    }


    /**
     * @author Vidhi Chapanera
     * @date 31 December 2021
     * @return
     * @param message
     * @throws Exception
     */
    @Step("message : {0}")
    private String getTextFromMessage(Message message) throws IOException, MessagingException {
        String result = "";
        if (message.isMimeType("text/plain")) {
            result = message.getContent().toString();
        } else if (message.isMimeType("multipart/*")) {
            MimeMultipart mimeMultipart = (MimeMultipart) message.getContent();
            result = getTextFromMimeMultipart(mimeMultipart);
        }
        return result;
    }


    /**
     * @author Vidhi Chapanera
     * @date 31 December 2021
     * @return
     * @param mimeMultipart
     * @throws Exception
     */
    @Step("mimeMultipart : {0}")
    private String getTextFromMimeMultipart(MimeMultipart mimeMultipart) throws IOException, MessagingException {
        int count = mimeMultipart.getCount();
        if (count == 0)
            throw new MessagingException("Multipart with no body parts not supported.");
        boolean multipartAlt = new ContentType(mimeMultipart.getContentType()).match("multipart/alternative");
        if (multipartAlt)
            return getTextFromBodyPart(mimeMultipart.getBodyPart(count - 1));
        String result = "";
        for (int i = 0; i < count; i++) {
            BodyPart bodyPart = mimeMultipart.getBodyPart(i);
            result += getTextFromBodyPart(bodyPart);
        }
        return result;
    }


    /**
     * @author Vidhi Chapanera
     * @date 31 December 2021
     * @return
     * @param bodyPart
     * @throws Exception
     */
    @Step("bodyPart : {0}")
    private String getTextFromBodyPart(BodyPart bodyPart) throws IOException, MessagingException {
        String result = "";
        if (bodyPart.isMimeType("text/plain")) {
            result = (String) bodyPart.getContent();
        } else if (bodyPart.isMimeType("text/html")) {
            String html = (String) bodyPart.getContent();
            result = org.jsoup.Jsoup.parse(html).text();
        } else if (bodyPart.getContent() instanceof MimeMultipart){
            result = getTextFromMimeMultipart((MimeMultipart)bodyPart.getContent());
        }
        return result;
    }


    /**
     * @author Vidhi Chapanera
     * @date 31 December 2021
     * @return
     * @throws Exception
     */
    @Step("read email")
    public boolean readEmail() {
        String receivingHost="imap.gmail.com";
        Properties props2=System.getProperties();
        Session session2=Session.getDefaultInstance(props2, null);
        try {
            Store store=session2.getStore("imaps");
            store.connect(receivingHost,testEmailID, "#Test4196");
            Folder folder=store.getFolder("INBOX");
            folder.open(Folder.READ_ONLY);
            Message message[]=folder.getMessages();
            receivingSubject = message[message.length-1].getSubject();
            folder.close(true);
            store.close();
            return true;
        } catch (Exception e) {
            System.out.println(e.toString());
            System.out.println(e.getMessage());
            return false;
        }
    }


    /**
     * @author Vidhi Chapanera
     * @date 31 December 2021
     * @return
     * @discriptions This Method is used to Verification email is sent or not
     * @throws Exception
     */
    @Step("Verify Email Sent or not")
    public boolean verifyEmailSent() {
        readEmail();
        sleepFor(10);
        Assert.assertTrue(receivingSubject.contains("Batch payment summary"));
        log4j.info("log4j---"+receivingSubject);
        return true;
    }


}