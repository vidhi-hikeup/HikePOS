package InventoryPO.BackorderPO;

import CommonPO.BasePage;
import CommonPO.CenterlizePO;
import InventoryPO.PurchasesPO.Purchases;
import PointofSalePO.PointofSale;
import PointofSalePO.ProcessSalePO.ProcessSale;
import PointofSalePO.SalesHistoryPO.SalesHistory;
import ProductsPO.GiftCardsPO.GiftCards;
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
 * @date 15 March 2021
 */
public class Backorder extends BasePage {

    public WebDriver driver;
    /**
     * @author Vidhi Chapanera
     * @discription this locator is for purchases button
     * @date 15 March 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//span[contains(text(),'Purchases')]//parent::a"
    )
    WebElement btn_purchases;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for create a backorder button
     * @date 15 March 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//button//div[contains(text(),'Create backorder')]"
    )
    WebElement btn_createbackorder;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for create a draft PO button
     * @date 15 March 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//button[contains(text(),'Create draft PO')]"
    )
    WebElement btn_createdaftPO;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for create new PO button
     * @date 15 March 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//button[contains(text(),'Create new PO')]"
    )
    WebElement btn_createnewPO;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Reference value
     * @date 15 March 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//label[contains(text(),'Reference#')]//parent::div//input"
    )
    WebElement Referencevalue;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for add to exsting PO button
     * @date 15 March 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//button[contains(text(),' Add to existing PO')]"
    )
    WebElement btn_addtoexstingPO;


    public Backorder(WebDriver driver) {
        this.driver = driver;
    }
    public WebElement getPurchasesButton() {
        return btn_purchases;
    }
    public WebElement getCreateBackorderButton() {
        return btn_createbackorder;
    }
    public WebElement getCreateDraftPOButton() {
        return btn_createdaftPO;
    }
    public WebElement getCreateNewPOButton() {
        return btn_createnewPO;
    }
    public WebElement getReferenceValue() {
        return Referencevalue;
    }
    public WebElement getAddToExstingPO() {
        return btn_addtoexstingPO;
    }


    /**
     * @return
     * @throws Exception
     * @author Vidhi Chapanera
     * @date 15 March 2021
     * @discription this method is use to add new product with empty stock
     */
    @Step("add new product with empty stock")
    public boolean addNewPRoductWithEmptyStock() {
        ProductsPO.ProductsPO.Products products1 = PageFactory.initElements(driver, ProductsPO.ProductsPO.Products.class);
        CenterlizePO centerlizePO = PageFactory.initElements(driver, CenterlizePO.class);
        Actions actions = new Actions(driver);
        String product = "Backorder-Product05";
        try {
            sleepFor(5);
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
            PageFactory.initElements(driver, PointofSale.class).clickOnPointOfSaleButtonn();
            centerlizePO.clickOnButton(PageFactory.initElements(driver, ProcessSale.class).getProcessSaleButton());
            sleepFor(15);
            PageFactory.initElements(driver, ProcessSale.class).getSearchBar().sendKeys(product);
            sleepFor(2);
            actions.sendKeys(Keys.TAB).build().perform();
            sleepFor(1);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, GiftCards.class).getYesButton());
            centerlizePO.clickOnButton(PageFactory.initElements(driver, ProcessSale.class).getAddCustomerButton());
            centerlizePO.enterDataUsingSendkeys(PageFactory.initElements(driver, ProcessSale.class).getAddCustomer(),"A");
            sleepFor(1);
            actions.sendKeys(Keys.TAB).build().perform();
            sleepFor(2);
            centerlizePO.clickOnButton(getCreateBackorderButton());
            sleepFor(4);
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
            sleepFor(5);
            driver.switchTo().window(mainWindowHandle);
            sleepFor(1);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, ProcessSale.class).getAddNewSaleButton());
            sleepFor(5);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, SalesHistory.class).getSalesHistoryButton());
            sleepFor(3);
            WebElement sale = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//table[@id='SalesTable']//tbody//tr[1]//td[5]//a[text()]")));
            sale.click();
            sleepFor(1);
            centerlizePO.clickOnButton(getCreateDraftPOButton());
            sleepFor(2);
            centerlizePO.clickOnButton(getCreateNewPOButton());
            sleepFor(2);
            WebElement reference = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//div[contains(@class,'slider-modal-body')]//table//a")));
            String referenceData = reference.getText();
            reference.click();
            sleepFor(5);
            /**
             * old locator //form[@name='orderCreateOrEditForm']
             * new locator //form[contains(@name,'orderCreateOrEditFormPo')]
             */
           /* WebElement form = new WebDriverWait(driver,80).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//form[@name='orderCreateOrEditForm']")));*/
            WebElement form = new WebDriverWait(driver,80).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//form[contains(@name,'orderCreateOrEditFormPo')]")));
            int oldCount = 0;
            if (form.isDisplayed()){
                sleepFor(2);
                if (getReferenceValue().getAttribute("value").contains(referenceData))
                    System.out.println("");
                //centerlizePO.clickOnButton(PageFactory.initElements(driver, Purchases.class).getDeleteThisPO());
                List<WebElement> elementList = new WebDriverWait(driver,60).until
                        (ExpectedConditions.presenceOfAllElementsLocatedBy
                                (By.xpath("//span[text()='Order items']//parent::div//parent::div//parent::div//table//tbody//tr")));
                oldCount = elementList.size();
                sleepFor(2);
            }
            PageFactory.initElements(driver, PointofSale.class).clickOnPointOfSaleButtonn();
            centerlizePO.clickOnButton(PageFactory.initElements(driver, ProcessSale.class).getProcessSaleButton());
            sleepFor(15);
            PageFactory.initElements(driver, ProcessSale.class).getSearchBar().sendKeys(product);
            sleepFor(2);
            actions.sendKeys(Keys.TAB).build().perform();
            sleepFor(1);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, GiftCards.class).getYesButton());
            centerlizePO.clickOnButton(PageFactory.initElements(driver, ProcessSale.class).getAddCustomerButton());
            centerlizePO.enterDataUsingSendkeys(PageFactory.initElements(driver, ProcessSale.class).getAddCustomer(),"A");
            sleepFor(1);
            actions.sendKeys(Keys.TAB).build().perform();
            sleepFor(2);
            centerlizePO.clickOnButton(getCreateBackorderButton());
            sleepFor(2);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, ProcessSale.class).getCashButton());
            sleepFor(5);
            String mainWindowHandle1 = driver.getWindowHandle();
            Set<String> allWindowHandles1 = driver.getWindowHandles();
            Iterator<String> iterator1 = allWindowHandles1.iterator();
            while (iterator1.hasNext()) {
                String ChildWindow = iterator1.next();
                if (!mainWindowHandle1.equalsIgnoreCase(ChildWindow)) {
                    driver.switchTo().window(ChildWindow);
                    WebElement text = new WebDriverWait(driver,60).until(ExpectedConditions.presenceOfElementLocated(By.tagName("print-preview-app")));
                    Actions actions1 = new Actions(driver);
                    actions1.sendKeys(Keys.TAB).build().perform();
                    actions1.sendKeys(Keys.ENTER).build().perform();
                }
            }
            sleepFor(5);
            driver.switchTo().window(mainWindowHandle1);
            sleepFor(1);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, ProcessSale.class).getAddNewSaleButton());
            sleepFor(5);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, SalesHistory.class).getSalesHistoryButton());
            sleepFor(3);
            WebElement sale1 = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//table[@id='SalesTable']//tbody//tr[1]//td[5]//a[text()]")));
            sale1.click();
            sleepFor(1);
            centerlizePO.clickOnButton(getCreateDraftPOButton());
            sleepFor(2);
            WebElement drpdwn = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//h5[text()='Add backorder items to an existing PO']//parent::div//a")));
            drpdwn.click();
            sleepFor(1);
            WebElement drpdwnvaalue = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//h5[text()='Add backorder items to an existing PO']//parent::div//ul//ul//li//div[contains(@class,'label')]")));
            drpdwnvaalue.click();
            sleepFor(2);
            centerlizePO.clickOnButton(getAddToExstingPO());
            sleepFor(4);
            WebElement reference1 = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//div[contains(@class,'slider-modal-body')]//table//a")));
            String referenceData1 = reference1.getText();
            int newCount =0;
            if (referenceData1.contains(referenceData)){
                reference1.click();
                sleepFor(5);
                List<WebElement> elementList = new WebDriverWait(driver,60).until
                        (ExpectedConditions.presenceOfAllElementsLocatedBy
                                (By.xpath("//span[text()='Order items']//parent::div//parent::div//parent::div//table//tbody//tr")));
                newCount = elementList.size();
                if (oldCount>newCount)
                    System.out.println("");
            }
            sleepFor(3);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Purchases.class).getReceiveButton());
            sleepFor(3);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Purchases.class).getReceiveAllButton());
            centerlizePO.clickOnButton(PageFactory.initElements(driver, GiftCards.class).getYesButton());
            sleepFor(3);
            sleepFor(5);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

}