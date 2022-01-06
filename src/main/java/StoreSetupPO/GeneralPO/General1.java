package StoreSetupPO.GeneralPO;

import ChangePINPO.ChangePIN;
import CommonPO.BasePage;
import CommonPO.CenterlizePO;
import Config.ExcelUtils;
import Config.WriteUtils;
import PointofSalePO.PointofSale;
import PointofSalePO.ProcessSalePO.ProcessSale;
import PointofSalePO.SalesHistoryPO.SalesHistory;
import ProductsPO.GiftCardsPO.GiftCards;
import ProductsPO.Products;
import ReportingPO.Reporting;
import ReportingPO.SalesPO.Sales;
import StoreSetupPO.LoyaltyPointsPO.LoyaltyPoints;
import StoreSetupPO.StoreSetup;
import StoreSetupPO.TaxRulesPO.TaxRules;
import UsersPO.UserPO.Users;
import io.qameta.allure.Step;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;


/**
 * @author Vidhi Chapanera
 * @date 22 January 2021
 */
public class General1 extends BasePage {

    public WebDriver driver;

    private static final Logger log4j = LogManager.getLogger(General1.class);

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for  Allow users to manually lock POS screen checkbox
     * @date 10 December 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//label[@for='toAllowUserToLockScreen']"
    )
    WebElement chk_lockscreen;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Lock screen button
     * @date 10 December 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//button[normalize-space(.)='Lock screen']"
    )
    WebElement btn_lockscreen;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Unlock screen form
     * @date 10 December 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//span[normalize-space(.)='Unlock screen']"
    )
    WebElement form_unlockscreen;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for iocn profile picture
     * @date 10 December 2021
     */
    @FindBy(
            how = How.ID,
            using = "HeaderProfilePicture"
    )
    WebElement icn_profile;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for tip/surcharge option
     * @date 16 December 2021
     */
    @FindBy(
            how = How.CSS,
            using = "label[for=generalrules4]"
    )
    WebElement chk_surcharge;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for  tip/surcharge option
     * @date 16 December 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//table[contains(@class,'cust-table')]//td[contains(text(),'Surcharge')]"
    )
    WebElement lnk_surcharge;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for surcharge area input box
     * @date 16 December 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//i[text()='%']//following-sibling::input"
    )
    WebElement surcharge_input;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for surcharge Percentage tax combo
     * @date 16 December 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//i[text()='%']//following-sibling::input//parent::div//parent::div//parent::form//tax-combo//a"
    )
    WebElement taxCombo;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Already exchanged items can be exchanged or returned again option
     * @date 16 December 2021
     */
    @FindBy(
            how = How.CSS,
            using = "label[for=exchangeInvoice]"
    )
    WebElement chk_againExchanged;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for directPrint
     * @date 16 December 2021
     */
    @FindBy(
            how = How.CSS,
            using = "label[for=directPrint]"
    )
    WebElement chk_directPrint;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for everyCustomerMustHaveAUniquePhoneNumber
     * @date 21 December 2021
     */
    @FindBy(
            how = How.CSS,
            using = "label[for=everyCustomerMustHaveAUniquePhoneNumber]"
    )
    WebElement chk_uniqueNumber;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for phone number textbox
     * @date 21 December 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//label[text()='Phone']//preceding-sibling::input"
    )
    WebElement txt_phone;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Do not include 'Parked orders' in sales reports check box
     * @date 24 December 2021
     */
    @FindBy(
            how = How.CSS,
            using = "label[for='excludeParkOrderFromReporting']"
    )
    WebElement chk_parkordernotinclude;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for park button
     * @date 24 December 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//button[normalize-space(.)='Park']"
    )
    WebElement btn_park;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Do not include 'Layby orders' in sales reports check box
     * @date 24 December 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//label[@for='excludeLayByFromReporting']"
    )
    WebElement chk_Laybyordernotinclude;

    public General1(WebDriver driver) {
        this.driver = driver;
    }
    public WebElement getLockScreenchk() {
        return chk_lockscreen;
    }
    public WebElement getLockScreenButton() {
        return btn_lockscreen;
    }
    public WebElement getUnLockScreenform() {
        return form_unlockscreen;
    }
    public WebElement getHeaderProfilePicture() {
        return icn_profile;
    }
    public WebElement getTipSurcharge() {
        return chk_surcharge;
    }
    public WebElement getSurchargePOS() {
        return lnk_surcharge;
    }
    public WebElement getSurchargeInput() {
        return surcharge_input;
    }
    public WebElement getTaxCombo() {
        return taxCombo;
    }
    public WebElement getAgainExchanged() {
        return chk_againExchanged;
    }
    public WebElement getDirectPrint() {
        return chk_directPrint;
    }
    public WebElement getUniqueNumber() {
        return chk_uniqueNumber;
    }
    public WebElement getPhoneNumber() {
        return txt_phone;
    }
    public WebElement getParkNotIncludeCheckbox() {
        return chk_parkordernotinclude;
    }
    public WebElement getParkButton() {
        return btn_park;
    }
    public WebElement getLaybyNotIncludeCheckbox() {
        return chk_Laybyordernotinclude;
    }

    /**
     * @author Vidhi Chapanera
     * @date 10 December 2021
     * @return
     * @throws Exception
     * @discription this method is used to Verify Allow users to manually lock POS screen
     */
    @Step("Allow users to manually lock POS screen")
    public boolean verifyUserManuallyLockPOSScreen() {
        Actions actions = new Actions(driver);
        CenterlizePO centerlizePO = PageFactory.initElements(driver,CenterlizePO.class);
        try {
            sleepFor(5);
            /*PageFactory.initElements(driver, StoreSetup.class).clickOnStoreSetupButton();
            centerlizePO.clickOnButton(PageFactory.initElements(driver, General.class).getGeneralButton());
            sleepFor(10);
            if (driver.findElement(By.id("toAllowUserToLockScreen")).getAttribute("class").contains("ng-not-empty")) {
                sleepFor(1);
                System.out.println("selected");
            } else {
                centerlizePO.clickOnButton(getLockScreenchk());
                actions.moveToElement(PageFactory.initElements(driver, Users.class).getSaveButton()).build().perform();
                PageFactory.initElements(driver, Users.class).getSaveButton().click();
                sleepFor(13);
            }*/
            String CurrentUrl = driver.getCurrentUrl();
            centerlizePO.clickOnButton(getHeaderProfilePicture());
            sleepFor(2);
            centerlizePO.clickOnButton(getLockScreenButton());
            sleepFor(3);
            Assert.assertTrue(getUnLockScreenform().isDisplayed());
            /*driver.navigate().refresh();
            sleepFor(10);
            Assert.assertTrue(getUnLockScreenform().isDisplayed());*/
            for (int i = 0; i < 2; i++) {
                sleepFor(1);
                ((JavascriptExecutor) driver).executeScript("window.open();");
                sleepFor(3);
                ArrayList<String> allWindows = new ArrayList<String> (driver.getWindowHandles());
                System.out.println(allWindows.size());
                driver.switchTo().window(allWindows.get(allWindows.size()-1));
                sleepFor(2);
                driver.get(CurrentUrl);
                sleepFor(10);
                Assert.assertTrue(getUnLockScreenform().isDisplayed());
            }
            ArrayList<String> allWindows = new ArrayList<String> (driver.getWindowHandles());
            for (int i = 1; i < allWindows.size(); i++) {
                sleepFor(1);
                driver.switchTo().window(allWindows.get(i));
                sleepFor(2);
                driver.close();
                sleepFor(2);
            }
            driver.switchTo().window(allWindows.get(0));
            List<WebElement> list = new WebDriverWait(driver, 30).ignoring(StaleElementReferenceException.class).until
                    (ExpectedConditions.refreshed(ExpectedConditions.presenceOfAllElementsLocatedBy
                            (By.xpath("//button[text()='Sign in as another user']//parent::div//parent::div//following-sibling::div//input"))));
            for(int i =0;i<list.size();i++){
                sleepFor(1);
                PageFactory.initElements(driver,CenterlizePO.class).enterDataUsingSendkeys(list.get(i),"0");
            }
            sleepFor(10);
            return true;

        }catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }


    /**
     * @author Vidhi Chapanera
     * @date 27 October 2021
     * @return
     * @throws Exception
     * @discription this method is used to Verify Shipping option
     */
    @Step("Verify Shipping option")
    public boolean verifySurchargeOption() {
        String amount = "10";
        Actions actions = new Actions(driver);
        try {
            sleepFor(3);
            CenterlizePO centerlizePO = PageFactory.initElements(driver,CenterlizePO.class);
            PageFactory.initElements(driver,StoreSetup.class).clickOnStoreSetupButton();
             /*centerlizePO.clickOnButton(PageFactory.initElements(driver,General.class).getGeneralButton());
            sleepFor(3);
            Actions actions = new Actions(driver);
            actions.moveToElement(getTipSurcharge()).click().build().perform();
            actions.moveToElement(PageFactory.initElements(driver, Users.class).getSaveButton()).build().perform();
            PageFactory.initElements(driver, Users.class).getSaveButton().click();
            sleepFor(13);*/

            centerlizePO.clickOnButton(PageFactory.initElements(driver, TaxRules.class).getTaxRules());
            sleepFor(8);

            ExcelUtils.removeAllCellDataString(System.getProperty("user.dir") + "\\xlsx File\\Tax.xlsx");
            sleepFor(10);
            List<WebElement> tax = new WebDriverWait(driver, 30).ignoring(StaleElementReferenceException.class).until
                    (ExpectedConditions.refreshed(ExpectedConditions.presenceOfAllElementsLocatedBy
                            (By.xpath("//tbody//tr//td//a"))));
            List<WebElement> per = new WebDriverWait(driver, 30).ignoring(StaleElementReferenceException.class).until
                    (ExpectedConditions.refreshed(ExpectedConditions.presenceOfAllElementsLocatedBy
                            (By.xpath("//tbody//tr//td[2]"))));
            for (int i = 1; i<tax.size();i++){
                String tax_itr = tax.get(i).getText();
                String percentage_itr = per.get(i).getText();
                String data = tax_itr + "/" + percentage_itr ;
                WriteUtils.writeCountInExstingExcel(System.getProperty("user.dir") + "\\xlsx File\\Tax.xlsx",data);
            }

            sleepFor(5);

            PageFactory.initElements(driver, Products.class).clickOnProductsButtonn();
            PageFactory.initElements(driver,PointofSale.class).clickOnPointOfSaleButtonn();
            centerlizePO.clickOnButton(PageFactory.initElements(driver,ProcessSale.class).getProcessSaleButton());
            sleepFor(15);

            sleepFor(2);
            PageFactory.initElements(driver, ProcessSale.class).getSearchBar().sendKeys("Demo Skirt");
            sleepFor(2);
            actions.sendKeys(Keys.TAB).build().perform();
            sleepFor(3);
            if (getSurchargePOS().isDisplayed())
            {
                List<String> listDD = ExcelUtils.getAllCellDataStringForTax();
                for (String ss : listDD) {
                    sleepFor(2);
                    getSurchargePOS().click();
                    sleepFor(1);
                    getSurchargeInput().clear();
                    getSurchargeInput().sendKeys(amount);
                    getTaxCombo().click();
                    sleepFor(3);
                    WebElement taxx = new WebDriverWait(driver, 60)
                            .until(ExpectedConditions.presenceOfElementLocated
                                    (By.xpath("//i[text()='%']//following-sibling::input//parent::div//parent::div//parent::form//tax-combo//a//following-sibling::div//li//div//div[text()='" + ss.split("/")[0] + "']")));
                    actions.moveToElement(taxx).click().build().perform();
                    sleepFor(3);
                    WebElement btn = new WebDriverWait(driver, 60)
                            .until(ExpectedConditions.presenceOfElementLocated
                                    (By.xpath("//i[text()='%']//following-sibling::input//parent::div//parent::div//parent::form//button[text()='Enter']")));
                    btn.click();
                    sleepFor(3);
                    float t1 = Float.parseFloat(ss.split("/")[1]) * Float.parseFloat(amount);
                    float t2 = (100 + Float.parseFloat(ss.split("/")[1]));
                    WebElement Inc = new WebDriverWait(driver, 60)
                            .until(ExpectedConditions.presenceOfElementLocated
                                    (By.xpath("//table[contains(@class,'cust-table')]//td[contains(text(),'Surcharge')]//span")));
                    if (Float.parseFloat(Inc.getText().substring(2))==Float.parseFloat(String.format("%.2f",t1 / t2))){
                        System.out.println("match...................//");
                    }
                }
            }else {
                System.out.println("not displayed............../");
            }
            return true;
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }


    /**
     * @author Vidhi Chapanera
     * @date 17 December 2021
     * @return
     * @throws Exception
     * @discription this method is used Already exchanged items can be exchanged or returned again option
     */
    @Step("Already exchanged items can be exchanged or returned again option")
    public boolean verifyExchangedAgain() {
        BasicConfigurator.configure();
        int count =3;
        Actions actions = new Actions(driver);
        try {
            sleepFor(3);
            CenterlizePO centerlizePO = PageFactory.initElements(driver,CenterlizePO.class);
            PageFactory.initElements(driver,StoreSetup.class).clickOnStoreSetupButton();
            centerlizePO.clickOnButton(PageFactory.initElements(driver,General.class).getGeneralButton());
            sleepFor(5);
            centerlizePO.clickOnButton(getDirectPrint());
            centerlizePO.clickOnButton(getAgainExchanged());
            sleepFor(5);
            actions.moveToElement(PageFactory.initElements(driver, Users.class).getSaveButton()).build().perform();
            PageFactory.initElements(driver, Users.class).getSaveButton().click();
            sleepFor(13);

            PageFactory.initElements(driver,PointofSale.class).clickOnPointOfSaleButtonn();
            centerlizePO.clickOnButton(PageFactory.initElements(driver,ProcessSale.class).getProcessSaleButton());
            sleepFor(15);

            sleepFor(2);
            PageFactory.initElements(driver, ProcessSale.class).getSearchBar().sendKeys("Demo Skirt");
            sleepFor(2);
            actions.sendKeys(Keys.TAB).build().perform();
            sleepFor(3);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, ProcessSale.class).getPayButton());
            centerlizePO.clickOnButton(PageFactory.initElements(driver, ProcessSale.class).getCashButton());
            sleepFor(3);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, ProcessSale.class).getAddNewSaleButton());
            sleepFor(3);

            centerlizePO.clickOnButton(PageFactory.initElements(driver, SalesHistory.class).getSalesHistoryButton());
            sleepFor(3);
            WebElement sale1 = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//table[@id='SalesTable']//tbody//tr[1]//td[2]//a[text()]")));
            String testSaleNumber = sale1.getText();
            sleepFor(1);
            log4j.info(testSaleNumber);

            for(int i=0 ;i<count;i++){
                WebElement exchangeElement = new WebDriverWait(driver,60).
                        until(ExpectedConditions.presenceOfElementLocated
                                (By.xpath("//table[@id='SalesTable']//tbody//tr[1]//td//a[normalize-space(.)='Exchange']")));
                exchangeElement.click();
                sleepFor(7);
                sleepFor(2);
                PageFactory.initElements(driver, ProcessSale.class).getSearchBar().sendKeys("T-01");
                sleepFor(2);
                actions.sendKeys(Keys.TAB).build().perform();
                sleepFor(3);
                centerlizePO.clickOnButton(PageFactory.initElements(driver, ProcessSale.class).getPayButton());
                sleepFor(2);
                if (PageFactory.initElements(driver, ProcessSale.class).getCashButton().isDisplayed()){
                    centerlizePO.clickOnButton(PageFactory.initElements(driver, ProcessSale.class).getCashButton());
                }else {
                    log4j.info("not Displayed/.,");
                }

                centerlizePO.clickOnButton(PageFactory.initElements(driver, ProcessSale.class).getAddNewSaleButton());
                sleepFor(3);
                centerlizePO.clickOnButton(PageFactory.initElements(driver, SalesHistory.class).getSalesHistoryButton());
                sleepFor(5);
            }

            List<WebElement> sixw = new WebDriverWait(driver, 30).ignoring(StaleElementReferenceException.class).until
                    (ExpectedConditions.refreshed(ExpectedConditions.presenceOfAllElementsLocatedBy
                            (By.xpath("//table[@id='SalesTable']//tbody//tr//td[2]//a[contains(text(),'"+testSaleNumber+"-EX')]"))));

            String s = String.valueOf(sixw.size());
            log4j.info(s);
            log4j.info(""+testSaleNumber+"-EX");

            Assert.assertEquals(String.valueOf(sixw.size()),String.valueOf(count));

            return true;
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }finally {
            sleepFor(3);
            CenterlizePO centerlizePO = PageFactory.initElements(driver,CenterlizePO.class);
            PageFactory.initElements(driver,StoreSetup.class).clickOnStoreSetupButton();
            centerlizePO.clickOnButton(PageFactory.initElements(driver,General.class).getGeneralButton());
            sleepFor(5);
            centerlizePO.clickOnButton(getDirectPrint());
            centerlizePO.clickOnButton(getAgainExchanged());
            sleepFor(5);
            actions.moveToElement(PageFactory.initElements(driver, Users.class).getSaveButton()).build().perform();
            PageFactory.initElements(driver, Users.class).getSaveButton().click();
            sleepFor(13);
        }
    }


    /**
     * @author Vidhi Chapanera
     * @date 21 December 2021
     * @return
     * @throws Exception
     * @discription this method is used Active Every customer must have a unique phone number option
     */
    @Step("Active Every customer must have a unique phone number ")
    public boolean uniquePhoneNumber() {
        BasicConfigurator.configure();
        Actions actions = new Actions(driver);
        String s ="Vivian Test1";
        String s1 ="412369875";
        try {
            sleepFor(3);
            CenterlizePO centerlizePO = PageFactory.initElements(driver,CenterlizePO.class);
            PageFactory.initElements(driver,StoreSetup.class).clickOnStoreSetupButton();
            centerlizePO.clickOnButton(PageFactory.initElements(driver,General.class).getGeneralButton());
            sleepFor(3);
            actions.moveToElement(getUniqueNumber()).click().build().perform();
            actions.moveToElement(PageFactory.initElements(driver, Users.class).getSaveButton()).build().perform();
            PageFactory.initElements(driver, Users.class).getSaveButton().click();
            sleepFor(13);

            PageFactory.initElements(driver, CustomersPO.Customers.class).clickOnCustomersButton();
            sleepFor(2);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, CustomersPO.CustomersPO.Customers.class).getCustomersButton());
            sleepFor(1);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, CustomersPO.CustomersPO.Customers.class).getAddCustomerButton());
            sleepFor(5);
            centerlizePO.enterDataUsingSendkeys(PageFactory.initElements(driver, CustomersPO.CustomersPO.Customers.class).getFirstName(),s.split(" ")[0]);
            centerlizePO.enterDataUsingSendkeys(PageFactory.initElements(driver, CustomersPO.CustomersPO.Customers.class).getLastName(),s.split(" ")[1]);
            centerlizePO.enterDataUsingSendkeys(getPhoneNumber(),s1);

            sleepFor(1);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, LoyaltyPoints.class).getSaveButton());
            sleepFor(7);

            centerlizePO.clickOnButton(PageFactory.initElements(driver, CustomersPO.CustomersPO.Customers.class).getAddCustomerButton());
            sleepFor(5);
            centerlizePO.enterDataUsingSendkeys(PageFactory.initElements(driver, CustomersPO.CustomersPO.Customers.class).getFirstName(),s.split(" ")[0]);
            centerlizePO.enterDataUsingSendkeys(PageFactory.initElements(driver, CustomersPO.CustomersPO.Customers.class).getLastName(),s.split(" ")[1]);
            centerlizePO.enterDataUsingSendkeys(getPhoneNumber(),s1);

            sleepFor(1);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, LoyaltyPoints.class).getSaveButton());
            sleepFor(7);

            Assert.assertTrue(driver.findElement(By.xpath("//div[text()='Phone already exist, please try with other option']")).isDisplayed());
            centerlizePO.clickOnButton(PageFactory.initElements(driver, ChangePIN.class).getOKButton());
            sleepFor(3);
            actions.sendKeys(Keys.ESCAPE).build().perform();
            sleepFor(3);

            return true;
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }finally {
            sleepFor(3);
            CenterlizePO centerlizePO = PageFactory.initElements(driver,CenterlizePO.class);
            PageFactory.initElements(driver,StoreSetup.class).clickOnStoreSetupButton();
            centerlizePO.clickOnButton(PageFactory.initElements(driver,General.class).getGeneralButton());
            sleepFor(3);
            actions.moveToElement(getUniqueNumber()).click().build().perform();
            actions.moveToElement(PageFactory.initElements(driver, Users.class).getSaveButton()).build().perform();
            PageFactory.initElements(driver, Users.class).getSaveButton().click();
            sleepFor(13);
        }
    }


    /**
     * @author Vidhi Chapanera
     * @date 24 December 2021
     * @return
     * @throws Exception
     * @discription this method is used get all amount from sales summery
     */
    @Step("get all amount of sales summery")
    public boolean getAllAmountFromSalesSummery() {
        BasicConfigurator.configure();
        try {
            ExcelUtils.removeAllCellDataString(System.getProperty("user.dir") + "\\xlsx File\\SalesSummery.xlsx");
            sleepFor(15);
            PageFactory.initElements(driver,Reporting.class).clickOnReportingButton();
            sleepFor(5);
            PageFactory.initElements(driver, Sales.class).getSalesButton().click();
            sleepFor(15);
            List<WebElement> amount = new WebDriverWait(driver, 30).ignoring(StaleElementReferenceException.class).until
                    (ExpectedConditions.refreshed(ExpectedConditions.presenceOfAllElementsLocatedBy
                            (By.xpath("//div[contains(@class,'dashboard-stat')]//div//h3[normalize-space(.)]"))));
            for (int i = 0; i<amount.size();i++){
                String amount_itr = amount.get(i).getText();
                WriteUtils.writeCountInExstingExcel(System.getProperty("user.dir") + "\\xlsx File\\SalesSummery.xlsx",amount_itr);
                log4j.info(amount_itr);
            }

            return true;
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }



    /**
     * @author Vidhi Chapanera
     * @date 24 December 2021
     * @return
     * @throws Exception
     * @discription this method is used Create one park sale option
     */
    @Step("Create one park sale")
    public boolean CreateOneParkSale() {
        BasicConfigurator.configure();
        Actions actions = new Actions(driver);
        try {
            sleepFor(3);
            CenterlizePO centerlizePO = PageFactory.initElements(driver,CenterlizePO.class);
            PageFactory.initElements(driver,StoreSetup.class).clickOnStoreSetupButton();
            centerlizePO.clickOnButton(PageFactory.initElements(driver,General.class).getGeneralButton());
            sleepFor(10);
            actions.moveToElement(getParkNotIncludeCheckbox()).click().build().perform();
            actions.moveToElement(PageFactory.initElements(driver, Users.class).getSaveButton()).build().perform();
            PageFactory.initElements(driver, Users.class).getSaveButton().click();
            sleepFor(15);

            getAllAmountFromSalesSummery();

            PageFactory.initElements(driver,PointofSale.class).clickOnPointOfSaleButtonn();
            centerlizePO.clickOnButton(PageFactory.initElements(driver,ProcessSale.class).getProcessSaleButton());
            sleepFor(15);

            sleepFor(2);
            PageFactory.initElements(driver, ProcessSale.class).getSearchBar().sendKeys("Demo Skirt");
            sleepFor(2);
            actions.sendKeys(Keys.TAB).build().perform();
            sleepFor(3);
            centerlizePO.clickOnButton(getParkButton());
            sleepFor(2);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, GiftCards.class).getYesButton());
            sleepFor(3);
            PageFactory.initElements(driver,Reporting.class).clickOnReportingButton();
            sleepFor(5);
            PageFactory.initElements(driver, Sales.class).getSalesButton().click();
            sleepFor(15);
            List<String> stringList = ExcelUtils.getAllCellDataStringSalesSummery();
            int i = 0;
            for (String s : stringList) {
                sleepFor(2);
                List<WebElement> amount = new WebDriverWait(driver, 30).ignoring(StaleElementReferenceException.class).until
                        (ExpectedConditions.refreshed(ExpectedConditions.presenceOfAllElementsLocatedBy
                                (By.xpath("//div[contains(@class,'dashboard-stat')]//div//h3[normalize-space(.)]"))));
                    Assert.assertEquals(amount.get(i).getText(), s);
                    String print = amount.get(i).getText()+"----"+ s;
                    log4j.info("same-" + print);
                    i++;

            }
            return true;
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }finally {
            sleepFor(3);
            CenterlizePO centerlizePO = PageFactory.initElements(driver,CenterlizePO.class);
            PageFactory.initElements(driver,StoreSetup.class).clickOnStoreSetupButton();
            centerlizePO.clickOnButton(PageFactory.initElements(driver,General.class).getGeneralButton());
            sleepFor(10);
            actions.moveToElement(getParkNotIncludeCheckbox()).click().build().perform();
            actions.moveToElement(PageFactory.initElements(driver, Users.class).getSaveButton()).build().perform();
            PageFactory.initElements(driver, Users.class).getSaveButton().click();
            sleepFor(13);
        }
    }



    /**
     * @author Vidhi Chapanera
     * @date 24 December 2021
     * @return
     * @throws Exception
     * @discription this method is used Create one LayBy sale option
     */
    @Step("Create one park sale")
    public boolean CreateOneLaybySale() {
        BasicConfigurator.configure();
        Actions actions = new Actions(driver);
        try {
            sleepFor(3);
            CenterlizePO centerlizePO = PageFactory.initElements(driver,CenterlizePO.class);
            PageFactory.initElements(driver,StoreSetup.class).clickOnStoreSetupButton();
            centerlizePO.clickOnButton(PageFactory.initElements(driver,General.class).getGeneralButton());
            sleepFor(10);
            actions.moveToElement(getLaybyNotIncludeCheckbox()).click().build().perform();
            actions.moveToElement(PageFactory.initElements(driver, Users.class).getSaveButton()).build().perform();
            PageFactory.initElements(driver, Users.class).getSaveButton().click();
            sleepFor(15);

            getAllAmountFromSalesSummery();

            PageFactory.initElements(driver, PointofSale.class).clickOnPointOfSaleButtonn();
            centerlizePO.clickOnButton(PageFactory.initElements(driver, ProcessSale.class).getProcessSaleButton());
            sleepFor(20);
            PageFactory.initElements(driver, ProcessSale.class).getSearchBar().sendKeys("Demo Skirt");
            sleepFor(3);
            actions.sendKeys(Keys.TAB).build().perform();
            sleepFor(1);
            sleepFor(1);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, ProcessSale.class).getAddCustomerButton());
            centerlizePO.enterDataUsingSendkeys(PageFactory.initElements(driver, ProcessSale.class).getAddCustomer(),"A");
            sleepFor(1);
            actions.sendKeys(Keys.TAB).build().perform();
            sleepFor(2);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, ProcessSale.class).getPayButton());
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Sales.class).getLayBy01Buttons());
            centerlizePO.clickOnButton(PageFactory.initElements(driver, GiftCards.class).getYesButton());
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
            sleepFor(3);
            PageFactory.initElements(driver,Reporting.class).clickOnReportingButton();
            sleepFor(5);
            PageFactory.initElements(driver, Sales.class).getSalesButton().click();
            sleepFor(15);
            List<String> stringList = ExcelUtils.getAllCellDataStringSalesSummery();
            int i = 0;
            for (String s : stringList) {
                sleepFor(2);
                List<WebElement> amount = new WebDriverWait(driver, 30).ignoring(StaleElementReferenceException.class).until
                        (ExpectedConditions.refreshed(ExpectedConditions.presenceOfAllElementsLocatedBy
                                (By.xpath("//div[contains(@class,'dashboard-stat')]//div//h3[normalize-space(.)]"))));
                Assert.assertEquals(amount.get(i).getText(), s);
                String print = amount.get(i).getText()+"----"+ s;
                log4j.info("same-" + print);
                i++;

            }
            return true;
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }finally {
            sleepFor(3);
            CenterlizePO centerlizePO = PageFactory.initElements(driver,CenterlizePO.class);
            PageFactory.initElements(driver,StoreSetup.class).clickOnStoreSetupButton();
            centerlizePO.clickOnButton(PageFactory.initElements(driver,General.class).getGeneralButton());
            sleepFor(10);
            actions.moveToElement(getLaybyNotIncludeCheckbox()).click().build().perform();
            actions.moveToElement(PageFactory.initElements(driver, Users.class).getSaveButton()).build().perform();
            PageFactory.initElements(driver, Users.class).getSaveButton().click();
            sleepFor(13);
        }
    }

}