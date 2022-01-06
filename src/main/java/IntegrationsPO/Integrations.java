package IntegrationsPO;

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
 * @date 19 March 2021
 */
public class Integrations extends BasePage {

    public WebDriver driver;
    public static String dataText = "";


    public Integrations(WebDriver driver) {
        this.driver = driver;
    }


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Integrations button
     * @date 19 March 2021
     */
    @FindBy(how = How.XPATH, using = "//span[contains(text(),'Integrations')]//parent::a")
    WebElement btn_Integrations;
    public WebElement getIntegrationsButton() {
        return btn_Integrations;
    }

}