package baseFramework;

import DriverUtils.ApplicationFactory;
import DriverUtils.DriverFactory;
import com.paxovision.execution.reporter.listener.ReporterTestListener;
import com.paxovision.execution.reporter.service.ReporterService;
import extentReport.ExtentTestNGITestListener;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import java.util.concurrent.TimeUnit;



/**
 * Created by Abdullah on 6/25/17.
 */

/** Paxo report Listener*/
@Listeners({ReporterTestListener.class, ExtentTestNGITestListener.class})
public class ScriptBase {

    protected ReporterService reporter = ReporterService.reporter();
    protected ApplicationController havenLifeInsurance;


  @BeforeClass
    public void beforeClass(){

    }

    @BeforeMethod
    public void setup(){

        DriverFactory.getInstance().getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        DriverFactory.getInstance().getDriver().manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        DriverFactory.getInstance().getDriver().manage().window().maximize();
        havenLifeInsurance = ApplicationFactory.getInstance().getApplicationController();

        reporter.setReportPath(System.getProperty("user.dir") + "/test-output/htmlReport/");
        reporter.setReportName("Haven Life Report");
        reporter.setReportTitle("Haven Life Insurance Functional Test");
        reporter.setCreateUniqueFileName(true);

    }

    @AfterMethod
    public void teardown(){
        //DriverFactory.getInstance().closeDriver();
        //DriverFactory.getInstance().quitDriver();
        //ApplicationFactory.getInstance().remove();
        //saksFifth = null;

    }
}