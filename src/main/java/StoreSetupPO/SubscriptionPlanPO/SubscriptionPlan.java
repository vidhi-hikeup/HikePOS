package StoreSetupPO.SubscriptionPlanPO;

import CommonPO.BasePage;
import CommonPO.CenterlizePO;
import io.qameta.allure.Step;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;


/**
 * @author Vidhi Chapanera
 * @date 05 January 2022
 */
public class SubscriptionPlan extends BasePage {

    public WebDriver driver;
    public static String dataText = "";
    public static final Logger log4j = Logger.getLogger(SubscriptionPlan.class);

    {
        BasicConfigurator.configure();
    }

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for select plan button
     * @date 05 January 2022
     */
    @FindBy(
            how = How.XPATH,
            using = "//span[text()='Select plan']//parent::button"
    )
    WebElement btn_selectPaln;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for select plan button
     * @date 05 January 2022
     */
    @FindBy(
            how = How.XPATH,
            using = "//h4[text()='Essential AUD Monthly']//parent::div//following-sibling::div//span[text()='Select this plan']//parent::label"
    )
    WebElement btn_selectPaln_Monthly;


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for card number text
     * @date 05 January 2022
     */
    @FindBy(
            how = How.NAME,
            using = "cardnumber"
    )
    WebElement txt_cardnumber;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for card expiry month text
     * @date 05 January 2022
     */
    @FindBy(
            how = How.NAME,
            using = "cardexpirymonth"
    )
    WebElement txt_cardexpirymonth;


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for card expiry Year text
     * @date 05 January 2022
     */
    @FindBy(
            how = How.NAME,
            using = "cardexpiryyear"
    )
    WebElement txt_cardexpiryyear;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for card cvv text
     * @date 05 January 2022
     */
    @FindBy(
            how = How.NAME,
            using = "cardcvv"
    )
    WebElement txt_cardcvv;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Pay button
     * @date 05 January 2022
     */
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(@class,'billing-model')]//button[contains(text(),'Pay')]"
    )
    WebElement btn_pay;


    public SubscriptionPlan(WebDriver driver) {
        this.driver = driver;
    }
    public WebElement getSelectPlanButton() {
        return btn_selectPaln;
    }
    public WebElement getSelectPlanMonthlyButton() {
        return btn_selectPaln_Monthly;
    }
    public WebElement getCardNumber() {
        return txt_cardnumber;
    }
    public WebElement getCardExpiryMonth() {
        return txt_cardexpirymonth;
    }
    public WebElement getCardExpiryYear() {
        return txt_cardexpiryyear;
    }
    public WebElement getCardCVV() {
        return txt_cardcvv;
    }
    public WebElement getPayButton() {
        return btn_pay;
    }


    /**
     * @author Vidhi Chapanera
     * @date 05 January 2022
     * @return
     * @throws Exception
     * @discription this method is used to switch to https://asy.io:82/ server
     */
    @Step("switch to https://asy.io:82/ server")
    public boolean switchServer() {
        try {
            sleepFor(7);
            driver.get("https://asy.io:82/");
            sleepFor(7);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }


    /**
     * @author Vidhi Chapanera
     * @date 05 January 2022
     * @return
     * @throws Exception
     * @discription this method is used to Select monthly Subscription
     */
    @Step("Select monthly Subscription")
    public boolean monthlySubscription() {
        try {
            sleepFor(7);
            CenterlizePO centerlizePO = PageFactory.initElements(driver, CenterlizePO.class);
            centerlizePO.clickOnButton(btn_selectPaln);
            sleepFor(5);
            WebElement switchLabel = new WebDriverWait(driver,60).
                    until(ExpectedConditions.
                            elementToBeClickable(By.xpath("//input[@id='subscribePlan']//parent::div//span[contains(@class,'switch-label')]")));
            Actions actions = new Actions(driver);
            actions.moveToElement(switchLabel).click().build().perform();
            sleepFor(8);
            actions.moveToElement(getSelectPlanMonthlyButton()).click().build().perform();
            sleepFor(5);
            centerlizePO.enterDataUsingSendkeys(getCardNumber(),"4111 1111 1111 1111");
            centerlizePO.enterDataUsingSendkeys(getCardExpiryMonth(),"12");
            centerlizePO.enterDataUsingSendkeys(getCardExpiryYear(),"27");
            centerlizePO.enterDataUsingSendkeys(getCardCVV(),"164");
            centerlizePO.clickOnButton(getPayButton());
            sleepFor(50);
            DateFormat dateFormat = new SimpleDateFormat("d MMM. yyyy");
            Calendar cal = Calendar.getInstance();
            String s = dateFormat.format(cal.getTime());
            log4j.info(dateFormat.format(cal.getTime()));
            Assert.assertTrue(driver.findElement(By.xpath("//span[contains(normalize-space(.),'Plan active since "+s+"')]")).isDisplayed());
            Calendar currentMonth = Calendar.getInstance();
            DateFormat dateFormat1 = new SimpleDateFormat("dd MMM., yyyy");
            currentMonth.add(Calendar.MONTH, 1);
            String s1 = dateFormat1.format(currentMonth.getTime());

            Assert.assertTrue(driver.findElement(By.xpath("//th[text()='Current plan']//parent::tr//parent::thead//parent::table//div//div[contains(normalize-space(.),'Active. Auto-renewal due on "+s1+"')]")).isDisplayed());
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }


}