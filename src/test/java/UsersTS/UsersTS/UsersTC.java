package UsersTS.UsersTS;

import CommonPO.CenterlizePO;
import Config.Base.BaseTest;
import Config.allure.AllureListener;
import LoginTS.LoginTC;
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

/**
 * @author Vidhi Chapanera
 * @date 22 January 2020
 */

@Listeners({AllureListener.class})
public class UsersTC extends BaseTest {

    public int flag = 1;

    public UsersTC() {
    }

    public UsersTC(WebDriver driver, int flag) {
        this.flag = flag;
        this.driver = driver;
    }


    /**
     * @author Vidhi Chapanera
     * @since 22 January 2020
     */
    @Test(
            groups = {"Core",
                      "HIKE-POS",
                      "Users",
                      "https://my.hikeup.com/"},
            priority = 1,
            description = "HIKE-08 : Add different 5 users in your demo store with admin, cashier and Manager."
    )
    @Owner("Vidhi Chapanera")
    @Feature("Feature : Users")
    @Severity(SeverityLevel.NORMAL)
    public void a_addDifferent5UsersInStoreLikeCashierAdminAndManager_08() throws IOException {

        if (flag > 0) {
            logger().getTest().setName("HIKE-08 : Add different 5 users in your demo store with admin, cashier and Manager.");
            logger().assignCategory("Users");
            logger().assignAuthor("Vidhi Chapanera");
        }

        CenterlizePO centerlizePO = PageFactory.initElements(driver, CenterlizePO.class);
        UsersPO.Users users = PageFactory.initElements(driver, UsersPO.Users.class);
        Users user = PageFactory.initElements(driver, Users.class);

        //pre-condition
        new LoginTC(driver,0).a_verifyLoginFunctionalitydynamic_05();

        logger().log(LogStatus.INFO, "Execution start for HIKE-08");

        //Step-1 : click on Users button
        Assert.assertTrue(users.clickOnUsersButton(), "click on Users button");
        logger().log(LogStatus.PASS, "click on Users button", "Users button clicked");

        //Step-2 : click on Users button 
        Assert.assertTrue(centerlizePO.clickOnButton(user.getUsersButton()), "click on Users button");
        //Assert.assertTrue(user.chnageSuperAdminPin());
        // Assert.assertTrue(user.clearAllNotification(), "click on Users button");
        logger().log(LogStatus.PASS, "click on Users button", "Users button clicked");

        //Step-3 : Add different 5 users
        Assert.assertTrue(user.addDifferentUsers(), "Add different 5 users");
        logger().log(LogStatus.PASS, "add different 5 users", "different 5 users added");

        //Step-4 : verify 5 different user created
        Assert.assertTrue(user.verifyCreatedUser(), "verify 5 different user created");
        logger().log(LogStatus.PASS, "verify 5 different user created", "5 different user created");
    }


    /**
     * @author Vidhi Chapanera
     * @since 25 January 2020
     */
    @Test(
            groups = {"Core",
                      "HIKE-POS",
                      "Users",
                      "https://my.hikeup.com/"},
            priority = 1,
            description = "HIKE-09 : Add different 3 roles for Cashier, manager, and admin users and assigned to existing users. Review that the roles are assigned correctly under existing users."
    )
    @Owner("Vidhi Chapanera")
    @Feature("Feature : Users")
    @Severity(SeverityLevel.NORMAL)
    public void b_addDifferentRoleAndAssingToExstingUsers_09() throws IOException {

        if (flag > 0) {
            logger().getTest().setName("HIKE-09 : Add different 3 roles for Cashier, manager, and admin users and assigned to existing users. Review that the roles are assigned correctly under existing users.");
            logger().assignCategory("Users");
            logger().assignAuthor("Vidhi Chapanera");
        }

        CenterlizePO centerlizePO = PageFactory.initElements(driver, CenterlizePO.class);
        UsersPO.Users users = PageFactory.initElements(driver, UsersPO.Users.class);
        Users user = PageFactory.initElements(driver, Users.class);

        //pre-condition
        //new LoginTC(driver,0).a_verifyLoginFunctionalitydynamic_05();

        logger().log(LogStatus.INFO, "Execution start for HIKE-09");

        //Step-1 : click on Users button
        Assert.assertTrue(users.clickOnUsersButton(), "click on Users button");
        logger().log(LogStatus.PASS, "click on Users button", "Users button clicked");

        //Step-2 : click on Users button
        Assert.assertTrue(centerlizePO.clickOnButton(user.getUsersButton()), "click on Users button");
        logger().log(LogStatus.PASS, "click on Users button", "Users button clicked");

        //Step-3 : Add different 5 users
        Assert.assertTrue(user.addDifferentRoleToExstingUsers(), "Add different 5 users");
        logger().log(LogStatus.PASS, "add different 5 users", "different 5 users added");

        //Step-4 : verify multiple role created
        Assert.assertTrue(user.verifyMultipleRoleCreated(), "verify multiple role created");
        logger().log(LogStatus.PASS, "verify multiple role created", "multiple role created");

        //Step-5 : Review that created roles are assigned correctly under existing users
        Assert.assertTrue(user.reviewCreatedRoleAssignedCorrectly(), "Review that created roles are assigned correctly under existing users");
        logger().log(LogStatus.PASS, "Review that created roles are assigned correctly under existing users", "Review that created roles are assigned correctly under existing users");

    }


