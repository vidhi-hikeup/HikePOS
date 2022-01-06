package ProductsTS.ProductsTS;

import CommonPO.CenterlizePO;
import Config.Base.BaseTest;
import Config.allure.AllureListener;
import LoginTS.LoginTC;
import ProductsPO.ProductsPO.Products;
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
 * @date 02 February 2021
 */

@Listeners({AllureListener.class})
public class ProductsTC extends BaseTest {

    public int flag = 1;

    public ProductsTC() {
    }

    public ProductsTC(WebDriver driver, int flag) {
        this.flag = flag;
        this.driver = driver;
    }

    /**
     * @author Vidhi Chapanera
     * @since 02 February 2021
     */
    @Test(
            enabled = false,
            groups = {"Core",
                      "HIKE-POS",
                      "Products",
                      "https://my.hikeup.com/"},
            priority = 1,
            description = "HIKE-12 : Successfully added new variant product with 3 colours and 3 sizes"
    )
    @Owner("Vidhi Chapanera")
    @Feature("Feature : Products")
    @Severity(SeverityLevel.NORMAL)
    public void a_addedNewVariantProductWithDifferentSizeandColour_12() throws IOException {

        if (flag > 0) {
            logger().getTest().setName("HIKE-12 : Successfully added new variant product with 3 colours and 3 sizes\n");
            logger().assignCategory("Products");
            logger().assignAuthor("Vidhi Chapanera");
        }

        CenterlizePO centerlizePO = PageFactory.initElements(driver, CenterlizePO.class);
        ProductsPO.Products products = PageFactory.initElements(driver, ProductsPO.Products.class);
        Products products1 = PageFactory.initElements(driver, Products.class);

        //pre-condition
        //new LoginTC(driver,0).a_verifyLoginFunctionality_03();

        logger().log(LogStatus.INFO, "Execution start for HIKE-12");

        //Step-1 : click on Products button
        Assert.assertTrue(products.clickOnProductsButtonn(), "click on Products button");
        logger().log(LogStatus.PASS, "click on Products button", "Products button clicked");

        //Step-2 : click on Products button
        Assert.assertTrue(centerlizePO.clickOnButton(products1.getProductButton()), "click on Products button");
        logger().log(LogStatus.PASS, "click on Products button", "Products button clicked");

        //Step-3 : add new variant product with Different Size and color
        Assert.assertTrue(products1.addMultipleVariantProduct(), "add new variant product with Different Size and color");
        logger().log(LogStatus.PASS, "add new variant product with Different Size and color", "add new variant product with Different Size and color");
    }


    /**
     * @author Vidhi Chapanera
     * @since 05 February 2021
     */
    @Test(
            enabled = false,
            groups = {"Core",
                      "HIKE-POS",
                      "Products",
                      "https://my.hikeup.com/"},
            priority = 1, description = "HIKE-15 : Create Multiple composite product and review in POS screen"
    )
    @Owner("Vidhi Chapanera")
    @Feature("Feature : Products")
    @Severity(SeverityLevel.NORMAL)
    public void b_CreateMultipleCompositeProductAndReviewInPOSScreen_15() throws IOException {

        if (flag > 0) {
            logger().getTest().setName("HIKE-15 : Create Multiple composite product and review in POS screen");
            logger().assignCategory("Products");
            logger().assignAuthor("Vidhi Chapanera");
        }

        CenterlizePO centerlizePO = PageFactory.initElements(driver, CenterlizePO.class);
        ProductsPO.Products products = PageFactory.initElements(driver, ProductsPO.Products.class);
        Products products1 = PageFactory.initElements(driver, Products.class);

        //pre-condition
        //new LoginTC(driver,0).a_verifyLoginFunctionality_03();

        logger().log(LogStatus.INFO, "Execution start for HIKE-15");

        //Step-1 : click on Products button
        Assert.assertTrue(products.clickOnProductsButtonn(), "click on Products button");
        logger().log(LogStatus.PASS, "click on Products button", "Products button clicked");

        //Step-2 : click on Products button
        Assert.assertTrue(centerlizePO.clickOnButton(products1.getProductButton()), "click on Products button");
        logger().log(LogStatus.PASS, "click on Products button", "Products button clicked");

        //Step-3 : Create Multiple composite product
        Assert.assertTrue(products1.createMultipleCompositeProduct(), "Create Multiple composite product");
        logger().log(LogStatus.PASS, "Create Multiple composite product", "Create Multiple composite product");

        //Step-4 : verify created Composite Product Display in POS screen
        //Assert.assertTrue(processSale.veriyCreatedCompositeProductDisplayinPOSScreen("PT Composite"), "verify created Composite Product Display in POS screen ");
        logger().log(LogStatus.PASS, "verify created Composite Product Display in POS screen ", "verify created Composite Product Display in POS screen ");
    }


