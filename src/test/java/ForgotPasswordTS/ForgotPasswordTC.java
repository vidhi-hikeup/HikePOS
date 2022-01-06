package ForgotPasswordTS;

import CommonPO.CenterlizePO;
import Config.Base.BaseTest;
import Config.allure.AllureListener;
import DashboardPO.Dashboard;
import ForgotPasswordPO.ForgotPassword;
import LoginTS.LoginTC;
import PointofSalePO.ProcessSalePO.ProcessSale;
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
 * @date 30 December 2021
 */

@Listeners({AllureListener.class})
public class ForgotPasswordTC extends BaseTest {

    public int flag = 1;
    public ForgotPasswordTC() {
    }

    public ForgotPasswordTC(WebDriver driver, int flag) {
        this.flag = flag;
        this.driver = driver;
    }


    /**
     * @author Vidhi Chapanera
     * @since 30 December 2021
     */
    @Test(
            /*enabled = false,*/
            //dependsOnMethods = {"h_verifyWelcomeEmailToNewEmployeeEmailTemplate_46"},
            groups = {"Core",
                      "HIKE-POS",
                      "Customers",
                      "https://my.hikeup.com/"},
            priority = 1,
            description = "HIKE-108 : Forgot Password Function"
    )
    @Owner("Vidhi Chapanera")
    @Feature("Feature : Customers")
    @Severity(SeverityLevel.NORMAL)
    public void forgotPassword_108() throws IOException {

        if (flag > 0) {
            logger().getTest().setName("HIKE-108 : Forgot Password Function");
            logger().assignCategory("Customers");
            logger().assignAuthor("Vidhi Chapanera");
        }

        ForgotPassword forgotPassword = PageFactory.initElements(driver,ForgotPassword.class);
        CenterlizePO centerlizePO = PageFactory.initElements(driver,CenterlizePO.class);

        //pre-condition
        new LoginTC(driver,0).a_verifyLoginFunctionalitydynamic_05();

        logger().log(LogStatus.INFO, "Execution start for HIKE-108");

        //Step-1 : Create User
        Assert.assertTrue(forgotPassword.addUser(),"Create user");
        logger().log(LogStatus.PASS, "Create user","Create user");

        //Step-2 : Click on forgot Button
        Assert.assertTrue(centerlizePO.clickOnButton(forgotPassword.getForgot()), "Click on forgot Button");
        logger().log(LogStatus.PASS, "Click on forgot Button","Click on forgot Button");

        //Step-3 : enter user email
        Assert.assertTrue(centerlizePO.enterDataUsingSendkeys(forgotPassword.getEmailAddress(),forgotPassword.testEmail), "enter user email");
        logger().log(LogStatus.PASS, "enter user email","enter user email");

        //Step-4 : click on send email button
        Assert.assertTrue(centerlizePO.clickOnButton(forgotPassword.getSendEmailButton()), "click on send email button");
        logger().log(LogStatus.PASS, "click on send email button","click on send email button");

        //Step-5 : Verify Success message Popup is displayed
        centerlizePO.sleepFor(15);
        Assert.assertTrue(forgotPassword.getSucessMessage().isDisplayed());
        logger().log(LogStatus.PASS, "Verify Success message Popup is displayed","Verify Success message Popup is displayed");

        //Step-6 : click on ok button
        Assert.assertTrue(centerlizePO.clickOnButton(PageFactory.initElements(driver, ProcessSale.class).getOkButton()),"click on ok button");
        logger().log(LogStatus.PASS, "Verify Success message Popup is displayed","Verify Success message Popup is displayed");

        //Step-7 : Reset Password
        Assert.assertTrue(forgotPassword.resetPassword(),"Reset Password");
        logger().log(LogStatus.PASS, "Reset Password","Reset Password");

    }



}
