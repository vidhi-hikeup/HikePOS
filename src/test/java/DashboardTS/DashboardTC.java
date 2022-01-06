package DashboardTS;

import Config.Base.BaseTest;
import Config.allure.AllureListener;
import DashboardPO.Dashboard;
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
 * @date 29 December 2021
 */

@Listeners({AllureListener.class})
public class DashboardTC extends BaseTest {

    public int flag = 1;
    public DashboardTC() {
    }

    public DashboardTC(WebDriver driver, int flag) {
        this.flag = flag;
        this.driver = driver;
    }


    /**
     * @author Vidhi Chapanera
     * @since 29 December 2021
     */
    @Test(
            /*enabled = false,*/
            groups = {"Core",
                      "HIKE-POS",
                      "Customers",
                      "https://my.hikeup.com/"},
            priority = 1,
            description = "HIKE-107 : Add Button Functionality On Dashboard Page"
    )
    @Owner("Vidhi Chapanera")
    @Feature("Feature : Customers")
    @Severity(SeverityLevel.NORMAL)
    public void a_AddButtonFunction_107() throws IOException {

        if (flag > 0) {
            logger().getTest().setName("HIKE-107 : Add Button Functionality On Dashboard Page");
            logger().assignCategory("Customers");
            logger().assignAuthor("Vidhi Chapanera");
        }

         Dashboard dashboard = PageFactory.initElements(driver,Dashboard.class);

        //pre-condition
        new LoginTC(driver,0).a_verifyLoginFunctionalitydynamic_05();

        logger().log(LogStatus.INFO, "Execution start for HIKE-107");

        //Step-1 : Verify Add Button Function
        Assert.assertTrue(dashboard.verifyAddButtonFunction(), "Verify Add Button Function");
        logger().log(LogStatus.PASS, "Verify Add Button Function","Verify Add Button Function");

    }



}
