package ReportingPO.PaymentsPO;

import CommonPO.BasePage;
import CommonPO.CenterlizePO;
import ReportingPO.Reporting;
import ReportingPO.SalesPO.Sales;
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
 * @date 06 December 2021
 */
public class Payments extends BasePage {

    public WebDriver driver;
    public static String testSaleNumber = "";

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Payments button
     * @date 06 December 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//span[contains(text(),'Reporting')]//parent::a[contains(@class,'auto')]//parent::li//ul//li//span[contains(text(),'Payments')]//parent::a"
    )
    WebElement btn_Payments;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Completed sale option
     * @date 06 December 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//invoice-search-status-combo//a//parent::div//following-sibling::div//li//div[text()='Completed sales']")
    WebElement option_CompletedSales;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Parked sale option
     * @date 06 December 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//invoice-search-status-combo//a//parent::div//following-sibling::div//li//div[text()='Parked']")
    WebElement option_ParkedSales;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Yes option
     * @date 06 December 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//button[normalize-space(.)='Yes']")
    WebElement btnYes;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for 'Deleted payments button
     * @date 06 December 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//ul[contains(@class,'nav-justified')]//li//span[text()='Deleted payments']//parent::uib-tab-heading//parent::a"
    )
    WebElement btn_Deletedpayments;

    public Payments(WebDriver driver) {
        this.driver = driver;
    }
    public WebElement getPaymentsButton() {
        return btn_Payments;
    }
    public WebElement getCompletedSaleOption() {
        return option_CompletedSales;
    }
    public WebElement getParkedSaleOption() {
        return option_ParkedSales;
    }
    public WebElement getYesButton() {
        return btnYes;
    }
    public WebElement getDeletedPaymentsButton() {
        return btn_Deletedpayments;
    }


    /**
     * @author Vidhi Chapanera
     * @date 06 December 2021
     * @return
     * @throws Exception
     * @discription this method is used to open completed Sale And Remove Payment
     */
    @Step("open completed Sale And Remove Payment")
    public boolean removePaymentFromCompletedSale() {
        Actions actions = new Actions(driver);
        try {
            sleepFor(3);
            CenterlizePO centerlizePO = PageFactory.initElements(driver, CenterlizePO.class);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Sales.class).getInvoiceSearchDropDown());
            sleepFor(2);
            centerlizePO.clickOnButton(getCompletedSaleOption());
            sleepFor(7);
            WebElement pagination = new WebDriverWait(driver,60).until(
                    ExpectedConditions.presenceOfElementLocated(By.name("SalesTable_length"))
            );
            actions.moveToElement(pagination).build().perform();
            sleepFor(3);
            Select select = new Select(pagination);
            select.selectByValue("20");
            sleepFor(7);
            WebElement sale = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//table[@id='SalesTable']//tbody//tr[last()]//td[2]//a[text()]")));
            actions.moveToElement(sale).build().perform();
            testSaleNumber += sale.getText();
            sleepFor(5);
            centerlizePO.clickOnButton(sale);
            sleepFor(7);
            List<WebElement> btn = new WebDriverWait(driver, 120).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy
                            (By.xpath("//span[text()='Payment summary']//parent::div//parent::div//parent::div//button[@cancel-button-type]")));
            for (int i = 0; i < btn.size(); i++) {
                centerlizePO.clickOnButton(btn.get(i));
                sleepFor(2);
            }
            centerlizePO.clickOnButton(getYesButton());
            sleepFor(7);
           /* centerlizePO.clickOnButton(PageFactory.initElements(driver, Sales.class).getInvoiceSearchDropDown());
            sleepFor(2);
            centerlizePO.clickOnButton(getParkedSaleOption());
            sleepFor(7);
            if (driver.findElement(By.xpath("//a[text()='"+testSaleNumber+"']//parent::td//following-sibling::td//span")).getText().contains("Parked")){
                sleepFor(1);
                return true;
            }
            else
                return false;*/
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }


    /**
     * @author Vidhi Chapanera
     * @date 06 December 2021
     * @return
     * @throws Exception
     * @discription this method is used to Verify In Reporting Side
     */
    @Step("Verify In Reporting Side")
    public boolean VerifySaleEnteryInReportingSide() {
        try {
            sleepFor(5);
            CenterlizePO centerlizePO = PageFactory.initElements(driver, CenterlizePO.class);
            PageFactory.initElements(driver, Reporting.class).clickOnReportingButton();
            sleepFor(5);
            centerlizePO.clickOnButton(getPaymentsButton());
            sleepFor(10);
            centerlizePO.clickOnButton(getDeletedPaymentsButton());
            sleepFor(10);
            if (driver.findElement(By.xpath("//a[text()='"+testSaleNumber+"']")).isDisplayed()){
                sleepFor(1);
                driver.findElement(By.xpath("//a[text()='"+testSaleNumber+"']")).click();
                sleepFor(10);
                Assert.assertTrue(driver.findElement(By.xpath("//td[text()='No payment as yet']")).isDisplayed());
                Actions actions = new Actions(driver);
                actions.sendKeys(Keys.DELETE).build().perform();
                return true;
            }
            else
                return false;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}