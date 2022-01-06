package StoreSetupPO.OutletsAndRegistersPO;

import CommonPO.BasePage;
import ProductsPO.DiscountOffersPO.DiscountOffers;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.text.Format;
import java.text.SimpleDateFormat;

/**
 * @author Vidhi Chapanera
 * @date 18 February 2021
 */
public class OutletsAndRegisters extends BasePage {

    public WebDriver driver;
    public static String dataText = "";

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Outlets & registers button
     * @date 18 February 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//span[contains(text(),'Outlets & registers')]//parent::a"
    )
    WebElement btn_OutletsAndRegisters;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for add outlet button
     * @date 18 February 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//button[contains(text(),'Add outlet')]"
    )
    WebElement btn_addoutlet;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for outlet name input box
     * @date 18 February 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//label[contains(text(),'Outlet name')]//parent::div//input"
    )
    WebElement txt_outletName;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for email input box
     * @date 18 February 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//label[contains(text(),'Email')]//parent::div//input"
    )
    WebElement txt_email;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for save button
     * @date 18 February 2021
     */
    @FindBy(
            how = How.CSS,
            using = "button[type='submit']"
    )
    WebElement btn_save;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for link all products radio button
     * @date 18 February 2021
     */
    @FindBy(
            how = How.CSS,
            using = "label[for='LinkAll']"
    )
    WebElement rbtn_linkall;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for continue button
     * @date 18 February 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//button[text()='Continue']"
    )
    WebElement btn_continue;

    public OutletsAndRegisters(WebDriver driver) {
        this.driver = driver;
    }
    public WebElement getOutletsAndRegisters() {
        return btn_OutletsAndRegisters;
    }
    public WebElement getAddOutlet() {
        return btn_addoutlet;
    }
    public WebElement getOutletName() {
        return txt_outletName;
    }
    public WebElement getEmail() {
        return txt_email;
    }
    public WebElement getSaveButton() {
        return btn_save;
    }
    public WebElement getLinkAllRadioButton() {
        return rbtn_linkall;
    }
    public WebElement getContinueButton() {
        return btn_continue;
    }


    /**
     * @author Vidhi Chapanera
     * @date 27 December 2021
     * @return
     * @throws Exception
     * @discription this method is used to Verify opening/closing Timing
     */
    @Step("Verify opening/closing Timing")
    public boolean VerifyTiming() {
        try {
            sleepFor(5);
            WebElement day = new WebDriverWait(driver, 90).
                    until(ExpectedConditions.
                            presenceOfElementLocated(By.xpath("//table//tbody//tr[1]//td//div[contains(@class,'bg-yellow-crusta')]" +
                                    "//span[contains(text(),': Closed')]//preceding-sibling::span[normalize-space(.)]")));
            Actions action = new Actions(driver);
            String closedDay = day.getText();
            WebElement btn = new WebDriverWait(driver, 90).
                    until(ExpectedConditions.
                            presenceOfElementLocated(By.xpath("//table//tbody//tr[1]//td//a[text()='Edit']")));
            btn.click();
            sleepFor(7);
            Format f1 = new SimpleDateFormat("EE");
            Format f = new SimpleDateFormat("EEEE");
            WebElement closingScheduleElement = new WebDriverWait(driver, 90).
                    until(ExpectedConditions.
                            presenceOfElementLocated(By.xpath("//td[text()='"+f.format(f1.parseObject(closedDay))+"']//following-sibling::td//input[contains(@class,'ng-empty')]")));
            System.out.println("//td[text()='"+f.format(f1.parseObject(closedDay))+"']//following-sibling::td//input");
            Assert.assertTrue(closingScheduleElement.getAttribute("class").contains("ng-empty"));
            PageFactory.initElements(driver, DiscountOffers.class).getCloseICon().click();
            sleepFor(5);

            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }






}
