package Config.Base;


import Config.ExtendReport.ExtentTestManager;
import Config.ExtendReport.TestListener;
import Config.Mailconfig.OutLookMailConfig;
import Config.ScreenRecorder.ScreenRecorderUtil;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author Vidhi Chapanera
 * @date 11 January 2021
 */
@Listeners({TestListener.class})
public class BaseTest {

    public static WebDriver driver;
    public static String browser;
    public static String browserVersion;
    public static String platform;
    public static String url;

    public BaseTest() { }
    public BaseTest(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * @author Vidhi Chapanera
     * @date 11 January 2021
     * @throws Exception
     */
    @BeforeSuite(alwaysRun = true)
    public synchronized void brforeLaunchBrowser() throws Exception {
        //deleteAllureFolder();
        ScreenRecorderUtil.clean_Directory();
    }


    /**
     * @author Vidhi Chapanera
     * @date 11 January 2021
     * @param method
     * @param browserName
     * @param baseURL
     * @throws Exception
     */
    @Parameters({"browserName","baseURL","headless"})
    @BeforeClass(alwaysRun = true)
    public synchronized void launchBrowser(Method method, @Optional("chrome") String browserName, @Optional("https://accounts.google.com/signin")String baseURL, @Optional("false")String headless) throws Exception {
        this.getDriver(browserName,headless);
        Capabilities caps = ((RemoteWebDriver) driver).getCapabilities();
        this.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        this.driver.get(baseURL);
        browser = caps.getBrowserName();
        browserVersion = caps.getVersion();
        platform = caps.getPlatform().toString();
        url = baseURL;

    }


    /**
     * @author Vidhi Chapanera
     * @date 11 January 2021
     * @param method
     * @throws Exception
     */
    @BeforeMethod(alwaysRun = true)
    public void beforeMethod(Method method) throws Exception{
        ScreenRecorderUtil.startRecord(""+method.getName());
        ExtentTestManager.startTest("" + method.getName());
        ExtentTestManager.getTest().log(LogStatus.INFO, "Bowser Name", browser);
        ExtentTestManager.getTest().log(LogStatus.INFO, browser + ": version", browserVersion);
        ExtentTestManager.getTest().log(LogStatus.INFO, "Platform Name", platform);
        ExtentTestManager.getTest().log(LogStatus.INFO, "Open Browser and navigate to","<a href="+driver.getCurrentUrl()+" target=_blank>"+driver.getCurrentUrl()+"</a>");
        //ExtentTestManager.getTest().log(LogStatus.INFO, "Open Browser and navigate to","<a href="+url+">"+url+"</a>");
    }


    /**
     * @author Vidhi Chapanera
     * @date 11 January 2021
     * @param result
     * @throws Exception
     */
   @AfterMethod(alwaysRun = true)
    public void afterMethod(ITestResult result) throws Exception{
       ExtentTestManager.getReporter().endTest(ExtentTestManager.getTest());
       ExtentTestManager.getReporter().flush();
       ScreenRecorderUtil.stopRecord();
   }


    /**
     * @author Vidhi Chapanera
     * @date 11 January 2021
     * @throws Exception
     */
    @AfterClass(alwaysRun = true)
    public void afterclass() throws Exception {
        this.driver.quit();
    }


    /**
     * @author Vidhi Chapanera
     * @date 11 January 2021
     * @param mailconfigenabled
     * @throws Exception
     */
    @Parameters({"mailconfigenabled"})
    @AfterSuite(alwaysRun = true)
    public void afterSuite(String mailconfigenabled) throws Exception {
        if(mailconfigenabled.equalsIgnoreCase("true")) {
            OutLookMailConfig.sendEmailUsingOutlookMail();
        }else {
            System.out.println("mailconfigenabled value should be true"+
                    "\n"+
                    "zip value should be true");
        }
    }


    /**
     * @author Vidhi Chapanera
     * @date 11 January 2021
     * @param browserName
     * @return
     */
    public synchronized WebDriver getDriver(String browserName,String headless) {
        if(browserName.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\driver\\Mozila-Firefox\\geckodriver.exe");
            this.driver = new FirefoxDriver();
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
        }else if (browserName.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\driver\\Chrome-Driver\\96-1\\chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            if(headless.equalsIgnoreCase("true")) {
                Map<String, Object> prefs = new HashMap<String, Object>();
                prefs.put("download.default_directory", System.getProperty("user.dir") + "\\Download");
                prefs.put("profile.default_content_settings.popups", 0);
                prefs.put("safebrowsing.enabled", "true"); //this is the needed configuration
                options.setExperimentalOption("prefs", prefs);
                options.setHeadless(true);
                // options.addArguments("--kiosk-printing");
                //options.addArguments("headless");
                this.driver = new ChromeDriver(options);
                driver.manage().window().maximize();
            }else {
                Map<String, Object> prefs = new HashMap<String, Object>();
                prefs.put("download.default_directory", System.getProperty("user.dir") + "\\Download");
                prefs.put("profile.default_content_settings.popups", 0);
                prefs.put("safebrowsing.enabled", "true"); //this is the needed configuration
                options.setExperimentalOption("prefs", prefs);

               /* options.setHeadless(false);
                DesiredCapabilities caps = new DesiredCapabilities();
                caps.setCapability(ChromeOptions.CAPABILITY,options);*/

                options.addArguments("start-maximized");
                options.addArguments("--disable-blink-features=AutomationControlled");

                // options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
                options.addArguments("--force-dark-mode");
                options.setPageLoadStrategy(PageLoadStrategy.EAGER);
                /*options.addArguments("--disable-notifications");
                options.addArguments("--disable-popup-blocking");
                options.addArguments("start-maximized")*/
                //options.setCapability("chrome.switches", Arrays.asList("--incognito"));
                //options.addArguments("auto-open-devtools-for-tabs");
                //options.addArguments("--kiosk-printing");
                this.driver = new ChromeDriver(options=options);
            }
        }else if(browserName.equalsIgnoreCase("opera")) {
            System.setProperty("webdriver.opera.driver", System.getProperty("user.dir") + "\\driver\\Opera-Driver\\operadriver.exe");
            this.driver = new OperaDriver();
            driver.manage().window().maximize();
            this.driver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);
        }else if(browserName.equalsIgnoreCase("edge")) {
            System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "\\driver\\Edge-Driver\\e\\89\\msedgedriver.exe");
            EdgeOptions edgeOptions = new EdgeOptions();
            //edgeOptions.addArguments("headless");
            this.driver = new EdgeDriver(edgeOptions);
            driver.manage().window().maximize();
            this.driver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);
        }else{
            this.driver=new ChromeDriver();
        }
        return this.driver;
    }


    /**
     * @author Vidhi Chapanera
     * @date 11 January 2021
     * @return
     */
    public static ExtentTest logger(){
        return ExtentTestManager.getTest();
    }


    /**
     * @author Vidhi Chapanera
     * @date 10 August 2021
     * @return
     */
    public void deleteAllureFolder() throws IOException {
        File f = new File(System.getProperty("user.dir") + "\\allure-results");
        FileUtils.deleteDirectory(f);
    }
}
