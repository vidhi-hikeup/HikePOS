package Config.ExtendReport;

import Config.Base.BaseTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.*;

/**
 * @author Vidhi Chapanera
 * @date 11 January 2021
 */
public class TestListener extends BaseTest implements ITestListener, ISuiteListener {

    public static int all_pass=0;
    public static int all_fail=0;

    /**
     * @param iTestResult
     * @return
     * @author Vidhi Chapanera
     * @date 11 January 2021
     */
    private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }

    /**
     * @param iTestContext
     * @author Vidhi Chapanera
     * @date 11 January 2021
     */
    @Override
    public void onStart(ITestContext iTestContext) {
        iTestContext.setAttribute("WebDriver", this.driver);
    }

    /**
     * @param iTestContext
     * @author Vidhi Chapanera
     * @date 11 January 2021
     */
    @Override
    public void onFinish(ITestContext iTestContext) {
        ExtentTestManager.endTest();
        ExtentTestManager.getReporter().flush();
    }

    /**
     * @param iTestResult
     * @author Vidhi Chapanera
     * @date 11 January 2021
     */
    @Override
    public void onTestStart(ITestResult iTestResult) {
    }

    /**
     * @param iTestResult
     * @author Vidhi Chapanera
     * @date 11 January 2021
     */
    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        ExtentTestManager.getTest().log(LogStatus.PASS, "Test passed");
        all_pass ++;

    }

    /**
     * @param iTestResult
     * @author Vidhi Chapanera
     * @date 11 January 2021
     */
    @Override
    public void onTestFailure(ITestResult iTestResult) {
        Object testClass = iTestResult.getInstance();
        WebDriver webDriver = ((BaseTest) testClass).driver;
        String base64Screenshot = "data:image/png;base64,"+((TakesScreenshot)webDriver).getScreenshotAs(OutputType.BASE64);
        ExtentTestManager.getTest().log(LogStatus.FAIL, ExtentTestManager.getTest().addBase64ScreenShot(base64Screenshot),iTestResult.getThrowable());
        ExtentTestManager.getTest().log(LogStatus.FAIL, "Test Failed");
        all_fail ++;

    }

    /**
     * @param iTestResult
     * @author Vidhi Chapanera
     * @date 11 January 2021
     */
    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        ExtentTestManager.getTest().log(LogStatus.SKIP, "Test Skipped");
    }

    /**
     * @param iTestResult
     * @author Vidhi Chapanera
     * @date 11 January 2021
     */
    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        System.out.println("Test failed but it is in defined success ratio " + getTestMethodName(iTestResult));
    }

    /**
     * @author Vidhi Chapanera
     * @date 11 January 2021
     * @param iSuite
     */
    @Override
    public void onStart(ISuite iSuite) {
        System.out.println("Suite executed onStart"  + iSuite.getName());
    }


    /**
     * @author Vidhi Chapanera
     * @date 11 January 2021
     * @param iSuite
     */
    @Override
    public void onFinish(ISuite iSuite) {
        System.out.println("Suite executed onStart"  + iSuite.getName());
    }
}
