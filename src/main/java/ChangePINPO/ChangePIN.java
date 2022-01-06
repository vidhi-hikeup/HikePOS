package ChangePINPO;

import CommonPO.BasePage;
import CommonPO.CenterlizePO;
import SwitchUserPO.SwitchUser;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;


/**
 * @author Vidhi Chapanera
 * @date 26 October 2021
 */
public class ChangePIN extends BasePage {

    public WebDriver driver;

    public static String Number1 = "4";
    public static String UserName = "";

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for current user
     * @date 26 October 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//img[@id='HeaderProfilePicture']//parent::a"
    )
    WebElement currentUser;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for change pin button
     * @date 26 October 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//a[normalize-space(.)='Change PIN']"
    )
    WebElement btn_changePIN;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for save button
     * @date 26 October 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//span[text()='Save']//parent::button"
    )
    WebElement btn_Save;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for ALERT POPUP
     * @date 27 October 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(text(),'You do not have enough permissions to perform this transactions. At least one of these permissions must be granted: Outlets & registers, Process sale')]"
    )
    WebElement alertPopup;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for ok button
     * @date 26 October 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//button[text()='Ok']"
    )
    WebElement btn_Ok;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for ok button
     * @date 26 October 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//div[text()='Invalid PIN.']"
    )
    WebElement invalid_PIN;

    public ChangePIN(WebDriver driver) {
        this.driver = driver;
    }
    public WebElement getCurrentUser() {
        return currentUser;
    }
    public WebElement getChangePINButton() {
        return btn_changePIN;
    }
    public WebElement getSaveButton() {
        return btn_Save;
    }
    public WebElement getAlertPopup() {
        return alertPopup;
    }
    public WebElement getOKButton() {
        return btn_Ok;
    }
    public WebElement getInvalidPIN() {
        return invalid_PIN;
    }


    /**
     * @return
     * @throws Exception
     * @author Vidhi Chapanera
     * @date 26 October 2021
     * @discription this method is use to Change Current PIN
     */
    @Step("Change Current PIN")
    public boolean changeOldPIN() {
        try {
            sleepFor(3);
            List<WebElement> list = new WebDriverWait(driver, 30).ignoring(StaleElementReferenceException.class).until
                    (ExpectedConditions.refreshed(ExpectedConditions.presenceOfAllElementsLocatedBy
                            (By.xpath("//div[@id='txtPasswordcurrentPin']//input"))));
            for(int i =0;i<list.size();i++){
                sleepFor(1);
                PageFactory.initElements(driver,CenterlizePO.class).enterDataUsingSendkeys(list.get(i),"0");
            }

            List<WebElement> newPIN = new WebDriverWait(driver, 30).ignoring(StaleElementReferenceException.class).until
                    (ExpectedConditions.refreshed(ExpectedConditions.presenceOfAllElementsLocatedBy
                            (By.xpath("//div[@id='txtPasswordnewPin']//input"))));
            for(int i =0;i<newPIN.size();i++){
                sleepFor(1);
                PageFactory.initElements(driver,CenterlizePO.class).enterDataUsingSendkeys(newPIN.get(i),Number1);
            }

            sleepFor(3);
            getSaveButton().click();
            sleepFor(7);

            return true;
        } catch (StaleElementReferenceException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }



    /**
     * @return
     * @throws Exception
     * @author Vidhi Chapanera
     * @date 26 October 2021
     * @discription this method is use to Verify New PIN is updated by Switching between user
     */
    @Step("Verify New PIN is updated by Switching between user")
    public boolean VerifyNewPIN() {
        try {
            sleepFor(3);
            getCurrentUser().click();
            sleepFor(2);
            PageFactory.initElements(driver, SwitchUser.class).getSwitchUserButton().click();
            sleepFor(2);

            List<WebElement> C_user = new WebDriverWait(driver, 30).ignoring(StaleElementReferenceException.class).until
                    (ExpectedConditions.refreshed(ExpectedConditions.presenceOfAllElementsLocatedBy
                            (By.xpath("//span[contains(@class,'uppercase')]"))));
            UserName = C_user.get(0).getText();

            List<WebElement> user = new WebDriverWait(driver, 30).ignoring(StaleElementReferenceException.class).until
                    (ExpectedConditions.refreshed(ExpectedConditions.presenceOfAllElementsLocatedBy
                            (By.xpath("//div[contains(@class,'img')]"))));
            user.get(0).click();
            sleepFor(2);

            sleepFor(3);
            String[] strArray2 = new String[]{"0", "0", "0", "0"};
            for (String s : strArray2) {
                WebElement element = new WebDriverWait(driver, 60).ignoring(StaleElementReferenceException.class).
                        until(ExpectedConditions.presenceOfElementLocated
                                (By.xpath("//div[@class='enter-pin-wrapper']//button[text()='" + s + "']")));
                element.click();
                sleepFor(1);
            }
            sleepFor(15);
            try{
                if (alertPopup.isDisplayed()){
                    System.out.println("Alert Displayed................/");
                    getOKButton().click();
                }
            }catch (Exception e)
            {
                System.out.println("test");
            }

            getCurrentUser().click();
            sleepFor(2);
            PageFactory.initElements(driver, SwitchUser.class).getSwitchUserButton().click();
            sleepFor(2);
            WebElement element = new WebDriverWait(driver, 60).ignoring(StaleElementReferenceException.class).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//h5[contains(text(),'" + capitalizeWord(UserName.toLowerCase()) + "')]")));
            element.click();
            sleepFor(2);
            /*List<WebElement> user1 = new WebDriverWait(driver, 30).ignoring(StaleElementReferenceException.class).until
                    (ExpectedConditions.refreshed(ExpectedConditions.presenceOfAllElementsLocatedBy
                            (By.xpath("//div[contains(@class,'img')]"))));
            user1.get(0).click();*/
            sleepFor(2);

            sleepFor(3);
            List<WebElement> list = new WebDriverWait(driver, 30).ignoring(StaleElementReferenceException.class).until
                    (ExpectedConditions.refreshed(ExpectedConditions.presenceOfAllElementsLocatedBy
                            (By.xpath("//div[@id='txtPassword']//input"))));
            for(int i =0;i<list.size();i++){
                sleepFor(1);
                PageFactory.initElements(driver,CenterlizePO.class).enterDataUsingSendkeys(list.get(i),Number1);
            }
            sleepFor(3);
            try {
                if (invalid_PIN.isDisplayed()){
                    return false;
                }
            }catch (Exception e){
                return true;
            }
            return true;
        } catch (StaleElementReferenceException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }


    /**
     * @return
     * @throws Exception
     * @author Vidhi Chapanera
     * @date 27 October 2021
     * @discription this method is use to capitalize Word
     */
    @Step("capitalize Word" + "\n" + "str:{0}")
    public static String capitalizeWord(String str){
        String words[]=str.split("\\s");
        String capitalizeWord="";
        for(String w:words){
            String first=w.substring(0,1);
            String afterfirst=w.substring(1);
            capitalizeWord+=first.toUpperCase()+afterfirst+" ";
        }
        return capitalizeWord.trim();
    }
    
}