package SwitchUserTS;

import CommonPO.CenterlizePO;
import Config.Base.BaseTest;
import Config.allure.AllureListener;
import LoginTS.LoginTC;
import SwitchUserPO.SwitchUser;
import UsersPO.UserPO.Users;
import com.relevantcodes.extentreports.LogStatus;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import java.io.IOException;

@Listeners({AllureListener.class})
public class SwitchUserTC extends BaseTest {


    public int flag = 1;

    public SwitchUserTC() {
    }

    public SwitchUserTC(WebDriver driver, int flag) {
        this.flag = flag;
        this.driver = driver;
    }


    /**
     * @author Vidhi Chapanera
     * @since 19 February 2021
     */
    @Test(
            groups = {"Core",
                      "HIKE-POS",
                      "Switch User",
                      "https://my.hikeup.com/"},
            priority = 1,
            description = "HIKE-29 : Create a new cashier user and apply permissions. verify that the user can only login to the store permissions was granted to."
    )
    @Owner("Vidhi Chapanera")
    @Feature("Feature : Switch User")
    @Severity(SeverityLevel.NORMAL)
    public void a_createNewCashierUserApplyPermissionsVerifyuserCanLogintotheStorePremissionGrantedto_29() throws IOException {

        if (flag > 0) {
            logger().getTest().setName("HIKE-29 : Create a new cashier user and apply permissions. verify that the user can only login to the store permissions was granted to.");
            logger().assignCategory("Switch User");
            logger().assignAuthor("Vidhi Chapanera");
        }

        CenterlizePO centerlizePO = PageFactory.initElements(driver, CenterlizePO.class);
        UsersPO.Users users = PageFactory.initElements(driver, UsersPO.Users.class);
        Users user = PageFactory.initElements(driver, Users.class);
        SwitchUser switchUser = PageFactory.initElements(driver, SwitchUser.class);

        //pre-condition
        new LoginTC(driver,0).a_verifyLoginFunctionalitydynamic_05();

        logger().log(LogStatus.INFO, "Execution start for HIKE-29");

        //Step-1 : click on Users button
        Assert.assertTrue(users.clickOnUsersButton(), "click on Users button");
        logger().log(LogStatus.PASS, "click on Users button", "Users button clicked");

        //Step-2 : click on Users button
        Assert.assertTrue(centerlizePO.clickOnButton(user.getUsersButton()), "click on Users button");
        logger().log(LogStatus.PASS, "click on Users button", "Users button clicked");

        //Step-3 : get user permissions and store name
        Assert.assertTrue(user.getUserPermissionsAndStoreName(), "get user permissions and store name");
        logger().log(LogStatus.PASS, "get user permissions and store name", "get user permissions and store name");

        //Step-4 : click on user profile picture icon
        Assert.assertTrue(centerlizePO.clickOnButton(switchUser.getUsersProfileIcon()), "click on user profile picture icon");
        logger().log(LogStatus.PASS, "click on user profile picture icon", "click on user profile picture icon");

        //Step-5 : click on switch user button
        Assert.assertTrue(centerlizePO.clickOnButton(switchUser.getSwitchUserButton()), "click on switch user button");
        logger().log(LogStatus.PASS, "click on switch user button", "click on switch user button");

        //Step-6 : switch user admin to cashier
        Assert.assertTrue(switchUser.switchUserAdmintoCashier(), "switch user admin to cashier");
        logger().log(LogStatus.PASS, "switch user admin to cashier", "switch user admin to cashier");

        //Step-7 : verify user switch successfully
        Assert.assertTrue(switchUser.verifyUserSwitchSuccessfully(), "verify user switch successfully");
        logger().log(LogStatus.PASS, "verify user switch successfully", "verify user switch successfully");

        //Step-8 : verify that the user can only login to the store permission was granted to
        Assert.assertTrue(switchUser.verifyUserCanOnlyloginPermissionWasGrantedto(), "verify that the user can only login to the store permission was granted to");
        logger().log(LogStatus.PASS, "verify that the user can only login to the store permission was granted to", "verify that the user can only login to the store permission was granted to");

    }
}
