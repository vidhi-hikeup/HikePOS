package ProductsPO.GiftCardsPO;

import CommonPO.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Vidhi Chapanera
 * @date 20 January 2021
 */
public class GiftCards extends BasePage {

    public WebDriver driver;
    public static String dataText = "";

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for gift cards button
     * @date 20 January 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//span[contains(text(),'Products')]//parent::a[contains(@class,'auto')]//parent::li//descendant::ul//span[contains(text(),'Gift cards')]//parent::a"
    )
    WebElement btn_giftcards;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for activate gift cards button
     * @date 20 January 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//button[text()='Activate gift cards']"
    )
    WebElement btn_activategiftcards;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for yes button on swal popup
     * @date 20 January 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//div[@class='swal-footer']//button[text()='Yes']"
    )
    WebElement btn_yes;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for gift card list table
     * @date 20 January 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//div[@id='GiftCardDataTable_wrapper']"
    )
    WebElement tbl_giftcardlist;

    public GiftCards(WebDriver driver) {
        this.driver = driver;
    }
    public WebElement getGiftCardsButton() {
        return btn_giftcards;
    }
    public WebElement getActivateGiftCardsButton() {
        return btn_activategiftcards;
    }
    public WebElement getYesButton() {
        return btn_yes;
    }
    public WebElement getGiftCardTable() {
        return tbl_giftcardlist;
    }

    /**
     * @author Vidhi Chapanera
     * @date 20 January 2021
     * @return
     * @throws Exception
     * @discription this method is used to click on active gift cards
     */
    @Step("click on store setup button")
    public boolean activeLoyaltyRewards() {
        try {
            if(getActivateGiftCardsButton().isDisplayed()) {
                sleepFor(1);
                WebElement btn = new WebDriverWait(driver, 90).
                        until(ExpectedConditions.visibilityOf(getActivateGiftCardsButton()));
                btn.click();
                WebElement yesbtn = new WebDriverWait(driver, 90).
                        until(ExpectedConditions.visibilityOf(getYesButton()));
                yesbtn.click();
            }
            return true;
        }catch (Exception e) {
            if(getGiftCardTable().isDisplayed()) {
                return true;
            }else
                return true;
        }
    }

}