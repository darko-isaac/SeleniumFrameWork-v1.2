package StepDefinitions;

import io.appium.java_client.android.AndroidDriver; // Correct import for AndroidDriver
import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
//import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import static StepDefinitions.Hooks.driver;


public class MobileExampleSteps {

    private AndroidDriver mobileDriver;

    @Before("@MobileTest")
    public void setUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "14");
        caps.setCapability("automationName", "UIAutomator2");
        caps.setCapability("deviceName", "isaacEmulator");
        caps.setCapability("appium:uuid", "emulator-5554");
        caps.setCapability("app", "/Users/isaac/Downloads/Facebook Lite_403.0.0.8.124_Apkpure.apk");
        //caps.setCapability("appPackage", "com.google.android.dialer");
        //caps.setCapability("appActivity", "com.google.android.dialer.extensions.GoogleDialtactsActivity");
        caps.setCapability("noReset", true);
        caps.setCapability("nativeWebScreenshot", true);
        caps.setCapability("newCommandTimeout", 3600);
        caps.setCapability("connectHardwareKeyboard", true);
//src/test/java/Software/

        // Primera coincidencia

       // cuando usamos appium 2.5 la ruta local solo va asi
        URL appiumServerURL = new URL("http://127.0.0.1:4723/");
        mobileDriver = new AndroidDriver(appiumServerURL,caps);


    }

    @Given("I have opened the calculator app")
    public void i_have_opened_the_calculator_app() {
        // No action needed, as the app is already opened in the setUp method
        // Take a screenshot and save it to a file




    }

 
}
