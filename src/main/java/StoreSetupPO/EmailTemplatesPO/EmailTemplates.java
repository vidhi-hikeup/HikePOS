package StoreSetupPO.EmailTemplatesPO;

import CommonPO.BasePage;
import CommonPO.CenterlizePO;
import CustomersPO.GroupsPO.Groups;
import InventoryPO.Inventory;
import InventoryPO.PurchasesPO.Purchases;
import InventoryPO.TransfersPO.Transfers;
import PointofSalePO.PointofSale;
import PointofSalePO.ProcessSalePO.ProcessSale;
import ProductsPO.GiftCardsPO.GiftCards;
import ReportingPO.CustomersPO.Customers;
import ReportingPO.Reporting;
import StoreSetupPO.GeneralPO.General;
import StoreSetupPO.LoyaltyPointsPO.LoyaltyPoints;
import UsersPO.Users;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import javax.mail.*;
import javax.mail.internet.ContentType;
import javax.mail.internet.MimeMultipart;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * @author Vidhi Chapanera
 * @date 03 March 2021
 */
public class EmailTemplates extends BasePage {

    public WebDriver driver;
    public static String subject = "";
    public static String customerName = "";
    public static String customerEmail = "";
    public static String userName = "";
    public static String password = "#Test4196";
    public static String receivingHost = "";
    public static String receivingSubject ="";
    public static String receivingBodyPart ="";
    public static String sentDate ="";
    public String testMessage = "This is Add for Automation Testing Purpose";
    public String storeName = "";
    public String testTD3Message = "";
    public String testTD5Message = "";
    public String testTD6Message = "";
    public String giftCardNumber = "";
    public String giftCardAmount = "";
    public String testFromName = "vidhi";
    public String testFromEmail = "vidhi@hikeup.com";
    public String testRecipientName = "Riana";
    public String testRecipientEmail = "vidhi.hike.46@gmail.com";
    public String testRecipientDetails = "Be safe, have fun!";

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for email templates button
     * @date 03 March 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//span[contains(text(),'Email templates')]//parent::a"
    )
    WebElement btn_emailtemplates;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for AR Statement template
     * @date 03 March 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//a[text()='AR Statement']"
    )
    WebElement arStatement;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Subject input box
     * @date 03 March 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//label[text()='Subject']//parent::div//input"
    )
    WebElement inputbox_subject;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Customer Invoice Receipt template
     * @date 04 March 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//a[text()='Customer Invoice Receipt']"
    )
    WebElement customerinvoicereceipt;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Customer Invoice Receipt template
     * @date 04 March 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//a[text()='Customer Quote']"
    )
    WebElement customerquote;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Inventory Transfer template
     * @date 04 March 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//a[text()='Inventory Transfer']"
    )
    WebElement inventorytransfer;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Purchase order to supplier template
     * @date 05 March 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//a[text()='Purchase order to supplier']" +
                    "")
    WebElement purchaseordertosupplier;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Welcome email to new customer template
     * @date 05 March 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//a[text()='Welcome email to new customer']"
    )
    WebElement customerwelcomeemail;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Signup for loyalty program template
     * @date 05 March 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//a[text()='Signup for loyalty program']")
    WebElement signupforloyaltypoint;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Welcome email to new employee template
     * @date 05 March 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//a[text()='Welcome email to new employee']")
    WebElement welcomeemailtonewemployee;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for from name text area in gift card
     * @date 27 August 2021
     */
    @FindBy(
            how = How.ID,
            using = "FromName"
    )
    WebElement fromNameTextarea;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Recipient Name text area in gift card
     * @date 27 August 2021
     */
    @FindBy(
            how = How.ID,
            using = "RecipientName"
    )
    WebElement recipientNameTextarea;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Recipient Email text area in gift card
     * @date 27 August 2021
     */
    @FindBy(
            how = How.ID,
            using = "RecipientEmail"
    )
    WebElement recipientemailTextarea;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for from email text area in gift card
     * @date 27 August 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//input[@placeholder='From email']"
    )
    WebElement fromEmailTextarea;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Recipient detail text area in gift card
     * @date 27 August 2021
     */
    @FindBy(
            how = How.CSS,
            using = "textarea[placeholder='Recipient detail']"
    )
    WebElement recipientDetailTextarea;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Gift card to recipient
     * @date 03 March 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//a[text()='Gift card to recipient']" +
                    "")
    WebElement giftCardtorecipient;

    public EmailTemplates(WebDriver driver) {
        this.driver = driver;
    }
    public WebElement getEmailTemplateButton() {
        return btn_emailtemplates;
    }
    public WebElement getARStatementEmailTemplate() {
        return arStatement;
    }
    public WebElement getSubject() {
        return inputbox_subject;
    }
    public WebElement getCustomerInvoiceReceiptEmailTemplate() {
        return customerinvoicereceipt;
    }
    public WebElement getCustomerQuoteEmailTemplate() {
        return customerquote;
    }
    public WebElement getInventoryTransferEmailTemplate() {
        return inventorytransfer;
    }
    public WebElement getPurchaseOrderToSupplierEmailTemplate() {
        return purchaseordertosupplier;
    }
    public WebElement getWelcomeEmailToNewCustomer() {
        return customerwelcomeemail;
    }
    public WebElement getSignupForLoyaltyProgram() {
        return signupforloyaltypoint;
    }
    public WebElement getWelcomeEmailToNewEmployeee() {
        return welcomeemailtonewemployee;
    }
    public WebElement getFromNameTextarea() {
        return fromNameTextarea;
    }
    public WebElement getRecipientNameTextarea() {
        return recipientNameTextarea;
    }
    public WebElement getRecipientEmailTextarea() {
        return recipientemailTextarea;
    }
    public WebElement getFromEmailTextarea() {
        return fromEmailTextarea;
    }
    public WebElement getRecipientDetailTextarea() {
        return recipientDetailTextarea;
    }
    public WebElement getGiftCardtoRecipient() {
        return giftCardtorecipient;
    }


    /**
     *
     * @author Vidhi Chapanera
     * @date 04 March 2021
     * @discription reset static variable value
     */
    @Step("")
    public void reset() {
        subject = "";
        customerName = "";
        customerEmail = "";
        userName = "";
        receivingHost = "";
        receivingSubject ="";
        receivingBodyPart ="";
        sentDate ="";
    }


    /**
     * @author Vidhi Chapanera
     * @date 03 March 2021
     * @return
     * @param element
     * @throws Exception
     * @discription this method is used to edit Email Template
     */
    @Step("edit Email Template"+"\n"+"element:{0}")
    public boolean editEmailTemplate(WebElement element) {
        CenterlizePO centerlizePO = PageFactory.initElements(driver,CenterlizePO.class);
        try {
            sleepFor(5);
            centerlizePO.clickOnButton(element);
            sleepFor(2);
            subject = getSubject().getAttribute("value");
            sleepFor(1);
            System.out.println("subject : "+subject);
            sleepFor(5);
            driver.switchTo().frame(0);
            sleepFor(2);
            WebElement txt = new WebDriverWait(driver, 90).
                    until(ExpectedConditions.presenceOfElementLocated(By.xpath("//body//table//tbody//tr[3]//td")));
            txt.clear();
            sleepFor(2);
            txt.click();
            sleepFor(2);
            Actions actions = new Actions(driver);
            actions.sendKeys(testMessage).build().perform();
            driver.switchTo().defaultContent();
            sleepFor(2);
            PageFactory.initElements(driver, Groups.class).getSaveButton().click();
            sleepFor(3);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }


    /**
     * @author Vidhi Chapanera
     * @date 03 March 2021
     * @return
     * @throws Exception
     * @discription this method is used to Add New Sale for AR Statement(Email Template Functionality)
     */
    @Step("Add New Sale for AR Statement(Email Template Functionality)")
    public boolean addNewSaleARStatementEmailTemplate() {
        CenterlizePO centerlizePO = PageFactory.initElements(driver,CenterlizePO.class);
        try {
            sleepFor(5);
            PageFactory.initElements(driver, CustomersPO.Customers.class).clickOnCustomersButton();
            sleepFor(2);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, CustomersPO.CustomersPO.Customers.class).getCustomersButton());
            WebElement customer = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table[@id='CustomersTable']//tbody//tr[last()]//td[2]//span")));
            customerName =customer.getText();
            sleepFor(2);
            customer.click();
            sleepFor(4);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Groups.class).getEditButton());
            sleepFor(4);
            customerEmail = PageFactory.initElements(driver, CustomersPO.CustomersPO.Customers.class).getEmail().getAttribute("value");
            sleepFor(2);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, ProcessSale.class).getSliderCloseIcon());
            sleepFor(2);
            PageFactory.initElements(driver, PointofSale.class).clickOnPointOfSaleButtonn();
            centerlizePO.clickOnButton(PageFactory.initElements(driver, ProcessSale.class).getProcessSaleButton());
            sleepFor(5);
            try {
                WebElement register = new WebDriverWait(driver,50)
                        .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='select-reg-btn']//span[contains(@class,'reg')]")));
                centerlizePO.clickOnButton(register);
            }catch (Exception e1){
                System.out.println("...! ");
            }
            sleepFor(15);
            PageFactory.initElements(driver, ProcessSale.class).getSearchBar().sendKeys("A");
            sleepFor(2);
            Actions actions = new Actions(driver);
            actions.sendKeys(Keys.TAB).build().perform();
            sleepFor(1);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, ProcessSale.class).getAddCustomerButton());
            centerlizePO.enterDataUsingSendkeys(PageFactory.initElements(driver, ProcessSale.class).getAddCustomer(),customerName);
            sleepFor(1);
            actions.sendKeys(Keys.TAB).build().perform();
            sleepFor(2);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, ProcessSale.class).getPayButton());
            centerlizePO.clickOnButton(PageFactory.initElements(driver, ProcessSale.class).getOnAccountButton());
            centerlizePO.clickOnButton(PageFactory.initElements(driver, GiftCards.class).getYesButton());
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
            sleepFor(1);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, ProcessSale.class).getAddNewSaleButton());
            sleepFor(5);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }


    /**
     * @author Vidhi Chapanera
     * @date 03 March 2021
     * @return
     * @throws Exception
     * @discription this method is used to Add New Sale for AR Statement(Email Template Functionality)
     */
    @Step("Add New Sale for AR Statement(Email Template Functionality)")
    public boolean sendARStatmentEmailFromReportingSide() {
        CenterlizePO centerlizePO = PageFactory.initElements(driver,CenterlizePO.class);
        try {
            sleepFor(5);
            PageFactory.initElements(driver, Reporting.class).clickOnReportingButton();
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Customers.class).getCustomersButton());
            sleepFor(3);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Customers.class).getAccReceivablesStatementsButton());
            sleepFor(2);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Customers.class).getApplyButton());
            sleepFor(10);
            WebElement customer = new WebDriverWait(driver,60).until
                    (ExpectedConditions.presenceOfElementLocated(By.xpath("//table[@id='CustomerBalanceHistoryDataTable']//tbody//tr//td[2]//a[text()='"+customerName+"']")));
            customer.click();
            sleepFor(5);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Customers.class).getEmailBtton());
            sleepFor(4);
            Actions actions = new Actions(driver);
            actions.sendKeys(Keys.ESCAPE).build().perform();
            sleepFor(3);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }


    /**
     * @author Vidhi Chapanera
     * @date 03 March 2021
     * @param message
     * @return
     * @throws IOException
     * @throws MessagingException
     */
    @Step("\n"+"message:{0}")
    private String getTextFromMessage(Message message) throws IOException, MessagingException {
        String result = "";
        if (message.isMimeType("text/plain")) {
            result = message.getContent().toString();
        } else if (message.isMimeType("multipart/*")) {
            MimeMultipart mimeMultipart = (MimeMultipart) message.getContent();
            result = getTextFromMimeMultipart(mimeMultipart);
        }
        return result;
    }


    /**
     * @author Vidhi Chapanera
     * @date 03 March 2021
     * @param mimeMultipart
     * @return
     * @throws IOException
     * @throws MessagingException
     */
    @Step("\n"+"mimeMultipart:{0}")
    private String getTextFromMimeMultipart(MimeMultipart mimeMultipart) throws IOException, MessagingException {
        int count = mimeMultipart.getCount();
        if (count == 0)
            throw new MessagingException("Multipart with no body parts not supported.");
        boolean multipartAlt = new ContentType(mimeMultipart.getContentType()).match("multipart/alternative");
        if (multipartAlt)
            return getTextFromBodyPart(mimeMultipart.getBodyPart(count - 1));
        String result = "";
        for (int i = 0; i < count; i++) {
            BodyPart bodyPart = mimeMultipart.getBodyPart(i);
            result += getTextFromBodyPart(bodyPart);
        }
        return result;
    }


    /**
     * @author Vidhi Chapanera
     * @date 03 March 2021
     * @param bodyPart
     * @return
     * @throws IOException
     * @throws MessagingException
     */
    @Step("\n"+"bodyPart:{0}")
    private String getTextFromBodyPart(BodyPart bodyPart) throws IOException, MessagingException {
        String result = "";
        if (bodyPart.isMimeType("text/plain")) {
            result = (String) bodyPart.getContent();
        } else if (bodyPart.isMimeType("text/html")) {
            String html = (String) bodyPart.getContent();
            result = org.jsoup.Jsoup.parse(html).text();
        } else if (bodyPart.getContent() instanceof MimeMultipart){
            result = getTextFromMimeMultipart((MimeMultipart)bodyPart.getContent());
        }
        return result;
    }


    /**
     * @author Vidhi Chapanera
     * @date 03 March 2021
     * @return
     * @throws Exception
     * @discription this method is used to verify and Read Email for AR Statement(Email Template Functionality)
     */
    @Step("verify and Read Email for AR Statement(Email Template Functionality)")
    public boolean readEmail() {
        sleepFor(10);
        receivingHost="imap.gmail.com";
        Properties props2=System.getProperties();
        props2.setProperty("mail.store.protocol", "imaps");
       /* props2.setProperty("mail.imaps.host", "imaps.google.com");
        props2.setProperty("mail.imaps.port", "993");
        props2.setProperty("mail.imaps.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props2.setProperty("mail.imaps.socketFactory.fallback", "false");*/
        Session session2=Session.getDefaultInstance(props2, null);
        try {
            Store store=session2.getStore("imaps");
            //userName = "vidhi.hike.46@gmail.com";
            userName = customerEmail;
            store.connect(receivingHost,userName, password);
            Folder folder=store.getFolder("INBOX");
            folder.open(Folder.READ_ONLY);
            Message message[]=folder.getMessages();
            receivingSubject = message[message.length-1].getSubject();
            System.out.println("receivingSubject : " + receivingSubject);
            receivingBodyPart = getTextFromMessage(message[message.length-1]);
            sentDate = String.valueOf(message[message.length-1].getSentDate());
            folder.close(true);
            store.close();
            return true;
        } catch (Exception e) {
            System.out.println(e.toString());
            System.out.println(e.getMessage());
            return false;
        }
    }

    /**
     * @author Vidhi Chapanera
     * @date 03 March 2021
     * @return
     * @throws Exception
     * @discription this method is used to verify mail
     */
    @Step("verify mail")
    public boolean verifyEmail() {
        try {
            sleepFor(5);
            SimpleDateFormat dateFormat = new SimpleDateFormat("EE MMM dd" /*hh:mm:ss z yyyy*/);
            String strDate = dateFormat.format(new Date());
            if (receivingSubject.equalsIgnoreCase(subject))
                //deleteMail();
                System.out.println("Verify..../");
            sleepFor(15);
            if (receivingBodyPart.equalsIgnoreCase(testMessage))
                System.out.println(" ");
            sleepFor(15);
           /* if (sentDate.contains(strDate))
                System.out.println(" ");*/
            sleepFor(2);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }


    /**
     * @author Vidhi Chapanera
     * @date 04 March 2021
     * @return
     * @throws Exception
     * @discription this method is used to Add New Sale for Customer Invoice/receipt(Email Template Functionality)
     */
    @Step("Add New Sale for Customer Invoice/receipt(Email Template Functionality)")
    public boolean addNewSaleCustomerInvoiceReceiptEmailTemplate() {
        CenterlizePO centerlizePO = PageFactory.initElements(driver,CenterlizePO.class);
        try {
            sleepFor(5);
            PageFactory.initElements(driver, CustomersPO.Customers.class).clickOnCustomersButton();
            sleepFor(2);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, CustomersPO.CustomersPO.Customers.class).getCustomersButton());
            WebElement customer = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table[@id='CustomersTable']//tbody//tr[last()]//td[2]//span")));
            customerName =customer.getText();
            sleepFor(2);
            customer.click();
            sleepFor(4);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Groups.class).getEditButton());
            sleepFor(4);
            customerEmail = PageFactory.initElements(driver, CustomersPO.CustomersPO.Customers.class).getEmail().getAttribute("value");
            sleepFor(2);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, ProcessSale.class).getSliderCloseIcon());
            sleepFor(2);
            PageFactory.initElements(driver, PointofSale.class).clickOnPointOfSaleButtonn();
            centerlizePO.clickOnButton(PageFactory.initElements(driver, ProcessSale.class).getProcessSaleButton());
            sleepFor(15);
            PageFactory.initElements(driver, ProcessSale.class).getSearchBar().sendKeys("A");
            sleepFor(2);
            Actions actions = new Actions(driver);
            actions.sendKeys(Keys.TAB).build().perform();
            sleepFor(1);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, ProcessSale.class).getAddCustomerButton());
            centerlizePO.enterDataUsingSendkeys(PageFactory.initElements(driver, ProcessSale.class).getAddCustomer(),customerName);
            sleepFor(1);
            actions.sendKeys(Keys.TAB).build().perform();
            sleepFor(2);
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
            sleepFor(1);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, ProcessSale.class).getEmailButton());
            sleepFor(1);
            if (PageFactory.initElements(driver, ProcessSale.class).getTextEmail1().getText().contains(customerEmail))
            //if (PageFactory.initElements(driver, ProcessSale.class).getTextEmail().getAttribute("value").contains(customerEmail))
                System.out.println(" ");
            centerlizePO.clickOnButton(PageFactory.initElements(driver, ProcessSale.class).getSendIconButton());
            sleepFor(10);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, ProcessSale.class).getAddNewSaleButton());
            sleepFor(5);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }


    /**
     * @author Vidhi Chapanera
     * @date 04 March 2021
     * @return
     * @throws Exception
     * @discription this method is used to Add New Sale for Customer Quote(Email Template Functionality)
     */
    @Step("Add New Sale for Customer Quote(Email Template Functionality)")
    public boolean addNewSaleCustomerQuoteEmailTemplate() {
        CenterlizePO centerlizePO = PageFactory.initElements(driver,CenterlizePO.class);
        try {
            sleepFor(5);
            PageFactory.initElements(driver, CustomersPO.Customers.class).clickOnCustomersButton();
            sleepFor(2);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, CustomersPO.CustomersPO.Customers.class).getCustomersButton());
            WebElement customer = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table[@id='CustomersTable']//tbody//tr[last()]//td[2]//span")));
            customerName =customer.getText();
            sleepFor(2);
            customer.click();
            sleepFor(4);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Groups.class).getEditButton());
            sleepFor(4);
            customerEmail = PageFactory.initElements(driver, CustomersPO.CustomersPO.Customers.class).getEmail().getAttribute("value");
            sleepFor(2);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, ProcessSale.class).getSliderCloseIcon());
            sleepFor(2);
            PageFactory.initElements(driver, PointofSale.class).clickOnPointOfSaleButtonn();
            centerlizePO.clickOnButton(PageFactory.initElements(driver, ProcessSale.class).getProcessSaleButton());
            sleepFor(15);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, ProcessSale.class).getQuoteButton());
            sleepFor(1);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, ProcessSale.class).getOkButton());
            sleepFor(2);
            WebElement color = new WebDriverWait(driver,60).until
                    (ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//div[@class='page-content']")));
            System.out.println(color.getCssValue("background-color"));
            if (color.getCssValue("background-color").contains("rgba(255, 230, 230, 0.54)"))
                System.out.println("");
            PageFactory.initElements(driver, ProcessSale.class).getSearchBar().sendKeys("A");
            sleepFor(2);
            Actions actions = new Actions(driver);
            actions.sendKeys(Keys.TAB).build().perform();
            sleepFor(1);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, ProcessSale.class).getAddCustomerButton());
            centerlizePO.enterDataUsingSendkeys(PageFactory.initElements(driver, ProcessSale.class).getAddCustomer(),customerName);
            sleepFor(1);
            actions.sendKeys(Keys.TAB).build().perform();
            sleepFor(2);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, ProcessSale.class).getQuotePayButton());
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
            if (PageFactory.initElements(driver, ProcessSale.class).getTextEmail1().getText().contains(customerEmail))
                System.out.println(" ");
            centerlizePO.clickOnButton(PageFactory.initElements(driver, ProcessSale.class).getSendIconButton());
            sleepFor(10);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, ProcessSale.class).getAddNewQuoteButton());
            sleepFor(3);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }


    /**
     * @author Vidhi Chapanera
     * @date 04 March 2021
     * @return
     * @throws Exception
     * @discription this method is used to  Inventory (Email Template Functionality)
     */
    @Step("Transfer Inventory (Email Template Functionality)")
    public boolean transferInventoryEmailTemplate() {
        CenterlizePO centerlizePO = PageFactory.initElements(driver,CenterlizePO.class);
        try {
            sleepFor(5);
            PageFactory.initElements(driver, Inventory.class).clickOnInventoryButton();
            sleepFor(2);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Transfers.class).getTransfersButton());
            sleepFor(2);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Purchases.class).getAddNewButton());
            sleepFor(5);
            WebElement sourceoutlet = new WebDriverWait(driver,120).
                    until(ExpectedConditions.presenceOfElementLocated(
                            (By.xpath("//label[text()='Source outlet']//parent::div//a"))));
            JavascriptExecutor executor = (JavascriptExecutor)driver;
            executor.executeScript("arguments[0].click();", sourceoutlet);
            sleepFor(1);
            List<WebElement> sourceoutletoption = new WebDriverWait(driver,120).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                            (By.xpath("//label[text()='Source outlet']//parent::div//ul//li//ul//li//div[contains(text(),'')]//parent::div[contains(@class,'inner')]"))));
            executor.executeScript("arguments[0].click();", sourceoutletoption.get(0));
            sleepFor(1);
            WebElement destinationoutlet = new WebDriverWait(driver,120).
                    until(ExpectedConditions.presenceOfElementLocated(
                            (By.xpath("//label[text()='Destination outlet']//parent::div//a"))));
            executor.executeScript("arguments[0].click();", destinationoutlet);
            sleepFor(1);
            List<WebElement> destinationoutletoption = new WebDriverWait(driver,120).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                            (By.xpath("//label[text()='Destination outlet']//parent::div//ul//li//ul//li//div[contains(text(),'')]//parent::div[contains(@class,'inner')]"))));
            executor.executeScript("arguments[0].click();", destinationoutletoption.get(1));
            sleepFor(1);
            List<WebElement> elements = new  WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//input[@ng-model='searchtext']")));
            sleepFor(1);
            elements.get(0).click();
            elements.get(0).sendKeys("A");
            sleepFor(3);
            WebElement chkbocx = new WebDriverWait(driver,60).until
                    (ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//table[contains(@class,'table-hover')]//tr[position()=1]//td//div//label")));
            executor.executeScript("arguments[0].click();", chkbocx);
            sleepFor(1);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Purchases.class).getAddAndContinueButton());
            sleepFor(3);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Transfers.class).getSaveDropDownButton());
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Transfers.class).getSaveAndEmailButton());
            sleepFor(10);
            customerEmail = "vidhi.hike.46@gmail.com";
            centerlizePO.enterDataUsingSendkeys(PageFactory.initElements(driver, Transfers.class).getToEmailInputBox(),customerEmail);
            centerlizePO.enterDataUsingSendkeys(PageFactory.initElements(driver, Transfers.class).getCCEmailInputBox(),customerEmail);
            sleepFor(2);
            Actions actions = new Actions(driver);
            actions.sendKeys(Keys.TAB).build().perform();
            sleepFor(2);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Transfers.class).getSendButton());
            sleepFor(12);
            /*WebElement PO = new WebDriverWait(driver,60).until
                    (ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//table[@id='stocktransferDataTable']//tbody//tr//td//i[contains(@class,'fa fa-circle')]//parent::td//parent::tr//td[1]//a")));
            PO.click();
            sleepFor(5);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Transfers.class).getDeleteTransferOrderButton());
            sleepFor(2);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, CashRegister.class).getContinueButton());
            sleepFor(7);*/
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }


    /**
     * @author Vidhi Chapanera
     * @date 05 March 2021
     * @return
     * @throws Exception
     * @discription this method is used to Add new Purchase order(Email Template Functionality)
     */
    @Step("Add new Purchase order(Email Template Functionality)")
    public boolean addNewPurchaseOrder() {
        CenterlizePO centerlizePO = PageFactory.initElements(driver,CenterlizePO.class);
        try {
            sleepFor(5);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, General.class).getGeneralButton());
            sleepFor(3);
            String name = PageFactory.initElements(driver, General.class).getTradingNameButton().getAttribute("value");
            storeName = subject.split("#")[0] + " " + name;
            sleepFor(1);
            PageFactory.initElements(driver, Inventory.class).clickOnInventoryButton();
            sleepFor(2);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Purchases.class).getPurchasesButton());
            sleepFor(2);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Purchases.class).getAddNewButton());
            sleepFor(5);
            List<WebElement> elements = new  WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//input[@ng-model='searchtext']")));
            sleepFor(1);
            elements.get(0).click();
            elements.get(0).sendKeys("A");
            sleepFor(5);
            WebElement chkbocx = new WebDriverWait(driver,60).until
                    (ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//table[contains(@class,'table-hover')]//tr[position()=1]//td//div//label")));
            JavascriptExecutor executor = (JavascriptExecutor)driver;
            executor.executeScript("arguments[0].click();", chkbocx);
            sleepFor(1);
            sleepFor(1);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Purchases.class).getAddAndContinueButton());
            sleepFor(2);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Purchases.class).getSaveDropDownButton());
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Transfers.class).getSaveAndEmailButton());
            sleepFor(10);
            customerEmail = "vidhi.hike.46@gmail.com";
            centerlizePO.enterDataUsingSendkeys(PageFactory.initElements(driver, Transfers.class).getCCEmailInputBox(),customerEmail);
            sleepFor(2);
            Actions actions = new Actions(driver);
            actions.sendKeys(Keys.TAB).build().perform();
            sleepFor(2);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Transfers.class).getSendButton());
            sleepFor(12);
           /* WebElement PO = new WebDriverWait(driver,60).until
                    (ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//table[@id='purchanseOrderDataTable']//tbody//tr//td//i[contains(@class,'fa fa-circle-o')]//parent::td//parent::tr//td[1]//a")));
            PO.click();
            sleepFor(5);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Purchases.class).getDeleteThisPO());
            centerlizePO.clickOnButton(PageFactory.initElements(driver, CashRegister.class).getContinueButton());
            sleepFor(7);*/
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }



    /**
     * @author Vidhi Chapanera
     * @date 05 March 2021
     * @return
     * @throws Exception
     * @discription this method is used to verify mail
     */
    @Step("verify mail")
    public boolean verifyEmailDetails() {
        try {
            sleepFor(5);
            SimpleDateFormat dateFormat = new SimpleDateFormat("EE MMM dd" /*hh:mm:ss z yyyy*/);
            String strDate = dateFormat.format(new Date());
            if (receivingSubject.contains(storeName))
                System.out.println(" ");
            if (receivingBodyPart.contains(testMessage))
                System.out.println(" ");
            if (sentDate.contains(strDate))
                System.out.println(" ");
            sleepFor(2);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }


    /**
     * @author Vidhi Chapanera
     * @date 05 March 2021
     * @return
     * @throws Exception
     * @discription this method is used to Add New Customer for Welcome email to new customer(Email Template Functionality)
     */
    @Step("Add New Customer for Welcome email to new customer(Email Template Functionality)")
    public boolean addNewCustomer() {
        CenterlizePO centerlizePO = PageFactory.initElements(driver,CenterlizePO.class);
        try {
            sleepFor(5);
            PageFactory.initElements(driver, CustomersPO.Customers.class).clickOnCustomersButton();
            sleepFor(2);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, CustomersPO.CustomersPO.Customers.class).getCustomersButton());
            sleepFor(1);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, CustomersPO.CustomersPO.Customers.class).getAddCustomerButton());
            sleepFor(5);
            centerlizePO.enterDataUsingSendkeys(PageFactory.initElements(driver, CustomersPO.CustomersPO.Customers.class).getFirstName(),"Vidhi");
            centerlizePO.enterDataUsingSendkeys(PageFactory.initElements(driver, CustomersPO.CustomersPO.Customers.class).getLastName(),"Test1");
            centerlizePO.clickOnButton(PageFactory.initElements(driver, CustomersPO.CustomersPO.Customers.class).getGenderDropDown());
            List<WebElement> elementList = new WebDriverWait(driver,120).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy
                            (By.xpath("//a[@placeholder='Gender']//parent::div//ul//li//span//parent::div[contains(@class,label)]")));
            elementList.get(1).click();
            sleepFor(3);
            WebElement outletchkBox = new WebDriverWait(driver,120).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//label[@for='activateAll']")));
            centerlizePO.clickOnButton(outletchkBox);
            centerlizePO.enterDataUsingSendkeys(PageFactory.initElements(driver, CustomersPO.CustomersPO.Customers.class).getCompany(),"hikeup.com");
            centerlizePO.enterDataUsingSendkeys(PageFactory.initElements(driver, CustomersPO.CustomersPO.Customers.class).getEmail(),"vidhi.hike.46@gmail.com");
            centerlizePO.clearText(PageFactory.initElements(driver, CustomersPO.CustomersPO.Customers.class).getAccountLimit());
            centerlizePO.enterDataUsingSendkeys(PageFactory.initElements(driver, CustomersPO.CustomersPO.Customers.class).getAccountLimit(),"50000");
            sleepFor(2);
            customerEmail = PageFactory.initElements(driver, CustomersPO.CustomersPO.Customers.class).getEmail().getAttribute("value");
            WebElement chk = new WebDriverWait(driver,120).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.id("checkbox1")));
            if (chk.getAttribute("class").contains("ng-not-empty")){
                WebElement chk1 = new WebDriverWait(driver,120).
                        until(ExpectedConditions.presenceOfElementLocated
                                (By.cssSelector("label[for='checkbox1']")));
                chk1.click();
            }
            sleepFor(1);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, LoyaltyPoints.class).getSaveButton());
            sleepFor(5);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }


    /**
     * @author Vidhi Chapanera
     * @date 05 March 2021
     * @return
     * @throws Exception
     * @discription this method is used to Edit Customer for Signup for loyalty program(Email Template Functionality)
     */
    @Step("Edit Customer for Signup for loyalty program(Email Template Functionality)")
    public boolean editCustomer() {
        CenterlizePO centerlizePO = PageFactory.initElements(driver,CenterlizePO.class);
        try {
            sleepFor(5);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, General.class).getGeneralButton());
            sleepFor(3);
            String name = PageFactory.initElements(driver, General.class).getTradingNameButton().getAttribute("value");
            sleepFor(1);
            storeName = subject.replace("#storename#",name);
            sleepFor(1);
            PageFactory.initElements(driver, CustomersPO.Customers.class).clickOnCustomersButton();
            sleepFor(2);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, CustomersPO.CustomersPO.Customers.class).getCustomersButton());
            sleepFor(1);
            WebElement customer = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table[@id='CustomersTable']//tbody//tr[last()]//td[2]//span")));
            sleepFor(2);
            customer.click();
            sleepFor(4);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Groups.class).getEditButton());
            sleepFor(4);
            customerEmail = PageFactory.initElements(driver, CustomersPO.CustomersPO.Customers.class).getEmail().getAttribute("value");
            sleepFor(2);
            WebElement chk1 = new WebDriverWait(driver,120).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.cssSelector("label[for='checkbox1']")));
            chk1.click();
            sleepFor(1);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, LoyaltyPoints.class).getSaveButton());
            sleepFor(2);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }


    /**
     * @author Vidhi Chapanera
     * @date 05 March 2021
     * @return
     * @throws Exception
     * @discription this method is used to Add User for Welcome email to new employee(Email Template Functionality)
     */
    @Step("Add User for Welcome email to new employee(Email Template Functionality)")
    public boolean addUser() {
        CenterlizePO centerlizePO = PageFactory.initElements(driver,CenterlizePO.class);
        try {
            sleepFor(5);
            PageFactory.initElements(driver, Users.class).clickOnUsersButton();
            centerlizePO.clickOnButton(PageFactory.initElements(driver,  UsersPO.UserPO.Users.class).getUsersButton());
            sleepFor(3);
            centerlizePO.clickOnButton(PageFactory.initElements(driver,  UsersPO.UserPO.Users.class).getAddUsersButton());
            sleepFor(3);
            centerlizePO.enterDataUsingSendkeys(PageFactory.initElements(driver,  UsersPO.UserPO.Users.class).getName(),"vidhi");
            centerlizePO.enterDataUsingSendkeys(PageFactory.initElements(driver,  UsersPO.UserPO.Users.class).getSurname(),"hikepos");
            centerlizePO.enterDataUsingSendkeys(PageFactory.initElements(driver,  UsersPO.UserPO.Users.class).getEmailAddress(),"vidhi.hike.46@gmail.com");
            sleepFor(1);
            customerEmail = PageFactory.initElements(driver,  UsersPO.UserPO.Users.class).getEmailAddress().getAttribute("value");
            WebElement rbtn = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[@for='EditUser_Manager']")));
            JavascriptExecutor executor = (JavascriptExecutor)driver;
            executor.executeScript("arguments[0].click();", rbtn);
            centerlizePO.clickOnButton(PageFactory.initElements(driver,  UsersPO.UserPO.Users.class).getSetRandomPasswordCheckbox());
            centerlizePO.enterDataUsingSendkeys(PageFactory.initElements(driver,  UsersPO.UserPO.Users.class).getUserName(),"V01");
            centerlizePO.clearText(PageFactory.initElements(driver,  UsersPO.UserPO.Users.class).getUserPin());
            centerlizePO.enterDataUsingSendkeys(PageFactory.initElements(driver,  UsersPO.UserPO.Users.class).getUserPin(),"4100");
            centerlizePO.clickOnButton(PageFactory.initElements(driver,  UsersPO.UserPO.Users.class).getAllOutletCheckBox());
            centerlizePO.clickOnButton(PageFactory.initElements(driver,  UsersPO.UserPO.Users.class).getSaveButton());
            sleepFor(5);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }



    /**
     * @author Vidhi Chapanera
     * @date 26 August 2021
     * @return
     * @throws Exception
     * @discription this method is used to select page from pagination
     */
    @Step("select page from pagination")
    public boolean selectPageFromPagination() {
        try {
            sleepFor(10);
            Actions actions = new Actions(driver);
            actions.sendKeys(Keys.PAGE_DOWN).build().perform();
            sleepFor(2);
            WebElement pagination = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated(By.name("TemplateDataTable_length")));
            Select select = new Select(pagination);
            select.selectByValue("100");
            sleepFor(10);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }


    /**
     * @author Vidhi Chapanera
     * @date 10 March 2021
     * @return
     * @throws Exception
     * @discription this method is used to delete mail
     */
    @Step("delete mail")
    public boolean deleteMail() {
        sleepFor(5);
        String receivingHost="imap.gmail.com";
        Properties props2=System.getProperties();
        props2.setProperty("mail.store.protocol", "imaps");
        Session session2=Session.getDefaultInstance(props2, null);
        try {
            Store store=session2.getStore("imaps");
            String userName = customerEmail;
            String password = "#Test4196";
            store.connect(receivingHost,userName, password);
            Folder folder=store.getFolder("INBOX");
            folder.open(Folder.READ_WRITE);
            Message message1[]=folder.getMessages();
            Message message = message1[message1.length-1];
            message.setFlag(Flags.Flag.DELETED, true);
            System.out.println("Marked DELETE for message : " + message1[message1.length-1].getSubject());
            folder.close(true);
            store.close();
            return true;
        } catch (Exception e) {
            System.out.println(e.toString());
            System.out.println(e.getMessage());
            return false;
        }
    }



    /**
     * @author Vidhi Chapanera
     * @date 27 August 2021
     * @return
     * @param element
     * @throws Exception
     * @discription this method is used to edit Email Template fir Gift card
     */
    @Step("edit Email Template"+"\n"+"element:{0}")
    public boolean editEmailTemplateForGiftCard(WebElement element) {
        CenterlizePO centerlizePO = PageFactory.initElements(driver,CenterlizePO.class);
        try {
            sleepFor(5);
            centerlizePO.clickOnButton(element);
            sleepFor(2);
            reset();
            subject = getSubject().getAttribute("value");
            sleepFor(1);
            System.out.println("subject : "+subject);
            sleepFor(5);
            driver.switchTo().frame(0);
            sleepFor(2);
            WebElement td3 = new WebDriverWait(driver, 90).
                    until(ExpectedConditions.presenceOfElementLocated(By.xpath("//body//table//tbody//tr[3]//td")));
            testTD3Message = td3.getText();
            System.out.println(testTD3Message);

            WebElement td5 = new WebDriverWait(driver, 90).
                    until(ExpectedConditions.presenceOfElementLocated(By.xpath("//body//table//tbody//tr[5]//td")));
            testTD5Message = td5.getText();
            System.out.println(testTD5Message);

            WebElement td6 = new WebDriverWait(driver, 90).
                    until(ExpectedConditions.presenceOfElementLocated(By.xpath("//body//table//tbody//tr[6]//td")));
            testTD6Message = td6.getText();
            System.out.println(testTD6Message);
            driver.switchTo().defaultContent();
            sleepFor(2);
            PageFactory.initElements(driver, Groups.class).getSaveButton().click();
            sleepFor(3);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }



    /**
     * @author Vidhi Chapanera
     * @date 27 August 2021
     * @return
     * @throws Exception
     * @Param gname
     * @discription this method is used to add Gift card
     */
    @Step("add gift card"+"\n"+"gname:{0}")
    public boolean saleGiftCard(String gname) {
        CenterlizePO centerlizePO = PageFactory.initElements(driver,CenterlizePO.class);
        General general = PageFactory.initElements(driver,General.class);
        try {
            sleepFor(5);
            PageFactory.initElements(driver,PointofSale.class).clickOnPointOfSaleButtonn();
            sleepFor(2);
            centerlizePO.clickOnButton(PageFactory.initElements(driver,ProcessSale.class).getProcessSaleButton());
            sleepFor(10);
            centerlizePO.clickOnButton(general.getGiftCard());
            centerlizePO.enterDataUsingSendkeys(general.getGiftCardNumber(),gname);
            giftCardNumber = general.getGiftCardNumber().getAttribute("value");
            sleepFor(7);
            centerlizePO.clickOnButton(general.getEnterAmount());
            centerlizePO.clearText(general.getEnterAmount());
            centerlizePO.enterDataUsingSendkeys(general.getEnterAmount(),"500");
            centerlizePO.enterDataUsingSendkeys(getFromNameTextarea(),testFromName);
            giftCardAmount = general.getEnterAmount().getAttribute("value");
            sleepFor(2);
            System.out.println(giftCardAmount);
            centerlizePO.enterDataUsingSendkeys(getFromEmailTextarea(),testFromEmail);
            Actions actions = new Actions(driver);
            actions.sendKeys(Keys.TAB).build().perform();
            centerlizePO.enterDataUsingSendkeys(getRecipientNameTextarea(),testRecipientName);
            centerlizePO.enterDataUsingSendkeys(getRecipientEmailTextarea(),testRecipientEmail);
            centerlizePO.enterDataUsingSendkeys(getRecipientDetailTextarea(),testRecipientDetails);
            centerlizePO.clickOnButton(general.getAddtoCartButton());
            sleepFor(3);
            centerlizePO.clickOnButton(PageFactory.initElements(driver,ProcessSale.class).getPayButton());
            centerlizePO.clickOnButton(PageFactory.initElements(driver,ProcessSale.class).getCashButton());
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
            centerlizePO.clickOnButton(PageFactory.initElements(driver,ProcessSale.class).getAddNewSaleButton());
            sleepFor(3);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }



    /**
     * @author Vidhi Chapanera
     * @date 27 August 2021
     * @return
     * @throws Exception
     * @discription this method is used to verify and Read Email for
     */
    @Step("verify and Read Email for Gift card to recipient(Email Template Functionality)")
    public boolean readEmailforGiftcard() {
        sleepFor(10);
        receivingHost="imap.gmail.com";
        Properties props2=System.getProperties();
        props2.setProperty("mail.store.protocol", "imaps");
        Session session2=Session.getDefaultInstance(props2, null);
        try {
            Store store=session2.getStore("imaps");
            userName = testRecipientEmail;
            store.connect(receivingHost,userName, password);
            Folder folder=store.getFolder("INBOX");
            folder.open(Folder.READ_ONLY);
            Message message[]=folder.getMessages();
            receivingSubject = message[message.length-1].getSubject();
            System.out.println("receivingSubject : " + receivingSubject);
            receivingBodyPart = org.jsoup.Jsoup.parse(message[message.length-1].getContent().toString()).text();
            System.out.println(receivingBodyPart);
            sentDate = String.valueOf(message[message.length-1].getSentDate());
            folder.close(true);
            store.close();
            return true;
        } catch (Exception e) {
            System.out.println(e.toString());
            System.out.println(e.getMessage());
            return false;
        }
    }


    /**
     * @author Vidhi Chapanera
     * @date 27 August 2021
     * @return
     * @throws Exception
     * @discription this method is used to verify mail
     */
    @Step("verify mail")
    public boolean verifyEmailforGiftCard() {
        try {
            sleepFor(5);
            if (receivingSubject.equalsIgnoreCase(subject.replace("#Gift-card-buyer-name#",testFromName).
                    replace("#storename#",driver.getCurrentUrl().split("//")[1].split(".hikeup")[0]))){
                System.out.println(" ");
                sleepFor(1);
                System.out.println("verified................./");
                sleepFor(5);
                String receivingHost="imap.gmail.com";
                Properties props2=System.getProperties();
                props2.setProperty("mail.store.protocol", "imaps");
                Session session2=Session.getDefaultInstance(props2, null);
                Store store=session2.getStore("imaps");
                String userName = testRecipientEmail;
                String password = "#Test4196";
                store.connect(receivingHost,userName, password);
                Folder folder=store.getFolder("INBOX");
                folder.open(Folder.READ_WRITE);
                Message message1[]=folder.getMessages();
                Message message = message1[message1.length-1];
                message.setFlag(Flags.Flag.DELETED, true);
                System.out.println("Marked DELETE for message : " + message1[message1.length-1].getSubject());
                folder.close(true);
                store.close();
            }
            sleepFor(1);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
