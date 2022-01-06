
package UsersPO.UserPO;

import ClockInOutPO.ClockInOut;
import CommonPO.BasePage;
import CommonPO.CenterlizePO;
import Config.ExcelUtils;
import Config.WriteUtils;
import StoreSetupPO.LoyaltyPointsPO.LoyaltyPoints;
import SwitchUserPO.SwitchUser;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

/**
 * @author Vidhi Chapanera
 * @date 22 January 2021
 */
public class Users extends BasePage {

    public WebDriver driver;

    public static String dataText = "";
    public static String userName = "";
    public static String name = "";
    public static String outLet = "";
    public static String currentUser = "";

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Users button
     * @date 22 January 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//span[contains(text(),'Users')]//parent::a[contains(@class,'auto')]//parent::li//descendant::ul//span[contains(text(),'Users')]//parent::a"
    )
    WebElement btn_users;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for add user button
     * @date 22 January 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//i[contains(@class,'fa-plus')]//parent::a[text()=' Add user']"
    )
    WebElement btn_adduser;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for name input box
     * @date 22 January 2021
     */
    @FindBy(
            how = How.NAME,
            using = "Name"
    )
    WebElement txtbox_name;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Surname input box
     * @date 22 January 2021
     */
    @FindBy(
            how = How.NAME,
            using = "Surname"
    )
    WebElement txtbox_surname;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Email Address input box
     * @date 22 January 2021
     */
    @FindBy(
            how = How.NAME,
            using = "EmailAddress"
    )
    WebElement txtbox_emailAddress;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for user pin input box
     * @date 22 January 2021
     */
    @FindBy(
            how = How.NAME,
            using = "userpin"
    )
    WebElement txtbox_userPin;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for all outlet check box
     * @date 22 January 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//label[@for='activateAll']"
    )
    WebElement chk_alloutlet;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Display name input box
     * @date 22 January 2021
     */
    @FindBy(
            how = How.NAME,
            using = "DisplayName"
    )
    WebElement txtbox_displayname;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for set random password checkbox
     * @date 22 January 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//label[@for='EditUser_SetRandomPassword']"
    )
    WebElement chk_setrandompassword;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for username input box
     * @date 22 January 2021
     */
    @FindBy(
            how = How.NAME,
            using = "UserName"
    )
    WebElement txtbox_username;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Cashier Role radio button
     * @date 22 January 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//label[@for='EditUser_Cashier']"
    )
    WebElement rbtn_cashier;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Manager Role radio button
     * @date 22 January 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//label[@for='EditUser_Manager']"
    )
    WebElement rbtn_manager;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Admin Role radio button
     * @date 22 January 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//label[@for='EditUser_Admin']"
    )
    WebElement rbtn_admin;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for save button
     * @date 22 January 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//span[text()='Save']//parent::button"
    )
    WebElement btn_save;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for manage user role
     * @date 25 January 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//a[contains(text(),'Manage user roles')]"
    )
    WebElement btn_manageuserrole;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for add new button
     * @date 25 January 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//button[contains(text(),'Add New')]" +
                    "")
    WebElement btn_addnew;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for role name input box
     * @date 25 January 2021
     */
    @FindBy(
            how = How.NAME,
            using = "RoleDisplayName"
    )
    WebElement txtbox_roleName;


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Permission button
     * @date 27 January 2021
     */
    //
    // [old element/not working]
    @FindBy(
            how = How.CSS ,
            using = "#body > ul > li:nth-child(2) > a"
    )
    // @FindBy(
            // how = How.XPATH ,
            // using = "//style[@id='zsiqcustomcss']//following-sibling::ul//li//a[text()='Permissions']"
            // )
    //@FindBy(how = How.XPATH, using = "//div[@id='siqcht']//parent::div//following::ul[contains(@class,'dropdown-menu')]//li[@class='ng-scope']//a[text()='Permissions']")
    //@FindBy(how = How.XPATH, using = "//div[contains(@class,'intercom')]//following::ul//li//a[text()='Permissions']")
    WebElement btn_permission;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for edit button
     * @date 27 January 2021
     */
    @FindBy(
            how = How.CSS ,
            using = "#body > ul > li:nth-child(1) > a"
    )
    //
    //[old element/not working]
    //@FindBy(how = How.XPATH ,using = "//style[@id='zsiqcustomcss']//following-sibling::ul//li//a[text()='Edit']")
    //@FindBy(how = How.XPATH, using = "//div[@id='siqcht']//parent::div//following::ul[contains(@class,'dropdown-menu')]//li//a[text()='Edit']")
    //@FindBy(how = How.XPATH, using = "//div[contains(@class,'intercom')]//following::ul//li//a[text()='Edit']")
    WebElement btn_edit;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Copy Permissions & Create role button
     * @date 27 January 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//span[contains(text(),'Copy Permissions & Create role')]//parent::button"
    )
    WebElement btn_copypermissionandcreaterole;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for slider close button
     * @date 27 January 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(@class,'slider-close')]"
    )
    WebElement icon_sliderclose;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for delete this role button
     * @date 27 January 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//a[contains(text(),'Delete this role')]"
    )
    WebElement btn_deletethisrole;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for active check box
     * @date 06 January 2022
     */
    @FindBy(
            how = How.XPATH,
            using = "//label[@for='EditUser_IsActive']"
    )
    WebElement chk_active;



    public Users(WebDriver driver) {
        this.driver = driver;
    }
    public WebElement getUsersButton() {
        return btn_users;
    }
    public WebElement getAddUsersButton() {
        return btn_adduser;
    }
    public WebElement getName() {
        return txtbox_name;
    }
    public WebElement getSurname() {
        return txtbox_surname;
    }
    public WebElement getEmailAddress() {
        return txtbox_emailAddress;
    }
    public WebElement getUserPin() {
        return txtbox_userPin;
    }
    public WebElement getAllOutletCheckBox() {
        return chk_alloutlet;
    }
    public WebElement getDisplayName() {
        return txtbox_displayname;
    }
    public WebElement getSetRandomPasswordCheckbox() {
        return chk_setrandompassword;
    }
    public WebElement getUserName() {
        return txtbox_username;
    }
    public WebElement getCashierRadioButton() {
        return rbtn_cashier;
    }
    public WebElement getManagerRadioButton() {
        return rbtn_manager;
    }
    public WebElement getAdminRadioButton() {
        return rbtn_admin;
    }
    public WebElement getSaveButton() {
        return btn_save;
    }
    public WebElement getManageUserRole() {
        return btn_manageuserrole;
    }
    public WebElement getAddNewButton() {
        return btn_addnew;
    }
    public WebElement getRoleName() {
        return txtbox_roleName;
    }
    public WebElement getPermissionButton() {
        return btn_permission;
    }
    public WebElement getEditButton() {
        return btn_edit;
    }
    public WebElement getCopyPermissionAndCreateRoleButton() {
        return btn_copypermissionandcreaterole;
    }
    public WebElement getSliderCloseIcon() {
        return icon_sliderclose;
    }
    public WebElement getDeleteThisRoleButton() {
        return btn_deletethisrole;
    }
    public WebElement getActiveCheckbox() {
        return chk_active;
    }



    /**
     * @return
     * @throws Exception
     * @author Vidhi Chapanera
     * @date 22 January 2021
     * @discription this method is use to Add different 5 users
     */
    @Step("Add different 5 users")
    public boolean addDifferentUsers() {
        try {
            sleepFor(10);
            List<String> list = ExcelUtils.getAllCellDataString();
            for (String s : list) {
                sleepFor(1);
                CenterlizePO centerlizePO = PageFactory.initElements(driver, CenterlizePO.class);
                centerlizePO.clickOnButton(getAddUsersButton());
                centerlizePO.enterDataUsingSendkeys(getName(),s.split("/")[0].split("-")[0]);
                centerlizePO.enterDataUsingSendkeys(getSurname(),s.split("/")[0].split("-")[1]);
                centerlizePO.enterDataUsingSendkeys(getEmailAddress(),s.split("-")[0]+"@yopmail.com");
                WebElement rbtn = new WebDriverWait(driver,60).
                        until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[@for='EditUser_"+s.split("/")[1]+"']")));
                JavascriptExecutor executor = (JavascriptExecutor)driver;
                executor.executeScript("arguments[0].click();", rbtn);
                centerlizePO.clickOnButton(getSetRandomPasswordCheckbox());
                centerlizePO.enterDataUsingSendkeys(getUserName(),s.split("-")[0]+"01");
                /*centerlizePO.clearText(getUserPin());
                centerlizePO.enterDataUsingSendkeys(getUserPin(),"4100");*/
                /*WebElement e =  new WebDriverWait(driver,60).
                        until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[@for='activateAll']//parent::div//input")));
                Actions actions = new Actions(driver);
                actions.moveToElement(e).build().perform();
                try{
                    if (e.getAttribute("class").contains("ng-empty")){
                        System.out.println("not selected");
                        centerlizePO.clickOnButton(getAllOutletCheckBox());
                    }
                }catch (Exception exception){
                    System.out.println("selected..../1");
                }*/
                centerlizePO.clickOnButton(getSaveButton());
                sleepFor(3);
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
     * @date 22 January 2021
     * @discription this method is use to verify created user
     */
    @Step("verify created user")
    public boolean verifyCreatedUser() {
        try {
            List<WebElement> list = new WebDriverWait(driver,30).until
                    (ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//table[@id='dtUsersDataTable']//tbody//tr")));
            int number = list.size();
            if (number >= 5)
                return true;
            return false;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }


    /**
     * @return
     * @throws Exception
     * @author Vidhi Chapanera
     * @date 25 January 2021
     * @discription this method is use to add multiple role in exsting User
     */
    @Step("add multiple role in exsting User")
    public boolean addDifferentRoleToExstingUser() {
        try {
            CenterlizePO centerlizePO = PageFactory.initElements(driver, CenterlizePO.class);
            centerlizePO.clickOnButton(getManageUserRole());
            sleepFor(5);
            List<String> list = ExcelUtils.getAllCellDataStringForRole("Role");
            for (String s : list) {
                centerlizePO.clickOnButton(getAddNewButton());
                centerlizePO.enterDataUsingSendkeys(getRoleName(),s.split("-")[1]);
                List<WebElement> e = new WebDriverWait(driver,60).
                        until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//form[@name='createorEditRoleForm']//ul//li//a[contains(@id,'Pages.Tenant')]")));
                for (int i=0; i<e.size() ; i++){
                    e.get(i).click();
                    sleepFor(1);
                }
                centerlizePO.clickOnButton(getSaveButton());
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
     * @date 25 January 2021
     * @discription this method is use to verify multiple role created
     */
    @Step("verify multiple role created")
    public boolean verifyMultipleRoleCreated() {
        try {
            sleepFor(2);
            CenterlizePO centerlizePO = PageFactory.initElements(driver, CenterlizePO.class);
            centerlizePO.clickOnButton(getManageUserRole());
            List<String> list = ExcelUtils.getAllCellDataStringForRole("Role");
            for (String s : list) {
                List<WebElement> e = new WebDriverWait(driver,60).
                        until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//table[@id='dtRolesDataTable']//tr//td[2]")));
                for (int i=0; i<e.size() ; i++){
                    if(e.get(i).getText().contains(s.split("-")[1])){
                        sleepFor(1);
                    }
                }
            }
            centerlizePO.clickOnButton(getSliderCloseIcon());
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
     * @date 27 January 2021
     * @discription this method is use to add multiple role in exsting User
     */
    @Step("add multiple role in exsting User")
    public boolean addDifferentRoleToExstingUsers() {
        try {
            CenterlizePO centerlizePO = PageFactory.initElements(driver, CenterlizePO.class);
            sleepFor(5);
            List<String> list = ExcelUtils.getAllCellDataStringForRole("Role");
            for (String s : list) {
                List<WebElement> e = new WebDriverWait(driver, 60).
                        until(ExpectedConditions.presenceOfAllElementsLocatedBy
                                (By.xpath("//table[@id='dtUsersDataTable']//tr//td[contains(text(),'" + s.split("-")[0] + "')]//parent::tr//button[contains(text(),'Actions')]")));
                for (int i = 0; i < e.size(); i++) {
                    e.get(i).click();
                    WebElement permissionbtn = new WebDriverWait(driver, 60).
                            until(ExpectedConditions.visibilityOf(getPermissionButton()));
                    if(permissionbtn.isDisplayed()) {
                        JavascriptExecutor executor = (JavascriptExecutor)driver;
                        executor.executeScript("arguments[0].click();", permissionbtn);
                        //permissionbtn.click();
                        sleepFor(5);
                        WebElement copyperbtn = new WebDriverWait(driver, 60).
                                until(ExpectedConditions.visibilityOf(getCopyPermissionAndCreateRoleButton()));
                        copyperbtn.click();
                        sleepFor(2);
                        centerlizePO.enterDataUsingSendkeys(getRoleName(), s.split("-")[1]);
                        centerlizePO.clickOnButton(getSaveButton());
                        /*while (true){
                            if (driver.findElement(By.name("createAssignRole")).isDisplayed()){
                                System.out.println("displayed");
                            }
                            break;
                        }*/
                        sleepFor(7);
                    }
                    break;
                }
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
     * @date 27 January 2021
     * @discription this method is use to Review that created roles are assigned correctly under existing users
     */
    @Step("Review that created roles are assigned correctly under existing users")
    public boolean reviewCreatedRoleAssignedCorrectly() {
        try {
            CenterlizePO centerlizePO = PageFactory.initElements(driver, CenterlizePO.class);
            sleepFor(5);
            List<String> list = ExcelUtils.getAllCellDataStringForRole("Role");
            for (String s : list) {
                List<WebElement> e = new WebDriverWait(driver, 60).
                        until(ExpectedConditions.presenceOfAllElementsLocatedBy
                                (By.xpath("//table[@id='dtUsersDataTable']//tr//td[contains(text(),'" + s.split("-")[1] + "')]//parent::tr//button[contains(text(),'Actions')]")));
                for (int i = 0; i < e.size(); i++) {
                    e.get(i).click();
                    WebElement editbtn = new WebDriverWait(driver, 60).
                            until(ExpectedConditions.visibilityOf(getEditButton()));
                    if(editbtn.isDisplayed()) {
                        editbtn.click();
                        sleepFor(5);
                        WebElement rbtn = new WebDriverWait(driver, 60).
                                until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='md-radio-list']//label[contains(@for,'EditUser_" + s.split("-")[1] + "')]//parent::div//input")));
                        if(rbtn.getAttribute("class").contains("ng-valid-parse")) {
                            System.out.println("");
                        }
                        centerlizePO.clickOnButton(getSliderCloseIcon());
                        break;
                    }
                    break;
                }
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
     * @date 27 January 2021
     * @discription this method is use to Delete existing roles in any of the user
     */
    @Step("Delete existing roles in any of the user")
    public boolean deleteExistingRole() {
        try {
            sleepFor(5);
            CenterlizePO centerlizePO = PageFactory.initElements(driver, CenterlizePO.class);
            centerlizePO.clickOnButton(getManageUserRole());
            sleepFor(5);
            List<String> list = ExcelUtils.getAllCellDataStringForRole("Role");
            for (String s : list) {
                sleepFor(1);
                WebElement role = new WebDriverWait(driver, 60).
                        until(ExpectedConditions.presenceOfElementLocated((By.xpath("//table[@id='dtRolesDataTable']//tbody//tr//td[2]//a[contains(text(),'" + s.split("-")[1] + "')]"))));
                role.click();
                centerlizePO.clickOnButton(getDeleteThisRoleButton());
                centerlizePO.clickOnButton(PageFactory.initElements(driver, LoyaltyPoints.class).getYesButton());
                sleepFor(5);
            }
            centerlizePO.clickOnButton(getSliderCloseIcon());
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
     * @date 27 January 2021
     * @discription this method is use to review there is no error in existing users
     * when reopen and save users.
     */
    @Step("review there is no error in existing users when reopen and save users")
    public boolean reviewExistingUsersWhenReopen() {
        try {
            sleepFor(5);
            List<WebElement> e = new WebDriverWait(driver, 60).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy
                            (By.xpath("//table[@id='dtUsersDataTable']//tr//td[3][not(text())]//parent::tr//button[contains(text(),'Actions')]")));
            for (int i = 0; i < e.size(); i++) {
                e.get(i).click();
                WebElement editbtn = new WebDriverWait(driver, 60).
                        until(ExpectedConditions.visibilityOf(getEditButton()));
                if(editbtn.isDisplayed()) {
                    editbtn.click();
                    sleepFor(5);
                    List<WebElement> list = new WebDriverWait(driver, 60).
                            until(ExpectedConditions.presenceOfAllElementsLocatedBy
                                    (By.xpath("//div[@class='md-radio-list']//label[contains(@for,'EditUser_')]//parent::div//input")));
                    for (WebElement e1 : list){
                        if(!e1.getAttribute("class").contains("ng-valid-parse"))
                            System.out.println("");
                    }
                    PageFactory.initElements(driver,CenterlizePO.class).clickOnButton(getSliderCloseIcon());
                }
                //break;
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
     * @date 27 January 2021
     * @discription this method is use to Change super admin pin
     * when reopen and save users.
     */
    @Step("Change super admin pin")
    public boolean chnageSuperAdminPin() {
        try {
            sleepFor(10);
            WebElement e = new WebDriverWait(driver, 60).
                    until(ExpectedConditions.presenceOfElementLocated((By.xpath("//table[@id='dtUsersDataTable']//tr[1]//td[3]//parent::tr//button[contains(text(),'Actions')]"))));
            e.click();
            sleepFor(1);
            PageFactory.initElements(driver, CenterlizePO.class).clickOnButton(getEditButton());
            PageFactory.initElements(driver, CenterlizePO.class).clearText(getUserPin());
            PageFactory.initElements(driver, CenterlizePO.class).enterDataUsingSendkeys(getUserPin(), "4100");
            PageFactory.initElements(driver, CenterlizePO.class).clickOnButton(getSaveButton());
            sleepFor(8);
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
     * @date 03 February 2021
     * @discription this method is use to clear all notification
     * when reopen and save users.
     */
    @Step("clear all notification")
    public boolean clearAllNotification() {
        try {
            sleepFor(10);
            driver.switchTo().frame("intercom-notifications-frame");
            sleepFor(1);
            List<WebElement> e = new WebDriverWait(driver, 60).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy((By.xpath("//div[contains(@class,'intercom')]//img"))));
            Actions actions = new Actions(driver);
            actions.moveToElement(e.get(1)).build().perform();
            sleepFor(1);
            WebElement btn = new WebDriverWait(driver, 60).
                    until(ExpectedConditions.presenceOfElementLocated((By.xpath("//button[contains(text(),'Clear All')]"))));
            actions.moveToElement(btn).build().perform();
            btn.click();
            driver.switchTo().defaultContent();
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
     * @date 19 February 2021
     * @discription this method is use to get user permissions and store name
     */
    @Step("get user prmissions and store name")
    public boolean getUserPermissionsAndStoreName() {
        try {
            sleepFor(5);
            List<WebElement> cashierUser = new WebDriverWait(driver, 60).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy
                            (By.xpath("//table[@id='dtUsersDataTable']//tr//td[contains(text(),'Cashier')]//parent::tr//button[contains(text(),'Actions')]")));
            for (int i=0 ;i<cashierUser.size();i++){
                cashierUser.get(i).click();
                WebElement editbtn = new WebDriverWait(driver, 60).
                        until(ExpectedConditions.visibilityOf(getEditButton()));
                if(editbtn.isDisplayed()) {
                    editbtn.click();
                    sleepFor(5);
                    WebElement username = new WebDriverWait(driver, 60).
                            until(ExpectedConditions.presenceOfElementLocated(By.xpath("//dl[contains(@class,'text-capitalize')]")));
                    userName = username.getText();
                    sleepFor(1);
                    name = getName().getAttribute("value") + " " +getSurname().getAttribute("value");
                    sleepFor(1);
                    System.out.println(name);
                    WebElement outlet = new WebDriverWait(driver, 60).
                            until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[contains(@for,'outlet')]//parent::div//input[contains(@class,'not-empty')]//parent::div//label[text()]")));
                    outLet = outlet.getText();
                    PageFactory.initElements(driver,CenterlizePO.class).clickOnButton(getSliderCloseIcon());
                    sleepFor(1);
                    cashierUser.get(i).click();
                    sleepFor(3);
                    WebElement permissionbtn = new WebDriverWait(driver, 60).
                            until(ExpectedConditions.visibilityOf(getPermissionButton()));
                    if(permissionbtn.isDisplayed()) {
                        JavascriptExecutor executor = (JavascriptExecutor) driver;
                        executor.executeScript("arguments[0].click();", permissionbtn);
                        sleepFor(5);
                    }
                    List<WebElement> permissionWhichIsNotSelected = new WebDriverWait(driver, 60).
                            until(ExpectedConditions.presenceOfAllElementsLocatedBy
                                    (By.xpath("//form[@name='editUserPermissionsForm']//ul[@class='jstree-children']//li[@aria-selected='false']//a[text()]")));
                    ExcelUtils.removeAllCellDataString(System.getProperty("user.dir") + "\\xlsx File\\Permissions.xlsx","not-selected");
                    for(int j=0;j<permissionWhichIsNotSelected.size();j++){
                        String testData = permissionWhichIsNotSelected.get(j).getText();
                        WriteUtils.writeCountInExstingExcel(System.getProperty("user.dir") + "\\xlsx File\\Permissions.xlsx","not-selected",testData);
                    }
                    sleepFor(1);
                    List<WebElement> permissionWhichIsSelected = new WebDriverWait(driver, 60).
                            until(ExpectedConditions.presenceOfAllElementsLocatedBy
                                    (By.xpath("//form[@name='editUserPermissionsForm']//ul[@class='jstree-children']//li//a//parent::li[not(@aria-selected='false')]")));
                    ExcelUtils.removeAllCellDataString(System.getProperty("user.dir") + "\\xlsx File\\Permissions.xlsx","selected");
                    for(int k=0;k<permissionWhichIsSelected.size();k++){
                        String testData = permissionWhichIsSelected.get(k).getText();
                        WriteUtils.writeCountInExstingExcel(System.getProperty("user.dir") + "\\xlsx File\\Permissions.xlsx","selected",testData);
                    }
                    sleepFor(1);
                    getSaveButton().click();
                    sleepFor(5);
                }
                break;
            }
            sleepFor(1);
            currentUser = PageFactory.initElements(driver, SwitchUser.class).getActiveuser().getText();
            System.out.println("currentUser : "+currentUser);
            sleepFor(1);
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
     * @date 06 January 2022
     * @discription this method is use to Verify after deactivation user should not display in switch user screen and clock in out screen
     */
    @Step("Verify after deactivation user should not display in switch user screen and clock in out screen")
    public boolean UserDeactivationFunctionality() {
        try {
            sleepFor(10);
            WebElement userName = new WebDriverWait(driver, 60).until(ExpectedConditions.presenceOfElementLocated
                    (By.xpath("//table[@id='dtUsersDataTable']//tr[last()]//button[contains(text(),'Actions')]//parent::div//parent::td//preceding-sibling::td[last()-1]")));
            String getUserName = userName.getText();
            WebElement actionButton = new WebDriverWait(driver, 60).until(ExpectedConditions.presenceOfElementLocated
                    (By.xpath("//table[@id='dtUsersDataTable']//tr[last()]//button[contains(text(),'Actions')]")));
            CenterlizePO centerlizePO = PageFactory.initElements(driver, CenterlizePO.class);
            centerlizePO.clickOnButton(actionButton);
            sleepFor(3);
            WebElement editbtn = new WebDriverWait(driver, 60).
                    until(ExpectedConditions.visibilityOf(getEditButton()));
            if(editbtn.isDisplayed()) {
                centerlizePO.clickOnButton(editbtn);
                sleepFor(10);
                centerlizePO.clickOnButton(getActiveCheckbox());
                sleepFor(3);
                centerlizePO.clickOnButton(PageFactory.initElements(driver,  UsersPO.UserPO.Users.class).getSaveButton());
                sleepFor(10);
                centerlizePO.clickOnButton(PageFactory.initElements(driver,  SwitchUser.class).getUsersProfileIcon());
                sleepFor(2);
                centerlizePO.clickOnButton(PageFactory.initElements(driver,  SwitchUser.class).getSwitchUserButton());
                sleepFor(10);
                try{
                    Assert.assertTrue(driver.findElement(By.xpath("//h5[text()='"+getUserName+"']")).isDisplayed());
                    return false;
                }catch (Exception e){
                    sleepFor(3);
                    Actions actions = new Actions(driver);
                    actions.sendKeys(Keys.ESCAPE).build().perform();
                    sleepFor(3);
                    centerlizePO.clickOnButton(PageFactory.initElements(driver, ClockInOut.class).getClockIcon());
                    sleepFor(5);
                    try{
                        Assert.assertTrue(driver.findElement(By.xpath("//p[normalize-space(.)='"+getUserName+"']")).isDisplayed());
                        return false;
                    }catch (Exception e1){
                        return true;
                    }
                }
            }
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}