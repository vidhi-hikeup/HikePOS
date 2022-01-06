package ReportingPO.InventoryPO;

import CommonPO.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


/**
 * @author Vidhi Chapanera
 * @date 12 February 2021
 */
public class Inventory extends BasePage {

    public WebDriver driver;
    public static String dataText = "";

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Inventory button
     * @date 12 February 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//span[contains(text(),'Reporting')]//parent::a[contains(@class,'auto')]//parent::li//ul//li//span[contains(text(),'Inventory')]//parent::a"
    )
    WebElement btn_inventory;


    public Inventory(WebDriver driver) {
        this.driver = driver;
    }
    public WebElement getInventoryButton() {
        return btn_inventory;
    }

}