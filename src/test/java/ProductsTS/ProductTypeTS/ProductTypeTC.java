package ProductsTS.ProductTypeTS;

import CommonPO.CenterlizePO;
import Config.Base.BaseTest;
import Config.allure.AllureListener;
import LoginTS.LoginTC;
import ProductsPO.ProductTypesPO.ProductTypes;
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
 * @date 02 February 2022
 */

@Listeners({AllureListener.class})
public class ProductTypeTC extends BaseTest {

    public int flag = 1;

    public ProductTypeTC() {
    }

    public ProductTypeTC(WebDriver driver, int flag) {
        this.flag = flag;
        this.driver = driver;
    }

    /**
     * @author Vidhi Chapanera
     * @since 02 February 2021
     */
    @Test(
            groups = {"Core",
                      "HIKE-POS",
                      "Products",
                      "https://my.hikeup.com/"},
            priority = 1,
            description = "HIKE-60 : Verify low stock inventory Option in PO"
    )
    @Owner("Vidhi Chapanera")
    @Feature("Feature : Products")
    @Severity(SeverityLevel.NORMAL)
    public void a_verifyProductTypeFilterFunctionality_60() throws IOException {

        if (flag > 0) {
            logger().getTest().setName("HIKE-60 : verify Product Type Filter Functionality");
            logger().assignCategory("Products");
            logger().assignAuthor("Vidhi Chapanera");
        }

        ProductTypes productTypes = PageFactory.initElements(driver, ProductTypes.class);

        //pre-condition
        new LoginTC(driver,0).a_verifyLoginFunctionalitydynamic_05();

        logger().log(LogStatus.INFO, "Execution start for HIKE-60");

        //Step-1 : click on Products button
        logger().log(LogStatus.PASS, "click on Products button", "Products button clicked");

        //Step-2 : click on Products button
        logger().log(LogStatus.PASS, "click on Products button", "Products button clicked");

        //Step-3 : Linked type: brand: tags create new product and assign product type, tag and
        //brand. Now go to product type page and click on assigned product count number ,
        //it should be filter automatically with select product type associate product
        Assert.assertTrue(productTypes.filterProductType(), "Linked type: brand: tags create new product and assign product type, tag and\n" +
                "brand. Now go to product type page and click on assigned product count number ,\n" +
                "it should be filter automatically with select product type associate productr");
        logger().log(LogStatus.PASS, "Linked type: brand: tags create new product and assign product type, tag and\n" +
                "brand. Now go to product type page and click on assigned product count number ,\n" +
                "it should be filter automatically with select product type associate product", "Linked type: brand: tags create new product and assign product type, tag and\n" +
                "brand. Now go to product type page and click on assigned product count number ,\n" +
                "it should be filter automatically with select product type associate product");
    }


    /**
     * @author Vidhi Chapanera
     * @since 13 December 2021
     */
    @Test(
            groups = {"Core",
                      "HIKE-POS",
                      "Products",
                      "https://my.hikeup.com/"},
            priority = 1,
            description = "HIKE-97 : General - Hide product type (category) if it has no products"
    )
    @Owner("Vidhi Chapanera")
    @Feature("Feature : Products")
    @Severity(SeverityLevel.NORMAL)
    public void b_verifyOptionOfHideProductTypeifithasnoProduct_97() throws IOException {

        if (flag > 0) {
            logger().getTest().setName("HIKE-97 : General - Hide product type (category) if it has no products");
            logger().assignCategory("Products");
            logger().assignAuthor("Vidhi Chapanera");
        }

        CenterlizePO centerlizePO = PageFactory.initElements(driver, CenterlizePO.class);
        Products products = PageFactory.initElements(driver, Products.class);
        ProductTypes productTypes = PageFactory.initElements(driver, ProductTypes.class);

        //pre-condition
        //new LoginTC(driver,0).a_verifyLoginFunctionalitydynamic_05();

        logger().log(LogStatus.INFO, "Execution start for HIKE-97");

        //Step-1 : click on Products button
        Assert.assertTrue(products.clickOnProductsButtonn(), "click on Products button");
        logger().log(LogStatus.PASS, "click on Products button", "Product Type button clicked");

        //Step-2 : click on Product Type button
        Assert.assertTrue(centerlizePO.clickOnButton(productTypes.getProductTypesButton()), "click on Product Types button");
        logger().log(LogStatus.PASS, "click on Product Types button", "Product Type button clicked");

       //Step-3 : General - Hide product type (category) if it has no products
        Assert.assertTrue(productTypes.hideProductType(),"General - Hide product type (category) if it has no products");
        logger().log(LogStatus.PASS,"General - Hide product type (category) if it has no products","General - Hide product type (category) if it has no products");
    }



    /**
     * @author Vidhi Chapanera
     * @since 04 January 2022
     */
    @Test(
            groups = {"Core",
                      "HIKE-POS",
                      "Products",
                      "https://my.hikeup.com/"},
            priority = 1,
            description = "HIKE-110 : Deactivate Product Type And Verify should not display in POS Screen , Add Product Page and Parent Type Drop Down"
    )
    @Owner("Vidhi Chapanera")
    @Feature("Feature : Products")
    @Severity(SeverityLevel.NORMAL)
    public void c_DeactivateProductTypeAndVerifyShouldNotDisplayInPOSScreen_110() throws IOException {

        if (flag > 0) {
            logger().getTest().setName("HIKE-110 : Deactivate Product Type And Verify should not display in POS Screen , Add Product Page and Parent Type Drop Down");
            logger().assignCategory("Products");
            logger().assignAuthor("Vidhi Chapanera");
        }

        CenterlizePO centerlizePO = PageFactory.initElements(driver, CenterlizePO.class);
        Products products = PageFactory.initElements(driver, Products.class);
        ProductTypes productTypes = PageFactory.initElements(driver, ProductTypes.class);

        //pre-condition
        //new LoginTC(driver,0).a_verifyLoginFunctionalitydynamic_05();

        logger().log(LogStatus.INFO, "Execution start for HIKE-110");

        //Step-1 : click on Products button
        Assert.assertTrue(products.clickOnProductsButtonn(), "click on Products button");
        logger().log(LogStatus.PASS, "click on Products button", "Product Type button clicked");

        //Step-2 : click on Product Type button
        Assert.assertTrue(centerlizePO.clickOnButton(productTypes.getProductTypesButton()), "click on Product Types button");
        logger().log(LogStatus.PASS, "click on Product Types button", "Product Type button clicked");

        //Step-3 :  Deactivate Product Type And Verify should not display in POS Screen
        Assert.assertTrue(productTypes.deactivateProuctType()," Deactivate Product Type And Verify should not display in POS Screen ");
        logger().log(LogStatus.PASS," Deactivate Product Type And Verify should not display in POS Screen "," Deactivate Product Type And Verify should not display in POS Screen ");
    }
}
