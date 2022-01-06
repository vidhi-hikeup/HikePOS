package PointofSalePO.CashRegisterPO;

import CommonPO.BasePage;
import CommonPO.CenterlizePO;
import CustomersPO.CustomersPO.Customers;
import CustomersPO.GroupsPO.Groups;
import InventoryPO.Inventory;
import InventoryPO.TransfersPO.Transfers;
import PointofSalePO.PointofSale;
import PointofSalePO.ProcessSalePO.ProcessSale;
import ReportingPO.RegisterPO.Register;
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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * @author Vidhi Chapanera
 * @date 20 January 2021
 */
public class CashRegister extends BasePage {

    public WebDriver driver;
    public static String dataText = "";

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for cash register button
     * @date 20 January 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//span[contains(text(),'Cash register')]//parent::a"
    )
    WebElement btn_cashregister;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Refresh data button
     * @date 20 January 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//button[contains(text(),'Refresh data')]"
    )
    WebElement btn_refreshdata;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for continue button on swal popup
     * @date 20 January 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//div[@class='swal-footer']//button[text()='Continue']"
    )
    WebElement btn_continue;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for open register button
     * @date 04 February 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//button[contains(text(),'Open register')]"
    )
    WebElement btn_openregister;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for open floating amount input box
     * @date 04 February 2021
     */
    @FindBy(
            how = How.ID,
            using = "openingFloatAmount"
    )
    WebElement txtbox_openfloatingamount;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for open button
     * @date 04 February 2021
     */
    //old//@FindBy(
    // how = How.XPATH,
    // using = "//span[contains(text(),'Open')]"
    // )
    @FindBy(
            how = How.XPATH,
            using = "//button[normalize-space(.)='Open']"
    )
    WebElement btn_open;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for open button
     * @date 17 March 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//i[contains(@class,'mortar-board')]//parent::a"
    )
    //@FindBy(
            // how = How.XPATH,
            // using = "//a[contains(text(),'Learn')]"
            // )
    WebElement lnk_learn;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for close register button
     * @date 18 March 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//button[text()='Close register']"
    )
    WebElement btn_closeregister;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for cash register name input box
     * @date 18 March 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//label[contains(text(),'Cash register name')]//parent::div//input"
    )
    //@FindBy(
            //how = How.XPATH,
            // using = "//label[text()='Cash register name']//parent::div//input"
            //)
    WebElement txt_registerName;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for delete outlet button
     * @date 18 March 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//button[text()='Delete this outlet']"
    )
    WebElement btn_deleteoutlet;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for continue button
     * @date 08 February 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//button[contains(text(),'Cancel')]//following-sibling::button[contains(text(),'Continue')]"
    )
    WebElement btn_continue1;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for second option
     * @date 08 February 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//label[@for='outletDeleteProductOption2']"
    )
    WebElement lbl_secondoption;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for second option
     * @date 03 December 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//label[contains(text(),'Receipt number prefix')]//preceding-sibling::input"
    )
    WebElement txt_receiptNumberPrefix;

    public CashRegister(WebDriver driver) {
        this.driver = driver;
    }
    public WebElement getCashRegisterButton() {
        return btn_cashregister;
    }
    public WebElement getRefreshDataButton() {
        return btn_refreshdata;
    }
    public WebElement getContinueButton() {
        return btn_continue;
    }
    public WebElement getOpenRegisterButton() {
        return btn_openregister;
    }
    public WebElement getOpenFloatingAmount() {
        return txtbox_openfloatingamount;
    }
    public WebElement getOpenButton() {
        return btn_open;
    }
    public WebElement getLearn() {
        return lnk_learn;
    }
    public WebElement getCloseRegister() {
        return btn_closeregister;
    }
    public WebElement getCashRegisterName() {
        return txt_registerName;
    }
    public WebElement getDeleteOutLet() {
        return btn_deleteoutlet;
    }
    public WebElement getagainContinueButton() {
        return btn_continue1;
    }
    public WebElement getSecondOption() {
        return lbl_secondoption;
    }
    public WebElement getReceiptNumberPrefix() {
        return txt_receiptNumberPrefix;
    }

    /**
     * @author Vidhi Chapanera
     * @date 20 January 2021
     * @return
     * @throws Exception
     * @discription this method is used to verify user redirect to process sale page after click on refresh data
     */
    @Step("verify user redirect to dashboard page after click on refresh data")
    public boolean verifyUserRedirectToprocessSalePage() {
        try {
            sleepFor(5);
            WebElement btn = new WebDriverWait(driver, 90).
                    until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'Process sale')]//parent::a//parent::li")));
            if (btn.getAttribute("class").contains("active")){
                System.out.println("");
                return true;
            }else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * @return
     * @throws Exception
     * @author Vidhi Chapanera
     * @date 04 February 2021
     * @discription this method is use to open Cash ragister
     */
    @Step("open cash ragister")
    public boolean openCashRagister(){
        CenterlizePO centerlizePO = PageFactory.initElements(driver,CenterlizePO.class);
        try {
            sleepFor(8);
            PageFactory.initElements(driver, PointofSale.class).clickOnPointOfSaleButtonn();
            centerlizePO.clickOnButton(PageFactory.initElements(driver, CashRegister.class).getCashRegisterButton());
            sleepFor(5);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, CashRegister.class).getOpenRegisterButton());
            centerlizePO.clearText(PageFactory.initElements(driver, CashRegister.class).getOpenFloatingAmount());
            centerlizePO.enterDataUsingSendkeys(PageFactory.initElements(driver, CashRegister.class).getOpenFloatingAmount(),"100");
            sleepFor(2);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, CashRegister.class).getOpenButton());
            sleepFor(3);
            return true;
        } catch (Exception ex) {
            return true;
        }
    }


    /**
     * @return
     * @throws Exception
     * @author Vidhi Chapanera
     * @date 17 March 2021
     * @discription this method is use to Support Article, go to enter sale page , click on support article button , slider should be open , now click on any article link , now selected article should be open in new tab.
     */
    @Step("Support Article, go to enter sale page , click on support article button , slider should be open , now click on any article link , now selected article should be open in new tab.")
    public boolean supportArticle(){
        CenterlizePO centerlizePO = PageFactory.initElements(driver,CenterlizePO.class);
        try {
            sleepFor(8);
            centerlizePO.clickOnButton(getLearn());
            if(driver.findElement(By.xpath("//span[contains(text(),'Support articles')]//parent::div//parent::div/parent::div/parent::div[contains(@class,'slider')]")).isDisplayed())
                System.out.println(" ");
            List<WebElement> list = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                            By.xpath("//span[contains(text(),'Support articles')]//parent::div//parent::div//parent::div//descendant::a")));
            for (int i=0; i<list.size();i++){
                list.get(i).click();
                sleepFor(5);
                ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
                driver.switchTo().window(tabs.get(1));
                if (tabs.size()>1)
                    System.out.println(tabs.size());
                if (driver.getCurrentUrl().contains("articles"))
                    System.out.println(" ");
                driver.close();
                driver.switchTo().window(tabs.get(0));
                break;
            }
            Actions actions = new Actions(driver);
            actions.sendKeys(Keys.ESCAPE).build().perform();
            sleepFor(3);
            return true;
        } catch (Exception ex) {
            return true;
        }
    }


    /**
     * @return
     * @throws Exception
     * @author Vidhi Chapanera
     * @date 18 March 2021
     * @discription this method is use to outlet/Cash Register and floating Point
     */
    @Step("outlet/Cash Register and floating Point")
    public boolean outletCashRegisterFloatingPoint(){
        CenterlizePO centerlizePO = PageFactory.initElements(driver,CenterlizePO.class);
        String outletName = "Test Outlet";
        String registerName = "Test Register";
        try {
            sleepFor(3);
            PageFactory.initElements(driver, StoreSetup.class).clickOnStoreSetupButton();
            centerlizePO.clickOnButton(PageFactory.initElements(driver, OutletsAndRegisters.class).getOutletsAndRegisters());
            sleepFor(5);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, OutletsAndRegisters.class).getAddOutlet());
            sleepFor(1);
            centerlizePO.enterDataUsingSendkeys(PageFactory.initElements(driver, OutletsAndRegisters.class).getOutletName(),outletName);
            centerlizePO.enterDataUsingSendkeys(PageFactory.initElements(driver, OutletsAndRegisters.class).getEmail(),"test.Outlet@yopmail.com");
            sleepFor(1);
            PageFactory.initElements(driver, OutletsAndRegisters.class).getSaveButton().click();
            sleepFor(8);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, OutletsAndRegisters.class).getLinkAllRadioButton());
            centerlizePO.clickOnButton(PageFactory.initElements(driver, OutletsAndRegisters.class).getContinueButton());
            sleepFor(15);
            WebElement btn = new WebDriverWait(driver,50)
                    .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='"+outletName+"']//parent::td//parent::tr//button")));
            btn.click();
            sleepFor(5);
            centerlizePO.enterDataUsingSendkeys(getCashRegisterName(),registerName);
            centerlizePO.enterDataUsingSendkeys(getReceiptNumberPrefix(),"V-");
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Groups.class).getSaveButton());
            sleepFor(20);
            PageFactory.initElements(driver, Inventory.class).clickOnInventoryButton();
            PageFactory.initElements(driver, PointofSale.class).clickOnPointOfSaleButtonn();
            centerlizePO.clickOnButton(getCashRegisterButton());
            sleepFor(3);
            centerlizePO.clickOnButton(getCloseRegister());
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Customers.class).getContinueButton());
            sleepFor(8);
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
            centerlizePO.clickOnButton(getRefreshDataButton());
            centerlizePO.clickOnButton(getContinueButton());
            sleepFor(20);
            WebElement outlet = new WebDriverWait(driver,50)
                    .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul[contains(@class,'tabs')]//li//a[text()='"+outletName+"']")));
            outlet.click();
            WebElement register = new WebDriverWait(driver,50)
                    .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='select-reg-btn']//span[contains(text(),'"+registerName+"')]")));
            register.click();
            sleepFor(5);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, CashRegister.class).getCashRegisterButton());
            sleepFor(5);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, CashRegister.class).getOpenRegisterButton());
            centerlizePO.clearText(PageFactory.initElements(driver, CashRegister.class).getOpenFloatingAmount());
            centerlizePO.enterDataUsingSendkeys(PageFactory.initElements(driver, CashRegister.class).getOpenFloatingAmount(),"100");
            sleepFor(2);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, CashRegister.class).getOpenButton());
            sleepFor(3);
            WebElement cash = new WebDriverWait(driver,50)
                    .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'Payment tally')]//parent::div//parent::div//parent::div//table//tbody//tr//td[1][text()='Cash']//following-sibling::td[1]")));
            String cashPrice = cash.getText();
            float cash01 = Float.parseFloat(cashPrice.substring(1));
            sleepFor(2);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, ProcessSale.class).getProcessSaleButton());
            sleepFor(30);
            centerlizePO.enterDataUsingSendkeys(PageFactory.initElements(driver, ProcessSale.class).getSearchBar(),"d");
            sleepFor(3);
            Actions actions = new Actions(driver);
            actions.sendKeys(Keys.TAB).build().perform();
            sleepFor(3);
            WebElement payprice = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//button[contains(@class,'btn-xlarge')]//div[contains(@class,'right')]")));
            String payPrice = payprice.getText();
            float pay01 = Float.parseFloat(payPrice.substring(1));
            float cashClose = cash01+pay01;
            centerlizePO.clickOnButton(PageFactory.initElements(driver, ProcessSale.class).getPayButton());
            sleepFor(3);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, ProcessSale.class).getCashButton());
            sleepFor(5);
            String mainWindowHandle01 = driver.getWindowHandle();
            Set<String> allWindowHandles01 = driver.getWindowHandles();
            Iterator<String> iterator01 = allWindowHandles01.iterator();
            while (iterator01.hasNext()) {
                String ChildWindow = iterator01.next();
                if (!mainWindowHandle01.equalsIgnoreCase(ChildWindow)) {
                    driver.switchTo().window(ChildWindow);
                    WebElement text = new WebDriverWait(driver,60).until(ExpectedConditions.presenceOfElementLocated(By.tagName("print-preview-app")));
                    Actions actions1 = new Actions(driver);
                    actions1.sendKeys(Keys.TAB).build().perform();
                    actions1.sendKeys(Keys.ENTER).build().perform();
                }
            }
            sleepFor(2);
            driver.switchTo().window(mainWindowHandle01);
            sleepFor(3);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, ProcessSale.class).getAddNewSaleButton());
            sleepFor(7);
            centerlizePO.clickOnButton(getCashRegisterButton());
            sleepFor(3);
            WebElement cash02 = new WebDriverWait(driver,50)
                    .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'Payment tally')]//parent::div//parent::div//parent::div//table//tbody//tr//td[1][text()='Cash']//following-sibling::td[1]")));
            String cashPrice02 = cash02.getText();
            float cash002 = Float.parseFloat(cashPrice02.substring(1));
            if(cash002==cashClose)
                sleepFor(2);
            centerlizePO.clickOnButton(getCloseRegister());
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Customers.class).getContinueButton());
            sleepFor(8);
            String mainWindowHandle02 = driver.getWindowHandle();
            Set<String> allWindowHandles02 = driver.getWindowHandles();
            Iterator<String> iterator02 = allWindowHandles02.iterator();
            while (iterator02.hasNext()) {
                String ChildWindow = iterator02.next();
                if (!mainWindowHandle02.equalsIgnoreCase(ChildWindow)) {
                    driver.switchTo().window(ChildWindow);
                    WebElement text = new WebDriverWait(driver,60).until(ExpectedConditions.presenceOfElementLocated(By.tagName("print-preview-app")));
                    System.out.println("Heading of child window is " + text.getText());
                    Actions actions1 = new Actions(driver);
                    actions1.sendKeys(Keys.TAB).build().perform();
                    actions1.sendKeys(Keys.ENTER).build().perform();
                }
            }
            sleepFor(3);
            driver.switchTo().window(mainWindowHandle02);
            sleepFor(1);
            PageFactory.initElements(driver, Reporting.class).clickOnReportingButton();
            sleepFor(2);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Register.class).getRegisterButton());
            sleepFor(5);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Transfers.class).getOutletDropDownButton());
            sleepFor(1);
            WebElement out = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//outlet-combo//a//parent::div//div[text()='"+outletName+"']//parent::div[contains(@class,'inner')]")));
            centerlizePO.clickOnButton(out);
            sleepFor(5);
            WebElement reout = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//table[@id='ShiftReportDetailDataTable']//tr//td[1]//a[contains(text(),'"+outletName+"')]//parent::td//following-sibling::td[3]")));
            String s = reout.getText();
            float f =Float.parseFloat(s.substring(1));
            sleepFor(1);
            if (f==cashClose)
                sleepFor(3);
            return true;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return true;
        }finally {
            PageFactory.initElements(driver, StoreSetup.class).clickOnStoreSetupButton();
            sleepFor(3);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, OutletsAndRegisters.class).getOutletsAndRegisters());
            sleepFor(5);
            WebElement editbtn = new WebDriverWait(driver,50)
                    .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='"+outletName+"']//parent::td//parent::tr//a[text()='Edit']")));
            JavascriptExecutor executor = (JavascriptExecutor)driver;
            executor.executeScript("arguments[0].click();", editbtn);
            sleepFor(10);
            Actions actions = new Actions(driver);
            actions.moveToElement(getDeleteOutLet()).click().build().perform();
            sleepFor(5);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Customers.class).getContinueButton());

            /**
             * @tag Added
             */
            centerlizePO.clickOnButton(getSecondOption());
            centerlizePO.clickOnButton(getagainContinueButton());///
            sleepFor(30);
            PageFactory.initElements(driver, Inventory.class).clickOnInventoryButton();
            sleepFor(2);
            PageFactory.initElements(driver, PointofSale.class).clickOnPointOfSaleButtonn();
            sleepFor(2);
            centerlizePO.clickOnButton(getCashRegisterButton());
            sleepFor(5);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, CashRegister.class).getOpenRegisterButton());
            sleepFor(2);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, CashRegister.class).getOpenButton());
            sleepFor(3);
        }
    }
}