package IntegrationsPO.QuickBooksPO;

import CommonPO.BasePage;
import CommonPO.CenterlizePO;
import Config.ExcelUtils;
import CreateStorePO.CreateStore;
import CreateStorePO.StoreConstant;
import CustomersPO.CustomersPO.Customers;
import IntegrationsPO.Integrations;
import IntegrationsPO.ShopifyPO.Shopify;
import InventoryPO.Inventory;
import InventoryPO.PurchasesPO.Purchases;
import InventoryPO.SuppliersPO.Suppliers;
import LoginPO.Login;
import LoginPO.LoginConstant;
import PointofSalePO.CashRegisterPO.CashRegister;
import PointofSalePO.PointofSale;
import PointofSalePO.ProcessSalePO.ProcessSale;
import PointofSalePO.SalesHistoryPO.SalesHistory;
import ProductsPO.GiftCardsPO.GiftCards;
import ProductsPO.ProductsPO.Products;
import ReportingPO.RegisterPO.Register;
import ReportingPO.Reporting;
import StoreSetupPO.GeneralPO.General;
import StoreSetupPO.LoyaltyPointsPO.LoyaltyPoints;
import StoreSetupPO.MyAccountPO.MyAccount;
import StoreSetupPO.StoreSetup;
import UsersPO.Users;
import com.google.common.base.CharMatcher;
import io.qameta.allure.Step;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Key;
import org.testng.Assert;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * @author Vidhi Chapanera
 * @date 01 April 2021
 */
public class QuickBooks extends BasePage {

    public WebDriver driver;
    public static String dataText = "";


