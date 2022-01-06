package ChangePINTS;

import ChangePINPO.ChangePIN;
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
 * @date 26 October 2021
 */

@Listeners({AllureListener.class})
public class ChangePINTC extends BaseTest {

    public int flag = 1;

    public ChangePINTC() {
    }

    public ChangePINTC(WebDriver driver, int flag) {
        this.flag = flag;
        this.driver = driver;
    }


    /**
     * @author Vidhi Chapanera
     * @since 26 October 2021
     */
    @Test(
            groups = {"Core",
                      "HIKE-POS",
                      "Change PIN",
                      "https://my.hikeup.com/"},
            priority = 1,
            description = "HIKE-77 : Checked Option to change pin and review if user is able to switch user by using updated PIN."
    )
    @Owner("Vidhi Chapanera")
    @Feature("Feature : Change PIN")
    @Severity(SeverityLevel.NORMAL)
    public void ChangePINOption_77() throws IOException {

        if (flag > 0) {
            logger().getTest().setName("HIKE-77 : Checked Option to change pin and review if user is able to switch user by using updated PIN.");
            logger().assignCategory("Change PIN");
            logger().assignAuthor("Vidhi Chapanera");
        }

        CenterlizePO centerlizePO = PageFactory.initElements(driver, CenterlizePO.class);
        ChangePIN changePIN = PageFactory.initElements(driver, ChangePIN.class);

        //pre-condition
        new LoginTC(driver,0).a_verifyLoginFunctionalitydynamic_05();

        logger().log(LogStatus.INFO, "Execution start for HIKE-77");

        //Step-1 : click on User Icon
        Assert.assertTrue(centerlizePO.clickOnButton(changePIN.getCurrentUser()), "click on User Icon");
        logger().log(LogStatus.PASS, "click on User Icon", "click on User Icon");

        //Step-2 : click on change PIN button
        Assert.assertTrue(centerlizePO.clickOnButton(changePIN.getChangePINButton()), "click on change PIN button");
        logger().log(LogStatus.PASS, "click on change PIN button","click on change PIN button");

        //Step-3 : Change current User PIN
        Assert.assertTrue(changePIN.changeOldPIN(), "Change current User PIN");
        logger().log(LogStatus.PASS, "Change current User PIN", "Change current User PIN");

        //Step-4 : Verify New PIn is updated by swtiching between user
        Assert.assertTrue(changePIN.VerifyNewPIN(), "Verify New PIn is updated by swtiching between user");
        logger().log(LogStatus.PASS, "Verify New PIn is updated by swtiching between user","Verify New PIn is updated by swtiching between user");


    }

}