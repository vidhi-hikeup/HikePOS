package ProductsPO.DiscountOffersPO;

import CommonPO.BasePage;
import CommonPO.CenterlizePO;
import CustomersPO.Customers;
import PointofSalePO.CashRegisterPO.CashRegister;
import PointofSalePO.PointofSale;
import PointofSalePO.ProcessSalePO.ProcessSale;
import ProductsPO.ProductTypesPO.ProductTypes;
import ProductsPO.ProductsPO.Products;
import StoreSetupPO.GeneralPO.General;
import StoreSetupPO.StoreSetup;
import UsersPO.UserPO.Users;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.util.List;

/**
 * @author Vidhi Chapanera
 * @date 25 February 2021
 */
public class DiscountOffers extends BasePage {

    public WebDriver driver;

    public static String discountOfferName = "";
    public static String typeName = "";
    public static String productName = "";
    public static String productBarcode = "";
    public static String discountOfferPercentage = "";

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for discount offer button
     * @date 25 February 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//span[contains(text(),'Products')]//parent::a[contains(@class,'auto')]//parent::li//descendant::ul//span[contains(text(),'Discount offers')]//parent::a"
    )
    WebElement btn_discountoffer;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for add discount offer button
     * @date 25 February 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//button[contains(@class,'btn-basic')]"
    )
    WebElement btn_adddiscountoffer;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for offer name input box
     * @date 25 February 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//label[contains(text(),'Offer name')]//parent::div//input"
    )
    //@FindBy(
            // how = How.XPATH,
            // using = "//label[text()='Offer name (internal)']//parent::div//input"
            // )
    WebElement txtbox_offername;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for offer display name input box
     * @date 25 February 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//label[text()='Offer display name (in POS)']//parent::div//input"
    )
    WebElement txtbox_offerdisplayname;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for discount offer drop down
     * @date 25 February 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//offeron-combo//a"
    )
    WebElement dropdown_discountoffer;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for discount offer option radio button
     * @date 25 February 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//label[normalize-space(.)='% discount on items in one or more product types']"
    )
    WebElement rbtn_perdiscount;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for discount offer option radio button
     * @date 25 February 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//label[text()='Offer a set % discount on selected product/s. ']"
    )
    WebElement rbtn_perdiscount2;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for discount offer option radio button
     * @date 28 october 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//label[@for='brandoffer']"
    )
    WebElement rbtn_brandOffer;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for save button
     * @date 25 February 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//span[contains(text(),'Save')]//parent::button"
    )
    WebElement btn_save;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for close icon button
     * @date 28 October 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(@class,'slider-close')]"
    )
    WebElement icn_close;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for conflict offer checkbox
     * @date 28 October 2021
     */
    @FindBy(
            how = How.CSS,
            using = "label[for=conflictOffer]"
    )
    WebElement chk_conflictOffer;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for conflict offer checkbox drop down
     * @date 27 October 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//label[@for='conflictOffer']//following-sibling::div//a"
    )
    WebElement chk_conflictoOfferdpdw;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for multiple offer slider
     * @date 27 October 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//span[text()='Multiple offers available for this item: Please select one']"
    )
    WebElement multipleOfferSlider;

    public DiscountOffers(WebDriver driver) {
        this.driver = driver;
    }
    public WebElement getDiscountOffersButton() {
        return btn_discountoffer;
    }
    public WebElement getAddDiscountOffersButton() {
        return btn_adddiscountoffer;
    }
    public WebElement getOfferNameTextBox() {
        return txtbox_offername;
    }
    public WebElement getOfferDisplayNameTextBox() {
        return txtbox_offerdisplayname;
    }
    public WebElement getDiscountOfferDropDown() {
        return dropdown_discountoffer;
    }
    public WebElement getDiscountOfferOption() {
        return rbtn_perdiscount;
    }
    public WebElement getDiscountOfferOnProductOption() {
        return rbtn_perdiscount2;
    }
    public WebElement getBrandOffer() {
        return rbtn_brandOffer;
    }
    public WebElement getSaveButton() {
        return btn_save;
    }
    public WebElement getCloseICon() {
        return icn_close;
    }
    public WebElement getConflictOffer() {
        return chk_conflictOffer;
    }
    public WebElement getConflictOfferDropDown() {
        return chk_conflictoOfferdpdw;
    }
    public WebElement getMultipleOfferSlider() {
        return multipleOfferSlider;
    }


    /**
     * @author Vidhi Chapanera
     * @date 12 January 2021
     * @discription reset static variable value
     */
    @Step("")
    public void Reset () {
        discountOfferName = "";
        typeName = "";
        productName = "";
    }


    /**
     * @author Vidhi Chapanera
     * @date 25 February 2021
     * @return
     * @throws Exception
     * @discription this method is used to Create a new ‘Product type’ discount offer
     */
    @Step("Create a new ‘Product type’ discount offer")
    public boolean createNewProductTypeDiscountOffer() {
        CenterlizePO centerlizePO = PageFactory.initElements(driver,CenterlizePO.class);
        try {
            sleepFor(5);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, ProductTypes.class).getProductTypesButton());
            sleepFor(1);
            List<WebElement> producttypeName = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//table[@id='CategoriesDataTable']//tbody//tr//td[3]//a[text()]")));
            for (int i=0;i<producttypeName.size();i++){
                sleepFor(1);
                typeName = producttypeName.get(i).getText();
                sleepFor(1);
                break;
            }
            centerlizePO.clickOnButton(getDiscountOffersButton());
            sleepFor(5);
            centerlizePO.clickOnButton(getAddDiscountOffersButton());
            sleepFor(3);
            centerlizePO.enterDataUsingSendkeys(getOfferNameTextBox(),"50% Discount");
            sleepFor(1);
            centerlizePO.enterDataUsingSendkeys(getOfferDisplayNameTextBox(),"min 50% off");
            sleepFor(1);
            discountOfferName = getOfferDisplayNameTextBox().getAttribute("value");
            sleepFor(1);
            centerlizePO.clickOnButton(getDiscountOfferDropDown());
            sleepFor(1);
            WebElement producttype = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated(By.xpath("//offeron-combo//li//div[text()='Product type']")));
            producttype.click();
            sleepFor(1);
            centerlizePO.clickOnButton(getDiscountOfferOption());
            sleepFor(1);
            WebElement inputDecimal = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@format='decimal']")));
            centerlizePO.enterDataUsingSendkeys(inputDecimal,Keys.CONTROL+ "a");
            centerlizePO.enterDataUsingSendkeys(inputDecimal, String.valueOf(Keys.DELETE));
            inputDecimal.sendKeys("50");
            sleepFor(2);
            Actions actions = new Actions(driver);
            WebElement tagging = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated(By.xpath("//category-tagging//input")));
            centerlizePO.clickOnButton(tagging);
            centerlizePO.enterDataUsingSendkeys(tagging,typeName);
            actions.sendKeys(Keys.TAB).build().perform();
            sleepFor(1);
            centerlizePO.clickOnButton(getSaveButton());
            sleepFor(3);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }


    /**
     * @author Vidhi Chapanera
     * @date 25 February 2021
     * @return
     * @throws Exception
     * @discription this method is used to Add a member product to cart and verify that offer is apply correctly
     */
    @Step("Add a member product to cart and verify that offer is apply correctly")
    public boolean addMemberProductToTheCartandVerifyOfferinCart() {
        CenterlizePO centerlizePO = PageFactory.initElements(driver,CenterlizePO.class);
        try {
            sleepFor(5);
            PageFactory.initElements(driver, PointofSale.class).clickOnPointOfSaleButtonn();
            Assert.assertTrue(centerlizePO.clickOnButton(PageFactory.initElements(driver, CashRegister.class).getCashRegisterButton()), "Click on process sale button");
            centerlizePO.sleepFor(5);
            Assert.assertTrue(centerlizePO.clickOnButton(PageFactory.initElements(driver, CashRegister.class).getRefreshDataButton()), "Click on process sale button");
            Assert.assertTrue(centerlizePO.clickOnButton(PageFactory.initElements(driver, CashRegister.class).getContinueButton()), "Click on process sale button");
            centerlizePO.sleepFor(20);
            WebElement producttypeName = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='mydiv']//a[contains(@class,'nav-link') and contains(text(),'" + typeName + "')]")));
            sleepFor(1);
            centerlizePO.clickOnButton(producttypeName);
            List<WebElement> elementList = new WebDriverWait(driver,120).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy
                            (By.xpath("//div[contains(@class,'deskview')]//div[contains(@class,'figure-footer-text')]")));
            elementList.get(0).click();
            sleepFor(1);
            if (driver.findElements(By.xpath("//div[@class='row']//label")).get(0).isDisplayed()){
                List<WebElement> variant = new WebDriverWait(driver,120).
                        until(ExpectedConditions.presenceOfAllElementsLocatedBy
                                (By.xpath("//div[@class='row']//label")));
                sleepFor(1);
                variant.get(0).click();
                sleepFor(1);
                variant.get(3).click();
                sleepFor(1);
            }
            sleepFor(1);
            WebElement discountName = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//div[contains(@class,'sell-item-list')]//a[contains(@class,'ng-hide')]//parent::div//parent::div//div[@class='sell-item-content']//div[contains(@class,'small')]//span[text()]")));
            String displayName = discountName.getText();
            if (displayName.contains(discountOfferName))
                System.out.println(" ");
            sleepFor(1);
            WebElement discounprice = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//div[contains(@class,'sell-item-list')]//a[contains(@class,'ng-hide')]//parent::div//parent::div//div[@class='sell-item-price']//div")));
            String priceAfterDiscount = discounprice.getText();
            float discounPrice = Float.parseFloat(priceAfterDiscount.substring(2));
            sleepFor(1);
            WebElement productprice = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//div[contains(@class,'sell-item-list')]//a[not(contains(@class,'ng-hide'))]//parent::div//parent::div//div[@class='sell-item-price']//div[(contains(@ng-if,'totalDiscount '))][text()]")));
            sleepFor(1);
            String productPriceAfterDiscount = productprice.getText();
            System.out.println(productPriceAfterDiscount);
            float ProductPrice = Float.parseFloat(productPriceAfterDiscount.substring(1));
            sleepFor(1);
            float finalPirce = ProductPrice*20/100;
            if (finalPirce==discounPrice){
                System.out.println(" ");
            }
            sleepFor(1);
            float pay = finalPirce-finalPirce;
            WebElement payprice = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//button[contains(@class,'btn-xlarge')]//div[contains(@class,'right')]")));
            String payPriceAfterDiscount = payprice.getText();
            float payPrice = Float.parseFloat(payPriceAfterDiscount.substring(1));
            if (payPrice==pay){
                System.out.println("");
            }
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
     * @date 25 February 2021
     * @return
     * @throws Exception
     * @discription this method is used to Create a new ‘Product’ discount offer
     */
    @Step("Create a new ‘Product’ discount offer")
    public boolean createNewProductDiscountOffer() {
        CenterlizePO centerlizePO = PageFactory.initElements(driver,CenterlizePO.class);
        try {
            sleepFor(10);
            Reset();
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Products.class).getProductButton());
            sleepFor(10);
            Actions actions = new Actions(driver);
            actions.sendKeys(Keys.PAGE_DOWN).build().perform();
            WebElement pagination = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated(By.name("RosterDataTable_length")));
            Select select = new Select(pagination);
            select.selectByValue("100");
            sleepFor(10);
            actions.sendKeys(Keys.PAGE_DOWN).build().perform();
            sleepFor(5);
            WebElement producttypeName = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table[@id='RosterDataTable']//tbody//tr[last()-1]//td[2]//span[text()]")));
            sleepFor(1);
            actions.moveToElement(producttypeName).build().perform();
            productName = producttypeName.getText();
            producttypeName.click();
            sleepFor(1);
            WebElement productType = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//label[contains(text(),'Product type')]//parent::div//category-combo//li//span[text()]")));
            typeName = productType.getText();
            WebElement productbarcode = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.cssSelector("#barcode")));
            productBarcode = productbarcode.getText();
            sleepFor(1);
            centerlizePO.clickOnButton(getDiscountOffersButton());
            centerlizePO.clickOnButton(getAddDiscountOffersButton());
            sleepFor(3);
            centerlizePO.enterDataUsingSendkeys(getOfferNameTextBox(),"50% Off");
            sleepFor(1);
            centerlizePO.enterDataUsingSendkeys(getOfferDisplayNameTextBox(),"min 50% off on "+typeName+" Product");
            sleepFor(1);
            discountOfferName = getOfferDisplayNameTextBox().getAttribute("value");
            sleepFor(1);
            centerlizePO.clickOnButton(getDiscountOfferDropDown());
            sleepFor(1);
            WebElement producttype = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated(By.xpath("//offeron-combo//li//div[text()='Product']")));
            producttype.click();
            sleepFor(1);
            centerlizePO.clickOnButton(getDiscountOfferOnProductOption());
            sleepFor(1);
            WebElement inputDecimal = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@format='decimal']")));
            centerlizePO.enterDataUsingSendkeys(inputDecimal,Keys.CONTROL+ "a");
            centerlizePO.enterDataUsingSendkeys(inputDecimal, String.valueOf(Keys.DELETE));
            inputDecimal.sendKeys("50");
            sleepFor(2);
            WebElement tagging = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated(By.xpath("//product-tagging//input")));
            tagging.click();
            actions.sendKeys(Keys.PAGE_DOWN).build().perform();
            tagging.sendKeys(productName);
            sleepFor(2);
            actions.sendKeys(Keys.TAB).build().perform();
            sleepFor(1);
            centerlizePO.clickOnButton(getSaveButton());
            sleepFor(5);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }


    /**
     * @author Vidhi Chapanera
     * @date 25 February 2021
     * @return
     * @throws Exception
     * @discription this method is used to Add a member product to cart and verify that offer is apply correctly
     */
    @Step("Add a member product to cart and verify that offer is apply correctly")
    public boolean addMemberProductOfferToTheCartandVerifyOfferinCart(){
        CenterlizePO centerlizePO = PageFactory.initElements(driver,CenterlizePO.class);
        try {
            sleepFor(5);
            PageFactory.initElements(driver, PointofSale.class).clickOnPointOfSaleButtonn();
            centerlizePO.clickOnButton(PageFactory.initElements(driver, CashRegister.class).getCashRegisterButton());
            centerlizePO.sleepFor(5);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, CashRegister.class).getRefreshDataButton());
            centerlizePO.clickOnButton(PageFactory.initElements(driver, CashRegister.class).getContinueButton());
            centerlizePO.sleepFor(15);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, ProcessSale.class).getProcessSaleButton());
            sleepFor(15);
            PageFactory.initElements(driver, ProcessSale.class).getSearchBar().sendKeys(productName);
            sleepFor(1);
            Actions actions = new Actions(driver);
            actions.sendKeys(Keys.TAB).build().perform();
            sleepFor(1);
            WebElement discountName = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//div[contains(@class,'sell-item-list')]//a[contains(@class,'ng-hide')]//parent::div//parent::div//div[@class='sell-item-content']//div[contains(@class,'small')]//span[text()]")));
            String displayName = discountName.getText();
            if (displayName.contains(discountOfferName))
                System.out.println(" ");
            sleepFor(1);
            WebElement discounprice = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//div[contains(@class,'sell-item-list')]//a[contains(@class,'ng-hide')]//parent::div//parent::div//div[@class='sell-item-price']//div")));
            String priceAfterDiscount = discounprice.getText();
            float discounPrice = Float.parseFloat(priceAfterDiscount.substring(2));
            sleepFor(1);
            WebElement productprice = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//div[contains(@class,'sell-item-list')]//a[not(contains(@class,'ng-hide'))]//parent::div//parent::div//div[@class='sell-item-price']//div[(contains(@ng-if,'totalDiscount '))][text()]")));
            sleepFor(1);
            String productPriceAfterDiscount = productprice.getText();
            System.out.println(productPriceAfterDiscount);
            float ProductPrice = Float.parseFloat(productPriceAfterDiscount.substring(1));
            sleepFor(1);
            float finalPirce = ProductPrice*20/100;
            if (finalPirce==discounPrice){
                System.out.println(" ");
            }
            sleepFor(1);
            float pay = finalPirce-finalPirce;
            WebElement payprice = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//button[contains(@class,'btn-xlarge')]//div[contains(@class,'right')]")));
            String payPriceAfterDiscount = payprice.getText();
            float payPrice = Float.parseFloat(payPriceAfterDiscount.substring(1));
            if (payPrice==pay){
                System.out.println("");
            }
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
     * @date 28 October 2021
     * @return
     * @throws Exception
     * @discription this method is used to Create one Product
     */
    @Step("Create one Product"+"\n"+"testName:{0}")
    public boolean CreateProduct(String testName){
        CenterlizePO centerlizePO = PageFactory.initElements(driver,CenterlizePO.class);
        Products productsPO = PageFactory.initElements(driver, Products.class);
        try {
            sleepFor(5);
            PageFactory.initElements(driver, Products.class).getProductButton().click();
            sleepFor(3);
            centerlizePO.clickOnButton(productsPO.getAddProductButton());
            sleepFor(3);
            centerlizePO.enterDataUsingSendkeys(productsPO.getProductName(), testName);
            sleepFor(1);
            centerlizePO.enterDataUsingSendkeys(productsPO.getProductType(),"PT UOM");
            Actions actions = new Actions(driver);
            actions.sendKeys(Keys.TAB).build().perform();
            centerlizePO.enterDataUsingSendkeys(productsPO.getSuppliers(),"Automation Suppliers");
            actions.sendKeys(Keys.TAB).build().perform();
            centerlizePO.enterDataUsingSendkeys(productsPO.getBrand(),"Pantaloons");
            actions.sendKeys(Keys.TAB).build().perform();
            sleepFor(2);
            centerlizePO.clickOnButton(productsPO.getInventoryTrackingButton());
            List<WebElement> input = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//th[text()='On hand']//parent::tr//parent::thead//parent::table//tbody//input")));
            input.get(0).clear();
            input.get(0).sendKeys("100");
            sleepFor(1);
            List<WebElement> cost = new WebDriverWait(driver,60).
                    until(ExpectedConditions.
                            presenceOfAllElementsLocatedBy(By.xpath
                                    ("//th[text()='Cost price']//parent::tr//parent::thead//parent::table//tbody//input")));
            centerlizePO.enterDataUsingSendkeys(cost.get(5),Keys.CONTROL+ "a");
            centerlizePO.enterDataUsingSendkeys(cost.get(5), String.valueOf(Keys.DELETE));
            centerlizePO.enterDataUsingSendkeys(cost.get(5),"150");
            sleepFor(2);
            centerlizePO.clickOnButton(productsPO.getProductSaveButton());
            sleepFor(5);
            sleepFor(1);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }


    /**
     * @author Vidhi Chapanera
     * @date 25 February 2021
     * @return
     * @throws Exception
     * @discription this method is used to Create a new ‘Brand’ discount offer
     */
    @Step("Create a new ‘Product’ discount offer"+"\n"+"discountName:{0}"+"\n"+"percentage:{1}")
    public boolean createNewTwoDiscountType(String discountName, String percentage) {
        CenterlizePO centerlizePO = PageFactory.initElements(driver,CenterlizePO.class);
        Actions actions = new Actions(driver);
        try {
            sleepFor(10);
            Reset();
            centerlizePO.clickOnButton(getAddDiscountOffersButton());
            sleepFor(3);
            centerlizePO.enterDataUsingSendkeys(getOfferNameTextBox(),discountName);
            sleepFor(1);
            centerlizePO.enterDataUsingSendkeys(getOfferDisplayNameTextBox(),discountName);
            sleepFor(1);
            discountOfferName = getOfferDisplayNameTextBox().getAttribute("value");
            sleepFor(1);
            centerlizePO.clickOnButton(getDiscountOfferDropDown());
            sleepFor(1);
            WebElement producttype = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated(By.xpath("//offeron-combo//li//div[text()='Brand']")));
            producttype.click();
            sleepFor(1);
            centerlizePO.clickOnButton(getBrandOffer());
            sleepFor(1);
            WebElement inputDecimal = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@format='decimal']")));
            centerlizePO.enterDataUsingSendkeys(inputDecimal,Keys.CONTROL+ "a");
            centerlizePO.enterDataUsingSendkeys(inputDecimal, String.valueOf(Keys.DELETE));
            inputDecimal.sendKeys(percentage);
            sleepFor(2);
            WebElement tagging = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated(By.xpath("//brand-tagging//input")));
            tagging.click();
            actions.sendKeys(Keys.PAGE_DOWN).build().perform();
            tagging.sendKeys("Pantaloons");
            sleepFor(2);
            actions.sendKeys(Keys.TAB).build().perform();
            sleepFor(1);
            centerlizePO.clickOnButton(getSaveButton());
            sleepFor(5);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }



    /**
     * @author Vidhi Chapanera
     * @date 28 October 202312
     * @return
     * @throws Exception
     * @discription this method is used to Verify Let cashier select the best suitable offer manually Option
     */
    @Step("Verify Let cashier select the best suitable offer manually Option"+"\n"+"productName:{0}")
    public boolean VerifyLetCashierSelectTheBestOption01(String productName) {
        CenterlizePO centerlizePO = PageFactory.initElements(driver,CenterlizePO.class);
        Actions actions = new Actions(driver);
        try {
            sleepFor(10);
            PageFactory.initElements(driver, Customers.class).clickOnCustomersButton();
            PageFactory.initElements(driver, StoreSetup.class).clickOnStoreSetupButton();
            centerlizePO.clickOnButton(PageFactory.initElements(driver, General.class).getGeneralButton());
            sleepFor(10);
            actions.moveToElement(getConflictOffer()).build().perform();
            centerlizePO.clickOnButton(getConflictOffer());
            centerlizePO.clickOnButton(getConflictOfferDropDown());
            sleepFor(3);
            WebElement option = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[@for='conflictOffer']//following-sibling::div//a//following-sibling::div//li//ul//li//span[text()='Let cashier select the best suitable offer manually']")));
            centerlizePO.clickOnButton(option);
            sleepFor(3);
            actions.moveToElement(PageFactory.initElements(driver, Users.class).getSaveButton()).build().perform();
            PageFactory.initElements(driver, Users.class).getSaveButton().click();
            sleepFor(13);

            PageFactory.initElements(driver,PointofSale.class).clickOnPointOfSaleButtonn();
            centerlizePO.clickOnButton(PageFactory.initElements(driver,ProcessSale.class).getProcessSaleButton());
            sleepFor(15);

            sleepFor(2);
            PageFactory.initElements(driver, ProcessSale.class).getSearchBar().sendKeys(productName);
            sleepFor(2);
            actions.sendKeys(Keys.TAB).build().perform();
            sleepFor(3);

            if (getMultipleOfferSlider().isDisplayed()){
                System.out.println("Displayed/////////////.");
                List<WebElement> e = new WebDriverWait(driver,60).
                        until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[contains(@class,'slider-close')]")));
                e.get(1).click();
                List<WebElement> e1 = new WebDriverWait(driver,60).
                        until(ExpectedConditions.presenceOfAllElementsLocatedBy
                                (By.xpath("//div[contains(@class,'sell-item-list')]//a[not(contains(@class,'ng-hide'))]")));
                for (int i=0;i<e1.size();i++){
                    sleepFor(1);
                    e1.get(i).click();
                }
                sleepFor(1);
                sleepFor(2);
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
     * @date 28 October 202312
     * @return
     * @throws Exception
     * @discription this method is used to Verify Automatically apply offer with a highest/lowest discount
     */
    @Step("Verify Automatically apply offer with a highest/lowest discount"+"\n"+"element:{0}"+"\n"+"productName:{1}"+"\n"+"DiscountName:{2}")
    public boolean VerifyAutomaticallyApplyOfferWithHighestDiscountOption0203(String element,String productName ,String DiscountName) {
        CenterlizePO centerlizePO = PageFactory.initElements(driver,CenterlizePO.class);
        Actions actions = new Actions(driver);
        try {
            sleepFor(10);
            PageFactory.initElements(driver, StoreSetup.class).clickOnStoreSetupButton();
            centerlizePO.clickOnButton(PageFactory.initElements(driver, General.class).getGeneralButton());
            centerlizePO.clickOnButton(getConflictOfferDropDown());
            sleepFor(3);
            WebElement option = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[@for='conflictOffer']//following-sibling::div//a//following-sibling::div//li//ul//li//span[text()='Automatically apply offer with " + element + " discount']")));
            centerlizePO.clickOnButton(option);
            sleepFor(3);
            actions.moveToElement(PageFactory.initElements(driver, Users.class).getSaveButton()).build().perform();
            PageFactory.initElements(driver, Users.class).getSaveButton().click();
            sleepFor(13);

            PageFactory.initElements(driver,PointofSale.class).clickOnPointOfSaleButtonn();
            centerlizePO.clickOnButton(PageFactory.initElements(driver,ProcessSale.class).getProcessSaleButton());
            sleepFor(15);

            sleepFor(2);
            PageFactory.initElements(driver, ProcessSale.class).getSearchBar().sendKeys(productName);
            sleepFor(2);
            actions.sendKeys(Keys.TAB).build().perform();
            sleepFor(3);

            WebElement appliedDiscount = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='sell-item-wrap']//span[contains(text(),'"+DiscountName+"')]")));

            if (appliedDiscount.isDisplayed())
            {
                System.out.println("Displayed..");
                List<WebElement> e = new WebDriverWait(driver,60).
                        until(ExpectedConditions.presenceOfAllElementsLocatedBy
                                (By.xpath("//div[contains(@class,'sell-item-list')]//a[not(contains(@class,'ng-hide'))]")));
                for (int i=0;i<e.size();i++){
                    sleepFor(1);
                    e.get(i).click();
                }
                sleepFor(1);
                sleepFor(2);
                return true;
            }else {
                return false;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}