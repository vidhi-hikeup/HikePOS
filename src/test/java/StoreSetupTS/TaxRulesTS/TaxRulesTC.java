package StoreSetupTS.TaxRulesTS;

import CommonPO.CenterlizePO;
import Config.Base.BaseTest;
import Config.allure.AllureListener;
import LoginTS.LoginTC;
import StoreSetupPO.StoreSetup;
import StoreSetupPO.TaxRulesPO.TaxRules;
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
 * @date 17 March 2021
 */

@Listeners({AllureListener.class})
public class TaxRulesTC extends BaseTest {

    public int flag = 1;

    public TaxRulesTC() {
    }

    public TaxRulesTC(WebDriver driver, int flag) {
        this.flag = flag;
        this.driver = driver;
    }


    /**
     * @author Vidhi Chapanera
     * @since 17 March 2021
     */
    @Test(
            groups = {"Core",
                      "HIKE-POS",
                      "Store Setup",
                      "https://my.hikeup.com/"},
            priority = 1,
            description = "HIKE-66 : Create a new: - Category - Tax (20%) - Custom payment type - Brand and; - Tag"
    )
    @Owner("Vidhi Chapanera")
    @Feature("Feature : Store Setup")
    @Severity(SeverityLevel.NORMAL)
    public void a_verifyTaxFunctionality_66() throws IOException {

        if (flag > 0) {
            logger().getTest().setName("HIKE-66 : Create a new: - Category - Tax (20%) - Custom payment type - Brand and; - Tag");
            logger().assignCategory("Store Setup");
            logger().assignAuthor("Vidhi Chapanera");
        }

        CenterlizePO centerlizePO = PageFactory.initElements(driver, CenterlizePO.class);
        StoreSetup storeSetup = PageFactory.initElements(driver, StoreSetup.class);
        TaxRules taxRules = PageFactory.initElements(driver, TaxRules.class);

        //pre-condition
        new LoginTC(driver,0).a_verifyLoginFunctionalitydynamic_05();

        logger().log(LogStatus.INFO, "Execution start for HIKE-66");

        //Step-1 : click on store setup button
        Assert.assertTrue(storeSetup.clickOnStoreSetupButton(), "click on store setup button");
        logger().log(LogStatus.PASS, "click on store setup button", "store setup button clicked");

        //Step-2 : click on Tax Rules button
        Assert.assertTrue(centerlizePO.clickOnButton(taxRules.getTaxRules()), "click on Tax Rules button");
        logger().log(LogStatus.PASS, "click on Tax Rules button", "Tax Rules button clicked");

        //Step-3 : add new tax rule
        Assert.assertTrue(taxRules.createTax(), "add new tax rule");
        logger().log(LogStatus.PASS, "add new tax rule", "add new tax rule");

    }


}