    /**
     * @author Vidhi Chapanera
     * @since 27 January 2020
     */
    @Test(
            groups = {"Core",
                      "HIKE-POS",
                      "Users",
                      "https://my.hikeup.com/"},
            priority = 1,
            description = "HIKE-10 : Delete existing roles in any of the user and review there is no error in existing users. when reopen and save users."
    )
    @Owner("Vidhi Chapanera")
    @Feature("Feature : Users")
    @Severity(SeverityLevel.NORMAL)
    public void c_deleteExistingRoleInAnyUser_10() throws IOException {

        if (flag > 0) {
            logger().getTest().setName("HIKE-10 : Delete existing roles in any of the user and review there is no error in existing users. when reopen and save users.");
            logger().assignCategory("Users");
            logger().assignAuthor("Vidhi Chapanera");
        }

        CenterlizePO centerlizePO = PageFactory.initElements(driver, CenterlizePO.class);
        UsersPO.Users users = PageFactory.initElements(driver, UsersPO.Users.class);
        Users user = PageFactory.initElements(driver, Users.class);

        //pre-condition
        //new LoginTC(driver,0).a_verifyLoginFunctionality_03();

        logger().log(LogStatus.INFO, "Execution start for HIKE-10");

        //Step-1 : click on Users button
        Assert.assertTrue(users.clickOnUsersButton(), "click on Users button");
        logger().log(LogStatus.PASS, "click on Users button", "Users button clicked");

        //Step-2 : click on Users button
        Assert.assertTrue(centerlizePO.clickOnButton(user.getUsersButton()), "click on Users button");
        logger().log(LogStatus.PASS, "click on Users button", "Users button clicked");

        //Step-3 : Delete existing roles in any of the user
        Assert.assertTrue(user.deleteExistingRole(), "Delete existing roles in any of the user");
        logger().log(LogStatus.PASS, "Delete existing roles in any of the user", "existing roles Delete");

        //Step-4 : review there is no error in existing users
        //when reopen and save users.
        Assert.assertTrue(user.reviewExistingUsersWhenReopen(), "review there is no error in existing users\n" +
                "when reopen and save users.\n");
        logger().log(LogStatus.PASS, "review there is no error in existing users\n" +
                "when reopen and save users.\n", "review there is no error in existing users\n" +
                "when reopen and save users.\n");

    }


    /**
     * @author Vidhi Chapanera
     * @since 06 January 2022
     */
    @Test(
            groups = {"Core",
                      "HIKE-POS",
                      "Users",
                      "https://my.hikeup.com/"},
            priority = 1,
            description = "HIKE-112 : Create one User And Deactivate that one and Verify user should not display in switch user screen and clock in out screen"
    )
    @Owner("Vidhi Chapanera")
    @Feature("Feature : Users")
    @Severity(SeverityLevel.NORMAL)
    public void d_UserDeactivation_112() throws IOException {

        if (flag > 0) {
            logger().getTest().setName("HIKE-112 : Create one User And Deactivate that one and Verify user should not display in switch user screen and clock in out screen");
            logger().assignCategory("Users");
            logger().assignAuthor("Vidhi Chapanera");
        }

        CenterlizePO centerlizePO = PageFactory.initElements(driver, CenterlizePO.class);
        UsersPO.Users users = PageFactory.initElements(driver, UsersPO.Users.class);
        Users user = PageFactory.initElements(driver, Users.class);

        //pre-condition
        new LoginTC(driver,0).a_verifyLoginFunctionalitydynamic_05();

        logger().log(LogStatus.INFO, "Execution start for HIKE-112");

        //Step-1 : click on Users button
        Assert.assertTrue(users.clickOnUsersButton(), "click on Users button");
        logger().log(LogStatus.PASS, "click on Users button", "Users button clicked");

        //Step-2 : click on Users button
        Assert.assertTrue(centerlizePO.clickOnButton(user.getUsersButton()), "click on Users button");
        logger().log(LogStatus.PASS, "click on Users button", "Users button clicked");

        //Step-3 : Verify after deactivation user should not display in switch user screen and clock in out screen
        Assert.assertTrue(user.UserDeactivationFunctionality(), "Verify after deactivation user should not display in switch user screen and clock in out screen");
        logger().log(LogStatus.PASS, "Verify after deactivation user should not display in switch user screen and clock in out screen", "Verify after deactivation user should not display in switch user screen and clock in out screen");

    }




}