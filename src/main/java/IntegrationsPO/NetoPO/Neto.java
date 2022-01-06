 package IntegrationsPO.NetoPO;

 import CommonPO.BasePage;
 import CommonPO.CenterlizePO;
 import CreateStorePO.CreateStore;
 import CreateStorePO.StoreConstant;
 import IntegrationsPO.Integrations;
 import IntegrationsPO.QuickBooksPO.QuickBooks;
 import IntegrationsPO.ShopifyPO.Shopify;
 import IntegrationsPO.XeroPO.Xero;
 import IntegrationsPO.XeroPO.XeroConstant;
 import InventoryPO.Inventory;
 import PointofSalePO.CashRegisterPO.CashRegister;
 import PointofSalePO.PointofSale;
 import PointofSalePO.ProcessSalePO.ProcessSale;
 import PointofSalePO.SalesHistoryPO.SalesHistory;
 import ProductsPO.ProductsPO.Products;
 import ReportingPO.Reporting;
 import StoreSetupPO.GeneralPO.General;
 import StoreSetupPO.LoyaltyPointsPO.LoyaltyPoints;
 import StoreSetupPO.StoreSetup;
 import UsersPO.Users;
 import io.qameta.allure.Step;
 import net.sourceforge.lept4j.Sel;
 import org.omg.CORBA.StringHolder;
 import org.openqa.selenium.*;
 import org.openqa.selenium.interactions.Actions;
 import org.openqa.selenium.support.FindBy;
 import org.openqa.selenium.support.How;
 import org.openqa.selenium.support.PageFactory;
 import org.openqa.selenium.support.ui.ExpectedConditions;
 import org.openqa.selenium.support.ui.Select;
 import org.openqa.selenium.support.ui.WebDriverWait;

 import java.io.FileReader;
 import java.io.IOException;
 import java.text.SimpleDateFormat;
 import java.util.*;


 /**
 * @author Vidhi Chapanera
 * @date 29 April 2021
 */
public class   Neto extends BasePage {

    public WebDriver driver;
    public static String currentURL = "";


