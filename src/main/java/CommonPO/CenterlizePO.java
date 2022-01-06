package CommonPO;

import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Vidhi Chapanera
 * @date 11 January 2021
 */
public class CenterlizePO extends BasePage {

    public WebDriver driver;

    public CenterlizePO(WebDriver driver) {
        this.driver = driver;
    }


    /**
     * @author Vidhi Chapanera
     * @date 11 January 2021
     * @param element
     * @return
     * @throws Exception
     * @discription this methd is used to click on button
     */
    @Step("click on button" + "\n" + "element:{0}")
    public boolean clickOnButton(WebElement element) {
        try {
            sleepFor(1);
            WebElement button = new WebDriverWait(driver, 90).
                    until(ExpectedConditions.elementToBeClickable(element));
            Actions action = new Actions(driver);
            action.moveToElement(button).build().perform();
            JavascriptExecutor executor = (JavascriptExecutor)driver;
            executor.executeScript("arguments[0].click();", button);
            sleepFor(1);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }


    /**
     * @param data
     * @param element
     * @return
     * @throws Exception
     * @author Vidhi Chapanera
     * @date 11 January 2021
     * @discription this Method is used to enter data to the text box
     */
    @Step("enter data to the Textbox" + "\n" + "element : {0} and data : {1} ")
    public boolean enterDataUsingSendkeys(WebElement element, String data) {
        try {
            sleepFor(1);
            WebElement txt = new WebDriverWait(driver, 90).
                    until(ExpectedConditions.visibilityOf(element));
            txt.sendKeys(data);
            sleepFor(1);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }


    /**
     * @param element
     * @return
     * @throws Exception
     * @author Vidhi Chapanera
     * @date 11 January 2021
     * @discription this Method is used to clear data to the text box
     */
    @Step("enter data to the Textbox" + "\n" + "element : {0} and data : {1} ")
    public boolean clearText(WebElement element) {
        try {
            sleepFor(1);
            WebElement txt = new WebDriverWait(driver, 90).
                    until(ExpectedConditions.visibilityOf(element));
            txt.clear();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }


    /**
     * @author Vidhi Chapanera
     * @date 13 January 2021
     * @param element
     * @param value
     * @return
     * @discription this method is used to select value from drop down
     */
    @Step("select value from dopdwon"+ "\n" + "element : {0} and value : {1}")
    public boolean selectValueFromDropDownUsingIndex(WebElement element, int value) {
        try {
            sleepFor(3);
            WebElement dpdn = new WebDriverWait(driver, 90).
                    until(ExpectedConditions.visibilityOf(element));
            Select select = new Select(dpdn);
            sleepFor(1);
            select.selectByIndex(value);
            sleepFor(1);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }


    /**
     * @param element
     * @param value
     * @return
     * @throws Exception
     * @author Vidhi Chapanera
     * @date 13 January 2021
     * @discription this Method is used to select value from drop down
     */
    @Step("select value from dopdwon" + "\n" + "element : {0} and value : {1}")
    public boolean selectValueFromDropDown(WebElement element, String value) {
        try {
            sleepFor(1);
            WebElement dpdn = new WebDriverWait(driver, 90).
                    until(ExpectedConditions.visibilityOf(element));
            Select select = new Select(dpdn);
            sleepFor(1);
            select.selectByVisibleText(value);
            sleepFor(1);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }


    /**
     * @param element
     * @return
     * @throws Exception
     * @author Vidhi Chapanera
     * @date 13 January 2021
     * @discription this Method is used to verify element is display or not
     */
    @Step("verify button is displayed" + "\n" + "element : {0}")
    public boolean verifyElemntIsDisplay(WebElement element) {
        try {
            sleepFor(1);
            WebElement btn = new WebDriverWait(driver, 30).
                    until(ExpectedConditions.visibilityOf(element));
            if (btn.isDisplayed())
                return true;
            return false;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }


    /**
     * @param text
     * @return
     * @throws Exception
     * @author Vidhi Chapanera
     * @date 18 January 2021
     * @discription this Method is used to verify page title
     */
    @Step("verify current title" + "\n" + "element : {0}")
    public boolean verifyTitle(String text) {
        try {
            sleepFor(1);
            String title = driver.getTitle();
            if (title.contains(text))
                return true;
            return false;
        } catch (Exception e) {
            return false;
        }
    }
}