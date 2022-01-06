package ReportingTS.UsersTS;

import CommonPO.CenterlizePO;
import Config.Base.BaseTest;
import Config.allure.AllureListener;
import LoginTS.LoginTC;
import ReportingPO.Reporting;
import ReportingPO.UsersPO.Users;
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
 * @date 15 December 2020
 */

@Listeners({AllureListener.class})
public class UserTC extends BaseTest {

    public int flag = 1;

    public UserTC() {
    }

    public UserTC(WebDriver driver, int flag) {
        this.flag = flag;
        this.driver = driver;
    }


    /**
     * @author Vidhi Chapanera
     * @since 15 December 2020
     */
    @Test(
            groups = {"Core",
                      "HIKE-POS",
                      "Users",
                      "https://my.hikeup.com/"},
            priority = 1,
            description = "HIKE-98 : IP Address in Major Activity Log is as per machine IP"
    )
    @Owner("Vidhi Chapanera")
    @Feature("Feature : Users")
    @Severity(SeverityLevel.NORMAL)
    public void a_MajorActivityLog_98() throws IOException {

        if (flag > 0) {
            logger().getTest().setName("HIKE-98 : IP Address in Major Activity Log is as per machine IP");
            logger().assignCategory("Users");
            logger().assignAuthor("Vidhi Chapanera");
        }

        CenterlizePO centerlizePO = PageFactory.initElements(driver, CenterlizePO.class);
        Reporting reporting = PageFactory.initElements(driver,Reporting.class);
        Users users = PageFactory.initElements(driver,Users.class);

        //pre-condition
        new LoginTC(driver,0).a_verifyLoginFunctionalitydynamic_05();

        logger().log(LogStatus.INFO, "Execution start for HIKE-98");

        //Step-1 : click on Reporting button
        Assert.assertTrue(reporting.clickOnReportingButton(), "click on Reporting button");
        logger().log(LogStatus.PASS, "click on Reporting button", "Users Reporting clicked");

        //Step-2 : click on Users button 
        Assert.assertTrue(centerlizePO.clickOnButton(users.getUsersButton()), "click on Users button");
        logger().log(LogStatus.PASS, "click on Users button", "Users button clicked");

        //Step-3 : Verify IP Address in Major Activity Log is as per machine IP
        Assert.assertTrue(users.VerifyMajorActivityLog(), "IP Address in Major Activity Log is as per machine IP");
        logger().log(LogStatus.PASS, "IP Address in Major Activity Log is as per machine IP", "IP Address in Major Activity Log is as per machine IP");

    }




}