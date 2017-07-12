package com.havenlife.vision.BaseFramework;

import DriverUtils.ApplicationFactory;
import DriverUtils.DriverFactory;
import com.paxovision.execution.reporter.listener.ReporterTestListener;
import com.paxovision.execution.reporter.service.ReporterService;
import ReportingLayer.ExtentTestNGITestListener;
import org.testng.annotations.*;

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

    @Parameters({"browser"})
    @BeforeMethod
    public void setup(@Optional("ch") String browser){

        System.out.println("Browser: " + browser);
        System.setProperty("Browser",browser);

        DriverFactory.getInstance().getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        DriverFactory.getInstance().getDriver().manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        DriverFactory.getInstance().getDriver().manage().deleteAllCookies();
        havenLifeInsurance = ApplicationFactory.getInstance().getApplicationController();

        reporter.setReportPath(System.getProperty("user.dir") + "/test-output/htmlReport/");
        reporter.setReportName("Haven Life Report");
        reporter.setReportTitle("Haven Life Insurance Functional Test");
        reporter.setCreateUniqueFileName(true);

    }

    @AfterMethod
    public void teardown(){
        DriverFactory.getInstance().closeDriver();
        //DriverFactory.getInstance().quitDriver();
    }
}
