package CreateStorePO;

import CommonPO.BasePage;
import CommonPO.CenterlizePO;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author Vidhi Chapanera
 * @date 11 January 2021
 */
public class CreateStore extends BasePage {

    public WebDriver driver;
    public static String dataText = "";

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for start your free trial link
     * @date 11 January 2021
     */
    @FindBy(
            how = How.ID,
            using = "signuplink"
    )
    WebElement lnk_StartFreeTrial;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for first name input box
     * @date 11 January 2021
     */
    @FindBy(
            how = How.NAME,
            using = "FirstName"
    )
    WebElement txtbox_firstname;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for last name input box
     * @date 11 January 2021
     */
    @FindBy(
            how = How.NAME,
            using = "LastName"
    )
    WebElement txtbox_lastname;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for email input box
     * @date 11 January 2021
     */
    @FindBy(
            how = How.NAME,
            using = "AdminEmailAddress"
    )
    WebElement txtbox_email;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for phone input box
     * @date 11 January 2021
     */
    @FindBy(
            how = How.ID,
            using = "phone"
    )
    WebElement txtbox_phone;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for city input box
     * @date 11 January 2021
     */
    @FindBy(
            how = How.NAME,
            using = "location"
    )
    WebElement txtbox_city;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for password input box
     * @date 11 January 2021
     */
    @FindBy(
            how = How.NAME,
            using = "AdminPassword"
    )
    WebElement txtbox_password;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for continue button
     * @date 11 January 2021
     */
    @FindBy(
            how = How.ID,
            using = "next"
    )
    WebElement btn_continue;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for your account address input box
     * @date 12 January 2021
     */
    @FindBy(
            how = How.ID,
            using = "stroreWebaddress"
    )
    WebElement txtbox_acccountaddress;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for continue button your account address Page
     * @date 11 January 2021
     */
    @FindBy(
            how = How.
            ID, using = "next2"
    )
    WebElement btn_continue_onaccountaddress;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for tick mark icon on your account address Page
     * @date 13 January 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//input[@id='stroreWebaddress']//parent::div//descendant::span[@class='tick-mark']"
    )
    WebElement icn_tickmark;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Industry Type Drop down value
     * @date 13 January 2021
     */
    @FindBy(
            how = How.CSS,
            using = "select#ddlIndustries"
    )
    WebElement drpdwn_industrytype;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for create my store button
     * @date 13 January 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//button[contains(text(),'Create my store')]"
    )
    WebElement btn_createmystore;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for create my store button
     * @date 15 January 2021
     */
    @FindBy(
            how = How.CSS,
            using = "div.loader-vert"
    )
    WebElement icn_loder;

    public CreateStore(WebDriver driver) {
        this.driver = driver;
    }
    public WebElement getStartFreeTrialLink() {
        return lnk_StartFreeTrial;
    }
    public WebElement getFirstNameTextBox() {
        return txtbox_firstname;
    }
    public WebElement getLastNameTextBox() {
        return txtbox_lastname;
    }
    public WebElement getEmailTextBox() {
        return txtbox_email;
    }
    public WebElement getPhoneTextBox() {
        return txtbox_phone;
    }
    public WebElement getCityTextBox() {
        return txtbox_city;
    }
    public WebElement getPasswordTextBox() {
        return txtbox_password;
    }
    public WebElement getContinueButton() {
        return btn_continue;
    }
    public WebElement getAccountAddressTextBox() {
        return txtbox_acccountaddress;
    }
    public WebElement getContinueButtonOnAccountAddressPage() {
        return btn_continue_onaccountaddress;
    }
    public WebElement getTickMarkIcon() {
        return icn_tickmark;
    }
    public WebElement getIndustryTypeDropDown() {
        return drpdwn_industrytype;
    }
    public WebElement getCreteMyStoreButton() {
        return btn_createmystore;
    }
    public WebElement getLoader() {
        return icn_loder;
    }


    /**
     * @author Vidhi Chapanera
     * @date 12 January 2021
     * @return
     * @throws IOException
     * @discription this method is used to rename the text file data
     */
    @Step("rename the text file data"+"\n"+"el:{0}"+"\n"+"filepath:{1}")
    public boolean renameFileData(WebElement el,String filepath) throws IOException {
        String tesLine ="";
        try {
            File f = new File(System.getProperty("user.dir") + filepath);
            f.canWrite();
            Scanner scanner = new Scanner(f);
            while (scanner.hasNextLine()) {
                tesLine += scanner.nextLine();
            }
            scanner.close();
            String string = tesLine;
            String[] parts = string.split("_");
            String part1 = parts[0]; //
            String part2 = parts[1]; //
            //int number = Integer.parseInt(protocolName.substring(protocolName.length()-1));
            int number = Integer.parseInt(part2);
            int sum = number + 1;
            String oldValue = String.valueOf(number);
            String newValue = String.valueOf(sum);
            String finalString = tesLine.replace(oldValue, newValue);
            dataText += finalString;
            System.out.println(dataText);

            FileWriter myWriter = new FileWriter(f);
            myWriter.write(dataText);
            myWriter.close();
            PageFactory.initElements(driver, CenterlizePO.class).enterDataUsingSendkeys(el, dataText);
            synchronized (dataText) {
                System.out.println(true);
            }
            Reset();
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }


    /**
     * @author Vidhi Chapanera
     * @date 12 January 2021
     * @discription reset static variable value
     */
    @Step("")
    public void Reset () {
        dataText = "";
    }


    /**
     * @author Vidhi Chapanera
     * @date 13 January 2021
     * @return
     * @throws IOException
     * @discription this method is used to get account address value
     */
    @Step("get Address value")
    public String getAddressValue() throws IOException {
        String tesLine ="";
        File f = new File(System.getProperty("user.dir") + "\\src\\main\\java\\CreateStorePO\\File\\AccountAddress");
        f.canWrite();
        Scanner scanner = new Scanner(f);
        while (scanner.hasNextLine()) {
            tesLine += scanner.nextLine();
        }
        //String lowercase = tesLine.split("-")[0].toLowerCase() + "-" + tesLine.split("-")[1].toLowerCase();
        scanner.close();
        System.out.println(tesLine);
        return tesLine;
    }


    /**
     * @return
     * @throws Exception
     * @author Vidhi Chapanera
     * @date 13 January 2021
     * @discription this Method is used to verify created store url
     */
    @Step("verify Created Store URL"+"\n"+"webAddress:{0}")
    public boolean verifyCreatedStore(String webAddress) {
        try {
            sleepFor(1);
            String currentURL = driver.getCurrentUrl();
            if(currentURL.contains(webAddress+".hikeup.com"))
                return true;
            return false;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }


    /**
     * @return
     * @throws Exception
     * @author Vidhi Chapanera
     * @date 12 May 2021
     * @discription this Method is used to enter phone number
     */
    @Step("enter phone number")
    public boolean enterPhoneNumber() {
        try {
            sleepFor(1);
            CenterlizePO centerlizePO = PageFactory.initElements(driver,CenterlizePO.class);
            WebElement phoneDropDown = new WebDriverWait(driver, 90).
                    until( ExpectedConditions.presenceOfElementLocated( By.xpath("//div[@class='selected-flag']")));
            centerlizePO.clickOnButton(phoneDropDown);
            WebElement value = new WebDriverWait(driver, 90).
                    until( ExpectedConditions.presenceOfElementLocated( By.xpath("//li[@class='divider']//following-sibling::li//span[text()='Australia']")));
            centerlizePO.clickOnButton(value);
            return  true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    /**
     * @return
     * @throws Exception
     * @author Vidhi Chapanera
     * @date 12 May 2021
     * @discription this Method is used to A bit about your store
     */
    @Step("A bit about your store")
    public boolean bitAboutYourStoreSection() {
        try {
            sleepFor(1);
            CenterlizePO centerlizePO = PageFactory.initElements(driver,CenterlizePO.class);
            WebElement nopebtn = new WebDriverWait(driver, 90).
                    until( ExpectedConditions.presenceOfElementLocated( By.xpath("//span[text()='Nope']")));
            centerlizePO.clickOnButton(nopebtn);
            WebElement yesbtn = new WebDriverWait(driver, 90).
                    until( ExpectedConditions.presenceOfElementLocated( By.xpath("//span[text()='Yes']")));
            centerlizePO.clickOnButton(yesbtn);
            WebElement nextbtn = new WebDriverWait(driver, 90).
                    until( ExpectedConditions.presenceOfElementLocated( By.xpath("//button[normalize-space(.)='Next']")));
            centerlizePO.clickOnButton(nextbtn);
            WebElement setitupbtn = new WebDriverWait(driver, 90).
                    until( ExpectedConditions.presenceOfElementLocated( By.xpath("//span[normalize-space(.)='I want to set it up myself']")));
            centerlizePO.clickOnButton(setitupbtn);
            WebElement selectoption = new WebDriverWait(driver, 90).
                    until( ExpectedConditions.presenceOfElementLocated( By.xpath("//span[normalize-space(.)='Select option']//parent::a")));
            centerlizePO.clickOnButton(selectoption);
            WebElement selectoptionv= new WebDriverWait(driver, 90).
                    until( ExpectedConditions.presenceOfElementLocated( By.xpath("//span[normalize-space(.)='Select option']//parent::a//following-sibling::div//ul//li//ul//li[1]//span")));
            centerlizePO.clickOnButton(selectoptionv);
            WebElement nextbtn1 = new WebDriverWait(driver, 90).
                    until( ExpectedConditions.presenceOfElementLocated( By.xpath("//button[normalize-space(.)='Next']")));
            centerlizePO.clickOnButton(nextbtn1);
            WebElement nobtn = new WebDriverWait(driver, 90).
                    until( ExpectedConditions.presenceOfElementLocated( By.xpath("//span[normalize-space(.)='No']")));
            centerlizePO.clickOnButton(nobtn);
            WebElement nobtn1 = new WebDriverWait(driver, 90).
                    until( ExpectedConditions.presenceOfElementLocated( By.xpath("//input[@id='NoGettingEcommerce']//following-sibling::label//span[normalize-space(.)='No']")));
            centerlizePO.clickOnButton(nobtn1);
            WebElement nextbtn2 = new WebDriverWait(driver, 90).
                    until( ExpectedConditions.presenceOfElementLocated( By.xpath("//button[normalize-space(.)='Next']")));
            centerlizePO.clickOnButton(nextbtn2);
            WebElement industry = new WebDriverWait(driver, 90).
                    until( ExpectedConditions.presenceOfElementLocated( By.xpath("//industry-combo//a")));
            centerlizePO.clickOnButton(industry);
            WebElement industryv = new WebDriverWait(driver, 90).
                    until( ExpectedConditions.presenceOfElementLocated( By.xpath("//industry-combo//a//following-sibling::div//ul//li//ul//li//span[text()='Fashion & Clothing Retail']")));
            centerlizePO.clickOnButton(industryv);
            WebElement Save = new WebDriverWait(driver, 90).
                    until( ExpectedConditions.presenceOfElementLocated( By.xpath("//form[@name='startuphikeForm']//button[normalize-space(.)='Save']")));
            centerlizePO.clickOnButton(Save);
            sleepFor(20);
            return  true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}

