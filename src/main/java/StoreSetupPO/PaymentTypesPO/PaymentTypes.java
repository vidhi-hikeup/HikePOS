package StoreSetupPO.PaymentTypesPO;

import CommonPO.BasePage;
import CommonPO.CenterlizePO;
import InventoryPO.Inventory;
import PointofSalePO.CashRegisterPO.CashRegister;
import PointofSalePO.PointofSale;
import PointofSalePO.ProcessSalePO.ProcessSale;
import PointofSalePO.SalesHistoryPO.SalesHistory;
import ReportingPO.RegisterPO.Register;
import ReportingPO.Reporting;
import StoreSetupPO.LoyaltyPointsPO.LoyaltyPoints;
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
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * @author Vidhi Chapanera
 * @date 09 March 2021
 */
public class PaymentTypes extends BasePage {

    public WebDriver driver;
    public static String paymentType = "";

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Payment types  button
     * @date 09 March 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//span[contains(text(),'Payment types')]//parent::a"
    )
    WebElement btn_paymenttypes;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for add Payment types button
     * @date 09 March 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//i[@class='fa fa-plus']//parent::a"
    )
    WebElement btn_addpaymenttypes;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Payment name input box
     * @date 09 March 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//label[contains(text(),'Payment name')]//parent::div//input"
    )
    //@FindBy(
            // how = How.XPATH,
            // using = "//label[text()='Payment name']//parent::div//input"
            // )
    WebElement txt_paymentname;

    public PaymentTypes(WebDriver driver) {
        this.driver = driver;
    }
    public WebElement getPaymentTypes() {
        return btn_paymenttypes;
    }
    public WebElement getAddPaymentTypes() {
        return btn_addpaymenttypes;
    }
    public WebElement getPaymentName() {
        return txt_paymentname;
    }


    /**
     * @author Vidhi Chapanera
     * @date 09 March 2021
     * @return
     * @throws Exception
     * @discription this method is used to add new payment method
     */
    @Step("add new payment method")
    public boolean addNewPaymentMethod() {
        CenterlizePO centerlizePO = PageFactory.initElements(driver,CenterlizePO.class);
        try {
            sleepFor(5);
            centerlizePO.clickOnButton(getAddPaymentTypes());
            sleepFor(2);
            centerlizePO.enterDataUsingSendkeys(getPaymentName(),"Automation2");
            paymentType = getPaymentName().getAttribute("value");
            sleepFor(1);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, LoyaltyPoints.class).getSaveButton());
            sleepFor(5);
            List<WebElement> elementList = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='table-responsive']//table//tbody//tr//td[1]//a")));
            for (WebElement e : elementList){
                if (e.getText().contains(paymentType))
                    System.out.println(" ");
                break;
            }
            sleepFor(5);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }


    /**
     * @author Vidhi Chapanera
     * @date 09 March 2021
     * @return
     * @throws Exception
     * @discription this method is used to add new sale and checkout with new payment method
     */
    @Step("add new sale and checkout with new payment method")
    public boolean addNewSaleAndCheckoutWithNewPaymentMethod() {
        CenterlizePO centerlizePO = PageFactory.initElements(driver,CenterlizePO.class);
        try {
            sleepFor(5);
            PageFactory.initElements(driver, Inventory.class).clickOnInventoryButton();
            PageFactory.initElements(driver, PointofSale.class).clickOnPointOfSaleButtonn();
            centerlizePO.clickOnButton(PageFactory.initElements(driver, CashRegister.class).getCashRegisterButton());
            sleepFor(5);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, CashRegister.class).getRefreshDataButton());
            centerlizePO.clickOnButton(PageFactory.initElements(driver, CashRegister.class).getContinueButton());
            sleepFor(25);
            PageFactory.initElements(driver, ProcessSale.class).getSearchBar().sendKeys("D");
            sleepFor(2);
            Actions actions = new Actions(driver);
            actions.sendKeys(Keys.TAB).build().perform();
            sleepFor(1);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, ProcessSale.class).getAddCustomerButton());
            centerlizePO.enterDataUsingSendkeys(PageFactory.initElements(driver, ProcessSale.class).getAddCustomer(),"A");
            sleepFor(1);
            actions.sendKeys(Keys.TAB).build().perform();
            sleepFor(4);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, ProcessSale.class).getPayButton());
            WebElement paymethod = new WebDriverWait(driver,50).
                    until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(text(),'"+paymentType+"')]")));
            paymethod.click();
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
            centerlizePO.clickOnButton(PageFactory.initElements(driver, ProcessSale.class).getEmailButton());
            sleepFor(1);
            //TODO
            /*centerlizePO.clearText(PageFactory.initElements(driver, ProcessSale.class).getTextEmail());
            centerlizePO.enterDataUsingSendkeys(PageFactory.initElements(driver, ProcessSale.class).getTextEmail(),"vidhi.hikeup@gmail.com");*/
            centerlizePO.clickOnButton(PageFactory.initElements(driver, ProcessSale.class).getSendIconButton());
            sleepFor(10);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, ProcessSale.class).getAddNewSaleButton());
            sleepFor(5);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }


    /**
     * @author Vidhi Chapanera
     * @date 09 March 2021
     * @return
     * @throws Exception
     * @discription this method is used to Verify new payment method in cash register page
     */
    @Step("Verify new payment method in cash register page")
    public boolean verifyPaymentMethodinCashRegister() {
        CenterlizePO centerlizePO = PageFactory.initElements(driver,CenterlizePO.class);
        try {
            sleepFor(5);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, CashRegister.class).getCashRegisterButton());
            sleepFor(5);
            List<WebElement> elementList = new WebDriverWait(driver,50).until
                    (ExpectedConditions.presenceOfAllElementsLocatedBy(
                            By.xpath("//span[contains(text(),'Payment tally')]//parent::div//parent::div//parent::div//table//tbody//tr//td[1][text()]")));
            for (int i=0;i<elementList.size();i++){
                sleepFor(1);
                if (elementList.get(i).getText().contains(paymentType))
                    System.out.println(" ");
                break;
            }
            sleepFor(2);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }


    /**
     * @author Vidhi Chapanera
     * @date 09 March 2021
     * @return
     * @throws Exception
     * @discription this method is used to Verify new payment method in sales history page
     */
    @Step("Verify new payment method in sales history page")
    public boolean verifyPaymentMethodinsaleshistory() {
        CenterlizePO centerlizePO = PageFactory.initElements(driver,CenterlizePO.class);
        try {
            sleepFor(5);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, SalesHistory.class).getSalesHistoryButton());
            sleepFor(5);
            List<WebElement> elementList = new WebDriverWait(driver,50).until
                    (ExpectedConditions.presenceOfAllElementsLocatedBy(
                            By.xpath("//div[@id='SalesTable_wrapper']//table//tbody//tr//td[2]//a")));
            elementList.get(0).click();
            sleepFor(3);
            WebElement element = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated(By.xpath
                            ("//span[text()='Payment summary']//parent::div//parent::div//parent::div//tbody//tr//td[1][text()]")));
            Actions actions = new Actions(driver);
            actions.moveToElement(element).build().perform();
            if (element.getText().contains(paymentType))
                System.out.println(" ");
            sleepFor(1);
            actions.sendKeys(Keys.ESCAPE).build().perform();
            sleepFor(3);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }


    /**
     * @author Vidhi Chapanera
     * @date 09 March 2021
     * @return
     * @throws Exception
     * @discription this method is used to Verify new payment method in Reporting side
     */
    @Step("Verify new payment method in Reporting side")
    public boolean verifyNewPaymentMethodInReportingSide() {
        CenterlizePO centerlizePO = PageFactory.initElements(driver,CenterlizePO.class);
        try {
            sleepFor(5);
            PageFactory.initElements(driver, Reporting.class).clickOnReportingButton();
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Register.class).getRegisterButton());
            sleepFor(5);
            List<WebElement> elementList = new WebDriverWait(driver,50).until
                    (ExpectedConditions.presenceOfAllElementsLocatedBy(
                            By.xpath("//div[@id='ShiftReportDetailDataTable_wrapper']//table//tbody//tr//td//a")));
            elementList.get(0).click();
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Register.class).getPaymentSummeryButton());
            List<WebElement> list = new WebDriverWait(driver,50).until
                    (ExpectedConditions.presenceOfAllElementsLocatedBy(
                            By.xpath("//div[@class='tab-content']//table//tbody//tr//td[1][text()]")));
            for (int i=0;i<list.size();i++){
                sleepFor(1);
                if (elementList.get(i).getText().contains(paymentType))
                    System.out.println(" ");
                break;
            }
            sleepFor(2);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}