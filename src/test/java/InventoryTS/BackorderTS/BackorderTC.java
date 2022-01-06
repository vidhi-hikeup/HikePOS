package InventoryTS.BackorderTS;

import CommonPO.CenterlizePO;
import Config.Base.BaseTest;
import Config.allure.AllureListener;
import InventoryPO.BackorderPO.Backorder;
import LoginTS.LoginTC;
import ProductsPO.Products;
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
 * @date 15 March 2021
 */

@Listeners({AllureListener.class})
public class BackorderTC extends BaseTest {

    public int flag = 1;

    public BackorderTC() {
    }

    public BackorderTC(WebDriver driver, int flag) {
        this.flag = flag;
        this.driver = driver;
    }

    /**
     * @author Vidhi Chapanera
     * @since 12 February 2021
     */
    @Test(
            groups = {"Core",
                      "HIKE-POS",
                      "Inventroy",
                      "https://my.hikeup.com/"},
            priority = 1,
            description = "HIKE-55 : Verify Backorder Functionality"
    )
    @Owner("Vidhi Chapanera")
    @Feature("Feature : Inventroy")
    @Severity(SeverityLevel.NORMAL)
    public void a_verifyBackorderFunctionality_55() throws IOException {

        if (flag > 0) {
            logger().getTest().setName("HIKE-55 : Verify Backorder Functionality");
            logger().assignCategory("Inventroy");
            logger().assignAuthor("Vidhi Chapanera");
        }

        CenterlizePO centerlizePO = PageFactory.initElements(driver, CenterlizePO.class);
        Products products = PageFactory.initElements(driver, Products.class);
        ProductsPO.ProductsPO.Products products1 = PageFactory.initElements(driver, ProductsPO.ProductsPO.Products.class);
        Backorder backorder = PageFactory.initElements(driver, Backorder.class);

        //pre-condition
        new LoginTC(driver,0).a_verifyLoginFunctionalitydynamic_05();

        logger().log(LogStatus.INFO, "Execution start for HIKE-55");

        //Step-1 : click on Products button
        Assert.assertTrue(products.clickOnProductsButtonn(), "click on Products button");
        logger().log(LogStatus.PASS, "click on Products button", "Products button clicked");

        //Step-2 : click on Products button
        Assert.assertTrue(centerlizePO.clickOnButton(products1.getProductButton()), "click on Products button");
        logger().log(LogStatus.PASS, "click on Products button", "Products button clicked");

        //Step-3 : add new product with empty stock
        Assert.assertTrue(backorder.addNewPRoductWithEmptyStock(), "add new product with empty stock");
        logger().log(LogStatus.PASS, "add new product with empty stock", "add new product with empty stock");

    }


    /**
     * @author Vidhi Chapanera
     * @since 12 February 2021
     */
    @Test(
            groups = {"Core",
                      "HIKE-POS",
                      "Inventroy",
                      "https://my.hikeup.com/"},
            priority = 1,
            description = "HIKE-56 : Verify backordered line items to an existing PO Functionality"
    )
    @Owner("Vidhi Chapanera")
    @Feature("Feature : Inventroy")
    @Severity(SeverityLevel.NORMAL)
    public void b_verifyBackorderLineItemToExstingPOFunctionality_56() throws IOException {

        if (flag > 0) {
            logger().getTest().setName("HIKE-56 : Verify backordered line items to an existing PO Functionality");
            logger().assignCategory("Inventroy");
            logger().assignAuthor("Vidhi Chapanera");
        }

        //pre-condition
        //new LoginTC(driver,0).a_verifyLoginFunctionality_03();

        logger().log(LogStatus.INFO, "Execution start for HIKE-56");

        //Step-1 : click on Products button
        logger().log(LogStatus.PASS, "click on Products button", "Products button clicked");

        //Step-2 : click on Products button
        logger().log(LogStatus.PASS, "click on Products button", "Products button clicked");

        //Step-3 : verify backordered line items to an existing PO by adding new sale of empty stock product
        logger().log(LogStatus.PASS, "verify backordered line items to an existing PO by adding new sale of empty stock product", "verify backordered line items to an existing PO by adding new sale of empty stock product");


    }
}