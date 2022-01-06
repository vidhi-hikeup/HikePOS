package CustomersPO;

import CommonPO.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Vidhi Chapanera
 * @date 22 January 2021
 */
public class Customers extends BasePage {

    public WebDriver driver;
    public static String dataText = "";

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Customers button
     * @date 22 January 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//span[contains(text(),'Customers')]//parent::a[contains(@class,'auto')]"
    )
    WebElement btn_customers;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for firstname input box
     * @date 04 February 2021
     */
    @FindBy(
            how = How.CSS,
            using = "input#firstName"
    )
    WebElement txtbox_firstname;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for lastname input box
     * @date 04 February 2021
     */
    @FindBy(
            how = How.CSS,
            using = "input#lastName"
    )
    WebElement txtbox_lastname;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for email input box
     * @date 04 February 2021
     */
    @FindBy(
            how = How.CSS,
            using = "input#email"
    )
    WebElement txtbox_email;

    public Customers(WebDriver driver) {
        this.driver = driver;
    }
    public WebElement getCustomersButton() {
        return btn_customers;
    }
    public WebElement getFirstName() {
        return txtbox_firstname;
    }
    public WebElement getLastName() {
        return txtbox_lastname;
    }
    public WebElement getEmail() {
        return txtbox_email;
    }



    /**
     * @author Vidhi Chapanera
     * @date 22 January 2021
     * @return
     * @throws Exception
     * @discription this method is used to click on Customers button
     */
    @Step("click on Customers button")
    public boolean clickOnCustomersButton() {
        try {
            sleepFor(1);
            WebElement storebtn = new WebDriverWait(driver, 90).
                    until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'Customers')]//parent::a[contains(@class,'auto')]//parent::li")));
            if (storebtn.getAttribute("class").contains("open")){
                System.out.println("");
            }else {
                WebElement button = new WebDriverWait(driver, 90).
                        until(ExpectedConditions.visibilityOf(getCustomersButton()));
                Actions action = new Actions(driver);
                action.moveToElement(button).build().perform();
                button.click();
            }
            sleepFor(1);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }


}