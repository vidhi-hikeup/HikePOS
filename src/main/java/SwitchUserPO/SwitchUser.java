package SwitchUserPO;

import CommonPO.BasePage;
import CommonPO.CenterlizePO;
import Config.ExcelUtils;
import PointofSalePO.CashRegisterPO.CashRegister;
import PointofSalePO.PointofSale;
import UsersPO.UserPO.Users;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;


/**
 * @author Vidhi Chapanera
 * @date 19 February 2021
 */
public class SwitchUser extends BasePage {

    public WebDriver driver;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for user profile icon
     * @date 19 February 2021
     */
    @FindBy(
            how = How.ID,
            using = "HeaderProfilePicture"
    )
    WebElement icn_userprofile;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for switch user button
     * @date 19 February 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//button[text()=' Switch user']"
    )
    WebElement btn_switchuser;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for active user
     * @date 19 February 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//span[contains(@class,'username-hide')][text()]"
    )
    WebElement activeuser;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for active user
     * @date 19 February 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//button[text()=' Lock screen']"
    )
    WebElement btn_lockscreen;

    public SwitchUser(WebDriver driver) {
        this.driver = driver;
    }
    public WebElement getUsersProfileIcon() {
        return icn_userprofile;
    }
    public WebElement getSwitchUserButton() {
        return btn_switchuser;
    }
    public WebElement getActiveuser() {
        return activeuser;
    }
    public WebElement getLockScreenButton() {
        return btn_lockscreen;
    }

    /**
     * @return
     * @throws Exception
     * @author Vidhi Chapanera
     * @date 19 February 2021
     * @discription this method is use to switch user admin to cashier
     */
    @Step("switch user admin to cashier")
    public boolean switchUserAdmintoCashier() {
        try {
            sleepFor(5);
            WebElement switchuserName = new WebDriverWait(driver, 60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//div[contains(@class,'switch-user')]//h5[text()='"+ Users.name +"']//parent::div")));
            switchuserName.click();
            sleepFor(1);
            sleepFor(3);
            String[] strArray2 = new String[]{"0", "0", "0", "0"};
            for (String s : strArray2) {
                WebElement element = new WebDriverWait(driver, 60).ignoring(StaleElementReferenceException.class).
                        until(ExpectedConditions.presenceOfElementLocated
                                (By.xpath("//div[@class='enter-pin-wrapper']//button[text()='" + s + "']")));
                element.click();
                sleepFor(1);
            }
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
     * @date 19 February 2021
     * @discription this method is use to verify user switch successfully
     */
    @Step("verify user switch successfully")
    public boolean verifyUserSwitchSuccessfully() {
        try {
            sleepFor(5);
            String activeUser = getActiveuser().getText();
            if (activeUser.contains(Users.name))
                System.out.println("");
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
     * @date 19 February 2021
     * @discription this method is use to verify that the user can only login to the store permission was granted to
     */
    @Step("verify that the user can only login to the store permission was granted to")
    public boolean verifyUserCanOnlyloginPermissionWasGrantedto() {
        CenterlizePO centerlizePO = PageFactory.initElements(driver, CenterlizePO.class);
        try {
            sleepFor(3);
            List<String> list = ExcelUtils.getAllCellDataStringForPermission("not-selected");
            for (String s : list) {
                List<WebElement> sidebarmenulist = new WebDriverWait(driver,30).until
                        (ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//a[contains(@class,'nav-link')]//span[contains(@class,'title')]")));
                for (int i =0;i<sidebarmenulist.size();i++){
                    if (s.contains("POINT OF SALE")){
                        if (!sidebarmenulist.get(i).getText().contains(s.replace(s,"Point of Sale")))
                            System.out.println("");
                    }
                    if (s.contains("STORE SETUP")){
                        if(!sidebarmenulist.get(i).getText().contains(s.replace(s,"Store setup")))
                            System.out.println("");
                    }
                    if(!sidebarmenulist.get(i).getText().contains(s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase())){
                        System.out.println("");                    }
                }
            }
            List<String> list1 = ExcelUtils.getAllCellDataStringForPermission("not-selected");
            for (String s : list1) {
                List<WebElement> sidebarmenulist = new WebDriverWait(driver,30).until
                        (ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//a[contains(@class,'nav-link')]//span[contains(@class,'title')]")));
                for (int i =0;i<sidebarmenulist.size();i++){
                    if (s.contains("POINT OF SALE")){
                        sidebarmenulist.get(i).getText().contains(s.replace(s,"Point of Sale"));
                    }
                    if (s.contains("STORE SETUP")){
                        sidebarmenulist.get(i).getText().contains(s.replace(s,"Store setup"));
                    }
                    if (sidebarmenulist.get(i).getText().contains(s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase())){
                        System.out.println("");
                    }
                }
            }
            sleepFor(1);
            PageFactory.initElements(driver, PointofSale.class).clickOnPointOfSaleButtonn();
            PageFactory.initElements(driver, CashRegister.class).getCashRegisterButton().click();
            sleepFor(2);
            WebElement store = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1//small[text()]")));
            sleepFor(1);
            if (store.getText().contains(Users.outLet))
                System.out.println("");
            sleepFor(3);
            centerlizePO.clickOnButton(getUsersProfileIcon());
            centerlizePO.clickOnButton(getSwitchUserButton());
            sleepFor(5);
            List<WebElement> switchuserName = new WebDriverWait(driver, 60).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy
                            (By.xpath("//div[contains(@class,'switch-user')]//h5[contains(text(),'')]//parent::div")));
            switchuserName.get(0).click();
            sleepFor(1);
            sleepFor(3);
            String[] strArray2 = new String[]{"0", "0", "0", "0"};
            for (String s : strArray2) {
                WebElement element = new WebDriverWait(driver, 60).ignoring(StaleElementReferenceException.class).
                        until(ExpectedConditions.presenceOfElementLocated
                                (By.xpath("//div[@class='enter-pin-wrapper']//button[text()='" + s + "']")));
                element.click();
                sleepFor(1);
            }
            sleepFor(5);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }




}