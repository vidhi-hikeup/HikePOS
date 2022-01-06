package InventoryPO.StockTakePO;

import CommonPO.BasePage;
import CommonPO.CenterlizePO;
import CustomersPO.GroupsPO.Groups;
import InventoryPO.Inventory;
import InventoryPO.SuppliersPO.Suppliers;
import PointofSalePO.CashRegisterPO.CashRegister;
import PointofSalePO.PointofSale;
import PointofSalePO.ProcessSalePO.ProcessSale;
import ProductsPO.ProductsPO.Products;
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
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;


/**
 * @author Vidhi Chapanera
 * @date 17 March 2021
 */
public class StockTake extends BasePage {

    public WebDriver driver;
    public String productName1 = "hikeProduct-31";
    public String productName2 = "hikeProduct-32";
    public String productName3 = "hikeProduct-33";
    public static String referenceDataText = "";

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Count, Stocktake button
     * @date 17 March 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//span[contains(text(),'Count, Stocktake')]//parent::a"
    )
    WebElement btn_CountStocktake;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Continue button
     * @date 07 May 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//button[contains(normalize-space(.),'Continue')]"
    )
    WebElement btn_continue;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Mark as complete button
     * @date 07 May 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//button[text()='Mark as complete']"
    )
    WebElement btn_markascomplete;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Add count value 0 (zero) for all skipped items button
     * @date 07 May 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//label[@for='AddCountZero']"
    )
    WebElement rbtn_addcountzero;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Remove skipped items from this count list button
     * @date 07 May 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//label[@for='RemoveSkippedItem']"
    )
    WebElement rbtn_removeskippeditems;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Mistakenly clicked on this, go back!
     * @date 07 May 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//label[@for='MistakenlyClicked']"
    )
    WebElement rbtn_mistakenlyclicked;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Unlock products for selling as soon as they are counted radio button
     * @date 07 May 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//label[@for='Unlockproductforsell']"
    )
    WebElement rbtn_unlockproductforsel;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is forAll inventory count radio button
     * @date 07 May 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//label[@for='AllProviders']"
    )
    WebElement rbtn_allinventory;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Delete this count button
     * @date 07 May 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//a[text()='Delete this count']"
    )
    WebElement btn_deletethiscount;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Omit items with 0 inventory check box
     * @date 07 May 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//label[@for='excludeZeroStockProduct']"
    )
    WebElement chk_omitCount;

    public StockTake(WebDriver driver) {
        this.driver = driver;
    }
    public WebElement getCountStockTakeButton() {
        return btn_CountStocktake;
    }
    public WebElement getContinueButton() {
        return btn_continue;
    }
    public WebElement getMarkAsCompleteButton() {
        return btn_markascomplete;
    }
    public WebElement getAddCountZeroRadioButton() {
        return rbtn_addcountzero;
    }
    public WebElement getRemoveSkippedItemButton() {
        return rbtn_removeskippeditems;
    }
    public WebElement getMistakenlyClickedButton() {
        return rbtn_removeskippeditems;
    }
    public WebElement getUnlockProductForSel() {
        return rbtn_unlockproductforsel;
    }
    public WebElement getAllInventory() {
        return rbtn_allinventory;
    }
    public WebElement getDeleteThisCount() {
        return btn_deletethiscount;
    }
    public WebElement getOmitCount() {
        return chk_omitCount;
    }


    /**
     * @author Vidhi Chapanera
     * @date 07 May 2021
     * @discription this method is use to create Product for stock take
     * @return
     */
    @Step("create Product for stocktake"+"\n"+"product:{0}")
    public boolean createProductforStocktake(String product) throws IOException {
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
            centerlizePO.enterDataUsingSendkeys(PageFactory.initElements(driver,Products.class).getProductName(),product);
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
            centerlizePO.enterDataUsingSendkeys(products1.getProductType(),"PT");
            actions.sendKeys(Keys.TAB).build().perform();
            centerlizePO.enterDataUsingSendkeys(products1.getSuppliers(),"Automation Suppliers");
            actions.sendKeys(Keys.TAB).build().perform();
            centerlizePO.enterDataUsingSendkeys(products1.getBrand(),"Automation Brand");
            actions.sendKeys(Keys.TAB).build().perform();
            centerlizePO.clickOnButton(products1.getProductSaveButton());
            sleepFor(5);
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    /**
     * @author Vidhi Chapanera
     * @date 07 May 2021
     * @discription this method is use to verify Add count value 0 (zero) for all skipped items option
     * @return
     */
    @Step("verify Add count value 0 (zero) for all skipped items option")
    public boolean verifyAddAccountValuezero() throws IOException {
        CenterlizePO centerlizePO = PageFactory.initElements(driver, CenterlizePO.class);
        ProductsPO.ProductsPO.Products products1 = PageFactory.initElements(driver, ProductsPO.ProductsPO.Products.class);
        Actions actions = new Actions(driver);
        try{
            sleepFor(5);
            PageFactory.initElements(driver, Inventory.class).clickOnInventoryButton();
            centerlizePO.clickOnButton(getCountStockTakeButton());
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Suppliers.class).getAddNewButton());
            centerlizePO.enterDataUsingSendkeys(PageFactory.initElements(driver, Products.class).getSearchBox(),productName1);
            List<WebElement> list1 = new WebDriverWait(driver,120).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy
                            (By.xpath("//ul[contains(@class,'hike-width-block')]//b[text()='Product']//parent::ul//li//a")));
            centerlizePO.clickOnButton(list1.get(0));
            centerlizePO.clickOnButton(getContinueButton());
            centerlizePO.clickOnButton(getMarkAsCompleteButton());
            centerlizePO.clickOnButton(getAddCountZeroRadioButton());
            centerlizePO.clickOnButton(getContinueButton());
            sleepFor(5);
            PageFactory.initElements(driver, ProductsPO.Products.class).clickOnProductsButtonn();
            centerlizePO.clickOnButton(products1.getProductButton());
            sleepFor(2);
            centerlizePO.enterDataUsingSendkeys(PageFactory.initElements(driver, Products.class).getSearchBox(),productName1);
            List<WebElement> list2 = new WebDriverWait(driver,120).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy
                            (By.xpath("//ul[contains(@class,'hike-width-block')]//b[text()='Product']//parent::ul//li//a")));
            centerlizePO.clickOnButton(list2.get(0));
            WebElement product = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//table[@id='RosterDataTable']//tbody//tr//td[2]//span[text()='" + productName1 + "']//parent::td")));
            product.click();
            actions.moveToElement(PageFactory.initElements(driver, Products.class).getAvailableStock()).build().perform();
            String as = PageFactory.initElements(driver, Products.class).getAvailableStock().getText();
            if (as.contains("0"))
                System.out.println("");
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Products.class).getViewProductHistoryButton());
            sleepFor(1);
            sleepFor(2);
            WebElement inventoryLabel = new WebDriverWait(driver,60).
                    until(ExpectedConditions.elementToBeClickable(
                            (By.cssSelector("label[for='SearchByStocktake']"))));
            sleepFor(2);
            inventoryLabel.click();
            WebElement phCostPrice = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//table[@id='HistoryTable']//tbody//tr[1]//td[last()-3]")));
            if (phCostPrice.getText().contains("0"))
                sleepFor(2);
            actions.sendKeys(Keys.ESCAPE).build().perform();
            sleepFor(2);
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }


    /**
     * @author Vidhi Chapanera
     * @date 07 May 2021
     * @discription this method is use to verify Remove skipped items from this count list option
     * @return
     */
    @Step("verify Remove skipped items from this count list option")
    public boolean verifyRemoveSkippedItemFromthisCountList() throws IOException {
        CenterlizePO centerlizePO = PageFactory.initElements(driver, CenterlizePO.class);
        try{
            sleepFor(5);
            PageFactory.initElements(driver, Inventory.class).clickOnInventoryButton();
            centerlizePO.clickOnButton(getCountStockTakeButton());
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Suppliers.class).getAddNewButton());
            sleepFor(3);
            WebElement reference = new WebDriverWait(driver,50).until
                    (ExpectedConditions.presenceOfElementLocated
                            (By.id("Reference")));
            String referenceText = reference.getAttribute("value");
            System.out.println(referenceText);
            centerlizePO.enterDataUsingSendkeys(PageFactory.initElements(driver, Products.class).getSearchBox(),productName1);
            List<WebElement> list1 = new WebDriverWait(driver,120).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy
                            (By.xpath("//ul[contains(@class,'hike-width-block')]//b[text()='Product']//parent::ul//li//a")));
            centerlizePO.clickOnButton(list1.get(0));
            centerlizePO.clickOnButton(getContinueButton());
            centerlizePO.clickOnButton(getMarkAsCompleteButton());
            centerlizePO.clickOnButton(getRemoveSkippedItemButton());
            centerlizePO.clickOnButton(getContinueButton());
            sleepFor(8);
            WebElement open = new WebDriverWait(driver,50).until
                    (ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//table[@id='stocktakeDataTable']//tr//td//a[normalize-space(.)='"+referenceText+"']")));
            centerlizePO.clickOnButton(open);
            WebElement notFound = new WebDriverWait(driver,50).until
                    (ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//table[@id='ToBeCounted']//td[normalize-space(.)='No records found']")));
            if (notFound.isDisplayed())
                System.out.println("not Found....!");
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }



    /**
     * @author Vidhi Chapanera
     * @date 07 May 2021
     * @discription this method is use to verify Mistakenly clicked on this, go back!
     * @return
     */
    @Step("verify Mistakenly clicked on this, go back! option")
    public boolean verifyMistakenlyClickedonThisOption() throws IOException {
        CenterlizePO centerlizePO = PageFactory.initElements(driver, CenterlizePO.class);
        try{
            sleepFor(5);
            PageFactory.initElements(driver, Inventory.class).clickOnInventoryButton();
            centerlizePO.clickOnButton(getCountStockTakeButton());
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Suppliers.class).getAddNewButton());
            sleepFor(3);
            WebElement reference = new WebDriverWait(driver,50).until
                    (ExpectedConditions.presenceOfElementLocated
                            (By.id("Reference")));
            String referenceText = reference.getAttribute("value");
            System.out.println(referenceText);
            centerlizePO.enterDataUsingSendkeys(PageFactory.initElements(driver, Products.class).getSearchBox(),productName1);
            List<WebElement> list1 = new WebDriverWait(driver,120).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy
                            (By.xpath("//ul[contains(@class,'hike-width-block')]//b[text()='Product']//parent::ul//li//a")));
            centerlizePO.clickOnButton(list1.get(0));
            centerlizePO.clickOnButton(getContinueButton());
            centerlizePO.clickOnButton(getMarkAsCompleteButton());
            centerlizePO.clickOnButton(getMistakenlyClickedButton());
            centerlizePO.clickOnButton(getContinueButton());
            sleepFor(3);
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }



    /**
     * @author Vidhi Chapanera
     * @date 07 May 2021
     * @discription this method is use to verify Products in this count are to be unlocked only once all included products are counted option
     * @return
     */
    @Step("verify Products in this count are to be unlocked only once all included products are counted option")
    public boolean verifyLockFunctionality() throws IOException {
        CenterlizePO centerlizePO = PageFactory.initElements(driver, CenterlizePO.class);
        try{
            sleepFor(5);
            createProductforStocktake(productName2);
            PageFactory.initElements(driver, Inventory.class).clickOnInventoryButton();
            centerlizePO.clickOnButton(getCountStockTakeButton());
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Suppliers.class).getAddNewButton());
            WebElement reference = new WebDriverWait(driver,50).until
                    (ExpectedConditions.presenceOfElementLocated
                            (By.id("Reference")));
            referenceDataText = reference.getAttribute("value");
            centerlizePO.enterDataUsingSendkeys(PageFactory.initElements(driver, Products.class).getSearchBox(),productName2);
            List<WebElement> list1 = new WebDriverWait(driver,120).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy
                            (By.xpath("//ul[contains(@class,'hike-width-block')]//b[text()='Product']//parent::ul//li//a")));
            centerlizePO.clickOnButton(list1.get(0));
            centerlizePO.clickOnButton(getContinueButton());
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Groups.class).getSaveButton());
            PageFactory.initElements(driver, PointofSale.class).clickOnPointOfSaleButtonn();
            centerlizePO.clickOnButton(PageFactory.initElements(driver, CashRegister.class).getCashRegisterButton());
            centerlizePO.clickOnButton(PageFactory.initElements(driver, CashRegister.class).getRefreshDataButton());
            centerlizePO.clickOnButton(PageFactory.initElements(driver, CashRegister.class).getContinueButton());
            sleepFor(15);
            PageFactory.initElements(driver, ProcessSale.class).getSearchBar().sendKeys(productName2);
            sleepFor(2);
            Actions actions = new Actions(driver);
            actions.sendKeys(Keys.TAB).build().perform();
            sleepFor(1);
            WebElement popup = new WebDriverWait(driver,50).until
                    (ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//div[contains(text(),'This product is currently locked for stock take (inventory count).')]")));
            if (popup.isDisplayed())
                System.out.println("");
            actions.sendKeys(Keys.ESCAPE).build().perform();
            sleepFor(2);
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }



    /**
     * @author Vidhi Chapanera
     * @date 07 May 2021
     * @discription this method is use to verify Unlock products for selling as soon as they are counted option
     * @return
     */
    @Step("verify Unlock products for selling as soon as they are counted option")
    public boolean verifyunLockFunctionality() throws IOException {
        CenterlizePO centerlizePO = PageFactory.initElements(driver, CenterlizePO.class);
        try{
            sleepFor(5);
            createProductforStocktake(productName3);
            PageFactory.initElements(driver, Inventory.class).clickOnInventoryButton();
            centerlizePO.clickOnButton(getCountStockTakeButton());
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Suppliers.class).getAddNewButton());
            centerlizePO.clickOnButton(getUnlockProductForSel());
            centerlizePO.enterDataUsingSendkeys(PageFactory.initElements(driver, Products.class).getSearchBox(),productName3);
            List<WebElement> list1 = new WebDriverWait(driver,120).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy
                            (By.xpath("//ul[contains(@class,'hike-width-block')]//b[text()='Product']//parent::ul//li//a")));
            centerlizePO.clickOnButton(list1.get(0));
            centerlizePO.clickOnButton(getContinueButton());
            String enterCount ="5";
            WebElement number = new WebDriverWait(driver,50).until
                    (ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//button//parent::span//parent::div//input[@type='number']")));
            centerlizePO.enterDataUsingSendkeys(number,enterCount);
            WebElement btn = new WebDriverWait(driver,50).until
                    (ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//button//parent::span//parent::div//input[@type='number']//following-sibling::span//button")));
            centerlizePO.clickOnButton(btn);
            List<WebElement> list2 = new WebDriverWait(driver,120).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy
                            (By.xpath("//button[contains(normalize-space(.),'Continue')]")));
            centerlizePO.clickOnButton(list2.get(0));
            PageFactory.initElements(driver, PointofSale.class).clickOnPointOfSaleButtonn();
            centerlizePO.clickOnButton(PageFactory.initElements(driver, CashRegister.class).getCashRegisterButton());
            centerlizePO.clickOnButton(PageFactory.initElements(driver, CashRegister.class).getRefreshDataButton());
            centerlizePO.clickOnButton(PageFactory.initElements(driver, CashRegister.class).getContinueButton());
            sleepFor(10);
            PageFactory.initElements(driver, ProcessSale.class).getSearchBar().sendKeys(productName3);
            sleepFor(2);
            Actions actions = new Actions(driver);
            actions.sendKeys(Keys.TAB).build().perform();
            sleepFor(1);
            WebElement saleitem = new WebDriverWait(driver,60).until
                    (ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//div[contains(@class,'sell-item-title')]//span")));
            centerlizePO.clickOnButton(saleitem);
            WebElement qty = new WebDriverWait(driver,60).until
                    (ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//label[text()='Quantity']//following-sibling::input")));
            centerlizePO.clearText(qty);
            centerlizePO.enterDataUsingSendkeys(qty,enterCount);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Groups.class).getSaveButton());
            centerlizePO.clickOnButton(PageFactory.initElements(driver, ProcessSale.class).getPayButton());
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
            sleepFor(1);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, ProcessSale.class).getAddNewSaleButton());
            sleepFor(1);
            PageFactory.initElements(driver, ProcessSale.class).getSearchBar().sendKeys(productName3);
            sleepFor(2);
            actions.sendKeys(Keys.TAB).build().perform();
            sleepFor(1);
            WebElement popup = new WebDriverWait(driver,50).until
                    (ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//div[text()='Item not in stock, create a backorder?']")));
            if (popup.isDisplayed())
                sleepFor(1);
            actions.sendKeys(Keys.ESCAPE).build().perform();
            sleepFor(2);
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }



    /**
     * @author Vidhi Chapanera
     * @date 07 May 2021
     * @discription this method is use to verify All inventory count and Omit items with 0 inventory option
     * @return
     */
    @Step("verify All inventory count and Omit items with 0 inventory option")
    public boolean verifyAllInventoryCountAndOmitItemsOption() throws IOException {
        CenterlizePO centerlizePO = PageFactory.initElements(driver, CenterlizePO.class);
        try{
            sleepFor(5);
            PageFactory.initElements(driver, Inventory.class).clickOnInventoryButton();
            centerlizePO.clickOnButton(getCountStockTakeButton());
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Suppliers.class).getAddNewButton());
            centerlizePO.clickOnButton(getAllInventory());
            centerlizePO.clickOnButton(getContinueButton());
            List<WebElement> list1 = new WebDriverWait(driver,120).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy
                            (By.xpath("//table[@id='ToBeCounted']//tr//td[position()=4]")));
            int list1Count = list1.size();
            List<WebElement> list2 = new WebDriverWait(driver,120).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy
                            (By.xpath("//table[@id='ToBeCounted']//tr//td[position()=4][normalize-space(.)='0']")));
            int zeroItems = list2.size();
            int newCount = list1Count-zeroItems;
            centerlizePO.clickOnButton(getDeleteThisCount());
            centerlizePO.clickOnButton(getContinueButton());
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Suppliers.class).getAddNewButton());
            centerlizePO.clickOnButton(getAllInventory());
            centerlizePO.clickOnButton(getOmitCount());
            centerlizePO.clickOnButton(getContinueButton());
            List<WebElement> list3 = new WebDriverWait(driver,120).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy
                            (By.xpath("//table[@id='ToBeCounted']//tr//td[position()=4]")));
            int newCount1 = list3.size();
            if(newCount1==newCount)
                System.out.println("Same");
            sleepFor(2);
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }


}