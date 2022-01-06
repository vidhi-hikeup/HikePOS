package IntegrationsPO.XeroPO;

import CommonPO.BasePage;
import CommonPO.CenterlizePO;
import Config.ExcelUtils;
import CreateStorePO.CreateStore;
import CreateStorePO.StoreConstant;
import CustomersPO.CustomersPO.Customers;
import IntegrationsPO.Integrations;
import IntegrationsPO.QuickBooksPO.QuickBooks;
import IntegrationsPO.ShopifyPO.Shopify;
import InventoryPO.Inventory;
import InventoryPO.PurchasesPO.Purchases;
import InventoryPO.SuppliersPO.Suppliers;
import PointofSalePO.CashRegisterPO.CashRegister;
import PointofSalePO.PointofSale;
import PointofSalePO.ProcessSalePO.ProcessSale;
import PointofSalePO.SalesHistoryPO.SalesHistory;
import ProductsPO.ProductsPO.Products;
import ReportingPO.RegisterPO.Register;
import ReportingPO.Reporting;
import StoreSetupPO.LoyaltyPointsPO.LoyaltyPoints;
import StoreSetupPO.StoreSetup;
import UsersPO.Users;
import com.google.common.base.CharMatcher;
import com.relevantcodes.extentreports.LogStatus;
import io.qameta.allure.Step;
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
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * @author Vidhi Chapanera
 * @date 19 April 2021
 */
public class Xero extends BasePage {

    public WebDriver driver;
    public static String verificationCode = "";


