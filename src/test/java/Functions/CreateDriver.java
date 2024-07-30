package Functions;

import StepDefinitions.Hooks;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
//import java.util.logging.Logger;
import org.apache.logging.log4j.Logger;

//import org.apache.log4j.Logger;
import static StepDefinitions.Hooks.driver;

public class CreateDriver {



    private static Properties pro = new Properties();
    private static InputStream in = CreateDriver.class.getResourceAsStream("../test.properties");
    private static String browser;
    private static String os;
    private static String logLevel;

    private static final Logger log = LogManager.getLogger(CreateDriver.class);
    //private static CreateDriver instance = null;

    public static WebDriver initConfig() throws IOException {

try {

    pro.load(in);
    browser = pro.getProperty("browser");
    os = pro.getProperty("os");
    logLevel = pro.getProperty("logLevel");

} catch (IOException e) {
    //log.error("initConfig Error");
    log.notify();

}
        driver = WebDriverFactory.createNewWebDriver(browser,os);
        driver.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);
        return driver;

    }
    }





