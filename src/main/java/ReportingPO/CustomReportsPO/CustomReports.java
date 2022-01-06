package ReportingPO.CustomReportsPO;

import CommonPO.BasePage;
import CommonPO.CenterlizePO;
import Config.ExcelUtils;
import Config.WriteUtils;
import io.qameta.allure.Step;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author Vidhi Chapanera
 * @date 11 March 2021
 */
public class CustomReports extends BasePage {

    public WebDriver driver;
    public static String titleText = "Automation Title";
    public static String testDate = "";
    public static XSSFWorkbook workbook;
    public static XSSFSheet sheet;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Custom reports button
     * @date 11 March 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//span[contains(text(),'Reporting')]//parent::a[contains(@class,'auto')]//parent::li//ul//li//span[contains(text(),'Custom reports')]//parent::a"
    )
    WebElement btn_customreports;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for add custom report button
     * @date 11 March 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//button[text()=' Add custom report']"
    )
    WebElement btn_addcustomreports;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for delivery button
     * @date 11 March 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//ul[contains(@class,'justify')]//li//a[contains(text(),'Delivery')]"
    )
    WebElement btn_delivery;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Recipients button
     * @date 11 March 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//ul[contains(@class,'justify')]//li//a[contains(text(),'Recipients')]"
    )
    WebElement btn_recipients;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Report section/s button
     * @date 11 March 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//ul[contains(@class,'justify')]//li//a[contains(text(),'Report section/s')]"
    )
    WebElement btn_reportsection;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for title input box
     * @date 11 March 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//label[contains(text(),'Title')]//parent::div//input"
    )
    WebElement txt_title;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for reporting period dropdown
     * @date 11 March 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//label[text()='Reporting period']//parent::div//div"
    )
    WebElement dropdown_reportingperiod;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Recipients input box
     * @date 11 March 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//label[text()='Recipients']//parent::div//input"
    )
    WebElement txt_recipients;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Message input box
     * @date 11 March 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//label[text()='Message']//parent::div//textarea"
    )
    WebElement txt_message;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Message input box
     * @date 11 March 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//span[@placeholder='Select report section']//following-sibling::li//input"
    )
    WebElement txt_reportsection;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for download button
     * @date 11 March 2021
     */
    @FindBy(
            how = How.CSS,
            using = "input[value='Download']"
    )
    WebElement btn_download;

    public CustomReports(WebDriver driver) {
        this.driver = driver;
    }
    public WebElement getCustomReportsButton() {
        return btn_customreports;
    }
    public WebElement getAddCustomReportsButton() {
        return btn_addcustomreports;
    }
    public WebElement getDeliveryButton() {
        return btn_delivery;
    }
    public WebElement getRecipientsButton() {
        return btn_recipients;
    }
    public WebElement getReportSectionButton() {
        return btn_reportsection;
    }
    public WebElement getTitleBox() {
        return txt_title;
    }
    public WebElement getReportingPeriod() {
        return dropdown_reportingperiod;
    }
    public WebElement getRecipients() {
        return txt_recipients;
    }
    public WebElement getMessage() {
        return txt_message;
    }
    public WebElement getReportSection() {
        return txt_reportsection;
    }
    public WebElement getDownloadButton() {
        return btn_download;
    }

    /**
     * @author Vidhi Chapanera
     * @date 11 March 2021
     * @return
     * @throws Exception
     * @discription this method is used to add Custom Reports
     */
    @Step("add Custom Reports")
    public boolean addCustomRepots() {
        Actions actions = new Actions(driver);
        CenterlizePO centerlizePO = PageFactory.initElements(driver,CenterlizePO.class);
        String testData = "";
        try {
            sleepFor(5);
            centerlizePO.clickOnButton(getAddCustomReportsButton());
            sleepFor(4);
            centerlizePO.clickOnButton(getDeliveryButton());
            sleepFor(1);
            centerlizePO.enterDataUsingSendkeys(getTitleBox(),titleText);
            sleepFor(1);
            centerlizePO.clickOnButton(getReportingPeriod());
            WebElement e = new WebDriverWait(driver,50).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//li[text()='Last 7 days']")));
            e.click();
            DateFormat dateFormat = new SimpleDateFormat("MMM dd, yyy");
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.DATE, -6);
            testDate = dateFormat.format(calendar.getTime()) + " - " + dateFormat.format(new Date());
            sleepFor(2);
            centerlizePO.clickOnButton(getRecipientsButton());
            centerlizePO.enterDataUsingSendkeys(getRecipients(),"vidhi.hikeup@gmail.com");
            actions.sendKeys(Keys.TAB).build().perform();
            centerlizePO.enterDataUsingSendkeys(getMessage(),"This Message is for Automation Testing purpose");
            sleepFor(5);
            centerlizePO.clickOnButton(getReportSectionButton());
            centerlizePO.clickOnButton(getReportSection());
            /*List<WebElement> list = new WebDriverWait(driver,50).until(ExpectedConditions.
                    presenceOfAllElementsLocatedBy(By.xpath
                            ("//input[@placeholder='Select report section']//parent::li//parent::ul//following-sibling::div//ul//li[@role]")));
            System.out.println(list.size());
            for (int i=0 ; i<list.size();i++){
                centerlizePO.clickOnButton(getReportSection());
                actions.sendKeys(Keys.TAB).build().perform();
            }*/
            actions.sendKeys(Keys.TAB).build().perform();
            actions.sendKeys(Keys.PAGE_UP).build().perform();
            sleepFor(5);
            List<WebElement> dataField = new WebDriverWait(driver,60).until
                    (ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//table[contains(@class,'table-vert')]//tbody//tr//td//a")));
            for (int i =0 ; i<dataField.size();i++){
                String s = dataField.get(i).getText();
                testData = s.split(" ")[0] + " " + s.split(" ")[1];
                centerlizePO.clickOnButton(dataField.get(i));
                sleepFor(1);
                List<WebElement> bold = new WebDriverWait(driver,60).until
                        (ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//span[contains(@class,'uppercase')]")));
                if (bold.get(0).getText().contains(s))
                    System.out.println(true);
                ExcelUtils.removeAllCellDataString(System.getProperty("user.dir") + "\\xlsx File\\CustomRepots.xlsx",testData);
                sleepFor(1);
                List<WebElement> chk = new WebDriverWait(driver,60).until
                        (ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='md-checkbox']//input[contains(@class,'ng-not-empty')]//parent::div//label[text()]")));
                for(int j=0;j<chk.size();j++){
                    String data = chk.get(j).getText();
                    WriteUtils.writeRosterDataInExstingExcel(testData,System.getProperty("user.dir") + "\\xlsx File\\CustomRepots.xlsx",data);
                }
                sleepFor(2);
                List<String> list2 = ExcelUtils.getAllCellDataStringForCustomeReport(testData);
                for (String s2 : list2) {
                    List<WebElement> preview = new WebDriverWait(driver,30).until
                            (ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//span[text()='Preview']//parent::div//parent::div//parent::div//thead//th//div[contains(@class,'binding')][text()]")));
                    for (int k =0;k<preview.size();k++) {
                        if (preview.get(k).getText().contains(s2)) {
                            System.out.println("");
                        }
                    }
                }
                actions.sendKeys(Keys.ESCAPE).build().perform();
                sleepFor(4);
            }
            return true;
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }


    /**
     * @author Vidhi Chapanera
     * @date 11 March 2021
     * @return
     * @throws Exception
     * @discription this method is used to open downloaded pdf
     */
    @Step("open downloaded pdf")
    public boolean openDownloadedPDf() {
        try{
            sleepFor(5);
            JavascriptExecutor jse = (JavascriptExecutor)driver;
            jse.executeScript("window.open()");
            ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));
            File f = new File(System.getProperty("user.dir") + "\\download\\");
            File[] files = f.listFiles(File::isFile);
            long lastModifiedTime = Long.MIN_VALUE;
            File chosenFile = null;
            if (files != null) {
                for (File file : files) {
                    if (file.lastModified() > lastModifiedTime) {
                        chosenFile = file;
                        lastModifiedTime = file.lastModified();
                    }
                }
                System.out.println(chosenFile);
            }
            String url = String.valueOf(chosenFile);
            driver.get(url);
            String pdfContent = readPdfContent();
            System.out.println(pdfContent);
            if (pdfContent.contains(titleText))
                System.out.println("true");
            if (pdfContent.contains(testDate))
                System.out.println("true");
            sleepFor(5);
            List<String> list2 = ExcelUtils.getAllCellDataStringForCustomeReport01();
            for (String s2 : list2) {
                if (pdfContent.contains(s2))
                    System.out.println("true");
            }
            sleepFor(2);
            jse.executeScript("window.close()");
            driver.switchTo().window(tabs.get(0));
            return true;
        } catch (Exception e) {
            System.out.println(e.toString());
            return false;
        }
    }


    /**
     * @author Vidhi Chapanera
     * @date 11 March 2018
     */
    @Step("Read pdf")
    public String readPdfContent() throws IOException {
        URL pdfUrl = new URL(driver.getCurrentUrl());
        InputStream in = pdfUrl.openStream();
        BufferedInputStream bf = new BufferedInputStream(in);
        PDDocument doc = PDDocument.load(bf);
        int numberOfPages = getPageCount(doc);
        System.out.println("The total number of pages "+numberOfPages);
        String content = new PDFTextStripper().getText(doc);
        doc.close();
        return content;
    }

    /**
     * @author Vidhi Chapanera
     * @date 11 March 2018
     * @param doc
     */
    @Step("get Page Count"+"\n"+"doc:{0}")
    public int getPageCount(PDDocument doc) {
        //get the total number of pages in the pdf document
        int pageCount = doc.getNumberOfPages();
        return pageCount;
    }


}