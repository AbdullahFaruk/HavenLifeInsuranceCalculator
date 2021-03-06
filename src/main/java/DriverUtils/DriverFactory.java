package DriverUtils;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Abdullah on 6/25/17.
 */
public class DriverFactory {

    private static DriverFactory instance = new DriverFactory();

    private DriverFactory()
    {
        //Do-nothing..Do not allow to initialize this class from outside
    }

    public static DriverFactory getInstance()
    {
        return instance;
    }

    ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<WebDriver>() // thread local driverThreadLocal object for webdriver
    {
        @Override
        protected WebDriver initialValue()
        {

            String browser = System.getProperty("Browser");

            if(browser.contentEquals("ch")) {
                ChromeDriverManager.getInstance().setup();
                return new ChromeDriver();
            }
            else if(browser.contentEquals("ff")){
                FirefoxDriverManager.getInstance().setup();
                return new FirefoxDriver();
            }
            /*else if(browser.contentEquals("rch")){
                DesiredCapabilities caps = DesiredCapabilities.chrome();
                caps.setCapability("browser", "Chrome");
                caps.setCapability("browser_version", "58.0");
                caps.setCapability("os", "Windows");
                caps.setCapability("os_version", "7");
                caps.setCapability("resolution", "1920x1080");
                try {
                    return new RemoteWebDriver(new URL(BROWSER_STACK_REMOTE_URL), caps);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }*/

            {
                return null;
            }
        }
    };
    public WebDriver getDriver() // call this method to get the driverThreadLocal object and launch the browser
    {
        return driverThreadLocal.get();
    }
    public void closeDriver()
    {
        driverThreadLocal.get().close();
    }
    public void quitDriver()
    {
        driverThreadLocal.get().quit();
        driverThreadLocal.remove();
    }
}
