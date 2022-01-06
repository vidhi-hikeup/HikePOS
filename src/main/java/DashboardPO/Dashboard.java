package DashboardPO;

import CommonPO.BasePage;
import CommonPO.CenterlizePO;
import Config.ExcelUtils;
import io.qameta.allure.Step;
import org.apache.log4j.BasicConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.util.List;

/**
 * @author Vidhi Chapanera
 * @date 22 January 2021
 */
public class Dashboard extends BasePage {

    public WebDriver driver;
    public static String dataText = "";

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Dashboard button
     * @date 22 January 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//span[contains(text(),'Dashboard')]//parent::a[contains(@class,'toggle')]"
    )
    WebElement btn_dashboard;
    /**
     * @author Vidhi Chapanera
     * @discription this locator is for add button
     * @date 22 January 2021
     */
    @FindBy(
            how = How.XPATH,
            using = " //button[@type='button']"
    )
    WebElement btn_add;



    public Dashboard(WebDriver driver) {
        this.driver = driver;
    }
    public WebElement getDashboardButton() {
        return btn_dashboard;
    }
    public WebElement getAddButton() {
        return btn_add;
    }


    /**
     * @author Vidhi Chapanera
     * @date 22 January 2021
     * @return
     * @throws Exception
     * @discription this method is used to click on Dashboard button
     */
    @Step("click on Dashboard button")
    public boolean clickOnIDashboardButton() {
        try {
            sleepFor(1);
            WebElement storebtn = new WebDriverWait(driver, 90).
                    until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'Dashboard')]//parent::a[contains(@class,'toggle')]//parent::li")));
            if (storebtn.getAttribute("class").contains("open")){
                System.out.println("");
            }else {
                WebElement button = new WebDriverWait(driver, 90).
                        until(ExpectedConditions.visibilityOf(getDashboardButton()));
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


    /**
     * @author Vidhi Chapanera
     * @date 24 December 2021
     * @return
     * @throws Exception
     * @discription this method is used Verify Add Button Function
     */
    @Step("Verify Add Button Function")
    public boolean verifyAddButtonFunction() {
        BasicConfigurator.configure();
        Actions actions = new Actions(driver);
        try {
            sleepFor(15);
            List<String> stringList = ExcelUtils.getAllCellDataStringAddButtons();
            for (String s : stringList) {
                sleepFor(2);
                PageFactory.initElements(driver,CenterlizePO.class).clickOnButton(getAddButton());
                sleepFor(5);
                if (s.split("-")[0].contains("New sale")){
                   WebElement element = new WebDriverWait(driver,160)
                           .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[normalize-space(.)='"+s.split("-")[0]+"']")));
                   element.click();
                   sleepFor(9);
                   Assert.assertTrue(driver.findElement(By.cssSelector("div#"+s.split("-")[1])).isDisplayed());
                   sleepFor(3);
                }else {
                    WebElement element = new WebDriverWait(driver,160)
                            .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[normalize-space(.)='"+s.split("-")[0]+"']")));
                    element.click();
                    sleepFor(5);
                    Assert.assertTrue(driver.findElement(By.xpath("//form[@name='"+s.split("-")[1]+"']")).isDisplayed());
                    sleepFor(3);
                    actions.sendKeys(Keys.ESCAPE).build().perform();
                    sleepFor(5);
                }
            }
            return true;
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }


}