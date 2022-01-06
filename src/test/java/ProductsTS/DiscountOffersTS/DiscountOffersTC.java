package ProductsTS.DiscountOffersTS;

import CommonPO.CenterlizePO;
import Config.Base.BaseTest;
import Config.allure.AllureListener;
import LoginTS.LoginTC;
import ProductsPO.DiscountOffersPO.DiscountOffers;
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
 * @date 25 February 2021
 */

@Listeners({AllureListener.class})
public class DiscountOffersTC extends BaseTest {

    public int flag = 1;

    public DiscountOffersTC() {
    }

    public DiscountOffersTC(WebDriver driver, int flag) {
        this.flag = flag;
        this.driver = driver;
    }

    /**
     * @author Vidhi Chapanera
     * @since 25 February 2021
     */
    @Test(
            groups = {"Core",
                      "HIKE-POS",
                      "Products",
                      "https://my.hikeup.com/"},
            priority = 1,
            description = "HIKE-34 : Verify Product Type Discount offer Functionalityctionality_34 "
    )
    @Owner("Vidhi Chapanera")
    @Feature("Feature : Products")
    @Severity(SeverityLevel.NORMAL)
    public void a_verifyProductTypeDiscountOfferFunctionality_34() throws IOException {

        if (flag > 0) {
            logger().getTest().setName("HIKE-34 : Verify Product Type Discount offer Functionalityctionality_34 ");
            logger().assignCategory("Products");
            logger().assignAuthor("Vidhi Chapanera");
        }

        ProductsPO.Products products = PageFactory.initElements(driver, ProductsPO.Products.class);
        DiscountOffers discountOffers = PageFactory.initElements(driver, DiscountOffers.class);

        //pre-condition
        new LoginTC(driver,0).a_verifyLoginFunctionalitydynamic_05();

        logger().log(LogStatus.INFO, "Execution start for HIKE-34");

        //Step-1 : click on Products button
        Assert.assertTrue(products.clickOnProductsButtonn(), "click on Products button");
        logger().log(LogStatus.PASS, "click on Products button", "Products button clicked");

        //Step-2 : click on Discount offer button
        logger().log(LogStatus.PASS, "click on Discount offer button", "Discount offer button clicked");

        //Step-3 : Create a new ‘Product type’ discount offer
        Assert.assertTrue(discountOffers.createNewProductTypeDiscountOffer(), "Create a new ‘Product type’ discount offer");
        logger().log(LogStatus.PASS, "Create a new ‘Product type’ discount offer", "Create a new ‘Product type’ discount offer");

        //Step-4 : Add a member product to cart and verify that offer is apply correctly
        Assert.assertTrue(discountOffers.addMemberProductToTheCartandVerifyOfferinCart(), "Add a member product to cart and verify that offer is apply correctly");
        logger().log(LogStatus.PASS, "Add a member product to cart and verify that offer is apply correctly", "Add a member product to cart and verify that offer is apply correctly");
    }


    /**
     * @author Vidhi Chapanera
     * @since 25 February 2021
     */
    @Test(
            groups = {"Core",
                      "HIKE-POS",
                      "Products",
                      "https://my.hikeup.com/"},
            priority = 1,
            description = "HIKE-35 : Verify Product Discount offer Functionality"
    )
    @Owner("Vidhi Chapanera")
    @Feature("Feature : Products")
    @Severity(SeverityLevel.NORMAL)
    public void b_verifyProductDiscountOfferFunctionality_35() throws IOException {

        if (flag > 0) {
            logger().getTest().setName("HIKE-35 : Verify Product Discount offer Functionality");
            logger().assignCategory("Products");
            logger().assignAuthor("Vidhi Chapanera");
        }

        ProductsPO.Products products = PageFactory.initElements(driver, ProductsPO.Products.class);
        DiscountOffers discountOffers = PageFactory.initElements(driver, DiscountOffers.class);

        //pre-condition
        //new LoginTC(driver,0).a_verifyLoginFunctionalitydynamic_05();

        logger().log(LogStatus.INFO, "Execution start for HIKE-35");

        //Step-1 : click on Products button
        Assert.assertTrue(products.clickOnProductsButtonn(), "click on Products button");
        logger().log(LogStatus.PASS, "click on Products button", "Products button clicked");

        //Step-2 : click on Discount offer button
        logger().log(LogStatus.PASS, "click on Discount offer button", "Discount offer button clicked");

        //Step-3 : Create a new ‘Product’ discount offer
        Assert.assertTrue(discountOffers.createNewProductDiscountOffer(), "Create a new ‘Product’ discount offer");
        logger().log(LogStatus.PASS, "Create a new ‘Product’ discount offer", "Create a new ‘Product’ discount offer");

        //Step-4 : Add a member product to cart and verify that offer is apply correctly
        Assert.assertTrue(discountOffers.addMemberProductOfferToTheCartandVerifyOfferinCart(), "Add a member product to cart and verify that offer is apply correctly");
        logger().log(LogStatus.PASS, "Add a member product to cart and verify that offer is apply correctly", "Add a member product to cart and verify that offer is apply correctly");
    }