    /**
     * @author Vidhi Chapanera
     * @since 10 February 2021
     */
    @Test(
            enabled = false,
            groups = {"Core",
                      "HIKE-POS",
                      "Products",
                      "https://my.hikeup.com/"},
            priority = 1,
            description = "HIKE-20 : Create a new Unity of measure product and review the measures entity in POS screen."
    )
    @Owner("Vidhi Chapanera")
    @Feature("Feature : Products")
    @Severity(SeverityLevel.NORMAL)
    public void c_addNewUnityOfMeasureProduct_20() throws IOException {

        if (flag > 0) {
            logger().getTest().setName("HIKE-20 : Create a new Unity of measure product and review the measures entity in POS screen.");
            logger().assignCategory("Products");
            logger().assignAuthor("Vidhi Chapanera");
        }

        CenterlizePO centerlizePO = PageFactory.initElements(driver, CenterlizePO.class);
        ProductsPO.Products products = PageFactory.initElements(driver, ProductsPO.Products.class);
        Products products1 = PageFactory.initElements(driver, Products.class);

        //pre-condition
        //new LoginTC(driver,0).a_verifyLoginFunctionality_03();

        logger().log(LogStatus.INFO, "Execution start for HIKE-20");

        //Step-1 : click on Products button
        Assert.assertTrue(products.clickOnProductsButtonn(), "click on Products button");
        logger().log(LogStatus.PASS, "click on Products button", "Products button clicked");

        //Step-2 : click on Products button
        Assert.assertTrue(centerlizePO.clickOnButton(products1.getProductButton()), "click on Products button");
        logger().log(LogStatus.PASS, "click on Products button", "Products button clicked");

        //Step-3 : add new Unit of measure Product
        Assert.assertTrue(products1.createNewUnityOfMeasureProduct(), "add new Unit of measure Product");
        logger().log(LogStatus.PASS, "add new Unit of measure Product", "add new Unit of measure Product");
    }


    /**
     * @author Vidhi Chapanera
     * @since 08 February 2021
     */
    @Test(
            groups = {"Core",
                      "HIKE-POS",
                      "Products",
                      "https://my.hikeup.com/"},
            priority = 1,
            description = "HIKE-17 : Import multiple Variant Products to and verify Products are imported successfully"
    )
    @Owner("Vidhi Chapanera")
    @Feature("Feature : Products")
    @Severity(SeverityLevel.NORMAL)
    public void d_importMultipleVariantProductsAndVerifyThat_17() throws IOException {

        if (flag > 0) {
            logger().getTest().setName("HIKE-17 : Import multiple Variant Products to and verify Products are imported successfully");
            logger().assignCategory("Products");
            logger().assignAuthor("Vidhi Chapanera");
        }

        CenterlizePO centerlizePO = PageFactory.initElements(driver, CenterlizePO.class);
        ProductsPO.Products products = PageFactory.initElements(driver, ProductsPO.Products.class);
        Products products1 = PageFactory.initElements(driver, Products.class);

        //pre-condition
        new LoginTC(driver,0).a_verifyLoginFunctionalitydynamic_05();

        logger().log(LogStatus.INFO, "Execution start for HIKE-17");

        //Step-1 : click on Products button
        Assert.assertTrue(products.clickOnProductsButtonn(), "click on Products button");
        logger().log(LogStatus.PASS, "click on Products button", "Products button clicked");

        //Step-2 : click on Products button
        Assert.assertTrue(centerlizePO.clickOnButton(products1.getProductButton()), "click on Products button");
        logger().log(LogStatus.PASS, "click on Products button", "Products button clicked");

        //Step-3 : import multiple Variant using Import Button
        Assert.assertTrue(products1.importProductsUsingImportButton(System.getProperty("user.dir")+"\\xlsx File\\Import-Products\\Variant-Products.xlsx"), "import Customers using Import Button");
        logger().log(LogStatus.PASS, "import multiple Variant using Import Button", "Product Imported");

        //Step-4 : Verify Variant product are imported successfully
        //Assert.assertTrue(products1.verifyProductsAreImported(), "Verify Variant product are imported successfully");
        logger().log(LogStatus.PASS, "Verify Variant product are imported successfully", "Verify Variant product are imported successfully");
    }


