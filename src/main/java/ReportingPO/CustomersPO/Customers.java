package ReportingPO.CustomersPO;

import CommonPO.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * @author Vidhi Chapanera
 * @date 03 March 2021
 */
public class Customers extends BasePage {

    public WebDriver driver;
    public static String dataText = "";

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Customers button
     * @date 03 March 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//span[contains(text(),'Reporting')]//parent::a[contains(@class,'auto')]//parent::li//ul//li//span[contains(text(),'Customers')]//parent::a"
    )
    WebElement btn_customers;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Acc. receivables statement button
     * @date 03 March 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//span[contains(text(),'Acc. receivables statement')]//parent::uib-tab-heading//parent::a"
    )
    WebElement btn_AccreceivablesStatement ;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for apply button
     * @date 03 March 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//form[@name='ARStatementSearch']//button[text()='Apply']"
    )
    WebElement btn_apply ;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for email button
     * @date 03 March 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//span[text()='Email']//parent::button"
    )
    WebElement btn_email ;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for gift card balance button
     * @date 12 March 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//span[contains(text(),'Gift card balance')]//parent::uib-tab-heading//parent::a"
    )
    WebElement btn_giftcardbalance ;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for gift card balance input box
     * @date 12 March 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//input[contains(@placeholder,'card')]"
    )
    WebElement txt_giftcardbalance ;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for loyalty points button
     * @date 12 March 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//span[contains(text(),'Loyalty points')]//parent::uib-tab-heading//parent::a"
    )
    WebElement btn_loyaltypoints ;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for loyalty point input box
     * @date 12 March 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//input[contains(@placeholder,'transaction number')]"
    )
    WebElement txt_loyaltypoint ;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for giftcard transaction button
     * @date 08 December 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//span[text()='Giftcard transactions']//parent::uib-tab-heading//parent::a"
    )
    WebElement btn_giftcardtransaction;


    public Customers(WebDriver driver) {
        this.driver = driver;
    }
    public WebElement getCustomersButton() {
        return btn_customers;
    }
    public WebElement getAccReceivablesStatementsButton() {
        return btn_AccreceivablesStatement;
    }
    public WebElement getApplyButton() {
        return btn_apply;
    }
    public WebElement getEmailBtton() {
        return btn_email;
    }
    public WebElement getGiftCardBalanceButton() {

        return btn_giftcardbalance;
    }
    public WebElement getGiftCardBalance() {
        return txt_giftcardbalance;
    }
    public WebElement getLoyaltyPointsButton() {
        return btn_loyaltypoints;
    }
    public WebElement getLoyaltyPoint() {
        return txt_loyaltypoint;
    }
    public WebElement getGiftcardTransactionButton() {
        return btn_giftcardtransaction;
    }




}