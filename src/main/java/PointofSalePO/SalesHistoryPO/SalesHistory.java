package PointofSalePO.SalesHistoryPO;

import CommonPO.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * @author Vidhi Chapanera
 * @date 09 February 2021
 */
public class SalesHistory extends BasePage {

    public WebDriver driver;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Sales History button
     * @date 09 February 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//span[contains(text(),'Sales history')]//parent::a"
    )
    WebElement btn_saleshistory;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for calender option button
     * @date 09 February 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//i[@class='fa fa-calendar']//parent::div"
    )
    WebElement btn_calenderoption;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for last 30 days button
     * @date 09 February 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//div[@class='ranges']//ul//li[text()='Last 30 days']"
    )
    WebElement btn_last30days;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for pagination drop down
     * @date 09 February 2021
     */
    @FindBy(
            how = How.CSS,
            using = "select[name=SalesTable_length]"
    )
    WebElement drpdwn_pagination;

    public SalesHistory(WebDriver driver) {
        this.driver = driver;
    }
    public WebElement getSalesHistoryButton() {
        return btn_saleshistory;
    }
    public WebElement getCalenderOptionButton() {
        return btn_calenderoption;
    }
    public WebElement getLast30DaysOption() {
        return btn_last30days;
    }
    public WebElement getPaginationDropDown() {
        return drpdwn_pagination;
    }

}