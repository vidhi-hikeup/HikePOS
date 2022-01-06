package StoreSetupPO.GeneralPO;

import CommonPO.BasePage;
import CommonPO.CenterlizePO;
import StoreSetupPO.StoreSetup;
import io.qameta.allure.Step;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


/**
 * @author Vidhi Chapanera
 * @date 20 December 2021
 */
public class General2 extends BasePage {

    public WebDriver driver;

    private static final Logger log4j = LogManager.getLogger(General2.class);

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for trading name input
     * @date 10 December 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//label[contains(normalize-space(.),'Trading name')]//preceding-sibling::input"
    )
    WebElement txt_tradingName;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for change button
     * @date 10 December 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//label[normalize-space(.)='Cloud address']//parent::div//a[contains(normalize-space(.),'Change')]"
    )
    WebElement txt_change;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for yes please button
     * @date 10 December 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//button[normalize-space(.)='Yes, please']"
    )
    WebElement btn_YesPlease;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for enter new address
     * @date 10 December 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//input[@placeholder='Enter new address']"
    )
    WebElement txt_enterNewAdress;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for continue button
     * @date 10 December 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//button[text()='Continue']"
    )
    WebElement btn_contiune;

    public General2(WebDriver driver) {
        this.driver = driver;
    }
    public WebElement getTradingName() {
        return txt_tradingName;
    }
    public WebElement getChangeButton() {
        return txt_change;
    }
    public WebElement getYesPleaseButton() {
        return btn_YesPlease;
    }
    public WebElement getEnterNewAdress() {
        return txt_enterNewAdress;
    }
    public WebElement getContinueButton() {
        return btn_contiune;
    }

    /**
     * @author Vidhi Chapanera
     * @date 10 December 2021
     * @return
     * @throws Exception
     * @discription this method is used to Change Cloud Address And Verify scenario
     */
    @Step("Change Cloud Address And Verify scenario")
    public boolean changeCloudAddress() {
        BasicConfigurator.configure();
        String webAddress =  "Test41";
        String name ="";
        CenterlizePO centerlizePO = PageFactory.initElements(driver,CenterlizePO.class);
        try {
            sleepFor(5);
            PageFactory.initElements(driver, StoreSetup.class).clickOnStoreSetupButton();
            centerlizePO.clickOnButton(PageFactory.initElements(driver, General.class).getGeneralButton());
            sleepFor(10);
            name = getTradingName().getAttribute("value");
            centerlizePO.clickOnButton(getChangeButton());
            centerlizePO.clickOnButton(getYesPleaseButton());
            centerlizePO.clearText(getEnterNewAdress());
            centerlizePO.enterDataUsingSendkeys(getEnterNewAdress(),webAddress);
            sleepFor(2);
            centerlizePO.clickOnButton(getContinueButton());
            sleepFor(25);
            String currentaddress = driver.getCurrentUrl();
            log4j.info(currentaddress);
            Assert.assertEquals(currentaddress.split("//")[1].split(".hikeup")[0],webAddress.toLowerCase());
            return true;
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }finally {
            PageFactory.initElements(driver, StoreSetup.class).clickOnStoreSetupButton();
            centerlizePO.clickOnButton(PageFactory.initElements(driver, General.class).getGeneralButton());
            sleepFor(10);
            centerlizePO.clickOnButton(getChangeButton());
            centerlizePO.clickOnButton(getYesPleaseButton());
            centerlizePO.clearText(getEnterNewAdress());
            centerlizePO.enterDataUsingSendkeys(getEnterNewAdress(),name);
            sleepFor(2);
            centerlizePO.clickOnButton(getContinueButton());
            sleepFor(25);
        }
    }



}