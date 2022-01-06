package IntegrationsTS.NetoTS;

import Config.Base.BaseTest;
import Config.allure.AllureListener;
import IntegrationsPO.NetoPO.Neto;
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
 * @date 29 April 2021
 */
@Listeners({AllureListener.class})
public class NetoTC extends BaseTest {

    public int flag = 1;

    public NetoTC() {
    }

    public NetoTC(WebDriver driver, int flag) {
        this.flag = flag;
        this.driver = driver;
    }

    /**
     * @author Vidhi Chapanera
     * @date 29 April 2021
     */
    @Test(groups = {"Core", "HIKE-POS", "Integrations", "Neto","https://my.hikeup.com/"}, priority = 1, description = "HIKE-72 : Automate Neto Integration")
    @Owner("Vidhi Chapanera")
    @Feature("Feature : Integrations,Neto")
    @Severity(SeverityLevel.NORMAL)
    public void netoIntegrations_72() throws IOException {
        if (flag > 0) {
            logger().getTest().setName( "HIKE-72 : Automate Neto Integration" );
            logger().assignCategory( "Integrations, Neto" );
            logger().assignAuthor( "Vidhi Chapanera" );
        }

        Neto neto = PageFactory.initElements( driver, Neto.class );

        //pre-condition
        //new LoginTC(driver,0).a_verifyLoginFunctionality_03();

        logger().log( LogStatus.INFO, "Execution start for HIKE-72" );

        //Step-1 : create hike store for Neto
        //Assert.assertTrue( neto.createHikeStoreForNeto(), "create hike store for Neto" );
        logger().log( LogStatus.PASS, "create hike store for Neto", "create hike store for Neto" );

        //Step-2 : click on activate button on Neto
        //Assert.assertTrue( neto.clickOnActivateButtonOnNeto(), "click on activate button on Neto" );
        logger().log( LogStatus.PASS, "click on activate button on Neto", "click on activate button on Neto" );

        //Step-3 : create Neto store
        //Assert.assertTrue( neto.createNetoStore(), "create Neto store" );
        logger().log( LogStatus.PASS, "create Neto store", "create Neto store" );

        //Step-4 : connect your neto store to hikeup
        //Assert.assertTrue( neto.connectYourNetotoHike(), "connect your neto store to hikeup" );
        logger().log( LogStatus.PASS, "connect your neto store to hikeup", "connect your neto store to hikeup" );


        /**
         * @date 30 April 2021
         */
        //Step-5 : mapping Neto
        //Assert.assertTrue(neto.mappingNeto(), "mapping Neto");
        logger().log(LogStatus.PASS, "mapping Neto ", "mapping Neto");

        //Step-6 : create Product Hike to Neto and verify in Neto
        //Assert.assertTrue(neto.createProductHiketoNeto(), "create Product Hike to Neto and verify in Neto");
        logger().log(LogStatus.PASS, "create Product Hike to Neto and verify in Neto", "create Product Hike to Neto and verify in Neto");

        //Step-7 : create Product Neto to hike and verify in Hike
        //ssert.assertTrue(neto.createProductNetotoHike(), "create Product Neto to hike and verify in Hike");
        logger().log(LogStatus.PASS, "create Product Neto to hike and verify in Hike", "create Product Hike to Neto and verify in Neto");

        //Step-8 : create Customer Hike to Neto and verify in Neto
        //Assert.assertTrue(neto.createCustomersHiketoNeto(), "create Customer Hike to Neto and verify in Neto");
        logger().log(LogStatus.PASS, "create Customer Hike to Neto and verify in Neto", "create Customer Hike to Neto and verify in Neto");

        //Step-9 : create Customer Neto to hike and verify in Hike
        //Assert.assertTrue(neto.createCustomersNetotoHike(), "create Customer Neto to hike and verify in Hike");
        logger().log(LogStatus.PASS, "create Customer Neto to hike and verify in Hike", "create Customer Neto to hike and verify in Hike");


        /**
         * @date 3 May 2021
         */
        //Step-10 : create Sale Hike to Neto and verify in Neto
        //Assert.assertTrue(neto.createSaleHiketoNeto(), "create Sale Hike to Neto and verify in Neto");
        logger().log(LogStatus.PASS, "create Sale Hike to Neto and verify in Neto", "create Sale Hike to Neto and verify in Neto");

        //Step-11 : create Sale Neto to hike and verify in Hike
        //Assert.assertTrue(neto.createSaleNetoToHike(), "create Sale Neto to hike and verify in Hike");
        Assert.assertTrue(neto.automateNeto(), "create Sale Neto to hike and verify in Hike");
        logger().log(LogStatus.PASS, "create Sale Neto to hike and verify in Hike", "create Sale Neto to hike and verify in Hike");


    }

}
