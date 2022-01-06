package CreateStoreTS;

import CommonPO.CenterlizePO;
import CreateStorePO.StoreConstant;
import Config.Base.BaseTest;
import Config.allure.AllureListener;
import CreateStorePO.CreateStore;
import com.relevantcodes.extentreports.LogStatus;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;


/**
 * @author Vidhi Chapanera
 * @date 11 January 2021
 */

@Listeners({AllureListener.class})
public class CreateStoreTC extends BaseTest {

    public int flag = 1;
    public CreateStoreTC() {
    }

    public CreateStoreTC(WebDriver driver, int flag) {
        this.flag = flag;
        this.driver = driver;
    }


    /**
     * @author Vidhi Chapanera
     * @since 11 January 2021
     */
    @Test(
            enabled = false,
            groups = {"Core",
                      "HIKE-POS",
                      "Create Store",
                      "https://my.hikeup.com/"},
            priority = 1, description = "HIKE-01 : Verify Create Store Functionality"
    )
    @Owner("Vidhi Chapanera")
    @Feature("Feature : Create Store")
    @Severity(SeverityLevel.NORMAL)
    public void a_verifyCreateStoreFunctionality_01() throws IOException {

        if (flag > 0) {
            logger().getTest().setName("HIKE-01 : Verify Create Store Functionality");
            logger().assignCategory("Create Store");
            logger().assignAuthor("Vidhi Chapanera");
        }

        CenterlizePO centerlizePO = PageFactory.initElements(driver,CenterlizePO.class);
        CreateStore createStore = PageFactory.initElements(driver,CreateStore.class);

        String fileLocation =System.getProperty("user.dir")+"\\src\\main\\resources\\createStore.properties";
        Properties properties1 = new Properties();
        properties1.load(new FileReader(fileLocation));

        logger().log(LogStatus.INFO, "Execution start for HIKE-01");

        //Step-1 : Click on Start Free Trial hyper link
        Assert.assertTrue(centerlizePO.clickOnButton(createStore.getStartFreeTrialLink()), "Click on Start Free Trial hyper link");
        logger().log(LogStatus.PASS, "Click on Start Free Trial hyper link", "Start Free Trial hyper link clicked");

        //Step-2 : enter First Name
        Assert.assertTrue(centerlizePO.enterDataUsingSendkeys(createStore.getFirstNameTextBox(), StoreConstant.FIRST_NAME), "enter First Name");
        logger().log(LogStatus.PASS, "enter First Name", "First Name entered");

        //Step-3 : enter Last Name
        Assert.assertTrue(centerlizePO.enterDataUsingSendkeys(createStore.getLastNameTextBox(), StoreConstant.LAST_NAME), "enter Last Name");
        logger().log(LogStatus.PASS, "enter Last Name", "Last Name entered");

        //Step-4 : enter email
        Assert.assertTrue(centerlizePO.enterDataUsingSendkeys(createStore.getEmailTextBox(), StoreConstant.EMAIL), "enter email");
        logger().log(LogStatus.PASS, "enter email", "email entered");

        //Step-5 : enter phone
        Assert.assertTrue(centerlizePO.enterDataUsingSendkeys(createStore.getPhoneTextBox(), StoreConstant.PHONE), "enter email");
        logger().log(LogStatus.PASS, "enter phone", "phone entered");

        //Step-6 : enter City
        Assert.assertTrue(centerlizePO.clearText(createStore.getCityTextBox()), "clear text");
        Assert.assertTrue(centerlizePO.enterDataUsingSendkeys(createStore.getCityTextBox(),StoreConstant.CITY), "enter City");
        logger().log(LogStatus.PASS, "enter City", "City entered");

        //Step-7 : enter password
        Assert.assertTrue(centerlizePO.enterDataUsingSendkeys(createStore.getPasswordTextBox(),String.valueOf(properties1.put(StoreConstant.PASSWORD,"password"))), "enter password");
        logger().log(LogStatus.PASS, "enter password", "password entered");

        //Step-8 : click on next button
        Assert.assertTrue(centerlizePO.clickOnButton(createStore.getContinueButton()), "click on next button");
        logger().log(LogStatus.PASS, "click on next button", "next button clicked");

        //Step-9 : enter your account address
        Assert.assertTrue(centerlizePO.enterDataUsingSendkeys(createStore.getAccountAddressTextBox(),StoreConstant.ACCOUNT_ADDRESS), "enter your account address");
        Assert.assertTrue(centerlizePO.verifyElemntIsDisplay(createStore.getTickMarkIcon()), "verify Tick mark icon is displayed");
        logger().log(LogStatus.PASS, "enter your account address", "your account address entered");

        //Step-10 : click on continue button
        Assert.assertTrue(centerlizePO.clickOnButton(createStore.getContinueButtonOnAccountAddressPage()), "click on continue button");
        logger().log(LogStatus.PASS, "click on continue button", "continue button clicked");

        //Step-11 : select Industry Type from Industry Type drop down
        Assert.assertTrue(centerlizePO.selectValueFromDropDownUsingIndex(createStore.getIndustryTypeDropDown(),1), "select Industry Type from Industry Type drop down");
        logger().log(LogStatus.PASS, "select Industry Type from Industry Type drop down", "Industry Type selected");

        //Step-12 : click on Create my store button
        Assert.assertTrue(centerlizePO.clickOnButton(createStore.getCreteMyStoreButton()), "click on Create my store button");
        centerlizePO.sleepFor(30);
        logger().log(LogStatus.PASS, "click on Create my store button", "Create my store button clicked");
    }


