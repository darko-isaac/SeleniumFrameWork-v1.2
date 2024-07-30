package StepDefinitions;

import Functions.CreateDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


import java.io.File;
import java.io.IOException;

public class Hooks {


    public static WebDriver driver;

    private Scenario scenario;

    private static boolean isApiTest = false;

    @Before("@ApiTest")
    public void beforeApiTest() {
        isApiTest = true;
    }

    private static boolean isJunitTest = false;

    @Before("@JunitTest")
    public void beforeJunitTest() {
        isJunitTest = true;
    }


    @Before("@Test")

    public void initDriver(Scenario scenario) throws IOException {
        if (!isApiTest) {
            // Initialize your WebDriver here
                driver = CreateDriver.initConfig();
                this.scenario = scenario;


        }
    }


    @After

    public void embedScreenshot(Scenario scenario ) {
        try {
            if (scenario.isFailed()) {
                String screenShotName =  "fallo el navegador";
                File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(srcFile, new File(String.format("%s.png", screenShotName)));
                scenario.attach(String.valueOf(srcFile), "src/test/resources/Errores","error");
            }
        } catch (Exception e) {
            System.err.println("Error capturing screenshot: " + e.getMessage());
        } finally {


            if (driver != null) {
                System.out.println("error cerrado");
               // driver.quit();
            }
        }
    }
}