package InventoryPO.TransfersPO;

import CommonPO.BasePage;
import CommonPO.CenterlizePO;
import Config.ExcelUtils;
import Config.WriteUtils;
import InventoryPO.Inventory;
import InventoryPO.MyInventoryPO.MyInventory;
import InventoryPO.PurchasesPO.Purchases;
import PointofSalePO.PointofSale;
import PointofSalePO.ProcessSalePO.ProcessSale;
import ReportingPO.Reporting;
import StoreSetupPO.OutletsAndRegistersPO.OutletsAndRegisters;
import StoreSetupPO.StoreSetup;
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
 * @date 18 February 2021
 */
public class Transfers extends BasePage {

    public WebDriver driver;

    public static String outLet01 = "";
    public static int outLet01Inventory = 0;
    public static String outLet02 = "";
    public static int outLet02Inventory = 0;
    public static int transferStock = 0;
    public static String productItemName = "";
    public static String UOMName = "";
    public static int UOMQuantity = 0;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Transfers button
     * @date 18 February 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//span[contains(text(),'Transfers')]//parent::a"
    )
    WebElement btn_transfers;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for save button
     * @date 18 February 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//button[text()='Save']"
    )
    WebElement btn_save ;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for save drop down button
     * @date 18 February 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//button[text()='Save']//parent::div//i//parent::button"
    )
    WebElement btn_savedropdown ;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for mark as received button
     * @date 18 February 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//a[text()='Mark as received']"
    )
    WebElement btn_markasreceived ;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for outlet drop down button
     * @date 18 February 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//outlet-combo//a"
    )
    WebElement btn_outletdropdown ;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Save & email button
     * @date 04 March 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//a[text()='Save & email']"
    )
    WebElement btn_saveandemail ;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for CC email input box
     * @date 04 March 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//label[text()='Cc']//parent::div//descendant::input"
    )
    WebElement txt_ccemail ;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for to email input box
     * @date 04 March 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//label[text()='to']//parent::div//descendant::input"
    )
    WebElement txt_toemail ;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for send button
     * @date 04 March 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//button[text()='Send']"
    )
    WebElement btn_Send ;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Delete this transfer order button
     * @date 04 March 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//button[text()='Delete this transfer order']"
    )
    WebElement btn_deletetransferorder ;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Save as draft (continue editing) button
     * @date 16 March 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//a[text()='Save as draft (continue editing)']"
    )
    WebElement btn_Saveasdraft;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Print goods received button
     * @date 16 March 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//a[text()='Print goods received']"
    )
    WebElement btn_Printgoodsreceived;

    public Transfers(WebDriver driver) {
        this.driver = driver;
    }
    public WebElement getTransfersButton() {
        return btn_transfers;
    }
    public WebElement getSaveButton() {
        return btn_save;
    }
    public WebElement getSaveDropDownButton() {
        return btn_savedropdown;
    }
    public WebElement getMarkAsReceivedButton() {
        return btn_markasreceived;
    }
    public WebElement getOutletDropDownButton() {
        return btn_outletdropdown;
    }
    public WebElement getSaveAndEmailButton() {
        return btn_saveandemail;
    }
    public WebElement getCCEmailInputBox() {
        return txt_ccemail;
    }
    public WebElement getToEmailInputBox() {
        return txt_toemail;
    }
    public WebElement getSendButton() {
        return btn_Send;
    }
    public WebElement getDeleteTransferOrderButton() {
        return btn_deletetransferorder;
    }
    public WebElement getSaveAsDraftButton() {
        return btn_Saveasdraft;
    }
    public WebElement getPrintgoodsreceivedButton() {
        return btn_Printgoodsreceived;
    }

    /**
     * @return
     * @throws Exception
     * @author Vidhi Chapanera
     * @date 18 February 2021
     * @discription this method is use to Verify Transfers Functionality
     */
    @Step("Verify Transfers Functionality"+"\n"+"ProductType:{0}")
    public boolean verifyTransfersFunctionality(String ProductType) {
        CenterlizePO centerlizePO = PageFactory.initElements(driver,CenterlizePO.class);
        OutletsAndRegisters outletsAndRegisters = PageFactory.initElements(driver,OutletsAndRegisters.class);
        try {
            sleepFor(3);
            PageFactory.initElements(driver, StoreSetup.class).clickOnStoreSetupButton();
            centerlizePO.clickOnButton(outletsAndRegisters.getOutletsAndRegisters());
            sleepFor(1);
            centerlizePO.clickOnButton(outletsAndRegisters.getAddOutlet());
            sleepFor(1);
            centerlizePO.enterDataUsingSendkeys(outletsAndRegisters.getOutletName(),"Melbourne");
            centerlizePO.enterDataUsingSendkeys(outletsAndRegisters.getEmail(),"melbourne.Outlet@yopmail.com");
            sleepFor(1);
            outletsAndRegisters.getSaveButton().click();
            sleepFor(2);
            centerlizePO.clickOnButton(outletsAndRegisters.getLinkAllRadioButton());
            centerlizePO.clickOnButton(outletsAndRegisters.getContinueButton());
            sleepFor(3);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, PointofSale.class).getPointOfSaleButton());
            centerlizePO.clickOnButton(PageFactory.initElements(driver, ProcessSale.class).getProcessSaleButton());
            sleepFor(5);
            /*WebElement register = new WebDriverWait(driver,120).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//div[contains(@class,'select-reg-btn')]")));
            register.click();*/
            sleepFor(7);
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
            centerlizePO.clickOnButton(PageFactory.initElements(driver, ProductsPO.Products.class).getProductButton());
            centerlizePO.clickOnButton(PageFactory.initElements(driver, ProductsPO.ProductsPO.Products.class).getProductButton());
            sleepFor(1);
            centerlizePO.enterDataUsingSendkeys(PageFactory.initElements(driver, ProductsPO.ProductsPO.Products.class).getSearchBox(),UOMName);
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
            List<WebElement> outlet = new WebDriverWait(driver,120).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy
                            (By.xpath("//th[text()='Available stock']//parent::tr//parent::thead//parent::table//tbody//tr//td[1]")));
            ExcelUtils.removeAllCellDataString(System.getProperty("user.dir") + "\\xlsx File\\Transfers.xlsx");
            for(int i =0; i<outlet.size();i++){
                actions.moveToElement(outlet.get(i)).build().perform();
                String outlets = outlet.get(i).getText();
                WebElement e1 = new WebDriverWait(driver,60).until(ExpectedConditions.presenceOfElementLocated(
                        (By.xpath("//th[text()='Available stock']//parent::tr//parent::thead//parent::table//tbody//tr//td[text()='"+outlets+"']//parent::tr//td[3]"))));
                String stock = e1.getText();
                String testData;
                testData = outlets + "_" + stock;
                WriteUtils.writeCountInExstingExcel(System.getProperty("user.dir") + "\\xlsx File\\Transfers.xlsx",testData);
            }
            PageFactory.initElements(driver,Inventory.class).clickOnInventoryButton();
            centerlizePO.clickOnButton(getTransfersButton());
            centerlizePO.clickOnButton(PageFactory.initElements(driver,Purchases.class).getAddNewButton());
            sleepFor(5);
            List<String> list1 = ExcelUtils.getAllCellDataStringForTransfers();
            outLet01 = list1.get(0).split("_")[0];
            outLet01Inventory = Integer.parseInt(list1.get(0).split("_")[1]);
            outLet02 = list1.get(1).split("_")[0];
            outLet02Inventory = Integer.parseInt(list1.get(1).split("_")[1]);
            WebElement sourceoutlet = new WebDriverWait(driver,120).
                    until(ExpectedConditions.presenceOfElementLocated(
                            (By.xpath("//label[text()='Source outlet']//parent::div//a"))));
            JavascriptExecutor executor = (JavascriptExecutor)driver;
            executor.executeScript("arguments[0].click();", sourceoutlet);
            sleepFor(1);
            WebElement sourceoutletoption = new WebDriverWait(driver,120).
                    until(ExpectedConditions.presenceOfElementLocated(
                            (By.xpath("//label[text()='Source outlet']//parent::div//ul//li//ul//li//div[text()='"+outLet01+"']//parent::div[contains(@class,'inner')]"))));
            executor.executeScript("arguments[0].click();", sourceoutletoption);
            sleepFor(1);
            WebElement destinationoutlet = new WebDriverWait(driver,120).
                    until(ExpectedConditions.presenceOfElementLocated(
                            (By.xpath("//label[text()='Destination outlet']//parent::div//a"))));
            executor.executeScript("arguments[0].click();", destinationoutlet);
            sleepFor(1);
            WebElement destinationoutletoption = new WebDriverWait(driver,120).
                    until(ExpectedConditions.presenceOfElementLocated(
                            (By.xpath("//label[text()='Destination outlet']//parent::div//ul//li//ul//li//div[text()='"+outLet02+"']//parent::div[contains(@class,'inner')]"))));
            executor.executeScript("arguments[0].click();", destinationoutletoption);
            List<WebElement> elements = new  WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//input[@ng-model='searchtext']")));
            sleepFor(1);
            elements.get(0).click();
            elements.get(0).sendKeys(UOMName);
            sleepFor(5);
            WebElement inventoryatsource = new WebDriverWait(driver,60).until
                    (ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//span[text()='Inventory at source']//parent::th//parent::tr//parent::thead//parent::table//tbody//tr//td[4]")));
            String t1 = inventoryatsource.getText();
            int inventoryAtSource1 = Integer.parseInt(t1);
            int inventoryAtSource = outLet01Inventory/UOMQuantity;
            if (inventoryAtSource1==inventoryAtSource)
                System.out.println("");
            sleepFor(1);
            WebElement inventoryatdestination = new WebDriverWait(driver,60).until
                    (ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//span[text()='Inventory at source']//parent::th//parent::tr//parent::thead//parent::table//tbody//tr//td[5]")));
            String t2 = inventoryatdestination.getText();
            int inventoryAtDestination1 = Integer.parseInt(t2);
            int inventoryAtDestination = outLet02Inventory/UOMQuantity;
            if (inventoryAtDestination1==inventoryAtDestination)
                System.out.println("");
            sleepFor(1);
            WebElement chkbocx = new WebDriverWait(driver,60).until
                    (ExpectedConditions.presenceOfElementLocated
                            (By.cssSelector("table.table.table-hover.table-vert.table-border.fix-table-header > tbody > tr > td > div > label")));
            executor.executeScript("arguments[0].click();", chkbocx);
            sleepFor(1);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Purchases.class).getAddAndContinueButton());
            sleepFor(1);
            String order = "5";
            int orderCount = Integer.parseInt(order);
            sleepFor(1);
            WebElement quantityinput = new WebDriverWait(driver,60).until
                    (ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//parent::th[text()=' Quantity ']//parent::tr//parent::thead//parent::table//tbody//tr//td[2]//input")));
            quantityinput.clear();
            quantityinput.sendKeys(order);
            transferStock = orderCount*UOMQuantity;
            centerlizePO.clickOnButton(getSaveButton());
            sleepFor(5);
            WebElement transfer = new WebDriverWait(driver,60).until
                    (ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//table[@id='stocktransferDataTable']//tbody//tr//td//i[contains(@class,'yellow-casablanca')]//parent::td//parent::tr//td[1]//a")));
            transfer.click();
            sleepFor(3);
            centerlizePO.clickOnButton(getSaveDropDownButton());
            centerlizePO.clickOnButton(getMarkAsReceivedButton());
            sleepFor(2);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, ProductsPO.Products.class).getProductButton());
            centerlizePO.clickOnButton(PageFactory.initElements(driver, ProductsPO.ProductsPO.Products.class).getProductButton());
            sleepFor(5);
            WebElement product1 = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//table[@id='RosterDataTable']//tbody//tr//td[2]//span[text()='" + productItemName + "']//parent::td")));
            product1.click();
            sleepFor(5);
            actions.sendKeys(Keys.PAGE_DOWN).build().perform();
            WebElement out01 = new WebDriverWait(driver,60).until(ExpectedConditions.presenceOfElementLocated(
                    (By.xpath("//th[text()='Available stock']//parent::tr//parent::thead//parent::table//tbody//tr//td[text()='"+outLet01+"']//parent::tr//td[3]"))));
            int afterTransfertOutLet01Stock = Integer.parseInt(out01.getText());
            int out01Inventory = outLet01Inventory-transferStock;
            if (afterTransfertOutLet01Stock==out01Inventory)
                System.out.println(" ");
            sleepFor(1);
            WebElement out02 = new WebDriverWait(driver,60).until(ExpectedConditions.presenceOfElementLocated(
                    (By.xpath("//th[text()='Available stock']//parent::tr//parent::thead//parent::table//tbody//tr//td[text()='"+outLet02+"']//parent::tr//td[3]"))));
            int afterTransfertOutLet02Stock = Integer.parseInt(out02.getText());
            int out02Inventory = outLet02Inventory+transferStock;
            if (afterTransfertOutLet02Stock==out02Inventory)
                System.out.println(" ");
            sleepFor(1);
            PageFactory.initElements(driver,Inventory.class).clickOnInventoryButton();
            sleepFor(1);
            centerlizePO.clickOnButton(PageFactory.initElements(driver,MyInventory.class).getMyInventoryButton());
            sleepFor(2);
            centerlizePO.enterDataUsingSendkeys(PageFactory.initElements(driver, MyInventory.class).getSearchBox(),productItemName);
            sleepFor(3);
            centerlizePO.clickOnButton(getOutletDropDownButton());
            sleepFor(1);
            WebElement myinvenrotyout01 = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//outlet-combo//a//parent::div//div[text()='"+outLet01+"']//parent::div[contains(@class,'inner')]")));
            centerlizePO.clickOnButton(myinvenrotyout01);
            sleepFor(2);
            WebElement outlet01onHand = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//table[@id='InventoryRecordDataTable']//tbody//tr[1]//td[3]")));
            String data = outlet01onHand.getText();
            int outlet01onHandstock = Integer.parseInt(data);
            if (outlet01onHandstock==out01Inventory)
                System.out.println("");
            sleepFor(3);
            centerlizePO.clickOnButton(getOutletDropDownButton());
            sleepFor(1);
            WebElement myinvenrotyout02 = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//outlet-combo//a//parent::div//div[text()='"+outLet02+"']//parent::div[contains(@class,'inner')]")));
            centerlizePO.clickOnButton(myinvenrotyout02);
            sleepFor(2);
            WebElement outlet02onHand = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//table[@id='InventoryRecordDataTable']//tbody//tr[1]//td[3]")));
            String data1 = outlet02onHand.getText();
            int outlet02onHandstock = Integer.parseInt(data1);
            if (outlet02onHandstock==out02Inventory)
                System.out.println("");
            sleepFor(3);
            centerlizePO.clickOnButton(getOutletDropDownButton());
            sleepFor(1);
            WebElement all = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//outlet-combo//a//parent::div//div[text()='All']//parent::div[contains(@class,'inner')]")));
            centerlizePO.clickOnButton(all);
            sleepFor(2);
            WebElement alloutletonHand = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//table[@id='InventoryRecordDataTable']//tbody//tr[1]//td[3]")));
            String data2 = alloutletonHand.getText();
            int alloutletonHandstock = Integer.parseInt(data2);
            int allstock = out01Inventory+out02Inventory;
            if (alloutletonHandstock==allstock)
                System.out.println("");
            sleepFor(1);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Reporting.class).getReportingButton());
            centerlizePO.clickOnButton(PageFactory.initElements(driver, ReportingPO.InventoryPO.Inventory.class).getInventoryButton());
            sleepFor(1);sleepFor(1);
            List<WebElement> invinput = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy
                            (By.xpath("//div[@class='input-icon']//input")));
            invinput.get(0).sendKeys(productItemName);
            sleepFor(2);
            centerlizePO.clickOnButton(getOutletDropDownButton());
            sleepFor(1);
            WebElement reportinginvenrotyout01 = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//outlet-combo//a//parent::div//div[text()='"+outLet01+"']//parent::div[contains(@class,'inner')]")));
            centerlizePO.clickOnButton(reportinginvenrotyout01);
            sleepFor(2);
            WebElement reportinginvenrotyout01onHand = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//table[@id='InventoryDetailDataTable']//tbody//tr[1]//td[3]//a")));
            String testData = reportinginvenrotyout01onHand.getText();
            int reportinginvenrotyout01onHandStock = Integer.parseInt(testData);
            if (reportinginvenrotyout01onHandStock==out01Inventory)
                System.out.println("");
            sleepFor(3);
            centerlizePO.clickOnButton(getOutletDropDownButton());
            sleepFor(1);
            WebElement reportinginvenrotyout02 = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//outlet-combo//a//parent::div//div[text()='"+outLet02+"']//parent::div[contains(@class,'inner')]")));
            centerlizePO.clickOnButton(reportinginvenrotyout02);
            sleepFor(2);
            WebElement reportinginvenrotyout02onHand = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//table[@id='InventoryDetailDataTable']//tbody//tr[1]//td[3]//a")));
            String testData1 = reportinginvenrotyout02onHand.getText();
            int reportinginvenrotyout02onHandStock = Integer.parseInt(testData1);
            if (reportinginvenrotyout02onHandStock==out02Inventory)
                System.out.println("");
            sleepFor(3);
            centerlizePO.clickOnButton(getOutletDropDownButton());
            sleepFor(1);
            WebElement reportingall = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//outlet-combo//a//parent::div//div[text()='All']//parent::div[contains(@class,'inner')]")));
            centerlizePO.clickOnButton(reportingall);
            sleepFor(2);
            WebElement reportingalloutletonHand = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//table[@id='InventoryDetailDataTable']//tbody//tr[1]//td[3]//a")));
            String testData2 = reportingalloutletonHand.getText();
            int reportingalloutletonHandstock = Integer.parseInt(testData2);
            int reportingallstock = out01Inventory+out02Inventory;
            if (reportingalloutletonHandstock==reportingallstock)
                System.out.println("");
            sleepFor(1);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

}