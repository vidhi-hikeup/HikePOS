package ProductsPO.ProductsPO;

import CommonPO.BasePage;
import CommonPO.CenterlizePO;
import Config.ExcelUtils;
import CustomersPO.CustomersPO.Customers;
import InventoryPO.Inventory;
import PointofSalePO.PointofSale;
import PointofSalePO.ProcessSalePO.ProcessSale;
import StoreSetupPO.GeneralPO.General;
import StoreSetupPO.LoyaltyPointsPO.LoyaltyPoints;
import StoreSetupPO.StoreSetup;
import UsersPO.UserPO.Users;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;


/**
 * @author Vidhi Chapanera
 * @date 02 February 2021
 */
public class Products extends BasePage {

    public WebDriver driver;

    public static String productName = "";
    public static String saleProductName = "";

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for products button
     * @date 02 February 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//span[contains(text(),'Products')]//parent::a[contains(@class,'auto')]//parent::li//descendant::ul//span[contains(text(),'Products')]//parent::a"
    )
    WebElement btn_products;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for add product button
     * @date 02 February 2021
     */
    @FindBy(
            how = How.XPATH, using = "//i[contains(@class,'fa-plus')]//parent::a[normalize-space(.)='Add Product']"
    )
    WebElement btn_addproduct;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for product variant radio button
     * @date 02 February 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//label[@for='hasvariants']"
    )
    WebElement rbtn_productvariant;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for product name input box
     * @date 02 February 2021
     */
    @FindBy(
            how = How.ID,
            using = "proName"
    )
    WebElement txtbox_productname;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for inventory tracking button
     * @date 02 February 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//input[@id='switchInventory']//parent::div//span[text()='Off']"
    )
    WebElement btn_inventorytracking;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for add variant button
     * @date 02 February 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//i[contains(@class,'fa-plus')]/parent::button[text()=' Add variant']"
    )
    WebElement btn_addvariant;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for add another variant button
     * @date 02 February 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//button[text()='Add Another variant']"
    )
    WebElement btn_addanothervariant;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for save button
     * @date 02 February 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//div[@class='slider-modal-actions']//span[text()='Save']//parent::button"
    )
    WebElement btn_save;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for product type input box
     * @date 02 February 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//label[contains(text(),'Product type')]//parent::div//input"
    )
    WebElement txtbox_producttype;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Suppliers input box
     * @date 02 February 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//label[contains(text(),'Suppliers')]//parent::div//input"
    )
    WebElement txtbox_suppliers;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Brand input box
     * @date 02 February 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//label[contains(text(),'Brand')]//parent::div//input"
    )
    WebElement txtbox_brand;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for product save button
     * @date 02 February 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//a[text()='Cancel']//following-sibling::button//span[text()='Save']//parent::button"
    )
    //@FindBy(
            // how = How.XPATH,
            // using = "//div[@class='row']//span[text()='Save']//parent::button"
            // )
    WebElement btn_productsave;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for copy to all button
     * @date 02 February 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//a[contains(text(),'Copy to all')]"
    )
    WebElement btn_copytoall;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for yes button
     * @date 02 February 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//div[@class='modal-footer']//button[contains(text(),'Yes')]"
    )
    WebElement btn_yes;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for composite product radio button
     * @date 05 February 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//label[@for='compositeProduct']"
    )
    WebElement rbtn_compositevariant;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for existing product search bar input box
     * @date 05 February 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//label[text()='Select from existing products to be used as component']//parent::div//a"
    )
    WebElement txtbox_existingproductsearchbar;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Composite/bundle selling price. (Inc. Tax) input box
     * @date 05 February 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//label[contains(text(),'Composite/bundle selling price. (Inc. Tax)')]//parent::div//input[@format='currency']"
    )
    WebElement txtbox_compositesellingpriceinc;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for search input box
     * @date 09 February 2021
     */
    @FindBy(
            how = How.ID,
            using = "advancesearchtext"
    )
    WebElement txtbox_search;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for view product history button
     * @date 09 February 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//button[text()='View product history']"
    )
    WebElement btn_viewProducthistory;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for active unit of measure check box
     * @date 10 February 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//label[@for='enableUnitOfMeasure']"
    )
    WebElement chk_unitofmeasure;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for add new row button
     * @date 10 February 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//th[text()='UoM name']//parent::tr//parent::thead//parent::table//tfoot//a"
    )
    WebElement btn_addnewrow;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for available stock
     * @date 12 February 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//th[text()='Available stock']//parent::tr//parent::thead//parent::table//tbody//tr//td[3]"
    )
    WebElement txt_availablestock;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Update selling price with same profit margin radio button
     * @date 15 February 2021
     */
    @FindBy(
            how = How.CSS,
            using = "label[for='UpdateSellPrice']"
    )
    WebElement rbtn_updatesellingpricewithsameprofitmargin;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Cost of goods sold cogs button
     * @date 15 February 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//span[contains(text(),'Cost of Goods Sold ( COGS )')]//parent::uib-tab-heading//parent::a"
    )
    WebElement btn_costofgoodsold;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Update profit margin with same selling price radio button
     * @date 16 February 2021
     */
    @FindBy(
            how = How.CSS,
            using = "label[for='UpdateProfitMargin']"
    )
    WebElement rbtn_updateprofitmarginwithsamesellingprice;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Temporary change – applies only to this PO radio button
     * @date 16 February 2021
     */
    @FindBy(
            how = How.CSS,
            using = "label[for='OnlyThisPO']"
    )
    WebElement rbtn_onlythispo;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for sales check box
     * @date 23 February 2021
     */
    @FindBy(
            how = How.CSS,
            using = "label[for='SearchBySale']"
    )
    WebElement chk_sales;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for purchase order check box
     * @date 24 February 2021
     */
    @FindBy(
            how = How.CSS,
            using = "label[for='SearchByPurchaseOrder']"
    )
    WebElement chk_purchaseorder;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for stock take check box
     * @date 07 May 2021
     */
    @FindBy(
            how = How.CSS,
            using = "label[for='SearchByStocktake']"
    )
    WebElement chk_Stocktake;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for serial number check box
     * @date 02 March 2021
     */
    @FindBy(
            how = How.CSS,
            using = "label[for='switchSerialNumber']" +
                    "")
    WebElement chk_serialNumber;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for serial number input box
     * @date 02 March 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//input[@placeholder='Serial Number' and contains(@class,'ng-empty')]"
    )
    WebElement txt_serialnum;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for error popup ok button
     * @date 02 March 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//div[@class='swal-modal']//div[@class='swal-footer']//button"
    )
    WebElement btn_ok;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Additional loyalty points input box
     * @date 02 March 2021
     */
    @FindBy(
            how = How.ID,
            using = "loyalty"
    )
    WebElement txt_addditionalloyaltypoints;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for auto generated barcode drop down
     * @date 02 March 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//label[@for='numericBarcodeGenerate']//following-sibling::div//a"
    )
    WebElement drpdwn_autogenerate;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for barcode Filed
     * @date 02 March 2021
     */
    @FindBy(
            how = How.CSS,
            using = "#barcode"
    )
    WebElement barcode;

    public Products(WebDriver driver) {
        this.driver = driver;
    }
    public WebElement getProductButton() {
        return btn_products;
    }
    public WebElement getAddProductButton() {
        return btn_addproduct;
    }
    public WebElement getProductVariantRadioButton() {
        return rbtn_productvariant;
    }
    public WebElement getProductName() {
        return txtbox_productname;
    }
    public WebElement getInventoryTrackingButton() {
        return btn_inventorytracking;
    }
    public WebElement getAddVariantButton() {
        return btn_addvariant;
    }
    public WebElement getAddAnotherVariantButton() {
        return btn_addanothervariant;
    }
    public WebElement getSaveButton() {
        return btn_save;
    }
    public WebElement getProductType() {
        return txtbox_producttype;
    }
    public WebElement getSuppliers() {
        return txtbox_suppliers;
    }
    public WebElement getBrand() {
        return txtbox_brand;
    }
    public WebElement getProductSaveButton() {
        return btn_productsave;
    }
    public WebElement getCopyToAllButton() {
        return btn_copytoall;
    }
    public WebElement getYesButton() {
        return btn_yes;
    }
    public WebElement getCompositeProductRadioButton() {
        return rbtn_compositevariant;
    }
    public WebElement getExistingProductSearchBar() {
        return txtbox_existingproductsearchbar;
    }
    public WebElement getCompositeSellingPriceIncTax() {
        return txtbox_compositesellingpriceinc;
    }
    public WebElement getSearchBox() {
        return txtbox_search;
    }
    public WebElement getViewProductHistoryButton() {
        return btn_viewProducthistory;
    }
    public WebElement getActiveUnitOfMeasure() {
        return chk_unitofmeasure;
    }
    public WebElement getAddNewRowButton() {
        return btn_addnewrow;
    }
    public WebElement getAvailableStock() {
        return txt_availablestock;
    }
    public WebElement getUpdateSellingPriceWithSameProfitMargin() {
        return rbtn_updatesellingpricewithsameprofitmargin;
    }
    public WebElement getCostsOfGoodSoldButon() {
        return btn_costofgoodsold;
    }
    public WebElement getUpdateProfitMarginWithSameSellingPrice() {
        return rbtn_updateprofitmarginwithsamesellingprice;
    }
    public WebElement getTemporaryChange() {
        return rbtn_onlythispo;
    }
    public WebElement getSalesCheckbox() {
        return chk_sales;
    }
    public WebElement getPurchaseOrderCheckbox() {
        return chk_purchaseorder;
    }
    public WebElement getSearchByStocktakeCheckbox() {
        return chk_Stocktake;
    }
    public WebElement getSerialNumber() {
        return chk_serialNumber;
    }
    public WebElement getSerialNumberTxtBox() {
        return txt_serialnum;
    }
    public WebElement getOKButton() {
        return btn_ok;
    }
    public WebElement getAdditionalLoyaltyPoints() {
        return txt_addditionalloyaltypoints;
    }
    public WebElement getAutoGeneratedBarcodeDropDown() {
        return drpdwn_autogenerate;
    }
    public WebElement gerBarcode() {
        return barcode;
    }

    /**
     * @return
     * @throws Exception
     * @author Vidhi Chapanera
     * @date 02 February 2021
     * @discription this method is use to add new variant product with Different Size and color
     */
    @Step("add new variant product with Different Size and color")
    public boolean addMultipleVariantProduct() {
        try {
            List<String> list = ExcelUtils.getAllCellDataStringForProduct("Products");
            for (String s : list) {
                sleepFor(2);
                CenterlizePO centerlizePO = PageFactory.initElements(driver, CenterlizePO.class);
                centerlizePO.clickOnButton(getAddProductButton());
                sleepFor(2);
                centerlizePO.enterDataUsingSendkeys(getProductName(), s);
                centerlizePO.clickOnButton(getProductVariantRadioButton());
                centerlizePO.clickOnButton(getInventoryTrackingButton());
                centerlizePO.clickOnButton(getAddVariantButton());
                for(int i = 0 ; i < 3 ; i++) {
                    sleepFor(1);
                    WebElement color_input = new WebDriverWait(driver, 60).
                            until(ExpectedConditions.presenceOfElementLocated
                                    (By.xpath("//attribute-combo//parent::div//parent::div//div[contains(@class,'btn-block')]//ul[contains(@class,'select2-choice')]//input")));
                    color_input.click();
                    sleepFor(1);
                    Actions actions = new Actions(driver);
                    actions.sendKeys(Keys.TAB).build().perform();
                    sleepFor(2);
                }
                centerlizePO.clickOnButton(getAddAnotherVariantButton());
                for (int i = 0 ; i < 3 ; i++){
                    sleepFor(1);
                    List<WebElement> size_input = new WebDriverWait(driver, 60).
                            until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                                    (By.xpath("//attribute-combo//parent::div//parent::div//div[contains(@class,'btn-block')]//ul[contains(@class,'select2-choice')]//input"))));
                    size_input.get(1).click();
                    sleepFor(1);
                    Actions actions = new Actions(driver);
                    actions.sendKeys(Keys.TAB).build().perform();
                    sleepFor(2);
                }
                centerlizePO.clickOnButton(getSaveButton());
                centerlizePO.enterDataUsingSendkeys(getProductType(),"PT Variant");
                Actions actions = new Actions(driver);
                actions.sendKeys(Keys.TAB).build().perform();
                centerlizePO.enterDataUsingSendkeys(getSuppliers(),"Automation Suppliers");
                actions.sendKeys(Keys.TAB).build().perform();
                centerlizePO.enterDataUsingSendkeys(getBrand(),"Automation Brand");
                actions.sendKeys(Keys.TAB).build().perform();
                List<WebElement> rate = new WebDriverWait(driver,60).
                        until(ExpectedConditions.presenceOfAllElementsLocatedBy
                                (By.xpath("//thead[contains(@class,'flip-content')]//parent::table//tbody//tr[2]//input")));
                rate.get(2).clear();
                rate.get(2).sendKeys("20");
                sleepFor(1);
                rate.get(7).clear();
                rate.get(7).sendKeys("100");
                sleepFor(2);
                centerlizePO.clickOnButton(getCopyToAllButton());
                sleepFor(2);
                List<WebElement> chkbox = new WebDriverWait(driver,60).
                        until(ExpectedConditions.presenceOfAllElementsLocatedBy
                                (By.xpath("//div[@id='modal-body']//label")));
                for (int i=0;i<chkbox.size();i++){
                    sleepFor(1);
                    chkbox.get(i).click();
                }
                centerlizePO.clickOnButton(getYesButton());
                centerlizePO.clickOnButton(getProductSaveButton());
                sleepFor(5);
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
     * @date 05 February 2021
     * @discription this method is use to Create Multiple composite product and review in POS screen
     */
    @Step("Create Multiple composite product and review in POS screen")
    public boolean createMultipleCompositeProduct() {
        try {
            List<String> list = ExcelUtils.getAllCellDataStringForProduct("Composite");
            for (String s : list) {
                sleepFor(2);
                CenterlizePO centerlizePO = PageFactory.initElements(driver, CenterlizePO.class);
                centerlizePO.clickOnButton(getAddProductButton());
                sleepFor(2);
                centerlizePO.enterDataUsingSendkeys(getProductName(), s);
                sleepFor(1);
                centerlizePO.clickOnButton(getCompositeProductRadioButton());
                centerlizePO.enterDataUsingSendkeys(getProductType(),"PT Composite");
                Actions actions = new Actions(driver);
                actions.sendKeys(Keys.TAB).build().perform();
                centerlizePO.enterDataUsingSendkeys(getBrand(),"Automation Brand");
                actions.sendKeys(Keys.TAB).build().perform();
                sleepFor(2);
                List<String> list1 = ExcelUtils.getAllCellDataStringForProduct("Products");
                for (int i = 0; i < list1.size()-1; i++) {
                    sleepFor(1);
                    centerlizePO.clickOnButton(getExistingProductSearchBar());
                    List<WebElement> searchbar = new WebDriverWait(driver, 60).
                            until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                                    (By.xpath("//div[@class='row']//ul[contains(@class,'scroll')]//parent::div//input"))));
                    searchbar.get(0).sendKeys(list1.get(i));
                    sleepFor(3);
                    List<WebElement> result = new WebDriverWait(driver, 60).
                            until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                                    (By.xpath("//div[@class='row']//ul[contains(@class,'scroll')]//li//ul//li//div"))));
                    sleepFor(2);
                    result.get(2).click();
                    sleepFor(1);
                }
                sleepFor(1);
                centerlizePO.clearText(getCompositeSellingPriceIncTax());
                centerlizePO.enterDataUsingSendkeys(getCompositeSellingPriceIncTax(),"89");
                centerlizePO.clickOnButton(getProductSaveButton());
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
     * @date 08 February 2021
     * @discription this method is use to Import Products using Import Button
     */
    @Step("Import Products using Import Button"+"\n"+"filePath:{0}")
    public boolean importProductsUsingImportButton(String filePath) {
        try {
            sleepFor(10);
            CenterlizePO centerlizePO = PageFactory.initElements(driver,CenterlizePO.class);
            Customers customers = PageFactory.initElements(driver,Customers.class);
            centerlizePO.clickOnButton(customers.getImportButton());
            sleepFor(1);
            List<WebElement> list = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//ul//li//i[@class='icon-share-alt']//parent::a[text()]")));
            list.get(0).click();
            sleepFor(3);
            customers.getImportEXCELButton().sendKeys(filePath);
            sleepFor(3);
            centerlizePO.clickOnButton(customers.getContinueButton());
            sleepFor(1);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, LoyaltyPoints.class).getYesButton());
            sleepFor(1);
            centerlizePO.clickOnButton(customers.getOKButton());
            sleepFor(3);
            centerlizePO.clickOnButton(customers.getConnectedValidateButton());
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
     * @discription this method is use to verify Products are imported successfully
     */
    @Step("verify Products are imported successfully")
    public boolean verifyProductsAreImported() {
        try {
            sleepFor(5);
            CenterlizePO centerlizePO = PageFactory.initElements(driver,CenterlizePO.class);
            Customers customers = PageFactory.initElements(driver,Customers.class);
            while (true){
                centerlizePO.clickOnButton(customers.getRefreshButton());
                /*WebElement e = new WebDriverWait(driver,60).
                        until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table[@id='ImportTable']//tbody//tr[1]//td[2]")));
                String record = e.getText();
                WebElement e1 = new WebDriverWait(driver,60).
                        until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table[@id='ImportTable']//tbody//tr[1]//td[4]")));
                String result = e1.getText();
                //driver.navigate().refresh();
                sleepFor(3);
                if (result.contains(record + " " + "Imported Successfully")){
                    break;
                }*/
                WebElement e = new WebDriverWait(driver,60).
                        until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table[@id='ImportTable']//tbody//tr[1]//td[3]//span")));
                if (e.getText().contains("Processed")){
                    System.out.println(e.getText());
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
     * @date 10 February 2021
     * @discription this method is use to Create Create a new Unity of measure product
     */
    @Step("Create a new Unity of measure product ")
    public boolean createNewUnityOfMeasureProduct() {
        CenterlizePO centerlizePO = PageFactory.initElements(driver, CenterlizePO.class);
        String testName = "Automation_UOM_01";
        try {
            sleepFor(3);
            centerlizePO.clickOnButton(getAddProductButton());
            sleepFor(3);
            centerlizePO.enterDataUsingSendkeys(getProductName(), testName);
            sleepFor(1);
            centerlizePO.enterDataUsingSendkeys(getProductType(),"PT UOM");
            Actions actions = new Actions(driver);
            actions.sendKeys(Keys.TAB).build().perform();
            centerlizePO.enterDataUsingSendkeys(getSuppliers(),"Automation Suppliers");
            actions.sendKeys(Keys.TAB).build().perform();
            centerlizePO.enterDataUsingSendkeys(getBrand(),"Automation Brand");
            actions.sendKeys(Keys.TAB).build().perform();
            sleepFor(2);
            centerlizePO.clickOnButton(getInventoryTrackingButton());
            List<WebElement> input = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//th[text()='On hand']//parent::tr//parent::thead//parent::table//tbody//input")));
            input.get(0).clear();
            input.get(0).sendKeys("100");
            sleepFor(1);
            List<WebElement> price = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//th[text()='Cost price']//parent::tr//parent::thead//parent::table//tbody//input")));
            price.get(0).clear();
            price.get(0).sendKeys("10");
            sleepFor(2);
            centerlizePO.clickOnButton(getActiveUnitOfMeasure());
            centerlizePO.clickOnButton(getAddNewRowButton());
            sleepFor(7);
            List<WebElement> UOMname = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//th[text()='UoM name']//parent::tr//parent::thead//parent::table//tbody//input")));
            UOMname.get(2).clear();
            sleepFor(5);
            UOMname.get(2).sendKeys(testName.split("_")[0].charAt(0)+ "_" +testName.split("_")[2]);
            UOMname.get(3).sendKeys("5");
            sleepFor(1);
            centerlizePO.clickOnButton(getProductSaveButton());
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
     * @date 10 February 2021
     * @discription this method is use to import multiple Unit of Measure using Import Button
     */
    @Step("import multiple Unit of Measure using Import Button")
    public boolean importUnitOfMeasureProductsUsingImportButton() {
        try {
            sleepFor(5);
            CenterlizePO centerlizePO = PageFactory.initElements(driver,CenterlizePO.class);
            Customers customers = PageFactory.initElements(driver,Customers.class);
            PageFactory.initElements(driver, ProductsPO.Products.class).clickOnProductsButtonn();
            sleepFor(2);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Products.class).getProductButton());
            sleepFor(2);
            centerlizePO.clickOnButton(customers.getImportButton());
            sleepFor(1);
            List<WebElement> list = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//ul//li//i[@class='icon-share-alt']//parent::a[text()]")));
            list.get(1).click();
            sleepFor(3);
            customers.getImportEXCELButton().sendKeys(System.getProperty("user.dir")+"\\xlsx File\\Import-Products\\UOMProduct.xlsx");
            sleepFor(3);
            centerlizePO.clickOnButton(customers.getContinueButton());
            sleepFor(1);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, LoyaltyPoints.class).getYesButton());
            sleepFor(1);
            centerlizePO.clickOnButton(customers.getOKButton());
            sleepFor(3);
            centerlizePO.clickOnButton(customers.getConnectedValidateButton());
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
     * @date 02 March 2021
     * @discription this method is use to enable serial number feature from product edit page
     */
    @Step("enable serial number feature from product edit page"+"\n"+"product:{0}")
    public boolean enableSerialNumberFeatureFromProductEditPage(String product) {
        ProductsPO.ProductsPO.Products products1 = PageFactory.initElements(driver, ProductsPO.ProductsPO.Products.class);
        CenterlizePO centerlizePO = PageFactory.initElements(driver,CenterlizePO.class);
        Actions actions = new Actions(driver);

        try {
            sleepFor(5);
            centerlizePO.clickOnButton(products1.getAddProductButton());
            sleepFor(2);
            centerlizePO.enterDataUsingSendkeys(products1.getProductName(), product);
            centerlizePO.clickOnButton(getSerialNumber());
            centerlizePO.clickOnButton(products1.getInventoryTrackingButton());
            List<WebElement> input = new WebDriverWait(driver,60).
                    until(ExpectedConditions.
                            presenceOfAllElementsLocatedBy(By.xpath
                                    ("//th[text()='On hand']//parent::tr//parent::thead//parent::table//tbody//input")));
            input.get(0).clear();
            input.get(0).sendKeys("100");
            sleepFor(2);
           /* centerlizePO.enterDataUsingSendkeys(products1.getProductType(),"S");
            actions.sendKeys(Keys.TAB).build().perform();
            centerlizePO.enterDataUsingSendkeys(products1.getSuppliers(),"Automation Suppliers");
            actions.sendKeys(Keys.TAB).build().perform();
            centerlizePO.enterDataUsingSendkeys(products1.getBrand(),"Automation Brand");
            actions.sendKeys(Keys.TAB).build().perform();*/
            List<WebElement> cost = new WebDriverWait(driver,60).
                    until(ExpectedConditions.
                            presenceOfAllElementsLocatedBy(By.xpath
                                    ("//th[text()='Cost price']//parent::tr//parent::thead//parent::table//tbody//input")));
            centerlizePO.enterDataUsingSendkeys(cost.get(5),Keys.CONTROL+ "a");
            centerlizePO.enterDataUsingSendkeys(cost.get(5), String.valueOf(Keys.DELETE));
            centerlizePO.enterDataUsingSendkeys(cost.get(5),"150");
            sleepFor(1);
            centerlizePO.clickOnButton(products1.getProductSaveButton());
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
     * @date 02 March 2021
     * @discription this method is use to verify sale flow
     */
    @Step("verify sale flow"+"\n"+"productName:{0}")
    public boolean verifySaleFlow(String productName) {
        CenterlizePO centerlizePO = PageFactory.initElements(driver,CenterlizePO.class);
        String serialNumber = "1234";
        try {
            sleepFor(5);
            PageFactory.initElements(driver, Inventory.class).clickOnInventoryButton();
            centerlizePO.clickOnButton(PageFactory.initElements(driver, PointofSale.class).getPointOfSaleButton());
            centerlizePO.clickOnButton(PageFactory.initElements(driver, ProcessSale.class).getProcessSaleButton());
            sleepFor(25);
            PageFactory.initElements(driver, ProcessSale.class).getSearchBar().sendKeys(productName);
            sleepFor(1);
            Actions actions = new Actions(driver);
            actions.sendKeys(Keys.TAB).build().perform();
            sleepFor(1);
            sleepFor(3);
            if (getSerialNumberTxtBox().getAttribute("class").contains("ng-empty")){
                sleepFor(1);
                PageFactory.initElements(driver, ProcessSale.class).getPayButton().getAttribute("disabled");
                WebElement color = new WebDriverWait(driver,60).until
                        (ExpectedConditions.presenceOfElementLocated
                                (By.xpath("//div[contains(text(),'Pay')]//parent::button//div[position()=1]")));
                if (color.getCssValue("background-color").contains("rgba(221,221,221,1)"))
                    System.out.println(" ");
            }
            sleepFor(1);
            centerlizePO.enterDataUsingSendkeys(getSerialNumberTxtBox(),serialNumber);
            WebElement color = new WebDriverWait(driver,60).until
                    (ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//div[contains(text(),'Pay')]//parent::button//div[position()=1]")));
            if (color.getCssValue("background-color").contains("rgba(43,189,185,1)"))
                System.out.println(" ");
            sleepFor(1);
            WebElement saleitem = new WebDriverWait(driver,60).until
                    (ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//div[contains(@class,'sell-item-title')]//span")));
            saleProductName=saleitem.getText();
            sleepFor(1);
            PageFactory.initElements(driver, ProcessSale.class).getSearchBar().sendKeys(saleProductName);
            sleepFor(1);
            actions.sendKeys(Keys.TAB).build().perform();
            sleepFor(1);
            centerlizePO.enterDataUsingSendkeys(getSerialNumberTxtBox(),serialNumber);
            sleepFor(3);
            WebElement errorMessgae = new WebDriverWait(driver,60).until
                    (ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//div[@class='swal-modal']//div[@class='swal-text']")));
            if (errorMessgae.getText().contains("Duplicate serial number"))
                System.out.println(" ");
            centerlizePO.clickOnButton(getOKButton());
            sleepFor(3);
            List<WebElement> e = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy
                            (By.xpath("//div[contains(@class,'sell-item-list')]//a[not(contains(@class,'ng-hide'))]")));
            for (int i=0;i<e.size();i++){
                sleepFor(1);
                e.get(i).click();
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
     * @date 28 october 2021
     * @discription this method is use to verify 8-digit alphanumeric option of Auto-generated barcode type
     */
    @Step("verify 8-digit alphanumeric option of Auto-generated barcode type"+"\n"+"productName:{0}")
    public boolean verify8DigitAlphanumericOption(String productName) {
        CenterlizePO centerlizePO = PageFactory.initElements(driver,CenterlizePO.class);
        try {
            sleepFor(3);
            PageFactory.initElements(driver, StoreSetup.class).clickOnStoreSetupButton();
            centerlizePO.clickOnButton(PageFactory.initElements(driver, General.class).getGeneralButton());
            sleepFor(3);
            Actions actions = new Actions(driver);
            actions.moveToElement(getAutoGeneratedBarcodeDropDown()).click().build().perform();
            sleepFor(2);
            WebElement option = new WebDriverWait(driver, 60)
                    .until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//label[@for='numericBarcodeGenerate']//following-sibling::div//a//following-sibling::div//li//ul//li//span[text()='8-digit alphanumeric']")));
            option.click();
            actions.moveToElement(PageFactory.initElements(driver, Users.class).getSaveButton()).build().perform();
            PageFactory.initElements(driver, Users.class).getSaveButton().click();
            sleepFor(13);

            PageFactory.initElements(driver, ProductsPO.Products.class).clickOnProductsButtonn();
            centerlizePO.clickOnButton(getProductButton());
            sleepFor(5);
            centerlizePO.clickOnButton(getAddProductButton());
            sleepFor(3);
            centerlizePO.enterDataUsingSendkeys(getProductName(), productName);
            sleepFor(1);
            centerlizePO.clickOnButton(getProductSaveButton());
            sleepFor(5);
            sleepFor(1);
            centerlizePO.enterDataUsingSendkeys(getSearchBox(), productName);
            sleepFor(2);
            List<WebElement> list = new WebDriverWait(driver,120).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy
                            (By.xpath("//ul[contains(@class,'hike-width-block')]//b[text()='Product']//parent::ul//li//a")));
            list.get(0).click();
            sleepFor(5);
            WebElement name = new WebDriverWait(driver,60).
                    until(ExpectedConditions.visibilityOfElementLocated
                            (By.xpath("//table[@id='RosterDataTable']//tbody//tr//td[2]//span[text()='" + productName + "']//parent::td")));
            name.click();
            sleepFor(3);
            String barcodeLength = gerBarcode().getAttribute("value");
            if(barcodeLength.length()==8)
            {
                String digits="";
                for (int i = 0; i < barcodeLength.length(); i++) {
                    char chrs = barcodeLength.charAt(i);
                    if (Character.isDigit(chrs))
                        digits = digits+chrs;
                }

                String alpha="";
                for (int i = 0; i < barcodeLength.length(); i++) {
                    char chrs = barcodeLength.charAt(i);
                    if (Character.isLetter(chrs))
                        alpha = alpha+chrs;
                }

                if (alpha.length() != 0) {
                    if (digits.length()+alpha.length()==8){
                        System.out.println("it's 8-digit alphanumeric barcode.....................");
                    }else {
                        return false;
                    }
                }else {
                    System.out.println("\n\n"+"alpha number not available"+"\n\n");
                    return false;
                }

            }else {
                return false;
            }
            sleepFor(3);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("alpha number not available");
            return false;
        }
    }


    /**
     * @return
     * @throws Exception
     * @author Vidhi Chapanera
     * @date 28 october 2021
     * @discription this method is use to verify 13-digit numeric option of Auto-generated barcode type
     */
    @Step("verify 13-digit Numeric option of Auto-generated barcode type"+"\n"+"productName:{0}")
    public boolean verify13DigitNumericOption(String productName) {
        CenterlizePO centerlizePO = PageFactory.initElements(driver,CenterlizePO.class);
        try {
            sleepFor(3);
            PageFactory.initElements(driver, StoreSetup.class).clickOnStoreSetupButton();
            centerlizePO.clickOnButton(PageFactory.initElements(driver, General.class).getGeneralButton());
            sleepFor(3);
            Actions actions = new Actions(driver);
            actions.moveToElement(getAutoGeneratedBarcodeDropDown()).click().build().perform();
            sleepFor(2);
            WebElement option = new WebDriverWait(driver, 60)
                    .until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//label[@for='numericBarcodeGenerate']//following-sibling::div//a//following-sibling::div//li//ul//li//span[text()='13-digit numeric']")));
            option.click();
            actions.moveToElement(PageFactory.initElements(driver, Users.class).getSaveButton()).build().perform();
            PageFactory.initElements(driver, Users.class).getSaveButton().click();
            sleepFor(13);

            PageFactory.initElements(driver, ProductsPO.Products.class).clickOnProductsButtonn();
            centerlizePO.clickOnButton(getProductButton());
            sleepFor(5);
            centerlizePO.clickOnButton(getAddProductButton());
            sleepFor(3);
            centerlizePO.enterDataUsingSendkeys(getProductName(), productName);
            sleepFor(1);
            centerlizePO.clickOnButton(getProductSaveButton());
            sleepFor(5);
            sleepFor(1);
            centerlizePO.enterDataUsingSendkeys(getSearchBox(), productName);
            sleepFor(2);
            List<WebElement> list = new WebDriverWait(driver,120).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy
                            (By.xpath("//ul[contains(@class,'hike-width-block')]//b[text()='Product']//parent::ul//li//a")));
            list.get(0).click();
            sleepFor(5);
            WebElement name = new WebDriverWait(driver,60).
                    until(ExpectedConditions.visibilityOfElementLocated
                            (By.xpath("//table[@id='RosterDataTable']//tbody//tr//td[2]//span[text()='" + productName + "']//parent::td")));
            name.click();
            sleepFor(3);
            String barcodeLength = gerBarcode().getAttribute("value");
            if(barcodeLength.length()==13)
            {
                String digits="";
                for (int i = 0; i < barcodeLength.length(); i++)
                {
                    char chrs = barcodeLength.charAt(i);
                    if (Character.isDigit(chrs))
                        digits = digits+chrs;
                }

                if (digits.length()==13)
                {
                    System.out.println("it's 16-digit numeric barcode.....................");
                }
                else
                {
                    System.out.println("length----------"+digits.length());
                    return false;
                }

            }
            else
            {
                return false;
            }
            sleepFor(3);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

}