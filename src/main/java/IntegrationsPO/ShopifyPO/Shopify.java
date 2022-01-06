package IntegrationsPO.ShopifyPO;

import CommonPO.BasePage;
import CommonPO.CenterlizePO;
import CreateStorePO.CreateStore;
import CreateStorePO.StoreConstant;
import IntegrationsPO.Integrations;
import IntegrationsPO.QuickBooksPO.QuickBooks;
import PointofSalePO.CashRegisterPO.CashRegister;
import PointofSalePO.PointofSale;
import PointofSalePO.ProcessSalePO.ProcessSale;
import PointofSalePO.SalesHistoryPO.SalesHistory;
import ProductsPO.ProductsPO.Products;
import ReportingPO.Reporting;
import StoreSetupPO.GeneralPO.General;
import StoreSetupPO.LoyaltyPointsPO.LoyaltyPoints;
import StoreSetupPO.MyAccountPO.MyAccount;
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
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;


/**
 * @author Vidhi Chapanera
 * @date 19 March 2021
 */
public class Shopify extends BasePage {

    public WebDriver driver;
    public static String dataText = "";


    public Shopify(WebDriver driver) {
        this.driver = driver;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Shopify activate button
     * @date 19 March 2021
     */
    @FindBy(how = How.XPATH, using = "//table//tr//td[contains(text(),'Shopify')]//parent::tr//button[normalize-space(.)='Activate']")
    WebElement btn_Shopifyactivate;
    public WebElement getShopifyActivate() {
        return btn_Shopifyactivate;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Shopify email input box
     * @date 19 March 2021
     */
    @FindBy(how = How.XPATH, using = "//form[@id='SignupForm_modal']//input[@name='signup[email]']")
    WebElement txt_email;
    public WebElement getEmailShopify() {
        return txt_email;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Shopify password input box
     * @date 19 March 2021
     */
    @FindBy(how = How.XPATH, using = "//form[@id='SignupForm_modal']//input[@name='signup[password]']")
    WebElement txt_pwd;
    public WebElement getPasswordShopify() {
        return txt_pwd;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Shopify storename input box
     * @date 19 March 2021
     */
    @FindBy(how = How.XPATH, using = "//form[@id='SignupForm_modal']//input[@name='signup[shop_name]']")
    WebElement txt_storename;
    public WebElement getStoreNameShopify() {
        return txt_storename;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for create your store button
     * @date 19 March 2021
     */
    @FindBy(how = How.XPATH, using = "//form[@id='SignupForm_modal']//button[text()='Create your store' and @name='button']")
    WebElement btn_createyoutstore;
    public WebElement getCreateYourStoreButton() {
        return btn_createyoutstore;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for skip button
     * @date 19 March 2021
     */
    @FindBy(how = How.XPATH, using = "//span[text()='Skip']//parent::span//parent::button")
    WebElement btn_skip;
    public WebElement getSkipButton() {
        return btn_skip;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for login button
     * @date 19 March 2021
     */
    @FindBy(how = How.XPATH, using = "//button[text()='Log in']")
    WebElement btn_login;
    public WebElement getLoginButton() {
        return btn_login;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for enter my store button
     * @date 19 March 2021
     */
    @FindBy(how = How.XPATH, using = "//span[text()='Enter my store']//parent::span//parent::button")
    WebElement btn_entermystore;
    public WebElement getEnterMyStoreButton() {
        return btn_entermystore;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Start free trial button
     * @date 19 March 2021
     */
    @FindBy(how = How.XPATH, using = "//label[text()='Email address']//following-sibling::button[text()='Start free trial']")
    WebElement btn_Startfreetrial;
    public WebElement getStartDreeTrial() {
        return btn_Startfreetrial;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for shopify store input box
     * @date 19 March 2021
     */
    @FindBy(how = How.XPATH, using = "//span[text()='.myshopify.com']//parent::div//input")
    WebElement txt_shopifyStore;
    public WebElement getShopifyStore() {
        return txt_shopifyStore;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for connect button
     * @date 19 March 2021
     */
    @FindBy(how = How.XPATH, using = "//button[text()='Connect']")
    WebElement btn_connect;
    public WebElement getConnectButton() {
        return btn_connect;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Install unlisted app button
     * @date 19 March 2021
     */
    @FindBy(how = How.XPATH, using = "//button[text()='Install unlisted app']")
    WebElement btn_Installunlistedapp;
    public WebElement getInstallUnlistedAppButton() {
        return btn_Installunlistedapp;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Shopify product vendor map with
     * @date 22 March 2021
     */
    @FindBy(how = How.XPATH, using = "//label[contains(text(),'Shopify product vendor map with')]//following-sibling::div//a")
    WebElement ShopifyProductVendorMap;
    public WebElement getShopifyProductVendorMapdrpDwn() {
        return ShopifyProductVendorMap;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Shopify product vendor map with drop down option
     * @date 22 March 2021
     */
    @FindBy(how = How.XPATH, using = "//label[contains(text(),'Shopify product vendor map with')]//following-sibling::div//a//following-sibling::div//ul//li//ul//li//div[text()='Supplier']")
    WebElement ShopifyProductVendorMapOption;
    public WebElement getShopifyProductVendorMapdrpDwnOPtion() {
        return ShopifyProductVendorMapOption;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Hike tax for products
     * @date 22 March 2021
     */
    @FindBy(how = How.XPATH, using = "//label[contains(text(),'Hike tax for products')]//following-sibling::tax-combo//a")
    WebElement hiketaxforproducts ;
    public WebElement getHikeTaxForProductsDrpDwn() {
        return hiketaxforproducts;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Shopify product vendor map with drop down option
     * @date 22 March 2021
     */
    @FindBy(how = How.XPATH, using = "//label[contains(text(),'Hike tax for products')]//following-sibling::tax-combo//a//following-sibling::div//ul//li//ul//li//div[text()='GST']")
    WebElement hiketaxforproductsoption;
    public WebElement getHikeTaxForProductsDrpDwnOption() {
        return hiketaxforproductsoption;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for retail prices drop down
     * @date 22 March 2021
     */
    @FindBy(how = How.XPATH, using = "//label[contains(text(),'retail prices')]//following-sibling::div//a")
    WebElement retailpricedropdown ;
    public WebElement getRetailPriceDropDown() {
        return retailpricedropdown;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for retail prices drop down option
     * @date 22 March 2021
     */
    @FindBy(how = How.XPATH, using = "//label[contains(text(),'retail prices')]//following-sibling::div//a/following-sibling::div//li//ul//li//div[text()='Price']")
    WebElement retailPriceDropDwonoption;
    public WebElement getRetailPriceDropDownOption() {
        return retailPriceDropDwonoption;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Shopify location drop down
     * @date 22 March 2021
     */
    @FindBy(how = How.XPATH, using = "//td[contains(text(),'Store')]//following-sibling::td//a")
    WebElement shopifylocationdrppdown ;
    public WebElement getShopifyLocationDropDown() {
        return shopifylocationdrppdown;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Shopify location drop down option
     * @date 22 March 2021
     */
    @FindBy(how = How.XPATH, using = "//td[contains(text(),'Store')]//following-sibling::td//a//following-sibling::div//li//ul//li")
    WebElement shopifylocationdrppdownoption;
    public WebElement getShopifyLocationDropDownOption() {
        return shopifylocationdrppdownoption;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Select Hike register for payments
     * @date 22 March 2021
     */
    @FindBy(how = How.XPATH, using = "//label[text()='Select Hike register for payments ']")
    WebElement hikeregister;
    public WebElement getHikeRegisterPayment() {
        return hikeregister;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Save Button
     * @date 22 March 2021
     */
    @FindBy(how = How.XPATH, using = "//form[@name='shopifySettings']//div[@class='slider-modal-actions']//button[text()='Save']")
    WebElement btn_save;
    public WebElement getSaveButton() {
        return btn_save;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for manage Button
     * @date 22 March 2021
     */
    @FindBy(how = How.XPATH, using = "//table//tr//td[contains(text(),'Shopify')]//parent::tr//button[contains(text(),'Manage')]")
    WebElement btn_manage;
    public WebElement getManageButton() {
        return btn_manage;
    }

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for manual sync button
     * @date 22 March 2021
     */
    @FindBy(how = How.XPATH, using = "//a[text()='Manual sync']")
    WebElement btn_manualsync;
    public WebElement getManualSyncButton() {
        return btn_manualsync;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for sync process log
     * @date 22 March 2021
     */
    @FindBy(how = How.XPATH, using = "//table//tr//td[contains(text(),'Shopify')]//parent::tr//a[contains(text(),'Sync process log')]")
    WebElement btn_syncprocesslog;
    public WebElement getSyncProcessLogButton() {
        return btn_syncprocesslog;
    }



    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Show errors only
     * @date 22 March 2021
     */
    @FindBy(how = How.XPATH, using = "//div[@class='md-checkbox']//label")
    WebElement btn_showerrorsonly;
    public WebElement getShowErrorsOnly() {
        return btn_showerrorsonly;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for button sync now
     * @date 22 March 2021
     */
    @FindBy(how = How.XPATH, using = "//button[text()='Sync now']")
    WebElement btn_syncnow;
    public WebElement getButtonSyncNow() {
        return btn_syncnow;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for button Refresh logs
     * @date 22 March 2021
     */
    @FindBy(how = How.XPATH, using = "//button[text()='Refresh logs']")
    WebElement btn_refreshlogs;
    public WebElement getRefreshLogButton() {
        return btn_refreshlogs;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for button ecommerce checkbox
     * @date 22 March 2021
     */
    @FindBy(how = How.XPATH, using = "//label[@for='salesChannel_2']")
    WebElement chk_ecommerce;
    public WebElement getEcommerceCheckbox() {
        return chk_ecommerce;
    }

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for products button on shopify
     * @date 22 March 2021
     */
    @FindBy(how = How.XPATH, using = "//div[@id='AppFrameNav']//span[text()='Products']//parent::a")
    WebElement btn_productsShopify;
    public WebElement getProductsButtonShopify() {
        return btn_productsShopify;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for all products button on shopify
     * @date 22 March 2021
     */
    @FindBy(how = How.XPATH, using = "//div[@id='AppFrameNav']//span[text()='All products']//parent::a")
    WebElement btn_allproductsShopify;
    public WebElement getAllProductsButtonShopify() {
        return btn_allproductsShopify;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for products search input box
     * @date 22 March 2021
     */
    @FindBy(how = How.XPATH, using = "//input[@placeholder='Filter products']")
    WebElement txt_productSearch;
    public WebElement getProductSearch() {
        return txt_productSearch;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Customers button on shopify
     * @date 22 March 2021
     */
    @FindBy(how = How.XPATH, using = "//div[@id='AppFrameNav']//span[text()='Customers']//parent::a")
    WebElement btn_CustomersShopify;
    public WebElement getCustomersButtonShopify() {
        return btn_CustomersShopify;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for customers search input box
     * @date 22 March 2021
     */
    @FindBy(how = How.XPATH, using = "//input[@placeholder='Filter customers']")
    WebElement txt_customersSearch;
    public WebElement getCustomersSearch() {
        return txt_customersSearch;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for add product button
     * @date 22 March 2021
     */
    @FindBy(how = How.XPATH, using = "//span[text()='Add product']")
    WebElement btn_addProduct;
    public WebElement getAddProductButtonShopify() {
        return btn_addProduct;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for title input box
     * @date 22 March 2021
     */
    @FindBy(how = How.XPATH, using = "//label[text()='Title']//parent::div//parent::div//following-sibling::div//input")
    WebElement txt_title;
    public WebElement getTitleInputBoxShopify() {
        return txt_title;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for SKU input box
     * @date 22 March 2021
     */
    @FindBy(how = How.XPATH, using = "//label[text()='SKU (Stock Keeping Unit)']//parent::div//parent::div//following-sibling::div//input")
    WebElement txt_sku;
    public WebElement getSKUInputBoxshopify() {
        return txt_sku;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for available input box
     * @date 22 March 2021
     */
    @FindBy(how = How.XPATH, using = "//label[text()='Available']//parent::div//parent::div//following-sibling::div//input")
    WebElement txt_available;
    public WebElement getAvailableInputBoxshopify() {
        return txt_available;
    }

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for price input box
     * @date 22 March 2021
     */
    @FindBy(how = How.XPATH, using = "//label[text()='Price']//parent::div//parent::div//following-sibling::div//input")
    WebElement txt_price;
    public WebElement getPrice() {
        return txt_price;
    }

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for add customer button
     * @date 22 March 2021
     */
    @FindBy(how = How.XPATH, using = "//span[text()='Add customer']")
    WebElement btn_addcustomer;
    public WebElement getAddCustomerButtonShopify() {
        return btn_addcustomer;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for open button
     * @date 24 March 2021
     */
    @FindBy(how = How.XPATH, using = "//span[contains(text(),'Open')]//parent::button")
    WebElement btn_open;
    public WebElement getOpenButton() {
        return btn_open;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for order button
     * @date 24 March 2021
     */
    @FindBy(how = How.XPATH, using = "//span[text()='Orders']")
    WebElement btn_orderShopify;
    public WebElement getOrderShopifyButton() {
        return btn_orderShopify;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for customers search input box
     * @date 22 March 2021
     */
    @FindBy(how = How.XPATH, using = "//input[@placeholder='Filter orders']")
    WebElement txt_orderSearch;
    public WebElement getOrderSearchShopify() {
        return txt_orderSearch;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for order button
     * @date 24 March 2021
     */
    @FindBy(how = How.XPATH, using = "//span[text()='Drafts']")
    WebElement btn_DraftsShopify;
    public WebElement getDraftsShopifyButton() {
        return btn_DraftsShopify;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for order button
     * @date 24 March 2021
     */
    @FindBy(how = How.XPATH, using = "//span[text()='Create draft order']")
    WebElement btn_createdraftsShopify;
    public WebElement getCreateDraftsShopifyButton() {
        return btn_createdraftsShopify;
    }

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for search product input box shopify
     * @date 24 March 2021
     */
    @FindBy(how = How.XPATH, using = "//label[text()='Search products']//parent::div//parent::div//following-sibling::div//input")
    //@FindBy(how = How.XPATH, using = "//label[text()='Product search input']//parent::div//input")
    WebElement txt_searchProductshopify;
    public WebElement getSearchProductShopify() {
        return txt_searchProductshopify;
    }

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Browse products button shopify
     * @date 25 March 2021
     */
    @FindBy(how = How.XPATH, using = "//button[text()='Browse products']")
    WebElement btn_browse;
    public WebElement getBrowseButtonShopify() {
        return btn_browse;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for add order button
     * @date 24 March 2021
     */
    @FindBy(how = How.XPATH, using = "//span[text()='Add']")
    //@FindBy(how = How.XPATH, using = "//button[text()='Add to order']")
    WebElement btn_addorder;
    public WebElement getAddOrderButton() {
        return btn_addorder;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Mark as paid button
     * @date 24 March 2021
     */
    @FindBy(how = How.XPATH, using = "//span[text()='Mark as paid']")
    //@FindBy(how = How.CSS, using = "#markAsPaidModalBtn")
    WebElement btn_markaspaid;
    public WebElement getMarkAsPaidButton() {
        return btn_markaspaid;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for create order button
     * @date 24 March 2021
     */
    @FindBy(how = How.XPATH, using = "//span[text()='Create order']")
    WebElement btn_createorder;
    public WebElement getCreateOrderButton() {
        return btn_createorder;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for create order button
     * @date 19 July 2021
     */
    @FindBy(how = How.XPATH, using = "//input[@placeholder='Search customers']")
    WebElement btn_searchcustomers;
    public WebElement getSearchCustomers() {
        return btn_searchcustomers;
    }

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for  Mark as fulfilled button
     * @date 24 March 2021
     */
    @FindBy(how = How.XPATH, using = "//span[text()='Mark as fulfilled']//parent::span//parent::a")
    WebElement btn_markasfulfilled;
    public WebElement getMarkAsfulfilledButton() {
        return btn_markasfulfilled;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Fulfill items button
     * @date 24 March 2021
     */
    @FindBy(how = How.XPATH, using = "//span[text()='Fulfill items']//parent::span//parent::button")
    WebElement btn_Fulfillitems;
    public WebElement getFulfillItemsButton() {
        return btn_Fulfillitems;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Store address Shopify input box
     * @date 30 March 2021
     */
    @FindBy(how = How.XPATH, using = "//label[contains(text(),'Store address')]//parent::div//input")
    WebElement txt_Storeaddressshopify;
    public WebElement getStoreAddressShopify() {
        return txt_Storeaddressshopify;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Next button
     * @date 30 March 2021
     */
    @FindBy(how = How.XPATH, using = "//button[contains(text(),'Next')]")
    WebElement btn_Next;
    public WebElement getNextButton() {
        return btn_Next;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for email input box
     * @date 30 March 2021
     */
    @FindBy(how = How.NAME, using = "account[email]")
    WebElement txt_email1;
    public WebElement getEmailShopifyL() {
        return txt_email1;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for password input box
     * @date 30 March 2021
     */
    @FindBy(how = How.CSS, using = "#account_password")
    WebElement txt_password;
    public WebElement getPasswordShopifyL() {
        return txt_password;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for login button
     * @date 30 March 2021
     */
    @FindBy(how = How.XPATH, using = "//button[contains(text(),'Log in')]")
    WebElement btn_login1;
    public WebElement getLoginButton01() {
        return btn_login1;
    }



    /**
     * @author Vidhi Chapanera
     * @date 19 March 2021
     * @discription this method is use to click on activate button on shopify
     * @return
     */
    @Step("click on activate button on shopify")
    public boolean clickOnActivateButtonOnShopify(){
        CenterlizePO centerlizePO = PageFactory.initElements(driver,CenterlizePO.class);
        try{
            sleepFor(5);
            driver.navigate().refresh();
            PageFactory.initElements(driver, Reporting.class).clickOnReportingButton();
            PageFactory.initElements(driver, StoreSetup.class).clickOnStoreSetupButton();
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Integrations.class).getIntegrationsButton());
            sleepFor(3);
            centerlizePO.clickOnButton(getShopifyActivate());
            sleepFor(5);
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }


    /**
     * @author Vidhi Chapanera
     * @date 19 March 2021
     * @discription reset static variable value
     */
    @Step("")
    public void reset () {
        dataText = "";
    }

    /**
     * @author Vidhi Chapanera
     * @date 19 March 2021
     * @discription this method is use to create hike store for shopify
     * @return
     */
   /* @Step("create hike store for shopify")
    public boolean createHikeStoreForShopify(){
        CenterlizePO centerlizePO = PageFactory.initElements(driver,CenterlizePO.class);
        try{
            sleepFor(5);
            String fileLocation =System.getProperty("user.dir")+"\\src\\main\\resources\\createStore.properties";
            Properties properties1 = new Properties();
            properties1.load(new FileReader(fileLocation));
            centerlizePO.clickOnButton(PageFactory.initElements(driver, CreateStore.class).getStartFreeTrialLink());
            PageFactory.initElements(driver, CreateStore.class).renameFileData
                    (PageFactory.initElements(driver, CreateStore.class).getFirstNameTextBox()
                            ,"\\src\\main\\java\\IntegrationsPO\\ShopifyPO\\File\\FirstName");
            PageFactory.initElements(driver, CreateStore.class).renameFileData
                    (PageFactory.initElements(driver, CreateStore.class).getLastNameTextBox()
                            ,"\\src\\main\\java\\IntegrationsPO\\ShopifyPO\\File\\LastName");
            centerlizePO.enterDataUsingSendkeys(PageFactory.initElements(driver, CreateStore.class).getEmailTextBox(), StoreConstant.EMAIL);
            centerlizePO.enterDataUsingSendkeys(PageFactory.initElements(driver, CreateStore.class).getPhoneTextBox(), StoreConstant.PHONE);
            centerlizePO.clearText(PageFactory.initElements(driver, CreateStore.class).getCityTextBox());
            centerlizePO.enterDataUsingSendkeys(PageFactory.initElements(driver, CreateStore.class).getCityTextBox(),StoreConstant.CITY);
            centerlizePO.enterDataUsingSendkeys(PageFactory.initElements(driver, CreateStore.class).getPasswordTextBox(),String.valueOf(properties1.put(StoreConstant.PASSWORD,"password")));
            centerlizePO.clickOnButton(PageFactory.initElements(driver, CreateStore.class).getContinueButton());
            PageFactory.initElements(driver, CreateStore.class).renameFileData
                    (PageFactory.initElements(driver, CreateStore.class).getAccountAddressTextBox()
                            ,"\\src\\main\\java\\IntegrationsPO\\ShopifyPO\\File\\AccountAddress");
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


    /**
     * @author Vidhi Chapanera
     * @date 13 May 2021
     * @discription this method is use to click on activate button on shopify
     * @return
     */
    @Step("create hike store for BigCommerce")
    public boolean createHikeStoreForShopify(){
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
                            ,"\\src\\main\\java\\IntegrationsPO\\ShopifyPO\\File\\AccountAddress");
            sleepFor( 3);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, CreateStore.class).getCreteMyStoreButton());
            sleepFor(30);
            PageFactory.initElements(driver,CreateStore.class).bitAboutYourStoreSection();
            sleepFor(10);
            PageFactory.initElements(driver,Shopify.class).PurgeData();
            PageFactory.initElements(driver, General.class).checkPrintReceiptOption();
            sleepFor(7);
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }


    /**
     * @author Vidhi Chapanera
     * @date 19 March 2021
     * @discription this method is use to create Shopify store
     * @return
     */
    @Step("create Shopify store")
    public boolean createShopifyStore() throws IOException {
        CenterlizePO centerlizePO = PageFactory.initElements(driver,CenterlizePO.class);
        String fileLocation =System.getProperty("user.dir")+"\\src\\main\\resources\\createStore.properties";
        Properties properties1 = new Properties();
        properties1.load(new FileReader(fileLocation));
        try{
            sleepFor(1);
            JavascriptExecutor jse = (JavascriptExecutor)driver;
            jse.executeScript("window.open()");
            ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));
            sleepFor(1);
            driver.get("https://www.shopify.com");
            sleepFor(5);
            centerlizePO.clickOnButton(getStartDreeTrial());
            sleepFor(3);
            renameFileData(getStoreNameShopify(),"\\src\\main\\java\\IntegrationsPO\\ShopifyPO\\File\\ShopifyStore");
            renameFileData(getEmailShopify(),"\\src\\main\\java\\IntegrationsPO\\ShopifyPO\\File\\email");
            centerlizePO.enterDataUsingSendkeys(getEmailShopify(),"@yahoo.com");
            centerlizePO.enterDataUsingSendkeys(getPasswordShopify(),String.valueOf(properties1.put(StoreConstant.PASSWORD,"password")));
            centerlizePO.clickOnButton(getCreateYourStoreButton());
            sleepFor(30);
            //centerlizePO.clickOnButton(getLoginButton());
            centerlizePO.clickOnButton(getSkipButton());
            sleepFor(5);
            List<WebElement> inputList = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//form//input[contains(@id,'Text')]")));
            for(int i =0;i<inputList.size()-3;i++){
                inputList.get(i).clear();
                inputList.get(i).sendKeys("test");
            }
            WebElement postcode = new WebDriverWait(driver, 60).ignoring(StaleElementReferenceException.class).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.name("account_setup[zip]")));
            centerlizePO.enterDataUsingSendkeys(postcode,"2060");
            WebElement country = new WebDriverWait(driver, 60).ignoring(StaleElementReferenceException.class).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.name("account_setup[country]")));
            Select select = new Select(country);
            select.selectByIndex(11);
            WebElement state = new WebDriverWait(driver, 60).ignoring(StaleElementReferenceException.class).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.name("province")));
            Select select1 = new Select(state);
            select1.selectByIndex(8);
            WebElement phone = new WebDriverWait(driver, 60).ignoring(StaleElementReferenceException.class).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.name("account_setup[phone]")));
            centerlizePO.enterDataUsingSendkeys(phone,"04523146");
            WebElement domain = new WebDriverWait(driver, 60).ignoring(StaleElementReferenceException.class).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.name("account_setup[custom_domain]")));
            centerlizePO.enterDataUsingSendkeys(domain,"test.com");
            sleepFor(2);
            centerlizePO.clickOnButton(getEnterMyStoreButton());
            sleepFor(20);
            //jse.executeScript("window.close()");
            driver.switchTo().window(tabs.get(0));
            sleepFor(5);
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }


    /**
     * @author Vidhi Chapanera
     * @date 19 March 2021
     * @return
     * @throws IOException
     * @discription this method is used to rename the text file data
     */
    @Step("")
    public boolean renameFileData(WebElement el,String filepath) throws IOException {
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
            reset();
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    /**
     * @author Vidhi Chapanera
     * @date 13 January 2021
     * @return
     * @throws IOException
     * @discription this method is used to get account address value
     */
    @Step("")
    public String getAddressValue() throws IOException {
        String tesLine ="";
        File f = new File(System.getProperty("user.dir") + "\\src\\main\\java\\IntegrationsPO\\ShopifyPO\\File\\ShopifyStore");
        f.canWrite();
        Scanner scanner = new Scanner(f);
        while (scanner.hasNextLine()) {
            tesLine += scanner.nextLine();
        }
        String lowercase = tesLine.split("-")[0].toLowerCase() + "-" + tesLine.split("-")[1];
        scanner.close();
        System.out.println(lowercase);
        return lowercase;
    }


    /**
     * @author Vidhi Chapanera
     * @date 19 July 2021
     * @return
     * @throws IOException
     * @discription this method is used to get account address value
     */
    @Step("")
    public String getValueFrom(String path) throws IOException {
        String tesLine ="";
        File f = new File(System.getProperty("user.dir") + path);
        f.canWrite();
        Scanner scanner = new Scanner(f);
        while (scanner.hasNextLine()) {
            tesLine += scanner.nextLine();
        }
        return tesLine;
    }

    /**
     * @author Vidhi Chapanera
     * @date 19 March 2021
     * @discription this method is use to connect your shopify store to hikeup
     * @return
     */
    @Step("connect your shopify store to hikeup")
    public boolean connectYourStoretoHike() throws IOException {
        CenterlizePO centerlizePO = PageFactory.initElements(driver,CenterlizePO.class);
        try{
            ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
            driver.switchTo().window(tabs.get(0));
            sleepFor(1);
            centerlizePO.enterDataUsingSendkeys(getShopifyStore(),getAddressValue());
            centerlizePO.clickOnButton(getConnectButton());
            sleepFor(20);
            try {
                if (getInstallUnlistedAppButton().isDisplayed())
                {
                    JavascriptExecutor executor = (JavascriptExecutor) driver;
                    executor.executeScript("arguments[0].click();", getInstallUnlistedAppButton());
                    sleepFor(5);
                }
            }catch (Exception e1){
                System.out.println("");
            }
            sleepFor(15);
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }


    /**
     * @author Vidhi Chapanera
     * @date 22 March 2021
     * @discription this method is use to mapping shopify
     * @return
     */
    @Step("mapping shopify")
    public boolean mappingShopify() throws IOException {
        CenterlizePO centerlizePO = PageFactory.initElements(driver,CenterlizePO.class);
        Actions actions = new Actions(driver);
        try{
            centerlizePO.clickOnButton(getShopifyProductVendorMapdrpDwn());
            sleepFor(1);
            centerlizePO.clickOnButton(getShopifyProductVendorMapdrpDwnOPtion());
            sleepFor(1);
            centerlizePO.clickOnButton(getHikeRegisterPayment());
            sleepFor(1);
            centerlizePO.clickOnButton(getHikeTaxForProductsDrpDwn());
            sleepFor(1);
            centerlizePO.clickOnButton(getHikeTaxForProductsDrpDwnOption());
            sleepFor(1);
            centerlizePO.clickOnButton(getRetailPriceDropDown());
            sleepFor(1);
            centerlizePO.clickOnButton(getRetailPriceDropDownOption());
            sleepFor(1);
            centerlizePO.clickOnButton(getShopifyLocationDropDown());
            sleepFor(1);
            centerlizePO.clickOnButton(getShopifyLocationDropDownOption());
            sleepFor(3);
            List<WebElement> list = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                            By.xpath("//span[text()='Sync settings']//parent::div//parent::div//following-sibling::div//div[@class='md-checkbox-list']//label")));
            for(int i=0;i<list.size()-1;i++){
                sleepFor(1);
                list.get(i).click();
            }
            sleepFor(3);
            actions.sendKeys(Keys.PAGE_DOWN).build().perform();
            List<WebElement> list1 = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                            By.xpath("//span[text()='Product Description Sync Preference']//parent::div//parent::div//following-sibling::div//label[text()]")));
            JavascriptExecutor executor = (JavascriptExecutor)driver;
            executor.executeScript("arguments[0].click();", list1.get(1));
            sleepFor(3);
            List<WebElement> list2 = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                            By.xpath("//span[text()='Product Image Sync Preference']//parent::div//parent::div//following-sibling::div//label[text()]")));
            executor.executeScript("arguments[0].click();", list2.get(1));
            sleepFor(3);
            centerlizePO.clickOnButton(getSaveButton());
            sleepFor(10);
            driver.navigate().refresh();
            sleepFor(6);
            if(getManageButton().isDisplayed()){
                centerlizePO.clickOnButton(getManageButton());
                sleepFor(1);
                centerlizePO.clickOnButton(getManualSyncButton());
                sleepFor(4);
                String[] strArray2 = new String[]{"syncProducts", "syncCustomers", "syncSales"};
                for (String s : strArray2) {
                    WebElement element = new WebDriverWait(driver, 60).ignoring(StaleElementReferenceException.class).
                            until(ExpectedConditions.presenceOfElementLocated
                                    (By.xpath("//label[@for='" + s + "']")));
                    element.click();
                }
                sleepFor(1);
                centerlizePO.clickOnButton(getButtonSyncNow());
                sleepFor(2);
                centerlizePO.clickOnButton(getSaveButton());
                sleepFor(10);
                centerlizePO.clickOnButton(getSyncProcessLogButton());
                sleepFor(3);
                centerlizePO.clickOnButton(getShowErrorsOnly());
                sleepFor(4);
                WebElement e = new WebDriverWait(driver,60).until
                        (ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Hike + Shopify']//parent::div//parent::div/parent::div//select")));
                Select select = new Select(e);
                select.selectByValue("100");
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
     * @date 22 March 2021
     * @discription this method is use to create Product Hike to shopify and verify in Shopify
     * @return
     */
    @Step("create Product Hike to shopify and verify in Shopify")
    public boolean createProductHiketoShopify() throws IOException {
        CenterlizePO centerlizePO = PageFactory.initElements(driver, CenterlizePO.class);
        ProductsPO.ProductsPO.Products products1 = PageFactory.initElements(driver, ProductsPO.ProductsPO.Products.class);
        Actions actions = new Actions(driver);
        try{
            sleepFor(5);
            PageFactory.initElements(driver, ProductsPO.Products.class).clickOnProductsButtonn();
            centerlizePO.clickOnButton(products1.getProductButton());
            sleepFor(2);
            centerlizePO.clickOnButton(products1.getAddProductButton());
            sleepFor(2);
            renameFileData(products1.getProductName(), "\\src\\main\\java\\IntegrationsPO\\ShopifyPO\\File\\HProduct");
            centerlizePO.clickOnButton(getEcommerceCheckbox());
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
            centerlizePO.enterDataUsingSendkeys(PageFactory.initElements(driver, Products.class).getSearchBox(),getValueFrom("\\src\\main\\java\\IntegrationsPO\\ShopifyPO\\File\\HProduct"));
            sleepFor(3);
            List<WebElement> list1 = new WebDriverWait(driver,120).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy
                            (By.xpath("//ul[contains(@class,'hike-width-block')]//b[text()='Product']//parent::ul//li//a")));
            list1.get(0).click();
            sleepFor(3);
            WebElement name = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//table[@id='RosterDataTable']//tbody//tr//td[2]//span[text()='" + getValueFrom("\\src\\main\\java\\IntegrationsPO\\ShopifyPO\\File\\HProduct") + "']//parent::td//following-sibling::td//a")));
            name.click();
            while(true){
                sleepFor(5);
                centerlizePO.clickOnButton(getRefreshLogButton());
                sleepFor(5);
                if (driver.findElement(By.xpath("//td[text()='Hike - Shopify']//following-sibling::td[1][text()='Created']")).isDisplayed())
                    break;
            }
            sleepFor(2);
            actions.sendKeys(Keys.ESCAPE).build().perform();
            sleepFor(3);
            ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));
            sleepFor(2);
            centerlizePO.clickOnButton(getProductsButtonShopify());
            sleepFor(1);
            centerlizePO.clickOnButton(getAllProductsButtonShopify());
            sleepFor(3);
            driver.navigate().refresh();
            sleepFor(7);
            //centerlizePO.enterDataUsingSendkeys(getProductSearch(),product);
            sleepFor(4);
            if (driver.findElement(By.xpath("//span[text()='"+getValueFrom("\\src\\main\\java\\IntegrationsPO\\ShopifyPO\\File\\HProduct")+"']")).isDisplayed())
                System.out.println(" ");
            sleepFor(1);
            driver.switchTo().window(tabs.get(0));
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }


    /**
     * @author Vidhi Chapanera
     * @date 22 March 2021
     * @discription this method is use to create Product shopify to hike and verify in hike
     * @return
     */
    @Step("create Product shopify to hike and verify in hike")
    public boolean createProductShopifytoHike() throws IOException {
        CenterlizePO centerlizePO = PageFactory.initElements(driver, CenterlizePO.class);
        ProductsPO.ProductsPO.Products products1 = PageFactory.initElements(driver, ProductsPO.ProductsPO.Products.class);
        Actions actions = new Actions(driver);
        try{
            sleepFor(5);
            ArrayList<String> tabs1 = new ArrayList<String> (driver.getWindowHandles());
            driver.switchTo().window(tabs1.get(1));
            sleepFor(1);
            centerlizePO.clickOnButton(getAddProductButtonShopify());
            sleepFor(3);
            renameFileData(getTitleInputBoxShopify(), "\\src\\main\\java\\IntegrationsPO\\ShopifyPO\\File\\SProduct");
            sleepFor(4);
            WebElement status = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//h2[text()='Product status']//parent::div//following-sibling::div//select")));
            Select select = new Select(status);
            select.selectByIndex(0);
            sleepFor(2);
            centerlizePO.enterDataUsingSendkeys(getSKUInputBoxshopify(),"5002030");
            sleepFor(1);
            centerlizePO.clearText(getPrice());
            centerlizePO.enterDataUsingSendkeys(getPrice(),"155");
            sleepFor(1);
            centerlizePO.clearText(getAvailableInputBoxshopify());
            centerlizePO.enterDataUsingSendkeys(getAvailableInputBoxshopify(),"100");
            sleepFor(2);
            List<WebElement> btn = new WebDriverWait(driver,60).
                    until(ExpectedConditions.
                            presenceOfAllElementsLocatedBy(By.xpath
                                    ("//span[text()='Save']//parent::span//parent::button")));
            actions.moveToElement(btn.get(0)).click().perform();
            sleepFor(5);
            ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
            driver.switchTo().window(tabs.get(0));
            driver.navigate().refresh();
            sleepFor(3);
            PageFactory.initElements(driver, Reporting.class).clickOnReportingButton();
            PageFactory.initElements(driver, Users.class).clickOnUsersButton();
            PageFactory.initElements(driver,StoreSetup.class).clickOnStoreSetupButton();
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Integrations.class).getIntegrationsButton());
            centerlizePO.clickOnButton(getManageButton());
            sleepFor(1);
            centerlizePO.clickOnButton(getManualSyncButton());
            sleepFor(4);
            String[] strArray2 = new String[]{"syncProducts", "syncCustomers", "syncSales"};
            for (String s : strArray2) {
                WebElement element = new WebDriverWait(driver, 60).ignoring(StaleElementReferenceException.class).
                        until(ExpectedConditions.presenceOfElementLocated
                                (By.xpath("//label[@for='" + s + "']")));
                element.click();
            }
            centerlizePO.clickOnButton(getButtonSyncNow());
            sleepFor(2);
            centerlizePO.clickOnButton(getSaveButton());
            sleepFor(10);
            PageFactory.initElements(driver, ProductsPO.Products.class).clickOnProductsButtonn();
            sleepFor(2);
            centerlizePO.clickOnButton(products1.getProductButton());
            sleepFor(3);
            centerlizePO.enterDataUsingSendkeys(products1.getSearchBox(), getValueFrom("\\src\\main\\java\\IntegrationsPO\\ShopifyPO\\File\\SProduct"));
            sleepFor(1);
            sleepFor(3);
            List<WebElement> list1 = new WebDriverWait(driver,120).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy
                            (By.xpath("//ul[contains(@class,'hike-width-block')]//b[text()='Product']//parent::ul//li//a")));
            list1.get(0).click();
            sleepFor(3);
            WebElement name = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//table[@id='RosterDataTable']//tbody//tr//td[2]//span[text()='" + getValueFrom("\\src\\main\\java\\IntegrationsPO\\ShopifyPO\\File\\SProduct") + "']//parent::td//following-sibling::td//a")));
            name.click();
            while(true){
                sleepFor(5);
                centerlizePO.clickOnButton(getRefreshLogButton());
                sleepFor(5);
                if (driver.findElement(By.xpath("//td[text()='Shopify - Hike']//following-sibling::td[1][text()='Created']")).isDisplayed())
                    break;
            }
            sleepFor(2);
            actions.sendKeys(Keys.ESCAPE).build().perform();
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }


    /**
     * @author Vidhi Chapanera
     * @date 22 March 2021
     * @discription this method is use to create Customers Hike to shopify and verify in Shopify
     * @return
     */
    @Step("create Customers Hike to shopify and verify in Shopify")
    public boolean createCustomersHiketoShopify() throws IOException {
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
            renameFileData(PageFactory.initElements(driver, CustomersPO.CustomersPO.Customers.class).getFirstName(), "\\src\\main\\java\\IntegrationsPO\\ShopifyPO\\File\\HCustomer");
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
                            (By.xpath("//table[@id='CustomersTable']//tbody//tr//td[2]//span[contains(text(),'"+getValueFrom("\\src\\main\\java\\IntegrationsPO\\ShopifyPO\\File\\HCustomer")+"')]//parent::td//following-sibling::td//a")));
            name.click();
            while(true){
                sleepFor(5);
                centerlizePO.clickOnButton(getRefreshLogButton());
                sleepFor(5);
                if (driver.findElement(By.xpath("//td[text()='Hike - Shopify']//following-sibling::td[1][text()='Created']")).isDisplayed())
                    break;
            }
            sleepFor(2);
            actions.sendKeys(Keys.ESCAPE).build().perform();
            sleepFor(3);
            ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));
            sleepFor(2);
            centerlizePO.clickOnButton(getCustomersButtonShopify());
            sleepFor(1);
            driver.navigate().refresh();
            System.out.println(8);
            //centerlizePO.enterDataUsingSendkeys(getCustomersSearch(),customer);
            sleepFor(4);
            if (driver.findElements(By.xpath("//ul//li//div[text()='"+getValueFrom("\\src\\main\\java\\IntegrationsPO\\ShopifyPO\\File\\HCustomer")+"']")).get(1).isDisplayed())
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
     * @date 22 March 2021
     * @discription this method is use to create Customers shopify to hike and verify in hike
     * @return
     */
    @Step("create Customers shopify to hike and verify in hike")
    public boolean createCustomersShopifytoHike() throws IOException {
        CenterlizePO centerlizePO = PageFactory.initElements(driver, CenterlizePO.class);
        try{
            sleepFor(5);
            ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));
            centerlizePO.clickOnButton(getAddCustomerButtonShopify());
            sleepFor(3);
            List<WebElement> elementList1 = new WebDriverWait(driver,120).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy
                            (By.xpath("//input[contains(@id,'Text')]")));
            renameFileData(elementList1.get(0), "\\src\\main\\java\\IntegrationsPO\\ShopifyPO\\File\\SCustomer");
            String[] strArray2 = new String[]{"1", "4", "5", "6", "7", "8", "9"};
            for (String s : strArray2) {
                List<WebElement> elementList = new WebDriverWait(driver,120).
                        until(ExpectedConditions.presenceOfAllElementsLocatedBy
                                (By.xpath("//input[contains(@id,'Text')]")));
                elementList.get(Integer.parseInt(s)).sendKeys("testData");
            }
            WebElement btn = new WebDriverWait(driver,60).
                    until(ExpectedConditions.
                            presenceOfElementLocated(By.xpath
                                    ("//span[text()='Save']//parent::span//parent::button")));
            btn.click();
            sleepFor(7);
            driver.switchTo().window(tabs.get(0));
            sleepFor(2);
            driver.navigate().refresh();
            sleepFor(3);
            PageFactory.initElements(driver, Reporting.class).clickOnReportingButton();
            PageFactory.initElements(driver, Users.class).clickOnUsersButton();
            PageFactory.initElements(driver,StoreSetup.class).clickOnStoreSetupButton();
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Integrations.class).getIntegrationsButton());
            sleepFor(3);
            centerlizePO.clickOnButton(getManageButton());
            sleepFor(1);
            centerlizePO.clickOnButton(getManualSyncButton());
            sleepFor(4);
            String[] strArray1 = new String[]{"syncProducts", "syncCustomers", "syncSales"};
            for (String s : strArray1) {
                WebElement element = new WebDriverWait(driver, 60).ignoring(StaleElementReferenceException.class).
                        until(ExpectedConditions.presenceOfElementLocated
                                (By.xpath("//label[@for='" + s + "']")));
                element.click();
            }
            centerlizePO.clickOnButton(getButtonSyncNow());
            sleepFor(2);
            centerlizePO.clickOnButton(getSaveButton());
            sleepFor(10);
            PageFactory.initElements(driver, CustomersPO.Customers.class).clickOnCustomersButton();
            sleepFor(2);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, CustomersPO.CustomersPO.Customers.class).getCustomersButton());
            sleepFor(3);
            WebElement name = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//table[@id='CustomersTable']//tbody//tr//td[2]//span[contains(text(),'"+getValueFrom("\\src\\main\\java\\IntegrationsPO\\ShopifyPO\\File\\SCustomer")+"')]//parent::td//following-sibling::td//a")));
            Actions actions = new Actions(driver);
            actions.moveToElement(name).click().perform();
            sleepFor(5);
            while(true){
                sleepFor(5);
                centerlizePO.clickOnButton(getRefreshLogButton());
                sleepFor(5);
                if (driver.findElement(By.xpath("//td[text()='Shopify - Hike']//following-sibling::td[1][text()='Created']")).isDisplayed())
                    break;
            }
            sleepFor(2);
            actions.sendKeys(Keys.ESCAPE).build().perform();
            sleepFor(3);
            sleepFor(1);
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }


    /**
     * @author Vidhi Chapanera
     * @date 22 March 2021
     * @discription this method is use to create Sale Shopify to Hike and verify in Hike
     * @return
     */
    @Step("create Sale Shopify to Hike and verify in Hike")
    public boolean createSaleShopifytoHike() throws IOException {
        CenterlizePO centerlizePO = PageFactory.initElements(driver, CenterlizePO.class);
        Actions actions = new Actions(driver);
        String product = "P-0002";
        try{
            sleepFor(5);
            ArrayList<String> tabs1 = new ArrayList<String> (driver.getWindowHandles());
            driver.switchTo().window(tabs1.get(1));
            sleepFor(5);
            centerlizePO.clickOnButton(getOrderShopifyButton());
            sleepFor(3);
            centerlizePO.clickOnButton(getDraftsShopifyButton());
            sleepFor(3);
            centerlizePO.clickOnButton(getCreateDraftsShopifyButton());
            sleepFor(7);
           /* centerlizePO.clickOnButton(getBrowseButtonShopify());
            sleepFor(3);*/
            centerlizePO.enterDataUsingSendkeys(getSearchProductShopify(),product);
            sleepFor(3);
            WebElement product002 = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//span[text()='"+product+"']//parent::label")));
            actions.moveToElement(product002).click().perform();
            sleepFor(2);
            centerlizePO.clickOnButton(getAddOrderButton());
            sleepFor(5);
            centerlizePO.clickOnButton(getSearchCustomers());
            List<WebElement> inputList = new WebDriverWait(driver, 60).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//li[contains(@id,'ListBoxOption')]")));
            actions.moveToElement(inputList.get(1)).click().build().perform();
            sleepFor(5);
            actions.sendKeys(Keys.PAGE_DOWN).build().perform();
            JavascriptExecutor executor = (JavascriptExecutor)driver;
            executor.executeScript("arguments[0].click();", getMarkAsPaidButton());
            sleepFor(10);
            centerlizePO.clickOnButton(getCreateOrderButton());
            sleepFor(8);
            centerlizePO.clickOnButton(getMarkAsfulfilledButton());
            sleepFor(8);
            centerlizePO.clickOnButton(getFulfillItemsButton());
            sleepFor(8);
            WebElement ref = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//h1")));
            String shopifySale = ref.getText();
            System.out.println(shopifySale);
            sleepFor(3);
            JavascriptExecutor jse = (JavascriptExecutor)driver;
            jse.executeScript("window.close()");
            ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
            driver.switchTo().window(tabs.get(0));
            sleepFor(5);
            PageFactory.initElements(driver,StoreSetup.class).clickOnStoreSetupButton();
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Integrations.class).getIntegrationsButton());
            centerlizePO.clickOnButton(getManageButton());
            sleepFor(1);
            centerlizePO.clickOnButton(getManualSyncButton());
            sleepFor(4);
            String[] strArray2 = new String[]{"syncProducts", "syncCustomers", "syncSales"};
            for (String s : strArray2) {
                WebElement element = new WebDriverWait(driver, 60).ignoring(StaleElementReferenceException.class).
                        until(ExpectedConditions.presenceOfElementLocated
                                (By.xpath("//label[@for='" + s + "']")));
                element.click();
            }
            centerlizePO.clickOnButton(getButtonSyncNow());
            sleepFor(2);
            centerlizePO.clickOnButton(getSaveButton());
            sleepFor(10);
            PageFactory.initElements(driver, PointofSale.class).clickOnPointOfSaleButtonn();
            sleepFor(5);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, SalesHistory.class).getSalesHistoryButton());
            sleepFor(7);
            WebElement sale = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//table[@id='SalesTable']//tbody//tr//td[2]//a[text()='"+shopifySale+"']//parent::td//following-sibling::td//a//i//parent::a")));
            actions.moveToElement(sale).click().perform();
            sleepFor(3);
            while(true){
                sleepFor(5);
                centerlizePO.clickOnButton(getRefreshLogButton());
                sleepFor(5);
                if (driver.findElement(By.xpath("//td[text()='Shopify - Hike']//following-sibling::td[1][text()='Created']")).isDisplayed())
                    break;
            }
            sleepFor(2);
            actions.sendKeys(Keys.ESCAPE).build().perform();
            sleepFor(3);
            sleepFor(1);
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }


    /**
     * @author Vidhi Chapanera
     * @date 22 March 2021
     * @discription this method is use to create Sale Hike to shopify and verify in Shopify
     * @return
     */
    @Step("create Sale Hike to shopify and verify in Shopify")
    public boolean createSaleHiketoShopify() throws IOException {
        CenterlizePO centerlizePO = PageFactory.initElements(driver, CenterlizePO.class);
        Actions actions = new Actions(driver);
        try{
            sleepFor(5);
            ArrayList<String> tabs1 = new ArrayList<String> (driver.getWindowHandles());
            driver.switchTo().window(tabs1.get(0));
            sleepFor(3);
            PageFactory.initElements(driver, PointofSale.class).clickOnPointOfSaleButtonn();
            sleepFor(2);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, ProcessSale.class).getProcessSaleButton());
            sleepFor(20);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, CashRegister.class).getOpenRegisterButton());
            sleepFor(2);
            centerlizePO.clickOnButton(getOpenButton());
            sleepFor(3);
            PageFactory.initElements(driver, ProcessSale.class).getSearchBar().sendKeys(getValueFrom("\\src\\main\\java\\IntegrationsPO\\ShopifyPO\\File\\SProduct"));
            sleepFor(2);
            actions.sendKeys(Keys.TAB).build().perform();
            sleepFor(1);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, ProcessSale.class).getPayButton());
            sleepFor(3);
            try{
                if (PageFactory.initElements(driver, ProcessSale.class).getCashButton().isDisplayed())
                    centerlizePO.clickOnButton(PageFactory.initElements(driver, ProcessSale.class).getCashButton());
            }catch (Exception e){
                System.out.println(" ");
            }
            sleepFor(3);
            /*String mainWindowHandle = driver.getWindowHandle();
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
            driver.switchTo().window(mainWindowHandle);*/
            centerlizePO.clickOnButton(PageFactory.initElements(driver, ProcessSale.class).getAddNewSaleButton());
            sleepFor(5);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, SalesHistory.class).getSalesHistoryButton());
            sleepFor(5);
            WebElement sale = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//table[@id='SalesTable']//tbody//tr[1]//td[2]//a[text()]//parent::td//following-sibling::td//a//i//parent::a")));
            sale.click();
            sleepFor(3);
            while(true){
                sleepFor(5);
                centerlizePO.clickOnButton(getRefreshLogButton());
                sleepFor(5);
                if (driver.findElement(By.xpath("//td[text()='Hike - Shopify']//following-sibling::td[1][text()='Created']")).isDisplayed())
                    break;
            }
            sleepFor(2);
            actions.sendKeys(Keys.ESCAPE).build().perform();
            sleepFor(3);
            /*JavascriptExecutor jse = (JavascriptExecutor)driver;
            jse.executeScript("window.open()");*/
            sleepFor(3);
            ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));
            sleepFor(3);
            //driver.get("https://" + getAddressValue() + ".myshopify.com/admin/orders");
            sleepFor(5);
            sleepFor(2);
            centerlizePO.clickOnButton(getOrderShopifyButton());
            sleepFor(5);
            centerlizePO.enterDataUsingSendkeys(getOrderSearchShopify(),getValueFrom("\\src\\main\\java\\IntegrationsPO\\ShopifyPO\\File\\SProduct"));
            sleepFor(4);
            WebElement moreFilter = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//span[text()='More filters']//parent::span//parent::button")));
            centerlizePO.clickOnButton(moreFilter);
            sleepFor(3);
            WebElement date = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//span[text()='Date']//parent::h3//parent::div//parent::button")));
            centerlizePO.clickOnButton(date);
            sleepFor(3);
            WebElement label = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//span[text()='Today']//parent::span//parent::label")));
            centerlizePO.clickOnButton(label);
            sleepFor(2);
            WebElement btn = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//span[text()='Done']//parent::span//parent::button")));
            centerlizePO.clickOnButton(btn);
            sleepFor(8);
            WebElement item = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//table//tr//td[9]//button")));
            item.click();
            sleepFor(2);
            WebElement item01 = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//span[contains(@class,'progressComplete')]//parent::div//following-sibling::div//p//a")));
            if (item01.getText().contains(getValueFrom("\\src\\main\\java\\IntegrationsPO\\ShopifyPO\\File\\SProduct")))
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
     * @date 30 March 2021
     * @discription this method is use to Purge data
     * @return
     */
    @Step("Purge data")
    public boolean PurgeData() throws IOException {
        CenterlizePO centerlizePO = PageFactory.initElements(driver,CenterlizePO.class);
        Actions actions = new Actions(driver);
        try{
            sleepFor(1);
            PageFactory.initElements(driver, StoreSetup.class).clickOnStoreSetupButton();
            centerlizePO.clickOnButton(PageFactory.initElements(driver, MyAccount.class).getMyAccountButton());
            sleepFor(5);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, MyAccount.class).getPurgeData());
            sleepFor(8);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, MyAccount.class).getDeleteAllProducts());
            sleepFor(1);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, MyAccount.class).getSupplier());
            sleepFor(1);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, MyAccount.class).getPurgeSelected());
            sleepFor(5);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, CashRegister.class).getContinueButton());
            sleepFor(5);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, ProcessSale.class).getOkButton());
            sleepFor(2);
            PageFactory.initElements(driver,PointofSale.class).clickOnPointOfSaleButtonn();
            sleepFor(2);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, CashRegister.class).getCashRegisterButton());
            sleepFor(15);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, CashRegister.class).getRefreshDataButton());
            centerlizePO.clickOnButton(PageFactory.initElements(driver, CashRegister.class).getContinueButton());
            centerlizePO.sleepFor(15);
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    /**
     * @author Vidhi Chapanera
     * @date 30 March 2021
     * @return
     * @throws IOException
     * @discription this method is used to get email value
     */
    @Step("")
    public String getemail() throws IOException {
        String tesLine ="";
        File f = new File(System.getProperty("user.dir") + "\\src\\main\\java\\IntegrationsPO\\ShopifyPO\\File\\email");
        f.canWrite();
        Scanner scanner = new Scanner(f);
        while (scanner.hasNextLine()) {
            tesLine += scanner.nextLine();
        }
        //String lowercase = tesLine.split("-")[0].toLowerCase() + "-" + tesLine.split("-")[1];
        scanner.close();
        return tesLine;
    }


    /**
     * @author Vidhi Chapanera
     * @date 30 March 2021
     * @discription this method is use to login to shopify existing store
     * @return
     */
    @Step("login to shopify existing store")
    public boolean loginToShopifyExistingStore() throws IOException {
        CenterlizePO centerlizePO = PageFactory.initElements(driver,CenterlizePO.class);
        Actions actions = new Actions(driver);
        try{
            sleepFor(2);
            JavascriptExecutor jse = (JavascriptExecutor)driver;
            jse.executeScript("window.open()");
            ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));
            sleepFor(1);
            driver.get("https://accounts.shopify.com/store-login?new_store_login=true");
            sleepFor(5);
            sleepFor(2);
            centerlizePO.enterDataUsingSendkeys(getEmailShopifyL(),getemail());
            centerlizePO.enterDataUsingSendkeys(getEmailShopifyL(),"@yahoo.com");
            sleepFor(2);
            centerlizePO.clickOnButton(getNextButton());
            sleepFor(5);
            centerlizePO.clearText(getPasswordShopifyL());
            String fileLocation =System.getProperty("user.dir")+"\\src\\main\\resources\\createStore.properties";
            Properties properties1 = new Properties();
            properties1.load(new FileReader(fileLocation));
            centerlizePO.enterDataUsingSendkeys(getPasswordShopifyL(),String.valueOf(properties1.put(StoreConstant.PASSWORD,"password")));
            sleepFor(2);
            centerlizePO.clickOnButton(getLoginButton01());
            sleepFor(15);
            try{
                if(driver.findElement(By.xpath("//p[text()='You can’t access this store because your trial ended']")).isDisplayed()) {
                    sleepFor(3);
                    driver.get("https://www.shopify.com");
                    sleepFor(5);
                    centerlizePO.clickOnButton(getStartDreeTrial());
                    sleepFor(3);
                    renameFileData(getStoreNameShopify(), "\\src\\main\\java\\IntegrationsPO\\ShopifyPO\\File\\ShopifyStore");
                    renameFileData(getEmailShopify(), "\\src\\main\\java\\IntegrationsPO\\ShopifyPO\\File\\email");
                    centerlizePO.enterDataUsingSendkeys(getEmailShopify(), "@yahoo.com");
                    centerlizePO.enterDataUsingSendkeys(getPasswordShopify(), String.valueOf(properties1.put(StoreConstant.PASSWORD, "password")));
                    centerlizePO.clickOnButton(getCreateYourStoreButton());
                    sleepFor(30);
                    //centerlizePO.clickOnButton(getLoginButton());
                    centerlizePO.clickOnButton(getSkipButton());
                    sleepFor(5);
                    List<WebElement> inputList = new WebDriverWait(driver, 60).
                            until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//form//input[contains(@id,'Text')]")));
                    for (int i = 0; i < inputList.size() - 3; i++) {
                        inputList.get(i).clear();
                        inputList.get(i).sendKeys("test");
                    }
                    WebElement postcode = new WebDriverWait(driver, 60).ignoring(StaleElementReferenceException.class).
                            until(ExpectedConditions.presenceOfElementLocated
                                    (By.name("account_setup[zip]")));
                    centerlizePO.enterDataUsingSendkeys(postcode, "2060");
                    WebElement country = new WebDriverWait(driver, 60).ignoring(StaleElementReferenceException.class).
                            until(ExpectedConditions.presenceOfElementLocated
                                    (By.name("account_setup[country]")));
                    Select select = new Select(country);
                    select.selectByIndex(11);
                    WebElement state = new WebDriverWait(driver, 60).ignoring(StaleElementReferenceException.class).
                            until(ExpectedConditions.presenceOfElementLocated
                                    (By.name("province")));
                    Select select1 = new Select(state);
                    select1.selectByIndex(8);
                    WebElement phone = new WebDriverWait(driver, 60).ignoring(StaleElementReferenceException.class).
                            until(ExpectedConditions.presenceOfElementLocated
                                    (By.name("account_setup[phone]")));
                    centerlizePO.enterDataUsingSendkeys(phone, "04523146");
                    WebElement domain = new WebDriverWait(driver, 60).ignoring(StaleElementReferenceException.class).
                            until(ExpectedConditions.presenceOfElementLocated
                                    (By.name("account_setup[custom_domain]")));
                    centerlizePO.enterDataUsingSendkeys(domain, "test.com");
                    sleepFor(2);
                    centerlizePO.clickOnButton(getEnterMyStoreButton());
                    sleepFor(20);
                    //jse.executeScript("window.close()");
                    driver.switchTo().window(tabs.get(0));
                    sleepFor(5);
                }
            }catch(Exception e1){
                sleepFor(2);
                deleteProduct();
                deletecustomers();
                deleteSale();
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
     * @date 30 March 2021
     * @discription this method is use to delete product
     * @return
     */
    @Step("delete product")
    public boolean deleteProduct() throws IOException {
        CenterlizePO centerlizePO = PageFactory.initElements(driver,CenterlizePO.class);
        try{
            sleepFor(2);
            centerlizePO.clickOnButton(getProductsButtonShopify());
            sleepFor(1);
            centerlizePO.clickOnButton(getAllProductsButtonShopify());
            sleepFor(8);
            try {
                if (driver.findElement(By.xpath("//th[text()='Product']//parent::tr//label")).isDisplayed()) {
                    driver.findElement(By.xpath("//th[text()='Product']//parent::tr//label")).click();
                    sleepFor(3);
                    WebElement moreOption = new WebDriverWait(driver, 60).ignoring(StaleElementReferenceException.class).
                            until(ExpectedConditions.presenceOfElementLocated
                                    (By.xpath("//span[text()='More actions']//parent::span//parent::button")));
                    moreOption.click();

                    WebElement deleteproduct = new WebDriverWait(driver, 60).ignoring(StaleElementReferenceException.class).
                            until(ExpectedConditions.presenceOfElementLocated
                                    (By.xpath("//span[text()='Delete products']//parent::span//parent::button")));
                    centerlizePO.clickOnButton(deleteproduct);
                    sleepFor(2);

                    WebElement delete = new WebDriverWait(driver, 60).ignoring(StaleElementReferenceException.class).
                            until(ExpectedConditions.presenceOfElementLocated
                                    (By.xpath("//span[text()='Delete']//parent::span//parent::button")));
                    centerlizePO.clickOnButton(delete);
                    sleepFor(10);
                    driver.navigate().refresh();
                    sleepFor(10);
                    }
            }catch (Exception e){
                System.out.println(true);;
            }
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }


    /**
     * @author Vidhi Chapanera
     * @date 30 March 2021
     * @discription this method is use to delete customers
     * @return
     */
    @Step("delete customers")
    public boolean deletecustomers() throws IOException {
        CenterlizePO centerlizePO = PageFactory.initElements(driver,CenterlizePO.class);
        try{
            sleepFor(2);
            centerlizePO.clickOnButton(getCustomersButtonShopify());
            sleepFor(10);
            try {
                if (driver.findElement(By.xpath("//span[contains(text(),'Showing')]//parent::div//label")).isDisplayed()) {
                    Actions actions = new Actions(driver);
                    actions.moveToElement(driver.findElement(By.xpath("//span[contains(text(),'Showing')]//parent::div//label"))).click().build().perform();
                    sleepFor(3);
                    WebElement moreOption = new WebDriverWait(driver, 60).ignoring(StaleElementReferenceException.class).
                            until(ExpectedConditions.presenceOfElementLocated
                                    (By.xpath("//span[text()='More actions']//parent::span//parent::button")));
                    moreOption.click();
                    WebElement deletecustomer = new WebDriverWait(driver, 60).ignoring(StaleElementReferenceException.class).
                            until(ExpectedConditions.presenceOfElementLocated
                                    (By.xpath("//span[text()='Delete selected customers']//parent::span//parent::button")));
                    centerlizePO.clickOnButton(deletecustomer);
                    sleepFor(2);
                    WebElement delete01 = new WebDriverWait(driver, 60).ignoring(StaleElementReferenceException.class).
                            until(ExpectedConditions.presenceOfElementLocated
                                    (By.xpath("//span[text()='Delete customers']//parent::span//parent::button")));
                    sleepFor(2);
                    centerlizePO.clickOnButton(delete01);
                    sleepFor(10);
                    driver.navigate().refresh();
                    sleepFor(10);
                }
            }catch (Exception e){
                System.out.println(true);;
            }
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }


    /**
     * @author Vidhi Chapanera
     * @date 30 March 2021
     * @discription this method is use to delete sale
     * @return
     */
    @Step("delete customers")
    public boolean deleteSale() throws IOException {
        CenterlizePO centerlizePO = PageFactory.initElements(driver,CenterlizePO.class);
        try{
            sleepFor(2);
            centerlizePO.clickOnButton(getOrderShopifyButton());
            sleepFor(3);
            centerlizePO.clickOnButton(getDraftsShopifyButton());
            sleepFor(10);
            try {
                if (driver.findElement(By.xpath("//span[text()='Draft order']//parent::p//parent::div//parent::div//parent::div//label")).isDisplayed()) {
                    Actions actions = new Actions(driver);
                    actions.moveToElement(driver.findElement(By.xpath("//span[text()='Draft order']//parent::p//parent::div//parent::div//parent::div//label"))).click().build().perform();
                    sleepFor(3);
                    WebElement moreOption = new WebDriverWait(driver, 60).ignoring(StaleElementReferenceException.class).
                            until(ExpectedConditions.presenceOfElementLocated
                                    (By.xpath("//span[text()='Actions']//parent::span//parent::button")));
                    moreOption.click();
                    WebElement deletecustomer = new WebDriverWait(driver, 60).ignoring(StaleElementReferenceException.class).
                            until(ExpectedConditions.presenceOfElementLocated
                                    (By.xpath("//span[text()='Delete draft orders']//parent::span//parent::button")));
                    centerlizePO.clickOnButton(deletecustomer);
                    sleepFor(2);
                    WebElement delete01 = new WebDriverWait(driver, 60).ignoring(StaleElementReferenceException.class).
                            until(ExpectedConditions.presenceOfElementLocated
                                    (By.xpath("//span[text()='Delete']//parent::span//parent::button")));
                    sleepFor(2);
                    centerlizePO.clickOnButton(delete01);
                    sleepFor(10);
                    driver.navigate().refresh();
                    sleepFor(10);
                }
            }catch (Exception e){
                System.out.println(true);;
            }
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }


    /**
     * @author Vidhi Chapanera
     * @date 20 July 2021
     * @discription this method is use to automate Shopify
     * @return
     */
    @Step("automate Xero")
    public boolean automateShopify() throws IOException {
        try{
            createHikeStoreForShopify();
            clickOnActivateButtonOnShopify();
            loginToShopifyExistingStore();
            connectYourStoretoHike();
            mappingShopify();
            createProductHiketoShopify();
            createProductShopifytoHike();
            createCustomersHiketoShopify();
            createCustomersShopifytoHike();
            createSaleHiketoShopify();
            //createSaleShopifytoHike();
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