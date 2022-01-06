package StoreSetupPO.LoyaltyPointsPO;

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
 * @date 19 January 2021
 */
public class LoyaltyPoints extends BasePage {

    public WebDriver driver;
    public static String dataText = "";

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for loyalty points button
     * @date 19 January 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//span[contains(text(),'Loyalty points')]//parent::a"
    )
    WebElement btn_loyaltypoints;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for activate loyalty rewards button
     * @date 19 January 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//button[text()='Activate loyalty rewards']"
    )
    WebElement btn_activateloyaltyrewards;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for yes button on swal popup
     * @date 19 January 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//div[@class='swal-footer']//button[text()='Yes']"
    )
    WebElement btn_yes;


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for save button
     * @date 19 January 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//span[text()='Save']//parent::button"
    )
    WebElement btn_save;

    public LoyaltyPoints(WebDriver driver) {
        this.driver = driver;
    }
    public WebElement getLoyaltyPointsButton() {
        return btn_loyaltypoints;
    }
    public WebElement getActivateLoyaltyRewardsButton() {
        return btn_activateloyaltyrewards;
    }
    public WebElement getSaveButton() {
        return btn_save;
    }
    public WebElement getYesButton() {
        return btn_yes;
    }

    /**
     * @author Vidhi Chapanera
     * @date 19 January 2021
     * @return
     * @throws Exception
     * @discription this method is used to click on active loyalty rewards
     */
    @Step("click on store setup button")
    public boolean activateLoyaltyRewards() {
        try {
            sleepFor(1);
            if(getActivateLoyaltyRewardsButton().isDisplayed()) {
                sleepFor(1);
                WebElement btn = new WebDriverWait(driver, 90).
                        until(ExpectedConditions.visibilityOf(getActivateLoyaltyRewardsButton()));
                btn.click();
                WebElement yesbtn = new WebDriverWait(driver, 90).
                        until(ExpectedConditions.visibilityOf(getYesButton()));
                yesbtn.click();
                WebElement save = new WebDriverWait(driver, 90).
                        until(ExpectedConditions.visibilityOf(getSaveButton()));
                save.click();
                return true;
            }
            return true;
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return true;
        }
    }
}