    public QuickBooks(WebDriver driver) {
        this.driver = driver;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for QuickBooks activate button
     * @date 01 April 2021
     */
    @FindBy(how = How.XPATH, using = "//table//tr//td[contains(text(),'QuickBooks')]//parent::tr//button[text()='Activate']")
    WebElement btn_QuickBooksactivate;
    public WebElement getQuickBooksActivate() {
        return btn_QuickBooksactivate;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for QuickBooks email input box
     * @date 01 April 2021
     */
    @FindBy(how = How.XPATH, using = "//input[@name='Email']")
    WebElement txt_emailQBO;
    public WebElement getEmailQBO() {
        return txt_emailQBO;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Password email input box
     * @date 01 April 2021
     */
    @FindBy(how = How.XPATH, using = "//input[@name='Password']")
    WebElement txt_PasswordQBO;
    public WebElement getPasswordQBO() {
        return txt_PasswordQBO;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for signin button
     * @date 01 April 2021
     */
    @FindBy(how = How.XPATH, using = "//button[@name='SignIn']")
    WebElement btn_signin;
    public WebElement getSignInButton() {
        return btn_signin;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for signin with google button
     * @date 01 April 2021
     */
    @FindBy(how = How.XPATH, using = "//span[text()='Sign in with Google']//parent::div//parent::button")
    WebElement btn_signinwithgoogle;
    public WebElement getSignInWithGoogleButton() {
        return btn_signinwithgoogle;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for email or phone input box
     * @date 01 April 2021
     */
    @FindBy(how = How.XPATH, using = "//div[text()='Email or phone']//parent::div//input")
    WebElement txt_emailorphone;
    public WebElement getEmailOrPhone() {
        return txt_emailorphone;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for email input box
     * @date 23 July 2021
     */
    @FindBy(how = How.XPATH, using = "//input[@name='Email']")
    WebElement txt_email;
    public WebElement getEmail() {
        return txt_email;
    }



    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Enter your password input box
     * @date 01 April 2021
     */
    @FindBy(how = How.XPATH, using = "//div[text()='Enter your password']//parent::div//input")
    WebElement txt_Enteryourpassword;
    public WebElement getEnterYourPassword() {
        return txt_Enteryourpassword;
    }

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Enter your password input box
     * @date 01 April 2021
     */
    @FindBy(how = How.XPATH, using = "//input[@name='Password']")
    WebElement txt_Enteryourpassword1;
    public WebElement getEnterYourPassword1() {
        return txt_Enteryourpassword1;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for next button
     * @date 01 April 2021
     */
    @FindBy(how = How.XPATH, using = "//span[text()='Next']//parent::button")
    WebElement btn_next;
    public WebElement getNextButton() {
        return btn_next;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Save Button
     * @date 02 April 2021
     */
    @FindBy(how = How.XPATH, using = "//form[@name='quickbookSettings']//div[@class='slider-modal-actions']//button[text()='Save']")
    //@FindBy(how = How.XPATH, using = "//form[@name='xeroSettings']//div[@class='slider-modal-actions']//button[text()='Save']")
            WebElement btn_save;
    public WebElement getSaveButton() {
        return btn_save;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for manage Button
     * @date 02 April 2021
     */
    @FindBy(how = How.XPATH, using = "//table//tr//td[contains(text(),'QuickBooks')]//parent::tr//button[contains(text(),'Manage')]")
    WebElement btn_manage;
    public WebElement getManageButton() {
        return btn_manage;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for continue button
     * @date 02 April 2021
     */
    @FindBy(how = How.XPATH, using = "//div[@class='slider-modal-actions']//button[text()='Continue']")
    WebElement btn_continue;
    public WebElement getContinueButton() {
        return btn_continue;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Save & sync now button
     * @date 02 April 2021
     */
    @FindBy(how = How.XPATH, using = "//div[@class='slider-modal-actions']//button[text()='Save & sync now']")
    WebElement btn_savesync;
    public WebElement getSaveAndSyncButton() {
        return btn_savesync;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for sync process log
     * @date 02 April 2021
     */
    @FindBy(how = How.XPATH, using = "//table//tr//td[contains(text(),'QuickBooks')]//parent::tr//a[contains(text(),'Sync process log')]")
    WebElement btn_syncprocesslog;
    public WebElement getSyncProcessLogButton() {
        return btn_syncprocesslog;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for sales button QBO
     * @date 02 April 2021
     */
    @FindBy(how = How.XPATH, using = "//span[text()='Sales']")
    WebElement btn_salesQBO;
    public WebElement getSalesQBO() {
        return btn_salesQBO;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Customers button QBO
     * @date 02 April 2021
     */
    @FindBy(how = How.XPATH, using = "//a[text()='Customers']")
    WebElement btn_CustomersQBO;
    public WebElement getCustomersQBO() {
        return btn_CustomersQBO;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for add new  Customers button QBO
     * @date 05 April 2021
     */
    @FindBy(how = How.XPATH, using = "//span[text()='New customer']//parent::button")
    WebElement btn_addnewCustomersQBO;
    public WebElement getNewCustomerButton() {
        return btn_addnewCustomersQBO;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for firstName input box QBO
     * @date 05 April 2021
     */
    @FindBy(how = How.NAME, using = "firstName")
    WebElement txt_firstnameQBO;
    public WebElement getFirstNameTextBoxQBO() {
        return txt_firstnameQBO;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for save button QBO
     * @date 05 April 2021
     */
    @FindBy(how = How.XPATH, using = "//div[@id='customerDialog']//button[text()='Save']")
    WebElement btn_saveQBO;
    public WebElement getSaveButtonQBO() {
        return btn_saveQBO;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Products and Services button QBO
     * @date 05 April 2021
     */
    @FindBy(how = How.XPATH, using = "//a[text()='Products and Services']")
    WebElement btn_ProductsandServicesQBO;
    public WebElement getProductsAndServicesQBO() {
        return btn_ProductsandServicesQBO;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Products and Services filter button QBO
     * @date 05 April 2021
     */
    @FindBy(how = How.XPATH, using = "//i[contains(@class,'filter')]//parent::a")
    WebElement btn_ProductsandServicesfilterQBO;
    public WebElement getProductsAndServicesFilterQBO() {
        return btn_ProductsandServicesfilterQBO;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Apply button QBO
     * @date 05 April 2021
     */
    @FindBy(how = How.XPATH, using = "//button[text()='Apply']")
    WebElement btn_Apply;
    public WebElement getApplyQBO() {
        return btn_Apply;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for product search bar input box QBO
     * @date 05 April 2021
     */
    @FindBy(how = How.XPATH, using = "//input[@placeholder='Find products and services']")
    WebElement txt_productSearchbarr;
    public WebElement getProductSearchBar() {
        return txt_productSearchbarr;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for add new product button QBO
     * @date 05 April 2021
     */
    @FindBy(how = How.XPATH, using = "//span[text()='New' and @class='label']//parent::button")
    WebElement btn_addnewproduct;
    public WebElement getAddNewProductButton() {
        return btn_addnewproduct;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for non-inventory label QBO
     * @date 05 April 2021
     */
    @FindBy(how = How.XPATH, using = "//div[text()='Non-inventory']")
    WebElement lbl_noninventory;
    public WebElement getNonInventoryLabel() {
        return lbl_noninventory;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for name text area QBO
     * @date 05 April 2021
     */
    @FindBy(how = How.XPATH, using = "//label[text()='Name']//following-sibling::textarea")
    WebElement txt_name;
    public WebElement getNameTextAreaNonInventory() {
        return txt_name;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for save and close QBO
     * @date 05 April 2021
     */
    @FindBy(how = How.XPATH, using = "//button[text()='Save and close']")
    WebElement btn_saveandclose;
    public WebElement getSaveAndClose() {
        return btn_saveandclose;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for all sales button QBO
     * @date 06 April 2021
     */
    @FindBy(how = How.XPATH, using = "//a[text()='All Sales']")
    WebElement btn_allsales;
    public WebElement getAllSalesButton() {
        return btn_allsales;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for filter button QBO
     * @date 06 April 2021
     */
    @FindBy(how = How.XPATH, using = "//span[text()='Filter']//parent::button")
    WebElement btn_filter;
    public WebElement getfilterButton() {
        return btn_filter;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Invoices button QBO
     * @date 06 April 2021
     */
    @FindBy(how = How.XPATH, using = "//a[text()='Invoices']")
    WebElement btn_Invoices;
    public WebElement getInvoicesButton() {
        return btn_Invoices;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Create Invoices button QBO
     * @date 06 April 2021
     */
    @FindBy(how = How.XPATH, using = "//span[text()='Create invoice']//parent::span//parent::button")
    WebElement btn_CreateInvoices;
    public WebElement getCreateInvoicesButton() {
        return btn_CreateInvoices;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for customer QBO
     * @date 06 April 2021
     */
    @FindBy(how = How.XPATH, using = "//input[@placeholder='Select a customer']")
    WebElement btn_customerQBO;
    public WebElement getCustomerQBO() {
        return btn_customerQBO;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for save customer button QBO
     * @date 06 April 2021
     */
    @FindBy(how = How.XPATH, using = "//form[@class='form quickAdd']//button[text()='Save']")
    WebElement btn_savecustomerQBO;
    public WebElement getSaveCustomerQBO() {
        return btn_savecustomerQBO;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for save and close button QBO
     * @date 06 April 2021
     */
    @FindBy(how = How.XPATH, using = "//button[text()='Save and close' and @class='combo-button-main']")
    WebElement btn_saveandcloseQBO;
    public WebElement getSaveandcloseQBO() {
        return btn_saveandcloseQBO;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Expenses button QBO
     * @date 06 April 2021
     */
    @FindBy(how = How.XPATH, using = "//span[text()='Expenses']")
    WebElement btn_expensesQBO;
    public WebElement getExpensesQBO() {
        return btn_expensesQBO;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Suppliers button QBO
     * @date 06 April 2021
     */
    @FindBy(how = How.XPATH, using = "//a[text()='Suppliers']")
    WebElement btn_Suppliers;
    public WebElement getSuppliersButton() {
        return btn_Suppliers;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for add new supplier button QBO
     * @date 05 April 2021
     */
    @FindBy(how = How.XPATH, using = "//span[text()='New supplier' and @class='label']//parent::button")
    WebElement btn_newsuppliert;
    public WebElement getNewSupplierButton() {
        return btn_newsuppliert;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Delete this integration Button
     * @date 07 April 2021
     */
    @FindBy(how = How.XPATH, using = "//a[text()='Delete this integration']")
    WebElement btn_deleteThisintegration;
    public WebElement getDeleteThisIntegrationButton() {
        return btn_deleteThisintegration;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Expenses button QBO
     * @date 07 April 2021
     */
    @FindBy(how = How.XPATH, using = "//a[text()='Expenses']")
    WebElement btn_Expenses;
    public WebElement getExpensesButton() {
        return btn_Expenses;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for New transaction button QBO
     * @date 07 April 2021
     */
    @FindBy(how = How.XPATH, using = "//span[contains(text(),'New transaction')]//parent::button")
    WebElement btn_newtransaction;
    public WebElement getNewTransactionButton() {
        return btn_newtransaction;
    }

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Purchase order button QBO
     * @date 07 April 2021
     */
    @FindBy(how = How.XPATH, using = "//td[contains(text(),'Purchase order')]")
    WebElement btn_Purchaseorder;
    public WebElement getPurchaseOrderButton() {
        return btn_Purchaseorder;
    }




    /**
     * @author Vidhi Chapanera
     * @date 01 April 2021
     * @discription this method is use to create hike store for QuickBooks
     * @return
     */
   /* @Step("create hike store for QuickBooks")
    public boolean createHikeStoreForQuickBooks(){
        CenterlizePO centerlizePO = PageFactory.initElements(driver,CenterlizePO.class);
        try{
            sleepFor(5);
            String fileLocation =System.getProperty("user.dir")+"\\src\\main\\resources\\createStore.properties";
            Properties properties1 = new Properties();
            properties1.load(new FileReader(fileLocation));
            centerlizePO.clickOnButton(PageFactory.initElements(driver, CreateStore.class).getStartFreeTrialLink());
            PageFactory.initElements(driver, CreateStore.class).renameFileData
                    (PageFactory.initElements(driver, CreateStore.class).getFirstNameTextBox()
                            ,"\\src\\main\\java\\IntegrationsPO\\QuickBooksPO\\File\\FirstName");
            PageFactory.initElements(driver, CreateStore.class).renameFileData
                    (PageFactory.initElements(driver, CreateStore.class).getLastNameTextBox()
                            ,"\\src\\main\\java\\IntegrationsPO\\QuickBooksPO\\File\\LastName");
            centerlizePO.enterDataUsingSendkeys(PageFactory.initElements(driver, CreateStore.class).getEmailTextBox(), StoreConstant.EMAIL);
            centerlizePO.enterDataUsingSendkeys(PageFactory.initElements(driver, CreateStore.class).getPhoneTextBox(), StoreConstant.PHONE);
            centerlizePO.clearText(PageFactory.initElements(driver, CreateStore.class).getCityTextBox());
            centerlizePO.enterDataUsingSendkeys(PageFactory.initElements(driver, CreateStore.class).getCityTextBox(),StoreConstant.CITY);
            centerlizePO.enterDataUsingSendkeys(PageFactory.initElements(driver, CreateStore.class).getPasswordTextBox(),String.valueOf(properties1.put(StoreConstant.PASSWORD,"password")));
            centerlizePO.clickOnButton(PageFactory.initElements(driver, CreateStore.class).getContinueButton());
            PageFactory.initElements(driver, CreateStore.class).renameFileData
                    (PageFactory.initElements(driver, CreateStore.class).getAccountAddressTextBox()
                            ,"\\src\\main\\java\\IntegrationsPO\\QuickBooksPO\\File\\AccountAddress");
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
     * @discription this method is use to click on activate button on QuickBook
     * @return
     */
    @Step("create hike store for Quickbook")
    public boolean createHikeStoreForQuickbooks(){
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
                            ,"\\src\\main\\java\\IntegrationsPO\\QuickBooksPO\\File\\AccountAddress");
            sleepFor( 3);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, CreateStore.class).getCreteMyStoreButton());
            sleepFor(30);
            PageFactory.initElements(driver,CreateStore.class).bitAboutYourStoreSection();
            sleepFor(10);
            PageFactory.initElements(driver,Shopify.class).PurgeData();
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }


    /**
     * @author Vidhi Chapanera
     * @date 01 April 2021
     * @discription this method is use to Login to QBO store
     * @return
     */
    @Step("Login to QBO store")
    public boolean loginQBOStore() throws IOException {
        CenterlizePO centerlizePO = PageFactory.initElements(driver,CenterlizePO.class);
        Actions actions = new Actions(driver);
        String fileLocation =System.getProperty("user.dir")+"\\src\\main\\resources\\QBO.properties";
        Properties properties1 = new Properties();
        properties1.load(new FileReader(fileLocation));
        try{
            sleepFor(2);
            JavascriptExecutor jse = (JavascriptExecutor)driver;
            jse.executeScript("window.open()");
            ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));
            sleepFor(1);
            driver.get("https://c7.qbo.intuit.com/qbo7/login?&useNeo=true&region=AU");
            sleepFor(5);
           /* centerlizePO.clickOnButton(getSignInWithGoogleButton());
            sleepFor(15);*/
            centerlizePO.enterDataUsingSendkeys(getEmail(),String.valueOf(properties1.getProperty("email_id")));
            /*sleepFor(5);
            centerlizePO.clickOnButton(getNextButton());
            sleepFor(5);*/
            centerlizePO.enterDataUsingSendkeys(getEnterYourPassword1(),String.valueOf(properties1.getProperty("passwordQ")));
            /*sleepFor(10);
            centerlizePO.clickOnButton(getNextButton());
            sleepFor(5);*/
          /*  centerlizePO.clearText(getEmailQBO());
            centerlizePO.enterDataUsingSendkeys(getEmailQBO(),"vidhi.01.hikeup@gmail.com");
            sleepFor(2);
            centerlizePO.clearText(getPasswordQBO());
            centerlizePO.enterDataUsingSendkeys(getPasswordQBO(),String.valueOf(properties1.put(StoreConstant.PASSWORD,"password")));
            sleepFor(2);*/
            centerlizePO.clickOnButton(getSignInButton());
            sleepFor(30);
            try {
                if (driver.findElement(By.xpath("//span[text()='Use my Intuit password']//parent::label")).isDisplayed()){
                    sleepFor(2);
                    WebElement e = new WebDriverWait(driver,60).
                            until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Use my Intuit password']//parent::label")));
                    e.click();
                    sleepFor(5);
                    WebElement btn = new WebDriverWait(driver,60).
                            until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='Back to sign in']//parent::div//input")));
                    actions.moveToElement(btn).click().build().perform();
                    sleepFor(3);
                    WebElement password = new WebDriverWait(driver,60).
                            until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='Password']//parent::fieldset//input[@type='password']")));
                    centerlizePO.enterDataUsingSendkeys(password,String.valueOf(properties1.put(QBOConstant.PASSWORD,"passwordQ")));
                    sleepFor(2);
                    WebElement btn1 = new WebDriverWait(driver,60).
                            until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='Cancel']//parent::div//input")));
                    centerlizePO.clickOnButton(btn1);
                    sleepFor(3);
                }
            }catch (Exception e){
                System.out.println(true);
            }
            sleepFor(5);
            deleteExistingproductQBO();
            DeleteSale();
            deleteExistingCustomerQBO();
            deleteSupplierQBO();
            driver.switchTo().window(tabs.get(0));
            sleepFor(2);
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }


    /**
     * @author Vidhi Chapanera
     * @date 01 April 2021
     * @discription this method is use to click on activate button on QuickBooks
     * @return
     */
    @Step("click on activate button on QuickBooks")
    public boolean clickOnActivateButtonOnQuickBooks() throws IOException {
        CenterlizePO centerlizePO = PageFactory.initElements(driver,CenterlizePO.class);
        String fileLocation = System.getProperty("user.dir") + "\\src\\main\\resources\\loginDetails.properties";
        Properties properties1 = new Properties();
        properties1.load(new FileReader(fileLocation));
        try{
            sleepFor(5);
            PageFactory.initElements(driver, StoreSetup.class).clickOnStoreSetupButton();
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Integrations.class).getIntegrationsButton());
            sleepFor(3);
            centerlizePO.clickOnButton(getQuickBooksActivate());
            sleepFor(35);
            WebElement element = new WebDriverWait(driver,60).until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Connect']//parent::span//parent::button")));
            element.click();
            sleepFor(20);
            try {
                if (PageFactory.initElements(driver, Login.class).getEmailTextBox().isDisplayed()){
                    centerlizePO.enterDataUsingSendkeys(PageFactory.initElements(driver, Login.class).getEmailTextBox(),String.valueOf(properties1.put(LoginConstant.EMAIL_ADDRESS,"email_address")));
                    centerlizePO.enterDataUsingSendkeys(PageFactory.initElements(driver, Login.class).getpasswordTextBox(), String.valueOf(properties1.put(LoginConstant.PASSWORD,"password_1")));
                    centerlizePO.clickOnButton(PageFactory.initElements(driver, Login.class).getLoginButton());
                }
            }catch (Exception e) {
                System.out.println(true);
            }
            sleepFor(30);
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }


    /**
     * @author Vidhi Chapanera
     * @date 02 April 2021
     * @discription this method is use to mapping QuickBooks
     * @return
     */
    @Step("mapping QuickBooks")
    public boolean mappingQuickBooks() throws IOException {
        CenterlizePO centerlizePO = PageFactory.initElements(driver,CenterlizePO.class);
        Actions actions = new Actions(driver);
        try{
            sleepFor(30);
            List<String> list2 = ExcelUtils.getAllCellDataStringForQuickBooks();
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
            WebElement chk = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[@for='ChkStoreCredit']")));
            actions.moveToElement(chk).click().build().perform();
            sleepFor(2);

            List<WebElement> taxmapping = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy
                            (By.xpath("//span[text()='Tax mapping']//parent::div//parent::div//following-sibling::div//table//tbody//tr//td//a")));
            actions.moveToElement(taxmapping.get(0)).click().build().perform();
            sleepFor(2);
            WebElement to0 = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Tax mapping']//parent::div//parent::div//following-sibling::div//table//tbody//tr//td//a//following-sibling::div//ul//li//ul//li//div[text()='GST free[0%]']")));
            actions.moveToElement(to0).click().build().perform();
            sleepFor(2);

            actions.moveToElement(taxmapping.get(1)).click().build().perform();
            sleepFor(2);
            WebElement to1 = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Tax mapping']//parent::div//parent::div//following-sibling::div//table//tbody//tr//td//a//following-sibling::div//ul//li//ul//li//div[text()='GST free purchases[0%]']")));
            actions.moveToElement(to1).click().build().perform();
            sleepFor(2);

            actions.moveToElement(taxmapping.get(2)).click().build().perform();
            sleepFor(2);
            WebElement to2 = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Tax mapping']//parent::div//parent::div//following-sibling::div//table//tbody//tr//td//a//following-sibling::div//ul//li//ul//li//div[text()='GST[10%]']")));
            actions.moveToElement(to2).click().build().perform();
            sleepFor(2);

            actions.moveToElement(taxmapping.get(3)).click().build().perform();
            sleepFor(2);
            WebElement to3 = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Tax mapping']//parent::div//parent::div//following-sibling::div//table//tbody//tr//td//a//following-sibling::div//ul//li//ul//li//div[text()='GST on purchases[10%]']")));
            actions.moveToElement(to3).click().build().perform();
            sleepFor(2);

            List<WebElement> payment = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy
                            (By.xpath("//span[text()='Payment mapping']//parent::div//parent::div//following-sibling::div//table//tbody//tr//td//a")));
            actions.moveToElement(payment.get(0)).click().build().perform();
            sleepFor(2);
            WebElement option = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Payment mapping']//parent::div//parent::div//following-sibling::div//table//tbody//tr//td//a//following-sibling::div//ul//li//ul//li//div[text()='Uncategorised Asset']")));
            actions.moveToElement(option).click().build().perform();
            sleepFor(2);

            actions.moveToElement(payment.get(2)).click().build().perform();
            sleepFor(2);
            WebElement option11 = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Payment mapping']//parent::div//parent::div//following-sibling::div//table//tbody//tr//td//a//following-sibling::div//ul//li//ul//li//div[text()='Uncategorised Asset']")));
            actions.moveToElement(option11).click().build().perform();
            sleepFor(2);

            actions.moveToElement(payment.get(1)).click().build().perform();
            sleepFor(2);
            WebElement o1 = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Payment mapping']//parent::div//parent::div//following-sibling::div//table//tbody//tr//td//a//following-sibling::div//ul//li//ul//li//div[text()='Cash [NON_CREDIT_CARD]']")));
            actions.moveToElement(o1).click().build().perform();
            sleepFor(2);

            actions.moveToElement(payment.get(3)).click().build().perform();
            sleepFor(2);
            WebElement o2 = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Payment mapping']//parent::div//parent::div//following-sibling::div//table//tbody//tr//td//a//following-sibling::div//ul//li//ul//li//div[text()='Credit Card [CREDIT_CARD]']")));
            actions.moveToElement(o2).click().build().perform();
            sleepFor(2);
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
            centerlizePO.clickOnButton(getContinueButton());
            sleepFor(10);
            centerlizePO.clickOnButton(getSaveAndSyncButton());
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
                centerlizePO.clickOnButton(getSaveButton());
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
     * @date 02 April 2021
     * @discription this method is use to create Customers Hike to QuickBooks and verify in QuickBooks
     * @return
     */
    @Step("create Customers Hike to QuickBooks and verify in QuickBooks")
    public boolean createCustomersHiketoQuickBooks() throws IOException {
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
            renameCustomerName(PageFactory.initElements(driver, CustomersPO.CustomersPO.Customers.class).getFirstName(),"\\src\\main\\java\\IntegrationsPO\\QuickBooksPO\\File\\HikeCustomer");
            centerlizePO.clickOnButton(PageFactory.initElements(driver, CustomersPO.CustomersPO.Customers.class).getGenderDropDown());
            List<WebElement> elementList = new WebDriverWait(driver,120).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy
                            (By.xpath("//a[@placeholder='Gender']//parent::div//ul//li//span//parent::div[contains(@class,label)]")));
            elementList.get(1).click();
            sleepFor(1);
            centerlizePO.enterDataUsingSendkeys(PageFactory.initElements(driver, CustomersPO.CustomersPO.Customers.class).getCompany(),"hikeup.com");
            centerlizePO.clearText(PageFactory.initElements(driver, CustomersPO.CustomersPO.Customers.class).getAccountLimit());
            centerlizePO.enterDataUsingSendkeys(PageFactory.initElements(driver, CustomersPO.CustomersPO.Customers.class).getAccountLimit(),"50000");
            sleepFor(2);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, LoyaltyPoints.class).getSaveButton());
            sleepFor(5);
            WebElement name = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//table[@id='CustomersTable']//tbody//tr//td[2]//span[contains(text(),'"+getCustomerValue("\\src\\main\\java\\IntegrationsPO\\QuickBooksPO\\File\\HikeCustomer")+"')]//parent::td//following-sibling::td//a")));
            name.click();
            while(true){
                sleepFor(1);
                centerlizePO.clickOnButton(PageFactory.initElements(driver, Shopify.class).getRefreshLogButton());
                sleepFor(3);
                WebElement e = new WebDriverWait(driver,60).
                        until(ExpectedConditions.presenceOfElementLocated
                                (By.xpath("//td[text()='Hike - QuickBooks']//following-sibling::td[1][text()='Created']")));
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
            executor.executeScript("arguments[0].click();",getSalesQBO());
            sleepFor(7);
            executor.executeScript("arguments[0].click();",getCustomersQBO());
            sleepFor(8);
            /*driver.navigate().refresh();
            System.out.println(8);*/
            WebElement search = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.cssSelector("input[placeholder='Search']")));
            search.sendKeys(getCustomerValue("\\src\\main\\java\\IntegrationsPO\\QuickBooksPO\\File\\HikeCustomer"));
            sleepFor(7);
            actions.sendKeys(Keys.TAB).build().perform();
            actions.sendKeys(Keys.ENTER).build().perform();
            sleepFor(3);
            if (driver.findElement(By.xpath("//p[text()='"+getCustomerValue("\\src\\main\\java\\IntegrationsPO\\QuickBooksPO\\File\\HikeCustomer")+"']")).isDisplayed())
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
     * @date 05 April 2021
     * @discription this method is use to create Customers quickbooks to hike and verify in hike
     * @return
     */
    @Step("create Customers quickbooks to hike and verify in hike")
    public boolean createCustomersQuickBookstoHike() throws IOException {
        CenterlizePO centerlizePO = PageFactory.initElements(driver, CenterlizePO.class);
        Actions actions = new Actions(driver);
        try{
            sleepFor(5);
            ArrayList<String> tabs1 = new ArrayList<String> (driver.getWindowHandles());
            driver.switchTo().window(tabs1.get(1));
            sleepFor(2);
            JavascriptExecutor executor = (JavascriptExecutor)driver;
            executor.executeScript("arguments[0].click();",getCustomersQBO());
            centerlizePO.clickOnButton(getNewCustomerButton());
            sleepFor(5);
            renameCustomerName(getFirstNameTextBoxQBO(),"\\src\\main\\java\\IntegrationsPO\\QuickBooksPO\\File\\QBOCustomer");
            sleepFor(7);
            WebElement element1 = new WebDriverWait(driver, 60).ignoring(StaleElementReferenceException.class).
                    until(ExpectedConditions.elementToBeClickable
                            (By.xpath("//div[@id='customerDialog']//button[text()='Save']")));
            actions.moveToElement(element1).click().build().perform();
            sleepFor(15);
            driver.switchTo().window(tabs1.get(0));
            sleepFor(3);
            PageFactory.initElements(driver, StoreSetup.class).clickOnStoreSetupButton();
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Integrations.class).getIntegrationsButton());
            sleepFor(3);
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
            centerlizePO.clickOnButton(getSaveButton());
            sleepFor(10);
            PageFactory.initElements(driver, CustomersPO.Customers.class).clickOnCustomersButton();
            sleepFor(2);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, CustomersPO.CustomersPO.Customers.class).getCustomersButton());
            sleepFor(5);
            WebElement name = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//table[@id='CustomersTable']//tbody//tr//td[2]//span[contains(text(),'"+getCustomerValue("\\src\\main\\java\\IntegrationsPO\\QuickBooksPO\\File\\QBOCustomer")+"')]//parent::td//following-sibling::td//a")));
            name.click();
            sleepFor(5);
            while(true){
                sleepFor(1);
                centerlizePO.clickOnButton(PageFactory.initElements(driver, Shopify.class).getRefreshLogButton());
                sleepFor(3);
                WebElement e = new WebDriverWait(driver,60).
                        until(ExpectedConditions.presenceOfElementLocated
                                (By.xpath("//td[text()='QuickBooks - Hike']//following-sibling::td[1][text()='Created']")));
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
     * @date 05 April 2021
     * @discription this method is use to create Product hike to Quickbooks and verify in quickbooks
     * @return
     */
    @Step("create Product hike to Quickbooks and verify in quickbooks")
    public boolean createProductHiketoQuickBooks() throws IOException {
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
            renameCustomerName(products1.getProductName(),"\\src\\main\\java\\IntegrationsPO\\QuickBooksPO\\File\\HikeProduct");
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
            centerlizePO.enterDataUsingSendkeys(cost.get(5),Keys.CONTROL+ "a");
            centerlizePO.enterDataUsingSendkeys(cost.get(5), String.valueOf(Keys.DELETE));
            centerlizePO.enterDataUsingSendkeys(cost.get(5),"150");
            centerlizePO.clickOnButton(products1.getProductSaveButton());
            sleepFor(5);
            centerlizePO.enterDataUsingSendkeys(PageFactory.initElements(driver, Products.class).getSearchBox(),getCustomerValue("\\src\\main\\java\\IntegrationsPO\\QuickBooksPO\\File\\HikeProduct"));
            sleepFor(3);
            List<WebElement> list1 = new WebDriverWait(driver,120).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy
                            (By.xpath("//ul[contains(@class,'hike-width-block')]//b[text()='Product']//parent::ul//li//a")));
            list1.get(0).click();
            sleepFor(3);
            WebElement name = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//table[@id='RosterDataTable']//tbody//tr//td[2]//span[text()='" + getCustomerValue("\\src\\main\\java\\IntegrationsPO\\QuickBooksPO\\File\\HikeProduct") + "']//parent::td//following-sibling::td//a")));
            name.click();
            while(true){
                sleepFor(1);
                centerlizePO.clickOnButton(PageFactory.initElements(driver, Shopify.class).getRefreshLogButton());
                sleepFor(3);
                WebElement e = new WebDriverWait(driver,60).
                        until(ExpectedConditions.presenceOfElementLocated
                                (By.xpath("//td[text()='Hike - QuickBooks']//following-sibling::td[1][text()='Created']")));
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
            executor.executeScript("arguments[0].click();",getSalesQBO());
            sleepFor(10);
            executor.executeScript("arguments[0].click();",getProductsAndServicesQBO());
            sleepFor(5);
            centerlizePO.enterDataUsingSendkeys(getProductSearchBar(),getCustomerValue("\\src\\main\\java\\IntegrationsPO\\QuickBooksPO\\File\\HikeProduct"));
            sleepFor(3);
            List<WebElement> pro = new WebDriverWait(driver,60).
                    until(ExpectedConditions.
                            presenceOfAllElementsLocatedBy(By.xpath
                                    ("//div[contains(text(),'"+getCustomerValue("\\src\\main\\java\\IntegrationsPO\\QuickBooksPO\\File\\HikeProduct")+"')]")));
            if (pro.get(0).isDisplayed()){
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
     * @date 05 April 2021
     * @discription this method is use to create Product Quickbooks to hike and verify in hike
     * @return
     */
    @Step("create Product Quickbooks to hike and verify in hike")
    public boolean createProductQuickBookstoHike() throws IOException {
        CenterlizePO centerlizePO = PageFactory.initElements(driver, CenterlizePO.class);
        ProductsPO.ProductsPO.Products products1 = PageFactory.initElements(driver, ProductsPO.ProductsPO.Products.class);
        Actions actions = new Actions(driver);
        try{
            sleepFor(5);
            ArrayList<String> tabs1 = new ArrayList<String> (driver.getWindowHandles());
            driver.switchTo().window(tabs1.get(1));
            sleepFor(2);
            centerlizePO.clickOnButton(getAddNewProductButton());
            sleepFor(5);
            List<WebElement> inventoryLabel = new WebDriverWait(driver,60).
                    until(ExpectedConditions.
                            presenceOfAllElementsLocatedBy(By.xpath
                                    ("//div[text()='Inventory']")));
            centerlizePO.clickOnButton(inventoryLabel.get(0));
            sleepFor(5);
            renameCustomerName(getNameTextAreaNonInventory(),"\\src\\main\\java\\IntegrationsPO\\QuickBooksPO\\File\\QBOProduct");
            List<WebElement> sku = new WebDriverWait(driver,60).
                    until(ExpectedConditions.
                            presenceOfAllElementsLocatedBy(By.xpath
                                    ("//label[text()='SKU']//following-sibling::div[contains(@id,'uniqName')]//input")));
            centerlizePO.clickOnButton(sku.get(0));
            renameItemCode(sku.get(0));
            //centerlizePO.enterDataUsingSendkeys(sku.get(0),"9006030");
            sleepFor(2);
            List<WebElement> onhand = new WebDriverWait(driver,60).
                    until(ExpectedConditions.
                            presenceOfAllElementsLocatedBy(By.xpath
                                    ("//label[text()='Initial quantity on hand']//parent::div//following-sibling::div//input")));
            centerlizePO.clickOnButton(onhand.get(0));
            centerlizePO.enterDataUsingSendkeys(onhand.get(0),"100");
            WebElement date = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//input[@placeholder='DD/MM/YYYY']")));
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            String strDate = dateFormat.format(new Date());
            centerlizePO.enterDataUsingSendkeys(date,strDate);
            centerlizePO.clickOnButton(onhand.get(0));
            sleepFor(3);
            centerlizePO.clickOnButton(getSaveAndClose());
            sleepFor(3);
            sleepFor(2);
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
            centerlizePO.clickOnButton(getSaveButton());
            sleepFor(10);
            PageFactory.initElements(driver, Inventory.class).clickOnInventoryButton();
            PageFactory.initElements(driver, ProductsPO.Products.class).clickOnProductsButtonn();
            centerlizePO.clickOnButton(products1.getProductButton());
            sleepFor(5);
            centerlizePO.enterDataUsingSendkeys(products1.getSearchBox(), getCustomerValue("\\src\\main\\java\\IntegrationsPO\\QuickBooksPO\\File\\QBOProduct"));
            sleepFor(1);
            sleepFor(3);
            List<WebElement> list1 = new WebDriverWait(driver,120).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy
                            (By.xpath("//ul[contains(@class,'hike-width-block')]//b[text()='Product']//parent::ul//li//a")));
            list1.get(0).click();
            sleepFor(3);
            WebElement name = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//table[@id='RosterDataTable']//tbody//tr//td[2]//span[text()='" + getCustomerValue("\\src\\main\\java\\IntegrationsPO\\QuickBooksPO\\File\\QBOProduct") + "']//parent::td//following-sibling::td//a")));
            name.click();
            while(true){
                sleepFor(1);
                centerlizePO.clickOnButton(PageFactory.initElements(driver, Shopify.class).getRefreshLogButton());
                sleepFor(3);
                WebElement e = new WebDriverWait(driver,60).
                        until(ExpectedConditions.presenceOfElementLocated
                                (By.xpath("//td[text()='QuickBooks - Hike']//following-sibling::td[1][text()='Created']")));
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
     * @date 05 April 2021
     * @discription this method is use to create Sale Hike to Quickbooks and verify in Quickbooks
     * @return
     */
    @Step("create Sale Hike to Quickbooks and verify in Quickbooks")
    public boolean createSaleHiketoQuickbooks() throws IOException {
        CenterlizePO centerlizePO = PageFactory.initElements(driver, CenterlizePO.class);
        ProductsPO.ProductsPO.Products products1 = PageFactory.initElements(driver, ProductsPO.ProductsPO.Products.class);
        Actions actions = new Actions(driver);
        try{
            sleepFor(5);
            ArrayList<String> tabs1 = new ArrayList<String> (driver.getWindowHandles());
            sleepFor(1);
            driver.switchTo().window(tabs1.get(0));
            sleepFor(2);
            PageFactory.initElements(driver,General.class).checkPrintReceiptOption();
            PageFactory.initElements(driver, Inventory.class).clickOnInventoryButton();
            PageFactory.initElements(driver, PointofSale.class).clickOnPointOfSaleButtonn();
            sleepFor(2);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, ProcessSale.class).getProcessSaleButton());
            sleepFor(20);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, CashRegister.class).getOpenRegisterButton());
            sleepFor(2);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Shopify.class).getOpenButton());
            sleepFor(3);
            PageFactory.initElements(driver, ProcessSale.class).getSearchBar().sendKeys(getCustomerValue("\\src\\main\\java\\IntegrationsPO\\QuickBooksPO\\File\\HikeProduct"));
            sleepFor(2);
            actions.sendKeys(Keys.TAB).build().perform();
            sleepFor(1);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, ProcessSale.class).getPayButton());
            sleepFor(3);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, ProcessSale.class).getCashButton());
            sleepFor(5);
           /* String mainWindowHandle = driver.getWindowHandle();
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
            driver.switchTo().window(mainWindowHandle);*/
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
                                (By.xpath("//td[text()='Hike - QuickBooks']//following-sibling::td[1][text()='Created']")));
                if (e.isDisplayed())
                    break;
            }
            sleepFor(2);
            actions.sendKeys(Keys.ESCAPE).build().perform();
            sleepFor(3);
            /**
             * @date 06 April 2021
             */
           /* JavascriptExecutor jse = (JavascriptExecutor)driver;
            jse.executeScript("window.open()");*/
            ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));
            /*driver.get("https://app.qbo.intuit.com/app/homepage");*/
            sleepFor(5);
            JavascriptExecutor executor = (JavascriptExecutor)driver;
            executor.executeScript("arguments[0].click();",getSalesQBO());
            sleepFor(10);
            executor.executeScript("arguments[0].click();",getInvoicesButton());
            sleepFor(10);
            if (driver.findElement(By.xpath("//td[contains(text(),'"+saleRef+"')]")).isDisplayed()){
                System.out.println("");
            }
            sleepFor(3);
            sleepFor(2);
            WebElement btn = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//td[contains(text(),'"+saleRef+"')]//following-sibling::td//button[text()='Print']//following-sibling::button")));
            centerlizePO.clickOnButton(btn);
            sleepFor(2);
            WebElement delete = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//div[text()='Delete']")));
            centerlizePO.clickOnButton(delete);
            sleepFor(2);
            WebElement yes = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//span[text()='Yes']//parent::span//parent::span//parent::button")));
            centerlizePO.clickOnButton(yes);
            sleepFor(7);
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }



    /**
     * @author Vidhi Chapanera
     * @date 06 April 2021
     * @discription this method is use to create Sale Quickbooks to Hike and verify in Hike
     * @return
     */
    @Step("create Sale Quickbooks to Hike and verify in Hike")
    public boolean createSaleQuickbookstoHike() throws IOException {
        CenterlizePO centerlizePO = PageFactory.initElements(driver, CenterlizePO.class);
        Actions actions = new Actions(driver);
        try{
            sleepFor(5);
            ArrayList<String> tabs1 = new ArrayList<String> (driver.getWindowHandles());
            driver.switchTo().window(tabs1.get(1));
            sleepFor(2);
            centerlizePO.clickOnButton(getInvoicesButton());
            sleepFor(10);
            centerlizePO.clickOnButton(getCreateInvoicesButton());
            sleepFor(10);
            String invoiceNumber = driver.findElement(By.xpath("//div[text()='no.']//following-sibling::div")).getText();
            System.out.println(invoiceNumber);
            sleepFor(2);
            centerlizePO.enterDataUsingSendkeys(getCustomerQBO(),"Guest");
            sleepFor(3);
            actions.sendKeys(Key.TAB).build().perform();
            sleepFor(2);
            /*centerlizePO.clickOnButton(getSaveCustomerQBO());
            sleepFor(7);*/
            List<WebElement> addProduct = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy
                            (By.xpath("//div[text()='product/service']//parent::div//parent::div//parent::th//parent::tr//parent::table//parent::div//following-sibling::div//tr//td[3]")));
            addProduct.get(0).click();
            sleepFor(2);
            WebElement pname = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//input[@placeholder='Enter Text' and contains(@id,'improved')]")));
            centerlizePO.clickOnButton(pname);
            centerlizePO.enterDataUsingSendkeys(pname,getCustomerValue("\\src\\main\\java\\IntegrationsPO\\QuickBooksPO\\File\\HikeProduct"));
            sleepFor(3);
            actions.sendKeys(Keys.TAB).build().perform();
            sleepFor(10);
            WebElement savedepdwn = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//button[text()='Save and send']//following-sibling::button")));
            //centerlizePO.clickOnButton(savedepdwn);
            actions.moveToElement(savedepdwn).click().build().perform();
            sleepFor(2);
            WebElement save= new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//td[text()='Save and close']")));
            centerlizePO.clickOnButton(save);
            sleepFor(10);
            try{
                WebElement paymentp = new WebDriverWait(driver,60).
                        until(ExpectedConditions.presenceOfElementLocated
                                (By.xpath("//td[text()='"+invoiceNumber+"']//parent::tr//td[7]//button[text()='Receive payment']")));
                actions.moveToElement(paymentp).click().build().perform();
                sleepFor(5);
                WebElement savedepdwn1 = new WebDriverWait(driver,60).
                        until(ExpectedConditions.presenceOfElementLocated
                                (By.xpath("//button[text()='Save and new']//following-sibling::button")));
                actions.moveToElement(savedepdwn1).click().build().perform();
                sleepFor(2);
                WebElement save1 = new WebDriverWait(driver,60).
                        until(ExpectedConditions.presenceOfElementLocated
                                (By.xpath("//td[text()='Save and close']")));
                centerlizePO.clickOnButton(save1);
            }catch (Exception e){
                System.out.println(true);
            }
            sleepFor(10);
            driver.switchTo().window(tabs1.get(0));
            sleepFor(2);
            PageFactory.initElements(driver, StoreSetup.class).clickOnStoreSetupButton();
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Integrations.class).getIntegrationsButton());
            sleepFor(3);
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
            centerlizePO.clickOnButton(getSaveButton());
            sleepFor(10);
            PageFactory.initElements(driver, Inventory.class).clickOnInventoryButton();
            PageFactory.initElements(driver, PointofSale.class).clickOnPointOfSaleButtonn();
            sleepFor(2);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, SalesHistory.class).getSalesHistoryButton());
            sleepFor(8);
           /* WebElement input = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//input[@placeholder]")));
            centerlizePO.enterDataUsingSendkeys(input,invoiceNumber);
            sleepFor(5);*/
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
                                (By.xpath("//td[text()='QuickBooks - Hike']//following-sibling::td[1][text()='Created']")));
                if (e.isDisplayed())
                    break;
            }
            sleepFor(2);
            actions.sendKeys(Keys.ESCAPE).build().perform();
            sleepFor(3);
            /*driver.switchTo().window(tabs1.get(1));
            sleepFor(2);
            WebElement btn = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//td[contains(text(),'"+invoiceNumber+"')]//following-sibling::td//button[text()='Print']//following-sibling::button")));
            centerlizePO.clickOnButton(btn);
            sleepFor(2);
            WebElement delete = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//div[text()='Delete']")));
            centerlizePO.clickOnButton(delete);
            sleepFor(2);
            WebElement yes = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//span[text()='Yes']//parent::span//parent::span//parent::button")));
            centerlizePO.clickOnButton(yes);
            sleepFor(7);
            sleepFor(3);*/
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }


    /**
     * @author Vidhi Chapanera
     * @date 06 April 2021
     * @discription this method is use to delete existing customer in QBO
     * @return
     */
    @Step("delete existing customer in QBO")
    public boolean deleteExistingCustomerQBO() throws IOException {
        CenterlizePO centerlizePO = PageFactory.initElements(driver, CenterlizePO.class);
        Actions actions = new Actions(driver);
        try{
            sleepFor(5);
            ArrayList<String> tabs1 = new ArrayList<String> (driver.getWindowHandles());
            driver.switchTo().window(tabs1.get(1));
            sleepFor(2);
            try{
                JavascriptExecutor executor = (JavascriptExecutor)driver;
                executor.executeScript("arguments[0].click();",getSalesQBO());
                sleepFor(4);
                executor.executeScript("arguments[0].click();",getCustomersQBO());
                sleepFor(5);
                WebElement chk  = new WebDriverWait(driver,60)
                        .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Customer']//parent::div//parent::th//parent::tr//parent::div//input")));
                centerlizePO.clickOnButton(chk);
                sleepFor(2);
                WebElement btn = new WebDriverWait(driver,60).
                        until(ExpectedConditions.presenceOfElementLocated
                                (By.xpath("//span[text()='Batch actions']//parent::button")));
                actions.moveToElement(btn).click().build().perform();
                sleepFor(1);
                WebElement option = new WebDriverWait(driver,60).
                        until(ExpectedConditions.presenceOfElementLocated
                                (By.xpath("//td[text()='Make inactive']")));
                actions.moveToElement(option).click().build().perform();
                sleepFor(2);
                WebElement btnYes = new WebDriverWait(driver,60).
                        until(ExpectedConditions.presenceOfElementLocated
                                (By.xpath("//button[text()='Yes']")));
                actions.moveToElement(btnYes).click().build().perform();
                sleepFor(2);
            }catch (Exception e){
                System.out.println(true);
            }
            sleepFor(2);
            sleepFor(3);
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }



    /**
     * @author Vidhi Chapanera
     * @date 06 April 2021
     * @discription this method is use to delete existing product in QBO
     * @return
     */
    @Step("delete existing product in QBO")
    public boolean deleteExistingproductQBO() throws IOException {
        CenterlizePO centerlizePO = PageFactory.initElements(driver, CenterlizePO.class);
        Actions actions = new Actions(driver);
        try{
            sleepFor(5);
            ArrayList<String> tabs1 = new ArrayList<String> (driver.getWindowHandles());
            driver.switchTo().window(tabs1.get(1));
            sleepFor(2);
            try{
                JavascriptExecutor executor = (JavascriptExecutor)driver;
                executor.executeScript("arguments[0].click();",getSalesQBO());
                sleepFor(4);
                executor.executeScript("arguments[0].click();",getProductsAndServicesQBO());
                sleepFor(8);
                executor.executeScript("arguments[0].click();",getProductsAndServicesFilterQBO());
                sleepFor(2);
                WebElement e  = new WebDriverWait(driver,60)
                        .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='Type']//parent::div//span//parent::div//following-sibling::div//div")));
                e.click();
                sleepFor(2);
                List<WebElement> option = new WebDriverWait(driver,120).
                        until(ExpectedConditions.presenceOfAllElementsLocatedBy
                                (By.xpath("//td[text()='Inventory']")));
                option.get(option.size()-1).click();
                sleepFor(2);
                centerlizePO.clickOnButton(getApplyQBO());
                sleepFor(10);
                WebElement chk  = new WebDriverWait(driver,60)
                        .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='SKU']//parent::th//parent::tr//parent::div//input")));
                centerlizePO.clickOnButton(chk);
                sleepFor(2);
                WebElement btn = new WebDriverWait(driver,60).
                        until(ExpectedConditions.presenceOfElementLocated
                                (By.xpath("//span[text()='Batch actions']//parent::button")));
                actions.moveToElement(btn).click().build().perform();
                sleepFor(1);
                WebElement option1 = new WebDriverWait(driver,60).
                        until(ExpectedConditions.presenceOfElementLocated
                                (By.xpath("//td[text()='Make inactive']")));
                actions.moveToElement(option1).click().build().perform();
                sleepFor(2);
                WebElement btnYes = new WebDriverWait(driver,60).
                        until(ExpectedConditions.presenceOfElementLocated
                                (By.xpath("//button[text()='Yes']")));
                actions.moveToElement(btnYes).click().build().perform();
                sleepFor(2);
            }catch (Exception e){
                System.out.println(true);
            }
            sleepFor(2);
            sleepFor(3);
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }



    /**
     * @author Vidhi Chapanera
     * @date 06 April 2021
     * @discription this method is use to delete existing invoice in QBO
     * @return
     */
    @Step("delete existing invoice in QBO")
    public boolean deleteinvoicetQBO() throws IOException {
        CenterlizePO centerlizePO = PageFactory.initElements(driver, CenterlizePO.class);
        Actions actions = new Actions(driver);
        try{
            sleepFor(5);
            ArrayList<String> tabs1 = new ArrayList<String> (driver.getWindowHandles());
            driver.switchTo().window(tabs1.get(1));
            sleepFor(2);
            try {
                JavascriptExecutor executor = (JavascriptExecutor)driver;
                executor.executeScript("arguments[0].click();",getSalesQBO());
                sleepFor(4);
                executor.executeScript("arguments[0].click();",getInvoicesButton());
                sleepFor(10);
                WebElement chk = new WebDriverWait(driver, 60)
                        .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Date']//parent::th//parent::tr//parent::thead//input")));
                actions.moveToElement(chk).click().build().perform();
                sleepFor(2);
                WebElement btn = new WebDriverWait(driver, 60).
                        until(ExpectedConditions.presenceOfElementLocated
                                (By.xpath("//span[text()='Batch actions']//parent::span//parent::span//parent::button")));
                actions.moveToElement(btn).click().build().perform();
                sleepFor(1);
                WebElement deletebtn = new WebDriverWait(driver, 60).
                        until(ExpectedConditions.presenceOfElementLocated
                                (By.xpath("//span[text()='Delete']")));
                actions.moveToElement(deletebtn).click().build().perform();
                sleepFor(5);
                WebElement btnYes = new WebDriverWait(driver, 60).
                        until(ExpectedConditions.presenceOfElementLocated
                                (By.xpath("//span[text()='Yes']//parent::span//parent::span//parent::button")));
                actions.moveToElement(btnYes).click().build().perform();
                sleepFor(2);
            }catch (Exception e){
                System.out.println(true);
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
     * @date 06 April 2021
     * @discription this method is use to delete existing Supplier in QBO
     * @return
     */
    @Step("delete existing Supplier in QBO")
    public boolean deleteSupplierQBO() throws IOException {
        CenterlizePO centerlizePO = PageFactory.initElements(driver, CenterlizePO.class);
        Actions actions = new Actions(driver);
        try{
            sleepFor(5);
            ArrayList<String> tabs1 = new ArrayList<String> (driver.getWindowHandles());
            driver.switchTo().window(tabs1.get(1));
            sleepFor(2);
            try {
                JavascriptExecutor executor = (JavascriptExecutor)driver;
                executor.executeScript("arguments[0].click();",getExpensesQBO());
                sleepFor(6);
                executor.executeScript("arguments[0].click();",getSuppliersButton());
                sleepFor(10);
                WebElement chk  = new WebDriverWait(driver,60)
                        .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Supplier']//parent::div//parent::th//parent::tr//parent::div//input")));
                centerlizePO.clickOnButton(chk);
                sleepFor(2);
                WebElement btn = new WebDriverWait(driver,60).
                        until(ExpectedConditions.presenceOfElementLocated
                                (By.xpath("//span[text()='Batch actions']//parent::button")));
                actions.moveToElement(btn).click().build().perform();
                sleepFor(1);
                WebElement option = new WebDriverWait(driver,60).
                        until(ExpectedConditions.presenceOfElementLocated
                                (By.xpath("//td[text()='Make inactive']")));
                actions.moveToElement(option).click().build().perform();
                sleepFor(2);
                WebElement btnYes = new WebDriverWait(driver,60).
                        until(ExpectedConditions.presenceOfElementLocated
                                (By.xpath("//button[text()='Yes']")));
                actions.moveToElement(btnYes).click().build().perform();
                sleepFor(2);
            }catch (Exception e){
                System.out.println(true);
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
     * @date 06 April 2021
     * @discription this method is use to create Suppliers Quickbooks to Hike and verify in Hike
     * @return
     */
    @Step("create Suppliers Quickbooks to Hike and verify in Hike")
    public boolean createSuppliersQuickbookstoHike() throws IOException {
        CenterlizePO centerlizePO = PageFactory.initElements(driver, CenterlizePO.class);
        Actions actions = new Actions(driver);
        try{
            sleepFor(5);
            ArrayList<String> tabs1 = new ArrayList<String> (driver.getWindowHandles());
            driver.switchTo().window(tabs1.get(1));
            sleepFor(2);
            centerlizePO.clickOnButton(getExpensesQBO());
            sleepFor(4);
            centerlizePO.clickOnButton(getSuppliersButton());
            sleepFor(10);
            centerlizePO.clickOnButton(getNewSupplierButton());
            sleepFor(10);
            renameCustomerName(getFirstNameTextBoxQBO(),"\\src\\main\\java\\IntegrationsPO\\QuickBooksPO\\File\\QS");
            sleepFor(7);
            WebElement element1 = new WebDriverWait(driver, 60).ignoring(StaleElementReferenceException.class).
                    until(ExpectedConditions.elementToBeClickable
                            (By.xpath("//button[text()='Save']")));
            actions.moveToElement(element1).click().build().perform();
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
            centerlizePO.clickOnButton(getSaveButton());
            sleepFor(10);
            PageFactory.initElements(driver, Inventory.class).clickOnInventoryButton();
            sleepFor(2);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Suppliers.class).getSuppliersButton());
            sleepFor(5);
            WebElement supplierName = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//table[@id='SupplierTable']//tbody//tr//td//a[contains(text(),'"+getCustomerValue("\\src\\main\\java\\IntegrationsPO\\QuickBooksPO\\File\\QS")+"')]//parent::td//following-sibling::td//a")));
            centerlizePO.clickOnButton(supplierName);
            sleepFor(4);
            sleepFor(3);
            while(true){
                sleepFor(1);
                centerlizePO.clickOnButton(PageFactory.initElements(driver, Shopify.class).getRefreshLogButton());
                sleepFor(3);
                WebElement e = new WebDriverWait(driver,60).
                        until(ExpectedConditions.presenceOfElementLocated
                                (By.xpath("//td[text()='QuickBooks - Hike']//following-sibling::td[1][text()='Created']")));
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
     * @date 06 April 2021S
     * @discription this method is use to create Suppliers Hike to Quickbooks and verify in Quickbooks
     * @return
     */
    @Step("create Suppliers Hike to Quickbooks and verify in Quickbooks")
    public boolean createSuppliersHiketoQuickbooks() throws IOException {
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
            renameCustomerName(PageFactory.initElements(driver, Suppliers.class).getCompanyName(),"\\src\\main\\java\\IntegrationsPO\\QuickBooksPO\\File\\HS");
            sleepFor(3);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Suppliers.class).getSaveButton());
            sleepFor(3);
            WebElement supplierName = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//table[@id='SupplierTable']//tbody//tr//td//a[contains(text(),'"+getCustomerValue("\\src\\main\\java\\IntegrationsPO\\QuickBooksPO\\File\\HS")+"')]//parent::td//following-sibling::td//a")));
            centerlizePO.clickOnButton(supplierName);
            sleepFor(4);
            sleepFor(3);
            while(true){
                sleepFor(1);
                centerlizePO.clickOnButton(PageFactory.initElements(driver, Shopify.class).getRefreshLogButton());
                sleepFor(3);
                WebElement e = new WebDriverWait(driver,60).
                        until(ExpectedConditions.presenceOfElementLocated
                                (By.xpath("//td[text()='Hike - QuickBooks']//following-sibling::td[1][text()='Created']")));
                if (e.isDisplayed())
                    break;
            }
            sleepFor(2);
            actions.sendKeys(Keys.ESCAPE).build().perform();
            sleepFor(3);
            driver.switchTo().window(tabs1.get(1));
            centerlizePO.clickOnButton(getExpensesQBO());
            sleepFor(4);
            centerlizePO.clickOnButton(getSuppliersButton());
            sleepFor(10);
            driver.navigate().refresh();
            sleepFor(10);
            WebElement supplierName01 = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//span[text()='Supplier']//parent::div//parent::th//parent::tr//parent::table//parent::div//following-sibling::div//tr//td//a[contains(text(),'"+getCustomerValue("\\src\\main\\java\\IntegrationsPO\\QuickBooksPO\\File\\HS")+"')]")));
            if (supplierName01.isDisplayed()){
                System.out.println(true);
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
     * @date 07 April 2021
     * @discription this method is use to create Register summery Hike to Quickbooks and verify in Quickbooks
     * @return
     */
    @Step("create Register summery Hike to Quickbooks and verify in Quickbooks")
    public boolean createRegisterSummeryHiketoQuickbooks() throws IOException {
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
            PageFactory.initElements(driver, StoreSetup.class).clickOnStoreSetupButton();
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Integrations.class).getIntegrationsButton());
            sleepFor(3);
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
            centerlizePO.clickOnButton(getSaveButton());
            sleepFor(10);
            PageFactory.initElements(driver, Reporting.class).clickOnReportingButton();
            sleepFor(2);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Register.class).getRegisterButton());
            sleepFor(5);
            WebElement register = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//table[@id='ShiftReportDetailDataTable']//tbody//tr[1]//td[1]//a")));
            String registerText = register.getText();
            String s1= registerText.split("#")[1];
            String s3 =StringUtils.chop(s1);
            sleepFor(2);
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
                                (By.xpath("//td[text()='Hike - QuickBooks']//following-sibling::td[1][text()='Created']")));
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
            driver.get("https://app.qbo.intuit.com/app/homepage");
            sleepFor(20);
            centerlizePO.clickOnButton(getSalesQBO());
            sleepFor(10);
            centerlizePO.clickOnButton(getAllSalesButton());
            sleepFor(5);
            if (driver.findElement(By.xpath("//td[text()='"+s3+"']")).isDisplayed()){
                System.out.println("");
            }
            sleepFor(3);
            WebElement btn = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//td[contains(text(),'"+s3+"')]//following-sibling::td//button[text()='Print']//following-sibling::button")));
            centerlizePO.clickOnButton(btn);
            sleepFor(2);
            WebElement delete = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//div[text()='Delete']")));
            centerlizePO.clickOnButton(delete);
            sleepFor(2);
            WebElement yes = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//span[text()='Yes']//parent::span//parent::span//parent::button")));
            centerlizePO.clickOnButton(yes);
            sleepFor(7);
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }



    /**
     * @author Vidhi Chapanera
     * @date 07 April 2021
     * @discription this method is use to create Purchase Order Hike to Quickbooks and verify in Quickbooks
     * @return
     */
    @Step("create Purchase Order Hike to Quickbooks and verify in Quickbooks")
    public boolean createPurchaseOrderHiketoQuickbooks() throws IOException {
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
            elements.get(0).sendKeys(getCustomerValue("\\src\\main\\java\\IntegrationsPO\\QuickBooksPO\\File\\HikeProduct"));
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
                                (By.xpath("//td[text()='Hike - QuickBooks']//following-sibling::td[1][text()='Created']")));
                if (e.isDisplayed())
                    break;
            }
            sleepFor(3);
            actions.sendKeys(Keys.ESCAPE).build().perform();
            sleepFor(3);
            driver.switchTo().window(tabs1.get(1));
            centerlizePO.clickOnButton(getExpensesQBO());
            sleepFor(4);
            centerlizePO.clickOnButton(getExpensesButton());
            sleepFor(10);
            WebElement ex = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//div[contains(text(),'Date')]//parent::th//parent::tr//parent::table//parent::div//following-sibling::div//tr//td[text()='"+poText+"']")));
            if (ex.isDisplayed()){
                System.out.println(true);
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
     * @date 07 April 2021
     * @discription this method is use to create Purchase Order Quickbooks to Hike and verify in Hike
     * @return
     */
    @Step("create Purchase Order Quickbooks to Hike and verify in Hike")
    public boolean createPurchaseOrderQuickbookstoHike() throws IOException {
        CenterlizePO centerlizePO = PageFactory.initElements(driver, CenterlizePO.class);
        Actions actions = new Actions(driver);
        try{
            sleepFor(5);
            ArrayList<String> tabs1 = new ArrayList<String> (driver.getWindowHandles());
            driver.switchTo().window(tabs1.get(1));
            sleepFor(2);
            centerlizePO.clickOnButton(getExpensesQBO());
            sleepFor(4);
            centerlizePO.clickOnButton(getExpensesButton());
            sleepFor(10);
            actions.moveToElement(getNewTransactionButton()).click().build().perform();
            sleepFor(2);
            centerlizePO.clickOnButton(getPurchaseOrderButton());
            sleepFor(10);
            List<WebElement> elements = new  WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//input[@placeholder='Choose a supplier']")));
            sleepFor(1);
            elements.get(0).click();
            elements.get(0).sendKeys(getCustomerValue("\\src\\main\\java\\IntegrationsPO\\QuickBooksPO\\File\\HS"));
            actions.sendKeys(Keys.TAB).build().perform();
            sleepFor(1);
            List<WebElement> addProduct = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy
                            (By.xpath("//div[text()='product/service']//parent::div//parent::div//parent::th//parent::tr//parent::table//parent::div//following-sibling::div//tr//td[3]")));
            addProduct.get(0).click();
            sleepFor(2);
            List<WebElement> pname = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy
                            (By.xpath("//input[@placeholder='Enter Text' and contains(@id,'improved')]")));
            centerlizePO.clickOnButton(pname.get(1));
            centerlizePO.enterDataUsingSendkeys(pname.get(1),getCustomerValue("\\src\\main\\java\\IntegrationsPO\\QuickBooksPO\\File\\HikeProduct"));
            sleepFor(3);
            actions.sendKeys(Keys.TAB).build().perform();
            sleepFor(3);
            centerlizePO.clickOnButton(getSaveandcloseQBO());
            sleepFor(10);
            List<WebElement> no = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy
                            (By.xpath("//input[@type='checkbox']//parent::td//following-sibling::td[3]")));
            String noText = no.get(0).getText();
            sleepFor(2);
            System.out.println(noText);
            driver.switchTo().window(tabs1.get(0));
            sleepFor(2);
            PageFactory.initElements(driver, StoreSetup.class).clickOnStoreSetupButton();
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Integrations.class).getIntegrationsButton());
            sleepFor(3);
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
            centerlizePO.clickOnButton(getSaveButton());
            sleepFor(10);
            PageFactory.initElements(driver, Inventory.class).clickOnInventoryButton();
            sleepFor(2);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Purchases.class).getPurchasesButton());
            sleepFor(5);
            WebElement POsysnc = new WebDriverWait(driver,60).until
                    (ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//table[@id='purchanseOrderDataTable']//tbody//tr//td//a[contains(text(),'"+noText+"')]//parent::td//following-sibling::td//a")));
            POsysnc.click();
            sleepFor(5);
            while(true){
                sleepFor(1);
                centerlizePO.clickOnButton(PageFactory.initElements(driver, Shopify.class).getRefreshLogButton());
                sleepFor(3);
                WebElement e = new WebDriverWait(driver,60).
                        until(ExpectedConditions.presenceOfElementLocated
                                (By.xpath("//td[text()='QuickBooks - Hike']//following-sibling::td[1][text()='Created']")));
                if (e.isDisplayed())
                    break;
            }
            sleepFor(3);
            actions.sendKeys(Keys.ESCAPE).build().perform();
            sleepFor(3);
            driver.switchTo().window(tabs1.get(1));
            sleepFor(5);
            boolean flag = true;
            while (flag){
                sleepFor(3);
                List<WebElement> btn = new WebDriverWait(driver,60).
                        until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                                (By.xpath("//div[contains(text(),'Date')]//parent::th//parent::tr//parent::table//parent::div//following-sibling::div//tr//td[text()='']//following-sibling::td//button[text()='Send']//following-sibling::button"))));
                btn.get(0).click();
                WebElement delete1 = new WebDriverWait(driver,60).
                        until(ExpectedConditions.presenceOfElementLocated
                                (By.xpath("//td[text()='Delete']")));
                actions.moveToElement(delete1).click().build().perform();
                sleepFor(2);
                WebElement yes1 = new WebDriverWait(driver,60).
                        until(ExpectedConditions.presenceOfElementLocated
                                (By.xpath("//button[text()='Yes']")));
                actions.moveToElement(yes1).click().build().perform();
                sleepFor(3);
                if (btn.size() == 1){
                    flag = false;
                }
            }
           /* List<WebElement> btn = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                            (By.xpath("//div[contains(text(),'Date')]//parent::th//parent::tr//parent::table//parent::div//following-sibling::div//tr//td[text()='']//following-sibling::td//button[text()='Send']//following-sibling::button"))));
            centerlizePO.clickOnButton(btn.get(0));
            sleepFor(2);
            WebElement delete = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//td[text()='Delete']")));
            centerlizePO.clickOnButton(delete);
            sleepFor(2);
            WebElement yes = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//button[text()='Yes']")));
            centerlizePO.clickOnButton(yes);
            sleepFor(7);
            List<WebElement> btn1 = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                            (By.xpath("//div[contains(text(),'Date')]//parent::th//parent::tr//parent::table//parent::div//following-sibling::div//tr//td[text()='']//following-sibling::td//button[text()='Send']//following-sibling::button"))));
            centerlizePO.clickOnButton(btn1.get(0));
            sleepFor(2);
            WebElement delete1 = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//td[text()='Delete']")));
            centerlizePO.clickOnButton(delete1);
            sleepFor(2);
            WebElement yes1 = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//button[text()='Yes']")));
            centerlizePO.clickOnButton(yes1);
            sleepFor(7);*/
            sleepFor(2);
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }



    /**
     * @author Vidhi Chapanerax
     * @date 07 April 2021
     * @discription this method is use to automate quickbook
     * @return
     */
    @Step("automate quickbook")
    public boolean automateQuickbooks() throws IOException {
        try{
            createHikeStoreForQuickbooks();

            loginQBOStore();

            clickOnActivateButtonOnQuickBooks();

            mappingQuickBooks();

            createCustomersHiketoQuickBooks();

            createCustomersQuickBookstoHike();

            createProductHiketoQuickBooks();

            createProductQuickBookstoHike();

            createSuppliersHiketoQuickbooks();

            createSuppliersQuickbookstoHike();

            createSaleHiketoQuickbooks();

            createSaleQuickbookstoHike();

            createPurchaseOrderHiketoQuickbooks();

            createPurchaseOrderQuickbookstoHike();

            createRegisterSummeryHiketoQuickbooks();

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
            centerlizePO.clickOnButton(getDeleteThisIntegrationButton());
            sleepFor(5);
            centerlizePO.clickOnButton(PageFactory.initElements(driver,CashRegister.class).getContinueButton());
            sleepFor(5);
            sleepFor(10);
        }
    }


    /**
     * @author Vidhi Chapanera
     * @date 08 April 2021
     * @return
     * @throws IOException
     * @discription this method is used to rename the text file data
     */
    @Step("")
    public boolean renameCustomerName(WebElement el,String filepath) throws IOException {
        String tesLine ="";
        try {
            File f = new File(System.getProperty("user.dir") + filepath);
            f.canWrite();
            Scanner scanner = new Scanner(f);
            while (scanner.hasNextLine()) {
                tesLine += scanner.nextLine();
            }
            scanner.close();
            String string = tesLine;
            String[] parts = string.split("-");
            String part1 = parts[0]; //
            String part2 = parts[1]; //
            //int number = Integer.parseInt(protocolName.substring(protocolName.length()-1));
            int number = Integer.parseInt(part2);
            int sum = number + 1;
            String oldValue = String.valueOf(number);
            String newValue = String.valueOf(sum);
            String finalString = tesLine.replace(oldValue, newValue);
            dataText += finalString;
            System.out.println(dataText);

            FileWriter myWriter = new FileWriter(f);
            myWriter.write(dataText);
            myWriter.close();
            PageFactory.initElements(driver, CenterlizePO.class).enterDataUsingSendkeys(el, dataText);
            synchronized (dataText) {
                System.out.println(true);
            }
            Reset();
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }


    /**
     * @author Vidhi Chapanera
     * @date 08 April 2021
     * @return
     * @throws IOException
     * @discription this method is used to get account address value
     */
    @Step("")
    public String getCustomerValue(String path) throws IOException {
        String tesLine ="";
        File f = new File(System.getProperty("user.dir") + path);
        f.canWrite();
        Scanner scanner = new Scanner(f);
        while (scanner.hasNextLine()) {
            tesLine += scanner.nextLine();
        }
        scanner.close();
        return tesLine;
    }


    /**
     * @author Vidhi Chapanera
     * @date 12 January 2021
     * @discription reset static variable value
     */
    @Step("")
    public void Reset() {
        dataText = "";
    }


    /**
     * @author Vidhi Chapanera
     * @date 27 July 2021
     * @return
     * @throws IOException
     * @discription this method is used to rename the text file data
     */
    @Step("")
    public boolean renameItemCode(WebElement el) throws IOException {
        String tesLine ="";
        try {
            File f = new File(System.getProperty("user.dir") + "\\src\\main\\java\\IntegrationsPO\\QuickBooksPO\\File\\ItemCode");
            f.canWrite();
            Scanner scanner = new Scanner(f);
            while (scanner.hasNextLine()) {
                tesLine += scanner.nextLine();
            }
            scanner.close();
            String string = String.valueOf(tesLine.charAt(tesLine.length() -1));
            System.out.println(string);
            int number = Integer.parseInt(string);
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
     * @date 27 July 2021
     * @discription this method is use to delete sale
     * @return
     */
    @Step("create Sale Quickbooks to Hike and verify in Hike")
    public boolean DeleteSale() throws IOException {
        CenterlizePO centerlizePO = PageFactory.initElements(driver, CenterlizePO.class);
        Actions actions = new Actions(driver);
        try{
            sleepFor(5);
            ArrayList<String> tabs1 = new ArrayList<String> (driver.getWindowHandles());
            driver.switchTo().window(tabs1.get(1));
            sleepFor(2);
            JavascriptExecutor executor = (JavascriptExecutor)driver;
            executor.executeScript("arguments[0].click();",getSalesQBO());
            sleepFor(5);
            List<WebElement> btn = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy
                            (By.xpath("//td[contains(text(),'')]//following-sibling::td//button[contains(@class,'DownArrowButton')]")));
            for (int i =0;i<btn.size();i++){
                sleepFor(2);
                actions.moveToElement(btn.get(i)).click().build().perform();
                sleepFor(2);
                WebElement delete = new WebDriverWait(driver,60).
                        until(ExpectedConditions.presenceOfElementLocated
                                (By.xpath("//td[text()='Delete']")));
                actions.moveToElement(delete).click().build().perform();
                sleepFor(3);
                WebElement yes = new WebDriverWait(driver,60).
                        until(ExpectedConditions.presenceOfElementLocated
                                (By.xpath("//button[text()='Yes']")));
                actions.moveToElement(yes).click().build().perform();
                sleepFor(2);
            }
            List<WebElement> list = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy
                            (By.xpath("//div[contains(text(),'Status')]//parent::th//parent::tr//parent::table//parent::div//following-sibling::div//tr//td[5]")));
            for (int i =0;i<list.size()-1;i++){
                sleepFor(2);
                actions.moveToElement(list.get(i)).click().build().perform();
                sleepFor(4);
                WebElement more = new WebDriverWait(driver,60).
                        until(ExpectedConditions.presenceOfElementLocated
                                (By.xpath("//div[text()='More']")));
                actions.moveToElement(more).click().build().perform();
                sleepFor(3);
                WebElement delete = new WebDriverWait(driver,60).
                        until(ExpectedConditions.presenceOfElementLocated
                                (By.xpath("//button[text()='Delete' and @class='tooltipOption']")));
                actions.moveToElement(delete).click().build().perform();
                List<WebElement> yes = new WebDriverWait(driver,60).
                        until(ExpectedConditions.presenceOfAllElementsLocatedBy
                                (By.xpath("//button[text()='Yes']")));
                actions.moveToElement(yes.get(yes.size()-1)).click().build().perform();
                sleepFor(5);
            }
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
}