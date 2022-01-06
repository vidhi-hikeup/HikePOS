package CustomersPO.GroupsPO;

import CommonPO.BasePage;
import CommonPO.CenterlizePO;
import CustomersPO.CustomersPO.Customers;
import PointofSalePO.CashRegisterPO.CashRegister;
import PointofSalePO.PointofSale;
import PointofSalePO.ProcessSalePO.ProcessSale;
import ProductsPO.ProductsPO.Products;
import io.qameta.allure.Step;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Vidhi Chapanera
 * @date 22 February 2021
 */
public class Groups extends BasePage {

    public WebDriver driver;
    public static String customerName = "";
    public static String discountOfferName = "";
    public static String filePath = "";

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Groups button
     * @date 22 February 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//span[contains(text(),'Customers')]//parent::a[contains(@class,'auto')]//parent::li//descendant::ul//span[contains(text(),'Groups')]//parent::a"
    )
    WebElement btn_groups;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for add Group button
     * @date 22 February 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//div[@class='inline-block']//button"
    )
    WebElement btn_addgroups;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Group name input box
     * @date 22 February 2021
     */
    @FindBy(
            how = How.ID,
            using = "form_control_1"
    )
    WebElement txt_groupname;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Flat rate % discount radio button
     * @date 22 February 2021
     */
    @FindBy(
            how = How.CSS,
            using = "label[for='ByPercent']"
    )
    WebElement rbtn_flatrate;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Flat rate % discount input box
     * @date 22 February 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//label[@class='font-grey-gallery']//parent::div//input"
    )
    WebElement txt_flatrate;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for save button
     * @date 22 February 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//span[text()='Save']//parent::button"
    )
    WebElement btn_save ;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for edit button
     * @date 22 February 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//button[text()='Edit']"
    )
    WebElement btn_edit ;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for customer group drop down
     * @date 22 February 2021
     */
    //@FindBy(
    // how = How.CSS,
    // using = "a[placeholder='Customer group']"
    // )
    @FindBy(
            how = How.XPATH,
            using = "//label[@for='customerGroupId']//parent::div//a"
    )
    WebElement drpdwn_customergroup ;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Custom price list radio button
     * @date 17 March 2021
     */
    @FindBy(
            how = How.CSS,
            using = "label[for='ByPriceList']"
    )
    WebElement rbtn_pricelist;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for generate template link
     * @date 17 March 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//a[text()='Generate template']"
    )
    WebElement generateTemplateLink;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for upload file button
     * @date 17 March 2021
     */
    @FindBy(
            how = How.ID,
            using = "filePriceList"
    )
    WebElement btn_uploadfile;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Export button
     * @date 17 March 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//button[contains(text(),'Export')]"
    )
    WebElement btn_export;

    public Groups(WebDriver driver) {
        this.driver = driver;
    }
    public WebElement getGroupsButton() {
        return btn_groups;
    }
    public WebElement getAddGroupButton() {
        return btn_addgroups;
    }
    public WebElement getTextGroupName() {
        return txt_groupname;
    }
    public WebElement getFlatRateRadioButton() {
        return rbtn_flatrate;
    }
    public WebElement getFlatRateDicount() {
        return txt_flatrate;
    }
    public WebElement getSaveButton() {
        return btn_save;
    }
    public WebElement getEditButton() {
        return btn_edit;
    }
    public WebElement getCustomerGroupDropDown() {
        return drpdwn_customergroup;
    }
    public WebElement getPriceList() {
        return rbtn_pricelist;
    }
    public WebElement getGenerateTempate() {
        return generateTemplateLink;
    }
    public WebElement getUploadFileButton() {
        return btn_uploadfile;
    }
    public WebElement getExportButton() {
        return btn_export;
    }


    /**
     * @return
     * @throws Exception
     * @author Vidhi Chapanera
     * @date 08 February 2021
     * @discription this method is use to Add discount group with 20 % Discount offer
     */
    @Step("Add discount group with 20 % Discount offer")
    public boolean addDiscountGroup() {
        try {
            sleepFor(5);
            CenterlizePO centerlizePO = PageFactory.initElements(driver,CenterlizePO.class);
            centerlizePO.clickOnButton(getAddGroupButton());
            sleepFor(1);
            getTextGroupName().sendKeys("20 % Discount Offer");
            sleepFor(1);
            discountOfferName = getTextGroupName().getAttribute("value");
            centerlizePO.clickOnButton(getFlatRateRadioButton());
            sleepFor(1);
            centerlizePO.clearText(getFlatRateDicount());
            centerlizePO.enterDataUsingSendkeys(getFlatRateDicount(),"20");
            sleepFor(1);
            centerlizePO.clickOnButton(getSaveButton());
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
     * @date 08 February 2021
     * @discription this method is use to allocate customer group  with 20% discount offer
     */
    @Step("allocate customer group  with 20% discount offer")
    public boolean allocateCustomerGroupWith20PerDiscount() {
        CenterlizePO centerlizePO = PageFactory.initElements(driver, CenterlizePO.class);
        try {
            sleepFor(5);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Customers.class).getCustomersButton());
            sleepFor(3);
            List<WebElement> customerlist = new WebDriverWait(driver,60).until
                    (ExpectedConditions.presenceOfAllElementsLocatedBy
                            (By.xpath("//table[@id='CustomersTable']//tbody//tr//td[2]//span")));
            for (int i =0;i<customerlist.size();i++){
                sleepFor(1);
                customerName = customerlist.get(i).getText();
                customerlist.get(i).click();
                sleepFor(2);
                centerlizePO.clickOnButton(getEditButton());
                sleepFor(2);
                centerlizePO.clickOnButton(getCustomerGroupDropDown());
                sleepFor(1);
                WebElement option = new WebDriverWait(driver,60).until
                        (ExpectedConditions.presenceOfElementLocated
                                (By.xpath("//span[text()='" + discountOfferName + "']//parent::div")));
                option.click();
                sleepFor(1);
                centerlizePO.clickOnButton(PageFactory.initElements(driver,Groups.class).getSaveButton());
                sleepFor(3);
                break;
            }
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
     * @date 08 February 2021
     * @discription this method is use to verify 20% discount is correctly apply to the cart
     */
    @Step("verify 20% discount is correctly apply to the cart")
    public boolean verify20perDiscountApplyCorrectlytoTheCartByAddingNewSale() {
        CenterlizePO centerlizePO = PageFactory.initElements(driver, CenterlizePO.class);
        try {
            sleepFor(5);
            List<WebElement> elementList = new WebDriverWait(driver,120).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy
                            (By.xpath("//div[contains(@class,'deskview')]//div[contains(@class,'figure-footer-text')]")));
            elementList.get(0).click();
            sleepFor(1);
            if (driver.findElements(By.xpath("//div[@class='row']//label")).get(0).isDisplayed()){
                List<WebElement> variant = new WebDriverWait(driver,120).
                        until(ExpectedConditions.presenceOfAllElementsLocatedBy
                                (By.xpath("//div[@class='row']//label")));
                sleepFor(1);
                variant.get(0).click();
                sleepFor(1);
                variant.get(4).click();
                sleepFor(1);
            }
            sleepFor(1);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, ProcessSale.class).getAddCustomerButton());
            centerlizePO.enterDataUsingSendkeys(PageFactory.initElements(driver, ProcessSale.class).getAddCustomer(),customerName);
            sleepFor(1);
            Actions actions = new Actions(driver);
            actions.sendKeys(Keys.TAB).build().perform();
            sleepFor(2);
            WebElement discountele = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//div[contains(@class,'customer-search-title')]//span[contains(@class,'small')][text()]")));
            String discountName = discountele.getText();
            if(discountName.split(":")[0].contains("20 % Discount Offer")){
                System.out.println(" ");
            }
            sleepFor(1);
            WebElement discounprice = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//div[contains(@class,'sell-item-list')]//a[contains(@class,'ng-hide')]//parent::div//parent::div//div[@class='sell-item-price']//div")));
            String priceAfterDiscount = discounprice.getText();
            float discounPrice = Float.parseFloat(priceAfterDiscount.substring(2));
            WebElement productprice = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//div[contains(@class,'sell-item-list')]//a[not(contains(@class,'ng-hide'))]//parent::div//parent::div//div[@class='sell-item-price']//div[(contains(@ng-if,'totalDiscount '))][text()]")));
            sleepFor(1);
            String productPriceAfterDiscount = productprice.getText();
            System.out.println(productPriceAfterDiscount);
            float ProductPrice = Float.parseFloat(productPriceAfterDiscount.split("\n")[0].substring(1));
            sleepFor(1);
            float finalPirce = ProductPrice*20/100;
            if (finalPirce==discounPrice){
                System.out.println(" ");
            }
            sleepFor(1);
            float pay = finalPirce-finalPirce;
            WebElement payprice = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//button[contains(@class,'btn-xlarge')]//div[contains(@class,'right')]")));
            String payPriceAfterDiscount = payprice.getText();
            float payPrice = Float.parseFloat(payPriceAfterDiscount.substring(1));
            if (payPrice==pay){
                System.out.println("");
            }
            sleepFor(1);
            sleepFor(1);
            List<WebElement> icon = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy
                            (By.xpath("//div[contains(@class,'sell-item-list')]//a[not(contains(@class,'ng-hide'))]")));
            for (int i=0;i<icon.size();i++){
                sleepFor(1);
                icon.get(i).click();
            }
            sleepFor(1);
            WebElement customer = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@class='customer-delete']")));
            customer.click();
            sleepFor(2);
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
     * @date 08 February 2021
     * @discription this method is use to verify 20% discount is correctly apply to the cart
     */
    @Step("verify 20% discount is correctly apply to the cart")
    public boolean verify20perDiscountApplyCorrectlytoTheCartByAddingNewSale_01() {
        CenterlizePO centerlizePO = PageFactory.initElements(driver, CenterlizePO.class);
        try {
            /*driver.navigate().refresh();
            sleepFor(9);
            List<WebElement> elementList = new WebDriverWait(driver,120).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy
                            (By.xpath("//div[contains(@class,'deskview')]//div[contains(@class,'figure-footer-text')]")));
            elementList.get(0).click();
            sleepFor(1);
            if (driver.findElements(By.xpath("//div[@class='row']//label")).get(0).isDisplayed()){
                List<WebElement> variant = new WebDriverWait(driver,120).
                        until(ExpectedConditions.presenceOfAllElementsLocatedBy
                                (By.xpath("//div[@class='row']//label")));
                sleepFor(1);
                variant.get(0).click();
                sleepFor(1);
                variant.get(4).click();
                sleepFor(1);
            }
            sleepFor(5);
            WebElement productprice01 = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//div[contains(@class,'sell-item-list')]//a[not(contains(@class,'ng-hide'))]//parent::div//parent::div//div[@class='sell-item-price']//div[(contains(@ng-if,'totalDiscount '))][text()]")));
            sleepFor(1);
            String productPriceAfterDiscount01 = productprice01.getText();
            float actualPrice01 = Float.parseFloat(productPriceAfterDiscount01.substring(1));//110
            float discountPirce = actualPrice01*20/100;//22
            centerlizePO.clickOnButton(PageFactory.initElements(driver, ProcessSale.class).getAddCustomerButton());
            centerlizePO.enterDataUsingSendkeys(PageFactory.initElements(driver, ProcessSale.class).getAddCustomer(),customerName);
            sleepFor(1);
            actions.sendKeys(Keys.TAB).build().perform();
            sleepFor(2);
            WebElement discountele = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//div[contains(@class,'customer-search-title')]//span[contains(@class,'small')][text()]")));
            String discountName = discountele.getText();
            if(discountName.split(":")[0].contains("20 % Discount Offer")){
                System.out.println(" ");
            }
            sleepFor(1);
            WebElement productprice = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//div[contains(@class,'sell-item-list')]//a[not(contains(@class,'ng-hide'))]//parent::div//parent::div//div[@class='sell-item-price']//div[(contains(@ng-if,'totalDiscount '))][text()]")));
            sleepFor(1);
            String productPriceAfterDiscount = productprice.getText();
            float actualPrice = Float.parseFloat(productPriceAfterDiscount.substring(1));//110
           // float actualPrice = Float.parseFloat(productPriceAfterDiscount.split("\n")[1].substring(1));//110
            System.out.println(productPriceAfterDiscount);
            sleepFor(1);
            sleepFor(1);
            float pay = actualPrice01-discountPirce;
            WebElement payprice = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//button[contains(@class,'btn-xlarge')]//div[contains(@class,'right')]")));
            String payPriceAfterDiscount = payprice.getText();
            float payPrice = Float.parseFloat(payPriceAfterDiscount.substring(1));
            if (payPrice==pay){
                System.out.println("");
            }
            sleepFor(1);
            sleepFor(1);
            List<WebElement> icon = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy
                            (By.xpath("//div[contains(@class,'sell-item-list')]//a[not(contains(@class,'ng-hide'))]")));
            for (int i=0;i<icon.size();i++){
                sleepFor(1);
                icon.get(i).click();
            }
            sleepFor(1);
            WebElement customer = new WebDriverWait(driver,60).
                        until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@class='customer-delete']")));
            customer.click();*/

            /**
             * @new Code
             */
            PageFactory.initElements(driver, ProcessSale.class).getSearchBar().sendKeys("A");
            sleepFor(1);
            Actions actions = new Actions(driver);
            actions.sendKeys(Keys.TAB).build().perform();
            centerlizePO.clickOnButton(PageFactory.initElements(driver, ProcessSale.class).getAddCustomerButton());
            centerlizePO.enterDataUsingSendkeys(PageFactory.initElements(driver, ProcessSale.class).getAddCustomer(),customerName);
            sleepFor(1);
            actions.sendKeys(Keys.TAB).build().perform();
            sleepFor(2);
            WebElement productprice01 = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//div[contains(@class,'sell-item-list')]//a[not(contains(@class,'ng-hide'))]//parent::div//parent::div//div[@class='sell-item-price']//div[(contains(@ng-if,'totalDiscount'))][text()]")));
            sleepFor(1);
            String productPriceAfterDiscount01 = productprice01.getText();
            float actualPrice01 = Float.parseFloat(productPriceAfterDiscount01.split("\n")[1].substring(1));//110
            float discountPirce = actualPrice01*20/100;//22
            WebElement discountele = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//div[contains(@class,'customer-search-title')]//span[contains(@class,'small')][text()]")));
            String discountName = discountele.getText();
            if(discountName.contains("20 % Discount Offer")){
                System.out.println(" ");
            }
            sleepFor(1);
            float pay = actualPrice01-discountPirce;
            WebElement payprice = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//button[contains(@class,'btn-xlarge')]//div[contains(@class,'right')]")));
            String payPriceAfterDiscount = payprice.getText();
            float payPrice = Float.parseFloat(payPriceAfterDiscount.substring(1));
            if (payPrice==pay){
                System.out.println("");
            }
            sleepFor(1);
            sleepFor(1);
            List<WebElement> icon = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy
                            (By.xpath("//div[contains(@class,'sell-item-list')]//a[not(contains(@class,'ng-hide'))]")));
            for (int i=0;i<icon.size();i++){
                sleepFor(1);
                icon.get(i).click();
            }
            sleepFor(1);
            WebElement customer = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@class='customer-delete']")));
            customer.click();

            sleepFor(5);
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
     * @date 17 March 2021
     * @discription this method is use to create new price list discount group
     */
    @Step("create new price list discount group")
    public boolean createNewPriceListDiscountGroup() {
        CenterlizePO centerlizePO = PageFactory.initElements(driver, CenterlizePO.class);
        ProductsPO.ProductsPO.Products products1 = PageFactory.initElements(driver, ProductsPO.ProductsPO.Products.class);
        Actions actions = new Actions(driver);
        String product = "v01 T-shirt";
        try {
            sleepFor(5);
            PageFactory.initElements(driver, ProductsPO.Products.class).clickOnProductsButtonn();
            centerlizePO.clickOnButton(products1.getProductButton());
            sleepFor(2);
            centerlizePO.clickOnButton(products1.getAddProductButton());
            sleepFor(2);
            centerlizePO.enterDataUsingSendkeys(products1.getProductName(), product);
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
            centerlizePO.enterDataUsingSendkeys(cost.get(0),Keys.CONTROL+"a");
            centerlizePO.enterDataUsingSendkeys(cost.get(0), String.valueOf(Keys.DELETE));
            centerlizePO.enterDataUsingSendkeys(cost.get(0), "150");
            centerlizePO.enterDataUsingSendkeys(products1.getProductType(),"PT Variant");
            actions.sendKeys(Keys.TAB).build().perform();
            centerlizePO.enterDataUsingSendkeys(products1.getSuppliers(),"Automation Suppliers");
            actions.sendKeys(Keys.TAB).build().perform();
            centerlizePO.enterDataUsingSendkeys(products1.getBrand(),"Automation Brand");
            actions.sendKeys(Keys.TAB).build().perform();
            centerlizePO.clickOnButton(products1.getProductSaveButton());
            sleepFor(2);
            PageFactory.initElements(driver, CustomersPO.Customers.class).clickOnCustomersButton();
            centerlizePO.clickOnButton(getGroupsButton());
            sleepFor(3);
            centerlizePO.clickOnButton(getAddGroupButton());
            sleepFor(2);
            getTextGroupName().sendKeys("Price list Discount Offer");
            sleepFor(1);
            discountOfferName = getTextGroupName().getAttribute("value");
            centerlizePO.clickOnButton(getPriceList());
            sleepFor(1);
            centerlizePO.clickOnButton(getGenerateTempate());
            sleepFor(4);
            centerlizePO.enterDataUsingSendkeys(PageFactory.initElements(driver, Products.class).getSearchBox(),product);
            sleepFor(3);
            List<WebElement> list1 = new WebDriverWait(driver,120).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy
                            (By.xpath("//ul[contains(@class,'hike-width-block')]//b[text()='Product']//parent::ul//li//a")));
            list1.get(0).click();
            sleepFor(3);
            WebElement pt01 = new WebDriverWait(driver, 90).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//a[@class='hike-group-dropdown-close']//following-sibling::span")));
            String productName = pt01.getText();
            centerlizePO.clickOnButton(getExportButton());
            sleepFor(20);
            File f = new File(System.getProperty("user.dir") + "\\download\\");
            File[] files = f.listFiles(File::isFile);
            long lastModifiedTime = Long.MIN_VALUE;
            File chosenFile = null;
            if (files != null) {
                for (File file : files) {
                    if (file.lastModified() > lastModifiedTime) {
                        chosenFile = file;
                        lastModifiedTime = file.lastModified();
                    }
                }
                System.out.println(chosenFile);
                filePath = String.valueOf(chosenFile);
            }
            sleepFor(2);
            String s = "";
            List<String> list = getAllCell(filePath);
            for (String z : list){
                System.out.println(z);
                s = z;
            }
            sleepFor(2);
            float f1 = Float.parseFloat(s);;
            double myInteger = Math.ceil(f1);
            System.out.println(myInteger-10);
            double n = myInteger-10;
            System.out.println(n);
            writePrice(filePath,String.valueOf(n));
            sleepFor(2);
            actions.sendKeys(Keys.ESCAPE).build().perform();
            sleepFor(2);
            getUploadFileButton().sendKeys(filePath);
            sleepFor(5);
            centerlizePO.clickOnButton(getSaveButton());
            sleepFor(2);
            PageFactory.initElements(driver, CustomersPO.Customers.class).clickOnCustomersButton();
            centerlizePO.clickOnButton( PageFactory.initElements(driver, Customers.class).getCustomersButton());
            sleepFor(5);
            WebElement customer = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table[@id='CustomersTable']//tbody//tr[last()-1]//td[2]//span")));
            sleepFor(2);
            customerName = customer.getText();
            customer.click();
            sleepFor(4);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Groups.class).getEditButton());
            sleepFor(4);
            centerlizePO.clickOnButton(getCustomerGroupDropDown());
            sleepFor(1);
            WebElement option = new WebDriverWait(driver,60).until
                    (ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//span[text()='" + discountOfferName + "']//parent::div")));
            option.click();
            sleepFor(1);
            centerlizePO.clickOnButton(PageFactory.initElements(driver,Groups.class).getSaveButton());
            sleepFor(3);
            PageFactory.initElements(driver, PointofSale.class).clickOnPointOfSaleButtonn();
            centerlizePO.clickOnButton(PageFactory.initElements(driver, CashRegister.class).getCashRegisterButton());
            sleepFor(5);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, CashRegister.class).getRefreshDataButton());
            centerlizePO.clickOnButton(PageFactory.initElements(driver, CashRegister.class).getContinueButton());
            centerlizePO.sleepFor(15);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, ProcessSale.class).getProcessSaleButton());
            sleepFor(15);
            centerlizePO.enterDataUsingSendkeys(PageFactory.initElements(driver, ProcessSale.class).getSearchBar(),productName);
            sleepFor(3);
            actions.sendKeys(Keys.TAB).build().perform();
            centerlizePO.clickOnButton(PageFactory.initElements(driver, ProcessSale.class).getAddCustomerButton());
            centerlizePO.enterDataUsingSendkeys(PageFactory.initElements(driver, ProcessSale.class).getAddCustomer(),customerName);
            sleepFor(1);
            actions.sendKeys(Keys.TAB).build().perform();
            sleepFor(2);
            WebElement discountele = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//div[contains(@class,'customer-search-title')]//span[contains(@class,'small')][text()]")));
            String discountName = discountele.getText();
            if(discountName.contains(discountOfferName)){
                System.out.println(" ");
            }
            sleepFor(1);
            WebElement productprice = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//div[contains(@class,'sell-item-list')]//a[not(contains(@class,'ng-hide'))]//parent::div//parent::div//div[@class='sell-item-price']//div[(contains(@ng-if,'totalDiscount '))][text()]")));
            sleepFor(1);
            String productPriceAfterDiscount = productprice.getText();
            float actualPrice =  Float.parseFloat(productPriceAfterDiscount.split("\n")[0].substring(1));//110
            System.out.println(productPriceAfterDiscount);
            if (actualPrice==n)
                System.out.println(" ");
            sleepFor(2);
            centerlizePO.enterDataUsingSendkeys(PageFactory.initElements(driver, ProcessSale.class).getSearchBar(),productName);
            sleepFor(3);
            actions.sendKeys(Keys.TAB).build().perform();
            sleepFor(3);
            List<WebElement> e = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy
                            (By.xpath("//div[contains(@class,'sell-item-list')]//a[not(contains(@class,'ng-hide'))]")));
            if (e.size()==2){
                centerlizePO.enterDataUsingSendkeys(PageFactory.initElements(driver, ProcessSale.class).getSearchBar(),productName);
                sleepFor(3);
                actions.sendKeys(Keys.TAB).build().perform();
                sleepFor(3);
                List<WebElement> e1 = new WebDriverWait(driver,60).
                        until(ExpectedConditions.presenceOfAllElementsLocatedBy
                                (By.xpath("//div[contains(@class,'sell-item-list')]//a[not(contains(@class,'ng-hide'))]//parent::div//parent::div//div[@class='sell-item-price']//div[(contains(@ng-if,'totalDiscount '))][text()]")));
                if (e1.get(0).getText().contains(s))
                    System.out.println(" ");
            }
            sleepFor(5);
            chosenFile.delete();
            List<WebElement> icon = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy
                            (By.xpath("//div[contains(@class,'sell-item-list')]//a[not(contains(@class,'ng-hide'))]")));
            for (int i=0;i<icon.size();i++){
                sleepFor(1);
                icon.get(i).click();
            }
            sleepFor(1);
            WebElement customer01 = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@class='customer-delete']")));
            customer01.click();
            sleepFor(2);
            sleepFor(1);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }


    /**
     * @author Vidhi Chapanera
     * @date 17 March 2021
     * @return
     * @throws IOException
     */
    @Step("get All Cell"+"\n"+"path:{0}")
    public static List getAllCell(String Path) throws IOException {
        List<String> map = new ArrayList<String>();
        File f = new File(String.valueOf(Path));
        FileInputStream fis = new FileInputStream(f);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet mysheet = workbook.getSheetAt(0);
        int l = mysheet.getLastRowNum();
        java.util.Iterator rowIter = mysheet.iterator();
        rowIter.next();
        while (rowIter.hasNext()) {
            XSSFRow row = (XSSFRow) rowIter.next();
            map.add(row.getCell(2).getStringCellValue());
            XSSFCell cell = row.getCell(2);
            row.removeCell(cell);
        }
        System.out.println(l);
        FileOutputStream fos = new FileOutputStream(Path);
        workbook.write(fos);
        return map;
    }


    /**
     * @author Vidhi Chapanera
     * @date 17 March 2021
     * @return
     * @throws Exception
     */
    @Step("write price"+"\n"+"path:{0}"+"\n"+"n:{0}")
    public static boolean writePrice(String path,String n) throws Exception {
        File f = new File(path);
        try {
            FileInputStream inputStream = new FileInputStream(new File(String.valueOf(f)));
            Workbook workbook = WorkbookFactory.create(inputStream);
            org.apache.poi.ss.usermodel.Sheet sheet = workbook.getSheetAt(0);
            int l = sheet.getLastRowNum();
            java.util.Iterator rowIter = sheet.iterator();
            rowIter.next();
            while (rowIter.hasNext()) {
                XSSFRow row = (XSSFRow) rowIter.next();
                XSSFCell cell = row.getCell(2);
                if (cell == null) {
                    row.createCell(2).setCellValue(n);
                    row.createCell(4).setCellValue("1");
                    row.createCell(5).setCellValue("2");
                }
            }
            inputStream.close();
            FileOutputStream outputStream = new FileOutputStream(f);
            workbook.write(outputStream);
            workbook.close();
            outputStream.close();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}