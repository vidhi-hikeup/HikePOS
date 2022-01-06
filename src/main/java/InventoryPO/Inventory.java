package InventoryPO;

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
public class Inventory extends BasePage {

    public WebDriver driver;
    public static String dataText = "";

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Inventory button
     * @date 22 January 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//span[contains(text(),'Inventory')]//parent::a[contains(@class,'auto')]"
    )
    WebElement btn_inventory;


    public Inventory(WebDriver driver) {
        this.driver = driver;
    }
    public WebElement getInventoryButton() {
        return btn_inventory;
    }


    /**
     * @author Vidhi Chapanera
     * @date 22 January 2021
     * @return
     * @throws Exception
     * @discription this method is used to click on Inventory button
     */
    @Step("click on Inventory button")
    public boolean clickOnInventoryButton() {
        try {
            sleepFor(1);
            WebElement storebtn = new WebDriverWait(driver, 90).
                    until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'Inventory')]//parent::a[contains(@class,'auto')]//parent::li")));
            if (storebtn.getAttribute("class").contains("open")){
                System.out.println("");
            }else {
                WebElement button = new WebDriverWait(driver, 90).
                        until(ExpectedConditions.visibilityOf(getInventoryButton()));
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