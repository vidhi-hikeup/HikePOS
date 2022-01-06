package CommonPO;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

/**
 * @author Vidhi Chapanera
 * @date 11 January 2021
 */
public class BasePage {

    public WebDriver driver;

    /**
     * @param seconds
     * @return
     * @author Vidhi Chapanera
     * @date 11 January 2021
     */
    public void sleepFor(int seconds){
        try {
            Thread.sleep(1000*seconds);
        }catch (Exception e){
            System.out.println(e);
            return;
        }
    }

    /**
     * @param sec
     * @throws Exception
     * @author Vidhi Chapanera
     * @date 11 January 2021
     */
    public static void waitWithoutSleep(long sec) throws Exception {
        try {
            long time = sec * 1000;
            long startTime = System.currentTimeMillis();
            for (int count = 0; ; count++) {
                long now = System.currentTimeMillis();
                if (now - startTime >= time) break;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }


    /**
     * @param timeoutInSeconds
     * @author Vidhi Chapanera
     * @date 11 January 2021
     */
    public void waitForAjaxControls(int timeoutInSeconds) {
        System.out
                .println("Querying active AJAX controls by calling jquery.active");
        try {
            if (driver instanceof JavascriptExecutor) {
                JavascriptExecutor jsDriver = (JavascriptExecutor) driver;
                for (int i = 0; i < timeoutInSeconds; i++) {
                    Object numberOfAjaxConnections = jsDriver
                            .executeScript("return jQuery.active");
                    // return should be a number
                    if (numberOfAjaxConnections instanceof Long) {
                        Long n = (Long) numberOfAjaxConnections;
                        System.out
                                .println("Number of active jquery AJAX controls: "
                                        + n);
                        if (n.longValue() == 0L)
                            break;
                    }
                    Thread.sleep(1000);
                }
            } else {
                System.out.println("Web driver: " + driver
                        + " can't run javascript.");
            }
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }

    /**
     * @param ms
     * @return
     * @author Vidhi Chapanera
     * @date 11 January 2021
     */
    public boolean waitMS(int ms) {
        try {
            Thread.sleep(ms);
        } catch (Exception ex) {
        }
        return true;
    }

}
