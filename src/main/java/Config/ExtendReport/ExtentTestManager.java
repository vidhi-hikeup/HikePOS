package Config.ExtendReport;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author vidhi chapanera
 * @date 11 January 2021
 */
public class ExtentTestManager {

    private static ExtentReports extent;
    public static String reportPath;
    static Map extentTestMap = new HashMap();
    static ExtentReports report = getReporter();

    /**
     * @return
     * @author vidhi chapanera
     * @date 11 January 2021
     */
    public static synchronized ExtentTest getTest() {
        return (ExtentTest)extentTestMap.get((int) (long) (Thread.currentThread().getId()));
    }

    /**
     * @author vidhi chapanera
     * @date 11 January 2021
     */
    public static synchronized void endTest() {
        report.endTest((ExtentTest)extentTestMap.get((int) (long) (Thread.currentThread().getId())));
    }

    /**
     * @param testName
     * @return
     * @author vidhi chapanera
     * @date 11 January 2021
     */
    public static synchronized ExtentTest startTest(String testName) {
        return startTest(testName, "");
    }


    /**
     * @param testName
     * @param desc
     * @return
     * @author vidhi chapanera
     * @date 11 January 2021
     */
    public static synchronized ExtentTest startTest(String testName, String desc) {
        ExtentTest test = report.startTest(testName, desc);
        extentTestMap.put((int) (long) (Thread.currentThread().getId()), test);
        return test;
    }

    /**
     * @author vidhi chapanera
     * @date 11 January 2021
     */
    public synchronized static ExtentReports getReporter(){
        if(extent == null) {
            SimpleDateFormat df = new SimpleDateFormat("dd_MMMM_yyyy_hh_mm_ss_a");
            String strDate = df.format(new Date());
            reportPath = System.getProperty("user.dir") + "\\report\\Report_" + strDate + ".html";
            File f = new File(System.getProperty("user.dir") + "\\report");
            if (f.listFiles().length > 30) {
                for (File file : f.listFiles()) {
                    file.delete();
                }
            }
            extent = new ExtentReports(reportPath, false);
            extent.loadConfig(new File(System.getProperty("user.dir") + "\\src\\main\\resources\\Config\\report-config.xml"));
        }
        return extent;
    }

}
