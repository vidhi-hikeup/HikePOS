package UsersPO.UserPO;

import CommonPO.BasePage;
import CommonPO.CenterlizePO;
import CustomersPO.CustomersPO.Customers;
import PointofSalePO.CashRegisterPO.CashRegister;
import PointofSalePO.PointofSale;
import PointofSalePO.ProcessSalePO.ProcessSale;
import ProductsPO.Products;
import StoreSetupPO.OutletsAndRegistersPO.OutletsAndRegisters;
import StoreSetupPO.StoreSetup;
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
 * @date 12 August 2021
 */
public class UsersOutletVisibility extends BasePage {

    public WebDriver driver;

    public static String typeName = "";
    public static String getOutlet = "";
    public static String getInVisibleOutlet = "";
    String Product = "zT-shirt";

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Select outlets button
     * @date 12 August 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//button[text()='Select outlets']"
    )
    WebElement btn_selectOutlet;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for save button
     * @date 12 August 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//div[@class='slider-modal-actions']//span[text()='Save']//parent::button"
    )
    WebElement btn_save;

    public UsersOutletVisibility(WebDriver driver) {
        this.driver = driver;
    }
    public WebElement getSelectOutletButton() {
        return btn_selectOutlet;
    }
    public WebElement getSavetButton() {
        return btn_save;
    }

    /**
     * @return
     * @throws Exception
     * @author Vidhi Chapanera
     * @date 12 August 2021
     * @discription this method is use to add multiple outlet/Cash Register
     */
    @Step("add multiple outlet/Cash Register")
    public boolean addMultipleOutlet(){
        CenterlizePO centerlizePO = PageFactory.initElements(driver,CenterlizePO.class);
        try {
            sleepFor(5);
            PageFactory.initElements(driver, StoreSetup.class).clickOnStoreSetupButton();
            centerlizePO.clickOnButton(PageFactory.initElements(driver, OutletsAndRegisters.class).getOutletsAndRegisters());
            sleepFor(5);
            String[] strArray2 = new String[]{"Show Off Shop", "Charm Farm", "Serious Shoppers"};
            for (String outletName : strArray2) {
                centerlizePO.clickOnButton(PageFactory.initElements(driver, OutletsAndRegisters.class).getAddOutlet());
                sleepFor(1);
                centerlizePO.enterDataUsingSendkeys(PageFactory.initElements(driver, OutletsAndRegisters.class).getOutletName(),outletName);
                centerlizePO.enterDataUsingSendkeys(PageFactory.initElements(driver, OutletsAndRegisters.class).getEmail(),outletName.replaceAll("\\s","")+"@yopmail.com");
                sleepFor(1);
                PageFactory.initElements(driver, OutletsAndRegisters.class).getSaveButton().click();
                sleepFor(8);
                centerlizePO.clickOnButton(PageFactory.initElements(driver, OutletsAndRegisters.class).getLinkAllRadioButton());
                centerlizePO.clickOnButton(PageFactory.initElements(driver, OutletsAndRegisters.class).getContinueButton());
                sleepFor(5);
            }
            sleepFor(5);
            return true;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }


    /**
     * @return
     * @throws Exception
     * @author Vidhi Chapanera
     * @date 12 August 2021
     * @discription this method is use to create product for particular outlet
     */
    @Step("create product for particular outlet")
    public boolean createProduct(){
        CenterlizePO centerlizePO = PageFactory.initElements(driver,CenterlizePO.class);
        ProductsPO.ProductsPO.Products products1 = PageFactory.initElements(driver, ProductsPO.ProductsPO.Products.class);
        Actions actions = new Actions(driver);
        try {
            sleepFor(5);
            PageFactory.initElements(driver, Products.class).clickOnProductsButtonn();
            centerlizePO.clickOnButton(PageFactory.initElements(driver, ProductsPO.ProductsPO.Products.class).getProductButton());
            sleepFor(2);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, ProductsPO.ProductsPO.Products.class).getAddProductButton());
            sleepFor(3);
            centerlizePO.enterDataUsingSendkeys(products1.getProductName(), Product);
            sleepFor(2);
            actions.moveToElement(products1.getProductType()).click().build().perform();
            actions.sendKeys(Keys.TAB).build().perform();
            sleepFor(2);
            WebElement productType = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//label[contains(text(),'Product type')]//parent::div//category-combo//li//span[text()]")));
            typeName = productType.getText();
            centerlizePO.clickOnButton(products1.getInventoryTrackingButton());
            List<WebElement> onhand = new WebDriverWait(driver,60).
                    until(ExpectedConditions.
                            presenceOfAllElementsLocatedBy(By.xpath
                                    ("//th[text()='On hand']//parent::tr//parent::thead//parent::table//tbody//tr//td[2]//input")));
            for (int i =0; i<onhand.size();i++){
                sleepFor(1);
                centerlizePO.enterDataUsingSendkeys(onhand.get(i),Keys.CONTROL+"a");
                centerlizePO.enterDataUsingSendkeys(onhand.get(i), String.valueOf(Keys.DELETE));
                centerlizePO.enterDataUsingSendkeys(onhand.get(i), "100");
            }
            List<WebElement> cost = new WebDriverWait(driver,60).
                    until(ExpectedConditions.
                            presenceOfAllElementsLocatedBy(By.xpath
                                    ("//th[text()='Cost price']//parent::tr//parent::thead//parent::table//tbody//input")));
            centerlizePO.enterDataUsingSendkeys(cost.get(0),Keys.CONTROL+ "a");
            centerlizePO.enterDataUsingSendkeys(cost.get(0), String.valueOf(Keys.DELETE));
            centerlizePO.enterDataUsingSendkeys(cost.get(0),"150");
            actions.moveToElement(getSelectOutletButton()).click().build().perform();
            sleepFor(7);
            List<WebElement> outletchk = new WebDriverWait(driver,60).
                    until(ExpectedConditions.
                            presenceOfAllElementsLocatedBy(By.xpath
                                    ("//input[@name='productoutletVisible']//following-sibling::label")));
            for (int j =0; j<outletchk.size();j++){
                sleepFor(1);
                actions.moveToElement(outletchk.get(j)).click().build().perform();
            }
            getOutlet += outletchk.get(outletchk.size()-1).getText();
            System.out.println("{"+getOutlet+"}");
            actions.moveToElement(outletchk.get(outletchk.size()-1)).click().build().perform();
            centerlizePO.clickOnButton(getSavetButton());
            sleepFor(5);
            centerlizePO.clickOnButton(products1.getProductSaveButton());
            sleepFor(5);
            return true;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }


    /**
     * @return
     * @throws Exception
     * @author Vidhi Chapanera
     * @date 12 August 2021
     * @discription this method is use to close the cash register and open new register
     */
    @Step("close the cash register and open new register")
    public boolean closeOldOneAndOpenNew(){
        CenterlizePO centerlizePO = PageFactory.initElements(driver,CenterlizePO.class);
        try {
            sleepFor(5);
            PageFactory.initElements(driver,PointofSale.class).clickOnPointOfSaleButtonn();
            centerlizePO.clickOnButton(PageFactory.initElements(driver,CashRegister.class).getCashRegisterButton());
            sleepFor(7);
            try{
                if(driver.findElement(By.xpath("//span[text()='Select your cash register']")).isDisplayed()){
                    WebElement outlet = new WebDriverWait(driver,50)
                            .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul[contains(@class,'tabs')]//li//a[text()='"+getOutlet+"']")));
                    outlet.click();
                    WebElement register = new WebDriverWait(driver,50)
                            .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'active')]//div[@class='select-reg-btn']")));
                    register.click();
                    sleepFor(3);
                    centerlizePO.clickOnButton(PageFactory.initElements(driver, CashRegister.class).getOpenRegisterButton());
                    centerlizePO.clickOnButton(PageFactory.initElements(driver, CashRegister.class).getOpenButton());
                    centerlizePO.clickOnButton(PageFactory.initElements(driver, ProcessSale.class).getProcessSaleButton());
                }
            }catch (Exception c){
                centerlizePO.clickOnButton(PageFactory.initElements(driver,CashRegister.class).getCloseRegister());
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
                centerlizePO.clickOnButton(PageFactory.initElements(driver,CashRegister.class).getRefreshDataButton());
                centerlizePO.clickOnButton(PageFactory.initElements(driver,CashRegister.class).getContinueButton());
                sleepFor(20);
                WebElement outlet = new WebDriverWait(driver,50)
                        .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul[contains(@class,'tabs')]//li//a[text()='"+getOutlet+"']")));
                outlet.click();
                WebElement register = new WebDriverWait(driver,50)
                        .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'active')]//div[@class='select-reg-btn']")));
                register.click();

                sleepFor(5);
            }
            sleepFor(5);
            return true;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }


    /**
     * @return
     * @throws Exception
     * @author Vidhi Chapanera
     * @date 12 August 2021
     * @discription this method is use to verify Product visibility
     */
    @Step("verify Product visibility")
    public boolean verifyProductVisibility(){
        try {
            sleepFor(5);
            WebElement type = new WebDriverWait(driver,50)
                    .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[normalize-space(.)='"+typeName+"']")));
            type.click();
            sleepFor(3);
            sleepFor(5);
            WebElement productD = new WebDriverWait(driver,50)
                    .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'"+Product+"')]")));
            if (productD.isDisplayed()){
                System.out.println("Displayed......................./");
            }
            return true;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }


    /**
     * @return
     * @throws Exception
     * @author Vidhi Chapanera
     * @date 12 August 2021
     * @discription this method is use to verify Product Invisibility
     */
    @Step("verify Product invisibility")
    public boolean verifyProductInVisibility(){
        CenterlizePO centerlizePO = PageFactory.initElements(driver,CenterlizePO.class);
        ProductsPO.ProductsPO.Products products1 = PageFactory.initElements(driver, ProductsPO.ProductsPO.Products.class);
        Actions actions = new Actions(driver);
        try {
            sleepFor(5);
            PageFactory.initElements(driver, Products.class).clickOnProductsButtonn();
            centerlizePO.clickOnButton(PageFactory.initElements(driver, ProductsPO.ProductsPO.Products.class).getProductButton());
            sleepFor(5);
            centerlizePO.enterDataUsingSendkeys(products1.getSearchBox(),Product);
            sleepFor(5);
            List<WebElement> list1 = new WebDriverWait(driver,120).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy
                            (By.xpath("//ul[contains(@class,'hike-width-block')]//b[text()='Product']//parent::ul//li//a")));
            actions.moveToElement(list1.get(0)).click().build().perform();
            sleepFor(5);
            WebElement name = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//table[@id='RosterDataTable']//tbody//tr//td[2]//span[text()='" + Product + "']")));
            actions.moveToElement(name).click().build().perform();
            sleepFor(5);
            actions.moveToElement(getSelectOutletButton()).click().build().perform();
            sleepFor(7);
            List<WebElement> outletchk = new WebDriverWait(driver,60).
                    until(ExpectedConditions.
                            presenceOfAllElementsLocatedBy(By.xpath
                                    ("//input[not(contains(@class,'not-empty')) and @name='productoutletVisible']//following-sibling::label")));
            getInVisibleOutlet += outletchk.get(outletchk.size()-1).getText();
            System.out.println("{"+getInVisibleOutlet+"}");
            actions.sendKeys(Keys.ESCAPE).build().perform();

            //@tag Cash-registers
            sleepFor(5);
            PageFactory.initElements(driver,PointofSale.class).clickOnPointOfSaleButtonn();
            centerlizePO.clickOnButton(PageFactory.initElements(driver,CashRegister.class).getCashRegisterButton());
            sleepFor(7);
            try{
                if(driver.findElement(By.xpath("//span[text()='Select your cash register']")).isDisplayed()){
                    WebElement outlet = new WebDriverWait(driver,50)
                            .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul[contains(@class,'tabs')]//li//a[text()='"+getInVisibleOutlet+"']")));
                    outlet.click();
                    WebElement register = new WebDriverWait(driver,50)
                            .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'active')]//div[@class='select-reg-btn']")));
                    register.click();
                    sleepFor(3);
                    sleepFor(15);
                    centerlizePO.clickOnButton(PageFactory.initElements(driver, ProcessSale.class).getProcessSaleButton());
                }
            }catch (Exception c) {
                centerlizePO.clickOnButton(PageFactory.initElements(driver, CashRegister.class).getCloseRegister());
                centerlizePO.clickOnButton(PageFactory.initElements(driver, Customers.class).getContinueButton());
                sleepFor(8);
                String mainWindowHandle = driver.getWindowHandle();
                Set<String> allWindowHandles = driver.getWindowHandles();
                Iterator<String> iterator = allWindowHandles.iterator();
                while (iterator.hasNext()) {
                    String ChildWindow = iterator.next();
                    if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
                        driver.switchTo().window(ChildWindow);
                        WebElement text = new WebDriverWait(driver, 60).until(ExpectedConditions.presenceOfElementLocated(By.tagName("print-preview-app")));
                        System.out.println("Heading of child window is " + text.getText());
                        Actions actions1 = new Actions(driver);
                        actions1.sendKeys(Keys.TAB).build().perform();
                        actions1.sendKeys(Keys.ENTER).build().perform();
                    }
                }
                sleepFor(3);
                driver.switchTo().window(mainWindowHandle);
                sleepFor(3);
                centerlizePO.clickOnButton(PageFactory.initElements(driver, CashRegister.class).getRefreshDataButton());
                centerlizePO.clickOnButton(PageFactory.initElements(driver, CashRegister.class).getContinueButton());
                sleepFor(20);
                WebElement outlet = new WebDriverWait(driver, 50)
                        .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul[contains(@class,'tabs')]//li//a[text()='" + getInVisibleOutlet + "']")));
                outlet.click();
                WebElement register = new WebDriverWait(driver, 50)
                        .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'active')]//div[@class='select-reg-btn']")));
                register.click();
            }
            sleepFor(20);
            WebElement type = new WebDriverWait(driver,50)
                    .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[normalize-space(.)='"+typeName+"']")));
            type.click();
            sleepFor(5);
            return true;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }


    /**
     * @return
     * @throws Exception
     * @author Vidhi Chapanera
     * @date 12 August 2021
     * @discription this method is use to verify Product Invisibility
     */
    @Step("verify Product invisibility")
    public boolean verifyProductIsDisplay(){
        try {
            sleepFor(20);
            if (driver.findElement(By.xpath("//div[contains(text(),'"+Product+"')]")).isDisplayed())
            {
                System.out.println("Visible......................./");
                return false;
            }
            return false;
        } catch (Exception ex) {
            System.out.println("InVisible................../");
            return true;
        }
    }
}
