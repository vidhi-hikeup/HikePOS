
package UsersPO.RosterPO;

import CommonPO.BasePage;
import CommonPO.CenterlizePO;
import Config.ExcelUtils;
import Config.WriteUtils;
import ProductsPO.DiscountOffersPO.DiscountOffers;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

/**
 * @author Vidhi Chapanera
 * @date 26 February 2021
 */
public class Roster extends BasePage {

    public WebDriver driver;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for roster button
     * @date 26 February 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//span[contains(text(),'Users')]//parent::a[contains(@class,'auto')]//parent::li//descendant::ul//span[contains(text(),'Roster')]//parent::a"
    )
    WebElement btn_roster;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for usual hours template button
     * @date 26 February 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//button[text()='Usual hours template']"
    )
    WebElement btn_usualhourstemplate;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for select staff member drop down
     * @date 26 February 2021
     */
    @FindBy(
            how = How.CSS,
            using = "a[placeholder='Select staff member']"
    )
    WebElement dropdown_selectstaffmember;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for select option button
     * @date 26 February 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//button[contains(text(),'Select option')]"
    )
    WebElement btn_selectoption;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Set usual hours button
     * @date 26 February 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//a[contains(text(),'Set usual hours')]"
    )
    WebElement btn_setusualhours;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for all work days checkbox
     * @date 26 February 2021
     */
    @FindBy(
            how = How.CSS,
            using = "label[for='working']"
    )
    WebElement chk_allworkdays;

    public Roster(WebDriver driver) {
        this.driver = driver;
    }
    public WebElement getRosterButton() {
        return btn_roster;
    }
    public WebElement getUsualHoursTemplateButton() {
        return btn_usualhourstemplate;
    }
    public WebElement getSelectStaffMemberDropDown() {
        return dropdown_selectstaffmember;
    }
    public WebElement getSelectOptionButton() {
        return btn_selectoption;
    }
    public WebElement getSetUsualHoursButton() {
        return btn_setusualhours;
    }
    public WebElement getAllWorkDaysCheckbox() {
        return chk_allworkdays;
    }

    /**
     * @return
     * @throws Exception
     * @author Vidhi Chapanera
     * @date 26 February 2021
     * @discription this method is use to Add Usual hours template
     */
    @Step("Add Usual hours template")
    public boolean addUsualHoursTemplateForStaffMember() {
        try {
            CenterlizePO centerlizePO = PageFactory.initElements(driver, CenterlizePO.class);
            sleepFor(10);
            List<String> list = ExcelUtils.getAllCellDataString();
            for (String s : list) {
                sleepFor(1);
                ExcelUtils.removeAllCellDataStringForRoster(System.getProperty("user.dir") + "\\xlsx File\\Roster.xlsx",s.split("/")[0].split("-")[0]+ " " + s.split("/")[0].split("-")[1]);
                sleepFor(5);
                centerlizePO.clickOnButton(getUsualHoursTemplateButton());
                sleepFor(3);
                centerlizePO.clickOnButton(getSelectStaffMemberDropDown());
                sleepFor(1);
                WebElement staffMember = new WebDriverWait(driver,60).
                        until(ExpectedConditions.presenceOfElementLocated
                                (By.xpath("//a[@placeholder='Select staff member']//parent::div//ul//li[@role='option']//div[text()='" + s.split("/")[0].split("-")[0]+ " " + s.split("/")[0].split("-")[1] + "']")));
                staffMember.click();
                sleepFor(3);
                List<WebElement> days = new WebDriverWait(driver,60).
                        until(ExpectedConditions.presenceOfAllElementsLocatedBy
                                (By.xpath("//table//tbody//td[@class='ng-binding']//following-sibling::td//div[contains(@class,'switch-on')]//parent::td//parent::tr//td[@class='ng-binding']")));
                for (int i=0;i<days.size();i++){
                    sleepFor(1);
                    String dayText = days.get(i).getText();
                    WebElement intimeelement = new WebDriverWait(driver,60).
                            until(ExpectedConditions.presenceOfElementLocated
                                    (By.xpath("//table//tbody//td[text()='" + dayText + "']//parent::tr//select[@ng-model='item.inTime']//option[@selected][text()]")));
                    String inTime = intimeelement.getText();
                    WebElement outtimeelement = new WebDriverWait(driver,60).
                            until(ExpectedConditions.presenceOfElementLocated
                                    (By.xpath("//table//tbody//td[text()='" + dayText + "']//parent::tr//select[@ng-model='item.outTime']//option[@selected][text()]")));
                    String outTime = outtimeelement.getText();
                    sleepFor(1);
                    String testData = dayText + " / " + "inTime-" + inTime + "_" + "outTime-" + outTime;
                    WriteUtils.writeRosterDataInExstingExcel(s.split("/")[0].split("-")[0]+ " " + s.split("/")[0].split("-")[1],System.getProperty("user.dir") + "\\xlsx File\\Roster.xlsx",testData);
                }
                sleepFor(1);
                centerlizePO.clickOnButton(getAllWorkDaysCheckbox());
                centerlizePO.clickOnButton(PageFactory.initElements(driver, DiscountOffers.class).getSaveButton());
                sleepFor(5);
                break;
            }
            sleepFor(2);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }


    /**
     * @return
     * @throws Exception
     * @author Vidhi Chapanera
     * @date 26 February 2021
     * @discription this method is use to verify added staff member in-out time
     */
    @Step("verify added staff member in-out time")
    public boolean verifyStaffMemberInOutTime() {
        CenterlizePO centerlizePO = PageFactory.initElements(driver, CenterlizePO.class);
        try {
            sleepFor(10);
            List<WebElement> chk = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy
                            (By.xpath("//table[@id='RosterDataTable']//tbody//tr//td//label")));
            System.out.println(chk.size());
            centerlizePO.clickOnButton(chk.get(0));
            /*for (int i=0;i<chk.size();i++){
                sleepFor(1);
                chk.get(i).click();
            }*/
            sleepFor(1);
            centerlizePO.clickOnButton(getSelectOptionButton());
            sleepFor(1);
            centerlizePO.clickOnButton(getSetUsualHoursButton());
            sleepFor(5);
            List<String> list = ExcelUtils.getAllCellDataString();
            for (String s : list) {
                sleepFor(1);
                List<String> list1 = ExcelUtils.getAllCellDataStringForRoster(s.split("/")[0].split("-")[0]+ " " + s.split("/")[0].split("-")[1]);
                for (String s1 : list1) {
                    List<WebElement> timeele = new WebDriverWait(driver,60).
                            until(ExpectedConditions.presenceOfAllElementsLocatedBy
                                    (By.xpath("//table[@id='RosterDataTable']//tbody//tr//td//a[contains(text(),'"+ s.split("/")[0].split("-")[0] +"')]//parent::td//following-sibling::td//div[contains(@ng-show,'true')]")));
                    for (int i=0;i<timeele.size();i++){
                        String time = timeele.get(i).getText();
                        if (time.split("\n")[0].contains(s1.split("_")[0].split("-")[1])
                                && time.split("\n")[1].contains(s1.split("_")[1].split("-")[1]))
                            System.out.println(" ");
                    }
                }
                break;
            }
            sleepFor(1);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}