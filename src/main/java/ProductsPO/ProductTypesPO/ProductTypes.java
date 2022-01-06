package ProductsPO.ProductTypesPO;

import CommonPO.BasePage;
import CommonPO.CenterlizePO;
import PointofSalePO.PointofSale;
import PointofSalePO.ProcessSalePO.ProcessSale;
import ProductsPO.Products;
import StoreSetupPO.GeneralPO.General;
import StoreSetupPO.StoreSetup;
import UsersPO.UserPO.Users;
import io.qameta.allure.Step;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
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
 * @date 25 February 2022
 */
public class ProductTypes extends BasePage {

    public WebDriver driver;
    public static String dataText = "";
    public static final Logger log4j = Logger.getLogger(ProductTypes.class);

    {
        BasicConfigurator.configure();
    }
    /**
     * @author Vidhi Chapanera
     * @discription this locator is for product types button
     * @date 25 February 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//span[contains(text(),'Products')]//parent::a[contains(@class,'auto')]//parent::li//descendant::ul//span[contains(text(),'Product types')]//parent::a"
    )
    WebElement btn_producttypes;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for add product types button
     * @date 13 December 2021
     */
    @FindBy(
            how = How.CSS,
            using = "button#btnAdd"
    )
    WebElement btn_addType;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for  types name text box
     * @date 13 December 2021
     */
    @FindBy(
            how = How.ID,
            using = "categoryname"
    )
    WebElement txt_typename;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Save Button
     * @date 13 December 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//button[@type='submit']"
    )
    WebElement btn_save;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Product type name
     * @date 13 December 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//label[@for='hideProductTypeIfNoProductInIt']"
    )
    WebElement chk_hideproductType;



    public ProductTypes(WebDriver driver) {
        this.driver = driver;
    }
    public WebElement getProductTypesButton() {
        return btn_producttypes;
    }
    public WebElement getAddProductTypeButton() {
        return btn_addType;
    }
    public WebElement getProductTypeName() {
        return txt_typename;
    }
    public WebElement getSaveButton() {
        return btn_save;
    }
    public WebElement getHideProductType() {
        return chk_hideproductType;
    }


    /**
     * @author Vidhi Chapanera
     * @date 20 January 2021
     * @return
     * @throws Exception
     * @discription this method is used to Linked type: brand: tags create new product and assign product type, tag and
     * brand. Now go to product type page and click on assigned product count number ,
     * it should be filter automatically with select product type associate product
     */
    @Step("Linked type: brand: tags create new product and assign product type, tag and\n" +
            "brand. Now go to product type page and click on assigned product count number ,\n" +
            "it should be filter automatically with select product type associate product")
    public boolean  filterProductType() {
        ProductsPO.ProductsPO.Products products1 = PageFactory.initElements(driver, ProductsPO.ProductsPO.Products.class);
        CenterlizePO centerlizePO = PageFactory.initElements(driver, CenterlizePO.class);
        Actions actions = new Actions(driver);
        String product = "vT-shirt";
        String productType = "";
        String count = "";
        try {
            sleepFor(7);
            PageFactory.initElements(driver, Products.class).clickOnProductsButtonn();
            centerlizePO.clickOnButton(getProductTypesButton());
            sleepFor(3);
            List<WebElement> pt = new WebDriverWait(driver, 90).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy
                            (By.xpath("//table[@id='CategoriesDataTable']//tr//td//a[not(@class)][text()]")));
            int n = 0;
            for (int i=0 ;i<pt.size();i++){
                productType = pt.get(i).getText();
                WebElement totalCount = new WebDriverWait(driver, 90).
                        until(ExpectedConditions.presenceOfElementLocated
                                (By.xpath("//table[@id='CategoriesDataTable']//tr//td//a[not(@class)][text()='" + productType + "']//parent::td//following-sibling::td//a")));
                count = totalCount.getText();
                n = Integer.parseInt(count+1);
                sleepFor(1);
                break;
            }
            sleepFor(3);
            //PageFactory.initElements(driver, Products.class).clickOnProductsButtonn();
            centerlizePO.clickOnButton(PageFactory.initElements(driver, ProductsPO.ProductsPO.Products.class).getProductButton());
            centerlizePO.clickOnButton(products1.getAddProductButton());
            sleepFor(2);
            centerlizePO.enterDataUsingSendkeys(products1.getProductName(), product);
            centerlizePO.clickOnButton(products1.getInventoryTrackingButton());
            /*List<WebElement> input = new WebDriverWait(driver,60).
                    until(ExpectedConditions.
                            presenceOfAllElementsLocatedBy(By.xpath
                                    ("//th[text()='On hand']//parent::tr//parent::thead//parent::table//tbody//input")));
            input.get(0).clear();
            input.get(0).sendKeys("100");
            List<WebElement> cost = new WebDriverWait(driver,60).
                    until(ExpectedConditions.
                            presenceOfAllElementsLocatedBy(By.xpath
                                    ("//th[text()='Cost price']//parent::tr//parent::thead//parent::table//tbody//input")));
            centerlizePO.enterDataUsingSendkeys(cost.get(0),Keys.CONTROL+"a");
            centerlizePO.enterDataUsingSendkeys(cost.get(0), String.valueOf(Keys.DELETE));
            centerlizePO.enterDataUsingSendkeys(cost.get(0), "150");*/
            centerlizePO.enterDataUsingSendkeys(products1.getProductType(),productType);
            actions.sendKeys(Keys.TAB).build().perform();
            centerlizePO.enterDataUsingSendkeys(products1.getSuppliers(),"Automation Suppliers");
            actions.sendKeys(Keys.TAB).build().perform();
            centerlizePO.enterDataUsingSendkeys(products1.getBrand(),"Automation Brand");
            actions.sendKeys(Keys.TAB).build().perform();
            centerlizePO.clickOnButton(products1.getProductSaveButton());
            sleepFor(5);
            PageFactory.initElements(driver, Products.class).clickOnProductsButtonn();
            centerlizePO.clickOnButton(getProductTypesButton());
            WebElement totalCount = new WebDriverWait(driver, 90).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//table[@id='CategoriesDataTable']//tr//td//a[not(@class)][text()='" + productType + "']//parent::td//following-sibling::td//a")));
            String count01 = totalCount.getText();
            int n1 = Integer.parseInt(count01);
            if (n1==n)
                System.out.println(" ");
            sleepFor(1);
            totalCount.click();
            sleepFor(2);
           /* WebElement pt01 = new WebDriverWait(driver, 90).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//a[@class='hike-group-dropdown-close']//following-sibling::span")));*/
            WebElement pt01 = new WebDriverWait(driver, 90).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//span[contains(@class,'tagging-group')]//span")));
            String s01 = pt01.getText();
            if(s01.contains(productType))
                System.out.println(" ");
            sleepFor(2);
            WebElement pagination = new WebDriverWait(driver, 90).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.name("RosterDataTable_length")));
            Select select = new Select(pagination);
            select.selectByValue("100");
            sleepFor(2);
            List<WebElement> product001 = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//table[@id='RosterDataTable']//tbody//tr//td[2]//span[text()]")));
            for (int i=0 ; i<product001.size();i++){
                if (product001.get(i).getText().contains(productType))
                    System.out.println(" ");
                break;
            }
            sleepFor(3);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }



    /**
     * @author Vidhi Chapanera
     * @date 20 January 2021
     * @return
     * @throws Exception
     * @discription this method is used to General - Hide product type (category) if it has no products
     */
    @Step("General - Hide product type (category) if it has no products")
    public boolean  hideProductType() {
        ProductsPO.ProductsPO.Products products1 = PageFactory.initElements(driver, ProductsPO.ProductsPO.Products.class);
        CenterlizePO centerlizePO = PageFactory.initElements(driver, CenterlizePO.class);
        Actions actions = new Actions(driver);
        String tesType = "v-Type";
        String counyt = "";
        try {
            sleepFor(7);
            centerlizePO.clickOnButton(getAddProductTypeButton());
            sleepFor(7);
            centerlizePO.enterDataUsingSendkeys(getProductTypeName(), tesType);
            centerlizePO.clickOnButton(products1.getSaveButton());
            sleepFor(7);
            WebElement ProductCount = new WebDriverWait(driver, 90).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//a[text()='"+tesType+"']//parent::td//following-sibling::td[last()-1]")));
            Assert.assertEquals(ProductCount.getText(),"0");
            PageFactory.initElements(driver, PointofSale.class).clickOnPointOfSaleButtonn();
            sleepFor(2);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, ProcessSale.class).getProcessSaleButton());
            sleepFor(15);
            WebElement notHide = new WebDriverWait(driver, 90).ignoring(StaleElementReferenceException.class).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//li[@heading='"+tesType+"']")));
            Assert.assertTrue(notHide.isDisplayed());
            sleepFor(5);
            PageFactory.initElements(driver, StoreSetup.class).clickOnStoreSetupButton();
            centerlizePO.clickOnButton(PageFactory.initElements(driver, General.class).getGeneralButton());
            sleepFor(5);
            centerlizePO.clickOnButton(getHideProductType());
            sleepFor(2);
            actions.moveToElement(PageFactory.initElements(driver, Users.class).getSaveButton()).build().perform();
            PageFactory.initElements(driver, Users.class).getSaveButton().click();
            sleepFor(13);
            PageFactory.initElements(driver, PointofSale.class).clickOnPointOfSaleButtonn();
            centerlizePO.clickOnButton(PageFactory.initElements(driver, ProcessSale.class).getProcessSaleButton());
            sleepFor(20);
            try {
                if (driver.findElement(By.xpath("//li[@heading='"+tesType+"']")).isDisplayed())
                {
                    System.out.println("Visible......................./");
                    return false;
                }
                return false;
            } catch (Exception ex) {
                System.out.println("InVisible................../");
                return true;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }


    /**
     * @author Vidhi Chapanera
     * @date 20 January 2021
     * @return
     * @throws Exception
     * @discription this method is used to Deactivate Product Type And Verify should not display in POS Screen
     */
    @Step("Deactivate Product Type And Verify should not display in POS Screen")
    public boolean  deactivateProuctType() {
        CenterlizePO centerlizePO = PageFactory.initElements(driver, CenterlizePO.class);
        Actions actions = new Actions(driver);
        String tesType = "";
        try {
            sleepFor(20);
            List<WebElement> pt01 = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//table[@id='CategoriesDataTable']//tr//td//a[not(@class)]")));
            tesType = pt01.get(0).getText();
            WebElement element = new WebDriverWait(driver,60).
                    until(ExpectedConditions.elementToBeClickable
                            (By.xpath("//table[@id='CategoriesDataTable']//tr//td//a[text()='"+tesType+"']//parent::td//following-sibling::td//span[contains(@class,'switch-label')]")));
            sleepFor(5);
            actions.moveToElement(element).click().build().perform();
            log4j.info(element);
            sleepFor(5);
            PageFactory.initElements(driver, PointofSale.class).clickOnPointOfSaleButtonn();
            sleepFor(2);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, ProcessSale.class).getProcessSaleButton());
            sleepFor(15);
            try {
                if (driver.findElement(By.xpath("//li[@heading='"+tesType+"']")).isDisplayed())
                {
                    System.out.println("Visible......................./");
                    return false;
                }
                return false;
            } catch (Exception ex) {
                System.out.println("InVisible................../");
                return true;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }finally{
            sleepFor(5);
            PageFactory.initElements(driver, Products.class).clickOnProductsButtonn();
            sleepFor(3);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, ProductTypes.class).getProductTypesButton());
            sleepFor(4);
            WebElement element = new WebDriverWait(driver,60).
                    until(ExpectedConditions.elementToBeClickable
                            (By.xpath("//table[@id='CategoriesDataTable']//tr//td//a[text()='"+tesType+"']//parent::td//following-sibling::td//span[contains(@class,'switch-label')]")));
            sleepFor(5);
            actions.moveToElement(element).click().build().perform();
            log4j.info(element);
        }
    }
}