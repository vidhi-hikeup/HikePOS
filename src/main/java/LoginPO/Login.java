package LoginPO;

import CommonPO.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * @author Vidhi Chapanera
 * @date 18 January 2021
 */
public class Login extends BasePage {

    public WebDriver driver;
    public static String dataText = "";

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for your account address input box
     * @date 18 January 2021
     */
    @FindBy(
            how = How.ID,
            using = "stroreWebaddress"
    )
    WebElement txtbox_acccountaddress;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for email or username input box
     * @date 18 January 2021
     */
    @FindBy(
            how = How.NAME,
            using = "usernameOrEmailAddress"
    )
    WebElement txtbox_email;

    /**
     *
     * @author Vidhi Chapanera
     * @discription this locator is for password input box
     * @date 18 January 2021
     */
    @FindBy(
            how = How.NAME,
            using = "password"
    )
    WebElement txtbox_password;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for login button
     * @date 18 January 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//button[@type='submit' and contains(@class,'green-meadow')]"
    )
    WebElement btn_login;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for hike logo
     * @date 18 January 2021
     */
    @FindBy(
            how = How.CSS,
            using = "img[alt=Hikeup]"
    )
    WebElement logo_hike;

    public Login(WebDriver driver) {
        this.driver = driver;
    }
    public WebElement getAccountAddressTextBox() {
        return txtbox_acccountaddress;
    }
    public WebElement getEmailTextBox() {
        return txtbox_email;
    }
    public WebElement getpasswordTextBox() {
        return txtbox_password;
    }
    public WebElement getLoginButton() {
        return btn_login;
    }
    public WebElement getHikeLogo() {
        return logo_hike;
    }


}