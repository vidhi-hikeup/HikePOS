package ChangePasswordTS;

import ChangePasswordPO.ChangePassword;
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
 * @date 28 October 2021
 */

@Listeners({AllureListener.class})
public class   ChangePasswordTC extends BaseTest {

    public int flag = 1;

    public ChangePasswordTC() {
    }

    public ChangePasswordTC(WebDriver driver, int flag) {
        this.flag = flag;
        this.driver = driver;
    }


    /**
     * @author Vidhi Chapanera
     * @since 28 October 2021
     */
    @Test(
            groups = {"Core",
                      "HIKE-POS",
                      "Change Password",
                      "https://my.hikeup.com/"},
            priority = 1,
            description = "HIKE-82 : Checked Option to change Password and review if user is able to login by using updated Password"
    )
    @Owner("Vidhi Chapanera")
    @Feature("Feature : Change Password")
    @Severity(SeverityLevel.NORMAL)
    public void ChangePassword_82() throws IOException {

        if (flag > 0) {
            logger().getTest().setName("HIKE-82 : Checked Option to change Password and review if user is able to login by using updated Password");
            logger().assignCategory("Change Password");
            logger().assignAuthor("Vidhi Chapanera");
        }

        CenterlizePO centerlizePO = PageFactory.initElements(driver, CenterlizePO.class);
        ChangePassword changePassword = PageFactory.initElements(driver, ChangePassword.class);

        //pre-condition
        new LoginTC(driver,0).a_verifyLoginFunctionalitydynamic_05();

        logger().log(LogStatus.INFO, "Execution start for HIKE-82");

        //Step-1 : click on User Icon
        Assert.assertTrue(centerlizePO.clickOnButton(changePassword.getCurrentUser()), "click on User Icon");
        logger().log(LogStatus.PASS, "click on User Icon", "click on User Icon");

        //Step-2 : click on change Password button
        Assert.assertTrue(centerlizePO.clickOnButton(changePassword.getChangePasswordButton()), "click on change Password button");
        logger().log(LogStatus.PASS, "click on change Password button","click on change Password button");

        //Step-3 : Change current User Password
        Assert.assertTrue(changePassword.changeOldPassword(), "Change current User Password");
        logger().log(LogStatus.PASS, "Change current User Password", "Change current User Password");

        //Step-4 : Verify New Password is updated by using login again
        Assert.assertTrue(changePassword.VerifyNewPassword(), "Verify New Password is updated by using login again");
        logger().log(LogStatus.PASS, "Verify New Password is updated by using login again","Verify New Password is updated by using login again");


    }

}