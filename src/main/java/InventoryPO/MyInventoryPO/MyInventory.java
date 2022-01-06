package InventoryPO.MyInventoryPO;

import CommonPO.BasePage;
import CommonPO.CenterlizePO;
import InventoryPO.Inventory;
import ProductsPO.ProductsPO.Products;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Vidhi Chapanera
 * @date 10 February 2021
 */
public class MyInventory extends BasePage {

    public WebDriver driver;
    public static String dataText = "";

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for my Inventory button
     * @date 10 February 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//span[contains(text(),'My inventory')]//parent::a"
    )
    WebElement btn_myinventory;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for search bar input box
     * @date 10 February 2021
     */
    @FindBy(
            how = How.ID,
            using = "advancesearchtext"
    )
    WebElement txxbox_search;

    public MyInventory(WebDriver driver) {
        this.driver = driver;
    }
    public WebElement getMyInventoryButton() {
        return btn_myinventory;
    }
    public WebElement getSearchBox() {
        return txxbox_search;
    }


    /**
     * @return
     * @throws Exception
     * @author Vidhi Chapanera
     * @date 16 March 2021
     * @discription this method is use to  Linked product edit, go to my inventory page, click on any product name , its should
     *         //be open in new tab and redirect on selected product edit page
     */
    @Step("Linked product edit, go to my inventory page, click on any product name , its should\n" +
            "be open in new tab and redirect on selected product edit page")
    public boolean verifyProductEdit() {
        CenterlizePO centerlizePO = PageFactory.initElements(driver, CenterlizePO.class);
        try {
            sleepFor(5);
            PageFactory.initElements(driver, Inventory.class).clickOnInventoryButton();
            sleepFor(2);
            centerlizePO.clickOnButton(getMyInventoryButton());
            sleepFor(7);
            List<WebElement> inventoryItem = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy
                            (By.xpath("//table[@id='InventoryRecordDataTable']//tr//td[1]//a")));
            String inventoryItemName = "";
            for (int i =0;i<inventoryItem.size();i++){
                inventoryItemName = inventoryItem.get(i).getText();
                inventoryItem.get(i).click();
                sleepFor(1);
                break;
            }
            sleepFor(10);
            ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));
            if (PageFactory.initElements(driver, Products.class).getProductName().getAttribute("value").contains(inventoryItemName))
                System.out.println("");
            if (tabs.size()>1)
                System.out.println(tabs.size());
            driver.close();
            driver.switchTo().window(tabs.get(0));
            sleepFor(5);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

}