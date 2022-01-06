package UsersTS.UsersTS;

import Config.Base.BaseTest;
import Config.allure.AllureListener;
import LoginTS.LoginTC;
import UsersPO.UserPO.UsersOutletVisibility;
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
 * @date 12 August 2021
 */
@Listeners({AllureListener.class})
public class UsersOutletVisibilityTC extends BaseTest {

    public int flag = 1;

    public UsersOutletVisibilityTC() {
    }

    public UsersOutletVisibilityTC(WebDriver driver, int flag) {
        this.flag = flag;
        this.driver = driver;
    }

    /**
     * @author Vidhi Chapanera
     * @since 12 August 2021
     */
    @Test(
            groups = {"Core",
                      "HIKE-POS",
                      "Users",
                      "https://my.hikeup.com/"},
            priority = 1,
            description = "HIKE-74 : If user have 1 outlet permission only, it should not display other outlet visibility products in list and POS screen. "
    )
    @Owner("Vidhi Chapanera")
    @Feature("Feature : Users")
    @Severity(SeverityLevel.NORMAL)
    public void shouldDisplayonlyPermissionOutletVisibilityProductsInListAndPOSScreen_74() throws IOException {

        if (flag > 0) {
            logger().getTest().setName("HIKE-74 : If user have 1 outlet permission only, it should not display other outlet visibility products in list and POS screen. ");
            logger().assignCategory("Users");
            logger().assignAuthor("Vidhi Chapanera");
        }

        UsersOutletVisibility usersOutletVisibility = PageFactory.initElements(driver, UsersOutletVisibility.class);

        //pre-condition
        new LoginTC(driver,0).a_verifyLoginFunctionalitydynamic_05();

        logger().log(LogStatus.INFO, "Execution start for HIKE-74");

        //Step-1 : add multiple outlet
        Assert.assertTrue(usersOutletVisibility.addMultipleOutlet(), "add multiple outlet");
        logger().log(LogStatus.PASS, "add multiple outlet","add multiple outlet");

        //Step-2 : create product for particular outlet
        Assert.assertTrue(usersOutletVisibility.createProduct(), "create product for particular outlet");
        logger().log(LogStatus.PASS, "create product for particular outlet","create product for particular outlet");

        //Step-3 : close the cash register and open new register
        Assert.assertTrue(usersOutletVisibility.closeOldOneAndOpenNew(), "close the cash register and open new register");
        logger().log(LogStatus.PASS, "close the cash register and open new register","close the cash register and open new register");

        //Step-4 : verify Product visibility
        Assert.assertTrue(usersOutletVisibility.verifyProductVisibility(), "verify Product visibility");
        logger().log(LogStatus.PASS, "verify Product visibility","verify Product visibility");

        //Step-5 : verify Product InVisibility
        Assert.assertTrue(usersOutletVisibility.verifyProductInVisibility(), "verify Product InVisibility");
        Assert.assertTrue(usersOutletVisibility.verifyProductIsDisplay(), "verify Product InVisibility");
        logger().log(LogStatus.PASS, "verify Product InVisibility","verify Product InVisibility");
    }




}