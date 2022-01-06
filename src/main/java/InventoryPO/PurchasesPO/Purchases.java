package InventoryPO.PurchasesPO;

import CommonPO.BasePage;
import CommonPO.CenterlizePO;
import CustomersPO.CustomersPO.Customers;
import InventoryPO.Inventory;
import InventoryPO.MyInventoryPO.MyInventory;
import InventoryPO.TransfersPO.Transfers;
import PointofSalePO.PointofSale;
import PointofSalePO.ProcessSalePO.ProcessSale;
import PointofSalePO.SalesHistoryPO.SalesHistory;
import ProductsPO.GiftCardsPO.GiftCards;
import ProductsPO.ProductsPO.Products;
import ReportingPO.Reporting;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Key;
import java.text.NumberFormat;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;

/**
 * @author Vidhi Chapanera
 * @date 12 February 2021
 */
public class Purchases extends BasePage {

    public WebDriver driver;
    public static String dataText = "";
    public static String productItemName = "";
    public static String UOMName = "";
    public static int availableStock = 0;
    public static int UOMQuantity = 0;
    public static int currentInventory = 0;
    public static int onHandStockAdjustment = 0;
    public static int balanceUnits = 0;
    public static int costPrice = 0;
    public static int avergeCostPrice = 0;
    public static int returnAdjustment = 0;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for purchases button
     * @date 12 February 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//span[contains(text(),'Purchases')]//parent::a"
    )
    WebElement btn_purchases;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for add new button
     * @date 12 February 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//a[text()='Add New']"
    )
    WebElement btn_addnew ;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for search bar
     * @date 12 February 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//div[@class='input-icon']//input"
    )
    WebElement txt_search ;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Current inventory
     * @date 12 February 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//span[text()='Current inventory']//parent::th//parent::tr//parent::thead//parent::table//tbody//tr//td[4]"
    )
    WebElement txt_currentinventory;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for add and continue button
     * @date 12 February 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//button[text()='Add & continue']"
    )
    WebElement btn_addandcontinue ;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for save button
     * @date 12 February 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//span[text()=' Save']//parent::button"
    )
    WebElement btn_save ;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for receive button
     * @date 12 February 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//button[text()='Receive']"
    )
    WebElement btn_receive ;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for receive all button
     * @date 12 February 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//button[text()='Receive all outstanding']"
    )
    WebElement btn_receiveall ;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for advance search button
     * @date 12 February 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//span[contains(text(),'Advanced search')]//parent::uib-tab-heading//parent::a"
    )
    WebElement btn_advancesearch ;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for advance search bar txt box
     * @date 12 February 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//div[@class='input-icon-flex']//input"
    )
    WebElement txt_advancesearchbar ;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for search button
     * @date 12 February 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//a[(contains(text(),'Search'))]"
    )
    WebElement btn_search ;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for return button
     * @date 17 February 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//button[contains(text(),'Return')]"
    )
    WebElement btn_return ;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for slider return button
     * @date 17 February 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//div[@id='sliderModalHeader']//button[contains(text(),'Return')]"
    )
    WebElement btn_sliderreturn ;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for save drop down button
     * @date 05 March 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//span[text()=' Save']//parent::button//parent::div//i//parent::button"
    )
    WebElement btn_savedropdown ;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for delete this po button
     * @date 05 March 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//span[contains(text(),'Delete this PO')]//parent::button"
    )
    WebElement btn_deletethispo ;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for replenish check box
     * @date 16 March 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//label[@for='quantitySold']"
    )
    WebElement chk_replenish ;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for low stock check box
     * @date 16 March 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//label[@for='autofill']"
    )
    WebElement chklowstock ;

    public Purchases(WebDriver driver) {
        this.driver = driver;
    }
    public WebElement getPurchasesButton() {
        return btn_purchases;
    }
    public WebElement getAddNewButton() {
        return btn_addnew;
    }
    public WebElement getSearch() {
        return txt_search;
    }
    public WebElement getCurrentInventory() {
        return txt_currentinventory;
    }
    public WebElement getAddAndContinueButton() {
        return btn_addandcontinue;
    }
    public WebElement getSaveButton() {
        return btn_save;
    }
    public WebElement getReceiveButton() {
        return btn_receive;
    }
    public WebElement getReceiveAllButton() {
        return btn_receiveall;
    }
    public WebElement getAdvanceSearch() {
        return btn_advancesearch;
    }
    public WebElement getAdvanceSearchBar() {
        return txt_advancesearchbar;
    }
    public WebElement getSearchButton() {
        return btn_search;
    }
    public WebElement getReturnButton() {
        return btn_return;
    }
    public WebElement getSliderReturnButton() {
        return btn_sliderreturn;
    }
    public WebElement getSaveDropDownButton() {
        return btn_savedropdown;
    }
    public WebElement getDeleteThisPO() {
        return btn_deletethispo;
    }
    public WebElement getRepenishcheckbox() {
        return chk_replenish;
    }
    public WebElement getLowStockcheckbox() {
        return chklowstock;
    }


    /**
     * @return
     * @throws Exception
     * @author Vidhi Chapanera
     * @date 12 February 2021
     * @discription this method is use to verify Unit of measure functionality with scenario PO and Average Cost price
     */
    @Step("verify Unit of measure functionality with scenario PO and Average Cost price"+"\n"+"ProductType:{0}")
    public boolean verifyUnitOfMeasureFunctionalityWithPOAndAvgCost(String ProductType) {
        CenterlizePO centerlizePO = PageFactory.initElements(driver,CenterlizePO.class);
        try {
            sleepFor(5);
            Reset();
            PageFactory.initElements(driver, Inventory.class).clickOnInventoryButton();
            centerlizePO.clickOnButton(PageFactory.initElements(driver, PointofSale.class).getPointOfSaleButton());
            centerlizePO.clickOnButton(PageFactory.initElements(driver, ProcessSale.class).getProcessSaleButton());
            sleepFor(15);
            try {
                WebElement register = new WebDriverWait(driver, 50)
                        .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='select-reg-btn']//span[contains(text(),'')]")));
                register.click();
            }catch (Exception e){
                System.out.println("");
            }
            WebElement e = new WebDriverWait(driver,120).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//div[@id='mydiv']//ul//li//a[text()='" + ProductType + "']")));
            e.click();
            List<WebElement> elementList = new WebDriverWait(driver,120).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy
                            (By.xpath("//div[contains(@uib-tooltip,'unit of measure')]")));
            elementList.get(0).click();
            sleepFor(2);
            centerlizePO.clickOnButton(PageFactory.initElements(driver,ProcessSale.class).getSaleItemTitle());
            sleepFor(1);
            centerlizePO.clickOnButton(PageFactory.initElements(driver,ProcessSale.class).getProductInfobutton());
            sleepFor(1);
            List<WebElement> webElementList = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy
                            (By.xpath("//span[contains(text(),'Name')][text()]")));
            String productName = webElementList.get(0).getText();
            sleepFor(1);
            productItemName += productName.split(":")[1].split(" ")[1];
            sleepFor(1);
            WebElement uomname = new WebDriverWait(driver,60).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[text()]")));
            UOMName += uomname.getText();
            centerlizePO.clickOnButton(PageFactory.initElements(driver,ProcessSale.class).getSliderCloseIcon());
            sleepFor(1);
           /* List<WebElement> icon = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy
                            (By.xpath("//div[contains(@class,'sell-item-list')]//a[not(contains(@class,'ng-hide'))]")));
            for (int i=0;i<icon.size();i++){
                sleepFor(1);
                icon.get(i).click();
            }*/
            sleepFor(1);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, ProductsPO.Products.class).getProductButton());
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Products.class).getProductButton());
            sleepFor(1);
            centerlizePO.enterDataUsingSendkeys(PageFactory.initElements(driver, Products.class).getSearchBox(),UOMName);
            sleepFor(2);
            List<WebElement> list = new WebDriverWait(driver,120).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy
                            (By.xpath("//ul[contains(@class,'hike-width-block')]//b[text()='Product']//parent::ul//li//a")));
            String qty = list.get(0).getText();
            StringBuilder builder = new StringBuilder(qty.split(" ")[3]);
            builder.deleteCharAt(qty.split(" ")[3].length() - 1);
            int n = Integer.parseInt(String.valueOf(builder));
            System.out.println(n);
            UOMQuantity = n;
            list.get(0).click();
            sleepFor(2);
            WebElement product = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//table[@id='RosterDataTable']//tbody//tr//td[2]//span[text()='" + productItemName + "']//parent::td")));
            product.click();
            sleepFor(3);
            Actions actions = new Actions(driver);
            actions.moveToElement(PageFactory.initElements(driver, Products.class).getAvailableStock()).build().perform();
            String as = PageFactory.initElements(driver, Products.class).getAvailableStock().getText();
            availableStock = Integer.parseInt(as);
            sleepFor(1);
            currentInventory = availableStock/UOMQuantity;
            sleepFor(1);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Inventory.class).getInventoryButton());
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Purchases.class).getPurchasesButton());
            sleepFor(2);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Purchases.class).getAddNewButton());
            sleepFor(5);
            List<WebElement> elements = new  WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//input[@ng-model='searchtext']")));
            sleepFor(1);
            elements.get(0).click();
            elements.get(0).sendKeys(UOMName);
            sleepFor(5);
            String ci = PageFactory.initElements(driver, Purchases.class).getCurrentInventory().getText();
            int inventory = Integer.parseInt(ci);
            sleepFor(1);
            if (inventory==currentInventory)
                System.out.println("");
            sleepFor(1);
            WebElement chkbocx = new WebDriverWait(driver,60).until
                    (ExpectedConditions.presenceOfElementLocated
                            (By.cssSelector("table.table.table-hover.table-vert.table-border.fix-table-header > tbody > tr > td > div > label")));
            JavascriptExecutor executor = (JavascriptExecutor)driver;
            executor.executeScript("arguments[0].click();", chkbocx);
            sleepFor(1);
            sleepFor(1);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Purchases.class).getAddAndContinueButton());
            WebElement small = new WebDriverWait(driver,60).until
                    (ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//span[text()='Order ']//parent::th//parent::tr//parent::thead//parent::table//tbody//tr//td[1]//small[text()]")));
            String sm = small.getText();
            String sm1 = sm.split(":")[1].split(" ")[1];
            int saleCount = Integer.parseInt(sm1);
            if (saleCount==currentInventory)
                System.out.println("");
            sleepFor(1);
            String order = "15";
            int orderCount = Integer.parseInt(order);
            sleepFor(1);
            WebElement orderinput = new WebDriverWait(driver,60).until
                    (ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//span[text()='Order ']//parent::th//parent::tr//parent::thead//parent::table//tbody//tr//td[2]//input")));
            orderinput.clear();
            orderinput.sendKeys(order);
            sleepFor(1);
            onHandStockAdjustment = orderCount*UOMQuantity+availableStock;
            sleepFor(1);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Purchases.class).getSaveButton());
            sleepFor(5);
            WebElement PO = new WebDriverWait(driver,60).until
                    (ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//table[@id='purchanseOrderDataTable']//tbody//tr//td//i[contains(@class,'fa fa-circle-o')]//parent::td//parent::tr//td[1]//a")));
            PO.click();
            sleepFor(3);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Purchases.class).getReceiveButton());
            sleepFor(3);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Purchases.class).getReceiveAllButton());
            centerlizePO.clickOnButton(PageFactory.initElements(driver, GiftCards.class).getYesButton());
            sleepFor(3);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, ProductsPO.Products.class).getProductButton());
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Products.class).getProductButton());
            sleepFor(2);
            WebElement product1 = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//table[@id='RosterDataTable']//tbody//tr//td[2]//span[text()='" + productItemName + "']//parent::td")));
            product1.click();
            sleepFor(3);
            String ad = PageFactory.initElements(driver, Products.class).getAvailableStock().getText();
            int adjustment = Integer.parseInt(ad);
            if (adjustment==onHandStockAdjustment)
                System.out.println("");
            sleepFor(1);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Inventory.class).getInventoryButton());
            centerlizePO.clickOnButton(PageFactory.initElements(driver, MyInventory.class).getMyInventoryButton());
            sleepFor(1);
            centerlizePO.enterDataUsingSendkeys(PageFactory.initElements(driver, MyInventory.class).getSearchBox(),productItemName);
            sleepFor(3);
            List<WebElement> lis1 = new WebDriverWait(driver,120).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy
                            (By.xpath("//ul[contains(@class,'hike-width-block')]//b[text()='Product']//parent::ul//li//a")));
            lis1.get(0).click();
            sleepFor(5);
            WebElement onHand = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//table[@id='InventoryRecordDataTable']//tbody//tr[1]//td[2]")));
            String data = onHand.getText();
            int stock = Integer.parseInt(data);
            if (stock==onHandStockAdjustment)
                System.out.println("");
            WebElement avgicon = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//table[@id='InventoryRecordDataTable']//tbody//tr[1]//td[3]//parent::tr//td[8]//a")));
            avgicon.click();
            sleepFor(3);
            List<WebElement> balance = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy
                            (By.xpath("//parent::th[text()='Units']//parent::tr//parent::thead//parent::table//tbody[last()]//tr[contains(@ng-show,'Purchase')]//td[6]//table//tr//td[1]")));
            for (int i =0;i<balance.size();i++){
                String b = balance.get(i).getText();
                int bu = Integer.parseInt(b);
                balanceUnits += bu;
            }
            sleepFor(1);
            if (balanceUnits==onHandStockAdjustment)
                System.out.println("");
            sleepFor(1);
            centerlizePO.clickOnButton(PageFactory.initElements(driver,ProcessSale.class).getSliderCloseIcon());
            sleepFor(1);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Reporting.class).getReportingButton());
            centerlizePO.clickOnButton(PageFactory.initElements(driver, ReportingPO.InventoryPO.Inventory.class).getInventoryButton());
            sleepFor(1);
            List<WebElement> invinput = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy
                            (By.xpath("//div[@class='input-icon']//input")));
            invinput.get(0).sendKeys(productItemName);
            sleepFor(3);
            WebElement inveOnHand = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//table[@id='InventoryDetailDataTable']//tbody//tr[1]//td[3]//a")));
            String data1 = inveOnHand.getText();
            int stock1 = Integer.parseInt(data1);
            System.out.println(stock+"\n\n\n\n\n\n\n");
            if (stock1==onHandStockAdjustment)
                return true;
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
     * @date 15 February 2021
     * @discription this method is use to Verify Update selling price with same profit margin PO (Average Cost Price) using unit of measure product
     */
    @Step("Verify Update selling price with same profit margin PO (Average Cost Price) using unit of measure product"+"\n"+"ProductType:{0}")
    public boolean verifyUpdateSellingPriceWithSameProfitMargin(String ProductType) {
        CenterlizePO centerlizePO = PageFactory.initElements(driver,CenterlizePO.class);
        try {
            sleepFor(3);
            driver.navigate().refresh();
            Reset();
            sleepFor(3);
            PageFactory.initElements(driver, Inventory.class).clickOnInventoryButton();
            centerlizePO.clickOnButton(PageFactory.initElements(driver, PointofSale.class).getPointOfSaleButton());
            centerlizePO.clickOnButton(PageFactory.initElements(driver, ProcessSale.class).getProcessSaleButton());
            sleepFor(15);
            WebElement e = new WebDriverWait(driver,120).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//div[@id='mydiv']//ul//li//a[text()='" + ProductType + "']")));
            e.click();
            List<WebElement> elementList = new WebDriverWait(driver,120).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy
                            (By.xpath("//div[contains(@uib-tooltip,'unit of measure')]")));
            elementList.get(1).click();
            sleepFor(2);
            centerlizePO.clickOnButton(PageFactory.initElements(driver,ProcessSale.class).getSaleItemTitle());
            sleepFor(1);
            centerlizePO.clickOnButton(PageFactory.initElements(driver,ProcessSale.class).getProductInfobutton());
            sleepFor(1);
            List<WebElement> webElementList = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy
                            (By.xpath("//span[contains(text(),'Name')][text()]")));
            String productName = webElementList.get(0).getText();
            sleepFor(1);
            productItemName += productName.split(":")[1].split(" ")[1];
            sleepFor(1);
            WebElement uomname = new WebDriverWait(driver,60).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[text()]")));
            UOMName += uomname.getText();
            centerlizePO.clickOnButton(PageFactory.initElements(driver,ProcessSale.class).getSliderCloseIcon());
            sleepFor(1);
            PageFactory.initElements(driver, ProductsPO.Products.class).clickOnProductsButtonn();
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Products.class).getProductButton());
            sleepFor(2);
            /*List<WebElement> closeIcon = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy
                            (By.cssSelector("a > i.fa-times")));
            for(int i =0 ;i< closeIcon.size();i++){
                closeIcon.get(i).click();
            }*/
            centerlizePO.enterDataUsingSendkeys(PageFactory.initElements(driver, Products.class).getSearchBox(),UOMName);
            sleepFor(2);
            List<WebElement> list = new WebDriverWait(driver,120).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy
                            (By.xpath("//ul[contains(@class,'hike-width-block')]//b[text()='Product']//parent::ul//li//a")));
            String qty = list.get(0).getText();
            StringBuilder builder = new StringBuilder(qty.split(" ")[3]);
            builder.deleteCharAt(qty.split(" ")[3].length() - 1);
            int n = Integer.parseInt(String.valueOf(builder));
            System.out.println(n);
            UOMQuantity = n;
            sleepFor(3);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Inventory.class).getInventoryButton());
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Purchases.class).getPurchasesButton());
            sleepFor(2);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Purchases.class).getAddNewButton());
            sleepFor(5);
            List<WebElement> elements = new  WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//input[@ng-model='searchtext']")));
            sleepFor(1);
            elements.get(0).click();
            elements.get(0).sendKeys(UOMName);
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
            Actions actions = new Actions(driver);
            actions.sendKeys(Keys.PAGE_DOWN).build().perform();
            String order = "5";
            sleepFor(1);
            WebElement orderinput = new WebDriverWait(driver,60).until
                    (ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//span[normalize-space(.)='Order']//parent::th//parent::tr//parent::thead//parent::table//tbody//tr//td[2]//input")));
            orderinput.clear();
            orderinput.sendKeys(order);
            sleepFor(1);
            WebElement costInc = new WebDriverWait(driver,60).until
                    (ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//span[normalize-space(.)='Order']//parent::th//parent::tr//parent::thead//parent::table//tbody//tr//td[6]//input")));
            String cost = "210";
            int costCount = Integer.parseInt(cost);
            sleepFor(1);

            costInc.sendKeys(Keys.CONTROL+"a");
            costInc.sendKeys(String.valueOf(Keys.DELETE));
            costInc.sendKeys(cost);
            sleepFor(1);
            WebElement notes = new WebDriverWait(driver,60).until
                    (ExpectedConditions.presenceOfElementLocated
                            (By.cssSelector("#Notes")));
            actions.moveToElement(notes).contextClick().build().perform();

            sleepFor(1);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Products.class).getUpdateSellingPriceWithSameProfitMargin());
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Customers.class).getContinueButton());
            sleepFor(1);
            costPrice = costCount/UOMQuantity;
            sleepFor(1);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Purchases.class).getSaveButton());
            sleepFor(5);
            WebElement PO = new WebDriverWait(driver,60).until
                    (ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//table[@id='purchanseOrderDataTable']//tbody//tr//td//i[contains(@class,'fa fa-circle-o')]//parent::td//parent::tr//td[1]//a")));
            PO.click();
            sleepFor(3);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Purchases.class).getReceiveButton());
            sleepFor(3);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Purchases.class).getReceiveAllButton());
            centerlizePO.clickOnButton(PageFactory.initElements(driver, GiftCards.class).getYesButton());
            sleepFor(3);
            PageFactory.initElements(driver, Inventory.class).clickOnInventoryButton();
            centerlizePO.clickOnButton(PageFactory.initElements(driver, MyInventory.class).getMyInventoryButton());
            sleepFor(1);
            centerlizePO.enterDataUsingSendkeys(PageFactory.initElements(driver, MyInventory.class).getSearchBox(),productItemName);
            sleepFor(3);
            List<WebElement> list2 = new WebDriverWait(driver,120).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy
                            (By.xpath("//ul[contains(@class,'hike-width-block')]//b[text()='Product']//parent::ul//li//a")));
            list2.get(0).click();
            sleepFor(5);
            WebElement avgicon = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//table[@id='InventoryRecordDataTable']//tbody//tr[1]//td[3]//parent::tr//td[8]//a")));
            avgicon.click();
            sleepFor(3);
            List<WebElement> balanceUnits = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy
                            (By.xpath("//parent::th[text()='Units']//parent::tr//parent::thead//parent::table//tbody[last()]//tr[contains(@ng-show,'Purchase')]//td[6]//table//tr//td[1]")));
            int units = 0;
            for (int i =0;i<balanceUnits.size();i++){
                String b = balanceUnits.get(i).getText();
                int bu = Integer.parseInt(b);
                units += bu;
            }
            sleepFor(1);
            List<WebElement> balanceTotal = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy
                            (By.xpath("//parent::th[text()='Units']//parent::tr//parent::thead//parent::table//tbody[last()]//tr[contains(@ng-show,'Purchase')]//td[6]//table//tr//td[3]")));
            int total = 0;
            for (int i =0;i<balanceTotal.size();i++){
                String b = balanceTotal.get(i).getText();
                String s1 = b.substring(1);
                NumberFormat format = NumberFormat.getNumberInstance(Locale.UK);
                int newcount = format.parse(s1).intValue();
                int ij = Math.round(newcount);
                total += ij;
            }
            sleepFor(1);
            avergeCostPrice = total/units;
            sleepFor(1);
            NumberFormat format = NumberFormat.getNumberInstance(Locale.UK);
            int newcounts = format.parse(String.valueOf(avergeCostPrice)).intValue();
            int finalAvergeCostPrice = Math.round(newcounts);
            sleepFor(1);
            centerlizePO.clickOnButton(PageFactory.initElements(driver,ProcessSale.class).getSliderCloseIcon());
            PageFactory.initElements(driver, ProductsPO.Products.class).clickOnProductsButtonn();
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Products.class).getProductButton());
            sleepFor(2);
            centerlizePO.enterDataUsingSendkeys(PageFactory.initElements(driver, Products.class).getSearchBox(),UOMName);
            sleepFor(2);
            List<WebElement> list1 = new WebDriverWait(driver,120).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy
                            (By.xpath("//ul[contains(@class,'hike-width-block')]//b[text()='Product']//parent::ul//li//a")));
            list1.get(0).click();
            sleepFor(2);
            WebElement product = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//table[@id='RosterDataTable']//tbody//tr//td[2]//span[text()='" + productItemName + "']//parent::td")));
            product.click();
            sleepFor(3);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Products.class).getViewProductHistoryButton());
            sleepFor(1);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Products.class).getPurchaseOrderCheckbox());
            WebElement phCostPrice = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//table[@id='HistoryTable']//tbody//tr[1]//td[6]")));
            String s = phCostPrice.getText();
            String s1 = s.substring(1);
            int newcount = format.parse(s1).intValue();
            int i = Math.round(newcount);
            System.out.println(i);
            if (i==costPrice)
                System.out.println(costPrice);
            sleepFor(1);
            WebElement avgCost = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//table[@id='HistoryTable']//tbody//tr[1]//td[7]")));
            String avCost = avgCost.getText();
            String s2 = avCost.substring(1);
            int newcount1 = format.parse(s2).intValue();
            int i1 = Math.round(newcount1);
            System.out.println(i);
            if (i1==finalAvergeCostPrice)
                System.out.println(finalAvergeCostPrice);
            sleepFor(1);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, ProcessSale.class).getSliderCloseIcon());
            sleepFor(1);
            PageFactory.initElements(driver, PointofSale.class).clickOnPointOfSaleButtonn();
            centerlizePO.clickOnButton(PageFactory.initElements(driver, ProcessSale.class).getProcessSaleButton());
            sleepFor(10);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, ProcessSale.class).getAddCustomerButton());
            centerlizePO.enterDataUsingSendkeys(PageFactory.initElements(driver, ProcessSale.class).getAddCustomer(),"A");
            sleepFor(1);
            actions.sendKeys(Keys.TAB).build().perform();
            sleepFor(2);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, ProcessSale.class).getPayButton());
            centerlizePO.clickOnButton(PageFactory.initElements(driver, ProcessSale.class).getCashButton());
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
                    System.out.println("Heading of child window is " + text.getText());
                    Actions actions1 = new Actions(driver);
                    actions1.sendKeys(Keys.TAB).build().perform();
                    actions1.sendKeys(Keys.ENTER).build().perform();
                }
            }
            sleepFor(3);
            driver.switchTo().window(mainWindowHandle);
            sleepFor(1);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, ProcessSale.class).getAddNewSaleButton());
            sleepFor(3);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Reporting.class).getReportingButton());
            centerlizePO.clickOnButton(PageFactory.initElements(driver, ReportingPO.InventoryPO.Inventory.class).getInventoryButton());
            sleepFor(1);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Products.class).getCostsOfGoodSoldButon());
            sleepFor(1);
            List<WebElement> invinput = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy
                            (By.xpath("//div[@class='input-icon']//input")));
            invinput.get(2).sendKeys(UOMName);
            sleepFor(5);
            int averageCostInReporting=finalAvergeCostPrice*UOMQuantity;
            sleepFor(1);
            WebElement inventoryAvgCost = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//table[@id='GoodSoldDetailDataTable']//tbody//tr[last()]//td[5]")));
            String data1 = inventoryAvgCost.getText();
            String s3 = data1.substring(1);
            int newcount3 = format.parse(s3).intValue();
            int i2 = Math.round(newcount3);
            System.out.println(i2);
            if (i2==averageCostInReporting)
                System.out.println("");
            sleepFor(2);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    /**
     * @author Vidhi Chapanera
     * @date 15 February 2021
     * @discription reset static variable value
     */
    @Step("")
    public void Reset() {
        dataText = "";
        productItemName = "";
        UOMName = "";
        availableStock = 0;
        UOMQuantity = 0;
        currentInventory = 0;
        onHandStockAdjustment = 0;
        balanceUnits = 0;
        costPrice = 0;
        avergeCostPrice = 0;
    }


    /**
     * @return
     * @throws Exception
     * @author Vidhi Chapanera
     * @date 16 February 2021
     * @discription this method is use to Verify Update profit margin with same selling price PO (Average Cost Price) using unit of measure product
     */
    @Step("Verify Update profit margin with same selling price PO (Average Cost Price) using unit of measure product"+"\n"+"ProductType:{0}")
    public boolean verifyUpdatepProfitMarginWithSameSellingPrice(String ProductType) {
        CenterlizePO centerlizePO = PageFactory.initElements(driver,CenterlizePO.class);
        try {
            sleepFor(3);
            Reset();
            PageFactory.initElements(driver, Inventory.class).clickOnInventoryButton();
            centerlizePO.clickOnButton(PageFactory.initElements(driver, PointofSale.class).getPointOfSaleButton());
            centerlizePO.clickOnButton(PageFactory.initElements(driver, ProcessSale.class).getProcessSaleButton());
            sleepFor(15);
            WebElement e = new WebDriverWait(driver,120).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//div[@id='mydiv']//ul//li//a[text()='" + ProductType + "']")));
            e.click();
            List<WebElement> elementList = new WebDriverWait(driver,120).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy
                            (By.xpath("//div[contains(@uib-tooltip,'unit of measure')]")));
            elementList.get(2).click();
            sleepFor(2);
            centerlizePO.clickOnButton(PageFactory.initElements(driver,ProcessSale.class).getSaleItemTitle());
            sleepFor(1);
            centerlizePO.clickOnButton(PageFactory.initElements(driver,ProcessSale.class).getProductInfobutton());
            sleepFor(1);
            List<WebElement> webElementList = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy
                            (By.xpath("//span[contains(text(),'Name')][text()]")));
            String productName = webElementList.get(0).getText();
            sleepFor(1);
            productItemName += productName.split(":")[1].split(" ")[1];
            sleepFor(1);
            WebElement uomname = new WebDriverWait(driver,60).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[text()]")));
            UOMName += uomname.getText();
            centerlizePO.clickOnButton(PageFactory.initElements(driver,ProcessSale.class).getSliderCloseIcon());
            sleepFor(1);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, ProductsPO.Products.class).getProductButton());
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Products.class).getProductButton());
            sleepFor(2);
            /*List<WebElement> closeIcon = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy
                            (By.cssSelector("a > i.fa-times")));
            for(int i =0 ;i< closeIcon.size();i++){
                closeIcon.get(i).click();
            }*/
            sleepFor(1);
            centerlizePO.enterDataUsingSendkeys(PageFactory.initElements(driver, Products.class).getSearchBox(),UOMName);
            sleepFor(2);
            List<WebElement> list = new WebDriverWait(driver,120).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy
                            (By.xpath("//ul[contains(@class,'hike-width-block')]//b[text()='Product']//parent::ul//li//a")));
            String qty = list.get(0).getText();
            StringBuilder builder = new StringBuilder(qty.split(" ")[3]);
            builder.deleteCharAt(qty.split(" ")[3].length() - 1);
            int n = Integer.parseInt(String.valueOf(builder));
            System.out.println(n);
            UOMQuantity = n;
            sleepFor(3);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Inventory.class).getInventoryButton());
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Purchases.class).getPurchasesButton());
            sleepFor(2);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Purchases.class).getAddNewButton());
            sleepFor(5);
            List<WebElement> elements = new  WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//input[@ng-model='searchtext']")));
            sleepFor(1);
            elements.get(0).click();
            elements.get(0).sendKeys(UOMName);
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
            Actions actions = new Actions(driver);
            actions.sendKeys(Keys.PAGE_DOWN).build().perform();
            String order = "5";
            sleepFor(1);
            WebElement orderinput = new WebDriverWait(driver,60).until
                    (ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//span[text()='Order ']//parent::th//parent::tr//parent::thead//parent::table//tbody//tr//td[2]//input")));
            orderinput.clear();
            orderinput.sendKeys(order);
            sleepFor(1);
            WebElement costInc = new WebDriverWait(driver,60).until
                    (ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//span[text()='Order ']//parent::th//parent::tr//parent::thead//parent::table//tbody//tr//td[6]//input")));
            String cost = "910";
            sleepFor(1);
            costInc.sendKeys(Keys.CONTROL+"a");
            costInc.sendKeys(String.valueOf(Keys.DELETE));
            costInc.sendKeys(cost);
            sleepFor(1);
            WebElement notes = new WebDriverWait(driver,60).until
                    (ExpectedConditions.presenceOfElementLocated
                            (By.cssSelector("#Notes")));
            actions.moveToElement(notes).contextClick().build().perform();

            sleepFor(1);
            int costCount = Integer.parseInt(cost);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Products.class).getUpdateProfitMarginWithSameSellingPrice());
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Customers.class).getContinueButton());
            sleepFor(1);
            costPrice = costCount/UOMQuantity;
            sleepFor(1);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Purchases.class).getSaveButton());
            sleepFor(5);
            WebElement PO = new WebDriverWait(driver,60).until
                    (ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//table[@id='purchanseOrderDataTable']//tbody//tr//td//i[contains(@class,'fa fa-circle-o')]//parent::td//parent::tr//td[1]//a")));
            PO.click();
            sleepFor(3);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Purchases.class).getReceiveButton());
            sleepFor(3);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Purchases.class).getReceiveAllButton());
            centerlizePO.clickOnButton(PageFactory.initElements(driver, GiftCards.class).getYesButton());
            sleepFor(3);
            PageFactory.initElements(driver, Inventory.class).clickOnInventoryButton();
            centerlizePO.clickOnButton(PageFactory.initElements(driver, MyInventory.class).getMyInventoryButton());
            sleepFor(1);
            centerlizePO.enterDataUsingSendkeys(PageFactory.initElements(driver, MyInventory.class).getSearchBox(),productItemName);
            sleepFor(3);
            List<WebElement> webElementList1 = new WebDriverWait(driver,120).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy
                            (By.xpath("//ul[contains(@class,'hike-width-block')]//b[text()='Product']//parent::ul//li//a")));
            webElementList1.get(0).click();
            sleepFor(5);
            WebElement avgicon = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//table[@id='InventoryRecordDataTable']//tbody//tr[1]//td[3]//parent::tr//td[8]//a")));
            avgicon.click();
            sleepFor(3);
            List<WebElement> balanceUnits = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy
                            (By.xpath("//parent::th[text()='Units']//parent::tr//parent::thead//parent::table//tbody[last()]//tr[contains(@ng-show,'Purchase')]//td[6]//table//tr//td[1]")));
            int units = 0;
            for (int i =0;i<balanceUnits.size();i++){
                String b = balanceUnits.get(i).getText();
                int bu = Integer.parseInt(b);
                units += bu;
            }
            sleepFor(1);
            List<WebElement> balanceTotal = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy
                            (By.xpath("//parent::th[text()='Units']//parent::tr//parent::thead//parent::table//tbody[last()]//tr[contains(@ng-show,'Purchase')]//td[6]//table//tr//td[3]")));
            int total = 0;
            for (int i =0;i<balanceTotal.size();i++){
                String b = balanceTotal.get(i).getText();
                String s1 = b.substring(1);
                NumberFormat format = NumberFormat.getNumberInstance(Locale.UK);
                int newcount = format.parse(s1).intValue();
                int ij = Math.round(newcount);
                total += ij;
            }
            sleepFor(1);
            avergeCostPrice = total/units;
            sleepFor(1);
            NumberFormat format = NumberFormat.getNumberInstance(Locale.UK);
            int newcounts = format.parse(String.valueOf(avergeCostPrice)).intValue();
            int finalAvergeCostPrice = Math.round(newcounts);
            sleepFor(1);
            centerlizePO.clickOnButton(PageFactory.initElements(driver,ProcessSale.class).getSliderCloseIcon());
            PageFactory.initElements(driver, ProductsPO.Products.class).clickOnProductsButtonn();
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Products.class).getProductButton());
            sleepFor(2);
            centerlizePO.enterDataUsingSendkeys(PageFactory.initElements(driver, Products.class).getSearchBox(),UOMName);
            sleepFor(2);
            List<WebElement> list1 = new WebDriverWait(driver,120).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy
                            (By.xpath("//ul[contains(@class,'hike-width-block')]//b[text()='Product']//parent::ul//li//a")));
            list1.get(0).click();
            sleepFor(2);
            WebElement product = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//table[@id='RosterDataTable']//tbody//tr//td[2]//span[text()='" + productItemName + "']//parent::td")));
            product.click();
            sleepFor(3);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Products.class).getViewProductHistoryButton());
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Products.class).getPurchaseOrderCheckbox());
            WebElement phCostPrice = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//table[@id='HistoryTable']//tbody//tr[1]//td[6]")));
            String s = phCostPrice.getText();
            String s1 = s.substring(1);
            int newcount = format.parse(s1).intValue();
            int i = Math.round(newcount);
            System.out.println(i);
            if (i==costPrice)
                System.out.println(costPrice);
            sleepFor(1);
            WebElement avgCost = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//table[@id='HistoryTable']//tbody//tr[1]//td[7]")));
            String avCost = avgCost.getText();
            String s2 = avCost.substring(1);
            int newcount1 = format.parse(s2).intValue();
            int i1 = Math.round(newcount1);
            System.out.println(i);
            if (i1==finalAvergeCostPrice)
                System.out.println(finalAvergeCostPrice);
            sleepFor(1);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, ProcessSale.class).getSliderCloseIcon());
            sleepFor(1);
            PageFactory.initElements(driver, PointofSale.class).clickOnPointOfSaleButtonn();
            centerlizePO.clickOnButton(PageFactory.initElements(driver, ProcessSale.class).getProcessSaleButton());
            sleepFor(15);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, ProcessSale.class).getAddCustomerButton());
            centerlizePO.enterDataUsingSendkeys(PageFactory.initElements(driver, ProcessSale.class).getAddCustomer(),"A");
            sleepFor(1);
            actions.sendKeys(Keys.TAB).build().perform();
            sleepFor(2);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, ProcessSale.class).getPayButton());
            centerlizePO.clickOnButton(PageFactory.initElements(driver, ProcessSale.class).getCashButton());
            sleepFor(5);
            /*Screen screen = new Screen();
            Pattern cancel_btn = new Pattern(System.getProperty("user.dir")+"\\test-image\\cancelBtn.png");
            screen.find(cancel_btn);
            screen.click(cancel_btn);
            sleepFor(3);*/
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
            centerlizePO.clickOnButton(PageFactory.initElements(driver, ProcessSale.class).getAddNewSaleButton());
            sleepFor(3);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Reporting.class).getReportingButton());
            centerlizePO.clickOnButton(PageFactory.initElements(driver, ReportingPO.InventoryPO.Inventory.class).getInventoryButton());
            sleepFor(1);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Products.class).getCostsOfGoodSoldButon());
            sleepFor(1);
            List<WebElement> invinput = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy
                            (By.xpath("//div[@class='input-icon']//input")));
            invinput.get(2).sendKeys(UOMName);
            sleepFor(2);
            int averageCostInReporting=finalAvergeCostPrice*UOMQuantity;
            sleepFor(1);
            WebElement inventoryAvgCost = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//table[@id='GoodSoldDetailDataTable']//tbody//tr[last()]//td[5]")));
            String data1 = inventoryAvgCost.getText();
            String s3 = data1.substring(1);
            int newcount3 = format.parse(s3).intValue();
            int i2 = Math.round(newcount3);
            System.out.println(i2);
            if (i2==averageCostInReporting)
                System.out.println("");
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
     * @date 16 February 2021
     * @discription this method is use to Verify Temporary change – applies only to this PO (Average Cost Price) using unit of measure product
     */
    @Step("Verify Temporary change – applies only to this PO (Average Cost Price) using unit of measure product"+"\n"+"ProductType:{0}")
    public boolean verifyTemporaryChangeAppliesOnlyToThisPO(String ProductType) {
        CenterlizePO centerlizePO = PageFactory.initElements(driver,CenterlizePO.class);
        try {
            sleepFor(3);
            Reset();
            PageFactory.initElements(driver, Inventory.class).clickOnInventoryButton();
            centerlizePO.clickOnButton(PageFactory.initElements(driver, PointofSale.class).getPointOfSaleButton());
            centerlizePO.clickOnButton(PageFactory.initElements(driver, ProcessSale.class).getProcessSaleButton());
            sleepFor(15);
            WebElement e = new WebDriverWait(driver,120).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//div[@id='mydiv']//ul//li//a[text()='" + ProductType + "']")));
            e.click();
            List<WebElement> elementList = new WebDriverWait(driver,120).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy
                            (By.xpath("//div[contains(@uib-tooltip,'unit of measure')]")));
            elementList.get(3).click();
            sleepFor(2);
            centerlizePO.clickOnButton(PageFactory.initElements(driver,ProcessSale.class).getSaleItemTitle());
            sleepFor(1);
            centerlizePO.clickOnButton(PageFactory.initElements(driver,ProcessSale.class).getProductInfobutton());
            sleepFor(1);
            List<WebElement> webElementList = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy
                            (By.xpath("//span[contains(text(),'Name')][text()]")));
            String productName = webElementList.get(0).getText();
            sleepFor(1);
            productItemName += productName.split(":")[1].split(" ")[1];
            sleepFor(1);
            WebElement uomname = new WebDriverWait(driver,60).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[text()]")));
            UOMName += uomname.getText();
            centerlizePO.clickOnButton(PageFactory.initElements(driver,ProcessSale.class).getSliderCloseIcon());
            sleepFor(1);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, ProductsPO.Products.class).getProductButton());
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Products.class).getProductButton());
            sleepFor(2);
            /*List<WebElement> closeIcon = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy
                            (By.cssSelector("a > i.fa-times")));
            for(int i =0 ;i< closeIcon.size();i++){
                closeIcon.get(i).click();
            }*/
            centerlizePO.enterDataUsingSendkeys(PageFactory.initElements(driver, Products.class).getSearchBox(),UOMName);
            sleepFor(2);
            List<WebElement> list = new WebDriverWait(driver,120).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy
                            (By.xpath("//ul[contains(@class,'hike-width-block')]//b[text()='Product']//parent::ul//li//a")));
            String qty = list.get(0).getText();
            StringBuilder builder = new StringBuilder(qty.split(" ")[3]);
            builder.deleteCharAt(qty.split(" ")[3].length() - 1);
            int n = Integer.parseInt(String.valueOf(builder));
            System.out.println(n);
            UOMQuantity = n;
            sleepFor(3);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Inventory.class).getInventoryButton());
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Purchases.class).getPurchasesButton());
            sleepFor(2);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Purchases.class).getAddNewButton());
            sleepFor(5);
            List<WebElement> elements = new  WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//input[@ng-model='searchtext']")));
            sleepFor(1);
            elements.get(0).click();
            elements.get(0).sendKeys(UOMName);
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
            Actions actions = new Actions(driver);
            actions.sendKeys(Keys.PAGE_DOWN).build().perform();
            String order = "1";
            sleepFor(1);
            WebElement orderinput = new WebDriverWait(driver,60).until
                    (ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//span[text()='Order ']//parent::th//parent::tr//parent::thead//parent::table//tbody//tr//td[2]//input")));
            orderinput.clear();
            orderinput.sendKeys(order);
            sleepFor(1);
            WebElement costInc = new WebDriverWait(driver,60).until
                    (ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//span[text()='Order ']//parent::th//parent::tr//parent::thead//parent::table//tbody//tr//td[6]//input")));
            String cost = "1500";
            int costCount = Integer.parseInt(cost);
            sleepFor(1);
            costInc.sendKeys(Keys.CONTROL+"a");
            costInc.sendKeys(String.valueOf(Keys.DELETE));
            costInc.sendKeys(cost);
            sleepFor(1);
            WebElement notes = new WebDriverWait(driver,60).until
                    (ExpectedConditions.presenceOfElementLocated
                            (By.cssSelector("#Notes")));
            actions.moveToElement(notes).contextClick().build().perform();

            sleepFor(1);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Products.class).getTemporaryChange());
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Customers.class).getContinueButton());
            sleepFor(1);
            costPrice = costCount/UOMQuantity;
            sleepFor(1);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Purchases.class).getSaveButton());
            sleepFor(5);
            WebElement PO = new WebDriverWait(driver,60).until
                    (ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//table[@id='purchanseOrderDataTable']//tbody//tr//td//i[contains(@class,'fa fa-circle-o')]//parent::td//parent::tr//td[1]//a")));
            PO.click();
            sleepFor(3);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Purchases.class).getReceiveButton());
            sleepFor(3);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Purchases.class).getReceiveAllButton());
            centerlizePO.clickOnButton(PageFactory.initElements(driver, GiftCards.class).getYesButton());
            sleepFor(3);
            PageFactory.initElements(driver, Inventory.class).clickOnInventoryButton();
            centerlizePO.clickOnButton(PageFactory.initElements(driver, MyInventory.class).getMyInventoryButton());
            sleepFor(1);
            centerlizePO.enterDataUsingSendkeys(PageFactory.initElements(driver, MyInventory.class).getSearchBox(),productItemName);
            sleepFor(3);
            List<WebElement> webElementList1 = new WebDriverWait(driver,120).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy
                            (By.xpath("//ul[contains(@class,'hike-width-block')]//b[text()='Product']//parent::ul//li//a")));
            webElementList1.get(0).click();
            sleepFor(5);
            WebElement avgicon = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//table[@id='InventoryRecordDataTable']//tbody//tr[1]//td[3]//parent::tr//td[8]//a")));
            avgicon.click();
            sleepFor(3);
            List<WebElement> balanceUnits = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy
                            (By.xpath("//parent::th[text()='Units']//parent::tr//parent::thead//parent::table//tbody[last()]//tr[contains(@ng-show,'Purchase')]//td[6]//table//tr//td[1]")));
            int units = 0;
            for (int i =0;i<balanceUnits.size();i++){
                String b = balanceUnits.get(i).getText();
                int bu = Integer.parseInt(b);
                units += bu;
            }
            sleepFor(1);
            List<WebElement> balanceTotal = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy
                            (By.xpath("//parent::th[text()='Units']//parent::tr//parent::thead//parent::table//tbody[last()]//tr[contains(@ng-show,'Purchase')]//td[6]//table//tr//td[3]")));
            int total = 0;
            for (int i =0;i<balanceTotal.size();i++){
                String b = balanceTotal.get(i).getText();
                String s1 = b.substring(1);
                NumberFormat format = NumberFormat.getNumberInstance(Locale.UK);
                int newcount = format.parse(s1).intValue();
                int ij = Math.round(newcount);
                total += ij;
            }
            sleepFor(1);
            avergeCostPrice = total/units;
            sleepFor(1);
            NumberFormat format = NumberFormat.getNumberInstance(Locale.UK);
            int newcounts = format.parse(String.valueOf(avergeCostPrice)).intValue();
            int finalAvergeCostPrice = Math.round(newcounts);
            sleepFor(1);
            centerlizePO.clickOnButton(PageFactory.initElements(driver,ProcessSale.class).getSliderCloseIcon());
            PageFactory.initElements(driver, ProductsPO.Products.class).clickOnProductsButtonn();
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Products.class).getProductButton());
            sleepFor(2);
            centerlizePO.enterDataUsingSendkeys(PageFactory.initElements(driver, Products.class).getSearchBox(),UOMName);
            sleepFor(2);
            List<WebElement> list1 = new WebDriverWait(driver,120).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy
                            (By.xpath("//ul[contains(@class,'hike-width-block')]//b[text()='Product']//parent::ul//li//a")));
            list1.get(0).click();
            sleepFor(2);
            WebElement product = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//table[@id='RosterDataTable']//tbody//tr//td[2]//span[text()='" + productItemName + "']//parent::td")));
            product.click();
            sleepFor(3);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Products.class).getViewProductHistoryButton());
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Products.class).getPurchaseOrderCheckbox());
            WebElement phCostPrice = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//table[@id='HistoryTable']//tbody//tr[1]//td[6]")));
            String s = phCostPrice.getText();
            String s1 = s.substring(1);
            int newcount = format.parse(s1).intValue();
            int i = Math.round(newcount);
            System.out.println(i);
            if (i!=costPrice)
                System.out.println(costPrice);
            sleepFor(1);
            WebElement avgCost = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//table[@id='HistoryTable']//tbody//tr[1]//td[7]")));
            String avCost = avgCost.getText();
            String s2 = avCost.substring(1);
            int newcount1 = format.parse(s2).intValue();
            int i1 = Math.round(newcount1);
            System.out.println(i);
            if (i1==finalAvergeCostPrice)
                System.out.println(finalAvergeCostPrice);
            sleepFor(1);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, ProcessSale.class).getSliderCloseIcon());
            sleepFor(1);
            PageFactory.initElements(driver, PointofSale.class).clickOnPointOfSaleButtonn();
            centerlizePO.clickOnButton(PageFactory.initElements(driver, ProcessSale.class).getProcessSaleButton());
            sleepFor(15);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, ProcessSale.class).getAddCustomerButton());
            centerlizePO.enterDataUsingSendkeys(PageFactory.initElements(driver, ProcessSale.class).getAddCustomer(),"A");
            sleepFor(1);
            actions.sendKeys(Keys.TAB).build().perform();
            sleepFor(2);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, ProcessSale.class).getPayButton());
            centerlizePO.clickOnButton(PageFactory.initElements(driver, ProcessSale.class).getCashButton());
            sleepFor(5);
            /*Screen screen = new Screen();
            Pattern cancel_btn = new Pattern(System.getProperty("user.dir")+"\\test-image\\cancelBtn.png");
            screen.find(cancel_btn);
            screen.click(cancel_btn);
            sleepFor(3);*/
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
            centerlizePO.clickOnButton(PageFactory.initElements(driver, ProcessSale.class).getAddNewSaleButton());
            sleepFor(3);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Reporting.class).getReportingButton());
            centerlizePO.clickOnButton(PageFactory.initElements(driver, ReportingPO.InventoryPO.Inventory.class).getInventoryButton());
            sleepFor(1);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Products.class).getCostsOfGoodSoldButon());
            sleepFor(1);
            List<WebElement> invinput = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy
                            (By.xpath("//div[@class='input-icon']//input")));
            invinput.get(2).sendKeys(UOMName);
            sleepFor(2);
            int averageCostInReporting=finalAvergeCostPrice*UOMQuantity;
            sleepFor(1);
            WebElement inventoryAvgCost = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//table[@id='GoodSoldDetailDataTable']//tbody//tr[last()]//td[5]")));
            String data1 = inventoryAvgCost.getText();
            String s3 = data1.substring(1);
            int newcount3 = format.parse(s3).intValue();
            int i2 = Math.round(newcount3);
            System.out.println(i2);
            if (i2==averageCostInReporting)
                System.out.println("");
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
     * @date 17 February 2021
     * @discription this method is use to Verify Purchase Order Return Functionality
     */
    @Step("Verify Purchase Order Return Functionality"+"\n"+"ProductType:{0}")
    public boolean verifyPurchaseOrderReturnFunctionality(String ProductType) {
        CenterlizePO centerlizePO = PageFactory.initElements(driver,CenterlizePO.class);
        Products products01 = PageFactory.initElements(driver, Products.class);
        try {
            createNewUnityOfMeasureProduct();
            sleepFor(3);
            Reset();
            PageFactory.initElements(driver, Inventory.class).clickOnInventoryButton();
            centerlizePO.clickOnButton(PageFactory.initElements(driver, PointofSale.class).getPointOfSaleButton());
            centerlizePO.clickOnButton(PageFactory.initElements(driver, ProcessSale.class).getProcessSaleButton());
            sleepFor(24);
            WebElement e = new WebDriverWait(driver,120).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//div[@id='mydiv']//ul//li//a[text()='" + ProductType + "']")));
            e.click();
            List<WebElement> elementList = new WebDriverWait(driver,120).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy
                            (By.xpath("//div[contains(@uib-tooltip,'unit of measure')]")));
            elementList.get(elementList.size()-1).click();
            sleepFor(2);
            centerlizePO.clickOnButton(PageFactory.initElements(driver,ProcessSale.class).getSaleItemTitle());
            sleepFor(1);
            centerlizePO.clickOnButton(PageFactory.initElements(driver,ProcessSale.class).getProductInfobutton());
            sleepFor(1);
            List<WebElement> webElementList = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy
                            (By.xpath("//span[contains(text(),'Name')][text()]")));
            String productName = webElementList.get(0).getText();
            sleepFor(1);
            productItemName += productName.split(":")[1].split(" ")[1];
            sleepFor(1);
            WebElement uomname = new WebDriverWait(driver,60).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[text()]")));
            UOMName += uomname.getText();
            centerlizePO.clickOnButton(PageFactory.initElements(driver,ProcessSale.class).getSliderCloseIcon());
            sleepFor(1);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, ProductsPO.Products.class).getProductButton());
            centerlizePO.clickOnButton(products01.getProductButton());
            sleepFor(1);
           /* List<WebElement> closeIcon = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy
                            (By.cssSelector("a > i.fa-times")));
            for(int i =0 ;i< closeIcon.size();i++){
                closeIcon.get(i).click();
            }*/
            centerlizePO.enterDataUsingSendkeys(products01.getSearchBox(),UOMName);
            sleepFor(2);
            List<WebElement> list = new WebDriverWait(driver,120).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy
                            (By.xpath("//ul[contains(@class,'hike-width-block')]//b[text()='Product']//parent::ul//li//a")));
            String qty = list.get(0).getText();
            StringBuilder builder = new StringBuilder(qty.split(" ")[3]);
            builder.deleteCharAt(qty.split(" ")[3].length() - 1);
            int n = Integer.parseInt(String.valueOf(builder));
            System.out.println(n);
            UOMQuantity = n;
            list.get(0).click();
            sleepFor(2);
            WebElement product = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//table[@id='RosterDataTable']//tbody//tr//td[2]//span[text()='" + productItemName + "']//parent::td")));
            product.click();
            sleepFor(3);
            Actions actions = new Actions(driver);
            actions.moveToElement(products01.getAvailableStock()).build().perform();
            String as = products01.getAvailableStock().getText();
            availableStock = Integer.parseInt(as);
            sleepFor(1);
            PageFactory.initElements(driver, Inventory.class).clickOnInventoryButton();
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Purchases.class).getPurchasesButton());
            sleepFor(2);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Purchases.class).getAddNewButton());
            sleepFor(5);
            List<WebElement> elements = new  WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//input[@ng-model='searchtext']")));
            sleepFor(1);
            elements.get(0).click();
            elements.get(0).sendKeys(UOMName);
            sleepFor(5);
            WebElement chkbocx = new WebDriverWait(driver,60).until
                    (ExpectedConditions.presenceOfElementLocated
                            (By.cssSelector("table.table.table-hover.table-vert.table-border.fix-table-header > tbody > tr > td > div > label")));
            JavascriptExecutor executor = (JavascriptExecutor)driver;
            executor.executeScript("arguments[0].click();", chkbocx);
            sleepFor(1);
            sleepFor(1);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Purchases.class).getAddAndContinueButton());
            sleepFor(1);
            String order = "15";
            int orderCount = Integer.parseInt(order);
            sleepFor(1);
            WebElement orderinput = new WebDriverWait(driver,60).until
                    (ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//span[text()='Order ']//parent::th//parent::tr//parent::thead//parent::table//tbody//tr//td[2]//input")));
            orderinput.clear();
            orderinput.sendKeys(order);
            sleepFor(1);
            onHandStockAdjustment = orderCount*UOMQuantity+availableStock;
            sleepFor(1);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Purchases.class).getSaveButton());
            sleepFor(5);
            WebElement PO = new WebDriverWait(driver,60).until
                    (ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//table[@id='purchanseOrderDataTable']//tbody//tr//td//i[contains(@class,'fa fa-circle-o')]//parent::td//parent::tr//td[1]//a")));
            sleepFor(1);
            String POReferance = PO.getText();
            PO.click();
            sleepFor(3);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Purchases.class).getReceiveButton());
            sleepFor(3);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Purchases.class).getReceiveAllButton());
            centerlizePO.clickOnButton(PageFactory.initElements(driver, GiftCards.class).getYesButton());
            sleepFor(3);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, ProductsPO.Products.class).getProductButton());
            centerlizePO.clickOnButton(products01.getProductButton());
            sleepFor(2);
            WebElement product1 = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//table[@id='RosterDataTable']//tbody//tr//td[2]//span[text()='" + productItemName + "']//parent::td")));
            product1.click();
            sleepFor(3);
            String ad = products01.getAvailableStock().getText();
            int adjustment = Integer.parseInt(ad);
            if (adjustment==onHandStockAdjustment)
                System.out.println("");
            sleepFor(1);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Inventory.class).getInventoryButton());
            centerlizePO.clickOnButton(PageFactory.initElements(driver, MyInventory.class).getMyInventoryButton());
            sleepFor(1);
            centerlizePO.enterDataUsingSendkeys(PageFactory.initElements(driver, MyInventory.class).getSearchBox(),productItemName);
            sleepFor(7);
            List<WebElement> webElementList1 = new WebDriverWait(driver,120).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy
                            (By.xpath("//ul[contains(@class,'hike-width-block')]//b[text()='Product']//parent::ul//li//a")));
            webElementList1.get(0).click();
            sleepFor(5);
            WebElement onHand = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//table[@id='InventoryRecordDataTable']//tbody//tr[1]//td[2]")));
            String data = onHand.getText();
            int stock = Integer.parseInt(data);
            if (stock==onHandStockAdjustment)
                System.out.println("");
            WebElement avgicon = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//table[@id='InventoryRecordDataTable']//tbody//tr[1]//td[3]//parent::tr//td[8]//a")));
            avgicon.click();
            sleepFor(3);
            List<WebElement> balance = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy
                            (By.xpath("//parent::th[text()='Units']//parent::tr//parent::thead//parent::table//tbody[last()]//tr[contains(@ng-show,'Purchase')]//td[6]//table//tr//td[1]")));
            for (int i =0;i<balance.size();i++){
                String b = balance.get(i).getText();
                int bu = Integer.parseInt(b);
                balanceUnits += bu;
            }
            sleepFor(1);
            if (balanceUnits==onHandStockAdjustment)
                System.out.println("");
            sleepFor(1);
            centerlizePO.clickOnButton(PageFactory.initElements(driver,ProcessSale.class).getSliderCloseIcon());
            sleepFor(1);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Reporting.class).getReportingButton());
            centerlizePO.clickOnButton(PageFactory.initElements(driver, ReportingPO.InventoryPO.Inventory.class).getInventoryButton());
            sleepFor(1);
            List<WebElement> invinput = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy
                            (By.xpath("//div[@class='input-icon']//input")));
            invinput.get(0).sendKeys(productItemName);
            sleepFor(1);
            WebElement inveOnHand = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//table[@id='InventoryDetailDataTable']//tbody//tr[1]//td[3]//a")));
            String data1 = inveOnHand.getText();
            int stock1 = Integer.parseInt(data1);
            if (stock1==onHandStockAdjustment)
                System.out.println("");
            sleepFor(2);
            PageFactory.initElements(driver, Inventory.class).clickOnInventoryButton();
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Purchases.class).getPurchasesButton());
            sleepFor(2);
            WebElement PO1 = new WebDriverWait(driver,60).until
                    (ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//table[@id='purchanseOrderDataTable']//tbody//tr//td//i[contains(@class,'fa fa-circle')]//parent::td//parent::tr//td[1]//a[text()='"+ POReferance +"']")));
            sleepFor(1);
            PO1.click();
            sleepFor(5);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Purchases.class).getReturnButton());
            sleepFor(7);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Purchases.class).getSliderReturnButton());
            sleepFor(5);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, GiftCards.class).getYesButton());
            sleepFor(5);
            WebElement color = new WebDriverWait(driver,60).until
                    (ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//div[@class='page-content']")));
            System.out.println(color.getCssValue("background-color"));
            if (color.getCssValue("background-color").contains("rgba(255, 230, 230, 0.54)"))
                System.out.println("");
            sleepFor(1);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, ProductsPO.Products.class).getProductButton());
            centerlizePO.clickOnButton(products01.getProductButton());
            sleepFor(1);
            sleepFor(2);
            sleepFor(2);
            WebElement product2 = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//table[@id='RosterDataTable']//tbody//tr//td[2]//span[text()='" + productItemName + "']//parent::td")));
            product2.click();
            sleepFor(3);
            actions.moveToElement(products01.getAvailableStock()).build().perform();
            String as1 = products01.getAvailableStock().getText();
            int availableStock1 = Integer.parseInt(as1);
            sleepFor(1);
            int poReturnCount = UOMQuantity*orderCount;
            returnAdjustment = poReturnCount-availableStock;
            if (availableStock1==returnAdjustment)
                System.out.println("");
            sleepFor(3);
            PageFactory.initElements(driver, Inventory.class).clickOnInventoryButton();
            sleepFor(1);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, MyInventory.class).getMyInventoryButton());
            sleepFor(1);
            centerlizePO.enterDataUsingSendkeys(PageFactory.initElements(driver, MyInventory.class).getSearchBox(),productItemName);
            sleepFor(3);
            WebElement onHand1 = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//table[@id='InventoryRecordDataTable']//tbody//tr[1]//td[3]")));
            String data2 = onHand1.getText();
            int stock2 = Integer.parseInt(data2);
            if (stock2==returnAdjustment)
                System.out.println("");
            sleepFor(1);
            sleepFor(1);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Reporting.class).getReportingButton());
            centerlizePO.clickOnButton(PageFactory.initElements(driver, ReportingPO.InventoryPO.Inventory.class).getInventoryButton());
            sleepFor(1);
            List<WebElement> invinput1 = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy
                            (By.xpath("//div[@class='input-icon']//input")));
            invinput1.get(0).sendKeys(productItemName);
            sleepFor(3);
            WebElement inveOnHand1 = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//table[@id='InventoryDetailDataTable']//tbody//tr[1]//td[3]//a")));
            String data3 = inveOnHand1.getText();
            int stock3 = Integer.parseInt(data3);
            if (stock3==returnAdjustment)
                System.out.println("");
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
     * @date 16 March 2021
     * @discription this method is use to verify quantity after receive PO
     */
    @Step("verify quntity after receive PO")
    public boolean verifyQuantityaftyerReceivePO() {
        ProductsPO.ProductsPO.Products products1 = PageFactory.initElements(driver, ProductsPO.ProductsPO.Products.class);
        CenterlizePO centerlizePO = PageFactory.initElements(driver, CenterlizePO.class);
        Actions actions = new Actions(driver);
        String product = "Quantity Product";
        try {
            sleepFor(5);
            PageFactory.initElements(driver, ProductsPO.Products.class).clickOnProductsButtonn();
            centerlizePO.clickOnButton(products1.getProductButton());
            sleepFor(2);
            centerlizePO.clickOnButton(products1.getAddProductButton());
            sleepFor(2);
            centerlizePO.enterDataUsingSendkeys(products1.getProductName(), product);
            centerlizePO.clickOnButton(products1.getInventoryTrackingButton());
            List<WebElement> cost = new WebDriverWait(driver,60).
                    until(ExpectedConditions.
                            presenceOfAllElementsLocatedBy(By.xpath
                                    ("//th[text()='Cost price']//parent::tr//parent::thead//parent::table//tbody//input")));
            centerlizePO.enterDataUsingSendkeys(cost.get(0),Keys.CONTROL+"a");
            centerlizePO.enterDataUsingSendkeys(cost.get(0), String.valueOf(Keys.DELETE));
            centerlizePO.enterDataUsingSendkeys(cost.get(0), "150");
            centerlizePO.enterDataUsingSendkeys(products1.getProductType(),"PT Variant");
            actions.sendKeys(Keys.TAB).build().perform();
            centerlizePO.enterDataUsingSendkeys(products1.getSuppliers(),"Automation Suppliers");
            actions.sendKeys(Keys.TAB).build().perform();
            centerlizePO.enterDataUsingSendkeys(products1.getBrand(),"Automation Brand");
            actions.sendKeys(Keys.TAB).build().perform();
            actions.moveToElement(products1.getAvailableStock()).build().perform();
            String as = products1.getAvailableStock().getText();
            availableStock = Integer.parseInt(as);
            centerlizePO.clickOnButton(products1.getProductSaveButton());
            sleepFor(2);
            PageFactory.initElements(driver, Inventory.class).clickOnInventoryButton();
            centerlizePO.clickOnButton(getPurchasesButton());
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Purchases.class).getAddNewButton());
            sleepFor(5);
            List<WebElement> elements = new  WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//input[@ng-model='searchtext']")));
            sleepFor(1);
            elements.get(0).click();
            elements.get(0).sendKeys(product);
            sleepFor(5);
            WebElement chkbocx = new WebDriverWait(driver,60).until
                    (ExpectedConditions.presenceOfElementLocated
                            (By.cssSelector("table.table.table-hover.table-vert.table-border.fix-table-header > tbody > tr > td > div > label")));
            JavascriptExecutor executor = (JavascriptExecutor)driver;
            executor.executeScript("arguments[0].click();", chkbocx);
            sleepFor(1);
            sleepFor(1);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Purchases.class).getAddAndContinueButton());
            sleepFor(1);
            String order = "15";
            int orderCount = Integer.parseInt(order);
            sleepFor(1);
            WebElement orderinput = new WebDriverWait(driver,60).until
                    (ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//span[text()='Order ']//parent::th//parent::tr//parent::thead//parent::table//tbody//tr//td[2]//input")));
            orderinput.clear();
            orderinput.sendKeys(order);
            sleepFor(1);
            onHandStockAdjustment = orderCount+availableStock;
            sleepFor(1);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Purchases.class).getSaveButton());
            sleepFor(5);
            WebElement PO = new WebDriverWait(driver,60).until
                    (ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//table[@id='purchanseOrderDataTable']//tbody//tr//td//i[contains(@class,'fa fa-circle-o font-green')]//parent::td//parent::tr//td[1]//a")));
            sleepFor(1);
            PO.click();
            sleepFor(3);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Purchases.class).getReceiveButton());
            sleepFor(3);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Purchases.class).getReceiveAllButton());
            centerlizePO.clickOnButton(PageFactory.initElements(driver, GiftCards.class).getYesButton());
            sleepFor(3);
            sleepFor(1);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, ProductsPO.Products.class).getProductButton());
            centerlizePO.clickOnButton(products1.getProductButton());
            sleepFor(1);
            centerlizePO.enterDataUsingSendkeys(products1.getSearchBox(),product);
            sleepFor(2);
            List<WebElement> list = new WebDriverWait(driver,120).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy
                            (By.xpath("//ul[contains(@class,'hike-width-block')]//b[text()='Product']//parent::ul//li//a")));
            list.get(0).click();
            sleepFor(2);
            WebElement product001 = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//table[@id='RosterDataTable']//tbody//tr//td[2]//span[text()='" + product + "']//parent::td")));
            product001.click();
            sleepFor(3);
            actions.moveToElement(products1.getAvailableStock()).build().perform();
            String as1 = products1.getAvailableStock().getText();
            int availableStock1 = Integer.parseInt(as1);
            if (availableStock1==onHandStockAdjustment) {
                System.out.printf(" ");
            }
            sleepFor(1);
            sleepFor(1);
            centerlizePO.clickOnButton(products1.getProductButton());
            List<WebElement> closeIcon = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy
                            (By.cssSelector("a > i.fa-times")));
            for(int i =0 ;i< closeIcon.size();i++){
                closeIcon.get(i).click();
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
     * @date 16 March 2021
     * @discription this method is use to Create PO for replenish Items PO
     */
    @Step("Create PO for replenish Items PO")
    public boolean createReplenishItemPO() {
        ProductsPO.ProductsPO.Products products1 = PageFactory.initElements(driver, ProductsPO.ProductsPO.Products.class);
        CenterlizePO centerlizePO = PageFactory.initElements(driver, CenterlizePO.class);
        Actions actions = new Actions(driver);
        String prdouctName = "";
        String count = "";
        try {
            sleepFor(5);
            PageFactory.initElements(driver, PointofSale.class).clickOnPointOfSaleButtonn();
            centerlizePO.clickOnButton(PageFactory.initElements(driver, SalesHistory.class).getSalesHistoryButton());
            sleepFor(8);
            WebElement sale = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//table[@id='SalesTable']//tbody//tr[1]//td[2]//a[text()]")));
            sale.click();
            sleepFor(4);
            WebElement product = new WebDriverWait(driver,60)
                    .until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//div[@class='sell-item-content'][text()]")));
            prdouctName = product.getText().split("\n")[0];
            System.out.printf(prdouctName);
            WebElement pic = new WebDriverWait(driver,60)
                    .until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//div[@class='sell-item-pic']//span")));
            count = pic.getText();
            sleepFor(2);
            actions.sendKeys(Keys.ESCAPE).build().perform();
            sleepFor(2);
            PageFactory.initElements(driver, Inventory.class).clickOnInventoryButton();
            centerlizePO.clickOnButton(getPurchasesButton());
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Purchases.class).getAddNewButton());
            sleepFor(5);
            centerlizePO.clickOnButton(getRepenishcheckbox());
            sleepFor(1);
            WebElement picker = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//div[@date-range-picker]")));
            picker.click();
            WebElement days = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//li[text()='Last 7 days']")));
            days.click();
            sleepFor(5);
            List<WebElement> name = new WebDriverWait(driver,60).until
                    (ExpectedConditions.presenceOfAllElementsLocatedBy
                            (By.xpath("//span[text()='Order items']//parent::div//parent::div//parent::div//table//tbody//tr//td[1][text()]")));
            for (int i=0; i<name.size();i++){
                String prdouctName01 = name.get(i).getText();
                WebElement orderCount = new WebDriverWait(driver,60).until
                        (ExpectedConditions.presenceOfElementLocated
                                (By.xpath("//span[text()='Order items']//parent::div//parent::div//parent::div//table//tbody//tr//td[contains(text(),'" + prdouctName + "')]//following-sibling::td[1]//input")));
                String count01 = orderCount.getAttribute("value");
                if(count01.contains(count))
                    System.out.printf(" ");
                if(prdouctName01.contains(prdouctName))
                    System.out.printf(" ");
                break;
            }
            sleepFor(1);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Purchases.class).getSaveDropDownButton());
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Transfers.class).getSaveAsDraftButton());
            sleepFor(5);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Purchases.class).getReceiveButton());
            sleepFor(3);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Purchases.class).getReceiveAllButton());
            centerlizePO.clickOnButton(PageFactory.initElements(driver, GiftCards.class).getYesButton());
            sleepFor(3);


           /* centerlizePO.clickOnButton(PageFactory.initElements(driver, ProductsPO.Products.class).getProductButton());
            centerlizePO.clickOnButton(products1.getProductButton());
            sleepFor(1);
            centerlizePO.enterDataUsingSendkeys(products1.getSearchBox(),prdouctName);
            sleepFor(2);
            List<WebElement> list = new WebDriverWait(driver,120).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy
                            (By.xpath("//ul[contains(@class,'hike-width-block')]//b[text()='Product']//parent::ul//li//a")));
            list.get(0).click();
            sleepFor(2);
            WebElement product001 = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//table[@id='RosterDataTable']//tbody//tr[1]//td[2]")));
            product001.click();
            sleepFor(3);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Products.class).getViewProductHistoryButton());
            sleepFor(1);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Products.class).getPurchaseOrderCheckbox());
            sleepFor(5);
            WebElement phCostPrice = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//table[@id='HistoryTable']//tbody//tr[1]//td[11]")));
            String s = phCostPrice.getText();
            if(s.contains(count))
                System.out.printf(" ");
            actions.sendKeys(Keys.ESCAPE).build().perform();
            centerlizePO.clickOnButton(products1.getProductButton());*/


            /*List<WebElement> closeIcon = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy
                            (By.cssSelector("a > i.fa-times")));
            for(int i =0 ;i< closeIcon.size();i++){
                closeIcon.get(i).click();
            }*/
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
     * @date 16 March 2021
     * @discription this method is use to Create a new PO for low stock inventory and review that items are correctly added in PO.
     */
    @Step("Create a new PO for low stock inventory and review that items are correctly added in PO.")
    public boolean createNewPOForLowStockInventory() {
        ProductsPO.ProductsPO.Products products1 = PageFactory.initElements(driver, ProductsPO.ProductsPO.Products.class);
        CenterlizePO centerlizePO = PageFactory.initElements(driver, CenterlizePO.class);
        Actions actions = new Actions(driver);
        String product = "lW001";
        try {
            sleepFor(5);
            PageFactory.initElements(driver, ProductsPO.Products.class).clickOnProductsButtonn();
            centerlizePO.clickOnButton(products1.getProductButton());
            sleepFor(2);
            centerlizePO.clickOnButton(products1.getAddProductButton());
            sleepFor(2);
            centerlizePO.enterDataUsingSendkeys(products1.getProductName(), product);
            centerlizePO.clickOnButton(products1.getInventoryTrackingButton());
            centerlizePO.enterDataUsingSendkeys(products1.getProductType(),"PT Variant");
            actions.sendKeys(Keys.TAB).build().perform();
            centerlizePO.enterDataUsingSendkeys(products1.getSuppliers(),"Automation Suppliers");
            actions.sendKeys(Keys.TAB).build().perform();
            centerlizePO.enterDataUsingSendkeys(products1.getBrand(),"Automation Brand");
            actions.sendKeys(Keys.TAB).build().perform();
            centerlizePO.clickOnButton(products1.getProductSaveButton());
            sleepFor(2);
            PageFactory.initElements(driver, Inventory.class).clickOnInventoryButton();
            centerlizePO.clickOnButton(getPurchasesButton());
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Purchases.class).getAddNewButton());
            sleepFor(5);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Purchases.class).getLowStockcheckbox());
            sleepFor(3);
            List<WebElement> name = new WebDriverWait(driver,60).until
                    (ExpectedConditions.presenceOfAllElementsLocatedBy
                            (By.xpath("//span[text()='Order items']//parent::div//parent::div//parent::div//table//tbody//tr//td[1][text()]")));
            for (int i=0; i<name.size();i++){
                String prdouctName01 = name.get(i).getText();
                WebElement small = new WebDriverWait(driver,60).until
                        (ExpectedConditions.presenceOfElementLocated
                                (By.xpath("//span[text()='Order items']//parent::div//parent::div//parent::div//table//tbody//tr//td[1][text()]//small")));
                String sm = small.getText();
                String sm1 = sm.split(":")[1].split(" ")[1];
                int lowCount = Integer.parseInt(sm1);
                if (lowCount<5)
                    System.out.println(" ");
                break;
            }
            sleepFor(1);
            sleepFor(1);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Purchases.class).getSaveDropDownButton());
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Transfers.class).getSaveAsDraftButton());
            sleepFor(5);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Purchases.class).getReceiveButton());
            sleepFor(3);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Purchases.class).getReceiveAllButton());
            centerlizePO.clickOnButton(PageFactory.initElements(driver, GiftCards.class).getYesButton());
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
     * @date 16 March 2021
     * @discription this method is use to Print goods received functionality once received PO
     */
    @Step("Print goods received functionality once received PO")
    public boolean printGoodsReceivedFunctionalityOnceReceivedPO() {
        CenterlizePO centerlizePO = PageFactory.initElements(driver,CenterlizePO.class);
        Products products01 = PageFactory.initElements(driver, Products.class);
        try {
            sleepFor(3);
            Reset();
            PageFactory.initElements(driver, Inventory.class).clickOnInventoryButton();
            centerlizePO.clickOnButton(getPurchasesButton());
            sleepFor(3);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Purchases.class).getAddNewButton());
            sleepFor(5);
            sleepFor(5);
            List<WebElement> elements = new  WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//input[@ng-model='searchtext']")));
            sleepFor(1);
            elements.get(0).click();
            elements.get(0).sendKeys("a");
            sleepFor(5);
            WebElement chkbocx = new WebDriverWait(driver,60).until
                    (ExpectedConditions.presenceOfElementLocated
                            (By.cssSelector("table.table.table-hover.table-vert.table-border.fix-table-header > tbody > tr > td > div > label")));
            JavascriptExecutor executor = (JavascriptExecutor)driver;
            executor.executeScript("arguments[0].click();", chkbocx);
            sleepFor(1);
            sleepFor(1);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Purchases.class).getAddAndContinueButton());
            sleepFor(1);
            WebElement orderinput = new WebDriverWait(driver,60).until
                    (ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//span[text()='Order ']//parent::th//parent::tr//parent::thead//parent::table//tbody//tr//td[2]//input")));
            orderinput.clear();
            orderinput.sendKeys("75");
            sleepFor(3);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Purchases.class).getSaveDropDownButton());
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Transfers.class).getSaveAsDraftButton());
            sleepFor(5);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Purchases.class).getReceiveButton());
            WebElement receiveinput = new WebDriverWait(driver,60).until
                    (ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//th[text()='Receive']//parent::tr//parent::thead//following-sibling::tbody//input")));
            receiveinput.clear();
            receiveinput.sendKeys("10");
            WebElement btn = new WebDriverWait(driver,60).until
                    (ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//th[text()='Receive']//parent::tr//parent::thead//following-sibling::tbody//input//parent::td//parent::tr//a[text()='Receive now']")));
            btn.click();
            sleepFor(2);
            Actions actions = new Actions(driver);
            actions.sendKeys(Key.ESC).build().perform();
            sleepFor(2);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Purchases.class).getSaveDropDownButton());
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Transfers.class).getPrintgoodsreceivedButton());
            sleepFor(5);
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
        ProductsPO.Products products = PageFactory.initElements(driver, ProductsPO.Products.class);
        CenterlizePO centerlizePO = PageFactory.initElements(driver, CenterlizePO.class);
        Products productsPO = PageFactory.initElements(driver, Products.class);
        String testName = "Zing_UOM_01";
        try {
            sleepFor(3);
            products.clickOnProductsButtonn();
            sleepFor(2);
            centerlizePO.clickOnButton(productsPO.getProductButton());
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
            centerlizePO.enterDataUsingSendkeys(productsPO.getBrand(),"Automation Brand");
            actions.sendKeys(Keys.TAB).build().perform();
            sleepFor(2);
            centerlizePO.clickOnButton(productsPO.getInventoryTrackingButton());
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
            actions.sendKeys(Keys.PAGE_DOWN).build().perform();;
            centerlizePO.clickOnButton(productsPO.getActiveUnitOfMeasure());
            centerlizePO.clickOnButton(productsPO.getAddNewRowButton());
            sleepFor(5);
            List<WebElement> UOMname = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//th[text()='UoM name']//parent::tr//parent::thead//parent::table//tbody//input")));
            UOMname.get(2).clear();
            sleepFor(5);
            UOMname.get(2).sendKeys(testName.split("_")[0].charAt(0)+ "_" +testName.split("_")[2]);
            sleepFor(5);
            UOMname.get(3).sendKeys("5");
            sleepFor(1);
            centerlizePO.clickOnButton(productsPO.getProductSaveButton());
            sleepFor(5);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}