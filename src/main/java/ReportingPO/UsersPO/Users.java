package ReportingPO.UsersPO;

import CommonPO.BasePage;
import CommonPO.CenterlizePO;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author Vidhi Chapanera
 * @date 29 January 2021
 */
public class Users extends BasePage {

    public WebDriver driver;
    public static String dataText = "";

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for users button
     * @date 29 January 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//span[contains(text(),'Reporting')]//parent::a[contains(@class,'auto')]//parent::li//ul//li//span[contains(text(),'Users')]//parent::a"
    )
    WebElement btn_users;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for pagination drop down
     * @date 02 February 2021
     */
    @FindBy(
            how = How.CSS,
            using = "select[name=dtUserTimeCardDataTable_length]"
    )
    WebElement drpdwn_pagination;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for by date button
     * @date 02 February 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//span[text()='Timecards by Date']//parent::uib-tab-heading//parent::a"
    )
    //@FindBy(
            // how = How.XPATH,
            // using = "//span[text()='By date']//parent::uib-tab-heading//parent::a"
            // )
    WebElement btn_bydate;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for by date button
     * @date 15 December 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//span[text()='Major activity log']//parent::uib-tab-heading//parent::a"
    )
    WebElement btn_majoractivity;


    public Users(WebDriver driver) {
        this.driver = driver;
    }
    public WebElement getUsersButton() {
        return btn_users;
    }
    public WebElement getPaginationDropDown() {
        return drpdwn_pagination;
    }
    public WebElement getByDateButton() {
        return btn_bydate;
    }
    public WebElement getMajorActivityButton() {
        return btn_majoractivity;
    }


    /**
     * @author Vidhi Chapanera
     * @date 15 December 2021
     * @return
     * @throws Exception
     * @discription this method is used to get public ip
     */
    @Step("get Public ip")
    public String getPublicIp() throws IOException {
        URL whatismyip = new URL("http://myexternalip.com/raw");
        URLConnection c = whatismyip.openConnection();
        c.setConnectTimeout(1000);
        c.setReadTimeout(1000);
        BufferedReader in = new BufferedReader(new InputStreamReader(c.getInputStream()));
        return in.readLine();
    }


    /**
     * @author Vidhi Chapanera
     * @date 15 December 2021
     * @return
     * @throws Exception
     * @discription this method is used to Verify IP Address in Major Activity Log is as per machine IP
     */
    @Step("Verify IP Address in Major Activity Log is as per machine IP")
    public boolean VerifyMajorActivityLog() throws IOException {
        try {
            sleepFor(10);
            CenterlizePO centerlizePO = PageFactory.initElements(driver,CenterlizePO.class);
            centerlizePO.clickOnButton(getMajorActivityButton());
            sleepFor(7);
            WebElement element= new WebDriverWait(driver,60)
                    .ignoring(StaleElementReferenceException.class).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table[@id='dtMajorActivityDataTable']//tr[1]//td[4]")));
            Assert.assertEquals(element.getText(),getPublicIp());
            System.out.println("IP match.../");;
            sleepFor(2);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

}