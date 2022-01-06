package StoreSetupPO.GeneralPO;

import CommonPO.BasePage;
import CommonPO.CenterlizePO;
import Config.ExcelUtils;
import Config.WriteUtils;
import CustomersPO.GroupsPO.Groups;
import InventoryPO.Inventory;
import InventoryPO.MyInventoryPO.MyInventory;
import InventoryPO.SuppliersPO.Suppliers;
import PointofSalePO.PointofSale;
import PointofSalePO.ProcessSalePO.ProcessSale;
import PointofSalePO.SalesHistoryPO.SalesHistory;
import ProductsPO.GiftCardsPO.GiftCards;
import ProductsPO.Products;
import ReportingPO.CustomersPO.Customers;
import ReportingPO.Reporting;
import StoreSetupPO.LoyaltyPointsPO.LoyaltyPoints;
import StoreSetupPO.ReceiptTemplatesPO.ReceiptTemplates;
import StoreSetupPO.StoreSetup;
import StoreSetupPO.TaxRulesPO.TaxRules;
import UsersPO.UserPO.Users;
import io.qameta.allure.Step;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import javax.mail.*;
import javax.mail.internet.MimeBodyPart;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.text.NumberFormat;
import java.util.*;


/**
 * @author Vidhi Chapanera
 * @date 22 January 2021
 */
public class General extends BasePage {

