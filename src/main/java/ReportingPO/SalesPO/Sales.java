package ReportingPO.SalesPO;

import CommonPO.BasePage;
import CommonPO.CenterlizePO;
import PointofSalePO.PointofSale;
import PointofSalePO.ProcessSalePO.ProcessSale;
import PointofSalePO.SalesHistoryPO.SalesHistory;
import ProductsPO.GiftCardsPO.GiftCards;
import ReportingPO.RegisterPO.Register;
import ReportingPO.Reporting;
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
import org.testng.Assert;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * @author Vidhi Chapanera
 * @date 09 February 2021
 */
public class Sales extends BasePage {

    public WebDriver driver;
    public static String testSaleNumber = "";
    public static int reportingSideVoidedCount =0;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for sales button
     * @date 09 February 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//span[contains(text(),'Reporting')]//parent::a[contains(@class,'auto')]//parent::li//ul//li//span[contains(text(),'Sales')]//parent::a"
    )
    WebElement btn_sales;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for sales Transactions button
     * @date 09 February 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//ul[contains(@class,'nav-justified')]//li//span[text()='Sales Transactions']//parent::uib-tab-heading//parent::a"
    )
    WebElement btn_salestransactions;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for pagination drop down
     * @date 09 February 2021
     */
    @FindBy(
            how = How.CSS,
            using = "select[name=TransactionDetailDataTable_length]"
    )
    WebElement drpdwn_pagination;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for search bar for sales transactions
     * @date 15 March 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//input[@placeholder='Find by order number']"
    )
    WebElement saletransactionstxt;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for LayBy[Reporting] button
     * @date 24 November 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//span[text()='Laybys']//parent::uib-tab-heading//parent::a"
    )
    WebElement btn_laybys;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for LayBy button
     * @date 24 November 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//button[normalize-space(.)='Layby']"
    )
    WebElement btn_laybys01;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for On Account button
     * @date 24 November 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//button[normalize-space(.)='On Account']"
    )
    WebElement btn_onaccount01;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for On Account[Reporting] button
     * @date 24 November 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//span[text()='On Account']//parent::uib-tab-heading//parent::a"
    )
    WebElement btn_onaccount02;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Park button
     * @date 26 November 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//button[normalize-space(.)='Park']"
    )
    WebElement btn_Park;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for discard button
     * @date 29 November 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//button[normalize-space(.)='Discard']"
    )
    WebElement btn_discard;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Include voided and discarded transactions checkbox
     * @date 29 November 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//label[@for='includeVoidedAndDiscardedTransactions']"
    )
    WebElement chk_includeVoidedAndDiscardedTransactions;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for invoice search drop down
     * @date 29 November 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//invoice-search-status-combo//a"
    )
    WebElement drpdwn_invoicesearch;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Voided sale option
     * @date 29 November 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//invoice-search-status-combo//a//parent::div//following-sibling::div//li//div[text()='Voided sales']"
    )
    WebElement option_voidedsales;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for yes button on swal popup
     * @date 19 January 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//a[text()='Yes']"
    )
    WebElement btn_yes;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for yes button on swal popup
     * @date 09 December 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//span[text()='Custom sale']//parent::uib-tab-heading//parent::a"
    )
    WebElement btn_customsale;


    public Sales(WebDriver driver) {
        this.driver = driver;
    }
    public WebElement getSalesButton() {
        return btn_sales;
    }
    public WebElement getSalesTransactionsButton() {
        return btn_salestransactions;
    }
    public WebElement getPaginationDropDown() {
        return drpdwn_pagination;
    }
    public WebElement getSalesTransactionsTxt() {
        return saletransactionstxt;
    }
    public WebElement getLayByButtons() {
        return btn_laybys;
    }
    public WebElement getLayBy01Buttons() {
        return btn_laybys01;
    }
    public WebElement getOnAccountButtons() {
        return btn_onaccount01;
    }
    public WebElement getOnAccount02Buttons() {
        return btn_onaccount02;
    }
    public WebElement getParkButton() {
        return btn_Park;
    }
    public WebElement getDiscardButton() {
        return btn_discard;
    }
    public WebElement getIncludeVoidedAndDiscardedTransactionsCheckBox() {
        return chk_includeVoidedAndDiscardedTransactions;
    }
    public WebElement getInvoiceSearchDropDown() {
        return drpdwn_invoicesearch;
    }
    public WebElement getVoidedSaleOption() {
        return option_voidedsales;
    }
    public WebElement getYesButton() {
        return btn_yes;
    }
    public WebElement getCustomSaleButton() {
        return btn_customsale;
    }

    /**
     * @return
     * @throws Exception
     * @author Vidhi Chapanera
     * @date 24 November 2021
     * @discription this method is use to Create LayBy sale
     */
    @Step("Create LayBy sale")
    public boolean createLayBySale() {
        CenterlizePO centerlizePO = PageFactory.initElements(driver, CenterlizePO.class);
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
            sleepFor(1);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, ProcessSale.class).getAddCustomerButton());
            centerlizePO.enterDataUsingSendkeys(PageFactory.initElements(driver, ProcessSale.class).getAddCustomer(),"A");
            sleepFor(1);
            actions.sendKeys(Keys.TAB).build().perform();
            sleepFor(2);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, ProcessSale.class).getPayButton());
            centerlizePO.clickOnButton(getLayBy01Buttons());
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
            centerlizePO.clickOnButton(PageFactory.initElements(driver, SalesHistory.class).getSalesHistoryButton());
            sleepFor(7);
            WebElement sale = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//table[@id='SalesTable']//tbody//tr[1]//td[2]//a[text()]")));
            testSaleNumber = sale.getText();
            System.out.println(testSaleNumber);
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
     * @date 24 November 2021
     * @discription this method is use to Verify Newly Created LayBy Sale orderNumber is display in Reporting side under LayBy section
     */
    @Step("Verify Newly Created LayBy Sale orderNumber is display in Reporting side under LayBy section"+"\n"+"id:{0}")
    public boolean VerifyReportingSide(String id) {
        try {
            sleepFor(5);
            WebElement sale = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//table[@id='"+id+"']//tbody//tr//td//a[text()='"+testSaleNumber+"']")));
            if (sale.isDisplayed())
                return true;
            return false;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }


    /**
     * @return
     * @throws Exception
     * @author Vidhi Chapanera
     * @date 24 November 2021
     * @discription this method is use to Create On Account sale
     */
    @Step("Create On Account sale")
    public boolean createOnAccountSale() {
        CenterlizePO centerlizePO = PageFactory.initElements(driver, CenterlizePO.class);
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
            sleepFor(1);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, ProcessSale.class).getAddCustomerButton());
            centerlizePO.enterDataUsingSendkeys(PageFactory.initElements(driver, ProcessSale.class).getAddCustomer(),"A");
            sleepFor(1);
            actions.sendKeys(Keys.TAB).build().perform();
            sleepFor(2);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, ProcessSale.class).getPayButton());
            centerlizePO.clickOnButton(getOnAccountButtons());
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
            centerlizePO.clickOnButton(PageFactory.initElements(driver, SalesHistory.class).getSalesHistoryButton());
            sleepFor(7);
            WebElement sale = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//table[@id='SalesTable']//tbody//tr[1]//td[2]//a[text()]")));
            testSaleNumber = sale.getText();
            System.out.println(testSaleNumber);
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
     * @date 26 November 2021
     * @discription this method is use to Create Park sale
     */
    @Step("Create Park sale")
    public boolean createParkSale() {
        CenterlizePO centerlizePO = PageFactory.initElements(driver, CenterlizePO.class);
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
            sleepFor(1);
            centerlizePO.clickOnButton(getParkButton());
            centerlizePO.clickOnButton(PageFactory.initElements(driver, GiftCards.class).getYesButton());
            sleepFor(3);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, SalesHistory.class).getSalesHistoryButton());
            sleepFor(7);
            WebElement sale = new WebDriverWait(driver, 60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//table[@id='SalesTable']//tbody//tr[1]//td[2]//a[text()]")));
            testSaleNumber = sale.getText();
            System.out.println(testSaleNumber);
            WebElement fullfillmentStatus = new WebDriverWait(driver, 60).
                    until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='" + testSaleNumber + "']//parent::td//following-sibling::td//span")));
            sleepFor(1);
            if (fullfillmentStatus.getText().equalsIgnoreCase("Parked")) {
                fullfillmentStatus.findElement(By.xpath("//parent::td//following-sibling::td//a[normalize-space(.)='Pay']")).click();
                sleepFor(10);
                centerlizePO.clickOnButton(PageFactory.initElements(driver, ProcessSale.class).getPayButton());
                centerlizePO.clickOnButton(PageFactory.initElements(driver, ProcessSale.class).getCashButton());
                centerlizePO.clickOnButton(getYesButton());
                sleepFor(3);
                String mainWindowHandle = driver.getWindowHandle();
                Set<String> allWindowHandles = driver.getWindowHandles();
                Iterator<String> iterator = allWindowHandles.iterator();
                while (iterator.hasNext()) {
                    String ChildWindow = iterator.next();
                    if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
                        driver.switchTo().window(ChildWindow);
                        WebElement text = new WebDriverWait(driver, 60).until(ExpectedConditions.presenceOfElementLocated(By.tagName("print-preview-app")));
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
                centerlizePO.clickOnButton(PageFactory.initElements(driver, SalesHistory.class).getSalesHistoryButton());
                sleepFor(3);
                WebElement fullfillmentStatus01 = new WebDriverWait(driver, 60).
                        until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='" + testSaleNumber + "']//parent::td//following-sibling::td//span")));
                sleepFor(1);
                if (fullfillmentStatus01.getText().equalsIgnoreCase("Completed"))
                    return true;
                else
                    return false;
            }else
                return false;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }



    /**
     * @return
     * @throws Exception
     * @author Vidhi Chapanera
     * @date 29 November 2021
     * @discription this method is use to Create Voided sale
     */
    @Step("Create Voided sale")
    public boolean createVoidedSale() {
        CenterlizePO centerlizePO = PageFactory.initElements(driver, CenterlizePO.class);
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
            sleepFor(1);
            centerlizePO.clickOnButton(getParkButton());
            centerlizePO.clickOnButton(PageFactory.initElements(driver, GiftCards.class).getYesButton());
            sleepFor(3);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, SalesHistory.class).getSalesHistoryButton());
            sleepFor(7);
            WebElement sale = new WebDriverWait(driver, 60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//table[@id='SalesTable']//tbody//tr[1]//td[2]//a[text()]")));
            testSaleNumber = sale.getText();
            System.out.println(testSaleNumber);
            WebElement fullfillmentStatus = new WebDriverWait(driver, 60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//a[text()='"+testSaleNumber+"']//parent::td//following-sibling::td//a[normalize-space(.)='Pay']")));
            sleepFor(1);
            fullfillmentStatus.click();
            sleepFor(10);
            centerlizePO.clickOnButton(getDiscardButton());
            centerlizePO.clickOnButton(PageFactory.initElements(driver, GiftCards.class).getYesButton());
            centerlizePO.clickOnButton(PageFactory.initElements(driver, SalesHistory.class).getSalesHistoryButton());
            sleepFor(10);
            /*if(getIncludeVoidedAndDiscardedTransactionsCheckBox().findElement(By.xpath("//preceding-sibling::input")).getAttribute("class").contains("ng-empty")){
                centerlizePO.clickOnButton(getIncludeVoidedAndDiscardedTransactionsCheckBox());
            }else {
                sleepFor(5);
            }*/
           // centerlizePO.clickOnButton(getIncludeVoidedAndDiscardedTransactionsCheckBox());

            centerlizePO.clickOnButton(getInvoiceSearchDropDown());
            centerlizePO.clickOnButton(getVoidedSaleOption());
            sleepFor(10);
            if (driver.findElement(By.xpath("//a[text()='"+testSaleNumber+"']")).isDisplayed()){
                List<WebElement> webElementList= new WebDriverWait(driver,60).
                        until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//table[@id='SalesTable']//tbody//tr//td[2]//a")));
                int salesHistorySideCount = webElementList.size();
                PageFactory.initElements(driver, Reporting.class).clickOnReportingButton();
                sleepFor(5);
                centerlizePO.clickOnButton(PageFactory.initElements(driver, Register.class).getRegisterButton());
                sleepFor(5);
                centerlizePO.clickOnButton(PageFactory.initElements(driver, Register.class).getVoidedTransactionsButton());
                sleepFor(5);
                List<WebElement> list001= new WebDriverWait(driver,60).
                        until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//table[@id='VoidTransactionsDetailDataTable']//tbody//td[2]")));
                for (int i=0;i<list001.size();i++){
                    reportingSideVoidedCount += Integer.parseInt(list001.get(i).getText());
                }
                int i = 0;
                if (reportingSideVoidedCount==salesHistorySideCount){
                    while (i<list001.size()) {
                        list001.get(i).click();
                        sleepFor(5);
                        if (driver.findElement(By.xpath("//a[text()='" + testSaleNumber + "']")).isDisplayed()) {
                            actions.sendKeys(Keys.ESCAPE).build().perform();
                            break;
                        }
                    }
                    PageFactory.initElements(driver, PointofSale.class).clickOnPointOfSaleButtonn();
                    sleepFor(3);
                    centerlizePO.clickOnButton(PageFactory.initElements(driver, SalesHistory.class).getSalesHistoryButton());
                    sleepFor(7);
                    centerlizePO.clickOnButton(getInvoiceSearchDropDown());
                    centerlizePO.clickOnButton(getVoidedSaleOption());
                    sleepFor(10);
                    centerlizePO.clickOnButton(getIncludeVoidedAndDiscardedTransactionsCheckBox());
                    sleepFor(7);
                    Assert.assertTrue(driver.findElement(By.xpath("//td[text()='No records found']")).isDisplayed());
                    return true;
                }else
                    return false;
            }else
                return false;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }


}
