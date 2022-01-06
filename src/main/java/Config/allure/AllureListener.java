package Config.allure;

import Config.Base.BaseTest;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.*;

/**
 * @author vidhi chapanera
 * @date 12 January 2021
 */
public class AllureListener extends BaseTest implements ITestListener, ISuiteListener {

    /**
	 *
	 * @author vidhi chapanera
	 * @date 12 January 2021
	 * @param iTestResult
	 * @return
     */
	private static String getTestMethodName(ITestResult iTestResult) {
		return iTestResult.getMethod().getConstructorOrMethod().getName();
    }

    /**
     * @author vidhi chapanera
     * @date 12 January 2021
     * @param driver
     * @return
	 */
	@Attachment
	public byte[] saveFailureScreenShot(WebDriver driver) {
		return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }

    /**
     * @author vidhi chapanera
     * @date 12 January 2021
     * @param message
     * @return
	 */
	@Attachment(value = "{0}", type = "text/plain")
	public static String saveTextLog(String message) {
		return message;
    }


    /**
     * @author vidhi chapanera
     * @date 12 January 2021
     * @param iTestContext
	 */
	@Override
	public void onStart(ITestContext iTestContext) {
		System.out.println(iTestContext.getName());
		iTestContext.setAttribute("WebDriver", this.driver);
    }


    /**
     * @author vidhi chapanera
     * @date 12 January 2021
     * @param iTestContext
	 */
	@Override
	public void onFinish(ITestContext iTestContext) {
		System.out.println(iTestContext.getName());
    }

    /**
     * @author vidhi chapanera
     * @date 12 January 2021
     * @param iTestResult
	 */
	@Override
	public void onTestStart(ITestResult iTestResult) {
		System.out.println(getTestMethodName(iTestResult) + " start");
    }


    /**
     * @author vidhi chapanera
     * @date 12 January 2021
     * @param iTestResult
	 */
	@Override
	public void onTestSuccess(ITestResult iTestResult) {
		System.out.println(getTestMethodName(iTestResult) + " succeed");
    }


    /**
     * @author vidhi chapanera
     * @date 12 January 2021
     * @param iTestResult
	 */
	@Override
	public void onTestFailure(ITestResult iTestResult) {
		Object testClass = iTestResult.getInstance();
		WebDriver webDriver = ((BaseTest) testClass).driver;
		if (webDriver instanceof WebDriver) {
			System.out.println("Screenshot captured for test case:" + getTestMethodName(iTestResult));
			saveFailureScreenShot(webDriver);
		}
		saveTextLog(getTestMethodName(iTestResult) + " failed and screenshot taken!");

    }

    /**
     * @author vidhi chapanera
     * @date 12 January 2021
     * @param iTestResult
	 */
	@Override
	public void onTestSkipped(ITestResult iTestResult) {
		System.out.println(getTestMethodName(iTestResult) + " skipped");
    }


    /**
     * @author vidhi chapanera
     * @date 12 January 2021
     * @param iTestResult
	 */
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
		System.out.println(getTestMethodName(iTestResult));
	}

	/**
	 * @author Vidhi Chapanera
	 * @date 12 January 2021
	 * @param iSuite
	 */
	@Override
	public void onStart(ISuite iSuite) {
		System.out.println("Suite executed onStart"  + iSuite.getName());
	}


	/**
	 * @author Vidhi Chapanera
	 * @date 12 January 2021
	 * @param iSuite
	 */
	@Override
	public void onFinish(ISuite iSuite) {
		System.out.println("Suite executed onStart"  + iSuite.getName());
	}
}
