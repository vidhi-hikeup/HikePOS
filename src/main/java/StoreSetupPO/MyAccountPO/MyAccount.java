package StoreSetupPO.MyAccountPO;

import CommonPO.BasePage;
import CommonPO.CenterlizePO;
import PointofSalePO.CashRegisterPO.CashRegister;
import PointofSalePO.PointofSale;
import ProductsPO.GiftCardsPO.GiftCards;
import ProductsPO.Products;
import StoreSetupPO.GeneralPO.General1;
import io.qameta.allure.Step;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

/**
 * @author Vidhi Chapanera
 * @date 30 March 2021
 */
public class MyAccount extends BasePage {

    public WebDriver driver;
    public static String dataText = "";
    private static final Logger log4j = LogManager.getLogger(General1.class);

    {
        BasicConfigurator.configure();
    }

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for my account button
     * @date 30 March 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//span[contains(text(),'My account')]//parent::a"
    )
    WebElement btn_myaccount;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Purge data button
     * @date 30 March 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//button[contains(text(),'Purge data')]"
    )
    WebElement btn_purgedata;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Delete all products and related records button
     * @date 30 March 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//strong[contains(text(),'Delete all products and related records')]//parent::label"
    )
    WebElement btn_deleteAllProducts;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Supplier and purchase order records button
     * @date 30 March 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//strong[contains(text(),'Supplier and purchase order records')]//parent::label"
    )
    WebElement btn_supplier;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Purge selected button
     * @date 30 March 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//span[contains(text(),'Purge selected')]//parent::button"
    )
    WebElement btn_Purgeselected;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Purge gift card checkbox
     * @date 23 December 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//strong[text()='Delete gift cards']//parent::label"
    )
    WebElement btn_PurgeGiftcards;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Purge selected button
     * @date 23 December 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//span[text()='Purge selected']//parent::button"
    )
    WebElement btn_purgeSelected;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for continue button
     * @date 23 December 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//button[contains(text(),'Continue')]"
    )
    WebElement btn_continue;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for ok button
     * @date 23 December 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//button[contains(text(),'Ok')]"
    )
    WebElement btn_ok;

    public MyAccount(WebDriver driver) {
        this.driver = driver;
    }
    public WebElement getMyAccountButton() {
        return btn_myaccount;
    }
    public WebElement getPurgeData() {
        return btn_purgedata;
    }
    public WebElement getDeleteAllProducts() {
        return btn_deleteAllProducts;
    }
    public WebElement getSupplier() {
        return btn_supplier;
    }
    public WebElement getPurgeSelected() {
        return btn_Purgeselected;
    }
    public WebElement getPurgeGiftcards() {
        return btn_PurgeGiftcards;
    }
    public WebElement getPurgeSelectedButton() {
        return btn_purgeSelected;
    }
    public WebElement getContinueButton() {
        return btn_continue;
    }
    public WebElement getOKButton() {
        return btn_ok;
    }

    /**
     * @author Vidhi Chapanera
     * @date 23 December 2021
     * @return
     * @throws Exception
     * @discription this methd is used to Purge data for gift cards
     */
    @Step("Purge data for gift cards")
    public boolean purgeDataForGiftCard() {
        try {
            sleepFor(1);
            CenterlizePO centerlizePO = PageFactory.initElements(driver, CenterlizePO.class);
            centerlizePO.clickOnButton(getPurgeGiftcards());
            sleepFor(3);
            Assert.assertTrue(getPurgeSelectedButton().getCssValue("background-color").contains("rgba(231, 80, 90, 1)"));
            String s =getPurgeSelectedButton().getCssValue("background-color");
            log4j.info(s);
            centerlizePO.clickOnButton(getPurgeSelectedButton());
            centerlizePO.clickOnButton(getContinueButton());
            centerlizePO.clickOnButton(getOKButton());
            sleepFor(3);
            PageFactory.initElements(driver, PointofSale.class).clickOnPointOfSaleButtonn();
            sleepFor(1);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, CashRegister.class).getCashRegisterButton());
            sleepFor(10);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, CashRegister.class).getRefreshDataButton());
            centerlizePO.clickOnButton(PageFactory.initElements(driver, CashRegister.class).getContinueButton());
            sleepFor(25);
            PageFactory.initElements(driver, Products.class).clickOnProductsButtonn();
            sleepFor(1);
            PageFactory.initElements(driver, GiftCards.class).getGiftCardsButton().click();
            sleepFor(15);
            Assert.assertTrue(driver.findElement(By.xpath("//table[@id='GiftCardDataTable']//td[text()='No records found']")).isDisplayed());
            sleepFor(13);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

}