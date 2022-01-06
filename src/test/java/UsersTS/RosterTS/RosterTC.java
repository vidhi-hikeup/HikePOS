package UsersTS.RosterTS;

import CommonPO.CenterlizePO;
import Config.Base.BaseTest;
import Config.allure.AllureListener;
import LoginTS.LoginTC;
import UsersPO.RosterPO.Roster;
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
 * @date 22 February 2020
 */

@Listeners({AllureListener.class})
public class RosterTC extends BaseTest {

    public int flag = 1;

    public RosterTC() {
    }

    public RosterTC(WebDriver driver, int flag) {
        this.flag = flag;
        this.driver = driver;
    }

    /**
     * @author Vidhi Chapanera
     * @since 22 February 2020
     */
    @Test(
            groups = {"Core",
                      "HIKE-POS",
                      "Users",
                      "https://my.hikeup.com/"},
            priority = 1,
            description = "HIKE-36 : Verify Roster Functionality"
    )
    @Owner("Vidhi Chapanera")
    @Feature("Feature : Users")
    @Severity(SeverityLevel.NORMAL)
    public void a_verifyRosterFunctionality_36() throws IOException {

        if (flag > 0) {
            logger().getTest().setName("HIKE-36 : Verify Roster Functionality");
            logger().assignCategory("Users");
            logger().assignAuthor("Vidhi Chapanera");
        }

        CenterlizePO centerlizePO = PageFactory.initElements(driver, CenterlizePO.class);
        UsersPO.Users users = PageFactory.initElements(driver, UsersPO.Users.class);
        Roster roster = PageFactory.initElements(driver, Roster.class);

        //pre-condition
        new LoginTC(driver,0).a_verifyLoginFunctionalitydynamic_05();

        logger().log(LogStatus.INFO, "Execution start for HIKE-36");

        //Step-1 : click on Users button
        Assert.assertTrue(users.clickOnUsersButton(), "click on Users button");
        logger().log(LogStatus.PASS, "click on Users button", "Users button clicked");

        //Step-2 : click on Roster button
        Assert.assertTrue(centerlizePO.clickOnButton(roster.getRosterButton()), "click on Roster button");
        logger().log(LogStatus.PASS, "click on Roster button", "Roster button clicked");

        //Step-3 : Add Usual hours template
        Assert.assertTrue(roster.addUsualHoursTemplateForStaffMember(), "Add Usual hours template");
        logger().log(LogStatus.PASS, "Usual hours template", "Usual hours template");

        //Step-4 : verify added staff member in-out time
        Assert.assertTrue(roster.verifyStaffMemberInOutTime(), "verify added staff member in-out time  ");
        logger().log(LogStatus.PASS, "verify added staff member in-out time  ", "verify added staff member in-out time  ");
    }
    
}