    /**
     * @author Vidhi Chapanera
     * @since 11 January 2021
     */
    /* @Test(
            groups = {"Core", "HIKE-POS", "Create Store", "https://my.hikeup.com/"},
             priority = 1,
             description = "HIKE-02 : Verify Create Store Functionality(dynamic)"
   )
    @Owner("Vidhi Chapanera")
    @Feature("Feature : Create Store")
    @Severity(SeverityLevel.NORMAL)
    public void b_verifyCreateStoreFunctionalitydynamic_02() throws IOException {
        if (flag > 0) {
            logger().getTest().setName("HIKE-01 : Verify Create Store Functionality(dynamic)");
            logger().assignCategory("Create Store");
            logger().assignAuthor("Vidhi Chapanera");
        }

        CenterlizePO centerlizePO = PageFactory.initElements(driver,CenterlizePO.class);
        CreateStore createStore = PageFactory.initElements(driver,CreateStore.class);

        String fileLocation =System.getProperty("user.dir")+"\\src\\main\\resources\\createStore.properties";
        Properties properties1 = new Properties();
        properties1.load(new FileReader(fileLocation));

        logger().log(LogStatus.INFO, "Execution start for HIKE-01");

        //Step-1 : Click on Start Free Trial hyper link
        Assert.assertTrue(centerlizePO.clickOnButton(createStore.getStartFreeTrialLink()), "Click on Start Free Trial hyper link");
        logger().log(LogStatus.PASS, "Click on Start Free Trial hyper link", "Start Free Trial hyper link clicked");

        //Step-2 : enter First Name
        Assert.assertTrue(createStore.renameFileData(createStore.getFirstNameTextBox(),"\\src\\main\\java\\CreateStorePO\\File\\FirstName"), "enter First Name");
        logger().log(LogStatus.PASS, "enter First Name", "First Name entered");

        //Step-3 : enter Last Name
        Assert.assertTrue(createStore.renameFileData(createStore.getLastNameTextBox(), "\\src\\main\\java\\CreateStorePO\\File\\LastName"), "enter Last Name");
        logger().log(LogStatus.PASS, "enter Last Name", "Last Name entered");

        //Step-4 : enter email
        Assert.assertTrue(centerlizePO.enterDataUsingSendkeys(createStore.getEmailTextBox(), StoreConstant.EMAIL), "enter email");
        logger().log(LogStatus.PASS, "enter email", "email entered");

        //Step-5 : enter phone
        Assert.assertTrue(centerlizePO.enterDataUsingSendkeys(createStore.getPhoneTextBox(), StoreConstant.PHONE), "enter email");
        logger().log(LogStatus.PASS, "enter phone", "phone entered");

        //Step-6 : enter City
        Assert.assertTrue(centerlizePO.clearText(createStore.getCityTextBox()), "clear text");
        Assert.assertTrue(centerlizePO.enterDataUsingSendkeys(createStore.getCityTextBox(),StoreConstant.CITY), "enter City");
        logger().log(LogStatus.PASS, "enter City", "City entered");

        //Step-7 : enter password
        Assert.assertTrue(centerlizePO.enterDataUsingSendkeys(createStore.getPasswordTextBox(),String.valueOf(properties1.put(StoreConstant.PASSWORD,"password"))), "enter password");
        logger().log(LogStatus.PASS, "enter password", "password entered");

        //Step-8 : click on next button
        Assert.assertTrue(centerlizePO.clickOnButton(createStore.getContinueButton()), "click on next button");
        logger().log(LogStatus.PASS, "click on next button", "next button clicked");

        //Step-9 : enter your account address
        Assert.assertTrue(createStore.renameFileData(createStore.getAccountAddressTextBox(),"\\src\\main\\java\\CreateStorePO\\File\\AccountAddress"), "enter your account address");
        Assert.assertTrue(centerlizePO.verifyElemntIsDisplay(createStore.getTickMarkIcon()), "verify Tick mark icon is displayed");
        logger().log(LogStatus.PASS, "enter your account address", "your account address entered");

        //Step-10 : click on continue button
        Assert.assertTrue(centerlizePO.clickOnButton(createStore.getContinueButtonOnAccountAddressPage()), "click on continue button");
        logger().log(LogStatus.PASS, "click on continue button", "continue button clicked");

        //Step-11 : select Industry Type from Industry Type drop down
        Assert.assertTrue(centerlizePO.selectValueFromDropDown(createStore.getIndustryTypeDropDown(),"Fashion & Clothing Retail"), "select Industry Type from Industry Type drop down");
        logger().log(LogStatus.PASS, "select Industry Type from Industry Type drop down", "Industry Type selected");

        //Step-12 : click on Create my store button
        Assert.assertTrue(centerlizePO.clickOnButton(createStore.getCreteMyStoreButton()), "click on Create my store button");
        centerlizePO.sleepFor(30);
        logger().log(LogStatus.PASS, "click on Create my store button", "Create my store button clicked");

        //Step-13 : verify Created Store
        Assert.assertTrue(createStore.verifyCreatedStore(createStore.getAddressValue()), "verify Created Store");
        logger().log(LogStatus.PASS, "verify Created Store", "store created");
    }*/


