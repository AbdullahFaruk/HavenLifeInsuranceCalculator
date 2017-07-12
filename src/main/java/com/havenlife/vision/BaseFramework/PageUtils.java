package com.havenlife.vision.BaseFramework;

import DriverUtils.DriverFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

/**
 * Created by shawon on 6/25/17.
 */
public class PageUtils {

    protected WebDriver driver = DriverFactory.getInstance().getDriver();


    /**   delay for a certain time**/
    public void delayFor(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /** Mouse hover**/
    public void mouseOn(WebElement element){
        Actions actions = new Actions(driver);
        actions.moveToElement(element)
                .perform();
    }


    //This method returns single webelements
    public WebElement getElementList(List<WebElement> elements, String text) {

        WebElement returningElement = null;
        for (int i = 0; i < elements.size(); i++){
            WebElement element = elements.get(i);
            if(element.getText().contentEquals(text)){
                returningElement = element;
                break;
            }else {
                System.out.println("Did not find the element");
            }
        }
        return returningElement;
    }

    public void selectOption(WebElement element, String text){
        Select option = new Select(element);
        option.selectByVisibleText(text);
    }

    /**
     * uses for highlight the element on the page
     * */
    public void highlightElement(WebElement element){
        for (int i = 0; i < 3; i++) {

            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript(
                    "arguments[0].setAttribute('style', arguments[1]);",
                    element, "border: 2px solid purple;");
            delayFor(500);
            js.executeScript(
                    "arguments[0].setAttribute('style', arguments[1]);",
                    element, "");
            delayFor(500);
        }
    }

    public String loadDataFromPropertiesFile(String string) {
        final String file = System.getProperty("user.dir") + "/src/main/resources/configuration.properties";
        Properties prop = new Properties();
        InputStream input;
        try {
            input = new FileInputStream(file);
            // load a properties file
            prop.load(input);
            return prop.getProperty(string);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return "";
    }


}
