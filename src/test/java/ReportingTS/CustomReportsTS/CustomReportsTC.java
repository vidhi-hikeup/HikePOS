package ReportingTS.CustomReportsTS;

import CommonPO.CenterlizePO;
import Config.Base.BaseTest;
import Config.allure.AllureListener;
import LoginTS.LoginTC;
import ReportingPO.CustomReportsPO.CustomReports;
import ReportingPO.Reporting;
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
 * @date 11 March 2021
 */

@Listeners({AllureListener.class})
public class CustomReportsTC extends BaseTest {

    public int flag = 1;

    public CustomReportsTC() {
    }

    public CustomReportsTC(WebDriver driver, int flag) {
        this.flag = flag;
        this.driver = driver;
    }


    /**
     * @author Vidhi Chapanera
     * @since 11 March 2021
     */
    @Test(
            groups = {"Core",
                      "HIKE-POS",
                      "Reporting",
                      "https://my.hikeup.com/"},
            priority = 1,
            description = "HIKE-51 : Verify Custom Fields Functionlity"
    )
    @Owner("Vidhi Chapanera")
    @Feature("Feature : Reporting")
    @Severity(SeverityLevel.NORMAL)
    public void a_verifyCustomReportsFunctionality_51() throws IOException {

        if (flag > 0) {
            logger().getTest().setName("HIKE-51 : Verify Custom Fields Functionlity");
            logger().assignCategory("Reporting");
            logger().assignAuthor("Vidhi Chapanera");
        }

        CenterlizePO centerlizePO = PageFactory.initElements(driver, CenterlizePO.class);
        Reporting reporting = PageFactory.initElements(driver, Reporting.class);
        CustomReports custom = PageFactory.initElements(driver, CustomReports.class);

        //pre-condition
        new LoginTC(driver,0).a_verifyLoginFunctionalitydynamic_05();

        logger().log(LogStatus.INFO, "Execution start for HIKE-51");

        //Step-1 : click on Reporting button
        Assert.assertTrue(reporting.clickOnReportingButton(), "click on Reporting button");
        logger().log(LogStatus.PASS, "click on Reporting button", "Reporting button clicked");

        //Step-2 : click on custom report button
        Assert.assertTrue(centerlizePO.clickOnButton(custom.getCustomReportsButton()), "click on custom report button");
        logger().log(LogStatus.PASS, "click on custom report button", "custom report button clicked");

        //Step-3 : add Custom Reports
        Assert.assertTrue(custom.addCustomRepots(), "add Custom Reports");
        logger().log(LogStatus.PASS,"add Custom Reports","add Custom Reports");

        //Step-4 : click on download button
        Assert.assertTrue(centerlizePO.clickOnButton(custom.getDownloadButton()), "click on download button");
        centerlizePO.sleepFor(50);
        logger().log(LogStatus.PASS,"click on download button","click on download button");

        //Step-5 : open downloaded pdf
        Assert.assertTrue(custom.openDownloadedPDf(), "open downloaded pdf");
        logger().log(LogStatus.PASS, "open downloaded pdf", "open downloaded pdf");
    }
}