    /**
     * @author Vidhi Chapanera
     * @since 09 February 2021
     */
    @Test(
            groups = {"Core",
                      "HIKE-POS",
                      "Products",
                      "https://my.hikeup.com/"},
            priority = 1,
            description = "HIKE-18 : Import multiple Composite Products to and verify Products are imported successfully"
    )
    @Owner("Vidhi Chapanera")
    @Feature("Feature : Products")
    @Severity(SeverityLevel.NORMAL)
    public void e_importMultipleCompositeProductsAndVerifyThat_18() throws IOException {

        if (flag > 0) {
            logger().getTest().setName("HIKE-18 : Import multiple Composite Products to and verify Products are imported successfully");
            logger().assignCategory("Products");
            logger().assignAuthor("Vidhi Chapanera");
        }

        CenterlizePO centerlizePO = PageFactory.initElements(driver, CenterlizePO.class);
        ProductsPO.Products products = PageFactory.initElements(driver, ProductsPO.Products.class);
        Products products1 = PageFactory.initElements(driver, Products.class);

        //pre-condition
        //new LoginTC(driver,0).a_verifyLoginFunctionality_03();

        logger().log(LogStatus.INFO, "Execution start for HIKE-18");

        //Step-1 : click on Products button
        Assert.assertTrue(products.clickOnProductsButtonn(), "click on Products button");
        logger().log(LogStatus.PASS, "click on Products button", "Products button clicked");

        //Step-2 : click on Products button
        Assert.assertTrue(centerlizePO.clickOnButton(products1.getProductButton()), "click on Products button");
        logger().log(LogStatus.PASS, "click on Products button", "Products button clicked");

        //Step-3 : import multiple Composite using Import Button
        Assert.assertTrue(products1.importProductsUsingImportButton(System.getProperty("user.dir")+"\\xlsx File\\Import-Products\\Composite-Products.xlsx"), "import multiple Composite using Import Button");
        logger().log(LogStatus.PASS, "import multiple Composite using Import Button", "Composite Product Imported");

        //Step-4 : Verify Composite product are imported Successfully
        //Assert.assertTrue(products1.verifyProductsAreImported(), "Verify Composite product are imported Successfully");
        logger().log(LogStatus.PASS, "Verify Composite product are imported Successfully", "Verify Composite product are imported Successfully");
    }


    /**
     * @author Vidhi Chapanera
     * @since 10 February 2021
     */
    @Test(
            groups = {"Core",
                      "HIKE-POS",
                      "Products",
                      "https://my.hikeup.com/"},
            priority = 1,
            description = "HIKE-21 : Import multiple Unit of Measure Products to and verify Products are imported successfully"
    )
    @Owner("Vidhi Chapanera")
    @Feature("Feature : Products")
    @Severity(SeverityLevel.NORMAL)
    public void f_importMultipleUnitOfMeasureProductsAndVerifyThat_21() throws IOException {

        if (flag > 0) {
            logger().getTest().setName("HIKE-21 : Import multiple Unit of Measure Products to and verify Products are imported successfully");
            logger().assignCategory("Products");
            logger().assignAuthor("Vidhi Chapanera");
        }

        CenterlizePO centerlizePO = PageFactory.initElements(driver, CenterlizePO.class);
        ProductsPO.Products products = PageFactory.initElements(driver, ProductsPO.Products.class);
        Products products1 = PageFactory.initElements(driver, Products.class);

        //Pre-requisite
       //new LoginTC(driver,0).a_verifyLoginFunctionalitydynamic_05();

        logger().log(LogStatus.INFO, "Execution start for HIKE-21");

        //Step-1 : click on Products button
        Assert.assertTrue(products.clickOnProductsButtonn(), "click on Products button");
        logger().log(LogStatus.PASS, "click on Products button", "Products button clicked");

        //Step-2 : click on Products button
        Assert.assertTrue(centerlizePO.clickOnButton(products1.getProductButton()), "click on Products button");
        logger().log(LogStatus.PASS, "click on Products button", "Products button clicked");

        //Step-3 : import multiple Unit of Measure using Import Button
        Assert.assertTrue(products1.importProductsUsingImportButton(System.getProperty("user.dir")+"\\xlsx File\\Import-Products\\Simple-Products.xlsx"), "import multiple Unit of Measure using Import Button");
       // Assert.assertTrue(products1.verifyProductsAreImported(), "Verify Unit of Measure product are imported Successfully");
        logger().log(LogStatus.PASS, "import multiple Unit of Measure using Import Button", "unit of measure Product Imported");

        //Step-4 : Verify Unit of Measure product are imported Successfully
        Assert.assertTrue(products1.importUnitOfMeasureProductsUsingImportButton(), "import multiple Unit of Measure using Import Button");
        //Assert.assertTrue(products1.verifyProductsAreImported(), "Verify Unit of Measure product are imported Successfully");
        logger().log(LogStatus.PASS, "Verify Unit of Measure product are imported Successfully", "Verify Unit of Measure product are imported Successfully");
    }


