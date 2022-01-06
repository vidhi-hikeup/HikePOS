package ProductsTS.GiftCardsTS;

import CommonPO.CenterlizePO;
import Config.Base.BaseTest;
import Config.allure.AllureListener;
import ProductsPO.GiftCardsPO.GiftCards;
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
 * @date 20 January 2021
 */

@Listeners({AllureListener.class})
public class GiftCardsTC extends BaseTest {

    public int flag = 1;

    public GiftCardsTC() {
    }

    public GiftCardsTC(WebDriver driver, int flag) {
        this.flag = flag;
        this.driver = driver;
    }

    /**
     * @author Vidhi Chapanera
     * @since 20 January 2021
     */
    @Test(
            groups = {"Core",
                      "HIKE-POS",
                      "Products",
                      "https://my.hikeup.com/"},
            priority = 1,
            description = "HIKE-06 : Activate Gift cards"
    )
    @Owner("Vidhi Chapanera")
    @Feature("Feature : Products")
    @Severity(SeverityLevel.NORMAL)
    public void activateGiftCards_06() throws IOException {

        if (flag > 0) {
            logger().getTest().setName("HIKE-06 : Activate Gift cards");
            logger().assignCategory("Products");
            logger().assignAuthor("Vidhi Chapanera");
        }

        CenterlizePO centerlizePO = PageFactory.initElements(driver, CenterlizePO.class);
        Products products = PageFactory.initElements(driver, Products.class);
        GiftCards giftCards = PageFactory.initElements(driver, GiftCards.class);

        //pre-condition
        //new LoginTC(driver,0).a_verifyLoginFunctionality_03();

        logger().log(LogStatus.INFO, "Execution start for HIKE-06");

        //Step-1 : click on Products button
        Assert.assertTrue(products.clickOnProductsButtonn(), "click on Products button");
        logger().log(LogStatus.PASS, "click on Products button", "Products button clicked");

        //Step-2 : click on gift cards button
        Assert.assertTrue(centerlizePO.clickOnButton(giftCards.getGiftCardsButton()), "click on gift cards button");
        logger().log(LogStatus.PASS, "click on gift cards button", "gift cards button clicked");

        //Step-3 : Activate gift cards
        Assert.assertTrue(giftCards.activeLoyaltyRewards(), "Activate gift cards");
        logger().log(LogStatus.PASS, "Activate gift cards", "Activate gift cards");
    }
}