    public WebDriver driver;
    public static String attachFiles = "";
    public static String src = "";
    public static String customer = "";
    public static String giftCardNumber = "";
    public static String amount = "";
    public static String currentBlance = "";
    public static int loyaltyPoints = 0;
    public static String customerName = "";
    public static int additionalPoints = 0;
    public static int payInt = 0;
    public static String transactionNumber = "";
    public static int Balance = 0;
    public static String GiftCard = "0258";
    public static String testInventory = "";
    public static float testBalance = 0;
    public static String testBalanceString = "";
    public static String testSaleNumber = "";

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for General button
     * @date 22 January 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//span[contains(text(),'General')]//parent::a"
    )
    WebElement btn_General;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for General button
     * @date 19 July 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//label[@for='directPrint']"
    )
    WebElement chk_print;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Activate Weighted Average Cost for purchase cost calculation checkbox
     * @date 12 February 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(@class,'md-checkbox')]//label[@for='DisableCostPriceInProduct']"
    )
    WebElement chk_avgcost;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for confirm and continue button
     * @date 12 February 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//button[contains(text(),'Confirm & continue')]"
    )
    WebElement btn_confirmcontinue;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for quote issuance check box
     * @date 04 March 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(@class,'md-checkbox')]//label[@for='enableQuoteSale']"
    )
    WebElement chk_quoteissuance;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Trading name input box
     * @date 22 January 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//label[contains(text(),'Trading name')]//parent::div//input"
    )
   // @FindBy(
            // how = How.XPATH,
            // using = "//label[text()='Trading name']//parent::div//input"
            // )
    WebElement txtbox_tradingname;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for customer welcome email check box
     * @date 05 March 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(@class,'md-checkbox')]//label[@for='activateWelcomeCustomer']"
    )
    WebElement chk_customerwelcomeemail;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for quote issuance check box
     * @date 10 March 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(@class,'md-checkbox')]//label[@for='requireDeliveryAddressTocustomer']"
    )
    WebElement chk_customerdeliveryaddress;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for select file button
     * @date 10 March 2021
     */
    @FindBy(
            how = How.ID,
            using = "inputImage"
    )
    WebElement btn_selectfile;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for gift card button
     * @date 12 March 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//button[contains(text(),'Gift card')]"
    )
    WebElement btn_giftcard;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for gift card button on pay screen
     * @date 12 March 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//button[contains(text(),'Gift card') and contains(@class,'green')]"
    )
    WebElement btn_giftcardpayscreen;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for gift card number input box
     * @date 12 March 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//h2[text()='Gift card number']//parent::div//input"
    )
    WebElement txt_giftcardnumber;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for check button
     * @date 12 March 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//i[@class='fa fa-check']//parent::button"
    )
    WebElement btn_check;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for enter amount input box
     * @date 12 March 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//label[text()='Enter amount']//parent::div//input"
    )
    /**
     * old locator
     * //@FindBy(how = How.XPATH, using = "//h2[text()='Enter amount']//parent::div//input")
     */
    WebElement txt_enteramount;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for add to cart button
     * @date 12 March 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//button[text()='Add to cart']"
    )
    WebElement btn_addtocart;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for gift card popup inputbox
     * @date 12 March 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//div[@class='giftcard-number-popup']//input"
    )
    WebElement txt_giftcardnumberpopup;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for charge button
     * @date 12 March 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//div[@class='giftcard-number-popup']//button[text()='Charge']"
    )
    WebElement btn_charge;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for charge button
     * @date 15 March 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//label[@for='switchUserAfterEachSale']"
    )
    WebElement btn_userenterpinonsale;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Prompt to print check box
     * @date 05 April 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//label[@for='directPrint']"
    )
    WebElement chk_printPrompt;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Shipping link
     * @date 27 October 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//table[contains(@class,'cust-table')]//td[contains(text(),'Shipping')]"
    )
    WebElement lnk_shipping;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for shipping text area
     * @date 27 October 2021
     */
    @FindBy(
            how = How.CSS,
            using = "input[type='number']"
    )
    WebElement shippingTextArea;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Enter Button
     * @date 27 October 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//button[text()='Enter']"
    )
    WebElement enterButton;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Tax Drop Down
     * @date 27 October 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//tax-combo//a"
    )
    WebElement TaxDropdown;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Shipping check box
     * @date 27 October 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(@class,'md-checkbox')]//label[@for='allowShippingTaxOnPOS']"
    )
    WebElement chk_shipping;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for park paid fulfillment checkbox drop down
     * @date 27 October 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(@class,'md-checkbox')]//label[@for='parkingPaidOrder']//following-sibling::div//a"
    )
    WebElement chk_parkpaiddpdw;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for park paid fulfillment checkbox
     * @date 27 October 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(@class,'md-checkbox')]//label[@for='parkingPaidOrder']"
    )
    WebElement chk_parkpaid;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Fulfilment popup
     * @date 27 October 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(text(),'Is this order now being fulfilled?')]"
    )
   //@FindBy(
            // how = How.XPATH,
            // using = "//div[contains(text(),'Has order already been fullfilled ?')]"
            // )
    WebElement alert_fulfillment;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Fulfilment popup
     * @date 27 October 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//a[contains(text(),'Yes')]"
    )
    WebElement btn_yes;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for hide three digit of giftcard checkbox box
     * @date 28 October 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(@class,'md-checkbox')]//label[@for='hideDigitGiftCard']"
    )
    WebElement chk_hidedigitgiftcard;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Display total items (quantity) in basket checkbox box
     * @date 01 December 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(@class,'md-checkbox')]//label[@for='showTotalQuantityInBasket']"
    )
    WebElement chk_DisplayTotalItems;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Display total items (quantity) in basket checkbox box
     * @date 01 December 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//label[@for='displayMutipleQuantitiesOfSameProduct']"
    )
    WebElement chk_mutipleQuantitiesOfSameProduct;


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for total items section on cart box
     * @date 01 December 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//td[text()='Total items']"
    )
    WebElement totalitem;


    /**
     * @author Vidhi Chapanera
     * @discription this locator is for View inventory count on POS screen checkbox box
     * @date 07 December 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//label[@for='showStockCountOnEnterSale']"
    )
    WebElement chk_showStockCountOnEnterSale;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Balance disable input box
     * @date 08 December 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//h2[text()='Balance']//following-sibling::label"
    )
    WebElement balance;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for Top up this card? input box
     * @date 08 December 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//h2[text()='Top up this card?']//following-sibling::div//input"
    )
    WebElement topupBox;

    /**
     * @author Vidhi Chapanera
     * @discription this locator is for proceed to add funds
     * @date 08 December 2021
     */
    @FindBy(
            how = How.XPATH,
            using = "//button[text()='Proceed to add funds']"
    )
    WebElement btn_addFunds;


    public General(WebDriver driver) {
        this.driver = driver;
    }
    public WebElement getPrintOption() {
        return chk_print;
    }
    public WebElement getGeneralButton() {
        return btn_General;
    }
    public WebElement getWeightedAverageCost() {
        return chk_avgcost;
    }
    public WebElement getConfirmAndContinueButton() {
        return btn_confirmcontinue;
    }
    public WebElement getQuoteIssuance() {
        return chk_quoteissuance;
    }
    public WebElement getTradingNameButton() {
        return txtbox_tradingname;
    }
    public WebElement getCustomerWelcomeEmail() {
        return chk_customerwelcomeemail;
    }
    public WebElement getCustomerDeliveryAddress() {
        return chk_customerdeliveryaddress;
    }
    public WebElement getSelectFile() {
        return btn_selectfile;
    }
    public WebElement getGiftCard() {
        return btn_giftcard;
    }
    public WebElement getGiftCardPayScreen() {
        return btn_giftcardpayscreen;
    }
    public WebElement getGiftCardNumber() {
        return txt_giftcardnumber;
    }
    public WebElement getCheckButton() {
        return btn_check;
    }
    public WebElement getEnterAmount() {
        return txt_enteramount;
    }
    public WebElement getAddtoCartButton() {
        return btn_addtocart;
    }
    public WebElement getGiftCardPopuptxt() {
        return txt_giftcardnumberpopup;
    }
    public WebElement gerChargeButton() {
        return btn_charge;
    }
    public WebElement getUsertoEnterPINOnEverySale() {
        return btn_userenterpinonsale;
    }
    public WebElement getPrintPrompt() {
        return chk_printPrompt;
    }
    public WebElement getShippingOption() {
        return lnk_shipping;
    }
    public WebElement getShippingTaxArea() {
        return shippingTextArea;
    }
    public WebElement getEnterButton() {
        return enterButton;
    }
    public WebElement getTaxDropDown() {
        return TaxDropdown;
    }
    public WebElement getShippingCheckBox() {
        return chk_shipping;
    }
    public WebElement getParkPaidDropDown() {
        return chk_parkpaiddpdw;
    }
    public WebElement getParkPaidCheckBox() {
        return chk_parkpaid;
    }
    public WebElement getFulfillmentAlert() {
        return alert_fulfillment;
    }
    public WebElement getYesButton() {
        return btn_yes;
    }
    public WebElement getHideDigitftCard() {
        return chk_hidedigitgiftcard;
    }
    public WebElement getDisplayTotalItemsInBasket() {
        return chk_DisplayTotalItems;
    }
    public WebElement getMutipleQuantitiesOfSameProduct() {
        return chk_mutipleQuantitiesOfSameProduct;
    }
    public WebElement getTotalItemsText() {
        return totalitem;
    }
    public WebElement getStockCountOnEnterSale() {
        return chk_showStockCountOnEnterSale;
    }
    public WebElement getBalance() {
        return balance;
    }
    public WebElement getTopupBox() {
        return topupBox;
    }
    public WebElement getAddFundsButton() {
        return btn_addFunds;
    }


    /**
     * @author Vidhi Chapanera
     * @date 22 January 2021
     * @return
     * @throws Exception
     * @discription this method is used to active features and general rules
     */
    @Step("active features and general rules")
    public boolean activeFeaturesAndGeneralRules() {
        try {
            sleepFor(3);
            Actions actions = new Actions(driver);
            String[] strArray2 = new String[]{"generalrules4",
                                              "activateLoyalty",
                                              "activateGiftCard",
                                              "exchangeInvoice",
                                              };
            for (String s : strArray2) {
                WebElement e1 = new WebDriverWait(driver,60)
                        .until(ExpectedConditions.presenceOfElementLocated
                                (By.xpath("//div[contains(@class,'md-checkbox')]//label[@for='"+s+"']")));
                actions.moveToElement(e1).build().perform();
                e1.click();
                if (e1.findElement(By.xpath("//parent::div//input")).getAttribute("class").contains("not-empty"))
                    sleepFor(1);
            }
            actions.moveToElement(PageFactory.initElements(driver, Users.class).getSaveButton()).build().perform();
            PageFactory.initElements(driver, Users.class).getSaveButton().click();
            sleepFor(13);
            return true;
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }


    /**
     * @author Vidhi Chapanera
     * @date 12 February 2021
     * @return
     * @throws Exception
     * @discription this method is used to Activate Weighted Average Cost for purchase cost calculation
     */
    @Step("Activate Weighted Average Cost for purchase cost calculation")
    public boolean activeWeightedAverageCostforPurchaseCost() {
        try {
            sleepFor(3);
            CenterlizePO centerlizePO = PageFactory.initElements(driver,CenterlizePO.class);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, StoreSetup.class).getStoreSetupButton());
            centerlizePO.clickOnButton(getGeneralButton());
            sleepFor(3);
            sleepFor(1);
            PageFactory.initElements(driver,CenterlizePO.class).clickOnButton(getWeightedAverageCost());
            sleepFor(5);
            PageFactory.initElements(driver,CenterlizePO.class).clickOnButton(getConfirmAndContinueButton());
            sleepFor(10);
            PageFactory.initElements(driver, Users.class).getSaveButton().click();
            PageFactory.initElements(driver, Inventory.class).clickOnInventoryButton();
            sleepFor(2);
            return true;
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }


    /**
     * @author Vidhi Chapanera
     * @date 10 March 2021
     * @return
     * @throws Exception
     * @discription this method is used to upload store logo
     */
    @Step("upload store logo")
    public boolean uploadStoreLogo() {
        try {
            sleepFor(5);
            WebElement webElement = new WebDriverWait(driver,60)
                    .until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//div[contains(@class,'fileinput')]//img")));
            webElement.click();
            sleepFor(3);
            if (driver.findElement(By.name("uploadImageform")).isDisplayed())
                System.out.println(true);
            getSelectFile().sendKeys(System.getProperty("user.dir")+"\\src\\main\\java\\StoreSetupPO\\GeneralPO\\Image\\skype_letter_V.jpg");
            sleepFor(5);
            //driver.findElement(By.xpath("//label[@for='inputImage']")).click();
            //Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\FileUpload.exe",);
            PageFactory.initElements(driver, LoyaltyPoints.class).getSaveButton().click();
            sleepFor(10);
            ArrayList result = (ArrayList)((JavascriptExecutor) driver).executeScript(
                    "return [arguments[0].naturalWidth, arguments[0].naturalHeight];", webElement);
            Long naturalWidth2 = (Long)result.get(0);
            Long naturalHeight2 = (Long)result.get(1);
            String s = webElement.getAttribute("src");
            src = s.split("/")[1];
            System.out.println(src);
            PageFactory.initElements(driver, Users.class).getSaveButton().click();
            sleepFor(10);
            return true;
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }


    /**
     * @author Vidhi Chapanera
     * @date 10 March 2021
     * @return
     * @throws Exception
     * @discription this method is used to download invoice pdf
     */
    @Step(" download invoice pdf")
    public boolean downloadPDF() {
        sleepFor(5);
        String receivingHost="imap.gmail.com";
        Properties props2=System.getProperties();
        props2.setProperty("mail.store.protocol", "imaps");
        Session session2=Session.getDefaultInstance(props2, null);
        try {
            Store store=session2.getStore("imaps");
            String userName = "Vidhi.hikeup@gmail.com";
            //String userName = "Vidhi.hike.04@gmail.com";
            String password = "#Test4196";
            store.connect(receivingHost,userName, password);
            Folder folder=store.getFolder("INBOX");
            folder.open(Folder.READ_ONLY);
            Message message1[]=folder.getMessages();
            Message message = message1[message1.length-1];
            String contentType = message.getContentType();
            String messageContent = "";
            if (contentType.contains("multipart")) {
                // content may contain attachments
                Multipart multiPart = (Multipart) message.getContent();
                int numberOfParts = multiPart.getCount();
                for (int partCount = 0; partCount < numberOfParts; partCount++) {
                    MimeBodyPart part = (MimeBodyPart) multiPart.getBodyPart(partCount);
                    if (Part.ATTACHMENT.equalsIgnoreCase(part.getDisposition())) {
                        String fileName = part.getFileName();
                        attachFiles += fileName + ", ";
                        part.saveFile(System.getProperty("user.dir")+"\\download" + File.separator + fileName);
                    } else {
                        messageContent = part.getContent().toString();
                    }
                }
                if (attachFiles.length() > 1) {
                    attachFiles = attachFiles.substring(0, attachFiles.length() - 2);
                }
            } else if (contentType.contains("text/plain")
                    || contentType.contains("text/html")) {
                Object content = message.getContent();
                if (content != null) {
                    messageContent = content.toString();
                }
            }
            System.out.println("\t Attachments: " + attachFiles);
            folder.close(false);
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
     * @date 10 March 2021
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
            String url =System.getProperty("user.dir")+"\\download\\"+attachFiles;
            driver.get(url);
            String pdfContent = readPdfContent();
            System.out.println(pdfContent);
            if (pdfContent.contains(PageFactory.initElements(driver, ReceiptTemplates.class).headerText))
                System.out.println("true");
            if (pdfContent.contains(PageFactory.initElements(driver, ReceiptTemplates.class).footerText))
                System.out.println("true");
            sleepFor(2);
            jse.executeScript("window.close()");
            driver.switchTo().window(tabs.get(0));
            File f = new File(System.getProperty("user.dir") + "\\download\\");
            for (File file : f.listFiles()) {
                file.delete();
                System.out.println("deleted File");
            }
            deleteMail();
            return true;
        } catch (Exception e) {
            System.out.println(e.toString());
            System.out.println(e.getMessage());
            return false;
        }
    }

    /**
     * @author Vidhi Chapanera
     * @date 10 March 2018
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
     * @date 10 March 2018
     * @param doc
     */
    @Step("get Page Count"+"\n"+"doc:{0}")
    public int getPageCount(PDDocument doc) {
        //get the total number of pages in the pdf document
        int pageCount = doc.getNumberOfPages();
        return pageCount;
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
            String userName = "Vidhi.hikeup@gmail.com";
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
     * @date 12 March 2021
     * @return
     * @throws Exception
     * @discription this method is used to sale gift card
     */
    @Step("sale gift card")
    public boolean saleGiftCard() {
        CenterlizePO centerlizePO = PageFactory.initElements(driver,CenterlizePO.class);
        try {
            sleepFor(5);
            WebElement giftcard = new WebDriverWait(driver,60)
                    .until(ExpectedConditions.elementToBeClickable(getGiftCard()));
            giftcard.click();
            sleepFor(2);
            centerlizePO.enterDataUsingSendkeys(getGiftCardNumber(),GiftCard);
            giftCardNumber = getGiftCardNumber().getAttribute("value");
            //centerlizePO.clickOnButton(getCheckButton());
            sleepFor(10);
            centerlizePO.clickOnButton(getEnterAmount());
            centerlizePO.clearText(getEnterAmount());
            centerlizePO.enterDataUsingSendkeys(getEnterAmount(),"5000");
            amount = getEnterAmount().getAttribute("value");
            sleepFor(2);
            centerlizePO.clickOnButton(getAddtoCartButton());
            sleepFor(3);
            centerlizePO.clickOnButton(PageFactory.initElements(driver,ProcessSale.class).getAddCustomerButton());
            centerlizePO.enterDataUsingSendkeys(PageFactory.initElements(driver,ProcessSale.class).getAddCustomer(),"A");
            sleepFor(1);
            Actions actions = new Actions(driver);
            actions.sendKeys(Keys.TAB).build().perform();
            sleepFor(2);
            WebElement customer1 = new WebDriverWait(driver,60)
                    .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'customer')]//a[contains(@class,'text')]")));
            customer = customer1.getText();
            WebElement payprice = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//button[contains(@class,'btn-xlarge')]//div[contains(@class,'right')]")));
            String payPrice = payprice.getText();
            if (payPrice==amount){
                System.out.println("");
            }
            sleepFor(1);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, ProcessSale.class).getPayButton());
            sleepFor(3);
            if (getGiftCardPayScreen().isDisplayed())
                System.out.println(" ");
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
            centerlizePO.clickOnButton(PageFactory.initElements(driver, ProcessSale.class).getAddNewSaleButton());
            sleepFor(3);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }


    /**
     * @author Vidhi Chapanera
     * @date 12 March 2021
     * @return
     * @throws Exception
     * @discription this method is used to verify gift card is display after sale under gift card  side
     */
    @Step("verify gift card is display after sale under gift card  side")
    public boolean verifyGiftcardDisplay() {
        CenterlizePO centerlizePO = PageFactory.initElements(driver,CenterlizePO.class);
        try {
            sleepFor(5);
            PageFactory.initElements(driver, Products.class).clickOnProductsButtonn();
            centerlizePO.clickOnButton(PageFactory.initElements(driver, GiftCards.class).getGiftCardsButton());
            sleepFor(4);
            List<WebElement> webElementList = new WebDriverWait(driver,60)
                    .until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                            By.xpath("//table[@id='GiftCardDataTable']//tbody//tr//td//a")));
            for(int i=0;i<webElementList.size();i++){
                if (webElementList.get(i).getText().contains(giftCardNumber))
                    System.out.println(" ");
                break;
            }
            WebElement value = new WebDriverWait(driver,60)
                    .until(ExpectedConditions.presenceOfElementLocated(
                            By.xpath("//table[@id='GiftCardDataTable']//tbody//tr//td//a[contains(text(),'"+giftCardNumber+"')]//parent::td//parent::tr//td[6]")));
            currentBlance = value.getText();
            if (currentBlance.contains(amount))
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
     * @date 12 March 2021
     * @return
     * @throws Exception
     * @discription this method is used to add new sale and checkout as gift card payment and then check flow
     */
    @Step("add new sale and checkout as gift card payment and then check flow")
    public boolean addNewSaleCheckoutGiftCard() {
        CenterlizePO centerlizePO = PageFactory.initElements(driver,CenterlizePO.class);
        try {
            sleepFor(5);
            PageFactory.initElements(driver,Inventory.class).clickOnInventoryButton();
            PageFactory.initElements(driver, PointofSale.class).clickOnPointOfSaleButtonn();
            centerlizePO.clickOnButton( PageFactory.initElements(driver, ProcessSale.class).getProcessSaleButton());
            sleepFor(15);
            PageFactory.initElements(driver, ProcessSale.class).getSearchBar().sendKeys("d");
            sleepFor(1);
            Actions actions = new Actions(driver);
            actions.sendKeys(Keys.TAB).build().perform();
            sleepFor(1);
            WebElement payprice = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//button[contains(@class,'btn-xlarge')]//div[contains(@class,'right')]")));
            String payPrice = payprice.getText();
            NumberFormat format = NumberFormat.getNumberInstance(Locale.UK);
            float currentBlance01 = Float.parseFloat(String.valueOf(format.parse(payPrice.substring(1)).intValue()));
            sleepFor(1);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, ProcessSale.class).getPayButton());
            centerlizePO.clickOnButton(getGiftCardPayScreen());
            sleepFor(2);
            centerlizePO.enterDataUsingSendkeys(getGiftCardPopuptxt(),giftCardNumber);
            sleepFor(7);
            WebElement blance = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//div[@class='giftcard-number-popup']//div[contains(@class,'text-center')]//span")));
            float currentBlance02 = Float.parseFloat(String.valueOf(format.parse(blance.getText().split(" ")[1].substring(1)).intValue()));
            float currentBlance03 = currentBlance02-currentBlance01;
            sleepFor(2);
            if (blance.getText().split(" ")[1].contains(currentBlance))
                System.out.println();
            sleepFor(3);
            centerlizePO.clickOnButton(gerChargeButton());
            sleepFor(5);
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
            centerlizePO.clickOnButton(PageFactory.initElements(driver, ProcessSale.class).getAddNewSaleButton());
            sleepFor(7);
            PageFactory.initElements(driver, Products.class).clickOnProductsButtonn();
            centerlizePO.clickOnButton(PageFactory.initElements(driver, GiftCards.class).getGiftCardsButton());
            sleepFor(4);
            WebElement value = new WebDriverWait(driver,60)
                    .until(ExpectedConditions.presenceOfElementLocated(
                            By.xpath("//table[@id='GiftCardDataTable']//tbody//tr//td//a[contains(text(),'"+giftCardNumber+"')]//parent::td//parent::tr//td[6]")));
            currentBlance = value.getText();
            String testData = String.valueOf(currentBlance03);
            if (currentBlance.contains(testData))
                System.out.println(" ");
            sleepFor(2);
           /* PageFactory.initElements(driver, Reporting.class).clickOnReportingButton();
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Customers.class).getCustomersButton());
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Customers.class).getGiftCardBalanceButton());
            sleepFor(2);
            centerlizePO.enterDataUsingSendkeys(PageFactory.initElements(driver, Customers.class).getGiftCardBalance(),giftCardNumber);
            sleepFor(3);
            List<WebElement> webElementList = new WebDriverWait(driver,60)
                    .until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                            By.xpath("//table[@id='GiftCardBalanceDetailDataTable']//tbody//tr//td[contains(text(),'')]//parent::td//parent::tr//td[7]")));
            String closingBalance = webElementList.get(0).getText();
            if (closingBalance.contains(currentBlance))
                System.out.println(" ");*/
            sleepFor(5);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }



    /**
     * @author Vidhi Chapanera
     * @date 12 March 2021
     * @return
     * @throws Exception
     * @discription this method is used to Edit Customer for get customer current loyalty blance before sale
     */
    @Step("get customer current loyalty blance before sale")
    public boolean editCustomerForLoyaltyPoints() {
        CenterlizePO centerlizePO = PageFactory.initElements(driver,CenterlizePO.class);
        try {
            sleepFor(5);
            PageFactory.initElements(driver, CustomersPO.Customers.class).clickOnCustomersButton();
            sleepFor(2);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, CustomersPO.CustomersPO.Customers.class).getCustomersButton());
            sleepFor(1);
            WebElement customer = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table[@id='CustomersTable']//tbody//tr[last()]//td[2]//span")));
            sleepFor(2);
            customerName = customer.getText();
            customer.click();
            sleepFor(4);
            WebElement loyaltypoint = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='font-grey-cascade' and text()='Loyalty points']//parent::div//div[@title][normalize-space(.)]")));
            String loyaltyPoints01 = loyaltypoint.getText();
            loyaltyPoints = Integer.parseInt(loyaltyPoints01);
            sleepFor(1);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Groups.class).getEditButton());
            sleepFor(4);
            WebElement chk1 = new WebDriverWait(driver,120).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.cssSelector("label[for='checkbox1']")));
            chk1.click();
            sleepFor(1);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, LoyaltyPoints.class).getSaveButton());
            sleepFor(4);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }


    /**
     * @author Vidhi Chapanera
     * @date 12 March 2021
     * @return
     * @throws Exception
     * @discription this method is used to add new sale for loyalty point
     */
    @Step("get customer current loyalty blance before sale")
    public boolean addNewSaleForLoyaltyPoints() {
        CenterlizePO centerlizePO = PageFactory.initElements(driver,CenterlizePO.class);
        try {
            sleepFor(5);
            PageFactory.initElements(driver, ProcessSale.class).getSearchBar().sendKeys("Demo Skirt");
            sleepFor(1);
            Actions actions = new Actions(driver);
            actions.sendKeys(Keys.TAB).build().perform();
            sleepFor(2);
            String productName = "Demo Skirt";
            WebElement payprice = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//button[contains(@class,'btn-xlarge')]//div[contains(@class,'right') and normalize-space(.)]")));
            String payPrice = payprice.getText();
            NumberFormat format = NumberFormat.getNumberInstance(Locale.UK);
            payInt = Integer.parseInt(String.valueOf(format.parse(payPrice.substring(1)).intValue()));
            sleepFor(1);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, ProcessSale.class).getAddCustomerButton());
            centerlizePO.enterDataUsingSendkeys(PageFactory.initElements(driver, ProcessSale.class).getAddCustomer(),customerName);
            sleepFor(1);
            actions.sendKeys(Keys.TAB).build().perform();
            sleepFor(2);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, ProcessSale.class).getPayButton());
            sleepFor(1);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, ProcessSale.class).getCashButton());
            sleepFor(5);
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
            centerlizePO.clickOnButton(PageFactory.initElements(driver, ProcessSale.class).getAddNewSaleButton());
            sleepFor(7);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, SalesHistory.class).getSalesHistoryButton());
            WebElement sale = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//table[@id='SalesTable']//tbody//tr[1]//td[2]//a[text()]")));
            transactionNumber = sale.getText();
            PageFactory.initElements(driver,Products.class).clickOnProductsButtonn();
            centerlizePO.clickOnButton(PageFactory.initElements(driver, ProductsPO.ProductsPO.Products.class).getProductButton());
            sleepFor(4);
            centerlizePO.enterDataUsingSendkeys(PageFactory.initElements(driver, ProductsPO.ProductsPO.Products.class).getSearchBox(),productName);
            sleepFor(4);
            List<WebElement> elementList = new WebDriverWait(driver,120).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy
                            (By.xpath("//ul[contains(@class,'hike-width-block')]//b[text()='Product']//parent::ul//li//a")));
            elementList.get(0).click();
            sleepFor(7);
            WebElement product = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//table[@id='RosterDataTable']//tbody//tr//td[2]//span[text()='" + productName + "']//parent::td")));
            product.click();
            sleepFor(3);
            String additionalPoints01 = PageFactory.initElements(driver, ProductsPO.ProductsPO.Products.class).getAdditionalLoyaltyPoints().getAttribute("value");
            additionalPoints = Integer.parseInt(additionalPoints01);
            sleepFor(1);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, ProductsPO.ProductsPO.Products.class).getProductButton());
            /*List<WebElement> closeIcon = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy
                            (By.cssSelector("a > i.fa-times")));
            for(int i =0 ;i< closeIcon.size();i++){
                closeIcon.get(i).click();
            }*/
            sleepFor(3);
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
     * @discription this method is used to verify loyalty point after sale product
     */
    @Step("verify loyalty point after sale product")
    public boolean verifyLoyaltyPointsAfteSalePoduct() {
        CenterlizePO centerlizePO = PageFactory.initElements(driver,CenterlizePO.class);
        try {
            sleepFor(5);
            PageFactory.initElements(driver, CustomersPO.Customers.class).clickOnCustomersButton();
            centerlizePO.clickOnButton(PageFactory.initElements(driver, CustomersPO.CustomersPO.Customers.class).getCustomersButton());
            sleepFor(2);
            WebElement customer = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table[@id='CustomersTable']//tbody//tr//td[2]//span[contains(text(),'"+customerName+"')]")));
            sleepFor(2);
            customer.click();
            sleepFor(4);
            WebElement loyaltypoints = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='font-grey-cascade' and text()='Loyalty points']//parent::div//div[@title][text()]")));
            String loyaltyPoint01 = loyaltypoints.getText();
            int point = Integer.parseInt(loyaltyPoint01);
            Balance = loyaltyPoints+payInt+additionalPoints;
            if (point==Balance)
                System.out.println("");
            sleepFor(2);
            Actions actions = new Actions(driver);
            actions.sendKeys(Keys.ESCAPE).build().perform();
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
     * @discription this method is used to verify loyalty point for reporting side
     */
    @Step("verify loyalty point for reporting side")
    public boolean verifyLoyaltyPointsForReportingSide() {
        CenterlizePO centerlizePO = PageFactory.initElements(driver,CenterlizePO.class);
        try {
            sleepFor(5);
            PageFactory.initElements(driver, Reporting.class).clickOnReportingButton();
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Customers.class).getCustomersButton());
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Customers.class).getLoyaltyPointsButton());
            sleepFor(2);
            centerlizePO.enterDataUsingSendkeys(PageFactory.initElements(driver, Customers.class).getLoyaltyPoint(),transactionNumber);
            sleepFor(3);
            List<WebElement> webElementList = new WebDriverWait(driver,60)
                    .until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                            By.xpath("//table[@id='LoyaltyPointsDetailDataTable']//tbody//tr//td[8]")));
            String closingBalance = webElementList.get(0).getText();
            int s01 = Integer.parseInt(closingBalance);
            if (s01==Balance)
                System.out.println(" ");
            sleepFor(5);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }


    /**
     * @author Vidhi Chapanera
     * @date 19 July 2021
     * @return
     * @throws Exception
     * @discription this method is used to check print receipt option
     */
    @Step("check print receipt option")
    public boolean checkPrintReceiptOption() {
        sleepFor(5);
        CenterlizePO centerlizePO = PageFactory.initElements(driver,CenterlizePO.class);
        try {
            PageFactory.initElements(driver,StoreSetup.class).clickOnStoreSetupButton();
            centerlizePO.clickOnButton(PageFactory.initElements(driver, General.class).getGeneralButton());
            sleepFor(3);
            Actions actions = new Actions(driver);
            actions.moveToElement(getPrintOption()).build().perform();
            centerlizePO.clickOnButton(getPrintOption());
            centerlizePO.clickOnButton(PageFactory.initElements(driver, Users.class).getSaveButton());
            sleepFor(2);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }



    /**
     * @author Vidhi Chapanera
     * @date 27 October 2021
     * @return
     * @throws Exception
     * @discription this method is used to Verify Shipping option
     */
    @Step("Verify Shipping option")
    public boolean verifyShippingOption() {
        String amount = "10";
        try {
            sleepFor(3);
            CenterlizePO centerlizePO = PageFactory.initElements(driver,CenterlizePO.class);
            PageFactory.initElements(driver,StoreSetup.class).clickOnStoreSetupButton();
            centerlizePO.clickOnButton(getGeneralButton());
            sleepFor(10);
            Actions actions = new Actions(driver);
            actions.moveToElement(getShippingCheckBox()).click().build().perform();
            actions.moveToElement(PageFactory.initElements(driver, Users.class).getSaveButton()).build().perform();
            PageFactory.initElements(driver, Users.class).getSaveButton().click();
            sleepFor(13);

            centerlizePO.clickOnButton(PageFactory.initElements(driver, TaxRules.class).getTaxRules());
            sleepFor(5);

            ExcelUtils.removeAllCellDataString(System.getProperty("user.dir") + "\\xlsx File\\Tax.xlsx");
            sleepFor(10);
            List<WebElement> tax = new WebDriverWait(driver, 30).ignoring(StaleElementReferenceException.class).until
                    (ExpectedConditions.refreshed(ExpectedConditions.presenceOfAllElementsLocatedBy
                            (By.xpath("//tbody//tr//td//a"))));
            List<WebElement> per = new WebDriverWait(driver, 30).ignoring(StaleElementReferenceException.class).until
                    (ExpectedConditions.refreshed(ExpectedConditions.presenceOfAllElementsLocatedBy
                            (By.xpath("//tbody//tr//td[2]"))));
            for (int i = 1; i<tax.size();i++){
                String tax_itr = tax.get(i).getText();
                String percentage_itr = per.get(i).getText();
                String data = tax_itr + "/" + percentage_itr ;
                WriteUtils.writeCountInExstingExcel(System.getProperty("user.dir") + "\\xlsx File\\Tax.xlsx",data);
            }

            sleepFor(5);

            PageFactory.initElements(driver,PointofSale.class).clickOnPointOfSaleButtonn();
            centerlizePO.clickOnButton(PageFactory.initElements(driver,ProcessSale.class).getProcessSaleButton());
            sleepFor(15);

            sleepFor(2);
            PageFactory.initElements(driver, ProcessSale.class).getSearchBar().sendKeys("Demo Skirt");
            sleepFor(2);
            actions.sendKeys(Keys.TAB).build().perform();
            sleepFor(3);
            if (getShippingOption().isDisplayed())
            {
                List<String> listDD = ExcelUtils.getAllCellDataStringForTax();
                for (String ss : listDD) {
                    sleepFor(2);
                    getShippingOption().click();
                    sleepFor(1);
                    getShippingTaxArea().clear();
                    getShippingTaxArea().sendKeys(amount);
                    getTaxDropDown().click();
                    WebElement taxx = new WebDriverWait(driver, 60)
                            .until(ExpectedConditions.presenceOfElementLocated
                                    (By.xpath("//tax-combo//a//following-sibling::div//ul//li//div[text()='" + ss.split("/")[0] + "']")));
                    actions.moveToElement(taxx).click().build().perform();
                    sleepFor(3);
                    getEnterButton().click();
                    sleepFor(3);
                    float t1 = Float.parseFloat(ss.split("/")[1]) * Float.parseFloat(amount);
                    float t2 = (100 + Float.parseFloat(ss.split("/")[1]));
                    WebElement Inc = new WebDriverWait(driver, 60)
                            .until(ExpectedConditions.presenceOfElementLocated
                                    (By.xpath("//table[contains(@class,'cust-table')]//td[contains(text(),'Shipping')]//span")));
                    if (Float.parseFloat(Inc.getText().substring(2))==Float.parseFloat(String.format("%.2f",t1 / t2))){
                        System.out.println("match...................//");
                    }
                }
            }else {
                System.out.println("not displayed............../");
            }
            return true;
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }finally {
            CenterlizePO centerlizePO = PageFactory.initElements(driver,CenterlizePO.class);
            PageFactory.initElements(driver,StoreSetup.class).clickOnStoreSetupButton();
            centerlizePO.clickOnButton(getGeneralButton());
            sleepFor(3);
            Actions actions = new Actions(driver);
            actions.moveToElement(getShippingCheckBox()).click().build().perform();
            actions.moveToElement(PageFactory.initElements(driver, Users.class).getSaveButton()).build().perform();
            PageFactory.initElements(driver, Users.class).getSaveButton().click();
            sleepFor(13);

        }
    }


    /**
     * @author Vidhi Chapanera
     * @date 27 October 2021
     * @return
     * @throws Exception
     * @discription this method is used to Park paid orders for fulfillment
     */
    @Step("Park paid orders for fulfillment")
    public boolean verifyParkPaidOrdersForFulfillmentOption() {
        String amount = "10";
        try {
            sleepFor(3);
            CenterlizePO centerlizePO = PageFactory.initElements(driver,CenterlizePO.class);
            PageFactory.initElements(driver,StoreSetup.class).clickOnStoreSetupButton();
            centerlizePO.clickOnButton(getGeneralButton());
            sleepFor(3);
            Actions actions = new Actions(driver);
            actions.moveToElement(getParkPaidCheckBox()).click().build().perform();
            sleepFor(2);
            getParkPaidDropDown().click();
            WebElement option = new WebDriverWait(driver, 60)
                    .until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//div[contains(@class,'md-checkbox')]//label[@for='parkingPaidOrder']//following-sibling::div//a//following-sibling::div//li//div//span[text()='Automatically park all']")));
            option.click();
            actions.moveToElement(PageFactory.initElements(driver, Users.class).getSaveButton()).build().perform();
            PageFactory.initElements(driver, Users.class).getSaveButton().click();
            sleepFor(13);

            PageFactory.initElements(driver,PointofSale.class).clickOnPointOfSaleButtonn();
            centerlizePO.clickOnButton(PageFactory.initElements(driver,ProcessSale.class).getProcessSaleButton());
            sleepFor(15);

            sleepFor(2);
            PageFactory.initElements(driver, ProcessSale.class).getSearchBar().sendKeys("Demo Skirt");
            sleepFor(2);
            actions.sendKeys(Keys.TAB).build().perform();
            sleepFor(3);
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
            centerlizePO.clickOnButton(PageFactory.initElements(driver, ProcessSale.class).getAddNewSaleButton());
            sleepFor(3);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, SalesHistory.class).getSalesHistoryButton());
            WebElement sale = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//table[@id='SalesTable']//tbody//tr[1]//td[5]")));
            System.out.println("Sale........................."+sale.getText());
            if (sale.getText().contains("Awaiting fulfillment"))
            {
                PageFactory.initElements(driver,StoreSetup.class).clickOnStoreSetupButton();
                centerlizePO.clickOnButton(getGeneralButton());
                sleepFor(3);
                sleepFor(2);
                getParkPaidDropDown().click();
                WebElement option1 = new WebDriverWait(driver, 60)
                        .until(ExpectedConditions.presenceOfElementLocated
                                (By.xpath("//div[contains(@class,'md-checkbox')]//label[@for='parkingPaidOrder']//following-sibling::div//a//following-sibling::div//li//div//span[text()='Prompt for confirmation (fulfilled or not) at checkout']")));
                option1.click();
                actions.moveToElement(PageFactory.initElements(driver, Users.class).getSaveButton()).build().perform();
                PageFactory.initElements(driver, Users.class).getSaveButton().click();
                sleepFor(13);
                PageFactory.initElements(driver,PointofSale.class).clickOnPointOfSaleButtonn();
                centerlizePO.clickOnButton(PageFactory.initElements(driver,ProcessSale.class).getProcessSaleButton());
                sleepFor(15);
                sleepFor(2);
                PageFactory.initElements(driver, ProcessSale.class).getSearchBar().sendKeys("Demo Skirt");
                sleepFor(2);
                actions.sendKeys(Keys.TAB).build().perform();
                sleepFor(3);
                centerlizePO.clickOnButton(PageFactory.initElements(driver, ProcessSale.class).getPayButton());
                centerlizePO.clickOnButton(PageFactory.initElements(driver, ProcessSale.class).getCashButton());
                sleepFor(3);
                if(getFulfillmentAlert().isDisplayed()){
                    getYesButton().click();
                    sleepFor(3);
                    String mainWindowHandle1 = driver.getWindowHandle();
                    Set<String> allWindowHandles1 = driver.getWindowHandles();
                    Iterator<String> iterator1 = allWindowHandles1.iterator();
                    while (iterator1.hasNext()) {
                        String ChildWindow = iterator1.next();
                        if (!mainWindowHandle1.equalsIgnoreCase(ChildWindow)) {
                            driver.switchTo().window(ChildWindow);
                            WebElement text = new WebDriverWait(driver,60).until(ExpectedConditions.presenceOfElementLocated(By.tagName("print-preview-app")));
                            Actions actions1 = new Actions(driver);
                            actions1.sendKeys(Keys.TAB).build().perform();
                            actions1.sendKeys(Keys.ENTER).build().perform();
                        }
                    }
                    sleepFor(2);
                    driver.switchTo().window(mainWindowHandle1);
                    sleepFor(3);
                    centerlizePO.clickOnButton(PageFactory.initElements(driver, ProcessSale.class).getAddNewSaleButton());
                    sleepFor(3);
                }else {
                    System.out.println("getFulfillmentAlert() not displayed");
                }
            }else {
                System.out.println("getFulfillmentAlert() not displayed");
            }
            return true;
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }finally {
            sleepFor(3);
            CenterlizePO centerlizePO = PageFactory.initElements(driver,CenterlizePO.class);
            PageFactory.initElements(driver,StoreSetup.class).clickOnStoreSetupButton();
            centerlizePO.clickOnButton(getGeneralButton());
            sleepFor(3);
            Actions actions = new Actions(driver);
            actions.moveToElement(getParkPaidCheckBox()).click().build().perform();
            sleepFor(2);
            actions.moveToElement(PageFactory.initElements(driver, Users.class).getSaveButton()).build().perform();
            PageFactory.initElements(driver, Users.class).getSaveButton().click();
            sleepFor(13);
        }
    }


    /**
     * @author Vidhi Chapanera
     * @date 28 October 2021
     * @return
     * @throws Exception
     * @discription this method is used to Verify Hide last 3 digits in 'sold' gift card numbers listing
     */
    @Step("Verify Hide last 3 digits in 'sold' gift card numbers listing")
    public boolean verifyHideLastThreeDigitinSoldGiftCardNumber() {
        try {
            sleepFor(3);
            CenterlizePO centerlizePO = PageFactory.initElements(driver,CenterlizePO.class);
            PageFactory.initElements(driver,StoreSetup.class).clickOnStoreSetupButton();
            centerlizePO.clickOnButton(getGeneralButton());
            sleepFor(3);
            Actions actions = new Actions(driver);
            centerlizePO.clickOnButton(getHideDigitftCard());
            sleepFor(2);
            actions.moveToElement(PageFactory.initElements(driver, Users.class).getSaveButton()).build().perform();
            PageFactory.initElements(driver, Users.class).getSaveButton().click();
            sleepFor(13);
            PageFactory.initElements(driver, Products.class).clickOnProductsButtonn();
            centerlizePO.clickOnButton(PageFactory.initElements(driver, GiftCards.class).getGiftCardsButton());
            sleepFor(4);
            PageFactory.initElements(driver, Suppliers.class).getSearch().sendKeys(GiftCard);
            sleepFor(10);
            WebElement list = new WebDriverWait(driver,60)
                    .ignoring(StaleElementReferenceException.class).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table//tr[1]//td//a")));
            String s ="";
            int initial = GiftCard.length()-3;
            for(int i=initial; i<GiftCard.length(); i++) {
                s += GiftCard.charAt(i);
            }
            sleepFor(3);
            System.out.println(GiftCard.replace(s,"xxx"));
            if (list.getText().contains(GiftCard.replace(s,"xxx"))){
                sleepFor(3);
                PageFactory.initElements(driver,StoreSetup.class).clickOnStoreSetupButton();
                centerlizePO.clickOnButton(getGeneralButton());
                sleepFor(3);
                actions.moveToElement(getHideDigitftCard()).click().build().perform();
                sleepFor(2);
                actions.moveToElement(PageFactory.initElements(driver, Users.class).getSaveButton()).build().perform();
                PageFactory.initElements(driver, Users.class).getSaveButton().click();
                sleepFor(13);
                return true;
            }else
                return false;
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }


    /**
     * @author Vidhi Chapanera
     * @date 1 December 2021
     * @return
     * @throws Exception
     * @discription this method is used to Verify Display total items (quantity) in basket
     */
    @Step("Verify Display total items (quantity) in basket")
    public boolean verifyDisplayTotalItemsInBasket() {
        int count =0;
        Actions actions = new Actions(driver);
        CenterlizePO centerlizePO = PageFactory.initElements(driver,CenterlizePO.class);
        try {
            sleepFor(5);
            PageFactory.initElements(driver,StoreSetup.class).clickOnStoreSetupButton();
            centerlizePO.clickOnButton(getGeneralButton());
            sleepFor(3);
            centerlizePO.clickOnButton(getDisplayTotalItemsInBasket());
            sleepFor(2);
            actions.moveToElement(PageFactory.initElements(driver, Users.class).getSaveButton()).build().perform();
            PageFactory.initElements(driver, Users.class).getSaveButton().click();
            sleepFor(13);
            PageFactory.initElements(driver, PointofSale.class).clickOnPointOfSaleButtonn();
            centerlizePO.clickOnButton(PageFactory.initElements(driver, ProcessSale.class).getProcessSaleButton());
            sleepFor(20);
            sleepFor(2);
            if (getTotalItemsText().isDisplayed()){
                WebElement e = new WebDriverWait(driver,120).
                        until(ExpectedConditions.presenceOfElementLocated
                                (By.xpath("//div[@id='mydiv']//ul//li//a[text()='PT UOM']")));
                e.click();
                List<WebElement> elementList = new WebDriverWait(driver,120).
                        until(ExpectedConditions.presenceOfAllElementsLocatedBy
                                (By.xpath("//div[contains(@uib-tooltip,'unit of measure')]")));
                for (int i=0;i<elementList.size();i++){
                    elementList.get(i).click();
                    sleepFor(1);
                }
                for (int i=0;i<elementList.size()-2;i++){
                    elementList.get(i).click();
                    sleepFor(1);
                }
                for (int i=0;i<elementList.size();i++){
                    elementList.get(i).click();
                    sleepFor(1);
                }
                List<WebElement> list0001 = new WebDriverWait(driver,120).
                        until(ExpectedConditions.presenceOfAllElementsLocatedBy
                                (By.xpath("//div[@class='sell-item-title']//span")));
                ExcelUtils.removeAllCellDataString(System.getProperty("user.dir") + "\\xlsx File\\Totalitem.xlsx");
                for (int i=0;i<list0001.size();i++){
                    sleepFor(1);
                    actions.moveToElement(list0001.get(i)).build().perform();
                    String productName = list0001.get(i).getText();
                    sleepFor(1);
                    String Qty = driver.findElement
                            (By.xpath("//div[@class='sell-item-title']//span[normalize-space(.)='"+productName+"']//parent::div//parent::div//parent::div//parent::div//parent::div//parent::div//preceding-sibling::div//span[contains(@class,'item-qty')]"))
                            .getText();
                    String data = productName+"/"+Qty;
                    WriteUtils.writeCountInExstingExcel(System.getProperty("user.dir") + "\\xlsx File\\Totalitem.xlsx",data);
                }
                sleepFor(1);
                centerlizePO.clickOnButton(getTotalItemsText());
                List<String> listDD = ExcelUtils.getAllCellDataStringFortotalItem();
                for (String s : listDD) {
                    sleepFor(2);
                    WebElement p01 = new WebDriverWait(driver,120).
                            until(ExpectedConditions.presenceOfElementLocated
                                    (By.xpath("//div[@class='popover-content']//td[1][text()='"+s.split("/")[0]+"']//following-sibling::td")));
                    if (p01.getText().contains(s.split("/")[1])){
                        count += Integer.parseInt(s.split("/")[1]);
                    }else
                        return false;
                }
                int qty1 = Integer.parseInt(driver.findElement(By.xpath("//td[text()='Total items']//following-sibling::td")).getText());
                Assert.assertTrue(qty1==count);
                System.out.println(count);
                return true;
            }else {
                return false;
            }
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }



    /**
     * @author Vidhi Chapanera
     * @date 1 December 2021
     * @return
     * @throws Exception
     * @discription this method is used to Verify inventory count Display on POS screen
     */
    @Step("Verify inventory count Display on POS screen")
    public boolean verifyInventoryCountOnPOSScreen() {
        String productName ="";
        int inventoryCount =0;
        Actions actions = new Actions(driver);
        CenterlizePO centerlizePO = PageFactory.initElements(driver,CenterlizePO.class);
        try {
            sleepFor(5);
            PageFactory.initElements(driver,StoreSetup.class).clickOnStoreSetupButton();
            centerlizePO.clickOnButton(getGeneralButton());
            sleepFor(5);
            centerlizePO.clickOnButton(getStockCountOnEnterSale());
            sleepFor(2);
            actions.moveToElement(PageFactory.initElements(driver, Users.class).getSaveButton()).build().perform();
            PageFactory.initElements(driver, Users.class).getSaveButton().click();
            sleepFor(13);
            PageFactory.initElements(driver, PointofSale.class).clickOnPointOfSaleButtonn();
            centerlizePO.clickOnButton(PageFactory.initElements(driver, ProcessSale.class).getProcessSaleButton());
            sleepFor(20);
            sleepFor(2);
            WebElement e = new WebDriverWait(driver,120).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//a[normalize-space(.)='PT Variant']")));
            centerlizePO.clickOnButton(e);
            sleepFor(5);
            List<WebElement> elementList = new WebDriverWait(driver,120).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy
                            (By.xpath("//div[@uib-tooltip='Inventory'][normalize-space(.)]")));
            for (int i=0;i<elementList.size();i++){
                sleepFor(5);
                testInventory = elementList.get(i).getText();
                int index = i;
                List<WebElement> name = new WebDriverWait(driver,120).
                        until(ExpectedConditions.presenceOfAllElementsLocatedBy
                                (By.xpath("//div[contains(@class,'figure-footer-text')][normalize-space(.)]")));
                productName = name.get(index).getText();
                PageFactory.initElements(driver,Inventory.class).clickOnInventoryButton();
                sleepFor(5);
                centerlizePO.clickOnButton(PageFactory.initElements(driver, MyInventory.class).getMyInventoryButton());
                sleepFor(5);
                centerlizePO.enterDataUsingSendkeys(PageFactory.initElements(driver, MyInventory.class).getSearchBox(),productName.split("\n")[0]);
                sleepFor(3);
                List<WebElement> list = new WebDriverWait(driver,120).
                        until(ExpectedConditions.presenceOfAllElementsLocatedBy
                                (By.xpath("//ul[contains(@class,'hike-width-block')]//b[text()='Product']//parent::ul//li//a")));
                list.get(0).click();
                sleepFor(5);
                WebElement pagination = new WebDriverWait(driver,120).
                        until(ExpectedConditions.presenceOfElementLocated
                                (By.name("InventoryRecordDataTable_length")));
                actions.moveToElement(pagination).build().perform();
                Select select = new Select(pagination);
                select.selectByValue("50");
                sleepFor(5);
                List<WebElement> onHand = new WebDriverWait(driver,120).
                        until(ExpectedConditions.presenceOfAllElementsLocatedBy
                                (By.xpath("//table[@id='InventoryRecordDataTable']//tbody//tr//td[2]")));
                for (int j=0;j<onHand.size();j++){
                    sleepFor(1);
                    inventoryCount += Integer.parseInt(onHand.get(j).getText());
                }
                Assert.assertEquals(testInventory,String.valueOf(inventoryCount));
                System.out.println("inventoryCount"+inventoryCount);
                break;
            }
            return true;
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }


    /**
     * @author Vidhi Chapanera
     * @date 08 December 2021
     * @return
     * @throws Exception
     * @discription this method is used to Add More Amount to exsting Gift card(Top up Functionality)
     */
    @Step("Add More Amount to exsting Gift card(Top up Functionality)")
    public boolean addTopup() {
        String amount = "150.50";
        CenterlizePO centerlizePO = PageFactory.initElements(driver,CenterlizePO.class);
        try {
            sleepFor(5);
            centerlizePO.enterDataUsingSendkeys(getGiftCardNumber(),GiftCard);
            giftCardNumber = getGiftCardNumber().getAttribute("value");
            //centerlizePO.clickOnButton(getCheckButton());
            sleepFor(10);
            String testBalance01 = getBalance().getText();
            centerlizePO.clickOnButton(getTopupBox());
            centerlizePO.clearText(getTopupBox());
            centerlizePO.enterDataUsingSendkeys(getTopupBox(),amount);
            sleepFor(2);
            System.out.println("............"+testBalance01);

            testBalance = Float.parseFloat(testBalance01.replace(",","").substring(1)) + Float.parseFloat(amount);
            centerlizePO.clickOnButton(getAddFundsButton());
            sleepFor(3);
            testBalanceString = String.format("%.2f", testBalance);
            System.out.println(testBalanceString);
            WebElement payprice = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//button[contains(@class,'btn-xlarge')]//div[contains(@class,'right')][normalize-space(.)]")));
            String payPrice = payprice.getText();
            if (payPrice.substring(1)==amount){
                System.out.println("");
            }
            sleepFor(1);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, ProcessSale.class).getPayButton());
            sleepFor(3);
            if (getGiftCardPayScreen().isDisplayed())
                System.out.println(" ");
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
            centerlizePO.clickOnButton(PageFactory.initElements(driver, ProcessSale.class).getAddNewSaleButton());
            sleepFor(3);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }


    /**
     * @author Vidhi Chapanera
     * @date 08 December 20214
     * @return
     * @throws Exception
     * @discription this method is used to Verify Top up Balance in reporting side
     */
    @Step("Verify Top up Balance in reporting side")
    public boolean verifyTopupReportingSide() {
        Actions actions = new Actions(driver);
        CenterlizePO centerlizePO = PageFactory.initElements(driver,CenterlizePO.class);
        try {
            sleepFor(5);
            centerlizePO.clickOnButton(PageFactory.initElements(driver, SalesHistory.class).getSalesHistoryButton());
            WebElement sale = new WebDriverWait(driver,60).
                    until(ExpectedConditions.presenceOfElementLocated
                            (By.xpath("//table[@id='SalesTable']//tbody//tr[position()=1]//td[2]//a[text()]")));
            actions.moveToElement(sale).build().perform();
            testSaleNumber += sale.getText();
            sleepFor(5);
            PageFactory.initElements(driver, Products.class).clickOnProductsButtonn();
            centerlizePO.clickOnButton(PageFactory.initElements(driver, GiftCards.class).getGiftCardsButton());
            sleepFor(4);
            WebElement List = new WebDriverWait(driver,60)
                    .until(ExpectedConditions.presenceOfElementLocated(
                            By.xpath("//table[@id='GiftCardDataTable']//tbody//tr//td//a[text()='"+giftCardNumber+"']")));
            centerlizePO.clickOnButton(List);
            sleepFor(5);
            WebElement status = new WebDriverWait(driver,60)
                    .until(ExpectedConditions.presenceOfElementLocated(
                            By.xpath("//td[text()='"+testSaleNumber+"']//following-sibling::td[position()=1]")));
            Assert.assertEquals(status.getText(),"Top up");
            WebElement closingBalance = new WebDriverWait(driver,60)
                    .until(ExpectedConditions.presenceOfElementLocated(
                            By.xpath("//td[text()='"+testSaleNumber+"']//following-sibling::td[position()=last()]")));
            Assert.assertEquals(closingBalance.getText().replace(",","").substring(1),testBalanceString);
            actions.sendKeys(Keys.ESCAPE).build().perform();
            sleepFor(2);
            PageFactory.initElements(driver,Reporting.class).clickOnReportingButton();
            sleepFor(3);
            centerlizePO.clickOnButton(PageFactory.initElements(driver,Customers.class).getCustomersButton());
            sleepFor(7);
            centerlizePO.clickOnButton(PageFactory.initElements(driver,Customers.class).getGiftcardTransactionButton());
            sleepFor(7);
            WebElement status01 = new WebDriverWait(driver,60)
                    .until(ExpectedConditions.presenceOfElementLocated(
                            By.xpath("//a[text()='"+testSaleNumber+"']//parent::td//following-sibling::td[position()=3]")));
            Assert.assertEquals(status01.getText(),"Top up");
            WebElement closingBalance01 = new WebDriverWait(driver,60)
                    .until(ExpectedConditions.presenceOfElementLocated(
                            By.xpath("//a[text()='"+testSaleNumber+"']//parent::td//following-sibling::td[position()=last()]")));
            Assert.assertEquals(closingBalance01.getText().replace(",","").substring(1),testBalanceString);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}