    /**
     * @author Vidhi Chapanera
     * @since 12 May 2021
     */
    @Test(
            groups = {"Core",
                      "HIKE-POS",
                      "Create Store",
                      "https://my.hikeup.com/"},
            priority = 1,
            description = "HIKE-02 : Verify Create Store Functionality(dynamic)"
    )
    @Owner("Vidhi Chapanera")
    @Feature("Feature : Create Store")
    @Severity(SeverityLevel.NORMAL)
    public void b_verifyCreateStoreFunctionalitydynamic_02() throws IOException {

        if (flag > 0) {
            logger().getTest().setName("HIKE-01 : Verify Create Store Functionality(dynamic)");
            logger().assignCategory("Create Store");
            logger().assignAuthor("Vidhi Chapanera");
        }

        CenterlizePO centerlizePO = PageFactory.initElements(driver,CenterlizePO.class);
        CreateStore createStore = PageFactory.initElements(driver,CreateStore.class);

        String fileLocation =System.getProperty("user.dir")+"\\src\\main\\resources\\createStore.properties";
        Properties properties1 = new Properties();
        properties1.load(new FileReader(fileLocation));

        logger().log(LogStatus.INFO, "Execution start for HIKE-01");

        //Step-1 : Click on Start Free Trial hyper link
        Assert.assertTrue(centerlizePO.clickOnButton(createStore.getStartFreeTrialLink()), "Click on Start Free Trial hyper link");
        logger().log(LogStatus.PASS, "Click on Start Free Trial hyper link", "Start Free Trial hyper link clicked");

        //Step-2 : enter First Name
        Assert.assertTrue(centerlizePO.enterDataUsingSendkeys(createStore.getFirstNameTextBox(),"Vidhi"), "enter First Name");
        logger().log(LogStatus.PASS, "enter First Name", "First Name entered");

        //Step-3 : enter Last Name
        Assert.assertTrue(centerlizePO.enterDataUsingSendkeys(createStore.getLastNameTextBox(),"Chapanera"), "enter Last Name");
        logger().log(LogStatus.PASS, "enter Last Name", "Last Name entered");

        //Step-4 : enter email
        Assert.assertTrue(centerlizePO.enterDataUsingSendkeys(createStore.getEmailTextBox(), StoreConstant.EMAIL), "enter email");
        logger().log(LogStatus.PASS, "enter email", "email entered");

        //Step-5 : enter phone
        Assert.assertTrue(createStore.enterPhoneNumber(), "enter email");
        Assert.assertTrue(centerlizePO.enterDataUsingSendkeys(createStore.getPhoneTextBox(), StoreConstant.PHONE), "enter email");
        logger().log(LogStatus.PASS, "enter phone", "phone entered");

        //Step-6 : enter City
        Assert.assertTrue(centerlizePO.clearText(createStore.getCityTextBox()), "clear text");
        Assert.assertTrue(centerlizePO.enterDataUsingSendkeys(createStore.getCityTextBox(),StoreConstant.CITY), "enter City");
        centerlizePO.sleepFor(5);
        Actions actions =new Actions(driver);
        actions.sendKeys(Keys.TAB).build().perform();
        logger().log(LogStatus.PASS, "enter City", "City entered");

        //Step-7 : enter password
        Assert.assertTrue(centerlizePO.enterDataUsingSendkeys(createStore.getPasswordTextBox(),String.valueOf(properties1.put(StoreConstant.PASSWORD,"password"))), "enter password");
        logger().log(LogStatus.PASS, "enter password", "password entered");

        //Step-8 : click on next button
        Assert.assertTrue(centerlizePO.clickOnButton(createStore.getContinueButton()), "click on next button");
        logger().log(LogStatus.PASS, "click on next button", "next button clicked");

        //Step-9 : enter your account address
        Assert.assertTrue(createStore.renameFileData(createStore.getAccountAddressTextBox(),"\\src\\main\\java\\CreateStorePO\\File\\AccountAddress"), "enter your account address");
        Assert.assertTrue(centerlizePO.verifyElemntIsDisplay(createStore.getTickMarkIcon()), "verify Tick mark icon is displayed");
        logger().log(LogStatus.PASS, "enter your account address", "your account address entered");

        //Step-10 : click on Create my store button
        Assert.assertTrue(centerlizePO.clickOnButton(createStore.getCreteMyStoreButton()), "click on Create my store button");
        centerlizePO.sleepFor(30);
        logger().log(LogStatus.PASS, "click on Create my store button", "Create my store button clicked");

        //Step-11 : A bit about your store
        Assert.assertTrue(createStore.bitAboutYourStoreSection(), "A bit about your store");
        logger().log(LogStatus.PASS, "A bit about your store", "A bit about your store");
    }
}
