package PageContentObjectModel;

import com.havenlife.vision.BaseFramework.PageUtils;
import com.paxovision.execution.annotations.LogReport;
import com.paxovision.execution.reporter.service.ReporterService;
import ReportingLayer.ExtentManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;

import java.util.List;

/**
 * Created by shawon on 6/25/17.
 */
public class InsuranceCalculator extends PageUtils {

    private static ExtentManager extentManager = ExtentManager.getInstance(); //extend manager
    protected ReporterService reporter = ReporterService.reporter();

    /**
     * This is Constructor
     * */

    public InsuranceCalculator() {
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
        //PageFactory.initElements(driver, this);
    }

    /**
     * Navigate to homepage
     * */
    public void naviageteToHomepage(){
        driver.navigate().to(loadDataFromPropertiesFile("url"));

    }

    public void naviagetePage(String url){
        driver.navigate().to(url);
    }

    public void verifyHomePage(){
        Assert.assertEquals("Haven Life", driver.getTitle());
        extentManager.log("Haven Life" + driver.getTitle());
    }

    /**
     * We must put all Calculator related contents here, which means all necessary fields will be here
     * */

    @LogReport(name = "User Enters Date of Birth", description = "Date of Birth is entered")
    public void InputDateOfBirth(String dateOfBirth){
        WebElement date_of_birth = driver.findElement(By.xpath("//input[@placeholder='mm/dd/yyyy']"));
        highlightElement(date_of_birth);
        date_of_birth.sendKeys(dateOfBirth);
    }

    @LogReport(name = "User Enters HouseHold Income", description = "Annual Income is entered")
    public void inputPrimaryIncome(String income){
        WebElement primaryIncomeField = driver.findElement(By.xpath("//input[@id='primarySalary']"));
        highlightElement(primaryIncomeField);
        primaryIncomeField.sendKeys(income);
    }

    @LogReport(name = "User Enters zipcode", description = "zipcode is entered")
    public void inputZipCode(String zcode){
        WebElement zipCodeField = driver.findElement(By.xpath("//input[@id='primaryZIP']"));
        highlightElement(zipCodeField);
        zipCodeField.sendKeys(zcode);
    }

    @LogReport(name = "User Enters Gender", description = "Gender is entered")
    public void inputGender(String gender){
        WebElement inputGender = driver.findElement(By.xpath("//select[@id='primaryGender']"));
        highlightElement(inputGender);
        inputGender.sendKeys(gender);
    }

    @LogReport(name = "User Enters Family Members", description = "Family members are entered")
    public void inputFamilyMembers(){
        List<WebElement> myObj = driver.findElements(By.xpath("//input[@name='family']"));
        System.out.println("Total selected values are " + myObj.size());
        myObj.get(3).click();
    }

    @LogReport(name = "User Enters Partner's Age Information", description = "Partner Age info is entered")
    public void inputPartnerAge(String age) {
        WebElement inputAge = driver.findElement(By.xpath("//input[@id='alternateAge']"));
        highlightElement(inputAge);
        inputAge.sendKeys(age);
    }

    @LogReport(name = "User Enters Partner's work information", description = "Partner work info is entered")
    public void inputPartnerWorks(String workStatus) {
        WebElement inputSpouseWorks = driver.findElement(By.xpath("//select[@id='spouseWorks']"));
        highlightElement(inputSpouseWorks);
        inputSpouseWorks.sendKeys(workStatus);
    }

    @LogReport(name = "User Enters number of kids", description = "Kids info is entered")
    public void inputNumberOfKids(String kids) {
        WebElement inputChildernInfo = driver.findElement(By.xpath("//input[@id='noOfKids']"));
        inputChildernInfo.clear();
        highlightElement(inputChildernInfo);
        inputChildernInfo.sendKeys(kids);
    }

    @LogReport(name = "User Enters Kid's Age", description = "Kid's Age info is entered")
    public void inputKidsAge(String ageInfo) {
        WebElement inputKidsAgeRelated = driver.findElement(By.xpath("//input[@id='__id__']"));
        inputKidsAgeRelated.clear();
        highlightElement(inputKidsAgeRelated);
        inputKidsAgeRelated.sendKeys(ageInfo);
    }

    @LogReport(name = "User Enters Kid Future College Payment", description = "User Not paying for College")
    public void inputKidsCollegePayment(String educationRespon) {
        WebElement inputKidsFutureCollege = driver.findElement(By.xpath("//select[@id='sendKidsToCollege']"));
        highlightElement(inputKidsFutureCollege);
        inputKidsFutureCollege.sendKeys(educationRespon);
    }

    @LogReport(name = "User Enters Debt Information", description = "User has Mortgage info")
    public void inputDebt() {
        List<WebElement> myCheckBox = driver.findElements(By.xpath("//input[@type='checkbox']"));
        System.out.println(myCheckBox);
        myCheckBox.get(2).click();
    }

    @LogReport(name = "User Enters Mortage", description = "User entered Mortage")
    public void inputMortageLoan(String loanAmount) {
        WebElement inputLoan = driver.findElement(By.xpath("//input[@id='mortgageLoan']"));
        highlightElement(inputLoan);
        inputLoan.sendKeys(loanAmount);
    }

    @LogReport(name = "User Clicks on To View Quotes", description = "User eClicked on Quotes")
    public void clickToViewMyQuoates(){
        driver.findElement(By.xpath("//button[@id='viewmyquotes']")).click();
        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath("./*//*[@id='healthsubmit']")).click();
    }

    public void validatePolicy(){
        WebElement myvalelem = driver.findElement(By.cssSelector("div[class='panel panel-default selected-panel']"));
        System.out.println(myvalelem.getText());
        Assert.assertEquals("GOLD $500,000 | 20 YEARS", "GOLD $500,000 | 20 YEARS");
    }




}
