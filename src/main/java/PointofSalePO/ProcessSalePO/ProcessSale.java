package PointofSalePO.ProcessSalePO;

import CommonPO.BasePage;
import CommonPO.CenterlizePO;
import Config.ExcelUtils;
import InventoryPO.Inventory;
import InventoryPO.MyInventoryPO.MyInventory;
import PointofSalePO.CashRegisterPO.CashRegister;
import PointofSalePO.PointofSale;
import PointofSalePO.SalesHistoryPO.SalesHistory;
import ProductsPO.GiftCardsPO.GiftCards;
import ProductsPO.ProductsPO.Products;
import ReportingPO.Reporting;
import ReportingPO.SalesPO.Sales;
import StoreSetupPO.GeneralPO.General;
import StoreSetupPO.StoreSetup;
import UsersPO.UserPO.Users;
import io.qameta.allure.Step;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.FindFailed;
import org.testng.Assert;
import javax.mail.*;
import javax.mail.internet.MimeBodyPart;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.text.NumberFormat;
import java.util.*;


/**
 * @author Vidhi Chapanera
 * @date 03 February 2021
 */
public class ProcessSale extends BasePage {

    public WebDriver driver;
    public static int testcount = 0;
    public static int dataCount = 0;
    public static String testData = "";
    public static String productItemName = "";
    public static String barcodeTest = "";
    public static int outletInventory = 0;
    public static int onHandStock = 0;
    public static int itemQuantity = 0;
    public static String attachFiles = "";
    public static String testPayablePrice = "";
    public static String testQuantity = "7";
    public static String testPrice = "55";
    public static String testSaleNumber = "";

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for process sale button
     * @date 03 February 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//span[contains(text(),'Process sale')]//parent::a"
    )
    WebElement btn_processsale ;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for add customer button
     * @date 04 February 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//span[contains(text(),'Add customer')]//parent::div"
    )
    WebElement btn_addcustomer ;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for add customer input box
     * @date 04 February 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//input[@placeholder='Find customer by name, phone or email']"
    )
    WebElement txtbox_addcustomer ;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for add new customer button
     * @date 04 February 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//button[contains(text(),'Add new customer')]"
    )
    WebElement btn_addnewcustomer ;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for pay button
     * @date 04 February 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(text(),'Pay')]//parent::button"
    )
    WebElement btn_pay ;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for cash button
     * @date 04 February 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//button[contains(text(),'Cash')]"
    )
    WebElement btn_cash ;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for on account button
     * @date 03 March 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//button[contains(text(),'On Account')]"
    )
    WebElement btn_onaccount ;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for add new sale button
     * @date 04 February 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//button[contains(text(),'Add new sale')]"
    )
    WebElement btn_addnewsale ;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for sale item title button
     * @date 09 February 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(@class,'sell-item-title')]"
    )
    WebElement btn_saleitle ;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for product info button
     * @date 09 February 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//button[contains(text(),'Product info')]"
    )
    WebElement btn_productinfo ;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for back button
     * @date 09 February 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//button[contains(text(),'Back')]"
    )
    WebElement btn_back ;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for slider close button
     * @date 09 February 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(@class,'slider-close cur')]"
    )
    WebElement icon_sliderclose;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for search bar
     * @date 09 February 2021
     */
    @FindBy(
            how = How.ID,
            using = "searchProductInput"
    )
    WebElement searchbar;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for email button
     * @date 04 March 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//a[text()='Email']"
    )
    WebElement btn_email ;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for send icon button
     * @date 04 March 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//i[@class='fa fa-send']//parent::button"
    )
    WebElement icn_send ;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for text email input box
     * @date 04 March 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//email-tagging-customer//input"
    )
    WebElement txtemail;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for text email input box
     * @date 04 March 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//span[@placeholder='Email']//following-sibling::li//span"
    )
    WebElement txtemail1;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Quote button
     * @date 04 March 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//span[contains(text(),'Quote')]"
    )
    WebElement btn_Quote;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for pay button
     * @date 04 March 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(text(),'Quote')]//parent::button"
    )
    WebElement btn_quote ;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for add new Quote button
     * @date 04 March 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//button[contains(text(),'Add new quote')]"
    )
    WebElement btn_addnewquote ;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for ok button on swal popup
     * @date 04 March 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//div[@class='swal-footer']//button[text()='Ok']"
    )
    WebElement btn_ok ;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Save and Select
     * @date 04 March 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//span[text()='Save & Select']//parent::button"
    )
    WebElement btn_saveselect ;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for who is selling popup
     * @date 15 March 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(@class,'selling')]"
    )
    WebElement whoissellingpopup ;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for who is street adaress
     * @date 01 July 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//form[@name='customerAddressCreateOrEditForm']//label[contains(text(),'Street address')]//parent::div//input"
    )
    WebElement streetaddress ;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for who is City / Suburb
     * @date 01 July 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//form[@name='customerAddressCreateOrEditForm']//label[contains(text(),'Suburb')]//parent::div//input"
    )
    WebElement suburbcity ;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for who is State / Territory
     * @date 01 July 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//form[@name='customerAddressCreateOrEditForm']//label[contains(text(),'State')]//parent::div//input"
    )
    WebElement state ;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for who is State / Territory
     * @date 01 July 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//form[@name='customerAddressCreateOrEditForm']//label[contains(text(),'Postal')]//parent::div//input"
    )
    WebElement postalCode ;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for discount part on cart
     * @date 01 July 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//div[@class='cart-sidebar']//td[normalize-space(.)='Discount']"
    )
    WebElement discount ;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for %
     * @date 01 July 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//a[text()='%']"
    )
    WebElement Percentage ;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for $
     * @date 01 July 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//a[text()='$']"
    )
    WebElement dollor ;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for % input box
     * @date 01 July 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//i[text()='%']//following-sibling::input"
    )
    WebElement PercentageTextBox ;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for % Enter
     * @date 01 July 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//i[text()='%']//parent::div//parent::div//following-sibling::div//button[text()='Enter']"
    )
    WebElement btn_PercentageEnter ;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for $ input box
     * @date 01 July 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//div[normalize-space(.)='$']//following-sibling::input"
    )
    WebElement PriceTextBox ;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for $ enter button
     * @date 01 July 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//div[normalize-space(.)='$']//parent::div//parent::div//following-sibling::div//button[text()='Enter']"
    )
    WebElement btn_priceEnter ;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for add new button
     * @date 03 December 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//button[normalize-space(.)='Add New']"
    )
    WebElement btn_addNewButton ;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Custom sale button
     * @date 09 December 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//button[text()='Custom sale']"
    )
    WebElement btn_customSale ;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for add to cart button
     * @date 09 December 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//button[text()='Add to cart']"
    )
    WebElement btn_addtocart ;

    public ProcessSale(WebDriver driver) {
        this.driver = driver;
    }
    public WebElement getProcessSaleButton() {
        return btn_processsale;
    }
    public WebElement getAddCustomerButton() {
        return btn_addcustomer;
    }
    public WebElement getAddCustomer() {
        return txtbox_addcustomer;
    }
    public WebElement getAddNewCustomerButton() {
        return btn_addnewcustomer;
    }
    public WebElement getPayButton() {
        return btn_pay;
    }
    public WebElement getCashButton() {
        return btn_cash;
    }
    public WebElement getOnAccountButton() {
        return btn_onaccount;
    }
    public WebElement getAddNewSaleButton() {
        return btn_addnewsale;
    }
    public WebElement getSaleItemTitle() {
        return btn_saleitle;
    }
    public WebElement getProductInfobutton() {
        return btn_productinfo;
    }
    public WebElement getBackButton() {
        return btn_back;
    }
    public WebElement getSliderCloseIcon() {
        return icon_sliderclose;
    }
    public WebElement getSearchBar() {
        return searchbar;
    }
    public WebElement getEmailButton() {
        return btn_email;
    }
    public WebElement getSendIconButton() {
        return icn_send;
    }
    public WebElement getTextEmail() {
        return txtemail;
    }
    public WebElement getTextEmail1() {
        return txtemail1;
    }
    public WebElement getQuoteButton() {
        return btn_Quote;
    }
    public WebElement getQuotePayButton() {
        return btn_quote;
    }
    public WebElement getAddNewQuoteButton() {
        return btn_addnewquote;
    }
    public WebElement getOkButton() {
        return btn_ok;
    }
    public WebElement getSaveAndSelect() {
        return btn_saveselect;
    }
    public WebElement getWhoIsSellingPopup() {
        return whoissellingpopup;
    }
    public WebElement getStreetAddress() {
        return streetaddress;
    }
    public WebElement getSuburbCity() {
        return suburbcity;
    }
    public WebElement getState() {
        return state;
    }
    public WebElement getPostalCode() {
        return postalCode;
    }
    public WebElement getDiscountButton() {
        return discount;
    }
    public WebElement getPercentage() {
        return Percentage;
    }
    public WebElement getDollor() {
        return dollor;
    }
    public WebElement getPercentageTextBox() {
        return PercentageTextBox;
    }
    public WebElement getPercentageEnterButton() {
        return btn_PercentageEnter;
    }
    public WebElement getPriceTextBox() {
        return PriceTextBox;
    }
    public WebElement getPriceEnterButton() {
        return btn_priceEnter;
    }
    public WebElement getAddNewButtonForDelivery() {
        return btn_addNewButton;
    }
    public WebElement getCustomSaleButton() {
        return btn_customSale;
    }
    public WebElement getAddToCartButton() {
        return btn_addtocart;
    }

    /**
     * @return
     * @throws Exception
     * @author Vidhi Chapanera
     * @date 03 February 2021
     * @discription this method is use to Checked new product display on the ‘process sale’ page
     */
    @Step("Checked new product display on the ‘process sale’ page"+"\n"+"ProductType:{0}")
    public boolean checkNeProductDisplayOnProcessSalePage(String ProductType) {
        try {
            sleepFor(2);
            WebElement e = new WebDriverWait(driver,120).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//div[@id='mydiv']//ul//li//a[text()='" + ProductType + "']")));
            e.click();
            List<String> list = ExcelUtils.getAllCellDataStringForProduct("Products");
            for (String s : list) {
                List<WebElement> elementList = new WebDriverWait(driver,120).
                        until(ExpectedConditions.presenceOfAllElementsLocatedBy
                                (By.xpath("//div[contains(@class,'deskview')]//div[contains(@class,'figure-footer-text')]")));
                for(int i = 0; i <elementList.size();i++){
                    elementList.get(i).getText().contains(s);
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
     * @date 04 February 2021
     * @discription this method is use to Added new product to cart and check out with ‘cash’ as payment method
     */
    @Step("Added new product to cart and check out with ‘cash’ as payment method"+"\n"+"ProductType:{0}")
    public boolean addedNewProductToCartAndCheckOutWithCashAsPaymentMethod(String ProductType) throws FindFailed {
        CenterlizePO centerlizePO = PageFactory.initElements(driver,CenterlizePO.class);
        try {
            sleepFor(5);
            WebElement e = new WebDriverWait(driver,120).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//div[@id='mydiv']//ul//li//a[text()='" + ProductType + "']")));
            e.click();
            sleepFor(2);
            List<WebElement> elementList = new WebDriverWait(driver, 120).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy
                            (By.xpath("//div[contains(@class,'deskview')]//div[contains(@class,'figure-footer-text')]")));
            JavascriptExecutor executor = (JavascriptExecutor)driver;
            executor.executeScript("arguments[0].click();", elementList.get(0));
            sleepFor(2);
            List<WebElement> variant = new WebDriverWait(driver, 120).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy
                            (By.xpath("//div[@class='row']//label")));
            variant.get(0).click();
            sleepFor(1);
            variant.get(4).click();
            sleepFor(1);
            centerlizePO.clickOnButton(getAddCustomerButton());
            centerlizePO.enterDataUsingSendkeys(getAddCustomer(),"A");
            sleepFor(1);
            Actions actions = new Actions(driver);
            actions.sendKeys(Keys.TAB).build().perform();
            sleepFor(2);
            centerlizePO.clickOnButton(getPayButton());
            centerlizePO.clickOnButton(getCashButton());
            sleepFor(5);
            /*Screen screen = new Screen();
            screen.find(System.getProperty("user.dir") + "\\test-image\\cancelBtn.png").click();
            sleepFor(1);*/
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
            sleepFor(1);
            centerlizePO.clickOnButton(getAddNewSaleButton());
            sleepFor(1);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, CashRegister.class).getCashRegisterButton());
            sleepFor(4);
            List<WebElement> total = new WebDriverWait(driver, 120).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy
                            (By.xpath("//div[@class='table-responsive']//table//thead//th[text()='Expected']//parent::tr//parent::thead//parent::table//tbody//tr//td[2]")));
            for (int i = 0; i < total.size(); i++) {
                String s = total.get(i).getText();
                NumberFormat format = NumberFormat.getNumberInstance(Locale.UK);
                int n = Integer.parseInt(String.valueOf(format.parse(s.substring(1)).intValue()));
                testcount += n;
            }
            WebElement amount = new WebDriverWait(driver, 120).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//div[@class='table-responsive']//table//thead//th[text()='Amount']//parent::tr//parent::thead//parent::table//tbody//tr//td[3]")));
            String s = amount.getText();
            NumberFormat format = NumberFormat.getNumberInstance(Locale.UK);
            int n = Integer.parseInt(String.valueOf(format.parse(s.substring(1)).intValue()));
            dataCount += n;
            WebElement totalsale = new WebDriverWait(driver, 120).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//span[contains(text(),'Sales summary')]//parent::div//parent::div//parent::div[contains(@class,'portlet light')]//tbody//tr//td[text()='Total sales:']//following-sibling::td")));
            String totalsale_1 = totalsale.getText();
            int n1 = Integer.parseInt(String.valueOf(format.parse(totalsale_1.substring(1)).intValue()));
            dataCount += n1;
            if (testcount == dataCount) {
                return true;
            }
            return true;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }


    /**
     * @return
     * @throws Exception
     * @author Vidhi Chapanera
     * @date 05 February 2021
     * @discription this method is use to verify created Composite Product Display in POS screen
     */
    @Step("verify created Composite Product Display in POS screen"+"\n"+"ProductType:{0}")
    public boolean veriyCreatedCompositeProductDisplayinPOSScreen(String ProductType) {
        try {
            sleepFor(3);
            CenterlizePO centerlizePO = PageFactory.initElements(driver,CenterlizePO.class);
            PageFactory.initElements(driver, PointofSale.class).clickOnPointOfSaleButtonn();
            centerlizePO.clickOnButton(getProcessSaleButton());
            sleepFor(1);
            WebElement e = new WebDriverWait(driver,120).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//div[@id='mydiv']//ul//li//a[text()='" + ProductType + "']")));
            e.click();
            List<String> list = ExcelUtils.getAllCellDataStringForProduct("Composite");
            for (String s : list) {
                List<WebElement> elementList = new WebDriverWait(driver,120).
                        until(ExpectedConditions.presenceOfAllElementsLocatedBy
                                (By.xpath("//div[contains(@class,'deskview')]//div[contains(@class,'figure-footer-text')]")));
                for(int i = 0; i <elementList.size();i++){
                    elementList.get(i).getText().contains(s);
                    break;
                }
            }
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
     * @date 09 February 2021
     * @discription this method is use to Sale Composite Product
     */
    @Step("Sale Composite Product"+"\n"+"ProductType:{0}")
    public boolean saleCompositeProduct(String ProductType) {
        String saleData = "";
        CenterlizePO centerlizePO = PageFactory.initElements(driver,CenterlizePO.class);
        try {
            Reset();
            sleepFor(5);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, SalesHistory.class).getSalesHistoryButton());
            sleepFor(3);
            Select select = new Select(PageFactory.initElements(driver, SalesHistory.class).getPaginationDropDown());
            select.selectByValue("100");
            WebElement sale = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                        (By.xpath("//table[@id='SalesTable']//tbody//tr[1]//td[2]//a[text()]")));
            saleData += sale.getText();
            sleepFor(1);
            centerlizePO.clickOnButton(getProcessSaleButton());
            sleepFor(10);
            WebElement e = new WebDriverWait(driver,120).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//div[@id='mydiv']//ul//li//a[text()='" + ProductType + "']")));
            e.click();
            List<WebElement> elementList = new WebDriverWait(driver,120).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy
                            (By.xpath("//div[contains(@class,'deskview')]//div[contains(@class,'figure-footer-text')]")));
            elementList.get(0).click();
            sleepFor(2);
            centerlizePO.clickOnButton(getSaleItemTitle());
            sleepFor(1);
            centerlizePO.clickOnButton(getProductInfobutton());
            sleepFor(1);
            List<WebElement> webElementList = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy
                            (By.xpath("//span[contains(text(),'Name')][text()]")));
            String productName = webElementList.get(0).getText();
            sleepFor(1);
            productItemName += productName.split("/")[0].split(":")[1].split(" ")[1];
            sleepFor(1);
            /**
             * @date 10 February 2021
             */
            List<WebElement> barcode = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy
                            (By.xpath("//span[contains(text(),'Barcode')][text()]")));
            String barcodeData = barcode.get(1).getText();
            sleepFor(1);
            String data =barcodeData.split(":")[1].split(" ")[1];
            sleepFor(1);
            barcodeTest += data;
            System.out.println(barcodeTest);
            sleepFor(1);
            List<WebElement> inventory = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy
                            (By.xpath("//span[contains(text(),'Outlet inventory')][text()]")));
            String inventoryData = inventory.get(0).getText();
            sleepFor(1);
            String data2 = inventoryData.split(":")[1].split(" ")[1];
            sleepFor(1);
            outletInventory += Integer.parseInt(data2);
            sleepFor(1);
            centerlizePO.clickOnButton(getSliderCloseIcon());
            centerlizePO.clickOnButton(getBackButton());
            centerlizePO.clickOnButton(getAddCustomerButton());
            centerlizePO.enterDataUsingSendkeys(getAddCustomer(),"A");
            sleepFor(1);
            Actions actions = new Actions(driver);
            actions.sendKeys(Keys.TAB).build().perform();
            sleepFor(2);
            WebElement saleItemQty = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//div[contains(@class,'sell-item-list')]//span[contains(@class,'sell-item-qty')]")));
            String qty = saleItemQty.getText();
            sleepFor(1);
            int saleQty = Integer.parseInt(qty);
            sleepFor(1);
            onHandStock += outletInventory-saleQty;
            sleepFor(1);
            /**
             */
            centerlizePO.clickOnButton(getPayButton());
            centerlizePO.clickOnButton(getCashButton());
            sleepFor(5);
            /*Screen screen = new Screen();
            Pattern cancel_btn = new Pattern(System.getProperty("user.dir")+"\\test-image\\cancelBtn.png");
            screen.find(cancel_btn);
            screen.click(cancel_btn);*/
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
            sleepFor(3);
            driver.switchTo().window(mainWindowHandle);
            sleepFor(1);
            centerlizePO.clickOnButton(getAddNewSaleButton());
            sleepFor(5);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, SalesHistory.class).getSalesHistoryButton());
            sleepFor(1);
            WebElement newSale = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//table[@id='SalesTable']//tbody//tr[1]//td[2]//a[text()]")));
            String newSaleData = newSale.getText();
            sleepFor(1);
            int n = Integer.parseInt(saleData.split("000")[1]);
            int n1 = n+1;
            testData += "000"+n1;
            System.out.println(testData);
            if (newSaleData.contains(testData))
                return true;
            return false;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }


    /**
     * @return
     * @throws Exception
     * @author Vidhi Chapanera
     * @date 09 February 2021
     * @discription this method is use to verify the sale entry under product history
     */
    @Step("verify the sale entry under product history")
    public boolean verifySaleEntryUnderProductHistory()  {
        CenterlizePO centerlizePO = PageFactory.initElements(driver,CenterlizePO.class);
        try {
            sleepFor(5);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, ProductsPO.Products.class).getProductButton());
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Products.class).getProductButton());
            centerlizePO.enterDataUsingSendkeys(PageFactory.initElements(driver, Products.class).getSearchBox(),productItemName);
            sleepFor(3);
            List<WebElement> elementList = new WebDriverWait(driver,120).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy
                            (By.xpath("//ul[contains(@class,'hike-width-block')]//b[text()='Product']//parent::ul//li//a")));
            elementList.get(0).click();
            sleepFor(2);
            WebElement product = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//table[@id='RosterDataTable']//tbody//tr//td[2]//span[text()='" + productItemName + "']//parent::td")));
            product.click();
            sleepFor(3);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Products.class).getViewProductHistoryButton());
            sleepFor(5);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Products.class).getSalesCheckbox());
            sleepFor(5);
            List<WebElement> reference = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy
                            (By.xpath("//table[@id='HistoryTable']//tbody//tr//td[5]")));
            for (int i=0;i<reference.size();i++){
                String referenceData = reference.get(i).getText();
                String reData = referenceData.split("#")[1];
                if (reData.contains(testData)){
                    centerlizePO.clickOnButton(getSliderCloseIcon());
                    sleepFor(1);
                    break;
                }
            }
            return true;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }


    /**
     * @return
     * @throws Exception
     * @author Vidhi Chapanera
     * @date 09 February 2021
     * @discription this method is use to verify the sale entry reporting side
     */
    @Step("verify the sale entry under reporting")
    public boolean verifySaleEntryUnderreporting() {
        CenterlizePO centerlizePO = PageFactory.initElements(driver,CenterlizePO.class);
        try {
            sleepFor(5);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Reporting.class).getReportingButton());
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Sales.class).getSalesButton());
            sleepFor(1);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Sales.class).getSalesTransactionsButton());
            sleepFor(3);
            Actions actions = new Actions(driver);
            actions.sendKeys(Keys.PAGE_DOWN).build().perform();
            List<WebElement> elementList = new WebDriverWait(driver,120).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy
                            (By.xpath("//table[@id='TransactionDetailDataTable']//tbody//tr//td[1]//a")));
            for (int i=0 ;i<elementList.size();i++){
                sleepFor(1);
               if (elementList.get(i).getText().contains(testData)){
                   sleepFor(1);
                   break;
               }
            }
            return true;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }


    /**
     * @return
     * @throws Exception
     * @author Vidhi Chapanera
     * @date 10 February 2021
     * @discription this method is use to verify on hand stock under my inventory after sale product
     */
    @Step("verify on hand stock under my inventory after sale product")
    public boolean verifystockUnderMyInventoryAfterSaleProduct() {
        CenterlizePO centerlizePO = PageFactory.initElements(driver,CenterlizePO.class);
        try {
            sleepFor(5);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Inventory.class).getInventoryButton());
            centerlizePO.clickOnButton(PageFactory.initElements(driver, MyInventory.class).getMyInventoryButton());
            sleepFor(1);
            centerlizePO.enterDataUsingSendkeys(PageFactory.initElements(driver, MyInventory.class).getSearchBox(),barcodeTest);
            sleepFor(3);
            List<WebElement> list = new WebDriverWait(driver,120).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy
                            (By.xpath("//ul[contains(@class,'hike-width-block')]//b[text()='Product']//parent::ul//li//a")));
            list.get(0).click();
            sleepFor(5);
            WebElement onHand = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//table[@id='InventoryRecordDataTable']//tbody//tr[1]//td[2]")));
            String data = onHand.getText();
            int stock = Integer.parseInt(data);
            if (stock==onHandStock)
                return true;
            return false;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }



    /**
     * @return
     * @throws Exception
     * @author Vidhi Chapanera
     * @date 11 February 2021
     * @discription this method is use to Sale newly created unity of measure product
     */
    @Step("Sale newly created unity of measure product"+"\n"+"ProductType:{0}")
    public boolean saleUnitOfMeasureProduct(String ProductType) {
        String saleData = "";
        CenterlizePO centerlizePO = PageFactory.initElements(driver,CenterlizePO.class);
        try {
            Reset();
            sleepFor(5);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, SalesHistory.class).getSalesHistoryButton());
           /* centerlizePO.clickOnButton(PageFactory.initElements(driver, SalesHistory.class).getCalenderOptionButton());
            centerlizePO.clickOnButton(PageFactory.initElements(driver, SalesHistory.class).getLast30DaysOption());*/
            sleepFor(3);
            Select select = new Select(PageFactory.initElements(driver, SalesHistory.class).getPaginationDropDown());
            select.selectByValue("100");
            WebElement sale = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//table[@id='SalesTable']//tbody//tr[1]//td[2]//a[text()]")));
            saleData += sale.getText();
            sleepFor(1);
            centerlizePO.clickOnButton(getProcessSaleButton());
            sleepFor(7);
            WebElement e = new WebDriverWait(driver,120).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//div[@id='mydiv']//ul//li//a[text()='" + ProductType + "']")));
            e.click();
            List<WebElement> elementList = new WebDriverWait(driver,120).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy
                            (By.xpath("//div[contains(@uib-tooltip,'unit of measure')]")));
            elementList.get(0).click();
            sleepFor(2);
            centerlizePO.clickOnButton(getSaleItemTitle());
            sleepFor(1);
            centerlizePO.clickOnButton(getProductInfobutton());
            sleepFor(1);
            List<WebElement> webElementList = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy
                            (By.xpath("//span[contains(text(),'Name')][text()]")));
            String productName = webElementList.get(0).getText();
            sleepFor(1);
            productItemName += productName.split(":")[1].split(" ")[1];
            sleepFor(1);
            List<WebElement> barcode = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy
                            (By.xpath("//span[contains(text(),'Barcode')][text()]")));
            String barcodeData = barcode.get(0).getText();
            sleepFor(1);
            String data =barcodeData.split(":")[1].split(" ")[1];
            sleepFor(1);
            barcodeTest += data;
            System.out.println(barcodeTest);
            sleepFor(1);
            List<WebElement> inventory = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy
                            (By.xpath("//span[contains(text(),'Outlet inventory')][text()]")));
            String inventoryData = inventory.get(0).getText();
            sleepFor(1);
            String data2 = inventoryData.split(":")[1].split(" ")[1];
            sleepFor(1);
            outletInventory += Integer.parseInt(data2);
            sleepFor(1);
            centerlizePO.clickOnButton(getSliderCloseIcon());
            centerlizePO.clickOnButton(getBackButton());
            centerlizePO.clickOnButton(getAddCustomerButton());
            centerlizePO.enterDataUsingSendkeys(getAddCustomer(),"A");
            sleepFor(1);
            Actions actions = new Actions(driver);
            actions.sendKeys(Keys.TAB).build().perform();
            sleepFor(2);
            WebElement saleItemQty = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//div[contains(@class,'sell-item-list')]//span[contains(@class,'sell-item-qty')]")));
            String qty = saleItemQty.getText();
            itemQuantity += Integer.parseInt(qty);
            centerlizePO.clickOnButton(getPayButton());
            centerlizePO.clickOnButton(getCashButton());
            sleepFor(5);
            /*Screen screen = new Screen();
            Pattern cancel_btn = new Pattern(System.getProperty("user.dir")+"\\test-image\\cancelBtn.png");
            screen.find(cancel_btn);
            screen.click(cancel_btn);*/
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
            sleepFor(3);
            driver.switchTo().window(mainWindowHandle);
            sleepFor(1);
            sleepFor(1);
            centerlizePO.clickOnButton(getAddNewSaleButton());
            sleepFor(1);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, SalesHistory.class).getSalesHistoryButton());
            sleepFor(1);
            WebElement newSale = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//table[@id='SalesTable']//tbody//tr[1]//td[2]//a[text()]")));
            String newSaleData = newSale.getText();
            sleepFor(1);
            int n = Integer.parseInt(saleData.split("000")[1]);
            int n1 = n+1;
            testData += "000"+n1;
            System.out.println(testData);
            if (newSaleData.contains(testData))
                return true;
            return false;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }



    /**
     * @return
     * @throws Exception
     * @author Vidhi Chapanera
     * @date 10 February 2021
     * @discription this method is use to verify on hand stock under my inventory after sale product
     */
    @Step("verify on hand stock under my inventory after sale product")
    public boolean verifystockUnderMyInventoryAfterSaleMeasureProduct() {
        CenterlizePO centerlizePO = PageFactory.initElements(driver,CenterlizePO.class);
        try {
            sleepFor(5);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, ProductsPO.Products.class).getProductButton());
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Products.class).getProductButton());
            centerlizePO.clearText(PageFactory.initElements(driver, Products.class).getSearchBox());
            centerlizePO.enterDataUsingSendkeys(PageFactory.initElements(driver, Products.class).getSearchBox(),barcodeTest);
            sleepFor(3);
            List<WebElement> elementList = new WebDriverWait(driver,120).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy
                            (By.xpath("//ul[contains(@class,'hike-width-block')]//b[text()='Product']//parent::ul//li//a")));
            String qty = elementList.get(0).getText();
            int n = Integer.parseInt(String.valueOf(qty.substring(qty.length()-2).charAt(0)));
            int saleQuantity = n*itemQuantity;
            onHandStock = outletInventory-saleQuantity;
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Inventory.class).getInventoryButton());
            centerlizePO.clickOnButton(PageFactory.initElements(driver, MyInventory.class).getMyInventoryButton());
            sleepFor(1);
            centerlizePO.enterDataUsingSendkeys(PageFactory.initElements(driver, MyInventory.class).getSearchBox(),productItemName);
            sleepFor(3);
            List<WebElement> list = new WebDriverWait(driver,120).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy
                            (By.xpath("//ul[contains(@class,'hike-width-block')]//b[text()='Product']//parent::ul//li//a")));
            list.get(0).click();
            sleepFor(5);
            WebElement onHand = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//table[@id='InventoryRecordDataTable']//tbody//tr[1]//td[2]")));
            String data = onHand.getText();
            int stock = Integer.parseInt(data);
            if (stock==onHandStock)
                return true;
            return false;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }


    /**
     * @author Vidhi Chapanera
     * @date 10 February 2021
     * @discription reset static variable value
     */
    @Step("")
    public void Reset() {
        testcount = 0;
        dataCount = 0;
        testData = "";
        productItemName = "";
        barcodeTest = "";
        outletInventory = 0;
        onHandStock = 0;
    }


    /**
     * @return
     * @throws Exception
     * @author Vidhi Chapanera
     * @date 24 February 2021
     * @discription this method is use to verify multiple quantities are added in separate line item in cart
     */
    @Step("verify multiple quantities are added in separate line item in cart")
    public boolean verifyMultipleQuantitiesareAddedInSeparateLineItemInCart() {
        try {
            sleepFor(5);
            //driver.navigate().refresh();
           // sleepFor(15);
            CenterlizePO centerlizePO = PageFactory.initElements(driver,CenterlizePO.class);
            PageFactory.initElements(driver,StoreSetup.class).clickOnStoreSetupButton();
            centerlizePO.clickOnButton(PageFactory.initElements(driver,General.class).getGeneralButton());
            sleepFor(3);
            Actions actions = new Actions(driver);
            centerlizePO.clickOnButton(PageFactory.initElements(driver,General.class).getMutipleQuantitiesOfSameProduct());
            sleepFor(2);
            actions.moveToElement(PageFactory.initElements(driver, Users.class).getSaveButton()).build().perform();
            PageFactory.initElements(driver, Users.class).getSaveButton().click();
            sleepFor(13);
            PageFactory.initElements(driver, PointofSale.class).clickOnPointOfSaleButtonn();
            centerlizePO.clickOnButton(PageFactory.initElements(driver, ProcessSale.class).getProcessSaleButton());
            sleepFor(20);
            WebElement test = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//a[normalize-space(.)='PT UOM']")));
            PageFactory.initElements(driver,CenterlizePO.class).clickOnButton(test);
            List<WebElement> elementList = new WebDriverWait(driver,120).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy
                            (By.xpath("//div[contains(@uib-tooltip,'unit of measure')]")));
            int number = 6;
            for (int i=0;i<number;i++) {
                elementList.get(0).click();
                sleepFor(1);
                /*if (driver.findElements(By.xpath("//div[@class='row']//label")).get(0).isDisplayed()) {
                    List<WebElement> variant = new WebDriverWait(driver, 120).
                            until(ExpectedConditions.presenceOfAllElementsLocatedBy
                                    (By.xpath("//div[@class='row']//label")));
                    sleepFor(1);
                    variant.get(0).click();
                    sleepFor(1);
                    variant.get(4).click();
                    sleepFor(1);
                }*/
            }
            sleepFor(1);
            List<WebElement> saleItemListele = new WebDriverWait(driver,120).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy
                            (By.xpath("//div[contains(@class,'sell-item-list')]")));
            int saleItemList = saleItemListele.size();
            if (saleItemList==number-1)
                sleepFor(1);
            sleepFor(1);
            List<WebElement> e = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy
                            (By.xpath("//div[contains(@class,'sell-item-list')]//a[not(contains(@class,'ng-hide'))]")));
            for (int i=0;i<e.size();i++){
                sleepFor(1);
                e.get(i).click();
            }
            sleepFor(1);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }


    /**
     * @author Vidhi Chapanera
     * @date 08 March 2021
     * @return
     * @throws Exception
     * @discription this method is used to Add New Quote
     */
    @Step("Add New Quote")
    public boolean addNewQuote() {
        String saleData = "";
        CenterlizePO centerlizePO = PageFactory.initElements(driver,CenterlizePO.class);
        try {
            sleepFor(5);
            Select select = new Select(PageFactory.initElements(driver, SalesHistory.class).getPaginationDropDown());
            select.selectByValue("100");
            WebElement sale = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//table[@id='SalesTable']//tbody//tr[1]//td[2]//a[text()]")));
            saleData += sale.getText();
            sleepFor(1);
            List<WebElement> list = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//table[@id='SalesTable']//tbody//tr")));
            centerlizePO.clickOnButton(getProcessSaleButton());
            sleepFor(20);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, ProcessSale.class).getQuoteButton());
            sleepFor(1);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, ProcessSale.class).getOkButton());
            sleepFor(2);
            WebElement color = new WebDriverWait(driver,60).until
                    (ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//div[@class='page-content']")));
            System.out.println(color.getCssValue("background-color"));
            if (color.getCssValue("background-color").contains("rgba(255, 230, 230, 0.54)"))
                System.out.println("");
            PageFactory.initElements(driver, ProcessSale.class).getSearchBar().sendKeys("A");
            sleepFor(2);
            Actions actions = new Actions(driver);
            actions.sendKeys(Keys.TAB).build().perform();
            sleepFor(1);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, ProcessSale.class).getAddCustomerButton());
            centerlizePO.enterDataUsingSendkeys(PageFactory.initElements(driver, ProcessSale.class).getAddCustomer(),"A");
            sleepFor(1);
            actions.sendKeys(Keys.TAB).build().perform();
            sleepFor(2);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, ProcessSale.class).getQuotePayButton());
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
            sleepFor(3);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, ProcessSale.class).getAddNewQuoteButton());
            sleepFor(3);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, SalesHistory.class).getSalesHistoryButton());
            WebElement FulfillmentStatus = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//table[@id='SalesTable']//tbody//tr[1]//td[5]//span[text()]")));
            if (FulfillmentStatus.getText().contains("Quote"))
                sleepFor(2);
            WebElement paymentStatus = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//table[@id='SalesTable']//tbody//tr[1]//td[6]//a[text()]")));
            if (paymentStatus.getText().contains(" Convert to sale"))
                sleepFor(2);
            if (paymentStatus.getCssValue("color").contains("rgba(35,82,124,1)"))
                sleepFor(1);
            paymentStatus.click();
            sleepFor(5);
            centerlizePO.clickOnButton(getPayButton());
            centerlizePO.clickOnButton(getCashButton());
            sleepFor(3);
            String mainWindowHandle1 = driver.getWindowHandle();
            Set<String> allWindowHandles1 = driver.getWindowHandles();
            Iterator<String> iterator1 = allWindowHandles1.iterator();
            while (iterator1.hasNext()) {
                String ChildWindow = iterator1.next();
                if (!mainWindowHandle1.equalsIgnoreCase(ChildWindow)) {
                    driver.switchTo().window(ChildWindow);
                    WebElement text = new WebDriverWait(driver,60).until(ExpectedConditions.presenceOfElementLocated(By.tagName("print-preview-app")));
                    Actions actions1 = new Actions(driver);
                    actions1.sendKeys(Keys.TAB).build().perform();
                    actions1.sendKeys(Keys.ENTER).build().perform();
                }
            }
            sleepFor(2);
            driver.switchTo().window(mainWindowHandle1);
            sleepFor(3);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, ProcessSale.class).getAddNewSaleButton());
            sleepFor(3);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, SalesHistory.class).getSalesHistoryButton());
            WebElement newSale = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//table[@id='SalesTable']//tbody//tr[1]//td[2]//a[text()]")));
            String newSaleData = newSale.getText();
            sleepFor(1);
            int n = Integer.parseInt(saleData.split("000")[1]);
            int n1 = n+1;
            testData += "000"+n1;
            System.out.println(testData);
            if (newSaleData.contains(testData))
                sleepFor(1);
            List<WebElement> list1 = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//table[@id='SalesTable']//tbody//tr")));
            int count = list.size()+2;
            sleepFor(1);
            if (list1.size()==count)
                sleepFor(2);
            PageFactory.initElements(driver, StoreSetup.class).clickOnStoreSetupButton();
            centerlizePO.clickOnButton(PageFactory.initElements(driver, General.class).getGeneralButton());
            centerlizePO.clickOnButton(PageFactory.initElements(driver, General.class).getQuoteIssuance());
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Users.class).getSaveButton());
            centerlizePO.sleepFor(10);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }


    /**
     * @author Vidhi Chapanera
     * @date 08 March 2021
     * @return
     * @throws Exception
     * @discription this method is used to Add New sale for delivery address
     */
    @Step("Add New sale for delivery address")
    public boolean addNewSaleForDeliveryAddress() {
        CenterlizePO centerlizePO = PageFactory.initElements(driver,CenterlizePO.class);
        try {
            sleepFor(10);
            PageFactory.initElements(driver, ProcessSale.class).getSearchBar().sendKeys("Demo Skirt");
            sleepFor(2);
            Actions actions = new Actions(driver);
            actions.sendKeys(Keys.TAB).build().perform();
            sleepFor(1);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, ProcessSale.class).getAddCustomerButton());
            centerlizePO.enterDataUsingSendkeys(PageFactory.initElements(driver, ProcessSale.class).getAddCustomer(),"A");
            sleepFor(1);
            actions.sendKeys(Keys.TAB).build().perform();
            sleepFor(2);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, GiftCards.class).getYesButton());
            sleepFor(4);
            try {
                if(getAddNewButtonForDelivery().isDisplayed())
                    getAddNewButtonForDelivery().click();
            }catch(Exception e){
                System.out.println(getAddNewButtonForDelivery()+" not Display");
            }
            getStreetAddress().sendKeys("85 Yangan Drive");
            getSuburbCity().sendKeys("Spring Ridge");
            getState().sendKeys("New South Wales");
            getPostalCode().sendKeys("2343");
            sleepFor(1);
            sleepFor(1);
            centerlizePO.clickOnButton(getSaveAndSelect());
            sleepFor(2);
            centerlizePO.clickOnButton(getPayButton());
            centerlizePO.clickOnButton(getCashButton());
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
            sleepFor(3);
            /*centerlizePO.clickOnButton(PageFactory.initElements(driver, ProcessSale.class).getEmailButton());
            centerlizePO.clearText(PageFactory.initElements(driver, ProcessSale.class).getEmailButton());
            sleepFor(1);
            centerlizePO.enterDataUsingSendkeys(getTextEmail(),"vidhi.hikeup@gmail.com");
            centerlizePO.clickOnButton(PageFactory.initElements(driver, ProcessSale.class).getSendIconButton());
            sleepFor(10);*/
            centerlizePO.clickOnButton(PageFactory.initElements(driver, ProcessSale.class).getAddNewSaleButton());
            sleepFor(3);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }



    /**
     * @author Vidhi Chapanera
     * @date 08 March 2021
     * @return
     * @throws Exception
     * @discription this method is used to download invoice pdf
     */
    @Step(" download invoice pdf")
    public boolean downloadPDF() {
        sleepFor(5);
        String receivingHost="imap.gmail.com";
        Properties props2=System.getProperties();
        props2.setProperty("imap.googlemail.com", "imaps");
        Session session2=Session.getDefaultInstance(props2, null);
        try {
            Store store=session2.getStore("imaps");
            String userName = "vidhi.hikeup@gmail.com";
            String password = "#Test4196";
            store.connect(receivingHost,userName, password);
            Folder folder=store.getFolder("INBOX");
            folder.open(Folder.READ_ONLY);
            Message message1[]=folder.getMessages();
            Message message = message1[message1.length-1];
            String contentType = message.getContentType();
            String messageContent = "";
            if (contentType.contains("multipart")) {
                // content may contain attachments
                Multipart multiPart = (Multipart) message.getContent();
                int numberOfParts = multiPart.getCount();
                for (int partCount = 0; partCount < numberOfParts; partCount++) {
                    MimeBodyPart part = (MimeBodyPart) multiPart.getBodyPart(partCount);
                    if (Part.ATTACHMENT.equalsIgnoreCase(part.getDisposition())) {
                        String fileName = part.getFileName();
                        attachFiles += fileName + ", ";
                        part.saveFile(System.getProperty("user.dir")+"\\download" + File.separator + fileName);
                    } else {
                        messageContent = part.getContent().toString();
                        System.out.println(messageContent);
                    }
                }
                if (attachFiles.length() > 1) {
                    attachFiles = attachFiles.substring(0, attachFiles.length() - 2);
                }
            } else if (contentType.contains("text/plain")
                    || contentType.contains("text/html")) {
                Object content = message.getContent();
                if (content != null) {
                    messageContent = content.toString();
                }
            }
            System.out.println("\t Attachments: " + attachFiles);
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
     * @date 08 March 2021
     * @return
     * @throws Exception
     * @discription this method is used to open downloaded pdf
     */
    @Step("open downloaded pdf"+"\n"+"content:{0}")
    public boolean openDownloadedPDf(String content) {
        try{
            sleepFor(5);
            JavascriptExecutor jse = (JavascriptExecutor)driver;
            jse.executeScript("window.open()");
            ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));
            String url =System.getProperty("user.dir")+"\\download\\"+attachFiles;
            driver.get(url);
            String pdfContent = readPdfContent();
            System.out.println(pdfContent);
            if (pdfContent.contains(content))
                System.out.println("true");
            sleepFor(2);
            jse.executeScript("window.close()");
            driver.switchTo().window(tabs.get(0));
            File f = new File(System.getProperty("user.dir") + "\\download\\");
            for (File file : f.listFiles()) {
                file.delete();
                System.out.println("deleted File");
            }
            deleteMail();
            return true;
        } catch (Exception e) {
            System.out.println(e.toString());
            System.out.println(e.getMessage());
            return false;
        }
    }

    /**
     * @author Vidhi Chapanera
     * @date 08 March 2018
     */
    public String readPdfContent() throws IOException {
        URL pdfUrl = new URL(driver.getCurrentUrl());
        InputStream in = pdfUrl.openStream();
        BufferedInputStream bf = new BufferedInputStream(in);
        PDDocument doc = PDDocument.load(bf);
        int numberOfPages = getPageCount(doc);
        System.out.println("The total number of pages "+numberOfPages);
        String content = new PDFTextStripper().getText(doc);
        doc.close();
        return content;
    }

    /**
     * @author Vidhi Chapanera
     * @date 08 March 2018
     * @param doc
     */
    @Step("get Page count"+"\n"+"doc:{0}")
    public int getPageCount(PDDocument doc) {
        //get the total number of pages in the pdf document
        int pageCount = doc.getNumberOfPages();
        return pageCount;
    }


    /**
     * @author Vidhi Chapanera
     * @date 08 March 2021
     * @return
     * @throws Exception
     * @discription this method is used to delete mail
     */
    @Step("delete mail")
    public boolean deleteMail() {
        sleepFor(5);
        String receivingHost="imap.gmail.com";
        Properties props2=System.getProperties();
        props2.setProperty("mail.store.protocol", "imaps");
        Session session2=Session.getDefaultInstance(props2, null);
        try {
            Store store=session2.getStore("imaps");
            String userName = "Vidhi.hikeup@gmail.com";
            String password = "#Test4196";
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
     * @date 25 November 2021
     * @return
     * @throws Exception
     * @discription this method is used to Add product to the cart
     */
    @Step("Add product to the cart")
    public boolean addProductToCart() {
        CenterlizePO centerlizePO = PageFactory.initElements(driver,CenterlizePO.class);
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
            sleepFor(3);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }


    /**
     * @author Vidhi Chapanera
     * @date 25 November 2021
     * @return
     * @throws Exception
     * @discription this method is used to Verify Discount With percentage
     */
    @Step("Verify Discount With percentage")
    public boolean verifyDiscountWithPercentage() {
        String percentage = "5";
        CenterlizePO centerlizePO = PageFactory.initElements(driver,CenterlizePO.class);
        try {
            sleepFor(5);
            WebElement payprice = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//button[contains(@class,'btn-xlarge')]//div[contains(@class,'right') and normalize-space(.)]")));
            testPayablePrice = payprice.getText();
            sleepFor(3);
            centerlizePO.clickOnButton(getDiscountButton());
            centerlizePO.clickOnButton(getPercentage());
            centerlizePO.enterDataUsingSendkeys(getPercentageTextBox(),percentage);
            centerlizePO.clickOnButton(getPercentageEnterButton());
            sleepFor(5);
            float i = Float.parseFloat(testPayablePrice.substring(1))*Float.parseFloat(percentage)/100;
            WebElement discounAppied = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//div[@class='cart-sidebar']//td[normalize-space(.)='Discount']//following-sibling::td")));
            if (discounAppied.getText().substring(1).equalsIgnoreCase(String.format("%.2f", i))){
                WebElement payprice1 = new WebDriverWait(driver,60).
                        until(ExpectedConditions.presenceOfElementLocated
                                (By.xpath("//button[contains(@class,'btn-xlarge')]//div[contains(@class,'right') and normalize-space(.)]")));
                String payPrice01 = payprice1.getText();
                float amount = Float.parseFloat(testPayablePrice.substring(1))-i;
                System.out.println(testPayablePrice.substring(1));
                System.out.println(amount);
                Assert.assertEquals(payPrice01.substring(1),String.format("%.2f", amount));
                return true;
            }else {
                return false;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }



    /**
     * @author Vidhi Chapanera
     * @date 25 November 2021
     * @return
     * @throws Exception
     * @discription this method is used to Verify Discount With Price
     */
    @Step("Verify Discount With Price")
    public boolean verifyDiscountWithPrice() {
        String testPrice = "10";
        CenterlizePO centerlizePO = PageFactory.initElements(driver,CenterlizePO.class);
        try {
            sleepFor(5);
            centerlizePO.clickOnButton(getDiscountButton());
            centerlizePO.clickOnButton(getDollor());
            getPriceTextBox().clear();
            centerlizePO.enterDataUsingSendkeys(getPriceTextBox(),testPrice);
            centerlizePO.clickOnButton(getPriceEnterButton());
            sleepFor(5);
            float i = Float.parseFloat(testPayablePrice.substring(1))-Float.parseFloat(testPrice);
            WebElement discounAppied = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//div[@class='cart-sidebar']//td[normalize-space(.)='Discount']//following-sibling::td")));
            if (discounAppied.getText().substring(1).contains(testPrice)){
                WebElement payprice01 = new WebDriverWait(driver,60).
                        until(ExpectedConditions.presenceOfElementLocated
                                (By.xpath("//button[contains(@class,'btn-xlarge')]//div[contains(@class,'right') and normalize-space(.)]")));
                String payPrice01 = payprice01.getText();
                Assert.assertTrue(Float.parseFloat(payPrice01.substring(1))==i);
                return true;
            }else {
                return false;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }



    /**
     * @author Vidhi Chapanera
     * @date 09 December 2021
     * @return
     * @throws Exception
     * @discription this method is used to create custom sale
     */
    @Step("create custom sale")
    public boolean createCustomSale() {
        CenterlizePO centerlizePO = PageFactory.initElements(driver,CenterlizePO.class);
        try {
            sleepFor(5);
            centerlizePO.clickOnButton(getCustomSaleButton());
            sleepFor(4);
            String[] strArray2 = new String[]{"Quantity", "Price ($)"};
            for (String s : strArray2) {
                sleepFor(3);
                WebElement quantityElement = new WebDriverWait(driver,60).
                        until(ExpectedConditions.presenceOfElementLocated
                                (By.xpath("//label[text()='"+s+"']//following-sibling::input")));
                if (s.contains("Price")){
                    quantityElement.clear();
                    centerlizePO.enterDataUsingSendkeys(quantityElement,testPrice);
                }else {
                    quantityElement.clear();
                    centerlizePO.enterDataUsingSendkeys(quantityElement, testQuantity);
                }
            }
            centerlizePO.clickOnButton(getAddToCartButton());
            centerlizePO.clickOnButton(getPayButton());
            centerlizePO.clickOnButton(getCashButton());
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
            sleepFor(3);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, ProcessSale.class).getAddNewSaleButton());
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }



    /**
     * @author Vidhi Chapanera
     * @date 09 December 2021
     * @return
     * @throws Exception
     * @discription this method is used to Verify in Reporting Side
     */
    @Step("Reporting Side")
    public boolean verifyCustomSaleInReportingSide() {
        CenterlizePO centerlizePO = PageFactory.initElements(driver,CenterlizePO.class);
        Actions actions = new Actions(driver);
        try {
            sleepFor(5);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, SalesHistory.class).getSalesHistoryButton());
            sleepFor(5);
            WebElement sale = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//table[@id='SalesTable']//tbody//tr[position()=1]//td[2]//a[text()]")));
            actions.moveToElement(sale).build().perform();
            testSaleNumber += sale.getText();
            sleepFor(5);
            PageFactory.initElements(driver,Reporting.class).clickOnReportingButton();
            sleepFor(3);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Sales.class).getSalesButton());
            sleepFor(7);
            centerlizePO.clickOnButton(PageFactory.initElements(driver,Sales.class).getCustomSaleButton());
            sleepFor(7);
            WebElement element = new WebDriverWait(driver,50).until(ExpectedConditions
                    .presenceOfElementLocated(By.xpath("//a[text()='"+testSaleNumber+"']//parent::td//following-sibling::td[position()=3]")));
            actions.moveToElement(element).build().perform();
            Assert.assertEquals(element.getText(),"Custom Sale");
            WebElement element1 = new WebDriverWait(driver,50).until(ExpectedConditions
                    .presenceOfElementLocated(By.xpath("//a[text()='"+testSaleNumber+"']//parent::td//following-sibling::td[position()=5]")));
            Assert.assertEquals(element1.getText(),testQuantity);
            WebElement element2 = new WebDriverWait(driver,50).until(ExpectedConditions
                    .presenceOfElementLocated(By.xpath("//a[text()='"+testSaleNumber+"']//parent::td//following-sibling::td[position()=9]")));
            Assert.assertEquals(element2.getText().substring(1),String.format("%.2f",Float.parseFloat(testQuantity)*Float.parseFloat(testPrice)));
            return true;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

}