
package LockScreenPO;

import CommonPO.BasePage;
import CommonPO.CenterlizePO;
import PointofSalePO.PointofSale;
import PointofSalePO.ProcessSalePO.ProcessSale;
import PointofSalePO.SalesHistoryPO.SalesHistory;
import ReportingPO.Reporting;
import ReportingPO.SalesPO.Sales;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
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
 * @date 19 February 2021
 */
public class LockScreen extends BasePage {

    public WebDriver driver;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for who is selling popup
     * @date 15 March 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(@class,'selling')]"
    )
    WebElement whoissellingpopup ;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for active user
     * @date 15 March 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//li[contains(@class,'dropdown-user')]//span[text()]"
    )
    WebElement ativeUser ;

    public LockScreen(WebDriver driver) {
        this.driver = driver;
    }
    public WebElement getWhoIsSellingPopup() {
        return whoissellingpopup;
    }
    public WebElement getActiveUser() {
        return ativeUser;
    }

    /**
     * @return
     * @throws Exception
     * @author Vidhi Chapanera
     * @date 15 March 2021
     * @discription this method is use to Check lock screen functionality by adding new sale
     */
    @Step("Checked new product display on the ‘process sale’ page")
    public boolean checkNeProductDisplayOnProcessSalePage() {
        CenterlizePO centerlizePO = PageFactory.initElements(driver,CenterlizePO.class);
        String activeUser = "";
        String saleData = "";
        try {
            sleepFor(5);
            try {
                WebElement register = new WebDriverWait(driver,50)
                        .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='select-reg-btn']//span[contains(@class,'reg')]")));
                centerlizePO.clickOnButton(register);
            }catch (Exception e1){
                System.out.println("...! ");
            }
            sleepFor(15);
            if (getWhoIsSellingPopup().isDisplayed()){
                sleepFor(2);
                List<WebElement> elementList = new WebDriverWait(driver,120).
                        until(ExpectedConditions.presenceOfAllElementsLocatedBy
                                (By.xpath("//div[contains(@class,'selling')]//div[@class='text-center']//h5")));
                for(int i = 0; i <elementList.size();i++){
                    activeUser = elementList.get(i).getText();
                    elementList.get(i).click();
                    sleepFor(2);
                    String[] strArray2 = new String[]{"0", "0", "0", "0"};
                    for (String s : strArray2) {
                        WebElement element = new WebDriverWait(driver, 60).ignoring(StaleElementReferenceException.class).
                                until(ExpectedConditions.presenceOfElementLocated
                                        (By.xpath("//div[@class='enter-pin-wrapper']//button[text()='" + s + "']")));
                        element.click();
                        sleepFor(1);
                    }
                    break;
                }
                sleepFor(1);
                PageFactory.initElements(driver, ProcessSale.class).getSearchBar().sendKeys("d");
                sleepFor(1);
                Actions actions = new Actions(driver);
                actions.sendKeys(Keys.TAB).build().perform();
                sleepFor(1);
                centerlizePO.clickOnButton(PageFactory.initElements(driver, ProcessSale.class).getPayButton());
                sleepFor(1);
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
                        Actions actions1 = new Actions(driver);
                        actions1.sendKeys(Keys.TAB).build().perform();
                        actions1.sendKeys(Keys.ENTER).build().perform();
                    }
                }
                sleepFor(2);
                driver.switchTo().window(mainWindowHandle);
                sleepFor(3);
                centerlizePO.clickOnButton(PageFactory.initElements(driver, ProcessSale.class).getAddNewSaleButton());
                sleepFor(7);
                if (getWhoIsSellingPopup().isDisplayed()){
                    WebElement element = new WebDriverWait(driver,120).
                            until(ExpectedConditions.presenceOfElementLocated
                                    (By.xpath("//div[contains(@class,'selling')]//div[@class='text-center']//h5[contains(text(),'" + activeUser + "')]")));
                    element.click();
                    sleepFor(2);
                    String[] strArray2 = new String[]{"0", "0", "0", "0"};
                    for (String s : strArray2) {
                        WebElement until = new WebDriverWait(driver, 60).ignoring(StaleElementReferenceException.class).
                                until(ExpectedConditions.presenceOfElementLocated
                                        (By.xpath("//div[@class='enter-pin-wrapper']//button[text()='" + s + "']")));
                        until.click();
                        sleepFor(1);
                    }
                }
                sleepFor(3);
                if (getActiveUser().getText().contains(activeUser))
                    System.out.println(" ");
                sleepFor(2);
                PageFactory.initElements(driver,PointofSale.class).clickOnPointOfSaleButtonn();
                sleepFor(2);
                centerlizePO.clickOnButton(PageFactory.initElements(driver, SalesHistory.class).getSalesHistoryButton());
                sleepFor(3);
                WebElement sale = new WebDriverWait(driver,60).
                        until(ExpectedConditions.presenceOfElementLocated
                                (By.xpath("//table[@id='SalesTable']//tbody//tr[1]//td[2]//a[text()]")));
                saleData += sale.getText();
                sale.click();
                sleepFor(2);
                WebElement element = new WebDriverWait(driver,60).
                        until(ExpectedConditions.presenceOfElementLocated(By.xpath
                                ("//span[text()='Sale history']//parent::div//parent::div//parent::div//tbody//tr//td[3][text()]")));
                actions.moveToElement(element).build().perform();
                if (element.getText().contains(activeUser))
                    System.out.println(" ");
                sleepFor(1);
                actions.sendKeys(Keys.ESCAPE).build().perform();
                sleepFor(3);
                PageFactory.initElements(driver, Reporting.class).clickOnReportingButton();
                sleepFor(3);
                centerlizePO.clickOnButton(PageFactory.initElements(driver, Sales.class).getSalesButton());
                sleepFor(2);
                centerlizePO.clickOnButton(PageFactory.initElements(driver, Sales.class).getSalesTransactionsButton());
                sleepFor(1);
                centerlizePO.enterDataUsingSendkeys(PageFactory.initElements(driver, Sales.class).getSalesTransactionsTxt(),saleData);
                sleepFor(3);
                WebElement datalist = new WebDriverWait(driver,120).
                        until(ExpectedConditions.presenceOfElementLocated
                                (By.xpath("//table[@id='TransactionDetailDataTable']//tbody//tr//td[1]//a")));
                datalist.click();
                sleepFor(2);
                WebElement element1 = new WebDriverWait(driver,60).
                        until(ExpectedConditions.presenceOfElementLocated(By.xpath
                                ("//span[text()='Sale history']//parent::div//parent::div//parent::div//tbody//tr//td[3][text()]")));
                actions.moveToElement(element1).build().perform();
                if (element1.getText().contains(activeUser))
                    System.out.println(" ");
                sleepFor(1);
                actions.sendKeys(Keys.ESCAPE).build().perform();
                sleepFor(3);
            }
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
