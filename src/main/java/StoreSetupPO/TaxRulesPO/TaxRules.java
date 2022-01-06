package StoreSetupPO.TaxRulesPO;

import CommonPO.BasePage;
import CommonPO.CenterlizePO;
import PointofSalePO.PointofSale;
import PointofSalePO.ProcessSalePO.ProcessSale;
import StoreSetupPO.GeneralPO.General;
import StoreSetupPO.LoyaltyPointsPO.LoyaltyPoints;
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
 * @date 17 March 2021
 */
public class TaxRules extends BasePage {

    public WebDriver driver;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Tax rules button
     * @date 17 March 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//span[contains(text(),'Tax rules')]//parent::a"
    )
    WebElement btn_taxrules;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for add Tax rules button
     * @date 17 March 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//span[contains(text(),'Tax rate')]//parent::div//parent::div//a"
    )
    WebElement btn_addtaxrules;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for tax name input box
     * @date 17 March 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//label[contains(text(),'Tax name')]//parent::div//input"
    )
    //@FindBy(
            // how = How.XPATH,
            // using = "//label[text()='Tax name']//parent::div//input"
            // )
    WebElement txt_taxName;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for rate input box
     * @date 17 March 2021
     */
    //@FindBy(
    // how = How.XPATH,
    // using = "//label[text()='Rate %']//parent::div//input"
    // )
    @FindBy(
            how = How.XPATH,
            using = "//label[contains(text(),'Rate %')]//parent::div//input"
    )
    WebElement txt_rate;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for zoom out
     * @date 17 March 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//i[@class='fa fa-search-minus']//parent::button"
    )
    WebElement zoomout;

    public TaxRules(WebDriver driver) {
        this.driver = driver;
    }
    public WebElement getTaxRules() {
        return btn_taxrules;
    }
    public WebElement getAddTaxRules() {
        return btn_addtaxrules;
    }
    public WebElement getTaxName() {
        return txt_taxName;
    }
    public WebElement getRate() {
        return txt_rate;
    }
    public WebElement getZoomOut() {
        return zoomout;
    }


    /**
     * @author Vidhi Chapanera
     * @date 17 March 2021
     * @return
     * @throws Exception
     * @discription this method is used to add new tax rule
     * @return
     */
    public boolean createTax(){
        CenterlizePO centerlizePO = PageFactory.initElements(driver, CenterlizePO.class);
        ProductsPO.ProductsPO.Products products1 = PageFactory.initElements(driver, ProductsPO.ProductsPO.Products.class);
        Actions actions = new Actions(driver);
        String taxName = "Automation Tax";
        String rate = "20";
        try{
            sleepFor(5);
            centerlizePO.clickOnButton(getAddTaxRules());
            sleepFor(3);
            centerlizePO.enterDataUsingSendkeys(getTaxName(),taxName);
            centerlizePO.enterDataUsingSendkeys(getRate(),rate);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, LoyaltyPoints.class).getSaveButton());
            sleepFor(5);
            PageFactory.initElements(driver, ProductsPO.Products.class).clickOnProductsButtonn();
            centerlizePO.clickOnButton(products1.getProductButton());
            sleepFor(2);
            centerlizePO.clickOnButton(products1.getAddProductButton());
            sleepFor(2);
            centerlizePO.enterDataUsingSendkeys(products1.getProductName(), "Table Lamp");
            centerlizePO.clickOnButton(products1.getInventoryTrackingButton());
            List<WebElement> input = new WebDriverWait(driver,60).
                    until(ExpectedConditions.
                            presenceOfAllElementsLocatedBy(By.xpath
                                    ("//th[text()='On hand']//parent::tr//parent::thead//parent::table//tbody//input")));
            input.get(0).clear();
            input.get(0).sendKeys("100");
            List<WebElement> cost = new WebDriverWait(driver,60).
                    until(ExpectedConditions.
                            presenceOfAllElementsLocatedBy(By.xpath
                                    ("//th[text()='Cost price']//parent::tr//parent::thead//parent::table//tbody//input")));
            centerlizePO.enterDataUsingSendkeys(cost.get(5),Keys.CONTROL+ "a");
            centerlizePO.enterDataUsingSendkeys(cost.get(5), String.valueOf(Keys.DELETE));
            centerlizePO.enterDataUsingSendkeys(cost.get(5),"150");
            centerlizePO.enterDataUsingSendkeys(products1.getProductType(),"Lamp");
            actions.sendKeys(Keys.TAB).build().perform();
            centerlizePO.enterDataUsingSendkeys(products1.getSuppliers(),"Lamp01");
            actions.sendKeys(Keys.TAB).build().perform();
            centerlizePO.enterDataUsingSendkeys(products1.getBrand(),"AT001B");
            actions.sendKeys(Keys.TAB).build().perform();
            WebElement webElement = new WebDriverWait(driver,60)
                    .until(ExpectedConditions.elementToBeClickable
                            (By.xpath("//div[contains(@class,'fileinput')]//img")));
            actions.moveToElement(webElement).build().perform();
            JavascriptExecutor executor = (JavascriptExecutor)driver;
            executor.executeScript("arguments[0].click();", webElement);
            sleepFor(3);
            if (driver.findElement(By.name("uploadImageform")).isDisplayed())
                System.out.println(true);
            PageFactory.initElements(driver, General.class).getSelectFile().sendKeys(System.getProperty("user.dir")+"\\src\\main\\java\\StoreSetupPO\\TaxRulesPO\\lamp.jpg");
            sleepFor(5);
            centerlizePO.clickOnButton(getZoomOut());
            sleepFor(2);
            centerlizePO.clickOnButton(getZoomOut());
            sleepFor(2);
            PageFactory.initElements(driver, LoyaltyPoints.class).getSaveButton().click();
            sleepFor(5);
            List<WebElement> e = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                            By.xpath("//span[contains(text(),'Start typing tax...')]//parent::a")));
            e.get(0).click();
            List<WebElement> e1 = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                            By.xpath("//span[contains(text(),'Start typing tax...')]//parent::a//following-sibling::div//li//ul//li//div//div")));
            for(int i=0;i<e1.size();i++){
                if (e1.get(i).getText().contains(taxName))
                    System.out.println(" ");
                WebElement tx  = new WebDriverWait(driver,60).
                        until(ExpectedConditions.presenceOfElementLocated
                                (By.xpath("//span[contains(text(),'Start typing tax...')]//parent::a//following-sibling::div//li//ul//li//div//div[text()='"+taxName+"']")));
                tx.click();
                break;
            }
            centerlizePO.clickOnButton(products1.getProductSaveButton());
            sleepFor(10);
            PageFactory.initElements(driver, PointofSale.class).clickOnPointOfSaleButtonn();
            sleepFor(3);
            centerlizePO.clickOnButton(PageFactory.initElements(driver,ProcessSale.class).getProcessSaleButton());
            sleepFor(20);
            WebElement e2 = new WebDriverWait(driver,120).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//div[@id='mydiv']//ul//li//a[text()='Lamp']")));
            e2.click();
            List<WebElement> list = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                            By.xpath("//div[@class='flex-wrap-tab']//img//parent::div//parent::div//parent::figure//parent::div/div[@class='figure-footer']//div[contains(@class,'figure-footer-text')]")));
            for(int i=0;i<list.size();i++){
                if (list.get(i).getText().contains("Table Lamp"))
                    list.get(i).click();
            }
            WebElement subtotal  = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//div[@class='detail-section']//table//tbody//tr//td[text()='Subtotal']//following-sibling::td")));
            String costp = subtotal.getText();
            float costPrice = Float.parseFloat(costp.substring(1));
            float tax = costPrice*Float.parseFloat(rate)/100;
            WebElement taxElement  = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//div[@class='detail-section']//table//tbody//tr//td[text()='Tax']//following-sibling::td")));
            String taxPrice = taxElement.getText();
            float taxPriceF = Float.parseFloat(taxPrice.substring(1));
            if (taxPriceF==tax){
                System.out.println(" ");
            }

            sleepFor(2);
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
}