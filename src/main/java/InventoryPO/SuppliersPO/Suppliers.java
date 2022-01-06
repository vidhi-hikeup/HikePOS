package InventoryPO.SuppliersPO;

import CommonPO.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * @author Vidhi Chapanera
 * @date 06 April 2021
 */
public class Suppliers extends BasePage {

    public WebDriver driver;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Suppliers button
     * @date 06 April 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//span[contains(text(),'Suppliers')]//parent::a"
    )
    WebElement btn_Suppliers;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for add new button
     * @date 06 April 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//i[@class='fa fa-plus']//parent::a"
    )
    WebElement btn_addnew;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Company name input box
     * @date 06 April 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//label[@for='CompanyName']//parent::div//input"
    )
    WebElement txt_cmpnyName;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for save button
     * @date 06 April 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//span[contains(text(),'Save')]//parent::button"
    )
    WebElement btn_save;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for search input box
     * @date 22 April 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//input[@type='search']"
    )
    WebElement txt_suppliersearch;


    public Suppliers(WebDriver driver) {
        this.driver = driver;
    }
    public WebElement getSuppliersButton() {
        return btn_Suppliers;
    }
    public WebElement getAddNewButton() {
        return btn_addnew;
    }
    public WebElement getCompanyName() {
        return txt_cmpnyName;
    }
    public WebElement getSaveButton() {
        return btn_save;
    }
    public WebElement getSearch() {
        return txt_suppliersearch;
    }
}