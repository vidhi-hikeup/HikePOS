package LoginTS;

import CommonPO.CenterlizePO;
import Config.Base.BaseTest;
import Config.allure.AllureListener;
import CreateStorePO.CreateStore;
import LoginPO.Login;
import LoginPO.LoginConstant;
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
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * @author Vidhi Chapanera
 * @date 18 January 2021
 */

@Listeners({AllureListener.class})
public class LoginTC extends BaseTest {

    public int flag = 1;

    public LoginTC() {
    }

    public LoginTC(WebDriver driver, int flag) {
        this.flag = flag;
        this.driver = driver;
    }

    /**
     * @author Vidhi Chapanera
     * @since 18 January 2021
     */
    @Test(
            groups = {"Core",
                      "HIKE-POS",
                      "Log In",
                      "https://my.hikeup.com/"},
            priority = 1,
            description = "HIKE-03 : Verify login Functionality"
    )
    @Owner("Vidhi Chapanera")
    @Feature("Feature : Log In")
    @Severity(SeverityLevel.NORMAL)
    public void a_verifyLoginFunctionality_03() throws IOException {

        if (flag > 0) {
            logger().getTest().setName("HIKE-03 : Verify login Functionality");
            logger().assignCategory("Log In");
            logger().assignAuthor("Vidhi Chapanera");
        }

        CenterlizePO centerlizePO = PageFactory.initElements(driver, CenterlizePO.class);
        Login login = PageFactory.initElements(driver, Login.class);

        String fileLocation = System.getProperty("user.dir") + "\\src\\main\\resources\\loginDetails.properties";
        Properties properties1 = new Properties();
        properties1.load(new FileReader(fileLocation));

        logger().log(LogStatus.INFO, "Execution start for HIKE-03");

        //Step-1 : enter account address
        Assert.assertTrue(centerlizePO.enterDataUsingSendkeys(login.getAccountAddressTextBox(), String.valueOf(properties1.put(LoginConstant.ACCOUNT_ADDRESS,"account_address"))), "enter account address");
        logger().log(LogStatus.PASS, "enter account address", "account address entered");

        //Step-2 : enter email 
        Assert.assertTrue(centerlizePO.enterDataUsingSendkeys(login.getEmailTextBox(), String.valueOf(properties1.put(LoginConstant.EMAIL_ADDRESS,"email_address"))), "enter email");
        logger().log(LogStatus.PASS, "enter email", "email entered");

        //Step-3 : enter password
        Assert.assertTrue(centerlizePO.enterDataUsingSendkeys(login.getpasswordTextBox(), String.valueOf(properties1.put(LoginConstant.PASSWORD,"password_1"))), "enter password");
        logger().log(LogStatus.PASS, "enter password", "password entered");

        //Step-4 : click on login button
        Assert.assertTrue(centerlizePO.clickOnButton(login.getLoginButton()), "click on login button");
        logger().log(LogStatus.PASS, "click on login button", "login button clicked");

        //Step-5 : verify hike logo is display after login you store
        Assert.assertTrue(centerlizePO.verifyElemntIsDisplay(login.getHikeLogo()), "verify hike logo is display after login you store");
        centerlizePO.sleepFor(3);
        Assert.assertTrue(centerlizePO.verifyTitle("POS"), "verify hike logo is display after login you store");
        logger().log(LogStatus.PASS, "verify hike logo is display after login you store", "hike logo displayed after login store");
    }


    /**
     * @author Vidhi Chapanera
     * @since 18 January 2021
     */
    @Test(
            groups = {"Core",
                      "HIKE-POS",
                      "Log In",
                      "https://my.hikeup.com/"},
            priority = 1,
            description = "HIKE-05 : Verify login Functionality(dynamic)"
    )
    @Owner("Vidhi Chapanera")
    @Feature("Feature : Log In")
    @Severity(SeverityLevel.NORMAL)
    public void a_verifyLoginFunctionalitydynamic_05() throws IOException {

        if (flag > 0) {
            logger().getTest().setName("HIKE-05 : Verify login Functionality(dynamic)");
            logger().assignCategory("Log In");
            logger().assignAuthor("Vidhi Chapanera");
        }

        CenterlizePO centerlizePO = PageFactory.initElements(driver, CenterlizePO.class);
        Login login = PageFactory.initElements(driver, Login.class);
        CreateStore createStore = PageFactory.initElements(driver, CreateStore.class);

        String fileLocation = System.getProperty("user.dir") + "\\src\\main\\resources\\loginDetails.properties";
        Properties properties1 = new Properties();
        properties1.load(new FileReader(fileLocation));

        logger().log(LogStatus.INFO, "Execution start for HIKE-05");

        //Step-1 : enter account address
        Assert.assertTrue(centerlizePO.enterDataUsingSendkeys(login.getAccountAddressTextBox(),createStore.getAddressValue()), "enter account address");
        logger().log(LogStatus.PASS, "enter account address", "account address entered");

        //Step-2 : enter email
        Assert.assertTrue(centerlizePO.enterDataUsingSendkeys(login.getEmailTextBox(), String.valueOf(properties1.put(LoginConstant.EMAIL_ADDRESS,"email_address"))), "enter email");
        logger().log(LogStatus.PASS, "enter email", "email entered");

        //Step-3 : enter password
        Assert.assertTrue(centerlizePO.enterDataUsingSendkeys(login.getpasswordTextBox(), String.valueOf(properties1.put(LoginConstant.PASSWORD,"password_1"))), "enter password");
        logger().log(LogStatus.PASS, "enter password", "password entered");

        //Step-4 : click on login button
        Assert.assertTrue(centerlizePO.clickOnButton(login.getLoginButton()), "click on login button");
        logger().log(LogStatus.PASS, "click on login button", "login button clicked");

        //Step-5 : verify hike logo is display after login you store
        Assert.assertTrue(centerlizePO.verifyElemntIsDisplay(login.getHikeLogo()), "verify hike logo is display after login you store");
        centerlizePO.sleepFor(3);
        //Assert.assertTrue(centerlizePO.verifyTitle("POS"), "verify hike logo is display after login you store");
        logger().log(LogStatus.PASS, "verify hike logo is display after login you store", "hike logo displayed after login store");
    }

}