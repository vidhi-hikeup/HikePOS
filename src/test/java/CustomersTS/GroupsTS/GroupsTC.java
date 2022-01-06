package CustomersTS.GroupsTS;

import CommonPO.CenterlizePO;
import Config.Base.BaseTest;
import Config.allure.AllureListener;
import CustomersPO.Customers;
import CustomersPO.GroupsPO.Groups;
import LoginTS.LoginTC;
import PointofSalePO.CashRegisterPO.CashRegister;
import PointofSalePO.PointofSale;
import PointofSalePO.ProcessSalePO.ProcessSale;
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
 * @date 22 February 2021
 */

@Listeners({AllureListener.class})
public class GroupsTC extends BaseTest {

    public int flag = 1;
    public GroupsTC() {
    }

    public GroupsTC(WebDriver driver, int flag) {
        this.flag = flag;
        this.driver = driver;
    }

    /**
     * @author Vidhi Chapanera
     * @since 22 February 2021
     */
    @Test(
            groups = {"Core", "HIKE-POS", "Customers", "https://my.hikeup.com/"},
            priority = 1,
            description = "HIKE-30 : Create a new customer, allocate a customer group with 20% discount"
    )
    @Owner("Vidhi Chapanera")
    @Feature("Feature : Customers")
    @Severity(SeverityLevel.NORMAL)
    public void a_CreateNewCustomerAllocateCustomerGroupWith20PerDiscount_30() throws IOException {

        if (flag > 0) {
            logger().getTest().setName("HIKE-30 : Create a new customer, allocate a customer group with 20% discount");
            logger().assignCategory("Customers");
            logger().assignAuthor("Vidhi Chapanera");
        }

        CenterlizePO centerlizePO = PageFactory.initElements(driver,CenterlizePO.class);
        Customers customers = PageFactory.initElements(driver,Customers.class);
        Groups groups = PageFactory.initElements(driver,Groups.class);

        //pre-condition
        new LoginTC(driver,0).a_verifyLoginFunctionalitydynamic_05();

        logger().log(LogStatus.INFO, "Execution start for HIKE-30");

        //Step-1 : Click on Customers Button
        Assert.assertTrue(customers.clickOnCustomersButton(), "Click on Customers Button");
        logger().log(LogStatus.PASS, "Click on Customers Button", "Customers Button clicked");

        //Step-2 : Click on Groups Button
        Assert.assertTrue(centerlizePO.clickOnButton(groups.getGroupsButton()), "Click on Groups Button");
        logger().log(LogStatus.PASS, "Click on Groups Button", "Groups Button clicked");

        //Step-3 : Add discount group with 20 % Discount offer
        Assert.assertTrue(groups.addDiscountGroup(), "Add discount group with 20 % Discount offer");
        logger().log(LogStatus.PASS, "Add discount group with 20 % Discount offer", "Add discount group with 20 % Discount offer");

        //Step-4 : allocate customer group  with 20% discount offer 
        Assert.assertTrue(groups.allocateCustomerGroupWith20PerDiscount(), "allocate customer group  with 20% discount offer ");
        logger().log(LogStatus.PASS, "allocate customer group  with 20% discount offer ", "allocate customer group  with 20% discount offer ");
    }


