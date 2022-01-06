package ClockInOutTS;

import ClockInOutPO.ClockInOut;
import CommonPO.CenterlizePO;
import Config.Base.BaseTest;
import Config.allure.AllureListener;
import LoginTS.LoginTC;
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
 * @date 28 January 2020
 */

@Listeners({AllureListener.class})
public class ClockInOutTC extends BaseTest {

    public int flag = 1;

    public ClockInOutTC() {
    }

    public ClockInOutTC(WebDriver driver, int flag) {
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
                      "ClockIn/Out ",
                      "https://my.hikeup.com/"},
            priority = 1,
            description = "HIKE-11 : Clocked in all user and review under user report, that user has logged In."
    )
    @Owner("Vidhi Chapanera")
    @Feature("Feature : ClockIn/Out")
    @Severity(SeverityLevel.NORMAL)
    public void clockInAllUserAndReviewUnderUserReport_11() throws IOException {

        if (flag > 0) {
            logger().getTest().setName("HIKE-11 : Clocked in all user and review under user report, that user has logged In.");
            logger().assignCategory("ClockIn/Out");
            logger().assignAuthor("Vidhi Chapanera");
        }

        CenterlizePO centerlizePO = PageFactory.initElements(driver, CenterlizePO.class);
        ClockInOut clockInOut = PageFactory.initElements(driver,ClockInOut.class);

        //pre-condition
        new LoginTC(driver,0).a_verifyLoginFunctionalitydynamic_05();

        logger().log(LogStatus.INFO, "Execution start for HIKE-11");

        //Step-1 : click on clock icon
       /* centerlizePO.sleepFor(10);
        Assert.assertTrue(pointofSale.clickOnPointOfSaleButtonn(), "click on Point of Sale button");
        centerlizePO.sleepFor(5);*/
        logger().log(LogStatus.PASS, "click on Point of Sale button", "Point of Sale button clicked");

        //Step-2 : click on Process Sale button
       /* Assert.assertTrue(centerlizePO.clickOnButton(processSale.getProcessSaleButton()), "click on Process Sale button");
        centerlizePO.sleepFor(20);*/
        Assert.assertTrue(centerlizePO.clickOnButton(clockInOut.getClockIcon()), "click on clock icon");
        logger().log(LogStatus.PASS, "click on clock icon", "clock icon clicked");

        //Step-2 : clock in all users
        Assert.assertTrue(clockInOut.clockInAllUsers(), "clock in all users");
        logger().log(LogStatus.PASS, "clock in all users","All users Clocked in");

        //Step-3 : get clock in users name and time
        Assert.assertTrue(clockInOut.getUsersNameAndTime(), "get clock in users name and time");
        logger().log(LogStatus.PASS, "get clock in users name and time","get clock in users name and time");

        //Step-4 : verify users log in reporting section
        Assert.assertTrue(clockInOut.verifyUsersLoginReportingSection(), "verify users log in reporting section");
        logger().log(LogStatus.PASS, "verify users log in reporting section","verify users log in reporting section");

    }

}