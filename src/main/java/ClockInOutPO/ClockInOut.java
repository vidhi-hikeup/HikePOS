package ClockInOutPO;

import CommonPO.BasePage;
import CommonPO.CenterlizePO;
import Config.ExcelUtils;
import Config.WriteUtils;
import ReportingPO.Reporting;
import ReportingPO.UsersPO.Users;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * @author Vidhi Chapanera
 * @date 28 January 2021
 */
public class ClockInOut extends BasePage {

    public WebDriver driver;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for icon clock
     * @date 28 January 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//i[@class='icon-clock']//parent::a"
    )
    WebElement icn_clock;

    public ClockInOut(WebDriver driver) {
        this.driver = driver;
    }
    public WebElement getClockIcon() {
        return icn_clock;
    }


    /**
     * @return
     * @throws Exception
     * @author Vidhi Chapanera
     * @date 28 January 2021
     * @discription this method is use to clock in all users
     */
    @Step("clock in all users")
    public boolean clockInAllUsers() {
        try {
            sleepFor(5);
            boolean flag = true;
            while (flag){
                sleepFor(3);
                List<WebElement> list = new WebDriverWait(driver, 30).ignoring(StaleElementReferenceException.class).until
                        (ExpectedConditions.refreshed(ExpectedConditions.presenceOfAllElementsLocatedBy
                                (By.xpath("//div[@class='portlet-body']//div[contains(@class,'font-dark')]//button[contains(text(),'Clock in')]"))));

                list.get(0).click();
                sleepFor(3);
                String[] strArray2 = new String[]{"0", "0", "0", "0"};
                for (String s : strArray2) {
                    WebElement element = new WebDriverWait(driver, 60).ignoring(StaleElementReferenceException.class).
                            until(ExpectedConditions.presenceOfElementLocated
                                    (By.xpath("//div[@class='enter-pin-wrapper']//button[text()='" + s + "']")));
                    element.click();
                    sleepFor(1);
                }
                if (list.size() == 1){
                    flag = false;
                }
            }
            return true;
        } catch (org.openqa.selenium.StaleElementReferenceException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }


    /**
     * @return
     * @throws Exception
     * @author Vidhi Chapanera
     * @date 28 January 2021
     * @discription this method is Get clock in users name and time
     */
    @Step("Get clock in users name and time")
    public boolean getUsersNameAndTime() throws IOException {
        ExcelUtils.removeAllCellDataString(System.getProperty("user.dir") + "\\xlsx File\\ClockInOut.xlsx");
        try {
            sleepFor(10);
            List<WebElement> userName = new WebDriverWait(driver, 30).ignoring(StaleElementReferenceException.class).until
                    (ExpectedConditions.refreshed(ExpectedConditions.presenceOfAllElementsLocatedBy
                            (By.xpath("//div[@class='portlet-body']//div[contains(@class,'portlet-title')]//p"))));
            List<WebElement> time = new WebDriverWait(driver, 30).ignoring(StaleElementReferenceException.class).until
                    (ExpectedConditions.refreshed(ExpectedConditions.presenceOfAllElementsLocatedBy
                            (By.xpath("//div[@class='portlet-body']//div[contains(@class,'portlet-title')]//parent::div//div[contains(@class,'text-green')]//following::span[1]"))));
            for (int i = 0; i<userName.size();i++){
                String user_itr = userName.get(i).getText();
                String timr_itr = time.get(i).getText();
                String data = user_itr + "/" + timr_itr ;
                WriteUtils.writeCountInExstingExcel(System.getProperty("user.dir") + "\\xlsx File\\ClockInOut.xlsx",data);
            }
            PageFactory.initElements(driver,CenterlizePO.class).clickOnButton
                    (PageFactory.initElements(driver, UsersPO.UserPO.Users.class).getSliderCloseIcon());
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
     * @date 28 January 2021
     * @discription this method is verify users log in reporting section
     */
    @Step("verify Users log in reporting section")
    public boolean verifyUsersLoginReportingSection() throws IOException {
        try {
            CenterlizePO centerlizePO = PageFactory.initElements(driver,CenterlizePO.class);
            PageFactory.initElements(driver, Reporting.class).clickOnReportingButton();
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Users.class).getUsersButton());
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Users.class).getByDateButton());
            Select select = new Select(PageFactory.initElements(driver,Users.class).getPaginationDropDown());
            select.selectByValue("100");
            List<String> list = ExcelUtils.getAllCellDataStringForClockInOutTime();
            for (String s : list) {
                sleepFor(2);
                /*SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMM, yyyy");
                String strDate = dateFormat.format(new Date());*/
                Calendar calendar = Calendar.getInstance();
                SimpleDateFormat sdf = new SimpleDateFormat("dd MMM, yyyy");
                sdf.setTimeZone(TimeZone.getTimeZone("Australia/Sydney"));
                String strDate=sdf.format(calendar.getTime());
                String cap = s.split("/")[0].split(" ")[0].substring(0,1).toUpperCase() + s.split(" ")[0].substring(1).toLowerCase();
                String cap1 = s.split("/")[0].split(" ")[1].substring(0,1).toUpperCase() + s.split("/")[0].split(" ")[1].substring(1).toLowerCase();
                String finalString = cap + " " + cap1;
                WebElement e = new WebDriverWait(driver,50).until
                        (ExpectedConditions.presenceOfElementLocated
                                (By.xpath("//table[@id='dtUserTimeCardDataTable']//tbody//tr//td[1][contains(text(),'"+strDate+"')]//parent::tr//td[3][contains(text(),'"+finalString+"')]//parent::tr//td[2]")));
                if (e.getText().contains(s.split("/")[1].split("-")[0]))
                    System.out.println("");
                sleepFor(1);
            }
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}