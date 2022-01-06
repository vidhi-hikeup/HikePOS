package StoreSetupPO.ReceiptTemplatesPO;

import CommonPO.BasePage;
import CommonPO.CenterlizePO;
import PointofSalePO.ProcessSalePO.ProcessSale;
import StoreSetupPO.LoyaltyPointsPO.LoyaltyPoints;
import io.qameta.allure.Step;
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
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * @author Vidhi Chapanera
 * @date 10 March 2021
 */
public class ReceiptTemplates extends BasePage {

    public WebDriver driver;
    public static String paymentType = "";
    public static String headerText = "This is Automation Header text";
    public static String footerText = "This is Automation Footer text";


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Receipt templates button
     * @date 10 March 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//span[contains(text(),'Receipt templates')]//parent::a"
    )
    WebElement btn_Receipttemplates;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for logo chk box
     * @date 10 March 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//label[@for='logo']"
    )
    WebElement chk_logo;


    public ReceiptTemplates(WebDriver driver) {
        this.driver = driver;
    }
    public WebElement getReceiptTemplates() {
        return btn_Receipttemplates;
    }
    public WebElement getLogocheckBox() {
        return chk_logo;
    }

    /**
     * @author Vidhi Chapanera
     * @date 10 March 2021
     * @return
     * @throws Exception
     * @discription this method is used to add receipt templates
     */
    @Step("add receipt templates")
    public boolean addReceiptTemplates() {
        try {
            sleepFor(5);
            List<WebElement> elementList = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//table[@id='TemplateDataTable']//tbody//tr//td[1]//a[text()]")));
            for (int i=0 ;i<elementList.size();i++){
                if (elementList.get(i).getText().contains("Default Template"))
                    elementList.get(i).click();
                break;
            }
            sleepFor(5);
           /* WebElement webElement = new WebDriverWait(driver,60)
                    .until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//div[contains(@class,'fileinput')]//img")));
            String s = webElement.getAttribute("src");
            if (s.contains(General.src))
                System.out.println(" ");*/
            driver.switchTo().frame(0);
            sleepFor(2);
            driver.findElement(By.tagName("p")).click();
            Actions actions = new Actions(driver);
            actions.sendKeys(headerText).build().perform();
            sleepFor(2);
            driver.switchTo().defaultContent();
            sleepFor(2);
            driver.switchTo().frame(1);
            sleepFor(2);
            driver.findElement(By.tagName("p")).click();
            actions.sendKeys(footerText).build().perform();
            sleepFor(2);
            driver.switchTo().defaultContent();
            sleepFor(2);
            PageFactory.initElements(driver,LoyaltyPoints.class).getSaveButton().click();
            sleepFor(2);
            return true;
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    /**
     * @author Vidhi Chapanera
     * @date 09 March 2021
     * @return
     * @throws Exception
     * @discription this method is used to add new sale
     */
    @Step("add new sale")
    public boolean addNewSale() {
        CenterlizePO centerlizePO = PageFactory.initElements(driver,CenterlizePO.class);
        try {
            sleepFor(15);
            PageFactory.initElements(driver, ProcessSale.class).getSearchBar().sendKeys("Demo Skirt");
            sleepFor(2);
            Actions actions = new Actions(driver);
            actions.sendKeys(Keys.TAB).build().perform();
            sleepFor(1);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, ProcessSale.class).getPayButton());
            centerlizePO.clickOnButton(PageFactory.initElements(driver, ProcessSale.class).getCashButton());
            sleepFor(3);
            String mainWindowHandle = driver.getWindowHandle();
            Set<String> allWindowHandles = driver.getWindowHandles();
            Iterator<String> iterator = allWindowHandles.iterator();
            while (iterator.hasNext()) {
                String ChildWindow = iterator.next();
                if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
                    driver.switchTo().window(ChildWindow);
                    WebElement text = new WebDriverWait(driver,60).until(ExpectedConditions.presenceOfElementLocated(By.tagName("print-preview-app")));
                    Actions actions1 = new Actions(driver);
                    actions1.sendKeys(Keys.TAB).build().perform();
                    actions1.sendKeys(Keys.ENTER).build().perform();
                }
            }
            sleepFor(2);
            driver.switchTo().window(mainWindowHandle);
            sleepFor(3);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, ProcessSale.class).getEmailButton());
            sleepFor(1);
            centerlizePO.enterDataUsingSendkeys(PageFactory.initElements(driver, ProcessSale.class).getTextEmail(),"vidhi.hikeup@gmail.com");
            sleepFor(1);
            actions.sendKeys(Keys.TAB).build().perform();
            sleepFor(2);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, ProcessSale.class).getSendIconButton());
            sleepFor(10);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, ProcessSale.class).getAddNewSaleButton());
            sleepFor(3);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