    public Xero(WebDriver driver) {
        this.driver = driver;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for xero activate button
     * @date 19 April 2021
     */
        @FindBy(how = How.XPATH, using = "//table//tr//td[contains(text(),'Xero')]//parent::tr//button")
    WebElement btn_Xeroactivate;
    public WebElement getXeroActivate() {
        return btn_Xeroactivate;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for xero username input box
     * @date 19 April 2021
     */
    @FindBy(how = How.NAME, using = "Username")
    WebElement txt_usernamexero;
    public WebElement getXeroUserName() {
        return txt_usernamexero;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for xero Password input box
     * @date 19 April 2021
     */
    @FindBy(how = How.NAME, using = "Password")
    WebElement txt_Passwordxero;
    public WebElement getXeroPassword() {
        return txt_Passwordxero;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for xero login button
     * @date 19 April 2021
     */
    @FindBy(how = How.XPATH, using = "//button[text()='Log in']")
    WebElement btn_login;
    public WebElement getLoginButton() {
        return btn_login;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for xero another auth method button
     * @date 19 April 2021
     */
    @FindBy(how = How.XPATH, using = "//button[text()='Use another authentication method']")
    WebElement btn_anotherauth;
    public WebElement getAnotherAuthenticationMethodButton() {
        return btn_anotherauth;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for xero backup email button
     * @date 19 April 2021
     */
    @FindBy(how = How.XPATH, using = "//button[contains(text(),'Backup email address')]")
    WebElement btn_backupemail;
    public WebElement getBackupEmailButton() {
        return btn_backupemail;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for xero send code button
     * @date 19 April 2021
     */
    @FindBy(how = How.XPATH, using = "//button[contains(text(),'Send code')]")
    WebElement btn_sendcode;
    public WebElement getSendCodeButton() {
        return btn_sendcode;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for xero confirmation code input box
     * @date 19 April 2021
     */
    @FindBy(how = How.XPATH, using = "//div[@id='auth-splashpage']//input")
    WebElement txt_confirmationcode;
    public WebElement getConfirmationCodeText() {
        return txt_confirmationcode;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for xero allow access button
     * @date 19 April 2021
     */
    @FindBy(how = How.ID, using = "approveButton")
    WebElement btn_allowaccess;
    public WebElement getAllowAcessButton() {
        return btn_allowaccess;
    }



    /**
     * @author Vidhi Chapanera
     * @discription this locator is for xero main dropdowm button
     * @date 20 April 2021
     */
    @FindBy(how = How.XPATH, using = "//div[contains(@class,'appmenucontainer')]//button[contains(@class,'xnav')]")
    WebElement xerodropdwn;
    public WebElement getXeroMainDropDown() {
        return xerodropdwn;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for my xero button
     * @date 20 April 2021
     */
    @FindBy(how = How.XPATH, using = "//a[contains(text(),'My Xero')]")
    WebElement btn_myxero;
    public WebElement getMyXeroButton() {
        return btn_myxero;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for xero add another organisation button
     * @date 20 April 2021
     */
    @FindBy(how = How.XPATH, using = "//a[text()='Add a new organisation']")
    WebElement btn_addorganisation;
    public WebElement getAddAnotherOrganisation() {
        return btn_addorganisation;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for xero business name input box
     * @date 20 April 2021
     */
    @FindBy(how = How.XPATH, using = "//label[text()='Business name']//parent::div//input")
    WebElement txt_businessname;
    public WebElement getBusinessName() {
        return txt_businessname;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for xero Industry input box
     * @date 20 April 2021
     */
    @FindBy(how = How.XPATH, using = "//label[text()='Industry']//parent::div//input")
    WebElement txt_Industry;
    public WebElement getIndustry() {
        return txt_Industry;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for xero yes button
     * @date 20 April 2021
     */
    @FindBy(how = How.XPATH, using = "//span[text()='Yes']")
    WebElement btn_yes;
    public WebElement getYesButton() {
        return btn_yes;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for xero start trial button
     * @date 20 April 2021
     */
    @FindBy(how = How.XPATH, using = "//button[text()='Start trial']")
    WebElement btn_starttrial;
    public WebElement getStartTrail() {
        return btn_starttrial;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for xero select organisation button
     * @date 20 April 2021
     */
    @FindBy(how = How.XPATH, using = "//span[contains(text(),'Select')]//parent::button")
    WebElement btn_selectorganisation;
    public WebElement getSelectOrganisation() {
        return btn_selectorganisation;
    }

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for xero approveButton button
     * @date 20 April 2021
     */
    @FindBy(how = How.ID, using = "approveButton")
    WebElement btn_approve;
    public WebElement getapproveButton() {
        return btn_approve;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for xero accounting button
     * @date 20 April 2021
     */
    @FindBy(how = How.XPATH, using = "//button[text()='Accounting']")
    WebElement btn_accounting;
    public WebElement getAccountingButton() {
        return btn_accounting;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for xero accounting button
     * @date 20 April 2021
     */
    @FindBy(how = How.XPATH, using = "//a[text()='Chart of accounts']")
    WebElement btn_chartofaccount;
    public WebElement getChartOfAccount() {
        return btn_chartofaccount;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for xero Import button
     * @date 20 April 2021
     */
    @FindBy(how = How.XPATH, using = "//a[text()='Import']")
    WebElement btn_Import;
    public WebElement getImportButton() {
        return btn_Import;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for xero browse button
     * @date 20 April 2021
     */
    @FindBy(how = How.CSS, using = "input#FileName")
    WebElement btn_browse;
    public WebElement getBrowseButton() {
        return btn_browse;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for xero Import button
     * @date 20 April 2021
     */
    @FindBy(how = How.XPATH, using = "//span[text()='Import']//parent::button")
    WebElement btn_Importxero;
    public WebElement getImportFileButton() {
        return btn_Importxero;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for xero Confirm button
     * @date 20 April 2021
     */
    @FindBy(how = How.XPATH, using = "//span[text()='Confirm']//parent::button")
    WebElement btn_Confirm;
    public WebElement getConfirmButton() {
        return btn_Confirm;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for xero Save button
     * @date 20 April 2021
     */
    @FindBy(how = How.XPATH, using = "//span[text()='Save']//parent::button")
    WebElement btn_Save;
    public WebElement getSaveButton() {
        return btn_Save;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for manage Button
     * @date 20 April 2021
     */
    @FindBy(how = How.XPATH, using = "//table//tr//td[contains(text(),'Xero')]//parent::tr//button[contains(text(),'Manage')]")
    WebElement btn_manage;
    public WebElement getManageButton() {
        return btn_manage;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for sync process log
     * @date 02 April 2021
     */
    @FindBy(how = How.XPATH, using = "//table//tr//td[contains(text(),'Xero')]//parent::tr//a[contains(text(),'Sync process log')]")
    WebElement btn_syncprocesslog;
    public WebElement getSyncProcessLogButton() {
        return btn_syncprocesslog;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for xero Business button
     * @date 21 April 2021
     */
    @FindBy(how = How.XPATH, using = "//button[text()='Business']")
    WebElement btn_Business;
    public WebElement getBusinessButton() {
        return btn_Business;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for xero products and services button
     * @date 21 April 2021
     */
    @FindBy(how = How.XPATH, using = "//a[text()='Products and services']")
    WebElement btn_productservice;
    public WebElement getProductAndServices() {
        return btn_productservice;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for xero new item button
     * @date 21 April 2021
     */
    @FindBy(how = How.XPATH, using = "//div[@id='newItemButton']//span[contains(text(),'+ New Item')]//parent::a")
    WebElement btn_newItem;
    public WebElement getNewItemButton() {
        return btn_newItem;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for xero item code input box
     * @date 21 April 2021
     */
    @FindBy(how = How.XPATH, using = "//label[text()='Item Code']//parent::div//parent::td//input")
    WebElement txt_itemcode;
    public WebElement getItemCode() {
        return txt_itemcode;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for xero item Name input box
     * @date 21 April 2021
     */
    @FindBy(how = How.XPATH, using = "//label[text()='Item Name']//parent::div//parent::td//input")
    WebElement txt_itemname;
    public WebElement getItemName() {
        return txt_itemname;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for xero product save button
     * @date 21 April 2021
     */
    @FindBy(how = How.XPATH, using = "//span[contains(@id,'button-accounts-inventory-save')]//parent::a")
    WebElement btn_proSaveXero;
    public WebElement getProductSaveButtonXero() {
        return btn_proSaveXero;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for xero Purchase orders button
     * @date 21 April 2021
     */
    @FindBy(how = How.XPATH, using = "//a[text()='Purchase orders']")
    WebElement btn_purchaseorder;
    public WebElement getPurchaseorders() {
        return btn_purchaseorder;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for xero new purchase order button
     * @date 21 April 2021
     */
    @FindBy(how = How.XPATH, using = "//span[contains(text(),'+ New Purchase Order')]//parent::a")
    WebElement btn_newPurchaseorder;
    public WebElement getNewPurchaseOrderButton() {
        return btn_newPurchaseorder;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for xero contact input box
     * @date 21 April 2021
     */
    @FindBy(how = How.XPATH, using = "//input[@name='Contact']")
    WebElement txt_contact;
    public WebElement getContact() {
        return txt_contact;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for xero order number input box
     * @date 21 April 2021
     */
    @FindBy(how = How.NAME, using = "DocumentNumber")
    WebElement txt_ordernumber;
    public WebElement getOrderNumber() {
        return txt_ordernumber;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for xero Approve button
     * @date 21 April 2021
     */
    @FindBy(how = How.XPATH, using = "//span[text()='Approve']//parent::a")
    WebElement btn_Approve;
    public WebElement getApprove() {
        return btn_Approve;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for xero Invoices button
     * @date 22 April 2021
     */
    @FindBy(how = How.XPATH, using = "//a[text()='Invoices']")
    WebElement btn_Invoices;
    public WebElement getInvoices() {
        return btn_Invoices;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for xero new Invoices button
     * @date 22 April 2021
     */
    @FindBy(how = How.XPATH, using = "//em//parent::a[contains(text(),'New Invoice')]")
    WebElement btn_newInvoices;
    public WebElement getNewInvoices() {
        return btn_newInvoices;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for xero contact button
     * @date 22 April 2021
     */
    @FindBy(how = How.XPATH, using = "//button[text()='Contacts']")
    WebElement btn_contact;
    public WebElement getcontactButton() {
        return btn_contact;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for xero all contact button
     * @date 22 April 2021
     */
    @FindBy(how = How.XPATH, using = "//a[text()='All contacts']")
    WebElement btn_allcontact;
    public WebElement getAllcontactButton() {
        return btn_allcontact;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for xero add contact button
     * @date 22 April 2021
     */
    @FindBy(how = How.XPATH, using = "//span[text()='Add contact']//parent::a")
    WebElement btn_addContact;
    public WebElement getAddContactButton() {
        return btn_addContact;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for xero contact name input box
     * @date 22 April 2021
     */
    @FindBy(how = How.CSS, using = "#Name")
    WebElement txt_contactname;
    public WebElement getContactName() {
        return txt_contactname;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for xero contact save button
     * @date 22 April 2021
     */
    @FindBy(how = How.XPATH, using = "//span[text()='Save']//parent::a")
    WebElement btn_saveContact;
    public WebElement getSaveContactButton() {
        return btn_saveContact;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Save Button
     * @date 02 April 2021
     */
    @FindBy(how = How.XPATH, using = "//form[@name='xeroSettings']//div[@class='slider-modal-actions']//button[text()='Save']")
    WebElement btn_Xerosave;
    public WebElement getXeroSaveButton() {
        return btn_Xerosave;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Mark as Billed Button
     * @date 23 April 2021
     */
    @FindBy(how = How.XPATH, using = "//span[text()='Mark as Billed']")
    WebElement btn_markasbilled;
    public WebElement getMarkAsBilled() {
        return btn_markasbilled;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for copy PO checkbox
     * @date 23 April 2021
     */
    @FindBy(how = How.XPATH, using = "//label[contains(text(),'Copy purchase order to a draft bill')]")
    WebElement chk_copyPo;
    public WebElement getCopyPOCheckBox() {
        return chk_copyPo;
    }



    /**
     * @author Vidhi Chapanera
     * @discription this locator is for ok button
     * @date 23 April 2021
     */
    @FindBy(how = How.XPATH, using = "//span[contains(text(),'OK')]")
    WebElement btn_ok;
    public WebElement getOKButton() {
        return btn_ok;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for xero Approve bill button
     * @date 21 April 2021
     */
    @FindBy(how = How.XPATH, using = "//a[text()='Approve']")
    WebElement btn_billApprove;
    public WebElement getBillApproveButton() {
        return btn_billApprove;
    }


    /**
     * @author Vidhi Chapanera
     * @date 19 April 2021
     * @discription this method is use to create hike store for Xero
     * @return
     */
    /*@Step("create hike store for Xero")
    public boolean createHikeStoreForXero(){
        CenterlizePO centerlizePO = PageFactory.initElements(driver,CenterlizePO.class);
        try{
            sleepFor(5);
            String fileLocation =System.getProperty("user.dir")+"\\src\\main\\resources\\createStore.properties";
            Properties properties1 = new Properties();
            properties1.load(new FileReader(fileLocation));
            centerlizePO.clickOnButton(PageFactory.initElements(driver, CreateStore.class).getStartFreeTrialLink());
            PageFactory.initElements(driver, CreateStore.class).renameFileData
                    (PageFactory.initElements(driver, CreateStore.class).getFirstNameTextBox()
                            ,"\\src\\main\\java\\IntegrationsPO\\XeroPO\\File\\FirstName");
            PageFactory.initElements(driver, CreateStore.class).renameFileData
                    (PageFactory.initElements(driver, CreateStore.class).getLastNameTextBox()
                            ,"\\src\\main\\java\\IntegrationsPO\\XeroPO\\File\\LastName");
            centerlizePO.enterDataUsingSendkeys(PageFactory.initElements(driver, CreateStore.class).getEmailTextBox(), StoreConstant.EMAIL);
            centerlizePO.enterDataUsingSendkeys(PageFactory.initElements(driver, CreateStore.class).getPhoneTextBox(), StoreConstant.PHONE);
            centerlizePO.clearText(PageFactory.initElements(driver, CreateStore.class).getCityTextBox());
            centerlizePO.enterDataUsingSendkeys(PageFactory.initElements(driver, CreateStore.class).getCityTextBox(),StoreConstant.CITY);
            centerlizePO.enterDataUsingSendkeys(PageFactory.initElements(driver, CreateStore.class).getPasswordTextBox(),String.valueOf(properties1.put(StoreConstant.PASSWORD,"password")));
            centerlizePO.clickOnButton(PageFactory.initElements(driver, CreateStore.class).getContinueButton());
            PageFactory.initElements(driver, CreateStore.class).renameFileData
                    (PageFactory.initElements(driver, CreateStore.class).getAccountAddressTextBox()
                            ,"\\src\\main\\java\\IntegrationsPO\\XeroPO\\File\\AccountAddress");
            sleepFor(3);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, CreateStore.class).getContinueButtonOnAccountAddressPage());
            centerlizePO.selectValueFromDropDown(PageFactory.initElements(driver, CreateStore.class).getIndustryTypeDropDown(),"Fashion & Clothing Retail");
            centerlizePO.clickOnButton(PageFactory.initElements(driver, CreateStore.class).getCreteMyStoreButton());
            sleepFor(30);
            sleepFor(1);
            PageFactory.initElements(driver, Shopify.class).PurgeData();
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }*/


    /**
     * @author Vidhi Chapanera
     * @date 13 May 2021
     * @discription this method is use to click on activate button on Xero
     * @return
     */
    @Step("create hike store for Xero")
    public boolean createHikeStoreForXero(){
        CenterlizePO centerlizePO = PageFactory.initElements(driver,CenterlizePO.class);
        try{
            sleepFor(5);
            String fileLocation =System.getProperty("user.dir")+"\\src\\main\\resources\\createStore.properties";
            Properties properties1 = new Properties();
            properties1.load(new FileReader(fileLocation));
            centerlizePO.clickOnButton(PageFactory.initElements(driver, CreateStore.class).getStartFreeTrialLink());
            centerlizePO.enterDataUsingSendkeys(PageFactory.initElements(driver, CreateStore.class).getFirstNameTextBox(),"Vidhi");
            centerlizePO.enterDataUsingSendkeys(PageFactory.initElements(driver, CreateStore.class).getLastNameTextBox(),"Chapanera");
            centerlizePO.enterDataUsingSendkeys(PageFactory.initElements(driver, CreateStore.class).getEmailTextBox(), StoreConstant.EMAIL);
            PageFactory.initElements(driver, CreateStore.class).enterPhoneNumber();
            centerlizePO.enterDataUsingSendkeys(PageFactory.initElements(driver, CreateStore.class).getPhoneTextBox(), StoreConstant.PHONE);
            centerlizePO.clearText(PageFactory.initElements(driver, CreateStore.class).getCityTextBox());
            centerlizePO.enterDataUsingSendkeys(PageFactory.initElements(driver, CreateStore.class).getCityTextBox(),StoreConstant.CITY);
            centerlizePO.enterDataUsingSendkeys(PageFactory.initElements(driver, CreateStore.class).getPasswordTextBox(),String.valueOf(properties1.put(StoreConstant.PASSWORD,"password")));
            centerlizePO.clickOnButton(PageFactory.initElements(driver, CreateStore.class).getContinueButton());
            PageFactory.initElements(driver, CreateStore.class).renameFileData
                    (PageFactory.initElements(driver, CreateStore.class).getAccountAddressTextBox()
                            ,"\\src\\main\\java\\IntegrationsPO\\BigCommercePO\\File\\AccountAddress");
            sleepFor( 3);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, CreateStore.class).getCreteMyStoreButton());
            sleepFor(30);
            PageFactory.initElements(driver,CreateStore.class).bitAboutYourStoreSection();
            sleepFor(10);
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }


    /**
     * @author Vidhi Chapanera
     * @date 19 April 2021
     * @discription this method is use to Login to Xero store
     * @return
     */
    @Step("Login to Xero store")
    public boolean loginXeroStore() throws IOException {
        CenterlizePO centerlizePO = PageFactory.initElements(driver,CenterlizePO.class);
        String fileLocation =System.getProperty("user.dir")+"\\src\\main\\resources\\Xero.properties";
        Properties properties1 = new Properties();
        properties1.load(new FileReader(fileLocation));
        try{
            sleepFor(2);
            JavascriptExecutor jse = (JavascriptExecutor)driver;
            jse.executeScript("window.open()");
            ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));
            sleepFor(1);
            driver.get("https://login.xero.com/");
            centerlizePO.enterDataUsingSendkeys(getXeroUserName(),String.valueOf(properties1.put( XeroConstant.XERO_EMAIL_ID,"xero.email.id")));
            centerlizePO.enterDataUsingSendkeys(getXeroPassword(),String.valueOf(properties1.put( XeroConstant.XERO_PASSWORD,"xero.password")));
            centerlizePO.clickOnButton(getLoginButton());
            sleepFor(5);
            centerlizePO.clickOnButton(getAnotherAuthenticationMethodButton());
            sleepFor( 1);
            centerlizePO.clickOnButton(getBackupEmailButton());
            sleepFor( 1);
            centerlizePO.clickOnButton(getSendCodeButton());
            sleepFor( 30);
            readEmail();
            centerlizePO.enterDataUsingSendkeys( getConfirmationCodeText(),verificationCode);
            centerlizePO.clickOnButton(getLoginButton());
            centerlizePO.clickOnButton(getXeroMainDropDown());
            sleepFor(2);
            centerlizePO.clickOnButton( getMyXeroButton() );
            ArrayList<String> tabs1 = new ArrayList<String> (driver.getWindowHandles());
            driver.switchTo().window(tabs1.get(2));
            sleepFor(5);
            try{
                if (driver.findElement(By.xpath("//b[contains(text(),'"+getValue("\\src\\main\\java\\IntegrationsPO\\XeroPO\\File\\XeroStore")+"')]//parent::div//following-sibling::div//b[text()='Trial Expired']")).isDisplayed()){
                    System.out.println(" Trial is Expired...Kindly Please Create Another Store");
                    centerlizePO.clickOnButton(getXeroMainDropDown());
                    sleepFor(2);
                    centerlizePO.clickOnButton(getAddAnotherOrganisation());
                    sleepFor(10);
                    PageFactory.initElements(driver, CreateStore.class).renameFileData
                            (getBusinessName(),"\\src\\main\\java\\IntegrationsPO\\XeroPO\\File\\XeroStore");
                    centerlizePO.enterDataUsingSendkeys(getIndustry(),"Retail Clothing");
                    Actions actions= new Actions( driver );
                    actions.sendKeys( Keys.TAB ).build().perform();
                    sleepFor( 1 );
                    centerlizePO.clickOnButton(getYesButton());
                    sleepFor(2);
                    centerlizePO.clickOnButton(getStartTrail());
                    sleepFor( 15 );
                    driver.close();
                    ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
                    driver.switchTo().window(tabs2.get(1));
                   sleepFor(2);
                   centerlizePO.clickOnButton(getAccountingButton());
                   centerlizePO.clickOnButton(getChartOfAccount());
                   centerlizePO.clickOnButton(getImportButton());
                   getBrowseButton().sendKeys(System.getProperty("user.dir")+"\\src\\main\\java\\IntegrationsPO\\XeroPO\\File\\XeroChartOfAccounts.csv");
                   centerlizePO.clickOnButton(getImportFileButton());
                   centerlizePO.clickOnButton(getConfirmButton());
                   WebElement cashdrpdwn = new WebDriverWait(driver,60).until(ExpectedConditions.presenceOfElementLocated
                           (By.xpath("//td[text()='Cash']//parent::tr//a[contains(@id,'AccountType')]")));
                   cashdrpdwn.click();
                   WebElement cashdrpdwno = new WebDriverWait(driver,60).until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//td[text()='Cash']//parent::tr//a[contains(@id,'AccountType')]//parent::div//parent::div//following-sibling::div//div[text()='Bank']")));
                   cashdrpdwno.click();
                    WebElement carddrpdwn = new WebDriverWait(driver,60).until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//td[text()='Card']//parent::tr//a[contains(@id,'AccountType')]")));
                    carddrpdwn.click();
                    WebElement carddrpdwn0 = new WebDriverWait(driver,60).until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//td[text()='Card']//parent::tr//a[contains(@id,'AccountType')]//parent::div//parent::div//following-sibling::div//div[text()='Credit Card']")));
                    carddrpdwn0.click();
                    centerlizePO.clickOnButton(getSaveButton());
                }
            }catch (Exception e){
                driver.close();
                ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
                driver.switchTo().window(tabs2.get(1));
            }
            sleepFor(2);
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }



    /**
     * @author Vidhi Chapanera
     * @date 19 April 2021
     * @param mimeMultipart
     * @return
     * @throws IOException
     * @throws MessagingException
     */
    private static String getTextFromMimeMultipart(MimeMultipart mimeMultipart) throws IOException, MessagingException {
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
     * @date 26 May 2021
     * @param bodyPart
     * @return
     * @throws IOException
     * @throws MessagingException
     */
    private static String getTextFromBodyPart(BodyPart bodyPart) throws IOException, MessagingException {
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
     * @date 19 April 2021
     * @return
     * @throws Exception
     * @discription this method is used to verify and Read Email for AR Statement(Email Template Functionality)
     */
    @Step("verify and Read Email for AR Statement(Email Template Functionality)")
    public boolean readEmail() throws IOException {
        String fileLocation =System.getProperty("user.dir")+"\\src\\main\\resources\\Xero.properties";
        Properties properties1 = new Properties();
        properties1.load(new FileReader(fileLocation));
        String receivingHost="imap.gmail.com";
        Properties props2=System.getProperties();
        props2.setProperty("mail.store.protocol", "imaps");
        Session session2=Session.getDefaultInstance(props2, null);
        try {
            Store store=session2.getStore("imaps");
            String userName = String.valueOf(properties1.put( XeroConstant.XERO_BACKUP_EMAIL_ID,"xero.backup.email.id"));
            String password = String.valueOf(properties1.put( XeroConstant.XERO_BACKUP_EMAIL_PASSWORD,"xero.backup.email.password"));
            store.connect(receivingHost,userName, password);
            Folder folder=store.getFolder("INBOX");
            folder.open(Folder.READ_WRITE);
            Message[] messages = folder.getMessages();
            String receivingSubject = messages[messages.length-1].getSubject();
            System.out.println("receivingSubject : " + receivingSubject);
            String  result = org.jsoup.Jsoup.parse(messages[messages.length-1].getContent().toString()).text();
            verificationCode = result.split( "Enter the following verification code to complete your login.")[1].split(" ")[1];
            System.out.println(verificationCode);
            folder.close(false);
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
     * @date 19 April 2021
     * @discription this method is use to click on activate button on Xero
     * @return
     */
    @Step("click on activate button on Xero")
    public boolean clickOnActivateButtonOnXero() throws IOException {
        CenterlizePO centerlizePO = PageFactory.initElements( driver, CenterlizePO.class );
        String fileLocation = System.getProperty( "user.dir" ) + "\\src\\main\\resources\\loginDetails.properties";
        Properties properties1 = new Properties();
        properties1.load( new FileReader( fileLocation ) );
        try {
            sleepFor( 2 );
            ArrayList<String> tabs = new ArrayList<String>( driver.getWindowHandles() );
            driver.switchTo().window( tabs.get( 0 ) );
            PageFactory.initElements( driver, StoreSetup.class ).clickOnStoreSetupButton();
            centerlizePO.clickOnButton( PageFactory.initElements( driver, Integrations.class ).getIntegrationsButton() );
            sleepFor( 3 );
            centerlizePO.clickOnButton( getXeroActivate() );
            sleepFor( 2 );
            try {
                sleepFor( 2 );
                if (getSelectOrganisation().isDisplayed()) {
                    centerlizePO.clickOnButton( getSelectOrganisation() );
                    if (driver.findElement( By.xpath( "//span[text()='" + getValue( "\\src\\main\\java\\IntegrationsPO\\XeroPO\\File\\XeroStore") + "']//parent::button//parent::li" ) ).getAttribute( "class" ).contains( "disabled" )) {
                        centerlizePO.clickOnButton( getapproveButton() );
                    }else{
                        WebElement org = new WebDriverWait( driver, 60 ).until( ExpectedConditions
                                .presenceOfElementLocated( By.xpath( "//span[text()='" + getValue( "\\src\\main\\java\\IntegrationsPO\\XeroPO\\File\\XeroStore") + "']//parent::button" ) ) );
                        JavascriptExecutor jse = (JavascriptExecutor) driver;
                        jse.executeScript( "arguments[0].click();", org );
                        centerlizePO.clickOnButton( getAllowAcessButton() );
                        System.out.println("else");
                    }
                }
            }catch (Exception e) {
                WebElement org = new WebDriverWait( driver, 60 ).until( ExpectedConditions
                        .presenceOfElementLocated( By.xpath( "//span[text()='" + getValue( "\\src\\main\\java\\IntegrationsPO\\XeroPO\\File\\XeroStore" ) + "']//parent::button" ) ) );
                JavascriptExecutor jse = (JavascriptExecutor) driver;
                jse.executeScript( "arguments[0].click();", org );
                centerlizePO.clickOnButton( getAllowAcessButton() );
                System.out.println("catch");
            }
        }catch (Exception e) {
            centerlizePO.clickOnButton( getAllowAcessButton() );
        }
        sleepFor( 5 );
        return true;
    }



    /**
     * @author Vidhi Chapanera
     * @date 20 April 2021
     * @return
     * @throws IOException
     * @discription this method is used to get account address value
     */
    @Step("")
    public String getValue(String path) throws IOException {
        String tesLine ="";
        File f = new File(System.getProperty("user.dir") + path);
        f.canWrite();
        Scanner scanner = new Scanner(f);
        while (scanner.hasNextLine()) {
            tesLine += scanner.nextLine();
        }
        System.out.println(tesLine);
        scanner.close();
        return tesLine;
    }


    /**
     * @author Vidhi Chapanera
     * @date 02 April 2021
     * @discription this method is use to mapping Xero
     * @return
     */
    @Step("mapping Xero")
    public boolean mappingXero() throws IOException {
        CenterlizePO centerlizePO = PageFactory.initElements(driver,CenterlizePO.class);
        Actions actions = new Actions(driver);
        try{
            sleepFor(30);
            try {
                sleepFor(5);
                if (driver.findElement(By.xpath("//span[text()='Select xero organisation']//parent::a")).isDisplayed()){
                    WebElement select = new WebDriverWait(driver,60).
                            until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Select xero organisation']//parent::a")));
                    centerlizePO.clickOnButton(select);
                    WebElement selecto = new WebDriverWait(driver,60).
                            until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='"+getValue( "\\src\\main\\java\\IntegrationsPO\\XeroPO\\File\\XeroStore")+"']")));
                    centerlizePO.clickOnButton(selecto);
                    WebElement btn = new WebDriverWait(driver,60).
                            until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Save']//parent::button")));
                    centerlizePO.clickOnButton(btn);
                }
            }catch (Exception e){
                System.out.println("select organisation not found.../!");
            }
            sleepFor(8);
            List<String> list2 = ExcelUtils.getAllCellDataStringForXero();
            for (String s2 : list2) {
                sleepFor(1);
                WebElement btn = new WebDriverWait(driver,60).
                        until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[contains(text(),'"+s2.split("-")[0]+"')]//following-sibling::div//a")));
                actions.moveToElement(btn).click().build().perform();
                sleepFor(2);
                WebElement option = new WebDriverWait(driver,60).
                        until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[contains(text(),'"+s2.split("-")[0]+"')]//following-sibling::div//a//following-sibling::div//ul//li//ul//li//div[contains(text(),'"+s2.split("-")[1]+"')]")));
                actions.moveToElement(option).click().build().perform();
                sleepFor(2);
            }

            /**
             * @checkBox
             */
            WebElement chk = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[@for='ChkStoreCredit']")));
            actions.moveToElement(chk).click().build().perform();
            sleepFor(2);

            /**
             * @tax
             */
            List<WebElement> taxmapping = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy
                            (By.xpath("//span[text()='Tax mapping']//parent::div//parent::div//following-sibling::div//table//tbody//tr//td//a")));
            actions.moveToElement(taxmapping.get(0)).click().build().perform();
            sleepFor(2);
            WebElement to0 = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//span[text()='Tax mapping']//parent::div//parent::div//following-sibling::div//table//tbody//tr//td//a//following-sibling::div//ul//li//ul//li//div[contains(text(),'GST Free Income [0.0000%]')]")));
            actions.moveToElement(to0).click().build().perform();
            sleepFor(2);

            actions.moveToElement(taxmapping.get(1)).click().build().perform();
            sleepFor(2);
            WebElement to1 = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//span[text()='Tax mapping']//parent::div//parent::div//following-sibling::div//table//tbody//tr//td//a//following-sibling::div//ul//li//ul//li//div[contains(text(),'Input Taxed [0.0000%]')]")));
            actions.moveToElement(to1).click().build().perform();
            sleepFor(2);

            actions.moveToElement(taxmapping.get(2)).click().build().perform();
            sleepFor(2);
            WebElement to2 = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Tax mapping']//parent::div//parent::div//following-sibling::div//table//tbody//tr//td//a//following-sibling::div//ul//li//ul//li//div[contains(text(),'GST on Income [10.0000%]')]")));
            actions.moveToElement(to2).click().build().perform();
            sleepFor(2);

            actions.moveToElement(taxmapping.get(3)).click().build().perform();
            sleepFor(2);
            WebElement to3 = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Tax mapping']//parent::div//parent::div//following-sibling::div//table//tbody//tr//td//a//following-sibling::div//ul//li//ul//li//div[contains(text(),'GST on Expenses [10.0000%]')]")));
            actions.moveToElement(to3).click().build().perform();
            sleepFor(2);

            /**
             * @payment
             */
            List<WebElement> payment = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy
                            (By.xpath("//span[text()='Payment mapping']//parent::div//parent::div//following-sibling::div//table//tbody//tr//td//a")));
            actions.moveToElement(payment.get(0)).click().build().perform();
            sleepFor(2);
            WebElement option = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Payment mapping']//parent::div//parent::div//following-sibling::div//table//tbody//tr//td//a//following-sibling::div//ul//li//ul//li//div[contains(text(),'1000 - Cash')]")));
            actions.moveToElement(option).click().build().perform();
            sleepFor(2);

            actions.moveToElement(payment.get(1)).click().build().perform();
            sleepFor(2);
            WebElement option11 = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Payment mapping']//parent::div//parent::div//following-sibling::div//table//tbody//tr//td//a//following-sibling::div//ul//li//ul//li//div[contains(text(),'2000 - Card')]")));
            actions.moveToElement(option11).click().build().perform();
            sleepFor(2);

            try{
                if (payment.get(2).isDisplayed()){
                    actions.moveToElement(payment.get(2)).click().build().perform();
                    sleepFor(2);
                    WebElement o1 = new WebDriverWait(driver,60).
                            until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Payment mapping']//parent::div//parent::div//following-sibling::div//table//tbody//tr//td//a//following-sibling::div//ul//li//ul//li//div[contains(text(),'1000 - Cash')]")));
                    actions.moveToElement(o1).click().build().perform();
                    sleepFor(2);
                }
            }catch (Exception e){
                System.out.println("BigCommerce Not Found...!");
            }



            /**
             * @twoWay
             */
            actions.sendKeys(Keys.PAGE_DOWN).build().perform();
            List<WebElement> twoway = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy
                            (By.xpath("//label[contains(@for,'Twoway')]")));
            for(int i=0;i<twoway.size();i++){
                JavascriptExecutor executor = (JavascriptExecutor)driver;
                executor.executeScript("arguments[0].click();", twoway.get(i));
                sleepFor(1);
            }
            sleepFor(3);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, QuickBooks.class).getContinueButton());
            sleepFor(10);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, QuickBooks.class).getSaveAndSyncButton());
            sleepFor(15);
            if(getManageButton().isDisplayed()){
                centerlizePO.clickOnButton(getManageButton());
                sleepFor(5);
                centerlizePO.clickOnButton(PageFactory.initElements(driver, Shopify.class).getManualSyncButton());
                sleepFor(4);
                String[] strArray2 = new String[]{"syncProducts", "syncCustomers", "syncSales", "syncPurchase", "syncSupplier", "syncRegisterClosure"};
                for (String s : strArray2) {
                    WebElement element = new WebDriverWait(driver, 60).ignoring(StaleElementReferenceException.class).
                            until(ExpectedConditions.presenceOfElementLocated
                                    (By.xpath("//label[@for='" + s + "']")));
                    element.click();
                }
                sleepFor(1);
                centerlizePO.clickOnButton(PageFactory.initElements(driver, Shopify.class).getButtonSyncNow());
                sleepFor(2);
                centerlizePO.clickOnButton(getXeroSaveButton());
                sleepFor(10);
                centerlizePO.clickOnButton(getSyncProcessLogButton());
                sleepFor(3);
                centerlizePO.clickOnButton(PageFactory.initElements(driver, Shopify.class).getShowErrorsOnly());
                sleepFor(4);
               /* WebElement e = new WebDriverWait(driver,60).until
                        (ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Hike + QuickBooks']//parent::div//parent::div/parent::div//select")));
                Select select = new Select(e);
                select.selectByValue("100");*/
                sleepFor(1);
            }
            sleepFor(2);
            for (int i =0;i<20;i++){
                sleepFor(1);
                WebElement page = new WebDriverWait(driver,60).until
                        (ExpectedConditions.presenceOfElementLocated(By.xpath
                                ("//div[contains(@id,'paginate')]//li[@class='active']//a")));
                actions.moveToElement(page).click().perform();
                sleepFor(1);
            }
            sleepFor(2);
            actions.sendKeys(Keys.ESCAPE).build().perform();
            sleepFor(3);
            System.out.println(true);
            sleepFor(5 );
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }


    /**
     * @author Vidhi Chapanera
     * @date 21 April 2021
     * @discription this method is use to create Product hike to xero and verify in xero
     * @return
     */
    @Step("create Product hike to xero and verify in xero")
    public boolean createProductHiketoxero() throws IOException {
        CenterlizePO centerlizePO = PageFactory.initElements(driver, CenterlizePO.class);
        ProductsPO.ProductsPO.Products products1 = PageFactory.initElements(driver, ProductsPO.ProductsPO.Products.class);
        Actions actions = new Actions(driver);
        try{
            sleepFor(5);
            ArrayList<String> tabs1 = new ArrayList<String> (driver.getWindowHandles());
            driver.switchTo().window(tabs1.get(0));
            sleepFor(2);
            PageFactory.initElements(driver, ProductsPO.Products.class).clickOnProductsButtonn();
            centerlizePO.clickOnButton(products1.getProductButton());
            sleepFor(2);
            centerlizePO.clickOnButton(products1.getAddProductButton());
            sleepFor(2);
            PageFactory.initElements(driver,Shopify.class).renameFileData(products1.getProductName(),"\\src\\main\\java\\IntegrationsPO\\XeroPO\\File\\HProduct");
            centerlizePO.clickOnButton(products1.getInventoryTrackingButton());
            List<WebElement> input = new WebDriverWait(driver,60).
                    until(ExpectedConditions.
                            presenceOfAllElementsLocatedBy(By.xpath
                                    ("//th[text()='On hand']//parent::tr//parent::thead//parent::table//tbody//input")));
            input.get(0).clear();
            input.get(0).sendKeys("100");
            sleepFor(2);
            List<WebElement> cost = new WebDriverWait(driver,60).
                    until(ExpectedConditions.
                            presenceOfAllElementsLocatedBy(By.xpath
                                    ("//th[text()='Cost price']//parent::tr//parent::thead//parent::table//tbody//input")));
            cost.get(0).clear();
            cost.get(0).sendKeys("150");
            centerlizePO.clickOnButton(products1.getProductSaveButton());
            sleepFor(5);
            centerlizePO.enterDataUsingSendkeys(PageFactory.initElements(driver, Products.class).getSearchBox(),getValue("\\src\\main\\java\\IntegrationsPO\\XeroPO\\File\\HProduct"));
            sleepFor(3);
            List<WebElement> list1 = new WebDriverWait(driver,120).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy
                            (By.xpath("//ul[contains(@class,'hike-width-block')]//b[text()='Product']//parent::ul//li//a")));
            list1.get(0).click();
            sleepFor(3);
            WebElement name = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//table[@id='RosterDataTable']//tbody//tr//td[2]//span[text()='" + getValue("\\src\\main\\java\\IntegrationsPO\\XeroPO\\File\\HProduct") + "']//parent::td//following-sibling::td//a")));
            name.click();
            while(true){
                sleepFor(1);
                centerlizePO.clickOnButton(PageFactory.initElements(driver, Shopify.class).getRefreshLogButton());
                sleepFor(3);
                WebElement e = new WebDriverWait(driver,60).
                        until(ExpectedConditions.presenceOfElementLocated
                                (By.xpath("//td[text()='Hike - Xero']//following-sibling::td[1][text()='Created']")));
                if (e.isDisplayed())
                    break;
            }
            sleepFor(2);
            actions.sendKeys(Keys.ESCAPE).build().perform();
            sleepFor(3);
            ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));
            sleepFor(2);
            JavascriptExecutor executor = (JavascriptExecutor)driver;
            executor.executeScript("arguments[0].click();",getBusinessButton());
            executor.executeScript("arguments[0].click();",getProductAndServices());
            sleepFor(3);
            List<WebElement> search = new WebDriverWait(driver,60).
                    until(ExpectedConditions.
                            presenceOfAllElementsLocatedBy(By.xpath
                                    ("//div[@id='inventory-grid-body']//parent::div//input")));
            actions.moveToElement(search.get(0)).click().build().perform();
            centerlizePO.enterDataUsingSendkeys(search.get(0), getValue("\\src\\main\\java\\IntegrationsPO\\XeroPO\\File\\HProduct"));
            sleepFor(3);
            WebElement pro = new WebDriverWait(driver,60).
                    until(ExpectedConditions.
                            presenceOfElementLocated(By.xpath
                                    ("//div[contains(text(),'"+getValue("\\src\\main\\java\\IntegrationsPO\\XeroPO\\File\\HProduct")+"')]")));
            if (pro.isDisplayed()){
                System.out.println(getValue("\\src\\main\\java\\IntegrationsPO\\XeroPO\\File\\HProduct") +
                        " Displayed...!");
            }
            sleepFor(3);
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }


    /**
     * @author Vidhi Chapanera
     * @date 21 April 2021
     * @discription this method is use to create Product Xero to hike and verify in hike
     * @return
     */
    @Step("create Product Xero to hike and verify in hike")
    public boolean createProductXerotoHike() throws IOException {
        CenterlizePO centerlizePO = PageFactory.initElements(driver, CenterlizePO.class);
        ProductsPO.ProductsPO.Products products1 = PageFactory.initElements(driver, ProductsPO.ProductsPO.Products.class);
        Actions actions = new Actions(driver);
        try{
            sleepFor(5);
            ArrayList<String> tabs1 = new ArrayList<String> (driver.getWindowHandles());
            driver.switchTo().window(tabs1.get(1));
            sleepFor(2);
            centerlizePO.clickOnButton(getNewItemButton());
            sleepFor(2);
            renameItemCode(getItemCode());
            PageFactory.initElements(driver,Shopify.class).renameFileData(getItemName(),"\\src\\main\\java\\IntegrationsPO\\XeroPO\\File\\XProduct");
            centerlizePO.clickOnButton(getProductSaveButtonXero());
            sleepFor(5);
            driver.switchTo().window(tabs1.get(0));
            sleepFor(2);
            PageFactory.initElements(driver, Reporting.class).clickOnReportingButton();
            PageFactory.initElements(driver, StoreSetup.class).clickOnStoreSetupButton();
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Integrations.class).getIntegrationsButton());
            sleepFor(3);
            centerlizePO.clickOnButton(getManageButton());
            sleepFor(5);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Shopify.class).getManualSyncButton());
            sleepFor(4);
            String[] strArray2 = new String[]{"syncProducts"};
            for (String s : strArray2) {
                WebElement element = new WebDriverWait(driver, 60).ignoring(StaleElementReferenceException.class).
                        until(ExpectedConditions.presenceOfElementLocated
                                (By.xpath("//label[@for='" + s + "']")));
                element.click();
            }
            sleepFor(1);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Shopify.class).getButtonSyncNow());
            sleepFor(2);
            centerlizePO.clickOnButton(getXeroSaveButton());
            sleepFor(10);
            PageFactory.initElements(driver, Inventory.class).clickOnInventoryButton();
            PageFactory.initElements(driver, ProductsPO.Products.class).clickOnProductsButtonn();
            centerlizePO.clickOnButton(products1.getProductButton());
            sleepFor(5);
            centerlizePO.enterDataUsingSendkeys(products1.getSearchBox(), getValue("\\src\\main\\java\\IntegrationsPO\\XeroPO\\File\\XProduct"));
            sleepFor(1);
            sleepFor(3);
            List<WebElement> list1 = new WebDriverWait(driver,120).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy
                            (By.xpath("//ul[contains(@class,'hike-width-block')]//b[text()='Product']//parent::ul//li//a")));
            list1.get(0).click();
            sleepFor(3);
            WebElement name = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//table[@id='RosterDataTable']//tbody//tr//td[2]//span[text()='" + getValue("\\src\\main\\java\\IntegrationsPO\\XeroPO\\File\\XProduct") + "']//parent::td//following-sibling::td//a")));
            name.click();
            while(true){
                sleepFor(1);
                centerlizePO.clickOnButton(PageFactory.initElements(driver, Shopify.class).getRefreshLogButton());
                sleepFor(3);
                WebElement e = new WebDriverWait(driver,60).
                        until(ExpectedConditions.presenceOfElementLocated
                                (By.xpath("//td[text()='Xero - Hike']//following-sibling::td[1][text()='Created']")));
                if (e.isDisplayed())
                    break;
            }
            sleepFor(2);
            actions.sendKeys(Keys.ESCAPE).build().perform();
            sleepFor(3);
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }


    /**
     * @author Vidhi Chapanera
     * @date 21 April 2021
     * @return
     * @throws IOException
     * @discription this method is used to rename the text file data
     */
    @Step("")
    public boolean renameItemCode(WebElement el) throws IOException {
        String tesLine ="";
        try {
            File f = new File(System.getProperty("user.dir") + "\\src\\main\\java\\IntegrationsPO\\XeroPO\\File\\ItemCode");
            f.canWrite();
            Scanner scanner = new Scanner(f);
            while (scanner.hasNextLine()) {
                tesLine += scanner.nextLine();
            }
            scanner.close();
            String string = tesLine;
            String[] parts = string.split("g");
            String part1 = parts[0]; //
            String part2 = parts[1]; //
            int number = Integer.parseInt(part2);
            int sum = number + 1;
            String oldValue = String.valueOf(number);
            String newValue = String.valueOf(sum);
            String finalString = tesLine.replace(oldValue, newValue);
            String dataText = finalString;
            System.out.println(dataText);
            FileWriter myWriter = new FileWriter(f);
            myWriter.write(dataText);
            myWriter.close();
            PageFactory.initElements(driver, CenterlizePO.class).enterDataUsingSendkeys(el, dataText);
            synchronized (dataText) {
                System.out.println(true);
            }
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }



    /**
     * @author Vidhi Chapanera
     * @date 21 April 2021
     * @discription this method is use to create Purchase Order hike to Xero and verify in Xero
     * @return
     */
    @Step("create Purchase Order hike to Xero and verify in Xero")
    public boolean createPurchaseOrderHiketoXero() throws IOException {
        CenterlizePO centerlizePO = PageFactory.initElements(driver, CenterlizePO.class);
        Actions actions = new Actions(driver);
        try{
            sleepFor(5);
            ArrayList<String> tabs1 = new ArrayList<String> (driver.getWindowHandles());
            driver.switchTo().window(tabs1.get(0));
            sleepFor(2);
            PageFactory.initElements(driver, Inventory.class).clickOnInventoryButton();
            sleepFor(2);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Purchases.class).getPurchasesButton());
            sleepFor(5);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Purchases.class).getAddNewButton());
            sleepFor(5);
            List<WebElement> elements = new  WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//input[@ng-model='searchtext']")));
            sleepFor(1);
            elements.get(0).click();
            elements.get(0).sendKeys(getValue("\\src\\main\\java\\IntegrationsPO\\XeroPO\\File\\HProduct"));
            sleepFor(5);
            WebElement chkbocx = new WebDriverWait(driver,60).until
                    (ExpectedConditions.presenceOfElementLocated
                            (By.cssSelector("table.table.table-hover.table-vert.table-border.fix-table-header > tbody > tr > td > div > label")));
            JavascriptExecutor executor = (JavascriptExecutor)driver;
            executor.executeScript("arguments[0].click();", chkbocx);
            sleepFor(1);
            sleepFor(1);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Purchases.class).getAddAndContinueButton());
            sleepFor(2);
            actions.sendKeys(Keys.PAGE_DOWN).build().perform();
            String order = "5";
            sleepFor(1);
            WebElement orderinput = new WebDriverWait(driver,60).until
                    (ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//span[text()='Order ']//parent::th//parent::tr//parent::thead//parent::table//tbody//tr//td[2]//input")));
            orderinput.clear();
            orderinput.sendKeys(order);
            sleepFor(1);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Purchases.class).getSaveButton());
            sleepFor(10);
            WebElement PO = new WebDriverWait(driver,60).until
                    (ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//table[@id='purchanseOrderDataTable']//tbody//tr//td//i[contains(@class,'fa fa-circle-o')]//parent::td//parent::tr//td[1]//a")));
            String poText = PO.getText();
            WebElement POsysnc = new WebDriverWait(driver,60).until
                    (ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//table[@id='purchanseOrderDataTable']//tbody//tr//td//a[contains(text(),'"+poText+"')]//parent::td//following-sibling::td//a")));
            POsysnc.click();
            sleepFor(5);
            while(true){
                sleepFor(1);
                centerlizePO.clickOnButton(PageFactory.initElements(driver, Shopify.class).getRefreshLogButton());
                sleepFor(3);
                WebElement e = new WebDriverWait(driver,60).
                        until(ExpectedConditions.presenceOfElementLocated
                                (By.xpath("//td[text()='Hike - Xero']//following-sibling::td[1][text()='Created']")));
                if (e.isDisplayed())
                    break;
            }
            sleepFor(3);
            actions.sendKeys(Keys.ESCAPE).build().perform();
            sleepFor(3);
            driver.switchTo().window(tabs1.get(1));
            executor.executeScript("arguments[0].click();",getBusinessButton());
            executor.executeScript("arguments[0].click();",getPurchaseorders());
            sleepFor(3);
            WebElement pro = new WebDriverWait(driver,60).
                    until(ExpectedConditions.
                            presenceOfElementLocated(By.xpath
                                    ("//div[contains(text(),'"+poText+"')]")));
            if (pro.isDisplayed()){
                System.out.println(poText +
                        " Displayed...!");
            }
            sleepFor(3);
            sleepFor(2);
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }


    /**
     * @author Vidhi Chapanera
     * @date 21 April 2021
     * @discription this method is use to create Purchase Order Xero to hike and verify in hike
     * @return
     */
    @Step("create Purchase Order Xero to hike and verify in hike")
    public boolean createPurchaseOrderXerotoHike() throws IOException {
        CenterlizePO centerlizePO = PageFactory.initElements(driver, CenterlizePO.class);
        Actions actions = new Actions(driver);
        String orderNumber ="";
        try{
            sleepFor(5);
            ArrayList<String> tabs1 = new ArrayList<String> (driver.getWindowHandles());
            driver.switchTo().window(tabs1.get(1));
            sleepFor(2);
            centerlizePO.clickOnButton( getNewPurchaseOrderButton());
            centerlizePO.enterDataUsingSendkeys( getContact(),getValue("\\src\\main\\java\\IntegrationsPO\\XeroPO\\File\\Supplier"));
            sleepFor(3);
            actions.sendKeys(Keys.ARROW_DOWN).build().perform();
            actions.sendKeys( Keys.TAB ).build().perform();
            sleepFor( 2 );
            orderNumber = getOrderNumber().getAttribute("value");
            System.out.println(orderNumber);
            List<WebElement> additem = new  WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//span[text()='Item']//parent::div//parent::div//parent::div//parent::div//parent::div//parent::div//td[2]")));
            centerlizePO.clickOnButton( additem.get(0) );
            WebElement e1 = new WebDriverWait( driver,60).
                    until(ExpectedConditions.presenceOfElementLocated(By.name("PriceListItemID")));
            centerlizePO.enterDataUsingSendkeys(e1,getValue("\\src\\main\\java\\IntegrationsPO\\XeroPO\\File\\HProduct"));
            actions.sendKeys( Keys.TAB ).build().perform();
            List<WebElement> adddis = new  WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//span[text()='Item']//parent::div//parent::div//parent::div//parent::div//parent::div//parent::div//td[3]")));
            centerlizePO.clickOnButton( adddis.get(0) );
            WebElement e2 = new WebDriverWait( driver,60).
                    until(ExpectedConditions.presenceOfElementLocated(By.name("Description")));
            centerlizePO.enterDataUsingSendkeys(e2,"test");
            centerlizePO.clickOnButton( getApprove() );
            sleepFor(8);
            centerlizePO.clickOnButton( getApprove() );
            sleepFor(15);
            driver.switchTo().window(tabs1.get(0));
            sleepFor(2);
            PageFactory.initElements(driver, StoreSetup.class).clickOnStoreSetupButton();
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Integrations.class).getIntegrationsButton());
            sleepFor(3);
            centerlizePO.clickOnButton(getManageButton());
            sleepFor(5);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Shopify.class).getManualSyncButton());
            sleepFor(4);
            String[] strArray2 = new String[]{"syncPurchase"};
            for (String s : strArray2) {
                WebElement element = new WebDriverWait(driver, 60).ignoring(StaleElementReferenceException.class).
                        until(ExpectedConditions.presenceOfElementLocated
                                (By.xpath("//label[@for='" + s + "']")));
                element.click();
            }
            sleepFor(1);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Shopify.class).getButtonSyncNow());
            sleepFor(2);
            centerlizePO.clickOnButton(getXeroSaveButton());
            sleepFor(10);
            PageFactory.initElements(driver, Inventory.class).clickOnInventoryButton();
            sleepFor(2);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Purchases.class).getPurchasesButton());
            sleepFor(5);
            WebElement POsysnc = new WebDriverWait(driver,60).until
                    (ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//table[@id='purchanseOrderDataTable']//tbody//tr//td//a[contains(text(),'"+orderNumber+"')]//parent::td//following-sibling::td//a")));
            POsysnc.click();
            sleepFor(5);
            while(true){
                sleepFor(1);
                centerlizePO.clickOnButton(PageFactory.initElements(driver, Shopify.class).getRefreshLogButton());
                sleepFor(3);
                WebElement e = new WebDriverWait(driver,60).
                        until(ExpectedConditions.presenceOfElementLocated
                                (By.xpath("//td[text()='Xero - Hike']//following-sibling::td[1][text()='Created']")));
                if (e.isDisplayed())
                    break;
            }
            sleepFor(3);
            actions.sendKeys(Keys.ESCAPE).build().perform();
            sleepFor(3);
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }


    /**
     * @author Vidhi Chapanera
     * @date 22 April 2021
     * @discription this method is use to create Sale hike to Xero and verify in Xero
     * @return
     */
    @Step("create Sale hike to Xero and verify in Xero")
    public boolean createSaleHiketoXero() throws IOException {
        CenterlizePO centerlizePO = PageFactory.initElements(driver, CenterlizePO.class);
        Actions actions = new Actions(driver);
        try{
            sleepFor(5);
            ArrayList<String> tabs1 = new ArrayList<String> (driver.getWindowHandles());
            driver.switchTo().window(tabs1.get(1));
            driver.close();
            sleepFor(1);
            driver.switchTo().window(tabs1.get(0));
            sleepFor(2);
            PageFactory.initElements(driver, Inventory.class).clickOnInventoryButton();
            PageFactory.initElements(driver, PointofSale.class).clickOnPointOfSaleButtonn();
            sleepFor(2);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, ProcessSale.class).getProcessSaleButton());
            sleepFor(20);
           /* centerlizePO.clickOnButton(PageFactory.initElements(driver, CashRegister.class).getOpenRegisterButton());
            sleepFor(2);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Shopify.class).getOpenButton());
            sleepFor(3);*/
            PageFactory.initElements(driver, ProcessSale.class).getSearchBar().sendKeys(getValue("\\src\\main\\java\\IntegrationsPO\\XeroPO\\File\\HProduct"));
            sleepFor(2);
            actions.sendKeys(Keys.TAB).build().perform();
            sleepFor(1);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, ProcessSale.class).getPayButton());
            sleepFor(3);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, ProcessSale.class).getCashButton());
            sleepFor(5);
            String mainWindowHandle = driver.getWindowHandle();
            Set<String> allWindowHandles = driver.getWindowHandles();
            Iterator<String> iterator = allWindowHandles.iterator();
            while (iterator.hasNext()) {
                String ChildWindow = iterator.next();
                if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
                    driver.switchTo().window(ChildWindow);
                    WebElement text = new WebDriverWait(driver,60).until(ExpectedConditions.presenceOfElementLocated(By.tagName("print-preview-app")));
                    System.out.println("Heading of child window is " + text.getText());
                    Actions actions1 = new Actions(driver);
                    actions1.sendKeys(Keys.TAB).build().perform();
                    actions1.sendKeys(Keys.ENTER).build().perform();
                }
            }
            sleepFor(3);
            driver.switchTo().window(mainWindowHandle);
            sleepFor(3);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, ProcessSale.class).getAddNewSaleButton());
            sleepFor(5);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, SalesHistory.class).getSalesHistoryButton());
            sleepFor(5);
            driver.navigate().refresh();
            sleepFor(10);
            WebElement sale = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//table[@id='SalesTable']//tbody//tr[1]//td[2]//a[text()]")));
            String saleRef = sale.getText();
            System.out.println(saleRef);
            WebElement sale01 = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//table[@id='SalesTable']//tbody//tr[1]//td[2]//a[text()='"+saleRef+"']//parent::td//following-sibling::td//a//i//parent::a")));
            centerlizePO.clickOnButton(sale01);
            sleepFor(3);
            while(true){
                sleepFor(1);
                centerlizePO.clickOnButton(PageFactory.initElements(driver, Shopify.class).getRefreshLogButton());
                sleepFor(3);
                WebElement e = new WebDriverWait(driver,60).
                        until(ExpectedConditions.presenceOfElementLocated
                                (By.xpath("//td[text()='Hike - Xero']//following-sibling::td[1][text()='Created']")));
                if (e.isDisplayed())
                    break;
            }
            sleepFor(2);
            actions.sendKeys(Keys.ESCAPE).build().perform();
            sleepFor(3);
            JavascriptExecutor jse = (JavascriptExecutor)driver;
            jse.executeScript("window.open()");
            ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));
            driver.get("https://go.xero.com/Dashboard/");
            sleepFor(5);
            JavascriptExecutor executor = (JavascriptExecutor)driver;
            executor.executeScript("arguments[0].click();",getBusinessButton());
            executor.executeScript("arguments[0].click();",getInvoices());
            sleepFor(3);
            if (driver.findElements(By.xpath("//td[text()='"+saleRef+"']")).get(0).isDisplayed()){
                System.out.println("");
            }
            sleepFor(3);
            sleepFor(2);
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }


    /**
     * @author Vidhi Chapanera
     * @date 22 April 2021
     * @discription this method is use to create Sale Xero to hike and verify in hike
     * @return
     */
    @Step("create Sale Xero to hike and verify in hike")
    public boolean createSaleXerotoHike() throws IOException {
        CenterlizePO centerlizePO = PageFactory.initElements(driver, CenterlizePO.class);
        Actions actions = new Actions(driver);
        try{
            sleepFor(5);
            ArrayList<String> tabs1 = new ArrayList<String> (driver.getWindowHandles());
            driver.switchTo().window(tabs1.get(1));
            centerlizePO.clickOnButton(getNewInvoices());
            sleepFor(3);
            driver.switchTo().frame("contactsAutoCompleter");
            WebElement to = new WebDriverWait(driver,60).until(
                    ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='trigger']//input")));
            centerlizePO.enterDataUsingSendkeys(to,"Guest");
            actions.sendKeys(Keys.ARROW_DOWN).build().perform();
            actions.sendKeys(Keys.TAB).build().perform();
            driver.switchTo().defaultContent();
            WebElement invoice = new WebDriverWait(driver,60).until(
                    ExpectedConditions.presenceOfElementLocated(By.xpath("//input[contains(@id,'InvoiceNumber')]")));
            String invoiceNumber = invoice.getAttribute("value");
            System.out.println(invoiceNumber);
            WebElement duedate = new WebDriverWait(driver,60).until(
                    ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@id,'DueDate')]//input[contains(@id,'DueDate')]")));
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy");
            String strDate = dateFormat.format(new Date());
            centerlizePO.enterDataUsingSendkeys(duedate,strDate);
            List<WebElement> additem = new  WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[text()='Item']//parent::td//parent::tr//parent::thead//parent::table//parent::div//parent::div//parent::div//following-sibling::div//div//tr//td[2]//div")));
            centerlizePO.clickOnButton( additem.get(0));
            WebElement e1 = new WebDriverWait( driver,60).
                    until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='Item']//parent::td//parent::tr//parent::thead//parent::table//parent::div//parent::div//parent::div//following-sibling::div//div//input")));
            centerlizePO.enterDataUsingSendkeys(e1,getValue("\\src\\main\\java\\IntegrationsPO\\XeroPO\\File\\HProduct"));
            actions.sendKeys( Keys.TAB ).build().perform();
            List<WebElement> adddis = new  WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[text()='Item']//parent::td//parent::tr//parent::thead//parent::table//parent::div//parent::div//parent::div//following-sibling::div//div//tr//td[3]//div")));
            centerlizePO.clickOnButton( adddis.get(0) );
            WebElement e2 = new WebDriverWait( driver,60).
                    until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='Item']//parent::td//parent::tr//parent::thead//parent::table//parent::div//parent::div//parent::div//following-sibling::div//div//textarea")));
            centerlizePO.enterDataUsingSendkeys(e2,"test");
            centerlizePO.clickOnButton( getApprove() );
            sleepFor(5);
            WebElement datepaid = new WebDriverWait(driver,60).until(
                    ExpectedConditions.presenceOfElementLocated(By.cssSelector("#DatePaidCalendar")));
            SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd MMM yyyy");
            String strDate1 = dateFormat1.format(new Date());
            centerlizePO.enterDataUsingSendkeys( datepaid,strDate1 );
            WebElement paidto = new WebDriverWait(driver,60).until(
                    ExpectedConditions.presenceOfElementLocated(By.cssSelector("#PaidFromDropDown_value")));
            centerlizePO.enterDataUsingSendkeys( paidto,"Cash" );
            sleepFor(2);
            actions.sendKeys( Keys.TAB ).build().perform();
            WebElement makepaymentbtn = new WebDriverWait(driver,60).until(
                    ExpectedConditions.presenceOfElementLocated(By.cssSelector("#makePaymentSubmit")));
            centerlizePO.clickOnButton(makepaymentbtn);
            sleepFor(5);
            driver.switchTo().window(tabs1.get(0));
            sleepFor(2);
            PageFactory.initElements(driver, StoreSetup.class).clickOnStoreSetupButton();
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Integrations.class).getIntegrationsButton());
            sleepFor(3);
            centerlizePO.clickOnButton(getManageButton());
            sleepFor(5);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Shopify.class).getManualSyncButton());
            sleepFor(4);
            String[] strArray2 = new String[]{"syncSales"};
            for (String s : strArray2) {
                WebElement element = new WebDriverWait(driver, 60).ignoring(StaleElementReferenceException.class).
                        until(ExpectedConditions.presenceOfElementLocated
                                (By.xpath("//label[@for='" + s + "']")));
                element.click();
            }
            sleepFor(1);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Shopify.class).getButtonSyncNow());
            sleepFor(2);
            centerlizePO.clickOnButton(getXeroSaveButton());
            sleepFor(10);
            PageFactory.initElements(driver, Inventory.class).clickOnInventoryButton();
            PageFactory.initElements(driver, PointofSale.class).clickOnPointOfSaleButtonn();
            sleepFor(2);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, SalesHistory.class).getSalesHistoryButton());
            sleepFor(8);
            driver.navigate().refresh();
            sleepFor(10);
            WebElement sale01 = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//table[@id='SalesTable']//tbody//tr//td[2]//a[text()='"+invoiceNumber+"']//parent::td//following-sibling::td//a//i//parent::a")));
            centerlizePO.clickOnButton(sale01);
            sleepFor(3);
            while(true){
                sleepFor(1);
                centerlizePO.clickOnButton(PageFactory.initElements(driver, Shopify.class).getRefreshLogButton());
                sleepFor(3);
                WebElement e = new WebDriverWait(driver,60).
                        until(ExpectedConditions.presenceOfElementLocated
                                (By.xpath("//td[text()='Xero - Hike']//following-sibling::td[1][text()='Created']")));
                if (e.isDisplayed())
                    break;
            }
            sleepFor(2);
            actions.sendKeys(Keys.ESCAPE).build().perform();
            sleepFor(3);
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }


    /**
     * @author Vidhi Chapanera
     * @date 07 April 2021
     * @discription this method is use to create Register summery hike to Xero and verify in Xero
     * @return
     */
    @Step("create Register summery hike to Xero and verify in Xero")
    public boolean createRegisterSummeryHiketoXero() throws IOException {
        CenterlizePO centerlizePO = PageFactory.initElements(driver, CenterlizePO.class);
        Actions actions = new Actions(driver);
        try{
            sleepFor(5);
            ArrayList<String> tabs1 = new ArrayList<String> (driver.getWindowHandles());
            driver.switchTo().window(tabs1.get(1));
            driver.close();
            sleepFor(1);
            driver.switchTo().window(tabs1.get(0));
            sleepFor(2);
            PageFactory.initElements(driver, PointofSale.class).clickOnPointOfSaleButtonn();
            sleepFor(2);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, CashRegister.class).getCashRegisterButton());
            sleepFor(10);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, CashRegister.class).getCloseRegister());
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Customers.class).getContinueButton());
            sleepFor(8);
            String mainWindowHandle = driver.getWindowHandle();
            Set<String> allWindowHandles = driver.getWindowHandles();
            Iterator<String> iterator = allWindowHandles.iterator();
            while (iterator.hasNext()) {
                String ChildWindow = iterator.next();
                if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
                    driver.switchTo().window(ChildWindow);
                    WebElement text = new WebDriverWait(driver,60).until(ExpectedConditions.presenceOfElementLocated(By.tagName("print-preview-app")));
                    System.out.println("Heading of child window is " + text.getText());
                    Actions actions1 = new Actions(driver);
                    actions1.sendKeys(Keys.TAB).build().perform();
                    actions1.sendKeys(Keys.ENTER).build().perform();
                }
            }
            sleepFor(3);
            driver.switchTo().window(mainWindowHandle);
            sleepFor(3);
            PageFactory.initElements(driver, Reporting.class).clickOnReportingButton();
            sleepFor(2);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Register.class).getRegisterButton());
            sleepFor(5);
            WebElement register = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//table[@id='ShiftReportDetailDataTable']//tbody//tr[1]//td[3]")));
            String registerText = register.getText();
            String n = registerText.split("-")[1].substring(0,registerText.split("-")[1].length() - 2);
            String s2 = String.valueOf(n.charAt(n.length()-2))+String.valueOf( n.charAt(n.length()-1));
            WebElement registersync = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//table[@id='ShiftReportDetailDataTable']//tbody//tr[1]//td[1]//a//parent::td//following-sibling::td//a")));
            centerlizePO.clickOnButton(registersync);
            sleepFor(2);
            while(true){
                sleepFor(1);
                centerlizePO.clickOnButton(PageFactory.initElements(driver, Shopify.class).getRefreshLogButton());
                sleepFor(3);
                WebElement e = new WebDriverWait(driver,60).
                        until(ExpectedConditions.presenceOfElementLocated
                                (By.xpath("//td[text()='Hike - Xero']//following-sibling::td[1][text()='Created']")));
                if (e.isDisplayed())
                    break;
            }
            sleepFor(3);
            actions.sendKeys(Keys.ESCAPE).build().perform();
            sleepFor(3);
            JavascriptExecutor jse = (JavascriptExecutor)driver;
            jse.executeScript("window.open()");
            ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));
            driver.get("https://go.xero.com/Dashboard/");
            sleepFor(5);
            JavascriptExecutor executor = (JavascriptExecutor)driver;
            executor.executeScript("arguments[0].click();",getBusinessButton());
            executor.executeScript("arguments[0].click();",getInvoices());
            sleepFor(3);
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMM");
            String strDate = dateFormat.format(new Date());
            if (driver.findElement(By.xpath("//td[contains(text(),'"+strDate+"') and contains(text(),'"+s2+"')]")).isDisplayed()){
                System.out.println("");
            }
            sleepFor(3);
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }


    /**
     * @author Vidhi Chapanera
     * @date 22 April 2021
     * @discription this method is use to create Customers Hike to Xero and verify in Xero
     * @return
     */
    @Step("create Customers Hike to Xero and verify in Xero")
    public boolean createCustomersHiketoXero() throws IOException {
        CenterlizePO centerlizePO = PageFactory.initElements(driver, CenterlizePO.class);
        Actions actions = new Actions(driver);
        try{
            sleepFor(5);
            ArrayList<String> tabs1 = new ArrayList<String> (driver.getWindowHandles());
            driver.switchTo().window(tabs1.get(0));
            PageFactory.initElements(driver, CustomersPO.Customers.class).clickOnCustomersButton();
            sleepFor(2);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, CustomersPO.CustomersPO.Customers.class).getCustomersButton());
            sleepFor(1);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, CustomersPO.CustomersPO.Customers.class).getAddCustomerButton());
            sleepFor(5);
            PageFactory.initElements(driver, QuickBooks.class).renameCustomerName(PageFactory.initElements(driver, CustomersPO.CustomersPO.Customers.class).getFirstName(),"\\src\\main\\java\\IntegrationsPO\\XeroPO\\File\\HikeCustomer");
            PageFactory.initElements(driver, QuickBooks.class).renameCustomerName(PageFactory.initElements(driver, CustomersPO.CustomersPO.Customers.class).getLastName(),"Customer");
            centerlizePO.clickOnButton(PageFactory.initElements(driver, CustomersPO.CustomersPO.Customers.class).getGenderDropDown());
            List<WebElement> elementList = new WebDriverWait(driver,120).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy
                            (By.xpath("//a[@placeholder='Gender']//parent::div//ul//li//span//parent::div[contains(@class,label)]")));
            elementList.get(1).click();
            sleepFor(1);
            centerlizePO.enterDataUsingSendkeys(PageFactory.initElements(driver, CustomersPO.CustomersPO.Customers.class).getCompany(),getValue("\\src\\main\\java\\IntegrationsPO\\XeroPO\\File\\HikeCustomer")+".com");
            centerlizePO.enterDataUsingSendkeys(PageFactory.initElements(driver, CustomersPO.CustomersPO.Customers.class).getEmail(),getValue("\\src\\main\\java\\IntegrationsPO\\XeroPO\\File\\HikeCustomer")+"@yahoo.com");
            centerlizePO.clearText(PageFactory.initElements(driver, CustomersPO.CustomersPO.Customers.class).getAccountLimit());
            centerlizePO.enterDataUsingSendkeys(PageFactory.initElements(driver, CustomersPO.CustomersPO.Customers.class).getAccountLimit(),"50000");
            sleepFor(2);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, LoyaltyPoints.class).getSaveButton());
            sleepFor(5);
            centerlizePO.enterDataUsingSendkeys(PageFactory.initElements(driver, CustomersPO.CustomersPO.Customers.class).getCustomerSearch(),getValue("\\src\\main\\java\\IntegrationsPO\\XeroPO\\File\\HikeCustomer"));
            sleepFor(2);
            WebElement name = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//table[@id='CustomersTable']//tbody//tr//td[2]//span[contains(text(),'"+getValue("\\src\\main\\java\\IntegrationsPO\\XeroPO\\File\\HikeCustomer")+"')]//parent::td//following-sibling::td//a")));
            name.click();
            while(true){
                sleepFor(1);
                centerlizePO.clickOnButton(PageFactory.initElements(driver, Shopify.class).getRefreshLogButton());
                sleepFor(3);
                WebElement e = new WebDriverWait(driver,60).
                        until(ExpectedConditions.presenceOfElementLocated
                                (By.xpath("//td[text()='Hike - Xero']//following-sibling::td[1][text()='Created']")));
                if (e.isDisplayed())
                    break;
            }
            sleepFor(2);
            actions.sendKeys(Keys.ESCAPE).build().perform();
            sleepFor(3);
            ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));
            sleepFor(2);
            JavascriptExecutor executor = (JavascriptExecutor)driver;
            executor.executeScript("arguments[0].click();",getcontactButton());
            sleepFor(7);
            executor.executeScript("arguments[0].click();",getAllcontactButton());
            sleepFor(3);
            WebElement search = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//input[@placeholder='Search']")));
            centerlizePO.clickOnButton(search);
            search.sendKeys(getValue("\\src\\main\\java\\IntegrationsPO\\XeroPO\\File\\HikeCustomer")+"@yahoo.com");
            actions.sendKeys(Keys.ENTER).build().perform();
            sleepFor(3);
            if (driver.findElement(By.xpath("//div[text()='"+getValue("\\src\\main\\java\\IntegrationsPO\\XeroPO\\File\\HikeCustomer")+"@yahoo.com"+"']")).isDisplayed())
                System.out.println(" ");
            sleepFor(1);
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }


    /**
     * @author Vidhi Chapanera
     * @date 22 April 2021
     * @discription this method is use to create Supplier hike to Xero and verify in Xero
     * @return
     */
    @Step("create Supplier hike to Xero and verify in Xero")
    public boolean createSuppliersHiketoXero() throws IOException {
        CenterlizePO centerlizePO = PageFactory.initElements(driver, CenterlizePO.class);
        Actions actions = new Actions(driver);
        try{
            sleepFor(5);
            ArrayList<String> tabs1 = new ArrayList<String> (driver.getWindowHandles());
            driver.switchTo().window(tabs1.get(0));
            sleepFor(2);
            PageFactory.initElements(driver, Inventory.class).clickOnInventoryButton();
            sleepFor(2);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Suppliers.class).getSuppliersButton());
            sleepFor(5);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Suppliers.class).getAddNewButton());
            sleepFor(5);
            PageFactory.initElements(driver, Shopify.class).renameFileData(PageFactory.initElements(driver, Suppliers.class).getCompanyName(),"\\src\\main\\java\\IntegrationsPO\\XeroPO\\File\\Supplier");
            sleepFor(3);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Suppliers.class).getSaveButton());
            sleepFor(3);
            centerlizePO.enterDataUsingSendkeys(PageFactory.initElements(driver,Suppliers.class).getSearch(),getValue("\\src\\main\\java\\IntegrationsPO\\XeroPO\\File\\Supplier"));
            sleepFor(2);
            WebElement supplierName = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//table[@id='SupplierTable']//tbody//tr//td//a[contains(text(),'"+getValue("\\src\\main\\java\\IntegrationsPO\\XeroPO\\File\\Supplier")+"')]//parent::td//following-sibling::td//a")));
            centerlizePO.clickOnButton(supplierName);
            sleepFor(4);
            while(true){
                sleepFor(1);
                centerlizePO.clickOnButton(PageFactory.initElements(driver, Shopify.class).getRefreshLogButton());
                sleepFor(3);
                WebElement e = new WebDriverWait(driver,60).
                        until(ExpectedConditions.presenceOfElementLocated
                                (By.xpath("//td[text()='Hike - Xero']//following-sibling::td[1][text()='Created']")));
                if (e.isDisplayed())
                    break;
            }
            sleepFor(2);
            actions.sendKeys(Keys.ESCAPE).build().perform();
            sleepFor(3);
            driver.switchTo().window(tabs1.get(1));
            JavascriptExecutor executor = (JavascriptExecutor)driver;
            executor.executeScript("arguments[0].click();",getcontactButton());
            sleepFor(7);
            executor.executeScript("arguments[0].click();",getAllcontactButton());
            sleepFor(3);
            WebElement search = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//input[@placeholder='Search']")));
            centerlizePO.clickOnButton(search);
            search.sendKeys(getValue("\\src\\main\\java\\IntegrationsPO\\XeroPO\\File\\Supplier"));
            actions.sendKeys(Keys.ENTER).build().perform();
            sleepFor(3);
            if (driver.findElement(By.xpath("//a[text()='"+getValue("\\src\\main\\java\\IntegrationsPO\\XeroPO\\File\\Supplier")+"']")).isDisplayed())
                System.out.println(" ");
            sleepFor(1);
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }



    /**
     * @author Vidhi Chapanera
     * @date 22 April 2021
     * @discription this method is use to create Customer Xero to hike and verify in hike
     * @return
     */
    @Step("create Customer Xero to hike and verify in hike")
    public boolean createCustomersXerotoHike() throws IOException {
        CenterlizePO centerlizePO = PageFactory.initElements(driver, CenterlizePO.class);
        Actions actions = new Actions(driver);
        try{
            sleepFor(1);
            ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));
            sleepFor(2);
            JavascriptExecutor executor = (JavascriptExecutor)driver;
            executor.executeScript("arguments[0].click();",getcontactButton());
            sleepFor(7);
            executor.executeScript("arguments[0].click();",getAllcontactButton());
            sleepFor(3);
            centerlizePO.clickOnButton(getAddContactButton());
            reNameXeroCustomerFileData(getContactName());
            centerlizePO.clickOnButton( getSaveContactButton() );
            sleepFor(5);
            executor.executeScript("arguments[0].click();",getBusinessButton());
            executor.executeScript("arguments[0].click();",getInvoices());
            sleepFor(3);
            centerlizePO.clickOnButton(getNewInvoices());
            sleepFor(3);
            driver.switchTo().frame("contactsAutoCompleter");
            WebElement to = new WebDriverWait(driver,60).until(
                    ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='trigger']//input")));
            centerlizePO.enterDataUsingSendkeys(to,getValue("\\src\\main\\java\\IntegrationsPO\\XeroPO\\File\\XCustomer"));
            actions.sendKeys(Keys.ARROW_DOWN).build().perform();
            actions.sendKeys(Keys.TAB).build().perform();
            driver.switchTo().defaultContent();
            WebElement invoice = new WebDriverWait(driver,60).until(
                    ExpectedConditions.presenceOfElementLocated(By.xpath("//input[contains(@id,'InvoiceNumber')]")));
            String invoiceNumber = invoice.getAttribute("value");
            System.out.println(invoiceNumber);
            WebElement duedate = new WebDriverWait(driver,60).until(
                    ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@id,'DueDate')]//input[contains(@id,'DueDate')]")));
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy");
            String strDate = dateFormat.format(new Date());
            centerlizePO.enterDataUsingSendkeys(duedate,strDate);
            List<WebElement> additem = new  WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[text()='Item']//parent::td//parent::tr//parent::thead//parent::table//parent::div//parent::div//parent::div//following-sibling::div//div//tr//td[2]//div")));
            centerlizePO.clickOnButton( additem.get(0));
            WebElement e1 = new WebDriverWait( driver,60).
                    until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='Item']//parent::td//parent::tr//parent::thead//parent::table//parent::div//parent::div//parent::div//following-sibling::div//div//input")));
            centerlizePO.enterDataUsingSendkeys(e1,getValue("\\src\\main\\java\\IntegrationsPO\\XeroPO\\File\\HProduct"));
            actions.sendKeys( Keys.TAB ).build().perform();
            List<WebElement> adddis = new  WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[text()='Item']//parent::td//parent::tr//parent::thead//parent::table//parent::div//parent::div//parent::div//following-sibling::div//div//tr//td[3]//div")));
            centerlizePO.clickOnButton( adddis.get(0) );
            WebElement e2 = new WebDriverWait( driver,60).
                    until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='Item']//parent::td//parent::tr//parent::thead//parent::table//parent::div//parent::div//parent::div//following-sibling::div//div//textarea")));
            centerlizePO.enterDataUsingSendkeys(e2,"test");
            centerlizePO.clickOnButton( getApprove() );
            sleepFor(5);
            WebElement datepaid = new WebDriverWait(driver,60).until(
                    ExpectedConditions.presenceOfElementLocated(By.cssSelector("#DatePaidCalendar")));
            SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd MMM yyyy");
            String strDate1 = dateFormat1.format(new Date());
            centerlizePO.enterDataUsingSendkeys( datepaid,strDate1 );
            WebElement paidto = new WebDriverWait(driver,60).until(
                    ExpectedConditions.presenceOfElementLocated(By.cssSelector("#PaidFromDropDown_value")));
            centerlizePO.enterDataUsingSendkeys( paidto,"Cash" );
            sleepFor(2);
            actions.sendKeys( Keys.TAB ).build().perform();
            WebElement makepaymentbtn = new WebDriverWait(driver,60).until(
                    ExpectedConditions.presenceOfElementLocated(By.cssSelector("#makePaymentSubmit")));
            centerlizePO.clickOnButton(makepaymentbtn);
            sleepFor(5);
            driver.switchTo().window(tabs.get(0));
            sleepFor(2);
            PageFactory.initElements(driver, StoreSetup.class).clickOnStoreSetupButton();
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Integrations.class).getIntegrationsButton());
            sleepFor(3);
            centerlizePO.clickOnButton(getManageButton());
            sleepFor(5);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Shopify.class).getManualSyncButton());
            sleepFor(4);
            String[] strArray2 = new String[]{"syncSales", "syncCustomers"};
            for (String s : strArray2) {
                WebElement element = new WebDriverWait(driver, 60).ignoring(StaleElementReferenceException.class).
                        until(ExpectedConditions.presenceOfElementLocated
                                (By.xpath("//label[@for='" + s + "']")));
                element.click();
            }
            sleepFor(1);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Shopify.class).getButtonSyncNow());
            sleepFor(2);
            centerlizePO.clickOnButton(getXeroSaveButton());
            sleepFor(10);
            PageFactory.initElements(driver, CustomersPO.Customers.class).clickOnCustomersButton();
            sleepFor(2);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, CustomersPO.CustomersPO.Customers.class).getCustomersButton());
            sleepFor(1);
            centerlizePO.enterDataUsingSendkeys(PageFactory.initElements(driver, CustomersPO.CustomersPO.Customers.class).getCustomerSearch(),getValue("\\src\\main\\java\\IntegrationsPO\\XeroPO\\File\\XCustomer"));
            sleepFor(2);
            WebElement name = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//table[@id='CustomersTable']//tbody//tr//td[3][contains(text(),'"+getValue("\\src\\main\\java\\IntegrationsPO\\XeroPO\\File\\XCustomer")+"')]//parent::td//following-sibling::td//a")));
            name.click();
            while(true){
                sleepFor(1);
                centerlizePO.clickOnButton(PageFactory.initElements(driver, Shopify.class).getRefreshLogButton());
                sleepFor(3);
                WebElement e = new WebDriverWait(driver,60).
                        until(ExpectedConditions.presenceOfElementLocated
                                (By.xpath("//td[text()='Xero - Hike']//following-sibling::td[1][text()='Created']")));
                if (e.isDisplayed())
                    break;
            }
            sleepFor(2);
            actions.sendKeys(Keys.ESCAPE).build().perform();
            sleepFor(3);
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }



    /**
     * @author Vidhi Chapanera
     * @date 22 April 2021
     * @return
     * @throws IOException
     * @discription this method is used to rename the text file data
     */
    @Step("")
    public boolean reNameXeroCustomerFileData(WebElement el) throws IOException {
        String tesLine ="";
        try {
            File f = new File(System.getProperty("user.dir") + "\\src\\main\\java\\IntegrationsPO\\XeroPO\\File\\XCustomer");
            f.canWrite();
            Scanner scanner = new Scanner(f);
            while (scanner.hasNextLine()) {
                tesLine += scanner.nextLine();
            }
            scanner.close();
            String string = tesLine;
            int number = Integer.parseInt( CharMatcher.digit().retainFrom(string));
            int sum = number + 1;
            String oldValue = String.valueOf(number);
            String newValue = String.valueOf(sum);
            String finalString = tesLine.replace(oldValue, newValue);
            String dataText = finalString;
            System.out.println(dataText);
            FileWriter myWriter = new FileWriter(f);
            myWriter.write(dataText);
            myWriter.close();
            PageFactory.initElements(driver, CenterlizePO.class).enterDataUsingSendkeys(el, dataText);
            synchronized (dataText) {
                System.out.println(true);
            }
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }


    /**
     * @author Vidhi Chapanera
     * @date 22 April 2021
     * @discription this method is use to create Supplier Xero to hike and verify in hike
     * @return
     */
    @Step("create Supplier Xero to hike and verify in hike")
    public boolean createSuppliersXerotoHike() throws IOException {
        CenterlizePO centerlizePO = PageFactory.initElements(driver, CenterlizePO.class);
        Actions actions = new Actions(driver);
        try{
            sleepFor(5);
            ArrayList<String> tabs1 = new ArrayList<String> (driver.getWindowHandles());
            driver.switchTo().window(tabs1.get(1));
            JavascriptExecutor executor = (JavascriptExecutor)driver;
            executor.executeScript("arguments[0].click();",getcontactButton());
            sleepFor(7);
            executor.executeScript("arguments[0].click();",getAllcontactButton());
            sleepFor(3);
            centerlizePO.clickOnButton(getAddContactButton());
            PageFactory.initElements(driver, Shopify.class).renameFileData(getContactName(),"\\src\\main\\java\\IntegrationsPO\\XeroPO\\File\\XSupplier");
            centerlizePO.clickOnButton( getSaveContactButton() );
            sleepFor(5);
            executor.executeScript("arguments[0].click();",getBusinessButton());
            executor.executeScript("arguments[0].click();",getPurchaseorders());
            sleepFor(3);
            centerlizePO.clickOnButton( getNewPurchaseOrderButton());
            centerlizePO.enterDataUsingSendkeys( getContact(),getValue("\\src\\main\\java\\IntegrationsPO\\XeroPO\\File\\XSupplier"));
            sleepFor(3);
            actions.sendKeys(Keys.ARROW_DOWN).build().perform();
            actions.sendKeys( Keys.TAB ).build().perform();
            sleepFor( 2 );
            List<WebElement> additem = new  WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//span[text()='Item']//parent::div//parent::div//parent::div//parent::div//parent::div//parent::div//td[2]")));
            centerlizePO.clickOnButton( additem.get(0) );
            WebElement e1 = new WebDriverWait( driver,60).
                    until(ExpectedConditions.presenceOfElementLocated(By.name("PriceListItemID")));
            centerlizePO.enterDataUsingSendkeys(e1,getValue("\\src\\main\\java\\IntegrationsPO\\XeroPO\\File\\HProduct"));
            actions.sendKeys( Keys.TAB ).build().perform();
            List<WebElement> adddis = new  WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//span[text()='Item']//parent::div//parent::div//parent::div//parent::div//parent::div//parent::div//td[3]")));
            centerlizePO.clickOnButton( adddis.get(0) );
            WebElement e2 = new WebDriverWait( driver,60).
                    until(ExpectedConditions.presenceOfElementLocated(By.name("Description")));
            centerlizePO.enterDataUsingSendkeys(e2,"test");
            centerlizePO.clickOnButton( getApprove() );
            centerlizePO.clickOnButton( getApprove() );
            sleepFor(2);
            centerlizePO.clickOnButton(getMarkAsBilled());
            centerlizePO.clickOnButton(getCopyPOCheckBox());
            centerlizePO.clickOnButton(getOKButton());
            sleepFor(3);
            WebElement duedate = new WebDriverWait(driver,60).until(
                    ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@id,'DueDate')]//input[contains(@id,'DueDate')]")));
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy");
            String strDate = dateFormat.format(new Date());
            centerlizePO.enterDataUsingSendkeys(duedate,strDate);
            centerlizePO.clickOnButton(getBillApproveButton());
            WebElement datepaid = new WebDriverWait(driver,60).until(
                    ExpectedConditions.presenceOfElementLocated(By.cssSelector("#DatePaidCalendar")));
            SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd MMM yyyy");
            String strDate1 = dateFormat1.format(new Date());
            centerlizePO.enterDataUsingSendkeys( datepaid,strDate1 );
            WebElement paidto = new WebDriverWait(driver,60).until(
                    ExpectedConditions.presenceOfElementLocated(By.cssSelector("#PaidFromDropDown_value")));
            centerlizePO.enterDataUsingSendkeys( paidto,"Cash" );
            sleepFor(2);
            actions.sendKeys( Keys.TAB ).build().perform();
            WebElement makepaymentbtn = new WebDriverWait(driver,60).until(
                    ExpectedConditions.presenceOfElementLocated(By.cssSelector("#makePaymentSubmit")));
            centerlizePO.clickOnButton(makepaymentbtn);
            sleepFor(5);
            driver.switchTo().window(tabs1.get(0));
            sleepFor(2);
            PageFactory.initElements(driver, Users.class).clickOnUsersButton();
            PageFactory.initElements(driver, StoreSetup.class).clickOnStoreSetupButton();
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Integrations.class).getIntegrationsButton());
            sleepFor(3);
            centerlizePO.clickOnButton(getManageButton());
            sleepFor(5);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Shopify.class).getManualSyncButton());
            sleepFor(4);
            String[] strArray2 = new String[]{"syncPurchase", "syncSupplier"};
            for (String s : strArray2) {
                WebElement element = new WebDriverWait(driver, 60).ignoring(StaleElementReferenceException.class).
                        until(ExpectedConditions.presenceOfElementLocated
                                (By.xpath("//label[@for='" + s + "']")));
                element.click();
            }
            sleepFor(1);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Shopify.class).getButtonSyncNow());
            sleepFor(2);
            centerlizePO.clickOnButton(getXeroSaveButton());
            sleepFor(10);
            PageFactory.initElements(driver, Inventory.class).clickOnInventoryButton();
            sleepFor(2);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Suppliers.class).getSuppliersButton());
            sleepFor(5);
            centerlizePO.enterDataUsingSendkeys(PageFactory.initElements(driver,Suppliers.class).getSearch(),getValue("\\src\\main\\java\\IntegrationsPO\\XeroPO\\File\\XSupplier"));
            sleepFor(2);
            WebElement supplierName = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//table[@id='SupplierTable']//tbody//tr//td//a[contains(text(),'"+getValue("\\src\\main\\java\\IntegrationsPO\\XeroPO\\File\\XSupplier")+"')]//parent::td//following-sibling::td//a")));
            centerlizePO.clickOnButton(supplierName);
            sleepFor(4);
            while(true){
                sleepFor(1);
                centerlizePO.clickOnButton(PageFactory.initElements(driver, Shopify.class).getRefreshLogButton());
                sleepFor(3);
                WebElement e = new WebDriverWait(driver,60).
                        until(ExpectedConditions.presenceOfElementLocated
                                (By.xpath("//td[text()='Xero - Hike']//following-sibling::td[1][text()='Created']")));
                if (e.isDisplayed())
                    break;
            }
            sleepFor(2);
            actions.sendKeys(Keys.ESCAPE).build().perform();
            sleepFor(3);

            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }



    /**
     * @author Vidhi Chapanera
     * @date 16 April 2021
     * @discription this method is use to automate Xero
     * @return
     */
    @Step("automate Xero")
    public boolean automateXero() throws IOException {
        try{
            createHikeStoreForXero();
            PageFactory.initElements(driver,Shopify.class).PurgeData();
            loginXeroStoreAndCreateNewOrganization();
            clickOnActivateButtonOnXero();
            mappingXero();
            createProductHiketoxero();
            createProductXerotoHike();
            createCustomersHiketoXero();
            createCustomersXerotoHike();
            createSuppliersHiketoXero();
            createSuppliersXerotoHike();
            createPurchaseOrderHiketoXero();
            createPurchaseOrderXerotoHike();
            createSaleHiketoXero();
            createSaleXerotoHike();
            createRegisterSummeryHiketoXero();
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
        finally {
            ArrayList<String> tabs1 = new ArrayList<String> (driver.getWindowHandles());
            driver.switchTo().window(tabs1.get(0));
            CenterlizePO centerlizePO = PageFactory.initElements(driver, CenterlizePO.class);
            PageFactory.initElements(driver, Users.class).clickOnUsersButton();
            PageFactory.initElements(driver, StoreSetup.class).clickOnStoreSetupButton();
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Integrations.class).getIntegrationsButton());
            sleepFor(3);
            centerlizePO.clickOnButton(getManageButton());
            sleepFor(5);
            centerlizePO.clickOnButton(PageFactory.initElements( driver, QuickBooks.class ).getDeleteThisIntegrationButton());
            sleepFor(5);
            centerlizePO.clickOnButton(PageFactory.initElements(driver,CashRegister.class).getContinueButton());
            sleepFor(5);
        }
    }




    /**
     * @author Vidhi Chapanera
     * @date 19 April 2021
     * @discription this method is use to Login to Xero store
     * @return
     */
    @Step("Login to Xero store")
    public boolean loginXeroStoreAndCreateNewOrganization() throws IOException {
        CenterlizePO centerlizePO = PageFactory.initElements(driver,CenterlizePO.class);
        String fileLocation =System.getProperty("user.dir")+"\\src\\main\\resources\\Xero.properties";
        Properties properties1 = new Properties();
        properties1.load(new FileReader(fileLocation));
        try{
            sleepFor(2);
            JavascriptExecutor jse = (JavascriptExecutor)driver;
            jse.executeScript("window.open()");
            ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));
            sleepFor(1);
            driver.get("https://login.xero.com/");
            centerlizePO.enterDataUsingSendkeys(getXeroUserName(),String.valueOf(properties1.put( XeroConstant.XERO_EMAIL_ID,"xero.email.id")));
            centerlizePO.enterDataUsingSendkeys(getXeroPassword(),String.valueOf(properties1.put( XeroConstant.XERO_PASSWORD,"xero.password")));
            centerlizePO.clickOnButton(getLoginButton());
            sleepFor(5);
            centerlizePO.clickOnButton(getAnotherAuthenticationMethodButton());
            sleepFor( 1);
            centerlizePO.clickOnButton(getBackupEmailButton());
            sleepFor( 1);
            centerlizePO.clickOnButton(getSendCodeButton());
            sleepFor( 30);
            readEmail();
            centerlizePO.enterDataUsingSendkeys( getConfirmationCodeText(),verificationCode);
            centerlizePO.clickOnButton(getLoginButton());
            centerlizePO.clickOnButton(getXeroMainDropDown());
            sleepFor(2);
            centerlizePO.clickOnButton( getMyXeroButton() );
            ArrayList<String> tabs1 = new ArrayList<String> (driver.getWindowHandles());
            driver.switchTo().window(tabs1.get(2));
            sleepFor(5);
            WebElement addorg = new WebDriverWait(driver,60).until(ExpectedConditions.presenceOfElementLocated
                    (By.xpath("//a[normalize-space(.)='Add an organisation']")));
            centerlizePO.clickOnButton(addorg);
           /* try {
                centerlizePO.clickOnButton( getXeroMainDropDown() );
                sleepFor( 2 );
                if (getAddAnotherOrganisation().isDisplayed()) {
                    centerlizePO.clickOnButton( getAddAnotherOrganisation() );
                }else{
                    System.out.println("else");
                    WebElement changeBtn = new WebDriverWait( driver, 60 ).until( ExpectedConditions.presenceOfElementLocated
                            ( By.xpath("//button[text()='Change organisation']") ) );
                    centerlizePO.clickOnButton( changeBtn );
                    centerlizePO.clickOnButton( getAddAnotherOrganisation() );
                }
            }catch (Exception e){
                System.out.println("catch");
                WebElement changeBtn = new WebDriverWait( driver, 60 ).until( ExpectedConditions.presenceOfElementLocated
                        ( By.xpath("//button[text()='Change organisation']") ) );
                centerlizePO.clickOnButton( changeBtn );
                centerlizePO.clickOnButton( getAddAnotherOrganisation() );
            }*/
            PageFactory.initElements(driver, CreateStore.class).renameFileData
                    (getBusinessName(),"\\src\\main\\java\\IntegrationsPO\\XeroPO\\File\\XeroStore");
            centerlizePO.enterDataUsingSendkeys(getIndustry(),"Retail Clothing");
            Actions actions= new Actions( driver );
            actions.sendKeys( Keys.TAB ).build().perform();
            sleepFor( 1 );
            centerlizePO.clickOnButton(getYesButton());
            sleepFor(2);
            centerlizePO.clickOnButton(getStartTrail());
            sleepFor( 30);
            driver.close();
            ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
            driver.switchTo().window(tabs2.get(1));
            sleepFor(2);
            driver.navigate().refresh();
                /*centerlizePO.clickOnButton(getXeroMainDropDown());
                WebElement store = new WebDriverWait(driver,60).until(ExpectedConditions.presenceOfElementLocated
                        (By.xpath("//ol//a[text()='"+getValue( "\\src\\main\\java\\IntegrationsPO\\XeroPO\\File\\XeroStore")+"']")));
                centerlizePO.clickOnButton(store);*/
            centerlizePO.clickOnButton(getAccountingButton());
            centerlizePO.clickOnButton(getChartOfAccount());
            centerlizePO.clickOnButton(getImportButton());
            getBrowseButton().sendKeys(System.getProperty("user.dir")+"\\src\\main\\java\\IntegrationsPO\\XeroPO\\File\\XeroChartOfAccounts.csv");
            centerlizePO.clickOnButton(getImportFileButton());
            centerlizePO.clickOnButton(getConfirmButton());
            WebElement cashdrpdwn = new WebDriverWait(driver,60).until(ExpectedConditions.presenceOfElementLocated
                    (By.xpath("//td[text()='Cash']//parent::tr//a[contains(@id,'AccountType')]")));
            cashdrpdwn.click();
            WebElement cashdrpdwno = new WebDriverWait(driver,60).until(ExpectedConditions.presenceOfElementLocated
                    (By.xpath("//td[text()='Cash']//parent::tr//a[contains(@id,'AccountType')]//parent::div//parent::div//following-sibling::div//div[text()='Bank']")));
            cashdrpdwno.click();
            WebElement carddrpdwn = new WebDriverWait(driver,60).until(ExpectedConditions.presenceOfElementLocated
                    (By.xpath("//td[text()='Card']//parent::tr//a[contains(@id,'AccountType')]")));
            carddrpdwn.click();
            WebElement carddrpdwn0 = new WebDriverWait(driver,60).until(ExpectedConditions.presenceOfElementLocated
                    (By.xpath("//td[text()='Card']//parent::tr//a[contains(@id,'AccountType')]//parent::div//parent::div//following-sibling::div//div[text()='Credit Card']")));
            carddrpdwn0.click();
            centerlizePO.clickOnButton(getSaveButton());
            sleepFor(2);
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }


}