    /**
     * @author Vidhi Chapanera
     * @since 02 March 2021
     */
    @Test(
            groups = {"Core",
                      "HIKE-POS",
                      "Products",
                      "https://my.hikeup.com/"},
            priority = 1,
            description = "HIKE-38 : Verify serial number Functionality"
    )
    @Owner("Vidhi Chapanera")
    @Feature("Feature : Products")
    @Severity(SeverityLevel.NORMAL)
    public void g_verifySerialNNumberFunctionality_38() throws IOException {

        if (flag > 0) {
            logger().getTest().setName("HIKE-38 : Verify serial number Functionality");
            logger().assignCategory("Products");
            logger().assignAuthor("Vidhi Chapanera");
        }

        CenterlizePO centerlizePO = PageFactory.initElements(driver, CenterlizePO.class);
        ProductsPO.Products products = PageFactory.initElements(driver, ProductsPO.Products.class);
        Products products1 = PageFactory.initElements(driver, Products.class);

        //pre-condition
        //new LoginTC(driver,0).a_verifyLoginFunctionalitydynamic_05();

        logger().log(LogStatus.INFO, "Execution start for HIKE-38");

        //Step-1 : click on Products button
        Assert.assertTrue(products.clickOnProductsButtonn(), "click on Products button");
        logger().log(LogStatus.PASS, "click on Products button", "Products button clicked");

        //Step-2 : click on Products button
        Assert.assertTrue(centerlizePO.clickOnButton(products1.getProductButton()), "click on Products button");
        logger().log(LogStatus.PASS, "click on Products button", "Products button clicked");

        //Step-3 : enable serial number feature from product edit page
        Assert.assertTrue(products1.enableSerialNumberFeatureFromProductEditPage("ProductSerial0001"), "enable serial number feature from product edit page");
        logger().log(LogStatus.PASS, "enable serial number feature from product edit page", "enable serial number feature from product edit page");

        //Step-4 : verify sale flow
        Assert.assertTrue(products1.verifySaleFlow("ProductSerial0001"), "enable serial number feature from product edit page");
        logger().log(LogStatus.PASS, "verify sale flow", "enable serial number feature from product edit page");

    }


    /**
     * @author Vidhi Chapanera
     * @since 02 March 2021
     */
    @Test(
            groups = {"Core",
                      "HIKE-POS",
                      "Products",
                      "https://my.hikeup.com/"},
            priority = 1,
            description = "HIKE-81 : Auto-generated barcode type"
    )
    @Owner("Vidhi Chapanera")
    @Feature("Feature : Products")
    @Severity(SeverityLevel.NORMAL)
    public void h_verifyAutoGeneratedBarcodeTypes_81() throws IOException {

        if (flag > 0) {
            logger().getTest().setName("HIKE-81 : Auto-generated barcode type");
            logger().assignCategory("Products");
            logger().assignAuthor("Vidhi Chapanera");
        }

        Products products1 = PageFactory.initElements(driver, Products.class);

        //pre-condition
        //new LoginTC(driver,0).a_verifyLoginFunctionalitydynamic_05();

        logger().log(LogStatus.INFO, "Execution start for HIKE-81");

        //Step-1 : click on Products button
        logger().log(LogStatus.PASS, "click on Products button", "Products button clicked");

        //Step-2 : click on Products button
        logger().log(LogStatus.PASS, "click on Products button", "Products button clicked");

        //Step-3 : verify 8-digit alphanumeric option of Auto-generated barcode type
        Assert.assertTrue(products1.verify8DigitAlphanumericOption("Max black Georgette Top"), "verify 8-digit alphanumeric option of Auto-generated barcode type");
        logger().log(LogStatus.PASS, "verify 8-digit alphanumeric option of Auto-generated barcode type","verify 8-digit alphanumeric option of Auto-generated barcode type");

        //Step-4 : verify 16-digit numeric option of Auto-generated barcode type
        Assert.assertTrue(products1.verify13DigitNumericOption("Max pink Georgette Top"), "verify 16-digit numeric option of Auto-generated barcode type");
        logger().log(LogStatus.PASS, "verify 16-digit numeric option of Auto-generated barcode type","verify 16-digit numeric option of Auto-generated barcode type");

    }
}