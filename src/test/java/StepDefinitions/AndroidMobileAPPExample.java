package StepDefinitions;

import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;


public class AndroidMobileAPPExample {

    /*
    private AndroidDriver mobileDriver;

    @Before("@MobileTest")
    public void setUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "14");
        caps.setCapability("automationName", "UIAutomator2");
        caps.setCapability("deviceName", "Pixel_3a_API_34_extension_level_7_x86_64");
        caps.setCapability("appium:uuid", "emulator-5554");
        caps.setCapability("app", "src/test/java/Software/com.instagram.android_326.0.0.42.90-372610520_minAPI24(armeabi-v7a)(280,320dpi)_apkmirror.com.apk");
        caps.setCapability("noReset", true);
        caps.setCapability("nativeWebScreenshot", true);
        caps.setCapability("newCommandTimeout", 3600);
        caps.setCapability("connectHardwareKeyboard", true);
//src/test/java/Software/

        // Primera coincidencia

        // cuando usamos appium 2.5 la ruta local solo va asi
        URL appiumServerURL = new URL("http://127.0.0.1:4723/");
        mobileDriver = new AndroidDriver(appiumServerURL, caps);


    }

    @Given("I have opened the calculator app")
    public void i_have_opened_the_calculator_app() {
        // No action needed, as the app is already opened in the setUp method
    }

    @Then("I add {int} and {int}")
    public void i_add_and(Integer num1, Integer num2) {

    }


    @After("@MobileTest")
    public void tearDown() {
        if (mobileDriver != null) {
            mobileDriver.quit();
        }
    }
*/

}