    public Neto(WebDriver driver) {
        this.driver = driver;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for neto activate button
     * @date 29 April 2021
     */
    @FindBy(how = How.XPATH, using = "//table//tr//td[contains(text(),'Neto')]//parent::tr//button")
    WebElement btn_netoactivate;
    public WebElement getNetoctivate() {
        return btn_netoactivate;
    }


     /**
      * @author Vidhi Chapanera
      * @discription this locator is for neto Free trial button
      * @date 29 April 2021
      */
     @FindBy(how = How.XPATH, using = "//a[@class='tel']//following-sibling::a[contains(text(),'Free trial')]")
     WebElement btn_netoFreeTrial;
     public WebElement getNetoFreeTrial() {
         return btn_netoFreeTrial;
     }


     /**
      * @author Vidhi Chapanera
      * @discription this locator is for neto email input box
      * @date 29 April 2021
      */
     @FindBy(how = How.NAME, using = "email")
     WebElement txt_email;
     public WebElement getEmailText() {
         return txt_email;
     }


     /**
      * @author Vidhi Chapanera
      * @discription this locator is for storename input box
      * @date 29 April 2021
      */
     @FindBy(how = How.NAME, using = "storename")
     WebElement txt_storename;
     public WebElement getStoreName() {
         return txt_storename;
     }


     /**
      * @author Vidhi Chapanera
      * @discription this locator is for username input box
      * @date 29 April 2021
      */
     @FindBy(how = How.NAME, using = "username")
     WebElement txt_username;
     public WebElement getUserName() {
         return txt_username;
     }


     /**
      * @author Vidhi Chapanera
      * @discription this locator is for phone input box
      * @date 29 April 2021
      */
     @FindBy(how = How.NAME, using = "phone")
     WebElement txt_phone;
     public WebElement getPhone() {
         return txt_phone;
     }


     /**
      * @author Vidhi Chapanera
      * @discription this locator is for get started button
      * @date 29 April 2021
      */
     @FindBy(how = How.ID, using = "free-trial-form-submit")
     WebElement btn_getStarted;
     public WebElement getStarted() {
         return btn_getStarted;
     }


     /**
      * @author Vidhi Chapanera
      * @discription this locator is for go to my store button
      * @date 29 April 2021
      */
     @FindBy(how = How.XPATH, using = "//a[contains(text(),'Go to my store')]")
     WebElement btn_gotomystore;
     public WebElement getGoToMyStore() {
         return btn_gotomystore;
     }


     /**
      * @author Vidhi Chapanera
      * @discription this locator is for contact person input box
      * @date 29 April 2021
      */
     @FindBy(how = How.XPATH, using = "//form[@id='popupForm']//label//span[text()='Contact Person']//parent::label//parent::div//input")
     WebElement txt_contactperson;
     public WebElement getContactPerson() {
         return txt_contactperson;
     }


     /**
      * @author Vidhi Chapanera
      * @discription this locator is for Password input box
      * @date 29 April 2021
      */
     @FindBy(how = How.ID_OR_NAME, using = "password")
     //@FindBy(how = How.XPATH, using = "//form[@id='popupForm']//label//span[text()='Password']//parent::label//parent::div//input")
     WebElement txt_Password;
     public WebElement getPassword() {
         return txt_Password;
     }


     /**
      * @author Vidhi Chapanera
      * @discription this locator is for confirm Password input box
      * @date 29 April 2021
      */
     @FindBy(how = How.XPATH, using = "//form[@id='popupForm']//label//span[text()='Confirm Password']//parent::label//parent::div//input")
     WebElement txt_confirmPassword;
     public WebElement getConfirmPassword() {
         return txt_confirmPassword;
     }


     /**
      * @author Vidhi Chapanera
      * @discription this locator is for Address input box
      * @date 29 April 2021
      */
     @FindBy(how = How.XPATH, using = "//form[@id='popupForm']//label//span[text()='Address']//parent::label//parent::div//input")
     WebElement txt_Address;
     public WebElement getAdresss() {
         return txt_Address;
     }


     /**
      * @author Vidhi Chapanera
      * @discription this locator is for postal code input box
      * @date 29 April 2021
      */
     @FindBy(how = How.XPATH, using = "//form[@id='popupForm']//label//span[text()='Postal Code']//parent::label//parent::div//input")
     WebElement txt_postalcode;
     public WebElement getPostalCode() {
         return txt_postalcode;
     }


     /**
      * @author Vidhi Chapanera
      * @discription this locator is for start using neto button
      * @date 29 April 2021
      */
     @FindBy(how = How.XPATH, using = "//span[text()='Start using Neto']//parent::Button")
     WebElement btn_startusingneto;
     public WebElement getStartUsingNetoButton() {
         return btn_startusingneto;
     }


     /**
      * @author Vidhi Chapanera
      * @discription this locator is for neto shop url text box
      * @date 29 April 2021
      */
     @FindBy(how = How.XPATH, using = "//label[text()='Neto Shop Url']//parent::div//input")
     WebElement txt_netoshopurl;
     public WebElement getNetoShopURL() {
         return txt_netoshopurl;
     }


     /**
      * @author Vidhi Chapanera
      * @discription this locator is for StoreUrl text box
      * @date 29 April 2021
      */
     @FindBy(how = How.ID, using = "StoreUrl")
     WebElement txt_netoshopurl1;
     public WebElement getNetoShopURL1() {
         return txt_netoshopurl1;
     }


     /**
      * @author Vidhi Chapanera
      * @discription this locator is for StoreUsername text box
      * @date 29 April 2021
      */
     @FindBy(how = How.ID, using = "StoreUsername")
     WebElement txt_netoStoreUsername;
     public WebElement getNetoStoreUsername() {
         return txt_netoStoreUsername;
     }


     /**
      * @author Vidhi Chapanera
      * @discription this locator is for StorePassword text box
      * @date 29 April 2021
      */
     @FindBy(how = How.ID, using = "StorePassword")
     WebElement txt_netoStorePassword;
     public WebElement getNetoStorePassword() {
         return txt_netoStorePassword;
     }



     /**
      * @author Vidhi Chapanera
      * @discription this locator is for StoreLoginButton  button
      * @date 29 April 2021
      */
     @FindBy(how = How.ID, using = "StoreLoginButton")
     WebElement btn_netoLogin;
     public WebElement getNetoLoginButton() {
         return btn_netoLogin;
     }


     /**
      * @author Vidhi Chapanera
      * @discription this locator is for hike tax dropdown
      * @date 30 April 2021
      */
     @FindBy(how = How.XPATH, using = "//label[contains(text(),'Hike tax for products')]//following-sibling::div//a")
     WebElement btn_hiketaxdropdown;
     public WebElement getHikeTaxDropDown() {
         return btn_hiketaxdropdown;
     }



     /**
      * @author Vidhi Chapanera
      * @discription this locator is for hike tax dropdown
      * @date 30 April 2021
      */
     @FindBy(how = How.XPATH, using = "//label[contains(text(),'Hike tax for products')]//following-sibling::div//a//following-sibling::div//li//div[text()='GST']")
     WebElement btn_hiketaxdropdownop;
     public WebElement getHikeTaxDropDownValue() {
         return btn_hiketaxdropdownop;
     }


     /**
      * @author Vidhi Chapanera
      * @discription this locator is for hike custom line text box
      * @date 30 April 2021
      */
     @FindBy(how = How.ID, using = "hikecustomline")
     WebElement txt_hikecusomeline;
     public WebElement getHikeCustomLine() {
         return txt_hikecusomeline;
     }


     /**
      * @author Vidhi Chapanera
      * @discription this locator is for Select Hike register for payments check box
      * @date 30 April 2021
      */
     @FindBy(how = How.XPATH, using = "//label[@for='syncLoremIpsum']")
     WebElement chk_hikeregister;
     public WebElement getHikeRegister() {
         return chk_hikeregister;
     }


     /**
      * @author Vidhi Chapanera
      * @discription this locator is for Save Button
      * @date 30 April 2021
      */
     @FindBy(how = How.XPATH, using = "//form[@name='netoSettings']//div[@class='slider-modal-actions']//button[text()='Save']")
     WebElement btn_save;
     public WebElement getSaveButton() {
         return btn_save;
     }


     /**
      * @author Vidhi Chapanera
      * @discription this locator is for manage Button
      * @date 30 April 2021
      */
     @FindBy(how = How.XPATH, using = "//table//tr//td[contains(text(),'Neto')]//parent::tr//button[contains(text(),'Manage')]")
     WebElement btn_manage;
     public WebElement getManageButton() {
         return btn_manage;
     }


     /**
      * @author Vidhi Chapanera
      * @discription this locator is for sync process log
      * @date 29 April 2021
      */
     @FindBy(how = How.XPATH, using = "//table//tr//td[contains(text(),'Neto')]//parent::tr//a[contains(text(),'Sync process log')]")
     WebElement btn_syncprocesslog;
     public WebElement getSyncProcessLogButton() {
         return btn_syncprocesslog;
     }


     /**
      * @author Vidhi Chapanera
      * @discription this locator is for neto Products
      * @date 29 April 2021
      */
     @FindBy(how = How.XPATH, using = "//span[text()='Products']")
     WebElement btn_Products;
     public WebElement getNetoProducts() {
         return btn_Products;
     }


     /**
      * @author Vidhi Chapanera
      * @discription this locator is for neto view Products
      * @date 29 April 2021
      */
     @FindBy(how = How.XPATH, using = "//a[text()='View products']")
     WebElement btn_viewproducts;
     public WebElement getNetoViewProducts() {
         return btn_viewproducts;
     }


     /**
      * @author Vidhi Chapanera
      * @discription this locator is for neto product name searchbox
      * @date 29 April 2021
      */
     @FindBy(how = How.XPATH, using = "//label[text()='Product Name']//following-sibling::input")
     WebElement search_productname;
     public WebElement getNetoProductsNameSearch() {
         return search_productname;
     }


     /**
      * @author Vidhi Chapanera
      * @discription this locator is for neto Apply filters button
      * @date 29 April 2021
      */
     @FindBy(how = How.XPATH, using = "//button[contains(text(),'Apply filters')]")
     WebElement btn_applyfilter;
     public WebElement getAppliyFilterButton() {
         return btn_applyfilter;
     }


     /**
      * @author Vidhi Chapanera
      * @discription this locator is for neto customers
      * @date 30 April 2021
      */
     @FindBy(how = How.XPATH, using = "//span[text()='Customers']")
     WebElement btn_Customers;
     public WebElement getNetoCustomers() {
         return btn_Customers;
     }


     /**
      * @author Vidhi Chapanera
      * @discription this locator is for neto view customers
      * @date 30 April 2021
      */
     @FindBy(how = How.XPATH, using = "//a[contains(text(),'View customers')]")
     WebElement btn_viewcustomers;
     public WebElement getNetoViewCustomers() {
         return btn_viewcustomers;
     }


     /**
      * @author Vidhi Chapanera
      * @discription this locator is for neto username searchbox
      * @date 30 April 2021
      */
     @FindBy(how = How.XPATH, using = "//label[text()='Username, First or Last Name']//following-sibling::input")
     WebElement search_username;
     public WebElement getNetoUserNameLastAndFirstNameSearch() {
         return search_username;
     }


     /**
      * @author Vidhi Chapanera
      * @discription this locator is for neto customer Apply filters button
      * @date 30 April 2021
      */
     @FindBy(how = How.XPATH, using = "//div[@class='filter-sortby']//button[contains(text(),'Apply')]")
     WebElement btn_applyfiltercustomer;
     public WebElement getAppliyFilterCustomerButton() {
         return btn_applyfiltercustomer;
     }


     /**
      * @author Vidhi Chapanera
      * @discription this locator is for neto Products
      * @date 30 April 2021
      */
     @FindBy(how = How.XPATH, using = "//a[contains(text(),'Add new product')]")
     WebElement btn_Addnewproduct;
     public WebElement getAddNewProductButton() {
         return btn_Addnewproduct;
     }


     /**
      * @author Vidhi Chapanera
      * @discription this locator is for neto add Products input
      * @date 30 April 2021
      */
     @FindBy(how = How.NAME, using = "addname")
     WebElement txt_productnameadd;
     public WebElement getAddNewProductText() {
         return txt_productnameadd;
     }


     /**
      * @author Vidhi Chapanera
      * @discription this locator is for neto continue setup button
      * @date 30 April 2021
      */
     @FindBy(how = How.XPATH, using = "//input[@value='Continue setup']")
     WebElement btn_continuesetup;
     public WebElement getContinueSetup() {
         return btn_continuesetup;
     }


     /**
      * @author Vidhi Chapanera
      * @discription this locator is for neto continue Editing button
      * @date 30 April 2021
      */
     @FindBy(how = How.XPATH, using = "//span[text()='Continue Editing']")
     WebElement btn_continueEditing;
     public WebElement getContinueEditing() {
         return btn_continueEditing;
     }


     /**
      * @author Vidhi Chapanera
      * @discription this locator is for neto product save button
      * @date 29 April 2021
      */
     @FindBy(how = How.XPATH, using = "//button[normalize-space(.)='Save']")
     WebElement btn_productsave;
     public WebElement getProductSave() {
         return btn_productsave;
     }


     /**
      * @author Vidhi Chapanera
      * @discription this locator is for neto customer
      * @date 30 April 2021
      */
     @FindBy(how = How.XPATH, using = "//a[contains(text(),'Add new customer')]")
     WebElement btn_Addnewcustomer;
     public WebElement getAddNewCustomerButton() {
         return btn_Addnewcustomer;
     }


     /**
      * @author Vidhi Chapanera
      * @discription this locator is for neto customer Username
      * @date 30 April 2021
      */
     @FindBy(how = How.XPATH, using = "//label[contains(normalize-space(.),'Username')]//parent::div//input")
     WebElement btn_Username;
     public WebElement getUsernametextBox() {
         return btn_Username;
     }


     /**
      * @author Vidhi Chapanera
      * @discription this locator is for neto Sales orders
      * @date 3 May 2021
      */
     @FindBy(how = How.XPATH, using = "//span[text()='Sales orders']")
     WebElement btn_salesorders;
     public WebElement getNetoSalesOrdersButton() {
         return btn_salesorders;
     }


     /**
      * @author Vidhi Chapanera
      * @discription this locator is for neto view orders
      * @date 3 May 2021
      */
     @FindBy(how = How.XPATH, using = "//a[text()='View orders']")
     WebElement btn_vieworders;
     public WebElement getNetoVieworders() {
         return btn_vieworders;
     }


     /**
      * @author Vidhi Chapanera
      * @discription this locator is for neto Order ID searchbox
      * @date 3 May 2021
      */
    // @FindBy(how = How.XPATH, using = "//label[text()='Order ID']//following-sibling::input")
     @FindBy(how = How.XPATH, using = "//div[text()='Filter orders']//parent::div//parent::div[contains(@class,'control')]")
     WebElement search_OrderID;
     public WebElement getNetoOrderIDSearch() {
         return search_OrderID;
     }

      /**
       * @author Vidhi Chapanera
       * @discription this locator is for neto hold and edit order button
       * @date 3 May 2021
       */
      @FindBy(how = How.XPATH, using = "//div[@id='orderActions']//a[normalize-space(.)='Hold or Edit Order']")
      WebElement btn_HoldOrder;
      public WebElement getHoldAndEditOrderButton() {
        return btn_HoldOrder;
      }

     /**
      * @author Vidhi Chapanera
      * @discription this locator is for neto Cancel button
      * @date 3 May 2021
      */
     @FindBy(how = How.XPATH, using = "//a[normalize-space(.)='Cancel']")
     WebElement btn_cancel;
     public WebElement getCancelButton() {
      return btn_cancel;
     }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for neto Delete button
     * @date 3 May 2021
     */
    @FindBy(how = How.XPATH, using = "//a[normalize-space(.)='Delete']")
    WebElement btn_delete;
    public WebElement getDeleteButton1() {
     return btn_delete;
    }


     /**
      * @author Vidhi Chapanera
      * @discription this locator is for neto customer Apply filters button
      * @date 3 May 2021
      */
     @FindBy(how = How.XPATH, using = "//td//button[contains(text(),'Apply')]")
     WebElement btn_applyfiltersale;
     public WebElement getAppliyFilterSaleButton() {
         return btn_applyfiltersale;
     }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for neto more action button
     * @date 3 May 2021
     */
    @FindBy(how = How.ID, using = "more")
    WebElement btn_moreaction;
    public WebElement getMoreAction() {
     return btn_moreaction;
    }

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for neto delete order button
     * @date 3 May 2021
     */
    @FindBy(how = How.XPATH, using = "//button[text()='Delete orders']")
    WebElement btn_deleteorders;
    public WebElement getDeleteOrderButton() {
     return btn_deleteorders;
    }


     /**
      * @author Vidhi Chapanera
      * @discription this locator is for neto delete selected order button
      * @date 3 May 2021
      */
     @FindBy(how = How.XPATH, using = "//a[normalize-space(.)='Delete Selected Orders']")
     WebElement btn_deleteselectedorders;
     public WebElement getDeleteSelectedOrder() {
      return btn_deleteselectedorders;
     }


     /**
      * @author Vidhi Chapanera
      * @discription this locator is for neto order
      * @date 30 April 2021
      */
     @FindBy(how = How.XPATH, using = "//a[text()='Add order' and contains(@class,'success')]")
     //@FindBy(how = How.XPATH, using = "//a[contains(text(),'Add new order')]")
     WebElement btn_Addneworder;
     public WebElement getAddNeOrderButton() {
         return btn_Addneworder;
     }


     /**
      * @author Vidhi Chapanera
      * @discription this locator is for neto order customer search box
      * @date 30 April 2021
      */
     @FindBy(how = How.XPATH, using = "//button[contains(normalize-space(.),'Create new customer')]//parent::td//parent::tr//input")
     WebElement txt_customerordersearch;
     public WebElement getAddNeOrderCustomerSearch() {
         return txt_customerordersearch;
     }


     /**
      * @author Vidhi Chapanera
      * @discription this locator is for neto Calculate shipping button
      * @date 30 April 2021
      */
     @FindBy(how = How.XPATH, using = "//a[contains(normalize-space(.),'Calculate shipping')]")
     WebElement btn_Calculateshipping;
     public WebElement getCalculateShipping() {
         return btn_Calculateshipping;
     }



     /**
      * @author Vidhi Chapanera
      * @discription this locator is for neto Save as New Order button
      * @date 30 April 2021
      */
     @FindBy(how = How.XPATH, using = "//a[contains(normalize-space(.),'Save as New Order')]")
     WebElement btn_SaveasNewOrder;
     public WebElement getSaveasNewOrder() {
         return btn_SaveasNewOrder;
     }


     /**
      * @author Vidhi Chapanera
      * @discription this locator is for neto Approve button
      * @date 30 April 2021
      */
     @FindBy(how = How.XPATH, using = "//a[text()='Approve']")
     WebElement btn_Approve;
     public WebElement getApproveButton() {
         return btn_Approve;
     }


     /**
      * @author Vidhi Chapanera
      * @discription this locator is for neto make payment button
      * @date 30 April 2021
      */
     @FindBy(how = How.CSS, using = "a#proc_payment")
     WebElement btn_makepayment;
     public WebElement getMakepPaymentButton() {
         return btn_makepayment;
     }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for neto select all checkbox for product
     * @date 4 May 2021
     */
    @FindBy(how = How.XPATH, using = "//i[@class='icon-check']//parent::a")
    WebElement chk_selectallprodutct;
    public WebElement getSelectAllCheckboxForProduct() {
     return chk_selectallprodutct;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for neto select all btn
     * @date 4 May 2021
     */
    @FindBy(how = How.XPATH, using = "//i[@class='icon-check']//parent::a//following-sibling::ul//li//a[text()='Select all']")
    WebElement btn_selectall;
    public WebElement getSelectAllButton() {
     return btn_selectall;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for neto delete btn
     * @date 4 May 2021
     */
    @FindBy(how = How.XPATH, using = "//a[normalize-space(.)='Delete']")
    WebElement btn_delete1;
    public WebElement getDeleteButton() {
     return btn_delete1;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for neto bulk delete selected btn
     * @date 4 May 2021
     */
    @FindBy(how = How.XPATH, using = "//a[normalize-space(.)='Bulk delete selected']")
    WebElement btn_bulkDeleteSelected;
    public WebElement getBulkDeleteSelectedButton() {
     return btn_bulkDeleteSelected;
    }


   /**
    * @author Vidhi Chapanera
    * @discription this locator is for neto login button
    * @date 20 July 2021
    */
   @FindBy(how = How.XPATH, using = "//button[normalize-space(.)='Log in']")
   WebElement btn_lognin;
   public WebElement getLogiButton() {
    return btn_lognin;
   }



      /**
      * @author Vidhi Chapanera
      * @date 29 April 2021
      * @discription this method is use to create hike store for Neto
      * @return
      */
     /*@Step("create hike store for Neto")
     public boolean createHikeStoreForNeto(){
         CenterlizePO centerlizePO = PageFactory.initElements(driver,CenterlizePO.class);
         try{
             sleepFor(5);
             String fileLocation =System.getProperty("user.dir")+"\\src\\main\\resources\\createStore.properties";
             Properties properties1 = new Properties();
             properties1.load(new FileReader(fileLocation));
             centerlizePO.clickOnButton(PageFactory.initElements(driver, CreateStore.class).getStartFreeTrialLink());
             PageFactory.initElements(driver, CreateStore.class).renameFileData
                     (PageFactory.initElements(driver, CreateStore.class).getFirstNameTextBox()
                             ,"\\src\\main\\java\\IntegrationsPO\\NetoPO\\File\\FirstName");
             PageFactory.initElements(driver, CreateStore.class).renameFileData
                     (PageFactory.initElements(driver, CreateStore.class).getLastNameTextBox()
                             ,"\\src\\main\\java\\IntegrationsPO\\NetoPO\\File\\LastName");
             centerlizePO.enterDataUsingSendkeys(PageFactory.initElements(driver, CreateStore.class).getEmailTextBox(), StoreConstant.EMAIL);
             centerlizePO.enterDataUsingSendkeys(PageFactory.initElements(driver, CreateStore.class).getPhoneTextBox(), StoreConstant.PHONE);
             centerlizePO.clearText(PageFactory.initElements(driver, CreateStore.class).getCityTextBox());
             centerlizePO.enterDataUsingSendkeys(PageFactory.initElements(driver, CreateStore.class).getCityTextBox(),StoreConstant.CITY);
             centerlizePO.enterDataUsingSendkeys(PageFactory.initElements(driver, CreateStore.class).getPasswordTextBox(),String.valueOf(properties1.put(StoreConstant.PASSWORD,"password")));
             centerlizePO.clickOnButton(PageFactory.initElements(driver, CreateStore.class).getContinueButton());
             PageFactory.initElements(driver, CreateStore.class).renameFileData
                     (PageFactory.initElements(driver, CreateStore.class).getAccountAddressTextBox()
                             ,"\\src\\main\\java\\IntegrationsPO\\NetoPO\\File\\AccountAddress");
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
     }
*/


      /**
       * @author Vidhi Chapanera
       * @date 13 May 2021
       * @discription this method is use to click on activate button on Neto
       * @return
       */
      @Step("create hike store for BigCommerce")
      public boolean createHikeStoreForNeto(){
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
                          ,"\\src\\main\\java\\IntegrationsPO\\NetoPO\\File\\AccountAddress");
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
      * @date 29 April 2021
      * @discription this method is use to click on activate button on Neto
      * @return
      */
     @Step("click on activate button on Neto")
     public boolean clickOnActivateButtonOnNeto(){
         CenterlizePO centerlizePO = PageFactory.initElements(driver,CenterlizePO.class);
         try{
             sleepFor(5);
             PageFactory.initElements(driver, StoreSetup.class).clickOnStoreSetupButton();
             centerlizePO.clickOnButton(PageFactory.initElements(driver, Integrations.class).getIntegrationsButton());
             sleepFor(3);
             centerlizePO.clickOnButton(getNetoctivate());
             sleepFor(5);
             return true;
         }catch (Exception e){
             System.out.println(e.getMessage());
             return false;
         }
     }


     /**
      * @author Vidhi Chapanera
      * @date 29 April 2021
      * @discription this method is use to create neto store
      * @return
      */
     @Step("create neto store")
     public boolean createNetoStore() throws IOException {
         CenterlizePO centerlizePO = PageFactory.initElements(driver,CenterlizePO.class);
         String fileLocation =System.getProperty("user.dir")+"\\src\\main\\resources\\createStore.properties";
         Properties properties1 = new Properties();
         properties1.load(new FileReader(fileLocation));
         String fileLocation1 =System.getProperty("user.dir")+"\\src\\main\\resources\\Neto.properties";
         Properties properties2 = new Properties();
         properties2.load(new FileReader(fileLocation1));
         try{
             sleepFor(1);
             JavascriptExecutor jse = (JavascriptExecutor)driver;
             jse.executeScript("window.open()");
             ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
             driver.switchTo().window(tabs.get(1));
             sleepFor(1);
             driver.get("https://www.netohq.com/free-trial");
             /*centerlizePO.clickOnButton(getNetoFreeTrial());*/
             PageFactory.initElements(driver, Shopify.class).renameFileData(getEmailText(),"\\src\\main\\java\\IntegrationsPO\\NetoPO\\File\\NetoStore");
             centerlizePO.enterDataUsingSendkeys( getEmailText(),"@yahoo.com" );
             centerlizePO.enterDataUsingSendkeys( getStoreName(),PageFactory.initElements(driver, Xero.class).getValue("\\src\\main\\java\\IntegrationsPO\\NetoPO\\File\\NetoStore"));
             centerlizePO.enterDataUsingSendkeys(getUserName(),String.valueOf(properties2.put(NetoConstant.NETO_USERNAME,"neto.username")));
             centerlizePO.enterDataUsingSendkeys(getPhone(),"0444222333");
             centerlizePO.clickOnButton(getStarted());
             sleepFor( 10);
             while (true){
                if (getGoToMyStore().isDisplayed()){
                    centerlizePO.clickOnButton(getGoToMyStore());
                    break;
                }
             }
             centerlizePO.enterDataUsingSendkeys(getContactPerson(),"Vidhi41");
             centerlizePO.enterDataUsingSendkeys(getPassword(),String.valueOf(properties2.put(NetoConstant.NETO_PASSWORD,"neto.password")));
             centerlizePO.enterDataUsingSendkeys(getConfirmPassword(),String.valueOf(properties2.put(NetoConstant.NETO_CPASSWORD,"neto.cpassword")));
             centerlizePO.enterDataUsingSendkeys(getAdresss(),"26 Tent St");
             centerlizePO.enterDataUsingSendkeys(getPostalCode(),"2747");
             sleepFor( 5);
             WebElement suburbcity = new WebDriverWait(driver, 60).ignoring( StaleElementReferenceException.class).
                     until(ExpectedConditions.presenceOfElementLocated
                             (By.xpath("//form[@id='popupForm']//label//span[text()='Suburb / City']//parent::label//parent::div//select")));
             Select select3 = new Select(suburbcity);
             select3.selectByIndex(6);
             WebElement yourself = new WebDriverWait(driver, 60).ignoring( StaleElementReferenceException.class).
                     until(ExpectedConditions.presenceOfElementLocated
                             (By.xpath("//form[@id='popupForm']//label//span[text()='Describe yourself']//parent::label//parent::div//select")));
             Select select = new Select(yourself);
             select.selectByIndex(1);
             WebElement revenue = new WebDriverWait(driver, 60).ignoring( StaleElementReferenceException.class).
                     until(ExpectedConditions.presenceOfElementLocated
                             (By.xpath("//form[@id='popupForm']//label//span[text()='Current annual revenue']//parent::label//parent::div//select")));
             Select select1 = new Select(revenue);
             select1.selectByIndex(1);
             WebElement industry = new WebDriverWait(driver, 60).ignoring( StaleElementReferenceException.class).
                     until(ExpectedConditions.presenceOfElementLocated
                             (By.xpath("//form[@id='popupForm']//label//span[text()='Industry Vertical']//parent::label//parent::div//select")));
             Select select2 = new Select(industry);
             select2.selectByIndex(2);
             centerlizePO.clickOnButton(getStartUsingNetoButton());
             sleepFor(50);
             currentURL = driver.getCurrentUrl();
             System.out.println(currentURL);
             sleepFor(3);
             deleteProduct();
             return true;
         }catch (Exception e){
             System.out.println(e.getMessage());
             return false;
         }
     }

     /**
      * @author Vidhi Chapanera
      * @date 29 April 2021
      * @discription this method is use to connect your neto store to hike up
      * @return
      */
     @Step("connect your neto store to hike up")
     public boolean connectYourNetotoHike() throws IOException {
         CenterlizePO centerlizePO = PageFactory.initElements(driver,CenterlizePO.class);
         String fileLocation =System.getProperty("user.dir")+"\\src\\main\\resources\\Neto.properties";
         Properties properties1 = new Properties();
         properties1.load(new FileReader(fileLocation));
         try{
             ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
             driver.switchTo().window(tabs.get(0));
             sleepFor(1);
             centerlizePO.enterDataUsingSendkeys(getNetoShopURL(),currentURL.split("//")[1].split("/")[0]);
             centerlizePO.clickOnButton(PageFactory.initElements(driver,Shopify.class).getConnectButton());
             centerlizePO.enterDataUsingSendkeys(getNetoShopURL1(),currentURL.split("//")[1].split("/")[0]);
             centerlizePO.enterDataUsingSendkeys(getNetoStoreUsername(),String.valueOf(properties1.put( NetoConstant.NETO_USERNAME,"neto.username")));
             centerlizePO.enterDataUsingSendkeys(getNetoStorePassword(),String.valueOf(properties1.put( NetoConstant.NETO_PASSWORD,"neto.password")));
             centerlizePO.clickOnButton(getNetoLoginButton());
             sleepFor(30);
             return true;
         }catch (Exception e){
             System.out.println(e.getMessage());
             return false;
         }
     }


     /**
      * @author Vidhi Chapanera
      * @date 30 April 2021
      * @discription this method is use to mapping Neto
      * @return
      */
     @Step("mapping shopify")
     public boolean mappingNeto() throws IOException {
         CenterlizePO centerlizePO = PageFactory.initElements(driver,CenterlizePO.class);
         Actions actions = new Actions(driver);
         try{
             sleepFor(5);
             centerlizePO.clickOnButton(getHikeTaxDropDown());
             centerlizePO.clickOnButton(getHikeTaxDropDownValue());
             centerlizePO.enterDataUsingSendkeys(getHikeCustomLine(),"1");
             centerlizePO.clickOnButton(getHikeRegister());
             List<WebElement> list = new WebDriverWait(driver,60).
                     until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                             By.xpath("//span[text()='Neto Location']//parent::a")));
             centerlizePO.clickOnButton(list.get(list.size()-1));
             WebElement option = new WebDriverWait(driver, 60).ignoring(StaleElementReferenceException.class).
                     until(ExpectedConditions.presenceOfElementLocated
                             (By.xpath("//span[text()='Neto Location']//parent::a//following-sibling::div//li//div//div[1]")));
                            // (By.xpath("//div[contains(text(),'" + PageFactory.initElements(driver,Xero.class).getValue("\\src\\main\\java\\IntegrationsPO\\NetoPO\\File\\NetoStore") + "')]")));
             centerlizePO.clickOnButton(option);

             /**
              * @Payment-Mapping
              */
             List<WebElement> paymentmapping = new WebDriverWait(driver,60).
                     until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                             By.xpath("//span[text()='Payment mapping']//parent::div//parent::div//parent::div//a")));
             centerlizePO.clickOnButton(paymentmapping.get(0));
             WebElement paymentmapping0 = new WebDriverWait(driver, 60).ignoring(StaleElementReferenceException.class).
                     until(ExpectedConditions.presenceOfElementLocated
                             (By.xpath("//span[text()='Payment mapping']//parent::div//parent::div//parent::div//a//following-sibling::div//li//div[text()='Account Credit']")));
             centerlizePO.clickOnButton(paymentmapping0);

             centerlizePO.clickOnButton(paymentmapping.get(1));
             WebElement paymentmapping1 = new WebDriverWait(driver, 60).ignoring(StaleElementReferenceException.class).
                     until(ExpectedConditions.presenceOfElementLocated
                             (By.xpath("//span[text()='Payment mapping']//parent::div//parent::div//parent::div//a//following-sibling::div//li//div[text()='PayPal Express']")));
             centerlizePO.clickOnButton(paymentmapping1);

             centerlizePO.clickOnButton(paymentmapping.get(2));
             WebElement paymentmapping2 = new WebDriverWait(driver, 60).ignoring(StaleElementReferenceException.class).
                     until(ExpectedConditions.presenceOfElementLocated
                             (By.xpath("//span[text()='Payment mapping']//parent::div//parent::div//parent::div//a//following-sibling::div//li//div[text()='Account Credit']")));
             centerlizePO.clickOnButton(paymentmapping2);

             /**
              * @Sync-Setting
              */
             actions.sendKeys(Keys.PAGE_DOWN).build().perform();
             List<WebElement> syncsetting = new WebDriverWait(driver,60).
                     until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                             By.xpath("//span[text()='Sync settings']//parent::div//parent::div//following-sibling::div//div[@class='md-checkbox-list']//label")));
             for(int i=0;i<syncsetting.size();i++){
                 sleepFor(1);
                 syncsetting.get(i).click();
             }

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

