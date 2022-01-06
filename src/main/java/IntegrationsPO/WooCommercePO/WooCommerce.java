package IntegrationsPO.WooCommercePO;

import CommonPO.BasePage;
import CommonPO.CenterlizePO;
import CreateStorePO.CreateStore;
import CreateStorePO.StoreConstant;
import IntegrationsPO.BigCommercePO.BigCommerceConstant;
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
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


/**
 * @author Vidhi Chapanera
 * @date 12 May 2021
 */
public class WooCommerce extends BasePage {

    public WebDriver driver;
    public static String consumerKey = "";
    public static String consumersecret = "";
    public static String currentURL = "";


    public WooCommerce(WebDriver driver) {
        this.driver = driver;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for WooCommerce activate button
     * @date 12 May 2021
     */
    @FindBy(how = How.XPATH, using = "//table//tr//td[contains(text(),'WooCommerce')]//parent::tr//button")
    WebElement btn_wooCommerceactivate;
    public WebElement getWooCommerceActivate() {
        return btn_wooCommerceactivate;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for WooCommerce username text box
     * @date 12 May 2021
     */
    @FindBy(how = How.ID, using = "user_login")
    WebElement txt_userwoo;
    public WebElement getUserNameWoo() {
        return txt_userwoo ;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for WooCommerce password text box
     * @date 12 May 2021
     */
    @FindBy(how = How.ID, using = "user_pass")
    WebElement txt_passwoo;
    public WebElement getPasswoedWoo() {
        return txt_passwoo ;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for WooCommerce login button
     * @date 12 May 2021
     */
    @FindBy(how = How.ID, using = "wp-submit")
    WebElement btb_login;
    public WebElement getLoginButton() {
        return btb_login ;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for WooCommerce button
     * @date 12 May 2021
     */
    @FindBy(how = How.XPATH, using = "//div[text()='WooCommerce']")
    WebElement btn_woocommerce;
    public WebElement getWooCommerceButton() {
        return btn_woocommerce ;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for WooCommerce Settings button
     * @date 12 May 2021
     */
    @FindBy(how = How.XPATH, using = "//div[text()='WooCommerce']//parent::a//parent::li//a[text()='Settings']")
    WebElement btn_woocommerceSettings;
    public WebElement getWooCommerceSettingsButton() {
        return btn_woocommerceSettings ;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for WooCommerce Advanced button
     * @date 12 May 2021
     */
    @FindBy(how = How.XPATH, using = "//a[text()='Advanced']")
    WebElement btn_woocommerceAdvanced;
    public WebElement getWooCommerceAdvancedButton() {
        return btn_woocommerceAdvanced ;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for WooCommerce REST API button
     * @date 12 May 2021
     */
    @FindBy(how = How.XPATH, using = "//a[text()='REST API']")
    WebElement btn_woocommercerestapi;
    public WebElement getWooCommerceRestAPIButton() {
        return btn_woocommercerestapi ;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for WooCommerce Add key button
     * @date 12 May 2021
     */
    @FindBy(how = How.XPATH, using = "//a[text()='Add key']")
    WebElement btn_woocommerceAddkey;
    public WebElement getWooCommerceAddKeyButton() {
        return btn_woocommerceAddkey ;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for WooCommerce key description textbox
     * @date 12 May 2021
     */
    @FindBy(how = How.ID, using = "key_description")
    WebElement txt_keydiscription;
    public WebElement getWooCommerceKeyDescription() {
        return txt_keydiscription ;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for WooCommerce Generate API key button
     * @date 12 May 2021
     */
    @FindBy(how = How.ID, using = "update_api_key")
    WebElement btn_woocommerceGenerateAPIkey;
    public WebElement getWooCommerceGenerateAPIkeyButton() {
        return btn_woocommerceGenerateAPIkey ;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for WooCommerce Consumer key text box
     * @date 12 May 2021
     */
    @FindBy(how = How.ID, using = "key_consumer_key")
    WebElement txt_Consumerkey;
    public WebElement getConsumerKey() {
        return txt_Consumerkey ;
    }



    /**
     * @author Vidhi Chapanera
     * @discription this locator is for WooCommerce Consumer secret text box
     * @date 12 May 2021
     */
    @FindBy(how = How.ID, using = "key_consumer_secret")
    WebElement txt_Consumersecret;
    public WebElement getConsumerSecret() {
        return txt_Consumersecret ;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for WooCommerce Shop Url text box
     * @date 12 May 2021
     */
    @FindBy(how = How.XPATH, using = "//label[normalize-space(.)='WooCommerce Shop Url']//parent::div//input")
    WebElement txt_wooshopurl;
    public WebElement getWooShopURL() {
        return txt_wooshopurl ;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for WooCommerce Consumer Key text box
     * @date 12 May 2021
     */
    @FindBy(how = How.XPATH, using = "//label[normalize-space(.)='WooCommerce Consumer Key']//parent::div//input")
    WebElement txt_wooConsumerKey;
    public WebElement getWooConsumerKey() {
        return txt_wooConsumerKey ;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for WooCommerce Consumer Secret text box
     * @date 12 May 2021
     */
    @FindBy(how = How.XPATH, using = "//label[normalize-space(.)='WooCommerce Consumer Secret']//parent::div//input")
    WebElement txt_wooConsumerSecret;
    public WebElement getWooConsumerSecret() {
        return txt_wooConsumerSecret ;
    }



    /**
     * @author Vidhi Chapanera
     * @date 12 May 2021
     * @discription this method is use to create hike store for WooCommerce
     * @return
     */
    /*@Step("create hike store for WooCommerce")
    public boolean createHikeStoreForWooCommerce(){
        CenterlizePO centerlizePO = PageFactory.initElements(driver,CenterlizePO.class);
        try{
            sleepFor(5);
            String fileLocation =System.getProperty("user.dir")+"\\src\\main\\resources\\createStore.properties";
            Properties properties1 = new Properties();
            properties1.load(new FileReader(fileLocation));
            centerlizePO.clickOnButton(PageFactory.initElements(driver, CreateStore.class).getStartFreeTrialLink());
            PageFactory.initElements(driver, CreateStore.class).renameFileData
                    (PageFactory.initElements(driver, CreateStore.class).getFirstNameTextBox()
                            ,"\\src\\main\\java\\IntegrationsPO\\WooCommercePO\\File\\FirstName");
            PageFactory.initElements(driver, CreateStore.class).renameFileData
                    (PageFactory.initElements(driver, CreateStore.class).getLastNameTextBox()
                            ,"\\src\\main\\java\\IntegrationsPO\\WooCommercePO\\File\\LastName");
            centerlizePO.enterDataUsingSendkeys(PageFactory.initElements(driver, CreateStore.class).getEmailTextBox(), StoreConstant.EMAIL);
            centerlizePO.enterDataUsingSendkeys(PageFactory.initElements(driver, CreateStore.class).getPhoneTextBox(), StoreConstant.PHONE);
            centerlizePO.clearText(PageFactory.initElements(driver, CreateStore.class).getCityTextBox());
            centerlizePO.enterDataUsingSendkeys(PageFactory.initElements(driver, CreateStore.class).getCityTextBox(),StoreConstant.CITY);
            centerlizePO.enterDataUsingSendkeys(PageFactory.initElements(driver, CreateStore.class).getPasswordTextBox(),String.valueOf(properties1.put(StoreConstant.PASSWORD,"password")));
            centerlizePO.clickOnButton(PageFactory.initElements(driver, CreateStore.class).getContinueButton());
            PageFactory.initElements(driver, CreateStore.class).renameFileData
                    (PageFactory.initElements(driver, CreateStore.class).getAccountAddressTextBox()
                            ,"\\src\\main\\java\\IntegrationsPO\\WooCommercePO\\File\\AccountAddress");
            centerlizePO.clickOnButton(PageFactory.initElements(driver, CreateStore.class).getContinueButtonOnAccountAddressPage());
            centerlizePO.selectValueFromDropDown(PageFactory.initElements(driver, CreateStore.class).getIndustryTypeDropDown(),"Fashion & Clothing Retail");
            centerlizePO.clickOnButton(PageFactory.initElements(driver, CreateStore.class).getCreteMyStoreButton());
            sleepFor(30);
            PageFactory.initElements(driver,Shopify.class).PurgeData();
            sleepFor(1);
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }*/


    /**
     * @author Vidhi Chapanera
     * @date 13 May 2021
     * @discription this method is use to click on activate button on WooCommerce
     * @return
     */
    @Step("create hike store for WooCommerce")
    public boolean createHikeStoreForWooCommerce(){
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
     * @date 12 May 2021
     * @discription this method is use to click on activate button on WooCommerce
     * @return
     */
    @Step("click on activate button on WooCommerce")
    public boolean clickOnActivateButtonOnWooCommerce(){
        CenterlizePO centerlizePO = PageFactory.initElements(driver,CenterlizePO.class);
        try{
            sleepFor(5);
            PageFactory.initElements(driver, StoreSetup.class).clickOnStoreSetupButton();
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Integrations.class).getIntegrationsButton());
            sleepFor(3);
            centerlizePO.clickOnButton(getWooCommerceActivate());
            sleepFor(5);
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }


    /**
     * @author Vidhi Chapanera
     * @date 12 May 2021
     * @discription this method is use to login to WooCommerce store
     * @return
     */
    @Step("login to WooCommerce store")
    public boolean loginToWooCommerceStore() throws IOException {
        CenterlizePO centerlizePO = PageFactory.initElements(driver,CenterlizePO.class);
        try{
            sleepFor(2);
            JavascriptExecutor jse = (JavascriptExecutor)driver;
            jse.executeScript("window.open()");
            ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));
            sleepFor(1);
            driver.get("https://www.hikedemo.club/wp-admin/");
            centerlizePO.enterDataUsingSendkeys(getUserNameWoo(),"support@hikeup.com");
            centerlizePO.enterDataUsingSendkeys(getPasswoedWoo(),"l6W$nzyv9unN%@G1kNyjMmTO");
            centerlizePO.clickOnButton(getLoginButton());
            sleepFor(5);
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }


    /**
     * @author Vidhi Chapanera
     * @date 12 May 2021
     * @discription this method is use to Generate API key
     * @return
     */
    @Step("Generate API key")
    public boolean generateAPIKeys() throws IOException {
        CenterlizePO centerlizePO = PageFactory.initElements(driver,CenterlizePO.class);
        try{
            sleepFor(2);
            ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));
            sleepFor(1);
            centerlizePO.clickOnButton(getWooCommerceButton());
            centerlizePO.clickOnButton(getWooCommerceSettingsButton());
            centerlizePO.clickOnButton(getWooCommerceAdvancedButton());
            centerlizePO.clickOnButton(getWooCommerceRestAPIButton());
            centerlizePO.clickOnButton(getWooCommerceAddKeyButton());
            PageFactory.initElements(driver,Shopify.class).renameFileData(getWooCommerceKeyDescription(),"\\src\\main\\java\\IntegrationsPO\\WooCommercePO\\File\\Key");
            WebElement permission = new WebDriverWait(driver,60)
                    .until(ExpectedConditions.presenceOfElementLocated
                            (By.id("key_permissions")));
            Select select = new Select(permission);
            select.selectByIndex(2);
            centerlizePO.clickOnButton(getWooCommerceGenerateAPIkeyButton());
            sleepFor(5);
            consumerKey = getConsumerKey().getAttribute("value");
            consumersecret = getConsumerSecret().getAttribute("value");
            currentURL = driver.getCurrentUrl();
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }


    /**
     * @author Vidhi Chapanera
     * @date 12 May 2021
     * @discription this method is use to connect your WooCommerce store to hikeup
     * @return
     */
    @Step("connect your WooCommerce store to hikeup")
    public boolean connectYourStoretoHike() throws IOException {
        CenterlizePO centerlizePO = PageFactory.initElements(driver,CenterlizePO.class);
        try{
            sleepFor(1);
            ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
            driver.switchTo().window(tabs.get(0));
            centerlizePO.enterDataUsingSendkeys(getWooShopURL(),"https://"+currentURL.split("//")[1].split("/")[0]);
            centerlizePO.enterDataUsingSendkeys(getWooConsumerKey(),consumerKey);
            centerlizePO.enterDataUsingSendkeys(getWooConsumerSecret(),consumersecret);
            centerlizePO.clickOnButton(PageFactory.initElements(driver,Shopify.class).getConnectButton());
            sleepFor(20);
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

}