    /**
     * @author Vidhi Chapanera
     * @since 22 February 2021
     */
    @Test(
            groups = {"Core", "HIKE-POS", "Customers", "https://my.hikeup.com/"},
            priority = 1,
            description = "HIKE-31 : verify 20% discount is correctly apply to the cart by Adding new sale > allocate newly created customer"
    )
    @Owner("Vidhi Chapanera")
    @Feature("Feature : Customers")
    @Severity(SeverityLevel.NORMAL)
    public void b_verify20perDiscountApplyCorrectlytoTheCartByAddingNewSale_31() throws IOException {

        if (flag > 0) {
            logger().getTest().setName("HIKE-31 : verify 20% discount is correctly apply to the cart by Adding new sale > allocate newly created customer");
            logger().assignCategory("Customers");
            logger().assignAuthor("Vidhi Chapanera");
        }

        CenterlizePO centerlizePO = PageFactory.initElements(driver,CenterlizePO.class);
        PointofSale pointofSale = PageFactory.initElements(driver,PointofSale.class);
        ProcessSale processSale = PageFactory.initElements(driver,ProcessSale.class);
        Groups groups = PageFactory.initElements(driver,Groups.class);

        logger().log(LogStatus.INFO, "Execution start for HIKE-31");

        //Step-1 : Click on Point of sale button
        Assert.assertTrue(pointofSale.clickOnPointOfSaleButtonn(), "Click on Point of sale button");
        logger().log(LogStatus.PASS, "Click on Point of sale button", "point of sale Button clicked");

        //Step-2 : Click on process sale button
        Assert.assertTrue(centerlizePO.clickOnButton(PageFactory.initElements(driver, CashRegister.class).getCashRegisterButton()), "Click on process sale button");
        centerlizePO.sleepFor(5);
        Assert.assertTrue(centerlizePO.clickOnButton(PageFactory.initElements(driver, CashRegister.class).getRefreshDataButton()), "Click on process sale button");
        Assert.assertTrue(centerlizePO.clickOnButton(PageFactory.initElements(driver, CashRegister.class).getContinueButton()), "Click on process sale button");
        centerlizePO.sleepFor(15);
        Assert.assertTrue(centerlizePO.clickOnButton(processSale.getProcessSaleButton()), "Click on process sale button");
        logger().log(LogStatus.PASS, "Click on process sale button", "process sal Button clicked");

        //Step-3 : Add new sale
        centerlizePO.sleepFor(15);
        logger().log(LogStatus.PASS, "Add new sale ", "Add new sale ");

        //Step-4 : verify 20% discount is correctly apply to the cart
        Assert.assertTrue(groups.verify20perDiscountApplyCorrectlytoTheCartByAddingNewSale_01(), "verify 20% discount is correctly apply to the cart ");
        logger().log(LogStatus.PASS, "verify 20% discount is correctly apply to the cart ", "verify 20% discount is correctly apply to the cart ");
    }


    /**
     * @author Vidhi Chapanera
     * @since 17 March 2021
     */
    @Test(
            groups = {"Core", "HIKE-POS", "Customers", "https://my.hikeup.com/"},
            priority = 1,
            description = "HIKE-63 : Customer group, create new price list discount group (set min, max qty and and set loyalty point), now check group discount proper work or not"
    )
    @Owner("Vidhi Chapanera")
    @Feature("Feature : Customers")
    @Severity(SeverityLevel.NORMAL)
    public void c_CreatePriceListDiscountGroup_63() throws IOException {

        if (flag > 0) {
            logger().getTest().setName("HIKE-63 : Customer group, create new price list discount group (set min, max qty and and set loyalty point), now check group discount proper work or not");
            logger().assignCategory("Customers");
            logger().assignAuthor("Vidhi Chapanera");
        }

        //pre-condition
        //new LoginTC(driver,0).a_verifyLoginFunctionalitydynamic_05();

        Groups groups = PageFactory.initElements(driver,Groups.class);

        logger().log(LogStatus.INFO, "Execution start for HIKE-63");

        //Step-1 : Customer group, create new price list discount group (set min, max qty and and set loyalty point), now check group discount proper work or not
        Assert.assertTrue(groups.createNewPriceListDiscountGroup(),"Customer group, create new price list discount group (set min, max qty and and set loyalty point), now check group discount proper work or not");
        logger().log(LogStatus.PASS,"Customer group, create new price list discount group (set min, max qty and and set loyalty point), now check group discount proper work or not","Customer group, create new price list discount group (set min, max qty and and set loyalty point), now check group discount proper work or not");
    }
    
}