    /**
     * @author Vidhi Chapanera
     * @since 25 February 2021
     */
    @Test(
            groups = {"Core",
                      "HIKE-POS",
                      "Products",
                      "https://my.hikeup.com/"},
            priority = 1,
            description = "HIKE-83 : Checked Option to Define a rule for discount offers when there are more than one offers applicable"
    )
    @Owner("Vidhi Chapanera")
    @Feature("Feature : Products")
    @Severity(SeverityLevel.NORMAL)
    public void c_VerifyRulesForDiscountOfferIfMoreThanTwoOffersAreAvailable_83() throws IOException {

        if (flag > 0) {
            logger().getTest().setName("HIKE-83 : Checked Option to Define a rule for discount offers when there are more than one offers applicable");
            logger().assignCategory("Products");
            logger().assignAuthor("Vidhi Chapanera");
        }

        ProductsPO.Products products = PageFactory.initElements(driver, ProductsPO.Products.class);
        DiscountOffers discountOffers = PageFactory.initElements(driver, DiscountOffers.class);
        CenterlizePO centerlizePO = PageFactory.initElements(driver,CenterlizePO.class);


        //pre-condition
       // new LoginTC(driver,0).a_verifyLoginFunctionalitydynamic_05();

        logger().log(LogStatus.INFO, "Execution start for HIKE-83");

        //Step-1 : click on Products button
        Assert.assertTrue(products.clickOnProductsButtonn(), "click on Products button");
        logger().log(LogStatus.PASS, "click on Products button", "Products button clicked");

       //Step-2 : Create One Product
        Assert.assertTrue(discountOffers.CreateProduct("Baby Girl Striped Dress"), "Create One Product");
        logger().log(LogStatus.PASS, "Create One Product", "Create One Product");

        //Step-2 : click on Discount offer button
        Assert.assertTrue(centerlizePO.clickOnButton(discountOffers.getDiscountOffersButton()), "Create One Product");
        logger().log(LogStatus.PASS, "click on Discount offer button", "Discount offer button clicked");

        //Step-3 : Create a new ‘Product’ discount offer
        Assert.assertTrue(discountOffers.createNewTwoDiscountType("Max-High","24"), "Create a new ‘Product’ discount offer");
        Assert.assertTrue(discountOffers.createNewTwoDiscountType("Min-Low","13"), "Create a new ‘Product’ discount offer");
        logger().log(LogStatus.PASS, "Create a new ‘Product’ discount offer", "Create a new ‘Product’ discount offer");

        //Step-4 : Verify Let cashier select the best suitable offer manually Option
        Assert.assertTrue(discountOffers.VerifyLetCashierSelectTheBestOption01("Baby Girl Striped Dress"), "Verify Let cashier select the best suitable offer manually Option");
        logger().log(LogStatus.PASS, "Verify Let cashier select the best suitable offer manually Option", "Verify Let cashier select the best suitable offer manually Option");

        //Step-5 :  Verify Automatically apply offer with a highest discount
        Assert.assertTrue(discountOffers.VerifyAutomaticallyApplyOfferWithHighestDiscountOption0203("a highest","Baby Girl Striped Dress","Max-High"), "Verify Automatically apply offer with a highest discount");
        logger().log(LogStatus.PASS, "Verify Automatically apply offer with a highest discount","Verify Automatically apply offer with a highest discount");

        //Step-5 :  Verify Automatically apply offer with the lowest discount
        Assert.assertTrue(discountOffers.VerifyAutomaticallyApplyOfferWithHighestDiscountOption0203("the lowest","Baby Girl Striped Dress","Min-Low"), "Verify Automatically apply offer with a lowest discount");
        logger().log(LogStatus.PASS, "Verify Automatically apply offer with a lowest discount","Verify Automatically apply offer with a lowest discount");
    }


}