package IntegrationsPO.BigCommercePO;

import CommonPO.BasePage;
import CommonPO.CenterlizePO;
import CreateStorePO.CreateStore;
import CreateStorePO.StoreConstant;
import IntegrationsPO.Integrations;
import IntegrationsPO.QuickBooksPO.QuickBooks;
import IntegrationsPO.ShopifyPO.Shopify;
import InventoryPO.Inventory;
import LoginPO.Login;
import PointofSalePO.CashRegisterPO.CashRegister;
import PointofSalePO.PointofSale;
import PointofSalePO.ProcessSalePO.ProcessSale;
import PointofSalePO.SalesHistoryPO.SalesHistory;
import ProductsPO.ProductsPO.Products;
import ReportingPO.Reporting;
import StoreSetupPO.LoyaltyPointsPO.LoyaltyPoints;
import StoreSetupPO.StoreSetup;
import UsersPO.Users;
import com.google.common.base.CharMatcher;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.mail.*;
import javax.mail.internet.ContentType;
import javax.mail.internet.MimeMultipart;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


/**
 * @author Vidhi Chapanera
 * @date 12 April 2021
 */
public class BigCommerce extends BasePage {

    public WebDriver driver;
    public static String verificationCode = "";
    public static String trialDays = "";


    public BigCommerce(WebDriver driver) {
        this.driver = driver;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for BigCommerce activate button
     * @date 12 April 2021
     */
    @FindBy(how = How.XPATH, using = "//table//tr//td[contains(text(),'BigCommerce')]//parent::tr//button")
    WebElement btn_BigCommerceactivate;
    public WebElement getBigCommerceActivate() {
        return btn_BigCommerceactivate;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for email input box
     * @date 12 April 2021
     */
    @FindBy(how = How.NAME, using = "user[email]")
    WebElement txt_emailBC;
    public WebElement getEmailBC() {
        return txt_emailBC;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for password input box
     * @date 12 April 2021
     */
    @FindBy(how = How.NAME, using = "user[password]")
    WebElement txt_passwordBC;
    public WebElement getPasswordBC() {
        return txt_passwordBC;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for login button
     * @date 12 April 2021
     */
    @FindBy(how = How.NAME, using = "commit")
    WebElement btn_login;
    public WebElement getLoginButton() {
        return btn_login;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for verification code input box
     * @date 12 April 2021
     */
    @FindBy(how = How.NAME, using = "device_verification[otp_code]")
    WebElement txt_verificationCode;
    public WebElement getVerificationCode() {
        return txt_verificationCode;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for get started button
     * @date 12 April 2021
     */
    @FindBy(how = How.XPATH, using = "//a[text()='Get started']")
    WebElement btn_getstarted;
    public WebElement getstartedButton() {
        return btn_getstarted;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for email input textbox
     * @date 12 April 2021
     */
    @FindBy(how = How.CSS, using = "input[name='email']")
    WebElement txt_input;
    public WebElement getEmailBCT() {
        return txt_input;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for customers button
     * @date 12 April 2021
     */
    @FindBy(how = How.XPATH, using = "//customers-menu//span[text()='Customers']//parent::a//span")
    WebElement btn_customer;
    public WebElement getCustomerButton() {
        return btn_customer;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Products button
     * @date 12 April 2021
     */
    @FindBy(how = How.XPATH, using = "//products-menu//span[text()='Products']//parent::a//span")
    WebElement btn_product;
    public WebElement getProductsButton() {
        return btn_product;
    }



    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Continue to Store Details button
     * @date 12 April 2021
     */
    @FindBy(how = How.CSS, using = "input[value='Continue to Store Details']")
    WebElement btn_contiuneStoreDetails;
    public WebElement getContiuneStoreDetails() {
        return btn_contiuneStoreDetails;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for  store name text box
     * @date 12 April 2021
     */
    @FindBy(how = How.NAME, using = "storeName")
    WebElement txt_storename;
    public WebElement getStoreName() {
        return txt_storename;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for password text box
     * @date 12 April 2021
     */
    @FindBy(how = How.NAME, using = "password")
    WebElement txt_password;
    public WebElement getPasswordN() {
        return txt_password;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for firstName text box
     * @date 12 April 2021
     */
    @FindBy(how = How.NAME, using = "firstName")
    WebElement txt_firstName;
    public WebElement getFirstName() {
        return txt_firstName;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for lastName text box
     * @date 12 April 2021
     */
    @FindBy(how = How.NAME, using = "lastName")
    WebElement txt_lastName;
    public WebElement getLastName() {
        return txt_lastName;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for phone text box
     * @date 12 April 2021
     */
    @FindBy(how = How.NAME, using = "phone")
    WebElement txt_phone;
    public WebElement getPhone() {
        return txt_phone;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Create your store button
     * @date 12 April 2021
     */
    @FindBy(how = How.XPATH, using = "//button[text()='Create my store']")
    //@FindBy(how = How.XPATH, using = "//button[text()='Create your store']")
    WebElement btn_createYourStoreButton;
    public WebElement getCreateYourStoreButton() {
        return btn_createYourStoreButton;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for install button Bc
     * @date 12 April 2021
     */
    @FindBy(how = How.XPATH, using = "//span[text()='Install']//parent::button")
    WebElement btn_install;
    public WebElement getinstallButtonBc() {
        return btn_install;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for uninstall button Bc
     * @date 12 April 2021
     */
    @FindBy(how = How.XPATH, using = "//span[text()='Uninstall']//parent::button")
    WebElement btn_Uninstall;
    public WebElement getUninstallButtonBc() {
        return btn_Uninstall;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for confirm button Bc
     * @date 12 April 2021
     */
    @FindBy(how = How.XPATH, using = "//button[text()='Confirm']")
    WebElement btn_confirm;
    public WebElement getConfirmButtonBC() {
        return btn_confirm;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for sign in with hike credential button Bc
     * @date 12 April 2021
     */
    @FindBy(how = How.XPATH, using = "//a[text()='Sign in with Hike creditionals']")
    WebElement btn_signinwithhikecreed;
    public WebElement getSignImWithHikeCredentialButton() {
        return btn_signinwithhikecreed;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for hike login button Bc
     * @date 12 April 2021
     */
    @FindBy(how = How.XPATH, using = "//a[text()='Login']")
    WebElement btn_hikeloginBc;
    public WebElement getHikeLoginButtonBC() {
        return btn_hikeloginBc;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for manage Button
     * @date 13 April 2021
     */
    @FindBy(how = How.XPATH, using = "//table//tr//td[contains(text(),'BigCommerce')]//parent::tr//button[contains(text(),'Manage')]")
    WebElement btn_manage;
    public WebElement getManageButton() {
        return btn_manage;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Save Button
     * @date 22 March 2021
     */
    @FindBy(how = How.XPATH, using = "//form[@name='bigcommSettings']//div[@class='slider-modal-actions']//span[contains(text(),'Save')]//parent::button")
    WebElement btn_save;
    public WebElement getSaveButton() {
        return btn_save;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for sync process log
     * @date 22 March 2021
     */
    @FindBy(how = How.XPATH, using = "//table//tr//td[contains(text(),'BigCommerce')]//parent::tr//a[contains(text(),'Sync process log')]")
    WebElement btn_syncprocesslog;
    public WebElement getSyncProcessLogButton() {
        return btn_syncprocesslog;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for view product button
     * @date 14 April 2021
     */
    @FindBy(how = How.XPATH, using = "//products-menu//a[text()='View']")
    WebElement btn_viewProduct;
    public WebElement getViewProductsButton() {
        return btn_viewProduct;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for get product search button
     * @date 14 April 2021
     */
    @FindBy(how = How.CSS, using = "#search-query")
    WebElement btn_productsearch;
    public WebElement getProductSearchButton() {
        return btn_productsearch;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for get home button
     * @date 14 April 2021
     */
    @FindBy(how = How.XPATH, using = "//span[text()='Home']")
    WebElement btn_home;
    public WebElement getHomeButton() {
        return btn_home;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for view customer button
     * @date 14 April 2021
     */
    @FindBy(how = How.XPATH, using = "//customers-menu//a[text()='View']")
    WebElement btn_viewcustomers;
    public WebElement getViewCustomersButton() {
        return btn_viewcustomers;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for get customer search button
     * @date 14 April 2021
     */
    @FindBy(how = How.XPATH, using = "//customers-list//input[@placeholder='Filter by Keyword']")
    WebElement btn_customersearch;
    public WebElement getCustomersSearchButton() {
        return btn_customersearch;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for orders button
     * @date 12 April 2021
     */
    @FindBy(how = How.XPATH, using = "//orders-menu//span[text()='Orders']//parent::a//span")
    WebElement btn_orders;
    public WebElement getOrdersButton() {
        return btn_orders;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for order view button
     * @date 14 April 2021
     */
    @FindBy(how = How.XPATH, using = "//orders-menu//a[text()='View']")
    WebElement btn_orderView;
    public WebElement getOrdersViewButton() {
        return btn_orderView;
    }

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for get orders search button
     * @date 14 April 2021
     */
    @FindBy(how = How.XPATH, using = "//input[@id='keyword-filter']")
    WebElement btn_ordersSearch;
    public WebElement getordersSearchButton() {
        return btn_ordersSearch;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for add product button
     * @date 14 April 2021
     */
    @FindBy(how = How.XPATH, using = "//products-menu//a[text()='Add']")
    WebElement btn_addProduct;
    public WebElement getAddProductsButton() {
        return btn_addProduct;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for product name input box
     * @date 14 April 2021
     */
    @FindBy(how = How.CSS, using = "input#productInput-name")
    WebElement txt_Productname;
    public WebElement getProductName() {
        return txt_Productname;
    }

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for product sku input box
     * @date 14 April 2021
     */
    @FindBy(how = How.CSS, using = "input#productInput-sku")
    WebElement txt_Productsku;
    public WebElement getProductSKU() {
        return txt_Productsku;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for product price input box
     * @date 14 April 2021
     */
    @FindBy(how = How.CSS, using = "input#productInput-price")
    WebElement txt_Productprice;
    public WebElement getProductPrice() {
        return txt_Productprice;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for product weight input box
     * @date 14 April 2021
     */
    @FindBy(how = How.CSS, using = "input#productInput-weight")
    WebElement txt_Productweight;
    public WebElement getProductWeight() {
        return txt_Productweight;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for product Track inventory check box
     * @date 14 April 2021
     */
    @FindBy(how = How.XPATH, using = "//span[text()='Track inventory']//parent::label")
    WebElement Chk_ProductTrackinventory;
    public WebElement getProductTrackInventoryCheck() {
        return Chk_ProductTrackinventory;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for product category check box
     * @date 14 April 2021
     */
    @FindBy(how = How.XPATH, using = "//li[@category][1]//label")
    WebElement chk_productcategory;
    public WebElement getProductCategory() {
        return chk_productcategory;
    }



    /**
     * @author Vidhi Chapanera
     * @discription this locator is for product stock input box
     * @date 14 April 2021
     */
    @FindBy(how = How.CSS, using = "input#productInput-inventory_level")
    WebElement txt_Productstock;
    public WebElement getProductStock() {
        return txt_Productstock;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for product low stock input box
     * @date 14 April 2021
     */
    @FindBy(how = How.CSS, using = "input#productInput-inventory_warning_level")
    WebElement txt_Productlowstock;
    public WebElement getProductLowStock() {
        return txt_Productlowstock;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for add customers button
     * @date 14 April 2021
     */
    @FindBy(how = How.XPATH, using = "//customers-menu//a[text()='Add']")
    WebElement btn_addCustomers;
    public WebElement getAddCustomersButton() {
        return btn_addCustomers;
    }



    /**
     * @author Vidhi Chapanera
     * @discription this locator is for add orders button
     * @date 14 April 2021
     */
    @FindBy(how = How.XPATH, using = "//orders-menu//a[text()='Add']")
    WebElement btn_addorders;
    public WebElement getAddOrdersButton() {
        return btn_addorders;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for customer search input box
     * @date 14 April 2021
     */
    @FindBy(how = How.CSS, using = "input#orderForSearch")
    WebElement txt_searchCustomer;
    public WebElement getSearchCustomer() {
        return txt_searchCustomer;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for next button
     * @date 14 April 2021
     */
    @FindBy(how = How.XPATH, using = "//button[contains(text(),'Next')]")
    WebElement btn_next;
    public WebElement getNextButton() {
        return btn_next;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for save button
     * @date 14 April 2021
     */
    @FindBy(how = How.XPATH, using = "//button[contains(text(),'Save & Process Payment')]")
    WebElement btn_saveorder;
    public WebElement getSaveorderButton() {
        return btn_saveorder;
    }



    /**
     * @author Vidhi Chapanera
     * @date 12 April 2021
     * @discription this method is use to create hike store for BigCommerce
     * @return
     */
   /* @Step("create hike store for BigCommerce")
    public boolean createHikeStoreForBigCommerce(){
        CenterlizePO centerlizePO = PageFactory.initElements(driver,CenterlizePO.class);
        try{
            sleepFor(5);
            String fileLocation =System.getProperty("user.dir")+"\\src\\main\\resources\\createStore.properties";
            Properties properties1 = new Properties();
            properties1.load(new FileReader(fileLocation));
            centerlizePO.clickOnButton(PageFactory.initElements(driver, CreateStore.class).getStartFreeTrialLink());
            PageFactory.initElements(driver, CreateStore.class).renameFileData
                    (PageFactory.initElements(driver, CreateStore.class).getFirstNameTextBox()
                            ,"\\src\\main\\java\\IntegrationsPO\\BigCommercePO\\File\\FirstName");
            PageFactory.initElements(driver, CreateStore.class).renameFileData
                    (PageFactory.initElements(driver, CreateStore.class).getLastNameTextBox()
                            ,"\\src\\main\\java\\IntegrationsPO\\BigCommercePO\\File\\LastName");
            centerlizePO.enterDataUsingSendkeys(PageFactory.initElements(driver, CreateStore.class).getEmailTextBox(), StoreConstant.EMAIL);
            centerlizePO.enterDataUsingSendkeys(PageFactory.initElements(driver, CreateStore.class).getPhoneTextBox(), StoreConstant.PHONE);
            centerlizePO.clearText(PageFactory.initElements(driver, CreateStore.class).getCityTextBox());
            centerlizePO.enterDataUsingSendkeys(PageFactory.initElements(driver, CreateStore.class).getCityTextBox(),StoreConstant.CITY);
            centerlizePO.enterDataUsingSendkeys(PageFactory.initElements(driver, CreateStore.class).getPasswordTextBox(),String.valueOf(properties1.put(StoreConstant.PASSWORD,"password")));
            centerlizePO.clickOnButton(PageFactory.initElements(driver, CreateStore.class).getContinueButton());
            PageFactory.initElements(driver, CreateStore.class).renameFileData
                    (PageFactory.initElements(driver, CreateStore.class).getAccountAddressTextBox()
                            ,"\\src\\main\\java\\IntegrationsPO\\BigCommercePO\\File\\AccountAddress");
            sleepFor( 3);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, CreateStore.class).getContinueButtonOnAccountAddressPage());
            centerlizePO.selectValueFromDropDown(PageFactory.initElements(driver, CreateStore.class).getIndustryTypeDropDown(),"Fashion & Clothing Retail");
            centerlizePO.clickOnButton(PageFactory.initElements(driver, CreateStore.class).getCreteMyStoreButton());
            sleepFor(30);
            sleepFor(1);
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
*/


    @Step("create hike store for BigCommerce")
    public boolean createHikeStoreForBigCommerce(){
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
            PageFactory.initElements(driver,Shopify.class).PurgeData();
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }




    /**
     * @author Vidhi Chapanera
     * @date 12 April 2021
     * @discription this method is use to login to shopify existing store
     * @return
     */
    @Step("login to shopify existing store")
    public boolean loginToShopifyExistingStore() throws IOException {
        CenterlizePO centerlizePO = PageFactory.initElements(driver,CenterlizePO.class);
        Actions actions = new Actions(driver);
        try{
            sleepFor(5);
            sleepFor(5);
            String fileLocation =System.getProperty("user.dir")+"\\src\\main\\resources\\BigCommerce.properties";
            Properties properties1 = new Properties();
            properties1.load(new FileReader(fileLocation));
            JavascriptExecutor jse = (JavascriptExecutor)driver;
            jse.executeScript("window.open()");
            ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));
            sleepFor(1);
            driver.get("https://login.bigcommerce.com/login");
            sleepFor(5);
            centerlizePO.enterDataUsingSendkeys(getEmailBC(),String.valueOf(properties1.put(BigCommerceConstant.EMAIL_ID,"email_id_BC")));
            centerlizePO.enterDataUsingSendkeys(getPasswordBC(),String.valueOf(properties1.put(BigCommerceConstant.PASSWORD,"passwordBC")));
            centerlizePO.clickOnButton(getLoginButton());
            sleepFor(10);
            readEmail();
            centerlizePO.enterDataUsingSendkeys(getVerificationCode(),verificationCode);
            sleepFor(2);
            deleteMail();
            sleepFor(1);
            centerlizePO.clickOnButton(getLoginButton());
            sleepFor(70);
            try{
                if (driver.findElement(By.xpath("//p[contains(text(),'Your free trial is over')]")).isDisplayed()){
                    sleepFor( 2);
                    jse.executeScript("window.close()");
                    driver.switchTo().window(tabs.get(0));
                    jse.executeScript("window.open()");
                    ArrayList<String> tabs1 = new ArrayList<String> (driver.getWindowHandles());
                    driver.switchTo().window(tabs1.get(1));
                    sleepFor(1);
                    driver.get("chrome://settings/clearBrowserData");
                    actions.sendKeys(Keys.TAB).build().perform();
                    sleepFor( 1);
                    actions.sendKeys(Keys.TAB).build().perform();
                    sleepFor( 1);
                    actions.sendKeys(Keys.TAB).build().perform();
                    sleepFor( 1);
                    actions.sendKeys(Keys.TAB).build().perform();
                    sleepFor( 1);
                    actions.sendKeys(Keys.TAB).build().perform();
                    sleepFor( 1);
                    actions.sendKeys(Keys.TAB).build().perform();
                    sleepFor( 1);
                    actions.sendKeys(Keys.TAB).build().perform();
                    sleepFor( 1);
                    actions.sendKeys(Keys.TAB).build().perform();
                    sleepFor( 1);
                    actions.sendKeys(Keys.ENTER).build().perform();
                    sleepFor( 10);
                    jse.executeScript("window.close()");
                    driver.switchTo().window(tabs1.get(0));
                    jse.executeScript("window.open()");
                    ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
                    driver.switchTo().window(tabs2.get(1));
                    sleepFor(1);
                    driver.get("https://login.bigcommerce.com/login");
                    sleepFor(8);
                    centerlizePO.clickOnButton(getstartedButton());
                    sleepFor( 5);
                    /*List<WebElement> btn = new WebDriverWait(driver,60).
                            until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//a[contains(text(),'Start your free trial')]")));
                    btn.get(0).click();*/
                    sleepFor( 2);
                    PageFactory.initElements(driver, CreateStore.class).renameFileData
                            (getFirstName(),"\\src\\main\\java\\IntegrationsPO\\BigCommercePO\\File\\FirstNameBC");
                    PageFactory.initElements(driver, CreateStore.class).renameFileData
                            (getLastName(),"\\src\\main\\java\\IntegrationsPO\\BigCommercePO\\File\\LastNameBC");
                    centerlizePO.enterDataUsingSendkeys( getPhone(),"0444000555");
                    centerlizePO.enterDataUsingSendkeys(getEmailBCT(),String.valueOf(properties1.put(BigCommerceConstant.NEW_EMAIL,"new_email")));
                    centerlizePO.enterDataUsingSendkeys(getPasswordN(),String.valueOf(properties1.put(BigCommerceConstant.PASSWORD,"passwordBC")));
                    PageFactory.initElements(driver, Shopify.class).renameFileData
                            (getStoreName(),"\\src\\main\\java\\IntegrationsPO\\BigCommercePO\\File\\BCStore");
                    WebElement project = new WebDriverWait( driver,60 ).until(
                            ExpectedConditions.presenceOfElementLocated(By.name("projectedAnnualRevenue")));
                    Select select = new Select(project);
                    select.selectByIndex(2);
                    centerlizePO.clickOnButton(getCreateYourStoreButton());
                   /* sleepFor(10);
                    WebElement btn01 = new WebDriverWait(driver,300).until(ExpectedConditions.presenceOfElementLocated(
                            By.xpath("//a[contains(text(),'Ask me later')]")));
                    jse.executeScript("arguments[0].click();",btn01);*/
                    sleepFor(15);
                }
            }catch (Exception e){
                System.out.println(true);
            }
            deleteCustomer();
            deleteProduct();
            ArrayList<String> tabs3 = new ArrayList<String> (driver.getWindowHandles());
            driver.switchTo().window(tabs3.get(0));
            sleepFor( 3);
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }


    /**
     * @author Vidhi Chapanera
     * @date 12 April 2021
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
     * @date 12 April 2021
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
     * @date 12 April 2021
     * @return
     * @throws Exception
     * @discription this method is used to verify and Read Email for AR Statement(Email Template Functionality)
     */
    @Step("verify and Read Email for AR Statement(Email Template Functionality)")
    public boolean readEmail() throws IOException {
        String fileLocation =System.getProperty("user.dir")+"\\src\\main\\resources\\BigCommerce.properties";
        Properties properties1 = new Properties();
        properties1.load(new FileReader(fileLocation));
        String receivingHost="imap.gmail.com";
        Properties props2=System.getProperties();
        props2.setProperty("mail.store.protocol", "imaps");
        Session session2=Session.getDefaultInstance(props2, null);
        try {
            Store store=session2.getStore("imaps");
            String userName = String.valueOf(properties1.put( BigCommerceConstant.EMAIL_ID,"email_id_BC"));
            String password = String.valueOf(properties1.put( BigCommerceConstant.AUTHPASSWORD,"gmailpasswordauth"));
            store.connect(receivingHost,userName, password);
            Folder folder=store.getFolder("INBOX");
            folder.open(Folder.READ_WRITE);
            Message[] messages = folder.getMessages();
            String receivingSubject = messages[messages.length-1].getSubject();
            System.out.println("receivingSubject : " + receivingSubject);
            String  result = org.jsoup.Jsoup.parse(messages[messages.length-1].getContent().toString()).text();
            verificationCode = CharMatcher.digit().retainFrom(result.split("Use the code below to verify your device:")[1]);
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
     * @date 12 April 2021
     * @return
     * @throws Exception
     * @discription this method is used to delete mail
     */
    @Step("delete mail")
    public boolean deleteMail() throws IOException {
        String fileLocation =System.getProperty("user.dir")+"\\src\\main\\resources\\BigCommerce.properties";
        Properties properties1 = new Properties();
        properties1.load(new FileReader(fileLocation));
        sleepFor(5);
        String receivingHost="imap.gmail.com";
        Properties props2=System.getProperties();
        props2.setProperty("mail.store.protocol", "imaps");
        Session session2=Session.getDefaultInstance(props2, null);
        try {
            Store store=session2.getStore("imaps");
            String userName = String.valueOf(properties1.put( BigCommerceConstant.EMAIL_ID,"email_id_BC"));
            String password = String.valueOf(properties1.put( BigCommerceConstant.AUTHPASSWORD,"gmailpasswordauth"));
            store.connect(receivingHost,userName, password);
            Folder folder=store.getFolder("INBOX");
            folder.open(Folder.READ_WRITE);
            Message message1[]=folder.getMessages();
            Message message = message1[message1.length-1];
            message.setFlag(Flags.Flag.DELETED, true);
            System.out.println("Marked DELETE for message : " + message1[message1.length-1].getSubject());
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
     * @date 30 March 2021
     * @discription this method is use to delete customer
     * @return
     */
    @Step("delete customer")
    public boolean deleteCustomer() throws IOException {
        try{
            JavascriptExecutor jse = (JavascriptExecutor)driver;
            jse.executeScript("arguments[0].click();",getCustomerButton());
            driver.switchTo().frame("content-iframe");
            try{
                sleepFor( 5);
                if (driver.findElement(By.xpath("//div[@class='noResults']")).isDisplayed()){
                    System.out.println("no Customer Found/....!");
                }
            }catch (Exception e){
                WebElement customerchk = new WebDriverWait(driver,60).until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//th//label")));
                jse.executeScript("arguments[0].click();",customerchk);
                sleepFor(2);
                WebElement deleteIcon = new WebDriverWait(driver,60).until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//icon[@glyph='ic-delete']//parent::button")));
                jse.executeScript("arguments[0].click();",deleteIcon);
                sleepFor(2);
                WebElement OK = new WebDriverWait(driver,60).until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//span[text()='OK']//parent::button")));
                jse.executeScript("arguments[0].click();",OK);
            }
            sleepFor( 1 );
            driver.switchTo().defaultContent();
            PageFactory.initElements( driver,CenterlizePO.class ).clickOnButton( getHomeButton() );
            sleepFor( 1 );
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }


    /**
     * @author Vidhi Chapanera
     * @date 30 March 2021
     * @discription this method is use to delete product
     * @return
     */
    @Step("delete customer")
    public boolean deleteProduct() throws IOException {
        Actions actions = new Actions(driver);
        try{
            sleepFor( 1 );
            JavascriptExecutor jse = (JavascriptExecutor)driver;
            jse.executeScript("arguments[0].click();",getProductsButton());
            driver.switchTo().frame("content-iframe");
            WebElement prochk = new WebDriverWait(driver,60).until(ExpectedConditions.presenceOfElementLocated(
                    By.xpath("//th//label")));
            jse.executeScript("arguments[0].click();",prochk);
            sleepFor(2);
            WebElement deleteIcon = new WebDriverWait(driver,60).until(ExpectedConditions.presenceOfElementLocated(
                    By.xpath("//i[contains(@class,'trash')]/parent::button")));
            jse.executeScript("arguments[0].click();",deleteIcon);
            sleepFor(2);
            try{
                List<WebElement> OK = new WebDriverWait(driver,60).until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                        By.xpath("//button[text()='Ok']")));
                actions.moveToElement(OK.get(OK.size()-1)).click().build().perform();
                sleepFor(1);
            }catch (Exception e){
                actions.sendKeys( Keys.ESCAPE ).build().perform();
                System.out.println("ESCAPE");
            }
            driver.switchTo().defaultContent();
            PageFactory.initElements( driver,CenterlizePO.class ).clickOnButton( getHomeButton() );
            sleepFor( 2);
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }



    /**
     * @author Vidhi Chapanera
     * @date 19 March 2021
     * @discription this method is use to click on activate button on BigCommerce
     * @return
     */
    @Step("click on activate button on BigCommerce")
    public boolean clickOnActivateButtonOnBigCommerce(){
        CenterlizePO centerlizePO = PageFactory.initElements(driver,CenterlizePO.class);
        try{
            String fileLocation =System.getProperty("user.dir")+"\\src\\main\\resources\\createStore.properties";
            Properties properties1 = new Properties();
            properties1.load(new FileReader(fileLocation));
            sleepFor(5);
            PageFactory.initElements(driver, StoreSetup.class).clickOnStoreSetupButton();
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Integrations.class).getIntegrationsButton());
            sleepFor(3);
            centerlizePO.clickOnButton(getBigCommerceActivate());
            sleepFor(5);
            WebElement login = new WebDriverWait(driver,90).until(
                    ExpectedConditions.presenceOfElementLocated(By.xpath("//h4[text()='Existing BigCommerce store']//following-sibling::a")));
            centerlizePO.clickOnButton(login);
            sleepFor( 20);
            ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));
            JavascriptExecutor jse = (JavascriptExecutor)driver;
            jse.executeScript("window.close()");
            driver.switchTo().window(tabs.get(0));
            driver.switchTo().frame("content-iframe");
            try{
                if(getUninstallButtonBc().isDisplayed()) {
                    jse.executeScript( "arguments[0].click();", getUninstallButtonBc() );
                }
            }catch (Exception e){
                System.out.println("uninstall button not found...!");
            }
            sleepFor(10);
            centerlizePO.clickOnButton(getinstallButtonBc());
            sleepFor(10);
            driver.switchTo().defaultContent();
            WebElement frame = new WebDriverWait(driver,60).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//iframe[@class='cp-iframe']")));
            driver.switchTo().frame(frame);
            centerlizePO.clickOnButton(getConfirmButtonBC());
            sleepFor(20);
            centerlizePO.clickOnButton(getSignImWithHikeCredentialButton());
            sleepFor(5);
            centerlizePO.enterDataUsingSendkeys(PageFactory.initElements( driver, Login.class).getAccountAddressTextBox(),getAddressValue());
            centerlizePO.enterDataUsingSendkeys(PageFactory.initElements( driver, Login.class).getEmailTextBox(),StoreConstant.EMAIL);
            centerlizePO.enterDataUsingSendkeys(PageFactory.initElements( driver, Login.class).getpasswordTextBox(),String.valueOf(properties1.put(StoreConstant.PASSWORD,"password")));
            centerlizePO.clickOnButton(PageFactory.initElements( driver, Login.class).getLoginButton());
            sleepFor(10);
            centerlizePO.clickOnButton(getHikeLoginButtonBC());
            driver.switchTo().defaultContent();
            sleepFor( 10);
            System.out.println(tabs.size());
            ArrayList<String> tabs1 = new ArrayList<String> (driver.getWindowHandles());
            driver.switchTo().window(tabs1.get(1));
            centerlizePO.enterDataUsingSendkeys(PageFactory.initElements( driver, Login.class).getEmailTextBox(),StoreConstant.EMAIL);
            centerlizePO.enterDataUsingSendkeys(PageFactory.initElements( driver, Login.class).getpasswordTextBox(),String.valueOf(properties1.put(StoreConstant.PASSWORD,"password")));
            centerlizePO.clickOnButton(PageFactory.initElements( driver, Login.class).getLoginButton());
            sleepFor(3);
            try {
                if (driver.findElement( By.xpath( "//div[text()='Login failed!']" ) ).isDisplayed()) {
                    sleepFor( 1 );
                    WebElement btn = new WebDriverWait( driver, 60 ).
                            until( ExpectedConditions.presenceOfElementLocated( By.xpath( "//div[text()='Login failed!']//parent::div//button" ) ) );
                    btn.click();
                    sleepFor( 1 );
                    centerlizePO.clearText( PageFactory.initElements( driver, Login.class ).getpasswordTextBox());
                    centerlizePO.enterDataUsingSendkeys(PageFactory.initElements( driver, Login.class ).getpasswordTextBox(),String.valueOf(properties1.put(StoreConstant.PASSWORD,"password")));
                    centerlizePO.clickOnButton(PageFactory.initElements( driver, Login.class).getLoginButton());
                    sleepFor( 3 );
                }
            }catch (Exception e){
                System.out.println(true);
            }
            sleepFor( 10);
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }


    /**
     * @author Vidhi Chapanera
     * @date 12 April 2021
     * @return
     * @throws IOException
     * @discription this method is used to get account address value
     */
    @Step("")
    public String getAddressValue() throws IOException {
        String tesLine ="";
        File f = new File(System.getProperty("user.dir") + "\\src\\main\\java\\IntegrationsPO\\BigCommercePO\\File\\AccountAddress");
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
     * @date 13 April 2021
     * @discription this method is use to mapping BigCommerce
     * @return
     */
    @Step("mapping BigCommerce")
    public boolean mappingBigCommerce() throws IOException {
        CenterlizePO centerlizePO = PageFactory.initElements(driver,CenterlizePO.class);
        Actions actions = new Actions(driver);
        try{
            sleepFor(1);
            ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));
            sleepFor(5);
            PageFactory.initElements(driver, StoreSetup.class).clickOnStoreSetupButton();
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Integrations.class).getIntegrationsButton());
            sleepFor(3);
            centerlizePO.clickOnButton(getManageButton());
            sleepFor(8);
            WebElement register = new WebDriverWait(driver, 60).ignoring(StaleElementReferenceException.class).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//label[@for='syncLoremIpsum']")));
            centerlizePO.clickOnButton( register );
            WebElement retailpricedrpdwn = new WebDriverWait(driver, 60).ignoring(StaleElementReferenceException.class).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//label[contains(text(),'retail prices is BC')]//following-sibling::div//a")));
            centerlizePO.clickOnButton(retailpricedrpdwn);
            WebElement retailpricedrpdwnoption = new WebDriverWait(driver, 60).ignoring(StaleElementReferenceException.class).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//label[contains(text(),'retail prices is BC')]//following-sibling::div//a//following-sibling::div//li//ul//li//div[text()='Price']")));
            centerlizePO.clickOnButton(retailpricedrpdwnoption);

            WebElement taxdrpdwn = new WebDriverWait(driver, 60).ignoring(StaleElementReferenceException.class).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//label[contains(text(),'Hike Shipping tax for Invoice')]//following-sibling::tax-combo//div//a")));
            centerlizePO.clickOnButton(taxdrpdwn);
            WebElement taxdrpdwnoption = new WebDriverWait(driver, 60).ignoring(StaleElementReferenceException.class).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//label[contains(text(),'Hike Shipping tax for Invoice')]//following-sibling::tax-combo//div//a//following-sibling::div//li//ul//li//div[text()='No Tax']")));
            centerlizePO.clickOnButton(taxdrpdwnoption);
            List<WebElement> list = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                            By.xpath("//th[text()='Hike tax']//parent::tr//parent::thead//following-sibling::tbody//tr//a")));
            centerlizePO.clickOnButton(list.get(0));
            WebElement list0 = new WebDriverWait(driver, 60).ignoring(StaleElementReferenceException.class).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//th[text()='Hike tax']//parent::tr//parent::thead//following-sibling::tbody//tr//a//following-sibling::div//li//ul//li//div[text()='Non-Taxable Products']")));
            centerlizePO.clickOnButton(list0);
            centerlizePO.clickOnButton(list.get(1));
            WebElement list1 = new WebDriverWait(driver, 60).ignoring(StaleElementReferenceException.class).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//th[text()='Hike tax']//parent::tr//parent::thead//following-sibling::tbody//tr//a//following-sibling::div//li//ul//li//div[text()='GST']")));
            centerlizePO.clickOnButton(list1);

            WebElement outlets = new WebDriverWait(driver, 60).ignoring(StaleElementReferenceException.class).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//label[text()='Map Hike outlets and Big commerce locations ']//following-sibling::div//input")));
            centerlizePO.clickOnButton(outlets);
            sleepFor( 2);
            actions.sendKeys( Keys.TAB ).build().perform();
            sleepFor( 2);
            List<WebElement> webElementList = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                            By.xpath("//span[text()='Sync settings']//parent::div//parent::div//following-sibling::div//div[@class='md-checkbox-list']//label")));
            for(int i=0;i<webElementList.size()-1;i++){
                sleepFor(1);
                centerlizePO.clickOnButton(webElementList.get(i));
            }
            sleepFor(3);
            actions.sendKeys(Keys.PAGE_DOWN).build().perform();
            centerlizePO.clickOnButton(getSaveButton());
            sleepFor( 8);
            if(getManageButton().isDisplayed()) {
                centerlizePO.clickOnButton(getManageButton());
                sleepFor( 1 );
                centerlizePO.clickOnButton(PageFactory.initElements(driver,Shopify.class).getManualSyncButton());
                sleepFor( 4 );
                String[] strArray2 = new String[]{"syncProducts", "syncCustomers", "syncSales"};
                for (String s : strArray2) {
                    WebElement element = new WebDriverWait( driver, 60 ).ignoring( StaleElementReferenceException.class ).
                            until( ExpectedConditions.presenceOfElementLocated
                                    ( By.xpath( "//label[@for='" + s + "']" ) ) );
                    element.click();
                }
                sleepFor( 1 );
                centerlizePO.clickOnButton(PageFactory.initElements(driver,Shopify.class).getButtonSyncNow() );
                sleepFor( 2 );
                centerlizePO.clickOnButton(getSaveButton());
                sleepFor( 10 );
            }
           /* centerlizePO.clickOnButton(PageFactory.initElements(driver,Shopify.class).getSyncProcessLogButton() );
            centerlizePO.clickOnButton(PageFactory.initElements(driver,Shopify.class).getShowErrorsOnly());
            sleepFor(4);
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
            System.out.println(true);*/
            sleepFor(5 );
            sleepFor(5 );
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }



    /**
     * @author Vidhi Chapanera
     * @date 14 April 2021
     * @discription this method is use to create Product Hike to BigCommerce and verify in BigCommerce
     * @return
     */
    @Step("create Product Hike to BigCommerce and verify in BigCommerce")
    public boolean createProductHiketoBigCommerce() throws IOException {
        CenterlizePO centerlizePO = PageFactory.initElements(driver, CenterlizePO.class);
        ProductsPO.ProductsPO.Products products1 = PageFactory.initElements(driver, ProductsPO.ProductsPO.Products.class);
        Actions actions = new Actions(driver);
        try{
            sleepFor(5);
            ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));
            PageFactory.initElements(driver, ProductsPO.Products.class).clickOnProductsButtonn();
            centerlizePO.clickOnButton(products1.getProductButton());
            sleepFor(2);
            centerlizePO.clickOnButton(products1.getAddProductButton());
            sleepFor(2);
            PageFactory.initElements(driver, Shopify.class).renameFileData
                    (PageFactory.initElements(driver,Products.class).getProductName(),"\\src\\main\\java\\IntegrationsPO\\BigCommercePO\\File\\Product");
            centerlizePO.clickOnButton(PageFactory.initElements(driver,Shopify.class).getEcommerceCheckbox());
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
            centerlizePO.enterDataUsingSendkeys(products1.getProductType(),"PT");
            actions.sendKeys(Keys.TAB).build().perform();
            centerlizePO.enterDataUsingSendkeys(products1.getSuppliers(),"Automation Suppliers");
            actions.sendKeys(Keys.TAB).build().perform();
            centerlizePO.enterDataUsingSendkeys(products1.getBrand(),"Automation Brand");
            actions.sendKeys(Keys.TAB).build().perform();
            centerlizePO.clickOnButton(products1.getProductSaveButton());
            sleepFor(5);
            centerlizePO.enterDataUsingSendkeys(PageFactory.initElements(driver, Products.class).getSearchBox(),getValue("\\src\\main\\java\\IntegrationsPO\\BigCommercePO\\File\\Product"));
            sleepFor(3);
            List<WebElement> list1 = new WebDriverWait(driver,120).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy
                            (By.xpath("//ul[contains(@class,'hike-width-block')]//b[text()='Product']//parent::ul//li//a")));
            list1.get(0).click();
            sleepFor(3);
            WebElement name = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//table[@id='RosterDataTable']//tbody//tr//td[2]//span[text()='" + getValue("\\src\\main\\java\\IntegrationsPO\\BigCommercePO\\File\\Product") + "']//parent::td//following-sibling::td//a")));
            name.click();
            while(true){
                sleepFor(1);
                centerlizePO.clickOnButton(PageFactory.initElements(driver,Shopify.class).getRefreshLogButton());
                sleepFor(3);
                WebElement e = new WebDriverWait(driver,60).
                        until(ExpectedConditions.presenceOfElementLocated
                                (By.xpath("//td[text()='Hike - BigCommerce']//following-sibling::td[1][text()='Created']")));
                if (e.isDisplayed())
                    break;
            }
            sleepFor(2);
            actions.sendKeys(Keys.ESCAPE).build().perform();
            sleepFor(3);
            driver.switchTo().window(tabs.get(0));
            sleepFor(2);
            JavascriptExecutor jse = (JavascriptExecutor)driver;
            jse.executeScript("arguments[0].click();",getProductsButton());
            sleepFor(1);
            centerlizePO.clickOnButton(getViewProductsButton());
            sleepFor(1);
            driver.switchTo().frame("content-iframe");
            centerlizePO.enterDataUsingSendkeys(getProductSearchButton(),getValue("\\src\\main\\java\\IntegrationsPO\\BigCommercePO\\File\\Product"));
            WebElement filterIcon = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//button[contains(@class,'filter-button')]")));
            filterIcon.click();
            sleepFor(5);
            if (driver.findElement(By.xpath("//a[text()='"+getValue("\\src\\main\\java\\IntegrationsPO\\BigCommercePO\\File\\Product")+"']")).isDisplayed())
                System.out.println(" ");
            sleepFor(1);
            driver.switchTo().defaultContent();
            centerlizePO.clickOnButton( getHomeButton() );
            sleepFor( 3 );
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }


    /**
     * @author Vidhi Chapanera
     * @date 14 April 2021
     * @discription this method is use to create Customer Hike to BigCommerce and verify in BigCommerce
     * @return
     */
    @Step("create Customer Hike to BigCommerce and verify in BigCommerce")
    public boolean createCustomersHiketoBigCommerce(String customer) throws IOException {
        CenterlizePO centerlizePO = PageFactory.initElements(driver, CenterlizePO.class);
        Actions actions = new Actions(driver);
        try{
            sleepFor(5);
            ArrayList<String> tabs1 = new ArrayList<String> (driver.getWindowHandles());
            driver.switchTo().window(tabs1.get(1));
            PageFactory.initElements(driver, CustomersPO.Customers.class).clickOnCustomersButton();
            sleepFor(2);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, CustomersPO.CustomersPO.Customers.class).getCustomersButton());
            sleepFor(1);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, CustomersPO.CustomersPO.Customers.class).getAddCustomerButton());
            sleepFor(5);
            centerlizePO.enterDataUsingSendkeys(PageFactory.initElements(driver, CustomersPO.CustomersPO.Customers.class).getFirstName(),customer.split(" ")[0]);
            centerlizePO.enterDataUsingSendkeys(PageFactory.initElements(driver, CustomersPO.CustomersPO.Customers.class).getLastName(),customer.split(" ")[1]);
            centerlizePO.enterDataUsingSendkeys(PageFactory.initElements(driver, CustomersPO.CustomersPO.Customers.class).getEmail(),customer.split(" ")[0]+"@yopmail.com");
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
                            (By.xpath("//table[@id='CustomersTable']//tbody//tr//td[2]//span[contains(text(),'"+customer+"')]//parent::td//following-sibling::td//a")));
            name.click();
            while(true){
                sleepFor(1);
                centerlizePO.clickOnButton(PageFactory.initElements( driver,Shopify.class ).getRefreshLogButton());
                sleepFor(3);
                WebElement e = new WebDriverWait(driver,60).
                        until(ExpectedConditions.presenceOfElementLocated
                                (By.xpath("//td[text()='Hike - BigCommerce']//following-sibling::td[1][text()='Created']")));
                if (e.isDisplayed())
                    break;
            }
            sleepFor(2);
            actions.sendKeys(Keys.ESCAPE).build().perform();
            sleepFor(3);
            ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
            driver.switchTo().window(tabs.get(0));
            sleepFor(2);
            JavascriptExecutor jse = (JavascriptExecutor)driver;
            jse.executeScript("arguments[0].click();",getCustomerButton());
            sleepFor(5  );
            centerlizePO.clickOnButton( getViewCustomersButton() );
            driver.switchTo().frame("content-iframe");
            centerlizePO.enterDataUsingSendkeys(getCustomersSearchButton(),customer);
            WebElement filterIcon = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//customers-list//input[@placeholder='Filter by Keyword']//parent::div//span//button")));
            filterIcon.click();
            sleepFor(5);
            if (driver.findElement(By.xpath("//a[contains(text(),'"+customer+"')]")).isDisplayed())
                System.out.println(" ");
            sleepFor(1);
            driver.switchTo().defaultContent();
            centerlizePO.clickOnButton( getHomeButton() );
            sleepFor( 3 );
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    /**
     * @author Vidhi Chapanera
     * @date 14 April 2021
     * @discription this method is use to create sale Hike to BigCommerce and verify in BigCommerce
     * @return
     */
    @Step("create sale Hike to BigCommerce and verify in BigCommerce")
    public boolean createSaleHiketoBigCommerce() throws IOException {
        CenterlizePO centerlizePO = PageFactory.initElements(driver, CenterlizePO.class);
        Actions actions = new Actions(driver);
        try{
            sleepFor(5);
            ArrayList<String> tabs1 = new ArrayList<String> (driver.getWindowHandles());
            driver.switchTo().window(tabs1.get(0));
            driver.close();
            sleepFor(1);
            ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
            driver.switchTo().window(tabs.get(0));
            sleepFor(2);
            PageFactory.initElements(driver, Inventory.class).clickOnInventoryButton();
            PageFactory.initElements(driver, PointofSale.class).clickOnPointOfSaleButtonn();
            sleepFor(2);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, ProcessSale.class).getProcessSaleButton());
            sleepFor(20);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, CashRegister.class).getOpenRegisterButton());
            sleepFor(2);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Shopify.class).getOpenButton());
            sleepFor(3);
            PageFactory.initElements(driver, ProcessSale.class).getSearchBar().sendKeys(getValue("\\src\\main\\java\\IntegrationsPO\\BigCommercePO\\File\\Product"));
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
            WebElement sale01 = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//table[@id='SalesTable']//tbody//tr//td[2]//a[text()='"+saleRef+"']//parent::td//following-sibling::td//a//i//parent::a")));
            centerlizePO.clickOnButton(sale01);
            sleepFor(3);
            while(true){
                sleepFor(1);
                centerlizePO.clickOnButton(PageFactory.initElements(driver, Shopify.class).getRefreshLogButton());
                sleepFor(3);
                WebElement e = new WebDriverWait(driver,60).
                        until(ExpectedConditions.presenceOfElementLocated
                                (By.xpath("//td[text()='Hike - BigCommerce']//following-sibling::td[1][text()='Created']")));
                if (e.isDisplayed())
                    break;
            }
            sleepFor(2);
            actions.sendKeys(Keys.ESCAPE).build().perform();
            sleepFor(3);
            JavascriptExecutor jse = (JavascriptExecutor)driver;
            jse.executeScript("window.open()");
            ArrayList<String> stringArrayList = new ArrayList<String> (driver.getWindowHandles());
            driver.switchTo().window(stringArrayList.get(1));
            driver.get("https://store-kb8m1bdx0p.mybigcommerce.com/manage/dashboard");
            sleepFor(15);
            JavascriptExecutor executor = (JavascriptExecutor)driver;
            executor.executeScript("arguments[0].click();",getOrdersButton());
            centerlizePO.clickOnButton( getOrdersViewButton() );
            sleepFor( 5 );
            driver.switchTo().frame("content-iframe");
            centerlizePO.enterDataUsingSendkeys(getordersSearchButton(),getValue( "\\src\\main\\java\\IntegrationsPO\\BigCommercePO\\File\\Product"));
            WebElement filterIcon = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//input[@id='keyword-filter']//parent::div//i[contains(@class,'filter')]//parent::button")));
            filterIcon.click();
            sleepFor(5);
            try {
                if (driver.findElement( By.xpath( "//article//a[text()='" + getValue( "\\src\\main\\java\\IntegrationsPO\\BigCommercePO\\File\\Product") + "']" ) ).isDisplayed()) {
                    System.out.println("a");
                }
            }catch (Exception e ){
                if (driver.findElement(By.xpath("//a[contains(text(),'Order ID')]//parent::th//parent::tr//parent::thead//following-sibling::tbody//tr//td[5]")).isDisplayed()){
                    System.out.println("td");
                }
            }
            sleepFor(3);
            driver.switchTo().defaultContent();
            centerlizePO.clickOnButton(getHomeButton());
            sleepFor( 3 );
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }


    /**
     * @author Vidhi Chapanera
     * @date 14 April 2021
     * @discription this method is use to  create Product BigCommerce to Hike and verify in Hike
     * @return
     */
    @Step(" create Product BigCommerce to Hike and verify in Hike")
    public boolean createProductBigCommercetoHike(String product) throws IOException {
        CenterlizePO centerlizePO = PageFactory.initElements(driver, CenterlizePO.class);
        ProductsPO.ProductsPO.Products products1 = PageFactory.initElements(driver, ProductsPO.ProductsPO.Products.class);
        Actions actions = new Actions(driver);
        try{
            sleepFor(5);
            ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
            driver.switchTo().window(tabs.get(0));
            JavascriptExecutor jse = (JavascriptExecutor)driver;
            jse.executeScript("arguments[0].click();",getProductsButton());
            sleepFor(1);
            centerlizePO.clickOnButton(getAddProductsButton());
            sleepFor(1);
            driver.switchTo().frame("content-iframe");
            centerlizePO.enterDataUsingSendkeys( getProductName(),product );
            centerlizePO.enterDataUsingSendkeys( getProductSKU(),"6030800");
            centerlizePO.enterDataUsingSendkeys( getProductPrice(),"53");
            centerlizePO.enterDataUsingSendkeys( getProductWeight(),"0.5");
            actions.moveToElement(getProductCategory()).build().perform();
            jse.executeScript("arguments[0].click();",getProductCategory());
            WebElement tax= new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//custom-dropdown//button[contains(text(),'Tax')]")));
            actions.moveToElement(tax).build().perform();
            jse.executeScript("arguments[0].click();",tax);
            sleepFor(1);
            WebElement gst= new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//custom-dropdown//button[contains(text(),'Tax')]//parent::div//following-sibling::div//li[text()='GST']")));
            centerlizePO.clickOnButton( gst);
            sleepFor(2);
            actions.sendKeys( Keys.PAGE_DOWN ).build().perform();
            actions.sendKeys( Keys.PAGE_DOWN ).build().perform();
            actions.moveToElement(getProductTrackInventoryCheck()).build().perform();
            jse.executeScript("arguments[0].click();",getProductTrackInventoryCheck());
            centerlizePO.enterDataUsingSendkeys( getProductStock(),"120" );
            centerlizePO.enterDataUsingSendkeys( getProductLowStock(),"20" );
            WebElement savedrpdwn = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//button[contains(@class,'arrow-button')]")));
            centerlizePO.clickOnButton( savedrpdwn );
            WebElement save= new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//li[contains(text(),'Save & View Products')]")));
            centerlizePO.clickOnButton( save );
            sleepFor( 5 );
            driver.switchTo().defaultContent();
            centerlizePO.clickOnButton( getHomeButton() );
            driver.switchTo().window(tabs.get(1));
            PageFactory.initElements(driver, Reporting.class).clickOnReportingButton();
            PageFactory.initElements(driver, StoreSetup.class).clickOnStoreSetupButton();
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Integrations.class).getIntegrationsButton());
            sleepFor(3);
            centerlizePO.clickOnButton(getManageButton());
            sleepFor( 1 );
            centerlizePO.clickOnButton(PageFactory.initElements(driver,Shopify.class).getManualSyncButton());
            sleepFor( 4 );
            String[] strArray2 = new String[]{"syncProducts"};
            for (String s : strArray2) {
                WebElement element = new WebDriverWait( driver, 60 ).ignoring( StaleElementReferenceException.class ).
                        until( ExpectedConditions.presenceOfElementLocated
                                ( By.xpath( "//label[@for='" + s + "']" ) ) );
                element.click();
            }
            sleepFor( 1 );
            centerlizePO.clickOnButton(PageFactory.initElements(driver,Shopify.class).getButtonSyncNow() );
            sleepFor( 2 );
            centerlizePO.clickOnButton(getSaveButton());
            sleepFor( 10 );
            PageFactory.initElements(driver, Inventory.class).clickOnInventoryButton();
            PageFactory.initElements(driver, ProductsPO.Products.class).clickOnProductsButtonn();
            centerlizePO.clickOnButton(products1.getProductButton());
            sleepFor(4);
            centerlizePO.enterDataUsingSendkeys(PageFactory.initElements(driver, Products.class).getSearchBox(),product);
            sleepFor(3);
            List<WebElement> list1 = new WebDriverWait(driver,120).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy
                            (By.xpath("//ul[contains(@class,'hike-width-block')]//b[text()='Product']//parent::ul//li//a")));
            list1.get(0).click();
            sleepFor(3);
            WebElement name = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//table[@id='RosterDataTable']//tbody//tr//td[2]//span[text()='" + product + "']//parent::td//following-sibling::td//a")));
            name.click();
            while(true){
                sleepFor(1);
                centerlizePO.clickOnButton(PageFactory.initElements(driver,Shopify.class).getRefreshLogButton());
                sleepFor(3);
                WebElement e = new WebDriverWait(driver,60).
                        until(ExpectedConditions.presenceOfElementLocated
                                (By.xpath("//td[text()='BigCommerce - Hike']//following-sibling::td[1][text()='Created']")));
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
     * @date 14 April 2021
     * @discription this method is use to   create Customer BigCommerce to hike and verify in hike
     * @return
     */
    @Step(" create Customer BigCommerce to hike and verify in hike")
    public boolean createCustomerBigCommercetoHike(String customer) throws IOException {
        CenterlizePO centerlizePO = PageFactory.initElements(driver, CenterlizePO.class);
        String fileLocation =System.getProperty("user.dir")+"\\src\\main\\resources\\BigCommerce.properties";
        Properties properties1 = new Properties();
        properties1.load(new FileReader(fileLocation));
        Actions actions = new Actions(driver);
        try{
            sleepFor(5);
            ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
            driver.switchTo().window(tabs.get(0));
            JavascriptExecutor jse = (JavascriptExecutor)driver;
            jse.executeScript("arguments[0].click();",getCustomerButton());
            sleepFor(1);
            centerlizePO.clickOnButton(getAddCustomersButton());
            sleepFor(1);
            driver.switchTo().frame("content-iframe");
            List<WebElement> input = new WebDriverWait(driver,120).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy
                            (By.xpath("//customer-view//input[not(@class='u-hiddenVisually')]")));
            centerlizePO.enterDataUsingSendkeys( input.get(0),customer);
            centerlizePO.enterDataUsingSendkeys( input.get(1),"test");
            centerlizePO.enterDataUsingSendkeys( input.get(2),"test.com");
            centerlizePO.enterDataUsingSendkeys( input.get(3),customer+"@yopmail.com");
            centerlizePO.enterDataUsingSendkeys( input.get(4),"0444222333");
            centerlizePO.clearText( input.get(5));
            centerlizePO.enterDataUsingSendkeys( input.get(5),"50000");
            centerlizePO.enterDataUsingSendkeys( input.get(6),"0022");
            centerlizePO.enterDataUsingSendkeys( input.get(7),"asdf4100");
            centerlizePO.enterDataUsingSendkeys( input.get(8),"asdf4100");
            WebElement btnsave= new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//span[text()='Save & Exit']//parent::button")));
            centerlizePO.clickOnButton( btnsave);
            sleepFor( 5 );
            driver.switchTo().defaultContent();
            centerlizePO.clickOnButton( getHomeButton() );
            driver.switchTo().window(tabs.get(1));
            PageFactory.initElements(driver, StoreSetup.class).clickOnStoreSetupButton();
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Integrations.class).getIntegrationsButton());
            sleepFor(3);
            centerlizePO.clickOnButton(getManageButton());
            sleepFor( 1 );
            centerlizePO.clickOnButton(PageFactory.initElements(driver,Shopify.class).getManualSyncButton());
            sleepFor( 4 );
            String[] strArray2 = new String[]{"syncCustomers"};
            for (String s : strArray2) {
                WebElement element = new WebDriverWait( driver, 60 ).ignoring( StaleElementReferenceException.class ).
                        until( ExpectedConditions.presenceOfElementLocated
                                ( By.xpath( "//label[@for='" + s + "']" ) ) );
                element.click();
            }
            sleepFor( 1 );
            centerlizePO.clickOnButton(PageFactory.initElements(driver,Shopify.class).getButtonSyncNow() );
            sleepFor( 2 );
            centerlizePO.clickOnButton(getSaveButton());
            sleepFor( 10 );
            PageFactory.initElements(driver, CustomersPO.Customers.class).clickOnCustomersButton();
            sleepFor(2);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, CustomersPO.CustomersPO.Customers.class).getCustomersButton());
            sleepFor(3);
            WebElement name = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//table[@id='CustomersTable']//tbody//tr//td[2]//span[contains(text(),'"+customer+"')]//parent::td//following-sibling::td//a")));
            actions.moveToElement(name).click().perform();
            sleepFor(5);
            while(true){
                sleepFor(1);
                centerlizePO.clickOnButton(PageFactory.initElements( driver,Shopify.class ).getRefreshLogButton());
                sleepFor(3);
                WebElement e = new WebDriverWait(driver,60).
                        until(ExpectedConditions.presenceOfElementLocated
                                (By.xpath("//td[text()='BigCommerce - Hike']//following-sibling::td[1][text()='Created']")));
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
     * @date 14 April 2021
     * @discription this method is use to create sale BigCommerce to Hike and verify in Hike
     * @return
     */
    @Step("create sale BigCommerce to Hike and verify in Hike")
    public boolean createSaleBigCommercetoHike(String customer) throws IOException {
        CenterlizePO centerlizePO = PageFactory.initElements(driver, CenterlizePO.class);
        Actions actions = new Actions(driver);
        try{
            sleepFor(5);
            ArrayList<String> tabs1 = new ArrayList<String> (driver.getWindowHandles());
            driver.switchTo().window(tabs1.get(1));
            sleepFor(2);
            JavascriptExecutor jse = (JavascriptExecutor)driver;
            jse.executeScript("arguments[0].click();",getOrdersButton());
            sleepFor(1);
            centerlizePO.clickOnButton(getAddOrdersButton());
            sleepFor(1);
            driver.switchTo().frame("content-iframe");
            centerlizePO.enterDataUsingSendkeys(getSearchCustomer(),customer);
            sleepFor( 5);
            actions.sendKeys( Keys.ARROW_DOWN ).build().perform();
            actions.sendKeys( Keys.TAB ).build().perform();
            sleepFor( 3);
            try{
                if (driver.findElement(By.xpath("//h3[text()='Confirmation']//parent::div//following-sibling::div//button")).isDisplayed()){
                    WebElement ok = new WebDriverWait(driver,60).
                            until(ExpectedConditions.presenceOfElementLocated
                                    (By.xpath("//h3[text()='Confirmation']//parent::div//following-sibling::div//button")));
                    centerlizePO.clickOnButton( ok );
                }
            }catch (Exception e){
                System.out.println("OK button not Found/....!");
            }
            sleepFor( 2);
            WebElement country = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.id("FormField_11")));
            Select select = new Select( country );
            select.selectByValue("Australia");
            WebElement statr = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//select[@id='FormField_12']")));
            Select select01 = new Select(statr);
            select01.selectByIndex(2);
            List<WebElement> input = new WebDriverWait(driver,120).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy
                            (By.xpath("//span[text()='Billing Information']//parent::legend//parent::fieldset//input[contains(@id,'Form')]")));
            centerlizePO.enterDataUsingSendkeys( input.get(0),customer);
            centerlizePO.enterDataUsingSendkeys( input.get(1),customer);
            centerlizePO.enterDataUsingSendkeys( input.get(2),"test.com");
            centerlizePO.enterDataUsingSendkeys( input.get(3),"0444222333");
            centerlizePO.enterDataUsingSendkeys( input.get(4),"test");
            centerlizePO.enterDataUsingSendkeys( input.get(5),"test");
            centerlizePO.enterDataUsingSendkeys( input.get(6),"test");
            centerlizePO.enterDataUsingSendkeys( input.get(7),"2000");
            centerlizePO.clickOnButton( getNextButton() );
            sleepFor( 3);
            WebElement prosearch = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//div[@class='field product-search']//input")));
            centerlizePO.enterDataUsingSendkeys( prosearch,getValue("\\src\\main\\java\\IntegrationsPO\\BigCommercePO\\File\\Product"));
            sleepFor( 5);
            actions.sendKeys( Keys.ARROW_DOWN ).build().perform();
            actions.sendKeys( Keys.TAB ).build().perform();
            sleepFor( 5 );
            centerlizePO.clickOnButton( getNextButton() );
            sleepFor( 3 );
            centerlizePO.clickOnButton( getNextButton() );
            sleepFor( 3 );
            WebElement payment = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.id("paymentMethod")));
            Select select02 = new Select( payment);
            select02.selectByIndex(2);
            centerlizePO.clickOnButton( getSaveorderButton() );
            sleepFor( 5);
            WebElement complete = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//table//tr[1]//td//select")));
            Select select03 = new Select(complete);
            select03.selectByIndex(6);
            sleepFor(2);
            WebElement ref = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//table//tr[1]//td//select//parent::td//parent::tr//td[5]")));
            String refText = ref.getText();
            System.out.println(refText);
            driver.switchTo().defaultContent();
            driver.switchTo().window(tabs1.get(0));
            PageFactory.initElements(driver, StoreSetup.class).clickOnStoreSetupButton();
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Integrations.class).getIntegrationsButton());
            sleepFor(3);
            centerlizePO.clickOnButton(getManageButton());
            sleepFor( 1 );
            centerlizePO.clickOnButton(PageFactory.initElements(driver,Shopify.class).getManualSyncButton());
            sleepFor( 4 );
            String[] strArray2 = new String[]{"syncSales"};
            for (String s : strArray2) {
                WebElement element = new WebDriverWait( driver, 60 ).ignoring( StaleElementReferenceException.class ).
                        until( ExpectedConditions.presenceOfElementLocated
                                ( By.xpath( "//label[@for='" + s + "']" ) ) );
                element.click();
            }
            sleepFor( 1 );
            centerlizePO.clickOnButton(PageFactory.initElements(driver,Shopify.class).getButtonSyncNow() );
            sleepFor( 2 );
            centerlizePO.clickOnButton(getSaveButton());
            sleepFor( 10 );
            PageFactory.initElements( driver,Inventory.class).clickOnInventoryButton();
            PageFactory.initElements( driver,PointofSale.class).clickOnPointOfSaleButtonn();
            centerlizePO.clickOnButton(  PageFactory.initElements( driver,SalesHistory.class).getSalesHistoryButton());
            sleepFor( 10 );
            WebElement sale01 = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//table[@id='SalesTable']//tbody//tr//td[2]//a[text()='"+refText+"']//parent::td//following-sibling::td//a//i//parent::a")));
            centerlizePO.clickOnButton(sale01);
            sleepFor(3);
            while(true){
                sleepFor(1);
                centerlizePO.clickOnButton(PageFactory.initElements(driver, Shopify.class).getRefreshLogButton());
                sleepFor(3);
                WebElement e = new WebDriverWait(driver,60).
                        until(ExpectedConditions.presenceOfElementLocated
                                (By.xpath("//td[text()='BigCommerce - Hike']//following-sibling::td[1][text()='Created']")));
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
        scanner.close();
        return tesLine;
    }



    /**
     * @author Vidhi Chapanera
     * @date 16 April 2021
     * @discription this method is use to automate BigCommerce
     * @return
     */
    @Step("automate BigCommerce")
    public boolean automateBigCommerce() throws IOException {
        try{
            createHikeStoreForBigCommerce();
            loginToShopifyExistingStore();
            clickOnActivateButtonOnBigCommerce();
            mappingBigCommerce();
            createProductHiketoBigCommerce();
            createProductBigCommercetoHike("testDataProduct");
            createCustomersHiketoBigCommerce("vidhi chapanera");
            createCustomerBigCommercetoHike("BG");
            createSaleHiketoBigCommerce();
            createSaleBigCommercetoHike("vidhi");
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



}