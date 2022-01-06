package ReportingPO.RegisterPO;

import CommonPO.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


/**
 * @author Vidhi Chapanera
 * @date 09 March 2021
 */
public class Register extends BasePage {

    public WebDriver driver;
    public static String dataText = "";

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Register button
     * @date 09 March 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//span[contains(text(),'Reporting')]//parent::a[contains(@class,'auto')]//parent::li//ul//li//span[contains(text(),'Register')]//parent::a"
    )
    WebElement btn_register;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for payment summery button
     * @date 09 March 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//span[text()='Payment summary']//parent::uib-tab-heading//parent::a"
    )
    WebElement btn_paymentsummery;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Voided transactions button
     * @date 29 November 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//span[normalize-space(.)='Voided transactions']//parent::uib-tab-heading//parent::a"
    )
    WebElement btn_voidedTransactions;


    public Register(WebDriver driver) {
        this.driver = driver;
    }
    public WebElement getRegisterButton() {
        return btn_register;
    }
    public WebElement getPaymentSummeryButton() {
        return btn_paymentsummery;
    }
    public WebElement getVoidedTransactionsButton() {
        return btn_voidedTransactions;
    }


}