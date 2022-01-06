package ReportingTS.PaymentsTS;

import CommonPO.CenterlizePO;
import Config.Base.BaseTest;
import Config.allure.AllureListener;
import LoginTS.LoginTC;
import PointofSalePO.PointofSale;
import PointofSalePO.SalesHistoryPO.SalesHistory;
import ReportingPO.PaymentsPO.Payments;
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
 * @date 06 December 2021
 */

@Listeners({AllureListener.class})
public class PaymentsTC extends BaseTest {

    public int flag = 1;

    public PaymentsTC() {
    }

    public PaymentsTC(WebDriver driver, int flag) {
        this.flag = flag;
        this.driver = driver;
    }


    /**
     * @author Vidhi Chapanera
     * @since 06 December 2021
     */
    @Test(
            groups = {"Core",
                      "HIKE-POS",
                      "Reporting",
                      "https://my.hikeup.com/"},
            priority = 1,
            description = "HIKE-92 : Remove Payment From Complete sale and Verify in Reporting Side"
    )
    @Owner("Vidhi Chapanera")
    @Feature("Feature : Reporting")
    @Severity(SeverityLevel.NORMAL)
    public void a_RemovePaymentFromComplateSale_92() throws IOException {

        if (flag > 0) {
            logger().getTest().setName("HIKE-92 : Remove Payment From Complete sale and Verify in Reporting Side");
            logger().assignCategory("Reporting");
            logger().assignAuthor("Vidhi Chapanera");
        }

        CenterlizePO centerlizePO = PageFactory.initElements(driver, CenterlizePO.class);
        SalesHistory salesHistory = PageFactory.initElements(driver, SalesHistory.class);
        PointofSale pointofSale = PageFactory.initElements(driver, PointofSale.class);
        Payments payments = PageFactory.initElements(driver, Payments.class);

        //pre-condition
        new LoginTC(driver,0).a_verifyLoginFunctionalitydynamic_05();

        logger().log(LogStatus.INFO, "Execution start for HIKE-92");

        //Step-1 : click on Point of sale button
        Assert.assertTrue(pointofSale.clickOnPointOfSaleButtonn(), "click on Point of sale button");
        logger().log(LogStatus.PASS, "click on Point of sale button", "Point of sale button clicked");

        //Step-2 : click on Sales history button
        Assert.assertTrue(centerlizePO.clickOnButton(salesHistory.getSalesHistoryButton()), "click on Sales history button");
        logger().log(LogStatus.PASS, "click on Sales history button", "Sales history button clicked");

        //Step-3 : open completed Sale And Remove Payment
        Assert.assertTrue(payments.removePaymentFromCompletedSale(), "open completed Sale And Remove Payment");
        logger().log(LogStatus.PASS,"open completed Sale And Remove Payment","Payment Removed");

        //Step-4 : Verify In Reporting Side
        Assert.assertTrue(payments.VerifySaleEnteryInReportingSide(), "Verify In Reporting Side");
        logger().log(LogStatus.PASS,"Verify In Reporting Side","Verify In Reporting Side");


    }
}