             centerlizePO.clickOnButton(PageFactory.initElements(driver, QuickBooks.class).getContinueButton());
             sleepFor(7);
             centerlizePO.clickOnButton(PageFactory.initElements(driver, QuickBooks.class).getSaveAndSyncButton());
             sleepFor(10);
             if(getManageButton().isDisplayed()){
                 centerlizePO.clickOnButton(getManageButton());
                 sleepFor(1);
                 actions.moveToElement(PageFactory.initElements(driver,Shopify.class).getManualSyncButton()).build().perform();
                 JavascriptExecutor jse = (JavascriptExecutor)driver;
                 jse.executeScript("arguments[0].click();",PageFactory.initElements(driver,Shopify.class).getManualSyncButton());
                 sleepFor(4);
                 String[] strArray2 = new String[]{"syncProducts", "syncCustomers", "syncSales"};
                 for (String s : strArray2) {
                     WebElement element = new WebDriverWait(driver, 60).ignoring(StaleElementReferenceException.class).
                             until(ExpectedConditions.presenceOfElementLocated
                                     (By.xpath("//label[@for='" + s + "']")));
                     element.click();
                 }
                 sleepFor(1);
                 centerlizePO.clickOnButton(PageFactory.initElements(driver,Shopify.class).getButtonSyncNow());
                 sleepFor(2);
                 centerlizePO.clickOnButton(getSaveButton());
                 sleepFor(10);
                 centerlizePO.clickOnButton(getSyncProcessLogButton());
                 sleepFor(3);
                 centerlizePO.clickOnButton(PageFactory.initElements(driver,Shopify.class).getShowErrorsOnly());
                 sleepFor(4);
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
      * @date 30 April 2021
      * @discription this method is use to create Product Hike to Neto and verify in Neto
      * @return
      */
     @Step("create Product Hike to Neto and verify in Neto")
     public boolean createProductHiketoNeto() throws IOException {
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
             PageFactory.initElements(driver,Shopify.class).renameFileData(products1.getProductName(),"\\src\\main\\java\\IntegrationsPO\\NetoPO\\File\\HProduct");
             centerlizePO.clickOnButton(PageFactory.initElements(driver, Shopify.class).getEcommerceCheckbox());
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
             cost.get(5).click();
             centerlizePO.enterDataUsingSendkeys(cost.get(5),Keys.CONTROL+ "a");
             centerlizePO.enterDataUsingSendkeys(cost.get(5), String.valueOf(Keys.DELETE));
             cost.get(5).sendKeys("150");
             centerlizePO.clickOnButton(products1.getProductSaveButton());
             sleepFor(5);
             centerlizePO.enterDataUsingSendkeys(PageFactory.initElements(driver, Products.class).getSearchBox(),PageFactory.initElements(driver,Xero.class).getValue("\\src\\main\\java\\IntegrationsPO\\NetoPO\\File\\HProduct"));
             sleepFor(3);
             List<WebElement> list1 = new WebDriverWait(driver,120).
                     until(ExpectedConditions.presenceOfAllElementsLocatedBy
                             (By.xpath("//ul[contains(@class,'hike-width-block')]//b[text()='Product']//parent::ul//li//a")));
             list1.get(0).click();
             driver.navigate().refresh();
             sleepFor(3);
             WebElement name = new WebDriverWait(driver,60).
                     until(ExpectedConditions.presenceOfElementLocated
                             (By.xpath("//table[@id='RosterDataTable']//tbody//tr//td[2]//span[text()='" + PageFactory.initElements(driver,Xero.class).getValue("\\src\\main\\java\\IntegrationsPO\\NetoPO\\File\\HProduct") + "']//parent::td//following-sibling::td//a")));
             name.click();
             sleepFor(5);
             while(true){
                 sleepFor(5);
                 centerlizePO.clickOnButton(PageFactory.initElements(driver,Shopify.class).getRefreshLogButton());
                 sleepFor(5);
                 if (driver.findElement(By.xpath("//td[text()='Hike - Neto']//following-sibling::td[1][text()='Created']")).isDisplayed())
                     break;
             }
             sleepFor(2);
             actions.sendKeys(Keys.ESCAPE).build().perform();
             sleepFor(3);
             ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
             driver.switchTo().window(tabs.get(1));
             sleepFor(2);
             actions.moveToElement(getNetoProducts()).build().perform();
             sleepFor(1);
             actions.moveToElement(getNetoViewProducts()).click().build().perform();
             centerlizePO.enterDataUsingSendkeys(getNetoProductsNameSearch(),PageFactory.initElements(driver,Xero.class).getValue("\\src\\main\\java\\IntegrationsPO\\NetoPO\\File\\HProduct"));
             centerlizePO.clickOnButton(getAppliyFilterButton());
             sleepFor(7);
             if (driver.findElement(By.xpath("//div[text()='"+PageFactory.initElements(driver,Xero.class).getValue("\\src\\main\\java\\IntegrationsPO\\NetoPO\\File\\HProduct")+"']")).isDisplayed())
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
      * @date 30 April 2021
      * @discription this method is use to create Customers Hike to Neto and verify in Neto
      * @return
      */
     @Step("create Customers Hike to Neto and verify in Neto")
     public boolean createCustomersHiketoNeto() throws IOException {
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
             PageFactory.initElements(driver, QuickBooks.class).renameCustomerName(PageFactory.initElements(driver, CustomersPO.CustomersPO.Customers.class).getFirstName(),"\\src\\main\\java\\IntegrationsPO\\NetoPO\\File\\HCustomer");
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
                             (By.xpath("//table[@id='CustomersTable']//tbody//tr//td[2]//span[contains(text(),'"+PageFactory.initElements(driver, Xero.class).getValue("\\src\\main\\java\\IntegrationsPO\\NetoPO\\File\\HCustomer")+"')]//parent::td//following-sibling::td//a")));
             name.click();
             while(true){
                 sleepFor(5);
                 centerlizePO.clickOnButton(PageFactory.initElements(driver,Shopify.class).getRefreshLogButton());
                 sleepFor(5);
                 if (driver.findElement(By.xpath("//td[text()='Hike - Neto']//following-sibling::td[1][text()='Created']")).isDisplayed())
                     break;
             }
             sleepFor(2);
             actions.sendKeys(Keys.ESCAPE).build().perform();
             sleepFor(3);
             ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
             driver.switchTo().window(tabs.get(1));
             actions.moveToElement(getNetoCustomers()).build().perform();
             sleepFor(1);
             actions.moveToElement(getNetoViewCustomers()).click().build().perform();
             centerlizePO.enterDataUsingSendkeys(getNetoUserNameLastAndFirstNameSearch(),PageFactory.initElements(driver,Xero.class).getValue("\\src\\main\\java\\IntegrationsPO\\NetoPO\\File\\HCustomer"));
             centerlizePO.clickOnButton(getAppliyFilterCustomerButton());
             sleepFor(7);
             if (driver.findElement(By.xpath("//td[contains(text(),'Name:')]//following-sibling::td[contains(text(),'"+PageFactory.initElements(driver,Xero.class).getValue("\\src\\main\\java\\IntegrationsPO\\NetoPO\\File\\HCustomer")+"')]")).isDisplayed())
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
      * @date 30 April 2021
      * @discription this method is use to create Product Neto to hike and verify in Hike
      * @return
      */
     @Step("create Product Neto to hike and verify in Hike")
     public boolean createProductNetotoHike() throws IOException {
         CenterlizePO centerlizePO = PageFactory.initElements(driver, CenterlizePO.class);
         ProductsPO.ProductsPO.Products products1 = PageFactory.initElements(driver, ProductsPO.ProductsPO.Products.class);
         Actions actions = new Actions(driver);
         try{
             sleepFor(3);
             ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
             driver.switchTo().window(tabs.get(1));
             /*sleepFor(2);
             actions.moveToElement(getNetoProducts()).build().perform();
             sleepFor(1);
             actions.moveToElement(getNetoViewProducts()).click().build().perform();*/
             centerlizePO.clickOnButton(getAddNewProductButton());
             WebElement regularP = new WebDriverWait(driver,60).
                     until(ExpectedConditions.presenceOfElementLocated
                             (By.xpath("//label[contains(normalize-space(.),'Regular Product')]")));
             centerlizePO.clickOnButton(regularP);
             WebElement active = new WebDriverWait(driver,60).
                     until(ExpectedConditions.presenceOfElementLocated
                             (By.xpath("//label[contains(normalize-space(.),'Active')]")));
             centerlizePO.clickOnButton(active);
             PageFactory.initElements(driver,Shopify.class).renameFileData(getAddNewProductText(),"\\src\\main\\java\\IntegrationsPO\\NetoPO\\File\\NProduct");
             try{
                sleepFor(5);
                WebElement frame = new WebDriverWait(driver,60).
                      until(ExpectedConditions.presenceOfElementLocated
                              (By.xpath("//iframe[@class='drift-frame-controller']")));
                driver.switchTo().frame(frame);
                if(driver.findElement( By.xpath("//button[contains(@class,'close')]")).isDisplayed()){
                    driver.findElement(By.xpath("//button[contains(@class,'close')]")).click();
                }
                driver.switchTo().defaultContent();
             }catch (Exception e){
                System.out.println("catch");
             }
             centerlizePO.clickOnButton(getContinueSetup());
             centerlizePO.clickOnButton(getContinueEditing());
             centerlizePO.clickOnButton(getProductSave());
             sleepFor( 7);
             driver.switchTo().window(tabs.get(0));
             PageFactory.initElements(driver, Reporting.class).clickOnReportingButton();
             PageFactory.initElements(driver, StoreSetup.class).clickOnStoreSetupButton();
             centerlizePO.clickOnButton(PageFactory.initElements(driver, Integrations.class).getIntegrationsButton());
             centerlizePO.clickOnButton(getManageButton());
             actions.moveToElement(PageFactory.initElements(driver,Shopify.class).getManualSyncButton()).build().perform();
             JavascriptExecutor jse = (JavascriptExecutor)driver;
             jse.executeScript("arguments[0].click();",PageFactory.initElements(driver,Shopify.class).getManualSyncButton());
             sleepFor(4);
             String[] strArray2 = new String[]{"syncProducts"};
             for (String s : strArray2) {
                 WebElement element = new WebDriverWait(driver, 60).ignoring(StaleElementReferenceException.class).
                         until(ExpectedConditions.presenceOfElementLocated
                                 (By.xpath("//label[@for='" + s + "']")));
                 element.click();
             }
             sleepFor(1);
             centerlizePO.clickOnButton(PageFactory.initElements(driver,Shopify.class).getButtonSyncNow());
             sleepFor(2);
             centerlizePO.clickOnButton(getSaveButton());
             sleepFor(10);
             PageFactory.initElements(driver,Inventory.class).clickOnInventoryButton();
             PageFactory.initElements(driver, ProductsPO.Products.class).clickOnProductsButtonn();
             sleepFor(2);
             centerlizePO.clickOnButton(products1.getProductButton());
             sleepFor(3);
             centerlizePO.enterDataUsingSendkeys(products1.getSearchBox(), PageFactory.initElements(driver,Xero.class).getValue("\\src\\main\\java\\IntegrationsPO\\NetoPO\\File\\NProduct"));
             sleepFor(1);
             sleepFor(3);
             List<WebElement> list1 = new WebDriverWait(driver,120).
                     until(ExpectedConditions.presenceOfAllElementsLocatedBy
                             (By.xpath("//ul[contains(@class,'hike-width-block')]//b[text()='Product']//parent::ul//li//a")));
             list1.get(0).click();
             sleepFor(3);
             WebElement name = new WebDriverWait(driver,60).
                     until(ExpectedConditions.presenceOfElementLocated
                             (By.xpath("//table[@id='RosterDataTable']//tbody//tr//td[2]//span[text()='" + PageFactory.initElements(driver,Xero.class).getValue("\\src\\main\\java\\IntegrationsPO\\NetoPO\\File\\NProduct") + "']//parent::td//following-sibling::td//a")));
             name.click();
             while(true){
                 sleepFor(5);
                 centerlizePO.clickOnButton(PageFactory.initElements(driver,Shopify.class).getRefreshLogButton());
                 sleepFor(5);
                 if (driver.findElement(By.xpath("//td[text()='Neto - Hike']//following-sibling::td[1][text()='Created']")).isDisplayed())
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
      * @date 30 April 2021
      * @discription this method is use to create Customer Neto to hike and verify in Hike
      * @return
      */
     @Step("create Customer Neto to hike and verify in Hike")
     public boolean createCustomersNetotoHike() throws IOException {
         CenterlizePO centerlizePO = PageFactory.initElements(driver, CenterlizePO.class);
         Actions actions = new Actions(driver);
         try{
             sleepFor(5);
             ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
             driver.switchTo().window(tabs.get(1));
            /* actions.moveToElement(getNetoCustomers()).build().perform();
             sleepFor(1);
             actions.moveToElement(getNetoViewCustomers()).click().build().perform();*/
             centerlizePO.clickOnButton(getAddNewCustomerButton());
             PageFactory.initElements(driver, QuickBooks.class).renameCustomerName(getUsernametextBox(),"\\src\\main\\java\\IntegrationsPO\\NetoPO\\File\\NCustomer");
             centerlizePO.clickOnButton(getProductSave());
             sleepFor( 7);
             driver.switchTo().window(tabs.get(0));
             PageFactory.initElements(driver, Users.class).clickOnUsersButton();
             PageFactory.initElements(driver, StoreSetup.class).clickOnStoreSetupButton();
             centerlizePO.clickOnButton(PageFactory.initElements(driver, Integrations.class).getIntegrationsButton());
             centerlizePO.clickOnButton(getManageButton());
             actions.moveToElement(PageFactory.initElements(driver,Shopify.class).getManualSyncButton()).build().perform();
             JavascriptExecutor jse = (JavascriptExecutor)driver;
             jse.executeScript("arguments[0].click();",PageFactory.initElements(driver,Shopify.class).getManualSyncButton());
             sleepFor(4);
             String[] strArray2 = new String[]{"syncCustomers"};
             for (String s : strArray2) {
                 WebElement element = new WebDriverWait(driver, 60).ignoring(StaleElementReferenceException.class).
                         until(ExpectedConditions.presenceOfElementLocated
                                 (By.xpath("//label[@for='" + s + "']")));
                 element.click();
             }
             sleepFor(1);
             centerlizePO.clickOnButton(PageFactory.initElements(driver,Shopify.class).getButtonSyncNow());
             sleepFor(2);
             centerlizePO.clickOnButton(getSaveButton());
             sleepFor(10);
             PageFactory.initElements(driver, CustomersPO.Customers.class).clickOnCustomersButton();
             sleepFor(2);
             centerlizePO.clickOnButton(PageFactory.initElements(driver, CustomersPO.CustomersPO.Customers.class).getCustomersButton());
             sleepFor(1);
             WebElement name = new WebDriverWait(driver,60).
                     until(ExpectedConditions.presenceOfElementLocated
                             (By.xpath("//table[@id='CustomersTable']//tbody//tr//td[2]//span[contains(text(),'"+PageFactory.initElements(driver, Xero.class).getValue("\\src\\main\\java\\IntegrationsPO\\NetoPO\\File\\NCustomer")+"')]//parent::td//following-sibling::td//a")));
             name.click();
             while(true){
                 sleepFor(5);
                 centerlizePO.clickOnButton(PageFactory.initElements(driver,Shopify.class).getRefreshLogButton());
                 sleepFor(5);
                 if (driver.findElement(By.xpath("//td[text()='Neto - Hike']//following-sibling::td[1][text()='Created']")).isDisplayed())
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
      * @date 03 May 2021
      * @discription this method is use to create Sale Hike to Neto and verify in Neto
      * @return
      */
     @Step("create Sale Hike to Neto and verify in Neto")
     public boolean createSaleHiketoNeto() throws IOException {
         CenterlizePO centerlizePO = PageFactory.initElements(driver, CenterlizePO.class);
         Actions actions = new Actions(driver);
         try{
             sleepFor(5);
             ArrayList<String> tabs1 = new ArrayList<String> (driver.getWindowHandles());
             driver.switchTo().window(tabs1.get(1));
             driver.close();
             sleepFor(1);
             ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
             driver.switchTo().window(tabs.get(0));
             sleepFor(2);
             PageFactory.initElements(driver, Inventory.class).clickOnInventoryButton();
             PageFactory.initElements(driver, PointofSale.class).clickOnPointOfSaleButtonn();
             centerlizePO.clickOnButton(PageFactory.initElements(driver, ProcessSale.class).getProcessSaleButton());
             sleepFor(20);
             centerlizePO.clickOnButton(PageFactory.initElements(driver, CashRegister.class).getOpenRegisterButton());
             sleepFor(2);
             centerlizePO.clickOnButton(PageFactory.initElements(driver, CashRegister.class).getOpenButton());
             sleepFor(3);
             PageFactory.initElements(driver, ProcessSale.class).getSearchBar().sendKeys(PageFactory.initElements(driver,Xero.class).getValue("\\src\\main\\java\\IntegrationsPO\\NetoPO\\File\\HProduct"));
             sleepFor(2);
             actions.sendKeys(Keys.TAB).build().perform();
             sleepFor(1);
             centerlizePO.clickOnButton(PageFactory.initElements(driver, ProcessSale.class).getPayButton());
             sleepFor(3);
             centerlizePO.clickOnButton(PageFactory.initElements(driver, ProcessSale.class).getCashButton());
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
             centerlizePO.clickOnButton(PageFactory.initElements(driver, SalesHistory.class).getSalesHistoryButton());
             sleepFor(5);
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
                 sleepFor(5);
                 centerlizePO.clickOnButton(PageFactory.initElements(driver,Shopify.class).getRefreshLogButton());
                 sleepFor(5);
                 if (driver.findElement(By.xpath("//td[text()='Hike - Neto']")).isDisplayed())
                     break;
             }
             sleepFor(2);
             actions.sendKeys(Keys.ESCAPE).build().perform();
             sleepFor(3);
             JavascriptExecutor jse = (JavascriptExecutor)driver;
             jse.executeScript("window.open()");
             sleepFor(3);
             ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
             driver.switchTo().window(tabs2.get(1));
             sleepFor(5);
             driver.get(currentURL);
             sleepFor(15);
             actions.moveToElement(getNetoSalesOrdersButton()).build().perform();
             sleepFor(1);
             actions.moveToElement(getNetoVieworders()).click().build().perform();
             sleepFor(10);
             /*centerlizePO.clickOnButton(getNetoOrderIDSearch());
             sleepFor(3);
             actions.moveToElement(driver.findElement(By.xpath("//span[@data-test-id='Product Name:']"))).click().build().perform();
             Thread.sleep(3);
             driver.findElement(By.xpath("//input[@value='Product Name:']")).sendKeys(PageFactory.initElements(driver,Xero.class).getValue("\\src\\main\\java\\IntegrationsPO\\NetoPO\\File\\HProduct"));
             Thread.sleep(5);
             driver.findElement(By.xpath("//div[contains(@class,'bg-secondary')]//following-sibling::div")).click();
             Thread.sleep(5);
             sleepFor(2);*/
             WebElement item01 = new WebDriverWait(driver,60).
                     until(ExpectedConditions.presenceOfElementLocated
                             (By.xpath("//a[text()='"+saleRef+"']")));
             if (item01.isDisplayed()){
                sleepFor(2);
                centerlizePO.clickOnButton(item01.findElement(By.xpath("//parent::td//parent::tr//td[2]//button")));
                sleepFor(3);
                driver.findElement(By.xpath("//td[text()='"+PageFactory.initElements(driver,Xero.class).getValue("\\src\\main\\java\\IntegrationsPO\\NetoPO\\File\\HProduct")+"']")).isDisplayed();
                centerlizePO.clickOnButton(item01);
                ArrayList<String> tabs3 = new ArrayList<String> (driver.getWindowHandles());
                driver.switchTo().window(tabs3.get(2));
                centerlizePO.clickOnButton(getHoldAndEditOrderButton());
                sleepFor(7);
                centerlizePO.clickOnButton(getCancelButton());
                sleepFor(10);
                centerlizePO.clickOnButton(getDeleteButton1());
                sleepFor(3);
                Alert alert = driver.switchTo().alert();
                alert.accept();
                driver.close();
                sleepFor(1);
                ArrayList<String> tab = new ArrayList<String> (driver.getWindowHandles());
                driver.switchTo().window(tab.get(1));
                driver.navigate().refresh();
                WebElement chk = new WebDriverWait(driver,60).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='"+saleRef+"']//parent::td//parent::tr//td//label")));
                centerlizePO.clickOnButton(chk);
                centerlizePO.clickOnButton(getMoreAction());
                centerlizePO.clickOnButton(getDeleteOrderButton());
                Alert alert1 = driver.switchTo().alert();
                alert1.accept();
                centerlizePO.clickOnButton(getDeleteSelectedOrder());
                Alert alert2 = driver.switchTo().alert();
                alert2.accept();
             }

             sleepFor(1);
             return true;
         }catch (Exception e){
             System.out.println(e.getMessage());
             return false;
         }
     }




     /**
      * @author Vidhi Chapanera
      * @date 03 May 2021
      * @discription this method is use to create Sale  Neto to hike and verify in Hike
      * @return
      */
     @Step("create Sale Neto to hike and verify in Hike")
     public boolean createSaleNetoToHike() throws IOException {
         CenterlizePO centerlizePO = PageFactory.initElements(driver, CenterlizePO.class);
         Actions actions = new Actions(driver);
         try{
             sleepFor(5);
             ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
             driver.switchTo().window(tabs.get(1));
             sleepFor(2);
             actions.moveToElement(getNetoSalesOrdersButton()).build().perform();
             sleepFor(1);
             actions.moveToElement(getNetoVieworders()).click().build().perform();
             sleepFor(10);
             centerlizePO.clickOnButton(getAddNeOrderButton());
             centerlizePO.enterDataUsingSendkeys( getAddNeOrderCustomerSearch(),PageFactory.initElements(driver,Xero.class).getValue("\\src\\main\\java\\IntegrationsPO\\NetoPO\\File\\HCustomer"));
             sleepFor(2);
             WebElement result = new WebDriverWait(driver,60).
                     until(ExpectedConditions.presenceOfElementLocated
                             (By.xpath("//a[contains(normalize-space(.),'"+PageFactory.initElements(driver,Xero.class).getValue("\\src\\main\\java\\IntegrationsPO\\NetoPO\\File\\HCustomer")+"')]")));
             centerlizePO.clickOnButton(result);
             WebElement cou = new WebDriverWait(driver,60).
                     until(ExpectedConditions.presenceOfElementLocated
                             (By.xpath("//select[contains(@name,'bill_country')]")));
             Select select9 = new Select(cou);
             select9.selectByIndex(13);
             WebElement address = new WebDriverWait(driver,60).
                     until(ExpectedConditions.presenceOfElementLocated
                             (By.xpath("//th[text()='Billing Address']//parent::tr//parent::thead//following-sibling::tbody//tr//td//label[text()='Address']//parent::td//following-sibling::td//input")));
             centerlizePO.enterDataUsingSendkeys(address,"16 Cecil Street");
             WebElement postalcode = new WebDriverWait(driver,60).
                     until(ExpectedConditions.presenceOfElementLocated
                             (By.xpath("//th[text()='Billing Address']//parent::tr//parent::thead//following-sibling::tbody//tr//td//label[text()='Post Code']//parent::td//following-sibling::td//input")));
             centerlizePO.enterDataUsingSendkeys(postalcode,"2112");
             WebElement surburbCity = new WebDriverWait(driver,60).
                     until(ExpectedConditions.presenceOfElementLocated
                             (By.xpath("//th[text()='Billing Address']//parent::tr//parent::thead//following-sibling::tbody//tr//td//label[text()='Suburb Selector']//parent::td//following-sibling::td//select")));
             Select select = new Select(surburbCity);
             select.selectByIndex(2);
             WebElement adressbook = new WebDriverWait(driver,60).
                     until(ExpectedConditions.presenceOfElementLocated
                             (By.xpath("//th[text()='Shipping Address']//parent::tr//parent::thead//following-sibling::tbody//tr//td//label[text()='Address Book']//parent::td//following-sibling::td//select")));
             Select select1 = new Select(adressbook);
             select1.selectByIndex(1);
             WebElement date = new WebDriverWait(driver,60).
                     until(ExpectedConditions.presenceOfElementLocated
                             (By.xpath("//th[text()='Shipping Address']//parent::tr//parent::thead//following-sibling::tbody//tr//td//label[text()='Date Required']//parent::td//following-sibling::td//input")));
             SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
             String strDate = dateFormat.format(new Date());
             centerlizePO.enterDataUsingSendkeys(date,strDate);
             centerlizePO.clickOnButton(address);
             WebElement address1 = new WebDriverWait(driver,60).
                     until(ExpectedConditions.presenceOfElementLocated
                             (By.xpath("//th[text()='Shipping Address']//parent::tr//parent::thead//following-sibling::tbody//tr//td//label[text()='Address']//parent::td//following-sibling::td//input")));
             centerlizePO.enterDataUsingSendkeys(address1,"18 Sullivan Court");
             WebElement postalcode1 = new WebDriverWait(driver,60).
                     until(ExpectedConditions.presenceOfElementLocated
                             (By.xpath("//th[text()='Shipping Address']//parent::tr//parent::thead//following-sibling::tbody//tr//td//label[text()='Post Code']//parent::td//following-sibling::td//input")));
             centerlizePO.enterDataUsingSendkeys(postalcode1,"3483");
             WebElement surburbCity1 = new WebDriverWait(driver,60).
                     until(ExpectedConditions.presenceOfElementLocated
                             (By.xpath("//th[text()='Shipping Address']//parent::tr//parent::thead//following-sibling::tbody//tr//td//label[contains(text(),'Suburb Selector')]//parent::td//following-sibling::td//select")));
             Select select2 = new Select(surburbCity1);
             select2.selectByIndex(4);
             List<WebElement> item = new WebDriverWait(driver,60).
                     until(ExpectedConditions.presenceOfAllElementsLocatedBy
                             (By.xpath("//table[@id='orderlist']//tr//td//input[@type='text' and @class='input-large']")));
             centerlizePO.enterDataUsingSendkeys(item.get(item.size()-1),PageFactory.initElements(driver,Xero.class).getValue("\\src\\main\\java\\IntegrationsPO\\NetoPO\\File\\HProduct"));
             sleepFor( 1);
             WebElement result1 = new WebDriverWait(driver,60).
                     until(ExpectedConditions.presenceOfElementLocated
                             (By.xpath("//a[contains(normalize-space(.),'"+PageFactory.initElements(driver,Xero.class).getValue("\\src\\main\\java\\IntegrationsPO\\NetoPO\\File\\HProduct")+"')]")));
             centerlizePO.clickOnButton(result1);
             centerlizePO.clickOnButton(getCalculateShipping());
             sleepFor(3);
             centerlizePO.clickOnButton(getSaveasNewOrder());
             centerlizePO.clickOnButton(getApproveButton());
             WebElement payment = new WebDriverWait(driver,60).
                     until(ExpectedConditions.presenceOfElementLocated
                             (By.xpath("//td[contains(text(),'Payment Method:')]//following-sibling::td//select[@name]")));
             Select select3 = new Select(payment);
             select3.selectByIndex(1);
             WebElement total = new WebDriverWait(driver,60).
                     until(ExpectedConditions.presenceOfElementLocated
                             (By.xpath("//td[text()='Product Subtotal']//following-sibling::td//span")));
             String totalPay = total.getText();
             WebElement amountpaid = new WebDriverWait(driver,60).
                     until(ExpectedConditions.presenceOfElementLocated
                             (By.xpath("//td[contains(text(),'Amount Paid:')]//following-sibling::td//input")));
             centerlizePO.enterDataUsingSendkeys( amountpaid,totalPay );
             centerlizePO.clickOnButton(getMakepPaymentButton());
             sleepFor(3);
             WebElement Dispatch = new WebDriverWait(driver,60).
                     until(ExpectedConditions.presenceOfElementLocated
                             (By.xpath("//a[normalize-space(.)='Dispatch' and contains(@class,'btn-large')]")));
             actions.moveToElement(Dispatch).build().perform();
             JavascriptExecutor jse = (JavascriptExecutor)driver;
             jse.executeScript("arguments[0].click();",Dispatch);
             sleepFor(4);
             WebElement orderid = new WebDriverWait(driver,60).
                     until(ExpectedConditions.presenceOfElementLocated
                             (By.xpath("//td[contains(normalize-space(.),'ORDER ID')]//following-sibling::td[position()=1]")));
             String netoOrderID = orderid.getText();
             driver.switchTo().window(tabs.get(0));
             PageFactory.initElements(driver, Users.class).clickOnUsersButton();
             PageFactory.initElements(driver, StoreSetup.class).clickOnStoreSetupButton();
             centerlizePO.clickOnButton(PageFactory.initElements(driver, Integrations.class).getIntegrationsButton());
             centerlizePO.clickOnButton(getManageButton());
             actions.moveToElement(PageFactory.initElements(driver,Shopify.class).getManualSyncButton()).build().perform();
             jse.executeScript("arguments[0].click();",PageFactory.initElements(driver,Shopify.class).getManualSyncButton());
             sleepFor(4);
             String[] strArray2 = new String[]{"syncSales"};
             for (String s : strArray2) {
                 WebElement element = new WebDriverWait(driver, 60).ignoring(StaleElementReferenceException.class).
                         until(ExpectedConditions.presenceOfElementLocated
                                 (By.xpath("//label[@for='" + s + "']")));
                 element.click();
             }
             sleepFor(1);
             centerlizePO.clickOnButton(PageFactory.initElements(driver,Shopify.class).getButtonSyncNow());
             sleepFor(2);
             centerlizePO.clickOnButton(getSaveButton());
             sleepFor(10);
             PageFactory.initElements(driver, PointofSale.class).clickOnPointOfSaleButtonn();
             centerlizePO.clickOnButton(PageFactory.initElements(driver, SalesHistory.class).getSalesHistoryButton());
             sleepFor(5);
             driver.navigate().refresh();
             sleepFor(8);
             WebElement sale01 = new WebDriverWait(driver,60).
                     until(ExpectedConditions.presenceOfElementLocated
                             (By.xpath("//table[@id='SalesTable']//tbody//tr[1]//td[2]//a[text()='"+netoOrderID+"']//parent::td//following-sibling::td//a//i//parent::a")));
             centerlizePO.clickOnButton(sale01);
             sleepFor(3);
             while(true){
                 sleepFor(5);
                 centerlizePO.clickOnButton(PageFactory.initElements(driver,Shopify.class).getRefreshLogButton());
                 sleepFor(5);
                 if (driver.findElement(By.xpath("//td[text()='Neto - Hike']//following-sibling::td[1][text()='Created']")).isDisplayed())
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
      * @date 03 May 2021
      * @discription this method is use to automate neto
      * @return
      */
     @Step("automate Neto")
     public boolean automateNeto() throws IOException {
       try{
         createHikeStoreForNeto();
         clickOnActivateButtonOnNeto();
         loginNetoStore();
         connectYourNetotoHike();
         mappingNeto();
         createProductHiketoNeto();
         createProductNetotoHike();
         createCustomersHiketoNeto();
         createCustomersNetotoHike();
         createSaleHiketoNeto();
         createSaleNetoToHike();
        return true;
       }catch (Exception e){
         System.out.println(e.getMessage());
         return false;
       }
       finally{
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
        * @date 04 May 2021
        * @discription this method is use to delete product
        * @return
        */
       @Step("delete product")
       public boolean deleteProduct() throws IOException {
        CenterlizePO centerlizePO = PageFactory.initElements(driver,CenterlizePO.class);
        Actions actions = new Actions(driver);
        try{
           sleepFor(2);
           ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
           driver.switchTo().window(tabs.get(1));
           sleepFor(2);
           actions.moveToElement(getNetoProducts()).build().perform();
           sleepFor(1);
           actions.moveToElement(getNetoViewProducts()).click().build().perform();
           sleepFor(5);
           try {
             if(getSelectAllCheckboxForProduct().isDisplayed()){
               centerlizePO.clickOnButton(getSelectAllCheckboxForProduct());
               centerlizePO.clickOnButton(getSelectAllButton());
               WebElement with = new WebDriverWait(driver,60).
                       until(ExpectedConditions.presenceOfElementLocated
                               (By.xpath("//a[contains(text(),'With')]")));
               centerlizePO.clickOnButton(with);
               centerlizePO.clickOnButton(getDeleteButton());
               Alert alert = driver.switchTo().alert();
               alert.accept();
               sleepFor(20);
             }
           }catch (Exception exception){
             System.out.println("");
           }
           return true;
        }catch (Exception e){
           return false;
        }
     }


     /**
      * @author Vidhi Chapanera
      * @date 20 July 2021
      * @discription this method is use to login neto store
      * @return
      */
     @Step("login neto store")
     public boolean loginNetoStore() throws IOException {
       CenterlizePO centerlizePO = PageFactory.initElements(driver,CenterlizePO.class);
       String fileLocation =System.getProperty("user.dir")+"\\src\\main\\resources\\createStore.properties";
       Properties properties1 = new Properties();
       properties1.load(new FileReader(fileLocation));
       String fileLocation1 =System.getProperty("user.dir")+"\\src\\main\\resources\\Neto.properties";
       Properties properties2 = new Properties();
       properties2.load(new FileReader(fileLocation1));
       try{
         sleepFor(1);
         JavascriptExecutor jse = (JavascriptExecutor)driver;
         jse.executeScript("window.open()");
         ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
         driver.switchTo().window(tabs.get(1));
         sleepFor(1);
         driver.get("https://"+properties2.getProperty("neto.store")+".neto.com.au/_cpanel");
         centerlizePO.enterDataUsingSendkeys(getUserName(),String.valueOf(properties2.getProperty("neto.username")));
         centerlizePO.enterDataUsingSendkeys(getPassword(),String.valueOf(properties2.getProperty("neto.password")));
         centerlizePO.clickOnButton(getLogiButton());
         sleepFor(5);
         try{
            if (driver.findElement(By.name("take_over_session")).isDisplayed()){
               driver.findElement(By.name("take_over_session")).click();
               centerlizePO.enterDataUsingSendkeys(getPassword(),String.valueOf(properties2.getProperty("neto.password")));
               centerlizePO.clickOnButton(getLogiButton());
            }
         }catch (Exception exception){
          System.out.println("Login");
         }
         currentURL = driver.getCurrentUrl();
         System.out.println(currentURL);
         sleepFor(3);
         deleteProduct();
         deleteCustomer();
         return true;
       }catch (Exception e){
        System.out.println(e.getMessage());
        return false;
       }
     }


     /**
      * @author Vidhi Chapanera
      * @date 20 July 2021
      * @discription this method is use to delete customer
      * @return
      */
     @Step("delete product")
     public boolean deleteCustomer() throws IOException {
       CenterlizePO centerlizePO = PageFactory.initElements(driver,CenterlizePO.class);
       Actions actions = new Actions(driver);
       try{
          sleepFor(2);
          ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
          driver.switchTo().window(tabs.get(1));
          sleepFor(2);
          actions.moveToElement(getNetoCustomers()).build().perform();
          sleepFor(1);
          actions.moveToElement(getNetoViewCustomers()).click().build().perform();
          sleepFor(5);
          try {
            if(getSelectAllCheckboxForProduct().isDisplayed()){
             centerlizePO.clickOnButton(getSelectAllCheckboxForProduct());
             centerlizePO.clickOnButton(getSelectAllButton());
             WebElement with = new WebDriverWait(driver,60).
                     until(ExpectedConditions.presenceOfElementLocated
                             (By.xpath("//a[contains(text(),'With')]")));
             centerlizePO.clickOnButton(with);
             centerlizePO.clickOnButton(getBulkDeleteSelectedButton());
             Alert alert = driver.switchTo().alert();
             alert.accept();
             sleepFor(20);
            }
          }catch (Exception exception){
           System.out.println("");
          }
          return true;
       }catch (Exception e){
         return false;
       }
     }

 }